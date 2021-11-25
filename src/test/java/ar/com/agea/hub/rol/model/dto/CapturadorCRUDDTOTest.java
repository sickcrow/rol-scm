/*
 * @(#)CapturadorCRUDDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase CapturadorCRUDDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class CapturadorCRUDDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo CapturadorCRUDDTO.
	 */
	@Test
	public void testConstructor() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"CapturadorCRUDDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoAnunciante y getCodigoAnunciante de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAnuncianteMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		Long codigoAnunciante = 300L;
		
		dto.setCodigoAnunciante(codigoAnunciante);
		
		Long tmp = dto.getCodigoAnunciante();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoAnunciante\" o \"getCodigoAnunciante\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoAnunciante\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAnunciante, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoTipoAnunciante y getCodigoTipoAnunciante de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoAnuncianteMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String codigoTipoAnunciante = "CODIGO_TIPO_ANUNCIANTE";
		
		dto.setCodigoTipoAnunciante(codigoTipoAnunciante);
		
		String tmp = dto.getCodigoTipoAnunciante();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoTipoAnunciante\" o \"getCodigoTipoAnunciante\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoTipoAnunciante\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoAnunciante, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoCliente y getCodigoCliente de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoClienteMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String codigoCliente = "CODIGO_CLIENTE";
		
		dto.setCodigoCliente(codigoCliente);
		
		String tmp = dto.getCodigoCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoCliente\" o \"getCodigoCliente\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoCliente\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoPerfilAnunciante y getCodigoPerfilAnunciante de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoPerfilAnuncianteMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String codigoPerfilAnunciante = "CODIGO_PERFIL_ANUNCIANTE";
		
		dto.setCodigoPerfilAnunciante(codigoPerfilAnunciante);
		
		String tmp = dto.getCodigoPerfilAnunciante();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoPerfilAnunciante\" o \"getCodigoPerfilAnunciante\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoPerfilAnunciante\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoPerfilAnunciante, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setEmail y getEmail de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetEmailMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String email = "EMAIL";
		
		dto.setEmail(email);
		
		String tmp = dto.getEmail();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setEmail\" o \"getEmail\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getEmail\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", email, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNombre y getNombre de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetNombreMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String nombre = "NOMBRE";
		
		dto.setNombre(nombre);
		
		String tmp = dto.getNombre();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNombre\" o \"getNombre\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNombre\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", nombre, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setApellido y getApellido de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetApellidoMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String apellido = "APELLIDO";
		
		dto.setApellido(apellido);
		
		String tmp = dto.getApellido();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setApellido\" o \"getApellido\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getApellido\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", apellido, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoMedioPagoPrincipal y getCodigoMedioPagoPrincipal de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMedioPagoPrincipalMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String codigoMedioPagoPrincipal = "CODIGO_MEDIO_PAGO_PRINCIPAL";
		
		dto.setCodigoMedioPagoPrincipal(codigoMedioPagoPrincipal);
		
		String tmp = dto.getCodigoMedioPagoPrincipal();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoMedioPagoPrincipal\" o \"getCodigoMedioPagoPrincipal\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoMedioPagoPrincipal\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoMedioPagoPrincipal, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoTipoIVA y getCodigoTipoIVA de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoIVAMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String codigoTipoIVA = "CODIGO_TIPO_IVA";
		
		dto.setCodigoTipoIVA(codigoTipoIVA);
		
		String tmp = dto.getCodigoTipoIVA();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoTipoIVA\" o \"getCodigoTipoIVA\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoTipoIVA\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoIVA, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoCanalEntrada y getCodigoCanalEntrada de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoCanalEntradaMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String codigoCanalEntrada = "CODIGO_CANAL_ENTRADA";
		
		dto.setCodigoCanalEntrada(codigoCanalEntrada);
		
		String tmp = dto.getCodigoCanalEntrada();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoCanalEntrada\" o \"getCodigoCanalEntrada\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoCanalEntrada\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCanalEntrada, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoTipoDocumento y getCodigoTipoDocumento de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoTipoDocumentoMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String codigoTipoDocumento = "CODIGO_TIPO_DOCUMENTO";
		
		dto.setCodigoTipoDocumento(codigoTipoDocumento);
		
		String tmp = dto.getCodigoTipoDocumento();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoTipoDocumento\" o \"getCodigoTipoDocumento\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoTipoDocumento\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoTipoDocumento, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNumeroDocumento y getNumeroDocumento de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetNumeroDocumentoMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		Long numeroDocumento = 300L;
		
		dto.setNumeroDocumento(numeroDocumento);
		
		Long tmp = dto.getNumeroDocumento();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNumeroDocumento\" o \"getNumeroDocumento\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNumeroDocumento\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", numeroDocumento, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoPASE y getCodigoPASE de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetCodigoPASEMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		String usuarioExternoCodigo = "300";
		
		dto.setUsuarioExternoCodigo(usuarioExternoCodigo);
		
		String tmp = dto.getUsuarioExternoCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setUsuarioExternoCodigo\" o \"getUsuarioExternoCodigo\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getUsuarioExternoCodigo\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", usuarioExternoCodigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setDomicilio y getDomicilio de la clase CapturadorCRUDDTO. 
	 */
	@Test
	public void testSetAndGetDomicilioMethod() {
		CapturadorCRUDDTO dto = new CapturadorCRUDDTO();
		DomicilioDTO domicilio = new DomicilioDTO();
		
		dto.setDomicilio(domicilio);
		
		DomicilioDTO tmp = dto.getDomicilio();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setDomicilio\" o \"getDomicilio\" de la clase \"CapturadorCRUDDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getDomicilio\" de la clase \"CapturadorCRUDDTO\""
				+ " no corresponde al valor enviado como argumento.", domicilio, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase CapturadorCRUDDTO. 
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
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"CapturadorCRUDDTO\".", tmp);
	}
}
