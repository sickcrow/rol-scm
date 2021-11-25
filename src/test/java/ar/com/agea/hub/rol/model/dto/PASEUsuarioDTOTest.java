/*
 * @(#)PASEUsuarioDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.PASEUsuarioDTO.Estado;

/**
 * Representa JUnit Tests de inicialización para la clase PASEUsuarioDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class PASEUsuarioDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo PASEUsuarioDTO.
	 */
	@Test
	public void testConstructor() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"PASEUsuarioDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigoSitio y getCodigoSitio de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetCodigoSitioMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String codigoSitio = "CODIGO_SITIO";
		
		dto.setCodigoSitio(codigoSitio);
		
		String tmp = dto.getCodigoSitio();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoSitio\" o \"getCodigoSitio\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoSitio\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoSitio, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setToken y getToken de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetTokenMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String token = "TOKEN";
		
		dto.setToken(token);
		
		String tmp = dto.getToken();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setToken\" o \"getToken\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoSitio\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", token, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setUid y getUid de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetUidMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String uid = "300";
		
		dto.setUid(uid);
		
		String tmp = dto.getUid();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setUid\" o \"getUid\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getUid\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", uid, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setApellido y getApellido de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetApellidoMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String apellido = "APELLIDO";
		
		dto.setApellido(apellido);
		
		String tmp = dto.getApellido();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setApellido\" o \"getApellido\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getApellido\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", apellido, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNombre y getNombre de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetNombreMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String nombre = "NOMBRE";
		
		dto.setNombre(nombre);
		
		String tmp = dto.getNombre();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNombre\" o \"getNombre\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNombre\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", nombre, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setGenero y getGenero de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetGeneroMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String genero = "GENERO";
		
		dto.setGenero(genero);
		
		String tmp = dto.getGenero();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setGenero\" o \"getGenero\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getGenero\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", genero, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFechaNacimiento y getFechaNacimiento de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetFechaNacimientoMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String fechaNacimiento = "FECHA_NACIMIENTO";
		
		dto.setFechaNacimiento(fechaNacimiento);
		
		String tmp = dto.getFechaNacimiento();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFechaNacimiento\" o \"getFechaNacimiento\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaNacimiento\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaNacimiento, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setEmail y getEmail de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetEmailMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String email = "EMAIL";
		
		dto.setEmail(email);
		
		String tmp = dto.getEmail();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setEmail\" o \"getEmail\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getEmail\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", email, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPalabraClave y getPalabraClave de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetPalabraClaveMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		String palabraClave = "PALABRA_CLAVE";
		
		dto.setPalabraClave(palabraClave);
		
		String tmp = dto.getPalabraClave();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPalabraClave\" o \"getPalabraClave\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPalabraClave\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", palabraClave, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setEstado y getEstado de la clase PASEUsuarioDTO. 
	 */
	@Test
	public void testSetAndGetEstadoMethod() {
		PASEUsuarioDTO dto = new PASEUsuarioDTO();
		Estado estado = Estado.CREADO;
		
		dto.setEstado(estado);
		
		Estado tmp = dto.getEstado();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setEstado\" o \"getEstado\" de la clase \"PASEUsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getEstado\" de la clase \"PASEUsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", estado, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase PASEUsuarioDTO. 
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
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"PASEUsuarioDTO\".", tmp);
	}
}
