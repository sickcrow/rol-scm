/*
 * @(#)URLServiceValidator.java		1.0 24/06/2014
 */

package ar.com.agea.hub.rol.utils;

/**
 * Valida diferentes datos usados por ROL.
 * 
 * @author		Mariano De Nicolo
 * @version		1.0 24/06/2014
 */
public final class URLServiceValidator {

	private static final int MAX_STRING_LENGTH = 255; 
	private static final int LOW_ASCII_CHAR_USED = 32;
	private static final int HIGH_ASCII_CHAR_USED = 126;
	
	private URLServiceValidator() {}
	
	/**
	 * Verifica que el objeto posea la longitud correcta y que sus caracteres ASCII sean imprimibles.
	 *  
	 * @param value Objeto a verificar. 
	 * @return false si el objeto posee una longitud mayor a 255 caracteres o si posee al menos un caracter ASCII no imprimible. 
	 */
	public static boolean validarParametroStringOK(String value) {
		boolean result = true;
		
		if (value != null) {
			if (value.length() > MAX_STRING_LENGTH) {
				result = false;
			} else {
				for (int i = 0; i < value.length(); i++) {
					int asciiChar = value.charAt(i);
					
					if (asciiChar < LOW_ASCII_CHAR_USED || asciiChar > HIGH_ASCII_CHAR_USED) {
						result = false;
						
						break;
					}
				}
			}
		}
		
		return result;
	}
}
