/*
 * @(#)DTOFactoryTest.java		1.0 03/09/2013
 */

package ar.com.agea.hub.rol.utils;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.model.dto.AccionSecuenciaDTO;
import ar.com.agea.hub.rol.model.dto.AgrupadorProductoComercialNivelDTO;
import ar.com.agea.hub.rol.model.dto.AgrupadorProductoZonasNivelesDTO;
import ar.com.agea.hub.rol.model.dto.CalendarioSearchDTO;
import ar.com.agea.hub.rol.model.dto.CapturadorCRUDDTO;
import ar.com.agea.hub.rol.model.dto.CapturadorDTO;
import ar.com.agea.hub.rol.model.dto.GWPTransaccionDTO;
import ar.com.agea.hub.rol.model.dto.GWPTransactionDTO;
import ar.com.agea.hub.rol.model.dto.ImagenDTO;
import ar.com.agea.hub.rol.model.dto.JustificacionDTO;
import ar.com.agea.hub.rol.model.dto.NivelEstructuraDTO;
import ar.com.agea.hub.rol.model.dto.NivelEstructuraSearchDTO;
import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;
import ar.com.agea.hub.rol.model.dto.OrdenamientoAvisoValorizadoDTO;
import ar.com.agea.hub.rol.model.dto.PASEUsuarioDTO;
import ar.com.agea.hub.rol.model.dto.ProductoComercialDTO;
import ar.com.agea.hub.rol.model.dto.ProductoComercialDefaultDTO;
import ar.com.agea.hub.rol.model.dto.ProductoDTO;
import ar.com.agea.hub.rol.model.dto.ProductoSearchDTO;
import ar.com.agea.hub.rol.model.dto.PromocionDTO;
import ar.com.agea.hub.rol.model.dto.PropiedadDefaultSearchDTO;
import ar.com.agea.hub.rol.model.dto.UpdateEstadoAvisoDTO;
import ar.com.agea.hub.rol.model.dto.UsuarioCompuestoDTO;
import ar.com.agea.hub.rol.model.dto.UsuarioExternoDTO;
import ar.com.agea.hub.rol.model.dto.ValidarPromocionesDTO;
import ar.com.agea.hub.rol.model.dto.ZonaComercializacionDTO;
import ar.com.agea.hub.rol.model.dto.ZonaComercializacionSearchDTO;

/**
 * Representa JUnit Tests de inicializaci�n para la clase DTOFactory.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 03/09/2013
 */
public class DTOFactoryTest extends InstantiationTest {

