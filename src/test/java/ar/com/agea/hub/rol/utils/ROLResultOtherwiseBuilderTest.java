/*
 * @(#)ROLResultOtherwiseBuilderTest.java		1.0 03/09/2013
 */

package ar.com.agea.hub.rol.utils;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.result.ROLResult;

/**
 * Representa JUnit Tests de inicialización para la clase ROLResultOtherwiseBuilder.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 03/09/2013
 */
public class ROLResultOtherwiseBuilderTest extends InstantiationTest {

	/**
	 * Comprueba la ejecución de métodos buildROLResult, buildData y getResult de la clase ROLResultOtherwiseBuilder
	 * sin errores. 
	 */
	@Test
	public void testFirstROLResultHUBBuilderWithoutErrors() {
		ROLResultOtherwiseBuilder builder = new ROLResultOtherwiseBuilder();
		
		builder.buildROLResult();
		
		String result = "VALUE";
		
		builder.buildData(result);
		
		ROLResult rolResult = builder.getResult();
		
		Assert.assertNotNull("El valor retornado por el método \"getResult\" de la clase ROLResultOtherwiseBuilder es nulo.",
				rolResult);
		Assert.assertFalse("El valor retornado por el método \"hasErrors\" de la clase ROLResult retornado por la clase ROLResultOtherwiseBuilder"
				+ " no es falso.", rolResult.hasErrors());
		Assert.assertNotNull("El valor retornado por el método \"getObject\" de la clase ROLResult retornado por la clase ROLResultOtherwiseBuilder"
				+ " no es falso.", rolResult.getObject());
	}
}
