/*
 * @(#)LoginController.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.agea.hub.rol.exception.ServiceException;
import ar.com.agea.hub.rol.model.dto.CaptchaDTO;
import ar.com.agea.hub.rol.model.dto.CapturadorCRUDDTO;
import ar.com.agea.hub.rol.model.dto.CapturadorDTO;
import ar.com.agea.hub.rol.model.dto.PropiedadDefaultDTO;
import ar.com.agea.hub.rol.model.dto.PropiedadDefaultSearchDTO;
import ar.com.agea.hub.rol.model.dto.UsuarioCompuestoDTO;
import ar.com.agea.hub.rol.model.dto.UsuarioDTO;
import ar.com.agea.hub.rol.model.result.ROLResult;
import ar.com.agea.hub.rol.service.HUBService;
import ar.com.agea.hub.rol.service.ROLService;
import ar.com.agea.hub.rol.utils.Auth0LoginHelper;
import ar.com.agea.hub.rol.utils.CustomHttpServletRequestWrapper;
import ar.com.agea.hub.rol.utils.DTOFactory;
import ar.com.agea.hub.rol.utils.PropiedadDefaultName;
import ar.com.agea.hub.rol.utils.ViewNamingName;

import com.auth0.IdentityVerificationException;
import com.auth0.SessionUtils;
import com.auth0.Tokens;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Representa el logueo de la aplicación.
 * 
 * @author		Alejandro Javier Di Fiore
 * 				Eduardo Barrera
 * @version		1.0 06/06/2013
 */
@Controller
public class LoginController extends ROLController {

	@Autowired
	private HUBService hubService;
	
	@Autowired
	private ROLService rolService;
	
	@Autowired
	private Auth0LoginHelper auth0LoginHelper;
	
	
	
	/**
	 * Mapea /login a la vista que representa el logueo.
	 * 
	 * @return Vista que representa el logueo. 
	 * @throws ServiceException 
	 * @throws JsonProcessingException 
	 * @throws Exception 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response, @RequestParam String uuid, @RequestParam(required=false) String activate) throws ServiceException, JsonProcessingException {
	
		PropiedadDefaultSearchDTO propiedadDefaultSearch = DTOFactory.createPropiedadDefaultSearch(
				Arrays.asList(new String[] {PropiedadDefaultName.HTTP_PROXY_HOST.getClave()}));
		
		List<PropiedadDefaultDTO> propiedadesDefault = (List<PropiedadDefaultDTO>) hubService.getPropiedadesDefault(propiedadDefaultSearch).getObject();
		
		String http_host = propiedadesDefault.iterator().next().getValor();
		
		propiedadDefaultSearch = DTOFactory.createPropiedadDefaultSearch(
				Arrays.asList(new String[] {PropiedadDefaultName.HTTP_PROXY_PORT.getClave()}));
		
		propiedadesDefault = (List<PropiedadDefaultDTO>) hubService.getPropiedadesDefault(propiedadDefaultSearch).getObject();
		
		String http_port = propiedadesDefault.iterator().next().getValor();
		
		System.setProperty("http.proxyHost", http_host);
        System.setProperty("http.proxyPort", http_port);
        System.setProperty("https.proxyHost", http_host);
        System.setProperty("https.proxyPort", http_port);
		
		try {
			Tokens tokens = auth0LoginHelper.getInstance().handle(new CustomHttpServletRequestWrapper(request, auth0LoginHelper));
			String idToken = tokens.getIdToken();
			//String accessToken = tokens.getAccessToken();
			
			Map<String, String> userData = auth0LoginHelper.verify(idToken, request);
			
			//Capturo email_verified para saber si saco cartel de que debe verificar mail
			Boolean emailValidated = false;
			emailValidated = new Boolean(userData.get("email_verified"));
			
			UsuarioDTO usuario = new UsuarioDTO();
			usuario.setEmail(userData.get("email"));
			usuario.setFechaNacimiento(userData.get("https://clarin.com/fechaNacimiento"));
			usuario.setGenero(userData.get("https://clarin.com/genero"));
			
			//Para el caso que sea nuevo usuario y no tenga idPase
			String idPase = userData.get("https://clarin.com/idPase");

			boolean usuarioMigrado = idPase != null;
			
			if(usuarioMigrado){
				usuario.setUsuarioExternoCodigo(idPase);
			}else{
				// Es usr auth0
				usuario.setUsuarioExternoCodigo(userData.get("sub"));
			}
			
			ObjectMapper mapper = new ObjectMapper();

			//seteo en la cookie el usuario para que lo tome en el controller js tanto como usurio como usuarioTemporal
			SessionUtils.set(request, "userData", userData);	//setea en la session de java
			
			Cookie usuarioCookie = new Cookie("usuario", mapper.writeValueAsString(usuario));
			usuarioCookie.setPath("/");
			response.addCookie(usuarioCookie);	//setea en la cookie de front
			
			Cookie emailValidatedCookie = null;
			
			if(!emailValidated){
				emailValidatedCookie = new Cookie("emailValidated", "false");
				emailValidatedCookie.setPath("/");
				response.addCookie(emailValidatedCookie);
				
				//return new ModelAndView("redirect:/login/activate?activate=true");
				if (!uuid.equals("null")) {
					return new ModelAndView("redirect:/crearaviso/crear-aviso?uuid="+uuid);
				} else {
					return new ModelAndView("redirect:/crearaviso/crear-aviso");
				}
				
			} else {
				emailValidatedCookie = new Cookie("emailValidated", "true");
				emailValidatedCookie.setPath("/");
				response.addCookie(emailValidatedCookie);
			}
			
			ROLResult rolResult = this.loginUsuario(usuario, session, usuarioMigrado);
			
			if(rolResult.hasErrors()){
				//por ahora el unico error es que no estaba en hub (REDIRECTION)... Con el activate ya no es unico
				//tiene id de pase pero el servicio no lo encontro en HUB
				
				return getModelAndView(ViewNamingName.LOGIN);
				
			} else {
				CapturadorDTO capturador = ((UsuarioCompuestoDTO)rolResult.getObject()).getCapturador();
				Cookie capturadorCookie = new Cookie("capturador", mapper.writeValueAsString(capturador));
				capturadorCookie.setPath("/");
				response.addCookie(capturadorCookie);	//setea en la cookie de front
			}
				
		} catch (IdentityVerificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		if (!uuid.equals("null")) {
			return new ModelAndView("redirect:/crearaviso/crear-aviso?uuid="+uuid);
		} else {
			return new ModelAndView("redirect:/crearaviso/crear-aviso");
		}
				
	}
	
	
	@RequestMapping(value = "/activate", method = RequestMethod.GET)
	public ModelAndView activate() {
		return getModelAndView(ViewNamingName.LOGIN);
	}
	
	
	
	
	/**
	 * Mapea a la acción /loginUsuario.
	 * 
	 * @param dto Objeto PASE usuario a loguear.
	 * @return Objeto ROLResult que contiene el resultado de la ejecución.
	 * @throws ServiceException Cuando se produce un error en la ejecución de la acción.
	 */
	public ROLResult loginUsuario(UsuarioDTO dto, HttpSession session, boolean usuarioMigrado) throws ServiceException {
		return rolService.loginUsuario(dto, usuarioMigrado);
	}
	
