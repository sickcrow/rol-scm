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
 * Representa JUnit Tests de inicializaci�n para la clase ItemConceptoVendibleDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ItemConceptoVendibleDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ItemConceptoVendibleDTO.
	 */
	@Test
	public void testConstructor() {
		ItemConceptoVendibleDTO dto = new ItemConceptoVendibleDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ItemConceptoVendibleDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setId y getId de la clase ItemConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetIdMethod() {
		ItemConceptoVendibleDTO dto = new ItemConceptoVendibleDTO();
		Long id = 300L;
		
		dto.setId(id);
		
		Long tmp = dto.getId();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setId\" o \"getId\" de la clase \"ItemConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getId\" de la clase \"ItemConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", id, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setNumero y getNumero de la clase ItemConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetNumeroMethod() {
		ItemConceptoVendibleDTO dto = new ItemConceptoVendibleDTO();
		Long numero = 300L;
		
		dto.setNumero(numero);
		
		Long tmp = dto.getNumero();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setNumero\" o \"getNumero\" de la clase \"ItemConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getNumero\" de la clase \"ItemConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", numero, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setItemsAviso y getItemsAviso de la clase ItemConceptoVendibleDTO. 
	 */
	@Test
	public void testSetAndGetItemsAvisoMethod() {
		ItemConceptoVendibleDTO dto = new ItemConceptoVendibleDTO();
		List<ItemAvisoDTO> itemsAviso = new ArrayList<ItemAvisoDTO>();
		
		dto.setItemsAviso(itemsAviso);
		
		List<ItemAvisoDTO> tmp = dto.getItemsAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setItemsAviso\" o \"getItemsAviso\" de la clase \"ItemConceptoVendibleDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getItemsAviso\" de la clase \"ItemConceptoVendibleDTO\""
				+ " no corresponde al valor enviado como argumento.", itemsAviso, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase ItemConceptoVendibleDTO. 
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
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"ItemConceptoVendibleDTO\".", tmp);
	}
}
