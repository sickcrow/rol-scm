/**
 * author: csantos version: 1.0.0
 * Funciones del paso Confirmacion y pagar de Crear Aviso
 */

// -----------------------------------------------------------------------------
// StateStep7Creacion ---------------------------------------------------------
// -----------------------------------------------------------------------------

var StateStep7Creacion = (function() {

	return function(args) {

		// ------------------------------------------------
		// global interface ------------------------------
		// ------------------------------------------------

		g_setUsuarioCapturador = function() {
			if (decoratorModel.getCapturador() !== null) {
				crearAvisosModel.getOrdenDePublicacion().capturador = decoratorModel.getCapturador();
			}
		};

		// ------------------------------------------------
		// private interface -----------------------------
		// ------------------------------------------------

		var setServerTimeHandler = function(data) {
			crearAvisosModel.setServerTime(new Date(data.serverTime));
		};

		var procesarTipoOperacion = function() {
			return crearAvisosModel.getTipoOperacion().descripcion;
		};

		var procesarClase = function() {
			return crearAvisosModel.getClase().descripcion;
		};

		var listAllOrdenamientos = function() {
			var odenamientosTotales = [];

			$.each(crearAvisosModel.getConfiguracionesOrdenamientoPantalla(),function(index, configuracionOrdenamientoPantalla) {
				odenamientosTotales = $.merge(odenamientosTotales,configuracionOrdenamientoPantalla.ordenamientosAviso);
			});

			return odenamientosTotales;
		};

		var sortOrdenamientos = function(a, b) {
			var aOrdenamiento = a.orden;
			var bOrdenamiento = b.orden;
			return ((aOrdenamiento < bOrdenamiento) ? -1
					: ((aOrdenamiento > bOrdenamiento) ? 1 : 0));
		};

		var procesarOrdenOrdenamientos = function(){

			var odenamientosTotales = listAllOrdenamientos().sort(sortOrdenamientos);
			var retorno = "";

			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			if ($.isArray(aviso.ordenamientos) && $.isArray(odenamientosTotales)){
				$.each(odenamientosTotales, function (indexOrdenamientoTotal, ordenamientoTotal){
					$.each(aviso.ordenamientos, function (indexOrdenamientoAviso, ordenamientoAviso){
						if (ordenamientoTotal.codigo == ordenamientoAviso.codigo){
							if(ordenamientoTotal.ocultarValorUnico === false){
								retorno += " > " + ordenamientoAviso.valor;
								return false;
							}
						}
					});
				});
			}

			return retorno;
		};

		var procesarZonasPublicacion = function(){
			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;

			//Se devuelve el aviso 0 porque son todos iguales.
			//En el caso que se agreguen republicaciones iterar aca sobre sus conceptos vendibles
			return new Array(aviso);
		};

		var buildImageUI = function(id, src) {
			var img = new Image();
			img.id = id;
			img.src = src;
			return img;
		};

		var calcularPrecio = function() {

			var retorno = 0;

			$.each(crearAvisosModel.getOrdenDePublicacion().conceptosVendibles,
					function(indexConcepto, concepto) {
						retorno += concepto.montoTotal;
					});

			return retorno;
		};

		var getFechasPedidoPublicacionString = function() {
			var fechasPedidoPublicacionString = [];

			$.each(crearAvisosModel.getOrdenDePublicacion().conceptosVendibles,function(indexConcepto, concepto) {
				$.each(concepto.itemsConceptoVendible,function(indexItemConcepto,itemConcepto) {
					$.each(itemConcepto.itemsAviso,function(indexItemAviso,itemAviso) {
						fechasPedidoPublicacionString.push(dateUtils.getDateFormatString(new Date(itemAviso.aviso.fechaPedidoPublicacion)));
					});
				});
			});

			return fechasPedidoPublicacionString;
		};

		var generarFechasPublicacion = function() {

			Handlebars.registerHelper("dia", CrearAvisosHelpers.selectedDateDia);
			Handlebars.registerHelper("mes", CrearAvisosHelpers.selectedDateMes);

			var source = CrearAvisosTemplates.selectedDateNoEditable;
			var template = Handlebars.compile(source);
			var context = {selectedDates : getFechasPedidoPublicacionString()};
			var html = template(context);

			ui.fechaPublicacionContainer.html(html);
		};

		var generarTituloPublicacion = function() {
			var source = CrearAvisosTemplates.textoAviso;
			var template = Handlebars.compile(source);
			var textoAviso = procesarClase() + " > " + procesarTipoOperacion()+ procesarOrdenOrdenamientos();
			var context = {textoAviso : textoAviso};
			var html = template(context);
			ui.publicacionContainer.html(html);
		};

		var generarZonas = function() {
			var source = CrearAvisosTemplates.zonasPublicacion;
			var template = Handlebars.compile(source);
			var avisos = procesarZonasPublicacion();
			var context = {avisos : avisos};
			var html = template(context);
			ui.zonasContainer.html(html);
		};

		var generarValorAviso = function() {
			var aux = calcularPrecio();
			g_limpiarMontos(ui.labelprecio, ui.labelNombreDePromo,
					ui.labelTotal, ui.valorMontoConPromocion, ui.valorMontoSinPromo, ui.precio);
			ui.precio.text(aux.toFixed(2));
			g_mostrarMontos(ui.labelprecio, ui.labelNombreDePromo,
					ui.labelTotal, ui.valorMontoConPromocion,
					ui.valorMontoSinPromo, ui.precio, ui.idDesgloce);
		};

		var generarListaPromociones = function(){
			var listadoPromociones = [];
			var conceptos = [];
			var ordenPublicacion = crearAvisosModel.getOrdenDePublicacion();
			var detalleOrden = {"conceptos":conceptos};
			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			var promocionesAplicadas = obtenerDescripcionPromocionesAplicadas(ordenPublicacion);
			var tienePromociones = aviso.avisoPromocion ? aviso.avisoPromocion.length > 0 : false;
			var tienePromocionesAplicadas = tienePromociones;

			if(!tienePromociones){
				$("#divDescuentosConfirmacion").hide();
			}
			else{
				$("#divDescuentosConfirmacion").show();
			}
			modelIterator.iterateConceptosVendiblesFromOrden(ordenPublicacion,{"detalleOrden":detalleOrden},function(index,concepto,args){
				args.detalleOrden.conceptos.push(concepto);
			});
			var template = Handlebars.compile(CrearAvisosTemplates.listadoPromosConfirmacion);
			var context  = {
					tienePromociones			: tienePromociones,
					promocionesAplicadas		: promocionesAplicadas,
					tienePromocionesAplicadas	: tienePromocionesAplicadas
				};
			var html     = template(context);
			$("#divDescuentosConfirmacion #listadoPromosConfirmacion").html(html);

		};

		var obtenerDescripcionPromocionesAplicadas = function(ordenPublicacion){
			var detallePromociones = { "promociones" : [] };
			modelIterator.iterateAvisosFromOrden(ordenPublicacion, { "detallePromociones" : detallePromociones }, function(index, aviso, args){
				if ($.isArray(aviso.avisoPromocion)){
					var encontro = false;
					$.each(aviso.avisoPromocion, function(index, avisoPromo){
						$.each(detallePromociones.promociones, function(index, detallePromocion){
							if (avisoPromo.promocion.codigo === detallePromocion.codigo){
								encontro = true;
							}
						});
						if(!encontro){
							detallePromociones.promociones.push(avisoPromo.promocion);
						}
					});
				}
			});
			return detallePromociones.promociones;
		};


		var generarImagen = function() {
			ui.imagenContainer.empty();
			ui.imagenContainer.prepend(buildImageUI("imgPreview","data:image/jpeg;base64,"+
					crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.preview.contenido));
		};

		var editarFechaPublicacion = function() {
			doOnObserver({"eventWarpTo" : StateEvents.WARP_TO,"step" : 2});
		};

		var editarImagenAviso = function() {
			doOnObserver({"eventWarpTo" : StateEvents.WARP_TO,"step" : 4});
		};

		// ------------------------------------------------
		// common interface ------------------------------
		// ------------------------------------------------

		var modificada = false;

		var accedida = false;

		var index = 7;

		var doOnObserver = args.doOnObserver;

		var isCapturaModificada = args.isCapturaModificada;

		var ui = {
			publicacionContainer		: $("#publicacionContainer"),
			zonasContainer				: $("#zonasContainer"),
			fechaPublicacionContainer	: $("#fechaPublicacionContainer"),
			imagenContainer				: $("#paso6-previewHolder"),
			precio						: $("#valorAvisoPromo"),
			lblPreview					: $("#paso6-lblPreview"),
			valorMontoConPromocion		: $("#paso6-valorConPromo"),
			valorMontoSinPromo			: $("#paso6-valorSinPromo"),
			labelprecio					: $("#paso6-lblPrecioSinPromo"),
			labelNombreDePromo			: $("#paso6-lblPrecioConPromo"),
			labelTotal					: $("#paso6-lblPrecioTotal"),
			editarFechaPublicacion		: $("#editarFechaPublicacion"),
			editarImagenAviso			: $("#editarImagenAviso"),
			idDesgloce					: $("#paso6-desglose")
		};

		var model = {
			notifyChange : false,
			generatedData : null,
			cambiarEstadoFooter : true
		};

		var generateTag = function() {
			decoratorModel.setA2("confirmacion");
			var area = decoratorModel.getA1() + decoratorModel.getA2();
			gChangeTagName(area);
		};

		/**
		 * { event : StateEvents.EVENT_CONST, }
		 */


		var agregaPaso = function(){
			$(".infoPaso").remove();
			$("#MyWizard .steps").append("<li class='infoPaso'>5/5</li>");
		}

		var doOnEnter = function(args) {
			showBreadcrum('PAGO');
			showPanelSeleccionado('PAGO');
			generateTag();

			// me aseguro en apagar la descripcion para el caso es vuelva de
			// anterior
			document.getElementById("divTextoSeleccionaste").style.display = "none";

			generarFechasPublicacion();
			generarTituloPublicacion();
			generarZonas();
			generarImagen();
			generarValorAviso();
			generarListaPromociones();
			doOnComplete({});
			agregaPaso();
		};

		/**
		 * { event : StateEvents.EVENT_CONST, }
		 */
		var doOnExit = function(args) {
			if (args.event === StateEvents.NEXT_FOOTER) {
				g_setUsuarioCapturador();
			} else {
				doOnObserver({"eventsTransform" : [ StateEvents.ACCEPT_TO_NEXT ]});
			}
		};

		var doOnError = function(args) {
			// Implements -----
		};

		var doOnCancel = function(args) {
			doOnObserver({"eventsTransform" : [ StateEvents.ACCEPT_TO_NEXT ]});
		};

		var doOnChange = function(args) {
			// Implements -----
		};

		var doOnShow = function(args) {
			if (args.event === StateEvents.PREVIOUS_FOOTER) {
				generarValorAviso();
			}
		};

		var doOnComplete = function(args) {
			// Evaluate Complete
			if (isComplete(args)) {
				doOnObserver({"eventEnabled" : StateEvents.NEXT_ENABLED});
			} else {
				doOnObserver({"eventEnabled" : StateEvents.NEXT_DISABLED});
			}

			if (decoratorModel.getUsuario() === null || decoratorModel.getCapturador() === null) {
				doOnObserver({"eventsTransform" : [ StateEvents.LOGIN ]});
			} else {
				doOnObserver({"eventsTransform" : [ StateEvents.NEXT_TO_ACCEPT ]});
			}
			// Si esta editando una orden habilito el siguiente si modifico.

			if (crearAvisosModel.esOrdenDePublicacionPersistida()){
				if (isCapturaModificada()){
					doOnObserver({"eventEnabled" : StateEvents.NEXT_ENABLED});
				} else {
					doOnObserver({"eventEnabled" : StateEvents.NEXT_DISABLED});
				}
			}
		};

		var bind = function(args) {
			ui.editarFechaPublicacion.on("click", editarFechaPublicacion);
			ui.editarImagenAviso.on("click", editarImagenAviso);
		};

		var unbind = function(args) {
			ui.editarFechaPublicacion.off("click");
			ui.editarImagenAviso.off("click");
		};

		var isComplete = function(args) {
			return true;
		};

		var notifyChange = function(args) {
			return model.notifyChange;
		};

		var doOnLoad = function(args) {
			doOnEnter(args);
		};

		var doOnExitScreen = function() {
		};

		var getAccedida = function() {
			return accedida;
		};

		// ------------------------------------------------
		// public interface ------------------------------
		// ------------------------------------------------

		return {

			doOnEnter			: doOnEnter,
			doOnExit			: doOnExit,
			doOnError			: doOnError,
			doOnCancel			: doOnCancel,
			doOnChange			: doOnChange,
			doOnShow			: doOnShow,
			doOnComplete		: doOnComplete,
			bind				: bind,
			unbind				: unbind,
			isComplete			: isComplete,
			notifyChange		: notifyChange,
			doOnLoad			: doOnLoad,
			doOnExitScreen		: doOnExitScreen,
			getAccedida			: getAccedida

		};

	};

})();

