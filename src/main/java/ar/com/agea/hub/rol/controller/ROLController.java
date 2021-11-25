/*
 * @(#)ROLController.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.controller;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import ar.com.agea.hub.rol.exception.InitializationException;
import ar.com.agea.hub.rol.exception.ServiceException;
import ar.com.agea.hub.rol.utils.ViewNamingName;

/**
 * Brinda una intefaz unificada a todos los Controllers para el acceso
 * a los servicios HUB y manejo de vistas y excepciones.
 * <p>
 * Todos los Controllers deben extender de esta clase para heredar y
 * utilizar sus prestaciones.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public abstract class ROLController {
	
	private static final String LOGGER_NAME = "rol";
	
	private final Logger logger;

	/**
	 * Instancia un objeto de tipo ROLController.
	 * <p>
	 * La instanciación se realiza a partir de sus clases derivadas.
	 */
	protected ROLController() {
		 logger = Logger.getLogger(LOGGER_NAME);
	}
	
	
	/**
	 * Obtiene el logger asociado a todos los Controllers.
	 *  
	 * @return Logger asociado.
	 */
	protected Logger getLogger() {
		return logger;
	}

	/**
	 * Maneja las excepciones lanzadas por problemas internos de la
	 * aplicación y las direcciona a una página de errores internos.
	 * <p>
	 * Estos son errores relacionados con lógica de programación que
	 * no contemplan ciertos casos excepcionales. Por tal motivo las
	 * excepciones que captura este método son excepciones de tipo
	 * RuntimeException y sus clases derivadas.
	 * 
	 * @param exception Excepción que produce el error.
	 * @return Página jsp de error interno direccionada.
	 */
	@ExceptionHandler({NullPointerException.class, InitializationException.class, ServiceException.class})
	@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
	@ResponseBody
	protected final String handleInternalExceptions(Exception exception) {
		logger.error("Ha fallado el flujo de la aplicación", exception);
		
		return exception.getMessage();
	}
	
	/**
	 * Maneja las excepciones lanzadas por conexión a la aplicación y las
	 * direcciona a una página de errores externos.
	 * <p>
	 * Estos son errores relacionados con localización de recursos
	 * inexistentes, problemas en el servidor, etc.
	 * 
	 * @param exception Excepción que produce el error.
	 * @return Página jsp de error externo direccionada.
	 */
	@ExceptionHandler({ServletException.class, HttpMessageConversionException.class, TypeMismatchException.class,
		HttpClientErrorException.class})
	@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE)
	protected final String handleExternalExceptions(Exception exception) {
		logger.error("Ha fallado el flujo de la aplicación", exception);
		
		return getView(ViewNamingName.EXTERNAL_ERROR);
	}

	/**
	 * Maneja las excepciones lanzadas por request no mapeados dentro de un controller y las
	 * direcciona a una página de no encontrada.
	 * <p>
	 * Estos son errores relacionados con request no mapeados.
	 * 
	 * @param exception Excepción que produce el error.
	 * @return Página jsp de error de pagina no encotrada.
	 */
	@ExceptionHandler({NoSuchRequestHandlingMethodException.class})
	protected final String handlePageNotFoundExceptions(Exception exception) {
		return getView(ViewNamingName.PAGINA_NO_ENCONTRADA);
	}
	
	/**
	 * Obtiene la vista a direccionar a partir de su nombre asociado.
	 * 
	 * @param viewNamingName Nombre de la vista.
	 * @return Vista.
	 */
	protected final String getView(ViewNamingName viewNamingName) {
		return viewNamingName.getName();
	}
	
	/**
	 * Retorna la vista asociada al parámetro viewNamingName.  
	 * 
	 * @param viewNamingName Nombre de la vista.
	 * @return ModelAndView que contiene la vista.
	 */
	protected final ModelAndView getModelAndView(ViewNamingName viewNamingName) {
		return new ModelAndView(getView(viewNamingName));
	}
}
