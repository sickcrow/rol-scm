/*
 * @(#)ROLResultGWPBuilderTest.java		1.0 03/09/2013
 */

package ar.com.agea.hub.rol.utils;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.result.ROLResult;

/**
 * Representa JUnit Tests de inicialización para la clase ROLResultGWPBuilder.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 03/09/2013
 */
public class ROLResultGWPBuilderTest extends InstantiationTest {

	/**
	 * Comprueba la ejecución de métodos buildROLResult, buildData y getResult de la clase ROLResultGWPBuilder
	 * con errores. 
	 */
	@Test
	public void testROLResultGWPBuilderWithErrors() {
		ROLResultGWPBuilder builder = new ROLResultGWPBuilder();
		
		builder.buildROLResult();
		
		builder.buildData("<data-html></data-html>");
		
		ROLResult rolResult = builder.getResult();
		
		Assert.assertNotNull("El valor retornado por el método \"getResult\" de la clase ROLResultGWPBuilder es nulo.",
				rolResult);
		Assert.assertTrue("El valor retornado por el método \"hasErrors\" de la clase ROLResult retornado por la clase ROLResultGWPBuilder"
				+ " no es falso.", rolResult.hasErrors());
		Assert.assertNull("El valor retornado por el método \"getObject\" de la clase ROLResult retornado por la clase ROLResultGWPBuilder"
				+ " no es falso.", rolResult.getObject());
	}
	
	/**
	 * Comprueba la ejecución de métodos buildROLResult, buildData y getResult de la clase ROLResultGWPBuilder
	 * sin errores. 
	 */
	@Test
	public void testROLResultGWPBuilderWithoutErrors() {
		ROLResultGWPBuilder builder = new ROLResultGWPBuilder();
		
		builder.buildROLResult();
		
		builder.buildData("<html></html>");
		
		ROLResult rolResult = builder.getResult();
		
		Assert.assertNotNull("El valor retornado por el método \"getResult\" de la clase ROLResultGWPBuilder es nulo.",
				rolResult);
		Assert.assertFalse("El valor retornado por el método \"hasErrors\" de la clase ROLResult retornado por la clase ROLResultGWPBuilder"
				+ " no es falso.", rolResult.hasErrors());
		Assert.assertNotNull("El valor retornado por el método \"getObject\" de la clase ROLResult retornado por la clase ROLResultGWPBuilder"
				+ " no es falso.", rolResult.getObject());
	}
}
