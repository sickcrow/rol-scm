
/**
 * author: adifiore
 * version: 1.0.0
 * description: DTO's - Data Transfer Objects.
 * Importante:  Si existe una dependencia entre Objetos a->b ('a' contiene 'b')
 * 				'a' debe declararse primero y luego 'b'.
 */

/****************
 * UI - OBJECTS *
 ****************/

// AgrupadorAvisoProductoZonasNivelesDTO (UI-OBJECT) --------------------------

var AgrupadorAvisoProductoZonasNivelDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var productoComercial		= args.productoComercial ? new ProductoComercialDTO(args.productoComercial) : null;
		var nivelEstructura			= args.nivelEstructura ? new NivelEstructuraDTO(args.nivelEstructura) : null;
		var zonasComercializacion	= args.zonasComercializacion ? arrayUtils.buildArrayObjFromJSON(args.zonasComercializacion, ZonaComercializacionDTO) : [];

		// public interface --------------------------------

		return {

			productoComercial		: productoComercial,
			nivelEstructura			: nivelEstructura,
			zonasComercializacion	: zonasComercializacion

		};

	};

})();

// AgrupadorItemsOrdenamientoDTO (UI-OBJECT) --------------------------

var AgrupadorItemsOrdenamientoDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var indice				= args.indice || "";
		var itemsOrdenamiento	= args.itemsOrdenamiento ? arrayUtils.buildArrayObjFromJSON(args.itemsOrdenamiento, ItemOrdenamientoDTO) : [];

		// public interface --------------------------------

		return {

			indice				: indice,
			itemsOrdenamiento	: itemsOrdenamiento

		};

	};

})();

// DataProviderSelectItemsOrdenamientoDTO (UI-OBJECT) --------------------------

var DataProviderSelectItemsOrdenamientoDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var ordenamiento		= args.ordenamiento || null;
		var itemsOrdenamiento	= args.itemsOrdenamiento ? arrayUtils.buildArrayObjFromJSON(args.itemsOrdenamiento, ItemOrdenamientoDTO) : []; // ItemOrdenamientoDTO

		// public interface --------------------------------

		return {

			ordenamiento		: ordenamiento,
			itemsOrdenamiento	: itemsOrdenamiento

		};

	};

})();

//GeneratedDataStep1 (UI-OBJECT) --------------------------

var GeneratedDataStep1 = (function () {

	return function(args){

		// private interface -------------------------------

		var codigoFamilia		= args.codigoFamilia || null;
		var codigoClase			= args.codigoClase || null;
		var codigoTipoOperacion = args.codigoTipoOperacion || null;


		// public interface --------------------------------

		return {

			codigoFamilia		: codigoFamilia,
			codigoClase			: codigoClase,
			codigoTipoOperacion : codigoTipoOperacion

		};

	};

})();

//GeneratedDataStep2 (UI-OBJECT) --------------------------

var GeneratedDataStep2 = (function () {

	return function(args){

		// private interface -------------------------------

		var agrupadoresAvisoProductoZonasNivel = args.agrupadoresAvisoProductoZonasNivel ? arrayUtils.buildArrayObjFromJSON(args.agrupadoresAvisoProductoZonasNivel, AgrupadorAvisoProductoZonasNivelDTO) : [];

		// public interface --------------------------------

		return {

			agrupadoresAvisoProductoZonasNivel : agrupadoresAvisoProductoZonasNivel

		};

	};

})();

//GeneratedDataStep3 (UI-OBJECT) --------------------------

var GeneratedDataStep3 = (function () {

	return function(args){

		// private interface -------------------------------

		var fechasDePublicacion = args.fechasDePublicacion ? arrayUtils.buildArrayObjFromJSON(args.fechasDePublicacion, Date) : [];

		// public interface --------------------------------

		return {

			fechasDePublicacion : fechasDePublicacion

		};

	};

})();

// GeneratedDataStep4 (UI-OBJECT) --------------------------

var GeneratedDataStep4 = (function () {

	return function(args){

		// private interface -------------------------------

		var ordenamientos = args.ordenamientos ? arrayUtils.buildArrayObjFromJSON(args.ordenamientos, OrdenamientoAvisoValorizadoDTO) : [];

		// public interface --------------------------------

		return {

			ordenamientos : ordenamientos

		};

	};

})();

//GeneratedDataStep5 (UI-OBJECT) --------------------------

var GeneratedDataStep5 = (function () {

	return function(args){

		// private interface -------------------------------

		var textoLibre		= args.textoLibre || null;
		var ordenamientos	= args.ordenamientos ? arrayUtils.buildArrayObjFromJSON(args.ordenamientos, OrdenamientoAvisoValorizadoDTO) : [];

		// public interface --------------------------------

		return {

			textoLibre	  : textoLibre,
			ordenamientos : ordenamientos

		};

	};

})();

//GeneratedDataStep6 (UI-OBJECT) --------------------------

var GeneratedDataStep6 = (function () {

	return function(args){

		// private interface -------------------------------

		var codigoImagenDestaque 	= args.codigoImagenDestaque || null;
		var repoImagenDestaque 		= args.repoImagenDestaque || null;
		var codigoProductoComercial = args.codigoProductoComercial || null;
		var codigoTemplateDetallado = args.codigoTemplateDetallado || null;

		// public interface --------------------------------

		return {

			codigoImagenDestaque 	: codigoImagenDestaque,
			repoImagenDestaque 		: repoImagenDestaque,
			codigoProductoComercial : codigoProductoComercial,
			codigoTemplateDetallado : codigoTemplateDetallado

		};

	};

})();

// FamiliaDTO --------------------------

var FamiliaDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var codigo			= args.codigo || null;
		var descripcion		= args.descripcion || null;

		// public interface --------------------------------

		return {
			codigo	  : codigo,
			descripcion : descripcion
		};

	};

})();

/*************************
 * DTO - MODEL - OBJECTS *
 *************************/

//CodeErrorsConstants

var CodeErrorsConstants = {

	CODE_000000						: "CODE_000000",
	CODE_000001						: "CODE_000001",
	CODE_000006						: "CODE_000006",
	CODE_000010						: "CODE_000010",
	CODE_000012						: "CODE_000012"

};

//AtributosCapturadorConstants

var ROLErrorTypeConstants = {

	SECURITY						: "SECURITY",
	VALIDATION						: "VALIDATION",
	REDIRECTION						: "REDIRECTION",
	EXCEPTION						: "EXCEPTION"

};

//AtributosCapturadorConstants

var EstadoUsuarioPASEConstants = {

	ACTIVO							: "ACTIVO",
	CREADO							: "CREADO",
	CANCELADO						: "CANCELADO"

};

// ValidateAnuncianteDTO

var ValidateAnuncianteDTO = (function() {

	return function(args){

		//private interface --------------------------------

		var usuarioPASE						= args.usuarioPASE || "";

		//public interface ---------------------------------

		return {

			usuarioPASE						: usuarioPASE

		};

	};

})();

// ServicioPASEConstants

var ServicioPASEConstants = {

	SERVICE_SUCCESS					: "SUCCESS",
	SERVICE_FAILED					: "ERROR",
	TIPO_ERROR_NEGOCIO				: "NEGOCIO",
	TIPO_ERROR_VALIDACION			: "VALIDACION"

};

// AtributosRegistracionPASE

var AtributosRegistracionPASE = {

	PALABRA_CLAVE					: "palabraClave",
	FECHA_NACIMIENTO				: "fechaNacimiento",
	CONTRASENIA						: "CONTRASENIA",
	EMAIL							: "EMAIL"

};

// ErrorPASEDTO

var ErrorPASEDTO = (function () {

	return function(args){

		//private interface --------------------------------

		var atributo							= args.atributo || "";
		var mensaje								= args.mensaje || "";

		//public interface ---------------------------------

		return {

			atributo							: atributo,
			mensaje								: mensaje

		};

	};

})();

// UsuarioPASEDTO

var UsuarioPASEDTO = (function () {

	return function(args){


		//private interface --------------------------------

		var uid									= args.usuarioExternoCodigo;
		var apellido							= args.apellido || "";
		var nombre								= args.nombre || "";
		var email								= args.email || "";
		var fechaNacimiento						= args.fechaNacimiento || new Date();
		var genero								= args.genero || "";
		var palabraClave						= args.palabraClave || "";
		// public interface --------------------------------

		return {

			uid									: uid,
			apellido							: apellido,
			nombre								: nombre,
			email								: email,
			fechaNacimiento						: fechaNacimiento,
			genero								: genero,
			palabraClave						: palabraClave

		};

	};

})();

//UsuarioDTO

