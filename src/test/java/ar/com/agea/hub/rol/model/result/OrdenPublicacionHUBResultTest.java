/*
 * @(#)OrdenPublicacionHUBResultTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;

/**
 * Representa JUnit Tests de inicialización para la clase OrdenPublicacionResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class OrdenPublicacionHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo OrdenPublicacionResult.
	 */
	@Test
	public void testConstructor() {
		OrdenPublicacionHUBResult result = new OrdenPublicacionHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"OrdenPublicacionResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase OrdenPublicacionResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		OrdenPublicacionHUBResult result = new OrdenPublicacionHUBResult();
		
		OrdenPublicacionDTO ordenPublicacion = new OrdenPublicacionDTO();
		
		result.setObject(ordenPublicacion);
		
		ordenPublicacion = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"OrdenPublicacionResult\".",
				ordenPublicacion);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase OrdenPublicacionResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		OrdenPublicacionHUBResult result = new OrdenPublicacionHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"OrdenPublicacionResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase OrdenPublicacionResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		OrdenPublicacionHUBResult result = new OrdenPublicacionHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"OrdenPublicacionResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"OrdenPublicacionResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"OrdenPublicacionResult\".",
				hasErrors);
	}
}
