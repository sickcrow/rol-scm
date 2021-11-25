/*
 * @(#)ProductoSearchDTOTest.java		1.0 30/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ProductoSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 30/08/2013
 */
public class ProductoSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ProductoSearchDTO.
	 */
	@Test
	public void testConstructor() {
		ProductoSearchDTO dto = new ProductoSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ProductoSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase ProductoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		ProductoSearchDTO dto = new ProductoSearchDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"ProductoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoCanalEntrada\" de la clase \"ProductoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoClase y getCodigoClase de la clase ProductoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoClaseMethod() {
		ProductoSearchDTO dto = new ProductoSearchDTO();
		String codigoClase = "CLASE";
		
		dto.setCodigoClase(codigoClase);
		
		String tmp = dto.getCodigoClase();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoClase\" o \"getCodigoClase\" de la clase \"ProductoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoClase\" de la clase \"ProductoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoClase, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoTipoOperacion y getCodigoTipoOperacion de la clase NivelEstructuraSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoOperacionMethod() {
		ProductoSearchDTO dto = new ProductoSearchDTO();
		String codigoTipoOperacion = "CODIGO_TIPO_OPERACION";
		
		dto.setCodigoTipoOperacion(codigoTipoOperacion);
		
		String tmp = dto.getCodigoTipoOperacion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoTipoOperacion\" o \"getCodigoTipoOperacion\" de la clase \"ProductoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoTipoOperacion\" de la clase \"ProductoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoOperacion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFechaVigencia y getFechaVigencia de la clase NivelEstructuraSearchDTO. 
	 */
	@Test
	public void testSetAndGetFechaVigenciaMethod() {
		ProductoSearchDTO dto = new ProductoSearchDTO();
		Date fechaVigencia = null;
		
		dto.setFechaVigencia(fechaVigencia);
		
		Date tmp = dto.getFechaVigencia();
		
		Assert.assertNull("Ha fallado la llamada al método \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"ProductoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaVigencia\" de la clase \"ProductoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
		
		fechaVigencia = new Date();
		
		dto.setFechaVigencia(fechaVigencia);
		
		tmp = dto.getFechaVigencia();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"ProductoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaVigencia\" de la clase \"ProductoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ProductoSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ProductoSearchDTO dto = new ProductoSearchDTO();

		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		dto.setCodigoClase("CODIGO_CLASE");
		dto.setCodigoTipoOperacion("CODIGO_TIPO_OPERACION");
		dto.setFechaVigencia(new Date());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ProductoSearchDTO\".", tmp);
	}
}
