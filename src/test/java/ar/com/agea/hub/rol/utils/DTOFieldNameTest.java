/*
 * @(#)DTOFieldNameTest.java		1.0 10/07/2014
 */

package ar.com.agea.hub.rol.utils;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para el enum DTOFieldName.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/07/2014
 */
public class DTOFieldNameTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo DTOFieldName.
	 */
	@Test
	public void testPalabraClaveConstructor() {
		DTOFieldName dtoFieldName = DTOFieldName.PALABRA_CLAVE; 
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"DTOFieldName\".",
				dtoFieldName);
	}
	
	/**
	 * Comprueba la ejecución de método getName del enum DTOFieldName. 
	 */
	@Test
	public void testGetNameMethod() {
		DTOFieldName dtoFieldName = DTOFieldName.PALABRA_CLAVE;
		
		String tmp = dtoFieldName.getName();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"getName\" del \"DTOFieldName\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getName\" de la clase \"DTOFieldName\""
				+ " no corresponde al valor esperado.", "palabraClave", tmp);
	}
}