	/**
	 * Comprueba la ejecuci�n de m�todo createAccionSecuencia de la clase DTOFactory. 
	 */
	@Test
	public void testCreateAccionSecuenciaMethod() {
		AccionSecuenciaDTO output = DTOFactory.createAccionSecuencia(300L, "ACCION");
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createAccionSecuencia\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getNumero\" de la clase \"AccionSecuenciaDTO\" es nulo.",
				output.getNumero());
		Assert.assertNotNull("El valor retornado por el m�todo \"getAccion\" de la clase \"AccionSecuenciaDTO\" es nulo.",
				output.getAccion());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createAgrupadorProductoComercialNivel de la clase DTOFactory. 
	 */
	@Test
	public void testCreateAgrupadorProductoComercialNivelMethod() {
		AgrupadorProductoComercialNivelDTO output = DTOFactory.createAgrupadorProductoComercialNivel(new ProductoComercialDTO(),
				new NivelEstructuraDTO());
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createAgrupadorProductoComercialNivel\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getProductoComercial\" de la clase \"AgrupadorProductoComercialNivelDTO\" es nulo.",
				output.getProductoComercial());
		Assert.assertNotNull("El valor retornado por el m�todo \"getNivelEstructura\" de la clase \"AgrupadorProductoComercialNivelDTO\" es nulo.",
				output.getNivelEstructura());
		
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createAgrupadorProductoZonasNiveles de la clase DTOFactory. 
	 */
	@Test
	public void testCreateAgrupadorProductoZonasNivelesMethod() {
		AgrupadorProductoZonasNivelesDTO output = DTOFactory.createAgrupadorProductoZonasNiveles(new ProductoDTO(),
				new ArrayList<ZonaComercializacionDTO>(), new ArrayList<AgrupadorProductoComercialNivelDTO>());
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createAgrupadorProductoZonasNiveles\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getProducto\" de la clase \"AgrupadorProductoZonasNivelesDTO\" es nulo.",
				output.getProducto());
		Assert.assertNotNull("El valor retornado por el m�todo \"getZonasComercializacion\" de la clase \"AgrupadorProductoZonasNivelesDTO\" es nulo.",
				output.getZonasComercializacion());
		Assert.assertNotNull("El valor retornado por el m�todo \"getAgrupadoresProductoComercialNivel\" de la clase \"AgrupadorProductoZonasNivelesDTO\" es nulo.",
				output.getAgrupadoresProductoComercialNivel());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createCalendarioSearch de la clase DTOFactory. 
	 */
	@Test
	public void testCreateCalendarioSearchMethod() {
		CalendarioSearchDTO output = DTOFactory.createCalendarioSearch("NIVEL_ESTRUCTURA", new Date(), true,
				new ArrayList<ZonaComercializacionDTO>(), 300L, "CODIGO_CANAL_ENTRADA");
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createCalendarioSearch\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getNivelEstructura\" de la clase \"CalendarioSearchDTO\" es nulo.",
				output.getNivelEstructura());
		Assert.assertNotNull("El valor retornado por el m�todo \"getFechaVigencia\" de la clase \"CalendarioSearchDTO\" es nulo.",
				output.getFechaVigencia());
		Assert.assertNotNull("El valor retornado por el m�todo \"getControlarHorarioCierre\" de la clase \"CalendarioSearchDTO\" es nulo.",
				output.getControlarHorarioCierre());
		Assert.assertNotNull("El valor retornado por el m�todo \"getZonasComercializacion\" de la clase \"CalendarioSearchDTO\" es nulo.",
				output.getZonasComercializacion());
		Assert.assertNotNull("El valor retornado por el m�todo \"getIdItemPromocion\" de la clase \"CalendarioSearchDTO\" es nulo.",
				output.getIdItemPromocion());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoCanalEntrada\" de la clase \"CalendarioSearchDTO\" es nulo.",
				output.getCodigoCanalEntrada());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createCapturadorCRUD de la clase DTOFactory. 
	 */
	@Test
	public void testCreateCapturadorCRUDMethod() {
		CapturadorCRUDDTO output = DTOFactory.createCapturadorCRUD("Apellido", "Nombre", "96", 30000000L,
				"apellidonombre@email.com", "ROL", 300L, "PARTICULAR", "Otro", "ROL", "CONSUMIDOR_FINAL", "TARJETA", "3000", "M", "1968-6-10 00:00:00.000");
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createCapturadorCRUD\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoAnunciante\" de la clase \"CapturadorCRUDDTO\" es nulo.",
				output.getCodigoAnunciante());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoTipoAnunciante\" de la clase \"CapturadorCRUDDTO\" es nulo.",
				output.getCodigoTipoAnunciante());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoCliente\" de la clase \"CapturadorCRUDDTO\" es nulo.",
				output.getCodigoCliente());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoPerfilAnunciante\" de la clase \"CapturadorCRUDDTO\" es nulo.",
				output.getCodigoPerfilAnunciante());
		Assert.assertNotNull("El valor retornado por el m�todo \"getEmail\" de la clase \"CapturadorCRUDDTO\" es nulo.",
				output.getEmail());
		Assert.assertNotNull("El valor retornado por el m�todo \"getNombre\" de la clase \"CapturadorCRUDDTO\" es nulo.",
				output.getNombre());
		Assert.assertNotNull("El valor retornado por el m�todo \"getApellido\" de la clase \"CapturadorCRUDDTO\" es nulo.",
				output.getApellido());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoMedioPagoPrincipal\" de la clase \"CapturadorCRUDDTO\" es nulo.",
				output.getCodigoMedioPagoPrincipal());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoTipoIVA\" de la clase \"CapturadorCRUDDTO\" es nulo.",
				output.getCodigoTipoIVA());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoCanalEntrada\" de la clase \"CapturadorCRUDDTO\" es nulo.",
				output.getCodigoCanalEntrada());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoTipoDocumento\" de la clase \"CapturadorCRUDDTO\" es nulo.",
				output.getCodigoTipoDocumento());
		Assert.assertNotNull("El valor retornado por el m�todo \"getNumeroDocumento\" de la clase \"CapturadorCRUDDTO\" es nulo.",
				output.getNumeroDocumento());
		Assert.assertNotNull("El valor retornado por el m�todo \"getUsuarioExternoCodigo\" de la clase \"CapturadorCRUDDTO\" es nulo.",
				output.getUsuarioExternoCodigo());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createGWPTransaccion de la clase DTOFactory. 
	 */
	@Test
	public void testCreateGWPTransaccionMethod() {
		GWPTransaccionDTO output = DTOFactory.createGWPTransaccion("ROL_DESA", "ROL_3000", "Clasificados Clar�n - Receptor�a On line",
				new Date(), new Date(), "ENVIADO", "TARJETA", "VISA", "3000-0000", "PESO", 300.0, 300.0,
				"ID_TRANSACCION_PROVEEDOR", "DECIDIR", false, "Ninguno", "apellidosnombres@email.com", "apellidos", "nombres",
				"3000-0000", "Ninguno");
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createGWPTransaccion\" de la clase \"GWPTransaccionDTO\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoAplicacionCliente\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getCodigoAplicacionCliente());
		Assert.assertNotNull("El valor retornado por el m�todo \"getIdTransaccionCliente\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getIdTransaccionCliente());
		Assert.assertNotNull("El valor retornado por el m�todo \"getNombreItem\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getNombreItem());
		Assert.assertNotNull("El valor retornado por el m�todo \"getFechaImputado\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getFechaImputado());
		Assert.assertNotNull("El valor retornado por el m�todo \"getFechaTransaccion\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getFechaTransaccion());
		Assert.assertNotNull("El valor retornado por el m�todo \"getEstado\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getEstado());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoMetodoPago\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getCodigoMetodoPago());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoMedioPago\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getCodigoMedioPago());
		Assert.assertNotNull("El valor retornado por el m�todo \"getNumeroTarjeta\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getNumeroTarjeta());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoMoneda\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getCodigoMoneda());
		Assert.assertNotNull("El valor retornado por el m�todo \"getMonto\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getMonto());
		Assert.assertNotNull("El valor retornado por el m�todo \"getMontoPagado\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getMontoPagado());
		Assert.assertNotNull("El valor retornado por el m�todo \"getIdTransaccionProveedor\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getIdTransaccionProveedor());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoProveedor\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getCodigoProveedor());
		Assert.assertNotNull("El valor retornado por el m�todo \"getPosibleFraude\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getPosibleFraude());
		Assert.assertNotNull("El valor retornado por el m�todo \"getMotivoPosibleFraude\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getMotivoPosibleFraude());
		Assert.assertNotNull("El valor retornado por el m�todo \"getEmail\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getEmail());
		Assert.assertNotNull("El valor retornado por el m�todo \"getApellidos\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getApellidos());
		Assert.assertNotNull("El valor retornado por el m�todo \"getNombres\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getNombres());
		Assert.assertNotNull("El valor retornado por el m�todo \"getTelefono\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getTelefono());
		Assert.assertNotNull("El valor retornado por el m�todo \"getDescripcionError\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getDescripcionError());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createGWPTransaccion de la clase DTOFactory. 
	 */
	@Test
	public void testCreateGWPTransactionMethod() {
		GWPTransactionDTO output = DTOFactory.createGWPTransaction("TARJETA", "VISA", 300.0, "Clasificados Clar�n - Receptor�a On line",
				"ROL_3000", "apellidosnombres@email.com", "apellidos", "nombres");
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createGWPTransaction\" de la clase \"GWPTransaccionDTO\".",
				output);
		Assert.assertNull("El valor retornado por el m�todo \"getCodigoAplicacionCliente\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getCodigoAplicacionCliente());
		Assert.assertNull("El valor retornado por el m�todo \"getLlaveAplicacionCliente\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getLlaveAplicacionCliente());
		Assert.assertNotNull("El valor retornado por el m�todo \"getIdTransaccionCliente\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getIdTransaccionCliente());
		Assert.assertNotNull("El valor retornado por el m�todo \"getNombreItem\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getNombreItem());
		Assert.assertNotNull("El valor retornado por el m�todo \"getApellidos\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getApellidos());
		Assert.assertNotNull("El valor retornado por el m�todo \"getNombres\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getNombres());
		Assert.assertNotNull("El valor retornado por el m�todo \"getMail\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getMail());
		Assert.assertNull("El valor retornado por el m�todo \"getTelefono\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getTelefono());
		Assert.assertNull("El valor retornado por el m�todo \"getTipoTransaccion\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getTipoTransaccion());
		Assert.assertNull("El valor retornado por el m�todo \"getNumeroCliente\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getNumeroCliente());
		Assert.assertNull("El valor retornado por el m�todo \"getNumeroFactura\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getNumeroFactura());
		Assert.assertNull("El valor retornado por el m�todo \"getFechaVencimiento\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getFechaVencimiento());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoMetodoPago\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getCodigoMetodoPago());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoMedioPago\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getCodigoMedioPago());
		Assert.assertNull("El valor retornado por el m�todo \"getCantidadCuotas\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getCantidadCuotas());
		Assert.assertNull("El valor retornado por el m�todo \"getCodigoMoneda\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getCodigoMoneda());
		Assert.assertNotNull("El valor retornado por el m�todo \"getMonto\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getMonto());
		Assert.assertNull("El valor retornado por el m�todo \"getUrlImagen\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getUrlImagen());
		Assert.assertNull("El valor retornado por el m�todo \"getUrlExito\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getUrlExito());
		Assert.assertNull("El valor retornado por el m�todo \"getUrlFracaso\" de la clase \"GWPTransaccionDTO\" es nulo.",
				output.getUrlFracaso());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createImagen de la clase DTOFactory. 
	 */
	@Test
	public void testCreateImagenMethod() {
		ImagenDTO output = DTOFactory.createImagen("/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgUUUAFFFFABRRRQB//2Q==");
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createImagen\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getTipo\" de la clase \"ImagenDTO\" es nulo.",
				output.getTipo());
		Assert.assertNotNull("El valor retornado por el m�todo \"getContenido\" de la clase \"ImagenDTO\" es nulo.",
				output.getContenido());
		Assert.assertNull("El valor retornado por el m�todo \"getId\" de la clase \"ImagenDTO\" es nulo.",
				output.getId());
		Assert.assertNull("El valor retornado por el m�todo \"getCodigo\" de la clase \"ImagenDTO\" es nulo.",
				output.getCodigo());
		Assert.assertNull("El valor retornado por el m�todo \"getPathImagen\" de la clase \"ImagenDTO\" es nulo.",
				output.getPathImagen());
		Assert.assertNull("El valor retornado por el m�todo \"getPathThumbnail\" de la clase \"ImagenDTO\" es nulo.",
				output.getPathThumbnail());
		Assert.assertNull("El valor retornado por el m�todo \"getAltura\" de la clase \"ImagenDTO\" es nulo.",
				output.getAltura());
		Assert.assertNull("El valor retornado por el m�todo \"getAncho\" de la clase \"ImagenDTO\" es nulo.",
				output.getAncho());
		Assert.assertNull("El valor retornado por el m�todo \"getTamanio\" de la clase \"ImagenDTO\" es nulo.",
				output.getTamanio());
		Assert.assertNull("El valor retornado por el m�todo \"getRepo\" de la clase \"ImagenDTO\" es nulo.",
				output.getRepo());
		Assert.assertNull("El valor retornado por el m�todo \"getExtension\" de la clase \"ImagenDTO\" es nulo.",
				output.getExtension());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createJustificacion de la clase DTOFactory. 
	 */
	@Test
	public void testCreateJustificacionMethod() {
 		JustificacionDTO output = DTOFactory.createJustificacion("CLASIFICADOS CLARIN", "R15 VENTA - LINEAL",
				"CLASIFICADOS_CLARIN.AUTOMOTORES.RUBRO_15.AUTOS_NACIONALES_E_IMPORTADOS", "131-Lineal auto simple",
				new ArrayList<OrdenamientoAvisoValorizadoDTO>(), "Un texto libre.", "", "", new ImagenDTO());
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createJustificacion\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoProducto\" de la clase \"JustificacionDTO\" es nulo.",
				output.getCodigoProducto());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoProductoComercial\" de la clase \"JustificacionDTO\" es nulo.",
				output.getCodigoProductoComercial());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoNivelEstructura\" de la clase \"JustificacionDTO\" es nulo.",
				output.getCodigoNivelEstructura());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoTemplateDetallado\" de la clase \"JustificacionDTO\" es nulo.",
				output.getCodigoTemplateDetallado());
		Assert.assertNotNull("El valor retornado por el m�todo \"getOrdenamientos\" de la clase \"JustificacionDTO\" es nulo.",
				output.getOrdenamientos());
		Assert.assertNotNull("El valor retornado por el m�todo \"getTextoLibre\" de la clase \"JustificacionDTO\" es nulo.",
				output.getTextoLibre());
		Assert.assertNull("El valor retornado por el m�todo \"getImagen\" de la clase \"JustificacionDTO\" es nulo.",
				output.getImagen());
		Assert.assertNull("El valor retornado por el m�todo \"getCantidadLineas\" de la clase \"JustificacionDTO\" es nulo.",
				output.getCantidadLineas());
		Assert.assertNull("El valor retornado por el m�todo \"getTextoJustificado\" de la clase \"JustificacionDTO\" es nulo.",
				output.getTextoJustificado());
		Assert.assertNull("El valor retornado por el m�todo \"getAlturaEstandar\" de la clase \"JustificacionDTO\" es nulo.",
				output.getAlturaEstandar());
		Assert.assertNull("El valor retornado por el m�todo \"getPuntosLibres\" de la clase \"JustificacionDTO\" es nulo.",
				output.getPuntosLibres());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createNivelEstructuraSearch de la clase DTOFactory. 
	 */
	@Test
	public void testCreateNivelEstructuraSearchMethod() {
		NivelEstructuraSearchDTO output = DTOFactory.createNivelEstructuraSearch("ROL", "AUTO", "CLASIFICADOS CLARIN", "VENTA", new Date());
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createNivelEstructuraSearch\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoCanalEntrada\" de la clase \"NivelEstructuraSearchDTO\" es nulo.",
				output.getCodigoCanalEntrada());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoClase\" de la clase \"NivelEstructuraSearchDTO\" es nulo.",
				output.getCodigoClase());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoProducto\" de la clase \"NivelEstructuraSearchDTO\" es nulo.",
				output.getCodigoProducto());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoTipoOperacion\" de la clase \"NivelEstructuraSearchDTO\" es nulo.",
				output.getCodigoTipoOperacion());
		Assert.assertNotNull("El valor retornado por el m�todo \"getFechaVigencia\" de la clase \"NivelEstructuraSearchDTO\" es nulo.",
				output.getFechaVigencia());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createPASEUsuario de la clase DTOFactory. 
	 */
	@Test
	public void testCreatePASEUsuarioMethod() {
		PASEUsuarioDTO output = DTOFactory.createPASEUsuario("300", "apellido", "nombre", "M", "10/06/1960", "apellidosnombres@email.com", "usuario");
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createPASEUsuario\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNull("El valor retornado por el m�todo \"getCodigoSitio\" de la clase \"PASEUsuarioDTO\" es nulo.",
				output.getCodigoSitio());
		Assert.assertNull("El valor retornado por el m�todo \"getToken\" de la clase \"PASEUsuarioDTO\" es nulo.",
				output.getToken());
		Assert.assertNotNull("El valor retornado por el m�todo \"getUid\" de la clase \"PASEUsuarioDTO\" es nulo.",
				output.getUid());
		Assert.assertNotNull("El valor retornado por el m�todo \"getApellido\" de la clase \"PASEUsuarioDTO\" es nulo.",
				output.getApellido());
		Assert.assertNotNull("El valor retornado por el m�todo \"getNombre\" de la clase \"PASEUsuarioDTO\" es nulo.",
				output.getNombre());
		Assert.assertNotNull("El valor retornado por el m�todo \"getGenero\" de la clase \"PASEUsuarioDTO\" es nulo.",
				output.getGenero());
		Assert.assertNotNull("El valor retornado por el m�todo \"getFechaNacimiento\" de la clase \"PASEUsuarioDTO\" es nulo.",
				output.getFechaNacimiento());
		Assert.assertNotNull("El valor retornado por el m�todo \"getEmail\" de la clase \"PASEUsuarioDTO\" es nulo.",
				output.getEmail());
		Assert.assertNotNull("El valor retornado por el m�todo \"getPalabraClave\" de la clase \"PASEUsuarioDTO\" es nulo.",
				output.getPalabraClave());
		Assert.assertNull("El valor retornado por el m�todo \"getEstado\" de la clase \"PASEUsuarioDTO\" es nulo.",
				output.getEstado());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createProductoComercialDefault de la clase DTOFactory. 
	 */
	@Test
	public void testCreateProductoComercialDefaultMethod() {
		ProductoComercialDefaultDTO output = DTOFactory.createProductoComercialDefault("LINEAL",
				"ROL", "VENTA", "CLASIFICADOS_CLARIN.AUTOMOTORES.RUBRO_15.AUTOS_NACIONALES_E_IMPORTADOS");
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createProductoComercialDefault\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoAgrupamientoProductoTecnico\" de la clase \"ProductoComercialDefaultDTO\" es nulo.",
				output.getCodigoAgrupamientoProductoTecnico());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoCanalEntrada\" de la clase \"ProductoComercialDefaultDTO\" es nulo.",
				output.getCodigoCanalEntrada());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoTipoOperacion\" de la clase \"ProductoComercialDefaultDTO\" es nulo.",
				output.getCodigoTipoOperacion());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoNivelEstructura\" de la clase \"ProductoComercialDefaultDTO\" es nulo.",
				output.getCodigoNivelEstructura());
		Assert.assertNull("El valor retornado por el m�todo \"getCodigoProductoComercial\" de la clase \"ProductoComercialDefaultDTO\" es nulo.",
				output.getCodigoProductoComercial());
		Assert.assertNull("El valor retornado por el m�todo \"getCodigoTemplate\" de la clase \"ProductoComercialDefaultDTO\" es nulo.",
				output.getCodigoTemplate());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createProductoSearch de la clase DTOFactory. 
	 */
	@Test
	public void testCreateProductoSearchMethod() {
		ProductoSearchDTO output = DTOFactory.createProductoSearch("ROL", "AUTO", "VENTA", new Date());
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createProductoSearch\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoCanalEntrada\" de la clase \"ProductoSearchDTO\" es nulo.",
				output.getCodigoCanalEntrada());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoClase\" de la clase \"ProductoSearchDTO\" es nulo.",
				output.getCodigoClase());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoTipoOperacion\" de la clase \"ProductoSearchDTO\" es nulo.",
				output.getCodigoTipoOperacion());
		Assert.assertNotNull("El valor retornado por el m�todo \"getFechaVigencia\" de la clase \"ProductoSearchDTO\" es nulo.",
				output.getFechaVigencia());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createPropiedadDefaultSearch de la clase DTOFactory. 
	 */
	@Test
	public void testCreatePropiedadDefaultSearch() {
		PropiedadDefaultSearchDTO output = DTOFactory.createPropiedadDefaultSearch(new ArrayList<String>());
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createPropiedadDefaultSearch\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoCanalEntrada\" de la clase \"PropiedadDefaultSearchDTO\" es nulo.",
				output.getCodigosPropiedadDefault());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createUpdateEstadoAviso de la clase DTOFactory. 
	 */
	@Test
	public void testCreateUpdateEstadoAvisoSearch() {
		UpdateEstadoAvisoDTO output = DTOFactory.createUpdateEstadoAviso(300L, "ACCION", "MOTIVO_RECHAZO", "OBSERVACION");
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createUpdateEstadoAviso\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getIdAviso\" de la clase \"UpdateEstadoAvisoDTO\" es nulo.",
				output.getIdAviso());
		Assert.assertNotNull("El valor retornado por el m�todo \"getAccion\" de la clase \"UpdateEstadoAvisoDTO\" es nulo.",
				output.getAccion());
		Assert.assertNotNull("El valor retornado por el m�todo \"getMotivoRechazo\" de la clase \"UpdateEstadoAvisoDTO\" es nulo.",
				output.getMotivoRechazo());
		Assert.assertNotNull("El valor retornado por el m�todo \"getObservacion\" de la clase \"UpdateEstadoAvisoDTO\" es nulo.",
				output.getObservacion());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createUsuarioCompuesto de la clase DTOFactory. 
	 */
	@Test
	public void testCreateUsuarioCompuesto() {
		UsuarioCompuestoDTO output = DTOFactory.createUsuarioCompuesto(new PASEUsuarioDTO(),
				new CapturadorDTO());
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createUsuarioCompuesto\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getPASEUsuario\" de la clase \"UsuarioCompuestoDTO\" es nulo.",
				output.getPASEUsuario());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCapturador\" de la clase \"UsuarioCompuestoDTO\" es nulo.",
				output.getCapturador());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createUsuarioExterno de la clase DTOFactory. 
	 */
	@Test
	public void testCreateUsuarioExternoMethod() {
		UsuarioExternoDTO output = DTOFactory.createUsuarioExterno("300", "PASE");
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createUsuarioExterno\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigo\" de la clase \"UsuarioExternoDTO\" es nulo.",
				output.getCodigo());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoSistema\" de la clase \"UsuarioExternoDTO\" es nulo.",
				output.getCodigoSistema());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createValidarPromociones de la clase DTOFactory. 
	 */
	@Test
	public void testCreateValidarPromocionesMethod() {
		ValidarPromocionesDTO output = DTOFactory.createValidarPromociones(new OrdenPublicacionDTO(), new ArrayList<PromocionDTO>());
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createValidarPromociones\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigo\" de la clase \"ValidarPromocionesDTO\" es nulo.",
				output.getOrdenPublicacion());
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoSistema\" de la clase \"ValidarPromocionesDTO\" es nulo.",
				output.getPromocionesAplicables());
		Assert.assertNull("El valor retornado por el m�todo \"getCaptcha\" de la clase \"ValidarPromocionesDTO\" es nulo.",
				output.getCaptcha());
		Assert.assertNull("El valor retornado por el m�todo \"getCantidadIntentos\" de la clase \"ValidarPromocionesDTO\" es nulo.",
				output.getCantidadIntentos());
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo createZonaComercializacionSearch de la clase DTOFactory. 
	 */
	@Test
	public void testCreateZonaComercializacionSearchMethod() {
		ZonaComercializacionSearchDTO output = DTOFactory.createZonaComercializacionSearch("CLASIFICADOS CLARIN", new Date());
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"createZonaComercializacionSearch\" de la clase \"JSONFactory\".",
				output);
		Assert.assertNotNull("El valor retornado por el m�todo \"getCodigoProducto\" de la clase \"ZonaComercializacionSearchDTO\" es nulo.",
				output.getCodigoProducto());
		Assert.assertNotNull("El valor retornado por el m�todo \"getFechaVigencia\" de la clase \"ZonaComercializacionSearchDTO\" es nulo.",
				output.getFechaVigencia());
	}
}
