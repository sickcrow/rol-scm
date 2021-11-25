/*
 * @(#)CapturadorCRUDDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase CapturadorCRUDDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class CapturadorCRUDDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo CapturadorCRUDDTO.
	 */
	@Test
	public void testConstructor() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"CapturadorCRUDDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigoAnunciante y getCodigoAnunciante de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAnuncianteMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		Long codigoAnunciante = 300L;
		
		dto.setCodigoAnunciante(codigoAnunciante);
		
		Long tmp = dto.getCodigoAnunciante();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoAnunciante\" o \"getCodigoAnunciante\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoAnunciante\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAnunciante, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoTipoAnunciante y getCodigoTipoAnunciante de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoAnuncianteMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String codigoTipoAnunciante = "CODIGO_TIPO_ANUNCIANTE";
		
		dto.setCodigoTipoAnunciante(codigoTipoAnunciante);
		
		String tmp = dto.getCodigoTipoAnunciante();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoTipoAnunciante\" o \"getCodigoTipoAnunciante\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoTipoAnunciante\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoAnunciante, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoCliente y getCodigoCliente de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoClienteMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String codigoCliente = "CODIGO_CLIENTE";
		
		dto.setCodigoCliente(codigoCliente);
		
		String tmp = dto.getCodigoCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoCliente\" o \"getCodigoCliente\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoCliente\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoPerfilAnunciante y getCodigoPerfilAnunciante de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoPerfilAnuncianteMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String codigoPerfilAnunciante = "CODIGO_PERFIL_ANUNCIANTE";
		
		dto.setCodigoPerfilAnunciante(codigoPerfilAnunciante);
		
		String tmp = dto.getCodigoPerfilAnunciante();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoPerfilAnunciante\" o \"getCodigoPerfilAnunciante\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoPerfilAnunciante\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoPerfilAnunciante, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setEmail y getEmail de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetEmailMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String email = "EMAIL";
		
		dto.setEmail(email);
		
		String tmp = dto.getEmail();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setEmail\" o \"getEmail\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getEmail\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", email, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNombre y getNombre de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetNombreMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String nombre = "NOMBRE";
		
		dto.setNombre(nombre);
		
		String tmp = dto.getNombre();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNombre\" o \"getNombre\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNombre\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", nombre, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setApellido y getApellido de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetApellidoMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String apellido = "APELLIDO";
		
		dto.setApellido(apellido);
		
		String tmp = dto.getApellido();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setApellido\" o \"getApellido\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getApellido\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", apellido, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoMedioPagoPrincipal y getCodigoMedioPagoPrincipal de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMedioPagoPrincipalMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String codigoMedioPagoPrincipal = "CODIGO_MEDIO_PAGO_PRINCIPAL";
		
		dto.setCodigoMedioPagoPrincipal(codigoMedioPagoPrincipal);
		
		String tmp = dto.getCodigoMedioPagoPrincipal();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoMedioPagoPrincipal\" o \"getCodigoMedioPagoPrincipal\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoMedioPagoPrincipal\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMedioPagoPrincipal, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoTipoIVA y getCodigoTipoIVA de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoIVAMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String codigoTipoIVA = "CODIGO_TIPO_IVA";
		
		dto.setCodigoTipoIVA(codigoTipoIVA);
		
		String tmp = dto.getCodigoTipoIVA();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoTipoIVA\" o \"getCodigoTipoIVA\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoTipoIVA\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoIVA, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoCanalEntrada\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoTipoDocumento y getCodigoTipoDocumento de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoDocumentoMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String codigoTipoDocumento = "CODIGO_TIPO_DOCUMENTO";
		
		dto.setCodigoTipoDocumento(codigoTipoDocumento);
		
		String tmp = dto.getCodigoTipoDocumento();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoTipoDocumento\" o \"getCodigoTipoDocumento\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoTipoDocumento\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoDocumento, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNumeroDocumento y getNumeroDocumento de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetNumeroDocumentoMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		Long numeroDocumento = 300L;
		
		dto.setNumeroDocumento(numeroDocumento);
		
		Long tmp = dto.getNumeroDocumento();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNumeroDocumento\" o \"getNumeroDocumento\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNumeroDocumento\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", numeroDocumento, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodigoPASE y getCodigoPASE de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoPASEMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String usuarioExternoCodigo = "300";
		
		dto.setUsuarioExternoCodigo(usuarioExternoCodigo);
		
		String tmp = dto.getUsuarioExternoCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setUsuarioExternoCodigo\" o \"getUsuarioExternoCodigo\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getUsuarioExternoCodigo\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", usuarioExternoCodigo, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setDomicilio y getDomicilio de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetDomicilioMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		DomicilioDTO domicilio = new DomicilioDTO();
		
		dto.setDomicilio(domicilio);
		
		DomicilioDTO tmp = dto.getDomicilio();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setDomicilio\" o \"getDomicilio\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getDomicilio\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", domicilio, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testToStringMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();

		dto.setCodigoAnunciante(300L);
		dto.setCodigoTipoAnunciante("CODIGO_TIPO_ANUNCIANTE");
		dto.setCodigoCliente("CODIGO_CLIENTE");
		dto.setCodigoPerfilAnunciante("CODIGO_PERFIL_ANUNCIANTE");
		dto.setEmail("EMAIL");
		dto.setNombre("NOMBRE");
		dto.setApellido("APELLIDO");
		dto.setCodigoMedioPagoPrincipal("CODIGO_MEDIO_PAGO_PRINCIPAL");
		dto.setCodigoTipoIVA("CODIGO_TIPO_IVA");
		dto.setCodigoCanalEntrada("CODIGO_CANAL_ENTRADA");
		dto.setCodigoTipoDocumento("CODIGO_TIPO_DOCUMENTO");
		dto.setNumeroDocumento(300L);
		dto.setUsuarioExternoCodigo("300");
		dto.setDomicilio(new DomicilioDTO());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"CapturadorCRUDDTO\".", tmp);
	}
}
