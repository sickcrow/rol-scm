/*
 * @(#)TarjetasPagoHUBResultTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.TarjetaPagoDTO;

/**
 * Representa JUnit Tests de inicialización para la clase TarjetasPagoHUBResult.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class TarjetasPagoHUBResultTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo TarjetasPagoHUBResult.
	 */
	@Test
	public void testConstructor() {
		TarjetasPagoHUBResult result = new TarjetasPagoHUBResult();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"TarjetasPagoHUBResult\""
				+ " utilizando el constructor por defecto.", result);
	}

	/**
	 * Comprueba la ejecución de métodos setObject y getObject de la clase TarjetasPagoHUBResult. 
	 */
	@Test
	public void testSetAndGetObjectMethod() {
		TarjetasPagoHUBResult result = new TarjetasPagoHUBResult();
		
		List<TarjetaPagoDTO> tarjetasPago = new ArrayList<TarjetaPagoDTO>();
		
		result.setObject(tarjetasPago);
		
		tarjetasPago = result.getObject();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObject\" o \"getObject\" de la clase \"TarjetasPagoHUBResult\".",
				tarjetasPago);
	}
	
	/**
	 * Comprueba la ejecución de métodos setErrors y getErrors de la clase TarjetasPagoHUBResult. 
	 */
	@Test
	public void testSetAndGetErrorsMethod() {
		TarjetasPagoHUBResult result = new TarjetasPagoHUBResult();
		
		Set<HUBError> errors = new HashSet<HUBError>();
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		
		result.setErrors(errors);
		
		errors = result.getErrors();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setErrors\" o \"getErrors\" de la clase \"TarjetasPagoHUBResult\".",
				errors);
	}
	
	/**
	 * Comprueba la ejecución de método hasErrors de la clase TarjetasPagoHUBResult. 
	 */
	@Test
	public void testHasErrorsMethod() {
		TarjetasPagoHUBResult result = new TarjetasPagoHUBResult();
		
		Set<HUBError> errors = null;
		
		result.setErrors(errors);
		
		boolean hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"TarjetasPagoHUBResult\".",
				hasErrors);
		
		errors = new HashSet<HUBError>();
		
		result.setErrors(errors);
		hasErrors = result.hasErrors();
		
		Assert.assertFalse("Ha fallado la llamada al método \"hasErrors\" de la clase \"TarjetasPagoHUBResult\".",
				hasErrors);
		
		HUBError error = new HUBError();
		
		error.setErrorType(HUBErrorType.NULLED_VALUE);
		error.setMessage("MENSAJE");
		errors.add(error);
		
		result.setErrors(errors);
		
		hasErrors = result.hasErrors();
		
		Assert.assertTrue("Ha fallado la llamada al método \"hasErrors\" de la clase \"TarjetasPagoHUBResult\".",
				hasErrors);
	}
}
