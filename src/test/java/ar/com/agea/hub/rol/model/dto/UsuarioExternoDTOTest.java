/*
 * @(#)UsuarioExternoDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase UsuarioExternoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class UsuarioExternoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo UsuarioExternoDTO.
	 */
	@Test
	public void testConstructor() {
		UsuarioExternoDTO dto = new UsuarioExternoDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"UsuarioExternoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigo y getCodigo de la clase UsuarioExternoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		UsuarioExternoDTO dto = new UsuarioExternoDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigo\" o \"getCodigo\" de la clase \"UsuarioExternoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigo\" de la clase \"UsuarioExternoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoSistema y getCodigoSistema de la clase UsuarioExternoDTO. 
	 */
	@Test
	public void testSetAndGetCodigoSistemaMethod() {
		UsuarioExternoDTO dto = new UsuarioExternoDTO();
		String codigoSistema = "CODIGO SISTEMA";
		
		dto.setCodigoSistema(codigoSistema);
		
		String tmp = dto.getCodigoSistema();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoSistema\" o \"getCodigoSistema\" de la clase \"UsuarioExternoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoSistema\" de la clase \"UsuarioExternoDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoSistema, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase UsuarioExternoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		UsuarioExternoDTO dto = new UsuarioExternoDTO();
		
		dto.setCodigo("CODIGO");
		dto.setCodigoSistema("CODIGO_SISTEMA");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"UsuarioExternoDTO\".", tmp);
	}
}
