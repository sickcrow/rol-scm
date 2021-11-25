/*
 * @(#)CustomXMLUnmarshallerTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.utils;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase CustomXMLUnmarshaller.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class CustomXMLUnmarshallerTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo CustomXMLUnmarshaller.
	 */
	@Test
	public void testConstructor() {
		CustomXMLUnmarshaller customXMLUnmarshaller = new CustomXMLUnmarshaller();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"CustomXMLUnmarshaller\".",
				customXMLUnmarshaller);
	}
}
