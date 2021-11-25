/*
 * @(#)ROLResultHUBBuilder.java		1.0 21/11/2013
 */

package ar.com.agea.hub.rol.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.com.agea.hub.rol.model.dto.ClaseDTO;
import ar.com.agea.hub.rol.model.dto.ConceptoVendibleDTO;
import ar.com.agea.hub.rol.model.dto.ConfiguracionOrdenamientoPantallaDTO;
import ar.com.agea.hub.rol.model.dto.ConfiguracionPromocionPantallaDTO;
import ar.com.agea.hub.rol.model.dto.ImagenDTO;
import ar.com.agea.hub.rol.model.dto.ItemOrdenamientoAvisoDTO;
import ar.com.agea.hub.rol.model.dto.ItemOrdenamientoAvisoGroupDTO;
import ar.com.agea.hub.rol.model.dto.NivelEstructuraDTO;
import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;
import ar.com.agea.hub.rol.model.dto.ProductoComercialTemplateDTO;
import ar.com.agea.hub.rol.model.dto.ProductoDTO;
import ar.com.agea.hub.rol.model.dto.PromocionDTO;
import ar.com.agea.hub.rol.model.dto.PropiedadDefaultDTO;
import ar.com.agea.hub.rol.model.dto.TarjetaPagoDTO;
import ar.com.agea.hub.rol.model.dto.TemplatePrecargaDTO;
import ar.com.agea.hub.rol.model.dto.TipoOperacionDTO;
import ar.com.agea.hub.rol.model.dto.ZonaComercializacionDTO;
import ar.com.agea.hub.rol.model.result.HUBError;
import ar.com.agea.hub.rol.model.result.HUBErrorType;
import ar.com.agea.hub.rol.model.result.HUBResult;
import ar.com.agea.hub.rol.model.result.ROLError;
import ar.com.agea.hub.rol.model.result.ROLErrorType;
import ar.com.agea.hub.rol.model.result.ROLMessageCode;

/**
 * Provee una implementación de la clase ROLResultBuilder.
 * <p>
 * Construye un objeto ROLResult a partir datos provenientes de un objeto resultado HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 21/11/2013
 */
public final class ROLResultHUBBuilder extends ROLResultBuilder {
	
	private static Map<URLServiceName, Object> defaultCollectionValues;
	private static Map<HUBErrorType, ROLErrorType> hubErrorsType;
	private static Map<String, ROLMessageCode> messagesCodeByString;
	
	static {
		defaultCollectionValues = new HashMap<URLServiceName, Object>();
		
		defaultCollectionValues.put(URLServiceName.HUB_GET_CARACTERES_INVALIDOS_JUSTIFICACION, new ArrayList<Integer>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_PROPIEDADES_DEFAULT, new ArrayList<PropiedadDefaultDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_BIENES, new ArrayList<ClaseDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_FAMILIAS, new ArrayList<ClaseDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_CONFIGURACIONES_ORDENAMIENTO_PANTALLA, new ArrayList<ConfiguracionOrdenamientoPantallaDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_ITEMS_ORDENAMIENTO_AVISO, new ArrayList<ItemOrdenamientoAvisoDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_ITEMS_ORDENAMIENTO_AVISO_GROUP, new ArrayList<ItemOrdenamientoAvisoGroupDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_EXECUTE_TASAR, new ArrayList<ConceptoVendibleDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_CALENDARIO, new ArrayList<Date>());
		defaultCollectionValues.put(URLServiceName.HUB_VALIDATE_PALABRAS_PROHIBIDAS, new ArrayList<String>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_ORDENES_PUBLICACION_BY_CAPTURADOR, new ArrayList<OrdenPublicacionDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_NIVELES_ESTRUCTURA, new ArrayList<NivelEstructuraDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_TARJETAS_PAGO, new ArrayList<TarjetaPagoDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_TIPOS_OPERACION, new ArrayList<TipoOperacionDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_PRODUCTOS, new ArrayList<ProductoDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_ZONAS_COMERCIALIZACION, new ArrayList<ZonaComercializacionDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_TEMPLATES_DETALLADO, new ArrayList<ProductoComercialTemplateDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_IMAGENES, new ArrayList<ImagenDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_TEMPLATE_PRECARGA, new ArrayList<TemplatePrecargaDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_GET_CONFIGURACIONES_PROMOCION_PANTALLA, new ArrayList<ConfiguracionPromocionPantallaDTO>());
		defaultCollectionValues.put(URLServiceName.HUB_VALIDATE_PROMOCIONES, new ArrayList<PromocionDTO>());
		
		hubErrorsType = new HashMap<HUBErrorType, ROLErrorType>();
		
		hubErrorsType.put(HUBErrorType.NULLED_VALUE, ROLErrorType.EXCEPTION);
		hubErrorsType.put(HUBErrorType.EMPTY_VALUE, ROLErrorType.EXCEPTION);
		hubErrorsType.put(HUBErrorType.NULLED_EMPTY_VALUE, ROLErrorType.EXCEPTION);
		hubErrorsType.put(HUBErrorType.EXIST_VALUE, ROLErrorType.EXCEPTION);
		hubErrorsType.put(HUBErrorType.NOT_EXIST_VALUE, ROLErrorType.EXCEPTION);
		hubErrorsType.put(HUBErrorType.NOT_APPLIED_VALUE, ROLErrorType.EXCEPTION);
		hubErrorsType.put(HUBErrorType.NOT_EQUAL_VALUE, ROLErrorType.EXCEPTION);
		hubErrorsType.put(HUBErrorType.DUPLICATED_VALUE, ROLErrorType.EXCEPTION);
		hubErrorsType.put(HUBErrorType.EXCEPTION_OCCURRED, ROLErrorType.EXCEPTION);
		
		messagesCodeByString = new HashMap<String, ROLMessageCode>();
		
		messagesCodeByString.put("La fecha de publicacion seleccionada esta cerrada. Por favor elegi otra fecha.", ROLMessageCode.CODE_000010);
		messagesCodeByString.put("Error obtener el Preview de Diseño: El preview tiene menos líneas que el alto mínimo del template", ROLMessageCode.CODE_000013);
										  
	}
	
	/**
	 * Construye los datos del objeto ROLResult.
	 * 
	 * @param hubResult Objeto datos del objeto ROLResult.
	 * @param urlServiceName Objeto nombre de servicio URL del objeto ROLResult.
	 */
	public <T> void buildData(HUBResult<T> hubResult, URLServiceName urlServiceName) {
		if (hubResult.getObject() != null) {
			rolResult.setObject(hubResult.getObject());
		} else if (urlServiceName != null && !hubResult.hasErrors()) {
			rolResult.setObject(defaultCollectionValues.get(urlServiceName));
		}
		
		Set<ROLError> rolErrors = new HashSet<ROLError>();
		
		for (HUBError hubError : hubResult.getErrors()) {
			ROLError rolError = new ROLError();
			
			rolError.setMessageCode(messagesCodeByString.get(hubError.getMessage()));
			rolError.setErrorType(hubErrorsType.get(hubError.getErrorType()));
			rolError.setMessage(hubError.getMessage());
			
			rolErrors.add(rolError);
		}
		
		rolResult.setErrors(rolErrors);
	}
}
