/*
 * @(#)CustomXMLUnmarshallerTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.utils;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase CustomXMLUnmarshaller.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class CustomXMLUnmarshallerTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo CustomXMLUnmarshaller.
	 */
	@Test
	public void testConstructor() {
		CustomXMLUnmarshaller customXMLUnmarshaller = new CustomXMLUnmarshaller();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"CustomXMLUnmarshaller\".",
				customXMLUnmarshaller);
	}
}