var UsuarioDTO = (function () {

	return function(args){

		//private interface --------------------------------

		var uid									= args.usuarioExternoCodigo || "";
		var apellido							= args.apellido || "";
		var nombre								= args.nombre || "";
		var genero								= args.genero || "";
		var fechaNacimiento						= args.fechaNacimiento || new Date();
		var codigoTipoDocumento					= args.codigoTipoDocumento || "";
		var numeroDocumento						= $.isNumeric(args.numeroDocumento) ? args.numeroDocumento : -1;
		var email								= args.email || "";
		var palabraClave						= args.palabraClave || "";
		var palabraClaveNueva					= args.palabraClaveNueva || "";
		var codigoCliente						= args.codigoCliente || "";
		var codigoAnunciante					= args.codigoAnunciante || "";
		var codigoTipoAnunciante				= args.codigoTipoAnunciante || "";
		var codigoCanalEntrada					= args.codigoCanalEntrada || "";
		var codigoTipoIVA						= args.codigoTipoIVA || "";
		var codigoMedioPagoPrincipal			= args.codigoMedioPagoPrincipal || "";
		var codigoPerfilAnunciante				= args.codigoPerfilAnunciante || "";
		var captcha								= args.captcha || new CaptchaDTO({});

		// public interface --------------------------------

		return {

			uid									: uid,
			apellido							: apellido,
			nombre								: nombre,
			genero								: genero,
			fechaNacimiento						: fechaNacimiento,
			codigoTipoDocumento					: codigoTipoDocumento,
			numeroDocumento						: numeroDocumento,
			email								: email,
			palabraClave						: palabraClave,
			palabraClaveNueva					: palabraClaveNueva,
			codigoCliente						: codigoCliente,
			codigoAnunciante					: codigoAnunciante,
			codigoTipoAnunciante				: codigoTipoAnunciante,
			codigoCanalEntrada					: codigoCanalEntrada,
			codigoTipoIVA						: codigoTipoIVA,
			codigoMedioPagoPrincipal			: codigoMedioPagoPrincipal,
			codigoPerfilAnunciante				: codigoPerfilAnunciante,
			captcha								: captcha

		};
	};

})();

// AtributosCapturadorConstants

var AtributosCapturadorConstants = {

	CODIGO_TIPO_ANUNCIANTE			: "PARTICULAR",
	CODIGO_CLIENTE					: "ROL",
	CODIGO_MEDIO_PAGO_PRINCIPAL		: "TARJETA",
	CODIGO_TIPO_IVA					: "CONSUMIDOR_FINAL",
	CODIGO_CANAL_ENTRADA			: "ROL",
	CODIGO_TIPO_DOCUMENTO			: "96",
	CODIGO_PERFIL_ANUNCIANTE_ROL	: "Otro"

};

// CapturadorCRUDDTO ---------------------------------------

var CapturadorCRUDDTO = (function () {

	return function(args){

		//private interface --------------------------------

		var codigoAnunciante					= args.codigoAnunciante || null;
		var descripcionAnunciante				= args.descripcionAnunciante || null;
		var codigoTipoAnunciante				= args.codigoTipoAnunciante || "";
		var codigoCliente						= args.codigoCliente || "";
		var codigoClase							= args.codigoClase || null;
		var email								= args.email || "";
		var nombre								= args.nombre || "";
		var apellido							= args.apellido || "";
		var codigoMedioPagoPrincipal			= args.codigoMedioPagoPrincipal || "";
		var codigoTipoIVA						= args.codigoTipoIVA || "";
		var codigoCanalEntrada					= args.codigoCanalEntrada || "";
		var codigoTipoDocumento					= args.codigoTipoDocumento || "";
		var numeroDocumento						= args.numeroDocumento || "";
		var usuarioExternoCodigo				= args.usuarioExternoCodigo;
		var codigoPerfilAnunciante				= args.codigoPerfilAnunciante||"Otro";
		var domicilio							= args.domicilio || null;
		var sexo								= args.sexo || null;
		var fechaNacimiento						= args.fechaNacimiento || null;

		// public interface --------------------------------

		return {

			codigoAnunciante					: codigoAnunciante,
			descripcionAnunciante				: descripcionAnunciante,
			codigoTipoAnunciante				: codigoTipoAnunciante,
			codigoCliente						: codigoCliente,
			codigoClase							: codigoClase,
			email								: email,
			nombre								: nombre,
			apellido							: apellido,
			codigoMedioPagoPrincipal			: codigoMedioPagoPrincipal,
			codigoTipoIVA						: codigoTipoIVA,
			codigoCanalEntrada					: codigoCanalEntrada,
			codigoTipoDocumento					: codigoTipoDocumento,
			numeroDocumento						: numeroDocumento,
			usuarioExternoCodigo				: usuarioExternoCodigo,
			codigoPerfilAnunciante				: codigoPerfilAnunciante,
			domicilio							: domicilio,
			sexo								: sexo,
			fechaNacimiento						: fechaNacimiento

		};

	};

})();

// AgrupadorProductoZonasNivelesSearchDTO --------------------------

var AgrupadorProductoZonasNivelesSearchDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var codigoCanalEntrada					= args.codigoCanalEntrada || "";
		var codigoClase							= args.codigoClase || "";
		var codigoTipoOperacion					= args.codigoTipoOperacion || "";
		var codigoAgrupamientoProductoTecnico	= args.codigoAgrupamientoProductoTecnico || "";
		var fechaVigencia						= args.fechaVigencia || new Date();

		// public interface --------------------------------

		return {

			codigoCanalEntrada					: codigoCanalEntrada,
			codigoClase							: codigoClase,
			codigoTipoOperacion					: codigoTipoOperacion,
			codigoAgrupamientoProductoTecnico   : codigoAgrupamientoProductoTecnico,
			fechaVigencia						: fechaVigencia

		};

	};

})();

//AgrupadorProductoComercialNivelDTO --------------------------

var AgrupadorProductoComercialNivelDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var productoComercial	= args.productoComercial ? new ProductoComercialDTO(args.productoComercial) : null;
		var nivelEstructura		= args.nivelEstructura ? new NivelEstructuraDTO(args.nivelEstructura) : null;

		// public interface --------------------------------

		return {

			productoComercial : productoComercial,
			nivelEstructura   : nivelEstructura

		};

	};

})();

//AgrupadorProductoZonasNivelesDTO --------------------------

var AgrupadorProductoZonasNivelesDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var producto							= args.producto ? new ProductoDTO(args.producto) : null;
		var zonasComercializacion				= args.zonasComercializacion ? arrayUtils.buildArrayObjFromJSON(args.zonasComercializacion, ZonaComercializacionDTO) : [];
		var agrupadoresProductoComercialNivel	= args.agrupadoresProductoComercialNivel ? arrayUtils.buildArrayObjFromJSON(args.agrupadoresProductoComercialNivel, AgrupadorProductoComercialNivelDTO) : [];

		// public interface --------------------------------

		return {

			producto							: producto,
			zonasComercializacion				: zonasComercializacion,
			agrupadoresProductoComercialNivel	: agrupadoresProductoComercialNivel

		};

	};

})();

//ClaseDTO -------------------------------------------------

var ClaseDTO = (function () {

	return function(args){

		//private interface -----

		var codigo								= args.codigo || "";
		var descripcion							= args.descripcion || "";

		//public interface -----

		return {

			codigo								: codigo,
			descripcion							: descripcion

		};

	};

})();

//ClaseSearchDTO -------------------------------------------

var ClaseSearchDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var codigoClase							= args.codigoClase || "";
		var codigoCanalEntrada					= args.codigoCanalEntrada || "";
		var fechaVigencia						= args.fechaVigencia || "";

		// public interface --------------------------------

		return {

			codigoClase							: codigoClase,
			codigoCanalEntrada					: codigoCanalEntrada,
			fechaVigencia						: fechaVigencia

		};

	};

})();

//TipoOperacionSearchDTO -----------------------------------

var TipoOperacionSearchDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var codigoCanalEntrada					= args.codigoCanalEntrada || "";
		var codigoClase							= args.codigoClase || "";
		var fechaVigencia						= args.fechaVigencia || new Date();

		// public interface --------------------------------

		return {

			codigoCanalEntrada					: codigoCanalEntrada,
			codigoClase							: codigoClase,
			fechaVigencia						: fechaVigencia

		};

	};

})();

// ItemOrdenamientoAvisoSearchDTO --------------------------

var ItemOrdenamientoAvisoSearchDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var codigoNivelEstructura				= args.codigoNivelEstructura || "";
		var codigoOrdenamientoAvisoPadre		= args.codigoOrdenamientoAvisoPadre || "";
		var codigoItemOrdenamientoAvisoPadre	= args.codigoItemOrdenamientoAvisoPadre || "";
		var codigoOrdenamientoAviso				= args.codigoOrdenamientoAviso || "";

		// public interface --------------------------------

		return {

			codigoNivelEstructura				: codigoNivelEstructura,
			codigoOrdenamientoAvisoPadre		: codigoOrdenamientoAvisoPadre,
			codigoItemOrdenamientoAvisoPadre	: codigoItemOrdenamientoAvisoPadre,
			codigoOrdenamientoAviso				: codigoOrdenamientoAviso

		};

	};

})();

// OrdenamientoAvisoSearchDTO --------------------------

var OrdenamientoAvisoSearchDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var codigoCanalEntrada					= args.codigoCanalEntrada || "";
		var codigoNivelEstructura				= args.codigoNivelEstructura || "";
		var codigoAgrupamientoProductoTecnico	= args.codigoAgrupamientoProductoTecnico || "";
		var codigoTipoOperacion					= args.codigoTipoOperacion || "";
		var fechaVigencia						= args.fechaVigencia || new Date();
		var codigoIndividuo						= args.codigoIndividuo || "";
		var codigoClase							= args.codigoClase || "";



		// public interface --------------------------------

		return {

			codigoCanalEntrada					: codigoCanalEntrada,
			codigoNivelEstructura				: codigoNivelEstructura,
			codigoAgrupamientoProductoTecnico	: codigoAgrupamientoProductoTecnico,
			codigoTipoOperacion					: codigoTipoOperacion,
			fechaVigencia						: fechaVigencia,
			codigoIndividuo						: codigoIndividuo,
			codigoClase							: codigoClase

		};

	};

})();

//ImagenTipoConstants -------------------

var ImagenTipoConstants = {

	IMAGEN	: "IMAGEN",
	PDF		: "PDF"

};

// OrdenamientoAvisoTipoDatoConstants -------------------

