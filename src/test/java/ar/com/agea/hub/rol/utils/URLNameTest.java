/*
 * @(#)URLNameTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.utils;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para el enum URLName.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class URLNameTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo URLName.
	 */
	@Test
	public void testGWPConstructor() {
		URLName urlName = URLName.GWP; 
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"URLName\".",
				urlName);
	}
	
	/**
	 * Comprueba la creaci�n de objeto de tipo URLName.
	 */
	@Test
	public void testHUBConstructor() {
		URLName urlName = URLName.HUB; 
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"URLName\".",
				urlName);
	}
	

}
