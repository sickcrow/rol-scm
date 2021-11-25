/*
 * @(#)ClaseSearchDTOTest.java		1.0 26/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ClaseSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/08/2013
 */
public class ClaseSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ClaseSearchDTO.
	 */
	@Test
	public void testConstructor() {
		ClaseSearchDTO dto = new ClaseSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ClaseSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase ClaseSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		ClaseSearchDTO dto = new ClaseSearchDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"ClaseSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoCanalEntrada\" de la clase \"ClaseSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoClase y getCodigoClase de la clase ClaseSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoClaseMethod() {
		ClaseSearchDTO dto = new ClaseSearchDTO();
		String codigoClase = "CODIGO_CLASE";
		
		dto.setCodigoClase(codigoClase);
		
		String tmp = dto.getCodigoClase();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoClase\" o \"getCodigoClase\" de la clase \"ClaseSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoClase\" de la clase \"ClaseSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoClase, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFechaVigencia y getFechaVigencia de la clase ClaseSearchDTO. 
	 */
	@Test
	public void testSetAndGetFechaVigenciaMethod() {
		ClaseSearchDTO dto = new ClaseSearchDTO();
		Date fechaVigencia = null;
		
		dto.setFechaVigencia(fechaVigencia);
		
		Date tmp = dto.getFechaVigencia();
		
		Assert.assertNull("Ha fallado la llamada al método \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"ClaseSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaVigencia\" de la clase \"ClaseSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
		
		fechaVigencia = new Date();
		
		dto.setFechaVigencia(fechaVigencia);
		
		tmp = dto.getFechaVigencia();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"ClaseSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaVigencia\" de la clase \"ClaseSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ClaseSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ClaseSearchDTO dto = new ClaseSearchDTO();

		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		dto.setCodigoClase("CODIGO_CLASE");
		dto.setFechaVigencia(new Date());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ClaseSearchDTO\".", tmp);
	}
}
