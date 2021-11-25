/*
 * @(#)GWPNotificarPagoController.java		1.0 30/10/2013
 */

package ar.com.agea.hub.rol.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ar.com.agea.hub.rol.exception.ServiceException;
import ar.com.agea.hub.rol.model.dto.GWPNotificationDTO;
import ar.com.agea.hub.rol.service.ROLService;
import ar.com.agea.hub.rol.utils.CustomXMLUnmarshaller;

/**
 * @author		Juan Martín Lichowski
 * @version		1.0 30/10/2013
 */
@Controller
public class GWPNotificarPagoController extends ROLController {
	
	@Autowired
	private ROLService rolService;

	@Autowired
	private CustomXMLUnmarshaller customXMLUnmarshaller;
	
	@RequestMapping(value = "executeNotificarPago", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void executeNotificarPago(HttpServletRequest request) throws ServiceException {
		GWPNotificationDTO dto = (GWPNotificationDTO) customXMLUnmarshaller.unmarshal(request);
		
 		rolService.executeNotificarPago(dto);
	}
}
