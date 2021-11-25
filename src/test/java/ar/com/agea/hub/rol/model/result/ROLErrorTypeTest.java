/*
 * @(#)ROLErrorTypeTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para el enum ROLErrorType.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ROLErrorTypeTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ROLErrorType.
	 */
	@Test
	public void testNulledValueConstructor() {
		ROLErrorType errorType = ROLErrorType.VALIDATION; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ROLErrorType\".",
				errorType);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ROLErrorType.
	 */
	@Test
	public void testEmptyValueConstructor() {
		ROLErrorType errorType = ROLErrorType.REDIRECTION; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ROLErrorType\".",
				errorType);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ROLErrorType.
	 */
	@Test
	public void testNulledEmptyValueConstructor() {
		ROLErrorType errorType = ROLErrorType.EXCEPTION; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ROLErrorType\".",
				errorType);
	}
}
