/*
 * @(#)ItemsOrdenamientoAvisoGroupHUBResultTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.ItemOrdenamientoAvisoGroupDTO;

/**
 * Representa JUnit Tests de inicialización para la clase ItemsOrdenamientoAvisoGroupHUBResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ItemsOrdenamientoAvisoGroupHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo ItemsOrdenamientoAvisoGroupHUBResult.
	 */
	@Test
	public void testConstructor() {
		ItemsOrdenamientoAvisoGroupHUBResult result = new ItemsOrdenamientoAvisoGroupHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"ItemsOrdenamientoAvisoGroupHUBResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase ItemsOrdenamientoAvisoGroupHUBResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		ItemsOrdenamientoAvisoGroupHUBResult result = new ItemsOrdenamientoAvisoGroupHUBResult();
		
		List<ItemOrdenamientoAvisoGroupDTO> itemsOrdenamientoAvisoGroup = new ArrayList<ItemOrdenamientoAvisoGroupDTO>();
		
		result.setObject(itemsOrdenamientoAvisoGroup);
		
		itemsOrdenamientoAvisoGroup = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"ItemsOrdenamientoAvisoGroupHUBResult\".",
				itemsOrdenamientoAvisoGroup);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase ItemsOrdenamientoAvisoGroupHUBResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		ItemsOrdenamientoAvisoGroupHUBResult result = new ItemsOrdenamientoAvisoGroupHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"ItemsOrdenamientoAvisoGroupHUBResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase ItemsOrdenamientoAvisoGroupHUBResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		ItemsOrdenamientoAvisoGroupHUBResult result = new ItemsOrdenamientoAvisoGroupHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ItemsOrdenamientoAvisoGroupHUBResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"ItemsOrdenamientoAvisoGroupHUBResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"ItemsOrdenamientoAvisoGroupHUBResult\".",
				hasErrors);
	}
}
