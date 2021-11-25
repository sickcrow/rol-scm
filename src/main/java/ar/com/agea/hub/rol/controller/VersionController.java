package ar.com.agea.hub.rol.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.agea.hub.rol.utils.ViewNamingName;

/**
 * Representa la version de la aplicación.
 * 
 * @author		Alejandro Javier Di Fiore
 * @version		1.0 16/07/2013
 */
@Controller
public class VersionController extends ROLController {

	/**
	 * Mapea /version a la vista que representa la version.
	 * 
	 * @return Vista que representa la version. 
	 */
	@RequestMapping(value = "/version", method = RequestMethod.GET)
	public ModelAndView showVersion(HttpSession session) {		
		return getModelAndView(ViewNamingName.VERSION);	
	}
}
