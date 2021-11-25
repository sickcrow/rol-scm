/*
 * @(#)ItemOrdenamientoAvisoGroupSearchDTOTest.java		1.0 09/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ItemOrdenamientoAvisoGroupSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 09/08/2013
 */
public class ItemOrdenamientoAvisoGroupSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ItemOrdenamientoAvisoGroupSearchDTO.
	 */
	@Test
	public void testConstructor() {
		ItemOrdenamientoAvisoGroupSearchDTO dto = new ItemOrdenamientoAvisoGroupSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ItemOrdenamientoAvisoGroupSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setCodigoNivelEstructura y getCodigoNivelEstructura de la clase ItemOrdenamientoAvisoGroupSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoNivelEstructuraMethod() {
		ItemOrdenamientoAvisoGroupSearchDTO dto = new ItemOrdenamientoAvisoGroupSearchDTO();
		String codigoNivelEstructura = "CODIGO_NIVEL_ESTRUCTURA";
		
		dto.setCodigoNivelEstructura(codigoNivelEstructura);
		
		String tmp = dto.getCodigoNivelEstructura();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setCodigoNivelEstructura\" o \"getCodigoNivelEstructura\" de la clase \"ItemOrdenamientoAvisoGroupSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getCodigoNivelEstructura\" de la clase \"ItemOrdenamientoAvisoGroupSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoNivelEstructura, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setItemsOrdenamientoAvisoSearch y getItemsOrdenamientoAvisoSearch de la clase ItemOrdenamientoAvisoGroupSearchDTO. 
	 */
	@Test
	public void testSetAndGetItemsOrdenamientoAvisoSearchMethod() {
		ItemOrdenamientoAvisoGroupSearchDTO dto = new ItemOrdenamientoAvisoGroupSearchDTO();
		List<ItemOrdenamientoAvisoSearchDTO> itemsOrdenamientoAvisoSearch = new ArrayList<ItemOrdenamientoAvisoSearchDTO>();
		
		dto.setItemsOrdenamientoAvisoSearch(itemsOrdenamientoAvisoSearch);
		
		List<ItemOrdenamientoAvisoSearchDTO> tmp = dto.getItemsOrdenamientoAvisoSearch();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setItemsOrdenamientoAvisoSearch\" o \"getItemsOrdenamientoAvisoSearch\" de la clase \"ItemOrdenamientoAvisoGroupSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getItemsOrdenamientoAvisoSearch\" de la clase \"ItemOrdenamientoAvisoGroupSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", itemsOrdenamientoAvisoSearch, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ItemOrdenamientoAvisoGroupSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ItemOrdenamientoAvisoGroupSearchDTO dto = new ItemOrdenamientoAvisoGroupSearchDTO();
		
		List<ItemOrdenamientoAvisoSearchDTO> itemsOrdenamientoAvisoSearch = new ArrayList<ItemOrdenamientoAvisoSearchDTO>();
		itemsOrdenamientoAvisoSearch.add(new ItemOrdenamientoAvisoSearchDTO());
		itemsOrdenamientoAvisoSearch.add(new ItemOrdenamientoAvisoSearchDTO());
		itemsOrdenamientoAvisoSearch.add(new ItemOrdenamientoAvisoSearchDTO());
		
		dto.setCodigoNivelEstructura("CODIGO_NIVEL_ESTRUCTURA");
		dto.setItemsOrdenamientoAvisoSearch(itemsOrdenamientoAvisoSearch);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ItemOrdenamientoAvisoGroupSearchDTO\".", tmp);
	}
}
