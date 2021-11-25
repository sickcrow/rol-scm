/*
 * @(#)ServiceExceptionTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.exception;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de instanciación para la clase ServiceException.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ServiceExceptionTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ServiceException. 
	 */
	@Test
	public void testFirstConstructor() {
		ServiceException exception = new ServiceException();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ServiceException\""
				+ " utilizando el constructor por defecto.", exception);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ServiceException que posee un parámetro de tipo String
	 * y otro parámetro de tipo Throwable. 
	 */
	@Test
	public void testSecondConstructor() {
		ServiceException exception = new ServiceException("Prueba de instanciación \"ServiceException\""
				+ " utilizando el constructor con los siguientes parámetros: \"String\", \"Throwable\"", new ClassCastException());
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ServiceException\"", exception);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ServiceException que posee un parámetro de tipo String. 
	 */
	@Test
	public void testThirdConstructor() {
		ServiceException exception = new ServiceException("Prueba de instanciación ServiceException.");
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ServiceException\""
				+ " utilizando el constructor con los siguientes parámetros: \"String\"",  exception);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ServiceException que posee un parámetro de tipo Throwable. 
	 */
	@Test
	public void testFourthConstructor() {
		ServiceException exception = new ServiceException(new ClassCastException());
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ServiceException\""
				+ " utilizando el constructor con los siguientes parámetros: \"Throwable\"", exception);
	}
}