var OrdenamientoAvisoTipoDatoConstants = {

	LISTA	: "LISTA",
	TEXTO	: "TEXTO"

};


// OrdenamientoAvisoDTO --------------------------

var OrdenamientoAvisoDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var id					= $.isNumeric(args.id) ? args.id : -1;
		var codigo				= args.codigo || "";
		var tipoDato			= args.tipoDato || "";
		var obligatorio			= args.obligatorio || false;
		var orden				= $.isNumeric(args.orden) ? args.orden : -1;
		var formato				= args.formato || "";
		var muestraDefault		= args.muestraDefault || false;
		var ocultarValorUnico	= args.ocultarValorUnico || false;
		var validacion			= args.validacion || "";
		var descValidacion		= args.descValidacion || "";
		var idPadre				= $.isNumeric(args.idPadre) ? args.idPadre : -1;
		var idSubrubro			= $.isNumeric(args.idSubrubro) ? args.idSubrubro : -1;
		var descAyuda			= args.descAyuda || "";

		// public interface --------------------------------

		return {

			id					: id,
			codigo				: codigo,
			tipoDato			: tipoDato,
			obligatorio			: obligatorio,
			orden				: orden,
			formato				: formato,
			muestraDefault		: muestraDefault,
			ocultarValorUnico	: ocultarValorUnico,
			validacion			: validacion,
			descValidacion		: descValidacion,
			idPadre				: idPadre,
			idSubrubro			: idSubrubro,
			descAyuda			: descAyuda

		};

	};

})();

 // ConfiguracionOrdenamientoPantallaDTO --------------------------

var ConfiguracionOrdenamientoPantallaDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var id					= $.isNumeric(args.id) ? args.id : -1;
		var posicion			= $.isNumeric(args.posicion) ? args.posicion : -1;
		var codigoCanalEntrada	= args.codigoCanalEntrada || "";
		var ordenamientosAviso	= args.ordenamientosAviso ? arrayUtils.buildArrayObjFromJSON(args.ordenamientosAviso, OrdenamientoAvisoDTO) : []; // OrdenamientoAvisoDTO

		// public interface --------------------------------

		return {

			id					: id,
			posicion			: posicion,
			codigoCanalEntrada	: codigoCanalEntrada,
			ordenamientosAviso	: ordenamientosAviso

		};

	};

})();

// ItemOrdenamientoDTO --------------------------

var ItemOrdenamientoDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var id					= $.isNumeric(args.id) ? args.id : -1;
	    var idPadre				= $.isNumeric(args.idPadre) ? args.idPadre : -1;
	    var idOrdenamientoAviso	= $.isNumeric(args.idOrdenamientoAviso) ? args.idOrdenamientoAviso : -1;
	    var valor				= args.valor || "";
	    var ingresoManual		= args.ingresoManual || false;
	    var codigo				= args.codigo || "";
	    var codigoBusqueda		= args.codigoBusqueda || "";
	    var descripcion			= args.descripcion || "";

	    // public interface --------------------------------

		return {

			id					: id,
		    idPadre				: idPadre,
		    idOrdenamientoAviso	: idOrdenamientoAviso,
		    valor				: valor,
		    ingresoManual		: ingresoManual,
		    codigo				: codigo,
		    codigoBusqueda		: codigoBusqueda,
		    descripcion			: descripcion

		};

	};

})();

// AgrupadorItemsOrdenamientoDTO (UI-OBJECT) --------------------------

var AgrupadorItemsOrdenamientoDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var indice				= args.indice || "";
		var itemsOrdenamiento	= args.itemsOrdenamiento ? arrayUtils.buildArrayObjFromJSON(args.itemsOrdenamiento, ItemOrdenamientoDTO) : []; // ItemOrdenamientoDTO

		// public interface --------------------------------

		return {

			indice				: indice,
			itemsOrdenamiento	: itemsOrdenamiento

		};

	};

})();

// ImagenTipoConstants -------------------

var ImagenTipoConstants = {

	IMAGEN	: "IMAGEN",
	PDF		: "PDF"

};

// ImagenDTO --------------------------

var ImagenDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var id					= $.isNumeric(args.id) ? args.id : -1;
		var tipo				= args.tipo || "";
		var codigo				= args.codigo || "";
		var contenido			= args.contenido || "";
		var pathImagen			= args.pathImagen || "";
		var pathThumbnail		= args.pathThumbnail || "";
		var altura				= $.isNumeric(args.altura) ? args.altura : -1;
		var ancho				= $.isNumeric(args.ancho) ? args.ancho : -1;
		var tamanio				= $.isNumeric(args.tamanio) ? args.tamanio : -1;
		var repo				= args.repo || "";
		var extension			= args.extension || "";

		// public interface --------------------------------

		return {

			id					: id,
			tipo				: tipo,
			codigo				: codigo,
			contenido			: contenido,
			pathImagen			: pathImagen,
			pathThumbnail		: pathThumbnail,
			altura				: altura,
			ancho				: ancho,
			tamanio				: tamanio,
			repo				: repo,
			extension			: extension

		};

	};

})();

// ZonaComercializacionDTO --------------------------

var ZonaComercializacionDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var codigo		= args.codigo || "";
    	var descripcion	= args.descripcion || "";

    	// public interface --------------------------------

    	return {

    		codigo		: codigo,
    		descripcion : descripcion

    	}

    }

})();

// OrdenamientoAvisoValorizadoDTO --------------------------

var OrdenamientoAvisoValorizadoDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var codigo 			= args.codigo || "";
    	var valor 			= args.valor || "";
    	var codigoBusqueda 	= args.codigoBusqueda || "";
    	var valoresPosibles = args.valoresPosibles||new Array();
    	var descripcion		= args.descripcion || "";

    	// public interface --------------------------------

    	return {

    		codigo 			: codigo,
    		valor  			: valor,
    		codigoBusqueda 	: codigoBusqueda,
    		valoresPosibles : valoresPosibles,
    		descripcion		: descripcion
    	}

    }

})();

// JustificacionDTO ------------------------------

var JustificacionDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var codigoProducto 			= args.codigoProducto || "";
    	var codigoProductoComercial = args.codigoProductoComercial || "";
    	var codigoNivelEstructura 	= args.codigoNivelEstructura || "";
    	var codigoTemplateDetallado = args.codigoTemplateDetallado || "";
    	var ordenamientos 			= args.ordenamientos ? arrayUtils.buildArrayObjFromJSON(args.ordenamientos, OrdenamientoAvisoValorizadoDTO) : new Array(); // OrdenamientoAvisoValorizadoDTO
    	var imagen 					= args.imagen || "";
    	var cantidadLineas 			= $.isNumeric(args.cantidadLineas) ? args.cantidadLineas : -1;
    	var textoJustificado 		= args.textoJustificado || "";
    	var alturaEstandar 			= $.isNumeric(args.alturaEstandar) ? args.alturaEstandar : -1;
    	var puntosLibres 			= $.isNumeric(args.puntosLibres) ? args.puntosLibres : -1;
    	var textoLibre 				= args.textoLibre || "";
    	var textoLibreJustificado	= args.textoLibreJustificado || "";
		var material				= args.material ? new ImagenDTO(args.material) : null;

    	// public interface --------------------------------

    	return {

    		codigoProducto 			: codigoProducto,
        	codigoProductoComercial : codigoProductoComercial,
        	codigoNivelEstructura 	: codigoNivelEstructura,
        	codigoTemplateDetallado : codigoTemplateDetallado,
        	ordenamientos 			: ordenamientos,
        	imagen 					: imagen,
        	cantidadLineas 			: cantidadLineas,
        	textoJustificado 		: textoJustificado,
        	alturaEstandar 			: alturaEstandar,
        	puntosLibres 			: puntosLibres,
        	textoLibre 				: textoLibre,
        	textoLibreJustificado	: textoLibreJustificado,
			material				: material

    	}

    }

})();

// ProductoComercialDefaultDTO ------------------------------

var ProductoComercialDefaultDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var codigoAgrupamientoProductoTecnico 	= args.codigoAgrupamientoProductoTecnico || "";
    	var codigoCanalEntrada 					= args.codigoCanalEntrada || "";
    	var codigoTipoOperacion 				= args.codigoTipoOperacion || "";
    	var codigoNivelEstructura 				= args.codigoNivelEstructura || "";
    	var codigoProductoComercial 			= args.codigoProductoComercial || "";
    	var codigoTemplate 						= args.codigoTemplate || "";

    	// public interface -------------------------------

    	return {

    		codigoAgrupamientoProductoTecnico 	: codigoAgrupamientoProductoTecnico,
    		codigoCanalEntrada 					: codigoCanalEntrada,
    		codigoTipoOperacion 				: codigoTipoOperacion,
    		codigoNivelEstructura 				: codigoNivelEstructura,
    		codigoProductoComercial 			: codigoProductoComercial,
    		codigoTemplate 						: codigoTemplate

    	}

    }

})();

// AccionSecuenciaDTO ------------------------------

var AccionSecuenciaDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var numero = $.isNumeric(args.numero) ? args.numero : -1;
    	var accion = args.accion || "";

    	// public interface -------------------------------

    	return {

    		numero : numero,
    		accion : accion

    	}

    }

})();

// AtributoAvisoCodigoConstants -------------------

