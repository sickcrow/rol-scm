/*
 * @(#)UsuarioCompuestoDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase UsuarioCompuestoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class UsuarioCompuestoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo UsuarioCompuestoDTO.
	 */
	@Test
	public void testConstructor() {
		UsuarioCompuestoDTO dto = new UsuarioCompuestoDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"UsuarioCompuestoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setPAsetPASEUsuarioSECookie y getPASEUsuario de la clase UsuarioCompuestoDTO. 
	 */
	@Test
	public void testSetAndGetPASEUsuarioMethod() {
		UsuarioCompuestoDTO dto = new UsuarioCompuestoDTO();
		PASEUsuarioDTO paseUsuario = new PASEUsuarioDTO();
		
		dto.setPASEUsuario(paseUsuario);
		
		PASEUsuarioDTO tmp = dto.getPASEUsuario();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPASEUsuario\" o \"getPASEUsuario\" de la clase \"UsuarioCompuestoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPASEUsuario\" de la clase \"UsuarioCompuestoDTO\""
				+ " no corresponde al valor enviado como argumento.", paseUsuario, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCapturador y getCapturador de la clase UsuarioCompuestoDTO. 
	 */
	@Test
	public void testSetAndGetCapturadorMethod() {
		UsuarioCompuestoDTO dto = new UsuarioCompuestoDTO();
		CapturadorDTO capturador = new CapturadorDTO();
		
		dto.setCapturador(capturador);
		
		CapturadorDTO tmp = dto.getCapturador();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCapturador\" o \"getCapturador\" de la clase \"UsuarioCompuestoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCapturador\" de la clase \"UsuarioCompuestoDTO\""
				+ " no corresponde al valor enviado como argumento.", capturador, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase UsuarioCompuestoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		UsuarioCompuestoDTO dto = new UsuarioCompuestoDTO();
		
		dto.setPASEUsuario(new PASEUsuarioDTO());
		dto.setCapturador(new CapturadorDTO());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"UsuarioCompuestoDTO\".", tmp);
	}
}
