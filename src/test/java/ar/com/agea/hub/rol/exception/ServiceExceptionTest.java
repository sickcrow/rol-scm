/*
 * @(#)ServiceExceptionTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.exception;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de instanciaci�n para la clase ServiceException.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ServiceExceptionTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ServiceException. 
	 */
	@Test
	public void testFirstConstructor() {
		ServiceException exception = new ServiceException();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ServiceException\""
				+ " utilizando el constructor por defecto.", exception);
	}
	
	/**
	 * Comprueba la creaci�n de objeto de tipo ServiceException que posee un par�metro de tipo String
	 * y otro par�metro de tipo Throwable. 
	 */
	@Test
	public void testSecondConstructor() {
		ServiceException exception = new ServiceException("Prueba de instanciaci�n \"ServiceException\""
				+ " utilizando el constructor con los siguientes par�metros: \"String\", \"Throwable\"", new ClassCastException());
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ServiceException\"", exception);
	}
	
	/**
	 * Comprueba la creaci�n de objeto de tipo ServiceException que posee un par�metro de tipo String. 
	 */
	@Test
	public void testThirdConstructor() {
		ServiceException exception = new ServiceException("Prueba de instanciaci�n ServiceException.");
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ServiceException\""
				+ " utilizando el constructor con los siguientes par�metros: \"String\"",  exception);
	}
	
	/**
	 * Comprueba la creaci�n de objeto de tipo ServiceException que posee un par�metro de tipo Throwable. 
	 */
	@Test
	public void testFourthConstructor() {
		ServiceException exception = new ServiceException(new ClassCastException());
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ServiceException\""
				+ " utilizando el constructor con los siguientes par�metros: \"Throwable\"", exception);
	}
}
