/*
 * @(#)DefaultHUBService.java		1.0 23/10/2013
 */

package ar.com.agea.hub.rol.service.impl;

import org.springframework.stereotype.Component;

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
import ar.com.agea.hub.rol.model.result.AtributoCIDResult;
import ar.com.agea.hub.rol.model.result.BooleanHUBResult;
import ar.com.agea.hub.rol.model.result.CapturadorHUBResult;
import ar.com.agea.hub.rol.model.result.ClaseHUBResult;
import ar.com.agea.hub.rol.model.result.ClasesHUBResult;
import ar.com.agea.hub.rol.model.result.ConceptosVendibleHUBResult;
import ar.com.agea.hub.rol.model.result.ConfiguracionesOrdenamientoPantallaHUBResult;
import ar.com.agea.hub.rol.model.result.ConfiguracionesPromocionPantallaHUBResult;
import ar.com.agea.hub.rol.model.result.DatesHUBResult;
import ar.com.agea.hub.rol.model.result.FamiliasHUBResult;
import ar.com.agea.hub.rol.model.result.ImagenesHUBResult;
import ar.com.agea.hub.rol.model.result.IntegersHUBResult;
import ar.com.agea.hub.rol.model.result.ItemsOrdenamientoAvisoGroupHUBResult;
import ar.com.agea.hub.rol.model.result.ItemsOrdenamientoAvisoHUBResult;
import ar.com.agea.hub.rol.model.result.JustificacionHUBResult;
import ar.com.agea.hub.rol.model.result.LocalidadesHUBResult;
import ar.com.agea.hub.rol.model.result.NivelesEstructuraHUBResult;
import ar.com.agea.hub.rol.model.result.OrdenPublicacionHUBResult;
import ar.com.agea.hub.rol.model.result.OrdenesPublicacionHUBResult;
import ar.com.agea.hub.rol.model.result.PaisesHUBResult;
import ar.com.agea.hub.rol.model.result.ProductoComercialDefaultHUBResult;
import ar.com.agea.hub.rol.model.result.ProductoComercialHUBResult;
import ar.com.agea.hub.rol.model.result.ProductosComercialTemplateHUBResult;
import ar.com.agea.hub.rol.model.result.ProductosHUBResult;
import ar.com.agea.hub.rol.model.result.PromocionesHUBResult;
import ar.com.agea.hub.rol.model.result.PropiedadesDefaultHUBResult;
import ar.com.agea.hub.rol.model.result.ProvinciasHUBResult;
import ar.com.agea.hub.rol.model.result.ROLResult;
import ar.com.agea.hub.rol.model.result.StringsHUBResult;
import ar.com.agea.hub.rol.model.result.TarjetasPagoHUBResult;
import ar.com.agea.hub.rol.model.result.TemplatePrecargaHUBResult;
import ar.com.agea.hub.rol.model.result.TiposOperacionHUBResult;
import ar.com.agea.hub.rol.model.result.ZonasComercializacionHUBResult;
import ar.com.agea.hub.rol.service.HUBService;
import ar.com.agea.hub.rol.service.Service;
import ar.com.agea.hub.rol.utils.URLServiceName;

/**
 * Provee una implementación de la interfaz HUBService.
 * 
 * @author		Eduardo Barrera
 * @author		Juan Martín Lichowski
 * @version		1.0 23/10/2013
 */
@Component
public class DefaultHUBService extends Service implements HUBService {

	// Servicios pertenecientes a Cliente.
	@Override
	public ROLResult saveCapturador(CapturadorCRUDDTO dto) throws ServiceException {
		getLogger().info("Guardando capturador...");
		
		CapturadorHUBResult tmp = getFacade().callService(URLServiceName.HUB_SAVE_CAPTURADOR, dto, CapturadorHUBResult.class, null);
		URLServiceName service = null;
		
		ROLResult rolResult = handleResult(tmp, service);

		getLogger().info("Capturador guardado.");
		
		return rolResult;
	}

	@Override
	public ROLResult updateCapturador(CapturadorCRUDDTO dto) throws ServiceException {
		getLogger().info("Actualizando capturador...");
		
		CapturadorHUBResult tmp = getFacade().callService(URLServiceName.HUB_UPDATE_CAPTURADOR, dto, CapturadorHUBResult.class, null);
		URLServiceName service = null;
		
		ROLResult rolResult = handleResult(tmp, service);

		getLogger().info("Capturador actualizado.");
		
		return rolResult;
	}
	
