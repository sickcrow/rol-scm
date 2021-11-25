/*
 * @(#)ValidateVigenciaDTOTest.java		1.0 31/07/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ValidateVigenciaDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 31/07/2014
 */
public class ValidateVigenciaDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ValidateVigenciaDTO.
	 */
	@Test
	public void testConstructor() {
		ValidateVigenciaDTO dto = new ValidateVigenciaDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ValidateVigenciaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoProductoComercial y getCodigoProductoComercial de la clase ValidateVigenciaDTO. 
	 */
	@Test
	public void testSetAndGeCodigoProductoComercialMethod() {
		ValidateVigenciaDTO dto = new ValidateVigenciaDTO();
		String codigoProductoComercial = "CODIGO_PRODUCTO_COMERCIAL";
		
		dto.setCodigoProductoComercial(codigoProductoComercial);
		
		String tmp = dto.getCodigoProductoComercial();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoProductoComercial\" o \"getCodigoProductoComercial\" de la clase \"ValidateVigenciaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoProductoComercial\" de la clase \"ValidateVigenciaDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProductoComercial, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoNivelEstructura y getCodigoNivelEstructura de la clase ValidateVigenciaDTO. 
	 */
	@Test
	public void testSetAndGeCodigoNivelEstructuraMethod() {
		ValidateVigenciaDTO dto = new ValidateVigenciaDTO();
		String codigoNivelEstructura = "CODIGO_NIVEL_ESTRUCTURA";
		
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		
		String tmp = dto.getCodigoNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoNivelEstructura\" o \"getCodigoNivelEstructura\" de la clase \"ValidateVigenciaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoNivelEstructura\" de la clase \"ValidateVigenciaDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoNivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoProducto y getCodigoProducto de la clase ValidateVigenciaDTO. 
	 */
	@Test
	public void testSetAndGeCodigoProductoMethod() {
		ValidateVigenciaDTO dto = new ValidateVigenciaDTO();
		String codigoProducto = "CODIGO_NIVEL_ESTRUCTURA";
		
		dto.setCodigoProducto(codigoProducto);
		
		String tmp = dto.getCodigoProducto();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoProducto\" o \"getCodigoProducto\" de la clase \"ValidateVigenciaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoProducto\" de la clase \"ValidateVigenciaDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProducto, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase ValidateVigenciaDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ValidateVigenciaDTO dto = new ValidateVigenciaDTO();

		dto.setCodigoProductoComercial("CODIGO_PRODUCTO_COMERCIAL");
		dto.setCodigoNivelEstructura("CODIGO_NIVEL_ESTRUCTURA");
		dto.setCodigoProducto("CODIGO_PRODUCTO");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"ValidateVigenciaDTO\".", tmp);
	}
}