var AtributoAvisoCodigoConstants = {

	CAMPO_WEB_PUBLICACION 			: "webPublicacion",
	CAMPO_DOMICILIO_PUBLICACION 	: "domicilioPublicacion",
	CAMPO_TELEFONO_PUBLICACION 		: "telefonoPublicacion",
	CAMPO_OBSERVACION 				: "observacion",
	CAMPO_TITULO_AVISO 				: "tituloAviso",
	CAMPO_MAIL 						: "mail",
	CAMPO_CANJE 					: "canje",
	CAMPO_PRECIO_PUBLICACION 		: "precioPublicacion",
	CAMPO_TIPO_COLOR 				: "tipoColor",
	CAMPO_CODIGO_ENRIQUECIMIENTO 	: "codigoEnriquecimiento",
	CAMPO_FORMA_MEDIO_PAGO 			: "formaMedioPago",
	CAMPO_AVISO_ABIERTO 			: "avisoAbierto",
	CAMPO_TIPO_MONEDA 				: "tipoMoneda"

};

// AtributoAvisoDTO ------------------------------

var AtributoAvisoDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var codigo 	= args.codigo 	|| "";
    	var valor 	= args.valor 	|| "";
    	var step 	= args.step 	|| -1; // Indica en que pantalla se cargo el ordenamiento.

    	// public interface -------------------------------

    	return {

    		codigo 	: codigo,
    		valor 	: valor,
    		step	: step

    	}

    }

})();


// AgrupadorAtributoAvisoDTO ------------------------

var AgrupadorAtributoAvisoDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var atributoAviso 	= args.atributoAviso ?	new AtributoAvisoDTO(args.atributoAviso) : null;
    	var step 			= args.step || -1; // Indica en que pantalla se cargo el ordenamiento.

    	// public interface -------------------------------

    	return {

    		atributoAviso 	: atributoAviso,
    		step 			: step

    	}

    }

})();

// CapturadorTipoConstants -------------------

var CapturadorTipoConstants = {

	TIPO_PAPEL : "PAPEL"

};

// CapturadorDTO ------------------------------

var CapturadorDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var tipo 				= args.tipo || "";
    	var codigoCliente 		= args.codigoCliente || "";
    	var codigoAnunciante 	= $.isNumeric(args.codigoAnunciante) ? args.codigoAnunciante : -1;
    	var usuarioExternoCodigo= args.usuarioExternoCodigo;
    	var nombre 	        	= args.nombre || "";
    	var apellido 	        = args.apellido || "";

    	// public interface -------------------------------

    	return {

    		tipo 				: tipo,
    		codigoCliente 		: codigoCliente,
    		codigoAnunciante 	: codigoAnunciante,
    		usuarioExternoCodigo: usuarioExternoCodigo,
    		nombre   	 		: nombre,
    		apellido	   	 	: apellido

    	}

    }

})();

// NivelEstructuraTipoConstants --------------------

var NivelEstructuraTipoConstants = {

	TIPO_PAPEL : "PAPEL"

};

// NivelEstructuraDTO ------------------------------

var NivelEstructuraDTO = (function () {

    return function(args){

    	// private interface ------------------------------

    	var tipo 		= args.tipo || "";
    	var codigo 		= args.codigo || "";
    	var descripcion = args.descripcion || "";

    	// public interface -------------------------------

    	return {

    		tipo 		: tipo,
    		codigo		: codigo,
    		descripcion : descripcion

    	}

    }

})();

//ProductoTipoConstants --------------------------------

var ProductoTipoConstants = {

	TIPO_PAPEL : "PAPEL"

};

// ProductoDTO -----------------------------------------

var ProductoDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var tipo 		= args.tipo || "";
    	var codigo 		= args.codigo || "";
    	var descripcion = args.descripcion || "";

    	// public interface -------------------------------

    	return {

    		tipo 		: tipo,
    		codigo		: codigo,
    		descripcion : descripcion

    	}

    }

})();

// ProductoComercialTipoConstants ----------------------

var ProductoComercialTipoConstants = {

	TIPO_PAPEL : "PAPEL"

};

// ProductoComercialDTO ------------------------------

var ProductoComercialDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var tipo 		= args.tipo || "";
    	var codigo 		= args.codigo || "";
    	var producto 	= args.producto ? new ProductoDTO(args.producto) : null;

    	// public interface -------------------------------

    	return {

    		tipo 		: tipo,
    		codigo		: codigo,
    		producto 	: producto

    	}

    }

})();

// PromocionDTO ------------------------------

var PromocionDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var codigo 					= args.codigo || "";
    	var descripcion				= args.descripcion || "";
    	var observacion				= args.observacion || "";
    	var gratuita				= args.gratuita || false;
    	var seleccion				= args.seleccion || false;
    	var repiteSalida			= args.repiteSalida || false;
    	var promocionesCompatibles	= args.promocionesCompatibles || new Array();

    	// public interface -------------------------------

    	return {

    		codigo					: codigo,
    		descripcion				: descripcion,
    		observacion				: observacion,
    		gratuita				: gratuita,
    		seleccion				: seleccion,
    		repiteSalida			: repiteSalida,
    		promocionesCompatibles	: promocionesCompatibles

    	}

    }

})();

// AtributoAvisoDTO ------------------------------

var extensionesMaterialDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var tipo 	= args || "";

    	// public interface -------------------------------

    	return {

    		tipo 	: tipo

    	}

    }

})();

// TemplateDetalladoDTO ------------------------------

var TemplateDetalladoDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var id							= args.id || null;
    	var codigo 						= args.codigo || "";
    	var descripcion					= args.descripcion || "";
    	var tieneImagenesPrediseniadas	= args.tieneImagenesPrediseniadas || false;
    	var tieneColor					= args.tieneColor || false;
    	var tieneMaterial				= args.tieneMaterial || false;
    	var ayuda						= args.ayuda || "";
    	var orden						= args.orden || null;
    	//var extensionesMaterial  		= args.extensionesMaterial ? arrayUtils.buildArrayObjFromJSON(args.extensionesMaterial, extensionesMaterialDTO) : new Array();
    	var extensionesMaterial  		= args.extensionesMaterial || new Array();
    	var pesoMaterial				= args.pesoMaterial || null;
    	var ancho						= args.ancho || null;
    	var alto						= args.alto || null;

    	// public interface -------------------------------

    	return {

    		id							: id,
    		codigo						: codigo,
    		descripcion 				: descripcion,
    		tieneImagenesPrediseniadas 	: tieneImagenesPrediseniadas,
    		tieneColor					: tieneColor,
    		tieneMaterial				: tieneMaterial,
        	ayuda						: ayuda,
    		orden						: orden,
    		extensionesMaterial  		: extensionesMaterial,
    		pesoMaterial				: pesoMaterial,
    		ancho						: ancho,
    		alto						: alto
    	}

    }

})();

//TemplateDetalladoSerchDTO ------------------------------

var TemplateDetalladoSearchDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var codigoNivelEstructura 		 		= args.codigoNivelEstructura || "";
    	var codigoCanalEntrada			 		= args.codigoCanalEntrada||"";
    	var codigoAgrupamientoProductoTecnico	= args.codigoAgrupamientoProductoTecnico || "";
    	var codigoTipoOperacion					= args.codigoTipoOperacion || "";
    	var fechaVigencia 				 		= args.fechaVigencia || new Date().getTime();
    	var promocionesAplicadas				= args.promocionesAplicadas || null;

    	// public interface -------------------------------

    	return {

    		codigoNivelEstructura				: codigoNivelEstructura,
    		codigoCanalEntrada					: codigoCanalEntrada,
    		codigoAgrupamientoProductoTecnico 	: codigoAgrupamientoProductoTecnico,
    		codigoTipoOperacion					: codigoTipoOperacion,
    		fechaVigencia						: fechaVigencia,
    		promocionesAplicadas				: promocionesAplicadas

    	}

    }

})();

// TipoDocumentoDTO ------------------------------

var TipoDocumentoDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var codigo 	= args.codigo || "";

    	// public interface -------------------------------

    	return {

    		codigo	: codigo

    	}

    }

})();

//DomicilioDTO ------------------------------

var DomicilioDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var tipoDomicilio = args.tipoDomicilio ? new TipoDomicilioDTO(args.tipoDomicilio) : null;
    	var calle		= args.calle	 || null;
    	var puerta		= args.puerta	 || null;
    	var piso		= args.piso		 || null;
    	var depto		= args.depto	 || null;
    	var codPostal	= args.codPostal || null;
    	var localidad 	= args.localidad || null;
    	var provincia 	= args.provincia || null;
    	var pais 		= args.pais		 || null;

    	// public interface -------------------------------

    	return {

    		tipoDomicilio	: tipoDomicilio,
    		calle			: calle,
    		puerta			: puerta,
    		piso			: piso,
    		depto			: depto,
    		codPostal		: codPostal,
    		localidad		: localidad,
    		provincia		: provincia,
    		pais			: pais
    	}

    }

})();

// TipoDomicilioDTO ------------------------------

var TipoDomicilioDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var codigo = args.codigo			|| null;
    	var descripcion = args.descripcion	|| null;

    	// public interface -------------------------------

    	return {

    		codigo			: codigo,
    		descripcion		: descripcion
    	}

    }

})();

// TipoIVADTO ------------------------------

var TipoIVADTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var codigo 	= args.codigo || "";

    	// public interface -------------------------------

    	return {

    		codigo	: codigo

    	}

    }

})();

// TipoMonedaDTO ------------------------------

var TipoMonedaDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var codigo 	= args.codigo || "";

    	// public interface -------------------------------

    	return {

    		codigo	: codigo

    	}

    }

})();

// TipoOperacionDTO ------------------------------

var TipoOperacionDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var id				= args.id || "";
    	var codigo 			= args.codigo || "";
    	var descripcion		= args.descripcion || "";

    	// public interface -------------------------------

    	return {

    		id				: id,
    		codigo			: codigo,
    		descripcion		: descripcion

    	}

    }

})();

