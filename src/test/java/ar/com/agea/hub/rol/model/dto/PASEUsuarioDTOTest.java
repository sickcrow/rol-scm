/*
 * @(#)PASEUsuarioDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.PASEUsuarioDTO.Estado;

/**
 * Representa JUnit Tests de inicializaci�n para la clase PASEUsuarioDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class PASEUsuarioDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo PASEUsuarioDTO.
	 */
	@Test
	public void testConstructor() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"PASEUsuarioDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoSitio y getCodigoSitio de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetCodigoSitioMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String codigoSitio = "CODIGO_SITIO";
		
		dto.setCodigoSitio(codigoSitio);
		
		String tmp = dto.getCodigoSitio();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoSitio\" o \"getCodigoSitio\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoSitio\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoSitio, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setToken y getToken de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetTokenMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String token = "TOKEN";
		
		dto.setToken(token);
		
		String tmp = dto.getToken();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setToken\" o \"getToken\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoSitio\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", token, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setUid y getUid de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetUidMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String uid = "300";
		
		dto.setUid(uid);
		
		String tmp = dto.getUid();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setUid\" o \"getUid\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getUid\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", uid, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setApellido y getApellido de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetApellidoMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String apellido = "APELLIDO";
		
		dto.setApellido(apellido);
		
		String tmp = dto.getApellido();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setApellido\" o \"getApellido\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getApellido\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", apellido, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNombre y getNombre de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetNombreMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String nombre = "NOMBRE";
		
		dto.setNombre(nombre);
		
		String tmp = dto.getNombre();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNombre\" o \"getNombre\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNombre\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", nombre, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setGenero y getGenero de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetGeneroMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String genero = "GENERO";
		
		dto.setGenero(genero);
		
		String tmp = dto.getGenero();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setGenero\" o \"getGenero\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getGenero\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", genero, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setFechaNacimiento y getFechaNacimiento de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetFechaNacimientoMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String fechaNacimiento = "FECHA_NACIMIENTO";
		
		dto.setFechaNacimiento(fechaNacimiento);
		
		String tmp = dto.getFechaNacimiento();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setFechaNacimiento\" o \"getFechaNacimiento\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getFechaNacimiento\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaNacimiento, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setEmail y getEmail de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetEmailMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String email = "EMAIL";
		
		dto.setEmail(email);
		
		String tmp = dto.getEmail();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setEmail\" o \"getEmail\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getEmail\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", email, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPalabraClave y getPalabraClave de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetPalabraClaveMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String palabraClave = "PALABRA_CLAVE";
		
		dto.setPalabraClave(palabraClave);
		
		String tmp = dto.getPalabraClave();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPalabraClave\" o \"getPalabraClave\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPalabraClave\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", palabraClave, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setEstado y getEstado de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetEstadoMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		Estado estado = Estado.CREADO;
		
		dto.setEstado(estado);
		
		Estado tmp = dto.getEstado();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setEstado\" o \"getEstado\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getEstado\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", estado, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testToStringMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();

		dto.setCodigoSitio("CODIGO_SITIO");
		dto.setToken("TOKEN");
		dto.setUid("300");
		dto.setApellido("APELLIDO");
		dto.setNombre("NOMBRE");
		dto.setGenero("GENERO");
		dto.setFechaNacimiento("FECHA_NACIMIENTO");
		dto.setEmail("EMAIL");
		dto.setPalabraClave("PALABRA_CLAVE");
		dto.setEstado(Estado.ACTIVO);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"PASEUsuarioDTO\".", tmp);
	}
}
