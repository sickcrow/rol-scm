/**
 * author: csantos version: 1.0.0
 * Funciones del paso Como de Crear Aviso, paso 4
 */


// -----------------------------------------------------------------------------
// StateStep4Creacion ---------------------------------------------------------
// -----------------------------------------------------------------------------

var StateStep4Creacion = (function() {

	return function(args) {

		// ------------------------------------------------
		// global interface ------------------------------
		// ------------------------------------------------

		/**
		 * Filtra en pantalla los items ordenamiento que corresponden de acuerdo
		 * al criterio de busqueda.
		 */
		gClickMuestraAyuda = function(event) {
			$(".popover").show();
			$("#txtAreaTextoLibre").focus();
			var altoTextArea = parseInt($("#txtAreaTextoLibre").height(), "");
			$(".popover").css({
				"top": altoTextArea + 37,
				"left": "15%"
			});
			$("#txtAreaTextoLibre").addClass("activa");
		};

		gOnblurMuestraAyuda = function(event) {
			$(".popover").hide();
			$("#txtAreaTextoLibre").addClass("activa");
		};

		gOnkeyupFilterOrdenamientosHandler = function(event) {

			$.each($(".indiceItemsOrdenamientos"),function(index, value) {

				var visible = false;
				var indice = value;
				$.each($(value).find(".itemOrdenamientoASeleccionar"),function(index, value) {
					if ($(value).data("descripcion").toString().toUpperCase().indexOf($("#inputFilterOrdenamientos").val().toUpperCase()) === -1) {
						$(value).css("display" , "none");
						$(value).parent().css("display" , "none");
					} else {
						$(value).css("display","block");
						$(value).parent().css("display" , "inline-block");
						visible = true;
					}
				});
				if (visible) {
					$(indice).css("display" , "inline");
				} else {
					$(indice).css("display" , "none");
				}
			});
		};

		gOnclickSelectOrdenamientoHandler = function(ordenamiento) {
			var campoBuscar = document.getElementById("inputFilterOrdenamientos");
			var idOrdenamientoAviso = $(ordenamiento).data("idOrdenamientoAviso");
			var valorOrdenamientoAviso = $(ordenamiento).data("valor");
			var codigoBusqueda = $(ordenamiento).data("codigoBusqueda");
			var descripcion = $(ordenamiento).data("descripcion");

			ui.paso4Cat.find("#" + idOrdenamientoAviso).empty();
			buildOrdenamientoSeleccionado({
				"id"					: ordenamiento.id,
				"valor"					: valorOrdenamientoAviso,
				"idOrdenamientoAviso"	: idOrdenamientoAviso,
				"codigoBusqueda"		: codigoBusqueda,
				"descripcion"			: descripcion
			}, ui.paso4Cat.find("#" + idOrdenamientoAviso));



			/* ANIMACION DE LOS ORDENAMIENTOS */
			if(Detectizr.device.type !== "mobile" && Detectizr.device.type !== "tablet"){
				$.blockUI({
					message : null,
					overlayCSS : {backgroundColor : "transparent"}
				});
				setTimeout($.unblockUI, 500);

				var elemento = $(ordenamiento);
				var elementoPosicion = elemento.position();
				var elementoPosicionTop = parseInt(elementoPosicion.top, "");
				var elementoPosicionLeft = parseInt(elementoPosicion.left, "");

				var numElem = $("#paso4-Cat .CatBox").size().toString();
				var numElementos = numElem - 1;

				var elCajaVacia = $("#paso4-Cat .CatBox:nth-child(" + numElem + ") div");
				var elCajaVaciaPos = elCajaVacia.position();
				var elCajaVaciaPosTop = parseInt(elCajaVaciaPos.top,"");
				var elCajaVaciaPosLeft = parseInt(elCajaVaciaPos.left, "");

				elCajaVacia.attr({
					"data-posicion-top"				: elementoPosicionTop,
					"data-posicion-left"			: elementoPosicionLeft,
					"data-posicion-caja-top"		: elCajaVaciaPosTop,
					"data-posicion-caja-left"		: elCajaVaciaPosLeft,
					"data-valor-filtro-busqueda"	: campoBuscar.value
				});

				$("html, body").animate({scrollTop : 0}, 550);
				elCajaVacia.hide();
				elemento.css({
					"top"		: elementoPosicionTop,
					"left"		: elementoPosicionLeft,
					"zIndex"	: 99,
					"position"	: "absolute"
				}).animate({
					//  del boton a su posicion
					"top" : elCajaVaciaPosTop,
					"left" : elCajaVaciaPosLeft
				},500, function(){
					elCajaVacia.parent().addClass("OrdenamientoBoxSeleccionado");
					elCajaVacia.find("span").css({"font-size":"1.4em"});
					elCajaVacia.show();
					elemento.hide();
				});
			}




			// / FIN DE ANIMACION
			setTimeout(function() {
						// Incremento verificando de que no me vaya de rango.
				if (model.posOrdenamientosSecuenciados + 1 < model.ordenamientosSecuenciados.length) {

					model.posOrdenamientosSecuenciados++;
					// SFHUB-2453 ocultar valor unico
					var ordenamientoValorUnico = false;
					// si es ocultarValorUnico == true ==> no dibujo el
					// recuadro de lineas de puntos (a seleccionar)
					if (!model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados].ocultarValorUnico === true) {
						buildOrdenamientosASeleccionar(model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados]);
					} else {
						ordenamientoValorUnico = true;
					}

					// si bien no lo dibujo debo obtener el valor ==>
					// continuo flujo
					limpiarTodosLosItemsOrdenamientos();
					model.agrupadoresItemsOrdenamiento = [];

					// busco valores ordenamiento
					if (model.ordenamientosSecuenciados.length > 0) {
						blockCallerUI.blockPost({
							url : CrearAvisoServiceURL.GET_ITEMS_ORDENAMIENTO_AVISO,
							dataObject : buildItemOrdenamientoAvisoSearch(),
							successHandlerCallback : setItemsOrdenamientoHandler,
							errorHandlerCallback : defaultErrorHandler
						});

					}

					if (ordenamientoValorUnico) {
						seleccionarOrdenamientoPostValorOculto();
					}


				} else {
					limpiarTodosLosItemsOrdenamientos();
					$("#btnWizardNext").trigger("click");
					/*doOnObserver({
						"eventToggle"	: {
							"estado"	: StateEvents.SHOW_TOOLTIP_NEXT,
							"mensaje"	: "<center> Ya terminaste aqu&iacute;.</br>Presion&aacute <b>siguiente</b> para avanzar. </center>"
						}
					});*/
				}

			}, 600);
			doOnComplete({});
		};

		gOnclickDeselectOrdenamientoHandler = function(itemOrdenamiento) {
			$.blockUI({
				message : null,
				overlayCSS : {backgroundColor : "transparent"}
			});
			setTimeout($.unblockUI, 500);
			var encontrado = false;
			for ( var i = 0; i < model.ordenamientosSecuenciados.length; i++) {

				if (!encontrado && model.ordenamientosSecuenciados[i].id === $(itemOrdenamiento).data("itemOrdenamientoSeleccionadoIdOrdenamientoAviso")) {
					encontrado = true;
					model.posOrdenamientosSecuenciados = i;
					buildOrdenamientosASeleccionar(model.ordenamientosSecuenciados[i]);
				} else if (encontrado) {

					// arreglo para valor unico oculto
					if (model.ordenamientosSecuenciados[i].ocultarValorUnico === false) {
						$("#" + model.ordenamientosSecuenciados[i].id).remove();
					} else {
						removeOrdenamientoOcultoValorUnico(model.ordenamientosSecuenciados[i].id);
					}

				}

			}

			limpiarTodosLosItemsOrdenamientos();

			model.agrupadoresItemsOrdenamiento = [];
			if (model.ordenamientosSecuenciados.length > 0) {
				/* ANIMACION DE LOS ORDENAMIENTOS */
				// Inicia la animacion del boton al desseleccionar

				var pTop = parseInt($(itemOrdenamiento).attr("data-posicion-top"), "");
				var pLeft = parseInt($(itemOrdenamiento).attr("data-posicion-left"), "");
				var nTop = $(itemOrdenamiento).attr("data-posicion-caja-top");
				var nLeft = $(itemOrdenamiento).attr("data-posicion-caja-left");
				var campoFiltroBusqueda = $(itemOrdenamiento).attr("data-valor-filtro-busqueda");

				var numElem = $("#paso4-Cat .CatBox").size().toString();
				var numElementos = numElem - 1;

				$("html, body").animate({scrollTop : pTop}, 450);

				$(itemOrdenamiento).parent().css("height","1px");
				$(itemOrdenamiento).css({
					"position":"absolute",
					"top" : nTop + "px",
					"left" : nLeft + "px"
				}).animate({
					// Vuelo
					"top" : pTop +"px",
					"left" : pLeft +"px"
				}, 500, function() {
					// Posiciona el boton
					$(itemOrdenamiento).parent().remove();
				});

				setTimeout(function(){
					// / FIN DE ANIMACION
					blockCallerUI.blockPost({
						url : CrearAvisoServiceURL.GET_ITEMS_ORDENAMIENTO_AVISO,
						dataObject : buildItemOrdenamientoAvisoSearch(),
						successHandlerCallback : setItemsOrdenamientoHandler,
						errorHandlerCallback : defaultErrorHandler
					});
				},250);

				var campoBuscar = document.getElementById("inputFilterOrdenamientos");
				if (campoFiltroBusqueda === null || campoFiltroBusqueda === undefined) {
					return false;
				} else if (campoBuscar !== null){
					campoBuscar.value = campoFiltroBusqueda;
					gOnkeyupFilterOrdenamientosHandler();
				}
			}

			doOnComplete({"deselect" : true});
			gOnclickCloseTerminastePopoverHandler();
		};

		// ------------------------------------------------
		// private interface -----------------------------
		// ------------------------------------------------

		// este metodo sirve para continuar seleccionando ordenamientos en caso
		// que halla mas de 1
		// es copia del onclick exceptuando por la animacion
		var seleccionarOrdenamientoPostValorOculto = function() {
			// Incremento verificando de que no me vaya de rango.
			if (model.posOrdenamientosSecuenciados + 1 < model.ordenamientosSecuenciados.length) {
				model.posOrdenamientosSecuenciados++;

				// SFHUB-2453 ocultar valor unico
				var ordenamientoValorUnico = false;
				// si es ocultarValorUnico == true ==> no dibujo el recuadro de
				// lineas de puntos (a seleccionar)
				if (!model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados].ocultarValorUnico === true) {
					buildOrdenamientosASeleccionar(model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados]);
				} else {
					ordenamientoValorUnico = true;
				}

				// si bien no lo dibujo debo obtener el valor ==> continuo flujo
				limpiarTodosLosItemsOrdenamientos();
				model.agrupadoresItemsOrdenamiento = [];

				// busco valores ordenamiento
				if (model.ordenamientosSecuenciados.length > 0) {
					blockCallerUI.blockPost({
						url : CrearAvisoServiceURL.GET_ITEMS_ORDENAMIENTO_AVISO,
						dataObject : buildItemOrdenamientoAvisoSearch(),
						successHandlerCallback : setItemsOrdenamientoHandler,
						errorHandlerCallback : defaultErrorHandler
					});

				}

				if (ordenamientoValorUnico) {
					seleccionarOrdenamientoPostValorOculto();
				}

			} else {
				// si no hay mas ordenamientos secuenciados
				doOnObserver({
					"eventToggle" : {
						"estado" : StateEvents.SHOW_TOOLTIP_NEXT,
						"mensaje" : "<center> Ya terminaste aqu&iacute;.</br>Presion&aacute <b>siguiente</b> para avanzar. </center>"
					}
				});
				doOnComplete({});
			}
		};

		var removeOrdenamientoOcultoValorUnico = function(idOrdenamientoOculto) {
			var deleteIndex = -1;
			for ( var i = 0; i < model.ordenamientosValorUnico.length; i++) {
				if (model.ordenamientosValorUnico[i].idOrdenamientoAviso === idOrdenamientoOculto) {
					deleteIndex = i;
				}
			}
			if (deleteIndex > -1) {
				model.ordenamientosValorUnico.splice(deleteIndex, 1);
			}
		};

		var getProductoComercialDefaultHandler = function(data) {
			var productoComercialDefault = new ProductoComercialDefaultDTO(data.productoComercialDefault);
			crearAvisosModel.setCodigoTemplateDetallado(productoComercialDefault.codigoTemplate);
			crearAvisosModel.setCodigoProductoComercial(productoComercialDefault.codigoProductoComercial);
		};

		var limpiarTodosLosOrdenamientos = function() {
			for ( var i = 0; i < model.ordenamientosSecuenciados.length; i++) {
				// arreglo para valor unico oculto
				if (model.ordenamientosSecuenciados[i].ocultarValorUnico === false) {
					$("#" + model.ordenamientosSecuenciados[i].id).remove();
				} else {
					removeOrdenamientoOcultoValorUnico(model.ordenamientosSecuenciados[i].id);
				}

			}
		};

		var limpiarTodosLosItemsOrdenamientos = function() {
			ui.paso4SelecCat.empty();
		};

		/**
		 * Agrupa los items ordenamiento por letra indice.
		 */
		var agruparItemsOrdenamiento = function(itemsOrdenamiento) {

			if ($.isArray(itemsOrdenamiento)) {
				$.each(itemsOrdenamiento,function(index, value) {
					var itemOrdenamiento = value;
					if ($(itemOrdenamiento).prop("descripcion")) {
						var letra = itemOrdenamiento.descripcion.substr(0, 1).toUpperCase();

						var agrupadorItemOrdenamientoExistente = $.grep(model.agrupadoresItemsOrdenamiento,function(agrupadorItemOrdenamiento,index) {
							return agrupadorItemOrdenamiento.indice === letra;
						});

						if (agrupadorItemOrdenamientoExistente.length === 0) {
							var agrupadorItemOrdenamiento = new AgrupadorItemsOrdenamientoDTO({
								"indice" : letra
							});
							agrupadorItemOrdenamiento.itemsOrdenamiento.push(itemOrdenamiento);
							model.agrupadoresItemsOrdenamiento.push(agrupadorItemOrdenamiento);
						} else {
							agrupadorItemOrdenamientoExistente[0].itemsOrdenamiento.push(itemOrdenamiento);
						}

					}
				});
			}
		};

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
		 * Obtiene el ordenamiento Hijo en base al Id Padre.
		 */
		var obtenerOrdenamientoHijo = function(ordenamientos, idOrdenamiento) {

			var ordenamientosHijo = $.grep(ordenamientos, function(ordenamientoHijo, index) {
				return ordenamientoHijo.idPadre === idOrdenamiento;
			});

			return arrayUtils.singleResult(ordenamientosHijo);
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

		/**
		 * Ordeno los ordenamientos padres por orden.
		 */
		var sortOrdenamientosPadre = function(a, b) {
			var aOrdenamiento = a.orden;
			var bOrdenamiento = b.orden;
			return ((aOrdenamiento < bOrdenamiento) ? -1 : ((aOrdenamiento > bOrdenamiento) ? 1 : 0));
		};

		/**
		 * Ordena los Items de Ordenamientos por el campo "valor".
		 */
		var sortItemsOrdenamiento = function(a, b) {
			var aItemOrdenamiento = a.descripcion.toLowerCase();
			var bItemOrdenamiento = b.descripcion.toLowerCase();
			return ((aItemOrdenamiento < bItemOrdenamiento) ? -1 : ((aItemOrdenamiento > bItemOrdenamiento) ? 1 : 0));
		};

		/**
		 * Ordena los Agrupadores de Item de Ordenamientos por el campo
		 * "indice".
		 */
		var sortAgrupadoresItemsOrdenamiento = function(a, b) {
			var aAgrupItemOrdenamiento = a.indice.toLowerCase();
			var bAgrupItemOrdenamiento = b.indice.toLowerCase();
			return ((aAgrupItemOrdenamiento < bAgrupItemOrdenamiento) ? -1 : ((aAgrupItemOrdenamiento > bAgrupItemOrdenamiento) ? 1
							: 0));
		};

		/**
		 * Ordena la estructura de Ordenamiento e Items de Ordenamiento.
		 */
		var sortOrdenamientos = function() {

			jQuery.each(model.agrupadoresItemsOrdenamiento, function(index,
					value) {
				value.itemsOrdenamiento = value.itemsOrdenamiento.sort(sortItemsOrdenamiento);
			});

			model.agrupadoresItemsOrdenamiento = model.agrupadoresItemsOrdenamiento.sort(sortAgrupadoresItemsOrdenamiento);
		};

		var renderHandlebars = function(source, context, uiComponent) {

			Handlebars.registerHelper("nombre-item-ordenamiento",CrearAvisosHelpers.nombreItemOrdenamiento);
			Handlebars.registerHelper("nombre-ordenamiento",CrearAvisosHelpers.nombreOrdenamiento);
			Handlebars.registerHelper("descripcion-bien",CrearAvisosHelpers.descripcionBien);

			var template = Handlebars.compile(source);
			var html = template(context);

			uiComponent.append(html);
		};

		var buildIndiceOrdenamiento = function(data) {
			renderHandlebars(CrearAvisosTemplates.indiceItemsOrdenamientos,data, ui.paso4SelecCat);
		};

		var buildOrdenamientosASeleccionar = function(data) {
			renderHandlebars(CrearAvisosTemplates.ordenamientoASeleccionar,data, ui.paso4CatContainer);
			ui.seleccioneVariable.html("Seleccion&aacute; " + data.codigo);
		};

		var buildOrdenamientoSeleccionado = function(data, uiComponent) {
			renderHandlebars(CrearAvisosTemplates.itemOrdenamientoSeleccionado,data, uiComponent);
		};

		var buildItemOrdenamientoAvisoSearch = function() {

			var itemOrdenamientoAvisoSearch = new ItemOrdenamientoAvisoSearchDTO({});

			itemOrdenamientoAvisoSearch.codigoNivelEstructura = crearAvisosModel.getCodigoNivelEstructura();
			itemOrdenamientoAvisoSearch.codigoOrdenamientoAviso = model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados].codigo;

			if (model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados].idPadre !== -1) {
				itemOrdenamientoAvisoSearch.codigoOrdenamientoAvisoPadre = model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados - 1].codigo;
				var indice = model.posOrdenamientosSecuenciados - 1;
				var comp = $("div[data-item-ordenamiento-seleccionado-id-ordenamiento-aviso='" + model.ordenamientosSecuenciados[indice].id + "']");
				itemOrdenamientoAvisoSearch.codigoItemOrdenamientoAvisoPadre = $(comp[0]).data("itemOrdenamientoSeleccionadoCodigoBusqueda");

			} else {
				itemOrdenamientoAvisoSearch.codigoOrdenamientoAvisoPadre = null;
				itemOrdenamientoAvisoSearch.codigoItemOrdenamientoAvisoPadre = null;
			}

			return itemOrdenamientoAvisoSearch;
		};

		var setConfiguracionesOrdenamientoPantallaHandler = function(data) {

			crearAvisosModel.setConfiguracionesOrdenamientoPantalla(arrayUtils.buildArrayObjFromJSON(
							data.configuracionesOrdenamientoPantalla,
							ConfiguracionOrdenamientoPantallaDTO));

			// Secuencio los ordenamientos.
			model.ordenamientosSecuenciados = secuenciarOrdenamientos();
			model.posOrdenamientosSecuenciados = 0;

			if (model.ordenamientosSecuenciados.length > 0) {

				// obtengo los datos del calendario.
				blockCallerUI.blockPost({
					url : CrearAvisoServiceURL.GET_ITEMS_ORDENAMIENTO_AVISO,
					dataObject : buildItemOrdenamientoAvisoSearch(),
					successHandlerCallback : setItemsOrdenamientoHandlerInit,
					errorHandlerCallback : defaultErrorHandler
				});


			}

		};

		var setConfiguracionesOrdenamientoPantallaHandlerFromOrden = function(data) {

			crearAvisosModel.setConfiguracionesOrdenamientoPantalla(arrayUtils.buildArrayObjFromJSON(
							data.configuracionesOrdenamientoPantalla,
							ConfiguracionOrdenamientoPantallaDTO));

			// Secuencio los ordenamientos.
			model.ordenamientosSecuenciados = secuenciarOrdenamientos();
			model.posOrdenamientosSecuenciados = 0;

			if (model.ordenamientosSecuenciados.length > 0) {

				// obtengo los datos del calendario.
				blockCallerUI.blockPost({
					url : CrearAvisoServiceURL.GET_ITEMS_ORDENAMIENTO_AVISO,
					dataObject : buildItemOrdenamientoAvisoSearch(),
					successHandlerCallback : setItemsOrdenamientoHandlerInitFromOrden,
					errorHandlerCallback : defaultErrorHandler
				});

			}

		};

		var seleccionOrdenamientoFromOrden = function(ordenamientoAvisoValorizado, ordenamientoSecuenciado) {
			if (!ordenamientoSecuenciado.ocultarValorUnico === true) {
				ui.paso4Cat.find("#" + ordenamientoSecuenciado.id).empty();
				buildOrdenamientoSeleccionado({
					"id"						: ordenamientoSecuenciado.id,
					"valor"						: ordenamientoAvisoValorizado.valor,
					"descripcion"				: ordenamientoAvisoValorizado.descripcion,
					"idOrdenamientoAviso"		: ordenamientoSecuenciado.id,
					"codigoBusqueda"			: ordenamientoAvisoValorizado.codigoBusqueda
				}, ui.paso4Cat.find("#" + ordenamientoSecuenciado.id));
			} else {
				ordenamientoAvisoValorizado.codigo = ordenamientoSecuenciado.codigo;
				model.ordenamientosValorUnico.push(ordenamientoAvisoValorizado);
			}

			model.indiceUltimoOrdenamientoCargado++;
			if (model.posOrdenamientosSecuenciados + 1 < model.ordenamientosSecuenciados.length) {

				model.posOrdenamientosSecuenciados++;

				// SFHUB-2453 ocultar valor unico
				var ordenamientoValorUnico = false;
				// si es ocultarValorUnico == true ==> no dibujo el recuadro de
				// lineas de puntos (a seleccionar)
				if (!model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados].ocultarValorUnico === true) {
					buildOrdenamientosASeleccionar(model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados]);
				} else {
					ordenamientoValorUnico = true;
				}
				//

				// si bien no lo dibujo debo obtener el valor ==> continuo flujo
				limpiarTodosLosItemsOrdenamientos();
				model.agrupadoresItemsOrdenamiento = [];

				// busco valores ordenamiento
				if (model.ordenamientosSecuenciados.length > 0) {
					blockCallerUI.blockPost({
						url : CrearAvisoServiceURL.GET_ITEMS_ORDENAMIENTO_AVISO,
						dataObject : buildItemOrdenamientoAvisoSearch(),
						successHandlerCallback : setItemsOrdenamientoHandlerFromOrden,
						errorHandlerCallback : defaultErrorHandler
					});

				}

			} else {
				limpiarTodosLosItemsOrdenamientos();
				doOnObserver({
					"eventToggle" : {
						"estado" : StateEvents.SHOW_TOOLTIP_NEXT,
						"mensaje" : "<center> Ya terminaste aqu&iacute;.</br>Presion&aacute <b>siguiente</b> para avanzar. </center>"
					}
				});
			}
			evaluateChangeDoOnLoad();

			doOnComplete({});
		};


		var setItemsOrdenamientoHandlerFromOrden = function(data) {

			var itemsOrdenamiento = arrayUtils.buildArrayObjFromJSON(
					data.itemsOrdenamientoAviso, ItemOrdenamientoDTO);
			var ordenamientos = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.ordenamientos;
			agruparItemsOrdenamiento(itemsOrdenamiento);
			sortOrdenamientos();

			// SFHUB-2453 ocultar valor unico
			if (!model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados].ocultarValorUnico === true) {
				buildIndiceOrdenamiento({
					nombreOrdenamiento : model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados].codigo.toLowerCase(),
					agrupadoresItemsOrdenamiento : model.agrupadoresItemsOrdenamiento
				});
			} else {
				// agrego el 0 pq es unico y le modifico el codigo para que
				// guarde el valor correcto
				itemsOrdenamiento[0].codigo = model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados].codigo;
				model.ordenamientosValorUnico.push(itemsOrdenamiento[0]);
			}

			if (model.indiceUltimoOrdenamientoCargado < ordenamientos.length) {
				var ordenamientoAvisoValorizado = ordenamientos[model.indiceUltimoOrdenamientoCargado];
				var ordenamientoSecuenciado = obtenerOdenamientoSecuenciado(ordenamientoAvisoValorizado.codigo);
				if(ordenamientoSecuenciado!==undefined &&ordenamientoSecuenciado!==null){
					seleccionOrdenamientoFromOrden(ordenamientoAvisoValorizado,
							ordenamientoSecuenciado);
				}

			}

		};



		var obtenerOdenamientoSecuenciado = function(codigoOrdenamiento) {

			var ordenResult = null;
			$.each(model.ordenamientosSecuenciados, function(index,ordenamientoSecuenciado) {
				if (ordenamientoSecuenciado.codigo === codigoOrdenamiento) {
					ordenResult = ordenamientoSecuenciado;
				}
			});

			return ordenResult;

		};

		var setItemsOrdenamientoHandlerInit = function(data) {
			var itemsOrdenamiento = arrayUtils.buildArrayObjFromJSON(data.itemsOrdenamientoAviso, ItemOrdenamientoDTO);
			agruparItemsOrdenamiento(itemsOrdenamiento);
			sortOrdenamientos();

			// SFHUB-2453 ocultar valor unico
			// En este caso que es el init NO DEBERIA venir un valor unico ya
			// que quedaria la pagina en blanco sino (pero por las dudas...)
			if (!model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados].ocultarValorUnico === true) {
				buildIndiceOrdenamiento({
					nombreOrdenamiento : model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados].codigo.toLowerCase(),
					agrupadoresItemsOrdenamiento : model.agrupadoresItemsOrdenamiento
				});
				buildOrdenamientosASeleccionar(model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados]);
			} else {
				// agrego el 0 pq es unico y le modifico el codigo para que
				// guarde el valor correcto
				itemsOrdenamiento[0].codigo = model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados].codigo;
				model.ordenamientosValorUnico.push(itemsOrdenamiento[0]);
			}
		};

		var setItemsOrdenamientoHandlerInitFromOrden = function(data) {
			setItemsOrdenamientoHandlerInit(data);
			var ordenamientos = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.ordenamientos;
			if (ordenamientos !== null && model.indiceUltimoOrdenamientoCargado < ordenamientos.length) {

				var ordenamientoAvisoValorizado = ordenamientos[model.indiceUltimoOrdenamientoCargado];
				var ordenamientoSecuenciado = obtenerOdenamientoSecuenciado(ordenamientoAvisoValorizado.codigo);
				while(ordenamientoSecuenciado === null || ordenamientoSecuenciado=== undefined){
					model.indiceUltimoOrdenamientoCargado = model.indiceUltimoOrdenamientoCargado +1;
					ordenamientoAvisoValorizado = ordenamientos[model.indiceUltimoOrdenamientoCargado];
					 ordenamientoSecuenciado = obtenerOdenamientoSecuenciado(ordenamientoAvisoValorizado.codigo);
				}
				if(ordenamientoSecuenciado!==undefined &&ordenamientoSecuenciado!==null){
					seleccionOrdenamientoFromOrden(ordenamientoAvisoValorizado,ordenamientoSecuenciado);
				}



			}

		};

		var setItemsOrdenamientoHandler = function(data) {
			var itemsOrdenamiento = arrayUtils.buildArrayObjFromJSON(data.itemsOrdenamientoAviso, ItemOrdenamientoDTO);
			agruparItemsOrdenamiento(itemsOrdenamiento);
			sortOrdenamientos();

			// SFHUB-2453 ocultar valor unico
			if (!model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados].ocultarValorUnico === true) {
				buildIndiceOrdenamiento({
					nombreOrdenamiento : model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados].codigo.toLowerCase(),
					agrupadoresItemsOrdenamiento : model.agrupadoresItemsOrdenamiento
				});
			} else {
				// agrego el 0 pq es unico y le modifico el codigo para que
				// guarde el valor correcto
				itemsOrdenamiento[0].codigo = model.ordenamientosSecuenciados[model.posOrdenamientosSecuenciados].codigo;
				model.ordenamientosValorUnico.push(itemsOrdenamiento[0]);
			}
		};

		var resetModel = function(data) {
			model.ordenamientosSecuenciados = [];
			model.agrupadoresItemsOrdenamiento = [];
			model.ordenamientosValorUnico = [];
			model.posOrdenamientosSecuenciados = -1;
		};

		var addOrdenamientos = function(args) {
			// Guardo en la orden los ordenamientos en la orden.
			$.each(args.sourceOrdenamientos,function(index, value) {
				var ordenamientoSource = value;
				var encontrado = false;
				$.each(args.targetOrdenamientos,function(index, value) {
					var ordenamientoTarget = value;
					if (ordenamientoSource.codigo === ordenamientoTarget.codigo) {
						args.targetOrdenamientos[index].valor = ordenamientoSource.valor;
						args.targetOrdenamientos[index].codigoBusqueda = ordenamientoSource.codigoBusqueda;
						encontrado = true;
						return false;
					}
				});
				if (!encontrado) {
					args.targetOrdenamientos.push(ordenamientoSource);
				}
			});
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

		var evaluateChangeDoOnLoad = function() {

			model.ordenamientosPantalla = [];

			$.each($(".itemOrdenamientoSeleccionado"), function(index, value) {
				var codigo = $(value).parent().data("ordenamientoASeleccionarCodigo");
				var valor = $(value).data("itemOrdenamientoSeleccionadoValor");
				var codigoBusqueda = $(value).data("itemOrdenamientoSeleccionadoCodigoBusqueda");
				var descripcion = $(value).data("itemOrdenamientoSeleccionadoDescripcion");
				model.ordenamientosPantalla.push(new OrdenamientoAvisoValorizadoDTO({
					"codigo" : codigo,
					"valor" : valor,
					"codigoBusqueda" : codigoBusqueda,
					"descripcion" : descripcion
				}));
			});

			// agrego ordenamientos ocultos
			for ( var i = 0; i < model.ordenamientosValorUnico.length; i++) {
				model.ordenamientosPantalla.push(new OrdenamientoAvisoValorizadoDTO({
					"codigo" : model.ordenamientosValorUnico[i].codigo,
					"valor" : model.ordenamientosValorUnico[i].valor,
					"codigoBusqueda" : model.ordenamientosValorUnico[i].codigoBusqueda,
					"descripcion" : model.ordenamientosValorUnico[i].descripcion
				}));
			}

			addOrdenamientos({
				"sourceOrdenamientos" : model.ordenamientosPantalla,
				"targetOrdenamientos" : crearAvisosModel.getOrdenamientos()
			});

			evaluateChange({
				"newData" : new GeneratedDataStep4({
					"ordenamientos" : model.ordenamientosPantalla
				})
			});

		};

		var evaluateChange = function(args) {

			var change = false;

			$.each(model.generatedData.ordenamientos,function(index, value) {
				var generatedOrdenamientoOld = value;
				$.each(args.newData.ordenamientos,function(index, value) {
					var generatedOrdenamientoNew = value;
					if (generatedOrdenamientoOld.codigo === generatedOrdenamientoNew.codigo && generatedOrdenamientoOld.valor !== generatedOrdenamientoNew.valor) {

						change = true;
						// Corto el bucle. Saco las imagenes de la orden para que no se muesren luego de ir a registrarse SFHUB-2680
						crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.preview = null;
						crearAvisosModel.setPalabrasProhibidas(null);
						crearConceptosVendibles();
						return false;
					}
				});
				if (change) {
				// Corto el bucle.
					return false;
				}
			});

			// Guardo la nuevo info.
			model.generatedData.ordenamientos = args.newData.ordenamientos;
			// Updateo la variable de notificacion de cambio.
			model.notifyChange = change;
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

		var buildProductoComercialDefaultDTO = function(args) {

			return new ProductoComercialDefaultDTO({
				codigoAgrupamientoProductoTecnico	: crearAvisosModel.getCodigoAgrupamientoProductoTecnico(),
				codigoCanalEntrada					: crearAvisosModel.getCodigoCanalEntrada(),
				codigoTipoOperacion					: crearAvisosModel.getTipoOperacion().codigo,
				codigoNivelEstructura				: crearAvisosModel.getCodigoNivelEstructura()
			});

		};

		var limpiarOrdenamientosAvisoModel = function() {
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.ordenamientos = [];
			crearAvisosModel.setOrdenamientos([]);
		};

		var verficarExistenDatosOrden = function(){
			if(crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.ordenamientos === null ||
					crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.ordenamientos.length === 0 ){
				return false;
			} else {
				return true;
			}
		};

		var renderScreen = function(){

			var breadcrum_text = selectionBarUtils.generarTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarZonasTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarNivelEstructuraTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarFechasTextoSeleccionaste(crearAvisosModel);

			/* Modifico el texto del popup de "Ver Seleccion" con lo seleccionado hasta el momento */
			modifyVerSeleccionadoText(breadcrum_text);

			ui.textoSeleccionaste[0].innerHTML = breadcrum_text;
			accedida = true;
			var bienSeleccionado = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.codigoClase;

            if(bienSeleccionado === "DIA_DE_LOS_ENAMORADOS" || bienSeleccionado === "DIA_DE_LOS_ENAMORADOS_1"){
                $("#step4").hide();
            }

			// obtengo los datos del configuraciones ordenamiento pantalla.
			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_CONFIGURACIONES_ORDENAMIENTO_PANTALLA,
				dataObject : buildOrdenamientoAvisoSearchDTO(),
				successHandlerCallback : setConfiguracionesOrdenamientoPantallaHandlerFromOrden,
				errorHandlerCallback : defaultErrorHandler
			});
			// obtengo el producto comercial default.
			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_PRODUCTO_COMERCIAL_DEFAULT,
				dataObject : buildProductoComercialDefaultDTO(),
				successHandlerCallback : getProductoComercialDefaultHandler,
				errorHandlerCallback : defaultErrorHandler
			});
		};

		//se crean nuevamente los conceptos luego de un cambio para que al justificar, validar promociones y tasar
		//se validen nuevamente las promociones y se verifiquen con conceptos separados por fecha
		var crearConceptosVendibles = function(){
			limpiarPromocionesRepiteSalida();
    		var fechasSeleccionadas = crearAvisosModel.fechasSeleccionadas;
    		var itemAvisoBase = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0];
    		var conceptoBase = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0];
    		crearAvisosModel.getOrdenDePublicacion().conceptosVendibles = [];
    		conceptoBase.itemsConceptoVendible[0].itemsAviso = [];

    		//se verifica si hay fechas seleccionadas en caso contrario no se crean conceptos nuevos y se deja uno solo porque es el concepto base para replicar
    		if(crearAvisosModel.getSelectedDates().length > 0){
    			$.each(crearAvisosModel.getSelectedDates(), function(indice, value){
    				var fechaSeleccionada = dateUtils.getDateParse(value);
    				var conceptoVendibleTemp = new ConceptoVendibleAvisoDTO(conceptoBase);
    				var itemAvisoTemp = new ItemAvisoDTO(itemAvisoBase);
    				itemAvisoTemp.numero = indice;
    				itemAvisoTemp.aviso.textoLibreJustificado ="";
    				itemAvisoTemp.aviso.preview = null;
    				itemAvisoTemp.aviso.avisoPromocion =[];
    				conceptoVendibleTemp.itemsConceptoVendible[0].itemsAviso.push(itemAvisoTemp);
    				crearAvisosModel.getOrdenDePublicacion().conceptosVendibles.push(conceptoVendibleTemp);
    				crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[indice].itemsConceptoVendible[0].itemsAviso[0].aviso.fechaPedidoPublicacion = fechaSeleccionada;
    				crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[indice].fechaTarifa = fechaSeleccionada;
    			});
    		}
    		else{
    			limpiarPromocionesPantalla();
    			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles.push(conceptoBase);
    			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.fechaPedidoPublicacion = null;
    			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].fechaTarifa = null;
    		}
   		};

		var limpiarPromociones = function() {

			var concepto = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0];
			var itemAvisoOriginal = concepto.itemsConceptoVendible[0].itemsAviso[0];
			concepto.itemsConceptoVendible[0].itemsAviso = [];
			concepto.itemsConceptoVendible[0].itemsAviso.push(itemAvisoOriginal);
			var aviso = concepto.itemsConceptoVendible[0].itemsAviso[0].aviso;
			//Esto es para que deba volver a cotizar
			//aviso.textoLibre = "";
			aviso.avisosPromocion = [];


		};

		var limpiarPromocionesRepiteSalida = function(){

			var promocionesRemover = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.avisoPromocion;
			var promociones =  crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.avisoPromocion

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
				crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.avisoPromocion = promociones;
			}


		};

		var clearScreen = function(){
			limpiarTodosLosOrdenamientos();
			limpiarTodosLosItemsOrdenamientos();
			crearAvisosModel.setOrdenamientos([]);
			//limpiarOrdenamientosAvisoModel();
			resetModel();
			accedida = false;
			model.generatedData = new GeneratedDataStep4({});
			gOnclickCloseTerminastePopoverHandler();
			doOnComplete({});
		}

		// ------------------------------------------------
		// common interface ------------------------------
		// ------------------------------------------------

		var modificada = false;

		var accedida = false;

		var index = 4;

		var doOnObserver = args.doOnObserver;

		var ui = {
			paso4Cat					: $("#paso4-Cat"),
			paso4CatContainer			: $("#paso4-Cat .container-panel"),
			seleccioneVariable			: $("#selecciona-variable"),
			paso4SelecCat				: $("#paso4-SelecCat"),
			inputFilterOrdenamientos	: $("#inputFilterOrdenamientos"),
			textoSeleccionaste			: $("#textoSeleccionaste"),
			divTextoSeleccionaste		: $("#divTextoSeleccionaste"),
			tituloPaso					: $("#titulo-paso"),
			btnWizardNext				: $("#btnWizardNext")
		};

		var model = {
			ordenamientosSecuenciados			: [],
			agrupadoresItemsOrdenamiento		: [],
			ordenamientosValorUnico				: [],
			posOrdenamientosSecuenciados		: -1,
			notifyChange						: false,
			ordenamientosPantalla				: [],
			generatedData						: new GeneratedDataStep4({}),
			indiceUltimoOrdenamientoCargado		: 0
		};

		var generateTag = function() {
			decoratorModel.setA2("como-sera-tu-aviso");
			var area = decoratorModel.getA1() + decoratorModel.getA2();
			gChangeTagName(area);
		};

		var generarTextBreadCrum = function(texto) {
			ui.textoSeleccionaste[0].innerHTML = texto;
		};
		/**
		 * { event : StateEvents.EVENT_CONST, }
		 */
		var doOnEnter = function(args) {
			showBreadcrum('PASO4');
			showPanelSeleccionado('PASO4');
			setTimeout(function(){
				$("#wizardPaso4").addClass("active").removeClass("complete");
			},10);

			var breadcrum_text = selectionBarUtils.generarTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarZonasTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarNivelEstructuraTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarFechasTextoSeleccionaste(crearAvisosModel);

			/* Modifico el texto del popup de "Ver Seleccion" con lo seleccionado hasta el momento */
			modifyVerSeleccionadoText(breadcrum_text);

			ui.textoSeleccionaste[0].innerHTML = breadcrum_text;



			/* Modifico el texto del popup de "Ver Seleccion" con lo seleccionado hasta el momento */
			modifyVerSeleccionadoText(breadcrum_text);


			if (args.event === StateEvents.PREVIOUS_FOOTER_ON_LOAD) {
				doOnLoad(args);
			} else {
				generateTag();
				if (!accedida || !verficarExistenDatosOrden() ) {
					clearScreen();
					renderScreen();
				}
				doOnComplete({});
			}
		};

		var doOnLoad = function(args) {
			showBreadcrum('PASO4');
			showPanelSeleccionado('PASO4');
			generateTag();
			renderScreen();
		};

		/**
		 * { event : StateEvents.EVENT_CONST, }
		 */
		var doOnExit = function(args) {

			//model.ordenamientosPantalla = [];

			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), { }, function (index, aviso, args){
				removerOrdenamientos(model.ordenamientosPantalla,aviso.ordenamientos);
    		});

			model.ordenamientosPantalla = [];

			$.each($(".itemOrdenamientoSeleccionado"), function(index, value) {
				var codigo = $(value).parent().data("ordenamientoASeleccionarCodigo");
				var valor = $(value).data("itemOrdenamientoSeleccionadoValor");
				var codigoBusqueda = $(value).data("itemOrdenamientoSeleccionadoCodigoBusqueda");
				var descripcion = $(value).data("itemOrdenamientoSeleccionadoDescripcion");
				model.ordenamientosPantalla.push(new OrdenamientoAvisoValorizadoDTO({
					"codigo" : codigo,
					"valor" : valor,
					"codigoBusqueda" : codigoBusqueda,
					"descripcion" : descripcion
				}));
			});

			// agrego ordenamientos ocultos
			for ( var i = 0; i < model.ordenamientosValorUnico.length; i++) {
				model.ordenamientosPantalla.push(new OrdenamientoAvisoValorizadoDTO({
					"codigo" : model.ordenamientosValorUnico[i].codigo,
					"valor" : model.ordenamientosValorUnico[i].valor,
					"codigoBusqueda" : model.ordenamientosValorUnico[i].codigoBusqueda,
					"descripcion" : model.ordenamientosValorUnico[i].descripcion
				}));
			}

			addOrdenamientos({
				"sourceOrdenamientos" : model.ordenamientosPantalla,
				"targetOrdenamientos" : crearAvisosModel.getOrdenamientos()
			});

			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), { }, function (index, aviso, args){
    			addOrdenamientos({
    				"sourceOrdenamientos" : model.ordenamientosPantalla,
    				"targetOrdenamientos" :aviso.ordenamientos
    			});
    		});

			// Evaluo si hubo cambios.
			evaluateChange({
					"newData" : new GeneratedDataStep4({
					"ordenamientos" : model.ordenamientosPantalla
				})
			});
			gOnclickCloseTerminastePopoverHandler();
		};

		var doOnError = function(args) {
			// Implements -----
		};

		var doOnCancel = function(args) {
			limpiarTodosLosOrdenamientos();
			limpiarTodosLosItemsOrdenamientos();
			limpiarOrdenamientosAvisoModel();
			resetModel();
			accedida = false;
			model.generatedData = new GeneratedDataStep4({});
			gOnclickCloseTerminastePopoverHandler();
			doOnComplete({});
		};

		var doOnChange = function(args) {
			//doOnCancel({});
		};

		var agregaPaso = function(){
			$(".infoPaso").remove();
			$("#MyWizard .steps").append("<li class='infoPaso'>4/5</li>");
		}

		var doOnShow = function(args) {
			agregaPaso();
			$("#titulo-paso").html("Seleccion&aacute; algo");
			setTimeout(function(){
				$("#footer").addClass("footer");
			},200);
			if (!decoratorModel.getExpired()) {
				if ($.isArray(model.ordenamientosSecuenciados) && model.ordenamientosSecuenciados.length === 0) {
					// Limpieza de ordenamientos en la orden.
					doOnCancel({});
					// Skip de la pantalla.
					if (args.event === StateEvents.NEXT_FOOTER || args.event === StateEvents.NEXT_FOOTER_EDIT) {
						doOnObserver({"event" : StateEvents.NEXT_SKIP});
					} else if (args.event === StateEvents.PREVIOUS_FOOTER || args.event === StateEvents.PREVIOUS_FOOTER_EDIT) {
						doOnObserver({"event" : StateEvents.PREVIOUS_SKIP});
					}
				}
			}

		};

		var doOnComplete = function(args) {
			// Evaluate Complete
			if (isComplete(args)) {
				doOnObserver({"eventEnabled" : StateEvents.NEXT_ENABLED});
			} else {
				doOnObserver({"eventToggle" : {"estado" : StateEvents.HIDE_TOOLTIP_NEXT}});
				doOnObserver({"eventEnabled" : StateEvents.NEXT_DISABLED});
			}
			doOnObserver({"eventEnabled" : StateEvents.PREVIOUS_ENABLED});
		};

		var doOnExitScreen = function() {

			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), { }, function (index, aviso, args){
				removerOrdenamientos(model.ordenamientosPantalla,aviso.ordenamientos);
    		});
			model.ordenamientosPantalla = [];

			$.each($(".itemOrdenamientoSeleccionado"), function(index, value) {
				var codigo = $(value).parent().data("ordenamientoASeleccionarCodigo");
				var valor = $(value).data("itemOrdenamientoSeleccionadoValor");
				var codigoBusqueda = $(value).data("itemOrdenamientoSeleccionadoCodigoBusqueda");
				var descripcion = $(value).data("itemOrdenamientoSeleccionadoDescripcion");
				model.ordenamientosPantalla.push(new OrdenamientoAvisoValorizadoDTO({
					"codigo" : codigo,
					"valor" : valor,
					"codigoBusqueda" : codigoBusqueda,
					"descripcion" : descripcion
				}));
			});

			// agrego ordenamientos ocultos
			for ( var i = 0; i < model.ordenamientosValorUnico.length; i++) {
				model.ordenamientosPantalla.push(new OrdenamientoAvisoValorizadoDTO({
					"codigo" : model.ordenamientosValorUnico[i].codigo,
					"valor" : model.ordenamientosValorUnico[i].valor,
					"codigoBusqueda" : model.ordenamientosValorUnico[i].codigoBusqueda,
					"descripcion" : model.ordenamientosValorUnico[i].descripcion
				}));
			}

			modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), { }, function (index, aviso, args){
    			addOrdenamientos({
    				"sourceOrdenamientos" : model.ordenamientosPantalla,
    				"targetOrdenamientos" :aviso.ordenamientos
    			})
    		});
		};

		var bind = function(args) {
			// Implements -----
		};

		var unbind = function(args) {
			// Implements -----
		};

		var isComplete = function(args) {
			var isComplete = true;

			if (args.deselect){
				isComplete = false;
			} else {
				// valido que lo ordenamientos obligatorios esten completos:
				$.each(model.ordenamientosSecuenciados,function(index, value) {
					var ordenamientoSecuenciado = value;
					if (ordenamientoSecuenciado.obligatorio && !ordenamientoSecuenciado.ocultarValorUnico) {
						var encontrados = $.grep($(".itemOrdenamientoSeleccionado"),function(ordenamientoSeleccionado,index) {
							return $(ordenamientoSeleccionado).data("itemOrdenamientoSeleccionadoIdOrdenamientoAviso") === ordenamientoSecuenciado.id;
						});
						if (encontrados.length === 0) {
							isComplete = false;
						}
					}
					if (ordenamientoSecuenciado.obligatorio && ordenamientoSecuenciado.ocultarValorUnico) {
						// lo busco en el array
						var isCargado = false;
						for ( var i = 0; i < model.ordenamientosValorUnico.length; i++) {
							if (model.ordenamientosValorUnico[i].idOrdenamientoAviso === ordenamientoSecuenciado.id) {
								isCargado = true;
							}
						}
						if (!isCargado) {
							isComplete = false;
						}
					}
				});
			}
			return isComplete;
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
			doOnExitScreen		: doOnExitScreen,
			doOnLoad			: doOnLoad,
			doOnChange			: doOnChange,
			doOnShow			: doOnShow,
			doOnComplete		: doOnComplete,
			bind				: bind,
			unbind				: unbind,
			isComplete			: isComplete,
			notifyChange		: notifyChange,
			getAccedida			: getAccedida

		};

	};

})();