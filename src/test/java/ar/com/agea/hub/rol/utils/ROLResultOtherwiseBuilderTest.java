/*
 * @(#)ROLResultOtherwiseBuilderTest.java		1.0 03/09/2013
 */

package ar.com.agea.hub.rol.utils;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.result.ROLResult;

/**
 * Representa JUnit Tests de inicializaci�n para la clase ROLResultOtherwiseBuilder.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 03/09/2013
 */
public class ROLResultOtherwiseBuilderTest extends InstantiationTest {

	/**
	 * Comprueba la ejecuci�n de m�todos buildROLResult, buildData y getResult de la clase ROLResultOtherwiseBuilder
	 * sin errores. 
	 */
	@Test
	public void testFirstROLResultHUBBuilderWithoutErrors() {
		ROLResultOtherwiseBuilder builder = new ROLResultOtherwiseBuilder();
		
		builder.buildROLResult();
		
		String result = "VALUE";
		
		builder.buildData(result);
		
		ROLResult rolResult = builder.getResult();
		
		Assert.assertNotNull("El valor retornado por el m�todo \"getResult\" de la clase ROLResultOtherwiseBuilder es nulo.",
				rolResult);
		Assert.assertFalse("El valor retornado por el m�todo \"hasErrors\" de la clase ROLResult retornado por la clase ROLResultOtherwiseBuilder"
				+ " no es falso.", rolResult.hasErrors());
		Assert.assertNotNull("El valor retornado por el m�todo \"getObject\" de la clase ROLResult retornado por la clase ROLResultOtherwiseBuilder"
				+ " no es falso.", rolResult.getObject());
	}
}
