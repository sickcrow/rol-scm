/**
 * author: csantos version: 1.0.0
 * Funciones del paso Como de Crear Aviso, paso 5
 */

// -----------------------------------------------------------------------------
// StateStep5Creacion ---------------------------------------------------------
// -----------------------------------------------------------------------------

var StateStep5Creacion = (function() {

	return function(args) {

		// ------------------------------------------------
		// global interface ------------------------------
		// ------------------------------------------------

		gOnchangeCargarItemsOrdenamientoHijoHandler = function(component) {
			// busco al hijo
			var ordenamientoHijo = $("select[data-id-padre='"+ $(component).data("idOrdenamiento") + "']");

			// Si existe un componente hijo
			if (ordenamientoHijo.length !== 0) {
				if (component.options.selectedIndex !== 0) {

					model.ordenamientoAux = ordenamientoHijo;
					blockCallerUI.blockPost({
						url : CrearAvisoServiceURL.GET_ITEMS_ORDENAMIENTO_AVISO,
						dataObject : getItemsOrdenamientoSearchDTO($(ordenamientoHijo).data("ordenamiento"),$(component).data("idOrdenamiento")),
						successHandlerCallback : setItemsOrdenamientoListaVaciaHandler,
						errorHandlerCallback : defaultErrorHandler
					});

				} else if (component.options.selectedIndex === 0) {
					clearOptions(ordenamientoHijo);
				}
			}
			$(".ordenamientoDinamico.select").select2({
				dropdownCssClass: "paso4Ordenamientos",
				placeholder: "Seleccione...",
				theme : "ordenamientosSelect"
			});
			if (decoratorModel.getExpired()) {
				clearOptions(ordenamientoHijo);
				document.getElementById("divOrdenamientos").innerHTML = "";
				removerOrdenamientos(model.ordenamientos, crearAvisosModel.getOrdenamientos());
				removerOrdenamientos(model.ordenamientos,crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.ordenamientos);
			}

			doOnComplete({});
		};

		gOnkeyupOrdenamientoTextoHandler = function(event) {
			doOnComplete({});
		};

		// ------------------------------------------------
		// private interface -----------------------------
		// ------------------------------------------------

		/**
		 * Secuencia los ordenamiento correspondiente a este paso.
		 */
		var secuenciarOrdenamientos = function() {

			var secuenciaOrdenamientos = [];
			var configuracionesOrdenamientoPantalla = [];

			if ($.isArray(crearAvisosModel.getConfiguracionesOrdenamientoPantalla())) {
				configuracionesOrdenamientoPantalla = $.grep(crearAvisosModel.getConfiguracionesOrdenamientoPantalla(), function(configuracionOrdenamientoPantalla, index) {
					return configuracionOrdenamientoPantalla.posicion === 1;
				});
			}
			// Obtengo la configuracionOrdenamientoPantalla asociado a la
			// solapa.

			if (configuracionesOrdenamientoPantalla.length === 1) {

				var ordenamientosPadre = obtenerOrdenamientosPadrePorOrden(configuracionesOrdenamientoPantalla[0].ordenamientosAviso);
				var cantidadDeOrdenamientosPadre = ordenamientosPadre.length;

				for ( var i = 0; i < cantidadDeOrdenamientosPadre; i++) {
					secuenciaOrdenamientos.push(ordenamientosPadre[i]);
					var tieneHijos = true;
					var idOrdenamientoActual = ordenamientosPadre[i].id;
					while (tieneHijos) {
						var ordenamientoHijo = obtenerOrdenamientoHijo(configuracionesOrdenamientoPantalla[0].ordenamientosAviso,idOrdenamientoActual);
						if (ordenamientoHijo) {
							secuenciaOrdenamientos.push(ordenamientoHijo);
							idOrdenamientoActual = ordenamientoHijo.id;
						} else {
							tieneHijos = false;
						}
					}
				}
			}

			return secuenciaOrdenamientos;
		};

		/**
		 * Obtiene todos los ordenamientos padres ordenados por el campo orden.
		 */
		var obtenerOrdenamientosPadrePorOrden = function(ordenamientos) {

			var ordenamientosPadre = $.grep(ordenamientos, function(ordenamiento, index) {
				return ordenamiento.idPadre === -1;
			});

			return ordenamientosPadre.sort(sortOrdenamientosPadre);
		};

		var obtenerOrdenamientoHijo = function(ordenamientos, idOrdenamiento) {

			ordenamientosHijo = $.grep(ordenamientos, function(ordenamientoHijo, index) {
				return ordenamientoHijo.idPadre === idOrdenamiento;
			});

			return arrayUtils.singleResult(ordenamientosHijo);
		};

		/**
		 * Ordeno los ordenamientos padres por orden.
		 */
		var sortOrdenamientosPadre = function(a, b) {
			var aOrdenamiento = a.orden;
			var bOrdenamiento = b.orden;
			return ((aOrdenamiento < bOrdenamiento) ? -1 : ((aOrdenamiento > bOrdenamiento) ? 1 : 0));
		};

		var agregarOrdenamiento = function(args) {
			// Modifico el ordenamiento si existe, lo agrego si no existe.
			if ($.isArray(args.targetOrdenamientos)) {
				var ordenamiento = args.sourceOrdenamiento;
				var encontrado = false;
				$.each(args.targetOrdenamientos,function(index, value) {
					var ordenamientoTarget = value;
					if (ordenamiento.codigo === ordenamientoTarget.codigo) {
						args.targetOrdenamientos[index].valor = ordenamiento.valor;
						args.targetOrdenamientos[index].codigoBusqueda = ordenamiento.codigoBusqueda;
						encontrado = true;
						return false;
					}
				});
				if (!encontrado) {
					args.targetOrdenamientos.push(ordenamiento);
				}
			}
		};

		var eliminarOrdenamiento = function(args) {
			// elimino el ordenamiento si existe.
			if ($.isArray(args.targetOrdenamientos)) {
				var ordenamiento = args.sourceOrdenamiento;
				var encontrado = false;
				var indexBorrar = -1;
				$.each(args.targetOrdenamientos, function(index, value) {
					var ordenamientoTarget = value;
					if (ordenamiento.codigo === ordenamientoTarget.codigo) {
						indexBorrar = index;
						encontrado = true;
						return false;
					}
				});
				if (encontrado && indexBorrar !== -1) {
					args.targetOrdenamientos.splice(indexBorrar, 1);
				}
			}
		};

		var buildOrdenamientoAvisoSearchDTO = function(args) {

			return new OrdenamientoAvisoSearchDTO({
				codigoCanalEntrada					: crearAvisosModel.getCodigoCanalEntrada(),
				codigoNivelEstructura				: crearAvisosModel.getCodigoNivelEstructura(),
				codigoAgrupamientoProductoTecnico	: crearAvisosModel.getCodigoAgrupamientoProductoTecnico(),
				codigoTipoOperacion					: crearAvisosModel.getTipoOperacion().codigo,
				fechaVigencia						: (crearAvisosModel.getSelectedDates() ? crearAvisosModel.getSelectedDates()[0] : null)
			});

		};

		var getItemsOrdenamientoSearchDTO = function(codigoOrdenamiento,idOrdenamientoPadre) {
			var itemOrdenamientoAvisoSearch = new ItemOrdenamientoAvisoSearchDTO({});
			itemOrdenamientoAvisoSearch.codigoNivelEstructura = crearAvisosModel.getCodigoNivelEstructura();
			itemOrdenamientoAvisoSearch.codigoOrdenamientoAviso = codigoOrdenamiento;

			if (idOrdenamientoPadre === -1) {
				// entro por render default
				itemOrdenamientoAvisoSearch.codigoOrdenamientoAvisoPadre = null;
				itemOrdenamientoAvisoSearch.codigoItemOrdenamientoAvisoPadre = null;
			} else {
				// entro para cargarle items a un hijo
				var ordenamientoPadre = document.getElementById("ordenamiento-"+ idOrdenamientoPadre);

				itemOrdenamientoAvisoSearch.codigoOrdenamientoAvisoPadre = $(ordenamientoPadre).data("ordenamiento");
				itemOrdenamientoAvisoSearch.codigoItemOrdenamientoAvisoPadre = $($(ordenamientoPadre)[0].options[$(ordenamientoPadre)[0].selectedIndex]).data("codigoBusqueda");
			}

			return itemOrdenamientoAvisoSearch;
		};

		var clearOptions = function(component) {

			for ( var i = component[0].options.length - 1; i > 0; i--) {
				component[0].remove(i);
			}

			// busco al hijo
			var ordenamientoHijo = $("select[data-id-padre='"+ $(component).data("idOrdenamiento") + "']");

			// Si existe un componente hijo
			if (ordenamientoHijo.length !== 0) {
				clearOptions(ordenamientoHijo);
			}
		};

		// Refatorizar para que el tipo de agregado html o append venga por parametro.

		var renderHandlebars = function (source, context, uiComponent){

    		var template = Handlebars.compile(source);
    		var html     = template(context);

    		uiComponent.append(html);
    	};

    	var renderHandlebarsHtml = function (source, context, uiComponent){

    		var template = Handlebars.compile(source);
    		var html     = template(context);

    		uiComponent.html(html);
    	};

		var setItemsOrdenamientoListaVaciaHandler = function(data) {
			var itemsOrdenamiento = arrayUtils.buildArrayObjFromJSON(data.itemsOrdenamientoAviso, ItemOrdenamientoDTO);
			var ordenamiento = model.ordenamientoAux;
			crearAvisosModel.getMapItemsOrdenamientoCombo()[$(ordenamiento).data("ordenamiento")] = itemsOrdenamiento;
			var component = $("#ordenamiento-"+ $(ordenamiento).data("idOrdenamiento"));

			clearOptions(component);
			renderHandlebars(CrearAvisosTemplates.itemOrdenamiento, {
				itemsOrdenamiento : itemsOrdenamiento
			}, component);

			// si llego por aca es porque hizo un change en la pantalla ya se
			// por seleccion manual o automatica
			// si es obligatorio y tiene un solo valor(ademas del default) lo
			// dejo seleccionado
			if ($(ordenamiento).data("obligatorio") === true && component[0].options.length === 2) {
				component[0].options[1].selected = true;

				// check si tiene hijos, luego queda recursivo
				var ordenamientoHijo = obtenerOrdenamientoHijo(ui.ordenamientosLista, $(ordenamiento).data("idOrdenamiento"));
				if (ordenamientoHijo !== null) {

					// requiere guardar el componente para usarlo luego
					model.ordenamientoAux = $("#ordenamiento-" + ordenamientoHijo.id)[0];
					blockCallerUI.blockPost({
						url : CrearAvisoServiceURL.GET_ITEMS_ORDENAMIENTO_AVISO,
						dataObject : getItemsOrdenamientoSearchDTO(ordenamientoHijo.codigo,ordenamiento.id),
						successHandlerCallback : setItemsOrdenamientoListaVaciaHandler,
						errorHandlerCallback : defaultErrorHandler
					});

				}

				// chequeo si el auto completar habilito algo
				doOnComplete({});
			}
		};

		var buildOrdenamientoLista = function(data) {
			renderHandlebars(CrearAvisosTemplates.ordenamientoLista, data,ui.ordenamientos);
		};

		var buildOrdenamientoListaVacia = function(ordenamiento) {
			// como lista es vacia solo cargo el ordenamiento y llamo al build
			// comun
			var dataProvider = new DataProviderSelectItemsOrdenamientoDTO({});
			dataProvider.ordenamiento = ordenamiento;

			buildOrdenamientoLista({
				dataProvider : dataProvider
			});
		};

		var setItemsOrdenamientoListaHandler = function(data) {
			var itemsOrdenamiento = arrayUtils.buildArrayObjFromJSON(data.itemsOrdenamientoAviso, ItemOrdenamientoDTO);

			// con la lista y el ordenamiento construyo el
			// DataProviderSelectItemsOrdenamientoDTO
			var dataProvider = new DataProviderSelectItemsOrdenamientoDTO({});
			dataProvider.ordenamiento = model.ordenamientoAux;
			crearAvisosModel.getMapItemsOrdenamientoCombo()[dataProvider.ordenamiento.codigo] = itemsOrdenamiento;
			dataProvider.itemsOrdenamiento = itemsOrdenamiento;

			buildOrdenamientoLista({dataProvider : dataProvider});
		};

		var marcarCampoRojo = function(component, msjError) {
			$(component).addClass("errorValidacion");
			if (msjError) {
				document.getElementById("validacion-"+ $(component).data("idOrdenamiento")).style.display = "inline-block";
			}
		};

		var marcarCampoNormal = function(component, msjError) {
			$(component).removeClass("errorValidacion");
			if (msjError) {
				document.getElementById("validacion-"+ $(component).data("idOrdenamiento")).style.display = "none";
			}
		};

		var validateInput = function(component, regEx) {
			if (regEx !== null && regEx !== "") {
				var pattern = new RegExp(regEx);
				if (!pattern.test(component[0].value)) {
					return false;
				}
			}
			return true;
		};

		var buildOrdenamientoTexto = function(data) {
			renderHandlebars(CrearAvisosTemplates.ordenamientoTexto, data,ui.ordenamientos);
		};

		/**
		 * Ordeno los ordenamientos
		 */
		var sortOrdenamientos = function(a, b) {
			var aOrdenamiento = a.orden;
			var bOrdenamiento = b.orden;
			return ((aOrdenamiento < bOrdenamiento) ? -1 : ((aOrdenamiento > bOrdenamiento) ? 1 : 0));
		};

		/**
		 * Devuevlve "verdadero" si el ordenamiento es de tipo "LISTA",
		 * obligatorio, no tiene padre y tiene un unico item para
		 * seleccionar(ademas del default)
		 */
		var ordenamientoPadrePreseleccionable = function(ordenamiento,itemsOrdenamiento) {
			if (ordenamiento.tipoDato === OrdenamientoAvisoTipoDatoConstants.LISTA && ordenamiento.obligatorio && ordenamiento.idPadre === -1 && itemsOrdenamiento.length === 2) {
				return true;
			}
			return false;
		};

		var renderizarOrdenamientos = function() {
			// creo variable de funcion y filtro la del model con las mias.
			var configuracionesOrdenamientoPantalla = [];

			if ($.isArray(crearAvisosModel.getConfiguracionesOrdenamientoPantalla())) {
				configuracionesOrdenamientoPantalla = $.grep(crearAvisosModel.getConfiguracionesOrdenamientoPantalla(), function(configuracionOrdenamientoPantalla, index) {
					return configuracionOrdenamientoPantalla.posicion === 2;
				});
			}

			if (configuracionesOrdenamientoPantalla.length > 0) {
				var ordenamientosARenderizar = configuracionesOrdenamientoPantalla[0].ordenamientosAviso.sort(sortOrdenamientos);
				for ( var i = 0; i < ordenamientosARenderizar.length; i++) {
					var ordenamientoAviso = ordenamientosARenderizar[i];
					model.ordenamientoAux = ordenamientoAviso;
					ui.ordenamientosLista.push(ordenamientoAviso);

					if (ordenamientoAviso.tipoDato === OrdenamientoAvisoTipoDatoConstants.TEXTO) {
						// si es texto renderizo
						buildOrdenamientoTexto({
							ordenamientoAviso : ordenamientoAviso
						});
					} else if (ordenamientoAviso.tipoDato === OrdenamientoAvisoTipoDatoConstants.LISTA) {
						// si es lista y no tiene padre busco sus items
						if (ordenamientoAviso.idPadre === -1) {
							blockCallerUI.blockPost({
								url : CrearAvisoServiceURL.GET_ITEMS_ORDENAMIENTO_AVISO,
								dataObject : getItemsOrdenamientoSearchDTO(ordenamientoAviso.codigo,ordenamientoAviso.idPadre),
								successHandlerCallback : setItemsOrdenamientoListaHandler,
								errorHandlerCallback : defaultErrorHandler
							});
						} else {
							buildOrdenamientoListaVacia(ordenamientoAviso);
						}
					}
				}

				// una vez renderizados, si son preseleccionables lo hago
				for ( var i = 0; i < ui.ordenamientosLista.length; i++) {
					var ordenamiento = ui.ordenamientosLista[i];
					var componentOrdenamiento = $("#ordenamiento-"+ ordenamiento.id)[0];
					var optionsOrdenamiento = componentOrdenamiento.options;
					if (ordenamientoPadrePreseleccionable(ordenamiento,optionsOrdenamiento)) {
						optionsOrdenamiento[1].selected = true;
						// TODO precargar y check hijos

						var ordenamientoHijo = obtenerOrdenamientoHijo(ui.ordenamientosLista, ordenamiento.id);
						if (ordenamientoHijo !== null) {

							// requiere guardar el componente para usarlo luego
							model.ordenamientoAux = $("#ordenamiento-"+ ordenamientoHijo.id)[0];
							blockCallerUI.blockPost({
								url : CrearAvisoServiceURL.GET_ITEMS_ORDENAMIENTO_AVISO,
								dataObject : getItemsOrdenamientoSearchDTO(ordenamientoHijo.codigo,ordenamiento.id),
								successHandlerCallback : setItemsOrdenamientoListaVaciaHandler,
								errorHandlerCallback : defaultErrorHandler
							});

						}

						// chequeo si el auto completar habilito algo
						doOnComplete({});
					}
				}

			}
		};

		var buildImagenDTO = function() {
			var imagen = new ImagenDTO({});
			imagen.tipo = ImagenTipoConstants.IMAGEN;
			return imagen;
		};

		var buildImageUI = function(id, src) {
			var img = new Image();
			img.id = id;
			img.src = src;
			return img;
		};

		var modifyInput = function() {
			return (crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.textoLibreTemplate === ui.txtAreaTextoLibre.val());
		};

		var enabledPrevisualizar = function(enabled) {

			if (enabled && ui.btnPrevisualizar.hasClass("disabledBtn")) {
				ui.btnPrevisualizar.removeClass("disabledBtn");
			} else if (!enabled && !ui.btnPrevisualizar.hasClass("disabledBtn")) {
				ui.btnPrevisualizar.addClass("disabledBtn");
			}
		};

		var keyUpInputHandler = function(event) {
			doOnComplete({});
		};

		var keyPressInputHandler = function(event) {
			var theEvent = event || window.event;
			var key = theEvent.keyCode || theEvent.which;
			var keyEnter = 13;

			if (jQuery.inArray(key, crearAvisosModel.getCaracteresInvalidos()) !== -1 || key === keyEnter) {
				theEvent.returnValue = false;
				if (theEvent.preventDefault) {
					theEvent.preventDefault();
				}
			}
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
			ui.lblPreview.text("As\u00ED ser\u00E1 el texto de tu aviso.");
			ui.lblPreview.removeClass("lblPreviewError");
			ui.lblPreview.addClass("lblPreview");
			previewAviso();
			mostrarPromocionesAplicadas();
			obtenerDestaques();
			doOnComplete({});
		};

		var previewAviso = function() {

			var concepto = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0];
			var aviso = concepto.itemsConceptoVendible[0].itemsAviso[0].aviso;
			removeImage();
			if (aviso.preview !== null) {
				ui.previewHolder.html(buildImageUI("imgPreview","data:image/jpeg;base64," + aviso.preview.contenido));
				if (Detectizr.device.browser === "ie") {
					var anchoImg = $("#imgPreview").attr("width");
					var altoImg = $("#imgPreview").attr("height");
					$("#imgPreview").css({"height": altoImg, "width" : anchoImg});
				}

			}

			$("#paso4-PreviewAviso").show();
			$("#btnWizardNext").show();
			$("#btn-Previsualizar").addClass("disabledBtn");
			$(".paso4-promociones").addClass("vistaHorizontal");

			g_mostrarMontos(ui.labelprecio, ui.labelNombreDePromo,ui.labelTotal, ui.valorMontoConPromocion,ui.valorMontoSinPromo, ui.valorAviso, ui.idDesglose);
			enabledPrevisualizar(false);

		};

		var removerOrdenamientos = function(ordenamientosRemover,ordenamientosTotales) {

			if ($.isArray(ordenamientosRemover) && $.isArray(ordenamientosTotales)) {
				$.each(ordenamientosRemover,function(index, ordenamientoRemover) {
					var ordenamientosEncontrados = $.grep(ordenamientosTotales,function(ordenamientosTotal,index) {
						return (ordenamientoRemover.codigo === ordenamientosTotal.codigo && ordenamientoRemover.valor === ordenamientosTotal.valor);
					});

					if (ordenamientosEncontrados.length === 1) {
						var indexBorrar = $.inArray(ordenamientosEncontrados[0],ordenamientosTotales);
						ordenamientosTotales.splice(indexBorrar, 1);
					}

				});
			}
		};

		var getCaracteresInvalidosHandler = function(data) {
			crearAvisosModel.setCaracteresInvalidos(data.caracteresInvalidos);
		};

		var guardarOrdenDePublicacionHandler = function(data) {
			alert("Se guardo la orden con id: " + data.ordenPublicacion.id);

		};

		var getPalabrasProhibidasHandler = function(data) {
			crearAvisosModel.setPalabrasProhibidas(data.palabrasProhibidas);
			if (crearAvisosModel.getPalabrasProhibidas().length > 0) {
				var palabras = data.palabrasProhibidas;

				removeImage();
				renderHandlebars(CrearAvisosTemplates.divPalabrasProhibidas, {
					palabrasProhibidas : crearAvisosModel.getPalabrasProhibidas()
				}, ui.previewHolder);
				marcarCampoRojo(ui.txtAreaTextoLibre, false);
				ui.valorAviso.text("");
				ui.lblPreview.text("Se detectaron palabras prohibidas");
				$("#parrafoPalabrasProhibidas").text("Se detectaron palabras prohibidas").show();
				ui.lblPreview.removeClass("lblPreview");
				ui.lblPreview.addClass("lblPreviewError");
				$("#paso4-PreviewAviso").show();
				$(".paso4-promociones").addClass("vistaHorizontal");
			} else {
				$("#parrafoPalabrasProhibidas").text("");
				// llamo al justificar
				//verifico si el producto comercial que tengo en el modelo se corresponde con el nivel de estructura
				//q tengo seleccionado.
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
					staticObject : crearAvisosModel.getPromocionesValidar(index),//promos
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

			}
		};

		var buildJustificar = function(){
			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;

    		if(crearAvisosModel.getCodigoProductoComercialDestaque()!=null
				&& crearAvisosModel.getCodigoTemplateDestaqueSeleccionado()!=null
				&& crearAvisosModel.getCodigoNivelEstructuraDestaque()!=null
				&& crearAvisosModel.getCodigoNivelEstructura() == crearAvisosModel.getCodigoNivelEstructuraDestaque() ){

    			if(aviso.preview === null){
    				aviso.preview = buildImagenDTO();
    			}

				if(crearAvisosModel.getCodigoImagenDestaqueSeleccionada()!=null
    				&& crearAvisosModel.getRepoImagenDestaqueSeleccionada()!=null){

					modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {"codigoProductoComercial":crearAvisosModel.getCodigoProductoComercialDestaque(),"codigoTemplateDetallado":crearAvisosModel.getCodigoTemplateDestaqueSeleccionado(),"codigoImagenDestaque":crearAvisosModel.getCodigoImagenDestaqueSeleccionada(),"repoImagenDestaque":crearAvisosModel.getRepoImagenDestaqueSeleccionada() }, function (index, aviso, args){
						aviso.productoComercial.codigo = args.codigoProductoComercial;
						aviso.templateDetallado.codigo = args.codigoTemplateDetallado;

						//lineas arriba crea el preview (buildImagenDTO) pero eso es al aviso 0 digamos, como aca itera entonces debo crearlo tmb
						//issue SFHUB-7782 vdenicolo
						if(aviso.preview === null){
		    				aviso.preview = buildImagenDTO();
		    			}

						aviso.preview.codigo = args.codigoImagenDestaque ;
						aviso.preview.repo =args.repoImagenDestaque;});

				} else if (crearAvisosModel.getTemplateTieneFondoColor()!=null){

					modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {"codigoProductoComercial":crearAvisosModel.getCodigoProductoComercialDestaque(),"codigoTemplateDetallado":crearAvisosModel.getCodigoTemplateDestaqueSeleccionado()}, function (index, aviso, args){
						aviso.productoComercial.codigo = args.codigoProductoComercial;
						aviso.templateDetallado.codigo = args.codigoTemplateDetallado;});
				
				} else if (crearAvisosModel.getTemplateTieneMaterial()!=null){
					
					modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {"codigoProductoComercial":crearAvisosModel.getCodigoProductoComercialDestaque(),"codigoTemplateDetallado":crearAvisosModel.getCodigoTemplateDestaqueSeleccionado()}, function (index, aviso, args){
						aviso.productoComercial.codigo = args.codigoProductoComercial;
						aviso.templateDetallado.codigo = args.codigoTemplateDetallado;});
				}

    		}
    		else{

    			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {"codigoTemplateDetallado":crearAvisosModel.getCodigoTemplateDetallado(), "codigoProductoComercial":crearAvisosModel.getCodigoProductoComercial() }, function (index, aviso, args){
    				aviso.templateDetallado.codigo = args.codigoTemplateDetallado;
    				aviso.productoComercial.codigo = args.codigoProductoComercial});

    				//Eliminamos los posibles restos de destaques
	    			crearAvisosModel.setCodigoImagenDestaqueSeleccionada(null);
					crearAvisosModel.setRepoImagenDestaqueSeleccionada(null);
					crearAvisosModel.setCodigoTemplateDestaqueSeleccionado(null);
					crearAvisosModel.setCodigoProductoComercialDestaque(null);
					crearAvisosModel.setCodigoNivelEstructuraDestaque(null);
					crearAvisosModel.setTemplateTieneFondoColor(null);

    		}

    		//TODO ver aca pq las agrega
			//aviso.promociones = crearAvisosModel.getPromocionesHastaPantallaSeleccionada(index);

    		modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {"atributosAvso":crearAvisosModel.getAtributosAvisoHastaPantallaSeleccionada(index),"textoLibre":ui.txtAreaTextoLibre.val(),"ordenamientos":crearAvisosModel.getOrdenamientos(),"imagen":new ImagenDTO({codigo:"Enam3", repo:"libreria"}) }, function (index, aviso, args){
    			aviso.atributosAviso = args.atributosAvso;

    			aviso.textoLibreTemplate = args.textoLibre;
    			aviso.ordenamientos = args.ordenamientos;
    			aviso.imagen = args.imagen;});

    		return crearAvisosModel.getOrdenDePublicacion();

		};

		var buildValidarPromociones = function(){
    		//se agrega que las promociones a validar sean todas las validadas hasta esta pantalla + las propias de esta)
    		return new ValidarPromocionesDTO({"promocionesAplicables":crearAvisosModel.getPromocionesValidar(index),"ordenPublicacion":crearAvisosModel.getOrdenDePublicacion()});
    	};

		var buildTextoValidate = function() {

			return new TextoValidateDTO({
				codigoNivelEstructura : crearAvisosModel
						.getCodigoNivelEstructura(),
				texto : ui.txtAreaTextoLibre.val()
			});

		};

		var obtenerOrdenamientosPantalla = function() {

			var ordenamientosPantalla = new Array();

			$.each($(".ordenamientoDinamico"),function(index, value) {
				var tipoOrdenamiento = $(value).data("tipo");
				var codigo = $(value).data("ordenamiento");
				var valor = null;
				var codigoBusqueda = null;
				var descripcion = null;
				if (tipoOrdenamiento === OrdenamientoAvisoTipoDatoConstants.TEXTO) {
					valor = $(value)[0].value;
					descripcion = $(value)[0]
				} else if (tipoOrdenamiento === OrdenamientoAvisoTipoDatoConstants.LISTA) {
					valor = $(value)[0].options[$(value)[0].selectedIndex].value;
					codigoBusqueda = $($(value)[0].options[$(value)[0].selectedIndex]).data("codigoBusqueda");
					descripcion = $($(value)[0].options[$(value)[0].selectedIndex]).data("descripcion");
				}

				if (tipoOrdenamiento === OrdenamientoAvisoTipoDatoConstants.TEXTO) {
					if (valor.trim() !== "" || validateInput($(value), $(value).data("validacion"))) {
						ordenamientosPantalla.push(new OrdenamientoAvisoValorizadoDTO({
							"codigo" : codigo,
							"codigoBusqueda" : null,
							"valor" : valor,
							"descripcion" : descripcion
						}));
					}
				} else if (tipoOrdenamiento === OrdenamientoAvisoTipoDatoConstants.LISTA) {
					if (valor !== "-1") {
						ordenamientosPantalla.push(new OrdenamientoAvisoValorizadoDTO({
							"codigo" : codigo,
							"codigoBusqueda" : codigoBusqueda,
							"valor" : valor,
							"descripcion" : descripcion
						}));
					}
				}

			});

			return ordenamientosPantalla;
		};

		var justificar = function(){

			var validadoOK = true;

			if (ui.btnPrevisualizar.hasClass("disabledBtn")){
				return false;
			}

    		if (ui.txtAreaTextoLibre.val().trim().length == 0){
    			validadoOK = false;
    			marcarCampoRojo(ui.txtAreaTextoLibre, false);
    			return false;
    		}else{
    			marcarCampoNormal(ui.txtAreaTextoLibre, false);
    		}

    		model.ordenamientos = new Array();

			$.each($(".ordenamientoDinamico"), function(index, value){

				var tipoOrdenamiento = $(value).data('tipo');
				var codigo 	=  $(value).data('ordenamiento');
				var descripcion = null;
				var valor = null;
				var formato = $(value).data('formato');
				var codigoBusqueda = null;
				var listOptions = null;
				if( tipoOrdenamiento == OrdenamientoAvisoTipoDatoConstants.TEXTO ){
					valor = $(value)[0].value;
					descripcion = $(value)[0].value;
				}else if( tipoOrdenamiento == OrdenamientoAvisoTipoDatoConstants.LISTA ){
					valor = $(value)[0].options[$(value)[0].selectedIndex].value;
					codigoBusqueda = $($(value)[0].options[$(value)[0].selectedIndex]).data('codigoBusqueda');
					descripcion = $($(value)[0].options[$(value)[0].selectedIndex]).data('descripcion');
				}

				var ordenamientoObligatorio = $(value).data('obligatorio');
				//si es obligatorio o esta cargado lo valido
				if (tipoOrdenamiento == OrdenamientoAvisoTipoDatoConstants.TEXTO){
					if (ordenamientoObligatorio && ( valor.trim() == "" || !validateInput($(value), $(value).data('validacion')))){
						//si es obligatorio y (esta vacio o no valida) ==> error
						validadoOK = false;
						marcarCampoRojo(value, true);
					} else if ( valor.trim() != "") {
						//si no esta vacio...
						if( !validateInput($(value), $(value).data('validacion')) ){
							//si no valida
							validadoOK = false;
							marcarCampoRojo(value, true);
							$(".validacion").show();
						}else{
							//si esta ok
							if (formato.trim() != "" && formato.toLocaleLowerCase().indexOf("textformatter") > -1) {
								valor = aplicarFormato(formato,valor);
								$(value)[0].value = valor;
							}
							marcarCampoNormal(value, true);
							$(".validacion").hide();
							/*
							 * IMPORTANTE: existen muchas notaciones JSON que se repiten en este código, como las
							 * que existen al crear OrdenamientoAvisoValorizadoDTO. Se podría haber unificado
							 * todo en un solo lugar para organizar el código y evitar posibles errores de
							 * codificación y facilitar las pruebas. Este comentario surgió a partir que se
							 * debió agregar la propiedad descripcion en el OrdenamientoAvisoValorizadoDTO y se
							 * tuvo que agregar en cada uno en los lugares que se utiliza (ver función agregarOrdenamiento).
							 *
							 * Para un futuro refactor de este código tener en cuenta esa mejora.
							 */
							agregarOrdenamiento({"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO({'codigo' : codigo, 'codigoBusqueda' : null, 'valor' : valor, "descripcion" : descripcion}),
													"targetOrdenamientos" : crearAvisosModel.getOrdenamientos()});
							modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), { }, function (index, aviso, args){
								agregarOrdenamiento({"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO({'codigo' : codigo, 'codigoBusqueda' : null, 'valor' : valor, "descripcion" : descripcion}),
													"targetOrdenamientos" :aviso.ordenamientos})});
								agregarOrdenamiento({"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO({'codigo' : codigo, 'codigoBusqueda' : null, 'valor' : valor, "descripcion" : descripcion}),
													"targetOrdenamientos" : model.ordenamientos});
						}
					} else if (valor.trim() == ""){
						eliminarOrdenamiento({"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO({'codigo' : codigo, 'codigoBusqueda' : null, 'valor' : valor, "descripcion" : descripcion}),
							"targetOrdenamientos" : crearAvisosModel.getOrdenamientos()});
						modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), { }, function (index, aviso, args){
							eliminarOrdenamiento({"sourceOrdenamiento" :new OrdenamientoAvisoValorizadoDTO({'codigo' : codigo, 'codigoBusqueda' : null, 'valor' : valor, "descripcion" : descripcion}),
								"targetOrdenamientos" :aviso.ordenamientos})});
						eliminarOrdenamiento({"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO({'codigo' : codigo, 'codigoBusqueda' : null, 'valor' : valor, "descripcion" : descripcion}),
							"targetOrdenamientos" : model.ordenamientos});
					}
				} else if (tipoOrdenamiento == OrdenamientoAvisoTipoDatoConstants.LISTA){
					if (ordenamientoObligatorio && valor == ""){
						validadoOK = false;
						marcarCampoRojo(value, true);
						document.getElementById('validacion-'+$(value).data('idOrdenamiento')).textContent = 'Se debe seleccionar un valor cuando el campo es obligatorio.'
					} else if (valor != ""){
						marcarCampoNormal(value, true);
						agregarOrdenamiento({"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO({'codigo' : codigo, 'codigoBusqueda' : codigoBusqueda, 'valor' : valor, "descripcion" : descripcion}),
													"targetOrdenamientos" : crearAvisosModel.getOrdenamientos()});
						modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), { }, function (index, aviso, args){
							agregarOrdenamiento({"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO({'codigo' : codigo, 'codigoBusqueda' : codigoBusqueda, 'valor' : valor, "descripcion" : descripcion}),
													"targetOrdenamientos" :aviso.ordenamientos})});
						agregarOrdenamiento({"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO({'codigo' : codigo, 'codigoBusqueda' : codigoBusqueda, 'valor' : valor, "descripcion" : descripcion}),
													"targetOrdenamientos" : model.ordenamientos});
					} else if (valor == ""){
						eliminarOrdenamiento({"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO({'codigo' : codigo, 'codigoBusqueda' : codigoBusqueda, 'valor' : valor, "descripcion" : descripcion}),
													"targetOrdenamientos" : crearAvisosModel.getOrdenamientos()});
						modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), { }, function (index, aviso, args){
							eliminarOrdenamiento({"sourceOrdenamiento" :new OrdenamientoAvisoValorizadoDTO({'codigo' : codigo, 'codigoBusqueda' : codigoBusqueda, 'valor' : valor, "descripcion" : descripcion}),
													"targetOrdenamientos" :aviso.ordenamientos})});
						eliminarOrdenamiento({"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO({'codigo' : codigo, 'codigoBusqueda' : codigoBusqueda, 'valor' : valor, "descripcion" : descripcion}),
													"targetOrdenamientos" : model.ordenamientos});
					}
				}
    		});

			var verData = crearAvisosModel.getMapItemsOrdenamientoCombo();
			if(validadoOK){

    			blockCallerUI.blockPost({ url : CrearAvisoServiceURL.VALIDATE_PALABRAS_PROHIBIDAS ,
    				dataObject : buildTextoValidate(),
    				successHandlerCallback : getPalabrasProhibidasHandler,
    				errorHandlerCallback : defaultErrorHandler });

			}
    	};

		var removeImage = function() {

			if ($("#divPalabrasProhibidas").length > 0) {
				$("#divPalabrasProhibidas").remove();
			} else if ($("#imgPreview").length > 0) {
				$("#imgPreview").remove();
			} else if ($("#imgEmpty").length > 0) {
				$("#imgEmpty").remove();
			}
		};

		var equalsOrdenamientos = function(ordenamientosA, ordenamientosB) {

			var result = true;

			if ($.isArray(ordenamientosA) && $.isArray(ordenamientosB)) {

				if (ordenamientosA.length !== ordenamientosB.length) {
					result = false;
				} else {

					$.each(ordenamientosA,function(index, ordenamientoA) {
						var encontrado = $.grep(ordenamientosB,function(ordenamientoB,index) {
							return (ordenamientoA.codigo === ordenamientoB.codigo && ordenamientoA.valor === ordenamientoB.valor);
						}).length > 0;

						if (!encontrado) {
							result = false;
							return false;
						}

					});

				}

			}

			return result;
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
			return new ValidarPromocionesDTO({"promocionesAplicables":staticObject,"ordenPublicacion":crearConceptosVendibles(processData)})
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

		var crearConceptosVendibles = function(orden){
			limpiarPromocionesRepiteSalida(orden);
    		var fechasSeleccionadas = crearAvisosModel.fechasSeleccionadas;
    		var conceptoBase = orden.conceptosVendibles[0];
    		var itemAvisoBase =orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0];
    		orden.conceptosVendibles = [];
    		conceptoBase.itemsConceptoVendible[0].itemsAviso = [];;

    		//se verifica si hay fechas seleccionadas en caso contrario no se crean conceptos nuevos y se deja uno solo porque es el concepto base para replicar
    		if(crearAvisosModel.getSelectedDates().length > 0){
    			$.each(crearAvisosModel.getSelectedDates(), function(indice, value){
    				var fechaSeleccionada = dateUtils.getDateParse(value);
    				var conceptoVendibleTemp = new ConceptoVendibleAvisoDTO(conceptoBase);
    				var itemAvisoTemp = new ItemAvisoDTO(itemAvisoBase);
    				itemAvisoTemp.numero = indice;
    				itemAvisoTemp.aviso.avisoPromocion =[];

    				//se setea el numero de item aviso incremental  por cada fecha seleccionada
    				//en el caso de promociones de repeticion de contenido debe realizarse la logica cuando arma un solo concepto
    				orden.conceptosVendibles.push(conceptoVendibleTemp);
    				conceptoVendibleTemp.itemsConceptoVendible[0].itemsAviso.push(itemAvisoTemp);
    				orden.conceptosVendibles[indice].itemsConceptoVendible[0].itemsAviso[0].aviso.fechaPedidoPublicacion = fechaSeleccionada;
    				orden.conceptosVendibles[indice].fechaTarifa = fechaSeleccionada;
    			});
    		}
    		else{
    			orden.conceptosVendibles.push(conceptoBase);
    			orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.fechaPedidoPublicacion = null;
    			orden.conceptosVendibles[0].fechaTarifa = null;
    		}
    		return orden;
   		};

   		var limpiarPromocionesRepiteSalida = function(orden){

			var promocionesRemover = orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.avisoPromocion;
			var promociones =  orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.avisoPromocion

			if(promocionesRemover!= undefined){
				$.each(promocionesRemover,function(index, avisoPromocionRemover) {
					var avisoPromocionEncontrados = $.grep(promociones,function(promociones,index) {
						return (avisoPromocionRemover.promocion.repiteSalida === true);
					});

					if (avisoPromocionEncontrados.length === 1) {
						var indexBorrar = $.inArray(avisoPromocionEncontrados[0],promociones);
						promociones.splice(indexBorrar, 1);
					}
				});
				orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.avisoPromocion = promociones;
			}
		};

   		var limpiarPromocionesConceptos = function(orden) {
			var concepto = orden.conceptosVendibles[0];
			var itemAvisoOriginal = concepto.itemsConceptoVendible[0].itemsAviso[0];
			concepto.itemsConceptoVendible[0].itemsAviso = [];
			concepto.itemsConceptoVendible[0].itemsAviso.push(itemAvisoOriginal);
			var aviso = concepto.itemsConceptoVendible[0].itemsAviso[0].aviso;
			aviso.avisosPromocion = [];
		};

		var evaluateChange = function(args) {

			var change = false;
			var textoLibreEquals = true;
			var ordenamientosEquals = true;

			if (model.generatedData.textoLibre && model.generatedData.textoLibre !== args.newData.textoLibre) {
				textoLibreEquals = false;
			}

			if (!equalsOrdenamientos(model.generatedData.ordenamientos,args.newData.ordenamientos)) {
				ordenamientosEquals = false;
			}

			if (!textoLibreEquals || !ordenamientosEquals) {
				change = true;
			}

			// Guardo la nuevo info.
			model.generatedData.ordenamientos = args.newData.ordenamientos;
			model.generatedData.textoLibre = args.newData.textoLibre;
			// Updateo la variable de notificacion de cambio.
			model.notifyChange = change;

		};

		var obtenerPromociones = function() {
			model.configuracionesPromocionPantallaVisible = [];
			if (crearAvisosModel.getConfiguracionesPromocionPantalla() && crearAvisosModel.getConfiguracionesPromocionPantalla().length > 0) {
				$.each(crearAvisosModel.getConfiguracionesPromocionPantalla(),function(indexPromociones,configuracionPromocionPantalla) {
					if (configuracionPromocionPantalla.pantallaShow === index) {
						model.configuracionesPromocionPantallaVisible.push(configuracionPromocionPantalla);
					}

				});
			}
		};

		var mostrarPromociones = function() {

			var divListaPromosPaso5 = document.querySelector(".paso4-promociones");
			limpiarPromociones();
			if (model.configuracionesPromocionPantallaVisible.length > 0) {

				renderHandlebarsHtml(CrearAvisosTemplates.promociones, {configuracionesPromocion:model.configuracionesPromocionPantallaVisible}, ui.promociones);
				divListaPromosPaso5.style.visibility = "visible";

			} else{
				divListaPromosPaso5.style.visibility = "hidden";
			}

		};

		var limpiarPromociones = function() {
			ui.promociones.empty();
		};

		var mostrarPromocionesAplicadas = function(){
			limpiarPromocionesAplicadas();

			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			if(aviso.avisoPromocion !== undefined){

				// crearAvisosModel.addPromocion({"promociones" : aviso.promociones });
				//Debido al cambio del modelo, genero una lista con promociones.
				var promociones = [];
				$.each(aviso.avisoPromocion, function(index, avisoPromo) {
					promociones.push(avisoPromo.promocion);
				});
				crearAvisosModel.setPromociones(promociones);
				$.each(aviso.avisoPromocion,function(indexPromociones,avisoPromo){
					var componentePromocion = $("#"+avisoPromo.promocion.codigo+"-"+index);
					if(componentePromocion !== "undefined"){
						componentePromocion.removeClass("promoInactiva");
						componentePromocion.addClass("promoActiva");
						componentePromocion.append("<span class='titPromoAplicada'>Promo aplicada</span>")
						var configuracionPromocionPantalla = obtenerConfiguracionPromocion({"promocion":avisoPromo.promocion});
						if(configuracionPromocionPantalla !== undefined){
							var titulo					= componentePromocion.find("#p-titulo-"+avisoPromo.promocion.codigo+"-"+index);
							var descripcionPromocion	= componentePromocion.find("#p-desc-"+avisoPromo.promocion.codigo+"-"+index);
							titulo.text(configuracionPromocionPantalla.titulo);
							descripcionPromocion.text(configuracionPromocionPantalla.descripcion);
						}
					}
				});
			}
		};

		var limpiarPromocionesAplicadas = function() {
			if (model.configuracionesPromocionPantallaVisible.length > 0) {

				$.each(model.configuracionesPromocionPantallaVisible,function(indexconfiguracionPromocionPantalla,configuracionPromocionPantalla) {
					var componentePromocion = $("#" + configuracionPromocionPantalla.promocion.codigo + "-" + index);
					var titulo = $("#p-titulo-" + configuracionPromocionPantalla.promocion.codigo + "-" + index);
					var descripcionPromocion = $("#p-desc-" + configuracionPromocionPantalla.promocion.codigo + "-" + index);
					if (componentePromocion !== "undefined") {
						componentePromocion.removeClass("promoActiva");
						componentePromocion.addClass("promoInactiva");
						titulo.text(configuracionPromocionPantalla.titulo);
						descripcionPromocion.text(configuracionPromocionPantalla.promocion.observacion);
					}
				});

			}

		};

		var obtenerConfiguracionPromocion = function(args) {

			var result;
			$.each(model.configuracionesPromocionPantallaVisible,function(indexPromociones,configuracionPromocionPantalla) {
				if (configuracionPromocionPantalla.promocion.codigo === args.promocion.codigo) {
					//agrego en el listado de las promociones.
					result = configuracionPromocionPantalla;
				}
			});
			return result;
		};

		var generarTextBreadCrum = function(texto) {
			ui.textoSeleccionaste[0].innerHTML = texto;
		};

		var verificarExistenDatosOrden = function() {
			var existenDatos = false;
			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;

			if( (aviso.textoLibreJustificado !== null && aviso.textoLibreJustificado !== "") &&
				(aviso.preview !== null && aviso.preview.contenido !== null) ) {
					existenDatos = true;
			}
			return existenDatos;
		};

		var limpiarPantalla = function() {

			ui.valorAviso.text("");
			ui.txtAreaTextoLibre.val("");

			ui.lblPreview.text("As\u00ED ser\u00E1 el texto de tu aviso.");
			ui.lblPreview.removeClass("lblPreviewError");
			ui.lblPreview.addClass("lblPreview");

			marcarCampoNormal(ui.txtAreaTextoLibre, false);
			ui.txtAreaTextoLibre.focus();
			limpiarDatosOrden();

			if ($("#divPalabrasProhibidas").length > 0) {
				$("#divPalabrasProhibidas").remove();
			} else if ($("#imgPreview").length > 0) {
				$("#imgPreview").remove();
			}

			// limpio ordenamientos
			document.getElementById("divOrdenamientos").innerHTML = "";

			accedida = false;
			crearAvisosModel.setPrevisualizo(false);
			model.generatedData = new GeneratedDataStep5({});
			doOnComplete({});

		};

		var aplicarFormato = function(formato, valorOrdenamiento) {
			if (formato.toLocaleLowerCase().indexOf("uppercomma") > -1 && valorOrdenamiento.lastIndexOf(",")+1 != valorOrdenamiento.length) {
				valorOrdenamiento = valorOrdenamiento + ',';
			}
			return valorOrdenamiento;
		}

		// ------------------------------------------------
		// common interface ------------------------------
		// ------------------------------------------------

		var modificada = false;

		var accedida = false;

		var index = 5;

		var doOnObserver = args.doOnObserver;

		var ui = {
			txtAreaTextoLibre			: $("#txtAreaTextoLibre"),
			previewHolder				: $("#previewHolder"),
			btnPrevisualizar			: $("#btn-Previsualizar"),
			valorAviso					: $("#valorAviso"),
			ordenamientos				: $("#divOrdenamientos"),
			lblPreview					: $("#lblPreview"),
			textoSeleccionaste			: $("#textoSeleccionaste"),
			divTextoSeleccionaste		: $("#divTextoSeleccionaste"),
			ordenamientosLista			: null,
			promociones					: $("#listaPromociones-paso4"),
			valorMontoConPromocion		: $("#valorConPromo"),
			valorMontoSinPromo			: $("#valorSinPromo"),
			labelprecio					: $("#lblPrecioSinPromo"),
			labelNombreDePromo			: $("#lblPrecioConPromo"),
			labelTotal					: $("#lblPrecioTotal"),
			idDesglose					: $("#desglosePreciosP4"),
			btnWizardNext				: $("#btnWizardNext")
		};

		var model = {
			notifyChange : false,
			generatedData : new GeneratedDataStep5({}),
			ordenamientos : null,
			ordenamientoAux : null,
			ordenSession : null,
			configuracionesPromocionPantallaVisible : []
		};

		var doOnLoad = function(args) {
			dibujarPantalla();
			$("#btn-Previsualizar").removeClass("hidden");
			$("#navFooterWizard").css({"height" : "165px"});
			$(".cancelar-wrapper").css({
				"float" : "left",
				"clear" : "both",
				"margin" : "46px 0 0"
			});
			showBreadcrum("PASO5");
			showPanelSeleccionado("PASO5");
		};

		var dibujarPantalla = function() {

			$("#wizardPaso4").addClass("active").removeClass("complete");

			obtenerDestaques();
			generateTag();
			accedida = true;
			model.ordenSession = args;

			var breadcrum_text = selectionBarUtils.generarTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarZonasTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarNivelEstructuraTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarFechasTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarOrdenamientosTextoSeleccionaste(crearAvisosModel);

			generarTextBreadCrum(breadcrum_text);

			/* Modifico el texto del popup de "Ver Seleccion" con lo seleccionado hasta el momento */
			modifyVerSeleccionadoText(breadcrum_text);

			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_CONFIGURACIONES_ORDENAMIENTO_PANTALLA,
				dataObject : buildOrdenamientoAvisoSearchDTO(),
				successHandlerCallback : setOnLoadConfiguracionesOrdenamientoPantallaHandler,
				errorHandlerCallback : defaultErrorHandler
			});


			if ($('#previewHolder').is(':empty')){
				$("#paso4-PreviewAviso").hide();
				$("#btnWizardNext").addClass("disabledBtn");
				$("#btn-Previsualizar").addClass("disabledBtn");
			}else{
				$("#paso4-PreviewAviso").show();
				$("#btnWizardNext").show();
				$("#btn-Previsualizar").addClass("disabledBtn");
				$(".paso4-promociones").addClass("vistaHorizontal");
			}
			$(".terminaste").hide();
			$(".ordenamientoDinamico.select").select2({
				dropdownCssClass: "paso4Ordenamientos",
				placeholder: "Seleccione...",
				theme : "ordenamientosSelect"
			});

			$(".ico-ayuda").tooltip();
			$(".validacion").hide();
			$(".ico-ayuda").on("tap",function(){
  				$(this).hide();
  			});


		};

		var setOnLoadConfiguracionesOrdenamientoPantallaHandler = function(data) {

			crearAvisosModel.setConfiguracionesOrdenamientoPantalla(arrayUtils.buildArrayObjFromJSON(
				data.configuracionesOrdenamientoPantalla,
				ConfiguracionOrdenamientoPantallaDTO));
			var ordenmientoPantalla = crearAvisosModel.getConfiguracionesOrdenamientoPantalla();
			ui.ordenamientosLista = [];

			// Secuencio los ordenamientos.
			model.ordenamientosSecuenciados = secuenciarOrdenamientos();
			model.posOrdenamientosSecuenciados = 0;
			doOnContinueOnLoad();

		};

		var doOnContinueOnLoad = function() {

			var orden = crearAvisosModel.getOrdenDePublicacion();

			renderizarOrdenamientosOnLoad();

			ui.txtAreaTextoLibre.val(orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.textoLibreTemplate);
			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;

			setValorOrden();
			if (crearAvisosModel.getPalabrasProhibidas() !== null && crearAvisosModel.getPalabrasProhibidas().length > 0) {

				removeImage();
				renderHandlebars(CrearAvisosTemplates.divPalabrasProhibidas, {
					palabrasProhibidas : crearAvisosModel.getPalabrasProhibidas()
				}, ui.previewHolder);
				marcarCampoRojo(ui.txtAreaTextoLibre, false);
				ui.valorAviso.text("");
				ui.lblPreview.text("Se detectaron palabras prohibidas.");
				ui.lblPreview.removeClass("lblPreview");
				ui.lblPreview.addClass("lblPreviewError");

			} else {
				if (orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.preview !== null) {

					removeImage();
					ui.lblPreview.text("As\u00ED ser\u00E1 el texto de tu aviso.");
					ui.lblPreview.removeClass("lblPreviewError");
					ui.lblPreview.addClass("lblPreview");
					ui.previewHolder.prepend(buildImageUI("imgPreview","data:image/jpeg;base64,"+ aviso.preview.contenido));
					g_mostrarMontos(ui.labelprecio, ui.labelNombreDePromo, ui.labelTotal, ui.valorMontoConPromocion, ui.valorMontoSinPromo, ui.valorAviso, ui.idDesglose);
					enabledPrevisualizar(false);
				} else {
					removeImage();
				}

			}
			evaluateChange({
				"newData" : new GeneratedDataStep5({
					"ordenamientos" : model.ordenamientos,
					"textoLibre" : orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.textoLibreTemplate
				})
			});

			obtenerPromociones();
			mostrarPromociones();
			mostrarPromocionesAplicadas();

			doOnComplete({});
			if (crearAvisosModel.getPrevisualizo()) {
				enabledPrevisualizar(false);
				doOnObserver({"eventEnabled" : StateEvents.NEXT_ENABLED});
			} else {
				enabledPrevisualizar(true);
				doOnObserver({"eventEnabled" : StateEvents.NEXT_DISABLED});
			}


		};

		var renderizarOrdenamientosOnLoad = function() {
			// creo variable de funcion y filtro la del model con las mias.
			var configuracionesOrdenamientoPantalla = [];

			if ($.isArray(crearAvisosModel.getConfiguracionesOrdenamientoPantalla())) {
				configuracionesOrdenamientoPantalla = $.grep(crearAvisosModel.getConfiguracionesOrdenamientoPantalla(), function(configuracionOrdenamientoPantalla, index) {
					return configuracionOrdenamientoPantalla.posicion === 2;
				});
			}

			if (configuracionesOrdenamientoPantalla.length > 0) {
				var ordenamientosARenderizar = configuracionesOrdenamientoPantalla[0].ordenamientosAviso;
				for ( var i = 0; i < ordenamientosARenderizar.length; i++) {
					var ordenamientoAviso = ordenamientosARenderizar[i];
					ui.ordenamientosLista.push(ordenamientoAviso);

					if (ordenamientoAviso.tipoDato === OrdenamientoAvisoTipoDatoConstants.TEXTO) {
						// si es texto renderizo
						buildOrdenamientoTexto({ordenamientoAviso : ordenamientoAviso});
					} else if (ordenamientoAviso.tipoDato === OrdenamientoAvisoTipoDatoConstants.LISTA) {

						var dataProvider = new DataProviderSelectItemsOrdenamientoDTO({});
						dataProvider.ordenamiento = ordenamientoAviso;

						//-----BUG SFHUB-4724 producido por doOnLoad en vez de doOnEnter
						//chequeo que no tenga padre o si lo tiene este cargado
						if(ordenamientoAviso.idPadre === -1 || ordenamientoPadreEstaCargado(ordenamientoAviso.idPadre)){

							if(dataProvider.itemsOrdenamiento.length === 0){
								model.ordenamientoAux = ordenamientoAviso;

								blockCallerUI.blockPost({
									url : CrearAvisoServiceURL.GET_ITEMS_ORDENAMIENTO_AVISO,
									dataObject : getItemsOrdenamientoSearchDTO(ordenamientoAviso.codigo,ordenamientoAviso.idPadre),
									successHandlerCallback : setItemsOrdenamientoListaEnMapItemsOrdenamientoHandler,
									errorHandlerCallback : defaultErrorHandler
								});

								dataProvider.itemsOrdenamiento = crearAvisosModel.itemsOrdenamientoAux;
								crearAvisosModel.getMapItemsOrdenamientoCombo()[ordenamientoAviso.codigo] = dataProvider.itemsOrdenamiento;
							}else{
								dataProvider.itemsOrdenamiento = crearAvisosModel.getMapItemsOrdenamientoCombo()[ordenamientoAviso.codigo];
							}

						}//-----
						else{
							if( crearAvisosModel.getMapItemsOrdenamientoCombo()[ordenamientoAviso.codigo]!== undefined && crearAvisosModel.getMapItemsOrdenamientoCombo()[ordenamientoAviso.codigo]!==null){
								dataProvider.itemsOrdenamiento = crearAvisosModel.getMapItemsOrdenamientoCombo()[ordenamientoAviso.codigo];
							}
						}
						buildOrdenamientoLista({dataProvider : dataProvider});
						setValorOrden();
					}
				}
			}

		};

		var ordenamientoPadreEstaCargado = function(idOrdenamientoPadre) {
			var padreCargado = false;

			var ordenamientoPadre = document.getElementById("ordenamiento-"+ idOrdenamientoPadre);
			var selectedIndex = $(ordenamientoPadre)[0].selectedIndex;
			var codigoItemOrdenamientoAvisoPadre = $($(ordenamientoPadre)[0].options[$(ordenamientoPadre)[0].selectedIndex]).data("codigoBusqueda");

			if(selectedIndex != 0){ //tambien el codigo va a ser !== de undefined
				padreCargado = true;
			}

			return padreCargado;
		};


		var setItemsOrdenamientoListaEnMapItemsOrdenamientoHandler = function(data) {
			var itemsOrdenamiento = arrayUtils.buildArrayObjFromJSON(data.itemsOrdenamientoAviso, ItemOrdenamientoDTO);
			crearAvisosModel.itemsOrdenamientoAux = itemsOrdenamiento;
		};

		var obtenerValoresPosiblesOrdenamientoAvisoValorizado = function(codigo) {

			var valoresPosibles = [];
			var ordenamientos = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.ordenamientos;
			$.each(ordenamientos, function(index, ordenamiento) {
				if (ordenamiento.codigo === codigo) {
					valoresPosibles = ordenamiento.valoresPosibles;
				}
			});
			return valoresPosibles;
		};

		var setValorOrden = function() {

			model.ordenamientos = [];
			$.each($(".ordenamientoDinamico"),function(index, value) {

				var tipoOrdenamiento = $(value).data("tipo");
				var codigo = $(value).data("ordenamiento");
				var ordenamientoAvisoValorizado = obtenerOrdenamientoValorizado(codigo);
				var valor = null;
				var codigoBusqueda = null;
				var elems = null;
				if (ordenamientoAvisoValorizado) {
					if (tipoOrdenamiento === OrdenamientoAvisoTipoDatoConstants.TEXTO && ordenamientoAvisoValorizado.valor.trim() !== "") {
						$(value).val(ordenamientoAvisoValorizado.valor);
						agregarOrdenamiento({
							"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO(ordenamientoAvisoValorizado),
							"targetOrdenamientos" : model.ordenamientos
						});
					} else if (tipoOrdenamiento === OrdenamientoAvisoTipoDatoConstants.LISTA) {
						elems = crearAvisosModel.getMapItemsOrdenamientoCombo()[codigo];
						$.each($(value)[0].options,function(index, valor) {
							if (Detectizr.device.browser === "ie" && Detectizr.device.browserVersion <= "9") {
							// INTERNET EXPLORER 9 y 8
								if (valor.innerText.trim() === ordenamientoAvisoValorizado.valor.trim()) {
									$(value).prop("selectedIndex",index);
									agregarOrdenamiento({
										"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO(ordenamientoAvisoValorizado),
										"targetOrdenamientos" : model.ordenamientos
									});
								}
							} else {
								if (("" + $(valor).data("codigoBusqueda")) === ordenamientoAvisoValorizado.codigoBusqueda) {
									$(value).prop("selectedIndex",index);
									agregarOrdenamiento({
										"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO(ordenamientoAvisoValorizado),
										"targetOrdenamientos" : model.ordenamientos
									});
								}
							}
						});
					}
				}
			});

		};

		var obtenerOrdenamientoValorizado = function(codigo) {
			var valor = null;
			$.each($(crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.ordenamientos),function(index, value) {
				if (value.codigo === codigo) {
					valor = value;
				}
			});
			return valor;
		};

		var obtenerDestaques = function() {

			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_TEMPLATES_DETALLADO,
				dataObject : getTemplateDetalladoSearchDTO(crearAvisosModel.getCodigoCanalEntrada(),
						crearAvisosModel.getCodigoAgrupamientoProductoTecnico(),
						crearAvisosModel.getTipoOperacion().codigo,
						crearAvisosModel.getCodigoNivelEstructura(),
						(crearAvisosModel.getSelectedDates() ? crearAvisosModel.getSelectedDates()[0] : null),
						getCodigosPromocion()),
				successHandlerCallback : setTemplatesDetalladoHandler,
				errorHandlerCallback : defaultErrorHandler
			});
		};

		var getCodigosPromocion = function(){
			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			var codigos =[];
			if(aviso != undefined){
				var listAvisoPromocion = aviso.avisoPromocion
				$.each($(listAvisoPromocion),function(index, value) {
					codigos.push(value.promocion.codigo);
				});
			}
			return codigos
		};

		var getTemplateDetalladoSearchDTO = function(codigoCanalEntrada,codigoAgrupamientoProductoTecnico, codigoTipoOperacion, codigoNivelEstructura,fechaPublicacion,promociones) {
			var templateDetalladoSearchDTO = new TemplateDetalladoSearchDTO({});
			templateDetalladoSearchDTO.codigoAgrupamientoProductoTecnico = codigoAgrupamientoProductoTecnico;
			templateDetalladoSearchDTO.codigoTipoOperacion = codigoTipoOperacion;
			templateDetalladoSearchDTO.codigoNivelEstructura = codigoNivelEstructura;
			templateDetalladoSearchDTO.codigoCanalEntrada = codigoCanalEntrada;
			templateDetalladoSearchDTO.fechaVigencia = fechaPublicacion;
			templateDetalladoSearchDTO.promocionesAplicadas = promociones;

			return templateDetalladoSearchDTO;
		};

		var setTemplatesDetalladoHandler = function(data) {
			var templatesDetallado = arrayUtils.buildArrayObjFromJSON(
					data.templates, ProductoComercialTemplateDTO);
			crearAvisosModel.setTemplatesDetallado(templatesDetallado);
		};

		var limpiarTodosLosOrdenamientos = function() {
			var longitud = $(".ordenamientoDinamico").length;
			for ( var i = 0; i < longitud; i++) {
				$("#divOrdenamientos")[i].remove();
			}
		};

		var generateTag = function() {
			decoratorModel.setA2("como-sera-tu-aviso.mas-info");
			var area = decoratorModel.getA1() + decoratorModel.getA2();
			gChangeTagName(area);
		};

		var limpiarComponenteMonto = function(args) {
			g_mostrarMontos(ui.labelprecio, ui.labelNombreDePromo,
					ui.labelTotal, ui.valorMontoConPromocion,
					ui.valorMontoSinPromo, ui.valorAviso, ui.idDesglose);
		};

		// limpia los datos de la orden que en esta pantalla se setean
		var limpiarDatosOrden = function() {
			$.each(crearAvisosModel.getOrdenDePublicacion().conceptosVendibles,function(indexConceptos, conceptovendible) {
				// TODO cambiar esta linea en multiples avisos
				conceptovendible.itemsConceptoVendible[0].itemsAviso[0].aviso.textoJustificado = "";
				conceptovendible.itemsConceptoVendible[0].itemsAviso[0].aviso.preview = null;
				conceptovendible.montoTotal = 0;
				conceptovendible.porcentajeIVA = 0;
				conceptovendible.montoSinIVA = 0;
				conceptovendible.montoSinIVASinPromo = 0;
				conceptovendible.montoIVA = 0;
				conceptovendible.montoIVASinPromo = 0;
				conceptovendible.montoPercepcion = 0;
				conceptovendible.montoPercepcionSinPromo = 0;
				conceptovendible.montoTotal = 0;
				conceptovendible.montoTotalSinPromo = 0;
			});
		};

		var limpiarPromocionesPantalla = function() {
			mostrarPromociones();
			mostrarPromocionesAplicadas();
		}

		var isFooterEventOnEdit = function(args){
			return (args.event === StateEvents.PREVIOUS_FOOTER_EDIT ||
						args.event === StateEvents.NEXT_FOOTER_EDIT);
		};

		var isFirstAccessOnEdit = function(args){
			return ((args.event === StateEvents.PREVIOUS_FOOTER_EDIT ||
					args.event === StateEvents.NEXT_FOOTER_EDIT) && !accedida && verificarExistenDatosOrden());
		};

		/**
		 * { event : StateEvents.EVENT_CONST, }
		 */
		var doOnEnter = function(args) {
			setTimeout(function(){
				$("#wizardPaso4").addClass("active").removeClass("complete");
				$("#btn-Previsualizar").removeClass("hidden");
				$("#navFooterWizard").css({"height" : "165px"});
				$(".cancelar-wrapper").css({
					"float" : "left",
					"clear" : "both",
					"margin" : "46px 0 0"
				});
			},10);

			var breadcrum_text = selectionBarUtils.generarTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarZonasTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarNivelEstructuraTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarFechasTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarOrdenamientosTextoSeleccionaste(crearAvisosModel);

			generarTextBreadCrum(breadcrum_text);

			/* Modifico el texto del popup de "Ver Seleccion" con lo seleccionado hasta el momento */
			modifyVerSeleccionadoText(breadcrum_text);

			showBreadcrum("PASO5");
			showPanelSeleccionado("PASO5");
			obtenerDestaques();

			//limpio las promos por si me cambio cosas (vdenicolo - refactor 22/07/2014)
			limpiarPromocionesPantalla();

			$("#ascrail2000").hide();
			if (args.event === StateEvents.PREVIOUS_FOOTER_ON_LOAD || isFirstAccessOnEdit(args)){
				doOnLoad(args);
			} else {
				if (!verificarExistenDatosOrden() || !accedida) {

					limpiarPantalla();

					limpiarComponenteMonto();

					blockCallerUI.blockPost({
						url : CrearAvisoServiceURL.GET_CARACTERES_INVALIDOS,
						dataObject : null,
						successHandlerCallback : getCaracteresInvalidosHandler,
						errorHandlerCallback : defaultErrorHandler
					});

					dibujarPantalla();

					accedida = true;
				}
			}

			doOnComplete({});
			if (crearAvisosModel.getPrevisualizo()) {
				previewAviso();
				doOnObserver({
					"eventEnabled" : StateEvents.NEXT_ENABLED
				});
			} else {
				enabledPrevisualizar(true);
				doOnObserver({
					"eventEnabled" : StateEvents.NEXT_DISABLED
				});
			}
		};

		/**
		 * { event : StateEvents.EVENT_CONST, }
		 */
		var doOnExit = function(args) {
			$("#btn-Previsualizar").addClass("hidden");
			$("#navFooterWizard").css({"height" : "110px"});
			$(".cancelar-wrapper").removeAttr("style");

			if (args && args.event && (args.event === StateEvents.NEXT_FOOTER ||
					args.event === StateEvents.NEXT_FOOTER_EDIT)) {

				var textoLibre = ui.txtAreaTextoLibre.val();
				if(crearAvisosModel.getCodigoProductoComercialDestaque()!=null
	    				&& crearAvisosModel.getCodigoTemplateDestaqueSeleccionado()!=null
	    				&& ( (crearAvisosModel.getCodigoImagenDestaqueSeleccionada()!=null
	    						&& crearAvisosModel.getRepoImagenDestaqueSeleccionada()!=null)
	    						|| (crearAvisosModel.getTemplateTieneFondoColor()!=null)) ){

					crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.templateDetallado.codigo = crearAvisosModel.getCodigoTemplateDestaqueSeleccionado();
				}
				else{
					crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.templateDetallado.codigo = crearAvisosModel.getCodigoTemplateDetallado();
				}

				evaluateChange({
					"newData" : new GeneratedDataStep5({
						"ordenamientos" : model.ordenamientos,
						"textoLibre" : textoLibre
					})
				});

				crearAvisosModel.setPrevisualizo(true);

			} else {
				if (isComplete(args)) {
					crearAvisosModel.setPrevisualizo(true);
				} else {
					crearAvisosModel.setPrevisualizo(false);
				}
			}

		};

		var doOnError = function(args) {
			// Implements -----
		};

		var doOnCancel = function(args) {

			//hago un refactor de limpieza de la pantalla. (vdenicolo - 23/07/2014)
			//limpio los ordenamientos y unbindeo en el cancel ya que es cuando anula toda la orden
			limpiarPantalla();

			// limpio ordenamientos del modelo
			removerOrdenamientos(model.ordenamientos, crearAvisosModel
					.getOrdenamientos());
			removerOrdenamientos(
					model.ordenamientos,
					crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.ordenamientos);

			unbind({});

		};

		var doOnChange = function(args) {
			//doOnCancel({});
		};

		var agregaPaso = function(){
			$(".infoPaso").remove();
			$("#MyWizard .steps").append("<li class='infoPaso'>4/5</li>");
		}

		var doOnShow = function(args) {
			// Implements -----
			agregaPaso();
		};

		var doOnComplete = function(args) {
			// Evaluate Complete
			if (isComplete(args)) {
				enabledPrevisualizar(false);
				doOnObserver({"eventEnabled" : StateEvents.NEXT_ENABLED});
			} else {
				enabledPrevisualizar(true);
				doOnObserver({"eventEnabled" : StateEvents.NEXT_DISABLED});
			}
		};

		var doOnExitScreen = function(args) {
			$.each($(".ordenamientoDinamico"),function(index, value) {

				var tipoOrdenamiento = $(value).data("tipo");
				var codigo = $(value).data("ordenamiento");
				var descripcion = null;
				var valor = null;
				var codigoBusqueda = null;
				var listOptions = null;
				if( tipoOrdenamiento === OrdenamientoAvisoTipoDatoConstants.TEXTO ){
					valor = $(value)[0].value;
					descripcion = $(value)[0].value;
				} else if( tipoOrdenamiento === OrdenamientoAvisoTipoDatoConstants.LISTA ){
					valor = $(value)[0].options[$(value)[0].selectedIndex].value;
					codigoBusqueda = $($(value)[0].options[$(value)[0].selectedIndex]).data("codigoBusqueda");
					descripcion = $($(value)[0].options[$(value)[0].selectedIndex]).data("descripcion");
				}

				if (tipoOrdenamiento === OrdenamientoAvisoTipoDatoConstants.TEXTO) {
					agregarOrdenamiento({
						"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO({
							"codigo" : codigo,
							"codigoBusqueda" : null,
							"valor" : valor,
							"descripcion" : descripcion
						}),
						"targetOrdenamientos" : crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.ordenamientos
					});

				} else if (tipoOrdenamiento === OrdenamientoAvisoTipoDatoConstants.LISTA) {

					agregarOrdenamiento({
						"sourceOrdenamiento" : new OrdenamientoAvisoValorizadoDTO({
							"codigo" : codigo,
							"codigoBusqueda" : codigoBusqueda,
							"valor" : valor,
							"descripcion" : descripcion,
							"valoresPosibles" : crearAvisosModel.getMapItemsOrdenamientoCombo()[codigo]
						}),
						"targetOrdenamientos" : crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.ordenamientos
					});

				}
			});

			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			if (isComplete(args)) {
				crearAvisosModel.setPrevisualizo(true);
			} else {
				crearAvisosModel.setPrevisualizo(false);
			}

			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.textoLibreTemplate = ui.txtAreaTextoLibre.val();
		};

		var bind = function(args) {
			ui.btnPrevisualizar.on("click", justificar);
			// validate chars input.
			ui.txtAreaTextoLibre.on("keypress", keyPressInputHandler);
			ui.txtAreaTextoLibre.on("keyup", keyUpInputHandler);
			// Prevent copy paste and drag an drop text.
			ui.txtAreaTextoLibre.on("copy paste cut drag drop", function() {
				return false;
			});
		};

		var unbind = function(args) {
			ui.btnPrevisualizar.off("click", justificar);
			// validate chars input.
			ui.txtAreaTextoLibre.off("keypress", keyPressInputHandler);
			ui.txtAreaTextoLibre.off("keyup", keyUpInputHandler);
			// Prevent copy paste and drag an drop text.
			ui.txtAreaTextoLibre.unbind("copy paste cut drag drop", function() {
				return false;
			});
		};

		var isComplete = function(args) {

			var ordenamientosEquals = true;
			var textoInputEqualsJustificado = true;
			var justificado = true;
			var hayPalabrasProhibidas = false;

			var textoJustificado = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.textoJustificado;

			var palabrasProhibidas = crearAvisosModel.getPalabrasProhibidas();
			if (!textoJustificado) {
				justificado = false;
			}

			var textoLibreTemplate = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.textoLibreTemplate;

			var textolibre = ui.txtAreaTextoLibre.val();

			if (textoLibreTemplate !== textolibre) {
				textoInputEqualsJustificado = false;
			}

			if (!equalsOrdenamientos(obtenerOrdenamientosPantalla(),
					model.ordenamientos)) {
				ordenamientosEquals = false;
			}
			if (palabrasProhibidas && palabrasProhibidas.length > 0) {
				hayPalabrasProhibidas = true;
			}

			return (justificado && textoInputEqualsJustificado && ordenamientosEquals && !hayPalabrasProhibidas);
		};

		var notifyChange = function(args) {
			return model.notifyChange;
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
			doOnExitScreen		: doOnExitScreen,
			doOnLoad			: doOnLoad,
			bind				: bind,
			unbind				: unbind,
			isComplete			: isComplete,
			notifyChange		: notifyChange,
			getAccedida			: getAccedida

		};

	};

})();