// UsuarioExternoDTO ------------------------------

var UsuarioExternoDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var codigo 			= args.codigo || "";
    	var codigoSistema 	= args.codigo || "";

    	// public interface -------------------------------

    	return {

    		codigo			: codigo,
    		codigoSistema 	: codigoSistema

    	}

    }

})();

// CalendarioSearchDTO ------------------------------

var CalendarioSearchDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var nivelEstructura 		= args.nivelEstructura || "";
    	var fechaVigencia 			= args.fechaVigencia || new Date().getTime();
    	var controlarHorarioCierre 	= args.controlarHorarioCierre || false;
    	var zonasComercializacion 	= args.zonasComercializacion || new Array(); // String
    	var idItemPromocion 		= $.isNumeric(args.idItemPromocion) ? args.idItemPromocion : -1;
    	var codigoCanalEntrada      = args.codigoCanalEntrada || "";


    	// public interface -------------------------------

        return {

	        	nivelEstructura 		: nivelEstructura,
	    		fechaVigencia 			: fechaVigencia,
	    		controlarHorarioCierre 	: controlarHorarioCierre,
	    		zonasComercializacion 	: zonasComercializacion,
	    		idItemPromocion 		: idItemPromocion,
	    		codigoCanalEntrada		: codigoCanalEntrada

        }

    };

})();

// AvisoTipoConstants ----------------------

var AvisoTipoConstants = {

	TIPO_PAPEL : "PAPEL"

}

//AvisoDTO ------------------------------

var AvisoDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var id 						= $.isNumeric(args.id) ? args.id : null;
    	var tipo					= args.tipo || "";
    	var fechaPedidoPublicacion 	= args.fechaPedidoPublicacion || null;
    	var incompleto 				= args.incompleto || false;
    	var bloqueado 				= args.bloqueado || false;
    	var facturable 				= args.facturable || false;
    	var estado					= args.estado || "";
    	var textoLibre 				= args.textoLibre || "";
    	var textoLibreTemplate      = args.textoLibreTemplate || "";
    	var idNUP					= args.idNUP || null;
    	var acciones 				= args.acciones ? arrayUtils.buildArrayObjFromJSON(args.acciones, AccionSecuenciaDTO ) : new Array();
    	var tipoOperacion 			= args.tipoOperacion ? new TipoOperacionDTO(args.tipoOperacion) : null;
    	var productoComercial 		= args.productoComercial ? new ProductoComercialDTO(args.productoComercial) : null;
    	var avisoPromocion 			= args.avisoPromocion ? arrayUtils.buildArrayObjFromJSON(args.avisoPromocion, AvisoPromocionDTO) : new Array();
    	var templateDetallado 		= args.templateDetallado ? new TemplateDetalladoDTO(args.templateDetallado) : null;
    	//var materiales				= args.materiales || null;
    	var materiales				= args.materiales ? arrayUtils.buildArrayObjFromJSON(args.materiales, ImagenDTO) : new Array();
    	var codigoClase 			= args.codigoClase || "";
    	var atributosAviso 			= args.atributosAviso ? arrayUtils.buildArrayObjFromJSON(args.atributosAviso, AtributoAvisoDTO) : new Array();
    	var nivelEstructura 		= args.nivelEstructura ? new NivelEstructuraDTO(args.nivelEstructura) : null;
    	var codigoFamilia			= args.codigoFamilia || "";

    	// atributos PAPEL -------------------------------

    	var lineasPublicadas 		= $.isNumeric(args.lineasPublicadas) ? args.lineasPublicadas : -1;
    	var lineasFacturadas 		= $.isNumeric(args.lineasFacturadas) ? args.lineasFacturadas : -1;
    	var textoJustificado 		= args.textoJustificado || "";
    	var avisoRepublicado		= $.isNumeric(args.avisoRepublicado) ? args.avisoRepublicado : 0;
    	var textoLibreJustificado 	= args.textoLibreJustificado || "";
    	var zonasComercializacion	= args.zonasComercializacion ? arrayUtils.buildArrayObjFromJSON(args.zonasComercializacion, ZonaComercializacionDTO) : new Array();
    	var ordenamientos			= args.ordenamientos ?  arrayUtils.buildArrayObjFromJSON(args.ordenamientos, OrdenamientoAvisoValorizadoDTO) : new Array();
    	var altoPuntosTipograficos  = $.isNumeric(args.altoPuntosTipograficos) ? args.altoPuntosTipograficos : -1;
    	var preview					= args.preview ? new ImagenDTO(args.preview) : null;

    	// public interface -------------------------------

    	return {

    		id 						: id,
    		tipo					: tipo,
        	fechaPedidoPublicacion 	: fechaPedidoPublicacion,
        	incompleto 				: incompleto,
        	bloqueado 				: bloqueado,
        	facturable				: facturable,
        	estado					: estado,
        	textoLibre 				: textoLibre,
        	idNUP					: idNUP,
        	acciones 				: acciones,
        	tipoOperacion 			: tipoOperacion,
        	productoComercial 		: productoComercial,
        	avisoPromocion 			: avisoPromocion,
        	templateDetallado 		: templateDetallado,
        	materiales				: materiales,
        	codigoClase 			: codigoClase,
        	atributosAviso 			: atributosAviso,
        	nivelEstructura 		: nivelEstructura,
        	textoLibreTemplate      : textoLibreTemplate,
        	codigoFamilia			: codigoFamilia,

        	// atributos PAPEL -------------------------------

        	lineasPublicadas 		: lineasPublicadas,
    	    lineasFacturadas 		: lineasFacturadas,
    	    textoJustificado 		: textoJustificado,
    	    textoLibreJustificado 	: textoLibreJustificado,
    	    avisoRepublicado		: avisoRepublicado,
    	    zonasComercializacion	: zonasComercializacion,
    	    ordenamientos			: ordenamientos,
    	    altoPuntosTipograficos  : altoPuntosTipograficos,
    	    preview					: preview

    	}

    };

})();


//AvisoPromocionDTO -------------------------

var AvisoPromocionDTO = (function() {

return function(args){

    	// private interface -------------------------------

		var aviso		= args.aviso ? new AvisoDTO(args.aviso) : null;
		var promocion	= args.promocion ? new PromocionDTO(args.promocion) : null;
		var montoSinIva	= $.isNumeric(args.montoSinIva) ? args.montoSinIva : 0;
		var montoConIva	= $.isNumeric(args.montoConIva) ? args.montoConIva : 0;
		var porcentaje	= $.isNumeric(args.porcentaje) ? args.porcentaje : 0;
		var esDescuento = args.esDescuento;


    	// public interface -------------------------------

    	return {

    		aviso			: aviso,
    		promocion		: promocion,
    		montoSinIva		: montoSinIva,
    		montoConIva		: montoConIva,
    		porcentaje		: porcentaje,
    		esDescuento		: esDescuento

    	}

    };

})();

//ItemAvisoDTO ------------------------------

var ItemAvisoDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var id 		= $.isNumeric(args.id) ? args.id : null;
    	var numero 	= $.isNumeric(args.numero) ? args.numero : 0;
    	var aviso 	= args.aviso ? new AvisoDTO(args.aviso) : null;

    	// public interface -------------------------------

    	return {

    		id 		: id,
        	numero 	: numero,
        	aviso 	: aviso

    	}

    };

})();

//ItemConceptoVendibleDTO ------------------------------

var ItemConceptoVendibleDTO = (function () {

	return function(args){

		// private interface -------------------------------

		var id			= $.isNumeric(args.id) ? args.id :null;
		var numero 		= $.isNumeric(args.numero) ? args.numero : 0;
		var itemsAviso 	= args.itemsAviso ? arrayUtils.buildArrayObjFromJSON(args.itemsAviso, ItemAvisoDTO) : new Array(); // ItemAvisoDTO

		// public interface -------------------------------

		return {

			id			: id,
			numero 		: numero,
			itemsAviso 	: itemsAviso

		}

	 };

})();

//ConceptoVendibleAvisoDTO ------------------------------

var ConceptoVendibleAvisoDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var id 						= $.isNumeric(args.id) ? args.id : null;
    	var descripcion 			= args.descripcion || "";
    	var fechaTarifa 			= args.fechaTarifa || new Date().getTime();
    	var prefacturado 			= args.prefacturado || false;
    	var tipoMoneda 				= args.tipoMoneda ? new TipoMonedaDTO(args.tipoMoneda) : null;
    	var porcentajeIVA 			= $.isNumeric(args.porcentajeIVA) ? args.porcentajeIVA : -1;
    	var montoSinIVA 			= $.isNumeric(args.montoSinIVA) ? args.montoSinIVA : -1;
    	var montoSinIVASinPromo		= $.isNumeric(args.montoSinIVASinPromo) ? args.montoSinIVASinPromo : -1;
    	var montoIVA 				= $.isNumeric(args.montoIVA) ? args.montoIVA : -1;
    	var montoIVASinPromo		= $.isNumeric(args.montoIVASinPromo) ? args.montoIVASinPromo : -1;
    	var montoPercepcion 		= $.isNumeric(args.montoPercepcion) ? args.montoPercepcion : -1;
    	var montoPercepcionSinPromo	= $.isNumeric(args.montoPercepcionSinPromo) ? args.montoPercepcionSinPromo : -1;
    	var montoTotal 				= $.isNumeric(args.montoTotal) ? args.montoTotal : -1;
    	var montoTotalSinPromo		= $.isNumeric(args.montoTotalSinPromo) ? args.montoTotalSinPromo : -1;
    	var estado 					= args.estado || "";
    	var motivoEstado 			= args.motivoEstado || "";
    	var acciones 				= args.acciones ? arrayUtils.buildArrayObjFromJSON(args.acciones, AccionSecuenciaDTO) : new Array(); // AccionSecuenciaDTO
    	var accionesPosibles 		= args.accionesPosibles ? arrayUtils.buildArrayObjFromJSON(args.accionesPosibles, String) : new Array(); // String
    	var promocion 				= args.promocion ? new PromocionDTO(args.promocion) : null;
    	var itemsConceptoVendible 	= args.itemsConceptoVendible ? arrayUtils.buildArrayObjFromJSON(args.itemsConceptoVendible, ItemConceptoVendibleDTO) : new Array(); // ItemConceptoVendibleDTO
    	var moderado 				= args.moderado || false;

    	// public interface -------------------------------

        return {

        	id 						: id,
        	descripcion 			: descripcion,
        	fechaTarifa 			: fechaTarifa,
        	prefacturado 			: prefacturado,
        	tipoMoneda 				: tipoMoneda,
        	porcentajeIVA 			: porcentajeIVA,
        	montoSinIVA 			: montoSinIVA,
        	montoSinIVASinPromo		: montoSinIVASinPromo,
        	montoIVA 				: montoIVA,
        	montoIVASinPromo		: montoIVASinPromo,
        	montoPercepcion 		: montoPercepcion,
        	montoPercepcionSinPromo	: montoPercepcionSinPromo,
        	montoTotal 				: montoTotal,
        	montoTotalSinPromo		: montoTotalSinPromo,
        	estado 					: estado,
        	motivoEstado 			: motivoEstado,
        	acciones 				: acciones,
        	accionesPosibles 		: accionesPosibles,
        	promocion 				: promocion,
        	itemsConceptoVendible 	: itemsConceptoVendible,
        	moderado 				: moderado

        }

    };

})();

// OrdenDePublicacionCabeceraDTO ------------------------------

var OrdenDePublicacionCabeceraDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var id 						= $.isNumeric(args.id) ? args.id : null;
    	var uuidGenerarOrden 		= args.uuidGenerarOrden ||  Math.floor((Math.random()*10000000)+1);
    	var fechaAlta				= args.fechaAlta || new Date();
    	var fechaUltimaModificacion = args.fechaUltimaModificacion || new Date();
    	var presupuestada 			= args.presupuestada || false;
    	var incompleta 				= args.incompleta || false;
    	var leida 					= args.leida || false;
    	var procesada 				= args.procesada || false;
    	var externa 				= args.externa || false;
    	var tipoDocumento 			= args.tipoDocumento ? new TipoDocumentoDTO(args.tipoDocumento) : null;
    	var domicilio				= args.domicilio ? new DomicilioDTO(args.domicilio) :null;
    	var telefono				= args.telefono || "";
    	var email					= args.email || "";
    	var codigoMedioDePago 		= args.codigoMedioDePago || "";
    	var codigoTipoTarjeta 		= args.codigoTipoTarjeta || "";
    	var tipoIVA 				= args.tipoIVA ? new TipoIVADTO(args.tipoIVA) : null;
    	var conceptosVendibles 		= args.conceptosVendibles ? arrayUtils.buildArrayObjFromJSON(args.conceptosVendibles, ConceptoVendibleAvisoDTO) : new Array(); // ConceptoVendibleAvisoDTO
    	var capturador 				= args.capturador ? new CapturadorDTO(args.capturador) : null;
    	var usuarioExterno 			= args.usuarioExterno ? new UsuarioExternoDTO(args.usuarioExterno) : null;
    	var transaccionActual		= args.transaccionActual ? new GWPTransaccionDTO(args.transaccionActual) : null;
    	var transacciones			= args.transacciones ? arrayUtils.buildArrayObjFromJSON(args.transacciones, GWPTransaccionDTO) : new Array(); // GWPTransaccionDTO
    	var trackCampana			= args.trackCampana ? new TrackCampanaDTO(args.trackCampana) : null;
    	var step					= args.step||0;

    	// public interface -------------------------------

        return {

        	id 						: id,
	    	uuidGenerarOrden 		: uuidGenerarOrden,
	    	fechaAlta				: fechaAlta,
	    	fechaUltimaModificacion : fechaUltimaModificacion,
	    	presupuestada 			: presupuestada,
	    	incompleta 				: incompleta,
	    	leida 					: leida,
	    	procesada 				: procesada,
	    	externa 				: externa,
	    	tipoDocumento 			: tipoDocumento,
	    	domicilio				: domicilio,
	    	telefono				: telefono,
	    	email					: email,
	    	codigoMedioDePago 		: codigoMedioDePago,
	    	codigoTipoTarjeta		: codigoTipoTarjeta,
	    	tipoIVA 				: tipoIVA,
	    	conceptosVendibles 		: conceptosVendibles,
	    	capturador 				: capturador,
	    	usuarioExterno 			: usuarioExterno,
	    	transaccionActual		: transaccionActual,
	    	transacciones			: transacciones,
	    	trackCampana			: trackCampana,
	    	step					: step

        }

    };

})();

// TextoValidateDTO ------------------------------------

var TextoValidateDTO = (function () {

    return function(args){

    	// private interface -------------------------------
    	var codigoNivelEstructura 	= args.codigoNivelEstructura || "";
    	var texto					= args.texto || "";

    	// public interface --------------------------------

    	return {

        	codigoNivelEstructura 	: codigoNivelEstructura,
        	texto					: texto

    	}

    };

})();

// CaptchaDTO ------------------------------------

var CaptchaDTO = (function() {

	return function(args) {

		// private interface -------------------------------

		var hashValue 			= args.hashValue || "";
    	var inputValue			= args.inputValue || "";

    	// public interface --------------------------------

    	return {

    		hashValue 			: hashValue,
    		inputValue			: inputValue

    	}
	};

})();

// ModelSearchDTO ------------------------------------

var ModelSearchDTO = (function() {

	return function(args) {

		// private interface -------------------------------

		var uuid = args || "";

    	// public interface --------------------------------

		return {

			uuid : uuid

		}

	};

})();

//TemplatePrecargaSearchDTO ------------------------------------

var TemplatePrecargaSearchDTO = (function() {

	return function(args) {

		// private interface -------------------------------

		var codigo = args || "";

    	// public interface --------------------------------

		return {

			codigo : codigo

		}

	};

})();


//ProductoComercialTemplateDTO ------------------------------------

var ProductoComercialTemplateDTO = (function() {

	return function(args) {

		// private interface -------------------------------

		var templateDetallado = args.templateDetallado ? new TemplateDetalladoDTO(args.templateDetallado) : null;
		var codigoProductoComercial = args.codigoProductoComercial ||"";

    	// public interface --------------------------------

		return {

			templateDetallado 	: templateDetallado,
			codigoProductoComercial : codigoProductoComercial

		}

	};

})();

// ModelCrearAvisoDTO ------------------------------------

