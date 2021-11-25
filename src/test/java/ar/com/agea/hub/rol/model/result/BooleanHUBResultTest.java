/*
 * @(#)BooleanHUBResultTest.java		1.0 31/07/2014
 */

package ar.com.agea.hub.rol.model.result;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase BooleanHUBResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 31/07/2014
 */
public class BooleanHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo BooleanHUBResult.
	 */
	@Test
	public void testConstructor() {
		BooleanHUBResult result = new BooleanHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"BooleanHUBResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase BooleanHUBResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		BooleanHUBResult result = new BooleanHUBResult();
		
		Boolean value = true; 
		
		result.setObject(value);
		
		value = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"BooleanHUBResult\".",
				value);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase BooleanHUBResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		BooleanHUBResult result = new BooleanHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"BooleanHUBResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase BooleanHUBResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		BooleanHUBResult result = new BooleanHUBResult();
		
		Set<HUBError> errors = null; 
				
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"BooleanHUBResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"BooleanHUBResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"BooleanHUBResult\".",
				hasErrors);
	}
}
