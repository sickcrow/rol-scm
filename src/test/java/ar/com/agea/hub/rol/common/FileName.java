/*
 * @(#)FileName.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.common;

/**
 * Representa los nombres de los archivos de entrada para los servicios HUB y PASE.
 * <p>
 * Estos nombres son utilizados por la clase ServiceTest para cargar
 * el contenido de todos los archivos con extensión .json que se encuentran
 * en test resources. 
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public enum FileName {
	// CommonServiceTest
	TEST_GET_PROPIEDADES_DEFAULT_WITH_EXCEPTION("testGetPropiedadesDefaultWithException.json"),
	TEST_GET_PROPIEDADES_DEFAULT_WITHOUT_ERRORS("testGetPropiedadesDefaultWithoutErrors.json"),
	
	// CommonUtilServiceTest
	TEST_GET_AGRUPADORES_PRODUCTO_ZONAS_NIVELES_WITH_ERRORS("testGetAgrupadoresProductoZonasNivelesWithErrors.json"),
	TEST_GET_AGRUPADORES_PRODUCTO_ZONAS_NIVELES_WITHOUT_ERRORS("testGetAgrupadoresProductoZonasNivelesWithoutErrors.json"),
	TEST_EXECUTE_JUSTIFICAR_AND_TASAR_WITH_ERRORS("testExecuteJustificarAndTasarWithErrors.json"),
	TEST_EXECUTE_JUSTIFICAR_AND_TASAR_WITHOUT_ERRORS("testExecuteJustificarAndTasarWithoutErrors.json"),
	TEST_LOGIN_USUARIO_WITHOUT_ERRORS("testLoginUsuarioWithoutErrors.json"),
	TEST_UPDATE_USUARIO_WITHOUT_ERRORS("testUpdateUsuarioWithoutErrors.json"),
	
	// InterfazDinamicaServiceTest
	TEST_GET_BIENES_WITH_EXCEPTION("testGetBienesWithException.json"),
	TEST_GET_BIENES_WITHOUT_ERRORS("testGetBienesWithoutErrors.json"),
	TEST_GET_FAMILIAS_WITH_EXCEPTION("testGetFamiliasWithErrors.json"),
	TEST_GET_FAMILIAS_WITHOUT_ERRORS("testGetFamiliasWithoutErrors.json"),
	
	// OrdenPublicacionServiceTest
	TEST_GET_CONFIGURACIONES_ORDENAMIENTO_PANTALLA_WITH_EXCEPTION("testGetConfiguracionesOrdenamientoPantallaWithErrors.json"),
	TEST_GET_CONFIGURACIONES_ORDENAMIENTO_PANTALLA_WITHOUT_ERRORS("testGetConfiguracionesOrdenamientoPantallaWithoutErrors.json"),
	TEST_FIRST_GET_ITEMS_ORDENAMIENTO_AVISO_WITH_EXCEPTION("testGetItemsOrdenamientoAvisoWithException01.json"),
	TEST_SECOND_GET_ITEMS_ORDENAMIENTO_AVISO_WITH_EXCEPTION("testGetItemsOrdenamientoAvisoWithException02.json"),
	TEST_FIRST_GET_ITEMS_ORDENAMIENTO_AVISO_WITHOUT_ERRORS("testGetItemsOrdenamientoAvisoWithoutErrors01.json"),
	TEST_SECOND_GET_ITEMS_ORDENAMIENTO_AVISO_WITHOUT_ERRORS("testGetItemsOrdenamientoAvisoWithoutErrors02.json"),
	TEST_UPDATE_ESTADO_AVISO_WITHOUT_ERRORS("testUpdateEstadoAvisoWithoutErrors.json"),

	// PretasadorServiceTest
	TEST_EXECUTE_TASAR_WITH_EXCEPTION("executeTasarWithException.json"),
	TEST_EXECUTE_TASAR_WITHOUT_ERRORS("executeTasarWithoutErrors.json"),

	// ProductoServiceTest
	TEST_GET_CALENDARIO_WITH_EXCEPTION("testGetCalendarioWithException.json"),
	TEST_GET_CALENDARIO_WITHOUT_ERRORS("testGetCalendarioWithoutErrors.json"),
	TEST_GET_PRODUCTO_COMERCIAL_DEFAULT_WITH_EXCEPTION("testGetProductoComercialDefaultWithException.json"),
	TEST_FIRST_GET_PRODUCTO_COMERCIAL_DEFAULT_WITHOUT_ERRORS("testGetProductoComercialDefaultWithNullResult.json"),
	TEST_SECOND_GET_PRODUCTO_COMERCIAL_DEFAULT_WITHOUT_ERRORS("testGetProductoComercialDefaultWithoutNullResult.json"),
	TEST_GET_PRODUCTO_COMERCIAL_WITH_EXCEPTION("testGetProductoComercialWithException.json"),
	TEST_FIRST_GET_PRODUCTO_COMERCIAL_WITHOUT_ERRORS("testGetProductoComercialWithNullResult.json"),
	TEST_SECOND_GET_PRODUCTO_COMERCIAL_WITHOUT_ERRORS("testGetProductoComercialWithoutNullResult.json"),
	TEST_EXECUTE_JUSTIFICAR_WITH_EXCEPTION("testExecuteJustificarWithException.json"),
	TEST_EXECUTE_JUSTIFICAR_WITHOUT_ERRORS("testExecuteJustificarWithoutErrors.json"),
	TEST_VALIDATE_PALABRAS_PROHIBIDAS_WITH_EXCEPTION("testValidatePalabrasProhibidasWithException.json"),
	TEST_VALIDATE_PALABRAS_PROHIBIDAS_WITHOUT_ERRORS("testValidatePalabrasProhibidasWithoutErrors.json"),
	TEST_GET_NIVELES_ESTRUCTURA_WITH_EXCEPTION("testGetNivelesEstructuraWithException.json"),
	TEST_GET_NIVELES_ESTRUCTURA_WITHOUT_ERRORS("testGetNivelesEstructuraWithoutErrors.json"),
	TEST_GET_TIPOS_OPERACION_WITH_EXCEPTION("testGetTiposOperacionWithException.json"),
	TEST_GET_TIPOS_OPERACION_WITHOUT_ERRORS("testGetTiposOperacionWithoutErrors.json"),
	TEST_GET_PRODUCTOS_WITH_EXCEPTION("testGetProductosWithException.json"),
	TEST_GET_PRODUCTOS_WITHOUT_ERRORS("testGetProductosWithoutErrors.json"),
	TEST_GET_ZONAS_COMERCIALIZACION_WITH_EXCEPTION("testGetZonasComercializacionWithException.json"),
	TEST_GET_ZONAS_COMERCIALIZACION_WITHOUT_ERRORS("testGetZonasComercializacionWithoutErrors.json"),
	TEST_GET_CONFIGURACIONES_PROMOCION_PANTALLA_WITH_EXCEPTION("testGetConfiguracionesPromocionPantallaWithException.json"),
	TEST_GET_CONFIGURACIONES_PROMOCION_PANTALLA_WITHOUT_ERRORS("testGetConfiguracionesPromocionPantallaWithoutErrors.json"),
	
	TEST_GET_TARJETAS_PAGOS_WITHOUT_ERRORS("testGetTarjetasPagoWithoutErrors.json"),
	
	TEST_GET_ORDENES_PUBLICACION_BY_CAPTURADOR_WITHOUT_ERRORS("testGetOrdenesPublicacionByCapturadorWithoutErrors.json"),
	
	// GWPServiceTest
	TEST_REALIZAR_WITH_ERRORS("testRealizarWithErrors.json"),
	
	// PASEServiceTest
	TEST_REGISTRAR_USUARIO_WITH_ERRORS("testRegistrarUsuarioWithErrors.json"),
	TEST_AUTENTICAR_USUARIO_WITH_ERRORS("testAutenticarUsuarioWithErrors.json"),
	TEST_AUTENTICAR_USUARIO_WITHOUT_ERRORS("testAutenticarUsuarioWithoutErrors.json"),
	
	// ROLServiceTest
	TEST_EXECUTE_PAGAR_AND_GUARDAR_WITH_ERRORS("testExecutePagarAndGuardarWithErrors.json");
	
	private String reference;

	private FileName(String reference) {
		this.reference = reference;
	}
	
	/**
	 * Obtiene el objeto FileName representando por reference.
	 * 
	 * @param reference Objeto reference asociado a un objeto FileName.
	 * @return Objeto FileName asociado a un objeto reference.
	 */
	public static FileName getByReference(String reference) {
		FileName result = null;
		
		for (FileName fileName : values()) {
			if (fileName.reference.equalsIgnoreCase(reference)) {
				result = fileName;
				break;
			}
		}
		
		return result;
	}
}
