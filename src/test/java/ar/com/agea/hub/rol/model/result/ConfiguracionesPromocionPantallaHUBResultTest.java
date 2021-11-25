/*
 * @(#)ConfiguracionesPromocionPantallaHUBResultTest.java		1.0 10/07/2014
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ConfiguracionPromocionPantallaDTO;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ConfiguracionesPromocionPantallaHUBResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/07/2014
 */
public class ConfiguracionesPromocionPantallaHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ConfiguracionesPromocionPantallaHUBResult.
	 */
	@Test
	public void testConstructor() {
		ConfiguracionesPromocionPantallaHUBResult result = new ConfiguracionesPromocionPantallaHUBResult();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ConfiguracionesPromocionPantallaHUBResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setObject y getObject de la clase ConfiguracionesPromocionPantallaHUBResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		ConfiguracionesPromocionPantallaHUBResult result = new ConfiguracionesPromocionPantallaHUBResult();
		
		List<ConfiguracionPromocionPantallaDTO> configuracionPromocionPantalla = new ArrayList<ConfiguracionPromocionPantallaDTO>(); 
		
		result.setObject(configuracionPromocionPantalla);
		
		configuracionPromocionPantalla = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setObject\" o \"getObject\" de la clase \"ConfiguracionesPromocionPantallaHUBResult\".",
				configuracionPromocionPantalla);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setErrors y getErrors de la clase ConfiguracionesPromocionPantallaHUBResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		ConfiguracionesPromocionPantallaHUBResult result = new ConfiguracionesPromocionPantallaHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setErrors\" o \"getErrors\" de la clase \"ConfiguracionesPromocionPantallaHUBResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo hasErrors de la clase ProductosResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		ConfiguracionesPromocionPantallaHUBResult result = new ConfiguracionesPromocionPantallaHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"ConfiguracionesPromocionPantallaHUBResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"ConfiguracionesPromocionPantallaHUBResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"ConfiguracionesPromocionPantallaHUBResult\".",
				hasErrors);
	}
}