var ModelCrearAvisoDTO = (function() {

	return function(args) {

		// private interface -------------------------------

		var redirectURL							= args.redirectURL || "";
		var ordenPublicacion					= args.ordenPublicacion ? new OrdenDePublicacionCabeceraDTO(args.ordenPublicacion):null;
		var codigoCanalEntrada					= args.codigoCanalEntrada || "ROL";
		var codigoNivelEstructura				= args.codigoNivelEstructura||"";
		var codigoAgrupamientoProductoTecnico   = args.codigoAgrupamientoProductoTecnico;
		var tipoOperacion						= args.tipoOperacion?new TipoOperacionDTO(args.tipoOperacion):null;
		var codigoProducto						= args.codigoProducto;
		var codigoProductoComercial				= args.codigoProductoComercial;
		var codigoTemplateDetallado				= args.codigoTemplateDetallado || null;
		var familia								= args.familia;
		var clase								= args.clase;
		var zonasComercializacion 				= args.zonasComercializacion|| new Array();
		var ordenamientos						= args.ordenamientos || new Array();
		var mapItemsOrdenamientoCombo			= args.mapItemsOrdenamientoCombo || {};
		var selectedDates						= args.selectedDates;
		var step								= args.step;
		var palabrasProhibidas					= args.palabrasProhibidas || new Array();
		var configuracionOrdenamientoPantalla	= args.configuracionOrdenamientoPantalla ? arrayUtils.buildArrayObjFromJSON(args.configuracionOrdenamientoPantalla, ConfiguracionOrdenamientoPantallaDTO):[];
		var previsualizo						= args.previsualizo||false;
		var codigoGATEWAYSeleccionado			= args.codigoGATEWAYSeleccionado;
		var	templatesDetallado					= args.templatesDetallado ? arrayUtils.buildArrayObjFromJSON(args.templatesDetallado, ProductoComercialTemplateDTO):null;
		var ordenDepublicacionHistory			= args.ordenDepublicacionHistory ? new OrdenDePublicacionCabeceraDTO(args.ordenPublicacion):null;
		var codigoTemplateDestaqueSeleccionado 	= args.codigoTemplateDestaqueSeleccionado||null;
		var codigoImagenDestaqueSeleccionada	= args.codigoImagenDestaqueSeleccionada||null;
		var repoImagenDestaqueSeleccionada      = args.repoImagenDestaqueSeleccionada||null;
		var codigoProductoComercialDestaque     = args.codigoProductoComercialDestaque||null;
		var codigoNivelEstructuraDestaque		= args.codigoNivelEstructuraDestaque || null;
		var tienePictoSeleccionado				= args.tienePictoSeleccionado || null;
		var tieneFondoColor						= args.tieneFondoColor || null;
		var tieneMaterial						= args.tieneMaterial || null;
		var materiales							= args.materiales ? arrayUtils.buildArrayObjFromJSON(args.materiales, ImagenDTO) : new Array();
		var configuracionesPromocionPantalla	= args.configuracionesPromocionPantalla ? arrayUtils.buildArrayObjFromJSON(args.configuracionesPromocionPantalla,ConfiguracionPromocionPantallaDTO):new Array();
		var agrupadoresAtributoAviso			= args.agrupadoresAtributoAviso ? arrayUtils.buildArrayObjFromJSON(args.agrupadoresAtributoAviso, AgrupadorAtributoAvisoDTO) : new Array();
		var promociones							= args.promociones ? arrayUtils.buildArrayObjFromJSON(args.promociones, PromocionDTO) : new Array();

    	// public interface --------------------------------

		return {

			redirectURL							: redirectURL,
			ordenPublicacion					: ordenPublicacion,
    		codigoCanalEntrada					: codigoCanalEntrada,
    		codigoNivelEstructura				: codigoNivelEstructura,
    		codigoAgrupamientoProductoTecnico   : codigoAgrupamientoProductoTecnico,
    		tipoOperacion						: tipoOperacion,
    		codigoProducto						: codigoProducto,
    		codigoProductoComercial				: codigoProductoComercial,
    		codigoTemplateDetallado				: codigoTemplateDetallado,
    		familia								: familia,
    		clase								: clase,
    		zonasComercializacion 				: zonasComercializacion,
    		ordenamientos						: ordenamientos,
    		mapItemsOrdenamientoCombo			: mapItemsOrdenamientoCombo,
    		selectedDates						: selectedDates,
    		step								: step,
    		palabrasProhibidas					: palabrasProhibidas,
    		configuracionOrdenamientoPantalla   : configuracionOrdenamientoPantalla,
    		previsualizo						: previsualizo,
    		codigoGATEWAYSeleccionado			: codigoGATEWAYSeleccionado,
    		templatesDetallado					: templatesDetallado,
			ordenDepublicacionHistory			: ordenDepublicacionHistory,
			codigoTemplateDestaqueSeleccionado	: codigoTemplateDestaqueSeleccionado,
			codigoImagenDestaqueSeleccionada	: codigoImagenDestaqueSeleccionada,
			repoImagenDestaqueSeleccionada      : repoImagenDestaqueSeleccionada,
			codigoProductoComercialDestaque     : codigoProductoComercialDestaque,
			codigoNivelEstructuraDestaque		: codigoNivelEstructuraDestaque,
			tienePictoSeleccionado				: tienePictoSeleccionado,
			tieneFondoColor						: tieneFondoColor,
			tieneMaterial						: tieneMaterial,
			materiales							: materiales,
			configuracionesPromocionPantalla	: configuracionesPromocionPantalla,
			agrupadoresAtributoAviso			: agrupadoresAtributoAviso,
			promociones 						: promociones

		}

	};

})();


//TarjetaPagoSearchDTO ------------------------------------

var TarjetaPagoSearchDTO = (function() {

	return function(args) {

		// private interface -------------------------------

		var codigoCanalEntrada = args || "ROL";

 	// public interface --------------------------------

		return {

			codigoCanalEntrada : codigoCanalEntrada

		}

	};

})();


//TarjetaPagoDTO ------------------------------------

var TarjetaPagoDTO = (function() {

	return function(args) {

		// private interface -------------------------------

		var codigoGATEWAY 	= args || "";
		var descripcion 	= args || "";
		var rutaImagenTC	= args || "";

 	// public interface --------------------------------

		return {

			codigoGATEWAY 	: codigoGATEWAY,
			descripcion 	: descripcion,
			rutaImagenTC	: rutaImagenTC

		}

	};

})();


//LimiteCotizacionDTO ------------------------------------

var LimiteCotizacionDTO = (function() {

	return function(args) {

		// private interface -----------------------------

		var montoAviso 	= args || $.isNumeric(args) ? args : 0;

		// public interface --------------------------------

		return {

			montoAviso 	: montoAviso

		}

	};

})();

var PaisDTO = (function() {

	return function(args) {

		// private interface -----------------------------

		var id 			= args.id || $.isNumeric(args.id) ? args.id : -1;
 	    var codigo 		= args.codigo || "";

		// public interface --------------------------------

		return {

			id 			: id,
			codigo		: codigo

		}

	};

})();

var ProvinciaDTO = (function() {

	return function(args) {

		// private interface -----------------------------

		var id		 		= $.isNumeric(args.id) ? args.id : -1;
		var codigo	 		= args.codigo || "";
 	    var codigoPais 		= args.codigoPais || "";

		// public interface --------------------------------

		return {

			id				: id,
			codigo			: codigo,
			codigoPais		: codigoPais

		}

	};

})();

var LocalidadDTO = (function() {

	return function(args) {

		// private interface -----------------------------

		var id		 			= $.isNumeric(args.id) ? args.id : -1;
		var codigo	 			= args.codigo || "";
 	    var codigoPais 			= args.codigoPais || "";
 	    var codigoProvincia		= args.codigoProvincia || "";

		// public interface --------------------------------

		return {

			id					: id,
			codigo				: codigo,
			codigoPais			: codigoPais,
			codigoProvincia		: codigoProvincia

		}

	};

})();



var PromocionSearchDTO = (function() {

	return function(args) {

		// private interface -----------------------------

		var codigoCanalEntrada			= args.codigoCanalEntrada||"";
		var codigoProductoComercial		= args.codigoProductoComercial || "";
		var codigoNivelEstructura		= args.codigoNivelEstructura||"";
 	    var codigoZonasComercializacion	= args.codigoZonasComercializacion ||  new Array();
 	    var fechaVigencia				= args.fechaVigencia || "";

		// public interface --------------------------------

		return {

			codigoCanalEntrada			: codigoCanalEntrada,
			codigoProductoComercial		: codigoProductoComercial,
			codigoZonasComercializacion	: codigoZonasComercializacion,
			codigoNivelEstructura		: codigoNivelEstructura,
			fechaVigencia				: fechaVigencia

		}

	};

})();

var ConfiguracionPromocionPantallaDTO = (function() {

	return function(args) {

		// private interface -----------------------------

		var pantallaShow	= args.pantallaShow||$.isNumeric(args.pantallaShow) ? args.pantallaShow : null;
		var promocion		= args.promocion?new PromocionDTO(args.promocion):null ;
 	    var trigger			= args.trigger ||  "";
 	    var descripcion		= args.descripcion || "";
 	    var titulo          = args.titulo || "";


		// public interface --------------------------------

		return {

			pantallaShow	: pantallaShow,
			promocion		: promocion,
			trigger			: trigger,
			descripcion		: descripcion,
			titulo		    : titulo
		}
	};

})();

var ValidarPromocionesDTO = (function() {

	return function(args) {

		// private interface -----------------------------

		var captcha					= args.captcha ? new CaptchaDTO(args.captcha) : null ;
		var promocionesAplicables	= args.promocionesAplicables ? arrayUtils.buildArrayObjFromJSON(args.promocionesAplicables, PromocionDTO) : new Array();
		var ordenPublicacion		= args.ordenPublicacion ? new OrdenDePublicacionCabeceraDTO(args.ordenPublicacion) : null ;

		// public interface --------------------------------

		return {

			captcha					: captcha,
			promocionesAplicables	: promocionesAplicables,
			ordenPublicacion		: ordenPublicacion

		}

	};

})();



//ROLResult ------------------------------------

var ROLResult = (function() {

	return function(args) {

		// private interface -------------------------------

		var object 	= args || "";
		var errors 	= args || new array();


 	// public interface --------------------------------

		return {

			object 	: object,
			errors	: errors

		}

	};

})();

var GWPTransaccionDTO = (function() {

	return function(args) {

		// private interface ---------------------------

		var codigoAplicacionCliente 	= args.codigoAplicacionCliente || "";
		var codigoMetodoPago			= args.codigoMetodoPago || "";
		var codigoMedioPago				= args.codigoMedioPago || "";
		var monto						= $.isNumeric(args.monto) ? args.monto : -1;
		var nombreItem					= args.nombreItem || "";
		var idTransaccionCliente 		= args.idTransaccionCliente || "";
		var estado						= args.estado || "";
		var fechaTransaccion			= args.fechaTransaccion || "";
		var email						= args.email || "";
		var apellidos					= args.apellidos || "";
		var nombres						= args.nombres || "";

		// public interface ----------------------------

		return {

			codigoAplicacionCliente 	: codigoAplicacionCliente,
			codigoMetodoPago			: codigoMetodoPago,
			codigoMedioPago				: codigoMedioPago,
			monto						: monto,
			nombreItem					: nombreItem,
			idTransaccionCliente 		: idTransaccionCliente,
			estado						: estado,
			fechaTransaccion			: fechaTransaccion,
			email						: email,
			apellidos					: apellidos,
			nombres						: nombres

		}

	};

})();

//UpdateEstadoAvisoDTO ------------------------------------

var UpdateEstadoAvisoDTO = (function() {

	return function(args) {

		// private interface ---------------------------

		var idAviso						= args.idAviso || "";
		var accion						= args.accion || "";
		var motivoRechazo				= args.motivoRechazo || "";
		var observacion					= args.observacion || "";

		// public interface ----------------------------

		return {

			idAviso						: idAviso,
			accion						: accion,
			motivoRechazo				: motivoRechazo,
			observacion					: observacion

		}

	};

})();

//TrackCampanaDTO ------------------------------

