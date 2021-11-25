/*
 * @(#)ItemOrdenamientoAvisoSearchDTOTest.java		1.0 09/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ItemOrdenamientoAvisoSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 09/08/2013
 */
public class ItemOrdenamientoAvisoSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo ItemOrdenamientoAvisoSearchDTO.
	 */
	@Test
	public void testConstructor() {
		ItemOrdenamientoAvisoSearchDTO dto = new ItemOrdenamientoAvisoSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"ItemOrdenamientoAvisoSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoOrdenamientoAviso y getCodigoOrdenamientoAviso de la clase ItemOrdenamientoAvisoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoOrdenamientoAvisoMethod() {
		ItemOrdenamientoAvisoSearchDTO dto = new ItemOrdenamientoAvisoSearchDTO();
		String codigoOrdenamientoAviso = "CODIGO_ORDENAMIENTO_AVISO";
		
		dto.setCodigoOrdenamientoAviso(codigoOrdenamientoAviso);
		
		String tmp = dto.getCodigoOrdenamientoAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoOrdenamientoAviso\" o \"getCodigoOrdenamientoAviso\" de la clase \"ItemOrdenamientoAvisoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoOrdenamientoAviso\" de la clase \"ItemOrdenamientoAvisoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoOrdenamientoAviso, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoOrdenamientoAvisoPadre y getCodigoOrdenamientoAvisoPadre de la clase ItemOrdenamientoAvisoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoOrdenamientoAvisoPadreMethod() {
		ItemOrdenamientoAvisoSearchDTO dto = new ItemOrdenamientoAvisoSearchDTO();
		String codigoOrdenamientoAvisoPadre = "CODIGO_ORDENAMIENTO_AVISO_PADRE";
		
		dto.setCodigoOrdenamientoAvisoPadre(codigoOrdenamientoAvisoPadre);
		
		String tmp = dto.getCodigoOrdenamientoAvisoPadre();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoOrdenamientoAvisoPadre\" o \"getCodigoOrdenamientoAvisoPadre\" de la clase \"ItemOrdenamientoAvisoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoOrdenamientoAvisoPadre\" de la clase \"ItemOrdenamientoAvisoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoOrdenamientoAvisoPadre, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setCodigoItemOrdenamientoAvisoPadre y getCodigoItemOrdenamientoAvisoPadre de la clase ItemOrdenamientoAvisoSearchDTO. 
	 */
	@Test
	public void testSetAndGetCodigoItemOrdenamientoAvisoPadreMethod() {
		ItemOrdenamientoAvisoSearchDTO dto = new ItemOrdenamientoAvisoSearchDTO();
		String codigoItemOrdenamientoAvisoPadre = "CODIGO_ITEM_ORDENAMIENTO_AVISO_PADRE";
		
		dto.setCodigoItemOrdenamientoAvisoPadre(codigoItemOrdenamientoAvisoPadre);
		
		String tmp = dto.getCodigoItemOrdenamientoAvisoPadre();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setCodigoItemOrdenamientoAvisoPadre\" o \"getCodigoItemOrdenamientoAvisoPadre\" de la clase \"ItemOrdenamientoAvisoSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getCodigoItemOrdenamientoAvisoPadre\" de la clase \"ItemOrdenamientoAvisoSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", codigoItemOrdenamientoAvisoPadre, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase ItemOrdenamientoAvisoSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ItemOrdenamientoAvisoSearchDTO dto = new ItemOrdenamientoAvisoSearchDTO();

		dto.setCodigoNivelEstructura("CODIGO_NIVEL_ESTRUCTURA");
		dto.setCodigoOrdenamientoAviso("CODIGO_ORDENAMIENTO_AVISO");
		dto.setCodigoOrdenamientoAvisoPadre("CODIGO_ORDENAMIENTO_AVISO_PADRE");
		dto.setCodigoItemOrdenamientoAvisoPadre("CODIGO_ITEM_ORDENAMIENTO_AVISO_PADRE");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"ItemOrdenamientoAvisoSearchDTO\".", tmp);
	}
}
