/*
 * @(#)ProductoServiceTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.service;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.agea.hub.rol.common.FileName;
import ar.com.agea.hub.rol.common.GenericTestException;
import ar.com.agea.hub.rol.common.ServiceTest;
import ar.com.agea.hub.rol.exception.ServiceException;
import ar.com.agea.hub.rol.model.dto.CalendarioSearchDTO;
import ar.com.agea.hub.rol.model.dto.CapturadorCRUDDTO;
import ar.com.agea.hub.rol.model.dto.ClaseSearchDTO;
import ar.com.agea.hub.rol.model.dto.ConceptoVendibleDTO;
import ar.com.agea.hub.rol.model.dto.ItemOrdenamientoAvisoSearchDTO;
import ar.com.agea.hub.rol.model.dto.JustificacionDTO;
import ar.com.agea.hub.rol.model.dto.NivelEstructuraSearchDTO;
import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;
import ar.com.agea.hub.rol.model.dto.OrdenamientoAvisoSearchDTO;
import ar.com.agea.hub.rol.model.dto.ProductoComercialDTO;
import ar.com.agea.hub.rol.model.dto.ProductoComercialDefaultDTO;
import ar.com.agea.hub.rol.model.dto.ProductoSearchDTO;
import ar.com.agea.hub.rol.model.dto.PromocionSearchDTO;
import ar.com.agea.hub.rol.model.dto.PropiedadDefaultDTO;
import ar.com.agea.hub.rol.model.dto.PropiedadDefaultSearchDTO;
import ar.com.agea.hub.rol.model.dto.TarjetaPagoSearchDTO;
import ar.com.agea.hub.rol.model.dto.TextoValidateDTO;
import ar.com.agea.hub.rol.model.dto.TipoOperacionSearchDTO;
import ar.com.agea.hub.rol.model.dto.ZonaComercializacionSearchDTO;
import ar.com.agea.hub.rol.model.result.ROLResult;

/**
 * Representa JUnit Tests de acceso a los servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class HUBServiceTest extends ServiceTest {

	@Autowired
	private HUBService hubService;
	
	// Servicios pertenecientes a Cliente.
	/**
	 * Comprueba el envío y recepción de objetos al servicio saveCapturador
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testSaveCapturadorWithoutErrors() {
		ROLResult output = null;
		
		CapturadorCRUDDTO input = new CapturadorCRUDDTO();
		input.setCodigoCliente("ROL");
		input.setCodigoTipoAnunciante("PARTICULAR");
		input.setEmail("usuario@correo.com");
		input.setNombre("Usuario");
		input.setApellido("Usuario");
		input.setCodigoMedioPagoPrincipal("TARJETA");
		input.setCodigoTipoIVA("CONSUMIDOR_FINAL");
		input.setCodigoCanalEntrada("ROL");
		input.setCodigoTipoDocumento("96");
		input.setNumeroDocumento(1234578L);
		input.setCodigoPerfilAnunciante("Otro");
		input.setUsuarioExternoCodigo("25163");
		
		try {
			output = hubService.saveCapturador(input);
		} catch (ServiceException e) {
			//throw new GenericTestException("Se produjo un error al acceder al servicio PASE.", e);
		}
		
		Assert.assertNull("El saveCapturador saveCapturador ha devuelto un valor null.", output);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio updateCapturador
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testUpdateCapturadorWithoutErrors() {
		ROLResult output = null;
		
		CapturadorCRUDDTO input = new CapturadorCRUDDTO();
		input.setCodigoAnunciante(8253L);
		input.setCodigoCliente("ROL");
		input.setCodigoTipoAnunciante("PARTICULAR");
		input.setEmail("usuario@correo.com");
		input.setNombre("Usuario");
		input.setApellido("Usuario");
		input.setCodigoMedioPagoPrincipal("TARJETA");
		input.setCodigoTipoIVA("CONSUMIDOR_FINAL");
		input.setCodigoCanalEntrada("ROL");
		input.setCodigoTipoDocumento("96");
		input.setNumeroDocumento(1234578L);
		
		try {
			output = hubService.updateCapturador(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio PASE.", e);
		}
		
		Assert.assertNotNull("El saveCapturador updateCapturador ha devuelto un valor null.", output);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getCapturador
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testGetCapturadorWithoutErrors() {
		ROLResult output = null;
		
		CapturadorCRUDDTO input = new CapturadorCRUDDTO();
		input.setEmail("roltest@yopmail.com");
		input.setUsuarioExternoCodigo("5074");
		
		
		try {
			output = hubService.getCapturador(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio PASE.", e);
		}
		
		Assert.assertNotNull("El servicio getCapturador ha devuelto un valor null.", output);
	}
	
	// Servicios pertenecientes a Common.
	/**
	 * Comprueba el envío y recepción de objetos al servicio getCaracteresInvalidosJustificacion
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testFirstGetCaracteresInvalidosJustificacionWithoutErrors() {
		String serviceName = "\"getCaracteresInvalidosJustificacion\"";
		
		ROLResult output = null;
		
		try {
			output = hubService.getCaracteresInvalidosJustificacion();
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}
		
		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getCaracteresInvalidosJustificacion
	 * obteniendo valores sin errores.
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testSecondGetCaracteresInvalidosJustificacionWithoutErrors() {
		String serviceName = "\"getCaracteresInvalidosJustificacion\"";
		
		ROLResult output = null;
		
		try {
			output = hubService.getCaracteresInvalidosJustificacion();
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}
		
		int invalidCharacter = (int) '<';
		int validCharacter = (int) 'A';
		
		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
		Assert.assertTrue(serviceName + ": se ha encontrado un caracter inválido entre los valores devueltos.",
				((List<Integer>) output.getObject()).contains(Integer.valueOf(invalidCharacter)));
		Assert.assertFalse(serviceName + ": se ha encontrado un caracter válido entre los valores devueltos.",
				((List<Integer>) output.getObject()).contains(Integer.valueOf(validCharacter)));
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getPropiedadesDefault
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testGetPropiedadesDefaultWithException() {
		String serviceName = "\"getPropiedadesDefault\"";
		
		boolean isServiceException = false;
		
		PropiedadDefaultSearchDTO input = getJSON(FileName.TEST_GET_PROPIEDADES_DEFAULT_WITH_EXCEPTION, PropiedadDefaultSearchDTO.class);
		
		try {
			hubService.getPropiedadesDefault(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getPropiedadesDefault
	 * obteniendo valores sin errores.
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testGetPropiedadesDefaultWithoutErrors() {
		String serviceName = "\"getCaracteresInvalidosJustificacion\"";
		
		ROLResult output = null;
		
		PropiedadDefaultSearchDTO input = getJSON(FileName.TEST_GET_PROPIEDADES_DEFAULT_WITHOUT_ERRORS, PropiedadDefaultSearchDTO.class);
		
		List<String> codigosPropiedadDefault = input.getCodigosPropiedadDefault();
		
		try {
			output = hubService.getPropiedadesDefault(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}
		
		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo \"List\".", output.getObject() instanceof List);
		
		for (PropiedadDefaultDTO propiedadDefault : (List<PropiedadDefaultDTO>) output.getObject()) {
			Assert.assertNotNull(serviceName + ": el valor \"código\" es null.", propiedadDefault.getCodigo());
			Assert.assertTrue(serviceName + ": el valor \"código\" no corresponde con el buscado.", codigosPropiedadDefault.contains(propiedadDefault.getCodigo()));
			Assert.assertNotNull(serviceName + ": el valor \"valor\" es null.", propiedadDefault.getValor());
		}
	}
	
	// Servicios pertenecientes a Interfaz Dinámica.
	/**
	 * Comprueba el envío y recepción de objetos al servicio getBienes
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testGetBienesWithException() {
		String serviceName = "\"getBienes\"";
		
		boolean isServiceException = false;
		
		ClaseSearchDTO input = getJSON(FileName.TEST_GET_BIENES_WITH_EXCEPTION, ClaseSearchDTO.class);
		
		try {
			hubService.getBienes(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getBienes
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testGetBienesWithoutErrors() {
		String serviceName = "\"getBienes\"";
		
		ROLResult output = null;
		
		ClaseSearchDTO input = getJSON(FileName.TEST_GET_BIENES_WITHOUT_ERRORS, ClaseSearchDTO.class);
		
		try {
			output = hubService.getBienes(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}

		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo \"List\".", output.getObject() instanceof List);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getFamilias
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testGetFamiliasWithException() {
		String serviceName = "\"getFamilias\"";
		
		boolean isServiceException = false;
		
		ClaseSearchDTO input = getJSON(FileName.TEST_GET_FAMILIAS_WITH_EXCEPTION, ClaseSearchDTO.class);
		
		try {
			hubService.getFamilias(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getFamilias
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testGetFamiliasWithoutErrors() {
		String serviceName = "\"getFamilias\"";
		
		ROLResult output = null;

		ClaseSearchDTO input = getJSON(FileName.TEST_GET_FAMILIAS_WITHOUT_ERRORS, ClaseSearchDTO.class);
			
		try {
			output = hubService.getFamilias(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}

		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
	}
	
	// Servicios pertenecientes a Aviso (Orden Publicación).
	/**
	 * Comprueba el envío y recepción de objetos al servicio getConfiguracionesOrdenamientoPantalla
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testGetConfiguracionesOrdenamientoPantallaWithException() {
		String serviceName = "\"getConfiguracionesOrdenamientoPantalla\"";
		
		boolean isServiceException = false;
		
		OrdenamientoAvisoSearchDTO input = getJSON(FileName.TEST_GET_CONFIGURACIONES_ORDENAMIENTO_PANTALLA_WITH_EXCEPTION, OrdenamientoAvisoSearchDTO.class);
		
		try {
			hubService.getConfiguracionesOrdenamientoPantalla(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getConfiguracionesOrdenamientoPantalla
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testGetConfiguracionesOrdenamientoPantallaWithoutErrors() {
		String serviceName = "\"getConfiguracionesOrdenamientoPantalla\"";
		
		ROLResult output = null;
		
		OrdenamientoAvisoSearchDTO input = getJSON(FileName.TEST_GET_CONFIGURACIONES_ORDENAMIENTO_PANTALLA_WITHOUT_ERRORS, OrdenamientoAvisoSearchDTO.class);
		
		try {
			output = hubService.getConfiguracionesOrdenamientoPantalla(input);
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
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testFirstGetItemsOrdenamientoAvisoWithException() {
		String serviceName = "\"getItemsOrdenamientoAviso\"";
		
		boolean isServiceException = false;
		
		ItemOrdenamientoAvisoSearchDTO input = getJSON(FileName.TEST_FIRST_GET_ITEMS_ORDENAMIENTO_AVISO_WITH_EXCEPTION, ItemOrdenamientoAvisoSearchDTO.class);
		
		try {
			hubService.getItemsOrdenamientoAviso(input);
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
			hubService.getItemsOrdenamientoAviso(input);
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
			output = hubService.getItemsOrdenamientoAviso(input);
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
			output = hubService.getItemsOrdenamientoAviso(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}
		
		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
	}
	
	// Servicios pertenecientes a Pretasador.
	/**
	 * Comprueba el envío y recepción de objetos al servicio executeTasar
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testExecuteTasarWithException() {
		String serviceName = "\"executeTasar\"";
		
		boolean isServiceException = false;
		
		OrdenPublicacionDTO input = getJSON(FileName.TEST_EXECUTE_TASAR_WITH_EXCEPTION, OrdenPublicacionDTO.class);
		
		try {
			hubService.executeTasar(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio executeTasar
	 * obteniendo valores sin errores.
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testExecuteTasarWithoutErrors() {
		String serviceName = "\"executeTasar\"";
		
		ROLResult output = null;
		
		OrdenPublicacionDTO input = getJSON(FileName.TEST_EXECUTE_TASAR_WITHOUT_ERRORS, OrdenPublicacionDTO.class);
		
		try {
			output = hubService.executeTasar(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}
		
		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
		
		for (ConceptoVendibleDTO conceptoVendible : (List<ConceptoVendibleDTO>) output.getObject()) {
		    // Tasación no devuelve valor en porcentaje IVA.
			Assert.assertNull(serviceName + ": el valor \"porcentaje IVA\" no es null.", conceptoVendible.getPorcentajeIVA());
			Assert.assertNotNull(serviceName + ": el valor \"monto sin IVA\" es null.", conceptoVendible.getMontoSinIVA());
			Assert.assertNotNull(serviceName + ": el valor \"monto IVA\" es null.", conceptoVendible.getMontoIVA());
			Assert.assertNotNull(serviceName + ": el valor \"monto percepción\" es null.", conceptoVendible.getMontoPercepcion());
			Assert.assertNotNull(serviceName + ": el valor \"monto total\" es null.", conceptoVendible.getMontoTotal());
		}
	}
	
	// Servicios pertenecientes a Producto.
	/**
	 * Comprueba el envío y recepción de objetos al servicio getCalendario
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testGetCalendarioWithException() {
		String serviceName = "\"getCalendario\"";
		
		boolean isServiceException = false;
		
		CalendarioSearchDTO input = getJSON(FileName.TEST_GET_CALENDARIO_WITH_EXCEPTION, CalendarioSearchDTO.class);
		
		try {
			hubService.getCalendario(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getCalendario
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testGetCalendarioWithoutErrors() {
		String serviceName = "\"getCalendario\"";
		
		ROLResult output = null;
		
		CalendarioSearchDTO input = getJSON(FileName.TEST_GET_CALENDARIO_WITHOUT_ERRORS, CalendarioSearchDTO.class);
		
		/*
		 * Substituye el valor de fecha vigencia en el archivo por la fecha de hoy debido a que
		 * existe una validación que requiere que fecha vigencia sea igual o mayor a la de hoy
		 * y por archivo es imposible realizarlo.
		 */
		input.setFechaVigencia(new Date());
		
		try {
			output = hubService.getCalendario(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}
		
		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getProductoComercialDefault
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testGetProductoComercialDefaultWithException() {
		String serviceName = "\"getProductoComercialDefault\"";
		
		boolean isServiceException = false;
		
		ProductoComercialDefaultDTO input = getJSON(FileName.TEST_GET_PRODUCTO_COMERCIAL_DEFAULT_WITH_EXCEPTION, ProductoComercialDefaultDTO.class);
			
		try {
			hubService.getProductoComercialDefault(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getProductoComercialDefault
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testFirstGetProductoComercialDefaultWithoutErrors() {
		String serviceName = "\"getProductoComercialDefault\"";
		
		ROLResult output = null; 
		
		ProductoComercialDefaultDTO input = getJSON(FileName.TEST_FIRST_GET_PRODUCTO_COMERCIAL_DEFAULT_WITHOUT_ERRORS, ProductoComercialDefaultDTO.class);
			
		try {
			output = hubService.getProductoComercialDefault(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}
		
		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNull(serviceName + ": se ha devuelto un resultado no null.", output.getObject());
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getProductoComercialDefault
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testSecondGetProductoComercialDefaultWithoutErrors() {
		String serviceName = "\"getProductoComercialDefault\"";
		
		ROLResult output = null;
		
		ProductoComercialDefaultDTO input = getJSON(FileName.TEST_SECOND_GET_PRODUCTO_COMERCIAL_DEFAULT_WITHOUT_ERRORS, ProductoComercialDefaultDTO.class);
			
		try {
			output = hubService.getProductoComercialDefault(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}
		
		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof ProductoComercialDefaultDTO);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getProductoComercial
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testGetProductoComercialWithException() {
		String serviceName = "\"getProductoComercial\"";
		
		boolean isServiceException = false;
		
		ProductoComercialDefaultDTO input = getJSON(FileName.TEST_GET_PRODUCTO_COMERCIAL_WITH_EXCEPTION, ProductoComercialDefaultDTO.class);
			
		try {
			hubService.getProductoComercial(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getProductoComercial
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testFirstGetProductoComercialWithoutErrors() {
		String serviceName = "\"getProductoComercial\"";
		
		ROLResult output = null; 
		
		ProductoComercialDefaultDTO input = getJSON(FileName.TEST_FIRST_GET_PRODUCTO_COMERCIAL_WITHOUT_ERRORS, ProductoComercialDefaultDTO.class);
			
		try {
			output = hubService.getProductoComercial(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}
		
		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getProductoComercial
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testSecondGetProductoComercialWithoutErrors() {
		String serviceName = "\"getProductoComercial\"";
		
		ROLResult output = null;
		
		ProductoComercialDefaultDTO input = getJSON(FileName.TEST_SECOND_GET_PRODUCTO_COMERCIAL_WITHOUT_ERRORS, ProductoComercialDefaultDTO.class);
			
		try {
			output = hubService.getProductoComercial(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}
		
		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof ProductoComercialDTO);
		
		ProductoComercialDTO productoComercial = ((ProductoComercialDTO) output.getObject());
		
		Assert.assertNotNull(serviceName + ": el valor \"tipo\" es null.", productoComercial.getTipo());
		Assert.assertNotNull(serviceName + ": el valor \"código\" es null.", productoComercial.getCodigo());
		Assert.assertNotNull(serviceName + ": el valor \"producto\" es null.", productoComercial.getProducto());
		Assert.assertNotNull(serviceName + ": el valor \"tipo del producto\" es null.", productoComercial.getProducto().getTipo());
		Assert.assertNotNull(serviceName + ": el valor \"código del producto\" es null.", productoComercial.getProducto().getCodigo());
		Assert.assertNotNull(serviceName + ": el valor \"producto técnico\" es null.", productoComercial.getProductoTecnico());
		Assert.assertNotNull(serviceName + ": el valor \"tipo del producto técnico\" es null.", productoComercial.getProductoTecnico().getTipo());
		Assert.assertNotNull(serviceName + ": el valor \"código del producto técnico\" es null.", productoComercial.getProductoTecnico().getCodigo());
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio executeJustificar
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testExecuteJustificarWithException() {
		String serviceName = "\"executeJustificar\"";
		
		boolean isServiceException = false;
		
		JustificacionDTO input = getJSON(FileName.TEST_EXECUTE_JUSTIFICAR_WITH_EXCEPTION, JustificacionDTO.class);
		
		try {
			hubService.executeJustificar(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio executeJustificar
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testExecuteJustificarWithoutErrors() {
		String serviceName = "\"executeJustificar\"";
		
		ROLResult output = null;
		
		JustificacionDTO input = getJSON(FileName.TEST_EXECUTE_JUSTIFICAR_WITHOUT_ERRORS, JustificacionDTO.class);
			
		try {
			output = hubService.executeJustificar(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}
		
		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof JustificacionDTO);
		
		JustificacionDTO justificacion = ((JustificacionDTO) output.getObject());
		
		Assert.assertNotNull(serviceName + ": el valor \"imagen\" es null.", justificacion.getImagen());
		Assert.assertNotNull(serviceName + ": el valor \"cantidad lineas\" es null.", justificacion.getCantidadLineas());
		Assert.assertNotNull(serviceName + ": el valor \"cantidad lineas publicadas\" es null.", justificacion.getCantidadLineasPublicadas());
		Assert.assertNotNull(serviceName + ": el valor \"texto justificado\" es null.", justificacion.getTextoJustificado());
		Assert.assertNotNull(serviceName + ": el valor \"altura estandar\" es null.", justificacion.getAlturaEstandar());
		Assert.assertNotNull(serviceName + ": el valor \"puntos libres\" es null.", justificacion.getPuntosLibres());
		Assert.assertNotNull(serviceName + ": el valor \"texto libre\" es null.", justificacion.getTextoLibre());
		Assert.assertNotNull(serviceName + ": el valor \"texto libre justificado\" es null.", justificacion.getTextoLibreJustificado());
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio validatePalabrasProhibidas
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testValidatePalabrasProhibidasWithException() {
		String serviceName = "\"validatePalabrasProhibidas\"";
		
		boolean isServiceException = false;
		
		TextoValidateDTO input = getJSON(FileName.TEST_VALIDATE_PALABRAS_PROHIBIDAS_WITH_EXCEPTION, TextoValidateDTO.class);
		
		try {
			hubService.validatePalabrasProhibidas(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio validatePalabrasProhibidas
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testValidatePalabrasProhibidasWithoutErrors() {
		String serviceName = "\"validatePalabrasProhibidas\"";
		
		ROLResult output = null;
		
		TextoValidateDTO input = getJSON(FileName.TEST_VALIDATE_PALABRAS_PROHIBIDAS_WITHOUT_ERRORS, TextoValidateDTO.class);
		
		try {
			output = hubService.validatePalabrasProhibidas(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}

		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getNivelesEstructura
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testGetNivelesEstructuraWithException() {
		String serviceName = "\"getNivelesEstructura\"";
		
		boolean isServiceException = false;
		
		NivelEstructuraSearchDTO input = getJSON(FileName.TEST_GET_NIVELES_ESTRUCTURA_WITH_EXCEPTION, NivelEstructuraSearchDTO.class);
		
		try {
			hubService.getNivelesEstructura(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getNivelesEstructura
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testGetNivelesEstructuraWithoutErrors() {
		String serviceName = "\"getNivelesEstructura\"";
		
		ROLResult output = null;
		
		NivelEstructuraSearchDTO input = getJSON(FileName.TEST_GET_NIVELES_ESTRUCTURA_WITHOUT_ERRORS, NivelEstructuraSearchDTO.class);

		/*
		 * Substituye el valor de fecha vigencia en el archivo por la fecha de hoy debido a que
		 * existe una validación que requiere que fecha vigencia sea igual o mayor a la de hoy
		 * y por archivo es imposible realizarlo.
		 */
		input.setFechaVigencia(new Date());
		
		try {
			output = hubService.getNivelesEstructura(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}

		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getTiposOperacion
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testGetTiposOperacionWithException() {
		String serviceName = "\"getTiposOperacion\"";
		
		boolean isServiceException = false;
		
		TipoOperacionSearchDTO input = getJSON(FileName.TEST_GET_TIPOS_OPERACION_WITH_EXCEPTION, TipoOperacionSearchDTO.class);
		
		try {
			hubService.getTiposOperacion(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getTiposOperacion
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testGetTiposOperacionWithoutErrors() {
		String serviceName = "\"getTiposOperacion\"";
		
		ROLResult output = null;
		
		TipoOperacionSearchDTO input = getJSON(FileName.TEST_GET_TIPOS_OPERACION_WITHOUT_ERRORS, TipoOperacionSearchDTO.class);
			
		try {
			output = hubService.getTiposOperacion(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}

		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getProductos
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testGetProductosWithException() {
		String serviceName = "\"getProductos\"";
		
		boolean isServiceException = false;
		
		ProductoSearchDTO input = getJSON(FileName.TEST_GET_PRODUCTOS_WITH_EXCEPTION, ProductoSearchDTO.class);
		
		try {
			hubService.getProductos(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getProductos
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testGetProductosWithoutErrors() {
		String serviceName = "\"getProductos\"";
		
		ROLResult output = null;
		
		ProductoSearchDTO input = getJSON(FileName.TEST_GET_PRODUCTOS_WITHOUT_ERRORS, ProductoSearchDTO.class);
			
		/*
		 * Substituye el valor de fecha vigencia en el archivo por la fecha de hoy debido a que
		 * existe una validación que requiere que fecha vigencia sea igual o mayor a la de hoy
		 * y por archivo es imposible realizarlo.
		 */
		input.setFechaVigencia(new Date());
		
		try {
			output = hubService.getProductos(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}

		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getZonasComercializacion
	 * obteniendo valores con excepción.
	 */
	@Test
	public void testGetZonasComercializacionWithException() {
		String serviceName = "\"getZonasComercializacion\"";
		
		boolean isServiceException = false;
		
		ZonaComercializacionSearchDTO input = getJSON(FileName.TEST_GET_ZONAS_COMERCIALIZACION_WITH_EXCEPTION, ZonaComercializacionSearchDTO.class);
		
		try {
			hubService.getZonasComercializacion(input);
		} catch (ServiceException e) {
			isServiceException = true;
		}
		
		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getZonasComercializacion
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testGetZonasComercializacionWithoutErrors() {
		String serviceName = "\"getZonasComercializacion\"";
		
		ROLResult output = null;
		
		ZonaComercializacionSearchDTO input = getJSON(FileName.TEST_GET_ZONAS_COMERCIALIZACION_WITHOUT_ERRORS, ZonaComercializacionSearchDTO.class);
			
		/*
		 * Substituye el valor de fecha vigencia en el archivo por la fecha de hoy debido a que
		 * existe una validación que requiere que fecha vigencia sea igual o mayor a la de hoy
		 * y por archivo es imposible realizarlo.
		 */
		input.setFechaVigencia(new Date());
		
		try {
			output = hubService.getZonasComercializacion(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}

		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
	}
	
	/**
	 * Comprueba el envío y recepción de objetos al servicio getTarjetasPago
	 * obteniendo valores sin errores.
	 */
	@Test
	public void testGetTarjetasPagosWithoutErrors() {
		String serviceName = "\"getTarjetasPago\"";
		
		ROLResult output = null;
		
		TarjetaPagoSearchDTO input = getJSON(FileName.TEST_GET_TARJETAS_PAGOS_WITHOUT_ERRORS, TarjetaPagoSearchDTO.class);
			
		try {
			output = hubService.getTarjetasPago(input);
		} catch (ServiceException e) {
			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
		}

		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
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
//			output = hubService.getOrdenesPublicacionByCapturador(input);
//		} catch (ServiceException e) {
//			isServiceException = true;
//		}
//
//		Assert.assertTrue("El servicio getOrdenesPublicacionByCapturador no ha devuelto ningún valor.", isServiceException);
//	}
//	
//	/**
//	 * Comprueba el envío y recepción de objetos al servicio getConfiguracionesPromocionPantalla
//	 * obteniendo valores con excepción.
//	 */
//	@Test
//	public void testGetConfiguracionesPromocionPantallaWithException() {
//		String serviceName = "\"getConfiguracionesPromocionPantalla\"";
//		
//		boolean isServiceException = false;
//		
//		PromocionSearchDTO input = getJSON(FileName.TEST_GET_CONFIGURACIONES_PROMOCION_PANTALLA_WITH_EXCEPTION, PromocionSearchDTO.class);
//		
//		try {
//			hubService.getConfiguracionesPromocionPantalla(input);
//		} catch (ServiceException e) {
//			isServiceException = true;
//		}
//		
//		Assert.assertTrue(serviceName + ": no ha lanzado una excepción.", isServiceException);
//	}
//	
//	/**
//	 * Comprueba el envío y recepción de objetos al servicio getZonasComercializacion
//	 * obteniendo valores sin errores.
//	 */
//	@Test
//	public void testGetConfiguracionesPromocionPantallaWithoutErrors() {
//		String serviceName = "\"getConfiguracionesPromocionPantalla\"";
//		
//		ROLResult output = null;
//		
//		PromocionSearchDTO input = getJSON(FileName.TEST_GET_CONFIGURACIONES_PROMOCION_PANTALLA_WITHOUT_ERRORS, PromocionSearchDTO.class);
//		/*
//		 * Substituye el valor de fecha vigencia en el archivo por la fecha de hoy debido a que
//		 * existe una validación que requiere que fecha vigencia sea igual o mayor a la de hoy
//		 * y por archivo es imposible realizarlo.
//		 */
//		input.setFechaVigencia(new Date());
//		
//		try {
//			output = hubService.getConfiguracionesPromocionPantalla(input);
//		} catch (ServiceException e) {
//			throw new GenericTestException("Se produjo un error al acceder al servicio " + serviceName + " de HUB.", e);
//		}
//
//		Assert.assertNotNull(serviceName + ": se ha devuelto un valor null.", output);
//		Assert.assertFalse(serviceName + ": se ha devuelto errores.", output.hasErrors());
//		Assert.assertNotNull(serviceName + ": se ha devuelto un resultado null.", output.getObject());
//		Assert.assertTrue(serviceName + ": se ha devuelto un resultado que no es de tipo List.", output.getObject() instanceof List);
//	}
//	
//	
}
