/*
 * @(#)DatesHUBResultTest.java		1.0 20/08/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase DatesResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 20/08/2013
 */
public class DatesHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo DatesResult.
	 */
	@Test
	public void testConstructor() {
		DatesHUBResult result = new DatesHUBResult();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"DatesResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setObject y getObject de la clase DatesResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		DatesHUBResult result = new DatesHUBResult();
		
		List<Date> dates = new ArrayList<Date>(); 
		dates.add(new Date());
		dates.add(new Date());
		dates.add(new Date());
		
		result.setObject(dates);
		
		dates = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setObject\" o \"getObject\" de la clase \"DatesResult\".",
				dates);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setErrors y getErrors de la clase DatesResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		DatesHUBResult result = new DatesHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setErrors\" o \"getErrors\" de la clase \"DatesResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo hasErrors de la clase DatesResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		DatesHUBResult result = new DatesHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"DatesResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"DatesResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"DatesResult\".",
				hasErrors);
	}
}
