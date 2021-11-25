/*
 * @(#)ProvinciaDTOTest.java		1.0 24/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ProvinciaDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 24/09/2013
 */
public class ProvinciaDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ProvinciaDTO.
	 */
	@Test
	public void testConstructor() {
		ProvinciaDTO dto = new ProvinciaDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ProvinciaDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setId y getId de la clase ProvinciaDTO. 
	 */
	@Test
	public void testSetAndGetidMethod() {
		ProvinciaDTO dto = new ProvinciaDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setId\" o \"getId\" de la clase \"ProvinciaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getId\" de la clase \"ProvinciaDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase ProvinciaDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		ProvinciaDTO dto = new ProvinciaDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"ProvinciaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"ProvinciaDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoPais y getCodigoPais de la clase ProvinciaDTO. 
	 */
	@Test
	public void testSetAndGetCodigoPaisMethod() {
		ProvinciaDTO dto = new ProvinciaDTO();
		String codigoPais = "CODIGO_PAIS";
		
		dto.setCodigoPais(codigoPais);
		
		String tmp = dto.getCodigoPais();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoPais\" o \"getCodigoPais\" de la clase \"ProvinciaDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoPais\" de la clase \"ProvinciaDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoPais, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase ProvinciaDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ProvinciaDTO dto = new ProvinciaDTO();

		dto.setId(300L);
		dto.setCodigo("CODIGO");
		dto.setCodigoPais("CODIGO_PAIS");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"ProvinciaDTO\".", tmp);
	}
}
