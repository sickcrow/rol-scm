/*
 * @(#)ConceptosVendibleHUBResultTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ConceptoVendibleDTO;

/**
 * Representa JUnit Tests de inicializaci?n para la clase ConceptosVendibleHUBResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ConceptosVendibleHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creaci?n de objeto de tipo ConceptosVendibleHUBResult.
	 */
	@Test
	public void testConstructor() {
		ConceptosVendibleHUBResult result = new ConceptosVendibleHUBResult();
		
		Assert.assertNotNull("Ha fallado la creaci?n del objeto de tipo \"ConceptosVendibleHUBResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecuci?n de m?todos setObject y getObject de la clase ConceptosVendibleHUBResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		ConceptosVendibleHUBResult result = new ConceptosVendibleHUBResult();
		
		List<ConceptoVendibleDTO> conceptosVendible = new ArrayList<ConceptoVendibleDTO>();
		
		result.setObject(conceptosVendible);
		
		conceptosVendible = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al m?todo \"setObject\" o \"getObject\" de la clase \"ConceptosVendibleHUBResult\".",
				conceptosVendible);
	}
	
	/**
	 * Comprueba la ejecuci?n de m?todos setErrors y getErrors de la clase ConceptosVendibleHUBResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		ConceptosVendibleHUBResult result = new ConceptosVendibleHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al m?todo \"setErrors\" o \"getErrors\" de la clase \"ConceptosVendibleHUBResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecuci?n de m?todo hasErrors de la clase ConceptosVendibleHUBResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		ConceptosVendibleHUBResult result = new ConceptosVendibleHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m?todo \"hasErrors\" de la clase \"ConceptosVendibleHUBResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m?todo \"hasErrors\" de la clase \"ConceptosVendibleHUBResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al m?todo \"hasErrors\" de la clase \"ConceptosVendibleHUBResult\".",
				hasErrors);
	}
}
