/**
 * author: adifiore version: 1.0.0 require: jquery.js | crear-aviso-model.js |
 * crear-aviso-templates.js | date-utils description: Clase que vincula la UI
 * con la logica, el modelo y el template de componentes.
 */
var StateEvents = {

	// Footer Init State Events:
	INIT_FOOTER					: "INIT_FOOTER",
	// Footer Navigation State Events:
	NEXT_FOOTER					: "NEXT_FOOTER",
	NEXT_FOOTER_EDIT			: "NEXT_FOOTER_EDIT",
	PREVIOUS_FOOTER				: "PREVIOUS_FOOTER",
	PREVIOUS_FOOTER_ON_LOAD		: "PREVIOUS_FOOTER_ON_LOAD",
	PREVIOUS_FOOTER_EDIT		: "PREVIOUS_FOOTER_EDIT",
	// Footer Skip Steps State Events:
	NEXT_SKIP					: "NEXT_SKIP",
	PREVIOUS_SKIP				: "PREVIOUS_SKIP",
	// Footer Enabled/Disabled State Events:
	FOOTER_NAV_DISABLED			: "FOOTER_NAV_DISABLED",
	FOOTER_NAV_ENABLED			: "FOOTER_NAV_ENABLED",
	NEXT_DISABLED				: "NEXT_DISABLED",
	NEXT_ENABLED				: "NEXT_ENABLED",
	PREVIOUS_DISABLED			: "PREVIOUS_DISABLED",
	PREVIOUS_ENABLED			: "PREVIOUS_ENABLED",
	// Footer Transform State Events:
	NEXT_TO_ACCEPT				: "NEXT_TO_ACCEPT",
	NEXT_TO_PAY					: "NEXT_TO_PAY",
	ACCEPT_TO_NEXT				: "ACCEPT_TO_NEXT",
	PREVIOUS_HIDE				: "PREVIOUS_HIDE",
	PREVIOUS_SHOW				: "PREVIOUS_SHOW",
	LOGIN						: "LOGIN",
	FINISH						: "FINISH",

	// Footer Toggle State Events:
	SHOW_TOOLTIP_NEXT			: "SHOW_TOOLTIP_NEXT",
	HIDE_TOOLTIP_NEXT			: "HIDE_TOOLTIP_NEXT",
	// Warper to edit items
	WARP_TO						: "WARP_TO",

	// estado de finalizacion
	FINISH_SUCCES				: "FINISH_SUCCES"
};

//-----------------------------------------------------------------------------
//StateStep1Creacion ---------------------------------------------------------
//-----------------------------------------------------------------------------

// ESTA EN EL ARCHIVO crearAvisoControllerPasoQue.js

//-----------------------------------------------------------------------------
//StateStep2Creacion ---------------------------------------------------------
//-----------------------------------------------------------------------------

//ESTA EN EL ARCHIVO crearAvisoControllerPasoDonde.js

//-----------------------------------------------------------------------------
//StateStep3Creacion ---------------------------------------------------------
//-----------------------------------------------------------------------------

//ESTA EN EL ARCHIVO crearAvisoControllerPasoCuando.js

//-----------------------------------------------------------------------------
//StateStep4Creacion ---------------------------------------------------------
//-----------------------------------------------------------------------------

//ESTA EN EL ARCHIVO crearAvisoControllerPasoComo.js

//-----------------------------------------------------------------------------
//StateStep5Creacion ---------------------------------------------------------
//-----------------------------------------------------------------------------

//ESTA EN EL ARCHIVO crearAvisoControllerPasoComo.js

//-----------------------------------------------------------------------------
//StateStep6Creacion ---------------------------------------------------------
//-----------------------------------------------------------------------------

//ESTA EN EL ARCHIVO crearAvisoControllerPasoComo.js

//-----------------------------------------------------------------------------
//StateStep7Creacion ---------------------------------------------------------
//-----------------------------------------------------------------------------

//ESTA EN EL ARCHIVO crearAvisoControllerPasoConfYPago.js

// -----------------------------------------------------------------------------
// crearAvisoController -------------------------------------------------------
// -----------------------------------------------------------------------------

