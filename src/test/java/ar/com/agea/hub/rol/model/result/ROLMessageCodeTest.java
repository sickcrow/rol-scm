/*
 * @(#)ROLMessageCodeTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.result;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para el enum ROLMessageCode.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class ROLMessageCodeTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ROLMessageCode.
	 */
	@Test
	public void testCode000000ValueConstructor() {
		ROLMessageCode messageCode = ROLMessageCode.CODE_000000; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ROLMessageCode\".",
				messageCode);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ROLMessageCode.
	 */
	@Test
	public void testCode000001ValueConstructor() {
		ROLMessageCode messageCode = ROLMessageCode.CODE_000001; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ROLMessageCode\".",
				messageCode);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ROLMessageCode.
	 */
	@Test
	public void testCode000010ValueConstructor() {
		ROLMessageCode messageCode = ROLMessageCode.CODE_000010; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ROLMessageCode\".",
				messageCode);
	}
}
