/*
 * @(#)ProductosHUBResultTest.java		1.0 30/08/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ProductoDTO;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ProductosResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 30/08/2013
 */
public class ProductosHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ProductosResult.
	 */
	@Test
	public void testConstructor() {
		ProductosHUBResult result = new ProductosHUBResult();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ProductosResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setObject y getObject de la clase ProductosResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		ProductosHUBResult result = new ProductosHUBResult();
		
		List<ProductoDTO> productos = new ArrayList<ProductoDTO>(); 
		
		result.setObject(productos);
		
		productos = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setObject\" o \"getObject\" de la clase \"ProductosResult\".",
				productos);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setErrors y getErrors de la clase ProductosResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		ProductosHUBResult result = new ProductosHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setErrors\" o \"getErrors\" de la clase \"ProductosResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo hasErrors de la clase ProductosResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		ProductosHUBResult result = new ProductosHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"ProductosResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"ProductosResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"ProductosResult\".",
				hasErrors);
	}
}