var crearAvisoController = (function () {

	//------------------------------------------------
	// global interface ------------------------------
	//------------------------------------------------

	//Handler para la 'x' de los popOver dinamicos
	gOnclickCloseTerminastePopoverHandler = function(){
		doOnObserver( {"eventToggle" : { "estado" : StateEvents.HIDE_TOOLTIP_NEXT}  });
	};

	gOnclickRedirectRegistrarHanlder = function(redirectURL){
		g_redirectPageHandler(redirectURL);
	};

	gOnclickRedirectIngresarHanlder = function(redirectURL){
		//redirect(URLConstants.ROL_MIS_AVISOS + "?uuid=" + crearAvisosModel.getOrdenDePublicacion().uuidGenerarOrden)
		g_redirectPageHandler(redirectURL);
	};

	gOnclickRedirectDatosPersonalesHanlder = function(redirectURL){
		g_redirectPageHandler(redirectURL);
	};

	gOnErrorRedirectLoginHandler = function(redirectURL){
		g_redirectPageHandler(redirectURL);
	};

	g_redirectPageHandler = function(redirectURL){
		console.log({ url : CrearAvisoServiceURL.SET_MODEL,
			dataObject : buildModelCrearAvisoDTO(redirectURL),
			successHandlerCallback : redirectHandler,
			errorHandlerCallback : defaultErrorHandler });
			
		blockCallerUI.blockPost({ url : CrearAvisoServiceURL.SET_MODEL,
			dataObject : buildModelCrearAvisoDTO(redirectURL),
			successHandlerCallback : redirectHandler,
			errorHandlerCallback : defaultErrorHandler });
	};

	//Este metodo funciona con los datos cargados en el modelo
	g_mostrarMontos = function(labelPrecio, labelNombrePromo, labelTotal, valorConPromo, valorSinPromo, valorAviso, componenteDesglose) {

		var conceptoVendible = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0];
		var aviso = conceptoVendible.itemsConceptoVendible[0].itemsAviso[0].aviso;

		if (tienePromociones(aviso.avisoPromocion) && (tienePromocionGratuita(conceptoVendible) || tienePromocionSinDesglose(aviso.avisoPromocion))){
			var montosSinDesglose =  {"avisosPromociones" : [], "montoTotal" : 0, "montoTotalSinPromo" : 0, "montoDePromociones" : 0};

			modelIterator.iterateConceptosVendiblesFromOrden(crearAvisosModel.getOrdenDePublicacion(), montosSinDesglose, function(index, conceptoVendibleSinDesglose, args){
				args.montoTotalSinPromo += conceptoVendibleSinDesglose.montoTotal;
			});
			var source   = CrearAvisosTemplates.desglosePromociones;
			var template = Handlebars.compile(source);
			var html     = template(montosSinDesglose);

			componenteDesglose.html(html);
			labelTotal.text("Precio");
			$(".desglose").hide();
			$("#valorAviso").text(montosSinDesglose.montoTotalSinPromo.toFixed(2));
			$("#valorAvisoPromo").text(montosSinDesglose.montoTotalSinPromo.toFixed(2));
		} else {
			var montosConDesglose = {"avisosPromociones" : [], "montoTotal" : 0, "montoTotalSinPromo" : 0, "montoDePromociones" : 0};
			modelIterator.iterateConceptosVendiblesFromOrden(crearAvisosModel.getOrdenDePublicacion(), montosConDesglose, function(index,conceptoVendibleIterado,args){

				modelIterator.iterateItemsConceptoVendible(conceptoVendibleIterado.itemsConceptoVendible, args, function(index, itemConceptoVendibleIterado, args) {

					modelIterator.iterateItemsAviso(itemConceptoVendibleIterado.itemsAviso, args, function(index, itemAvisoIterado, args) {

						if (tienePromociones(itemAvisoIterado.aviso.avisoPromocion)){

							$.each(itemAvisoIterado.aviso.avisoPromocion, function(index, avisoPromocionIterado){

								var avisoPromocionProcesado = buscarAvisoPromocion(args.avisosPromociones, avisoPromocionIterado);

								if (avisoPromocionProcesado){
									avisoPromocionProcesado.montoConIva = (parseFloat(avisoPromocionProcesado.montoConIva) + avisoPromocionIterado.montoConIva).toFixed(2);
								} else {
									var avisoPromocionAInsertar = new AvisoPromocionDTO(avisoPromocionIterado);
									avisoPromocionAInsertar.montoConIva = avisoPromocionAInsertar.montoConIva.toFixed(2);
									args.avisosPromociones.push(avisoPromocionAInsertar);
								}
								if (avisoPromocionIterado.esDescuento){
									args.montoDePromociones -= avisoPromocionIterado.montoConIva.toFixed(2);
								} else {
									args.montoDePromociones += avisoPromocionIterado.montoConIva.toFixed(2);
								}
							});
						}
					});
				});

				args.montoTotal = (new Number(args.montoTotal) + conceptoVendibleIterado.montoTotal).toFixed(2);
			});

			montosConDesglose.montoTotalSinPromo = (new Number(montosConDesglose.montoTotal) - montosConDesglose.montoDePromociones).toFixed(2);

			if (crearAvisosModel.getTemplateTieneMaterial() != null) {
				modelIterator.iterateConceptosVendiblesFromOrden(crearAvisosModel.getOrdenDePublicacion(), montosConDesglose, function(index, conceptoVendible, args) {
					conceptoVendible.montoTotalSinPromo = montosConDesglose.montoTotalSinPromo;
				});
			}
			
			var source   = CrearAvisosTemplates.desglosePromociones;
			var template = Handlebars.compile(source);
			var html     = template(montosConDesglose);

			componenteDesglose.html(html);
			$('.desglose').show();
		}

	};

	g_limpiarMontos = function(labelPrecio, labelNombrePromo, labelTotal, valorConPromo, valorSinPromo, valorAviso) {
		var montoCero = 0;
		valorSinPromo.text(montoCero.toFixed(2));
		labelTotal.text("Precio");
		$(".desgloce").hide();
		valorAviso.text(montoCero.toFixed(2));
	};

	//------------------------------------------------
	// private interface -----------------------------
	//------------------------------------------------

	var tienePromociones = function(avisosPromocion){
		return ($.isArray(avisosPromocion) && avisosPromocion.length > 0);
	}

	var tienePromocionGratuita = function(conceptoVendible){
		return (conceptoVendible.montoTotal === 0);
	};

	var tienePromocionSinDesglose = function(avisosPromocion){
		var result = false;
		$.each($(avisosPromocion).toArray(), function(index, avisoPromo){
			if (!avisoPromo.porcentaje){
				result = true;
				return;
			}
		});
		return result;
	};

	var buscarAvisoPromocion = function(avisosPromocion, avisoPromocion){
		var result = $.grep(avisosPromocion, function (avisoPromocionIterado, index){
			return (avisoPromocion.promocion.codigo === avisoPromocionIterado.promocion.codigo);
		});
		return arrayUtils.singleResult(result);
	};

	var removeModelHandler = function (data){
		// implements.
	};

	var buildModelCrearAvisoDTO = function(redirectURL){

		steps[crearAvisosModel.getStep()].doOnExitScreen();

		var previsualizo = crearAvisosModel.getStep() >= 4 ? crearAvisosModel.getPrevisualizo() : false;
		var modelCrearAvisoDTO = new ModelCrearAvisoDTO({
			"redirectURL"						: redirectURL,
			"previsualizo"						: previsualizo,
			"ordenPublicacion"					: crearAvisosModel.getOrdenDePublicacion(),
			"step"								: crearAvisosModel.getStep(),
			"codigoAgrupamientoProductoTecnico"	: crearAvisosModel.getCodigoAgrupamientoProductoTecnico(),
			"codigoNivelEstructura"				: crearAvisosModel.getCodigoNivelEstructura(),
			"tipoOperacion"						: crearAvisosModel.getTipoOperacion(),
			"codigoProducto"					: crearAvisosModel.getCodigoProducto(),
			"codigoProductoComercial"			: crearAvisosModel.getCodigoProductoComercial(),
			"codigoTemplateDetallado"			: crearAvisosModel.getCodigoTemplateDetallado(),
			"familia"							: crearAvisosModel.getFamilia(),
			"clase"								: crearAvisosModel.getClase(),
			"zonasComercializacion"				: crearAvisosModel.getZonasComercializacion(),
			"ordenamientos"						: crearAvisosModel.getOrdenamientos(),
			"mapItemsOrdenamientoCombo"			: crearAvisosModel.getMapItemsOrdenamientoCombo(),
			"selectedDates"						: crearAvisosModel.getSelectedDates(),
			"palabrasProhibidas"				: crearAvisosModel.getPalabrasProhibidas(),
			"configuracionOrdenamientoPantalla"	: crearAvisosModel.getConfiguracionesOrdenamientoPantalla(),
			"codigoGATEWAYSeleccionado"			: crearAvisosModel.getCodigoGATEWAYSeleccionado(),
			"templatesDetallado"				: crearAvisosModel.getTemplatesDetallado(),
			"ordenDepublicacionHistory"			: crearAvisosModel.getOrdenDePublicacionHistory(),
			"codigoTemplateDestaqueSeleccionado": crearAvisosModel.getCodigoTemplateDestaqueSeleccionado(),
			"codigoImagenDestaqueSeleccionada"	: crearAvisosModel.getCodigoImagenDestaqueSeleccionada(),
			"repoImagenDestaqueSeleccionada"	: crearAvisosModel.getRepoImagenDestaqueSeleccionada(),
			"tienePictoSeleccionado"			: crearAvisosModel.getTemplateTienePictoSeleccionado(),
			"tieneFondoColor"					: crearAvisosModel.getTemplateTieneFondoColor(),
			"tieneMaterial"						: crearAvisosModel.getTemplateTieneMaterial(),
			"materiales"						: crearAvisosModel.getMateriales(),
			"codigoProductoComercialDestaque"	: crearAvisosModel.getCodigoProductoComercialDestaque(),
			"codigoNivelEstructuraDestaque"		: crearAvisosModel.getCodigoNivelEstructuraDestaque(),
			"configuracionesPromocionPantalla"	: crearAvisosModel.getConfiguracionesPromocionPantalla(),
			"agrupadoresAtributoAviso"			: crearAvisosModel.getAgrupadoresAtributoAviso(),
			"promociones"						: crearAvisosModel.getPromociones()
		});

		return modelCrearAvisoDTO;
	};

	var hasUUID = function (){
		var uuid = GetURLParameters("uuid");
		return (uuid !== undefined && uuid !== "" && uuid !== "undefined");
	};

	var hasTemplatePrecarga = function (){
		var template = GetURLParameters("template");
		return (template !== undefined && template !== "");
	};

	var hasTrackCampana = function(){
		var fuente = GetURLParameters("fuente");
		var medio = GetURLParameters("medio");
		var campana = GetURLParameters("campana");

		if( (fuente !== undefined && fuente !== "") &&
				(medio !== undefined && medio !== "") &&
				(campana !== undefined && campana !== "")	){
			return true;
		}

		return false;
	}

	var redirectHandler = function(data){
		console.log(data.url);
		redirect(data.url);
	};

	var restart = function (){

		if (hasUUID()){
			blockCallerUI.blockPost({ url : CrearAvisoServiceURL.REMOVE_MODEL,
				dataObject : buildModelSearchDTO(GetURLParameters("uuid")),
				successHandlerCallback : removeModelHandler,
				errorHandlerCallback : defaultErrorHandler });
		}

		redirect(URLConstants.ROL_CREAR_AVISO);
	};


	var footerNavWizard = function(){

		var source   = CrearAvisosTemplates.navigationFooter;
		var template = Handlebars.compile(source);
		var html     = template();

		ui.navFooterWizard.append(html);

		// bind components to ui
		ui.btnWizardPrev	= $("#btnWizardPrev");
		ui.btnWizardNext	= $("#btnWizardNext");
		ui.btnWizardCancel	= $("#btnWizardCancel");
		ui.wrapperAction	= $("section#wrapperAction");
		ui.wrapperAction.addClass("container");
	};

	var MIN_INDEX_STEP = 0;
	var MAX_INDEX_STEP = 7;
	var STEP_REQUIRE_LOGIN = 6;
	var STEP_PAY_ORDER = 7;

	var ui = {
		mainContainer		: $("#mainApp"),
		navFooterWizard		: $("#navFooterWizard"),
		wizard				: $("#MyWizard"),
		wrapperAction		: null,
		btnWizardPrev		: null,
		btnWizardNext		: null,
		btnWizardCancel		: null,
		menuLogueado		: $("#menuLogueado"),
		menuNoLogueado		: $("#menuNoLogueado"),
		menuMailNoValidado	: $("#menuMailNoValidado"),
		menuSinCapturador	: $("#menuSinCapturador")
	};

	var model = {
		// implements.
	};

	var label = {
		aceptar		: "Aceptar",
		siguiente	: "Siguiente",
		login		: "Ingresar",
		pagar		: "Pagar",
		finalizar	: "Finalizar"
	};

	var steps = [];

	var initUIComponents = function (){

		footerNavWizard();
		steps.push(new StateStep1Creacion({"doOnObserver" : doOnObserver}));
		steps.push(new StateStep2Creacion({"doOnObserver" : doOnObserver}));
		steps.push(new StateStep3Creacion({"doOnObserver" : doOnObserver}));
		steps.push(new StateStep4Creacion({"doOnObserver" : doOnObserver}));
		steps.push(new StateStep5Creacion({"doOnObserver" : doOnObserver}));
		steps.push(new StateStep6Creacion({"doOnObserver" : doOnObserver}));
		steps.push(new StateStep7Creacion({"doOnObserver" : doOnObserver, "isCapturaModificada" : isCapturaModificada}));
		steps.push(new StateStep8Creacion({"doOnObserver" : doOnObserver}));

		var wizard  = $("#myWizard").wizard();
		wizard.off("click", "li.complete");
		// initialize first step ------------
		steps[0].bind({ event : StateEvents.INIT_FOOTER });
		if (!hasUUID() && !hasTemplatePrecarga()){
			steps[0].doOnEnter({ event : StateEvents.INIT_FOOTER });
		}

	};

	var onChangeStepWizardHandler = function(){
		// Implements -----
	};

	var onChangedStepWizardHandler = function(){
		// Implements -----
	};

	var onFinishedStepWizardHandler = function(){

		if (hasUUID()){
			blockCallerUI.blockPost({ url : CrearAvisoServiceURL.REMOVE_MODEL,
				dataObject : buildModelSearchDTO(GetURLParameters("uuid")),
				successHandlerCallback : removeModelHandler,
				errorHandlerCallback : defaultErrorHandler });
		}

		redirect(URLConstants.ROL_MIS_AVISOS + "?uuid=" + crearAvisosModel.getOrdenDePublicacion().uuidGenerarOrden);
	};

	var onStepClickStepWizardHandler = function(){
		// Implements -----
	};

	var onClickNextWizardHandler = function(){

		var selectedItem	= ui.wizard.wizard("selectedItem");
		var currentIndex	= selectedItem.step -1;
		var nextIndex		= selectedItem.step;

		if (ui.btnWizardNext.hasClass("disabledBtn")){
			return false;
		}

		if (steps[currentIndex].isComplete({})){

			//Si el usuario se deslogueo por alguna razon y esta en el paso de pagar, debe iniciar sesion
			if (currentIndex === STEP_PAY_ORDER && decoratorController.getCookieUsuario() === null &&
					decoratorController.getCookieCapturador() === null) {

				crearAvisosModel.getOrdenDePublicacion().domicilio = domicilioFacturacion;

				gOnclickRedirectIngresarHanlder(URLConstants.ROL_LOGIN_AUTH0);

			} else {

				if (currentIndex >= MIN_INDEX_STEP){
					if (crearAvisosModel.esOrdenDePublicacionPersistida()){
						steps[currentIndex].doOnExit({ event : StateEvents.NEXT_FOOTER_EDIT });
					} else {
						steps[currentIndex].doOnExit({ event : StateEvents.NEXT_FOOTER });
					}
					steps[currentIndex].unbind({});
				}

				//Si el modelo no tiene el usuario y el paso requiere que se inicie sesion, se lo redirige al login
				if( currentIndex === STEP_REQUIRE_LOGIN && (decoratorModel.getUsuario() === null || decoratorModel.getCapturador() === null)){
					gOnclickRedirectIngresarHanlder(URLConstants.ROL_LOGIN_AUTH0);
				}else {
					//Si todo esta en orden continuamos el flujo
					if (nextIndex <= MAX_INDEX_STEP ){
						steps[nextIndex].bind({});
						if (crearAvisosModel.esOrdenDePublicacionPersistida()){
							steps[nextIndex].doOnEnter({ event : StateEvents.NEXT_FOOTER_EDIT });
						} else {
							steps[nextIndex].doOnEnter({ event : StateEvents.NEXT_FOOTER });
						}
						crearAvisosModel.setStep(nextIndex);
					}

					if(currentIndex<MAX_INDEX_STEP){

						ui.wizard.wizard("next");
					}

					if (nextIndex <= MAX_INDEX_STEP ){
						if (crearAvisosModel.esOrdenDePublicacionPersistida()){
							steps[nextIndex].doOnShow({ event : StateEvents.NEXT_FOOTER_EDIT });
						} else {
							steps[nextIndex].doOnShow({ event : StateEvents.NEXT_FOOTER });
						}
					}

					if(currentIndex == MAX_INDEX_STEP){
						onFinishedStepWizardHandler();
					}
				}
			}
		}
	};

	var onClickPreviousWizardHandler = function(){

		var selectedItem	= ui.wizard.wizard("selectedItem");
		var currentIndex	= selectedItem.step - 1;
		var nextIndex		= selectedItem.step - 2;

		if (ui.btnWizardPrev.hasClass("disabledBtn")){
			return false;
		}

		if (currentIndex <= MAX_INDEX_STEP){
			if (crearAvisosModel.esOrdenDePublicacionPersistida()){
				steps[currentIndex].doOnExit({ event : StateEvents.PREVIOUS_FOOTER_EDIT });
			} else {
				steps[currentIndex].doOnExit({ event : StateEvents.PREVIOUS_FOOTER });
			}
			steps[currentIndex].unbind({});
		}

		if (nextIndex >= MIN_INDEX_STEP){
			steps[nextIndex].bind({});

			if (crearAvisosModel.esOrdenDePublicacionPersistida()){
				steps[nextIndex].doOnEnter({ event : StateEvents.PREVIOUS_FOOTER_EDIT });
			} else {
				if(steps[nextIndex].getAccedida()){
					steps[nextIndex].doOnEnter({ event : StateEvents.PREVIOUS_FOOTER });
				}
				else {
					steps[nextIndex].doOnEnter({ event : StateEvents.PREVIOUS_FOOTER_ON_LOAD });
				}
			}

			crearAvisosModel.setStep(nextIndex);
		}

		ui.wizard.wizard("previous");

		if (nextIndex >= MIN_INDEX_STEP){
			steps[nextIndex].doOnShow({ event : StateEvents.PREVIOUS_FOOTER });
		}

	};

	var warpToWizardHandler = function(arg){

		var selectedItem	= ui.wizard.wizard("selectedItem");
		var currentIndex	= selectedItem.step - 1;
		var targetIndex		= arg;

		if (currentIndex > targetIndex){
			while (currentIndex > targetIndex) {
				if (currentIndex <= MAX_INDEX_STEP){
					if (crearAvisosModel.esOrdenDePublicacionPersistida()){
						steps[currentIndex].doOnExit({ event : StateEvents.PREVIOUS_FOOTER_EDIT });
					} else {
						steps[currentIndex].doOnExit({ event : StateEvents.PREVIOUS_FOOTER });
					}
					steps[currentIndex].unbind({});

					ui.wizard.wizard("previous");
				}
				currentIndex = currentIndex -1;
			}
			if (currentIndex === targetIndex) {
				if (currentIndex >= MIN_INDEX_STEP){
					steps[currentIndex].bind({});

					if (crearAvisosModel.esOrdenDePublicacionPersistida()){
						steps[currentIndex].doOnEnter({ event : StateEvents.PREVIOUS_FOOTER_EDIT });
					} else {
						if(steps[currentIndex].getAccedida()){
							steps[currentIndex].doOnEnter({ event : StateEvents.PREVIOUS_FOOTER });

						} else {
							steps[currentIndex].doOnEnter({ event : StateEvents.PREVIOUS_FOOTER_ON_LOAD });
						}
					}
					steps[currentIndex].doOnShow({ event : StateEvents.PREVIOUS_FOOTER });
				}
			}
		} else {
			while (currentIndex < targetIndex){
				if (currentIndex <= MAX_INDEX_STEP){
					steps[currentIndex].unbind({});
					ui.wizard.wizard("next");
				}
				currentIndex = currentIndex +1;
			}
		}

	};
	
	var onClickCancelWizardHandler = function(){
		$("#popUpCancelar").modal("show");
		$("#popUpCancelar .modal-body p").text("Si contin\xfaa perder\xe1 todos los cambios realizados. \xbfDesea continuar?");
	};
	

	var bindUIActions = function(){

		// next/previous/cancel -----------------------------------
		ui.btnWizardPrev.on("click", onClickPreviousWizardHandler);
		ui.btnWizardNext.on("click", onClickNextWizardHandler);
		ui.btnWizardCancel.on("click", onClickCancelWizardHandler);

		// wizard -------------------------------------------------
		ui.wizard.on("change", onChangeStepWizardHandler);
		ui.wizard.on("changed", onChangedStepWizardHandler);
		ui.wizard.on("finished", onFinishedStepWizardHandler);
		ui.wizard.on("stepclick", onStepClickStepWizardHandler);

	};

	var initModel = function (){
		if (hasUUID()){

			blockCallerUI.blockPost({ url : CrearAvisoServiceURL.GET_MODEL,
				dataObject : buildModelSearchDTO(GetURLParameters("uuid")),
				successHandlerCallback : obtenerOrdenSessionHandler,
				errorHandlerCallback : defaultErrorHandler });

		} else if (hasTemplatePrecarga()){

			blockCallerUI.blockPost({ url : CrearAvisoServiceURL.GET_TEMPLATE_PRECARGA,
				dataObject : buildTemplatePrecargaSearchDTO(GetURLParameters("template")),
				successHandlerCallback : obtenerOrdenTemplatePrecargaHandler,
				errorHandlerCallback : defaultErrorHandler });

		}

	};

	var buildModelSearchDTO = function(uuid){
		var ord = new ModelSearchDTO();
		ord.uuid = uuid;
		return ord;
	};

	var buildTemplatePrecargaSearchDTO = function (codigo){
		var templatePrecargaSearchDTO = new TemplatePrecargaSearchDTO();
		templatePrecargaSearchDTO.codigo = codigo;
		return templatePrecargaSearchDTO;
	};

	var obtenerOrdenTemplatePrecargaHandler = function (data){
		var templatePrecarga = jQuery.parseJSON(data.model);
		obtenerOrdenSessionHandler(templatePrecarga);
	};

	var obtenerOrdenSessionHandler = function (data){

		if(data.model !== null){

			//Verificamos si el usuario que estaba logueado (si es que estaba logueado) es el mismo que el que inicio sesion
			if ( (decoratorController.getCookieUsuario() !== null && decoratorController.getCookieCapturador() !== null ) &&
					crearAvisosModel.getOrdenDePublicacion().capturador.usuarioExternoCodigo &&
					crearAvisosModel.getOrdenDePublicacion().capturador.usuarioExternoCodigo !== -1){

				if((crearAvisosModel.getOrdenDePublicacion().capturador.usuarioExternoCodigo !== decoratorController.getCookieCapturador().usuarioExternoCodigo ||
						crearAvisosModel.getOrdenDePublicacion().capturador.codigoAnunciante !== decoratorController.getCookieCapturador().codigoAnunciante) )
					 {
						g_restart();
					 }
				else{
					crearAvisosModel.getOrdenDePublicacion().capturador.usuarioExternoCodigo = decoratorController.getCookieCapturador().usuarioExternoCodigo;
					crearAvisosModel.getOrdenDePublicacion().capturador.codigoAnunciante = decoratorController.getCookieCapturador().codigoAnunciante;
				}

			}

			var model = new ModelCrearAvisoDTO(data.model);
			var zonasComercializacion = model.ordenPublicacion.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.zonasComercializacion;
			crearAvisosModel.setOrdenDePublicacion(model.ordenPublicacion);
			crearAvisosModel.setClase(model.clase);
			crearAvisosModel.setTipoOperacion(model.tipoOperacion);
			crearAvisosModel.setFamilia(model.familia);
			crearAvisosModel.setCodigoNivelEstructura(model.codigoNivelEstructura);
			crearAvisosModel.setOrdenamientos(model.ordenamientos);
			crearAvisosModel.setCodigoProducto(model.codigoProducto);
			crearAvisosModel.setCodigoProductoComercial(model.codigoProductoComercial);
			crearAvisosModel.setCodigoTemplateDetallado(model.codigoTempalteDetallado);
			crearAvisosModel.setZonasComercializacion(model.zonasComercializacion);
			crearAvisosModel.setSelectedDates(model.selectedDates);
			crearAvisosModel.setFechaVigencia(model.fechaVigencia);
			crearAvisosModel.setStep(model.step);
			crearAvisosModel.setMapItemsOrdenamientoCombo(model.mapItemsOrdenamientoCombo);
			crearAvisosModel.setCodigoTemplateDetallado(model.codigoTemplateDetallado);
			crearAvisosModel.setPalabrasProhibidas(model.palabrasProhibidas);
			crearAvisosModel.setConfiguracionesOrdenamientoPantalla(model.configuracionOrdenamientoPantalla);
			crearAvisosModel.setPrevisualizo(model.previsualizo);
			crearAvisosModel.setCodigoGATEWAYSeleccionado(model.codigoGATEWAYSeleccionado);
			crearAvisosModel.setOrdenDepublicacionHistory(model.ordenDepublicacionHistory);
			crearAvisosModel.setTemplatesDetallado(model.templatesDetallado);
			crearAvisosModel.setCodigoTemplateDestaqueSeleccionado(model.codigoTemplateDestaqueSeleccionado);
			crearAvisosModel.setCodigoProductoComercialDestaque(model.codigoProductoComercialDestaque);
			crearAvisosModel.setCodigoNivelEstructuraDestaque(model.codigoNivelEstructuraDestaque);
			crearAvisosModel.setCodigoImagenDestaqueSeleccionada(model.codigoImagenDestaqueSeleccionada);
			crearAvisosModel.setRepoImagenDestaqueSeleccionada(model.repoImagenDestaqueSeleccionada);
			crearAvisosModel.setTemplateTienePictoSeleccionado(model.tienePictoSeleccionado);
			crearAvisosModel.setTemplateTieneFondoColor(model.tieneFondoColor);
			crearAvisosModel.setTemplateTieneMaterial(model.tieneMaterial);
			crearAvisosModel.setConfiguracionesPromocionPantalla(model.configuracionesPromocionPantalla);
			crearAvisosModel.setAgrupadoresAtributoAviso(model.agrupadoresAtributoAviso);
			crearAvisosModel.setPromociones(model.promociones);

			//Colocamos al usuario como capturador de la orden
			g_setUsuarioCapturador();

			var paso = model.step;
			for (var i=0 ;i<paso ;i++){
				var paso  = steps[i];
				steps[i].unbind({});
				if (i===0){
					doOnObserver( {"eventsTransform" : [StateEvents.PREVIOUS_SHOW]} );
				}
			}

			warpToWizardHandler(crearAvisosModel.getStep());
			steps[crearAvisosModel.getStep()].bind();
			steps[crearAvisosModel.getStep()].doOnLoad();

			if (crearAvisosModel.getStep() <= MAX_INDEX_STEP ){
				steps[crearAvisosModel.getStep()].doOnShow({ event : StateEvents.NEXT_FOOTER });
			}
		}
		else {
			steps[0].doOnEnter({ event : StateEvents.INIT_FOOTER });
		}

	};

	var doOnObserver = function (args){

		//--------------------------
		// SKIP/WIZARD logic footer:
		//--------------------------

		if (args && args.event){

			if (args.event === StateEvents.NEXT_SKIP){
				onClickNextWizardHandler();
			} else if (args.event === StateEvents.PREVIOUS_SKIP){
				onClickPreviousWizardHandler();
			}

		}

		//-------------------------------
		// DISABLED/ENABLED logic footer:
		//-------------------------------

		if (args && args.eventEnabled){

			if (args.eventEnabled === StateEvents.NEXT_DISABLED ||
					args.eventEnabled === StateEvents.FOOTER_NAV_DISABLED){

				if (!ui.btnWizardNext.hasClass("disabledBtn")){
					ui.btnWizardNext.addClass("disabledBtn");
				}
			}

			if (args.eventEnabled === StateEvents.NEXT_ENABLED ||
					args.eventEnabled === StateEvents.FOOTER_NAV_ENABLED){

				if (ui.btnWizardNext.hasClass("disabledBtn")){
					ui.btnWizardNext.removeClass("disabledBtn");
				}
			}

			if (args.eventEnabled === StateEvents.PREVIOUS_DISABLED ||
					args.eventEnabled === StateEvents.FOOTER_NAV_DISABLED){

				if (!ui.btnWizardPrev.hasClass("disabledBtn")){
					ui.btnWizardPrev.addClass("disabledBtn");
				}
			}

			if (args.eventEnabled === StateEvents.PREVIOUS_ENABLED ||
					args.eventEnabled === StateEvents.FOOTER_NAV_DISABLED){

				if (ui.btnWizardPrev.hasClass("disabledBtn")){
					ui.btnWizardPrev.removeClass("disabledBtn");
				}
			}

		}

		if (args && args.eventsTransform) {
			for (var i=0; i < args.eventsTransform.length; i++){

				if (args.eventsTransform[i] === StateEvents.NEXT_TO_ACCEPT) {
					ui.btnWizardNext.text(label.aceptar);
				}
				if (args.eventsTransform[i] === StateEvents.NEXT_TO_PAY) {
					ui.btnWizardNext.text(label.pagar);
				}
				if (args.eventsTransform[i] === StateEvents.FINISH) {
					ui.btnWizardNext.text(label.finalizar);
				}

				if (args.eventsTransform[i] === StateEvents.ACCEPT_TO_NEXT) {
					ui.btnWizardNext.text(label.siguiente);
				}

				if (args.eventsTransform [i] === StateEvents.LOGIN) {
					ui.btnWizardNext.text(label.login);
				}

				if (args.eventsTransform[i] === StateEvents.PREVIOUS_HIDE) {
					ui.btnWizardPrev.hide();
					if(Detectizr.device.type === "mobile" || Detectizr.device.type === "tablet"){
						$(".botonera-wrapper").css({"width" : "50%"});
						$("#wrap").css({
							"margin" : "0 auto -100px",
							"padding" : "0 0 60px",
							"width" : "100%"
						});
					}else{
						$("#wrap").css({
							"margin" : "0 auto -120px",
							"padding" : "0 0 120px",
							"width" : "100%"
						});
					}
				}

				if (args.eventsTransform[i] === StateEvents.PREVIOUS_SHOW) {
					ui.btnWizardPrev.show();
					if(Detectizr.device.type === "mobile" || Detectizr.device.type === "tablet"){
						ui.btnWizardPrev.css({"float" : "left"});
						$(".botonera-wrapper").css({"width" : "100%"});
						$("#navFooterWizard").css({"height" : "110px"});
						$("#wrap").css({
							"margin" : "0 auto -160px",
							"padding" : "0 0 160px",
							"width" : "100%"
						});
					}else{
						$("#wrap").css({
							"margin" : "0 auto -120px",
							"padding" : "0 0 120px",
							"width" : "100%"
						});
					}
				}

			}
		}

		if (args && args.eventToggle) {

			//Parametros permitidos para mostrar en el popOver:
			// toggle.estado [StatEvents.SHOW_TOOLTIP_NEXT/HIDE_TOOLTIP_NEXT] : Acciones para mostrar u ocultar el popup.
			//
			// Solo para cuando se desea mostrar el popover
			// toggle.mensaje [String] : mensaje a mostrar en el popOver de siguiente
			// toggle.ocultarCerrar [true/false] : Por default muestra la 'x' para cerrar el popOver. Si se quiere ocultar se debe enviar true

			if (args.eventToggle.estado === StateEvents.HIDE_TOOLTIP_NEXT) {
				$("#btnWizardNext").popover("destroy");
			}

			if (args.eventToggle.estado === StateEvents.SHOW_TOOLTIP_NEXT) {
				if (!args.eventToggle.ocultarCerrar) {
					args.eventToggle.mensaje = "<button type='button' class='close' onclick='gOnclickCloseTerminastePopoverHandler()'>&times;</button>" + args.eventToggle.mensaje;
				}
				$("#btnWizardNext").popover("destroy");
				$("#btnWizardNext").popover({ content : args.eventToggle.mensaje,
					   html : true,
					   placement : "top"});
				$("#btnWizardNext").popover("show");
			}
		}

		//Debe recibir un objeto de tipo step conteniendo un numerico:
		//Ej: { "step" : 3 }
		if (args && args.eventWarpTo ) {
			if (args.eventWarpTo === StateEvents.WARP_TO){
				warpToWizardHandler(args.step);
			}
		}

		//verifico si es un evento de finalizacion
		//Debe recibir un objeto de tipo step conteniendo un numerico:
		//Ej: { "step" : 3 }
		if (args && args.eventFinish ) {
			// TODO: VER DE HACER LA COMPARACION DE OTRA MANERA PARA EVITAR PONER ==
			// SI EL IF SE HACE CON === EN LUGAR DE == DEJA DE FUNCIONAR CON AVISOS GRATUITOS
			if ( args.eventFinish  == StateEvents.FINISH_SUCCES){
				ui.wizard.wizard("next");
			}
		}

	};

	var setUUIDOnStartUp = function(){
		if (!hasUUID()){
			blockCallerUI.blockPost({ url : CrearAvisoServiceURL.GET_UUID,
				dataObject : null,
				successHandlerCallback : setUUIDOnStartUpHandler,
				errorHandlerCallback : defaultErrorHandler });
		}
	};

	var setUUIDOnStartUpHandler = function(data){
		crearAvisosModel.getOrdenDePublicacion().uuidGenerarOrden = data.uuid.object;
	};

	var setTrackCampanaOnStartUp = function(){
		if (hasTrackCampana()){
			blockCallerUI.blockPost({ url : CrearAvisoServiceURL.GET_TRACK_CAMPANA,
				dataObject : null,
				successHandlerCallback : setTrackCampanaHandler,
				errorHandlerCallback : defaultErrorHandler });
		}
	};

	var setTrackCampanaHandler = function(data){
		crearAvisosModel.getOrdenDePublicacion().trackCampana = new TrackCampanaDTO(data.trackCampana);
	};

	var isCapturaModificada = function(){
		var modificada = false;

		$.each(steps, function (index, step){
			if ( step.notifyChange() == true ){
				modificada = true;
				return false;
			}
		});

		return modificada;
	};

	//------------------------------------------------
	// public interface ------------------------------
	//------------------------------------------------

	return {

		init : function (args){
			decoratorController.setUpFromModule({ module :ModuleConstants.CREAR_AVISO });
			initUIComponents();
			bindUIActions();
			initModel();
			setUUIDOnStartUp();
			setTrackCampanaOnStartUp();
			avisoMailNoValidado();
		}

	};
})();


