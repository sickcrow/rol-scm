// CrearAvisoServiceURL --------------------------------

var CrearAvisoServiceURL = {
			
	GET_BIENES 									: "getBienes",
	GET_FAMILIAS 								: "getFamilias",
	GET_TIPOS_OPERACION 						: "getTiposOperacion",
	GET_SERVER_TIME 							: "getServerTime",
	GET_AGRUPADORES_PRODUCTO_ZONAS_NIVELES 		: "getAgrupadoresProductoZonasNiveles",
	GET_CALENDARIO 								: "getCalendario",
	GET_ITEMS_ORDENAMIENTO_AVISO 				: "getItemsOrdenamientoAviso",
	GET_CONFIGURACIONES_ORDENAMIENTO_PANTALLA 	: "getConfiguracionesOrdenamientoPantalla",
	GET_CONFIGURACIONES_PROMOCION_PANTALLA 		: "getConfiguracionesPromocionPantalla",
	GET_PRODUCTO_COMERCIAL_DEFAULT 				: "getProductoComercialDefault",
	VALIDATE_PALABRAS_PROHIBIDAS 				: "validatePalabrasProhibidas",
	GET_TEMPLATES_DETALLADO 					: "getTemplatesDetallado",
	GET_CARACTERES_INVALIDOS 					: "getCaracteresInvalidos",
	JUSTIFICAR_AND_TASAR 						: "justificarAndTasar",
	JUSTIFICAR									: "justificar",
	TASAR										: "tasar",
	GET_IMAGENES 								: "getImagenes",
	GET_PAISES 									: "getPaises",
	GET_PROVINCIAS 								: "getProvincias",
	GET_LOCALIDADES 							: "getLocalidades",
	PAGAR_Y_GUARDAR_ORDEN_DE_PUBLICACION 		: "pagarYGuardarOrdenDePublicacion",
	GET_LIMITE_COTIZACION_EXEDIDO 				: "getLimiteCotizacionExedido",
	UPDATE_CAPTURADOR 							: "updateCapturador",
	ELIMINAR_PROMO_365 							: "eliminarPromo365",
	VALIDATE_PROMOCIONES_AND_TASAR 				: "validatePromocionesAndTasar",
	CHECK_INTENTOS_PROMOCION_365				: "checkIntentosPromocion365",
	VALIDATE_PROMOCION_365						: "validatePromocion365",
	GET_TARJETAS_PAGO 							: "getTarjetasPago",
	SET_MODEL 									: "setModel",
	REMOVE_MODEL 								: "removeModel",
	GET_MODEL 									: "getModel",
	GET_TEMPLATE_PRECARGA 						: "getTemplatePrecarga",
	GET_UUID 									: "getUUID",
	VALIDAR_PROMOCIONES							: "validatePromociones",
	GET_TRACK_CAMPANA							: "getTrackCampana",
	GET_PERMISO_ATRIBUTO 						: "getPermisoAtributo"
				
};

// DatosPersonalesURL --------------------------------

var DatosPersonalesServiceURL = {

	UPDATE_USUARIO : "updateUsuario"	
		
};

// DecoratorServiceURL -------------------------------

var DecoratorServiceURL = {

	LOGOUT 			: "logout",
	REMOVE_MODEL 	: "removeModel"
		
};

// LoginServiceURL -------------------------------

var LoginServiceURL = {

	LOGIN_USUARIO 				: "loginUsuario",
	SAVE_CAPTURADOR 			: "saveCapturador",
	UPDATE_USUARIO_PASE			: "updateUsuarioPase",
	VALIDATE_CAPTCHA 			: "validateCaptcha",
	RECUPERAR_PASSWORD_USUARIO 	: "recuperarPasswordUsuario"

};

// LogoutServiceURL -------------------------------

var LogoutServiceURL = {

	LOGOUT : "logout"	
		
};

// MisAvisosServiceURL ------------------------------

var MisAvisosServiceURL = {

	EXECUTE_PAGAR_AND_ACTUALIZAR 				: "executePagarAndActualizar",
	GET_TARJETAS_PAGO 							: "getTarjetasPago",
	GET_ORDENES_PUBLICACION_BY_CAPTURADOR 		: "getOrdenesPublicacionByCapturador",
	SUSPENDER_PUBLICACION_AVISO					: "suspenderPublicacionAviso",
	REANUDAR_PUBLICACION_AVISO					: "reanudarPublicacionAviso",
	GET_SESSION_STATUS							: "getSessionStatus",
	REPUBLICAR_AVISO							: "republicarAviso",
	EDITAR_ORDEN_DE_PUBLICACION					: "editarOrdenDePublicacion",
	GET_FAMILIAS_BY_FILTER						: "getFamiliasByFilter",
	GET_CONFIGURACIONES_ORDENAMIENTO_PANTALLA 	: "getConfiguracionesOrdenamientoPantalla"
		
};

// RegistrarmeServiceURL -----------------------------

var RegistrarmeServiceURL = {
	
	VALIDATE_CAPTCHA 	: "validateCaptcha",
	SAVE_USUARIO 		: "saveUsuario"	
		
};

//URLConstants ----------------------

var URLConstants = {
		
	ROL_LOGIN 						: "/rol/login/login",
	ROL_LOGIN_AUTH0					: "/rol/login/loginAuth0",
	ROL_CREAR_AVISO					: "/rol/crearaviso/crear-aviso",
	ROL_MIS_AVISOS					: "/rol/misavisos/mis-avisos",
	ROL_DATOS_PERSONALES 			: "/rol/datospersonales/datospersonales",
	ROL_REGISTRARME					: "/rol/registrarme/registrarme",
	ROL_ERROR						: "/rol/error/error",
	ROL_ERROR_ACTUALIZA_NAVEGADOR 	: "/rol/error/actualiza-navegador",
	ROL_TERMINOS				 	: "/rol/terminos/terminos",
	ROL_PREGUNTAS_FRECUENTES		: "/rol/preguntas/preguntas"
		
};

var GetURLParameters = function(sParam){
		var sPageURL = window.location.search.substring(1);
		var sURLVariables = sPageURL.split('&');
	    for (var i = 0; i < sURLVariables.length; i++) 
	    {
	        var sParameterName = sURLVariables[i].split('=');
	        if (sParameterName[0] == sParam) 
	        {
	            return sParameterName[1];
	        }
	    }
};

var validRedirect = function (url){	
	return (url == URLConstants.ROL_LOGIN || url == URLConstants.ROL_CREAR_AVISO ||
	 url == URLConstants.ROL_MIS_AVISOS || url == URLConstants.ROL_DATOS_PERSONALES  ||
	 url == URLConstants.ROL_REGISTRARME);	
};

var redirect = function (url){
	window.location.assign(url);
};

var redirectMain = function (param){
	window.location.assign(URLConstants.ROL_CREAR_AVISO + '?uuid=' + param);
};

