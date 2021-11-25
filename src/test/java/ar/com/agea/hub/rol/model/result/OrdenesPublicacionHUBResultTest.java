/*
 * @(#)OrdenesPublicacionHUBResultTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;

/**
 * Representa JUnit Tests de inicialización para la clase OrdenesPublicacionHUBResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class OrdenesPublicacionHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo OrdenesPublicacionHUBResult.
	 */
	@Test
	public void testConstructor() {
		OrdenesPublicacionHUBResult result = new OrdenesPublicacionHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"OrdenesPublicacionHUBResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase OrdenesPublicacionHUBResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		OrdenesPublicacionHUBResult result = new OrdenesPublicacionHUBResult();
		
		List<OrdenPublicacionDTO> ordenesPublicacion = new ArrayList<OrdenPublicacionDTO>();
		
		result.setObject(ordenesPublicacion);
		
		ordenesPublicacion = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"OrdenesPublicacionHUBResult\".",
				ordenesPublicacion);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase OrdenesPublicacionHUBResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		OrdenesPublicacionHUBResult result = new OrdenesPublicacionHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"OrdenesPublicacionHUBResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase OrdenesPublicacionHUBResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		OrdenesPublicacionHUBResult result = new OrdenesPublicacionHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"OrdenesPublicacionHUBResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"OrdenesPublicacionHUBResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"OrdenesPublicacionHUBResult\".",
				hasErrors);
	}
}
