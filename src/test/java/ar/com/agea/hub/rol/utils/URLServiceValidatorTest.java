/*
 * @(#)URLServiceValidatorTest.java		1.0 10/07/2014
 */

package ar.com.agea.hub.rol.utils;

import junit.framework.Assert;

import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase URLServiceValidator.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/07/2014
 */
public class URLServiceValidatorTest extends InstantiationTest {

	/**
	 * Comprueba la ejecución de método validateLengthTypeCharsStringParam de la clase URLServiceValidator. 
	 */
	@Test
	public void testValidateLengthTypeCharsStringParamMethod() {
		String input = null;
		
		boolean output = URLServiceValidator.validarParametroStringOK(input);

		Assert.assertTrue("Ha fallado la llamada al método \"validateLengthTypeCharsStringParam\" para el valor " + input + " de la clase \"URLServiceValidator\".", output);
		
		input = "LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENGTH_LENG";
		
		output = URLServiceValidator.validarParametroStringOK(input);
		
		Assert.assertFalse("Ha fallado la llamada al método \"validateLengthTypeCharsStringParam\" para el valor " + input + " de la clase \"URLServiceValidator\".", output);
		
		input = Character.toString((char) 31);
		
		output = URLServiceValidator.validarParametroStringOK(input);
		
		Assert.assertFalse("Ha fallado la llamada al método \"validateLengthTypeCharsStringParam\" para el valor " + input + " de la clase \"URLServiceValidator\".", output);
		
		input = Character.toString((char) 127);
		
		output = URLServiceValidator.validarParametroStringOK(input);
		
		Assert.assertFalse("Ha fallado la llamada al método \"validateLengthTypeCharsStringParam\" para el valor " + input + " de la clase \"URLServiceValidator\".", output);
		
		input = "VALUE_300";
		
		output = URLServiceValidator.validarParametroStringOK(input);
		
		Assert.assertTrue("Ha fallado la llamada al método \"validateLengthTypeCharsStringParam\" para el valor " + input + " de la clase \"URLServiceValidator\".", output);
	}
}
