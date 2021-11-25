/*
 * @(#)HUBService.java		1.0 23/10/2013
 */

package ar.com.agea.hub.rol.service;

import ar.com.agea.hub.rol.exception.ServiceException;
import ar.com.agea.hub.rol.model.dto.CalendarioSearchDTO;
import ar.com.agea.hub.rol.model.dto.CapturadorCRUDDTO;
import ar.com.agea.hub.rol.model.dto.ClaseSearchDTO;
import ar.com.agea.hub.rol.model.dto.FamiliasByFilterSearchDTO;
import ar.com.agea.hub.rol.model.dto.GWPTransaccionDTO;
import ar.com.agea.hub.rol.model.dto.ItemOrdenamientoAvisoGroupSearchDTO;
import ar.com.agea.hub.rol.model.dto.ItemOrdenamientoAvisoSearchDTO;
import ar.com.agea.hub.rol.model.dto.JustificacionDTO;
import ar.com.agea.hub.rol.model.dto.NivelEstructuraSearchDTO;
import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;
import ar.com.agea.hub.rol.model.dto.OrdenamientoAvisoSearchDTO;
import ar.com.agea.hub.rol.model.dto.PaisDTO;
import ar.com.agea.hub.rol.model.dto.PermisoAtributoSearchDTO;
import ar.com.agea.hub.rol.model.dto.PrimitiveDTO;
import ar.com.agea.hub.rol.model.dto.ProductoComercialDefaultDTO;
import ar.com.agea.hub.rol.model.dto.ProductoSearchDTO;
import ar.com.agea.hub.rol.model.dto.PromocionSearchDTO;
import ar.com.agea.hub.rol.model.dto.PropiedadDefaultSearchDTO;
import ar.com.agea.hub.rol.model.dto.ProvinciaDTO;
import ar.com.agea.hub.rol.model.dto.TarjetaPagoSearchDTO;
import ar.com.agea.hub.rol.model.dto.TemplateDetalladoDTO;
import ar.com.agea.hub.rol.model.dto.TemplateDetalladoSearchDTO;
import ar.com.agea.hub.rol.model.dto.TemplatePrecargaSearchDTO;
import ar.com.agea.hub.rol.model.dto.TextoValidateDTO;
import ar.com.agea.hub.rol.model.dto.TipoOperacionSearchDTO;
import ar.com.agea.hub.rol.model.dto.UpdateEstadoAvisoDTO;
import ar.com.agea.hub.rol.model.dto.ValidarPromocionesDTO;
import ar.com.agea.hub.rol.model.dto.ValidateVigenciaDTO;
import ar.com.agea.hub.rol.model.dto.ZonaComercializacionSearchDTO;
import ar.com.agea.hub.rol.model.result.ROLResult;


/**
 * Representa una capa de abstración de los servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 23/10/2013
 */
public interface HUBService {

