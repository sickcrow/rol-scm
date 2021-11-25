/*
 * @(#)ValidateVigenciaDTOTest.java		1.0 31/07/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ValidateVigenciaDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 31/07/2014
 */
public class ValidateVigenciaDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ValidateVigenciaDTO.
	 */
	@Test
	public void testConstructor() {
		ValidateVigenciaDTO dto = new ValidateVigenciaDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ValidateVigenciaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigoProductoComercial y getCodigoProductoComercial de la clase ValidateVigenciaDTO. 
	 */
	@Test
	public void testSetAndGeCodigoProductoComercialMethod() {
		ValidateVigenciaDTO dto = new ValidateVigenciaDTO();
		String codigoProductoComercial = "CODIGO_PRODUCTO_COMERCIAL";
		
		dto.setCodigoProductoComercial(codigoProductoComercial);
		
		String tmp = dto.getCodigoProductoComercial();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoProductoComercial\" o \"getCodigoProductoComercial\" de la clase \"ValidateVigenciaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoProductoComercial\" de la clase \"ValidateVigenciaDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProductoComercial, tmp);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigoNivelEstructura y getCodigoNivelEstructura de la clase ValidateVigenciaDTO. 
	 */
	@Test
	public void testSetAndGeCodigoNivelEstructuraMethod() {
		ValidateVigenciaDTO dto = new ValidateVigenciaDTO();
		String codigoNivelEstructura = "CODIGO_NIVEL_ESTRUCTURA";
		
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		
		String tmp = dto.getCodigoNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoNivelEstructura\" o \"getCodigoNivelEstructura\" de la clase \"ValidateVigenciaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoNivelEstructura\" de la clase \"ValidateVigenciaDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoNivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoProducto y getCodigoProducto de la clase ValidateVigenciaDTO. 
	 */
	@Test
	public void testSetAndGeCodigoProductoMethod() {
		ValidateVigenciaDTO dto = new ValidateVigenciaDTO();
		String codigoProducto = "CODIGO_NIVEL_ESTRUCTURA";
		
		dto.setCodigoProducto(codigoProducto);
		
		String tmp = dto.getCodigoProducto();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoProducto\" o \"getCodigoProducto\" de la clase \"ValidateVigenciaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoProducto\" de la clase \"ValidateVigenciaDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProducto, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ValidateVigenciaDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ValidateVigenciaDTO dto = new ValidateVigenciaDTO();

		dto.setCodigoProductoComercial("CODIGO_PRODUCTO_COMERCIAL");
		dto.setCodigoNivelEstructura("CODIGO_NIVEL_ESTRUCTURA");
		dto.setCodigoProducto("CODIGO_PRODUCTO");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ValidateVigenciaDTO\".", tmp);
	}
}
