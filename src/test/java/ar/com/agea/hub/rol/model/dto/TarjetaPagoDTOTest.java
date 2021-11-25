/*
 * @(#)TarjetaPagoDTOTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase TarjetaPagoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class TarjetaPagoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo TarjetaPagoDTO.
	 */
	@Test
	public void testConstructor() {
		TarjetaPagoDTO dto = new TarjetaPagoDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"TarjetaPagoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigoGATEWAY y getCodigoGATEWAY de la clase TarjetaPagoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoGATEWAYMethod() {
		TarjetaPagoDTO dto = new TarjetaPagoDTO();
		String codigoGATEWAY = "CODIGO_GATEWAY";
		
		dto.setCodigoGATEWAY(codigoGATEWAY);
		
		String tmp = dto.getCodigoGATEWAY();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoGATEWAY\" o \"getCodigoGATEWAY\" de la clase \"TarjetaPagoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoGATEWAY\" de la clase \"TarjetaPagoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoGATEWAY, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setDescripcion y getDescripcion de la clase TarjetaPagoDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		TarjetaPagoDTO dto = new TarjetaPagoDTO();
		String descripcion = "DESCRIPCION";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setDescripcion\" o \"getDescripcion\" de la clase \"TarjetaPagoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getDescripcion\" de la clase \"TarjetaPagoDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setRutaImagenTC y getRutaImagenTC de la clase TarjetaPagoDTO. 
	 */
	@Test
	public void testSetAndGetRutaImagenTCMethod() {
		TarjetaPagoDTO dto = new TarjetaPagoDTO();
		String rutaImagenTC = "RUTA_IMAGEN_TC";
		
		dto.setRutaImagenTC(rutaImagenTC);
		
		String tmp = dto.getRutaImagenTC();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setRutaImagenTC\" o \"getRutaImagenTC\" de la clase \"TarjetaPagoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getRutaImagenTC\" de la clase \"TarjetaPagoDTO\""
				+ " no corresponde al valor enviado como argumento.", rutaImagenTC, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase TarjetaPagoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		TarjetaPagoDTO dto = new TarjetaPagoDTO();

		dto.setCodigoGATEWAY("CODIGO_GATEWAY");
		dto.setDescripcion("DESCRIPCION");
		dto.setRutaImagenTC("RUTA_IMAGEN_TC");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"TarjetaPagoDTO\".", tmp);
	}
}