// -----------------------------------------------------------------------------
// StateStep8Creacion ----------------------------------------------------------
// -----------------------------------------------------------------------------

var StateStep8Creacion = (function() {

	return function(args) {

		// ------------------------------------------------
		// global interface ------------------------------
		// ------------------------------------------------

		gOnblurMuestraAyudaEmail = function(){
			$("#ayudaEmail").hide();
		};

		gClickMuestraAyudaEmail = function(){
			$("#ayudaEmail").show();
		};

		gOnblurMuestraAyudaTelefono = function(){
			$("#ayudaTelefono").hide();
		};

		gClickMuestraAyudaTelefono = function(){
			$("#ayudaTelefono").show();
		};

		gOnblurMuestraAyudaArea = function(){
			$("#ayudaArea").hide();
		};

		gClickMuestraAyudaArea = function(){
			$("#ayudaArea").show();
		};

		$("#inputTelefonoAviso, #inputAreaAviso").keypress(function(e) {
			// Admite BACKSPACE y chequea por digitos
	        var keynum = window.event ? window.event.keyCode : e.which;
	        if (keynum == 8){	return true;	}
	        return /\d/.test(String.fromCharCode(keynum));
		});

		//--------

		gOnkeyupHabilitarBotonPagar = function() {
			doOnComplete({});
		};

		gOnchangeSeleccionarPaisHandler = function(component) {
			clearOptionsDireccion(ui.divSeleccionProvincia);
			clearOptionsDireccion(ui.divSeleccionLocalidad);

			if (component.options.selectedIndex !== 0) {
				var codigoPais = $(component.options[component.options.selectedIndex]).data("codigo");
				cargarComboProvincias(codigoPais);
			}

			doOnComplete({});
		};

		gOnchangeSeleccionarProvinciaHandler = function(component) {
			clearOptionsDireccion(ui.divSeleccionLocalidad);

			if (component.options.selectedIndex !== 0) {
				var codigoProvincia = $(component.options[component.options.selectedIndex]).data("codigo");
				cargarComboLocalidades(codigoProvincia);
			}

			doOnComplete({});
		};

		gOnchangeSeleccionarLocalidadHandler = function() {
			doOnComplete({});
		};

		gOnClick_tarjeta = function(component) {

			if (Detectizr.device.browser === "ie" && Detectizr.device.browserVersion === "8") {

				$(".css-label-radio").click(function() {
					$(".css-label-radio").css({"backgroundPositionY" : "-5px"});
					$(this).css({"backgroundPositionY" : "-87px"});
				});
			}

			crearAvisosModel.setCodigoGATEWAYSeleccionado(component.id);
			doOnComplete({});

		};

		gOnClickBotonTarjeta365 = function(component) {
			if (Detectizr.device.browser === "ie") {
				if ($("#btnInput365").hasClass("disabledBtn")) {
					return false;
				}
			}
			var valorInputTarjeta365 = $("#textInput365").val();
			var codigoPromocion = $(component).data("promocion");
			var promocion365 = obtenerPromocion(codigoPromocion);
			promocion365.seleccion = true;
			valorInputTarjeta365 = valorInputTarjeta365.replace(/\s+/g, "");
			tresNumTarjeta = valorInputTarjeta365.slice(valorInputTarjeta365.length - 3);
			crearAvisosModel.setTarjeta365(valorInputTarjeta365);
			if (valorInputTarjeta365.length <= 18) {
				// VALIDO LA LONGITUD DE LO QUE HA INTRODUCIDO
				$("#errorTarjeta365").show();
				$("#errorTarjeta365").html("La tarjeta debe tener 19 n&uacute;meros. Introdujiste " + valorInputTarjeta365.length + " n&uacute;meros.");
				ocultaCaptcha365();
			} else {
				var atributoAviso = new AtributoAvisoDTO({
					"codigo" : Promocion365Constants.CODIGO_ATRIBUTO_PROMOCION_365,
					"valor" : valorInputTarjeta365
				});
				var agrupadorAtributoAviso = new AgrupadorAtributoAvisoDTO({
					"atributoAviso" : atributoAviso,
					"step" : index
				});

				validarPromocion({
					"agrupadorAtributoAviso" : agrupadorAtributoAviso,
					"promocion" : promocion365
				});
			}
		};

		gOnfocusRecuperarEstiloInputHandler = function(component,componentError) {
			if ($("#" + component.id).hasClass("warning")) {
				$("#" + component.id).removeClass("warning");
				$("#" + componentError).hide();
			}
		};

		gOnClickCancelarPopUp365Handler = function(args){
			$('#popUp365Cargada').modal('hide');
		};

		gOnClickAceptarPopUp365Handler = function(args){
			$('#popUp365Cargada').modal('hide');
			$("#textInput365").focus();
		};

		// ------------------------------------------------
		// private interface -----------------------------
		// ------------------------------------------------

		var initDatosDeContacto = function (){
			var result = { telefono : {codigoArea : "", telefono : ""}, email : ""};
			// Si es orden guardada tomo inicialmente los datos de la orden.
			if (crearAvisosModel.esOrdenDePublicacionPersistida()){
				result.telefono = getDatoContactoTelefono(crearAvisosModel.getOrdenDePublicacion().telefono);
				result.email = crearAvisosModel.getOrdenDePublicacion().email;
			} else {
				if (crearAvisosModel.getPermisoAtributoEmail() &&
						crearAvisosModel.getPermisoAtributoEmail().publicable){
					result.email = decoratorModel.getUsuario().email;
				}
			}
			ui.campoContactoCodigoArea.val(result.telefono.codigoArea);
			ui.campoContactoTelefono.val(result.telefono.telefono);
			ui.campoContactoEmail.val(result.email);
		};

		/**
		 * Setea los campos de contacto del input en la Orden a persistir.
		 */
		var setDatosContactoFromOrden = function(){
			var result = { telefono : {codigoArea : "", telefono : ""}, email : ""};
			result.telefono = getDatoContactoTelefono(crearAvisosModel.getOrdenDePublicacion().telefono);
			result.email = crearAvisosModel.getOrdenDePublicacion().email;
			ui.campoContactoCodigoArea.val(result.telefono.codigoArea);
			ui.campoContactoTelefono.val(result.telefono.telefono);
			ui.campoContactoEmail.val(result.email);
		};

		var commitDatoContactoEmail = function(){
			crearAvisosModel.getOrdenDePublicacion().email = ui.campoContactoEmail.val();
		};

		var commitDatoContactoTelefono = function(){
			crearAvisosModel.getOrdenDePublicacion().telefono = ui.campoContactoCodigoArea.val() + "-" + ui.campoContactoTelefono.val();
		};

		var validateEmptyTelefonoFromOrden = function(){
			if (crearAvisosModel.getOrdenDePublicacion().telefono == "-"){
				crearAvisosModel.getOrdenDePublicacion().telefono = "";
			}
		};

		/**
		 * Recibe el telefono con el formato "codigoArea-telefono" y lo
		 * devuelve separado en codigoArea y telefono.
		 */
		var getDatoContactoTelefono = function (telefono){
			var result = {codigoArea : "", telefono : ""};
			if (telefono !== undefined){
				var arrayTelefono = telefono.split("-");
				if (arrayTelefono.length <= 2){
					result.codigoArea = arrayTelefono[0];
					result.telefono = arrayTelefono[1];
				}
			}
			return result;
		};

		var initPopUp365Cargada = function () {
			datos = {
				idPopUp   : "popUp365Cargada",
				classTipoMensaje : "popUpAlerta", // Puede ser "popUpAlerta", "popUpInfo" � "popUpError"
				titulo    : "Atenci\xf3n",
				mensaje   : "Por favor valid\xe1 tu n\xfamero de tarjeta 365." ,
				txtBoton2 : "Aceptar",
				funcionBoton1:"",
				funcionBoton2: "gOnClickAceptarPopUp365Handler(this)"

			};
			var source   = DecoratorTemplates.modalPopUpWindowSinCerrar;
			var template = Handlebars.compile(source);
			var html     = template(datos);

			ui.footer.append(html);
		};

		var editarAvisoGratis = function() {
			doOnObserver({
				"eventWarpTo" : StateEvents.WARP_TO,
				"step" : 4
			});
		};

		var renderHandlebars = function(source, context, uiComponent) {

			var template = Handlebars.compile(source);
			var html = template(context);

			uiComponent.append(html);
		};

		var calcularPrecio = function() {

			var retorno = 0;

			$.each(crearAvisosModel.getOrdenDePublicacion().conceptosVendibles,
					function(indexConcepto, concepto) {
						retorno += concepto.montoTotal;
					});

			return retorno;
		};

		var obtenerTarjetasDisponibles = function() {

			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_TARJETAS_PAGO,
				dataObject : new TarjetaPagoSearchDTO(crearAvisosModel.getCodigoCanalEntrada()),
				successHandlerCallback : obtenerTarjetasDisponiblesHandler,
				errorHandlerCallback : defaultErrorHandler
			});

		};

		var obtenerTarjetasDisponiblesHandler = function(args) {

			crearAvisosModel.tarjetas = args.tarjetas;

			var template = Handlebars.compile(CrearAvisosTemplates.selectorTarjetas);
			var context = {tarjetasPago : crearAvisosModel.tarjetas};
			var html = template(context);

			ui.pagosContainer.append(html);

		};

		var mostrarPrecio = function() {

			var aux = calcularPrecio();
			model.montoAviso = aux;
			ui.precioContainer.text("$" + aux.toFixed(2));

		};

		var cargarComboPaises = function() {
			clearOptionsDireccion(ui.divSeleccionPais);
			clearOptionsDireccion(ui.divSeleccionProvincia);
			clearOptionsDireccion(ui.divSeleccionLocalidad);

			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_PAISES,
				dataObject : null,
				successHandlerCallback : getPaisesHandler,
				errorHandlerCallback : defaultErrorHandler
			});
		};

		var getPaisesHandler = function(data) {
			var listaPaises = arrayUtils.buildArrayObjFromJSON(data.paises,PaisDTO);
			renderHandlebars(CrearAvisosTemplates.paises, {paises : listaPaises}, ui.divSeleccionPais);

			if (listaPaises.length === 1) {
				ui.divSeleccionPais[0].selectedIndex = 1;
				cargarComboProvincias(listaPaises[0].codigo);
			}
		};

		var cargarComboProvincias = function(codigoPais) {
			clearOptionsDireccion(ui.divSeleccionProvincia);
			clearOptionsDireccion(ui.divSeleccionLocalidad);

			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_PROVINCIAS,
				dataObject : buildProviciaSearchDTO(codigoPais),
				successHandlerCallback : getProvinciasHandler,
				errorHandlerCallback : defaultErrorHandler
			});
		};

		var buildProviciaSearchDTO = function(codigoPais) {
			return new PaisDTO({
				"codigo" : codigoPais
			});
		};

		var getProvinciasHandler = function(data) {
			var listaProvincias = arrayUtils.buildArrayObjFromJSON(
					data.provincias, ProvinciaDTO);
			renderHandlebars(CrearAvisosTemplates.provincias, {
				provincias : listaProvincias
			}, ui.divSeleccionProvincia);

			if (listaProvincias.length === 1) {
				ui.divSeleccionProvincia[0].selectedIndex = 1;
				cargarComboLocalidades(listaProvincias[0].codigo);
			}
		};

		var cargarComboLocalidades = function(codigoProvincia) {
			clearOptionsDireccion(ui.divSeleccionLocalidad);

			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_LOCALIDADES,
				dataObject : buildLocalidadSearchDTO(codigoProvincia),
				successHandlerCallback : getLocalidadesHandler,
				errorHandlerCallback : defaultErrorHandler
			});
		};

		var buildLocalidadSearchDTO = function(codigoProvincia) {
			return new ProvinciaDTO({
				"codigo" : codigoProvincia
			});
		};

		var getLocalidadesHandler = function(data) {
			var listaLocalidades = arrayUtils.buildArrayObjFromJSON(
					data.localidades, LocalidadDTO);
			renderHandlebars(CrearAvisosTemplates.localidades, {
				localidades : listaLocalidades
			}, ui.divSeleccionLocalidad);

			if (listaLocalidades.length === 1) {
				ui.divSeleccionLocalidad[0].selectedIndex = 1;
			}
		};

		var clearOptionsDireccion = function(component) {
			for ( var i = component[0].options.length - 1; i > 0; i--) {
				component[0].remove(i);
			}
		};

		var cargarDatosDireccionCapturador = function(domicilio) {
			if (domicilio && domicilio !== undefined) {
				if (domicilio.calle !== undefined) {
					ui.campoCalle[0].value = domicilio.calle;
				}
				if (domicilio.puerta !== undefined) {
					ui.campoNroPuerta[0].value = domicilio.puerta;
				}
				if (domicilio.piso !== undefined) {
					ui.campoPiso[0].value = domicilio.piso;
				}
				if (domicilio.depto !== undefined) {
					ui.campoDepto[0].value = domicilio.depto;
				}
				if (domicilio.codPostal !== undefined) {
					ui.campoCodPostal[0].value = domicilio.codPostal;
				}

				seleccionarValorCombo(domicilio.pais, ui.divSeleccionPais);
				seleccionarValorCombo(domicilio.provincia,ui.divSeleccionProvincia);
				seleccionarValorCombo(domicilio.localidad,ui.divSeleccionLocalidad);
			}

			doOnComplete({});
		};

		var seleccionarValorCombo = function(value, selectCombo) {
			for ( var i = 0; i < selectCombo[0].options.length; i++) {
				if ($(selectCombo[0].options[i]).data("codigo") === value) {
					selectCombo[0].selectedIndex = i;

					if ($(selectCombo[0].options[i]).data("select") === "pais") {
						cargarComboProvincias(value);
					} else if ($(selectCombo[0].options[i]).data("select") === "provincia") {
						cargarComboLocalidades(value);
					}
				}
			}
		};

		var pagarYGuardarOrdenPublicacion = function() {
			if(!model.tienePromocionGratuita && !crearAvisosModel.esOrdenDePublicacionPagoAcreditado()){
    			ui.popup=window.open();
    			if (ui.popup == null || typeof(ui.popup)=='undefined') {
    				alert('Por favor deshabilita el bloqueador de ventanas emergentes y vuelve a intentarlo.');
    			}else{
    				decoratorModel.setA3("pago");
    				var area = decoratorModel.getA1()+decoratorModel.getA2()+decoratorModel.getA3();
    				gChangeTagName(area);
    				ui.popup.document.write('<h1 style="margin:20% 0 0 ; text-align:center; width:100%">Espera unos instantes.<br> Estamos preparando la informaci&oacute;n para pagar</h1><p style="text-align:center; width:100%"><img src="../img/ajax-loader.gif" alt="cargando" ></p> ');
    				blockCallerUI.blockPost({ url : "pagarYGuardarOrdenDePublicacion",
    					dataObject : new OrdenDePublicacionCabeceraDTO(crearAvisosModel.getOrdenDePublicacion()),
    					successHandlerCallback : pagarYGuardarOrdenDePublicacionHandler,
    					errorHandlerCallback : defaultErrorHandler });
    			}
    		}else{
    			blockCallerUI.blockPost({ url : "pagarYGuardarOrdenDePublicacion",
    				dataObject : new OrdenDePublicacionCabeceraDTO(crearAvisosModel.getOrdenDePublicacion()),
    				successHandlerCallback : pagarYGuardarOrdenDePublicacionHandler,
    				errorHandlerCallback : defaultErrorHandler });
    		}
		};

		var pagarYGuardarOrdenDePublicacionHandler = function(data){
            var result = data.ROLResult;

            if (result.errors.length > 0) {
                if (result.errors[0].errorType == ROLErrorTypeConstants.VALIDATION) {
                    $('#popUpAlerta').modal({
                        backdrop: "static",
                        show: true
                    });

                    var value = "";

                    $.each(result.errors, function (indexError, error) {
                        if (error.messageCode == "CODE_000011") {
                            value = "La fecha seleccionada ha sido cerrada en el transcurso de la carga del aviso. Por favor seleccione otra.";
                        } else {
                            value += error.message;
                        }
                    });

                    $("#popUpAlerta .modal-body p").text(value);
                } else {
                    $('#popUpError').modal({
                        backdrop: "static",
                        show: true
                    });

                    $("#popUpError .modal-body p").text("Su pago no pudo ser procesado. Por favor intente mas tarde");
                    $('#popUpError .btn-primary').click(function() {
                        doOnObserver({"eventFinish" : [StateEvents.FINISH_SUCCES]});
                        doOnObserver({"eventsTransform" : [StateEvents.ACCEPT_TO_NEXT]});
                    });
                }
            } else {

                if (typeof(result.object) == 'string') {
                     if(Detectizr.device.browser === "ie" && Detectizr.device.browserVersion == "8"){
                            doOnObserver( {"eventFinish" :[StateEvents.FINISH_SUCCES]} );
                            doOnObserver( {"eventsTransform" : [StateEvents.ACCEPT_TO_NEXT]} );
                            ui.popup.document.write(result.object);
                            ui.popup.location.reload();
                        }else{

                            /*if(Detectizr.device.browser != "ie"&&Detectizr.device.browser!=""){
                                ui.popup.focus = function(){
                                    windowFocus=true;
                                };
                            }*/
                            doOnObserver( {"eventFinish" : [StateEvents.FINISH_SUCCES]} );
                            doOnObserver( {"eventsTransform" : [StateEvents.ACCEPT_TO_NEXT]} );
                            ui.popup.document.write(result.object);
                            var evt = ui.popup.document.createEvent('Event');
                            evt.initEvent('load', false, false);
                            ui.popup.window.dispatchEvent(evt);
                    }

                } else {
                    doOnObserver({"eventFinish" : [StateEvents.FINISH_SUCCES]});
                    doOnObserver({"eventsTransform" : [StateEvents.ACCEPT_TO_NEXT]});
                }
            }
        };


		var limiteCotizacionDireccionHandler = function(data) {
			// si se paso del limite configurado
			if (model.montoAviso > data.result) {
				model.limiteCotizacionExcedido = true;

				if (!model.cargoDatosDireccionCapturador) {
					// inicializo los campos
					bindUILimiteCotizacion();

					// cargo el combo inicial
					cargarComboPaises();

					// precargo los campos
					var domicilio = decoratorModel.getCapturador().domicilio;

					if (domicilio !== undefined) {
						cargarDatosDireccionCapturador(domicilio);
					} else if (crearAvisosModel.getOrdenDePublicacion().domicilio) {
						cargarDatosDireccionCapturador(crearAvisosModel.getOrdenDePublicacion().domicilio);
					}
					model.cargoDatosDireccionCapturador = true;
				}
				// muestro la carga de direccion
				ui.mensajeAlertaLimite[0].style.display = "block";
				//comento la muestra de la descripcion del limite pq pasa a ser siempre - vdenicolo 16/04/2018
				//document.getElementById("valorLimite").innerHTML = data.result;
				ui.divCargaDireccion[0].style.display = "block";
				ui.datosPagoContainer[0].style.display = "block";
				posicionarCamposDeFormulario();

			} else {
				ui.mensajeAlertaLimite[0].style.display = "none";
				ui.divCargaDireccion[0].style.display = "none";
				ui.datosPagoContainer[0].style.display = "none";
				model.limiteCotizacionExcedido = false;
			}

			doOnComplete();
		};

		var analizarLimiteCotizacion = function() {
			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_LIMITE_COTIZACION_EXEDIDO,
				dataObject : new LimiteCotizacionDTO(model.montoAviso),
				successHandlerCallback : limiteCotizacionDireccionHandler,
				errorHandlerCallback : defaultErrorHandler
			});
		};

		var completoDireccion = function() {
			if (checkCalleCompletado() && checkNroPuertaCompletado() && checkCodigoPostalCompletado() && checkSelectsCompletado()) {
				return true;
			}
			return false;
		};

		var checkCalleCompletado = function() {
			if (ui.campoCalle[0].value.trim().length > 0) {
				return true;
			}
			return false;
		};

		var checkNroPuertaCompletado = function() {
			if (ui.campoNroPuerta[0].value.trim().length > 0) {
				return true;
			}
			return false;
		};

		var checkCodigoPostalCompletado = function() {
			if (ui.campoCodPostal[0].value.trim().length > 0) {
				return true;
			}
			return false;
		};

		var checkSelectsCompletado = function() {
			if (ui.divSeleccionPais[0].selectedIndex !== 0 && ui.divSeleccionProvincia[0].selectedIndex !== 0 && ui.divSeleccionLocalidad[0].selectedIndex !== 0) {
				return true;
			}
			return false;
		};

		var bindUILimiteCotizacion = function() {
			ui.campoCalle.bind("contextmenu cut copy paste", function(e) {
				e.preventDefault();
			});
			ui.campoNroPuerta.bind("contextmenu cut copy paste", function(e) {
				e.preventDefault();
			});
			ui.campoPiso.bind("contextmenu cut copy paste", function(e) {
				e.preventDefault();
			});
			ui.campoDepto.bind("contextmenu cut copy paste", function(e) {
				e.preventDefault();
			});
			ui.campoCodPostal.bind("contextmenu cut copy paste", function(e) {
				e.preventDefault();
			});

			ui.campoNroPuerta.keypress(function(e) {
				// adaptado de la funcion que se encuentra en registrarse
				var keynum;
				var keychar;
				var numcheck;
				if (window.event) {
					keynum = e.keyCode;
				} // IE
				else if (e.which) {
					keynum = e.which;
				} // netscape/Firefox/opera
				var tabkey = e.keyCode;
				if (keynum === 8 || tabkey === 9 || tabkey === 37 || tabkey === 39) {
					return true;
				} else {
					keychar = String.fromCharCode(keynum);
					numcheck = /[.0-9]/;
					return numcheck.test(keychar);
				}
			});
		};

		var crearDomicilioAviso = function() {
			domicilio = new DomicilioDTO({});

			domicilio.tipoDomicilio = new TipoDomicilioDTO({});
			domicilio.tipoDomicilio.codigo = TipoDomicilioConstants.PRINCIPAL;

			domicilio.calle = ui.campoCalle[0].value;
			domicilio.puerta = ui.campoNroPuerta[0].value;
			domicilio.piso = ui.campoPiso[0].value;
			domicilio.depto = ui.campoDepto[0].value;
			domicilio.codPostal = ui.campoCodPostal[0].value;
			domicilio.pais = $(ui.divSeleccionPais[0].options[ui.divSeleccionPais[0].selectedIndex]).data("codigo");
			domicilio.provincia = $(ui.divSeleccionProvincia[0].options[ui.divSeleccionProvincia[0].selectedIndex]).data("codigo");
			domicilio.localidad = $(ui.divSeleccionLocalidad[0].options[ui.divSeleccionLocalidad[0].selectedIndex]).data("codigo");

			return domicilio;
		};

		var buildCapturadorCRUDDTO = function(domicilioFacturacion) {
			return new CapturadorCRUDDTO({
				codigoCliente			: AtributosCapturadorConstants.CODIGO_CLIENTE,
				codigoAnunciante		: decoratorModel.getCapturador().codigoAnunciante,
				nombre					: decoratorModel.getCapturador().nombre,
				apellido				: decoratorModel.getCapturador().apellido,
				numeroDocumento			: decoratorModel.getCapturador().numeroDocumento,
				codigoTipoDocumento		: AtributosCapturadorConstants.CODIGO_TIPO_DOCUMENTO,
				domicilio				: domicilioFacturacion,
				sexo					: decoratorModel.getCapturador().sexo,
				fechaNacimiento			: decoratorModel.getCapturador().fechaNacimiento
			});
		};

		var direccionActualizadaHandler = function(data) {
			// dummy
		};

		var saveUpdateDireccionAnuncianteHUB = function(domicilioFacturacion) {
			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.UPDATE_CAPTURADOR,
				dataObject : buildCapturadorCRUDDTO(domicilioFacturacion),
				successHandlerCallback : direccionActualizadaHandler,
				errorHandlerCallback : defaultErrorHandler
			});
		};

		var placeHolderOldBrowsers = function() { };

		var checkInput365Completado = function() {
			var tarjeta365 = stringUtils.replaceAll(" ", "",$("#textInput365")[0].value);
			if (tarjeta365.length === Promocion365Constants.DIGITOS_TARJETA) {
				return true;
			}
			return false;
		};

		var checkInputCaptcha365Completado = function() {
			if (model.mostrarCaptcha) {
				if ($("#captchaPromo365")[0].value.trim().length === 6) {
					return true;
				} else {
					return false;
				}
			}
			return true;
		};

		var agregaPaso = function(){
			$(".infoPaso").remove();
			$("#MyWizard .steps").append("<li class='infoPaso'>5/5</li>");
		}

		var muestraInput = function(promocion) {
			renderizarPromociones(promocion);
			$("#textLink365").on("click",function() {
				$("#promo365").css({'background':'none', 'min-height':'110px', 'padding-bottom':'10px'});
				$("#textLink365").parent().hide();
				$("#input365").show();
				$("#btnInput365").addClass("disabledBtn");
				if (Detectizr.device.browser === "ie") {
					$("#btnInput365").removeAttr("onclick");
				}
				$("#textInput365").on("keyup", habilitarBoton365);
				$("#textInput365").on("keypress", validateTarjeta365);
				$("#textInput365").on("contextmenu cut copy paste drag drop",function() {
					return false;
				});
				if (model.mostrarCaptcha) {
					muestraCaptcha365();
				}
			});
		};

		var renderizarPromociones = function(args) {
			renderHandlebars(CrearAvisosTemplates.promocion365, {
				configuracionPromocionPantalla : args
			}, ui.promocionesContainer);
		};

		var isNumeric = function(val) {
			return val !== "NaN" && (+val) + "" === val + "";
		};

		var getChar = function(event) {
			if (event.which === null) {
				return String.fromCharCode(event.keyCode); // IE
			} else if (event.which !== 0 && event.charCode !== 0) {
				return String.fromCharCode(event.which); // the rest
			} else {
				return null; // special key
			}
		};

		var validateTarjeta365 = function(e) {
			e = e || event;
			var chr = getChar(e);
			if (!isNumeric(chr) && chr !== null) {
				e.returnValue = false;
				if (e.preventDefault) {
					e.preventDefault();
					return false;
				}
			}

		};

		var habilitarBoton365 = function() {
			if (checkInput365Completado() && checkInputCaptcha365Completado()) {
				if ($("#btnInput365").hasClass("disabledBtn")) {
					$("#btnInput365").removeClass("disabledBtn");
					if (Detectizr.device.browser === "ie") {
						$("#btnInput365").attr("onclick","gOnClickBotonTarjeta365(this);");
					}
				}
			} else {
				if (!$("#btnInput365").hasClass("disabledBtn")) {
					// si no la tiene se la agrego
					$("#btnInput365").addClass("disabledBtn");
					if (Detectizr.device.browser === "ie") {
						$("#btnInput365").removeAttr("onclick");
					}
				}
			}
			doOnComplete({});
		};

		var cerrarPromo365 = function() {
			$(".close365Ok").on("click", reiniciarComponente365);
		};

		var limpiarOcultarCaptcha = function() {
			// oculto msjs error
			$("#textInput365").removeClass("warning");
			$("#errorTarjeta365").hide();
			$("#captchaPromo365").removeClass("warning");
			$("#errorCaptchaPromo365").hide();
			// limpio input captcha
			$("#captchaPromo365").val("");
			$("#captcha365").hide();
		};

		var reiniciarComponente365 = function() {
			$("#ok365").hide();
			limpiarOcultarCaptcha();
			$("#textInput365").val("");
			$("#textLink365").parent().show();
			quitarPromocion365FromOrden();
			quitarPromocion365FromModel();
			quitarAtributoTarjeta365FromOrden();
			quitarAgrupadorAtributoAvisoTarjeta365FromModel();
			restaurarPrecioSinPromo();
		};

		var restaurarPrecioSinPromo = function() {
			var orden = crearAvisosModel.getOrdenDePublicacion();

			// retazo la orden y actualizo la orden de session
			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.ELIMINAR_PROMO_365,
				dataObject : crearAvisosModel.getOrdenDePublicacion(),
				successHandlerCallback : eliminarPromocion365Handler,
				errorHandlerCallback : defaultErrorHandler
			});

		};

		var eliminarPromocion365Handler = function(data) {
			var orden = data.object;
			crearAvisosModel.setOrdenDePublicacion(orden);
			mostrarPrecio();
			analizarLimiteCotizacion();
		};

		var muestraCaptcha365 = function() {
			$("#captcha365").show();
			noSeleccionCaptcha();
			$("#btnInput365").addClass("disabledBtn btn365Captcha");
			$("#errorTarjeta365").addClass("error365ToLeft");
			$("#captchaPromo365").on("click", function() {
				$(this).focus();
			});
			$("#captchaPromo365").on("keyup", habilitarBoton365);
		};

		var ocultaCaptcha365 = function() {
			$("#captcha365").hide();
			$("#btnInput365").removeClass("btn365Captcha");
			$("#errorTarjeta365").removeClass("error365ToLeft");
		};

		var actualizarCaptcha365 = function() {
			$(".realperson-regen").trigger("click");
		};

		var initImagenCaptcha365 = function() {
			$("#captchaPromo365").realperson();
		};

		var noSeleccionCaptcha = function() {
			var textCaptcha = document.getElementById("captcha365");
			// Internet Explorer
			textCaptcha.onselectstart = function() {
				return false;
			};
			// Firefox
			textCaptcha.onmousedown = function() {
				return false;
			};
		};

		var getIntentosPromocion365 = function() {
			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.CHECK_INTENTOS_PROMOCION_365,
				dataObject : null,
				successHandlerCallback : intentosPromocion365Handler,
				errorHandlerCallback : defaultErrorHandler
			});
		};

		var intentosPromocion365Handler = function(data) {
			var intentos = data.object;
			if (intentos >= TraduccionSecurityError.ROL_MAX_INTENTOS_365) {
				model.mostrarCaptcha = true;
			}
		};

		var mostrarPromociones = function(args) {
			if (crearAvisosModel.getConfiguracionesPromocionPantalla() !== null && crearAvisosModel.getConfiguracionesPromocionPantalla().length > 0) {
				$.each(crearAvisosModel.getConfiguracionesPromocionPantalla(),function(indexPromociones,configuracionPromocionPantalla) {
					if(configuracionPromocionPantalla.pantallaShow === index && crearAvisosModel.getOrdenDePublicacion().conceptosVendibles.length === 1 ){
						
						//agrego un chequeo de promociones compatibles - vdenicolo 18/05/2017
						//en este caso se hace para 365 pq es la unica en pantalla 8
						var codigoPromocion = configuracionPromocionPantalla.promocion.codigo;
						var promocionesCompatibles = configuracionPromocionPantalla.promocion.promocionesCompatibles;
						
						validaPromocion = true;
						$.each(crearAvisosModel.getPromociones(), function (indexPromocion, promocion) {
							if(promocionesCompatibles.indexOf(promocion.codigo) === -1){
								validaPromocion = false;
							}
						});
						if (validaPromocion){
							muestraInput(configuracionPromocionPantalla);
							initImagenCaptcha365();
						}
					}
				});
			}
		};

		// El DoOnLoad hace lo mismo solo que chequea en la orden si tenia algo
		// ya cargado por el usuario y renderiza el cambio
		var mostrarPromocionesDoOnLoad = function(args) {
			if (crearAvisosModel.getConfiguracionesPromocionPantalla().length > 0) {
				$.each(crearAvisosModel.getConfiguracionesPromocionPantalla(),function(indexPromociones,configuracionPromocionPantalla) {
					if(configuracionPromocionPantalla.pantallaShow === index && crearAvisosModel.getOrdenDePublicacion().conceptosVendibles.length === 1 ){
						
						//agrego un chequeo de promociones compatibles - vdenicolo 18/05/2017
						//en este caso se hace para 365 pq es la unica en pantalla 8
						var codigoPromocion = configuracionPromocionPantalla.promocion.codigo;
						var promocionesCompatibles = configuracionPromocionPantalla.promocion.promocionesCompatibles;
						
						validaPromocion = true;
						$.each(crearAvisosModel.getPromociones(), function (indexPromocion, promocion) {
							if(promocionesCompatibles.indexOf(promocion.codigo) === -1){
								validaPromocion = false;
							}
						});
						if (validaPromocion){
							muestraInput(configuracionPromocionPantalla);
							initImagenCaptcha365();
							checkTarjeta365CargadaDoOnLoad();
						}
					}
				});
			}
		};

		var checkTarjeta365CargadaDoOnLoad = function() {
			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			var atributoTarjeta365Cargada = null;
			var atributoTarjeta365Valor = null;

			/* recorro los atributos, si encuentro el de la 365, lo cargo en el input y lo muestro */
			if (aviso.atributosAviso !== undefined) {
				$.each(aviso.atributosAviso,function(i, atributoAviso) {
					if (atributoAviso.codigo === Promocion365Constants.CODIGO_ATRIBUTO_PROMOCION_365) {
						atributoTarjeta365Valor = atributoAviso.valor;
						mostrarTarjeta365Valor(atributoTarjeta365Valor);
					}
				});
			}

			/* Recorro las promociones, si encuentro la 365 aplicada, muestro el 365 ok y oculto el input */
			if (aviso.avisoPromocion !== undefined) {
				/* Puede tener tarjeta 365 cargada */
				$.each(aviso.avisoPromocion,function(i, avisoPromocion) {
					var promo = avisoPromocion.promocion;
					if (promo.codigo !== undefined && promo.codigo === Promocion365Constants.CODIGO_PROMOCION_365) {
						mostrarTarjeta365OK(atributoTarjeta365Valor);
					}
				});
			}
		};

		var mostrarTarjeta365OK = function(atributoTarjeta365Valor) {
			var ultimosTresNumTarjeta = atributoTarjeta365Valor.slice(atributoTarjeta365Valor.length - 3);
			$("#ok365").find(".numTarjeta365").text("..." + ultimosTresNumTarjeta);
			crearAvisosModel.setTarjeta365(atributoTarjeta365Valor);
			$("#textLink365").parent().hide(); /* oculto el link */
			$("#ok365").show(); /* Muestro el 365OK */
			$("#input365").hide(); /* Oculto el input */
			cerrarPromo365();
		};

		var mostrarTarjeta365Valor = function(valor){
			$("#textLink365").parent().hide(); /* oculto el link */
			$("#textInput365").val(valor);
			$("#input365").show(); /* Muestro el input */
			$("#ok365").hide(); /* Oculto el 365OK */
			crearAvisosModel.setTarjeta365(valor);
		}

		var validarPromocion = function(args) {
			var ordenPublicacion = crearAvisosModel.getOrdenDePublicacion();
			var aviso = ordenPublicacion.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;

			// inicializo los array por cualquier inconveniente.
			initArray({"array" : aviso.avisoPromocion});
			initArray({"array" : aviso.atributosAviso});

			// agrego en el listado de las promociones.
			crearAvisosModel.addPromocion({
				"promocion"		: args.promocion,
				"promociones"	: crearAvisosModel.getPromocionesAnterioresValidadas(index),
				"index"			: index
			});
			addOrUpdateAgrupadorAtributoAviso({
				"agrupadorAtributoAviso"	: args.agrupadorAtributoAviso,
				"agrupadoresAtributoAviso"	: crearAvisosModel.getAgrupadoresAtributoAviso()
			});

			// obtengo las promociones que corresponden hasta la ubicacion en la que estoy.
			var promocionesAplicables = crearAvisosModel.getPromocionesHastaPantallaSeleccionada(index);
			var argsFunction = {"atributosAviso" : crearAvisosModel.getAtributosAvisoHastaPantallaSeleccionada(index)};
			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), argsFunction,
				function(index, aviso, args){
					aviso.atributosAviso = args.atributosAviso;
				}
			);

			var montoTotalSinPromo = null;

			if (crearAvisosModel.getTemplateTieneMaterial() != null) {
				modelIterator.iterateConceptosVendiblesFromOrden(crearAvisosModel.getOrdenDePublicacion(), montoTotalSinPromo, function(index, conceptoVendible, args) {
					montoTotalSinPromo = conceptoVendible.montoTotalSinPromo;
				});
			}

			var callerArray = [];

			callerArray.push(new CallBackObject({
				url:CrearAvisoServiceURL.VALIDATE_PROMOCION_365,
				staticObject : buildValidarPromocionDTO(promocionesAplicables,crearAvisosModel.getOrdenDePublicacion()),//promos
				successHandlerCallback : validarPromocionesHandler,
				errorHandlerCallBack : errorValidarPromocion,
				processCallBack: processCallBackValidarPromociones
			}));
			callerArray.push(new CallBackObject({
				url : CrearAvisoServiceURL.TASAR,
				successHandlerCallback : tasarHandler,
				processCallBack		 : processCallBackTasar,
				errorHandlerCallBack : defaultErrorHandler
			}));

			sequenceCallerUI.createPost(callerArray);

			if (crearAvisosModel.getTemplateTieneMaterial() != null && montoTotalSinPromo != null) {
				modelIterator.iterateConceptosVendiblesFromOrden(crearAvisosModel.getOrdenDePublicacion(), montoTotalSinPromo, function(index, conceptoVendible, args) {
					conceptoVendible.montoTotalSinPromo = montoTotalSinPromo;
				});
			}

			if (decoratorModel.getExpired()) {
				quitarPromocion365FromOrden();
				quitarPromocion365FromModel();
				quitarAtributoTarjeta365FromOrden();
				quitarAgrupadorAtributoAvisoTarjeta365FromModel();
			}
		};
		var errorValidarPromocion = function(data){
			quitarPromocion365FromOrden();
			quitarPromocion365FromModel();
			quitarAtributoTarjeta365FromOrden();
			quitarAgrupadorAtributoAvisoTarjeta365FromModel();
			defaultErrorHandler(data);
		}

		var errorValidarPromocion = function(data){
			quitarPromocion365FromOrden();
			quitarPromocion365FromModel();
			quitarAtributoTarjeta365FromOrden();
			quitarAgrupadorAtributoAvisoTarjeta365FromModel();
			defaultErrorHandler(data);
		}
		
		var buildValidarPromocionDTO = function(promocionesAplicables,ordenDePublicacion) {
			var validarPromocionDTO = new ValidarPromocionesDTO({
				captcha : new CaptchaDTO({
					hashValue				: $("#captcha365 input[name=captchaPromo365Hash]").val(),
					inputValue				: $("#captcha365 input[name=captchaPromo365]").val()
				}),
				promocionesAplicables	: promocionesAplicables,
				ordenPublicacion		: new OrdenDePublicacionCabeceraDTO(ordenDePublicacion)
			});

			return validarPromocionDTO;
		};

		var validarPromocionesHandler = function (data){

			var listaErrores = data.ROLResult.errors;
			var orden =data.ROLResult.object.ordenPublicacion;
			if (listaErrores === null || listaErrores.length === 0) {

				var aviso = orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
				var promociones = data.ROLResult.object.promocionesAplicables;
				var avisoPromocionList = [];
				if(promociones!=undefined){

					$.each(promociones, function(index, promocion){
						var avisoPromocion = new AvisoPromocionDTO({});
						avisoPromocion.promocion = promocion;
						avisoPromocionList.push(avisoPromocion);

					});
					modelIterator.iterateAvisosFromOrden(orden, {"avisoPromocionList":avisoPromocionList}, function(index, aviso, args) {
						aviso.avisoPromocion = args.avisoPromocionList;
					});

					if(isPromoEco(promociones)){
						orden  = armarEstructuraOrdenPromoEco(promociones,orden);
					}
				}

			} else {

				// si tiene errores le saco la promocion y el atributo agregado
				quitarPromocion365FromOrden();
				quitarPromocion365FromModel();
				quitarAtributoTarjeta365FromOrden();
				quitarAgrupadorAtributoAvisoTarjeta365FromModel();

				for ( var i = 0; i < listaErrores.length; i++) {
					// manejo de errores
					if (listaErrores[i].errorType === ROLErrorTypeConstants.VALIDATION) {
						$("#textInput365").addClass("warning");
						$("#errorTarjeta365").show();
						$("#errorTarjeta365").html(listaErrores[i].message);
						actualizarCaptcha365();
					}

					if (listaErrores[i].errorType === ROLErrorTypeConstants.SECURITY) {
						if (listaErrores[i].message === TraduccionSecurityError.VALIDATE_CAPTCHA) {
							model.mostrarCaptcha = true;
							muestraCaptcha365();
							actualizarCaptcha365();
						} else {
							marcarErrorCaptchaDistintas();
						}
					}

					if (listaErrores[i].errorType === ROLErrorTypeConstants.EXCEPTION) {
						alert(listaErrores[i].message);
					}
				}
			}
			return orden;
		};

		var processCallBackValidarPromociones = function(staticObject,processData){
			return staticObject;
		}



		var isPromoEco = function(promociones) {
			var promocionesEnModelo = promociones;
			var tienePromoEco = false;

			//if tiene una promo repiteSalida ==> es promo eco
			$.each(promocionesEnModelo, function(index, promocion){
				if( promocion.repiteSalida ){
					tienePromoEco = true;
				}
			});

			return tienePromoEco;
		};


		var armarEstructuraOrdenPromoEco = function(promociones,orden) {

			var avisoOriginal = orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			var promocionesEnModelo = promociones;
			var actualizarPromociones = true;

			//Si el usuario fue hasta la cotizacion y luego volvio al calendario (por el motivo que sea)
			//si no modifico las fechas, no deberia re-estructurar la orden
			if ( orden.conceptosVendibles.length === 1) {
				modelIterator.iterateAvisosFromOrden(orden, promocionesEnModelo, function(index, avisoOriginal, args) {
					$.each(args, function(index, promocion){
						$.each(avisoOriginal.avisoPromocion, function(index,avisoPromo){
							if (promocion.codigo == avisoPromo.promocion.codigo){
								actualizarPromociones = false;
								return;
							};
						});
					});
				});
			};

			if (actualizarPromociones) {
				//quito los conceptos vendibles de multiples fechas, vacio el item aviso original y cargo los nuevos
				var conceptosVendibles = orden.conceptosVendibles;
				conceptosVendibles.splice(1, conceptosVendibles.length-1);

				orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso = [];
				$.each(crearAvisosModel.getSelectedDates(), function(index, fecha){
					//creo el item aviso, cargo la fecha parseada y agrego el itemAviso
					var itemAviso = new ItemAvisoDTO({});
					itemAviso.numero = index;
					itemAviso.aviso = new AvisoDTO(avisoOriginal);
					itemAviso.aviso.fechaPedidoPublicacion = dateUtils.getDateParse(fecha);
					var avisoPromocion = [];
					$.each(promocionesEnModelo, function(index, promocion){
						var avisoPromo = new AvisoPromocionDTO({});
						avisoPromo.promocion = promocion;
						avisoPromocion.push(avisoPromo);
					});
					if (avisoPromocion.length > 0) {
						itemAviso.aviso.avisoPromocion = avisoPromocion;
					}
					orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso.push(itemAviso);
				});
			}
			return orden;
		};


		var initArray = function(args) {
			if (typeof args.array === "undefined") {
				args.array = [];
			}
		};

		var addOrUpdateAgrupadorAtributoAviso = function(args) {
			var agrupadoresAtributoAvisoEncontrados = $.grep(args.agrupadoresAtributoAviso,function(agrupadorAtributoAvisoIterado,indexAgrupadorAtributoAvisoIterado) {
				return args.agrupadorAtributoAviso.atributoAviso.codigo === agrupadorAtributoAvisoIterado.atributoAviso.codigo;
			});
			if (agrupadoresAtributoAvisoEncontrados.length === 0) {
				args.agrupadoresAtributoAviso.push(args.agrupadorAtributoAviso);
			} else if (agrupadoresAtributoAvisoEncontrados.length === 1) {
				agrupadoresAtributoAvisoEncontrados[0].atributoAviso.valor = args.agrupadorAtributoAviso.atributoAviso.valor;
			}
		};

		var tasarHandler = function(data) {

				var orden = data.ROLResult;
				var aviso = data.ROLResult.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
				var promociones = [];
	      		if(aviso.avisoPromocion !== undefined){
	      			$.each(aviso.avisoPromocion, function(indexPromociones,avisoPromo){
	      				promociones.push(avisoPromo.promocion);
	      			})
	      		}
	      		crearAvisosModel.setPromociones(promociones);
				crearAvisosModel.setOrdenDePublicacion(orden);
				mostrarPrecio();
				$("#errorTarjeta365").hide();
				$("#input365").hide();
				$("#ok365").show();
				$("#ok365").find(".numTarjeta365").text("..." + tresNumTarjeta);
				ocultaCaptcha365();
				cerrarPromo365();
				analizarLimiteCotizacion();

		};

		var processCallBackTasar = function(staticObject,data){
			return data;
		}

		var quitarPromocion365FromOrden = function() {
			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {},
				function(index, aviso, args){
					quitarPromocionFromAviso(aviso.avisoPromocion,Promocion365Constants.CODIGO_PROMOCION_365);
				}
			);
		};

		var quitarPromocion365FromModel = function() {
			crearAvisosModel.setTarjeta365("");
			quitarPromocionFromList(crearAvisosModel.getPromociones(),Promocion365Constants.CODIGO_PROMOCION_365);
		};

		var quitarPromocionFromList = function(promociones, codigoPromocion) {
			if (promociones) {
				$.each(promociones, function(index, promocion) {
					if (promocion.codigo === codigoPromocion) {
						promociones.splice(index, 1);
					}
				});
			}
		};

		var quitarPromocionFromAviso = function(avisosPromocion, codigoPromocion) {
			if (avisosPromocion) {
				$.each(avisosPromocion, function(index, avisoPromocion) {
					if (avisoPromocion.promocion.codigo === codigoPromocion) {
						avisosPromocion.splice(index, 1);
					}
				});
			}
		}

		var quitarAtributoTarjeta365FromOrden = function() {
			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {},
				function(index, aviso, args){
					quitarAtributoTarjeta365FromList(aviso.atributosAviso,Promocion365Constants.CODIGO_ATRIBUTO_PROMOCION_365);
				}
			);
		};

		var quitarAgrupadorAtributoAvisoTarjeta365FromModel = function() {
			quitarAgrupadorAtributoTarjeta365FromList(crearAvisosModel.agrupadoresAtributoAviso,Promocion365Constants.CODIGO_ATRIBUTO_PROMOCION_365);
		};

		var quitarAtributoTarjeta365FromList = function(atributosAviso,codigoAtributoAviso) {
			if (atributosAviso) {
				$.each(atributosAviso, function(index, atributoAviso) {
					if (atributoAviso.codigo === codigoAtributoAviso) {
						atributosAviso.splice(index, 1);
					}
				});
			}
		};

		var quitarAgrupadorAtributoTarjeta365FromList = function(agrupadoresAtributoAviso, codigoAtributoAviso) {
			if (agrupadoresAtributoAviso) {
				$.each(agrupadoresAtributoAviso,function(index, agrupadorAtributoAviso) {
					if (agrupadorAtributoAviso.atributoAviso.codigo === codigoAtributoAviso) {
						agrupadoresAtributoAviso.splice(index,1);
					}
				});
			}
		};

		var marcarErrorCaptchaDistintas = function() {
			$("#captchaPromo365").addClass("warning");
			$("#errorCaptchaPromo365").show();
		};

		var obtenerPromocion = function(arg) {
			var promocion;
			$.each(crearAvisosModel.getConfiguracionesPromocionPantalla(),function(index, configuracionPromocionPantalla) {
				if (configuracionPromocionPantalla.promocion.codigo === arg) {
					promocion = configuracionPromocionPantalla.promocion;
				}
			});
			return promocion;
		};


		var mostrarPantalla = function(args) {
			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			model.tienePromocionGratuita = false;
			var pantallaGratuita = $("#paso8-AvisoGratuito");
			var pantallaPagar = $("#paso7-ComoPagas");
			var pantallaAvisoPago = $("#paso8-AvisoPago");
			var datosObligatorios = $("#datosObligatorios");
			agregaPaso();

			if (aviso.avisoPromocion !== null && aviso.avisoPromocion !== undefined && aviso.avisoPromocion.length > 0) {
				$.each(aviso.avisoPromocion, function(index, avisoPromo) {
					if (!model.tienePromocionGratuita && avisoPromo.promocion.gratuita) {
						model.tienePromocionGratuita = avisoPromo.promocion.gratuita;
					}
				});
			}
			// Muestro y oculto componentes segun corresponda
			if (crearAvisosModel.esOrdenDePublicacionPagoAcreditado()){
				$(pantallaAvisoPago)[0].style.display = "block";
				$(pantallaAvisoPago)[0].style.visibility = "visible";
				$(pantallaGratuita)[0].style.display = "none";
				$(pantallaGratuita)[0].style.visibility = "hidden";
				$(pantallaPagar)[0].style.display = "none";
				datosObligatorios.appendTo("#boxDatosObligatoriosPago").show();
				doOnComplete({});
			} else if (model.tienePromocionGratuita) {
				$(datosObligatorios)[0].style.display = "block";
				$(pantallaGratuita)[0].style.display = "block";
				$(pantallaGratuita)[0].style.visibility = "visible";
				$(pantallaAvisoPago)[0].style.display = "none";
				$(pantallaAvisoPago)[0].style.visibility = "hidden";
				$(pantallaPagar)[0].style.display = "none";
				datosObligatorios.appendTo("#boxDatosObligatoriosGratuito").show();
				doOnComplete({});
			} else {
				$(pantallaGratuita)[0].style.display = "none";
				$(pantallaGratuita)[0].style.visibility = "hidden";
				$(pantallaAvisoPago)[0].style.display = "none";
				$(pantallaAvisoPago)[0].style.visibility = "hidden";
				$("#paso1-Cat").hide();
				$(pantallaPagar)[0].style.display = "block";
				datosObligatorios.appendTo("#boxDatosObligatorios").show();
				doOnComplete({});
			}

		};

		var verficarExistenDatosOrden = function(){

			var tieneAtributo365 = false;
			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {},
					function(index, aviso, args){
						if (aviso.atributosAviso!==undefined &&aviso.atributosAviso!==null) {
							$.each(aviso.atributosAviso, function(index, atributoAviso) {
								if (atributoAviso.codigo === Promocion365Constants.CODIGO_ATRIBUTO_PROMOCION_365) {
									tieneAtributo365 = true;
								}
							});
						};
				}
			);

			return tieneAtributo365;
		};

		var validarPromocion365FromOrden = function(){

			var valorInputTarjeta365 = $("#textInput365").val();
			var codigoPromocion = $(component).data("promocion");
			var promocion365 = obtenerPromocion(codigoPromocion);

			var atributoAviso = new AtributoAvisoDTO({
				"codigo" : Promocion365Constants.CODIGO_ATRIBUTO_PROMOCION_365,
				"valor" : crearAvisosModel.getTarjeta365()
			});
			var agrupadorAtributoAviso = new AgrupadorAtributoAvisoDTO({
				"atributoAviso" : atributoAviso,
				"step" : index
			});

			validarPromocion({
				"agrupadorAtributoAviso" : agrupadorAtributoAviso,
				"promocion" : promocion365
			});
		};

		var continueDoOnExit = function(){
			validateEmptyTelefonoFromOrden();
			crearAvisosModel.getOrdenDePublicacion().codigoTipoTarjeta = crearAvisosModel.getCodigoGATEWAYSeleccionado();
			pagarYGuardarOrdenPublicacion();
		};

		var validarDatosContacto = function(){

			if ((crearAvisosModel.getPermisoAtributoEmail() != null &&
				 crearAvisosModel.getPermisoAtributoTelefono() != null) &&
				((crearAvisosModel.getPermisoAtributoEmail().publicable &&
				crearAvisosModel.getPermisoAtributoEmail().obligatorio &&
				validarEmail() == "VALIDO") ||
			   (crearAvisosModel.getPermisoAtributoEmail().publicable &&
				!crearAvisosModel.getPermisoAtributoEmail().obligatorio &&
				(validarEmail() == "VALIDO" || validarEmail() == "VACIO")) ||
			   (!crearAvisosModel.getPermisoAtributoEmail().publicable &&
			    validarEmail() == "VACIO")) &&
				((crearAvisosModel.getPermisoAtributoTelefono().publicable &&
				crearAvisosModel.getPermisoAtributoTelefono().obligatorio &&
				validarTelefono() == "VALIDO") ||
			   (crearAvisosModel.getPermisoAtributoTelefono().publicable &&
				!crearAvisosModel.getPermisoAtributoTelefono().obligatorio &&
				(validarTelefono() == "VALIDO" || validarTelefono() == "VACIO")) ||
			   (!crearAvisosModel.getPermisoAtributoTelefono().publicable &&
				 validarTelefono() == "VACIO")))
			{
				return true;
			} else {
				return false;
			}
		};

		var validarEmail = function(){
			var result = "";
			var emailVal = ui.campoContactoEmail.val();
			if (emailVal != ""){
				var emailReg = /^([\w-\.]+@{1}([\w-]+\.)+[\w-]{2,4})?$/;
				if(emailReg.test(emailVal)){
					result = "VALIDO";
				} else {
					result = "INVALIDO";
				}
			} else {
				result = "VACIO";
			}
			return result;
		};

		var validarTelefono = function(){
			var result = "";
			var codigoAreaVal = ui.campoContactoCodigoArea.val();
			var telefonoVal = ui.campoContactoTelefono.val();
			if (codigoAreaVal != "" || telefonoVal != ""){
				if (codigoAreaVal.length > 1 && telefonoVal.length > 5){
					result = "VALIDO";
				} else {
					result = "INVALIDO";
				}
			} else {
				result = "VACIO";
			}
			return result;
		};

		var keyUpInputContactoCodigoAreaHandler = function(event) {
			commitDatoContactoTelefono({})
			doOnComplete({});
		};

		var keyUpInputContactoTelefonoHandler = function(event) {
			commitDatoContactoTelefono({})
			doOnComplete({});
		};

		var keyUpInputContactoEmailHandler = function(event) {
			commitDatoContactoEmail();
			doOnComplete({});
		};


		var buildPermisoAtributoSearchDTO = function (args){

			var result = new PermisoAtributoDTO({});

			result.codigoAtributo 			= args.codigoAtributo;
			result.fechaVigencia 			= crearAvisosModel.getSelectedDates() ? crearAvisosModel.getSelectedDates()[0] : null;
			result.codigoCanalEntrada 		= crearAvisosModel.getCodigoCanalEntrada();
			result.codigoTipoOperacion 		= crearAvisosModel.getTipoOperacion().codigo;
			result.codigoProductoComercial 	= crearAvisosModel.getCodigoProductoComercialDestaque() ? crearAvisosModel.getCodigoProductoComercialDestaque() : crearAvisosModel.getCodigoProductoComercial();
			result.codigoProducto 			= crearAvisosModel.getCodigoProducto();
			result.codigoNivelEstructura 	= crearAvisosModel.getCodigoNivelEstructura();

			return result;
		};

		var obtenerPermisoAtributoEmail = function() {

			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_PERMISO_ATRIBUTO,
				dataObject : buildPermisoAtributoSearchDTO({"codigoAtributo" : AtributoCIDConstants.MAIL}),
				successHandlerCallback : obtenerPermisoAtributoEmailHandler,
				errorHandlerCallback : defaultErrorHandler
			});

		};

		var obtenerPermisoAtributoTelefono = function() {

			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_PERMISO_ATRIBUTO,
				dataObject : buildPermisoAtributoSearchDTO({"codigoAtributo" : AtributoCIDConstants.TELEFONO}),
				successHandlerCallback : obtenerPermisoAtributoTelefonoHanlder,
				errorHandlerCallback : defaultErrorHandler
			});

		};

		var showTituloDatosDeContacto = function (){

			if (crearAvisosModel.getPermisoAtributoEmail() != null &&
				crearAvisosModel.getPermisoAtributoTelefono() != null &&
			    !crearAvisosModel.getPermisoAtributoEmail().publicable &&
			    !crearAvisosModel.getPermisoAtributoTelefono().publicable){
				$("#boxDatosObligatorios").hide();
			} else {
				$("#boxDatosObligatorios").show();
			}
		};

		var showLeyendaObligatoriedad = function (){
			if (crearAvisosModel.getPermisoAtributoEmail() != null &&
				crearAvisosModel.getPermisoAtributoTelefono() != null &&
			   ((crearAvisosModel.getPermisoAtributoEmail().publicable &&
				crearAvisosModel.getPermisoAtributoEmail().obligatorio) ||
			   (crearAvisosModel.getPermisoAtributoTelefono().publicable &&
				crearAvisosModel.getPermisoAtributoTelefono().obligatorio))){
				$("#camposObligatoriosContacto").show();
			} else {
				$("#camposObligatoriosContacto").hide();
			}
		}



		var obtenerPermisoAtributoEmailHandler = function (data){
			var atributoCID = new AtributoCIDDTO(data.ROLResult);
			crearAvisosModel.setPermisoAtributoEmail(atributoCID.permisoAtributo);
			if (atributoCID.permisoAtributo.publicable){
				$(".boxInpEmail").show();
				if (atributoCID.permisoAtributo.obligatorio){
					$("#lblRequiredEmail").show();
				} else {
					$("#lblRequiredEmail").hide();
				}
			} else {
				$(".boxInpEmail").hide();
			}
			showTituloDatosDeContacto();
			showLeyendaObligatoriedad();
		};



		var obtenerPermisoAtributoTelefonoHanlder = function (data){
			var atributoCID = new AtributoCIDDTO(data.ROLResult);
			crearAvisosModel.setPermisoAtributoTelefono(atributoCID.permisoAtributo);
			if (atributoCID.permisoAtributo.publicable){
				$(".boxInpTelefono").show();
				if (atributoCID.permisoAtributo.obligatorio){
					$("#lblRequiredTelefono").show();
				} else {
					$("#lblRequiredTelefono").hide();
				}
			} else {
				$(".boxInpTelefono").hide();
			}
			showTituloDatosDeContacto();
			showLeyendaObligatoriedad();
		};

		// ------------------------------------------------
		// common interface ------------------------------
		// ------------------------------------------------

		var accedida = false;

		var index = 8;

		var doOnObserver = args.doOnObserver;

		var ui = {
			pagosContainer			: $("#pagos"),
			precioContainer			: $("#precioPago"),
			popup					: null,
			datosPagoContainer		: $("#datosPago"),
			mensajeAlertaLimite		: $("#divAlertaLimiteCotizacion"),
			divCargaDireccion		: $("#divCargaDireccion"),
			divSeleccionPais		: $("#pagarPais"),
			divSeleccionProvincia	: $("#pagarProvincia"),
			divSeleccionLocalidad	: $("#pagarLocalidad"),

			campoContactoCodigoArea	: $("#inputAreaAviso"),
			campoContactoTelefono	: $("#inputTelefonoAviso"),
			campoContactoEmail		: $("#inputEmailAviso"),

			campoCalle				: $("#pagarCalle"),
			campoNroPuerta			: $("#pagarNumPuerta"),
			campoPiso				: $("#pagarPiso"),
			campoDepto				: $("#pagarDepto"),
			campoCodPostal			: $("#pagarCp"),

			promocionesContainer	: $("#promociones"),
			editarAvisoGratis		: $("#editarAvisoGratis"),

			footer					: $('#footerRol')
		};

		var model = {
			montoAviso : null,
			limiteCotizacionExcedido : false,
			cargoDatosDireccionCapturador : false,
			mostrarCaptcha : false,
			tienePromocionGratuita : false
		};

		var generateTag = function() {
			decoratorModel.setA2("seleccion-tarjeta");
			var area = decoratorModel.getA1() + decoratorModel.getA2();
			gChangeTagName(area);
		};

		var doOnEnter = function(args) {

			showBreadcrum('PAGO');
			showPanelSeleccionado('PAGO');

			mostrarPrecio();
			analizarLimiteCotizacion();
			getIntentosPromocion365();
			obtenerPermisoAtributoEmail();
			obtenerPermisoAtributoTelefono();
			crearAvisosModel.setOrdenDepublicacionHistory(new OrdenDePublicacionCabeceraDTO(crearAvisosModel.getOrdenDePublicacion()));
			if (!accedida || !verficarExistenDatosOrden() ) {
				if(!accedida){
					initPopUp365Cargada();
					initDatosDeContacto();
					commitDatoContactoEmail();
				}
				ui.pagosContainer.empty();
				ui.promocionesContainer.empty();
				obtenerTarjetasDisponibles();
				mostrarPromociones();
				accedida = true;
			}
			// accedida o no ==> miro si tiene promo 365 cargada para mostrar
			checkTarjeta365CargadaDoOnLoad();
			bindUIContacto({});
			if(crearAvisosModel.getTarjeta365() != undefined && crearAvisosModel.getTarjeta365() != null && crearAvisosModel.getTarjeta365() != "" && !verficarExistenDatosOrden()){
				$("#textLink365").parent().hide();
				$("#input365").show();
				$("#btnInput365").addClass("disabledBtn");
				if (Detectizr.device.browser === "ie") {
					$("#btnInput365").removeAttr("onclick");
				}
				$("#textInput365").on("keyup", habilitarBoton365);
				$("#textInput365").on("keypress", validateTarjeta365);
				$("#textInput365").on("contextmenu cut copy paste drag drop",function() {
					return false;
				});
				if (model.mostrarCaptcha) {
					muestraCaptcha365();
				}
				$("#textInput365").val(crearAvisosModel.getTarjeta365());
				habilitarBoton365();
			}
			mostrarPantalla();
			doOnComplete({});
			generateTag();
		};

		var doOnExit = function(args) {

			if (decoratorModel.getUsuario() !== null && decoratorModel.getCapturador() !== null) {

				if ( args.event === StateEvents.NEXT_FOOTER ||
						args.event === StateEvents.NEXT_FOOTER_EDIT ) {

					// si limite de cotizacion activado ==> guardo direccion
					if (model.limiteCotizacionExcedido) {
						var domicilioFacturacion = crearDomicilioAviso();

						// guardarlo en el capturador y en la orden
						decoratorModel.getCapturador().domicilio = domicilioFacturacion;
						decoratorModel.setCookieCapturador(decoratorModel.getCapturador());
						crearAvisosModel.getOrdenDePublicacion().domicilio = domicilioFacturacion;

						// updateCapturador - salva la direccion cargada o la
						// updatea
						saveUpdateDireccionAnuncianteHUB(domicilioFacturacion);
					}

					if(!datos365Completos()){
						$('#popUp365Cargada').modal('show');
					}
					else{
						continueDoOnExit();
					}
				}

			}
		};

		var doOnError = function(args) {

		};

		var doOnCancel = function(args) {
			accedida = false;
			model.montoAviso = null;
			model.limiteCotizacionExcedido = false;
			model.cargoDatosDireccionCapturador = false;
			model.mostrarCaptcha = false;
			quitarPromocion365FromOrden();
			quitarPromocion365FromModel();
			quitarAtributoTarjeta365FromOrden();
			quitarAgrupadorAtributoAvisoTarjeta365FromModel();
			ui.pagosContainer.empty();
			ui.promocionesContainer.empty();
		};

		var doOnChange = function(args) {
			doOnCancel(args);
		};

		var doOnShow = function(args) {
			// implements.
		};

		var doOnComplete = function(args) {
			// Evaluate Complete
			if (isComplete(args)) {
				doOnObserver({"eventEnabled" : StateEvents.NEXT_ENABLED});
			} else {
				doOnObserver({"eventEnabled" : StateEvents.NEXT_DISABLED});
			}
			if (model.tienePromocionGratuita || crearAvisosModel.esOrdenDePublicacionPagoAcreditado()) {
				doOnObserver({"eventsTransform" : [ StateEvents.NEXT_TO_ACCEPT ]});
			} else {
				doOnObserver({"eventsTransform" : [ StateEvents.NEXT_TO_PAY ]});
			}
		};

		var bindUIContacto = function(args){
			// Eventos para los datos de contacto:
			ui.campoContactoCodigoArea.on("keyup", keyUpInputContactoCodigoAreaHandler);
			ui.campoContactoTelefono.on("keyup", keyUpInputContactoTelefonoHandler);
			ui.campoContactoEmail.on("keyup", keyUpInputContactoEmailHandler);
			ui.campoContactoCodigoArea.on("contextmenu cut copy paste drag drop", function() {
				return false;
			});
			ui.campoContactoTelefono.on("contextmenu cut copy paste drag drop", function() {
				return false;
			});
			ui.campoContactoEmail.on("contextmenu cut copy paste drag drop", function() {
				return false;
			});
		}

		var bind = function(args) {
			ui.editarAvisoGratis.on("click", editarAvisoGratis);
		};

		var unbind = function(args) {
			ui.editarAvisoGratis.off("click");
		};

		var seleccionoTarjeta = function() {
			var haySeleccion = false;
			if (crearAvisosModel.tarjetas !== undefined && crearAvisosModel.tarjetas !== null) {
				$.each(crearAvisosModel.tarjetas, function(index, tarjeta) {
					if ($("#" + tarjeta.codigoGATEWAY).prop("checked")) {
						haySeleccion = true;
					}
				});
			}
			return haySeleccion;
		};

		var datos365Completos = function(){
			var completo = true;
			if($("#textInput365").is(":visible") && $("#textInput365")[0].value.trim().length > 0){
				completo = false;
			}

			return completo


		}

		var isComplete = function(args) {

			var completo = true;

			if (!model.tienePromocionGratuita && !crearAvisosModel.esOrdenDePublicacionPagoAcreditado()) {

				if (!seleccionoTarjeta() ) {
					completo = false;
				}

				if (model.limiteCotizacionExcedido && !completoDireccion()) {
					completo = false;
				}

			}

			if (!validarDatosContacto()){
				completo = false;
			}

			return completo;
		};

		var notifyChange = function(args) {

		};



		var agregaPaso = function(){
			$(".infoPaso").remove();
			$("#MyWizard .steps").append("<li class='infoPaso'>5/5</li>");
		}

		var doOnLoad = function(args) {
			generateTag();
			mostrarPantalla();
			obtenerTarjetasDisponiblesDoOnLoad();
			obtenerPermisoAtributoEmail();
			obtenerPermisoAtributoTelefono();
			mostrarPrecio();
			setDatosContactoFromOrden();
			bindUIContacto();
			analizarLimiteCotizacion();
			getIntentosPromocion365();
			mostrarPromocionesDoOnLoad();
			accedida = true;
			doOnComplete();
			agregaPaso();
		};

		var obtenerTarjetasDisponiblesDoOnLoad = function() {
			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_TARJETAS_PAGO,
				dataObject : new TarjetaPagoSearchDTO(crearAvisosModel.getCodigoCanalEntrada()),
				successHandlerCallback : obtenerTarjetasDisponiblesHandlerDoOnLoad,
				errorHandlerCallback : defaultErrorHandler
			});

		};

		var obtenerTarjetasDisponiblesHandlerDoOnLoad = function(args) {

			crearAvisosModel.tarjetas = args.tarjetas;

			var template = Handlebars.compile(CrearAvisosTemplates.selectorTarjetas);
			var context = {tarjetasPago : crearAvisosModel.tarjetas};
			var html = template(context);

			ui.pagosContainer.append(html);
			$("#" + crearAvisosModel.getCodigoGATEWAYSeleccionado()).prop("checked", true);

		};

		var doOnExitScreen = function(args) {

		};

		var getAccedida = function(args) {

		};

		// ------------------------------------------------
		// public interface ------------------------------
		// ------------------------------------------------

		return {

			doOnEnter			: doOnEnter,
			doOnExit			: doOnExit,
			doOnError			: doOnError,
			doOnCancel			: doOnCancel,
			doOnChange			: doOnChange,
			doOnShow			: doOnShow,
			doOnComplete		: doOnComplete,
			bind				: bind,
			unbind				: unbind,
			isComplete			: isComplete,
			notifyChange		: notifyChange,
			doOnLoad			: doOnLoad,
			doOnExitScreen		: doOnExitScreen,
			getAccedida			: getAccedida

		};

	};

})();
