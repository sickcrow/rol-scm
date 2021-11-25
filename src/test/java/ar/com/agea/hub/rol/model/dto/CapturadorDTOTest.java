/*
 * @(#)CapturadorDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.CapturadorDTO.Tipo;

/**
 * Representa JUnit Tests de inicializaci�n para la clase CapturadorDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class CapturadorDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo CapturadorDTO.
	 */
	@Test
	public void testConstructor() {
		CapturadorDTO dto = new CapturadorDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"CapturadorDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setTipo y getTipo de la clase CapturadorDTO. 
	 */
	@Test
	public void testSetAndGetTipoMethod() {
		CapturadorDTO dto = new CapturadorDTO();
		Tipo tipo = Tipo.ANUNCIANTE;
		
		dto.setTipo(tipo);
		
		Tipo tmp = dto.getTipo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTipo\" o \"getTipo\" de la clase \"CapturadorDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTipo\" de la clase \"CapturadorDTO\""
				+ " no corresponde al valor enviado como argumento.", tipo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNumeroDocumento y getNumeroDocumento de la clase CapturadorDTO. 
	 */
	@Test
	public void testSetAndGetNumeroDocumentoMethod() {
		CapturadorDTO dto = new CapturadorDTO();
		Long numeroDocumento = 300L;
		
		dto.setNumeroDocumento(numeroDocumento);
		
		Long tmp = dto.getNumeroDocumento();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNumeroDocumento\" o \"getNumeroDocumento\" de la clase \"CapturadorDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNumeroDocumento\" de la clase \"CapturadorDTO\""
				+ " no corresponde al valor enviado como argumento.", numeroDocumento, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoCliente y getCodigoCliente de la clase CapturadorDTO. 
	 */
	@Test
	public void testSetAndGetCodigoClienteMethod() {
		CapturadorDTO dto = new CapturadorDTO();
		String codigoCliente = "CODIGO CLIENTE";
		
		dto.setCodigoCliente(codigoCliente);
		
		String tmp = dto.getCodigoCliente();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoCliente\" o \"getCodigoCliente\" de la clase \"CapturadorDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoCliente\" de la clase \"CapturadorDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoCliente, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoAnunciante y getCodigoAnunciante de la clase CapturadorDTO. 
	 */
	@Test
	public void testSetAndGetCodigoAnuncianteMethod() {
		CapturadorDTO dto = new CapturadorDTO();
		Long codigoAnunciante = 300L;
		
		dto.setCodigoAnunciante(codigoAnunciante);
		
		Long tmp = dto.getCodigoAnunciante();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoAnunciante\" o \"getCodigoAnunciante\" de la clase \"CapturadorDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoAnunciante\" de la clase \"CapturadorDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoAnunciante, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setUsuarioExternoCodigo y getUsuarioExternoCodigo de la clase CapturadorDTO. 
	 */
	@Test
	public void testSetAndGetCodigoPASEMethod() {
		CapturadorDTO dto = new CapturadorDTO();
		String usuarioExternoCodigo = "300";
		
		dto.setUsuarioExternoCodigo(usuarioExternoCodigo);
		
		String tmp = dto.getUsuarioExternoCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setUsuarioExternoCodigo\" o \"getCodigoPASE\" de la clase \"CapturadorDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getUsuarioExternoCodigo\" de la clase \"CapturadorDTO\""
				+ " no corresponde al valor enviado como argumento.", usuarioExternoCodigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setDomicilio y getDomicilio de la clase CapturadorDTO. 
	 */
	@Test
	public void testSetAndGetDomicilioMethod() {
		CapturadorDTO dto = new CapturadorDTO();
		DomicilioDTO domicilio = new DomicilioDTO();
		
		dto.setDomicilio(domicilio);
		
		DomicilioDTO tmp = dto.getDomicilio();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setDomicilio\" o \"getDomicilio\" de la clase \"CapturadorDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getDomicilio\" de la clase \"CapturadorDTO\""
				+ " no corresponde al valor enviado como argumento.", domicilio, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase CapturadorDTO. 
	 */
	@Test
	public void testToStringMethod() {
		CapturadorDTO dto = new CapturadorDTO();

		dto.setTipo(Tipo.ANUNCIANTE);
		dto.setNumeroDocumento(300L);
		dto.setCodigoCliente("CODIGO_CLIENTE");
		dto.setCodigoAnunciante(300L);
		dto.setUsuarioExternoCodigo("300");
		dto.setDomicilio(new DomicilioDTO());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"CapturadorDTO\".", tmp);
	}
}
