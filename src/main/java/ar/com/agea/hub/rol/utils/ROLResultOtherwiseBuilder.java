/*
 * @(#)ROLResultOtherwiseBuilder.java		1.0 21/11/2013
 */

package ar.com.agea.hub.rol.utils;

import java.util.HashMap;
import java.util.Map;

import ar.com.agea.hub.rol.model.result.ROLError;
import ar.com.agea.hub.rol.model.result.ROLErrorType;
import ar.com.agea.hub.rol.model.result.ROLMessageCode;

/**
 * Provee una implementación de la clase ROLResultBuilder.
 * <p>
 * Construye un objeto ROLResult a partir datos provenientes de un objeto cualquiera que
 * no represente un resultado GWP, HUB y PASE.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 21/11/2013
 */
public final class ROLResultOtherwiseBuilder extends ROLResultBuilder {
	
	private static Map<String, ROLMessageCode> messagesCodeByString;
	
	static {
		messagesCodeByString = new HashMap<String, ROLMessageCode>();
		
		messagesCodeByString.put("La fecha de publicación fue cerrada.", ROLMessageCode.CODE_000011);
	}
	
	/**
	 * Construye los datos del objeto ROLResult.
	 * 
	 * @param result Objeto datos del objeto ROLResult.
	 */
	public void buildData(Object result) {
		rolResult.setObject(result);
	}
	
	/**
	 * Construye los datos del objeto ROLResult.
	 * 
	 * @param errorType Objeto tipo error del objeto ROLResult.
	 * @param message Objeto mensaje del objeto ROLResult. 
	 */
	public void buildData(ROLErrorType errorType, String message) {
		ROLError rolError = new ROLError();
		
		rolError.setMessageCode(messagesCodeByString.get(message));
		rolError.setErrorType(errorType);
		rolError.setMessage(message);
		
		rolResult.addError(rolError);
	}
}
