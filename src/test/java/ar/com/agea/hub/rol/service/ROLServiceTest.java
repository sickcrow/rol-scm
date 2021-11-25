/*
 * @(#)CommonServiceTest.java		1.0 14/08/2013
 */

package ar.com.agea.hub.rol.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.agea.hub.rol.common.FileName;
import ar.com.agea.hub.rol.common.GenericTestException;
import ar.com.agea.hub.rol.common.ServiceTest;
import ar.com.agea.hub.rol.exception.ServiceException;
import ar.com.agea.hub.rol.model.dto.ItemOrdenamientoAvisoSearchDTO;
import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;
import ar.com.agea.hub.rol.model.dto.ProvinciaDTO;
import ar.com.agea.hub.rol.model.result.ROLResult;

/**
 * Representa JUnit Tests de acceso a los servicios GWP.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 14/08/2013
 */
public class ROLServiceTest extends ServiceTest {

	@Autowired
	private ROLService rolService;

	@Test
	public void testTemporal() {}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio registrarUsuario
	 * obteniendo valores con errores.
	 */
//	@Test
	public void testRegistrarUsuarioWithErrors() {
		ROLResult output = null;
		
		OrdenPublicacionDTO input = getJSON(FileName.TEST_EXECUTE_PAGAR_AND_GUARDAR_WITH_ERRORS, OrdenPublicacionDTO.class);
		
		try {
			output = rolService.executePagarAndGuardar(input);
		} catch (Exception e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio GWP.", e);
		}
		
		Assert.assertNotNull("El servicio registrarUsuario ha devuelto un valor null.", output);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getOrdenesPublicacionByCapturador
	 * obteniendo valores sin errores.
	 */
//	@Test
//	@SuppressWarnings("unchecked")
//	public void testGetOrdenesPublicacionByCapturadorWithoutErrors() {
//		boolean isServiceException = false;
//		ROLResult output = null;
//		
//		CapturadorCRUDDTO input = getJSON(FileName.TEST_GET_ORDENES_PUBLICACION_BY_USUARIO_WITHOUT_ERRORS, CapturadorCRUDDTO.class);
//			
//		try {
//			output = rolService.getOrdenesPublicacionByCapturador(input);
//		} catch (ServiceException e) {
//			isServiceException = true;
//		}
//
//		Assert.assertTrue("El servicio getOrdenesPublicacionByCapturador no ha devuelto ningún valor.", isServiceException);
//	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getItemsOrdenamientoAviso
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testFirstGetItemsOrdenamientoAvisoWithException() {
		String serviceName = "\"getItemsOrdenamientoAviso\"";
		
		boolean isServiceException = false;
		
		ItemOrdenamientoAvisoSearchDTO input = getJSON(FileName.TEST_FIRST_GET_ITEMS_ORDENAMIENTO_AVISO_WITH_EXCEPTION, ItemOrdenamientoAvisoSearchDTO.class);
		
		try {
			rolService.getItemsOrdenamientoAviso(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getItemsOrdenamientoAviso
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testSecondGetItemsOrdenamientoAvisoWithException() {
		String serviceName = "\"getItemsOrdenamientoAviso\"";
		
		boolean isServiceException = false;
		
		ItemOrdenamientoAvisoSearchDTO input = getJSON(FileName.TEST_SECOND_GET_ITEMS_ORDENAMIENTO_AVISO_WITH_EXCEPTION, ItemOrdenamientoAvisoSearchDTO.class);
		
		try {
			rolService.getItemsOrdenamientoAviso(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getItemsOrdenamientoAviso
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testFirstGetItemsOrdenamientoAvisoWithoutErrors() {
		String serviceName = "\"getItemsOrdenamientoAviso\"";
		
		ROLResult output = null;
		
		ItemOrdenamientoAvisoSearchDTO input = getJSON(FileName.TEST_FIRST_GET_ITEMS_ORDENAMIENTO_AVISO_WITHOUT_ERRORS, ItemOrdenamientoAvisoSearchDTO.class);
		
		try {
			output = rolService.getItemsOrdenamientoAviso(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}
		
		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getItemsOrdenamientoAviso
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testSecondGetItemsOrdenamientoAvisoWithoutErrors() {
		String serviceName = "\"getItemsOrdenamientoAviso\"";
		
		ROLResult output = null;
		
		ItemOrdenamientoAvisoSearchDTO input = getJSON(FileName.TEST_SECOND_GET_ITEMS_ORDENAMIENTO_AVISO_WITHOUT_ERRORS, ItemOrdenamientoAvisoSearchDTO.class);
		
		try {
			output = rolService.getItemsOrdenamientoAviso(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}
		
		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
	}
	
	@Test
	public void testFirstGetLocalidadesWithoutErrors() {
		String serviceName = "\"getLocalidades\"";
		
		ROLResult output = null;
		
//		ItemOrdenamientoAvisoSearchDTO input = getJSON(FileName.TEST_SECOND_GET_ITEMS_ORDENAMIENTO_AVISO_WITHOUT_ERRORS, ItemOrdenamientoAvisoSearchDTO.class);
		
		ProvinciaDTO input = new ProvinciaDTO();
//		input.setCodigo("CAPITAL FEDERAL");
		input.setCodigo("BUENOS AIRES");
		
		try {
			output = rolService.getLocalidades(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}
		
		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
	}
}
