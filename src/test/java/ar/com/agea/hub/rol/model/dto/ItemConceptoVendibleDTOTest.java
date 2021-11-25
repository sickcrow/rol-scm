/*
 * @(#)ItemConceptoVendibleDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ItemConceptoVendibleDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ItemConceptoVendibleDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ItemConceptoVendibleDTO.
	 */
	@Test
	public void testConstructor() {
		ItemConceptoVendibleDTO dto = new ItemConceptoVendibleDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ItemConceptoVendibleDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setId y getId de la clase ItemConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		ItemConceptoVendibleDTO dto = new ItemConceptoVendibleDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setId\" o \"getId\" de la clase \"ItemConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getId\" de la clase \"ItemConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setNumero y getNumero de la clase ItemConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetNumeroMethod() {
		ItemConceptoVendibleDTO dto = new ItemConceptoVendibleDTO();
		Long numero = 300L;
		
		dto.setNumero(numero);
		
		Long tmp = dto.getNumero();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setNumero\" o \"getNumero\" de la clase \"ItemConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getNumero\" de la clase \"ItemConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", numero, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setItemsAviso y getItemsAviso de la clase ItemConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetItemsAvisoMethod() {
		ItemConceptoVendibleDTO dto = new ItemConceptoVendibleDTO();
		List<ItemAvisoDTO> itemsAviso = new ArrayList<ItemAvisoDTO>();
		
		dto.setItemsAviso(itemsAviso);
		
		List<ItemAvisoDTO> tmp = dto.getItemsAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setItemsAviso\" o \"getItemsAviso\" de la clase \"ItemConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getItemsAviso\" de la clase \"ItemConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", itemsAviso, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ItemConceptoVendibleDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ItemConceptoVendibleDTO dto = new ItemConceptoVendibleDTO();
		
		List<ItemAvisoDTO> itemsAviso = new ArrayList<ItemAvisoDTO>();
		itemsAviso.add(new ItemAvisoDTO());
		itemsAviso.add(new ItemAvisoDTO());
		itemsAviso.add(new ItemAvisoDTO());
		
		dto.setId(300L);
		dto.setNumero(300L);
		dto.setItemsAviso(itemsAviso);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ItemConceptoVendibleDTO\".", tmp);
	}
}
