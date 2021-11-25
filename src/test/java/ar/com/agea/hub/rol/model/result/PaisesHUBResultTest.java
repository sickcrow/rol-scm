/*
 * @(#)PaisesHUBResultTest.java		1.0 10/07/2014
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.PaisDTO;

/**
 * Representa JUnit Tests de inicialización para la clase PaisesHUBResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/07/2014
 */
public class PaisesHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo PaisesHUBResult.
	 */
	@Test
	public void testConstructor() {
		PaisesHUBResult result = new PaisesHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"PaisesHUBResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase PaisesHUBResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		PaisesHUBResult result = new PaisesHUBResult();
		
		List<PaisDTO> paises = new ArrayList<PaisDTO>();
		
		result.setObject(paises);
		
		paises = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"PaisesHUBResult\".",
				paises);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase PaisesHUBResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		PaisesHUBResult result = new PaisesHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"PaisesHUBResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase PaisesHUBResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		PaisesHUBResult result = new PaisesHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"PaisesHUBResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"PaisesHUBResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"PaisesHUBResult\".",
				hasErrors);
	}
}
