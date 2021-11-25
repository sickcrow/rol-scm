/*
 * @(#)CapturadorHUBResultTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.CapturadorDTO;

/**
 * Representa JUnit Tests de inicialización para la clase CapturadorHUBResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class CapturadorHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo CapturadorHUBResult.
	 */
	@Test
	public void testConstructor() {
		CapturadorHUBResult result = new CapturadorHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"CapturadorHUBResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase CapturadorHUBResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		CapturadorHUBResult result = new CapturadorHUBResult();
		
		CapturadorDTO capturador = new CapturadorDTO();
		
		result.setObject(capturador);
		
		capturador = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"CapturadorHUBResult\".",
				capturador);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase CapturadorHUBResultCapturadorHUBResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		CapturadorHUBResult result = new CapturadorHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"CapturadorHUBResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase CapturadorHUBResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		CapturadorHUBResult result = new CapturadorHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"CapturadorHUBResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"CapturadorHUBResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"CapturadorHUBResult\".",
				hasErrors);
	}
}
