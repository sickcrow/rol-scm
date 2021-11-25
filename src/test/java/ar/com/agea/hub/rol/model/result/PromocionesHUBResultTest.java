/*
 * @(#)PromocionesHUBResultTest.java		1.0 10/07/2014
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.PromocionDTO;

/**
 * Representa JUnit Tests de inicializaci�n para la clase PromocionesHUBResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/07/2014
 */
public class PromocionesHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo PromocionesHUBResult.
	 */
	@Test
	public void testConstructor() {
		PromocionesHUBResult result = new PromocionesHUBResult();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"PromocionesHUBResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setObject y getObject de la clase PromocionesHUBResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		PromocionesHUBResult result = new PromocionesHUBResult();
		
		List<PromocionDTO> promociones = new ArrayList<PromocionDTO>();
		
		result.setObject(promociones);
		
		promociones = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setObject\" o \"getObject\" de la clase \"PromocionesHUBResult\".",
				promociones);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setErrors y getErrors de la clase PromocionesHUBResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		PromocionesHUBResult result = new PromocionesHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setErrors\" o \"getErrors\" de la clase \"PromocionesHUBResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo hasErrors de la clase PromocionesHUBResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		PromocionesHUBResult result = new PromocionesHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"PromocionesHUBResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"PromocionesHUBResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"PromocionesHUBResult\".",
				hasErrors);
	}
}