/* Muestro un modal si el usuario no confirmo el mail de registracion */
avisoMailNoValidado = function (){
	if (decoratorModel.getEmailValidated() === false) {
		$("#popUpEmailNoValidado").modal("show");
		$("#popUpEmailNoValidado .modal-body p").text("Record\xe1 que para poder continuar con el ingreso del aviso deb\xe9s activar tu cuenta confirmando el mail");
	}
};


/* Variables UI globales */
var ui = {
		/* Para el panel lateral (mobile & tablet) */
		panelVerSeleccionado				: $("#paso1-Cat"),
		panelVerOrdenamientosSeleccionado	: $("#paso4-Cat"),
		categoriaBox						: $("#categoriaBox"),
		bienBox								: $("#bienBox"),
		tipoOperacionBox					: $("#tipoOperacionBox"),
		footer								: $("#footerRol"),
		/* Para el breadcrum de Desktop */
		textoSeleccionaste					: $("#textoSeleccionaste"),
		divTextoSeleccionaste				: $("#divTextoSeleccionaste")
	};
var dispositivo = Detectizr.device.type;
/* FIN Variables UI globales */


/* Funciones globales */
var renderLeftPanelHandlebars = function(source, context, uiComponent) {
	var template = Handlebars.compile(source);
	var html = template(context);
	uiComponent.html(html);
};

