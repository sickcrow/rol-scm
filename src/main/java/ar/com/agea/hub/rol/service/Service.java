/*
 * @(#)ROLService.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.service;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.agea.hub.rol.exception.ServiceException;
import ar.com.agea.hub.rol.facade.Facade;
import ar.com.agea.hub.rol.model.result.HUBError;
import ar.com.agea.hub.rol.model.result.HUBResult;
import ar.com.agea.hub.rol.model.result.ROLError;
import ar.com.agea.hub.rol.model.result.ROLErrorType;
import ar.com.agea.hub.rol.model.result.ROLResult;
import ar.com.agea.hub.rol.utils.ROLResultGWPBuilder;
import ar.com.agea.hub.rol.utils.ROLResultHUBBuilder;
import ar.com.agea.hub.rol.utils.ROLResultOtherwiseBuilder;
import ar.com.agea.hub.rol.utils.URLServiceName;

/**
 * Brinda una intefaz unificada a todos los Services para el acceso
 * a los servicios HUB.
 * <p>
 * Todos los Services deben extender de esta clase para heredar y
 * utilizar sus prestaciones.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public abstract class Service {
	
	private static final String LOGGER_NAME = "rol";
	
	private final Logger logger;

	@Autowired
	private Facade facade;
	
	/**
	 * Instancia un objeto de tipo ROLService.
	 * <p>
	 * La instanciación se realiza a partir de sus clases derivadas.
	 */
	protected Service() {
		 logger = Logger.getLogger(LOGGER_NAME);
	}
	
	/**
	 * Obtiene el logger asociado a todos los Services.
	 *  
	 * @return Logger asociado.
	 */
	protected Logger getLogger() {
		return logger;
	}
	
	/**
	 * Obtiene el ROL facade asociado a todos los servicios.
	 *  
	 * @return Facade asociado.
	 */
	protected Facade getFacade() {
		return facade;
	}
	
	/**
	 * Maneja los errores lanzados por llamadas a los servicios HUB a través
	 * de los Services.
	 * <p>
	 * Este método debe ser llamado cada vez que un servicio HUB devuelve
	 * errores. Dicha lista de errores debe ser enviada como argumento a este método.
	 * 
	 * @param errors Errores que produce la llamada al servicio HUB.
	 * @throws ServiceException Cuando el manejo de errores devuelve errores. 
	 */
	protected void handleErrors(Set<HUBError> errors) throws ServiceException {
		StringBuilder message = new StringBuilder();

		/*
		 * TODO Investigar una manera elegante de no colocar caracteres especiales en back-end
		 * 		para que sean mostrados correctamente en front-end.
		 * 
		 * 		Cuando se implemente en HUB (al igual que se hizo en PASE) los códigos de mensajes
		 * 		(no confundir con códigos de error) se debe quitar este caracter especial.
		 */
		//Ã³ o con tilde
		message.append("Ha ocurrido un error en la aplicaciÃ³n.\n");
		
		for (HUBError error : errors) {
			message.append(error.getErrorType());
			message.append(" : ");
			message.append(error.getMessage());
			message.append("\n");
		}
		
		logger.error(message.toString());
		
		throw new ServiceException(message.toString());
	}

	/**
	 * Maneja el resultado HUB a partir del cual crea un resultado ROL.
	 * 
	 * @param hubResult Resultado HUB a manejar.
	 * @param urlServiceName Nombre de servicio URL del resultado HUB.
	 * @return Resultado ROL creado.
	 * @throws ServiceException Cuando el manejo de resultado HUB devuelve errores.
	 */
	protected ROLResult handleResult(HUBResult<?> hubResult, URLServiceName urlServiceName) throws ServiceException {
		ROLResultHUBBuilder builder = new ROLResultHUBBuilder();
		
		builder.buildROLResult();
		builder.buildData(hubResult, urlServiceName);
		
		return processErrors(builder.getResult());
	}
	
	
	/**
	 * Maneja el resultado GWP a partir del cual crea un resultado ROL.
	 * 	
	 * @param stringResult Resultado GWP a manejar.
	 * @return Resultado ROL creado.
	 * @throws ServiceException Cuando el manejo de resultado GWP devuelve errores.
	 */
	protected ROLResult handleResult(String stringResult) throws ServiceException {
		ROLResultGWPBuilder builder = new ROLResultGWPBuilder();
		
		builder.buildROLResult();
		builder.buildData(stringResult);
		
		return processErrors(builder.getResult());
	}
	
	/**
	 * Maneja el resultado de cualquier tipo de dato a partir del cual crea un resultado ROL.
	 * 
	 * Este manejador de resultado tiene la particularidad de no generar excepciones a partir
	 * del tipo de error que pueda contener debido a que son resultados manejados
	 * por ROLService.
	 * 
	 * @param result Resultado de cualquier tipo de dato a manejar.
	 * @return Resultado ROL creado.
	 */
	protected ROLResult handleResult(Object result) {
		ROLResultOtherwiseBuilder builder = new ROLResultOtherwiseBuilder();
		
		builder.buildROLResult();
		builder.buildData(result);
		
		return builder.getResult();
	}
	
	/**
	 * Maneja el resultado de cualquier tipo de dato a partir del cual crea un resultado ROL.
	 * 
	 * Este manejador de resultado tiene la particularidad de no generar excepciones a partir
	 * del tipo de error que pueda contener debido a que son resultados manejados
	 * por ROLService.
	 * 
	 * @param errorType Objeto tipo error del objeto resultado ROL.
	 * @param message Objeto mensaje del objeto resultado ROL.
	 * @return Resultado ROL creado.
	 * @throws ServiceException Cuando el manejo de resultado GWP devuelve errores.
	 */
	protected ROLResult handleResult(ROLErrorType errorType, String message) throws ServiceException {
		ROLResultOtherwiseBuilder builder = new ROLResultOtherwiseBuilder();
		
		builder.buildROLResult();
		builder.buildData(errorType, message);
		
		return processErrors(builder.getResult());
	}
	
	/**
	 * Maneja el resultado de cualquier tipo de dato a partir del cual crea un resultado ROL.
	 * 
	 * Este manejador de resultado tiene la particularidad de no generar excepciones a partir
	 * del tipo de error que pueda contener debido a que son resultados manejados
	 * por ROLService.
	 *  
	 * @param result Resultado de cualquier tipo de dato a manejar.
	 * @param errorType Objeto tipo error del objeto resultado ROL.
	 * @param message Objeto mensaje del objeto resultado ROL.
	 * @return Resultado ROL creado.
	 * @throws ServiceException Cuando el manejo de resultado GWP devuelve errores.
	 */
	protected ROLResult handleResult(Object result, ROLErrorType errorType, String message) throws ServiceException {
		ROLResultOtherwiseBuilder builder = new ROLResultOtherwiseBuilder();
		
		builder.buildROLResult();
		builder.buildData(result);
		builder.buildData(errorType, message);
		
		return builder.getResult();
	}
	
	/**
	 * Maneja el resultado de cualquier tipo de dato a partir del cual crea un resultado ROL.
	 * 
	 * Este manejador de resultado tiene la particularidad de no generar excepciones a partir
	 * del tipo de error que pueda contener debido a que son resultados manejados
	 * por ROLService.
	 * 
	 * @param result Resultado de cualquier tipo de dato a manejar.
	 * @param rolResult Objeto ROL result del objeto resultado ROL.
	 * @return Resultado ROL creado.
	 * @throws ServiceException Cuando el manejo de resultado GWP devuelve errores.
	 */
	protected ROLResult handleResult(Object result, ROLResult rolResult) throws ServiceException {
		ROLResultOtherwiseBuilder builder = new ROLResultOtherwiseBuilder();
		
		builder.buildROLResult();
		builder.buildData(result);
		
		for (ROLError error : rolResult.getErrors()) {
			builder.buildData(error.getErrorType(), error.getMessage());
		}
		
		return builder.getResult();
	}
	
	private ROLResult processErrors(ROLResult rolResult) throws ServiceException {
		for (ROLError rolError : rolResult.getErrors()) {
			if (rolError.getErrorType().equals(ROLErrorType.EXCEPTION)) {
				throw new ServiceException(rolError.getMessage());
			}
		}
		
		return rolResult;
	}
}
