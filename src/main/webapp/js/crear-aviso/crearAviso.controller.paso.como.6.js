 /**
 * author: csantos version: 1.0.0
 * Funciones del paso Como de Crear Aviso, paso 6
 */


// -----------------------------------------------------------------------------
// StateStep6Creacion ---------------------------------------------------------
// -----------------------------------------------------------------------------

var StateStep6Creacion = (function() {

	return function(args) {

		// ------------------------------------------------
		// global interface ------------------------------
		// ------------------------------------------------

		var executeJustificarValidarPromosTasarCaller = function(){
			var callerArray = [];
			callerArray.push(new CallBackObject({
				url:CrearAvisoServiceURL.JUSTIFICAR,
				staticObject : buildJustificar(),//orden
				successHandlerCallback : justificarHandler,
				errorHandlerCallBack : defaultErrorHandler,
				processCallBack		 : processCallBackJustificar
			}));
			callerArray.push(new CallBackObject({
				url:CrearAvisoServiceURL.VALIDAR_PROMOCIONES,
				staticObject :	crearAvisosModel.getPromocionesValidar(obtenerIndiceStep()),//promos
				successHandlerCallback : validarPromocionesHandler,
				errorHandlerCallBack : defaultErrorHandler,
				processCallBack: processCallBackValidarPromociones
			}));
			callerArray.push(new CallBackObject({
				url : CrearAvisoServiceURL.TASAR,
				successHandlerCallback : tasarHandler,
				processCallBack		 : processCallBackTasar,
				errorHandlerCallBack : defaultErrorHandler
			}));

			sequenceCallerUI.createPost(callerArray);
		};

		/*04/08/2016 - vdenicolo - SFHUB-7992*/
		/*Al dar el aceptar del error de 1 linea va a rejustificar el sistema
		el problema esta que va a rejustificar desde el paso 5 con el index 6 ya que parte desde esta funcion en este paso
		como esta misma funcion esta repetida en el paso 5 y las promociones de Eco estan configuradas con pantallaShow 5
		debe llegar un index = 5 en caso que este parado alli (if que pregunta si el paso esta oculto en false) ==> re-evaluo su step.*/
		var obtenerIndiceStep = function(){
			if($("#paso4-ComoSeraTuAviso").is(":hidden") == false){
				return 5;
			}else{
				return index;
			}
		};

		// ------------------------------------------------
		// destaque pictos -------------------------------
		// ------------------------------------------------

		g_muestraPictos = function(component) {
			$("#popUpPictos .modal-header .close").attr("onclick","gOnclickCancelarPictosHandler(this)");

			//si tiene seleccionado fondo color lo limpio
			if(crearAvisosModel.getTemplateTieneFondoColor() == true){
				limpiarFondoColorFromOrden();
			}

			$("html").on("keydown", function(e) {
				if (e.keyCode === 9) {
					e.preventDefault();
				}
			});

			var codigoTemplate = $(component).data("codigo");
			var idTemplate = $(component).data("id");
			var codigoProductoComercialDestaque = $(component).data("productocomercial");

			crearAvisosModel.setCodigoTemplateDestaqueSeleccionado(codigoTemplate);
			crearAvisosModel.setCodigoProductoComercialDestaque(codigoProductoComercialDestaque);
			crearAvisosModel.setCodigoNivelEstructuraDestaque(crearAvisosModel.getCodigoNivelEstructura());
			crearAvisosModel.setTemplateTieneFondoColor(null);

			mostrarPopUpPictos(codigoTemplate, idTemplate);

			if (Detectizr.device.browser === "ie") {
				$("#popUpPictos .btn-primary").addClass("disabledBtn");
				$("#popUpPictos .btn-primary").attr("onclick", "");
			} else {
				$("#popUpPictos .btn-primary").addClass("disabledBtn");
			}

			//SFHUB-7780 si se quita el agrandar queda seleccionado por css - vdenicolo
			agrandarComponenteDestaquePicto();
		};

		gOnclickCancelarPictosHandler = function(component) {
			$(".modal").modal("hide");
			if (!crearAvisosModel.getTemplateTienePictoSeleccionado()) {
				$("#labelRadioPicto").attr("onclick","g_muestraPictos(this)");
				$("#radioPicto").attr("checked", false);
				var boxDestaque = $("#listDestaque");
				boxDestaque.removeClass("box-picto-seleccionado");

				crearAvisosModel.setCodigoImagenDestaqueSeleccionada(null);
				crearAvisosModel.setRepoImagenDestaqueSeleccionada(null);
				crearAvisosModel.setCodigoTemplateDestaqueSeleccionado(null);
				crearAvisosModel.setCodigoProductoComercialDestaque(null);
				crearAvisosModel.setCodigoNivelEstructuraDestaque(null);
				crearAvisosModel.setOrdenDePublicacion(crearAvisosModel.getOrdenDePublicacionHistory());
				previewAviso();

				achicarComponenteDestaquePicto();
				initPopupPictos();
			}
			$("html").off("keydown");
		};

		gOnclickAceptarPictosHandler = function(args) {
			var idPictoSeleccionado = $("#popUpPictos .modal-body li.pictoSeleccionada img").attr("id");

			// Agregar imagen a el aviso
			$(".modal").modal("hide");

			crearAvisosModel.setCodigoImagenDestaqueSeleccionada($("#popUpPictos .modal-body li.pictoSeleccionada img").data("codigo"));
			crearAvisosModel.setRepoImagenDestaqueSeleccionada($("#popUpPictos .modal-body li.pictoSeleccionada img").data("repo"));
			crearAvisosModel.setTemplateTienePictoSeleccionado(true);
			crearAvisosModel.setTemplateTieneFondoColor(null);
			crearAvisosModel.setTemplateTieneMaterial(null);
			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			aviso.templateDetallado.codigo = crearAvisosModel.getCodigoTemplateDestaqueSeleccionado();
			aviso.productoComercial.codigo = crearAvisosModel.getCodigoProductoComercialDestaque();

			$.each(crearAvisosModel.imagenes, function(index, value) {
				if (value.codigo === crearAvisosModel.getCodigoImagenDestaqueSeleccionada()) {
					var array = [];
					array.push(value);
					aviso.materiales = array;
					return false;
				}
			});
			aviso.preview.codigo = crearAvisosModel.getCodigoImagenDestaqueSeleccionada();
			aviso.preview.repo = crearAvisosModel.getRepoImagenDestaqueSeleccionada();

			executeJustificarValidarPromosTasarCaller();
			agrandarComponenteDestaquePicto();
			$("html").off("keydown");
		};

		g_eliminaPictos = function(component) {
			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(),
					{"codigoTemplateDetallado" : crearAvisosModel.getCodigoTemplateDetallado(),
					 "codigoProductoComercial" : crearAvisosModel.getCodigoProductoComercial()},
					 function(index, aviso, args){
						aviso.templateDetallado.codigo = args.codigoTemplateDetallado;
						aviso.productoComercial.codigo = args.codigoProductoComercial;
						aviso.preview.codigo = null;
						aviso.preview.repo = null;
						aviso.materiales = [];
					 });

			// limpio los datos del model
			crearAvisosModel.setCodigoImagenDestaqueSeleccionada(null);
			crearAvisosModel.setRepoImagenDestaqueSeleccionada(null);
			crearAvisosModel.setCodigoTemplateDestaqueSeleccionado(null);
			crearAvisosModel.setCodigoProductoComercialDestaque(null);
			crearAvisosModel.setCodigoNivelEstructuraDestaque(null);
			crearAvisosModel.setTemplateTienePictoSeleccionado(null);

			executeJustificarValidarPromosTasarCaller();

			achicarComponenteDestaquePicto();
			initPopupPictos();
		};

		gCambiaPictos = function() {
			$("html").on("keydown", function(e) {
				if (e.keyCode === 9) {
					e.preventDefault();
				}
			});
			$("#popUpPictos").modal("show");
			initColeccionImagenes(crearAvisosModel.getCodigoTemplateDestaqueSeleccionado());
			g_imgHover();
			$("#" + crearAvisosModel.getCodigoImagenDestaqueSeleccionada()).parent().addClass("pictoSeleccionada");
		};

		var mostrarPopUpPictos = function(codigoTemplate, idTemplate) {
			$("#labelRadioPicto").removeAttr("onclick"); /* Le saco el onclick al label */
			$("#radioPicto").attr("checked", "checked");

			/* Muestro el popup */
			$("#popUpPictos").modal({
				backdrop : "static",
				show : true
			});

			/* Busco las imagenes, las dibujo y les agrego funcionalidad */
			initColeccionImagenes(codigoTemplate);
			g_imgHover();
		};

		g_imgHover = function() {

			$("#popUpPictos .modal-body li").on("click",function() {
				$(this).addClass("pictoSeleccionada").siblings().removeClass("pictoSeleccionada"); /* Esto lo dejo porque sino se rompe la funcionalidad JS */
				$("#popUpPictos .btn-primary").removeClass("disabledBtn");
				$("#popUpPictos .btn-primary").attr("onclick","gOnclickAceptarPictosHandler(this)");
			});
		};

		var agrandarComponenteDestaquePicto = function() {
			var boxDestaque = $("#listDestaque .MedioRubroMainWrapper");
			boxDestaque.addClass("box-picto-seleccionado");
			$("#radioPicto").attr("checked", "checked");
		};

		var achicarComponenteDestaquePicto = function() {
			var boxDestaque = $("#listDestaque .MedioRubroMainWrapper");
			$("#labelRadioPicto").attr("onclick", "g_muestraPictos(this)");
			$("#radioPicto").attr("checked", false);

			boxDestaque.removeClass("box-picto-seleccionado");
		};



		// ------------------------------------------------
		// destaque fondo color --------------------------
		// ------------------------------------------------

		g_seleccionarColor = function(component, event) {

			//si tiene seleccionado una imagen entonces la limpio
			if(crearAvisosModel.getTemplateTienePictoSeleccionado() === true){
				limpiarPictoFromOrden();
			}else if(crearAvisosModel.getTemplateTieneFondoColor() === true){
				event.preventDefault();
				event.stopPropagation();
				g_eliminaColor(".css-label-radio-color", "seleccionarColor");
				//elimina y debe cortar
				return;
			}else if(crearAvisosModel.getTemplateTieneMaterial() === true || $("div[id^='selDestaqueMaterialBox']").parent().hasClass("destaqueActivado")){
				event.preventDefault();
				event.stopPropagation();
				g_eliminaMaterial("seleccionarColor");
				//elimina y debe cortar
				//envia ademas el seleccionar material para que tome la accion extra en este caso
				return;
			}

			if($(".image-editor").is(":visible")){
				$(".image-editor").empty();
				event.preventDefault();
				event.stopPropagation();
			}

			var codigoTemplate = $(".css-label-radio-color").data("codigo");
			var idTemplate = $(".css-label-radio-color").data("id");
			var codigoProductoComercialDestaque = $(".css-label-radio-color").data("productocomercial");

			agrandarComponenteDestaqueColor();

			crearAvisosModel.setCodigoTemplateDestaqueSeleccionado(codigoTemplate);
			crearAvisosModel.setCodigoProductoComercialDestaque(codigoProductoComercialDestaque);
			crearAvisosModel.setCodigoImagenDestaqueSeleccionada(null);
			crearAvisosModel.setRepoImagenDestaqueSeleccionada(null);
			crearAvisosModel.setTemplateTieneFondoColor(true);
			crearAvisosModel.setCodigoNivelEstructuraDestaque(crearAvisosModel.getCodigoNivelEstructura());

			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			aviso.templateDetallado.codigo = crearAvisosModel.getCodigoTemplateDestaqueSeleccionado();
			aviso.productoComercial.codigo = crearAvisosModel.getCodigoProductoComercialDestaque();

			executeJustificarValidarPromosTasarCaller();

		};

		gOnclickCancelarColorHandler = function(){
			$("#popUpColor").modal("hide");
		};

		gOnclickAceptarColorHandler = function(){
			$("#popUpColor").modal("hide");
			var origen = $("#popUpColor .modal-footer .btn-primary").attr("data-origen");

			if(crearAvisosModel.getTemplateTieneFondoColor() == true){
				g_eliminaColorFn(".css-label-radio-color");

				//si toco material ademas lo selecciono
				if(origen === "seleccionarMaterial"){
					g_seleccionarMaterial(".css-label-radio-material");
				}
			}

		};

		g_eliminaColor = function(component, origen) {

			$("#popUpColor").modal("show");
			$("#popUpColor .modal-body p").text("\xbfEst\xe1s seguro de eliminar el fondo color?");
			$("#popUpColor .modal-footer .btn-primary").attr("data-origen", origen);

		};

		var agrandarComponenteDestaqueColor = function() {

			$("div[id^='selDestaqueColorBox']").parent().addClass("destaqueActivado");
			$("#radioColor").trigger("click");
			$(".opcionesColor").show();

		};

		var achicarComponenteDestaqueColor = function() {

		};

		g_eliminaColorFn = function(component){

			$(".MedioRubroMainWrapper").removeClass("destaqueActivado");
			$(".opcionesColor").hide();
			$("#radioColor").attr("checked", false);

			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(),
					{"codigoTemplateDetallado" : crearAvisosModel.getCodigoTemplateDetallado(),
					 "codigoProductoComercial" : crearAvisosModel.getCodigoProductoComercial()},
					 function(index, aviso, args){
						aviso.templateDetallado.codigo = args.codigoTemplateDetallado;
						aviso.productoComercial.codigo = args.codigoProductoComercial;
						aviso.preview.codigo = null;
						aviso.preview.repo = null;
						aviso.materiales = [];
					 });

			// limpio los datos del model
			crearAvisosModel.setCodigoImagenDestaqueSeleccionada(null);
			crearAvisosModel.setRepoImagenDestaqueSeleccionada(null);
			crearAvisosModel.setCodigoTemplateDestaqueSeleccionado(null);
			crearAvisosModel.setCodigoProductoComercialDestaque(null);
			crearAvisosModel.setCodigoNivelEstructuraDestaque(null);
			crearAvisosModel.setTemplateTieneFondoColor(null);
			crearAvisosModel.setTemplateTieneMaterial(null);

			executeJustificarValidarPromosTasarCaller();

		};



		// ------------------------------------------------
		// destaque material --------------------------
		// ------------------------------------------------

		g_seleccionarMaterial = function(component,event) {

			if(event){
				event.preventDefault();
    			event.stopPropagation();
			}

    		if(crearAvisosModel.getTemplateTienePictoSeleccionado() === true){
				limpiarPictoFromOrden();
			}else if(crearAvisosModel.getTemplateTieneFondoColor() === true){
				g_eliminaColor(".css-label-radio-color", "seleccionarMaterial");
				//elimina y debe cortar
				//envia ademas el seleccionar material para que tome la accion extra en este caso
				return;
			}else if(crearAvisosModel.getTemplateTieneMaterial() === true){
				//elimina y debe cortar
				g_eliminaMaterial("seleccionarMaterial");
				return;
			}

			abrirSeleccionMaterial();

		};

		var abrirSeleccionMaterial = function() {

			$("#previewHolderP6 .image-editor").remove();
			$("#previewHolderP6 .boxImgPreview").append("<div class='image-editor'></div>");
			renderHandlebars(CrearAvisosTemplates.renderSubidaMaterial, {templatesDetallado : crearAvisosModel.getTemplatesDetallado()}, $("#previewHolderP6 .image-editor"));
			subidaMaterialComponente();
			$("#btn-elige-archivo").click();

		};

		g_eliminaMaterial = function(origen){
			$("#popUpMateriales").modal("show");
			$("#popUpMateriales .modal-body p").text("\xbfEst\xe1s seguro de eliminar el destaque?");
			if(origen === "seleccionarColor"){
				$("#popUpMateriales .modal-footer .btn-primary").attr("data-origen","seleccionarColor");
				return;
			}else{
				return;
			}
		};

		gOnclickCancelarMaterialHandler = function(){
			$("#popUpMateriales").modal("hide");
		};

		gOnclickAceptarMaterialHandler = function(){
			$("#popUpMateriales").modal("hide");

			if(crearAvisosModel.getTemplateTieneMaterial() == true){
				g_eliminaMaterialFn();

				//si toco fondo color ademas lo selecciono
				var origen = $("#popUpMateriales .modal-footer .btn-primary").attr("data-origen");
				if(origen === "seleccionarColor"){
					g_seleccionarColor(".css-label-radio-color");
				}

				return;
			}

			agrandarComponenteDestaqueMaterial();
		};

		var agrandarComponenteDestaqueMaterial = function(){
			$("div[id^='selDestaqueMaterialBox']").parent().addClass("destaqueActivado");
			$("#radioMaterial").attr("checked", "checked");
			$(".opcionesMaterial").show();
		};

		g_eliminaMaterialFn = function() {

			var attr = $(".image-editor").attr('style');
			if (typeof attr !== typeof undefined && attr !== false) {
				$(".image-editor").removeAttr("style").removeClass("superPuesta");
			}
			$(".boxImgPreview").css({"height": "auto"});

			var codigoTemplate = $(".linkEliminarDestaqueMaterial a").data("codigo-eliminar");
			var idTemplate = $(".linkEliminarDestaqueMaterial a").data("id-eliminar");

			$("div[id^='selDestaqueMaterialBox']").parent().removeClass("destaqueActivado");
			$(".image-editor").remove();
			$(".opcionesMaterial").hide();
			$("#radioMaterial").attr("checked", false);

			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(),
					{"codigoTemplateDetallado" : crearAvisosModel.getCodigoTemplateDetallado(),
					 "codigoProductoComercial" : crearAvisosModel.getCodigoProductoComercial()},
					 function(index, aviso, args){
						aviso.templateDetallado.codigo = args.codigoTemplateDetallado;
						aviso.productoComercial.codigo = args.codigoProductoComercial;
						aviso.preview.codigo = null;
						aviso.preview.repo = null;
						aviso.materiales = [];
					 });

			// limpio los datos del model
			crearAvisosModel.setCodigoImagenDestaqueSeleccionada(null);
			crearAvisosModel.setRepoImagenDestaqueSeleccionada(null);
			crearAvisosModel.setCodigoTemplateDestaqueSeleccionado(null);
			crearAvisosModel.setCodigoProductoComercialDestaque(null);
			crearAvisosModel.setCodigoNivelEstructuraDestaque(null);
			crearAvisosModel.setTemplateTieneMaterial(null);

			executeJustificarValidarPromosTasarCaller();

		};

		g_cambiaMaterial = function(){
			var codigoTemplate = $(".css-label-radio-material").data("codigo");
			var idTemplate = $(".css-label-radio-material").data("id");
			$("#previewHolderP6 .image-editor").remove();
			$("#previewHolderP6 .boxImgPreview").append("<div class='image-editor'></div>");
			renderHandlebars(CrearAvisosTemplates.renderSubidaMaterial, {templatesDetallado : crearAvisosModel.getTemplatesDetallado()}, $("#previewHolderP6 .image-editor"));
			subidaMaterialComponente();

			var validaAnchoImagenPreview = 0;

			$.each(crearAvisosModel.getTemplatesDetallado(), function(index, tD) {
				if(tD.templateDetallado.tieneMaterial){
					validaAltoImagenPreview = tD.templateDetallado.alto;
				}
			});


			$(".image-editor").parent().css({"position":"relative"});
			var altoPreview = 0;
			var altoPreviewBox = 0;
			altoPreview = parseInt($(".imgPreview").height(),"");
			altoTextPreview = altoPreview - validaAltoImagenPreview;
			altoPreview = altoPreview-altoTextPreview;
			altoPreviewBox = parseInt($(".imgPreview").height(),"")+120; //El 120 es el alto en px de la botonera "ACEPTAR Y CANCELAR"
			$(".boxImgPreview").height(altoPreviewBox);
			$(".image-editor").addClass("superPuesta").css({"top" : "-"+altoPreview+"px"});
			$("#btn-elige-archivo").click();
		};

		gOnclickAceptarErrorLinealHandler = function(component){
			$(".modal").modal("hide");
			crearAvisosModel.setTemplateTieneMaterial(false);
			$("div[id^='selDestaqueMaterialBox']").parent().removeClass("destaqueActivado");
			$(".opcionesMaterial").hide();
			$("#radioMaterial").attr("checked", false);
			if($("#paso4-ComoSeraTuAviso").is(":hidden")){
				g_eliminaMaterialFn();
			}else{
				g_eliminaMaterialFn();
				$("#btn-Previsualizar").trigger("click");
			}
		};

		g_ampliaImagen = function(){
			document.getElementById("cropit-range").stepUp(10);
		};

		g_reduceImagen = function(){
			document.getElementById("cropit-range").stepDown(10);
		};



		// ------------------------------------------------
		// private interface -----------------------------
		// ------------------------------------------------

		var limpiarComponentes = function (){
			var component = $("#listDestaque");
			if(component !== null && component !== undefined){
				component.empty();
			}
		}

		var limpiarDestaques = function (){
			limpiarMaterialFromOrden();
			limpiarFondoColorFromOrden();
			limpiarPictoFromOrden();
		}

		var limpiarPictoFromOrden = function(){
			g_eliminaPictos(componenteDestaqueEliminar);
		}

		var limpiarFondoColorFromOrden = function(origen){
			g_eliminaColor(origen);
		}

		var limpiarMaterialFromOrden = function(){
			g_eliminaMaterialFn();
		}

		var renderizarTemplates = function() {

			var component = $("#listDestaque");

			// clearOptions(component);
			renderHandlebars(CrearAvisosTemplates.selectorDestaque, {templatesDetallado : crearAvisosModel.getTemplatesDetallado()}, component);
			setTimeout(function(){
				//$(".opcionesColor").hide();
				//$(".opcionesMaterial").hide();
				$(".ico-ayuda").tooltip();
				$(".ico-ayuda").on("tap",function(){
	  				$(this).hide();
  				});
				if(Detectizr.device.type === "mobile" || Detectizr.device.type === "tablet"){
					$("div[id^='selDestaqueMaterialBox']").parent().hide();
				}
			},0);

		};

		var renderHandlebars = function(source, context, uiComponent) {

			Handlebars.registerHelper("pesoMaterial",CrearAvisosHelpers.pesoMaterial);

			var template = Handlebars.compile(source);
			var html = template(context);
			uiComponent.append(html);

		};

		var obtenerTemplate = function(codigoTemplate) {
			var result;
			$.each(crearAvisosModel.getTemplatesDetallado(),function(index, templateDetallado) {
				if (templateDetallado.templateDetallado.codigo === codigoTemplate) {
					result = templateDetallado;
				}
			});
			return result;
		};

		var obtenerDestaquesDoOnLoad = function() {
			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_TEMPLATES_DETALLADO,
				dataObject : getTemplateDetalladoSearchDTO(crearAvisosModel.getCodigoCanalEntrada(),
					crearAvisosModel.getCodigoAgrupamientoProductoTecnico(),
					crearAvisosModel.getTipoOperacion().codigo,
					crearAvisosModel.getCodigoNivelEstructura(),
					(crearAvisosModel.getSelectedDates() ? crearAvisosModel.getSelectedDates()[0] : null)),
				successHandlerCallback : setTemplatesDetalladoHandlerDoOnLoad,
				errorHandlerCallBack : defaultErrorHandler
			});
		};

		var getTemplateDetalladoSearchDTO = function(codigoCanalEntrada,codigoAgrupamientoProductoTecnico, codigoTipoOperacion, codigoNivelEstructura,fechaPublicacion) {
			var templateDetalladoSearchDTO = new TemplateDetalladoSearchDTO({});
			templateDetalladoSearchDTO.codigoAgrupamientoProductoTecnico = codigoAgrupamientoProductoTecnico;
			templateDetalladoSearchDTO.codigoTipoOperacion = codigoTipoOperacion;
			templateDetalladoSearchDTO.codigoNivelEstructura = codigoNivelEstructura;
			templateDetalladoSearchDTO.codigoCanalEntrada = codigoCanalEntrada;
			templateDetalladoSearchDTO.fechaVigencia = fechaPublicacion;

			return templateDetalladoSearchDTO;
		};

		var setTemplatesDetalladoHandlerDoOnLoad = function(data) {

			var templatesDetallado = arrayUtils.buildArrayObjFromJSON(data.templates, ProductoComercialTemplateDTO);
			crearAvisosModel.setTemplatesDetallado(templatesDetallado);
			renderizarTemplates();

			initImagen();
			initPopupPictos();
			initPopupMateriales();
			initPopupColor();

		};

		var verificarExistenDatosOrden = function() {
			var existenDatos = false;
			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;

			if( (aviso.textoLibreJustificado !== null && aviso.textoLibreJustificado !== "") &&
				(aviso.preview !== null && aviso.preview.contenido !== null &&
					aviso.preview.codigo !== null && aviso.preview.codigo !== undefined  &&
					aviso.preview.repo !== null && aviso.preview.repo !== undefined) ) {
					existenDatos = true;
			}


			return existenDatos;
		};

		var renderPantalla = function(){

			var breadcrum_text = selectionBarUtils.generarTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarZonasTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarNivelEstructuraTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarFechasTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarOrdenamientosTextoSeleccionaste(crearAvisosModel);

			/* Modifico el texto del popup de "Ver Seleccion" con lo seleccionado hasta el momento */
			modifyVerSeleccionadoText(breadcrum_text);

			ui.textoSeleccionaste[0].innerHTML = breadcrum_text;

			$("#wizardPaso4").addClass("active").removeClass("complete");

			if (crearAvisosModel.getCodigoTemplateDestaqueSeleccionado() !== null) {

				var templateDetallado = obtenerTemplate(crearAvisosModel.getCodigoTemplateDestaqueSeleccionado());

				if(crearAvisosModel.getTemplateTienePictoSeleccionado() == true){
					agrandarComponenteDestaquePicto();
				}
				else if(crearAvisosModel.getTemplateTieneFondoColor() == true){
					agrandarComponenteDestaqueColor();
				}else if(crearAvisosModel.getTemplateTieneMaterial() == true){
					agrandarComponenteDestaqueMaterial();
				}

			}

			evaluateChange({
				"newData" : new GeneratedDataStep6({
					"codigoImagenDestaque" : crearAvisosModel.getCodigoImagenDestaqueSeleccionada(),
					"repoImagenDestaque" : crearAvisosModel.getRepoImagenDestaqueSeleccionada(),
					"codigoProductoComercial" : crearAvisosModel.getCodigoProductoComercialDestaque(),
					"codigoTemplateDetallado" :	crearAvisosModel.getCodigoTemplateDestaqueSeleccionado()
				})
			});

		};

		var buildJustificar = function(){

			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;

			if(crearAvisosModel.getCodigoProductoComercialDestaque()!=null
					&& crearAvisosModel.getCodigoTemplateDestaqueSeleccionado()!=null){

	    			if(aviso.preview === null){
	    				aviso.preview = buildImagenDTO();
	    			}

					if(crearAvisosModel.getCodigoImagenDestaqueSeleccionada()!=null
	    				&& crearAvisosModel.getRepoImagenDestaqueSeleccionada()!=null){

						modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {"codigoProductoComercial":crearAvisosModel.getCodigoProductoComercialDestaque(),"codigoTemplateDetallado":crearAvisosModel.getCodigoTemplateDestaqueSeleccionado(),"codigoImagenDestaque":crearAvisosModel.getCodigoImagenDestaqueSeleccionada(),"repoImagenDestaque":crearAvisosModel.getRepoImagenDestaqueSeleccionada() }, function (index, aviso, args){
							aviso.productoComercial.codigo = args.codigoProductoComercial;
							aviso.templateDetallado.codigo = args.codigoTemplateDetallado;
							aviso.preview.codigo = args.codigoImagenDestaque ;
							aviso.preview.repo = args.repoImagenDestaque;});

					} else if (crearAvisosModel.getTemplateTieneFondoColor()!=null){

						modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {"codigoProductoComercial":crearAvisosModel.getCodigoProductoComercialDestaque(),"codigoTemplateDetallado":crearAvisosModel.getCodigoTemplateDestaqueSeleccionado()}, function (index, aviso, args){
							aviso.productoComercial.codigo = args.codigoProductoComercial;
							aviso.templateDetallado.codigo = args.codigoTemplateDetallado;});
					} else if (crearAvisosModel.getTemplateTieneMaterial()!=null){
						modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {
							"codigoProductoComercial":crearAvisosModel.getCodigoProductoComercialDestaque(),
							"codigoTemplateDetallado":crearAvisosModel.getCodigoTemplateDestaqueSeleccionado(),
						}, function (index, aviso, args){
							aviso.productoComercial.codigo = args.codigoProductoComercial;
							aviso.templateDetallado.codigo = args.codigoTemplateDetallado;
						});
					}

    		}
    		else{
    			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {"codigoTemplateDetallado":crearAvisosModel.getCodigoTemplateDetallado() }, function (index, aviso, args){
    				aviso.templateDetallado.codigo = args.codigoTemplateDetallado;});
    		}
    		return crearAvisosModel.getOrdenDePublicacion();

		};

		var initComponenteDestaque = function(){
			$.each(crearAvisosModel.getTemplatesDetallado(),function(index, templateDetallado) {
				if (templateDetallado.templateDetallado.tieneImagenesPrediseniadas) {
					achicarComponenteDestaquePicto();
				} else if(templateDetallado.templateDetallado.tieneColor) {
					achicarComponenteDestaqueColor();
				}
			});
		}

		var isFooterEventOnEdit = function(args){
			return (args.event === StateEvents.PREVIOUS_FOOTER_EDIT ||
						args.event === StateEvents.NEXT_FOOTER_EDIT);
		};

		var isFirstAccessOnEdit = function(args){
			return (isFooterEventOnEdit(args) && !accedida && verificarExistenDatosOrden());
		};

		var evaluateChange = function (args){

			var change = false;
			var codigoImagenDestaqueEquals 		= true;
			var repoImagenDestaqueEquals 		= true;
			var codigoProductoComercialEquals 	= true;
			var codigoTemplateDetalladoEquals 	= true;

			if (model.generatedData.codigoImagenDestaque !== args.newData.codigoImagenDestaque){
				codigoImagenDestaqueEquals = false;
			}

			if (model.generatedData.repoImagenDestaque !== args.newData.repoImagenDestaque){
				repoImagenDestaqueEquals = false;
			}

			if (model.generatedData.codigoProductoComercial !== args.newData.codigoProductoComercial){
				codigoProductoComercialEquals = false;
			}

			if (model.generatedData.codigoTemplateDetallado !== args.newData.codigoTemplateDetallado){
				codigoTemplateDetalladoEquals = false;
			}

			if (!codigoImagenDestaqueEquals || !repoImagenDestaqueEquals || !codigoProductoComercialEquals || !codigoTemplateDetalladoEquals) {
				change = true;
			}

			// Guardo la nuevo info.
			model.generatedData.codigoImagenDestaque = args.newData.codigoImagenDestaque;
			model.generatedData.repoImagenDestaque = args.newData.repoImagenDestaque;
			model.generatedData.codigoProductoComercial = args.newData.codigoProductoComercial;
			model.generatedData.codigoTemplateDetallado = args.newData.codigoTemplateDetallado;

			model.notifyChange = change;
		};

		var subidaMaterialComponente = function(){

			$(".image-editor").show();
			var anchoImagenPreview = 0;
			var altoImagenPreview = 0;
			var tipoArchivo = "";
			var validaPesoImagen = 0;

			$("#previewHolderP6 .cropit-image-zoom-input").width(anchoImagenPreview-20);
			var altoImagenPreviewInit = $("#previewHolderP6 img").height();


			$.each(crearAvisosModel.getTemplatesDetallado(), function(index, tD) {
				if(tD.templateDetallado.tieneMaterial){
					validaAltoImagenPreview = tD.templateDetallado.alto;
					validaAnchoImagenPreview = tD.templateDetallado.ancho;
					altoImagenPreview = tD.templateDetallado.alto;
					anchoImagenPreview = tD.templateDetallado.ancho;
					extensionArchivo = tD.templateDetallado.extensionesMaterial;
					validaPesoImagen = tD.templateDetallado.pesoMaterial;
				}
			});

			var validaPesoImagenBytes = validaPesoImagen;
			var altoImgVal, anchoImgVal, pesoImgVal, extImgVal;

			var cambiaClaseErrorImagen = function(altoImgVal, anchoImgVal, pesoImgVal, extImgVal){

				if(altoImgVal){
					$(".msgDimensionesAlto").removeClass("errorImagen").addClass("okImagen");
				}else{
					$(".msgDimensionesAlto").removeClass("okImagen").addClass("errorImagen");
				}

				if(anchoImgVal){
					$(".msgDimensionesAncho").removeClass("errorImagen").addClass("okImagen");
				}else{
					$(".msgDimensionesAncho").removeClass("okImagen").addClass("errorImagen");
				}

				if(pesoImgVal){
					$("#msgPeso").removeClass("errorImagen").addClass("okImagen");
				}else{
					$("#msgPeso").removeClass("okImagen").addClass("errorImagen");
				}

				if(extImgVal){
					$("#msgExtension").removeClass("errorImagen").addClass("okImagen");
				}else{
					$("#msgExtension").removeClass("okImagen").addClass("errorImagen");
				}

				if(altoImgVal && anchoImgVal && pesoImgVal && extImgVal){
					$("#boxImage").removeClass("hidden");
					$("#loading").addClass("hidden");
					$("#errorMsg").addClass("hidden");
				}else{
					muestraErrorImagen();
				}

			};

			var muestraErrorImagen = function(){
				$("#boxImage").addClass("hidden");
				$("#loading").addClass("hidden");
				$("#errorMsg").removeClass("hidden").fadeIn();
			};

			var validacionMaterial = function(){
				var anchoArchivoSubido = $(".imgOculta").width();
				var altoArchivoSubido = $(".imgOculta").height();

				if(anchoArchivoSubido >= validaAnchoImagenPreview){
					anchoImgVal = true;
				}else{
					anchoImgVal = false;
				}
				if(altoArchivoSubido >= validaAltoImagenPreview){
					altoImgVal = true;
				}else{
					altoImgVal = false;
				}
				if(tamanoArchivo <= validaPesoImagenBytes){
					pesoImgVal = true;
				}else{
					pesoImgVal = false;
				}
				if(tipoArchivo === "image/jpeg"){
					extImgVal = true;
				}else{
					extImgVal = false;
				}
			};

			$('.image-editor').cropit({
				imageBackground: true,
				imageBackgroundBorderWidth: 20,
				width: anchoImagenPreview,
				height: altoImagenPreview,
				exportZoom: 1,
				maxZoom: 2,

				onFileChange: function(event){
					archivo = event.target.files[0];
					tipoArchivo = archivo.type;
					nombreArchivo = archivo.name;
					tamanoArchivo = archivo.size;
					extArchivo = nombreArchivo.substr(nombreArchivo.lastIndexOf('.') + 1);
					$("#btnWizardNext").addClass("disabledBtn");
					$("#boxImage").removeClass("hidden");
					$("#loading").removeClass("hidden");
					$("#errorMsg").addClass("hidden");
					$("#previewHolderP6#previewHolderP6").width("40%");

					for (var j = 0; j < extensionArchivo.length; j++) {
						var sCurExtension = extensionArchivo[j].tipo;
						if (extArchivo == sCurExtension.toLowerCase()) {
							extImgVal = true;
							break;
						}
					}

					var reader = new FileReader();
					reader.onload = function (e) {
						var img = new Image;
						img.onload = function() {
							img.className = "imgOculta";
							$("#imgSubidaOculta").html(img);
							$("body").css({"overflow-x":"hidden"});
						};
						img.src = reader.result;
					};

					reader.readAsDataURL(archivo);

				},
				onFileReaderError: function(event){
					var anchoArchivoSubido = $(".imgOculta").width();
					var altoArchivoSubido = $(".imgOculta").height();
					muestraErrorImagen();
					validacionMaterial();
					cambiaClaseErrorImagen(altoImgVal, anchoImgVal, pesoImgVal, extImgVal);

				},
				onImageLoading: function(){
					$("#errorMsg").addClass("hidden");
					$("#loading").removeClass("hidden");
				},
				onImageLoaded: function(){
					validacionMaterial();
					$(".cropit-image-zoom-input").width(anchoImagenPreview);
					cambiaClaseErrorImagen(altoImgVal, anchoImgVal, pesoImgVal, extImgVal);
				},
				onImageError: function(object,number,string){
					$("#boxImage").addClass("hidden");
					validacionMaterial();
					if(object.code === 0){
						$("#loading").addClass("hidden");
						$("#errorMsg").removeClass("hidden").fadeIn();
						altoImgVal = true;
						anchoImgVal = true;
						pesoImgVal = true;
						extImgVal = true;
					} else if(object.code === 1){
						$("#errorMsg").removeClass("hidden").fadeIn();

					} else {
						$("#errorMsg").removeClass("hidden").fadeIn();
					}
					cambiaClaseErrorImagen(altoImgVal, anchoImgVal, pesoImgVal, extImgVal);
				}
			});

			$('.btn-retry').click(function() {
				if(crearAvisosModel.getTemplateTieneMaterial() !== true){
					$("#btn-elige-archivo").trigger("click");
				}else{
					g_cambiaMaterial();
				}
			});

			$('.btnAceptarImagen').click(function(event) {
				var attr = $(".image-editor").attr('style');
				if (typeof attr !== typeof undefined && attr !== false) {
					$(".image-editor").removeAttr("style").removeClass("superPuesta");
					$(".boxImgPreview").css({"height": "auto"});
				}
				event.preventDefault();
				event.stopPropagation();

				var imageData = $('.image-editor').cropit('export',{
					type: 'image/jpeg',
					quality: 1,
					originalSize: false
				});

				$("#radioMaterial").remove();
				$(".box-material").prepend("<input class='css-radio-material' type='checkbox' id='radioMaterial' data-codigo-eliminar='{{templateDetallado.codigo}}' data-id-eliminar='{{templateDetallado.id}}' data-productoComercial-eliminar='{{codigoProductoComercial}}'>");
				$(".image-editor").remove();
				$("div[id^='selDestaqueMaterialBox']").parent().addClass("destaqueActivado");
				$(".opcionesMaterial").show();
				$("#radioMaterial").attr("checked", "checked");

				enviaMaterial($(".css-label-radio-material"),imageData, extArchivo);

			});

			$('.btnCancelar').click(function() {
				var attr = $(".image-editor").attr('style');
				if (typeof attr !== typeof undefined && attr !== false) {
					$(".image-editor").removeAttr("style").removeClass("superPuesta");
					$(".boxImgPreview").css({"height": "auto"});
				}
				limpiaComponenteSubida();
			});
		};

		var limpiaComponenteSubida = function(){
			$("#previewHolderP6#previewHolderP6").width("30%");
			$(".btnAceptarImagen").remove();
			$(".cropit-buttons").append("<a class='btn btn-primary btnAceptarImagen' title='Envia la imagen seleccionada'>Aceptar</a>");
			$("#boxImage").addClass("hidden");

		};

		var enviaMaterial = function(component, imagenRecortada, extensionImagen){

			var codigoTemplate = $(".css-label-radio-material").data("codigo");
			var idTemplate = $(".css-label-radio-material").data("id");
			var codigoProductoComercialDestaque = $(component).data("productocomercial");

			crearAvisosModel.setCodigoTemplateDestaqueSeleccionado(codigoTemplate);
			crearAvisosModel.setCodigoProductoComercialDestaque(codigoProductoComercialDestaque);
			crearAvisosModel.setCodigoImagenDestaqueSeleccionada(null);
			crearAvisosModel.setRepoImagenDestaqueSeleccionada(null);
			crearAvisosModel.setTemplateTieneFondoColor(null);
			crearAvisosModel.setTemplateTieneMaterial(true);
			crearAvisosModel.setContenidoTieneMaterial(imagenRecortada);
			crearAvisosModel.setCodigoNivelEstructuraDestaque(crearAvisosModel.getCodigoNivelEstructura());

			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			aviso.templateDetallado.codigo = crearAvisosModel.getCodigoTemplateDestaqueSeleccionado();
			aviso.productoComercial.codigo = crearAvisosModel.getCodigoProductoComercialDestaque();

			// Agrego material adjuntado por usuario como material al aviso de la orden publicación.
			aviso.materiales = [];
			var material = new ImagenDTO({});
			material.contenido = imagenRecortada;
			material.tipo = "IMAGEN";
			material.extension = extensionImagen;

			aviso.materiales.push(material);

			executeJustificarValidarPromosTasarCaller();

		};

		// ------------------------------------------------
		// private interface -----------------------------
		// ------------------------------------------------

		var generateTag = function() {
			decoratorModel.setA2("como-sera-tu-aviso.destaque");
			var area = decoratorModel.getA1() + decoratorModel.getA2();
			gChangeTagName(area);
		};

		// ------------------------------------------------
		// common interface ------------------------------
		// ------------------------------------------------

		var modificada = false;

		var accedida = false;

		var index = 6;

		var doOnObserver = args.doOnObserver;

		var ui = {
			textoSeleccionaste			: $("#textoSeleccionaste"),
			divTextoSeleccionaste		: $("#divTextoSeleccionaste"),
			selPictosBox				: $("#selPictosBox"),
			selDestaqueColorBox			: $("#selDestaqueColorBox"),
			footer						: $("#footerRol"),
			paso6DestacaAviso			: $("#paso6-Destaca-Aviso"),
			previewHolder				: $("#previewHolderP6"),
			valorAviso					: $("#valorAvisoP6"),
			lblPreview					: $("#lblPreviewP6"),
			valorMontoConPromocion		: $("#valorConPromoP6"),
			valorMontoSinPromo			: $("#valorSinPromoP6"),
			labelprecio					: $("#lblPrecioSinPromoP6"),
			labelNombreDePromo			: $("#lblPrecioConPromoP6"),
			labelTotal					: $("#lblPrecioTotalP6"),
			idDesglose					: $("#desglosePreciosP6"),
			btnWizardNext				: $("#btnWizardNext")
		};

		var model = {
			notifyChange : false,
			generatedData : new GeneratedDataStep6({}),
		};

		/**
		 * { event : StateEvents.EVENT_CONST, }
		 */
		var doOnEnter = function(args) {
			showBreadcrum("PASO6");
			showPanelSeleccionado("PASO6");
			// Implements -----
			generateTag();
			initImagen();
			if (args.event === StateEvents.PREVIOUS_FOOTER_ON_LOAD || isFirstAccessOnEdit(args)) {
				doOnLoad(args);
			} else {
				if ( !verificarExistenDatosOrden() || !accedida) {
					accedida = true;
					limpiarComponentes();
					renderizarTemplates();
					initImagen();
					renderPantalla();
					initPopupPictos();
					initPopupMateriales();
					initPopupColor();
				}
				doOnComplete({});
			}
		};

		/**
		 * { event : StateEvents.EVENT_CONST, }
		 */
		var doOnExit = function(args) {
			$("#ascrail2000").hide();
			evaluateChange({
				"newData" : new GeneratedDataStep6({
					"codigoImagenDestaque" : crearAvisosModel.getCodigoImagenDestaqueSeleccionada(),
					"repoImagenDestaque" : crearAvisosModel.getRepoImagenDestaqueSeleccionada(),
					"codigoProductoComercial" : crearAvisosModel.getCodigoProductoComercialDestaque(),
					"codigoTemplateDetallado" :	crearAvisosModel.getCodigoTemplateDestaqueSeleccionado()
				})
			});

			doOnObserver({"eventsTransform" : [ StateEvents.ACCEPT_TO_NEXT ]});
		};

		var doOnError = function(args) {
			// Implements -----
		};

		var doOnCancel = function(args) {

			if (crearAvisosModel.getTemplatesDetallado() !== null) {
				$.each(crearAvisosModel.getTemplatesDetallado(), function(index, templateDetallado) {
					achicarComponenteDestaquePicto();
				});
				crearAvisosModel.setCodigoImagenDestaqueSeleccionada(null);
				crearAvisosModel.setRepoImagenDestaqueSeleccionada(null);
				crearAvisosModel.setTemplateTieneFondoColor(null);
				crearAvisosModel.setCodigoTemplateDestaqueSeleccionado(null);
				crearAvisosModel.setCodigoProductoComercialDestaque(null);
				crearAvisosModel.setTemplatesDetallado(null);
				crearAvisosModel.setCodigoNivelEstructuraDestaque(null);
				crearAvisosModel.setTemplateTienePictoSeleccionado(null);
				crearAvisosModel.setTemplateTieneMaterial(null);

			}
		};

		var doOnChange = function(args) {
			//doOnCancel({});
		};

		var doOnLoad = function(args) {
			// Implements -----
			$("#btn-Previsualizar").addClass("hidden");
			$("#navFooterWizard").css({"height" : "110px"});
			$(".cancelar-wrapper").removeAttr("style");
			showBreadcrum('PASO6');
			showPanelSeleccionado('PASO6');
			accedida = true;
			obtenerDestaquesDoOnLoad();
			renderPantalla();

		};

		var doOnExitScreen = function(args) {};

		var doOnShow = function(args) {
			// Skip de la pantalla.
			if ( ( args.event === StateEvents.NEXT_FOOTER || args.event === StateEvents.NEXT_FOOTER_EDIT ) && (crearAvisosModel.getTemplatesDetallado() === null || crearAvisosModel.getTemplatesDetallado().length === 0)) {
				doOnObserver({"event" : StateEvents.NEXT_SKIP});
			} else if ( ( args.event === StateEvents.PREVIOUS_FOOTER || args.event === StateEvents.PREVIOUS_FOOTER_EDIT ) && (crearAvisosModel.getTemplatesDetallado() === null || crearAvisosModel.getTemplatesDetallado().length === 0)) {
				doOnObserver({"event" : StateEvents.PREVIOUS_SKIP});
			}
		};

		var doOnComplete = function(args) {
			// Evaluate Complete
			if (isComplete(args)) {
				doOnObserver({"eventEnabled" : StateEvents.NEXT_ENABLED});
			} else {
				doOnObserver({"eventEnabled" : StateEvents.NEXT_DISABLED});
			}
		};

		var bind = function(args) {
			// Implements -----
		};

		var unbind = function(args) {
			// Implements -----
		};

		var isComplete = function(args) {
			return true;
		};

		var notifyChange = function(args) {
			return model.notifyChange;
		};

		var getAccedida = function() {

			return accedida;
		};

		var initPopupPictos = function() {
			datos = {
				idPopUp				: "popUpPictos",
				classTipoMensaje	: "popUpInfo", // Puede ser "popUpAlerta", "popUpInfo" o "popUpError"
				titulo				: "Seleccion\u00E1 una imagen:",
				txtBoton1			: "Cancelar",
				txtBoton2			: "Aceptar",
				classBoton1 		: "btn-link",
				funcionBoton1		: "gOnclickCancelarPictosHandler(this)",
				funcionBoton2		: "gOnclickAceptarPictosHandler(this)" // Vacio, si solo tiene un boton

			};
			var source = DecoratorTemplates.modalPopUpWindow;
			var template = Handlebars.compile(source);
			var html = template(datos);

			ui.footer.append(html);

		};

		var initPopupMateriales = function() {
			datos = {
				idPopUp				: "popUpMateriales",
				classTipoMensaje	: "popUpAlerta", // Puede ser "popUpAlerta", "popUpInfo" o "popUpError"
				txtBoton1			: "Cancelar",
				txtBoton2			: "Aceptar",
				classBoton1 		: "btn-link",
				funcionBoton1		: "gOnclickCancelarMaterialHandler(this)",
				funcionBoton2		: "gOnclickAceptarMaterialHandler(this)" // Vacio, si solo tiene un boton

			};
			var source = DecoratorTemplates.modalPopUpWindow;
			var template = Handlebars.compile(source);
			var html = template(datos);

			ui.footer.append(html);

		};

		var initPopupColor = function() {
			datos = {
				idPopUp				: "popUpColor",
				classTipoMensaje	: "popUpAlerta", // Puede ser "popUpAlerta", "popUpInfo" o "popUpError"
				txtBoton1			: "Cancelar",
				txtBoton2			: "Aceptar",
				classBoton1 		: "btn-link",
				funcionBoton1		: "gOnclickCancelarColorHandler(this)",
				funcionBoton2		: "gOnclickAceptarColorHandler(this)" // Vacio, si solo tiene un boton

			};
			var source = DecoratorTemplates.modalPopUpWindow;
			var template = Handlebars.compile(source);
			var html = template(datos);

			ui.footer.append(html);

		};

		var initColeccionImagenes = function(args) {

			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_IMAGENES,
				dataObject : new TemplateDetalladoDTO({codigo : args}),
				successHandlerCallback : obtenerColeccionImagenesHandler,
				errorHandlerCallBack : defaultErrorHandler
			});

		};

		var obtenerColeccionImagenesHandler = function(args) {
			crearAvisosModel.imagenes = args.imagenes;

			var source = CrearAvisosTemplates.renderImagenes;
			var template = Handlebars.compile(source);
			var context = {
				imagenes : crearAvisosModel.imagenes
			};
			var html = template(context);
			$("#popUpPictos .modal-body").html(html);
		};

		var tasarHandler = function(data) {

			var aviso = data.ROLResult.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			var promociones = [];
      		if(aviso.avisoPromocion !== undefined){
      			$.each(aviso.avisoPromocion, function(indexPromociones,avisoPromo){
      				promociones.push(avisoPromo.promocion);
      			})
      		}
      		crearAvisosModel.setPromociones(promociones);
			crearAvisosModel.setOrdenDepublicacionHistory(data.ROLResult);
			crearAvisosModel.setOrdenDePublicacion(data.ROLResult);

			previewAviso();
		};

		var justificarHandler = function (data){
			return data.ROLResult;
		}
		var processCallBackJustificar = function(staticObject,data){
			return staticObject;
		}
		var processCallBackTasar = function(staticObject,data){
			return data;
		}

		var validarPromocionesHandler = function (data){

			var orden =data.ROLResult.ordenPublicacion;
			var aviso = orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			var promocionesAplicables = data.ROLResult.promocionesAplicables;
			var avisoPromocionList = [];



			if(promocionesAplicables != undefined){
				$.each(promocionesAplicables, function(index, promocion){
					var avisoPromocion = new AvisoPromocionDTO({});
					avisoPromocion.promocion = promocion;
					avisoPromocionList.push(avisoPromocion);

				});
				modelIterator.iterateAvisosFromOrden(orden, {"avisoPromocionList":avisoPromocionList}, function(index, aviso, args) {
					aviso.avisoPromocion = args.avisoPromocionList;
				});

	      		if(isPromoEco(promocionesAplicables)){
	      			orden  = armarEstructuraOrdenPromoEco(promocionesAplicables, orden);
	      		}
			} else {
				var promocionesNoAplicables = crearAvisosModel.getPromocionesValidar(index);

				modelIterator.iterateAvisosFromOrden(orden, {"promocionesNoAplicables" : promocionesNoAplicables}, function(index, aviso, args) {
					$.each(args.promocionesNoAplicables, function(indexPromocion, promocionNoAplicable){
						if ($.isArray(aviso.avisoPromocion)){
							$.each(aviso.avisoPromocion, function (indexAvisoPromocion, avisoPromocion){
								if (avisoPromocion.promocion.codigo === promocionNoAplicable.codigo){
									aviso.avisoPromocion.splice(indexAvisoPromocion, 1);
								}
							});
						}
					});
				});

			}

      		return orden;
		};

		var processCallBackValidarPromociones = function(staticObject,processData){
			return new ValidarPromocionesDTO({"promocionesAplicables":staticObject,"ordenPublicacion":processData})
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
				modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), promocionesEnModelo, function(index, avisoOriginal, args) {
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

		var previewAviso = function() {
			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			removeImage();
			ui.previewHolder.find(".imgPreview").html(buildImageUI("imgPreview","data:image/jpeg;base64," + aviso.preview.contenido));
			g_mostrarMontos(ui.labelprecio, ui.labelNombreDePromo,ui.labelTotal, ui.valorMontoConPromocion,ui.valorMontoSinPromo, ui.valorAviso, ui.idDesglose);
			doOnComplete({});
		};

		var removeImage = function() {
			if ($("#imgPreview").length > 0) {
				$("#imgPreview").remove();
			} else if ($("#imgEmpty").length > 0) {
				$("#imgEmpty").remove();
			}
		};

		var initImagen = function() {
			previewAviso();
		};

		var buildImageUI = function(id, src) {
			var img = new Image();
			img.id = id;
			img.src = src;
			return img;
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
			getAccedida			: getAccedida,
			doOnExitScreen		: doOnExitScreen,
			doOnLoad			: doOnLoad

		};

	};

})();