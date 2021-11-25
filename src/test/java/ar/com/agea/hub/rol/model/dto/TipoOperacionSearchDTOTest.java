/*
 * @(#)TipoOperacionSearchDTOTest.java		1.0 26/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase TipoOperacionSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/08/2013
 */
public class TipoOperacionSearchDTOTest extends InstantiationTest {
	
	/**
	 * Comprueba la creación de objeto de tipo TipoOperacionSearchDTO.
	 */
	@Test
	public void testConstructor() {
		TipoOperacionSearchDTO dto = new TipoOperacionSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"TipoOperacionSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase TipoOperacionSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		TipoOperacionSearchDTO dto = new TipoOperacionSearchDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"TipoOperacionSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoCanalEntrada\" de la clase \"TipoOperacionSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoClase y getCodigoClase de la clase TipoOperacionSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoClaseMethod() {
		TipoOperacionSearchDTO dto = new TipoOperacionSearchDTO();
		String codigoClase = "CODIGO_CLASE";
		
		dto.setCodigoClase(codigoClase);
		
		String tmp = dto.getCodigoClase();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoClase\" o \"getCodigoClase\" de la clase \"TipoOperacionSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoClase\" de la clase \"TipoOperacionSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoClase, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFechaVigencia y getFechaVigencia de la clase TipoOperacionSearchDTO. 
	 */
	@Test
	public void testSetAndGetFechaVigenciaMethod() {
		TipoOperacionSearchDTO dto = new TipoOperacionSearchDTO();
		Date fechaVigencia = null;
		
		dto.setFechaVigencia(fechaVigencia);
		
		Date tmp = dto.getFechaVigencia();
		
		Assert.assertNull("Ha fallado la llamada al método \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"TipoOperacionSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaVigencia\" de la clase \"TipoOperacionSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
		
		fechaVigencia = new Date();
		
		dto.setFechaVigencia(fechaVigencia);
		
		tmp = dto.getFechaVigencia();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"TipoOperacionSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaVigencia\" de la clase \"TipoOperacionSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase TipoOperacionSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		TipoOperacionSearchDTO dto = new TipoOperacionSearchDTO();
		
		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		dto.setCodigoClase("CODIGO_CLASE");
		dto.setFechaVigencia(new Date());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"TipoOperacionSearchDTO\".", tmp);
	}
}
