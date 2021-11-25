/*
 * @(#)ProductoComercialDefaultHUBResultTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ProductoComercialDefaultDTO;

/**
 * Representa JUnit Tests de inicialización para la clase ProductoComercialDefaultResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ProductoComercialDefaultHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ProductoComercialDefaultResult.
	 */
	@Test
	public void testConstructor() {
		ProductoComercialDefaultHUBResult result = new ProductoComercialDefaultHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ProductoComercialDefaultResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase ProductoComercialDefaultResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		ProductoComercialDefaultHUBResult result = new ProductoComercialDefaultHUBResult();
		
		ProductoComercialDefaultDTO productoComercialDefault = new ProductoComercialDefaultDTO();
		
		result.setObject(productoComercialDefault);
		
		productoComercialDefault = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"ProductoComercialDefaultResult\".",
				productoComercialDefault);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase ProductoComercialDefaultResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		ProductoComercialDefaultHUBResult result = new ProductoComercialDefaultHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"ProductoComercialDefaultResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase ProductoComercialDefaultResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		ProductoComercialDefaultHUBResult result = new ProductoComercialDefaultHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ProductoComercialDefaultResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ProductoComercialDefaultResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"ProductoComercialDefaultResult\".",
				hasErrors);
	}
}
