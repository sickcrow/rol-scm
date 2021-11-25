/*
 * @(#)CrearAvisoController.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.agea.hub.rol.comparator.ConceptoVendibleComparator;
import ar.com.agea.hub.rol.exception.ServiceException;
import ar.com.agea.hub.rol.model.dto.AgrupadorProductoZonasNivelesDTO;
import ar.com.agea.hub.rol.model.dto.AgrupadorProductoZonasNivelesSearchDTO;
import ar.com.agea.hub.rol.model.dto.AtributoCIDDTO;
import ar.com.agea.hub.rol.model.dto.CalendarioSearchDTO;
import ar.com.agea.hub.rol.model.dto.CapturadorCRUDDTO;
import ar.com.agea.hub.rol.model.dto.ClaseDTO;
import ar.com.agea.hub.rol.model.dto.ClaseSearchDTO;
import ar.com.agea.hub.rol.model.dto.ConceptoVendibleDTO;
import ar.com.agea.hub.rol.model.dto.ConfiguracionOrdenamientoPantallaDTO;
import ar.com.agea.hub.rol.model.dto.ItemOrdenamientoAvisoDTO;
import ar.com.agea.hub.rol.model.dto.ItemOrdenamientoAvisoSearchDTO;
import ar.com.agea.hub.rol.model.dto.LimiteCotizacionDTO;
import ar.com.agea.hub.rol.model.dto.ModelCrearAvisoDTO;
import ar.com.agea.hub.rol.model.dto.ModelSearchDTO;
import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;
import ar.com.agea.hub.rol.model.dto.OrdenamientoAvisoSearchDTO;
import ar.com.agea.hub.rol.model.dto.PaisDTO;
import ar.com.agea.hub.rol.model.dto.PermisoAtributoSearchDTO;
import ar.com.agea.hub.rol.model.dto.ProductoComercialDefaultDTO;
import ar.com.agea.hub.rol.model.dto.PromocionSearchDTO;
import ar.com.agea.hub.rol.model.dto.ProvinciaDTO;
import ar.com.agea.hub.rol.model.dto.TarjetaPagoSearchDTO;
import ar.com.agea.hub.rol.model.dto.TemplateDetalladoDTO;
import ar.com.agea.hub.rol.model.dto.TemplateDetalladoSearchDTO;
import ar.com.agea.hub.rol.model.dto.TemplatePrecargaDTO;
import ar.com.agea.hub.rol.model.dto.TemplatePrecargaSearchDTO;
import ar.com.agea.hub.rol.model.dto.TextoValidateDTO;
import ar.com.agea.hub.rol.model.dto.TipoOperacionDTO;
import ar.com.agea.hub.rol.model.dto.TipoOperacionSearchDTO;
import ar.com.agea.hub.rol.model.dto.TrackCampanaDTO;
import ar.com.agea.hub.rol.model.dto.ValidarPromocionesDTO;
import ar.com.agea.hub.rol.model.result.ROLResult;
import ar.com.agea.hub.rol.service.HUBService;
import ar.com.agea.hub.rol.service.ROLService;
import ar.com.agea.hub.rol.utils.Auth0LoginHelper;
import ar.com.agea.hub.rol.utils.ComparatorContext;
import ar.com.agea.hub.rol.utils.SessionNamingName;
import ar.com.agea.hub.rol.utils.URLServiceValidator;
import ar.com.agea.hub.rol.utils.ViewNamingName;

/**
 * Representa la creación de avisos de la aplicación.
 * 
 * @author		Alejandro Javier Di Fiore
 * 				Eduardo Barrera
 * 				Mariano De Nicolo
 * @version		1.0 06/06/2013
 */
@Controller
public class CrearAvisoController extends ROLController {

	@Autowired
	private HUBService hubService;

	@Autowired
	private ROLService rolService;
	
	@Autowired
	private ConceptoVendibleComparator conceptoVendibleComparator;
	
	@Autowired
	private Auth0LoginHelper auth0LoginHelper;
	
