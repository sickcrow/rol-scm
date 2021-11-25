/*
 * @(#)LocalidadDTOTest.java		1.0 22/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase LocalidadDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class LocalidadDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo LocalidadDTO.
	 */
	@Test
	public void testConstructor() {
		LocalidadDTO dto = new LocalidadDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"LocalidadDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setId y getId de la clase LocalidadDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		LocalidadDTO dto = new LocalidadDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setId\" o \"getId\" de la clase \"LocalidadDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getId\" de la clase \"LocalidadDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase LocalidadDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		LocalidadDTO dto = new LocalidadDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"LocalidadDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"LocalidadDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoProvincia y getCodigoProvincia de la clase LocalidadDTO. 
	 */
	@Test
	public void testSetAndGetCodigoProvinciaMethod() {
		LocalidadDTO dto = new LocalidadDTO();
		String codigoProvincia = "CODIGO_PROVINCIA";
		
		dto.setCodigoProvincia(codigoProvincia);
		
		String tmp = dto.getCodigoProvincia();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoProvincia\" o \"getCodigoProvincia\" de la clase \"LocalidadDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoProvincia\" de la clase \"LocalidadDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoProvincia, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoPais y getCodigoPais de la clase LocalidadDTO. 
	 */
	@Test
	public void testSetAndGetCodigoPaisMethod() {
		LocalidadDTO dto = new LocalidadDTO();
		String codigoPais = "CODIGO_PAIS";
		
		dto.setCodigoPais(codigoPais);
		
		String tmp = dto.getCodigoPais();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoPais\" o \"getCodigoPais\" de la clase \"LocalidadDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoPais\" de la clase \"LocalidadDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoPais, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase LocalidadDTO. 
	 */
	@Test
	public void testToStringMethod() {
		LocalidadDTO dto = new LocalidadDTO();
		
		dto.setId(300L);
		dto.setCodigo("CODIGO");
		dto.setCodigoProvincia("CODIGO_PROVINCIA");
		dto.setCodigoPais("CODIGO_PAIS");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"LocalidadDTO\".", tmp);
	}
}
