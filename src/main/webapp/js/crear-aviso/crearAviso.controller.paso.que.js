/**
 * author: csantos version: 1.0.0
 * Funciones del paso Que de Crear Aviso
 */

// -----------------------------------------------------------------------------
// StateStep1Creacion ---------------------------------------------------------
// -----------------------------------------------------------------------------

var StateStep1Creacion = (function() {

	return function(args) {

		// ------------------------------------------------
		// global interface ------------------------------
		// ------------------------------------------------

		gOnclickBoton1PerdidaDatosHandler = function(args) {
			$("#popUpPerdidaDatos").modal("hide");
		};

		gOnclickBoton2PerdidaDatosHandler = function(args) {
			$("#popUpPerdidaDatos").modal("hide");
			if(model.tipoDeseleccion === DeseleccionConstants.TIPO_DESELECCION_CATEGORIA){
				deseleccionarCategoriaHandler();
			}else if(model.tipoDeseleccion === DeseleccionConstants.TIPO_DESELECCION_BIEN){
				deseleccionarBienHandler();
			}
		};

		gOnclickClosePopoverCategoria = function() {
			$("#divCategoria").popover("hide");
		};

		gOnkeyupFilterItemsHandler = function(event) {

			var listaAFiltrar = "#"+$(event.target).data('id-lista')+" li div";
			var inputFiltro = "#"+event.target.id;

			$.each($(listaAFiltrar),function(index, value) {
				var visible = false;
				var indice = value;

				if ($(value).data("descripcion-clase").toString().toUpperCase().indexOf($(inputFiltro).val().toUpperCase()) === -1) {
					$(value).css("display" , "none");
					$(value).parent().css("display" , "none");
				} else {
					$(value).css("display","block");
					$(value).parent().css("display" , "inline-block");
					visible = true;
				}

				if (visible) {
					$(indice).css("display" , "block");
				} else {
					$(indice).css("display" , "none");
				}
			});
		};



		gOnclickDeseleccionarTipoOperacionHandler = function(component) {
			$.blockUI({
				message : null,
				overlayCSS : {
					backgroundColor : "transparent"
				}
			});
			setTimeout($.unblockUI, 400);
			// deshabilito siguiente y oculto popover
			model.habilitado = false;
			gOnclickCloseTerminastePopoverHandler();
			$("#divOperacion").show();

				// RESTO DE NAVEGADORES

				// Inicia la animacion del boton al desseleccionar
			var posicionTop = parseInt($("#tipoOperacionSeleccionada").attr("data-posicion-top"), "");
			var posicionLeft = parseInt($("#tipoOperacionSeleccionada").attr("data-posicion-left"), "");
			//$(component).parent().removeClass("CatBox");

			var posicionComponente = $("#tipoOperacionSeleccionada").position();

			$("#tipoOperacionSeleccionada").css({
				"position" : "absolute",
				"top" : posicionComponente.top,
				"left" : posicionComponente.left
			}).animate({
				// Vuelo
				"top" : posicionTop,
				"left" : posicionLeft
			},{
				duration: 400,
				complete: function() {
					$("#tipoOperacionSeleccionada").remove();
					$("#tipoOperacionBox").removeClass("OperacionBoxSeleccionado").html("<span class='inner-desc'>OPERACION</span>");
					$("#divOperacion").show().removeClass("hidden");
				}
			});

			crearAvisosModel.setTipoOperacion(null);
			ui.tituloPaso.html(txt.tituloPasoOperacion);
			ui.tituloPaso.show();
			doOnComplete({});
		};

		gOnclickSeleccionarTipoOperacionHandler = function(component) {
			$.blockUI({
				message			: null,
				overlayCSS		: {
					backgroundColor : "transparent"
				}
			});
			setTimeout($.unblockUI, 400);
			$(component).addClass("CatBox");

			// agrego los datos
			var tipoOperacion = new TipoOperacionDTO({
				"codigo"		: $(component).data("codigoOperacion"),
				"descripcion"	: $(component).data("descripcionOperacion")
			});

			crearAvisosModel.setTipoOperacion(tipoOperacion);

			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {
				"tipoOperacion" : tipoOperacion
			}, function(index, aviso, args) {
				aviso.tipoOperacion = args.tipoOperacion;
			});

			if(Detectizr.device.type === "mobile" || Detectizr.device.type === "tablet"){
				ui.tipoOperacionBox.empty();
				renderHandlebars(
					CrearAvisosTemplates.tipoOperacionSeleccionada, {
						codigo : $(component).data("codigoOperacion"),
						descripcion : $(component).data("descripcionOperacion")
					}, ui.tipoOperacionBox);

				renderOperaciones();

			} else {
				ui.tipoOperacionBox.empty();
				renderHandlebars(
					CrearAvisosTemplates.tipoOperacionSeleccionada, {
						codigo : $(component).data("codigoOperacion"),
						descripcion : $(component).data("descripcionOperacion")
					}, ui.tipoOperacionBox);

				$("#tipoOperacionSeleccionada").parent().addClass("OperacionBoxSeleccionado");
				ui.tipoOperacionBox.removeClass("hide");
				renderOperaciones();
				ui.tituloPaso.html(txt.tituloPasoOperacion);
			}
		};

		var renderOperaciones = function(){
			$("#divOperacion").hide();
			model.habilitado = true;
			doOnComplete({});
			ui.btnWizardNext.trigger("click");
		};

		gOnclickDeseleccionarBienHandler = function(component) {
			model.tipoDeseleccion = DeseleccionConstants.TIPO_DESELECCION_BIEN;
			model.bienComponent = component;
			$("#popUpPerdidaDatos").modal("show");
		};

		deseleccionarBienHandler = function() {
			var component = model.bienComponent;

			$.blockUI({
				message : null,
				overlayCSS : {
					backgroundColor : "transparent"
				}
			});
			setTimeout($.unblockUI, 400);
			// deshabilito siguiente y oculto popover
			model.habilitado = false;
			gOnclickCloseTerminastePopoverHandler();
			$($("#divOperacion")[0]).remove();

			var operacionSeleccionada = document.getElementById("tipoOperacionSeleccionada");
			// if tipo estaba seleccionado
			if (operacionSeleccionada !== null) {
				$(operacionSeleccionada).remove();
				ui.tipoOperacionBox[0].innerHTML += "<span class='inner-desc'>" + label.OPERACION + "</span>";
				$(ui.tipoOperacionBox[0]).removeClass("OperacionBoxSeleccionado");
			}
			ui.tipoOperacionBox.addClass("hidden");

			// Inicia la animacion del boton al desseleccionar
			var posicionTop = parseInt($("#bienSeleccionado").attr("data-posicion-top"), "");
			var posicionLeft = parseInt($("#bienSeleccionado").attr("data-posicion-left"), "");

			var posicionComponente = $("#bienSeleccionado").position();

			$("#bienSeleccionado").css({
				"position" : "absolute",
				"top" : posicionComponente.top,
				"left" : posicionComponente.left
			}).animate({
				// Vuelo
				"top" : posicionTop,
				"left" : posicionLeft
			},{
				duration: 400,
				complete: function() {
					$("#bienSeleccionado").remove();
					$("#bienBox").removeClass("BienBoxSeleccionado").html("<span class='inner-desc'>BIEN</span>");
					$("#divBien").show().removeClass("hidden");
				}
			});

			setTimeout(function(){
				crearAvisosModel.setClase(null);
				crearAvisosModel.setTipoOperacion(null);
				doOnComplete({});
				ui.tituloPaso.html(txt.tituloPasoBien);
				ui.tituloPaso.show();
			}, 500);
		};

		gOnclickSeleccionarBienHandler = function(component) {
			$.blockUI({
				message : null,
				overlayCSS : {
					backgroundColor : "transparent"
				}
			});
			setTimeout($.unblockUI, 400);
			//csantos: Se detecta si es un dispositivo tablet o mobile, para habilitar el vuelo o no
			if(Detectizr.device.type === "mobile" || Detectizr.device.type === "tablet"){
				ui.bienBox.empty();
				renderHandlebars(CrearAvisosTemplates.bienSeleccionado, {
					descripcion : $(component).data("descripcionClase"),
					descripcionBien : $(component).data("descripcionTrim")
				}, ui.bienBox);
				renderBienes($(component));

			} else { // VERSION DESKTOP

				var elemento = $(component);
				setTimeout(function(){$("#divCategoria").popover("hide");},40);
				ui.bienBox.empty();
				var posicion = elemento.offset();
				renderHandlebars(CrearAvisosTemplates.bienSeleccionado, {
					descripcion : $(component).data("descripcionClase"),
					descripcionBien : $(component).data("descripcionTrim")
				}, ui.bienBox);
				$(this).css({"position": "absolute"});
				$("#bienSeleccionado").parent().addClass("BienBoxSeleccionado");
				$("#bienSeleccionado").css({"position": "absolute"});
				var posicionBienBox = $("#bienSeleccionado").offset();
				$("#bienSeleccionado").attr({"data-posicion-top": posicion.top, "data-posicion-left": posicion.left});
				$("#bienSeleccionado").css({
					"top" : posicion.top,
					"left" : posicion.left,
					"zIndex" : ui.bienZindexFin
				}).delay(400).animate({
					"top" : posicionBienBox.top,
					"left" : posicionBienBox.left
				}, {
					duration: 400,
					complete: function() {
						$("#bienSeleccionado").removeAttr('style');
						//$("#bienSeleccionado span").html(textoCortado);
					}
				});
				setTimeout(function() {renderBienes(elemento);}, 1000);
			}
			ui.bienBox.removeClass("hidden");
			ui.tipoOperacionBox.removeClass("hidden");
		};



		var renderBienes = function(component){
			ui.tipoOperacionBox.removeClass("hidden");
			ui.bienBox.removeClass("hidden");
			ui.tituloPaso.html(txt.tituloPasoOperacion);
			$("#divBien").hide();
			crearAvisosModel.setClase(new ClaseDTO({
				"codigo" : $(component).data("codigoClase"),
				"descripcion" : $(component).data("descripcionClase")
			}));

			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(),
				{"codigoClase" : $(component).data("codigoClase")},
				function(index, aviso, args) {aviso.codigoClase = args.codigoClase;});

			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_TIPOS_OPERACION,
				dataObject : getTipoOperacionSearchDTO("ROL", $(component).data("codigoClase")),
				successHandlerCallback : setTiposOperacionPantallaHandler,
				errorHandlerCallback : defaultErrorHandler
			});
		}

		gOnclickSeleccionarCategoriaHandler = function(component) {
			$.blockUI({
				message : null,
				overlayCSS : {
					backgroundColor : "transparent"
				}
			});
			setTimeout($.unblockUI, 400);
			//csantos: Se detecta si es un dispositivo tablet o mobile, para habilitar el vuelo o no
			if(Detectizr.device.type === "mobile" || Detectizr.device.type === "tablet"){

				$(component).addClass("CatBox");
				ui.categoriaBox.empty();
				renderHandlebars(CrearAvisosTemplates.categoriaSeleccionada, {descripcion : $(component).data("descripcionClase")},ui.categoriaBox);
				renderCategorias($(component));
				setTimeout(function(){$("#divCategoria").popover("hide");},40);


			}else{

				var elemento = $(component);
				setTimeout(function(){$("#divCategoria").popover("hide");},40);
				ui.categoriaBox.empty();
				var posicion = elemento.offset();

				renderHandlebars(CrearAvisosTemplates.categoriaSeleccionada, {descripcion : $(component).data("descripcionClase")},ui.categoriaBox);
				$("#categoriaSeleccionada").parent().addClass("CatBoxSeleccionado");
				$(this).css({"position": "absolute"});
				$("#categoriaSeleccionada").css({"position": "absolute"});
				var posicionCategoriaBox = $("#categoriaSeleccionada").offset();
				$("#categoriaSeleccionada").attr({"data-posicion-top": posicion.top, "data-posicion-left": posicion.left});
				$("#categoriaSeleccionada").css({
					"top" : posicion.top,
					"left" : posicion.left,
					"zIndex" : ui.categoriaZindexFin
				}).delay(400).animate({
					"top" : posicionCategoriaBox.top,
					"left" : posicionCategoriaBox.left
				}, {
					duration: 400,
					complete: function() {
						$("#categoriaSeleccionada").removeAttr('style');
						ui.bienBox.removeClass("hidden");
					}
				});
				setTimeout(function() {renderCategorias(elemento);}, 1000);
			}
		};

		var renderCategorias = function(component){

			crearAvisosModel.setFamilia(new FamiliaDTO({
				"codigo"		: $(component).data("codigoClase"),
				"descripcion"	: $(component).data("descripcionClase")
			}));

			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {
				"codigoFamilia" : $(component).data("codigoClase")
			}, function(index, aviso, args) {
				aviso.codigoFamilia = args.codigoFamilia;
			});

			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_BIENES,
				dataObject : getClaseSearchDTO($(component).data("codigoClase"), "ROL"),
				successHandlerCallback : setBienesPantallaHandler,
				errorHandlerCallback : defaultErrorHandler
			});
			ui.tituloPaso.html(txt.tituloPasoBien);
			$("#divCategoria").addClass("hidden");

		};

		gOnclickDeseleccionarCategoriaHandler = function(component) {
			model.tipoDeseleccion = DeseleccionConstants.TIPO_DESELECCION_CATEGORIA;
			model.categoriaComponent = component;
			$("#popUpPerdidaDatos").modal("show");
		};

		deseleccionarCategoriaHandler = function() {

			var component = model.categoriaComponent;

			$.blockUI({
				message : null,
				overlayCSS : {
					backgroundColor : "transparent"
				}
			});
			setTimeout($.unblockUI, 400);
			// deshabilito siguiente y oculto popover
			model.habilitado = false;
			gOnclickCloseTerminastePopoverHandler();

			// Inicia la animacion del boton al desseleccionar
			var posicionTop = parseInt($(component).attr("data-posicion-top"), "");
			var posicionLeft = parseInt($(component).attr("data-posicion-left"), "");
			var posicionComponente = $(component).position();
			$(component).css({
				"position" : "absolute",
				"top" : posicionComponente.top,
				"left" : posicionComponente.left
			});
			$(component).animate({
				// Vuelo
				"top" : posicionTop,
				"left" : posicionLeft
			},400);

			setTimeout(function(){
				if ($("#divOperacion").length !== 0) {
					$($("#divOperacion")[0]).remove();
				}
				$($("#divBien")[0]).remove();

				$("#categoriaBox").removeClass("CatBoxSeleccionado").html("<span class='inner-desc'>CATEGORIA</span>");
				$("#divCategoria").show();

				var bienSeleccionado = document.getElementById("bienSeleccionado");
				var operacionSeleccionada = document.getElementById("tipoOperacionSeleccionada");
				if (bienSeleccionado !== null) {
					$(bienSeleccionado).remove();
					ui.bienBox[0].innerHTML += "<span class='inner-desc'>" + label.BIEN + "</span>";
					$(ui.bienBox[0]).removeClass("BienBoxSeleccionado");
				}
				if (operacionSeleccionada !== null) {
					$(operacionSeleccionada).remove();
					ui.tipoOperacionBox[0].innerHTML += "<span class='inner-desc'>" + label.OPERACION + "</span>";
					$(ui.tipoOperacionBox[0]).removeClass("OperacionBoxSeleccionado");
				}
				$("#divCategoria").removeClass("hidden");
				ui.bienBox.addClass("hidden");
				ui.tipoOperacionBox.addClass("hidden");
				ui.divCategoria.popover("show");
				crearAvisosModel.setFamilia(null);
				crearAvisosModel.setClase(null);
				crearAvisosModel.setTipoOperacion(null);
				ui.tituloPaso.html(txt.tituloPasoCategoria);
				ui.tituloPaso.show();
				doOnComplete({});
			},500);
		};

		// ------------------------------------------------
		// private interface -----------------------------
		// ------------------------------------------------

		var renderHandlebars = function(source, context, uiComponent) {

			Handlebars.registerHelper("nombre-item-ordenamiento",CrearAvisosHelpers.nombreItemOrdenamiento);
			Handlebars.registerHelper("nombre-ordenamiento",CrearAvisosHelpers.nombreOrdenamiento);
			Handlebars.registerHelper("descripcion-bien",CrearAvisosHelpers.descripcionBien);

			var template = Handlebars.compile(source);
			var html = template(context);

			uiComponent.append(html);
		};

		var openTerminastePopover = function() {
			doOnObserver({
				"eventToggle" : {
					"estado" : StateEvents.SHOW_TOOLTIP_NEXT,
					"mensaje" : "<center> Ya terminaste aqu&iacute;.</br>Presion&aacute <b>siguiente</b> para avanzar. </center>"
				}
			});
		};

		var limpiarBoxes = function() {
			var categoriaSeleccionada	= document.getElementById("categoriaSeleccionada");
			var bienSeleccionado		= document.getElementById("bienSeleccionado");
			var operacionSeleccionada	= document.getElementById("tipoOperacionSeleccionada");

			if (categoriaSeleccionada !== null) {$(categoriaSeleccionada).remove();ui.categoriaBox[0].innerHTML += "<span class='inner-desc'>" + label.CATEGORIA + "</span>";$($("#divBien")[0]).remove();}
			if (bienSeleccionado !== null) {$(bienSeleccionado).remove();ui.bienBox[0].innerHTML += "<span class='inner-desc'>" + label.BIEN + "</span>";$($("#divOperacion")[0]).remove();}
			if (operacionSeleccionada !== null) {$(operacionSeleccionada).remove();ui.tipoOperacionBox[0].innerHTML += "<span class='inner-desc'>" + label.OPERACION + "</span>";}

			ui.bienBox[0].style.visibility = "hidden";
			ui.tipoOperacionBox[0].style.visibility = "hidden";
			$("#divCategoria")[0].style.display = "inline-block";
		};

		var getTipoOperacionDTO = function(codigo, descripcion) {
			return new TipoOperacionDTO({codigo : codigo,descripcion : descripcion});
		};

		var setTiposOperacionPantallaHandler = function(data) {
			var listaTiposOperacion = arrayUtils.buildArrayObjFromJSON(data.tiposOperacion, TipoOperacionDTO);
			$("#divBien")[0].style.display = "none";
			renderHandlebars(CrearAvisosTemplates.tiposOperacion, {tiposOperacion : listaTiposOperacion}, ui.paso1SelecCat);
		};

		var setBienesPantallaHandler = function(data) {
			var listaBienes = arrayUtils.buildArrayObjFromJSON(data.bienes,ClaseDTO);
			$("#divCategoria")[0].style.display = "none";
			renderHandlebars(CrearAvisosTemplates.bienes, {bienes : listaBienes}, ui.paso1SelecCat);
		};

		var setFamiliasPantallaHandler = function(data) {
			var listaFamilias = arrayUtils.buildArrayObjFromJSON(data.familias,ClaseDTO);
			renderHandlebars(CrearAvisosTemplates.familias, {familias : listaFamilias}, ui.paso1SelecCat);
		};

		var setServerDateHandler = function(data) {
			ui.dateFechaVigencia = data.serverTime;
			crearAvisosModel.setServerTime(new Date(data.serverTime));
		};

		var getTipoOperacionSearchDTO = function(codigoCanalEntrada,codigoClase) {
			return new TipoOperacionSearchDTO({codigoCanalEntrada : codigoCanalEntrada,codigoClase : codigoClase,fechaVigencia : ui.dateFechaVigencia});
		};

		var getClaseSearchDTO = function(codigoClase, codigoCanalEntrada) {
			return new ClaseSearchDTO({codigoClase : codigoClase,codigoCanalEntrada : codigoCanalEntrada,fechaVigencia : ui.dateFechaVigencia});
		};

		var doOnLoadCategoriaPantalla = function(args) {

			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_FAMILIAS,
				dataObject : getClaseSearchDTO(null, "ROL"),
				successHandlerCallback : setFamiliasPantallaHandler,
				errorHandlerCallback : defaultErrorHandler
			});
			$("#paso4-Cat").hide();
			setTimeout(function(){$("#divCategoria").popover("hide");}, 200);
			ui.tituloPaso.html(txt.tituloPasoCategoria);
			if (crearAvisosModel.getFamilia() && crearAvisosModel.getFamilia().codigo) {

				ui.categoriaBox.empty();
				renderHandlebars(CrearAvisosTemplates.categoriaSeleccionada, {
					descripcion : crearAvisosModel.getFamilia().descripcion
				}, ui.categoriaBox);

				ui.categoriaBox.addClass("CatBoxSeleccionado");
				$("#divCategoria").addClass("hidden");
				ui.bienBox.removeClass("hidden");
				doOnLoadBienPantalla({});
			}else {
				ui.divCategoria.popover("show");
			}

		};

		var doOnLoadBienPantalla = function(args) {

			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_BIENES,
				dataObject : getClaseSearchDTO(crearAvisosModel.getFamilia().codigo, "ROL"),
				successHandlerCallback : setBienesPantallaHandler,
				errorHandlerCallback : defaultErrorHandler
			});

			ui.tituloPaso.html(txt.tituloPasoBien);
			if (crearAvisosModel.getClase() && crearAvisosModel.getClase().codigo) {
				var idBoton = "bien-" + crearAvisosModel.getClase().codigo;
				var elemento = $("[id='"+ idBoton + "']");
				var posicion = elemento.position();
				$(elemento).addClass("CatBox");
				ui.bienBox.empty();
				renderHandlebars(CrearAvisosTemplates.bienSeleccionado, {
					descripcion : crearAvisosModel.getClase().descripcion,
					descripcionBien : $(elemento).data("descripcionTrim")
				}, ui.bienBox);
				$("#bienSeleccionado").parent().addClass("BienBoxSeleccionado");
				$("#bienSeleccionado").attr("data-posicion-top", posicion.top).attr("data-posicion-left", posicion.left);
				ui.tipoOperacionBox.removeClass("hidden");
				$("#divBien").addClass("hidden");
				doOnLoadTipoOperacionPantalla({});
			}
		};

		var doOnLoadTipoOperacionPantalla = function(args) {

			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_TIPOS_OPERACION,
				dataObject : getTipoOperacionSearchDTO("ROL", crearAvisosModel.getClase().codigo),
				successHandlerCallback : setTiposOperacionPantallaHandler,
				errorHandlerCallback : defaultErrorHandler
			});

			ui.tituloPaso.html(txt.tituloPasoOperacion);


			if (crearAvisosModel.getTipoOperacion() && crearAvisosModel.getTipoOperacion().codigo) {
				var idBoton = "operacion-" + crearAvisosModel.getTipoOperacion().codigo;
				var elemento = $("[id='"+ idBoton + "']");
				var posicion = elemento.position();
				$(elemento).addClass("CatBox");
				ui.tipoOperacionBox.empty();
				renderHandlebars(CrearAvisosTemplates.tipoOperacionSeleccionada,{
					codigo : crearAvisosModel.getTipoOperacion().codigo,
					descripcion : crearAvisosModel.getTipoOperacion().descripcion
				}, ui.tipoOperacionBox);
				ui.navFooterWizard.show();
				openTerminastePopover();
				$("#tipoOperacionSeleccionada").parent().addClass("OperacionBoxSeleccionado");
				$("#divOperacion").hide();
				model.habilitado = true;

			}

		};

		var evaluateChange = function(args) {

			var change = false;

			var equalsCodigoFamilia = true;
			var equalsCodigoClase = true;
			var equalsCodigoTipoOperacion = true;

			if (model.generatedData.codigoFamilia && args.newData.codigoFamilia !== model.generatedData.codigoFamilia) {
				equalsCodigoFamilia = false;
			}

			if (model.generatedData.codigoClase && args.newData.codigoClase !== model.generatedData.codigoClase) {
				equalsCodigoClase = false;
			}

			if (model.generatedData.codigoTipoOperacion && args.newData.codigoTipoOperacion !== model.generatedData.codigoTipoOperacion) {
				equalsCodigoTipoOperacion = false;
			}

			if (!equalsCodigoFamilia || !equalsCodigoClase || !equalsCodigoTipoOperacion) {
				change = true;
				modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {"preview" : null},
				function(index, aviso, args) {
					aviso.preview = args.preview;
				});

				crearAvisosModel.setPalabrasProhibidas(null);

			}

			// Guardo la nuevo info.
			model.generatedData.codigoFamilia = args.newData.codigoFamilia;
			model.generatedData.codigoClase = args.newData.codigoClase;
			model.generatedData.codigoTipoOperacion = args.newData.codigoTipoOperacion;
			// Updateo la variable de notificacion de cambio.
			if(change){

				if(!equalsCodigoFamilia || !equalsCodigoClase){
					limpiarOrdenCompleta();
				}
				else {
					if(!equalsCodigoTipoOperacion){
						limpiarOrden();
					}
				}


				new GeneratedDataStep2({});
				new GeneratedDataStep3({});
				new GeneratedDataStep4({});
			}
			model.notifyChange = change;

		};

		var getAccedida = function() {
			return accedida;
		};

		var cargarServerTime = function(){
			// obtengo la fecha del server.
			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_SERVER_TIME,
				dataObject : null,
				successHandlerCallback : setServerDateHandler,
				errorHandlerCallback : defaultErrorHandler
			});
		};

		var agregaPaso = function(){
			$(".infoPaso").remove();
			$("#MyWizard .steps").append("<li class='infoPaso'>1/5</li>");
		}

		var dibujarPantalla = function() {
			agregaPaso();
			$("#paso1-QueQueres, #categoriaBox").removeClass("hidden");

			if ($('#divCategoria').hasClass('hidden')) {
				setTimeout(function(){$("#divCategoria").popover("hide");}, 1400);
			}

			doOnLoadCategoriaPantalla({});
			// Construyo los shortcuts. Remuevo el comportamiento generico del click y "sobreescribo" el evento.
			var shortcuts = [{selector : "#categoria-FAMILIA_DIA_DE_LOS_ENAMORADOS", urlShortcut : "?template=ENAMORADOS2016"},
			                 {selector : "#categoria-FAMILIA_FUNEBRES", urlShortcut : "?template=FUNEBRES_RECORDATORIOS"},
			                 {selector : "#categoria-FAMILIA_DIA_DE_LA_MADRE", urlShortcut : "?template=DIADELAMADRE"}];
			$.each(shortcuts, function(index, shortcut){
				$(shortcut.selector).removeAttr("onclick");
				$(document).on("click", shortcut.selector, function(){
					$("#step1").fadeOut(400);
					var url = shortcut.urlShortcut;
					window.location = url;
				});
			});
		};

		var verificarExistenDatosOrden = function(){
			var existenDatos = false;
			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;

			//El codigo de familia no viene cargado porque no esta en el DTO java ==> al crear el DTO js viene con ""
			//TODO revisar para familias...
			if( (crearAvisosModel.getFamilia() !== null && crearAvisosModel.getFamilia().codigo !== "") &&
				(aviso.codigoClase !== null && aviso.codigoClase !== "") &&
				(aviso.tipoOperacion !== null && aviso.tipoOperacion.codigo !== "") ) {
				existenDatos = true;
			}

			return existenDatos;
		};

		var limpiarOrden = function(){

			var conceptoBase;
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.productoComercial = null;
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.ordenamientos = [];
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.nivelEstructura = null;
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.fechaPedidoPublicacion = null;
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.zonasComercializacion = [];

			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.preview	= null;
			crearAvisosModel.ordenamientos = [];
			crearAvisosModel.configuracionesOrdenamientoPantalla = null;
			crearAvisosModel.ordenamientosPantalla =[];
			conceptoBase = new ConceptoVendibleAvisoDTO(crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0]);
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles = [];
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles.push(conceptoBase);
			crearAvisosModel.setTarjeta365("");
			crearAvisosModel.setCodigoProductoComercialDestaque(null);
			crearAvisosModel.setCodigoTemplateDestaqueSeleccionado(null);
			crearAvisosModel.setCodigoImagenDestaqueSeleccionada(null);
			crearAvisosModel.setRepoImagenDestaqueSeleccionada(null);
		};

		var limpiarOrdenCompleta = function(){
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.textoLibre = "";
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.textoJustificado = "";
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.textoLibreJustificado = "";
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.textoLibreTemplate ="";
			limpiarOrden();
		};

		// ------------------------------------------------
		// common interface ------------------------------
		// ------------------------------------------------

		var modificada = false;

		var accedida = false;

		var index = 1;

		var doOnObserver = args.doOnObserver;

		var label = {
			CATEGORIA : "CATEGOR&Iacute;A",
			BIEN : "BIEN",
			OPERACION : "OPERACI&Oacute;N"
		};

		var ui = {
			// components:
			paso1SelecCat			: $("#paso1-SelecCat"),
			categoriaBox			: $("#categoriaBox"),
			divCategoria			: $("#divCategoria"),
			bienBox					: $("#bienBox"),
			tipoOperacionBox		: $("#tipoOperacionBox"),
			panelVerSeleccionado	: $(".panel-ver-seleccionado"),
			pasoTitulo				: $("#titulo-paso"),
			breadcrum				: $(".breadcrum"),
			tituloPaso				: $("#titulo-paso"),
			navFooterWizard			: $("#navFooterWizard"),
			btnWizardNext			: $("#btnWizardNext"),
			dateFechaVigencia		: null,
			// position for animation:
			categoriaTopInit		: 85,
			categoriaLeftInit		: 204,
			categoriaTopFin			: "49px",
			categoriaLeftFin		: "24px",
			categoriaZindexFin		: 99,
			bienTopInit				: 50,
			bienLeftInit			: 189,
			bienTopFin				: "96px",
			bienLeftFin				: "24px",
			bienZindexFin			: 99,
			mainContainer			: $("#mainApp"),
			operacionTopInit		: 50,
			operacionLeftInit		: 189,
			operacionTopFin			: "143px",
			operacionLeftFin		: "24px",
			operacionZindexFin		: 99
		};

		var txt = {
			tituloPasoCategoria		: "Seleccion&aacute; una categor&iacute;a",
			tituloPasoBien			: "Seleccion&aacute; un tipo de bien",
			tituloPasoOperacion		: "Seleccion&aacute; una operaci&oacute;n"
		};

		var model = {
			notifyChange : false,
			generatedData : new GeneratedDataStep1({}),
			habilitado : false,
			cambiarEstadoFooter : true,
			tipoDeseleccion : null,
			tipoDeseleccion : "",
			categoriaComponent : null,
			bienComponent : null
		};

		var terminastePopoverConfig = {
			html : true
		};

		/**
		 * { event : StateEvents.EVENT_CONST, }
		 */
		var doOnEnter = function(args) {
			agregaPaso();
			showBreadcrum('QUE');
			showPanelSeleccionado('QUE');

			/* Inicializo el popup de Ver Seleccion que se va a usar y actualizar durante todo el wizard */
			/* Inicializo el popup de Ver Seleccion en el decorator Controller donde estan iniciados todos los popups */
			//initPopUpVerSeleccionado();

			if (args.event === StateEvents.PREVIOUS_FOOTER_ON_LOAD) {
				doOnLoad();
			} else {
				/* Si viene del paso siguiente, tengo que mostrar el panel de entrada [SFHUB-7227] */
				if (args.event === StateEvents.PREVIOUS_FOOTER) {
					ui.panelVerSeleccionado.show();
					ui.panelVerSeleccionado.find(".container-panel").show();
					/* Oculto el titulo porque viene del paso siguiente */
					ui.pasoTitulo.hide();
				}
				generateTag();
				if (!verificarExistenDatosOrden() || !accedida) {
					accedida = true;
					model.habilitado = false;

					// configuro popover
					$(".terminaste").popover(terminastePopoverConfig);

					cargarServerTime();
					dibujarPantalla();
				}
				doOnComplete({});
			}
		};

		var doOnLoad = function(args) {
			generateTag();
			accedida = true;
			model.habilitado = false;
			/* Lo muestro por si lo había ocultado antes */
			ui.pasoTitulo.show();

			// configuro popover
			$(".terminaste").popover(terminastePopoverConfig);

			cargarServerTime();
			dibujarPantalla();
			doOnComplete({});

			//debo de regenerar la data debido a que cuando entra x onload y vuelve para
			//atras el model esta vacio y no detecta cambio
			evaluateChange({
				"newData" : new GeneratedDataStep1({
					"codigoFamilia" : crearAvisosModel.getFamilia().codigo,
					"codigoClase" : crearAvisosModel.getClase() ? crearAvisosModel.getClase().codigo : null,
					"codigoTipoOperacion" : crearAvisosModel.getTipoOperacion() ? crearAvisosModel.getTipoOperacion().codigo : null
				})
			});


		};

		/**
		 * { event : StateEvents.EVENT_CONST, }
		 */
		var doOnExit = function(args) {
			gOnclickCloseTerminastePopoverHandler();
			evaluateChange({
				"newData" : new GeneratedDataStep1({
					"codigoFamilia" : crearAvisosModel.getFamilia().codigo,
					"codigoClase" : crearAvisosModel.getClase().codigo,
					"codigoTipoOperacion" : crearAvisosModel.getTipoOperacion().codigo
				})
			});
			model.cambiarEstadoFooter = true;
			doOnObserver({"eventsTransform" : [ StateEvents.PREVIOUS_SHOW ]});
		};

		var doOnError = function(args) {
			// Implements -----
		};

		var doOnCancel = function(args) {
			model.habilitado = false;
			gOnclickCloseTerminastePopoverHandler();
			limpiarBoxes();
			model.generatedData = new GeneratedDataStep1({});
			$("#listaCategorias div").removeClass("CatBox").addClass("genericBtn");
			ui.divCategoria.popover("show");
			doOnComplete({});
		};

		var doOnChange = function(args) {
			// Implements -----
		};

		var doOnShow = function(args) {
			// Implements -----

		};

		var doOnComplete = function(args) {
			// Evaluate Complete
			if (isComplete(args)) {
				doOnObserver({"eventEnabled" : StateEvents.NEXT_ENABLED});
			} else {
				doOnObserver({"eventEnabled" : StateEvents.NEXT_DISABLED});
			}
			// Hide Previous
			if (model.cambiarEstadoFooter) {
				doOnObserver({"eventsTransform" : [ StateEvents.PREVIOUS_HIDE ]});
				model.cambiarEstadoFooter = false;
			}

		};

		var doOnExitScreen = function() {

			var clase = crearAvisosModel.getClase();
			var tipoOperacion = crearAvisosModel.getTipoOperacion();
			var familia = crearAvisosModel.getFamilia();

			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(),{
				"familia" : familia,
				"clase" : clase,
				"tipoOperacion" : tipoOperacion
			},function(index, aviso, args) {
				aviso.codigoFamilia = (args.familia !== null && args.familia !== undefined) ? args.familia.codigo : undefined;
				aviso.codigoClase = (args.clase !== null && args.clase !== undefined) ? args.clase.codigo : undefined;
				aviso.tipoOperacion = (args.tipoOperacion !== null && args.tipoOperacion !== undefined) ? args.tipoOperacion : undefined;
			});

		};

		var bind = function(args) {
			// Implements -----
		};

		var unbind = function(args) {
			// Implements -----
		};

		var isComplete = function(args) {
			return model.habilitado;
		};

		var notifyChange = function(args) {
			return model.notifyChange;
		};

		var generateTag = function() {
			decoratorModel.setA2("que-queres-publicar");
			var area = decoratorModel.getA1() + decoratorModel.getA2();
			gChangeTagName(area);
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
			doOnLoad			: doOnLoad,
			doOnExitScreen		: doOnExitScreen,
			bind				: bind,
			unbind				: unbind,
			isComplete			: isComplete,
			notifyChange		: notifyChange,
			getAccedida			: getAccedida

		};

	};

})();
