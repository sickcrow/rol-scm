/*
 * @(#)UsuarioDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase UsuarioDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class UsuarioDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo UsuarioDTO.
	 */
	@Test
	public void testConstructor() {
		UsuarioDTO dto = new UsuarioDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"UsuarioDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setUid y getUid de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetUidMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String uid = "300";
		
		dto.setUid(uid);
		
		String tmp = dto.getUid();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setUid\" o \"getUid\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getUid\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", uid, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setApellido y getApellido de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetApellidoMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String apellido = "APELLIDO";
		
		dto.setApellido(apellido);
		
		String tmp = dto.getApellido();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setApellido\" o \"getApellido\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getApellido\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", apellido, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNombre y getNombre de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetNombreMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String nombre = "NOMBRE";
		
		dto.setNombre(nombre);
		
		String tmp = dto.getNombre();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNombre\" o \"getNombre\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNombre\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", nombre, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setGenero y getGenero de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetGeneroMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String genero = "GENERO";
		
		dto.setGenero(genero);
		
		String tmp = dto.getGenero();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setGenero\" o \"getGenero\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getGenero\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", genero, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setFechaNacimiento y getFechaNacimiento de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetFechaNacimientoMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String fechaNacimiento = "FECHA_NACIMIENTO";
		
		dto.setFechaNacimiento(fechaNacimiento);
		
		String tmp = dto.getFechaNacimiento();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFechaNacimiento\" o \"getFechaNacimiento\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFechaNacimiento\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", fechaNacimiento, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoTipoDocumento y getCodigoTipoDocumento de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoDocumentoMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String codigoTipoDocumento = "CODIGO_TIPO_DOCUMENTO";
		
		dto.setCodigoTipoDocumento(codigoTipoDocumento);
		
		String tmp = dto.getCodigoTipoDocumento();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoTipoDocumento\" o \"getCodigoTipoDocumento\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoTipoDocumento\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoDocumento, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNumeroDocumento y getNumeroDocumento de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetNumeroDocumentoMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		Long numeroDocumento = 300L;
		
		dto.setNumeroDocumento(numeroDocumento);
		
		Long tmp = dto.getNumeroDocumento();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNumeroDocumento\" o \"getNumeroDocumento\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNumeroDocumento\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", numeroDocumento, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setEmail y getEmail de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetEmailMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String email = "EMAIL";
		
		dto.setEmail(email);
		
		String tmp = dto.getEmail();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setEmail\" o \"getEmail\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getEmail\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", email, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPalabraClave y getPalabraClave de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetPalabraClaveMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String palabraClave = "PALABRA_CLAVE";
		
		dto.setPalabraClave(palabraClave);
		
		String tmp = dto.getPalabraClave();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPalabraClave\" o \"getPalabraClave\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPalabraClave\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", palabraClave, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPalabraClaveNueva y getPalabraClaveNueva de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetPalabraClaveNuevaMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String palabraClaveNueva = "PALABRA_CLAVE_NUEVA";
		
		dto.setPalabraClaveNueva(palabraClaveNueva);
		
		String tmp = dto.getPalabraClaveNueva();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPalabraClaveNueva\" o \"getPalabraClaveNueva\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPalabraClaveNueva\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", palabraClaveNueva, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoCliente y getCodigoCliente de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetCodigoClienteMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String codigoCliente = "CODIGO_CLIENTE";
		
		dto.setCodigoCliente(codigoCliente);
		
		String tmp = dto.getCodigoCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoCliente\" o \"getCodigoCliente\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoCliente\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoAnunciante y getCodigoAnunciante de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAnuncianteMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		Long codigoAnunciante = 300L;
		
		dto.setCodigoAnunciante(codigoAnunciante);
		
		Long tmp = dto.getCodigoAnunciante();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoAnunciante\" o \"getCodigoAnunciante\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoAnunciante\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAnunciante, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoTipoAnunciante y setCodigoTipoAnunciante de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoAnuncianteMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String codigoTipoAnunciante = "CODIGO_TIPO_ANUNCIANTE";
		
		dto.setCodigoTipoAnunciante(codigoTipoAnunciante);
		
		String tmp = dto.getCodigoTipoAnunciante();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoTipoAnunciante\" o \"setCodigoTipoAnunciante\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"setCodigoTipoAnunciante\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoAnunciante, tmp);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigoPerfilAnunciante y setCodigoPerfilAnunciante de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetCodigoPerfilAnuncianteMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String codigoPerfilAnunciante = "CODIGO_PERFIL_ANUNCIANTE";
		
		dto.setCodigoPerfilAnunciante(codigoPerfilAnunciante);
		
		String tmp = dto.getCodigoPerfilAnunciante();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoPerfilAnunciante\" o \"setCodigoPerfilAnunciante\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"setCodigoPerfilAnunciante\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoPerfilAnunciante, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoCanalEntrada\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoTipoIVA y getCodigoTipoIVA de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoIVAMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String codigoTipoIVA = "CODIGO_TIPO_IVA";
		
		dto.setCodigoTipoIVA(codigoTipoIVA);
		
		String tmp = dto.getCodigoTipoIVA();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoTipoIVA\" o \"getCodigoTipoIVA\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoTipoIVA\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoIVA, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoMedioPagoPrincipal y getCodigoMedioPagoPrincipal de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMedioPagoPrincipalMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		String codigoMedioPagoPrincipal = "CODIGO_MEDIO_PAGO_PRINCIPAL";
		
		dto.setCodigoMedioPagoPrincipal(codigoMedioPagoPrincipal);
		
		String tmp = dto.getCodigoMedioPagoPrincipal();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoMedioPagoPrincipal\" o \"getCodigoMedioPagoPrincipal\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoMedioPagoPrincipal\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMedioPagoPrincipal, tmp);
	}

	/**
	 * Comprueba la ejecución de métodos setCaptcha y getCaptcha de la clase UsuarioDTO. 
	 */
	@Test
	public void testSetAndGetCaptchaMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		CaptchaDTO captcha = new CaptchaDTO();
		
		dto.setCaptcha(captcha);
		
		CaptchaDTO tmp = dto.getCaptcha();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCaptcha\" o \"getCaptcha\" de la clase \"UsuarioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCaptcha\" de la clase \"UsuarioDTO\""
				+ " no corresponde al valor enviado como argumento.", captcha, tmp);
	}
	

	/**
	 * Comprueba la ejecución de método toString de la clase UsuarioDTO. 
	 */
	@Test
	public void testToStringMethod() {
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setUid("300");
		dto.setApellido("APELLIDO");
		dto.setNombre("NOMBRE");
		dto.setGenero("GENERO");
		dto.setFechaNacimiento("FECHA_NACIMIENTO");
		dto.setCodigoTipoDocumento("CODIGO_TIPO_DOCUMENTO");
		dto.setNumeroDocumento(300L);
		dto.setEmail("EMAIL");
		dto.setPalabraClave("PALABRA_CLAVE");
		dto.setPalabraClaveNueva("PALABRA_CLAVE_NUEVA");
		dto.setCodigoCliente("CODIGO_CLIENTE");
		dto.setCodigoAnunciante(300L);
		dto.setCodigoTipoAnunciante("CODIGO_TIPO_ANUNCIANTE");
		dto.setCodigoPerfilAnunciante("CODIGO_PERFIL_ANUNCIANTE");
		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		dto.setCodigoTipoIVA("CODIGO_TIPO_IVA");
		dto.setCodigoMedioPagoPrincipal("CODIGO_MEDIO_PAGO_PRINCIPAL");
		dto.setCaptcha(new CaptchaDTO());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"UsuarioDTO\".", tmp);
	}
}
