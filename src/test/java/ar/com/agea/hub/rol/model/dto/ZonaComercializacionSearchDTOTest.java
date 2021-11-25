/*
 * @(#)ZonaComercializacionSearchDTOTest.java		1.0 02/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ZonaComercializacionSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 02/09/2013
 */
public class ZonaComercializacionSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ZonaComercializacionSearchDTO.
	 */
	@Test
	public void testConstructor() {
		ZonaComercializacionSearchDTO dto = new ZonaComercializacionSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ZonaComercializacionSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoProducto y getCodigoProducto de la clase ZonaComercializacionSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProductoMethod() {
		ZonaComercializacionSearchDTO dto = new ZonaComercializacionSearchDTO();
		String codigoProducto = "CODIGO_PRODUCTO";
		
		dto.setCodigoProducto(codigoProducto);
		
		String tmp = dto.getCodigoProducto();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoProducto\" o \"getCodigoProducto\" de la clase \"ZonaComercializacionSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoProducto\" de la clase \"ZonaComercializacionSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProducto, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFechaVigencia y getFechaVigencia de la clase ZonaComercializacionSearchDTO. 
	 */
	@Test
	public void testSetAndGetFechaVigenciaMethod() {
		ZonaComercializacionSearchDTO dto = new ZonaComercializacionSearchDTO();
		Date fechaVigencia = null;
		
		dto.setFechaVigencia(fechaVigencia);
		
		Date tmp = dto.getFechaVigencia();
		
		Assert.assertNull("Ha fallado la llamada al método \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"ZonaComercializacionSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaVigencia\" de la clase \"ZonaComercializacionSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
		
		fechaVigencia = new Date();
		
		dto.setFechaVigencia(fechaVigencia);
		
		tmp = dto.getFechaVigencia();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFechaVigencia\" o \"getFechaVigencia\" de la clase \"ZonaComercializacionSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaVigencia\" de la clase \"ZonaComercializacionSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaVigencia, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ZonaComercializacionSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ZonaComercializacionSearchDTO dto = new ZonaComercializacionSearchDTO();
		
		dto.setCodigoProducto("CODIGO_PRODUCTO");
		dto.setFechaVigencia(new Date());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ZonaComercializacionSearchDTO\".", tmp);
	}
}
