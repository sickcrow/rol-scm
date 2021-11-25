/*
 * @(#)ProductoComercialHUBResultTest.java		1.0 26/08/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ProductoComercialDTO;

/**
 * Representa JUnit Tests de inicialización para la clase ProductoComercialResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/08/2013
 */
public class ProductoComercialHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ProductoComercialResult.
	 */
	@Test
	public void testConstructor() {
		ProductoComercialHUBResult result = new ProductoComercialHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ProductoComercialResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase ProductoComercialResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		ProductoComercialHUBResult result = new ProductoComercialHUBResult();
		
		ProductoComercialDTO productoComercial = new ProductoComercialDTO(); 
		
		result.setObject(productoComercial);
		
		productoComercial = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"ProductoComercialResult\".",
				productoComercial);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase ProductoComercialResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		ProductoComercialHUBResult result = new ProductoComercialHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"ProductoComercialResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase ProductoComercialResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		ProductoComercialHUBResult result = new ProductoComercialHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ProductoComercialResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ProductoComercialResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"ProductoComercialResult\".",
				hasErrors);
	}
}
