/*
 * @(#)ROLResultHUBBuilderTest.java		1.0 03/09/2013
 */

package ar.com.agea.hub.rol.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.result.HUBError;
import ar.com.agea.hub.rol.model.result.HUBErrorType;
import ar.com.agea.hub.rol.model.result.IntegersHUBResult;
import ar.com.agea.hub.rol.model.result.ROLResult;

/**
 * Representa JUnit Tests de inicialización para la clase ROLResultHUBBuilder.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 03/09/2013
 */
public class ROLResultHUBBuilderTest extends InstantiationTest {

	/**
	 * Comprueba la ejecución de métodos buildROLResult, buildData y getResult de la clase ROLResultHUBBuilder
	 * con errores. 
	 */
	@Test
	public void testROLResultHUBBuilderWithErrors() {
		ROLResultHUBBuilder builder = new ROLResultHUBBuilder();
		
		builder.buildROLResult();
		
		IntegersHUBResult hubResult = new IntegersHUBResult();
		
		Set<HUBError> hubErrors = new HashSet<HUBError>();
		
		HUBError hubError = new HUBError();
		
		hubError.setErrorType(HUBErrorType.NULLED_VALUE);
		hubError.setMessage("El valor es nulo.");
		
		hubErrors.add(hubError);
		
		hubResult.setErrors(hubErrors);
		
		builder.buildData(hubResult, null);
		
		ROLResult rolResult = builder.getResult();
		
		Assert.assertNotNull("El valor retornado por el método \"getResult\" de la clase ROLResultHUBBuilder es nulo.",
				rolResult);
		Assert.assertTrue("El valor retornado por el método \"hasErrors\" de la clase ROLResult retornado por la clase ROLResultHUBBuilder"
				+ " no es falso.", rolResult.hasErrors());
		Assert.assertNull("El valor retornado por el método \"getObject\" de la clase ROLResult retornado por la clase ROLResultHUBBuilder"
				+ " no es falso.", rolResult.getObject());
	}

	/**
	 * Comprueba la ejecución de métodos buildROLResult, buildData y getResult de la clase ROLResultHUBBuilder
	 * sin errores. 
	 */
	@Test
	public void testFirstROLResultHUBBuilderWithoutErrors() {
		ROLResultHUBBuilder builder = new ROLResultHUBBuilder();
		
		builder.buildROLResult();
		
		IntegersHUBResult hubResult = new IntegersHUBResult();
		
		List<Integer> integers = new ArrayList<Integer>();
		
		integers.add(3);
		
		hubResult.setObject(integers);
		
		builder.buildData(hubResult, null);
		
		ROLResult rolResult = builder.getResult();
		
		Assert.assertNotNull("El valor retornado por el método \"getResult\" de la clase ROLResultHUBBuilder es nulo.",
				rolResult);
		Assert.assertFalse("El valor retornado por el método \"hasErrors\" de la clase ROLResult retornado por la clase ROLResultHUBBuilder"
				+ " no es falso.", rolResult.hasErrors());
		Assert.assertNotNull("El valor retornado por el método \"getObject\" de la clase ROLResult retornado por la clase ROLResultHUBBuilder"
				+ " no es falso.", rolResult.getObject());
	}
	
	/**
	 * Comprueba la ejecución de métodos buildROLResult, buildData y getResult de la clase ROLResultHUBBuilder
	 * sin errores. 
	 */
	@Test
	public void testSecondROLResultHUBBuilderWithoutErrors() {
		ROLResultHUBBuilder builder = new ROLResultHUBBuilder();
		
		builder.buildROLResult();
		
		IntegersHUBResult hubResult = new IntegersHUBResult();
		
		builder.buildData(hubResult, URLServiceName.HUB_GET_CARACTERES_INVALIDOS_JUSTIFICACION);
		
		ROLResult rolResult = builder.getResult();
		
		Assert.assertNotNull("El valor retornado por el método \"getResult\" de la clase ROLResultHUBBuilder es nulo.",
				rolResult);
		Assert.assertFalse("El valor retornado por el método \"hasErrors\" de la clase ROLResult retornado por la clase ROLResultHUBBuilder"
				+ " no es falso.", rolResult.hasErrors());
		Assert.assertNotNull("El valor retornado por el método \"getObject\" de la clase ROLResult retornado por la clase ROLResultHUBBuilder"
				+ " no es falso.", rolResult.getObject());
	}
}
