/*
 * @(#)SessionNamingNameTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.utils;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para el enum SessionNamingName.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class SessionNamingNameTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo SessionNamingName.
	 */
	@Test
	public void testModelConstructor() {
		SessionNamingName sessionNamingName = SessionNamingName.MODEL; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"SessionNamingName\".",
				sessionNamingName);
	}

	
	/**
	 * Comprueba la creación de objeto de tipo SessionNamingName.
	 */
	@Test
	public void testCantidadIntentosPromocion365Constructor() {
		SessionNamingName sessionNamingName = SessionNamingName.CANTIDAD_INTENTOS_PROMOCION_365; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"SessionNamingName\".",
				sessionNamingName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo SessionNamingName.
	 */
	@Test
	public void testCotizacionConstructor() {
		SessionNamingName sessionNamingName = SessionNamingName.COTIZACION; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"SessionNamingName\".",
				sessionNamingName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo SessionNamingName.
	 */
	@Test
	public void testTrackCampanaConstructor() {
		SessionNamingName sessionNamingName = SessionNamingName.TRACK_CAMPANA; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"SessionNamingName\".",
				sessionNamingName);
	}
	
	/**
	 * Comprueba la ejecución de método getName del enum SessionNamingName. 
	 */
	@Test
	public void testGetNameMethod() {
		
		SessionNamingName sessionNamingName = SessionNamingName.MODEL;
		String tmp = sessionNamingName.getName();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"getName\" del \"SessionNamingName\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getName\" de la clase \"SessionNamingName\""
				+ " no corresponde al valor esperado.", "MODEL", tmp);
	}
}
