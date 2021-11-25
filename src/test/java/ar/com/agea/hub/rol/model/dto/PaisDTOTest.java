/*
 * @(#)PaisDTOTest.java		1.0 21/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase PaisDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 21/01/2014
 */
public class PaisDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo PaisDTO.
	 */
	@Test
	public void testConstructor() {
		PaisDTO dto = new PaisDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"PaisDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setId y getId de la clase PaisDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		PaisDTO dto = new PaisDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setId\" o \"getId\" de la clase \"PaisDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getId\" de la clase \"PaisDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigo y getCodigo de la clase PaisDTO. 
	 */
	@Test
	public void testSetAndGetCodigoMethod() {
		PaisDTO dto = new PaisDTO();
		String codigo = "CODIGO";
		
		dto.setCodigo(codigo);
		
		String tmp = dto.getCodigo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigo\" o \"getCodigo\" de la clase \"PaisDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigo\" de la clase \"PaisDTO\""
				+ " no corresponde al valor enviado como argumento.", codigo, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase PaisDTO. 
	 */
	@Test
	public void testToStringMethod() {
		PaisDTO dto = new PaisDTO();
		
		dto.setId(300L);
		dto.setCodigo("CODIGO");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"PaisDTO\".", tmp);
	}
}
