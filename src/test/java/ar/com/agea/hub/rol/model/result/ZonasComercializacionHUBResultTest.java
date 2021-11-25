/*
 * @(#)ZonasComercializacionHUBResultTest.java		1.0 26/08/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ZonaComercializacionDTO;

/**
 * Representa JUnit Tests de inicialización para la clase ZonasComercializacionResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/08/2013
 */
public class ZonasComercializacionHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ZonasComercializacionResult.
	 */
	@Test
	public void testConstructor() {
		ZonasComercializacionHUBResult result = new ZonasComercializacionHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ZonasComercializacionResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase ZonasComercializacionResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		ZonasComercializacionHUBResult result = new ZonasComercializacionHUBResult();
		
		List<ZonaComercializacionDTO> zonasComercializacion = new ArrayList<ZonaComercializacionDTO>(); 
		
		result.setObject(zonasComercializacion);
		
		zonasComercializacion = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"ZonasComercializacionResult\".",
				zonasComercializacion);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase ZonasComercializacionResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		ZonasComercializacionHUBResult result = new ZonasComercializacionHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"ZonasComercializacionResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase ZonasComercializacionResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		ZonasComercializacionHUBResult result = new ZonasComercializacionHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ZonasComercializacionResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ZonasComercializacionResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"ZonasComercializacionResult\".",
				hasErrors);
	}
}
