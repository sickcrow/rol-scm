/*
 * @(#)ROLService.java		1.0 23/10/2013
 */

package ar.com.agea.hub.rol.service;

import java.util.List;

import ar.com.agea.hub.rol.exception.ServiceException;
import ar.com.agea.hub.rol.model.dto.AgrupadorProductoZonasNivelesSearchDTO;
import ar.com.agea.hub.rol.model.dto.CapturadorCRUDDTO;
import ar.com.agea.hub.rol.model.dto.ConceptoVendibleDTO;
import ar.com.agea.hub.rol.model.dto.FamiliasByFilterSearchDTO;
import ar.com.agea.hub.rol.model.dto.GWPNotificationDTO;
import ar.com.agea.hub.rol.model.dto.ItemOrdenamientoAvisoSearchDTO;
import ar.com.agea.hub.rol.model.dto.LimiteCotizacionDTO;
import ar.com.agea.hub.rol.model.dto.ModelCrearAvisoDTO;
import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;
import ar.com.agea.hub.rol.model.dto.PaisDTO;
import ar.com.agea.hub.rol.model.dto.PermisoAtributoSearchDTO;
import ar.com.agea.hub.rol.model.dto.ProvinciaDTO;
import ar.com.agea.hub.rol.model.dto.TemplateDetalladoSearchDTO;
import ar.com.agea.hub.rol.model.dto.UsuarioDTO;
import ar.com.agea.hub.rol.model.dto.ValidarPromocionesDTO;
import ar.com.agea.hub.rol.model.result.ROLResult;

/**
 * Representa una capa de abstraci�n de los servicios ROL.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 23/10/2013
 */
public interface ROLService {

	/**
	 * Obtiene un objeto que representa la orden publicaci�n justificada.
	 * 
	 * Este servicio es utilizado internamente en la aplicaci�n.
	 * 
	 * @param dto Objeto Orden Publicaci�n a justificar.
	 * @return Objeto Orden Publicaci�n justificada.
	 * @throws ServiceException Cuando la salida a la llamada al servicio devuelve errores.
	 */
	ROLResult executeJustificar(OrdenPublicacionDTO dto) throws ServiceException;
	
	/**
	 * Notifica un objeto que representa un pago de orden publicaci�n en el sistema GWP.
	 * 
	 * @param dto Objeto GWP Notificaci�n que recibir� la notificaci�n.
	 * @return Objeto Datos que indican que la orden publicaci�n fue acreditada o cancelada.
	 * @throws ServiceException Cuando la salida a la llamada al servicio devuelve errores.
	 */
	ROLResult executeNotificarPago(GWPNotificationDTO dto) throws ServiceException;
	
