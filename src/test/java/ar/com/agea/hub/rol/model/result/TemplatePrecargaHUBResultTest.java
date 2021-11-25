/*
 * @(#)TemplatePrecargaHUBResultTest.java		1.0 10/07/2014
 */

package ar.com.agea.hub.rol.model.result;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.TemplatePrecargaDTO;

/**
 * Representa JUnit Tests de inicialización para la clase TemplatePrecargaHUBResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/07/2014
 */
public class TemplatePrecargaHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo TemplatePrecargaHUBResult.
	 */
	@Test
	public void testConstructor() {
		TemplatePrecargaHUBResult result = new TemplatePrecargaHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"TemplatePrecargaHUBResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase TemplatePrecargaHUBResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		TemplatePrecargaHUBResult result = new TemplatePrecargaHUBResult();
		
		TemplatePrecargaDTO templatePrecarga = new TemplatePrecargaDTO();
		
		result.setObject(templatePrecarga);
		
		templatePrecarga = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"TemplatePrecargaHUBResult\".",
				templatePrecarga);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase TemplatePrecargaHUBResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		TemplatePrecargaHUBResult result = new TemplatePrecargaHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"TemplatePrecargaHUBResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase TemplatePrecargaHUBResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		TemplatePrecargaHUBResult result = new TemplatePrecargaHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"TemplatePrecargaHUBResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"TemplatePrecargaHUBResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"TemplatePrecargaHUBResult\".",
				hasErrors);
	}
}
