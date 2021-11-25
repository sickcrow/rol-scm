/*
 * @(#)ROLResultTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ROLResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ROLResultTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ROLResult.
	 */
	@Test
	public void testConstructor() {
		ROLResult result = new ROLResult();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ROLResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setObject y getObject de la clase ROLResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		ROLResult result = new ROLResult();
		
		Object object = new Object();
		
		result.setObject(object);
		
		object = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setObject\" o \"getObject\" de la clase \"ROLResult\".",
				object);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setErrors y getErrors de la clase ROLResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		ROLResult result = new ROLResult();
		
		Set<ROLError> errors = new HashSet<ROLError>();
		
		ROLError error = new ROLError();
		
		error.setErrorType(ROLErrorType.VALIDATION);
		error.setMessage("MESSAGE");
		errors.add(error);
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setErrors\" o \"getErrors\" de la clase \"ROLResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo especial addError de la clase ROLResult. 
	 */
	@Test
	public void testSpecialAddErrorMethod() {
		ROLResult result = new ROLResult();
		
		Set<ROLError> errors = new HashSet<ROLError>();
		
		result.addError(ROLErrorType.VALIDATION, "MESSAGE");
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"addErrors\" de la clase \"ROLResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos addError y removeError de la clase ROLResult. 
	 */
	@Test
	public void testAddAndRemoveErrorMethod() {
		ROLResult result = new ROLResult();
		
		Set<ROLError> errors = new HashSet<ROLError>();
		
		ROLError error = new ROLError();
		
		error.setErrorType(ROLErrorType.VALIDATION);
		error.setMessage("MESSAGE");
		
		result.addError(error);
		
		errors = result.getErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"addErrors\" de la clase \"ROLResult\".",
				errors.isEmpty());
		
		result.removeError(error);
		
		errors = result.getErrors();
		
		Assert.assertTrue("Ha fallado la llamada al m�todo \"removeErrors\" de la clase \"ROLResult\".",
				errors.isEmpty());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos addErrors y removeErrors de la clase ROLResult. 
	 */
	@Test
	public void testAddAndRemoveErrorsMethod() {
		ROLResult result = new ROLResult();
		
		Set<ROLError> errors = new HashSet<ROLError>();
		
		ROLError error = new ROLError();
		
		error.setErrorType(ROLErrorType.VALIDATION);
		error.setMessage("MESSAGE");
		errors.add(error);
		
		result.addErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"addErrors\" de la clase \"ROLResult\".",
				errors.isEmpty());
		
		result.removeErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertTrue("Ha fallado la llamada al m�todo \"removeErrors\" de la clase \"ROLResult\".",
				errors.isEmpty());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo hasErrors de la clase ROLResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		ROLResult result = new ROLResult();
		
		result.setErrors(null);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"ROLResult\".",
				hasErrors);
		
		Set<ROLError> errors = new HashSet<ROLError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"ROLResult\".",
				hasErrors);
		
		ROLError error = new ROLError();
		
		error.setErrorType(ROLErrorType.VALIDATION);
		error.setMessage("MESSAGE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al m�todo \"hasErrors\" de la clase \"ROLResult\".",
				hasErrors);
	}
}
