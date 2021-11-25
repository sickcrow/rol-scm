package ar.com.agea.hub.rol.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.agea.hub.rol.exception.ServiceException;
import ar.com.agea.hub.rol.model.dto.CapturadorCRUDDTO;
import ar.com.agea.hub.rol.model.dto.ConfiguracionOrdenamientoPantallaDTO;
import ar.com.agea.hub.rol.model.dto.EditarOrdenDTO;
import ar.com.agea.hub.rol.model.dto.FamiliasByFilterSearchDTO;
import ar.com.agea.hub.rol.model.dto.ModelCrearAvisoDTO;
import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;
import ar.com.agea.hub.rol.model.dto.OrdenamientoAvisoSearchDTO;
import ar.com.agea.hub.rol.model.dto.TarjetaPagoSearchDTO;
import ar.com.agea.hub.rol.model.dto.UpdateEstadoAvisoDTO;
import ar.com.agea.hub.rol.model.result.ROLResult;
import ar.com.agea.hub.rol.service.HUBService;
import ar.com.agea.hub.rol.service.ROLService;
import ar.com.agea.hub.rol.utils.Auth0LoginHelper;
import ar.com.agea.hub.rol.utils.SessionNamingName;
import ar.com.agea.hub.rol.utils.ViewNamingName;

/**
 * Representa mis avisos del usuario de la aplicación.
 * 
 * @author		Alejandro Javier Di Fiore
 * @version		1.0 16/07/2013
 */
@Controller
public class MisAvisosController extends ROLController {

	@Autowired
	private ROLService rolService;
	
	@Autowired
	private HUBService hubService;
	
	@Autowired
	private Auth0LoginHelper auth0LoginHelper;
	
	/**
	 * Mapea /mis-avisos a la vista que representa mis avisos.
	 * 
	 * @return Vista que representa mis avisos. 
	 */
	@RequestMapping(value = "/mis-avisos", method = RequestMethod.GET)
	public ModelAndView showMisAvisos(HttpSession session) {		
		return getModelAndView(ViewNamingName.MIS_AVISOS);	
	}
		
