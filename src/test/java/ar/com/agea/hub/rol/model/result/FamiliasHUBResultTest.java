/*
 * @(#)FamiliasHUBResultTest.java		1.0 31/07/2014
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.FamiliaDTO;

/**
 * Representa JUnit Tests de inicialización para la clase FamiliasHUBResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 31/07/2014
 */
public class FamiliasHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo FamiliasHUBResult.
	 */
	@Test
	public void testConstructor() {
		FamiliasHUBResult result = new FamiliasHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"FamiliasHUBResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase FamiliasHUBResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		FamiliasHUBResult result = new FamiliasHUBResult();
		
		List<FamiliaDTO> familias = new ArrayList<FamiliaDTO>(); 
		
		result.setObject(familias);
		
		familias = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"FamiliasHUBResult\".",
				familias);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase FamiliasHUBResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		FamiliasHUBResult result = new FamiliasHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"FamiliasHUBResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase FamiliasHUBResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		FamiliasHUBResult result = new FamiliasHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"FamiliasHUBResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"FamiliasHUBResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"FamiliasHUBResult\".",
				hasErrors);
	}
}
