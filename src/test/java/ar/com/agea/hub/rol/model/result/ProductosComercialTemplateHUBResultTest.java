/*
 * @(#)ProductosComercialTemplateHUBResultTest.java		1.0 10/07/2014
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ProductoComercialTemplateDTO;

/**
 * Representa JUnit Tests de inicialización para la clase ProductosComercialTemplateHUBResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/07/2014
 */
public class ProductosComercialTemplateHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ProductosComercialTemplateHUBResult.
	 */
	@Test
	public void testConstructor() {
		ProductosComercialTemplateHUBResult result = new ProductosComercialTemplateHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ProductosComercialTemplateHUBResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase ProductosComercialTemplateHUBResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		ProductosComercialTemplateHUBResult result = new ProductosComercialTemplateHUBResult();
		
		List<ProductoComercialTemplateDTO> productoComercialTemplate = new ArrayList<ProductoComercialTemplateDTO>();
		
		result.setObject(productoComercialTemplate);
		
		productoComercialTemplate = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"ProductosComercialTemplateHUBResult\".",
				productoComercialTemplate);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase ProductosComercialTemplateHUBResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		ProductosComercialTemplateHUBResult result = new ProductosComercialTemplateHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"ProductosComercialTemplateHUBResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase ProductosComercialTemplateHUBResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		ProductosComercialTemplateHUBResult result = new ProductosComercialTemplateHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ProductosComercialTemplateHUBResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ProductosComercialTemplateHUBResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"ProductosComercialTemplateHUBResult\".",
				hasErrors);
	}
}
