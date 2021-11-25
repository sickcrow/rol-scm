/*
 * @(#)ModelSearchDTOTest.java		1.0 05/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase ModelSearchDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ModelSearchDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ModelSearchDTO.
	 */
	@Test
	public void testConstructor() {
		ModelSearchDTO dto = new ModelSearchDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ModelSearchDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setUuid y getUuid de la clase ModelSearchDTO. 
	 */
	@Test
	public void testSetAndGetUuidMethod() {
		ModelSearchDTO dto = new ModelSearchDTO();
		String uuid = "UUID";
		
		dto.setUuid(uuid);
		
		String tmp = dto.getUuid();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setUuid\" o \"getUuid\" de la clase \"ModelSearchDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getUuid\" de la clase \"ModelSearchDTO\""
				+ " no corresponde al valor enviado como argumento.", uuid, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase ModelSearchDTO. 
	 */
	@Test
	public void testToStringMethod() {
		ModelSearchDTO dto = new ModelSearchDTO();
		
		dto.setUuid("UUID");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"ModelSearchDTO\".", tmp);
	}
}