	/**
	 * Mapea a la acción /checkIntentosLogin.
	 * 
	 * @return Objeto ROLResult que contiene el resultado de la ejecución.
	 * @throws ServiceException Cuando se produce un error en la ejecución de la acción.
	 */
	@RequestMapping(value = "checkIntentosLogin", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ROLResult loginUsuario(HttpSession session) throws ServiceException {
		return new ROLResult();
	}
	
	@RequestMapping(value = "saveCapturador", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ROLResult saveCapturador(@RequestBody CapturadorCRUDDTO dto) throws ServiceException {
		ROLResult result = hubService.saveCapturador(dto);
		
		return result;
	}
	
	/**
	 * Mapea a la acción /updateUsuarioPase.
	 * 
	 * @param dto Objeto PASE usuario a modificar.
	 * @return Objeto ROLResult que contiene el resultado de la ejecución.
	 * @throws ServiceException Cuando se produce un error en la ejecución de la acción.
	 */
	@RequestMapping(value = "/updateUsuarioPase", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ROLResult updateUsuarioPASE(@RequestBody UsuarioDTO dto) throws ServiceException {
		ROLResult result = rolService.updateUsuarioPASE(dto);
		
		return result;
	}
	
	
	/**
	 * Mapea /validateCaptcha a la vista que registra a un usuario.
	 * 
	 * @param captcha Objeto captcha de entrada en donde esta el valor hash del componente y lo ingresado.
	 * @return resultado de la validacion.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "validateCaptcha", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> validateCaptcha(@RequestBody CaptchaDTO captcha, HttpSession session) throws ServiceException {
		Boolean result = ((String) rolService.getHash(captcha.getInputValue()).getObject()).equals(captcha.getHashValue());		
		
		return Collections.singletonMap("valid", result);		
	}
	
	/**
	 * Realiza las operaciones de logout, invalidación de session.
	 * 
	 * @return Mensaje de exito. 
	 * @throws IOException 
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, ? extends Object> logout(HttpSession session, HttpServletResponse response) throws IOException {		
		
		//Elimino la session para limpiar valores
		session.invalidate();
		
		this.getLogger().debug("Ejecutando llamada de logout desde LoginController");
		
	    String logoutUrl = String.format("https://%s/v2/logout?client_id=%s&returnTo=%s",
	    									auth0LoginHelper.getAuth0Credentials().getDomain(),
	    									auth0LoginHelper.getAuth0Credentials().getClientId(),
	            							auth0LoginHelper.getAuth0Credentials().getCallbackLogout());
	    
	    response.sendRedirect(logoutUrl);
		
		return Collections.singletonMap("logout", "success");			
	}
	
	
	@RequestMapping(value = "/loginAuth0", method = RequestMethod.GET)
	public void redirectToAuth0Login(HttpServletRequest request, HttpServletResponse response, @RequestParam(required=false) String uuid) throws IOException {
		
		String redirectURL = auth0LoginHelper.getInstance().buildAuthorizeUrl(request, auth0LoginHelper.getAuth0Credentials().getCallbackLogin()+"?uuid="+uuid).withScope("openid profile email").build();
		response.sendRedirect(redirectURL);
		
	}

}