var TrackCampanaDTO = (function () {

    return function(args){

    	// private interface -------------------------------

    	var fuente 		 				= args.fuente || "";
    	var medio		 				= args.medio || "";
    	var campana			 			= args.campana || "";

    	// public interface -------------------------------

    	return {

    		fuente 						: fuente,
    		medio						: medio,
    		campana						: campana

    	}

    }

})();

//FamiliasByFilterSearchDTO -------------------------------------

var FamiliasByFilterSearchDTO = (function () {

	return function(args){

		// private interface ---------------------------------------
		var codigosClase 		= args.codigosClase ? arrayUtils.buildArrayObjFromJSON(args.codigosClase, String):[];
		var codigoCanalEntrada 	= args.codigoCanalEntrada || "";
		// public interface ---------------------------------------
		return {
			codigosClase		: codigosClase,
			codigoCanalEntrada	: codigoCanalEntrada
		}

	}

})();

// EditarOrdenDTO -------------------------------------

var EditarOrdenDTO = (function () {

	return function(args){

		// private interface ---------------------------------------

		var idOrden = $.isNumeric(args.idOrden) ? args.idOrden : -1;

		// public interface ---------------------------------------

		return {

			idOrden	: idOrden

		}

	}

})();

//PermisoAtributoDTO -------------------------------------

var PermisoAtributoDTO = (function () {

	return function(args){

		// private interface ---------------------------------------

		var obligatorio = args.obligatorio || false;
		var publicable 	= args.publicable || false;

		// public interface ---------------------------------------

		return {

			obligatorio	: obligatorio,
			publicable 	: publicable

		}

	}

})();

// AtributoCIDDTO -------------------------------------

var AtributoCIDDTO = (function () {

	return function(args){

		// private interface ---------------------------------------

		var nombre 			= args.nombre || "";
		var permisoAtributo = args.permisoAtributo ? new PermisoAtributoDTO(args.permisoAtributo) : null ;

		// public interface ---------------------------------------

		return {

			nombre			: nombre,
			permisoAtributo : permisoAtributo

		}

	}

})();

// PermisoAtributoSearchDTO -------------------------------------

var PermisoAtributoSearchDTO = (function () {

	return function(args){

		// private interface ---------------------------------------

		var codigoAtributo 			= args.codigoAtributo || "";
		var fechaVigencia 			= args.fechaVigencia || new Date();
		var codigoCanalEntrada 		= args.codigoCanalEntrada || "";
		var codigoTipoOperacion 	= args.codigoTipoOperacion || "";
		var codigoProductoComercial = args.codigoProductoComercial || "";
		var codigoProducto 			= args.codigoProducto || "";
		var codigoNivelEstructura 	= args.codigoNivelEstructura || "";

		// public interface ---------------------------------------

		return {

			codigoAtributo			: codigoAtributo,
			fechaVigencia			: fechaVigencia,
			codigoCanalEntrada		: codigoCanalEntrada,
			codigoTipoOperacion		: codigoTipoOperacion,
			codigoProductoComercial	: codigoProductoComercial,
			codigoProducto			: codigoProducto,
			codigoNivelEstructura 	: codigoNivelEstructura

		}

	}

})();

// CallBackObject -------------------------------------

var CallBackObject = (function() {

	return function(args) {

		// private interface ---------------------------

		var url 						= args.url || "";
		var staticObject				= args.staticObject || null;
		var succesHandlerCallBack		= args.successHandlerCallback || null;
		var errorHandlerCallBack		= args.errorHandlerCallBack||null;
		var processCallBack				= args.processCallBack||null;
		var next						= args.next||null;

		// public interface ----------------------------

		return {

			url						:url,
			staticObject			:staticObject,
			succesHandlerCallBack	:succesHandlerCallBack,
			errorHandlerCallBack	:errorHandlerCallBack,
			processCallBack			:processCallBack,
			next					:next

		}

	};

})();



//EstadoGWPTransacciones

var EstadoGWPTransaccion = {

	PENDIENTE_CONFIRMACION			: "PENDIENTE_CONFIRMACION",
	ENVIADO							: "ENVIADO",
	NO_RECIBIDO						: "NO_RECIBIDO",
	ACREDITADO						: "ACREDITADO",
	CANCELADO						: "CANCELADO",
	ERROR							: "ERROR"

};

//EstadoAviso

var EstadoAviso = {

	PENDIENTE_PAGO				: "PENDIENTE_PAGO",
	SIN_AUTORIZAR				: "SIN_AUTORIZAR",
	PENDIENTE_PUBLICACION		: "PENDIENTE_PUBLICACION",
	DERIVADO_PUBLICACION		: "DERIVADO_PUBLICACION",
	VENCIDO						: "VENCIDO",
	CANCELADO					: "CANCELADO",
	RECHAZADO					: "RECHAZADO",
	NO_PUBLICADO				: "NO_PUBLICADO",
	SUSPENDIDO_SIN_AUTORIZAR	: "SUSPENDIDO_SIN_AUTORIZAR",
	SUSPENDIDO_AUTORIZADO		: "SUSPENDIDO_AUTORIZADO"

};

//EstadoAviso

var EstadoConcepto = {

	ANULADO : "ANULADO"

};

//AccionAviso

var AccionAviso = {

	SUSPENDER				: "SUSPENDER",
	REACTIVAR_AVISO			: "REACTIVAR_AVISO",
	REPBLICAR_AVISO			: "REPUBLICAR_AVISO"

};

//TraduccionEstadoAviso

var TraduccionEstadoAviso = {

	PENDIENTE_PAGO_GWP_PENDIENTE		: "Aguardando confirmaci\xf3n de pago",
	PENDIENTE_PAGO_GWP_RECHAZADO		: "Pago rechazado",
	PENDIENTE_PAGO_GWP_SIN_RESPUESTA	: "Pendiente de pago",
	SIN_AUTORIZAR						: "Pendiente de moderaci\xf3n",
	PENDIENTE_PUBLICACION				: "En proceso de publicaci\xf3n",
	DERIVADO_PUBLICACION_FECHA_MAYOR	: "En proceso de publicaci\xf3n",
	DERIVADO_PUBLICACION_FECHA_MENOR	: "Aviso publicado",
	VENCIDO								: "Aviso vencido",
	CANCELADO							: "Aviso cancelado",
	RECHAZADO							: "Aviso rechazado",
	NO_PUBLICADO						: "Aviso cancelado",
	SUSPENDIDO_AUTORIZADO				: "Publicaci\xf3n detenida",
	SUSPENDIDO_SIN_AUTORIZAR			: "Publicaci\xf3n detenida"

};

//DescripcionEstadoAvisoPopOver

var DescripcionEstadoAvisoPopOver = {

	PENDIENTE_PAGO_GWP_PENDIENTE		: "Por favor aguarde, estamos procesando el pago.",
	PENDIENTE_PAGO_GWP_RECHAZADO		: "El pago ha sido rechazado, por favor intente nuevamente o comun\xedquese con su entidad bancaria.",
	PENDIENTE_PAGO_GWP_SIN_RESPUESTA	: "No hemos podido procesar el pago, por favor vuelva a intentarlo m\xe1s tarde.",
	SIN_AUTORIZAR						: "El pago fue aprobado y el aviso est\xe1 pendiente de moderaci\xf3n. Los avisos son moderados antes de ser publicados. Si existe alg\xfan inconveniente lo estaremos contactando.",
	PENDIENTE_PUBLICACION				: "Felicitaciones. El pago y la moderaci\xf3n han sido aprobados.",
	DERIVADO_PUBLICACION_FECHA_MAYOR	: "Felicitaciones. El pago y la moderaci\xf3n han sido aprobados.",
	DERIVADO_PUBLICACION_FECHA_MENOR	: "Felicitaciones. El aviso ha sido publicado.",
	VENCIDO								: "El aviso no ha sido pagado o no se ha moderado. La fecha de publicaci\xf3n ha expirado.",
	CANCELADO							: "El aviso ha sido anulado.",
	RECHAZADO							: "El aviso ha sido rechazado durante el proceso de moderaci\xf3n.",
	NO_PUBLICADO						: "El aviso ha sido anulado por decisi\xf3n propia del anunciante.",
	SUSPENDIDO_AUTORIZADO				: "Decidiste interrumpir la publicaci\xf3n del aviso. Si queres retomar la publicaci\xf3n podes hacerlo seleccionando la opci\xf3n 'Reanudar publicaci\xf3n'",
	SUSPENDIDO_SIN_AUTORIZAR			: "Decidiste interrumpir la publicaci\xf3n del aviso. Si queres retomar la publicaci\xf3n podes hacerlo seleccionando la opci\xf3n 'Reanudar publicaci\xf3n'"

};

//TraduccionSecurityError

var TraduccionSecurityError = {

	VALIDATE_CAPTCHA 					: "validateCaptcha",
	ROL_MAX_INTENTOS_365				: 3

}

//TipoDomicilioConstants --------------------------------

var TipoDomicilioConstants = {

	PRINCIPAL : "1"

};

// 365Constants

var Promocion365Constants = {

	DIGITOS_TARJETA 					: 19,
	CODIGO_ATRIBUTO_PROMOCION_365		: "tarjetaCLARIN365",
	CODIGO_PROMOCION_365				: "CLARIN_365_ROL"

};

// DeseleccionConstants

var DeseleccionConstants = {
	TIPO_DESELECCION_CATEGORIA			: "CATEGORIA",
	TIPO_DESELECCION_BIEN				: "BIEN"
}

// AtributoCIDConstants

var AtributoCIDConstants = {
	MAIL 		: "mail",
	TELEFONO 	: "telefono"
}


