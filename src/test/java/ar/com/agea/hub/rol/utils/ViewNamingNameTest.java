/*
 * @(#)ViewNamingNameTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.utils;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para el enum ViewNamingName.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ViewNamingNameTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ViewNamingName.
	 */
	@Test
	public void testCrearAvisoConstructor() {
		ViewNamingName viewNamingName = ViewNamingName.CREAR_AVISO; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ViewNamingName\".",
				viewNamingName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ViewNamingName.
	 */
	@Test
	public void testMisAvisosConstructor() {
		ViewNamingName viewNamingName = ViewNamingName.MIS_AVISOS; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ViewNamingName\".",
				viewNamingName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ViewNamingName.
	 */
	@Test
	public void testInternalErrorConstructor() {
		ViewNamingName viewNamingName = ViewNamingName.INTERNAL_ERROR; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ViewNamingName\".",
				viewNamingName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ViewNamingName.
	 */
	@Test
	public void testExternalErrorConstructor() {
		ViewNamingName viewNamingName = ViewNamingName.EXTERNAL_ERROR; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ViewNamingName\".",
				viewNamingName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ViewNamingName.
	 */
	@Test
	public void testLoginConstructor() {
		ViewNamingName viewNamingName = ViewNamingName.LOGIN; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ViewNamingName\".",
				viewNamingName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ViewNamingName.
	 */
	@Test
	public void testLogoutConstructor() {
		ViewNamingName viewNamingName = ViewNamingName.LOGOUT; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ViewNamingName\".",
				viewNamingName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ViewNamingName.
	 */
	@Test
	public void testVersionConstructor() {
		ViewNamingName viewNamingName = ViewNamingName.VERSION; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ViewNamingName\".",
				viewNamingName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ViewNamingName.
	 */
	@Test
	public void testRegistrarmeConstructor() {
		ViewNamingName viewNamingName = ViewNamingName.REGISTRARME; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ViewNamingName\".",
				viewNamingName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ViewNamingName.
	 */
	@Test
	public void testDatosPersonalesConstructor() {
		ViewNamingName viewNamingName = ViewNamingName.DATOS_PERSONALES; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ViewNamingName\".",
				viewNamingName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ViewNamingName.
	 */
	@Test
	public void testPaginaNoEncontradaConstructor() {
		ViewNamingName viewNamingName = ViewNamingName.PAGINA_NO_ENCONTRADA; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ViewNamingName\".",
				viewNamingName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ViewNamingName.
	 */
	@Test
	public void testTerminosConstructor() {
		ViewNamingName viewNamingName = ViewNamingName.TERMINOS; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ViewNamingName\".",
				viewNamingName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo ViewNamingName.
	 */
	@Test
	public void testActualizaNavegadorConstructor() {
		ViewNamingName viewNamingName = ViewNamingName.ACTUALIZA_NAVEGADOR; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ViewNamingName\".",
				viewNamingName);
	}
	
	/**
	 * Comprueba la ejecución de método getName del enum ViewNamingName. 
	 */
	@Test
	public void testGetNameMethod() {
		ViewNamingName viewNamingName = ViewNamingName.CREAR_AVISO;
		
		String tmp = viewNamingName.getName();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"getName\" del \"ViewNamingName\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getName\" de la clase \"ViewNamingName\""
				+ " no corresponde al valor esperado.", "crearAviso", tmp);
	}
}
