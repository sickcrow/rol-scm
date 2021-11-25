/*
 * @(#)HUBErrorTypeTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para el enum HUBErrorType.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class HUBErrorTypeTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo HUBErrorType.
	 */
	@Test
	public void testNulledValueConstructor() {
		HUBErrorType errorType = HUBErrorType.NULLED_VALUE; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"HUBErrorType\".",
				errorType);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo HUBErrorType.
	 */
	@Test
	public void testEmptyValueConstructor() {
		HUBErrorType errorType = HUBErrorType.EMPTY_VALUE; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"HUBErrorType\".",
				errorType);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo HUBErrorType.
	 */
	@Test
	public void testNulledEmptyValueConstructor() {
		HUBErrorType errorType = HUBErrorType.NULLED_EMPTY_VALUE; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"HUBErrorType\".",
				errorType);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo HUBErrorType.
	 */
	@Test
	public void testExistValueConstructor() {
		HUBErrorType errorType = HUBErrorType.EXIST_VALUE; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"HUBErrorType\".",
				errorType);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo HUBErrorType.
	 */
	@Test
	public void testNotExistValueConstructor() {
		HUBErrorType errorType = HUBErrorType.NOT_EXIST_VALUE; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"HUBErrorType\".",
				errorType);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo HUBErrorType.
	 */
	@Test
	public void testNotAppliedValueConstructor() {
		HUBErrorType errorType = HUBErrorType.NOT_APPLIED_VALUE; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"HUBErrorType\".",
				errorType);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo HUBErrorType.
	 */
	@Test
	public void testNotEqualValueConstructor() {
		HUBErrorType errorType = HUBErrorType.NOT_EQUAL_VALUE; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"HUBErrorType\".",
				errorType);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo HUBErrorType.
	 */
	@Test
	public void testDuplicatedValueConstructor() {
		HUBErrorType errorType = HUBErrorType.DUPLICATED_VALUE; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"HUBErrorType\".",
				errorType);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo HUBErrorType.
	 */
	@Test
	public void testExceptionOccurredConstructor() {
		HUBErrorType errorType = HUBErrorType.EXCEPTION_OCCURRED; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"HUBErrorType\".",
				errorType);
	}
}