	/**
	 * Paga y guarda un objeto que representa una orden publicaci�n en el sistema GWP y HUB.
	 * 
	 * @param dto Objeto Orden Publicaci�n a pagar y guardar.
	 * @return Objeto Datos que indican que la orden publicaci�n fue pagada y guardada.
	 * @throws ServiceException Cuando la salida a la llamada al servicio devuelve errores.
	 */
	ROLResult executePagarAndGuardar(OrdenPublicacionDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un objeto que representa la orden publicaci�n tasada.
	 * 
	 * Este servicio es utilizado internamente en la aplicaci�n.
	 * 
	 * @param dto Objeto Orden Publicaci�n a tasar.
	 * @return Objeto Orden Publicaci�n tasada.
	 * @throws ServiceException Cuando la salida a la llamada al servicio devuelve errores.
	 */
	ROLResult executeTasar(OrdenPublicacionDTO dto) throws ServiceException;
	
	/**
	 * Paga y actualiza un objeto que representa una orden publicaci�n en el sistema GWP y HUB.
	 * 
	 * @param dto Objeto Orden Publicaci�n a pagar y actualizar.
	 * @return Objeto Datos que indican que la orden publicaci�n fue pagada y actualizada.
	 * @throws ServiceException Cuando la salida a la llamada al servicio devuelve errores.
	 */
	ROLResult executePagarAndActualizar(OrdenPublicacionDTO dto) throws ServiceException;
	
	/**
	 *  Actualiza un objeto que representa una orden publicaci�n en el sistema HUB.
	 *  
	 * @param dto Objeto Orden Publicaci�n a actualizar.
	 * @return Objeto Datos que indican que la orden publicaci�n fue actualizada.
	 * @throws ServiceException Cuando la salida a la llamada al servicio devuelve errores.
	 */
	ROLResult executeActualizar(OrdenPublicacionDTO dto) throws ServiceException;
	
	/**
	 * Actualiza la orden de publicaci�n.
	 * 
	 * @param dto Objeto Orden Publicaci�n a actualizar.
	 * @return Objeto Datos que indican que la orden publicaci�n fue actualizada.
	 * @throws ServiceException Cuando la salida a la llamada al servicio devuelve errores.
	 */
	ROLResult executeActualizarOrdenPublicacionEditada(OrdenPublicacionDTO ordenPublicacion) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan los agrupadores de productos, productos comerciales default,
	 * zonas comercializaci�n y niveles de estructuras relacionados.
	 * 
	 * Este servicio es utilizado internamente en la aplicaci�n.
	 * 
	 * @param dto Objeto agrupador producto zonas niveles por el cual filtrar.
	 * @return Objetos agrupadores producto zonas niveles.
	 * @throws ServiceException Cuando la salida a la llamada al servicio devuelve errores.
	 */
	ROLResult getAgrupadoresProductoZonasNiveles(AgrupadorProductoZonasNivelesSearchDTO dto) throws ServiceException;

	/**
	 * Obtiene un conjunto de objetos que representan las clases.
	 * 
	 * Este servicio tiene la particularidad de devolver las clases ordenadas.
	 * 
	 * @param dto Objeto familias por filtro por el cual filtrar.
	 * @return Objetos clases.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getFamiliasByFilter(FamiliasByFilterSearchDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un objeto que representa el hash de un valor String.
	 * 
	 * @param value Objeto value por el cual generar el hash.
	 * @return Objeto hash generado.
	 */
	ROLResult getHash(String value);
	
	/**
	 * Obtiene un conjunto de objetos que representan los items de ordenamientos avisos.
	 * 
	 * Este servicio tiene la particularidad de devolver los items de ordenamientos avisos
	 * ordenados si su ordenamiento aviso es A�O.
	 * 
	 * @param dto Objeto item ordenamiento aviso b�squeda por el cual filtrar.
	 * @return Objetos items de ordenamientos avisos obtenidos.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getItemsOrdenamientoAviso(ItemOrdenamientoAvisoSearchDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un objeto que representa si se ha excedido el l�mite de la cotizaci�n configurado
	 * y el domicilio es requerido.
	 * 
	 * @param dto Objeto l�mite cotizaci�n con el monto a comparar.
	 * @return Objeto valor obtenido.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getLimiteCotizacionExedido(LimiteCotizacionDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan las localidades.
	 * 
	 * Este servicio tiene la particularidad de devolver las localidades ordenadas.
	 *  
	 * @param dto Objeto provincia por el cual filtrar.
	 * @return Objetos localidades obtenidos.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getLocalidades(ProvinciaDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan las ordenes publicaci�n.
	 * 
	 * Este servicio tiene la particularidad de devolver los avisos ordenados por fecha publicaci�n
	 * desde la m�s reciente.
	 * 
	 * @param dto Objeto capturador por el cual filtrar.
	 * @return Objetos ordenes publicaci�n.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */	
	ROLResult getOrdenesPublicacionByCapturador(CapturadorCRUDDTO dto) throws ServiceException;

	/**
	 * Obtiene un conjunto de objetos que representan los paises.
	 * 
	 * Este servicio tiene la particularidad de devolver los paises ordenados.
	 *  
	 * @return Objetos paises obtenidos.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getPaises() throws ServiceException;

	/**
	 * Obtiene un conjunto de objetos que representan las provincias.
	 * 
	 * Este servicio tiene la particularidad de devolver las provincias ordenadas.
	 *  
	 * @param dto Objeto pa�s por el cual filtrar.
	 * @return Objetos provincias obtenidos.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getProvincias(PaisDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un objeto que representa la fecha del servidor.
	 *
	 * @return Objeto fecha del servidor.
	 */
	ROLResult getServerTime();
	
	/**
	 * Obtiene un objeto que representa un identificador �nico universal.
	 * 
	 * @return Objeto identificador �nico universal generado.
	 */
	ROLResult getUUID();

	/**
	 * Loguea un objeto que representa el usuario a loguear en el sistema PASE y HUB.
	 * 
	 * @param dto Objeto Usuario a loguear.
	 * @return Objeto usuario logueado.
	 * @throws ServiceException Cuando la salida a la llamada al servicio devuelve errores.
	 */
	ROLResult loginUsuario(UsuarioDTO dto, boolean usuarioMigrado) throws ServiceException;
	

	/**
	 * Actualiza un objeto que representa el usuario a modificar en el sistema PASE y actualizar en HUB.
	 * 
	 * @param idAviso Objeto Usuario a actualizar.
	 * @return Objeto usuario actualizado.
	 * @throws ServiceException Cuando la salida a la llamada al servicio devuelve errores.
	 */
	ROLResult updateUsuario(UsuarioDTO dto) throws ServiceException;
	
	/**
	 * Actualiza un objeto que representa el usuario a modificar en el sistema PASE y guardar en HUB.
	 * 
	 * @param dto Objeto Usuario a actualizar en PASE y guardar en HUB.
	 * @return Objeto usuario actualizado.
	 * @throws ServiceException Cuando la salida a la llamada al servicio devuelve errores.
	 */
	ROLResult updateUsuarioPASE(UsuarioDTO dto) throws ServiceException;
	
	/**
	 * Actualiza un objeto que representa un aviso con el estado suspender.
	 * 
	 * @param idAviso Objeto update estado aviso a actualizar.
	 * @return Objeto orden publicacion que contiene el aviso actualizado.
	 * @throws ServiceException Cuando la salida a la llamada al servicio devuelve errores.
	 */
	ROLResult updateEstadoAvisoWithSuspender(Long idAviso) throws ServiceException;
	
	/**
	 * Actualiza un objeto que representa un aviso con el estado reactivar.
	 * 
	 * @param dto Objeto update estado aviso a actualizar.
	 * @return Objeto orden publicacion que contiene el aviso actualizado.
	 * @throws ServiceException Cuando la salida a la llamada al servicio devuelve errores.
	 */
	ROLResult updateEstadoAvisoWithReactivar(Long idAviso) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan las promociones v�lidas para la promoci�n 365.
	 * 
	 * @param dto Objeto validar promociones a validar para la promoci�n 365.
	 * @return Objetos promociones obtenidas.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult validatePromocion365(ValidarPromocionesDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan las promociones v�lidas.
	 * 
	 * @param dto Objeto validar promociones a validar.
	 * @return Objetos promociones obtenidas.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult validatePromociones(ValidarPromocionesDTO dto) throws ServiceException;
		
	/**
	 * Prepara la orden de publicacion para la republicacion
	 * 
	 * @param dto Objeto Long a preparar para obtener la orden a republicar
	 * @return Objeto ModelCrearAvisoDTO para republicar
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ModelCrearAvisoDTO republishOrdenPublicacion(Long idOrdenPublicacion) throws ServiceException;
	
	/**
	 * Prepara la orden de publicacion para la edici�n.
	 * 
	 * @param dto Objeto Long a preparar para obtener la orden a editar.
	 * @return Objeto ModelCrearAvisoDTO para editar.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ModelCrearAvisoDTO editOrdenPublicacion(Long idOrdenPublicacion) throws ServiceException;
	
	/**
	 * Calcula el monto total a partir de los conceptos vendibles pasados como par�metro.
	 * 
	 * @param dto Objeto conceptos vendibles de los cuales se va a calcular el monto total.
	 * @return  Objeto con el monto total sumarizados de los conceptos.
	 */
	ROLResult calculateMontoTotal(List<ConceptoVendibleDTO> conceptosVendibles);
	
	
	/**
	 * Verifica si una orden se encuentra paga (ACREDITADA)
	 * 
	 *  @param dto Objeto OrdenPublicacionDTO que contiene la orden a verificar si se encuentra paga.
	 *  @return Objeto boolean que indica si la orden se encuentra paga o no.
	 */
	boolean isOrdenPublicacionPaga(OrdenPublicacionDTO ordenPublicacion);
	
	/**
	 * Obtiene el permiso asociado al atributo y los par�metros de b�squeda.
	 * 
	 *  @param dto Objeto PermisoAtributoSearchDTO que contiene los parametros de busquedas para el 
	 *  permisos y sus atributos.
	 *  @return Objeto AtributoCIDDTO que contiene asociado los permisos.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getPermisoAtributo(PermisoAtributoSearchDTO permisoAtributoSearch) throws ServiceException;

	ROLResult getTemplatesDetallado(TemplateDetalladoSearchDTO dto) throws ServiceException;
}