	/**
	 * Mapea /crear-aviso a la vista que representa la creación de avisos.
	 * 
	 * @return Vista que representa la creación de avisos.
	 */
	@RequestMapping(value = "/crear-aviso", method = RequestMethod.GET)
	public ModelAndView  showCrearAviso(HttpSession session,
											@RequestParam(value="fuente", required=false) String fuente,
											@RequestParam(value="medio", required=false) String medio,
											@RequestParam(value="campana", required=false) String campana) {
		ModelAndView modelAndView = null;
		
		if (!URLServiceValidator.validarParametroStringOK(fuente) 
				|| !URLServiceValidator.validarParametroStringOK(medio)
				|| !URLServiceValidator.validarParametroStringOK(campana)) {
			modelAndView = getModelAndView(ViewNamingName.PAGINA_NO_ENCONTRADA);
		} else {
			TrackCampanaDTO trackeo = (TrackCampanaDTO)session.getAttribute(SessionNamingName.TRACK_CAMPANA.getName());
			if(trackeo == null){
				session.setAttribute(SessionNamingName.TRACK_CAMPANA.getName(), new TrackCampanaDTO(fuente, medio, campana));
			}else if( (fuente != null && !fuente.equals(trackeo.getFuente())) || 
					(medio != null && !medio.equals(trackeo.getFuente())) || 
					(campana!= null && !campana.equals(trackeo.getCampana())) ){
				session.setAttribute(SessionNamingName.TRACK_CAMPANA.getName(), new TrackCampanaDTO(fuente, medio, campana));
			}
			modelAndView = getModelAndView(ViewNamingName.CREAR_AVISO);	
		}
		
		return modelAndView;
	}
	
