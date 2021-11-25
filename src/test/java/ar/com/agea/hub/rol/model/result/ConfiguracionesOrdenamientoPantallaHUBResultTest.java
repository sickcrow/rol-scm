/*
 * @(#)ConfiguracionesOrdenamientoPantallaHUBResultTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ConfiguracionOrdenamientoPantallaDTO;

/**
 * Representa JUnit Tests de inicialización para la clase ConfiguracionesOrdenamientoPantallaResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ConfiguracionesOrdenamientoPantallaHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ConfiguracionesOrdenamientoPantallaResult.
	 */
	@Test
	public void testConstructor() {
		ConfiguracionesOrdenamientoPantallaHUBResult result = new ConfiguracionesOrdenamientoPantallaHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ConfiguracionesOrdenamientoPantallaResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase ConfiguracionesOrdenamientoPantallaResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		ConfiguracionesOrdenamientoPantallaHUBResult result = new ConfiguracionesOrdenamientoPantallaHUBResult();
		
		List<ConfiguracionOrdenamientoPantallaDTO> configuracionesOrdenamientoPantalla = new ArrayList<ConfiguracionOrdenamientoPantallaDTO>(); 
		
		result.setObject(configuracionesOrdenamientoPantalla);
		
		configuracionesOrdenamientoPantalla = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"ConfiguracionesOrdenamientoPantallaResult\".",
				configuracionesOrdenamientoPantalla);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase ConfiguracionesOrdenamientoPantallaResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		ConfiguracionesOrdenamientoPantallaHUBResult result = new ConfiguracionesOrdenamientoPantallaHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"ConfiguracionesOrdenamientoPantallaResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase ConfiguracionesOrdenamientoPantallaResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		ConfiguracionesOrdenamientoPantallaHUBResult result = new ConfiguracionesOrdenamientoPantallaHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ConfiguracionesOrdenamientoPantallaResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ConfiguracionesOrdenamientoPantallaResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"ConfiguracionesOrdenamientoPantallaResult\".",
				hasErrors);
	}
}
