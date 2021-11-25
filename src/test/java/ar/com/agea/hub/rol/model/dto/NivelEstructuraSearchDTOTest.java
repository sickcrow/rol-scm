/*
 * @(#)NivelEstructuraSearchDTOTest.java		1.0 26/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase NivelEstructuraSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/08/2013
 */
public class NivelEstructuraSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo NivelEstructuraSearchDTO.
	 */
	@Test
	public void testConstructor() {
		NivelEstructuraSearchDTO dto = new NivelEstructuraSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"NivelEstructuraSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase NivelEstructuraSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		NivelEstructuraSearchDTO dto = new NivelEstructuraSearchDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"NivelEstructuraSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoCanalEntrada\" de la clase \"NivelEstructuraSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoClase y getCodigoClase de la clase NivelEstructuraSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoClaseMethod() {
		NivelEstructuraSearchDTO dto = new NivelEstructuraSearchDTO();
		String codigoClase = "CODIGO_CLASE";
		
		dto.setCodigoClase(codigoClase);
		
		String tmp = dto.getCodigoClase();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoClase\" o \"getCodigoClase\" de la clase \"NivelEstructuraSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoClase\" de la clase \"NivelEstructuraSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoClase, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoProducto y getCodigoProducto de la clase NivelEstructuraSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProductoMethod() {
		NivelEstructuraSearchDTO dto = new NivelEstructuraSearchDTO();
		String codigoProducto = "CODIGO_PRODUCTO";
		
		dto.setCodigoProducto(codigoProducto);
		
		String tmp = dto.getCodigoProducto();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoProducto\" o \"getCodigoProducto\" de la clase \"NivelEstructuraSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoProducto\" de la clase \"NivelEstructuraSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProducto, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoTipoOperacion y getCodigoTipoOperacion de la clase NivelEstructuraSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoOperacionMethod() {
		NivelEstructuraSearchDTO dto = new NivelEstructuraSearchDTO();
		String codigoTipoOperacion = "CODIGO_TIPO_OPERACION";
		
		dto.setCodigoTipoOperacion(codigoTipoOperacion);
		
		String tmp = dto.getCodigoTipoOperacion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoTipoOperacion\" o \"getCodigoTipoOperacion\" de la clase \"NivelEstructuraSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoTipoOperacion\" de la clase \"NivelEstructuraSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoOperacion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFechaVigencia y getFechaVigencia de la clase NivelEstructuraSearchDTO. 
	 */
	@Test
	public void testSetAndGetFechaVigenciaMethod() {
		NivelEstructuraSearchDTO dto = new NivelEstructuraSearchDTO();
		Date fechaVigencia = null;
		
		dto.setFechaVigencia(fechaVigencia);
		
		Date tmp = dto.getFechaVigencia();
		
		Assert.assertNull("Ha fallado la llamada al método \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"NivelEstructuraSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaVigencia\" de la clase \"NivelEstructuraSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
		
		fechaVigencia = new Date();
		
		dto.setFechaVigencia(fechaVigencia);
		
		tmp = dto.getFechaVigencia();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"NivelEstructuraSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaVigencia\" de la clase \"NivelEstructuraSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase NivelEstructuraSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		NivelEstructuraSearchDTO dto = new NivelEstructuraSearchDTO();
		
		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		dto.setCodigoClase("CODIGO_CLASE");
		dto.setCodigoProducto("CODIGO_PRODUCTO");
		dto.setCodigoTipoOperacion("CODIGO_TIPO_OPERACION");
		dto.setFechaVigencia(new Date());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"NivelEstructuraSearchDTO\".", tmp);
	}
}
