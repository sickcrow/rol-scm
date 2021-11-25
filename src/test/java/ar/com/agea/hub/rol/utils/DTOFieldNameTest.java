/*
 * @(#)DTOFieldNameTest.java		1.0 10/07/2014
 */

package ar.com.agea.hub.rol.utils;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para el enum DTOFieldName.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/07/2014
 */
public class DTOFieldNameTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo DTOFieldName.
	 */
	@Test
	public void testPalabraClaveConstructor() {
		DTOFieldName dtoFieldName = DTOFieldName.PALABRA_CLAVE; 
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"DTOFieldName\".",
				dtoFieldName);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo getName del enum DTOFieldName. 
	 */
	@Test
	public void testGetNameMethod() {
		DTOFieldName dtoFieldName = DTOFieldName.PALABRA_CLAVE;
		
		String tmp = dtoFieldName.getName();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"getName\" del \"DTOFieldName\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getName\" de la clase \"DTOFieldName\""
				+ " no corresponde al valor esperado.", "palabraClave", tmp);
	}
}
