/*
 * @(#)DatosPersonalesController.java		1.0 09/10/2013
 */

package ar.com.agea.hub.rol.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.agea.hub.rol.exception.ServiceException;
import ar.com.agea.hub.rol.model.dto.UsuarioDTO;
import ar.com.agea.hub.rol.model.result.ROLResult;
import ar.com.agea.hub.rol.service.ROLService;
import ar.com.agea.hub.rol.utils.Auth0LoginHelper;
import ar.com.agea.hub.rol.utils.ViewNamingName;

/**
 * Representa los datos personales del usuario de la aplicación.
 * 
 * @author		Mariano De Nicolo
 * @version		1.0 09/10/2013
 */
@Controller
public class DatosPersonalesController extends ROLController {
	
	@Autowired
	private ROLService rolService;
	
	@Autowired
	private Auth0LoginHelper auth0LoginHelper;
	
	/**
	 * Mapea /datosPersonales a la vista que representa los datos personales del usuario.
	 * 
	 * @return Vista que representa los datos personales del usuario. 
	 */
	@RequestMapping(value = "/datospersonales", method = RequestMethod.GET)
	public ModelAndView showRegistrarme(HttpSession session) {		
		return getModelAndView(ViewNamingName.DATOS_PERSONALES);	
	}
	
	
	/**
	 * Mapea a la acción /updateUsuario.
	 * 
	 * @param dto Objeto PASE usuario a modificar.
	 * @return Objeto ROLResult que contiene el resultado de la ejecución.
	 * @throws ServiceException Cuando se produce un error en la ejecución de la acción.
	 */
	@RequestMapping(value = "/updateUsuario", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ROLResult updateUsuario(@RequestBody UsuarioDTO dto) throws ServiceException {
		ROLResult result = rolService.updateUsuario(dto);
		
		return result;
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
				
		this.getLogger().debug("Ejecutando llamada de logout desde DatosPersonalesController");
		
	    String logoutUrl = String.format("https://%s/v2/logout?client_id=%s&returnTo=%s",
	    									auth0LoginHelper.getAuth0Credentials().getDomain(),
	    									auth0LoginHelper.getAuth0Credentials().getClientId(),
	            							auth0LoginHelper.getAuth0Credentials().getCallbackLogout());
	    
	    response.sendRedirect(logoutUrl);
		
		return Collections.singletonMap("logout", "success");			
	}
}