	// Servicios pertenecientes a Cliente.
	/**
	 * Guarda un objeto capturador.
	 * 
	 * @param dto Objeto capturador a guardar.
	 * @return Objeto capturador guardado.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult saveCapturador(CapturadorCRUDDTO dto) throws ServiceException;
	
	/**
	 * Actualiza un objeto capturador.
	 * 
	 * @param dto Objeto capturador a actualizar.
	 * @return Objeto capturador actualizado.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult updateCapturador(CapturadorCRUDDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un objeto que representa el capturador.
	 * 
	 * @param dto Objeto capturador CRUD por el cual obtener.
	 * @return Objeto capturador obtenido.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getCapturador(CapturadorCRUDDTO dto) throws ServiceException;
	
	ROLResult updateSexoFechaCapturador(CapturadorCRUDDTO dto) throws ServiceException;
	
	// Servicios pertenecientes a Common.
	/**
	 * Obtiene un conjunto de objetos que representan los caracteres inválidos.
	 * @return Objetos caracteres inválidos.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getCaracteresInvalidosJustificacion() throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan las propiedades default.
	 * 
	 * @param dto Objeto propiedad default búsqueda por el cual filtrar.
	 * @return Objetos propiedades default.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getPropiedadesDefault(PropiedadDefaultSearchDTO dto) throws ServiceException;
	
	// Servicios pertenecientes a Facturación.
	/**
	 * 
	 * @param idOrdenPublicacion el id de la orden publicación.
	 * @return Objeto booleano que indica si la orden publicación es facturada.
	 * @throws ServiceException cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult validateOrdenFacturadaEnSAP(PrimitiveDTO<Long> idOrdenPublicacion) throws ServiceException;
	
	// Servicios pertenecientes a Interfaz Dinámica.
	/**
	 * Obtiene un conjunto de objetos que representan las clases.
	 * 
	 * @param dto Objeto clase por el cual filtrar.
	 * @return Objetos clases.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getBienes(ClaseSearchDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan las clases.
	 * 
	 * @param dto Objeto clase por el cual filtrar.
	 * @return Objetos clases.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getFamilias(ClaseSearchDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan las clases.
	 * 
	 * @param dto Objeto familias por filtro por el cual filtrar.
	 * @return Objetos clases.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getFamiliasByFilter(FamiliasByFilterSearchDTO dto) throws ServiceException;
	
	// Servicios pertenecientes a Aviso (Orden Publicación).
	/**
	 * Guarda un objeto orden publicación. 
	 * 
	 * @param dto Objeto orden publicación a guardar.
	 * @return Objeto orden publicación guardado.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult saveOrdenPublicacion(OrdenPublicacionDTO dto) throws ServiceException;
	
	/**
	 * Actualiza un objeto orden publicación.
	 * 
	 * @param dto Objeto orden publicación a actualizar.
	 * @return Objeto orden publicación actualizada.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult updateOrdenPublicacion(OrdenPublicacionDTO dto) throws ServiceException;
	
	/**
	 * Actualiza un objeto aviso perteneciente a orden publicación. 
	 * 
	 * @param dto Objeto update estado aviso que contiene el aviso a actualizar.
	 * @return Objeto orden publicación cuyo aviso fue actualizado.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult updateEstadoAviso(UpdateEstadoAvisoDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan las configuraciones de ordenamientos avisos por pantalla.
	 * 
	 * @param dto Objeto ordenamiento aviso búsqueda por el cual filtrar.
	 * @return Objetos configuraciones de ordenamientos avisos por pantalla obtenidos.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getConfiguracionesOrdenamientoPantalla(OrdenamientoAvisoSearchDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan los items de ordenamientos avisos.
	 * 
	 * @param dto Objeto item ordenamiento aviso búsqueda por el cual filtrar.
	 * @return Objetos items de ordenamientos avisos obtenidos.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getItemsOrdenamientoAviso(ItemOrdenamientoAvisoSearchDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan los items de ordenamientos avisos agrupados.
	 * 
	 * @param dto Objeto item ordenamiento aviso búsqueda agrupado por el cual filtrar.
	 * @return Objetos items de ordenamientos avisos agrupados obtenidos.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getItemsOrdenamientoAvisoGroup(ItemOrdenamientoAvisoGroupSearchDTO dto) throws ServiceException;
	
	// Servicios pertenecientes a Pretasador.
	/**
	 * Obtiene un conjunto de objetos que representan los conceptos vendibles con sus montos.
	 * 
	 * @param dto Objeto orden publicación a tasar.
	 * @return Objetos conceptos vendibles con sus montos.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult executeTasar(OrdenPublicacionDTO dto) throws ServiceException;
	
	// Servicios pertenecientes a Producto.
	/**
	 * Obtiene un conjunto de objetos que representan las fechas disponibles.
	 * 
	 * @param dto Objeto calendario por el cual filtrar.
	 * @return Objetos fechas disponibles.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getCalendario(CalendarioSearchDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un objeto que representa el producto comercial y template detallado default.
	 * 
	 * @param dto Objeto producto comercial default por el cual filtrar.
	 * @return Objeto producto comercial y template detallado default. 
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getProductoComercialDefault(ProductoComercialDefaultDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un objeto que representa el producto comercial.
	 * 
	 * @param dto Objeto producto comercial default por el cual filtrar.
	 * @return Objeto producto comercial obtenido. 
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getProductoComercial(ProductoComercialDefaultDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un objeto que representa el aviso justificado.
	 * 
	 * @param dto Objeto a justificar.
	 * @return Objeto justificado.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult executeJustificar(JustificacionDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan las palabras prohibidas.
	 * 
	 * @param dto Objeto texto por el cual validar.
	 * @return Objetos palabras prohibidas.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult validatePalabrasProhibidas(TextoValidateDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan las ordenes publicación.
	 * 
	 * @param dto Objeto capturador por el cual filtrar.
	 * @return Objetos ordenes publicación.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */	
	ROLResult getOrdenesPublicacionByCapturador(CapturadorCRUDDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan los niveles de estructuras.
	 * 
	 * @param dto Objeto nivel estructura por el cual filtrar.
	 * @return Objetos niveles de estructuras.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getNivelesEstructura(NivelEstructuraSearchDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un objeto que representa la lista de tarjetas que se pueden utilizar para pagar.
	 * 
	 * @param dto Objeto TarjetaPagoSearch que contiene el canal de entrada para las tarjetas a obtener.
	 * @return Objeto lista de tarjetas obtenido.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getTarjetasPago(TarjetaPagoSearchDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan los tipos de operaciones.
	 * 
	 * @param dto Objeto tipo operación por el cual filtrar.
	 * @return Objetos tipos de operaciones.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getTiposOperacion(TipoOperacionSearchDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan los productos.
	 * 
	 * @param dto Objeto producto por el cual filtrar.
	 * @return Objetos productos.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getProductos(ProductoSearchDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan las zonas de comercialización.
	 * 
	 * @param dto Objeto zona comercialización por el cual filtrar.
	 * @return Objetos zonas de comercialización.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getZonasComercializacion(ZonaComercializacionSearchDTO dto) throws ServiceException;
	
	/**
	 * Notifica el pago de una orden publicación.
	 * 
	 * @param dto Objeto a notificar.
	 * @return Objeto notificado.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult executeNotificarPago(GWPTransaccionDTO dto) throws ServiceException;
	
	/**
	 * Obtiene el template de precarga que coincida con los criterios de busqueda.
	 * 
	 * @param dto Objeto que contiene los criterios de busqueda para el template de precarga.
	 * @return Objeto template de precarga que coincide con los criterios de busqueda.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getTemplatePrecarga(TemplatePrecargaSearchDTO dto) throws ServiceException;
	
	/**
	 * Obtiene un conjunto de objetos que representan la imagenes de un template
	 * 
	 * @param dto Objeto template por el cual filtrar.
	 * @return Objetos imagenes.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getImagenes(TemplateDetalladoDTO dto) throws ServiceException;
	
	/**
	 * Obtiene los templates detallados de los productos comerciales del nivel de estructura que no son los 
	 * del producto comercial default.
	 * 
	 * @param dto Objeto que contiene el codigo del producto comercial default, el nivel del estructura, el canal de entrada y la fecha de vigencia.
	 * @return Objeto lista de templates detallados.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getTemplatesDetallado(TemplateDetalladoSearchDTO dto) throws ServiceException;

	/**
	 * Obtiene un conjunto de objetos que representan los mensajes de error de validacion
	 * 
	 * @param dto que contiene la Orden de publicacion y las promociones aplicables a validar para aplicar a la misma
	 * @return Listado de strings con los mensajes de errores, si es que hubo.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult validatePromociones(ValidarPromocionesDTO dto) throws ServiceException;
	
	/**
	 * Obtiene las configuracion de promocion por pantalla. que representan las promociones asociada a cada pantalla
	 * 
	 * @param dto Objeto que contiene el codigo del producto comercial , el nivel del estructura, el canal de entrada,la fecha de vigencia y una lista de codigos de zonas de comercializacion.
	 * @return Objeto lista de configuraciones de promociones por pantalla.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getConfiguracionesPromocionPantalla(PromocionSearchDTO dto) throws ServiceException;
	
	/**
	 * Obtiene los paises disponibles para cargar una direccion.
	 * 
	 * @return Objeto lista de paises.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getPaises() throws ServiceException;
	
	/**
	 * Obtiene las provincias disponibles para cargar una direccion dado un codigo de pais.
	 * 
	 * @param dto Objeto que contiene el codigo de pais.
	 * @return Objeto lista de provincias.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getProvincias(PaisDTO dto) throws ServiceException;
	
	/**
	 * Obtiene las localidades disponibles para cargar una direccion dado un codigo de provincia.
	 * 
	 * @param dto Objeto que contiene el codigo de provincia.
	 * @return Objeto lista de localidades.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores.
	 */
	ROLResult getLocalidades(ProvinciaDTO dto) throws ServiceException;
	
	/**
	 * Obtiene una orden de publicacion a partir de su Id
	 * 
	 * @param idOrdenPublicacion el id de la orden
	 * @return Objeto orden de publicacion dto
	 * @throws ServiceException cuando la salida a la llamada al servicio HUB devuelve errores
	 */
	ROLResult getOrdenPublicacionById(PrimitiveDTO<Long> idOrdenPublicacion) throws ServiceException;
	
	/**
	 * Valida la vigencia de un producto comercial, un nivel de estructura y un producto
	 * 
	 * @param dto Objeto que contiene los codigos a obtener y validar
	 * @return Objeto booleano que indica si es valido o no
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores
	 */
	ROLResult validateVigencia(ValidateVigenciaDTO dto) throws ServiceException;
	
	/**
	 * Devuelve la familia asociada a la clase del aviso
	 * 
	 * @param dto Objeto que contiene los datos con los que va a buscar
	 * @return Objeto clase 
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores 
	 */
	ROLResult getFamiliaByClaseAviso(ClaseSearchDTO dto) throws ServiceException;
	
	/**
	 * Devuelve la clase con los datos completos a partir de su codigo
	 * 
	 * @param dto Objeto que contiene los datos con los que va a buscar
	 * @return Objeto clase 
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores 
	 */
	ROLResult getClaseByCodigo(PrimitiveDTO<String> dto) throws ServiceException;
	
	/**
	 * Obtiene el permiso asociado al atributo y los parámetros de búsqueda.
	 * 
	 * @param dto Objeto  que contiene los parametros de busquedas para el 
	 * permisos y sus atributos.
	 * @return Objeto atributo CID que contiene asociado los permisos.
	 * @throws ServiceException Cuando la salida a la llamada al servicio HUB devuelve errores
	 */
	ROLResult getPermisoAtributoByFilter(PermisoAtributoSearchDTO dto) throws ServiceException;
}
