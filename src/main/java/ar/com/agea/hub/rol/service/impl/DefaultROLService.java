/*
 * @(#)DefaultROLService.java		1.0 23/10/2013
 */

package ar.com.agea.hub.rol.service.impl;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.agea.hub.rol.comparator.impl.DefaultItemAvisoFechaPublicacionComparator;
import ar.com.agea.hub.rol.comparator.impl.DefaultOrdenPublicacionFechaPublicacionComparator;
import ar.com.agea.hub.rol.exception.ServiceException;
import ar.com.agea.hub.rol.model.dto.AccionSecuenciaDTO;
import ar.com.agea.hub.rol.model.dto.AgrupadorAtributoAvisoDTO;
import ar.com.agea.hub.rol.model.dto.AgrupadorProductoComercialNivelDTO;
import ar.com.agea.hub.rol.model.dto.AgrupadorProductoZonasNivelesDTO;
import ar.com.agea.hub.rol.model.dto.AgrupadorProductoZonasNivelesSearchDTO;
import ar.com.agea.hub.rol.model.dto.AtributoAvisoDTO;
import ar.com.agea.hub.rol.model.dto.AtributoCIDDTO;
import ar.com.agea.hub.rol.model.dto.AvisoDTO;
import ar.com.agea.hub.rol.model.dto.AvisoPromocionDTO;
import ar.com.agea.hub.rol.model.dto.CalendarioSearchDTO;
import ar.com.agea.hub.rol.model.dto.CaptchaDTO;
import ar.com.agea.hub.rol.model.dto.CapturadorCRUDDTO;
import ar.com.agea.hub.rol.model.dto.CapturadorDTO;
import ar.com.agea.hub.rol.model.dto.ClaseDTO;
import ar.com.agea.hub.rol.model.dto.ClaseSearchDTO;
import ar.com.agea.hub.rol.model.dto.ConceptoVendibleDTO;
import ar.com.agea.hub.rol.model.dto.ConfiguracionOrdenamientoPantallaDTO;
import ar.com.agea.hub.rol.model.dto.ConfiguracionPromocionPantallaDTO;
import ar.com.agea.hub.rol.model.dto.FamiliaDTO;
import ar.com.agea.hub.rol.model.dto.FamiliasByFilterSearchDTO;
import ar.com.agea.hub.rol.model.dto.GWPNotificationDTO;
import ar.com.agea.hub.rol.model.dto.GWPTransaccionDTO;
import ar.com.agea.hub.rol.model.dto.GWPTransactionDTO;
import ar.com.agea.hub.rol.model.dto.ImagenDTO;
import ar.com.agea.hub.rol.model.dto.ItemAvisoDTO;
import ar.com.agea.hub.rol.model.dto.ItemConceptoVendibleDTO;
import ar.com.agea.hub.rol.model.dto.ItemOrdenamientoAvisoDTO;
import ar.com.agea.hub.rol.model.dto.ItemOrdenamientoAvisoSearchDTO;
import ar.com.agea.hub.rol.model.dto.JustificacionDTO;
import ar.com.agea.hub.rol.model.dto.LimiteCotizacionDTO;
import ar.com.agea.hub.rol.model.dto.LocalidadDTO;
import ar.com.agea.hub.rol.model.dto.ModelCrearAvisoDTO;
import ar.com.agea.hub.rol.model.dto.NivelEstructuraDTO;
import ar.com.agea.hub.rol.model.dto.NivelEstructuraSearchDTO;
import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;
import ar.com.agea.hub.rol.model.dto.OrdenamientoAvisoSearchDTO;
import ar.com.agea.hub.rol.model.dto.PASEUsuarioDTO;
import ar.com.agea.hub.rol.model.dto.PaisDTO;
import ar.com.agea.hub.rol.model.dto.PermisoAtributoSearchDTO;
import ar.com.agea.hub.rol.model.dto.PrimitiveDTO;
import ar.com.agea.hub.rol.model.dto.ProductoComercialDTO;
import ar.com.agea.hub.rol.model.dto.ProductoComercialDefaultDTO;
import ar.com.agea.hub.rol.model.dto.ProductoComercialTemplateDTO;
import ar.com.agea.hub.rol.model.dto.ProductoDTO;
import ar.com.agea.hub.rol.model.dto.ProductoSearchDTO;
import ar.com.agea.hub.rol.model.dto.PromocionDTO;
import ar.com.agea.hub.rol.model.dto.PromocionSearchDTO;
import ar.com.agea.hub.rol.model.dto.PropiedadDefaultDTO;
import ar.com.agea.hub.rol.model.dto.PropiedadDefaultSearchDTO;
import ar.com.agea.hub.rol.model.dto.ProvinciaDTO;
import ar.com.agea.hub.rol.model.dto.TemplateDetalladoSearchDTO;
import ar.com.agea.hub.rol.model.dto.UpdateEstadoAvisoDTO;
import ar.com.agea.hub.rol.model.dto.UsuarioCompuestoDTO;
import ar.com.agea.hub.rol.model.dto.UsuarioDTO;
import ar.com.agea.hub.rol.model.dto.UsuarioExternoDTO;
import ar.com.agea.hub.rol.model.dto.ValidacionPromocionDTO;
import ar.com.agea.hub.rol.model.dto.ValidarPromocionesDTO;
import ar.com.agea.hub.rol.model.dto.ZonaComercializacionDTO;
import ar.com.agea.hub.rol.model.dto.ZonaComercializacionSearchDTO;
import ar.com.agea.hub.rol.model.result.ROLErrorType;
import ar.com.agea.hub.rol.model.result.ROLResult;
import ar.com.agea.hub.rol.service.GWPService;
import ar.com.agea.hub.rol.service.HUBService;
import ar.com.agea.hub.rol.service.ROLService;
import ar.com.agea.hub.rol.service.Service;
import ar.com.agea.hub.rol.utils.DTOFactory;
import ar.com.agea.hub.rol.utils.JSONFactory;
import ar.com.agea.hub.rol.utils.PropiedadDefaultName;

/**
 * Provee una implementación de la interfaz ROLService.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 23/10/2013
 */
@Component
public class DefaultROLService extends Service implements ROLService {

	// Constantes utilizadas por el método getHash.
	private static final int INITIAL_HASH_VALUE = 5381;
	private static final int OFFSET = 5;
	
	// Constantes utilizadas por el método executePagarAndGuardar.
	private static final String CODIGO_SISTEMA_USUARIO_EXTERNO_VALUE = "AUTH0";
	
	private static final String INICIAR_PENDIENTE_PAGO_ACCION = "INICIAR_PENDIENTE_PAGO";
	private static final String INICIAR_SIN_AUTORIZAR_ACCION = "INICIAR_SIN_AUTORIZAR";	
	
	private static final String SUSPENDER_AVISO_ACCION = "SUSPENDER";
	private static final String REACTIVAR_AVISO_ACCION = "REACTIVAR_AVISO";
	private static final String ANULAR_CONCEPTO_ACCION = "ANULAR";
	private static final String MODIFICAR_CONCEPTO_ACCION = "MODIFICAR";
			
	// Constantes utilizadas por el método executePagar.
	private static final String GWP_TRANSACCION_ESTADO_ENVIADO = "ENVIADO";
	private static final String GWP_TRANSACCION_ESTADO_PENDIENTE_CONFIRMACION = "PENDIENTE_CONFIRMACION";
	private static final String GWP_TRANSACCION_ESTADO_NO_RECIBIDO = "NO_RECIBIDO";
	private static final String GWP_TRANSACCION_ESTADO_ACREDITADO = "ACREDITADO";
	
	private static final int GWP_TRANSACCION_FECHA_TRANSACCION_INCREMENT_SECOND = 1;
	private static final int GWP_TRANSACCION_FECHA_TRANSACCION_INCREMENT_MINUTE = 5;
	
	private static final String DEFAULT_ID_NUP_VALUE = "ENCOLADO";
	
	// Constantes utilizadas por el método getItemsOrdenamientoAviso.
	private static final String ORDENAMIENTO_AVISO_CODIGO_ANIO_DE_PATENTAMIENTO = "AÑO DE PATENTAMIENTO";
	private static final String CODIGO_ORDENAMIENTO_AVISO_AMBIENTES = "AMBIENTES";
	private static final String ITEM_ORDENAMIENTO_AVISO_VALOR_OKM = "0KM";
	private static final int ITEM_ORDENAMIENTO_AVISO_VALOR_OKM_INDEX = 0;
	private static final String ITEM_ORDENAMIENTO_AVISO_CONTAINS_VALOR_AMB = "amb";
	
	private static final String DEFAULT_ESTADO_AVISO = "PENDIENTE_PUBLICACION";
	
	private static final String DEFAULT_MEDIO_PAGO = "TARJETA";
	
	private static final String LANGUAGE_ES = "es";
	private static final String COUNTRY_AR = "AR";
	
	private static final long STEP_CUANDO = 2L;
	private static final long STEP_CONFIRMACION = 6L;
	private static final String URL_REDIRECT_CREAR_AVISO = "/rol/crearaviso/crear-aviso";
	
	private static Locale locale;
	
	static {
		locale = new Locale(LANGUAGE_ES, COUNTRY_AR);
	}
	
	@Autowired
	private HUBService hubService;
	
	@Autowired
	private GWPService gwpService;
	
	@Override
	public ROLResult executeJustificar(OrdenPublicacionDTO dto) throws ServiceException {
		getLogger().info("Justificando y tasando orden publicación...");
		
		/*
		 * Al momento de implementación desde ROL se publica un aviso para una fecha determinada, no existen
		 * frecuencias, ecos, republicaciones, combos, etc. Por tal motivo se obtiene el único aviso de
		 * la orden publicación y se justifica.
		 * 
		 * Si en algún momento existiesen cambios para soportar todas o algunas de estas características se debe
		 * actualizar esta implementación.
		 */
		AvisoDTO aviso = dto.getConceptosVendibles().iterator().next().getItemsConceptoVendible().iterator().next()
				.getItemsAviso().iterator().next().getAviso();
		
		String nombreImagen = null;
		String nombreLibreriaImagen = null;
		
		if (aviso.getPreview() != null) {
			if( aviso.getPreview().getCodigo() != null && aviso.getPreview().getCodigo().equals("") == false &&
				aviso.getPreview().getRepo() != null && aviso.getPreview().getRepo().equals("") == false) {
				
				nombreImagen = aviso.getPreview().getCodigo();
				nombreLibreriaImagen = aviso.getPreview().getRepo();
			}
		}
		
		ImagenDTO material = (aviso.getMateriales() != null && aviso.getMateriales().size() > 0 && nombreImagen == null 
				&& nombreLibreriaImagen == null) ? aviso.getMateriales().iterator().next() : null;
		
		JustificacionDTO justificacion = DTOFactory.createJustificacion(aviso.getProductoComercial().getProducto().getCodigo(),
				aviso.getProductoComercial().getCodigo(), aviso.getNivelEstructura().getCodigo(), aviso.getTemplateDetallado().getCodigo(),
				aviso.getOrdenamientos(), aviso.getTextoLibreTemplate(), nombreImagen, nombreLibreriaImagen, material);
		
		/*
		 * Justifica la orden publicación.
		 */
		justificacion = (JustificacionDTO) hubService.executeJustificar(justificacion).getObject();

		/*
		 * Setea el identificador único universal para ser utilizado como id asociado a la orden publicación en
		 * la sesión del servidor y necesario al guardar la orden publicación.
		 */
		
		if (dto.getUuidGenerarOrden() == null || dto.getUuidGenerarOrden().isEmpty()) {
			dto.setUuidGenerarOrden(String.format("ROL-%s", (String) getUUID().getObject()));
		}
		
		/*
		 * Setea datos necesarios para tasar y otros que son necesarios al guardar la orden publicación.
		 */
		for (ConceptoVendibleDTO conceptoVendibleDTO : dto.getConceptosVendibles()) {
			for (ItemConceptoVendibleDTO itemConceptoVendibleDTO : conceptoVendibleDTO.getItemsConceptoVendible()) {
				for (ItemAvisoDTO itemAvisoDTO : itemConceptoVendibleDTO.getItemsAviso()) {
					itemAvisoDTO.getAviso().setPreview(DTOFactory.createImagen(justificacion.getImagen()));
					itemAvisoDTO.getAviso().setLineasFacturadas(justificacion.getCantidadLineas());
					itemAvisoDTO.getAviso().setLineasPublicadas(justificacion.getCantidadLineasPublicadas());
					itemAvisoDTO.getAviso().setTextoLibre(justificacion.getTextoLibre());
					itemAvisoDTO.getAviso().setTextoLibreJustificado(justificacion.getTextoLibreJustificado());
					itemAvisoDTO.getAviso().setTextoJustificado(justificacion.getTextoJustificado());
					itemAvisoDTO.getAviso().setAltoPuntosTipograficos(justificacion.getAlturaEstandar());
					
					/*
					 * Se chequea si existe material. En caso que si,
					 * se crea la colección y el material para adjuntarlo al aviso.
					 */
					if (material != null && nombreImagen == null && nombreLibreriaImagen == null) {
						List<ImagenDTO> materiales = new ArrayList<ImagenDTO>();
						
						materiales.add(justificacion.getMaterial());
						
						itemAvisoDTO.getAviso().setMateriales(materiales);
					}
				}
			}
		}

		ROLResult rolResult = handleResult(dto);
		
		getLogger().info("Orden publicación justificada y tasada.");
		
		return rolResult;
	}

