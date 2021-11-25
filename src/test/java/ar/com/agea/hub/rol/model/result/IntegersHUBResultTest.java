/*
 * @(#)IntegersHUBResultTest.java		1.0 20/08/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase IntegersResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 20/08/2013
 */
public class IntegersHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo IntegersResult.
	 */
	@Test
	public void testConstructor() {
		IntegersHUBResult result = new IntegersHUBResult();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"IntegersResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setObject y getObject de la clase IntegersResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		IntegersHUBResult result = new IntegersHUBResult();
		
		List<Integer> caracteresInvalidos = new ArrayList<Integer>(); 
		
		result.setObject(caracteresInvalidos);
		
		caracteresInvalidos = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setObject\" o \"getObject\" de la clase \"IntegersResult\".",
				caracteresInvalidos);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setErrors y getErrors de la clase IntegersResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		IntegersHUBResult result = new IntegersHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setErrors\" o \"getErrors\" de la clase \"IntegersResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo hasErrors de la clase IntegersResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		IntegersHUBResult result = new IntegersHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"IntegersResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"IntegersResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"IntegersResult\".",
				hasErrors);
	}
}
