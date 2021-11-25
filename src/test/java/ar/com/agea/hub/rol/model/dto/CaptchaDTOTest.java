/*
 * @(#)CaptchaDTOTest.java		1.0 24/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase CaptchaDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 24/09/2013
 */
public class CaptchaDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo CaptchaDTO.
	 */
	@Test
	public void testConstructor() {
		CaptchaDTO dto = new CaptchaDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"CaptchaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setHashValue y getHashValue de la clase CaptchaDTO. 
	 */
	@Test
	public void testSetAndGetHashValueMethod() {
		CaptchaDTO dto = new CaptchaDTO();
		String hashValue = "HASH_VALUE";
		
		dto.setHashValue(hashValue);
		
		String tmp = dto.getHashValue();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setHashValue\" o \"getHashValue\" de la clase \"CaptchaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getHashValue\" de la clase \"CaptchaDTO\""
				+ " no corresponde al valor enviado como argumento.", hashValue, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setInputValue y getInputValue de la clase CaptchaDTO. 
	 */
	@Test
	public void testSetAndGetInputValueMethod() {
		CaptchaDTO dto = new CaptchaDTO();
		String inputValue = "INPUT_VALUE";
		
		dto.setInputValue(inputValue);
		
		String tmp = dto.getInputValue();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setInputValue\" o \"getInputValue\" de la clase \"CaptchaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getInputValue\" de la clase \"CaptchaDTO\""
				+ " no corresponde al valor enviado como argumento.", inputValue, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase CaptchaDTO. 
	 */
	@Test
	public void testToStringMethod() {
		CaptchaDTO dto = new CaptchaDTO();
		
		dto.setHashValue("HASH_VALUE");
		dto.setInputValue("INPUT_VALUE");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"CaptchaDTO\".", tmp);
	}
}
