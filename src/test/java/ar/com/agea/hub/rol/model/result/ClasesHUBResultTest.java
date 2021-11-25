/*
 * @(#)ClasesHUBResultTest.java		1.0 30/08/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ClaseDTO;

/**
 * Representa JUnit Tests de inicialización para la clase ClasesResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 30/08/2013
 */
public class ClasesHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ClasesResult.
	 */
	@Test
	public void testConstructor() {
		ClasesHUBResult result = new ClasesHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ClasesResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase ClasesResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		ClasesHUBResult result = new ClasesHUBResult();
		
		List<ClaseDTO> clases = new ArrayList<ClaseDTO>(); 
		
		result.setObject(clases);
		
		clases = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"ClasesResult\".",
				clases);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase ClasesResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		ClasesHUBResult result = new ClasesHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"ClasesResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase ClasesResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		ClasesHUBResult result = new ClasesHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ClasesResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ClasesResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"ClasesResult\".",
				hasErrors);
	}
}
