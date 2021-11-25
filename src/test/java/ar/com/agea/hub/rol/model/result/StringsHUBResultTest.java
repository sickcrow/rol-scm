/*
 * @(#)StringsHUBResultTest.java		1.0 20/08/2013
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
 * Representa JUnit Tests de inicializaci�n para la clase StringsResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 20/08/2013
 */
public class StringsHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo StringsResult.
	 */
	@Test
	public void testConstructor() {
		StringsHUBResult result = new StringsHUBResult();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"StringsResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setObject y getObject de la clase StringsResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		StringsHUBResult result = new StringsHUBResult();
		
		List<String> palabrasProhibidas = new ArrayList<String>(); 
		
		result.setObject(palabrasProhibidas);
		
		palabrasProhibidas = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setObject\" o \"getObject\" de la clase \"StringsResult\".",
				palabrasProhibidas);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setErrors y getErrors de la clase StringsResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		StringsHUBResult result = new StringsHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setErrors\" o \"getErrors\" de la clase \"StringsResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo hasErrors de la clase StringsResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		StringsHUBResult result = new StringsHUBResult();
		
		Set<HUBError> errors = null; 
				
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"StringsResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"StringsResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"StringsResult\".",
				hasErrors);
	}
}