/* Funciones que manejan el comportamiento de "Ver Seleccion" para tablet y mobile */
/* GGONTARUK: Estas funciones no van mas porque desaparece el panel lateral emergente
gOnclickPanelSeleccionado = function(e){
	if (e.target.id === 'paso1-Cat') {
		gOnclickOcultarPanelSeleccionado();
	}
	if (e.keyCode == 27 && dispositivo !== 'desktop') {
		gOnclickOcultarPanelSeleccionado();
	}
};

$(document).keyup(function(e) {
	if (e.keyCode == 27 && dispositivo !== 'desktop') {
		gOnclickOcultarPanelSeleccionado();
	}
});

gOnclickVerPanelSeleccionado = function(){
	armarBotonVerSeleccionado(true);
};

gOnclickOcultarPanelSeleccionado = function(){
	ui.panelVerSeleccionado.find(".container-panel").hide('slide', {direction: 'left'}, 1000);
	ui.panelVerSeleccionado.fadeOut(1000);
	ui.panelVerOrdenamientosSeleccionado.find(".container-panel").hide('slide', {direction: 'left'}, 1000);
	ui.panelVerOrdenamientosSeleccionado.fadeOut(1000);
};
*/

function isEmpty(str) {
    return (!str || 0 === str.length);
}

/* Arma los items seleccionados para el panel lateral */
/* GGONTARUK: Esta funcion no debería llamarse más */
var armarBotonVerSeleccionado = function(mostrar) {

	var familia = selectionBarUtils.obtenerFamiliaSeleccionada(crearAvisosModel);
	var bien = selectionBarUtils.obtenerBienSeleccionado(crearAvisosModel);
	var tipoOperacion = selectionBarUtils.obtenerTipoOperacionSeleccionado(crearAvisosModel);

	/* recorro el modelo en el orden correcto para mostrar o no las cajitas */
	if (!isEmpty(familia)){
		renderLeftPanelHandlebars(CrearAvisosTemplates.itemLeftPanel, {
			descripcion : familia
		}, ui.categoriaBox);
		ui.categoriaBox.removeClass('hide');
	}
	if (!isEmpty(bien)){
		renderLeftPanelHandlebars(CrearAvisosTemplates.itemLeftPanel, {
			descripcion : bien
		}, ui.bienBox);
		ui.bienBox.removeClass('hide');
	}
	if (!isEmpty(tipoOperacion)){
		renderLeftPanelHandlebars(CrearAvisosTemplates.itemLeftPanel, {
			descripcion : tipoOperacion
		}, ui.tipoOperacionBox);
		ui.tipoOperacionBox.removeClass('hide');
	}

	if (mostrar == true){
		ui.panelVerSeleccionado.show(500).find(".container-panel").show( 'slide', {direction: "left"},1000);
	}

};

