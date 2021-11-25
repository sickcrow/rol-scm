/*
 * @(#)DomicilioDTOTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase DomicilioDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class DomicilioDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo DomicilioDTO.
	 */
	@Test
	public void testConstructor() {
		DomicilioDTO dto = new DomicilioDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"DomicilioDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setTipoDomicilio y getTipoDomicilio de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetTipoDomicilioMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		TipoDomicilioDTO tipoDomicilio = new TipoDomicilioDTO();
		
		dto.setTipoDomicilio(tipoDomicilio);
		
		TipoDomicilioDTO tmp = dto.getTipoDomicilio();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setTipoDomicilio\" o \"getTipoDomicilio\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getTipoDomicilio\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", tipoDomicilio, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCalle y getCalle de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetCalleMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String calle = "CALLE";
		
		dto.setCalle(calle);
		
		String tmp = dto.getCalle();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCalle\" o \"getCalle\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCalle\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", calle, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPuerta y getPuerta de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetPuertaMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String puerta = "PUERTA";
		
		dto.setPuerta(puerta);
		
		String tmp = dto.getPuerta();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPuerta\" o \"getPuerta\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPuerta\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", puerta, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPiso y getPiso de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetPisoMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String piso = "PISO";
		
		dto.setPiso(piso);
		
		String tmp = dto.getPiso();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPiso\" o \"getPiso\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPiso\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", piso, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setDepto y getDepto de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetDeptoMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String depto = "DEPTO";
		
		dto.setDepto(depto);
		
		String tmp = dto.getDepto();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setDepto\" o \"getDepto\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getDepto\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", depto, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodPostal y getCodPostal de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetCodPostalMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String codPostal = "COD_POSTAL";
		
		dto.setCodPostal(codPostal);
		
		String tmp = dto.getCodPostal();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodPostal\" o \"getCodPostal\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodPostal\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", codPostal, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setLocalidad y getLocalidad de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetLocalidadMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String localidad = "LOCALIDAD";
		
		dto.setLocalidad(localidad);
		
		String tmp = dto.getLocalidad();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setLocalidad\" o \"getLocalidad\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getLocalidad\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", localidad, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setProvincia y getProvincia de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetProvinciaMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String provincia = "PROVINCIA";
		
		dto.setProvincia(provincia);
		
		String tmp = dto.getProvincia();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setProvincia\" o \"getProvincia\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getProvincia\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", provincia, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setPais y getPais de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetPaisMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String pais = "PAIS";
		
		dto.setPais(pais);
		
		String tmp = dto.getPais();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setPais\" o \"getPais\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getPais\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", pais, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase DomicilioDTO. 
	 */
	@Test
	public void testToStringMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		
		dto.setTipoDomicilio(new TipoDomicilioDTO());
		dto.setCalle("CALLE");
		dto.setPuerta("PUERTA");
		dto.setPiso("PISO");
		dto.setDepto("DEPTO");
		dto.setCodPostal("COD_POSTAL");
		dto.setLocalidad("LOCALIDAD");
		dto.setProvincia("PROVINCIA");
		dto.setPais("PAIS");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"DomicilioDTO\".", tmp);
	}
}