	/**
	 * Realiza las operaciones de logout, invalidación de session.
	 * 
	 * @return Mensaje de exito. 
	 * @throws IOException 
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, ? extends Object> logout(HttpSession session, HttpServletResponse response) throws IOException {		
		
		//Elimino la session para limpiar valores
		session.invalidate();
				
		this.getLogger().debug("Ejecutando llamada de logout desde MisAvisosController");
		
	    String logoutUrl = String.format("https://%s/v2/logout?client_id=%s&returnTo=%s",
	    									auth0LoginHelper.getAuth0Credentials().getDomain(),
	    									auth0LoginHelper.getAuth0Credentials().getClientId(),
	            							auth0LoginHelper.getAuth0Credentials().getCallbackLogout());
	    
	    response.sendRedirect(logoutUrl);
	    
	    return Collections.singletonMap("logout", "success");			
	}

	/**
	 * Paga y actualiza la orden publicación.
	 * 
	 * @param dto Objeto orden publicación a pagar y actualizar.
	 * @return vista que representa el actualizado de la orden de publicación.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "executePagarAndActualizar", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> executePagarAndActualizar(@RequestBody OrdenPublicacionDTO dto, HttpSession session) throws ServiceException {
		ROLResult result = rolService.executePagarAndActualizar(dto);
		
		session.removeAttribute(SessionNamingName.MODEL.getName() + dto.getUuidGenerarOrden());
		
		return Collections.singletonMap("ROLResult", result);
	}
	
	/**
	 * Obtiene las tarjetas disponibles para pagar.
	 * 
	 * @return Mensaje de exito con listas de tarjetas para pagar. 
	 */
	@RequestMapping(value = "getTarjetasPago", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getTarjetasPago(@RequestBody TarjetaPagoSearchDTO dto,HttpSession session) throws ServiceException {		
		ROLResult result = hubService.getTarjetasPago(dto);
		
		return Collections.singletonMap("tarjetas", result.getObject());			
	}
	
	/**
	 * Mapea /getOrdenesPublicacionByCapturador que obtiene una lista de ordenes de publicacion realizada por el capturador.
	 * 
	 * @return Lista de dtos de las ordenes de publicacion. 
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "getOrdenesPublicacionByCapturador", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getOrdenesPublicacionByCapturador(@RequestBody CapturadorCRUDDTO dto) throws ServiceException {		
		ROLResult result = rolService.getOrdenesPublicacionByCapturador(dto); 
		
		return Collections.singletonMap("ordenesPublicacion", result.getObject());			
	}
	
	/**
	 * Mapea /suspenderPublicacionAviso. Detiene la publicacion del aviso
	 *  
	 * @param dto Objeto updateEstadoAviso con el id del aviso a detener. 
	 * @return ROLResult resultado de la accion
	 * @throws ServiceException
	 */
	@RequestMapping(value = "suspenderPublicacionAviso", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> updateEstadoAvisoWithSuspender(@RequestBody UpdateEstadoAvisoDTO dto) throws ServiceException {		
		ROLResult result = rolService.updateEstadoAvisoWithSuspender(dto.getIdAviso()); 
		
		return Collections.singletonMap("ROLResult", result);			
	}
	
	/**
	 * Mapea /reanudarPublicacionAviso. Reanuda la publicacion del aviso despues de estar suspendida
	 *  
	 * @param dto Objeto updateEstadoAviso con el id del aviso a reanudar. 
	 * @return ROLResult resultado de la accion
	 * @throws ServiceException
	 */
	@RequestMapping(value = "reanudarPublicacionAviso", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> updateEstadoAvisoWithReanudar(@RequestBody UpdateEstadoAvisoDTO dto) throws ServiceException {		
		ROLResult result = rolService.updateEstadoAvisoWithReactivar(dto.getIdAviso()); 
		
		return Collections.singletonMap("ROLResult", result);			
	}
	
	@RequestMapping(value = "getSessionStatus", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getSessionStatus() throws ServiceException {
		return Collections.singletonMap("val", true);
	}
	
	/**
	 * Obtiene las familias disponibles.
	 * 
	 * @param dto Objeto familias por filtro búsqueda a filtrar.
	 * @return vista que representa las familias disponibles.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "getFamiliasByFilter", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> getFamiliasByFilter(@RequestBody FamiliasByFilterSearchDTO dto, HttpSession session) throws ServiceException {
		ROLResult result = rolService.getFamiliasByFilter(dto);
		
		return Collections.singletonMap("ROLResult", result);
	}
	
	/**
	 * Mapea /setModel al servicio que representa el guardado de la orden en session y el pasaje de url para redireccionar	 
	 *
	 * @param  dto Objeto redirect que contiene la orden a guardar en session y la url para redireccionar	 
	 * @return devuelve la url de redireccion.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "republicarAviso", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> republicarAviso(@RequestBody Long idOrden, HttpSession session) throws ServiceException {
		ModelCrearAvisoDTO dto = rolService.republishOrdenPublicacion(idOrden);
		session.setAttribute(SessionNamingName.MODEL.getName() + dto.getOrdenPublicacion().getUuidGenerarOrden(), dto);

		String url = dto.getRedirectURL() + "?uuid=" + dto.getOrdenPublicacion().getUuidGenerarOrden();
		
		return Collections.singletonMap("url", url);
	}
	
	/**
	 * Mapea /setModel al servicio que representa el guardado de la orden en session y el pasaje de url para redireccionar	 
	 *
	 * @param  dto Objeto redirect que contiene la orden a guardar en session y la url para redireccionar	 
	 * @return devuelve la url de redireccion.
	 * @throws ServiceException 
	 */
	@RequestMapping(value = "editarOrdenDePublicacion", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, ? extends Object> editarOrdenDePublicacion(@RequestBody EditarOrdenDTO editarAviso, HttpSession session) throws ServiceException {
		ModelCrearAvisoDTO dto = rolService.editOrdenPublicacion(editarAviso.getIdOrden());
		
		session.setAttribute(SessionNamingName.MODEL.getName() + dto.getOrdenPublicacion().getUuidGenerarOrden(), dto);
		
		session.setAttribute(SessionNamingName.PRECIO_TOTAL_ORDEN_PUBLICACION_EDITADA.getName() + dto.getOrdenPublicacion().getUuidGenerarOrden(), 
			rolService.calculateMontoTotal(dto.getOrdenPublicacion().getConceptosVendibles()).getObject());
		
		String url = dto.getRedirectURL() + "?uuid=" + dto.getOrdenPublicacion().getUuidGenerarOrden();
		
		return Collections.singletonMap("url", url);
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
	
}