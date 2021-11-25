/*
 * @(#)PropiedadesDefaultHUBResultTest.java		1.0 21/08/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.PropiedadDefaultDTO;

/**
 * Representa JUnit Tests de inicialización para la clase PropiedadesDefaultResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 21/08/2013
 */
public class PropiedadesDefaultHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo PropiedadesDefaultResult.
	 */
	@Test
	public void testConstructor() {
		PropiedadesDefaultHUBResult result = new PropiedadesDefaultHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"PropiedadesDefaultResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase PropiedadesDefaultResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		PropiedadesDefaultHUBResult result = new PropiedadesDefaultHUBResult();
		
		List<PropiedadDefaultDTO> propiedadesDefault = new ArrayList<PropiedadDefaultDTO>(); 
		
		result.setObject(propiedadesDefault);
		
		propiedadesDefault = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"PropiedadesDefaultResult\".",
				propiedadesDefault);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase PropiedadesDefaultResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		PropiedadesDefaultHUBResult result = new PropiedadesDefaultHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"PropiedadesDefaultResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase PropiedadesDefaultResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		PropiedadesDefaultHUBResult result = new PropiedadesDefaultHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"PropiedadesDefaultResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"PropiedadesDefaultResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"PropiedadesDefaultResult\".",
				hasErrors);
	}
}
