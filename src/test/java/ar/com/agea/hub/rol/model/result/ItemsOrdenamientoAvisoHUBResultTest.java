/*
 * @(#)ItemsOrdenamientoAvisoHUBResultTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ItemOrdenamientoAvisoDTO;

/**
 * Representa JUnit Tests de inicialización para la clase ItemsOrdenamientoAvisoResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ItemsOrdenamientoAvisoHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ItemsOrdenamientoAvisoResult.
	 */
	@Test
	public void testConstructor() {
		ItemsOrdenamientoAvisoHUBResult result = new ItemsOrdenamientoAvisoHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ItemsOrdenamientoAvisoResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase ItemsOrdenamientoAvisoResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		ItemsOrdenamientoAvisoHUBResult result = new ItemsOrdenamientoAvisoHUBResult();
		
		List<ItemOrdenamientoAvisoDTO> itemsOrdenamientoAviso = new ArrayList<ItemOrdenamientoAvisoDTO>(); 
		
		result.setObject(itemsOrdenamientoAviso);
		
		itemsOrdenamientoAviso = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"ItemsOrdenamientoAvisoResult\".",
				itemsOrdenamientoAviso);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase ItemsOrdenamientoAvisoResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		ItemsOrdenamientoAvisoHUBResult result = new ItemsOrdenamientoAvisoHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"ItemsOrdenamientoAvisoResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase ItemsOrdenamientoAvisoResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		ItemsOrdenamientoAvisoHUBResult result = new ItemsOrdenamientoAvisoHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ItemsOrdenamientoAvisoResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ItemsOrdenamientoAvisoResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"ItemsOrdenamientoAvisoResult\".",
				hasErrors);
	}
}