	/**
	 * Mapea /getCalendario a la vista que representa el calendario.
	 * 
	 * @param dto Objeto calendario de entrada a partir del cual se obtienen sus fechas disponibles.
	 * @return Vista que representa el calendario.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "getCalendario", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Map<String, ? extends Object> getCalendario(@RequestBody CalendarioSearchDTO dto, HttpSession session) throws ServiceException {
		List<Date> result = (List<Date>) hubService.getCalendario(dto).getObject();		
		
		return Collections.singletonMap("dates", result);		
	}

	/**
	 * Mapea /guardarOrdenPublicacion a la vista que representa el guardado de la orden de publicación.
	 * 
	 * @param dto Objeto orden publicación de entrada a partir de la cual se guardan sus datos
	 *        en HUB mediante los servicios HUB.
	 * @return vista que representa el guardado de la orden de publicación.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "guardarOrdenDePublicacion", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Map<String, ? extends Object> saveOrdenPublicacion(@RequestBody OrdenPublicacionDTO dto, HttpSession session) throws ServiceException {
		List<ConceptoVendibleDTO> tmp = (List<ConceptoVendibleDTO>) session.getAttribute(SessionNamingName.COTIZACION.getName() + dto.getUuidGenerarOrden());

		if (!conceptoVendibleComparator.compareConceptosVendible(tmp, dto.getConceptosVendibles(), new ComparatorContext())) {
			throw new ServiceException("La orden publicaciÃ³n fue adulterada.");
		}
		
		OrdenPublicacionDTO result = (OrdenPublicacionDTO) hubService.saveOrdenPublicacion(dto).getObject();			
				
		// Remuevo los datos de la session.
		session.removeAttribute(SessionNamingName.MODEL.getName() + dto.getUuidGenerarOrden());
		session.removeAttribute(SessionNamingName.COTIZACION.getName() + dto.getUuidGenerarOrden());
		
		// Una vez que se setee la orden cotizada y previsualizada en session se debería borrar de la session también. 
		return Collections.singletonMap("ordenPublicacion", result);
	}
	
	/**
	 * Mapea /guardarOrdenPublicacion a la vista que representa el guardado de la orden de publicación.
	 * 
	 * @param dto Objeto orden publicación de entrada a partir de la cual se guardan sus datos
	 *        en HUB mediante los servicios HUB-API.
	 * @return vista que representa el guardado de la orden de publicación.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "pagarYGuardarOrdenDePublicacion", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Map<String, ? extends Object> executePagarAndGuardarOrdenPublicacion(@RequestBody OrdenPublicacionDTO dto, HttpSession session) throws ServiceException {
		
		//se ponen varios logs para trackear tiempos del servicio
		this.getLogger().info("--- Iniciando el servicio de pagar y guardar orden para la uuid: "+dto.getUuidGenerarOrden()+" ---");
		
		List<ConceptoVendibleDTO> tmp = (List<ConceptoVendibleDTO>) session.getAttribute(SessionNamingName.COTIZACION.getName() + dto.getUuidGenerarOrden());
		Double montoTotalOriginal = (Double) session.getAttribute(SessionNamingName.PRECIO_TOTAL_ORDEN_PUBLICACION_EDITADA.getName() + dto.getUuidGenerarOrden());
		
		if (!conceptoVendibleComparator.compareConceptosVendible(tmp, dto.getConceptosVendibles(), new ComparatorContext())) {
			throw new ServiceException("La orden publicaciÃ³n fue adulterada.");
		}

		if (rolService.isOrdenPublicacionPaga(dto) && !montoTotalOriginal.equals((Double) rolService.calculateMontoTotal(tmp).getObject())){
			throw new ServiceException("La orden ya estÃ¡ paga. No se puede modificar ningÃºn dato del aviso que altere el precio cobrado de $ " +
					montoTotalOriginal.toString());
		}
		
		ROLResult result = rolService.executeActualizarOrdenPublicacionEditada(dto);
		
		// Borro los datos de la session
		session.removeAttribute(SessionNamingName.MODEL.getName() + dto.getUuidGenerarOrden());
		session.removeAttribute(SessionNamingName.COTIZACION.getName() + dto.getUuidGenerarOrden());
		session.removeAttribute(SessionNamingName.PRECIO_TOTAL_ORDEN_PUBLICACION_EDITADA.getName() + dto.getUuidGenerarOrden());
		
		return Collections.singletonMap("ROLResult", result);
	}
	
	/**
	 * Mapea /getProductoComercialDefault a la vista que representa la obtencion del Producto Comercial default para la ROL.
	 * 
	 * @param ordenDePublicacion Objeto orden publicación de entrada a partir de la cual se guardan sus datos
	 *        en HUB mediante los servicios HUB.
	 * @return vista que representa el guardado de la orden de publicación.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "getProductoComercialDefault", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getProductoComercialDefault(@RequestBody ProductoComercialDefaultDTO dto, HttpSession session) throws ServiceException {
		ProductoComercialDefaultDTO result = (ProductoComercialDefaultDTO) hubService.getProductoComercialDefault(dto).getObject();
				
		return Collections.singletonMap("productoComercialDefault", result);
	}
	
	/**
	 * Mapea /getServerTime al servicio que representa la obtencion del fecha del servidor para la ROL.
	 *	 
	 * @return devuelve la fecha del servidor.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "getServerTime", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getServerTime(HttpSession session) throws ServiceException {
		Long result = (Long) rolService.getServerTime().getObject();
				
		return Collections.singletonMap("serverTime", result);
	}
	
	/**
	 * Mapea /justificarAndTasar al servicio que representa la justificación y tasación del aviso para la ROL.
	 *
	 * @param  justificacion Objeto justificacion que contiene los parametros necesarios para justificar:
	 * 		   textoLibre, ordenamientos, etc.	 
	 * @return devuelve el texto justificado, con su cant de lines, texto libre, etc.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "justificar", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> executeJustificar(@RequestBody OrdenPublicacionDTO dto, HttpSession session) throws ServiceException {

		return Collections.singletonMap("ROLResult", rolService.executeJustificar(dto).getObject());
	}
	
	/**
	 * Mapea /justificarAndTasar al servicio que representa la justificación y tasación del aviso para la ROL.
	 *
	 * @param  justificacion Objeto justificacion que contiene los parametros necesarios para justificar:
	 * 		   textoLibre, ordenamientos, etc.	 
	 * @return devuelve el texto justificado, con su cant de lines, texto libre, etc.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "tasar", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> executeTasar(@RequestBody OrdenPublicacionDTO dto, HttpSession session) throws ServiceException {
		OrdenPublicacionDTO orden = (OrdenPublicacionDTO) rolService.executeTasar(dto).getObject();

		session.setAttribute(SessionNamingName.COTIZACION.getName() + dto.getUuidGenerarOrden(), orden.getConceptosVendibles());

		return Collections.singletonMap("ROLResult", orden);
	}
		
	/**
	 * Mapea /getCaracteresProhibidos al servicio que representa la obtencion de los caracteres prohibidos en el input de texto 
	 * libre para la ROL.
	 *
	 * @return devuelve un array con los codigos unicode de los caracteres prohibidos.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "getCaracteresInvalidos", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Map<String, ? extends Object> getCaracteresInvalidos(HttpSession session) throws ServiceException {
		List<Integer> result = (List<Integer>) hubService.getCaracteresInvalidosJustificacion().getObject();
		
		return Collections.singletonMap("caracteresInvalidos", result);
	}
	
	/**
	 * Mapea /getConfiguracionesOrdenamientoPantalla al servicio que representa la obtencion de los ordenamientos con la configuracion 
	 * de a que pantalla corresponden.
	 *
	 * @param dto Objeto que contiene los criterios de busqueda para las configuraciones de ordenamientos.
	 * @return devuelve un array con las configuraciones de ordenamientos (ordenamientos y a que pantalla corresponden).
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "getConfiguracionesOrdenamientoPantalla", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Map<String, ? extends Object> getConfiguracionesOrdenamientoPantalla(@RequestBody OrdenamientoAvisoSearchDTO dto, HttpSession session) throws ServiceException {
		List<ConfiguracionOrdenamientoPantallaDTO> result = (List<ConfiguracionOrdenamientoPantallaDTO>) hubService.getConfiguracionesOrdenamientoPantalla(dto).getObject();
		
		return Collections.singletonMap("configuracionesOrdenamientoPantalla", result);
	}
	
	/**
	 * Mapea /getItemsOrdenamientoAviso al servicio que representa la obtencion de los items ordenamientos, correspondientes
	 * a los parámetros de busquedas. 
	 *
	 * @param dto Objeto que contiene los criterios de busqueda de los items ordenamiento (ordenamiento al que pertenece, etc). 
	 * @return devuelve un array con los items ordenamientos, que se corresponden con los parametros de busqueda.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "getItemsOrdenamientoAviso", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Map<String, ? extends Object> getItemsOrdenamientoAviso(@RequestBody ItemOrdenamientoAvisoSearchDTO dto, HttpSession session) throws ServiceException {
		List<ItemOrdenamientoAvisoDTO> result = (List<ItemOrdenamientoAvisoDTO>) rolService.getItemsOrdenamientoAviso(dto).getObject(); 
		
		return Collections.singletonMap("itemsOrdenamientoAviso", result);
	}
	
	/**
	 * Mapea /getAgrupadoresProductoZonasNiveles al servicio que representa la obtencion de los agrupadores de productos, zonas
	 * y niveles de estructura. 
	 *	  
	 * @return devuelve un array con los niveles de agrupadores de producto, zonas y nivles. Los cuales se corresponden con los parametros de busqueda.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "getAgrupadoresProductoZonasNiveles", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Map<String, ? extends Object> getAgrupadoresProductoComercialZonasNiveles(@RequestBody AgrupadorProductoZonasNivelesSearchDTO dto, HttpSession session) throws ServiceException {
		List<AgrupadorProductoZonasNivelesDTO> result = (List<AgrupadorProductoZonasNivelesDTO>) rolService.getAgrupadoresProductoZonasNiveles(dto).getObject(); 
				
		return Collections.singletonMap("agrupadoresProductoZonasNiveles", result);
	}
	
	/**
	 * Mapea /getTiposOperacion al servicio que representa la obtencion de los tipos de operaciones posibles
	 * para un bien de una familia determinada en la carga del aviso para la ROL.
	 *
	 * @param  dto Objeto search que contiene los parametros necesarios para obtener los tipos:
	 * 		   compra, venta, etc.	 
	 * @return devuelve la lista de los tipos de operacion.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "getTiposOperacion", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Map<String, ? extends Object> getTiposOperacion(@RequestBody TipoOperacionSearchDTO dto, HttpSession session) throws ServiceException {
		List<TipoOperacionDTO> result = (List<TipoOperacionDTO>) hubService.getTiposOperacion(dto).getObject();
		
		return Collections.singletonMap("tiposOperacion", result);
	}
	
	/**
	 * Mapea /getBienes al servicio que representa la obtencion de los bienes posibles
	 * para una familia determinada en la carga del aviso para la ROL.
	 *
	 * @param  dto Objeto search que contiene los parametros necesarios para obtener los bienes:
	 * 		   auto, camioneta, etc.	 
	 * @return devuelve la lista de los bienes.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "getBienes", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Map<String, ? extends Object> getBienes(@RequestBody ClaseSearchDTO dto, HttpSession session) throws ServiceException {
		List<ClaseDTO> result = (List<ClaseDTO>) hubService.getBienes(dto).getObject();
		
		return Collections.singletonMap("bienes", result);
	}
	
	/**
	 * Mapea /getFamilias al servicio que representa la obtencion de las familias de productos
	 * disponibles a ser pubicados en la carga del aviso para la ROL.
	 *
	 * @param  dto Objeto search que contiene los parametros necesarios para obtener las familias:
	 * 		   automoviles, empleos, inmuebles, etc.	 
	 * @return devuelve la lista de las familias.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "getFamilias", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Map<String, ? extends Object> getFamilias(@RequestBody ClaseSearchDTO dto, HttpSession session) throws ServiceException {
		List<ClaseDTO> result = (List<ClaseDTO>) hubService.getFamilias(dto).getObject();
		
		return Collections.singletonMap("familias", result);
	}
	
	/**
	 * Mapea /validatePalabrasProhibidas al servicio que representa la validacion de palabras prohibidas que 
	 * contiene el texto en un determinado rubro.
	 *
	 * @param  dto Objeto search que contiene los parametros necesarios para la validacion del texto	 
	 * @return devuelve la lista de las palabras que estan prohibidas.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "validatePalabrasProhibidas", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public Map<String, ? extends Object> validatePalabrasProhibidas(@RequestBody TextoValidateDTO dto, HttpSession session) throws ServiceException {
		List<String> result = (List<String>) hubService.validatePalabrasProhibidas(dto).getObject();
		
		return Collections.singletonMap("palabrasProhibidas", result);
	}
	
	
	/**
	 * Mapea /setModel al servicio que representa el guardado de la orden en session y el pasaje de url para redireccionar	 
	 *
	 * @param  dto Objeto redirect que contiene la orden a guardar en session y la url para redireccionar	 
	 * @return devuelve la url de redireccion.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "setModel", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> setModel(@RequestBody ModelCrearAvisoDTO dto, HttpSession session) throws ServiceException {
		session.setAttribute(SessionNamingName.MODEL.getName() + dto.getOrdenPublicacion().getUuidGenerarOrden(), dto);

		String url = dto.getRedirectURL() + "?uuid=" + dto.getOrdenPublicacion().getUuidGenerarOrden();
		
		return Collections.singletonMap("url", url);
	}
	
	/**
	 * Mapea /getModel al servicio que representa opteneción del modelo guardado en session  
	 *
	 * @param  dto Objeto que contiene los criterios de busqueda de el modelo en session (uuid).	 
	 * @return devuelve el modelo. 
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "getModel", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getModel(@RequestBody ModelSearchDTO dto, HttpSession session) throws ServiceException {
		ModelCrearAvisoDTO model = (ModelCrearAvisoDTO)session.getAttribute(SessionNamingName.MODEL.getName() + dto.getUuid());
		
		if (model != null) {
			session.setAttribute(SessionNamingName.COTIZACION.getName() + dto.getUuid(), model.getOrdenPublicacion().getConceptosVendibles());
		}
		
		return Collections.singletonMap("model", model);
	}

	/**
	 * Mapea /removeModel al servicio que representa la eliminacion del modelo guardado en session  
	 *
	 * @param  dto Objeto que contiene los criterios de busqueda de el modelo en session (uuid).	 
	 * @return devuelve el modelo. 
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "removeModel", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> removeModel(@RequestBody ModelSearchDTO dto, HttpSession session) throws ServiceException {
		session.removeAttribute(SessionNamingName.MODEL.getName() + dto.getUuid());
				
		return Collections.singletonMap("status", "REMOVE COMPLETE");
	}

	/**
	 * Realiza las operaciones de logout, invalidación de session.
	 * 
	 * @return Mensaje de exito. 
	 * @throws IOException 
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, ? extends Object> logout(HttpSession session, HttpServletResponse response) throws IOException {		
		
		//Elimino la session para limpiar valores
		session.invalidate();
				
		this.getLogger().debug("Ejecutando llamada de logout desde CrearAvisoController");
				
	    String logoutUrl = String.format("https://%s/v2/logout?client_id=%s&returnTo=%s",
	    									auth0LoginHelper.getAuth0Credentials().getDomain(),
	    									auth0LoginHelper.getAuth0Credentials().getClientId(),
	            							auth0LoginHelper.getAuth0Credentials().getCallbackLogout());
	    
	    response.sendRedirect(logoutUrl);
		
		return Collections.singletonMap("logout", "success");			
	}
	
	/**
	 * Obtiene las tarjetas disponibles para pagar.
	 * 
	 * @return Mensaje de exito. 
	 */
	@RequestMapping(value = "getTarjetasPago", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getTarjetasPago(@RequestBody TarjetaPagoSearchDTO dto,HttpSession session) throws ServiceException {		
		ROLResult result = hubService.getTarjetasPago(dto);
		
		return Collections.singletonMap("tarjetas", result.getObject());			
	}

	/**
	 * Obtiene las imagenes disponibles para pagar.
	 * 
	 * @return devuelve una lista de imagenes. 
	 */
	@RequestMapping(value = "getImagenes", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getTarjetasPago(@RequestBody TemplateDetalladoDTO dto,HttpSession session) throws ServiceException {		
		ROLResult result = hubService.getImagenes(dto);
		
		return Collections.singletonMap("imagenes", result.getObject());			
	}
	
	/**
	 * Obtiene los templates para la pantalla de destaque.
	 * 
	 * @return Mensaje de exito. 
	 */
	@RequestMapping(value = "getTemplatesDetallado", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getTemplatesDetallado(@RequestBody TemplateDetalladoSearchDTO dto, HttpSession session) throws ServiceException {		
		ROLResult result = rolService.getTemplatesDetallado(dto);
		
		return Collections.singletonMap("templates", result.getObject());			
	}
	
	/**
	 * Mapea /getTemplatePrecarga al servicio que representa obtenciÃ³n del template para la precarga de avisos
	 * 
	 * @param dto Objeto que contiene los criterios de busqueda de el template de precarga (codigo).
	 * @param session Objeto que contiene la sesión.
	 * @returndevuelve el template de precarga (modelo).
	 * @throws ServiceException
	 */
	@RequestMapping(value = "getTemplatePrecarga", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getTemplatePrecarga(@RequestBody TemplatePrecargaSearchDTO dto, HttpSession session) throws ServiceException {
		TemplatePrecargaDTO templatePrecarga = (TemplatePrecargaDTO) hubService.getTemplatePrecarga(dto).getObject();
		
		String templatePrecargaContent = "{}";
		
		if (templatePrecarga != null) {
			templatePrecargaContent = templatePrecarga.getTemplate();
		}
		
		return Collections.singletonMap("model", templatePrecargaContent);
	}
	
	/**
	 * Obtiene el resultado de la validacion del limite.
	 * 
	 * @return Resultado booleano. 
	 */
	@RequestMapping(value = "getLimiteCotizacionExedido", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getLimiteCotizacionExedido(@RequestBody LimiteCotizacionDTO dto, HttpSession session) throws ServiceException {		
		Double result = (Double) rolService.getLimiteCotizacionExedido(dto).getObject();
		
		return Collections.singletonMap("result", result);			
	}
	
	/**
	 * Obtiene el uuid de la orden.
	 * 
	 * @return Mensaje de exito. 
	 */
	@RequestMapping(value = "getUUID", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getUUID(HttpSession session) throws ServiceException {		
		return Collections.singletonMap("uuid", rolService.getUUID());			
	}
	
	/**
	 * Obtiene los paises disponibles para cargar en la direccion.
	 * 
	 * @return devuelve una lista de paises. 
	 */
	@RequestMapping(value = "getPaises", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getPaises(HttpSession session) throws ServiceException {		
		ROLResult result = rolService.getPaises();
		
		return Collections.singletonMap("paises", result.getObject());			
	}
	
	/**
	 * Obtiene las provincias disponibles para cargar en la direccion dado un pais.
	 * 
	 * @return devuelve una lista de provincias. 
	 */
	@RequestMapping(value = "getProvincias", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getProvincias(@RequestBody PaisDTO dto, HttpSession session) throws ServiceException {		
		ROLResult result = rolService.getProvincias(dto);
		
		return Collections.singletonMap("provincias", result.getObject());			
	}
	
	/**
	 * Obtiene las localidas disponibles para cargar en la direccion dada una provincia.
	 * 
	 * @return devuelve una lista de localidades. 
	 */
	@RequestMapping(value = "getLocalidades", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getLocalidades(@RequestBody ProvinciaDTO dto, HttpSession session) throws ServiceException {		
		ROLResult result = rolService.getLocalidades(dto);
		
		return Collections.singletonMap("localidades", result.getObject());			
	}
	
	/**
	 * Obtiene las configuraciones de promocion pantalla
	 * 
	 * @return devuelve las lista de configuraciones de promocion pantalla.
	 * @throws ServiceException Cuando se produce un error en la ejecución de la acción.
	 */
	@RequestMapping(value = "getConfiguracionesPromocionPantalla", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getConfiguracionesPromocionPantalla(@RequestBody PromocionSearchDTO dto) throws ServiceException {
		ROLResult result = hubService.getConfiguracionesPromocionPantalla(dto);
		
		return Collections.singletonMap("configuracionesPromocionPantalla", result.getObject());
	}
	
	/**
	 * Mapea a la acción /updateCapturador.
	 * 
	 * @return Objeto ROLResult que contiene el resultado de la ejecución.
	 * @throws ServiceException Cuando se produce un error en la ejecución de la acción.
	 */
	@RequestMapping(value = "updateCapturador", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ROLResult updateCapturador(@RequestBody CapturadorCRUDDTO dto) throws ServiceException {
		ROLResult result = hubService.updateCapturador(dto);
		
		return result;
	}
	
	/**
	 * Mapea a la acción /checkIntentosPromocion365.
	 * 
	 * @return Objeto ROLResult que contiene el resultado de la ejecucion.
	 * @throws ServiceException Cuando se produce un error en la ejecucion de la accion.
	 */
	@RequestMapping(value = "checkIntentosPromocion365", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ROLResult checkIntentosPromocion365(HttpSession session) throws ServiceException {
		ROLResult rolResult = new ROLResult();

		rolResult.setObject(session.getAttribute(SessionNamingName.CANTIDAD_INTENTOS_PROMOCION_365.getName()));
		
		return rolResult;
	}
	
	/**
	 * Mapea a la acción /eliminarPromo365.
	 * 
	 * @return Objeto ROLResult que contiene el resultado de la ejecucion.
	 * @throws ServiceException Cuando se produce un error en la ejecucion de la accion.
	 */
	@RequestMapping(value = "eliminarPromo365", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ROLResult deletePromo365(@RequestBody OrdenPublicacionDTO dto, HttpSession session) throws ServiceException {
		ROLResult rolResult = rolService.executeTasar(dto);
		
		session.setAttribute(SessionNamingName.COTIZACION.getName() + dto.getUuidGenerarOrden(), ((OrdenPublicacionDTO) rolResult.getObject()).getConceptosVendibles());
		
		return rolResult;
	}

	/**
	 * Valida la promocion 365 en cuanto a su captcha dependiendo de los intentos que haya hecho.
	 * Luego valida las promociones (si ya tiene) junto con la 365 y finalmente tasa su valor.
	 * 
	 * @return una lista de mensajes de validacion en caso que alguna falle. La orden con la promo365
	 * agregada en caso ok.
	 */
	@RequestMapping(value = "validatePromocion365", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> validatePromocion365(@RequestBody ValidarPromocionesDTO dto, HttpSession session) throws ServiceException {
		if (session.getAttribute(SessionNamingName.CANTIDAD_INTENTOS_PROMOCION_365.getName()) == null) {
			session.setAttribute(SessionNamingName.CANTIDAD_INTENTOS_PROMOCION_365.getName(), 0);
		}
		
		dto.setCantidadIntentos((Integer) session.getAttribute(SessionNamingName.CANTIDAD_INTENTOS_PROMOCION_365.getName()));
		
		ROLResult rolResult = rolService.validatePromocion365(dto);
		
		session.setAttribute(SessionNamingName.CANTIDAD_INTENTOS_PROMOCION_365.getName(), ((ValidarPromocionesDTO) rolResult.getObject()).getCantidadIntentos());
		
		return Collections.singletonMap("ROLResult", rolResult);
	}
	
	/**
	 * Mapea /validarPromociones al servicio que representa la validacion de promociones para la ROL.
	 *
	 * @param  dto Objeto dto que contiene los parametros necesarios para validar promociones:
	 * 		  ordenPublicacion, promocionesAplicables, etc.	 
	 * @return devuelve las promociones validas aplicadas.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "validatePromociones", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> validatePromociones(@RequestBody ValidarPromocionesDTO dto, HttpSession session) throws ServiceException {
		ValidarPromocionesDTO result = (ValidarPromocionesDTO) rolService.validatePromociones(dto).getObject();
		
		return Collections.singletonMap("ROLResult", result);
	}
	
	/**
	 * Obtiene el TrackCampana de la session.
	 * 
	 * @return Mensaje de exito. 
	 */
	@RequestMapping(value = "getTrackCampana", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getTrackCampana(HttpSession session) throws ServiceException {		
		return Collections.singletonMap("trackCampana", session.getAttribute(SessionNamingName.TRACK_CAMPANA.getName()));			
	}
	
	/**
	 * Obtiene el permiso asociado al atributo.
	 * @param  dto Objeto dto que contiene los parametros necesarios para para obtener el atributo y los permisos asociados.	 
	 * @return devuelve el atributo con los permisos asociados a el,
	 * @throws ServiceException  
	 */
	@RequestMapping(value = "getPermisoAtributo", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getPermisoAtributo(@RequestBody PermisoAtributoSearchDTO dto, HttpSession session) throws ServiceException {		
		AtributoCIDDTO result = (AtributoCIDDTO) rolService.getPermisoAtributo(dto).getObject();
		
		return Collections.singletonMap("ROLResult", result);			
	}
		
}
