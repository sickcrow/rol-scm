/*
 * @(#)TiposOperacionHUBResultTest.java		1.0 26/08/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.TipoOperacionDTO;

/**
 * Representa JUnit Tests de inicializaci�n para la clase TiposOperacionResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/08/2013
 */
public class TiposOperacionHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo TiposOperacionResult.
	 */
	@Test
	public void testConstructor() {
		TiposOperacionHUBResult result = new TiposOperacionHUBResult();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"TiposOperacionResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setObject y getObject de la clase TiposOperacionResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		TiposOperacionHUBResult result = new TiposOperacionHUBResult();
		
		List<TipoOperacionDTO> tiposOperacion = new ArrayList<TipoOperacionDTO>(); 
		
		result.setObject(tiposOperacion);
		
		tiposOperacion = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setObject\" o \"getObject\" de la clase \"TiposOperacionResult\".",
				tiposOperacion);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setErrors y getErrors de la clase TiposOperacionResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		TiposOperacionHUBResult result = new TiposOperacionHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setErrors\" o \"getErrors\" de la clase \"TiposOperacionResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo hasErrors de la clase TiposOperacionResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		TiposOperacionHUBResult result = new TiposOperacionHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"TiposOperacionResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"TiposOperacionResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"TiposOperacionResult\".",
				hasErrors);
	}
}
