/*
 * @(#)ClaseHUBResultTest.java		1.0 31/07/2014
 */

package ar.com.agea.hub.rol.model.result;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ClaseDTO;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ClaseHUBResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 31/07/2014
 */
public class ClaseHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ClaseHUBResult.
	 */
	@Test
	public void testConstructor() {
		ClaseHUBResult result = new ClaseHUBResult();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ClaseHUBResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setObject y getObject de la clase ClaseHUBResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		ClaseHUBResult result = new ClaseHUBResult();
		
		ClaseDTO clase = new ClaseDTO();
		
		result.setObject(clase);
		
		clase = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setObject\" o \"getObject\" de la clase \"ClaseHUBResult\".",
				clase);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setErrors y getErrors de la clase ClaseHUBResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		ClaseHUBResult result = new ClaseHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setErrors\" o \"getErrors\" de la clase \"ClaseHUBResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo hasErrors de la clase ClaseHUBResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		ClaseHUBResult result = new ClaseHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"ClaseHUBResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"ClaseHUBResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"ClaseHUBResult\".",
				hasErrors);
	}
}
