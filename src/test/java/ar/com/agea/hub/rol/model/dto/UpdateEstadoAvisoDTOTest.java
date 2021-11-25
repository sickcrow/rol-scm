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
 * Representa JUnit Tests de inicialización para la clase UpdateEstadoAvisoDTO.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 27/05/2014
 */
public class UpdateEstadoAvisoDTOTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo UpdateEstadoAvisoDTO.
	 */
	@Test
	public void testConstructor() {
		UpdateEstadoAvisoDTO dto = new UpdateEstadoAvisoDTO();
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"UpdateEstadoAvisoDTO\""
				+ " utilizando el constructor por defecto.", dto);
	}

	/**
	 * Comprueba la ejecución de métodos setIdAviso y getIdAviso de la clase UpdateEstadoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetIdAvisoMethod() {
		UpdateEstadoAvisoDTO dto = new UpdateEstadoAvisoDTO();
		Long idAviso = 300L;
		
		dto.setIdAviso(idAviso);
		
		Long tmp = dto.getIdAviso();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setIdAviso\" o \"getIdAviso\" de la clase \"UpdateEstadoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getIdAviso\" de la clase \"UpdateEstadoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", idAviso, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setAccion y getAccion de la clase UpdateEstadoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetAccionMethod() {
		UpdateEstadoAvisoDTO dto = new UpdateEstadoAvisoDTO();
		String accion = "ACCION";
		
		dto.setAccion(accion);
		
		String tmp = dto.getAccion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setAccion\" o \"getAccion\" de la clase \"UpdateEstadoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getAccion\" de la clase \"UpdateEstadoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", accion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de métodos setMotivoRechazo y getMotivoRechazo de la clase UpdateEstadoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetMotivoRechazoMethod() {
		UpdateEstadoAvisoDTO dto = new UpdateEstadoAvisoDTO();
		String motivoRechazo = "MOTIVO_RECHAZO";
		
		dto.setMotivoRechazo(motivoRechazo);
		
		String tmp = dto.getMotivoRechazo();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setMotivoRechazo\" o \"getMotivoRechazo\" de la clase \"UpdateEstadoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getMotivoRechazo\" de la clase \"UpdateEstadoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", motivoRechazo, tmp);
	}

	/**
	 * Comprueba la ejecución de métodos setObservacion y getObservacion de la clase UpdateEstadoAvisoDTO. 
	 */
	@Test
	public void testSetAndGetObservacionMethod() {
		UpdateEstadoAvisoDTO dto = new UpdateEstadoAvisoDTO();
		String observacion = "OBSERVACION";
		
		dto.setObservacion(observacion);
		
		String tmp = dto.getObservacion();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"setObservacion\" o \"getObservacion\" de la clase \"UpdateEstadoAvisoDTO\".",
				tmp);
		Assert.assertEquals("El valor retornado por el método \"getObservacion\" de la clase \"UpdateEstadoAvisoDTO\""
				+ " no corresponde al valor enviado como argumento.", observacion, tmp);
	}
	
	/**
	 * Comprueba la ejecución de método toString de la clase UpdateEstadoAvisoDTO. 
	 */
	@Test
	public void testToStringMethod() {
		UpdateEstadoAvisoDTO dto = new UpdateEstadoAvisoDTO();

		dto.setIdAviso(300L);
		dto.setAccion("ACCION");
		dto.setMotivoRechazo("MOTIVO_RECHAZO");
		dto.setObservacion("OBSERVACION");
		
		String tmp = dto.toString();
		
		Assert.assertNotNull("Ha fallado la llamada al método \"toString\" de la clase \"UpdateEstadoAvisoDTO\".", tmp);
	}
}
