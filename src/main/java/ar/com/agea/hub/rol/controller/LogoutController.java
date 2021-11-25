package ar.com.agea.hub.rol.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.agea.hub.rol.utils.Auth0LoginHelper;
import ar.com.agea.hub.rol.utils.ViewNamingName;

/**
 * Representa el logout de la aplicación.
 * 
 * @author		Alejandro Javier Di Fiore
 * 				
 * @version		1.0 11/11/2013
 */
@Controller
public class LogoutController extends ROLController {
	
	@Autowired
	private Auth0LoginHelper auth0LoginHelper;
	
	/**
	 * Mapea /crear-aviso a la vista que representa la creación de avisos.
	 * 
	 * @return Vista que representa la creación de avisos.
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView  showLogout(HttpSession session) {		
		return getModelAndView(ViewNamingName.LOGOUT);		
	}
	
	/**
	 * Realiza las operaciones de logout, invalidación de session.
	 * 
	 * @return Mensaje de exito. 
	 * @throws IOException 
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, ? extends Object> logout(HttpSession session, HttpServletResponse response) throws IOException {		
		
		//Elimino la session para limpiar valores
		session.invalidate();
				
		this.getLogger().debug("Ejecutando llamada de logout desde LogoutController");
		
	    String logoutUrl = String.format("https://%s/v2/logout?client_id=%s&returnTo=%s",
	    									auth0LoginHelper.getAuth0Credentials().getDomain(),
	    									auth0LoginHelper.getAuth0Credentials().getClientId(),
	            							auth0LoginHelper.getAuth0Credentials().getCallbackLogout());
	    
	    response.sendRedirect(logoutUrl);
		
		return Collections.singletonMap("logout", "success");			
	}
}
