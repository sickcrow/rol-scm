/*
 * @(#)InitializationExceptionTests.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.exception;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de instanciaci�n para la clase InitializationException.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class InitializationExceptionTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo InitializationException. 
	 */
	@Test
	public void testFirstConstructor() {
		InitializationException exception = new InitializationException();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"InitializationException\""
				+ " utilizando el constructor por defecto.", exception);
	}
	
	/**
	 * Comprueba la creaci�n de objeto de tipo InitializationException que posee un par�metro de tipo String
	 * y otro par�metro de tipo Throwable. 
	 */
	@Test
	public void testSecondConstructor() {
		InitializationException exception = new InitializationException("Prueba de instanciaci�n \"InitializationException\""
				+ " utilizando el constructor con los siguientes par�metros: \"String\", \"Throwable\"", new ClassCastException());
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"InitializationException\"", exception);
	}
	
	/**
	 * Comprueba la creaci�n de objeto de tipo InitializationException que posee un par�metro de tipo String. 
	 */
	@Test
	public void testThirdConstructor() {
		InitializationException exception = new InitializationException("Prueba de instanciaci�n InitializationException.");
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"InitializationException\""
				+ " utilizando el constructor con los siguientes par�metros: \"String\"",  exception);
	}
	
	/**
	 * Comprueba la creaci�n de objeto de tipo InitializationException que posee un par�metro de tipo Throwable. 
	 */
	@Test
	public void testFourthConstructor() {
		InitializationException exception = new InitializationException(new ClassCastException());
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"InitializationException\""
				+ " utilizando el constructor con los siguientes par�metros: \"Throwable\"", exception);
	}
}
