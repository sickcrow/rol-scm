/*
 * @(#)UpdateEstadoAvisoDTOTest.java		1.0 27/05/2014
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase UpdateEstadoAvisoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 27/05/2014
 */
public class UpdateEstadoAvisoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo UpdateEstadoAvisoDTO.
	 */
	@Test
	public void testConstructor() {
		UpdateEstadoAvisoDTO dto = new UpdateEstadoAvisoDTO();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"UpdateEstadoAvisoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setIdAviso y getIdAviso de la clase UpdateEstadoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetIdAvisoMethod() {
		UpdateEstadoAvisoDTO dto = new UpdateEstadoAvisoDTO();
		Long idAviso = 300L;
		
		dto.setIdAviso(idAviso);
		
		Long tmp = dto.getIdAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setIdAviso\" o \"getIdAviso\" de la clase \"UpdateEstadoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getIdAviso\" de la clase \"UpdateEstadoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", idAviso, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setAccion y getAccion de la clase UpdateEstadoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetAccionMethod() {
		UpdateEstadoAvisoDTO dto = new UpdateEstadoAvisoDTO();
		String accion = "ACCION";
		
		dto.setAccion(accion);
		
		String tmp = dto.getAccion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setAccion\" o \"getAccion\" de la clase \"UpdateEstadoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getAccion\" de la clase \"UpdateEstadoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", accion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todos setMotivoRechazo y getMotivoRechazo de la clase UpdateEstadoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetMotivoRechazoMethod() {
		UpdateEstadoAvisoDTO dto = new UpdateEstadoAvisoDTO();
		String motivoRechazo = "MOTIVO_RECHAZO";
		
		dto.setMotivoRechazo(motivoRechazo);
		
		String tmp = dto.getMotivoRechazo();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setMotivoRechazo\" o \"getMotivoRechazo\" de la clase \"UpdateEstadoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getMotivoRechazo\" de la clase \"UpdateEstadoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", motivoRechazo, tmp);
	}

	/**
	 * Comprueba la ejecuci�n de m�todos setObservacion y getObservacion de la clase UpdateEstadoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetObservacionMethod() {
		UpdateEstadoAvisoDTO dto = new UpdateEstadoAvisoDTO();
		String observacion = "OBSERVACION";
		
		dto.setObservacion(observacion);
		
		String tmp = dto.getObservacion();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"setObservacion\" o \"getObservacion\" de la clase \"UpdateEstadoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el m�todo \"getObservacion\" de la clase \"UpdateEstadoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", observacion, tmp);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo toString de la clase UpdateEstadoAvisoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		UpdateEstadoAvisoDTO dto = new UpdateEstadoAvisoDTO();

		dto.setIdAviso(300L);
		dto.setAccion("ACCION");
		dto.setMotivoRechazo("MOTIVO_RECHAZO");
		dto.setObservacion("OBSERVACION");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"toString\" de la clase \"UpdateEstadoAvisoDTO\".", tmp);
	}
}
