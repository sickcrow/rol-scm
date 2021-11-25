/*
 * @(#)ProvinciasHUBResultTest.java		1.0 10/07/2014
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ProvinciaDTO;

/**
 * Representa JUnit Tests de inicialización para la clase ProvinciasHUBResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/07/2014
 */
public class ProvinciasHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ProvinciasHUBResult.
	 */
	@Test
	public void testConstructor() {
		ProvinciasHUBResult result = new ProvinciasHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ProvinciasHUBResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase ProvinciasHUBResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		ProvinciasHUBResult result = new ProvinciasHUBResult();
		
		List<ProvinciaDTO> provincias = new ArrayList<ProvinciaDTO>();
		
		result.setObject(provincias);
		
		provincias = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"ProvinciasHUBResult\".",
				provincias);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase ProvinciasHUBResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		ProvinciasHUBResult result = new ProvinciasHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"ProvinciasHUBResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase ProvinciasHUBResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		ProvinciasHUBResult result = new ProvinciasHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ProvinciasHUBResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ProvinciasHUBResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"ProvinciasHUBResult\".",
				hasErrors);
	}
}