	@Override
	public ROLResult executeNotificarPago(GWPNotificationDTO dto) throws ServiceException {
		Calendar calendar = Calendar.getInstance();
		
		/*
		 * Suma minutos a la fecha utilizada como transacción para evitar desfazajes entre los nodos del servidor donde corre
		 * la aplicación. Esta fecha de transacción luego es utilizada en HUB-API para retornar la última transacción registrada
		 * para una orden publicación.
		 */
		calendar.add(Calendar.MINUTE, GWP_TRANSACCION_FECHA_TRANSACCION_INCREMENT_MINUTE);
		
		GWPTransaccionDTO gwpTransaccion = DTOFactory.createGWPTransaccion(dto.getCodigoAplicacionCliente(),
				dto.getIdTransaccionCliente(), dto.getNombreItem(), dto.getFecha(), calendar.getTime(), dto.getEstado(),
				dto.getCodigoMetodoPago(), dto.getMedioPago(), dto.getNumeroTarjeta(), dto.getCodigoMoneda(),
				dto.getMonto(), dto.getMontoPagado(), dto.getIdTransaccionProveedor(), dto.getCodigoProveedor(),
				dto.getPosibleFraude(), dto.getMotivoPosibleFraude(), null, null, null, null, null);
		
		ROLResult rolResult = hubService.executeNotificarPago(gwpTransaccion);
		
		try {
			getLogger().info("Salida servicio \"executeNotificarPago\" de ROL: id orden publicacion " + ((OrdenPublicacionDTO) rolResult.getObject()).getId());
		} catch (Exception e) {
			getLogger().info("Salida servicio \"executeNotificarPago\" de ROL: ha ocurrido un error en el proceso de logueo.");
		}
		
		/*
		 * Esto es un tratamiento especial por el resultado que debemos retornar cuando nos llama GWP.
		 * 
		 * GWP espera que devolvamos un OK 200 o un error. El error lo creamos a partir de lanzar una excepción.
		 */
		if (rolResult.hasErrors()) {
			throw new ServiceException();
		}
		
		return rolResult;
	}
	
