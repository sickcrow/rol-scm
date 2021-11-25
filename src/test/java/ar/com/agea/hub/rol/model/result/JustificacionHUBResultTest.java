/*
 * @(#)JustificacionHUBResultTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.JustificacionDTO;

/**
 * Representa JUnit Tests de inicialización para la clase JustificacionResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class JustificacionHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo JustificacionResult.
	 */
	@Test
	public void testConstructor() {
		JustificacionHUBResult result = new JustificacionHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"JustificacionResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase JustificacionResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		JustificacionHUBResult result = new JustificacionHUBResult();
		
		JustificacionDTO justificacion = new JustificacionDTO();
		
		result.setObject(justificacion);
		
		justificacion = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"JustificacionResult\".",
				justificacion);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase JustificacionResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		JustificacionHUBResult result = new JustificacionHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"JustificacionResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase JustificacionResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		JustificacionHUBResult result = new JustificacionHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"JustificacionResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"JustificacionResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"JustificacionResult\".",
				hasErrors);
	}
}