/* FIN funciones globales */

function isDesktop(){
	if(typeof window.orientation === 'undefined')
		{return true;}
	else
		{return false;}
}

function showBreadcrum(descripcionPaso){
	/* El breadcrum se muestra solo en desktop y despues del paso QUE, excepto en la pantalla Pagar. */
	if (isDesktop() && descripcionPaso != 'QUE' && descripcionPaso != 'PAGO'){
		ui.divTextoSeleccionaste.show();
	}else{
		ui.divTextoSeleccionaste.hide();
	}
}


function showPanelSeleccionado(descripcionPaso){
	/* ID: paso1-Cat - El panel lateral de categoria, bien y operacion (PASO QUE) */
	/* ID: paso4-Cat - El panel lateral de ordenamientos (PASO 4 - COMO) */
	ui.panelVerSeleccionado.hide();
	ui.panelVerOrdenamientosSeleccionado.hide();
	if (descripcionPaso == 'QUE'){
		ui.panelVerSeleccionado.show();
	}else if (descripcionPaso == 'PASO4'){
		ui.panelVerOrdenamientosSeleccionado.show();
	}
}

function modifyVerSeleccionadoText(new_text){
	$("#popUpVerSeleccionado .modal-body p").html(new_text);
}

function showPopUpVerSeleccion(){
	$("#popUpVerSeleccionado").modal('show');
}
function hidePopUpVerSeleccion(){
	$("#popUpVerSeleccionado").modal('hide');
}
var posicionarCamposDeFormulario = function(){
	if($('#datosPago').length < 1) return;
	if($('#datosPago').css('display')=='none') return;

	var width = $(window).width();
	if(width < 773 && width != 768){
		$('#divSeleccionProvincia').insertAfter('#divSeleccionPais');
		$('#divDirCol2').insertAfter('#divDirCalle');
		$('#divDirCol2').removeClass();
	}else{
		$('#divDirCol2').insertAfter('#divDirCol1');
		$('#divDirCol2').addClass('col-xs-12 col-sm-6 col-md-6 col-lg-6 form-pagar-group');
		$('#divSeleccionProvincia').insertAfter('#divDirCol2 .inpCp');
	}
}
var posicionarFechasSeleccionadas = function(){
	if(crearAvisosModel.getStep() == 2){
		var width = $(window).width();
		if(width <= 773 || width == 962){
			$('.tuAvisoPublicara').insertBefore('.paso3-promociones');
			$('div.clearfix.PickedTop').insertBefore('.tuAvisoPublicara');
			$('div.clearfix.PickedFooter').insertAfter('.tuAvisoPublicara');
		}else{
			$('.tuAvisoPublicara').insertAfter('.paso3-promociones');
			$('div.clearfix.PickedTop').insertBefore('.tuAvisoPublicara');
			$('div.clearfix.PickedFooter').insertAfter('.tuAvisoPublicara');
		}
	}
}

$(document).ajaxStop($.unblockUI);
$(document).ready(function() {

	define([ "crearAvisoControllerPasoQue",
			"crearAvisoControllerPasoDonde",
			"crearAvisoControllerPasoCuando",
			"crearAvisoControllerPasoComo4",
			"crearAvisoControllerPasoComo5",
			"crearAvisoControllerPasoComo6",
			"crearAvisoControllerPasoConfYPago" ], function() {
		crearAvisoController.init({});
	});

	//fix IE10
	if(navigator.userAgent.indexOf('MSIE 10.0') != -1){
		$('#wizardPaso7').css('width', '15%');
	}
});

$(window).on('resize', function(){
	posicionarCamposDeFormulario();
	posicionarFechasSeleccionadas();
});
