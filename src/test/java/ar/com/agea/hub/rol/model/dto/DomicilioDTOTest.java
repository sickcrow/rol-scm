/*
 * @(#)DomicilioDTOTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase DomicilioDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class DomicilioDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo DomicilioDTO.
	 */
	@Test
	public void testConstructor() {
		DomicilioDTO dto = new DomicilioDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"DomicilioDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setTipoDomicilio y getTipoDomicilio de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetTipoDomicilioMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		TipoDomicilioDTO tipoDomicilio = new TipoDomicilioDTO();
		
		dto.setTipoDomicilio(tipoDomicilio);
		
		TipoDomicilioDTO tmp = dto.getTipoDomicilio();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setTipoDomicilio\" o \"getTipoDomicilio\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getTipoDomicilio\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", tipoDomicilio, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCalle y getCalle de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetCalleMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String calle = "CALLE";
		
		dto.setCalle(calle);
		
		String tmp = dto.getCalle();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCalle\" o \"getCalle\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCalle\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", calle, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPuerta y getPuerta de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetPuertaMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String puerta = "PUERTA";
		
		dto.setPuerta(puerta);
		
		String tmp = dto.getPuerta();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPuerta\" o \"getPuerta\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPuerta\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", puerta, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPiso y getPiso de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetPisoMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String piso = "PISO";
		
		dto.setPiso(piso);
		
		String tmp = dto.getPiso();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPiso\" o \"getPiso\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPiso\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", piso, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setDepto y getDepto de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetDeptoMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String depto = "DEPTO";
		
		dto.setDepto(depto);
		
		String tmp = dto.getDepto();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setDepto\" o \"getDepto\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getDepto\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", depto, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setCodPostal y getCodPostal de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetCodPostalMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String codPostal = "COD_POSTAL";
		
		dto.setCodPostal(codPostal);
		
		String tmp = dto.getCodPostal();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodPostal\" o \"getCodPostal\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodPostal\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", codPostal, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setLocalidad y getLocalidad de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetLocalidadMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String localidad = "LOCALIDAD";
		
		dto.setLocalidad(localidad);
		
		String tmp = dto.getLocalidad();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setLocalidad\" o \"getLocalidad\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getLocalidad\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", localidad, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setProvincia y getProvincia de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetProvinciaMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String provincia = "PROVINCIA";
		
		dto.setProvincia(provincia);
		
		String tmp = dto.getProvincia();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setProvincia\" o \"getProvincia\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getProvincia\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", provincia, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setPais y getPais de la clase DomicilioDTO. 
	 */
	@Test
	public void testSetAndGetPaisMethod() {
		DomicilioDTO dto = new DomicilioDTO();
		String pais = "PAIS";
		
		dto.setPais(pais);
		
		String tmp = dto.getPais();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setPais\" o \"getPais\" de la clase \"DomicilioDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getPais\" de la clase \"DomicilioDTO\""
				+ " no corresponde al valor enviado como argumento.", pais, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase DomicilioDTO. 
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
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"DomicilioDTO\".", tmp);
	}
}
