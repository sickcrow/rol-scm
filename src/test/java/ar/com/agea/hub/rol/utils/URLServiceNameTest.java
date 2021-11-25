/*
 * @(#)URLServiceNameTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.utils;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para el enum URLServiceName.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class URLServiceNameTest extends InstantiationTest {

	// Servicios de HUB.
	// Servicios de Aviso.
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBExecuteNotificarPagoConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_EXECUTE_NOTIFICAR_PAGO; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetConfiguracionesOrdenamientoPantallaConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_CONFIGURACIONES_ORDENAMIENTO_PANTALLA; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetItemsOrdenamientoAvisoConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_ITEMS_ORDENAMIENTO_AVISO; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetItemsOrdenamientoAvisoGroupConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_ITEMS_ORDENAMIENTO_AVISO_GROUP; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetOrdenesPublicacionByCapturadorConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_ORDENES_PUBLICACION_BY_CAPTURADOR; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBUpdateOrdenPublicacionConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_UPDATE_ORDEN_PUBLICACION; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBSaveOrdenPublicacionConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_SAVE_ORDEN_PUBLICACION; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	// Servicios de Common.

	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetCaracteresInvalidosJustificacionConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_CARACTERES_INVALIDOS_JUSTIFICACION; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetPropiedadesDefaultConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_PROPIEDADES_DEFAULT; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	// Servicios de Interfaz Dinámica.
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetBienesConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_BIENES; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetFamiliasConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_FAMILIAS; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	// Servicios de Pretasador.
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBExecuteTasarConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_EXECUTE_TASAR; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	// Servicios de Producto.
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBExecuteJustificarConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_EXECUTE_JUSTIFICAR; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetCalendarioConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_CALENDARIO; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetNivelesEstructuraConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_NIVELES_ESTRUCTURA; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetProductoComercialConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_PRODUCTO_COMERCIAL; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetProductoComercialDefaultConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_PRODUCTO_COMERCIAL_DEFAULT; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetProductosConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_PRODUCTOS; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetTiposOperacionConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_TIPOS_OPERACION; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetZonasComercializacionConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_ZONAS_COMERCIALIZACION; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBValidatePalabrasProhibidasConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_VALIDATE_PALABRAS_PROHIBIDAS; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	// Servicios de Usuario Cliente.
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetCapturadorConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_CAPTURADOR; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBGetTarjetasPagoConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_GET_TARJETAS_PAGO; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBSaveCapturadorConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_SAVE_CAPTURADOR; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testHUBUpdateCapturadorConstructor() {
		URLServiceName urlServiceName = URLServiceName.HUB_UPDATE_CAPTURADOR; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
	

	// Servicios de GWP.
	
	/**
	 * Comprueba la creación de objeto de tipo URLServiceName.
	 */
	@Test
	public void testGWPRealizarConstructor() {
		URLServiceName urlServiceName = URLServiceName.GWP_REALIZAR; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceName\".",
				urlServiceName);
	}
}