	@Override
	public ROLResult updateOrdenPublicacion(OrdenPublicacionDTO dto) throws ServiceException {
		getLogger().info("Actualizando orden publicación...");
		
		OrdenPublicacionHUBResult tmp = getFacade().callService(URLServiceName.HUB_UPDATE_ORDEN_PUBLICACION, dto, OrdenPublicacionHUBResult.class, null);
		URLServiceName service = null;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Orden publicación \'" + ((OrdenPublicacionDTO) rolResult.getObject()).getId() + "\' actualizada.");
		
		return rolResult;
	}

	@Override
	public ROLResult updateEstadoAviso(UpdateEstadoAvisoDTO dto) throws ServiceException {
		getLogger().info("Actualizando aviso...");
		
		OrdenPublicacionHUBResult tmp = getFacade().callService(URLServiceName.HUB_UPDATE_ESTADO_AVISO, dto, OrdenPublicacionHUBResult.class, null);
		URLServiceName service = null;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Aviso \'" + dto.getIdAviso() + "\' actualizado.");
		
		return rolResult;
	}

	@Override
	public ROLResult getCapturador(CapturadorCRUDDTO dto) throws ServiceException {
		getLogger().info("Obteniendo capturador...");
		
		CapturadorHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_CAPTURADOR, dto, CapturadorHUBResult.class, null);
		URLServiceName service = null;
		
		ROLResult rolResult = handleResult(tmp, service);

		getLogger().info("Capturador obtenido.");
		
