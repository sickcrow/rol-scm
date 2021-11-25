/*
 * @(#)ROLResultGWPBuilder.java		1.0 21/11/2013
 */

package ar.com.agea.hub.rol.utils;

import ar.com.agea.hub.rol.model.result.ROLError;
import ar.com.agea.hub.rol.model.result.ROLErrorType;

/**
 * Provee una implementación de la clase ROLResultBuilder.
 * <p>
 * Construye un objeto ROLResult a partir datos provenientes de un objeto resultado GWP.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 21/11/2013
 */
public final class ROLResultGWPBuilder extends ROLResultBuilder {
	
	private static final String HTML_TAG = "<html>";
	
	/**
	 * Construye los datos del objeto ROLResult.
	 * 
	 * @param result Objeto datos del objeto ROLResult.
	 */
	public void buildData(String result) {
		if (result != null && result.startsWith(HTML_TAG)) {
			rolResult.setObject(result);
		} else {
			ROLError rolError = new ROLError();
			
			rolError.setErrorType(ROLErrorType.REDIRECTION);
			rolError.setMessage(result);
			
			rolResult.addError(rolError);
		}
	}
}