	/**
	 * Este método es synchronized por concurrencia. Evita la creación de ordenes con las misma tarjeta en aviso.
	 */	
	@Override
	public synchronized ROLResult executePagarAndGuardar(OrdenPublicacionDTO dto) throws ServiceException {
		getLogger().info("Pagando y guardando orden publicación...");

		List<AccionSecuenciaDTO> acciones = buildAccionesSecuencia(INICIAR_PENDIENTE_PAGO_ACCION); 
		/*
		 * Setea datos necesarios para tasar y otros que son necesarios al guardar la orden publicación.
		 */
		for (ConceptoVendibleDTO conceptoVendibleDTO : dto.getConceptosVendibles()) {
			conceptoVendibleDTO.setAcciones(acciones);
			
			for (ItemConceptoVendibleDTO itemConceptoVendibleDTO : conceptoVendibleDTO.getItemsConceptoVendible()) {
				for (ItemAvisoDTO itemAviso : itemConceptoVendibleDTO.getItemsAviso()) {
					AvisoDTO aviso = itemAviso.getAviso();
					
					if (!hasPromocionGratuita(aviso)) {
						aviso.setIdNUP(DEFAULT_ID_NUP_VALUE);
					}
				}
			}
		}

		ConceptoVendibleDTO conceptoVendible = dto.getConceptosVendibles().iterator().next();
			
		AvisoDTO aviso = conceptoVendible.getItemsConceptoVendible().iterator().next().getItemsAviso().iterator().next().getAviso();
		
		//Las promociones aplicables en el caso de pagar estan ya en el aviso - vdenicolo 28/02/2014
		List<PromocionDTO> promociones = new ArrayList<PromocionDTO>();
		
		for (AvisoPromocionDTO avisoPromocion : aviso.getAvisoPromocion()) {
			promociones.add(avisoPromocion.getPromocion());
		}
		
		ROLResult rolResult = validatePromociones(DTOFactory.createValidarPromociones(dto, promociones));
		
		if (rolResult == null || !rolResult.hasErrors()) {
			// Valida las promociones si tiene y que no se haya hecho un cierre de recepción entre los pasos de selección de la fecha a publicar y el pago.
			if (validateCierreRecepcion(dto)) {
				// Registra la transacción en GWP, crea transacciones acorde al resultado devuelto por GWP
				// y se las asigna a la orden publicación.
				rolResult = executePagar(dto);
				
				// Crea Usuario Externo para asignarlo a la orden publicación a guardar en HUB.
				UsuarioExternoDTO usuarioExterno = DTOFactory.createUsuarioExterno(dto.getCapturador().getUsuarioExternoCodigo(), CODIGO_SISTEMA_USUARIO_EXTERNO_VALUE);
				
				dto.setUsuarioExterno(usuarioExterno);
				
				// Guarda la orden publicación en HUB.
				getLogger().info("--- paso al GWP. Guardando orden uuid: "+dto.getUuidGenerarOrden()+" ---");
				hubService.saveOrdenPublicacion(dto);
				
				getLogger().info("Orden publicación pagada y guardada.");
			} else {
				rolResult = handleResult(ROLErrorType.VALIDATION, "La fecha de publicación fue cerrada.");
				
				getLogger().info("Orden publicación no ha sido pagada por cierre de recepción para la fecha seleccionada.");
			}
		}
		
		return rolResult;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ROLResult executeTasar(OrdenPublicacionDTO dto) throws ServiceException {
		
		ROLResult rolResult = hubService.executeTasar(dto);
		
		dto.setConceptosVendibles((List<ConceptoVendibleDTO>) rolResult .getObject());
		
		return  handleResult(dto);
	}
	
	@Override
	public synchronized ROLResult executePagarAndActualizar(OrdenPublicacionDTO dto) throws ServiceException {
		getLogger().info("Pagando y actualizando orden publicación...");
	
		ROLResult rolResult = null;
		
		// Valida que no se haya hecho un cierre de recepción entre los pasos de selección de la fecha a publicar y el pago.
		if (validateCierreRecepcion(dto)) {
			rolResult = executePagar(dto);
			
			// Actualiza la orden publicación en HUB.
			hubService.updateOrdenPublicacion(dto);
			
			getLogger().info("Orden publicación pagada y actualizada.");
		} else {
			rolResult = handleResult(ROLErrorType.VALIDATION, "La fecha de publicación fue cerrada.");

			getLogger().info("Orden publicación no ha sido pagada por cierre de recepción para la fecha seleccionada.");
		}
	
		return rolResult;
	}
	
	@Override
	public synchronized ROLResult executeActualizar(OrdenPublicacionDTO dto) throws ServiceException {
		getLogger().info("Actualizando orden publicación...");
	
		ROLResult rolResult = null;
		
		// Valida que no se haya hecho un cierre de recepción entre los pasos de selección de la fecha a publicar y el pago.
		if (validateCierreRecepcion(dto)) {			
			
			// Actualiza la orden publicación en HUB.
			rolResult = hubService.updateOrdenPublicacion(dto);
			
			getLogger().info("Orden publicación actualizada.");
		} else {
			rolResult = handleResult(ROLErrorType.VALIDATION, "La fecha de publicación fue cerrada.");

			getLogger().info("Orden publicación no ha sido actualizada por cierre de recepción para la fecha seleccionada.");
		}
	
		return rolResult;
	}
	
	
	@SuppressWarnings("unchecked")
	private boolean validateCierreRecepcion(OrdenPublicacionDTO dto) throws ServiceException {
		// TODO arreglar cuanto antes que recorra todos los avisos y verifique fecha de cierre recepción.
		AvisoDTO aviso = dto.getConceptosVendibles().iterator().next().getItemsConceptoVendible().iterator().next()
				.getItemsAviso().iterator().next().getAviso();
		
		Calendar date = Calendar.getInstance();
		
		CalendarioSearchDTO calendarioSearch = DTOFactory.createCalendarioSearch(aviso.getNivelEstructura().getCodigo(),
				date.getTime(), true, aviso.getZonasComercializacion(), null, dto.getCapturador().getCodigoCliente());
		
		ROLResult rolResult = hubService.getCalendario(calendarioSearch);

		date = Calendar.getInstance();

		date.setTime(aviso.getFechaPedidoPublicacion());
		date.set(Calendar.HOUR, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		
		return (((List<Date>) rolResult.getObject()).contains(date.getTime()));
	}
	
	@SuppressWarnings("unchecked")
	private ROLResult executePagar(OrdenPublicacionDTO dto) throws ServiceException {
		// Obtiene Usuario PASE para utilizar su apellido, nombre y email.
		PASEUsuarioDTO paseUsuario = DTOFactory.createPASEUsuario(dto.getCapturador().getUsuarioExternoCodigo(), null, null,
				null, null, null, null);
		
		//paseUsuario = ((UsuarioCompuestoDTO) paseService.obtener(paseUsuario).getObject()).getPASEUsuario();
		
		// Obtiene Propiedad Default que identifica el valor para el atributo nombre ítem enviado a GWP.
		PropiedadDefaultSearchDTO propiedadDefaultSearch = DTOFactory.createPropiedadDefaultSearch(
				Arrays.asList(new String[] {PropiedadDefaultName.ROL_PARAMETRO_NOMBRE_ITEM_GWP_TRANSACCION_REALIZAR.name()}));
		
		List<PropiedadDefaultDTO> propiedadesDefault = (List<PropiedadDefaultDTO>) hubService.getPropiedadesDefault(propiedadDefaultSearch).getObject();

		/*
		 * En caso de que sea un aviso con fechas múltiples se deben sumar los montos totales
		 * de todos los conceptos vendibles.
		 * Se agrego para filtrar los conceptos con accion ANULAR. 
		 */
		Double montoTotal = 0.0;
		
		for (ConceptoVendibleDTO conceptoVendible : dto.getConceptosVendibles()) {
			if (!hasAccionAnular(conceptoVendible)){
				montoTotal += conceptoVendible.getMontoTotal();
			}
		}

		// Crea objeto GWP Transaction para registrar la transacción en GWP.
		getLogger().info("--- Creando transaccion en el Gateway de Pagos de la orden uuid: "+dto.getUuidGenerarOrden()+" ---");
		GWPTransactionDTO gwpTransaction = DTOFactory.createGWPTransaction(dto.getCodigoMedioDePago(), dto.getCodigoTipoTarjeta(),
				montoTotal, propiedadesDefault.iterator().next().getValor(),
				dto.getUuidGenerarOrden() + new Date().getTime(), dto.getEmail(),
				dto.getCapturador().getApellido(), dto.getCapturador().getNombre());

		try {
			getLogger().info("Entrada servicio \"realizar\" de GWP: " + JSONFactory.createJSONObjectAsString(gwpTransaction));
		} catch (Exception e) {
			getLogger().info("Entrada servicio \"realizar\" de GWP: ha ocurrido un error al convertir un objeto en objeto JSON en el proceso de logueo.");
		}
		
		AvisoDTO aviso = dto.getConceptosVendibles().iterator().next().getItemsConceptoVendible().iterator().next()
				.getItemsAviso().iterator().next().getAviso();
		
		ROLResult rolResult = null;

		boolean hasPromocionGratuita = hasPromocionGratuita(aviso);
		
		if (hasPromocionGratuita) {
			// Adjunta la orden publicación recibida como parámetro de este método.
			rolResult = handleResult(dto);
		} else {
			// Registra la transacción en GWP.
			rolResult = gwpService.realizar(gwpTransaction);
			
			try {
				getLogger().info("Salida servicio \"realizar\" de GWP: " + rolResult.getObject());
			} catch (Exception e) {
				getLogger().info("Salida servicio \"realizar\" de GWP: ha ocurrido un error en el proceso de logueo.");
			}
		}
		
		// Agrega las gwp transacciones necesarias dependiendo si es un aviso a pagar o un aviso gratuito.
		dto.setTransacciones(createGWPTransacciones(gwpTransaction, paseUsuario, rolResult, hasPromocionGratuita));

		// Obtiene la última transacción agregada a la lista de transacciones para usarla como transacción actual.
		List<GWPTransaccionDTO> tmp = new ArrayList<GWPTransaccionDTO>(dto.getTransacciones());
		
		Collections.sort(tmp, new Comparator<GWPTransaccionDTO>() {
			public int compare(GWPTransaccionDTO first, GWPTransaccionDTO second) {
				int result = 0;
				
				if (second.getFechaTransaccion() != null && first.getFechaTransaccion() != null) {
					result = second.getFechaTransaccion().compareTo(first.getFechaTransaccion());
				} else if (second.getFechaTransaccion() != null) {
					result = 1;
				} else if (first.getFechaTransaccion() != null) {
					result = -1;
				}
				
				return result;
			}
		});

		dto.setTransaccionActual(tmp.iterator().next());
		
		return rolResult;
	}
	
	private boolean hasAccionAnular(ConceptoVendibleDTO conceptoVendible){
				
		for (AccionSecuenciaDTO accion : conceptoVendible.getAcciones()){
			if (accion.getAccion().equals(ANULAR_CONCEPTO_ACCION)){
				return true;
			}
		}
		
		return false;
	};
	
	private boolean hasPromocionGratuita(AvisoDTO aviso) {
		boolean result = false;
		
		for (AvisoPromocionDTO avisoPromocion : aviso.getAvisoPromocion()) {
			PromocionDTO promocion = avisoPromocion.getPromocion();
			
			if (promocion.getGratuita()) {
				result = true;
				
				break;
			}
		}
		
		return result;
	}
	
	private List<GWPTransaccionDTO> createGWPTransacciones(GWPTransactionDTO gwpTransaction, PASEUsuarioDTO paseUsuario,
			ROLResult rolResult, boolean hasPromocionGratuita) {
		// Genera los objetos Date con diferencia de un segundo.
		Calendar calendar = Calendar.getInstance();
				
		// Crea objetos GWP Transacción para asignarlos a la orden publicación a guardar en HUB.
		List<GWPTransaccionDTO> gwpTransacciones = new ArrayList<GWPTransaccionDTO>();
				
		GWPTransaccionDTO gwpTransaccion = DTOFactory.createGWPTransaccion(gwpTransaction.getCodigoAplicacionCliente(),
				gwpTransaction.getIdTransaccionCliente(), gwpTransaction.getNombreItem(), null, calendar.getTime(),
				GWP_TRANSACCION_ESTADO_ENVIADO, gwpTransaction.getCodigoMetodoPago(), gwpTransaction.getCodigoMedioPago(),
				null, gwpTransaction.getCodigoMoneda(), gwpTransaction.getMonto(), null, null, null, null, null,
				gwpTransaction.getMail(), gwpTransaction.getApellidos(), gwpTransaction.getNombres(), null, null);
		
		gwpTransacciones.add(gwpTransaccion);
		
		/*
		 * Suma minutos a la fecha utilizada como transacción para evitar desfazajes entre los nodos del servidor donde corre
		 * la aplicación. Esta fecha de transacción luego es utilizada en HUB-API para retornar la última transacción registrada
		 * para una orden publicación.
		 */
		calendar.add(Calendar.SECOND, GWP_TRANSACCION_FECHA_TRANSACCION_INCREMENT_SECOND);
		
		String gwpTransaccionEstado = null;
		
		if (hasPromocionGratuita) {
			gwpTransaccionEstado = GWP_TRANSACCION_ESTADO_PENDIENTE_CONFIRMACION;
		} else {
			gwpTransaccionEstado = !rolResult.hasErrors() ? GWP_TRANSACCION_ESTADO_PENDIENTE_CONFIRMACION : GWP_TRANSACCION_ESTADO_NO_RECIBIDO;
		}

		gwpTransaccion = DTOFactory.createGWPTransaccion(gwpTransaction.getCodigoAplicacionCliente(),
				gwpTransaction.getIdTransaccionCliente(), gwpTransaction.getNombreItem(), null, calendar.getTime(),
				gwpTransaccionEstado, gwpTransaction.getCodigoMetodoPago(), gwpTransaction.getCodigoMedioPago(),
				null, gwpTransaction.getCodigoMoneda(), gwpTransaction.getMonto(), null, null, null, null, null,
				gwpTransaction.getMail(), gwpTransaction.getApellidos(), gwpTransaction.getNombres(), null, null);
		
		gwpTransacciones.add(gwpTransaccion);

		if (hasPromocionGratuita) {
			/*
			 * Suma minutos a la fecha utilizada como transacción para evitar desfazajes entre los nodos del servidor donde corre
			 * la aplicación. Esta fecha de transacción luego es utilizada en HUB-API para retornar la última transacción registrada
			 * para una orden publicación.
			 */
			calendar.add(Calendar.SECOND, GWP_TRANSACCION_FECHA_TRANSACCION_INCREMENT_SECOND);
			
			gwpTransaccionEstado = GWP_TRANSACCION_ESTADO_ACREDITADO;
	
			gwpTransaccion = DTOFactory.createGWPTransaccion(gwpTransaction.getCodigoAplicacionCliente(),
					gwpTransaction.getIdTransaccionCliente(), gwpTransaction.getNombreItem(), null, calendar.getTime(),
					gwpTransaccionEstado, gwpTransaction.getCodigoMetodoPago(), gwpTransaction.getCodigoMedioPago(),
					null, gwpTransaction.getCodigoMoneda(), gwpTransaction.getMonto(), null, null, null, null, null,
					gwpTransaction.getMail(), gwpTransaction.getApellidos(), gwpTransaction.getNombres(), null, null);
			
			gwpTransacciones.add(gwpTransaccion);
		}
		
		return gwpTransacciones;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ROLResult getAgrupadoresProductoZonasNiveles(AgrupadorProductoZonasNivelesSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo agrupadores producto zonas niveles...");
		
		List<AgrupadorProductoZonasNivelesDTO> tmp = new ArrayList<AgrupadorProductoZonasNivelesDTO>();

		ProductoSearchDTO productoSearch = DTOFactory.createProductoSearch(dto.getCodigoCanalEntrada(), dto.getCodigoClase(),
				dto.getCodigoTipoOperacion(), dto.getFechaVigencia());
		
		for (ProductoDTO producto : (List<ProductoDTO>) hubService.getProductos(productoSearch).getObject()) {
			ZonaComercializacionSearchDTO zonaComercializacionSearch = DTOFactory.createZonaComercializacionSearch(
					producto.getCodigo(), dto.getFechaVigencia());
			
			List<ZonaComercializacionDTO> zonasComercializacion = sortZonasComercializacion((List<ZonaComercializacionDTO>) hubService
					.getZonasComercializacion(zonaComercializacionSearch).getObject());

			NivelEstructuraSearchDTO nivelEstructuraSearch = DTOFactory.createNivelEstructuraSearch(dto.getCodigoCanalEntrada(),
					dto.getCodigoClase(), producto.getCodigo(), dto.getCodigoTipoOperacion(), dto.getFechaVigencia());
			
			List<AgrupadorProductoComercialNivelDTO> agrupadoresProductoComercialNivel = new ArrayList<AgrupadorProductoComercialNivelDTO>();
			
			for (NivelEstructuraDTO nivelEstructura : (List<NivelEstructuraDTO>) hubService.getNivelesEstructura(nivelEstructuraSearch).getObject()) {
				ProductoComercialDefaultDTO productoComercialDefault = DTOFactory.createProductoComercialDefault(
						dto.getCodigoAgrupamientoProductoTecnico(), dto.getCodigoCanalEntrada(),
						dto.getCodigoTipoOperacion(), nivelEstructura.getCodigo());
				
				ProductoComercialDTO productoComercial = (ProductoComercialDTO) hubService.getProductoComercial(productoComercialDefault).getObject();
			
				AgrupadorProductoComercialNivelDTO agrupadorProductoComercialNivel = DTOFactory.createAgrupadorProductoComercialNivel(
						productoComercial, nivelEstructura);
				
				agrupadoresProductoComercialNivel.add(agrupadorProductoComercialNivel);
			}
			
			AgrupadorProductoZonasNivelesDTO agrupador = DTOFactory.createAgrupadorProductoZonasNiveles(
					producto, zonasComercializacion, agrupadoresProductoComercialNivel);
			
			tmp.add(agrupador);
		}
		
		ROLResult rolResult = handleResult(tmp);
		
		getLogger().info("Agrupadores producto zonas niveles obtenidos.");
		
		return rolResult;
	}
	
	private List<ZonaComercializacionDTO> sortZonasComercializacion(List<ZonaComercializacionDTO> zonasComercializacion) {
		List<ZonaComercializacionDTO> result = new ArrayList<ZonaComercializacionDTO>();

		final Collator collator = Collator.getInstance(locale);
		
		Set<ZonaComercializacionDTO> sortedStringZonasComercializacion = new TreeSet<ZonaComercializacionDTO>(new Comparator<ZonaComercializacionDTO>() {
			@Override
			public int compare(ZonaComercializacionDTO first, ZonaComercializacionDTO second) {
				return collator.compare(first.getDescripcion(), second.getDescripcion());
			}
		});
		
		sortedStringZonasComercializacion.addAll(zonasComercializacion);
		
		result.addAll(sortedStringZonasComercializacion);
		
		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ROLResult getFamiliasByFilter(FamiliasByFilterSearchDTO dto) throws ServiceException {
		ROLResult rolResult = hubService.getFamiliasByFilter(dto);
		
		rolResult.setObject(sortFamiliaByDefault((List<FamiliaDTO>) rolResult.getObject()));
		
		return rolResult;
	}

	private List<FamiliaDTO> sortFamiliaByDefault(List<FamiliaDTO> familias) {
		List<FamiliaDTO> result = new ArrayList<FamiliaDTO>();

		final Collator collator = Collator.getInstance(locale);
		
		Set<FamiliaDTO> sortedStringFamilias = new TreeSet<FamiliaDTO>(new Comparator<FamiliaDTO>() {
			@Override
			public int compare(FamiliaDTO first, FamiliaDTO second) {
				return collator.compare(first.getClase().getDescripcion(), second.getClase().getDescripcion());
			}
		});
		
		sortedStringFamilias.addAll(familias);
		
		result.addAll(sortedStringFamilias);
		
		return result;
	}
	
	@Override
	public ROLResult getHash(String value) {
		int hash = INITIAL_HASH_VALUE;
		String tmp = value.toUpperCase();
		
		for (int i = 0; i < tmp.length(); i++) {
			hash = ((hash << OFFSET) + hash) + tmp.charAt(i);
		}
		
		ROLResult rolResult = handleResult((Object) String.valueOf(hash));
		
		return rolResult;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ROLResult getItemsOrdenamientoAviso(ItemOrdenamientoAvisoSearchDTO dto) throws ServiceException {
		ROLResult rolResult = hubService.getItemsOrdenamientoAviso(dto);
		
		if (dto.getCodigoOrdenamientoAviso().equalsIgnoreCase(ORDENAMIENTO_AVISO_CODIGO_ANIO_DE_PATENTAMIENTO)) {
			rolResult.setObject(sortOrdenamientoAvisoAnio((List<ItemOrdenamientoAvisoDTO>) rolResult.getObject()));
		} else if (dto.getCodigoOrdenamientoAviso().equalsIgnoreCase(CODIGO_ORDENAMIENTO_AVISO_AMBIENTES)) {
			rolResult.setObject(sortOrdenamientoAvisoAmbientes((List<ItemOrdenamientoAvisoDTO>) rolResult.getObject()));
		} else {
			rolResult.setObject(sortOrdenamientoAvisoByDefault((List<ItemOrdenamientoAvisoDTO>) rolResult.getObject()));
		}
		
		return rolResult;
	}
	
	private List<ItemOrdenamientoAvisoDTO> sortOrdenamientoAvisoAnio(List<ItemOrdenamientoAvisoDTO> itemsOrdenamientoAviso) {
		List<ItemOrdenamientoAvisoDTO> result = new ArrayList<ItemOrdenamientoAvisoDTO>();

		Map<Integer, ItemOrdenamientoAvisoDTO> sortedIntegerItems = new TreeMap<Integer, ItemOrdenamientoAvisoDTO>(new Comparator<Integer>() {
			@Override
			public int compare(Integer first, Integer second) {
				return second.compareTo(first);
			}
		});

		String okmItemDescripcion = null;
		
		for (ItemOrdenamientoAvisoDTO itemOrdenamientoAviso : itemsOrdenamientoAviso) {
			String value = itemOrdenamientoAviso.getDescripcion();
			boolean isNotDigit = false;
			
			for (char character : value.toCharArray()) {
				if (!Character.isDigit(character)) {
					isNotDigit = true;
					
					break;
				}
			}

			if (isNotDigit) {
				if (itemOrdenamientoAviso.getValor().equalsIgnoreCase(ITEM_ORDENAMIENTO_AVISO_VALOR_OKM)) {
					sortedIntegerItems.put(ITEM_ORDENAMIENTO_AVISO_VALOR_OKM_INDEX, itemOrdenamientoAviso);
					okmItemDescripcion =  itemOrdenamientoAviso.getDescripcion();
				}
			} else {
				sortedIntegerItems.put(Integer.valueOf(value), itemOrdenamientoAviso);
			}
		}
		
		result.addAll(sortedIntegerItems.values());
		Collections.rotate(result, result.size() - result.indexOf(okmItemDescripcion));
		
		return result;
	}
	
	private List<ItemOrdenamientoAvisoDTO> sortOrdenamientoAvisoByDefault(List<ItemOrdenamientoAvisoDTO> itemsOrdenamientoAviso) {
		List<ItemOrdenamientoAvisoDTO> result = new ArrayList<ItemOrdenamientoAvisoDTO>();

		Map<String, ItemOrdenamientoAvisoDTO> sortedStringItems = new TreeMap<String, ItemOrdenamientoAvisoDTO>(new Comparator<String>() {
			@Override
			public int compare(String first, String second) {
				return first.compareTo(second);
			}
		});

		for (ItemOrdenamientoAvisoDTO itemOrdenamientoAviso : itemsOrdenamientoAviso) {
			String value = itemOrdenamientoAviso.getValor();
			
			sortedStringItems.put(value, itemOrdenamientoAviso);
		}
		
		result.addAll(sortedStringItems.values());
		
		return result;
	}

	private List<ItemOrdenamientoAvisoDTO> sortOrdenamientoAvisoAmbientes(List<ItemOrdenamientoAvisoDTO> itemsOrdenamientoAviso) {
		List<ItemOrdenamientoAvisoDTO> result = new ArrayList<ItemOrdenamientoAvisoDTO>();

		Map<Integer, ItemOrdenamientoAvisoDTO> sortedIntegerItems = new TreeMap<Integer, ItemOrdenamientoAvisoDTO>(new Comparator<Integer>() {
			@Override
			public int compare(Integer first, Integer second) {
				return first.compareTo(second);
			}
		});
		
		Map<String, ItemOrdenamientoAvisoDTO> sortedStringItems = new TreeMap<String, ItemOrdenamientoAvisoDTO>(new Comparator<String>() {
			@Override
			public int compare(String first, String second) {
				return first.compareTo(second);
			}
		});

		for (ItemOrdenamientoAvisoDTO itemOrdenamientoAviso : itemsOrdenamientoAviso) {
			String value = itemOrdenamientoAviso.getValor();
			
			if (value.contains(ITEM_ORDENAMIENTO_AVISO_CONTAINS_VALOR_AMB)) {
				int index = value.indexOf(ITEM_ORDENAMIENTO_AVISO_CONTAINS_VALOR_AMB);
				
				sortedIntegerItems.put(Integer.valueOf(value.substring(0, index)), itemOrdenamientoAviso);
			} else {
				sortedStringItems.put(value, itemOrdenamientoAviso);
			}
		}
		
		result.addAll(sortedIntegerItems.values());
		
		if (!sortedStringItems.isEmpty()) {
			result.addAll(sortedStringItems.values());
		}
		
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ROLResult getLimiteCotizacionExedido(LimiteCotizacionDTO dto) throws ServiceException {
		PropiedadDefaultSearchDTO propiedadDefaultSearch = DTOFactory.createPropiedadDefaultSearch(
				Arrays.asList(new String[] {PropiedadDefaultName.ROL_LIMITE_COTIZACION_DIRECCION_REQUERIDA.name()}));
		
		List<PropiedadDefaultDTO> propiedadesDefault = (List<PropiedadDefaultDTO>) hubService.getPropiedadesDefault(propiedadDefaultSearch).getObject();
		
		Double limiteCotizacionDireccion = Double.valueOf(propiedadesDefault.iterator().next().getValor());
		
		return handleResult(limiteCotizacionDireccion);
	}

	@Override
	@SuppressWarnings("unchecked")
	public ROLResult getLocalidades(ProvinciaDTO dto) throws ServiceException {
		ROLResult rolResult = hubService.getLocalidades(dto);
		
		rolResult.setObject(sortLocalidades((List<LocalidadDTO>) rolResult.getObject()));
		
		return rolResult;
	}

	private List<LocalidadDTO> sortLocalidades(List<LocalidadDTO> localidades) {
		List<LocalidadDTO> result = new ArrayList<LocalidadDTO>();

		final Collator collator = Collator.getInstance(locale);
		
		Set<LocalidadDTO> sortedIntegerLocalidades = new TreeSet<LocalidadDTO>(new Comparator<LocalidadDTO>() {
			@Override
			public int compare(LocalidadDTO first, LocalidadDTO second) {
				return first.getCodigo().compareTo(second.getCodigo());
			}
		});
		
		Set<LocalidadDTO> sortedStringLocalidades = new TreeSet<LocalidadDTO>(new Comparator<LocalidadDTO>() {
			@Override
			public int compare(LocalidadDTO first, LocalidadDTO second) {
				return collator.compare(first.getCodigo(), second.getCodigo());
			}
		});
		
		for (LocalidadDTO localidad : localidades) {
			String value = localidad.getCodigo();
			
			if (!Character.isDigit(value.toCharArray()[0])) {
				sortedStringLocalidades.add(localidad);
			} else {
				sortedIntegerLocalidades.add(localidad);
			}
		}
		
		result.addAll(sortedStringLocalidades);
		
		if (!sortedIntegerLocalidades.isEmpty()) {
			result.addAll(sortedIntegerLocalidades);
		}
		
		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ROLResult getOrdenesPublicacionByCapturador(CapturadorCRUDDTO dto) throws ServiceException {
		ROLResult rolResult = hubService.getOrdenesPublicacionByCapturador(dto);
		
		if (!rolResult.hasErrors()) {
			List<OrdenPublicacionDTO> ordenesPublicacion = (List<OrdenPublicacionDTO>) rolResult.getObject();

			for (OrdenPublicacionDTO ordenPublicacion : ordenesPublicacion) {
				for (ConceptoVendibleDTO conceptoVendible : ordenPublicacion.getConceptosVendibles()) {
					for (ItemConceptoVendibleDTO itemConceptoVendible : conceptoVendible.getItemsConceptoVendible()) {
						Collections.sort(itemConceptoVendible.getItemsAviso(), new DefaultItemAvisoFechaPublicacionComparator());
					}
				}
			}
			
			Collections.sort((List<OrdenPublicacionDTO>) rolResult.getObject(), new DefaultOrdenPublicacionFechaPublicacionComparator());
		}
		
		return rolResult;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ROLResult getPaises() throws ServiceException {
		ROLResult rolResult = hubService.getPaises();
		
		rolResult.setObject(sortPaises((List<PaisDTO>) rolResult.getObject()));
		
		return rolResult;
	}
	
	private List<PaisDTO> sortPaises(List<PaisDTO> paises) {
		List<PaisDTO> result = new ArrayList<PaisDTO>();

		final Collator collator = Collator.getInstance(locale);
		
		Set<PaisDTO> sortedStringPaises = new TreeSet<PaisDTO>(new Comparator<PaisDTO>() {
			@Override
			public int compare(PaisDTO first, PaisDTO second) {
				return collator.compare(first.getCodigo(), second.getCodigo());
			}
		});
		
		sortedStringPaises.addAll(paises);
		
		result.addAll(sortedStringPaises);
		
		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ROLResult getProvincias(PaisDTO dto) throws ServiceException {
		ROLResult rolResult = hubService.getProvincias(dto);
		
		rolResult.setObject(sortProvincias((List<ProvinciaDTO>) rolResult.getObject()));
		
		return rolResult;
	}

	private List<ProvinciaDTO> sortProvincias(List<ProvinciaDTO> provincias) {
		List<ProvinciaDTO> result = new ArrayList<ProvinciaDTO>();

		final Collator collator = Collator.getInstance(locale);
		
		Set<ProvinciaDTO> sortedStringProvincias = new TreeSet<ProvinciaDTO>(new Comparator<ProvinciaDTO>() {
			@Override
			public int compare(ProvinciaDTO first, ProvinciaDTO second) {
				return collator.compare(first.getCodigo(), second.getCodigo());
			}
		});
		
		sortedStringProvincias.addAll(provincias);
		
		result.addAll(sortedStringProvincias);
		
		return result;
	}
	
	@Override
	public ROLResult getServerTime() {
		ROLResult rolResult = handleResult((Object) new Date().getTime());
		
		return rolResult;
	}

	@Override
	public ROLResult getUUID() {
		ROLResult rolResult = handleResult((Object) UUID.randomUUID().toString());
		
		return rolResult;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ROLResult getTemplatesDetallado(TemplateDetalladoSearchDTO dto) throws ServiceException {
		ROLResult rolResult = hubService.getTemplatesDetallado(dto);
		
		rolResult.setObject(sortProductoComercialTemplates((List<ProductoComercialTemplateDTO>) rolResult.getObject()));
		
		return rolResult;
	}
	
	private List<ProductoComercialTemplateDTO> sortProductoComercialTemplates(List<ProductoComercialTemplateDTO> productoComercialTemplates) {
		List<ProductoComercialTemplateDTO> result = new ArrayList<ProductoComercialTemplateDTO>();

		Set<ProductoComercialTemplateDTO> sortedStringProductoComercialTemplates = new TreeSet<ProductoComercialTemplateDTO>(new Comparator<ProductoComercialTemplateDTO>() {
			@Override
			public int compare(ProductoComercialTemplateDTO first, ProductoComercialTemplateDTO second) {
				return first.getTemplateDetallado().getOrden().compareTo(second.getTemplateDetallado().getOrden());
			}
		});
		
		sortedStringProductoComercialTemplates.addAll(productoComercialTemplates);
		
		result.addAll(sortedStringProductoComercialTemplates);
		
		return result;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ROLResult loginUsuario(UsuarioDTO dto, boolean usuarioMigrado) throws ServiceException {
		getLogger().info("Logueando usuario...");
		
		ROLResult rolResult = null;
		
		/*PropiedadDefaultSearchDTO propiedadDefaultSearch = DTOFactory.createPropiedadDefaultSearch(
				Arrays.asList(new String[] {PropiedadDefaultName.ROL_MAX_INTENTOS_LOGIN.name()}));
		
		List<PropiedadDefaultDTO> propiedadesDefault = (List<PropiedadDefaultDTO>) hubService.getPropiedadesDefault(propiedadDefaultSearch).getObject();
		
		Integer cantidadMaximaIntentos = Integer.valueOf(propiedadesDefault.iterator().next().getValor());
		
		if (dto.getCantidadIntentosLogin() < cantidadMaximaIntentos	|| checkCaptchaValidado(dto.getCaptcha())) {
			PASEUsuarioDTO paseUsuario = DTOFactory.createPASEUsuario(null, null, null, null, null, dto.getEmail(), dto.getPalabraClave());
			
			rolResult = paseService.autenticar(paseUsuario);
	
			if (!rolResult.hasErrors()) {
				dto.setCantidadIntentosLogin(0);
				
				UsuarioCompuestoDTO usuarioCompuesto = (UsuarioCompuestoDTO) rolResult.getObject();
				
				switch (usuarioCompuesto.getPASEUsuario().getEstado()) {
				case ACTIVO :
					CapturadorCRUDDTO capturadorCRUD = DTOFactory.createCapturadorCRUD(null, null, null, null, null,
							null, null, null, null, null, null, null, usuarioCompuesto.getPASEUsuario().getUid());
					
					ROLResult tmpResult = hubService.getCapturador(capturadorCRUD);
					
					if (tmpResult.getObject() != null) {
						usuarioCompuesto.setCapturador((CapturadorDTO) tmpResult.getObject());
						
						getLogger().info("Usuario logueado.");
					} else {
						rolResult.addError(ROLErrorType.REDIRECTION, "El usuario no existe en HUB.");
					}
					
					break;
					
				case CREADO:
					rolResult.addError(ROLErrorType.VALIDATION, "Falta que confirmes tu correo electrónico.");
					
					break;
					
				case CANCELADO:
					rolResult.addError(ROLErrorType.VALIDATION, "El usuario está cancelado.");
					
					break;
				}
				
			} else {
				dto.setCantidadIntentosLogin(dto.getCantidadIntentosLogin() + 1);
				
				if (dto.getCantidadIntentosLogin() >= cantidadMaximaIntentos) {
					rolResult.addError(ROLErrorType.SECURITY, "validateCaptcha");
				}
			}
		} else {
			dto.setCantidadIntentosLogin(dto.getCantidadIntentosLogin() + 1);
			rolResult = handleResult(ROLErrorType.SECURITY, "No coincide el captcha.");
		}*/

		rolResult = new ROLResult();
		UsuarioCompuestoDTO usuarioCompuesto = new UsuarioCompuestoDTO();
		
		PASEUsuarioDTO usuarioExterno = new PASEUsuarioDTO();
		usuarioExterno.setUid(dto.getUsuarioExternoCodigo());
		
		usuarioCompuesto.setPASEUsuario(usuarioExterno);
		//usuarioCompuesto.setCapturador(capturador);
		
		CapturadorCRUDDTO capturadorCRUD = DTOFactory.createCapturadorCRUD(null, null, null, null, null,
				null, null, null, null, null, null, null, usuarioCompuesto.getPASEUsuario().getUid(), null, null);
		
		ROLResult tmpResult = hubService.getCapturador(capturadorCRUD);
		
		if (tmpResult.getObject() != null) {
			CapturadorDTO capturador = (CapturadorDTO) tmpResult.getObject();
			
			if(usuarioMigrado) { // Es usuario migrado de PASE
				boolean actualizarCapturador = false;
				
				if (capturador.getFechaNacimiento() == null && dto.getFechaNacimiento() != null && dto.getFechaNacimiento() != "") {
					capturadorCRUD.setFechaNacimiento(dto.getFechaNacimiento());
					actualizarCapturador = true;
				}
				if (capturador.getSexo() == null && dto.getGenero() != null && dto.getGenero() != "") {
					capturadorCRUD.setSexo(dto.getGenero().toUpperCase());
					actualizarCapturador = true;
				}
				
				if (actualizarCapturador) {
					tmpResult = hubService.updateSexoFechaCapturador(capturadorCRUD);
				}
				
			}
			
			usuarioCompuesto.setCapturador((CapturadorDTO)tmpResult.getObject());
			rolResult.setObject(usuarioCompuesto);
			getLogger().info("Usuario logueado.");
		} else {
			rolResult.addError(ROLErrorType.REDIRECTION, "El usuario no existe en HUB.");
		}
		
		return rolResult;
	}
	
	private Boolean checkCaptchaValidado(CaptchaDTO captcha) {
		return ((String) getHash(captcha.getInputValue()).getObject()).equals(captcha.getHashValue());
	}

//	@Override
//	public ROLResult saveUsuario(UsuarioDTO dto) throws ServiceException {
//		getLogger().info("Guardando usuario...");
//		
//		PASEUsuarioDTO paseUsuario = DTOFactory.createPASEUsuario(null, dto.getApellido(), dto.getNombre(), dto.getGenero(),
//				dto.getFechaNacimiento(), dto.getEmail(), dto.getPalabraClave());
//		
//		ROLResult rolResult = paseService.registrar(paseUsuario);
//
//		if (!rolResult.hasErrors()) {
//			UsuarioCompuestoDTO usuarioCompuesto = (UsuarioCompuestoDTO) rolResult.getObject();
//			
//			CapturadorCRUDDTO capturadorCRUD = DTOFactory.createCapturadorCRUD(dto.getApellido(), dto.getNombre(),
//					dto.getCodigoTipoDocumento(), dto.getNumeroDocumento(), dto.getEmail(), dto.getCodigoCliente(),
//					null, dto.getCodigoTipoAnunciante(), dto.getCodigoPerfilAnunciante(), dto.getCodigoCanalEntrada(), dto.getCodigoTipoIVA(),
//					dto.getCodigoMedioPagoPrincipal(), usuarioCompuesto.getPASEUsuario().getUid());
//
//			ROLResult tmpResult = hubService.saveCapturador(capturadorCRUD);
//			
//			if (tmpResult.getObject() != null) {
//				usuarioCompuesto.setCapturador((CapturadorDTO) tmpResult.getObject());
//				
//				getLogger().info("Usuario guardado.");
//			}
//		}
//
//		return rolResult;
//	}

	@Override
	public ROLResult updateUsuario(UsuarioDTO dto) throws ServiceException {
//		getLogger().info("Actualizando usuario...");
//		
//		PASEUsuarioDTO paseUsuario = null;
//		ROLResult rolResult = null;
//		
//		boolean hasPalabraClave = !DataTypeUtil.isEmpty(dto.getPalabraClave());
//		
//		// Indica que el usuario quiere cambiar su contraseña.
//		if (hasPalabraClave) {
//			paseUsuario = DTOFactory.createPASEUsuario(null, null, null, null, null, dto.getEmail(), dto.getPalabraClave());
//			
//			rolResult = paseService.autenticar(paseUsuario);
//		}
//
//		if (!hasPalabraClave || !rolResult.hasErrors()) {
//			paseUsuario = DTOFactory.createPASEUsuario(dto.getUid(), dto.getApellido(), dto.getNombre(), dto.getGenero(),
//					dto.getFechaNacimiento(), null, ((hasPalabraClave) ? dto.getPalabraClaveNueva() : null));
//			
//			rolResult = paseService.modificar(paseUsuario);
//			
//			if (!rolResult.hasErrors()) {
//				CapturadorCRUDDTO capturadorCRUD = DTOFactory.createCapturadorCRUD(dto.getApellido(), dto.getNombre(),
//						dto.getCodigoTipoDocumento(), dto.getNumeroDocumento(), dto.getEmail(), dto.getCodigoCliente(),
//						dto.getCodigoAnunciante(), dto.getCodigoTipoAnunciante(), null, null, null, null, null);
//				
//				ROLResult tmpResult = hubService.updateCapturador(capturadorCRUD);
//				
//				if (tmpResult.getObject() != null) {
//					((UsuarioCompuestoDTO) rolResult.getObject()).setCapturador((CapturadorDTO) tmpResult.getObject());
//					
//					getLogger().info("Usuario actualizado.");
//				} else {
//					rolResult.addErrors(tmpResult.getErrors());
//				}
//			}
//		}
//
//		return rolResult;
		
		
		getLogger().info("Actualizando usuario...");
		
		PASEUsuarioDTO paseUsuario = null;
		ROLResult rolResult = new ROLResult();
		rolResult.setObject(new UsuarioCompuestoDTO());

		paseUsuario = DTOFactory.createPASEUsuario(dto.getUid(), dto.getApellido(), dto.getNombre(), dto.getGenero(),
				dto.getFechaNacimiento(), null, null);
		
		((UsuarioCompuestoDTO) rolResult.getObject()).setPASEUsuario(paseUsuario);
		
		CapturadorCRUDDTO capturadorCRUD = DTOFactory.createCapturadorCRUD(dto.getApellido(), dto.getNombre(),
				dto.getCodigoTipoDocumento(), dto.getNumeroDocumento(), dto.getEmail(), dto.getCodigoCliente(),
				dto.getCodigoAnunciante(), dto.getCodigoTipoAnunciante(), null, null, null, null, null, dto.getGenero(), dto.getFechaNacimiento());
		
		ROLResult tmpResult = hubService.updateCapturador(capturadorCRUD);
		
		if (tmpResult.getObject() != null) {
			((UsuarioCompuestoDTO) rolResult.getObject()).setCapturador((CapturadorDTO) tmpResult.getObject());
			
			getLogger().info("Usuario actualizado.");
		} else {
			rolResult.addErrors(tmpResult.getErrors());
		}

		return rolResult;
	}
	
	@Override
	public ROLResult updateUsuarioPASE(UsuarioDTO dto) throws ServiceException {
		/*getLogger().info("Actualizando usuario PASE y guardando en HUB...");
		
		PASEUsuarioDTO paseUsuario = null;
		ROLResult rolResult = null;
		
		paseUsuario = DTOFactory.createPASEUsuario(dto.getUid(), dto.getApellido(), dto.getNombre(), dto.getGenero(),
				dto.getFechaNacimiento(), null, null);
		
		rolResult = paseService.modificar(paseUsuario);
		
		if (!rolResult.hasErrors()) {
			CapturadorCRUDDTO capturadorCRUD = DTOFactory.createCapturadorCRUD(dto.getApellido(), dto.getNombre(),
					dto.getCodigoTipoDocumento(), dto.getNumeroDocumento(), dto.getEmail(), dto.getCodigoCliente(),
					dto.getCodigoAnunciante(), dto.getCodigoTipoAnunciante(), "OTRO", dto.getCodigoCanalEntrada(), dto.getCodigoTipoIVA(), 
					dto.getCodigoMedioPagoPrincipal(), dto.getUid());
			
			ROLResult tmpResult = hubService.saveCapturador(capturadorCRUD);
			
			if (tmpResult.getObject() != null) {
				((UsuarioCompuestoDTO) rolResult.getObject()).setCapturador((CapturadorDTO) tmpResult.getObject());
				
				getLogger().info("Usuario actualizado.");
			} else {
				rolResult.addErrors(tmpResult.getErrors());
			}
		}*/
		
		//Anulo todo el update de pase y limpio a solo dejar el de HUB
		getLogger().info("Guardando el usuario en HUB...");
		
		UsuarioCompuestoDTO usuarioCompuestoDTO = new UsuarioCompuestoDTO();
		usuarioCompuestoDTO.setPASEUsuario(new PASEUsuarioDTO());
		
		ROLResult rolResult = new ROLResult();
		rolResult.setObject(usuarioCompuestoDTO);
		
		CapturadorCRUDDTO capturadorCRUD = DTOFactory.createCapturadorCRUD(dto.getApellido(), dto.getNombre(),
				dto.getCodigoTipoDocumento(), dto.getNumeroDocumento(), dto.getEmail(), dto.getCodigoCliente(),
				dto.getCodigoAnunciante(), dto.getCodigoTipoAnunciante(), "OTRO", dto.getCodigoCanalEntrada(), dto.getCodigoTipoIVA(), 
				dto.getCodigoMedioPagoPrincipal(), dto.getUid(), dto.getGenero(), dto.getFechaNacimiento());
		
		ROLResult tmpResult = hubService.saveCapturador(capturadorCRUD);
		
		if (tmpResult.getObject() != null) {
			((UsuarioCompuestoDTO) rolResult.getObject()).setCapturador((CapturadorDTO) tmpResult.getObject());
			
			getLogger().info("Usuario actualizado.");
		} else {
			rolResult.addErrors(tmpResult.getErrors());
		}
		
		return rolResult;
	}

	@Override
	public ROLResult updateEstadoAvisoWithSuspender(Long idAviso) throws ServiceException {
		UpdateEstadoAvisoDTO dto = DTOFactory.createUpdateEstadoAviso(idAviso, SUSPENDER_AVISO_ACCION, null,
				"Aviso " + idAviso + " suspendido por usuario desde aplicación ROL.");
		
		ROLResult result = hubService.updateEstadoAviso(dto);
		
		if(result.getErrors().isEmpty()){
			//como lo que recibe es la orden, me quedo con el aviso
			for(ConceptoVendibleDTO concepto : ((OrdenPublicacionDTO)result.getObject()).getConceptosVendibles()){
				for(ItemConceptoVendibleDTO itemConcepto :concepto.getItemsConceptoVendible()){
					for(ItemAvisoDTO itemAviso : itemConcepto.getItemsAviso()){
						AvisoDTO aviso = itemAviso.getAviso();
						if(aviso.getId().equals(idAviso)){
							result = handleResult(aviso);
						}
					}
				}
			}
		}
		
		return result;
	}

	@Override
	public ROLResult updateEstadoAvisoWithReactivar(Long idAviso) throws ServiceException {
		UpdateEstadoAvisoDTO dto = DTOFactory.createUpdateEstadoAviso(idAviso, REACTIVAR_AVISO_ACCION, null,
				"Aviso " + idAviso + " reactivado por usuario desde aplicación ROL.");
		
		ROLResult result = hubService.updateEstadoAviso(dto);
		
		if (result.getErrors().isEmpty()) {
			// Como lo que recibe es la orden, me quedo con el aviso.
			for (ConceptoVendibleDTO concepto : ((OrdenPublicacionDTO) result.getObject()).getConceptosVendibles()) {
				for (ItemConceptoVendibleDTO itemConcepto :concepto.getItemsConceptoVendible()) {
					for (ItemAvisoDTO itemAviso : itemConcepto.getItemsAviso()) {
						AvisoDTO aviso = itemAviso.getAviso();
						
						if (aviso.getId().equals(idAviso)) {
							result = handleResult(aviso);
						}
					}
				}
			}
		}
		
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ROLResult validatePromocion365(ValidarPromocionesDTO dto) throws ServiceException {
		getLogger().info("Validando promoción 365...");
		
		ROLResult rolResult = null;
		
		PropiedadDefaultSearchDTO propiedadDefaultSearch = DTOFactory.createPropiedadDefaultSearch(
				Arrays.asList(new String[] {PropiedadDefaultName.ROL_MAX_INTENTOS_PROMOCION365.name()}));
		
		List<PropiedadDefaultDTO> propiedadesDefault = (List<PropiedadDefaultDTO>) hubService.getPropiedadesDefault(propiedadDefaultSearch).getObject();
		
		Integer cantidadMaximaIntentos = Integer.valueOf(propiedadesDefault.iterator().next().getValor());
		
		if (dto.getCantidadIntentos() < cantidadMaximaIntentos || checkCaptchaValidado(dto.getCaptcha())) {
			// Las promociones aplicables cuando no se envian se deja en null la lista - vdenicolo 24/02/2014
			rolResult = validatePromociones(dto);
			
			// Recibe una promoción.
			if (!rolResult.hasErrors()) {
				((ValidarPromocionesDTO) rolResult.getObject()).setCantidadIntentos(0);
				
				getLogger().info("Promoción 365 validada.");
			} else {
				((ValidarPromocionesDTO) rolResult.getObject()).setCantidadIntentos(dto.getCantidadIntentos() + 1);
				
				if (dto.getCantidadIntentos() >= cantidadMaximaIntentos) {
					rolResult.addError(ROLErrorType.SECURITY, "validateCaptcha");
				}
			}
		} else {
			rolResult = handleResult(dto);
			
			((ValidarPromocionesDTO) rolResult.getObject()).setCantidadIntentos(dto.getCantidadIntentos() + 1);

			rolResult.addError(ROLErrorType.SECURITY, "No coincide el captcha.");
		}
		
		return rolResult;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public ROLResult validatePromociones(ValidarPromocionesDTO dto) throws ServiceException {
		getLogger().info("Validando promociones...");
		
		ROLResult rolResult = hubService.validatePromociones(DTOFactory.createValidarPromociones(dto.getOrdenPublicacion(),dto.getPromocionesAplicables()));
		
		dto.setPromocionesAplicables((List<PromocionDTO>) rolResult.getObject());

		if (!rolResult.hasErrors()) {
			rolResult = handleResult(dto);
			
			for (PromocionDTO promocion : ((ValidarPromocionesDTO) rolResult.getObject()).getPromocionesAplicables()) {
				for (ValidacionPromocionDTO validacionPromocion : promocion.getValidacionPromocion()) {
					if (!validacionPromocion.getValida()) {
						rolResult.addError(ROLErrorType.VALIDATION, validacionPromocion.getMotivoInvalidez());
					}
				}
			}
		} else {
			rolResult = handleResult(dto, rolResult);
		}
		
		getLogger().info("Promociones validadas.");
		
		return rolResult;
	}
	
	@SuppressWarnings("unchecked")
	public ModelCrearAvisoDTO republishOrdenPublicacion(Long idOrdenPublicacion) throws ServiceException {
		ModelCrearAvisoDTO modelDTO = new ModelCrearAvisoDTO();
		
		// Obtiene orden publicación.
		PrimitiveDTO<Long> id = DTOFactory.createPrimitiveDTO("idOrdenPublicacion", idOrdenPublicacion);
		OrdenPublicacionDTO dto = (OrdenPublicacionDTO) hubService.getOrdenPublicacionById(id).getObject();
		
		// Modifica orden publicación.
		dto.setId(null);
		dto.setUuidGenerarOrden(UUID.randomUUID().toString());
		dto.setFechaAlta(new Date());
		// Limpio las transacciones para el republicar ya que interpreta que esta paga sino y la toma como editar
		dto.setTransaccionActual(null);
		dto.setTransacciones(new ArrayList<GWPTransaccionDTO>());
		
		ConceptoVendibleDTO conceptoVendible = dto.getConceptosVendibles().iterator().next();
		conceptoVendible.setId(null);
		
		ItemConceptoVendibleDTO itemCV = conceptoVendible.getItemsConceptoVendible().iterator().next();
		itemCV.setId(null);
		ItemAvisoDTO itemAviso = itemCV.getItemsAviso().iterator().next();
		itemAviso.setId(null);
		
		AvisoDTO aviso = itemAviso.getAviso();
		aviso.setFechaPedidoPublicacion(null);
		aviso.setAvisoRepublicado(aviso.getId());
		aviso.setId(null);
		aviso.setAvisoPromocion(new ArrayList<AvisoPromocionDTO>());
		aviso.setAtributosAviso(new ArrayList<AtributoAvisoDTO>());
		aviso.setTextoJustificado("");
		aviso.setTextoLibreJustificado("");
		aviso.setEstado(DEFAULT_ESTADO_AVISO);
		aviso.setIdNUP(DEFAULT_ID_NUP_VALUE);
		aviso.setPreview(null);
		
		String codigoProductoComercial = aviso.getProductoComercial().getCodigo();
		String codigoNivelEstructura = aviso.getNivelEstructura().getCodigo();
		String codigoProducto = aviso.getProductoComercial().getProducto().getCodigo();
		String codigoTemplateDetallado = aviso.getTemplateDetallado().getCodigo();
		
		itemCV.setItemsAviso(new ArrayList<ItemAvisoDTO>());
		itemCV.getItemsAviso().add(itemAviso);
		
		conceptoVendible.setItemsConceptoVendible(new ArrayList<ItemConceptoVendibleDTO>());
		conceptoVendible.getItemsConceptoVendible().add(itemCV);
		
		dto.setConceptosVendibles(new ArrayList<ConceptoVendibleDTO>());
		dto.getConceptosVendibles().add(conceptoVendible);
		dto.setCodigoMedioDePago(DEFAULT_MEDIO_PAGO);
		
		// Valida vigencia.
		hubService.validateVigencia(DTOFactory.createValidateVigencia(codigoProductoComercial, codigoNivelEstructura, codigoProducto)).getObject();
		
		ClaseSearchDTO claseSearch = DTOFactory.createClaseSearchDTO("ROL", aviso.getCodigoClase(), new Date());
		ClaseDTO claseFamilia = ((ArrayList<ClaseDTO>) hubService.getFamiliaByClaseAviso(claseSearch).getObject()).iterator().next();
		PrimitiveDTO<String> codigoClase = DTOFactory.createPrimitiveDTO("codigoClase", aviso.getCodigoClase());
		
		ClaseDTO claseAviso = (ClaseDTO) hubService.getClaseByCodigo(codigoClase).getObject();
		
		// Arma modelo antes de redirigir a la acción crear aviso.
		modelDTO.setPrevisualizo(false);
		modelDTO.setCodigoProductoComercial(codigoProductoComercial);
		modelDTO.setCodigoNivelEstructura(codigoNivelEstructura);
		modelDTO.setCodigoProducto(codigoProducto);
		modelDTO.setCodigoTemplateDetallado(codigoTemplateDetallado);
		modelDTO.setStep(STEP_CUANDO);
		modelDTO.setRedirectURL(URL_REDIRECT_CREAR_AVISO);
		modelDTO.setZonasComercializacion(aviso.getZonasComercializacion());
		modelDTO.setOrdenPublicacion(dto);
		modelDTO.setFamilia(claseFamilia);
		modelDTO.setClase(claseAviso);
		modelDTO.setTipoOperacion(aviso.getTipoOperacion());
		
		if (aviso.getTemplateDetallado().getTieneColor()){
			modelDTO.setCodigoTemplateDestaqueSeleccionado(aviso.getTemplateDetallado().getCodigo());		
			modelDTO.setCodigoProductoComercialDestaque(aviso.getProductoComercial().getCodigo());
			modelDTO.setCodigoNivelEstructuraDestaque(aviso.getNivelEstructura().getCodigo());
		}
				
		return modelDTO;
	}
	
	public ROLResult executeActualizarOrdenPublicacionEditada(OrdenPublicacionDTO ordenPublicacion) throws ServiceException {

		ROLResult rolResult = null;
		
		if (ordenPublicacion.getId() == null){
			getLogger().info("uuid: "+ordenPublicacion.getUuidGenerarOrden()+" detectada como nueva ==> ingresando a pagar y guardar");
			rolResult = executePagarAndGuardar(ordenPublicacion);
		} else {
			if (isOrdenPublicacionPaga(ordenPublicacion)){
				getLogger().info("uuid: "+ordenPublicacion.getUuidGenerarOrden()+" detectada existente ==> actualizando orden paga");
				ordenPublicacion.getTransacciones().clear();
				editConceptosVendiblesPagos(ordenPublicacion);
				rolResult = executeActualizar(ordenPublicacion);
			}else {
				getLogger().info("uuid: "+ordenPublicacion.getUuidGenerarOrden()+" detectada existente ==> actualizando orden impaga");
				editConceptosVendiblesImpagos(ordenPublicacion);
				rolResult = executePagarAndActualizar(ordenPublicacion);
			}
		}

		return rolResult;
	}
	
	public ModelCrearAvisoDTO editOrdenPublicacion(Long idOrdenPublicacion) throws ServiceException {
		
		// Obtiene orden publicación.
		PrimitiveDTO<Long> id = DTOFactory.createPrimitiveDTO("idOrdenPublicacion", idOrdenPublicacion);
		OrdenPublicacionDTO dto = (OrdenPublicacionDTO) hubService.getOrdenPublicacionById(id).getObject();
		
		if (isOrdenPublicacionPaga(dto)){			
			Boolean isOrdenFacturadaEnSAP = (Boolean) hubService.validateOrdenFacturadaEnSAP(id).getObject();  
			if (isOrdenFacturadaEnSAP){				
				throw new ServiceException("El aviso no se puede modificar porque ya fue facturado. Por favor comuniquese con el CEAC.");
			}
		}		
		
		ModelCrearAvisoDTO modelDTO = buildModelOnEdit(dto);
		
		return modelDTO;		
	}
	
	
	public ROLResult calculateMontoTotal(List<ConceptoVendibleDTO> conceptosVendibles){
		
		ROLResult rolResult = null;
		Double montoTotal = 0.0;
		
		for (ConceptoVendibleDTO conceptoVendible : conceptosVendibles){
			montoTotal += conceptoVendible.getMontoTotal();
		}
		
		rolResult = handleResult((Object) montoTotal);
		
		return rolResult;		
	}
	
	/**
	 * Edita los conceptos vendibles impagos.
	 */	
	private OrdenPublicacionDTO editConceptosVendiblesImpagos(OrdenPublicacionDTO ordenEditada) throws ServiceException {
		
		List<ConceptoVendibleDTO> conceptosVendiblesOriginales = getConceptosVendiblesPersistidosFromOrden(ordenEditada.getId());
		List<ConceptoVendibleDTO> conceptosVendiblesEditados = ordenEditada.getConceptosVendibles();
		
		for (ConceptoVendibleDTO conceptoVendibleEditado : conceptosVendiblesEditados){
			if (!conceptosVendiblesOriginales.isEmpty()){
				ConceptoVendibleDTO conceptoVendibleOriginal = conceptosVendiblesOriginales.remove(0);
				conceptoVendibleEditado.setId(conceptoVendibleOriginal.getId());
				setAccionModificarEnConceptoVendible(conceptoVendibleEditado);
			} else {				
				setAccionPendientePagoEnConceptoVendible(conceptoVendibleEditado);				
			}			
		}
		if (!conceptosVendiblesOriginales.isEmpty()){
			for (ConceptoVendibleDTO conceptoVendibleOriginal  : conceptosVendiblesOriginales){
				setAccionAnularEnConceptoVendible(conceptoVendibleOriginal);
				conceptosVendiblesEditados.add(conceptoVendibleOriginal);				
			}
		}
		
		return ordenEditada;
	}	
	
	private OrdenPublicacionDTO editConceptosVendiblesPagos(OrdenPublicacionDTO ordenEditada) throws ServiceException {
		
		List<ConceptoVendibleDTO> conceptosVendiblesOriginales = getConceptosVendiblesPersistidosFromOrden(ordenEditada.getId());
		List<ConceptoVendibleDTO> conceptosVendiblesEditados = ordenEditada.getConceptosVendibles();
		
		for (ConceptoVendibleDTO conceptoVendibleEditado : conceptosVendiblesEditados){
			if (!conceptosVendiblesOriginales.isEmpty()){
				ConceptoVendibleDTO conceptoVendibleOriginal = conceptosVendiblesOriginales.remove(0);
				conceptoVendibleEditado.setId(conceptoVendibleOriginal.getId());
				setAccionModificarEnConceptoVendible(conceptoVendibleEditado);
			} else {				
				setAccionSinAutorizarEnConceptoVendible(conceptoVendibleEditado);
			}			
		}
		if (!conceptosVendiblesOriginales.isEmpty()){
			for (ConceptoVendibleDTO conceptoVendibleOriginal  : conceptosVendiblesOriginales){
				setAccionAnularEnConceptoVendible(conceptoVendibleOriginal);
				conceptosVendiblesEditados.add(conceptoVendibleOriginal);				
			}
		}
		
		return ordenEditada;
	}
	
	public boolean isOrdenPublicacionPaga(OrdenPublicacionDTO ordenPublicacion){
		return (ordenPublicacion.getTransaccionActual() != null && ordenPublicacion.getTransaccionActual().getEstado().equals(GWP_TRANSACCION_ESTADO_ACREDITADO)) ? true : false;
	}
	
	public ROLResult getPermisoAtributo(PermisoAtributoSearchDTO permisoAtributoSearch) throws ServiceException {
		
		ROLResult rolResult = hubService.getPermisoAtributoByFilter(permisoAtributoSearch);
		
		rolResult.setObject((AtributoCIDDTO) rolResult.getObject());
		
		return rolResult;
		
	}
		
	@SuppressWarnings("unchecked")
	private ModelCrearAvisoDTO buildModelOnEdit(OrdenPublicacionDTO dto) throws ServiceException {
		
		ModelCrearAvisoDTO modelDTO = new ModelCrearAvisoDTO();
		
		ConceptoVendibleDTO conceptoVendible = dto.getConceptosVendibles().iterator().next();
		ItemConceptoVendibleDTO itemCV = conceptoVendible.getItemsConceptoVendible().iterator().next();
		ItemAvisoDTO itemAviso = itemCV.getItemsAviso().iterator().next();
		AvisoDTO aviso = itemAviso.getAviso();
		
		Boolean isOrdenPublicacionPaga = isOrdenPublicacionPaga(dto);
		
		
		for (ConceptoVendibleDTO conceptoVendibleIt : dto.getConceptosVendibles()){
			if (cleanIdFromConceptoVendible(conceptoVendibleIt)){
				for (ItemConceptoVendibleDTO itemConceptoVendibleIt : conceptoVendibleIt.getItemsConceptoVendible()){
					if (cleanIdFromItemConceptoVendible(itemConceptoVendibleIt)){
						for (ItemAvisoDTO itemAvisoIt : itemConceptoVendibleIt.getItemsAviso()){
							if (cleanIdFromItemAviso(itemAvisoIt)){
								cleanIdFromAviso(itemAvisoIt.getAviso());
								if (isOrdenPublicacionPaga){
									itemAvisoIt.getAviso().setAtributosAviso(filterAtributosAvisos(itemAvisoIt.getAviso().getAtributosAviso()));						
								} else {
									itemAvisoIt.getAviso().setAtributosAviso(new ArrayList<AtributoAvisoDTO>());
								}
							}
						}						
					}
				}				
			}
		}		

		if (isOrdenPublicacionPaga){
			modelDTO.setAgrupadoresAtributoAviso(getAgrupadoresAtributoAviso(aviso.getAtributosAviso()));			
		}
		
		String codigoNivelEstructura = aviso.getNivelEstructura().getCodigo();
		String codigoProducto = aviso.getProductoComercial().getProducto().getCodigo();

		ClaseSearchDTO claseSearch = DTOFactory.createClaseSearchDTO("ROL", aviso.getCodigoClase(), new Date());
		ClaseDTO claseFamilia = ((ArrayList<ClaseDTO>) hubService.getFamiliaByClaseAviso(claseSearch).getObject()).iterator().next();
		PrimitiveDTO<String> codigoClase = DTOFactory.createPrimitiveDTO("codigoClase", aviso.getCodigoClase());
		
		ClaseDTO claseAviso = (ClaseDTO) hubService.getClaseByCodigo(codigoClase).getObject();
				
		// Arma modelo antes de redirigir a la acción crear aviso.
		modelDTO.setPrevisualizo(true);

		modelDTO.setCodigoNivelEstructura(codigoNivelEstructura);
		modelDTO.setCodigoProducto(codigoProducto);

		// Se debe armar una funcion para determinar el paso ya que puede o no tener destaques y ordenamientos. 
		modelDTO.setStep(STEP_CONFIRMACION);
		modelDTO.setRedirectURL(URL_REDIRECT_CREAR_AVISO);
		modelDTO.setZonasComercializacion(aviso.getZonasComercializacion());
		modelDTO.setOrdenPublicacion(dto);
		modelDTO.setFamilia(claseFamilia);
		modelDTO.setClase(claseAviso);
		modelDTO.setTipoOperacion(aviso.getTipoOperacion());
		
		// Obtengo las fechas de todos los avisos (ordenadas).
		List<Date> selectedDates = getSelectedDatesInOrderFromOrdenPublicacion(dto);
		modelDTO.setSelectedDates(selectedDates);

		// Obtengo los ordenamientos del aviso.
		modelDTO.setOrdenamientos(aviso.getOrdenamientos());
		
		ProductoComercialDefaultDTO productoComercialDefaultDTO = new ProductoComercialDefaultDTO();
		productoComercialDefaultDTO.setCodigoCanalEntrada("ROL");
		productoComercialDefaultDTO.setCodigoAgrupamientoProductoTecnico("LINEAL");
		productoComercialDefaultDTO.setCodigoNivelEstructura(codigoNivelEstructura);
		productoComercialDefaultDTO.setCodigoTipoOperacion(aviso.getTipoOperacion().getCodigo());
		ProductoComercialDefaultDTO resultProductoComercialDefaultDTO = (ProductoComercialDefaultDTO) hubService.getProductoComercialDefault(productoComercialDefaultDTO).getObject();
		
		String codigoProductoComercial = resultProductoComercialDefaultDTO.getCodigoProductoComercial();
		String codigoTemplateDetallado = resultProductoComercialDefaultDTO.getCodigoTemplate();
		
		modelDTO.setCodigoProductoComercial(codigoProductoComercial);
		modelDTO.setCodigoTemplateDetallado(codigoTemplateDetallado);
		
		// Obtengo los templates detallados disponibles.
		List<ProductoComercialTemplateDTO> templatesDetallado = getTemplatesDetalladoFromService("LINEAL", 
				"ROL", codigoNivelEstructura, aviso.getTipoOperacion().getCodigo(), selectedDates.get(0));
		modelDTO.setTemplatesDetallado(templatesDetallado);
		
		// Obtengo las configuraciones ordenamiento pantalla.		
		List<ConfiguracionOrdenamientoPantallaDTO> configuracionesOrdenamientoPantalla = getConfiguracionesOrdenamientoPantallaFromService("LINEAL", 
				"ROL", codigoNivelEstructura, aviso.getTipoOperacion().getCodigo(),  selectedDates.get(0));
		modelDTO.setConfiguracionOrdenamientoPantalla(configuracionesOrdenamientoPantalla);
		
		// Obtengo las configuraciones promocion pantalla.
		List<ConfiguracionPromocionPantallaDTO> configuracionesPromocionPantalla = getConfiguracionesPromocionPantallaFromService("ROL", 
				codigoNivelEstructura, codigoProductoComercial, getCodigosZonaComercializacion(aviso.getZonasComercializacion()), selectedDates.get(0));
		modelDTO.setConfiguracionesPromocionPantalla(configuracionesPromocionPantalla);
	
		// Seteo los valores de destaque que corresponden.
		if (aviso.getTemplateDetallado().getTieneColor()){
			modelDTO.setCodigoTemplateDestaqueSeleccionado(aviso.getTemplateDetallado().getCodigo());		
			modelDTO.setCodigoProductoComercialDestaque(aviso.getProductoComercial().getCodigo());
			modelDTO.setCodigoNivelEstructuraDestaque(aviso.getNivelEstructura().getCodigo());
			modelDTO.setTieneFondoColor(aviso.getTemplateDetallado().getTieneColor());
		}	
		
		if (aviso.getMateriales() != null && !aviso.getMateriales().isEmpty()){
			modelDTO.setCodigoImagenDestaqueSeleccionada(aviso.getMateriales().get(0).getCodigo());
			modelDTO.setRepoImagenDestaqueSeleccionada(aviso.getMateriales().get(0).getRepo());
			modelDTO.setCodigoTemplateDestaqueSeleccionado(aviso.getTemplateDetallado().getCodigo());		
			modelDTO.setCodigoProductoComercialDestaque(aviso.getProductoComercial().getCodigo());
			modelDTO.setCodigoNivelEstructuraDestaque(aviso.getNivelEstructura().getCodigo());
		}
		
		return modelDTO;
	}
	
	private List<AtributoAvisoDTO> filterAtributosAvisos(List<AtributoAvisoDTO> atributosAvisos){
		List<AtributoAvisoDTO> result = new ArrayList<AtributoAvisoDTO>();
		for (AtributoAvisoDTO atributoAviso : atributosAvisos){
			if (atributoAviso.getCodigo().equals(AtributoAvisoDTO.CAMPO_TARJETA_CLARIN_365)){
				result.add(atributoAviso);
			}
		}		
		return result;
	}
	
	private List<AgrupadorAtributoAvisoDTO> getAgrupadoresAtributoAviso(List<AtributoAvisoDTO> atributosAvisos){
		List<AgrupadorAtributoAvisoDTO> result = new ArrayList<AgrupadorAtributoAvisoDTO>();
		for (AtributoAvisoDTO atributoAviso : atributosAvisos){
			if (atributoAviso.getCodigo().equals(AtributoAvisoDTO.CAMPO_TARJETA_CLARIN_365)){
				AgrupadorAtributoAvisoDTO agrupadorAtributoAvisoDTO = new AgrupadorAtributoAvisoDTO();
				agrupadorAtributoAvisoDTO.setAtributoAviso(atributoAviso);
				// Le asigno el primer paso desde donde se puede justificar/tasar para que lo pueda asignar a la orden.
				agrupadorAtributoAvisoDTO.setStep(4L);
				result.add(agrupadorAtributoAvisoDTO);
			}
		}
		return result;
	}
	
	private List<String> getCodigosZonaComercializacion(List<ZonaComercializacionDTO> zonasComercializacion){
		List<String> codigosZonaComercializacion = new ArrayList<String>();
		for (ZonaComercializacionDTO zonaComercializacionDTO : zonasComercializacion){
			codigosZonaComercializacion.add(zonaComercializacionDTO.getCodigo());
		}
		return codigosZonaComercializacion;
	}
	
	@SuppressWarnings("unchecked")
	private List<ConfiguracionPromocionPantallaDTO> getConfiguracionesPromocionPantallaFromService(String codigoCanalEntrada, String codigoNivelEstructura, String codigoProductoComercial,
			List<String> codigoZonasComercializacion, Date fechaVigencia) throws ServiceException{

		List<ConfiguracionPromocionPantallaDTO> configuracionesPromocionPantalla = null;
		PromocionSearchDTO promocionSearchDTO = new PromocionSearchDTO();
		
		promocionSearchDTO.setCodigoCanalEntrada(codigoCanalEntrada);
		promocionSearchDTO.setCodigoNivelEstructura(codigoNivelEstructura);
		promocionSearchDTO.setCodigoProductoComercial(codigoProductoComercial);
		promocionSearchDTO.setCodigoZonasComercializacion(codigoZonasComercializacion);
		promocionSearchDTO.setFechaVigencia(fechaVigencia);
		
		configuracionesPromocionPantalla = (ArrayList<ConfiguracionPromocionPantallaDTO>) hubService.getConfiguracionesPromocionPantalla(promocionSearchDTO).getObject();
		
		return configuracionesPromocionPantalla;
	}
		
	@SuppressWarnings("unchecked")
	private List<ProductoComercialTemplateDTO> getTemplatesDetalladoFromService(String codigoAgrupamientoProductoTecnico,
			String codigoCanalEntrada, String codigoNivelEstructura, String codigoTipoOperacion, Date fechaVigencia) throws ServiceException{
		
		List<ProductoComercialTemplateDTO> templatesDetallado = null;
		TemplateDetalladoSearchDTO templateDetalladoSearchDTO = new TemplateDetalladoSearchDTO();
		
		templateDetalladoSearchDTO.setCodigoAgrupamientoProductoTecnico(codigoAgrupamientoProductoTecnico);
		templateDetalladoSearchDTO.setCodigoCanalEntrada(codigoCanalEntrada);
		templateDetalladoSearchDTO.setCodigoNivelEstructura(codigoNivelEstructura);
		templateDetalladoSearchDTO.setCodigoTipoOperacion(codigoTipoOperacion);
		templateDetalladoSearchDTO.setFechaVigencia(fechaVigencia);
		
		templatesDetallado = (ArrayList<ProductoComercialTemplateDTO>) getTemplatesDetallado(templateDetalladoSearchDTO).getObject();
				
		return templatesDetallado;
	}
	
	@SuppressWarnings("unchecked")
	private List<ConfiguracionOrdenamientoPantallaDTO> getConfiguracionesOrdenamientoPantallaFromService(String codigoAgrupamientoProductoTecnico,
			String codigoCanalEntrada, String codigoNivelEstructura, String codigoTipoOperacion, Date fechaVigencia) throws ServiceException{
				
		List<ConfiguracionOrdenamientoPantallaDTO> configuracionesOrdenamientoPantalla = null;
		
		OrdenamientoAvisoSearchDTO ordenamientoAvisoSearchDTO = new OrdenamientoAvisoSearchDTO();
		ordenamientoAvisoSearchDTO.setCodigoAgrupamientoProductoTecnico(codigoAgrupamientoProductoTecnico);
		ordenamientoAvisoSearchDTO.setCodigoCanalEntrada(codigoCanalEntrada);		
		ordenamientoAvisoSearchDTO.setCodigoNivelEstructura(codigoNivelEstructura);
		ordenamientoAvisoSearchDTO.setCodigoTipoOperacion(codigoTipoOperacion);
		ordenamientoAvisoSearchDTO.setFechaVigencia(fechaVigencia);
		
		configuracionesOrdenamientoPantalla = (ArrayList<ConfiguracionOrdenamientoPantallaDTO>) hubService.getConfiguracionesOrdenamientoPantalla(ordenamientoAvisoSearchDTO).getObject();
		
		return configuracionesOrdenamientoPantalla;
	}
			
	private List<Date> getSelectedDatesInOrderFromOrdenPublicacion(OrdenPublicacionDTO orden){
		List<Date> selectedDates = new ArrayList<Date>();
		
		for (ConceptoVendibleDTO cvDTO : orden.getConceptosVendibles()){
			for (ItemConceptoVendibleDTO icvDTO : cvDTO.getItemsConceptoVendible()){
				for (ItemAvisoDTO iaDTO : icvDTO.getItemsAviso()){
					if (iaDTO.getAviso() != null){
						selectedDates.add(iaDTO.getAviso().getFechaPedidoPublicacion());
					}
				}
			}
		}
		
		// Ordeno las fechas
		Collections.sort(selectedDates);
		
		return selectedDates;
	}	
	
	/**
	 * Obtengo los conceptos vendibles del id de la orden pasado como párametro. 
	 */	
	private List<ConceptoVendibleDTO> getConceptosVendiblesPersistidosFromOrden(Long idOrdenPublicacion) throws ServiceException{
		PrimitiveDTO<Long> id = DTOFactory.createPrimitiveDTO("idOrdenPublicacion", idOrdenPublicacion);
		OrdenPublicacionDTO dto = (OrdenPublicacionDTO) hubService.getOrdenPublicacionById(id).getObject();
		return dto.getConceptosVendibles();
	}
		
	private List<AccionSecuenciaDTO> buildAccionesSecuencia(String accion){				
		List<AccionSecuenciaDTO> accionesSecuencia = new ArrayList<AccionSecuenciaDTO>();
		accionesSecuencia.add(DTOFactory.createAccionSecuencia(1L, accion));		
		return accionesSecuencia;
	};
	
	/**
	 * Seteo la accion anular en el concepto pasado por párametro. 
	 */
	private void setAccionAnularEnConceptoVendible(ConceptoVendibleDTO conceptoVendible){
		conceptoVendible.setAcciones(buildAccionesSecuencia(ANULAR_CONCEPTO_ACCION));
	}
	
	/**
	 * Seteo la accion iniciar pendiente de pago en el concepto pasado por párametro.
	 */	
	private void setAccionPendientePagoEnConceptoVendible(ConceptoVendibleDTO conceptoVendible){
		conceptoVendible.setAcciones(buildAccionesSecuencia(INICIAR_PENDIENTE_PAGO_ACCION));
	}
	
	/**
	 * Seteo la accion iniciar pendiente de pago en el concepto pasado por párametro.
	 */	
	private void setAccionModificarEnConceptoVendible(ConceptoVendibleDTO conceptoVendible){
		conceptoVendible.setAcciones(buildAccionesSecuencia(MODIFICAR_CONCEPTO_ACCION));
	}
	
	/**
	 * Seteo la accion iniciar pendiente de pago en el concepto pasado por párametro.
	 */	
	private void setAccionSinAutorizarEnConceptoVendible(ConceptoVendibleDTO conceptoVendible){
		conceptoVendible.setAcciones(buildAccionesSecuencia(INICIAR_SIN_AUTORIZAR_ACCION));
	}	
	
	/**
	 * Limpia los ID's de los conceptos.
	 */	
	private boolean cleanIdFromConceptoVendible(ConceptoVendibleDTO conceptoVendible){		
		if (conceptoVendible != null){
			conceptoVendible.setId(null);
			return true;
		}
		return false;
	}	
		
	/**
	 * Limpia los ID's de los conceptos.
	 */	
	private boolean cleanIdFromItemConceptoVendible(ItemConceptoVendibleDTO itemConceptoVendible){
		if (itemConceptoVendible != null){
			itemConceptoVendible.setId(null);			
			return true;
		}
		return false;		
	}
	
	/**
	 * Limpia los ID's de los conceptos.
	 */	
	private boolean cleanIdFromItemAviso(ItemAvisoDTO itemAviso){
		if (itemAviso != null){
			itemAviso.setId(null);			
			return true;
		}
		return false;
	}
	
	/**
	 * Limpia los ID's de los conceptos.
	 */	
	private boolean cleanIdFromAviso(AvisoDTO aviso){
		if (aviso != null){
			aviso.setId(null);
			return true;
		}
		return false;
	}
		
}