		return rolResult;
	}
	
	
	@Override
	public ROLResult updateSexoFechaCapturador(CapturadorCRUDDTO dto) throws ServiceException {
		getLogger().info("Actualizando sexo / fecha en  capturador...");
		
		CapturadorHUBResult tmp = getFacade().callService(URLServiceName.HUB_UPDATE_SEXO_FECHA_CAPTURADOR, dto, CapturadorHUBResult.class, null);
		URLServiceName service = null;
		
		ROLResult rolResult = handleResult(tmp, service);

		getLogger().info("Capturador guardado.");
		
		return rolResult;
	}
	
	// Servicios pertenecientes a Common.
	@Override
	public ROLResult getCaracteresInvalidosJustificacion() throws ServiceException {
		getLogger().info("Obteniendo caracteres inválidos...");
		
		IntegersHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_CARACTERES_INVALIDOS_JUSTIFICACION, null, IntegersHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_CARACTERES_INVALIDOS_JUSTIFICACION;
		
		ROLResult rolResult = handleResult(tmp, service);
			
		getLogger().info("Caracteres inválidos obtenidos.");
		
		return rolResult;
	}

	@Override
	public ROLResult getPropiedadesDefault(PropiedadDefaultSearchDTO propiedadesDefaultSearch) throws ServiceException {
		getLogger().info("Obteniendo propiedades default...");
		
		PropiedadesDefaultHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_PROPIEDADES_DEFAULT, propiedadesDefaultSearch, PropiedadesDefaultHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_PROPIEDADES_DEFAULT;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Propiedades default obtenidas.");
		
		return rolResult;
	}
	
	@Override
	public ROLResult validateOrdenFacturadaEnSAP(PrimitiveDTO<Long> idOrdenPublicacion) throws ServiceException {
		getLogger().info("Validando orden publicación facturada en SAP...");
		
		URLServiceName service = URLServiceName.HUB_VALIDATE_ORDEN_FACTURADA_EN_SAP;
		BooleanHUBResult tmp = getFacade().callService(service, idOrdenPublicacion, BooleanHUBResult.class, null);
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Orden publicacion facturada en SAP validada.");
		
		return rolResult;
	}

	// Servicios pertenecientes a Interfaza Dinamicá.
	@Override
	public ROLResult getBienes(ClaseSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo bienes...");
		
		ClasesHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_BIENES, dto, ClasesHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_BIENES;
				
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Bienes obtenidos.");
		
		return rolResult;
	}

	@Override
	public ROLResult getFamilias(ClaseSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo familias...");
		
		ClasesHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_FAMILIAS, dto, ClasesHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_FAMILIAS;
				
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Familias obtenidas.");
		
		return rolResult;
	}
	
	@Override
	public ROLResult getFamiliasByFilter(FamiliasByFilterSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo familias por filtro...");
		
		FamiliasHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_FAMILIAS_BY_FILTER, dto, FamiliasHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_FAMILIAS_BY_FILTER;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Familias por filtro obtenidas.");
		
		return rolResult;
	}

	// Servicios pertenecientes a Aviso (Orden Publicación).
	@Override
	public ROLResult saveOrdenPublicacion(OrdenPublicacionDTO dto) throws ServiceException {
		getLogger().info("Guardando orden publicación...");
		
		OrdenPublicacionHUBResult tmp = getFacade().callService(URLServiceName.HUB_SAVE_ORDEN_PUBLICACION, dto, OrdenPublicacionHUBResult.class, null);
		URLServiceName service = null;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Orden publicación \'" + ((OrdenPublicacionDTO) rolResult.getObject()).getId() + "\' guardada.");
		
		return rolResult;
	}

	@Override
	public ROLResult getConfiguracionesOrdenamientoPantalla(OrdenamientoAvisoSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo configuraciones ordenamiento pantalla...");
		
		ConfiguracionesOrdenamientoPantallaHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_CONFIGURACIONES_ORDENAMIENTO_PANTALLA, dto, ConfiguracionesOrdenamientoPantallaHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_CONFIGURACIONES_ORDENAMIENTO_PANTALLA; 
				
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Configuraciones ordenamiento pantalla obtenidas.");
		
		return rolResult;
	}

	@Override
	public ROLResult getItemsOrdenamientoAviso(ItemOrdenamientoAvisoSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo items ordenamiento aviso...");
		
		ItemsOrdenamientoAvisoHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_ITEMS_ORDENAMIENTO_AVISO, dto, ItemsOrdenamientoAvisoHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_ITEMS_ORDENAMIENTO_AVISO;
				
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Items ordenamiento aviso obtenidos.");
		
		return rolResult;
	}

	@Override
	public ROLResult getItemsOrdenamientoAvisoGroup(ItemOrdenamientoAvisoGroupSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo items ordenamiento aviso agrupados...");
		
		ItemsOrdenamientoAvisoGroupHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_ITEMS_ORDENAMIENTO_AVISO_GROUP, dto, ItemsOrdenamientoAvisoGroupHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_ITEMS_ORDENAMIENTO_AVISO_GROUP;
				
		ROLResult rolResult = handleResult(tmp, service);

		getLogger().info("Items ordenamiento aviso agrupados obtenidos.");
		
		return rolResult;
	}

	// Servicios pertenecientes a Pretasador.
	@Override
	public ROLResult executeTasar(OrdenPublicacionDTO dto) throws ServiceException {
		getLogger().info("Tasando aviso...");
		
		ConceptosVendibleHUBResult tmp = getFacade().callService(URLServiceName.HUB_EXECUTE_TASAR, dto, ConceptosVendibleHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_EXECUTE_TASAR;
				
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Aviso tasado.");
		
		return rolResult;
	}
	
	// Servicios pertenecientes a Producto.
	@Override
	public ROLResult getCalendario(CalendarioSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo calendario...");
		
		DatesHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_CALENDARIO, dto, DatesHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_CALENDARIO;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Calendario obtenido.");
		
		return rolResult;
	}

	@Override
	public ROLResult getProductoComercialDefault(ProductoComercialDefaultDTO dto) throws ServiceException {
		getLogger().info("Obteniendo producto comercial default...");
		
		ProductoComercialDefaultHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_PRODUCTO_COMERCIAL_DEFAULT, dto, ProductoComercialDefaultHUBResult.class, null);
		URLServiceName service = null;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Producto comercial default obtenido.");
		
		return rolResult;
	}

	@Override
	public ROLResult getProductoComercial(ProductoComercialDefaultDTO dto) throws ServiceException {
		getLogger().info("Obteniendo producto comercial...");
		
		ProductoComercialHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_PRODUCTO_COMERCIAL, dto, ProductoComercialHUBResult.class, null);
		URLServiceName service = null;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Producto comercial obtenido.");
		
		return rolResult;
	}
	
	@Override
	public ROLResult executeJustificar(JustificacionDTO dto) throws ServiceException {
		getLogger().info("Justificando aviso...");
		
		JustificacionHUBResult tmp = getFacade().callService(URLServiceName.HUB_EXECUTE_JUSTIFICAR, dto, JustificacionHUBResult.class, null);
		URLServiceName service = null;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Aviso justificado.");
		
		return rolResult;
	}

	@Override
	public ROLResult validatePalabrasProhibidas(TextoValidateDTO dto) throws ServiceException {
		getLogger().info("Validando palabras prohibidas...");
		
		StringsHUBResult tmp = getFacade().callService(URLServiceName.HUB_VALIDATE_PALABRAS_PROHIBIDAS, dto, StringsHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_VALIDATE_PALABRAS_PROHIBIDAS;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Palabras prohibidas validadas.");
		
		return rolResult;
	}

	@Override
	public ROLResult getOrdenesPublicacionByCapturador(CapturadorCRUDDTO dto) throws ServiceException {
		getLogger().info("Obteniendo ordenes publicación por capturador...");
		
		OrdenesPublicacionHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_ORDENES_PUBLICACION_BY_CAPTURADOR, dto, OrdenesPublicacionHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_ORDENES_PUBLICACION_BY_CAPTURADOR;
				
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Ordenes publicación por capturador obtenidas.");
		
		return rolResult;
	}

	@Override
	public ROLResult getNivelesEstructura(NivelEstructuraSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo niveles de estructuras...");
		
		NivelesEstructuraHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_NIVELES_ESTRUCTURA, dto, NivelesEstructuraHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_NIVELES_ESTRUCTURA;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Niveles de estructuras obtenidos.");
		
		return rolResult;
	}
	
	@Override
	public ROLResult getTarjetasPago(TarjetaPagoSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo tarjetas de pago...");
		
		TarjetasPagoHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_TARJETAS_PAGO, dto, TarjetasPagoHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_TARJETAS_PAGO;
				
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Tarjetas de pago obtenidas.");
		
		return rolResult;
	}

	@Override
	public ROLResult getTiposOperacion(TipoOperacionSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo tipos de operación...");
		
		TiposOperacionHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_TIPOS_OPERACION, dto, TiposOperacionHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_TIPOS_OPERACION;
				
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Tipos de operación obtenidos.");
		
		return rolResult;
	}
	
	@Override
	public ROLResult getProductos(ProductoSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo productos...");
		
		ProductosHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_PRODUCTOS, dto, ProductosHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_PRODUCTOS;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Productos obtenidos.");
		
		return rolResult;
	}

	@Override
	public ROLResult getZonasComercializacion(ZonaComercializacionSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo zonas de comercialización...");
		
		ZonasComercializacionHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_ZONAS_COMERCIALIZACION, dto, ZonasComercializacionHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_ZONAS_COMERCIALIZACION;
				
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Zonas de comercialización obtenidas.");
		
		return rolResult;
	}

	@Override
	public ROLResult executeNotificarPago(GWPTransaccionDTO dto) throws ServiceException {
		getLogger().info("Notificando pago...");
		
		OrdenPublicacionHUBResult tmp = getFacade().callService(URLServiceName.HUB_EXECUTE_NOTIFICAR_PAGO, dto, OrdenPublicacionHUBResult.class, null);
		URLServiceName service = null;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Pago notificado.");
		
		return rolResult;
	}

	@Override
	public ROLResult getTemplatesDetallado(TemplateDetalladoSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo templates detallado...");
		
		ProductosComercialTemplateHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_TEMPLATES_DETALLADO, dto, ProductosComercialTemplateHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_TEMPLATES_DETALLADO;
				
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Templates detallado obtenidos.");
		
		return rolResult;
	}
	
	@Override
	public ROLResult getImagenes(TemplateDetalladoDTO dto) throws ServiceException {
		getLogger().info("Obteniendo imagenes..."); 
		
		ImagenesHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_IMAGENES, dto, ImagenesHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_IMAGENES;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Imagenes obtenidas");
		
		return rolResult;
	}
	
	@Override
	public ROLResult getTemplatePrecarga(TemplatePrecargaSearchDTO dto)	throws ServiceException {
		getLogger().info("Obteniendo template precarga...");
		
		TemplatePrecargaHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_TEMPLATE_PRECARGA, dto, TemplatePrecargaHUBResult.class, null);
		URLServiceName service = null;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Template precarga obtenido.");
		
		return rolResult;
	}

	@Override
	public ROLResult getConfiguracionesPromocionPantalla(PromocionSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo configuraciones promoción pantalla...");
		
		ConfiguracionesPromocionPantallaHUBResult tmp =  getFacade().callService(URLServiceName.HUB_GET_CONFIGURACIONES_PROMOCION_PANTALLA, dto, ConfiguracionesPromocionPantallaHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_CONFIGURACIONES_PROMOCION_PANTALLA;
		
		ROLResult rolResult = handleResult(tmp, service);		
		
		getLogger().info("configuraciones promoción pantalla obtenidas.");
		
		return rolResult;
	}
	
	@Override
	public ROLResult validatePromociones(ValidarPromocionesDTO dto) throws ServiceException {
		getLogger().info("Validando promociones...");
		
		PromocionesHUBResult tmp = getFacade().callService(URLServiceName.HUB_VALIDATE_PROMOCIONES, dto, PromocionesHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_VALIDATE_PROMOCIONES;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Promociones validadas.");
		
		return rolResult;
	}
	
	@Override
	public ROLResult getPaises() throws ServiceException {
		getLogger().info("Obteniendo paises...");
		
		PaisesHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_PAISES, null, PaisesHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_PAISES;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Paises obtenidos.");
		
		return rolResult;
	}

	@Override
	public ROLResult getProvincias(PaisDTO dto) throws ServiceException {
		getLogger().info("Obteniendo provincias...");
		
		ProvinciasHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_PROVINCIAS, dto, ProvinciasHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_PROVINCIAS;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Provincias obtenidas.");
		
		return rolResult;
	}
	
	@Override
	public ROLResult getLocalidades(ProvinciaDTO dto) throws ServiceException {
		getLogger().info("Obteniendo localidades...");
		
		LocalidadesHUBResult tmp = getFacade().callService(URLServiceName.HUB_GET_LOCALIDADES, dto, LocalidadesHUBResult.class, null);
		URLServiceName service = URLServiceName.HUB_GET_LOCALIDADES;
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Localidades obtenidas.");
		
		return rolResult;
	}
	
	@Override
	public ROLResult getOrdenPublicacionById(PrimitiveDTO<Long> idOrdenPublicacion) throws ServiceException {
		getLogger().info("Obteniendo orden publicación por id...");
		
		URLServiceName service = URLServiceName.HUB_GET_ORDEN_PUBLICACION_BY_ID;
		OrdenPublicacionHUBResult tmp = getFacade().callService(service, idOrdenPublicacion, OrdenPublicacionHUBResult.class, null);
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Orden publicacion por id obtenida.");
		
		return rolResult;
	}
	
	@Override
	public ROLResult validateVigencia(ValidateVigenciaDTO dto) throws ServiceException {
		getLogger().info("Validando vigencia...");
		
		URLServiceName service = URLServiceName.HUB_VALIDATE_VIGENCIA;
		BooleanHUBResult tmp = getFacade().callService(service, dto, BooleanHUBResult.class, null);
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Vigencia validada.");
		
		return rolResult;
	}

	@Override
	public ROLResult getFamiliaByClaseAviso(ClaseSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo familia por clase y aviso...");
		
		URLServiceName service = URLServiceName.HUB_GET_FAMILIA_BY_CLASE_AVISO;
		
		ClasesHUBResult tmp = getFacade().callService(service, dto, ClasesHUBResult.class, null);
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Familia por clase y aviso obtenida.");
		
		return rolResult;
	}

	@Override
	public ROLResult getClaseByCodigo(PrimitiveDTO<String> dto) throws ServiceException {
		getLogger().info("Obteniendo clase por codigo...");
		
		URLServiceName service = URLServiceName.HUB_GET_CLASE_BY_CODIGO;
		
		ClaseHUBResult tmp = getFacade().callService(service, dto, ClaseHUBResult.class, null);
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Clase port codigo obtenida.");
		
		return rolResult;
	}
	
	@Override
	public ROLResult getPermisoAtributoByFilter(PermisoAtributoSearchDTO dto) throws ServiceException {
		getLogger().info("Obteniendo permiso atributo...");
	
		URLServiceName service = URLServiceName.HUB_GET_PERMISO_ATRIBUTO_BY_FILTER;
	
		AtributoCIDResult tmp = getFacade().callService(service, dto, AtributoCIDResult.class, null);
		
		ROLResult rolResult = handleResult(tmp, service);
		
		getLogger().info("Atributo CID y permisos obtenidos.");
		
		return rolResult;		
	}
	
}
