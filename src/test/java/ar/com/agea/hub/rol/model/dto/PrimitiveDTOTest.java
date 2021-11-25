/*
 * @(#)PrimitiveDTOTest.java		1.0 31/07/2014
 */

package ar.com.agea.hub.rol.model.dto;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase PrimitiveDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 31/07/2014
 */
public class PrimitiveDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo PrimitiveDTO.
	 */
	@Test
	public void testConstructor() {
		PrimitiveDTO<String> dto = new PrimitiveDTO<String>("FIELD_NAME", "VALUE");
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"PrimitiveDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setFieldName y getFieldName de la clase PrimitiveDTO. 
	 */
	@Test
	public void testSetAndGetFieldNameMethod() {
		PrimitiveDTO<String> dto = new PrimitiveDTO<String>("FIELD_NAME", "VALUE");
		String fieldName = "NEW_FIELD_NAME";
		
		dto.setFieldName(fieldName);
		
		String tmp = dto.getFieldName();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setFieldName\" o \"getFieldName\" de la clase \"PrimitiveDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getFieldName\" de la clase \"PrimitiveDTO\""
				+ " no corresponde al valor enviado como argumento.", fieldName, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setValue y getValue de la clase PrimitiveDTO. 
	 */
	@Test
	public void testSetAndGetValueMethod() {
		PrimitiveDTO<String> dto = new PrimitiveDTO<String>("FIELD_NAME", "VALUE");
		String value = "NEW_VALUE";
		
		dto.setValue(value);
		
		String tmp = dto.getValue();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setValue\" o \"getValue\" de la clase \"PrimitiveDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getValue\" de la clase \"PrimitiveDTO\""
				+ " no corresponde al valor enviado como argumento.", value, tmp);
	}

	/**
	 * Comprueba la ejecución de método toString de la clase ImagenDTO. 
	 */
	@Test
	public void testToStringMethod() {
		PrimitiveDTO<String> dto = new PrimitiveDTO<String>("FIELD_NAME", "VALUE");
		
		dto.setFieldName("NEW_FIELD_NAME");
		dto.setValue("NEW_VALUE");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"PrimitiveDTO\".", tmp);
	}
}
