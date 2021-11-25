/*
 * @(#)ItemAvisoDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ItemAvisoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ItemAvisoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ItemAvisoDTO.
	 */
	@Test
	public void testConstructor() {
		ItemAvisoDTO dto = new ItemAvisoDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ItemAvisoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setId y getId de la clase ItemAvisoDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		ItemAvisoDTO dto = new ItemAvisoDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setId\" o \"getId\" de la clase \"ItemAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getId\" de la clase \"ItemAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNumero y getNumero de la clase ItemAvisoDTO. 
	 */
	@Test
	public void testSetAndGetNumeroMethod() {
		ItemAvisoDTO dto = new ItemAvisoDTO();
		Long numero = 300L;
		
		dto.setNumero(numero);
		
		Long tmp = dto.getNumero();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNumero\" o \"getNumero\" de la clase \"ItemAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNumero\" de la clase \"ItemAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", numero, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setAviso y getAviso de la clase ItemAvisoDTO. 
	 */
	@Test
	public void testSetAndGetAvisoMethod() {
		ItemAvisoDTO dto = new ItemAvisoDTO();
		AvisoDTO aviso = new AvisoDTO();
		
		dto.setAviso(aviso);
		
		AvisoDTO tmp = dto.getAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setAviso\" o \"getAviso\" de la clase \"ItemAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getAviso\" de la clase \"ItemAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", aviso, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ItemAvisoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ItemAvisoDTO dto = new ItemAvisoDTO();
		
		dto.setId(300L);
		dto.setNumero(300L);
		dto.setAviso(new AvisoDTO());
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ItemAvisoDTO\".", tmp);
	}
}
