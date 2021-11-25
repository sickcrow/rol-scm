/*
 * @(#)ItemOrdenamientoAvisoGroupDTOTest.java		1.0 09/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ItemOrdenamientoAvisoGroupDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 09/08/2013
 */
public class ItemOrdenamientoAvisoGroupDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ItemOrdenamientoAvisoGroupDTO.
	 */
	@Test
	public void testConstructor() {
		ItemOrdenamientoAvisoGroupDTO dto = new ItemOrdenamientoAvisoGroupDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ItemOrdenamientoAvisoGroupDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoOrdenamientoAvisoPadre y getCodigoOrdenamientoAvisoPadre de la clase ItemOrdenamientoAvisoGroupDTO. 
	 */
	@Test
	public void testSetAndGetCodigoOrdenamientoAvisoPadreMethod() {
		ItemOrdenamientoAvisoGroupDTO dto = new ItemOrdenamientoAvisoGroupDTO();
		String codigoOrdenamientoAvisoPadre = "CODIGO_ORDENAMIENTO_AVISO_PADRE";
		
		dto.setCodigoOrdenamientoAvisoPadre(codigoOrdenamientoAvisoPadre);
		
		String tmp = dto.getCodigoOrdenamientoAvisoPadre();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoOrdenamientoAvisoPadre\" o \"getCodigoOrdenamientoAvisoPadre\" de la clase \"ItemOrdenamientoAvisoGroupDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoOrdenamientoAvisoPadre\" de la clase \"ItemOrdenamientoAvisoGroupDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoOrdenamientoAvisoPadre, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoItemOrdenamientoAvisoPadre y getCodigoItemOrdenamientoAvisoPadre de la clase ItemOrdenamientoAvisoGroupDTO. 
	 */
	@Test
	public void testSetAndGetCodigoItemOrdenamientoAvisoPadreMethod() {
		ItemOrdenamientoAvisoGroupDTO dto = new ItemOrdenamientoAvisoGroupDTO();
		String codigoItemOrdenamientoAvisoPadre = "CODIGO_ITEM_ORDENAMIENTO_AVISO_PADRE";
		
		dto.setCodigoItemOrdenamientoAvisoPadre(codigoItemOrdenamientoAvisoPadre);
		
		String tmp = dto.getCodigoItemOrdenamientoAvisoPadre();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoItemOrdenamientoAvisoPadre\" o \"getCodigoItemOrdenamientoAvisoPadre\" de la clase \"ItemOrdenamientoAvisoGroupDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoItemOrdenamientoAvisoPadre\" de la clase \"ItemOrdenamientoAvisoGroupDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoItemOrdenamientoAvisoPadre, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoOrdenamientoAviso y getCodigoOrdenamientoAviso de la clase ItemOrdenamientoAvisoGroupDTO. 
	 */
	@Test
	public void testSetAndGetCodigoOrdenamientoAvisoMethod() {
		ItemOrdenamientoAvisoGroupDTO dto = new ItemOrdenamientoAvisoGroupDTO();
		String codigoOrdenamientoAviso = "CODIGO_ORDENAMIENTO_AVISO";
		
		dto.setCodigoOrdenamientoAviso(codigoOrdenamientoAviso);
		
		String tmp = dto.getCodigoOrdenamientoAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoOrdenamientoAviso\" o \"getCodigoOrdenamientoAviso\" de la clase \"ItemOrdenamientoAvisoGroupDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoOrdenamientoAviso\" de la clase \"ItemOrdenamientoAvisoGroupDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoOrdenamientoAviso, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setItemsOrdenamientoAviso y getItemsOrdenamientoAviso de la clase ItemOrdenamientoAvisoGroupDTO. 
	 */
	@Test
	public void testSetAndGetItemsOrdenamientoAvisoMethod() {
		ItemOrdenamientoAvisoGroupDTO dto = new ItemOrdenamientoAvisoGroupDTO();
		List<ItemOrdenamientoAvisoDTO> itemsOrdenamientoAviso = new ArrayList<ItemOrdenamientoAvisoDTO>();
		
		dto.setItemsOrdenamientoAviso(itemsOrdenamientoAviso);
		
		List<ItemOrdenamientoAvisoDTO> tmp = dto.getItemsOrdenamientoAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setItemsOrdenamientoAviso\" o \"getItemsOrdenamientoAviso\" de la clase \"ItemOrdenamientoAvisoGroupDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getItemsOrdenamientoAviso\" de la clase \"ItemOrdenamientoAvisoGroupDTO\""
				+ " no corresponde al valor enviado como argumento.", itemsOrdenamientoAviso, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase ItemOrdenamientoAvisoGroupDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ItemOrdenamientoAvisoGroupDTO dto = new ItemOrdenamientoAvisoGroupDTO();
		
		List<ItemOrdenamientoAvisoDTO> itemsOrdenamientoAviso = new ArrayList<ItemOrdenamientoAvisoDTO>();
		itemsOrdenamientoAviso.add(new ItemOrdenamientoAvisoDTO());
		itemsOrdenamientoAviso.add(new ItemOrdenamientoAvisoDTO());
		itemsOrdenamientoAviso.add(new ItemOrdenamientoAvisoDTO());
		
		dto.setCodigoOrdenamientoAvisoPadre("CODIGO_ORDENAMIENTO_AVISO_PADRE");
		dto.setCodigoItemOrdenamientoAvisoPadre("CODIGO_ITEM_ORDENAMIENTO_AVISO_PADRE");
		dto.setCodigoOrdenamientoAviso("CODIGO_ORDENAMIENTO_AVISO");
		dto.setItemsOrdenamientoAviso(itemsOrdenamientoAviso);
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"ItemOrdenamientoAvisoGroupDTO\".", tmp);
	}
}
