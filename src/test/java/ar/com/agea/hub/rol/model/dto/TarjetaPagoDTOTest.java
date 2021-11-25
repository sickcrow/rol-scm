/*
 * @(#)TarjetaPagoDTOTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase TarjetaPagoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class TarjetaPagoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo TarjetaPagoDTO.
	 */
	@Test
	public void testConstructor() {
		TarjetaPagoDTO dto = new TarjetaPagoDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"TarjetaPagoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoGATEWAY y getCodigoGATEWAY de la clase TarjetaPagoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoGATEWAYMethod() {
		TarjetaPagoDTO dto = new TarjetaPagoDTO();
		String codigoGATEWAY = "CODIGO_GATEWAY";
		
		dto.setCodigoGATEWAY(codigoGATEWAY);
		
		String tmp = dto.getCodigoGATEWAY();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoGATEWAY\" o \"getCodigoGATEWAY\" de la clase \"TarjetaPagoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoGATEWAY\" de la clase \"TarjetaPagoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoGATEWAY, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setDescripcion y getDescripcion de la clase TarjetaPagoDTO. 
	 */
	@Test
	public void testSetAndGetDescripcionMethod() {
		TarjetaPagoDTO dto = new TarjetaPagoDTO();
		String descripcion = "DESCRIPCION";
		
		dto.setDescripcion(descripcion);
		
		String tmp = dto.getDescripcion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setDescripcion\" o \"getDescripcion\" de la clase \"TarjetaPagoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getDescripcion\" de la clase \"TarjetaPagoDTO\""
				+ " no corresponde al valor enviado como argumento.", descripcion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setRutaImagenTC y getRutaImagenTC de la clase TarjetaPagoDTO. 
	 */
	@Test
	public void testSetAndGetRutaImagenTCMethod() {
		TarjetaPagoDTO dto = new TarjetaPagoDTO();
		String rutaImagenTC = "RUTA_IMAGEN_TC";
		
		dto.setRutaImagenTC(rutaImagenTC);
		
		String tmp = dto.getRutaImagenTC();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setRutaImagenTC\" o \"getRutaImagenTC\" de la clase \"TarjetaPagoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getRutaImagenTC\" de la clase \"TarjetaPagoDTO\""
				+ " no corresponde al valor enviado como argumento.", rutaImagenTC, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase TarjetaPagoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		TarjetaPagoDTO dto = new TarjetaPagoDTO();

		dto.setCodigoGATEWAY("CODIGO_GATEWAY");
		dto.setDescripcion("DESCRIPCION");
		dto.setRutaImagenTC("RUTA_IMAGEN_TC");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"TarjetaPagoDTO\".", tmp);
	}
}
