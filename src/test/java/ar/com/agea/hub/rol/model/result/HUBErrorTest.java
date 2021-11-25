/*
 * @(#)HUBErrorTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase HUBError.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class HUBErrorTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo HUBError.
	 */
	@Test
	public void testConstructor() {
		HUBError error = new HUBError();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"HUBError\""
				+ " utilizando el constructor por defecto.", error);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setErrorType y getErrorType de la clase HUBError. 
	 */
	@Test
	public void testSetAndGetErrorTypeMethod() {
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		
		HUBErrorType errorType = error.getErrorType();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setErrorType\" o \"getErrorType\" de la clase \"HUBError\".",
				errorType);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setMessage y getMessage de la clase HUBError. 
	 */
	@Test
	public void testSetAndGetMessageMethod() {
		HUBError error = new HUBError();
		
		error.setMessage("MESSAGE");
		
		String message = error.getMessage();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setMessage\" o \"getMessage\" de la clase \"HUBError\".",
				message);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo hashCode de la clase HUBError. 
	 */
	@Test
	public void testHashCodeMethod() {
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		errors.add(error);

		error = new HUBError();
		error.setErrorType(HUBErrorType.EMPTY_VALUE);
		error.setMessage("MESSAGE");
		errors.add(error);
		
		Iterator<HUBError> iterator = errors.iterator();
		
		HUBError first = iterator.next();
		HUBError second = iterator.next();
		
		boolean isEqual = first.equals(second);
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"equals\" de la clase \"HUBError\".",
				isEqual);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo equals de la clase HUBError. 
	 */
	@Test
	public void testEqualsMethod() {
		HUBError error = new HUBError();

		boolean isEqual = error.equals(error);
		
		Assert.assertTrue("Ha fallado la llamada al m�todo \"equals\" de la clase \"HUBError\".",
				isEqual);
		
		isEqual = error.equals(null);
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"equals\" de la clase \"HUBError\".",
				isEqual);
		
		isEqual = error.equals("Un objeto diferente.");
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"equals\" de la clase \"HUBError\".",
				isEqual);
		
		HUBError otherError = new HUBError();
		
		otherError.setErrorType(HUBErrorType.NULLED_VALUE);
		
		isEqual = error.equals(otherError);
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"equals\" de la clase \"HUBError\".",
				isEqual);
		
		otherError.setErrorType(null);
		otherError.setMessage("OTHER MESSAGE");
		
		isEqual = error.equals(otherError);
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"equals\" de la clase \"HUBError\".",
				isEqual);
		
		error.setMessage("MESSAGE");
		
		isEqual = error.equals(otherError);
		
		Assert.assertFalse("Ha fallado la llamada al m�todo \"equals\" de la clase \"HUBError\".",
				isEqual);
		
		otherError.setMessage("MESSAGE");
		
		isEqual = error.equals(otherError);
		
		Assert.assertTrue("Ha fallado la llamada al m�todo \"equals\" de la clase \"HUBError\".",
				isEqual);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase HUBError. 
	 */
	@Test
	public void testToStringMethod() {
		HUBError error = new HUBError();
		
		error.setMessage("MESSAGE");
		
		String message = error.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"HUBError\".",
				message);
	}
}
