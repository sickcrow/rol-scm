/**
 * author: csantos version: 1.0.0
 * Funciones del paso Donde de Crear Aviso
 */


// -----------------------------------------------------------------------------
// StateStep2Creacion ---------------------------------------------------------
// -----------------------------------------------------------------------------

var StateStep2Creacion = (function() {

	return function(args) {

		// ------------------------------------------------
		// global interface ------------------------------
		// ------------------------------------------------

		gOnchangeZonaComercializacionHandler = function(event) {

			var elClick = $(event.currentTarget);

  			var checkbox = $('#' + $(this).attr('for'));
			if (checkbox.is(':checked')) {
				checkbox.removeAttr('checked');
				animacionRubro(elClick);
			} else {
				checkbox.attr('checked', 'checked');
				animacionRubro(elClick);
			}

		};

		gOnchangeNivelEstructuraHandler = function nivelEstructuraChangeHandler(event) {
			doOnComplete({});
		};

		gOnclickClosePopoverHandler = function() {
			$(".medioPopover").popover("hide");
		};


		// ------------------------------------------------
		// private interface -----------------------------
		// ------------------------------------------------

		var buildAgrupadorProductoZonasNivelesSearchDTO = function() {
			return new AgrupadorProductoZonasNivelesSearchDTO({
				codigoCanalEntrada					: crearAvisosModel.getCodigoCanalEntrada(),
				codigoClase							: crearAvisosModel.getClase().codigo,
				codigoTipoOperacion					: crearAvisosModel.getTipoOperacion().codigo,
				codigoAgrupamientoProductoTecnico	: crearAvisosModel.getCodigoAgrupamientoProductoTecnico(),
				fechaVigencia						: crearAvisosModel.getServerTime()
			});
		};

		var setAgrupadoresProductoZonasNiveles = function(data) {

			var listaData = arrayUtils.buildArrayObjFromJSON(data.agrupadoresProductoZonasNiveles,AgrupadorProductoZonasNivelesDTO);
			renderHandlebars(CrearAvisosTemplates.productoZonasNiveles,{agrupadoresProductoZonasNiveles : listaData},ui.productoZonasNivelesContainer);

			if (listaData[0].agrupadoresProductoComercialNivel.length === 1) {
				document.getElementById("select-" + listaData[0].producto.codigo).selectedIndex = 1;
			}

			seleccionarZonasOrden(crearAvisosModel.getOrdenDePublicacion());
			seleccionarRubroOrden(crearAvisosModel.getOrdenDePublicacion());

			doOnExit();
		};

		var hayZonasSeleccionadas = function(checkbox) {
			var checkboxes = $.makeArray($(checkbox).parent().parent().find(":checkbox:checked"));
			return checkboxes.length > 0;
		};

		var seleccionarRubroOrden = function(orden) {
			var rubro = orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.nivelEstructura;
			if (rubro !== null) {
				var indicePunto = rubro.codigo.indexOf(".");
				var producto = rubro.codigo.slice(0, indicePunto);
				var productoEspaciado = producto.replace("_", " ");
				var comboBoxRubro = document.getElementById("select-"+ productoEspaciado);
				$.each(comboBoxRubro.options,function(index, valor) {
					if (Detectizr.device.browser === "ie" && Detectizr.device.browserVersion <= "9") {
						// INTERNET EXPLORER 9 y 8
						if (valor.innerText.trim() === rubro.descripcion.trim()) {
							$(comboBoxRubro).prop("selectedIndex", index);
						}
					} else {
						if (valor.label === rubro.descripcion) {
							$(comboBoxRubro).prop("selectedIndex", index);
						}
					}
				});
			}
		};

		var seleccionarZonasOrden = function(orden) {
			var zonas = orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.zonasComercializacion;
            var bienSeleccionado = orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.codigoClase;

            //MDN - Este if esta por si biene de enamorados que se tape interior
            if(bienSeleccionado === "DIA_DE_LOS_ENAMORADOS" || bienSeleccionado === "DIA_DE_LOS_ENAMORADOS_1"){
                $("div[data-zona-descripcion='Interior']").hide();
                $("div[data-zona-descripcion='Capital Federal + GBA'] input").trigger( "click" );

            }

            //MDN - idem para dia de la madre
            if(bienSeleccionado === "DIA_DE_LA_MADRE" || bienSeleccionado === "DIA_DE_LA_MADRE_1"){
            	$("div[data-zona-descripcion='Interior']").hide();
            	$("div[data-zona-descripcion='Capital Federal + GBA'] input").trigger( "click" );
            }

            if (zonas !== null) {
				$.each(zonas,function(index, zona) {
					var comboBoxZona = document.getElementById(zona.codigo);
					$(comboBoxZona).attr("checked", true);
					/* Llamada a funcion de animacion */
					animacionRubro(comboBoxZona);
				});
			}
		};


		var animacionRubro = function animacionRubro(elClicked) {

			if (!$(elClicked).is(":checked") === false) {
				$.blockUI({
					message : null,
					overlayCSS : {backgroundColor : "transparent"}
				});

				setTimeout($.unblockUI, 400);
				//$(elClicked).parent().parent().parent().animate({width : '100%'},{

				$("#MedioRubroMainWrapper").animate({width : '100%'},{
					queue : false,
					duration : 400,
					complete : function() {
						if(Detectizr.device.type === "mobile" || Detectizr.device.type === "tablet"){
							$(".bloqueZonas").css({"width" : '100%'});
						}else{
							$(".bloqueZonas").css({"width" : '25%'});
						}
						$(".selectRubroPaso2").select2({placeholder:'Selecciona un rubro'});
						$(elClicked).parent().parent().siblings(".combobox").fadeIn("fast");
						$(elClicked).parent().parent().siblings().find(".combobox").fadeIn("fast");
						var mensajePopoverRubro = "Ahora eleg&iacute; el rubro";
						creaPopover(mensajePopoverRubro);
						$(".popover").addClass("rubroPopover");
					}
				});
			} else if (!hayZonasSeleccionadas($(elClicked))) {
				$.blockUI({
					message : null,
					overlayCSS : {backgroundColor : "transparent"}
				});

				setTimeout($.unblockUI, 400);
				$(elClicked).parent().parent().siblings(".combobox").hide();
				$(elClicked).parent().parent().siblings().find(".combobox").hide();
				$(elClicked).siblings().find("input[type=checkbox]:checked").hide();
				$(".bloqueZonas").css({"width" : '100%'});
				$("#MedioRubroMainWrapper").animate({width:'260px'},{
					queue : false,
					duration : 400,
					complete : function() {
						$(elClicked).parent().parent().siblings(".combobox").hide();
						$(elClicked).parent().parent().siblings().find(".combobox").hide();
						var mensajePopoverMedios = "Eleg&iacute; el medio";
						creaPopover(mensajePopoverMedios);
						$(".popover").addClass("elegi");
					}
				});
				$(".combobox").hide();
			}
			doOnComplete({});
		};
		var creaPopover = function(mensajePopover) {

			$(".medioPopover").popover("destroy");
			var mensajePopoverMediosCerrar = "<button type='button' class='close' onclick='gOnclickClosePopoverHandler()'>×</button>";
			$(".medioPopover").popover({
				content : mensajePopoverMediosCerrar + mensajePopover,
				html : true,
				placement : "top"
			});
            var rubroOptionSeleccionado = $("#selectRubro option").attr("data-nivel-estructura-codigo");

            if(rubroOptionSeleccionado !== "CLASIFICADOS_CLARIN.CONTACTOS.RUBRO_58.DIA_DE_LA_MADRE"){
                $(".rubroPopover").popover("show");
            }else{
                console.log("Dia de la madre");
                $(".rubroPopover").popover("hide");
            }
		};

		var setModel = function(args) {

			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;

			$.each(args.agrupadoresAvisoProductoZonasNiveles,function(indexAgrupadorAvisoProductoZonasNiveles,agrupadorAvisoProductoZonasNiveles) {

				aviso.zonasComercializacion = agrupadorAvisoProductoZonasNiveles.zonasComercializacion;
				crearAvisosModel.setZonasComercializacion(agrupadorAvisoProductoZonasNiveles.zonasComercializacion);
				// Seteo en la orden el nivel de estructura.
				if (agrupadorAvisoProductoZonasNiveles.nivelEstructura !== null) {
					aviso.nivelEstructura = agrupadorAvisoProductoZonasNiveles.nivelEstructura;
					crearAvisosModel.setCodigoNivelEstructura(agrupadorAvisoProductoZonasNiveles.nivelEstructura.codigo);
				}
				// Seteo en la orden el producto.
				if (agrupadorAvisoProductoZonasNiveles.productoComercial !== null) {
					aviso.productoComercial = agrupadorAvisoProductoZonasNiveles.productoComercial;
					crearAvisosModel.setCodigoProducto(agrupadorAvisoProductoZonasNiveles.productoComercial.producto.codigo);
					crearAvisosModel.setCodigoProductoComercial(agrupadorAvisoProductoZonasNiveles.productoComercial.codigo);
				}
			});
		};

		var equalsProductoComercial = function(productoComercialA,productoComercialB) {
			// Evaluo si los productos comerciales son igualse.
			return (productoComercialA && productoComercialA && productoComercialA.codigo === productoComercialB.codigo && equalsProducto(
					productoComercialA.producto, productoComercialB.producto));
		};

		var equalsProducto = function(productoA, productoB) {
			// Evaluo si los productos son iguales.
			return (productoA && productoB && productoA.codigo === productoB.codigo);
		};

		var equalsNivelEstructura = function(nivelEstructuraA, nivelEstructuraB) {
			// Evaluo si los niveles son iguales.
			return (nivelEstructuraA && nivelEstructuraB && nivelEstructuraA.codigo === nivelEstructuraB.codigo);
		};

		var equalsZonasComercializacion = function(zonasComercializacionA,zonasComercializacionB) {
			// Evaluo si las zonas de comercializacion
			var result = true;
			if ($.isArray(zonasComercializacionA) && $.isArray(zonasComercializacionB)) {
				if (zonasComercializacionA.length === zonasComercializacionB.length) {
					$.each(zonasComercializacionA, function(indexA, zonaA) {
						var encontrado = $.grep(zonasComercializacionB,
								function(zonaB, indexB) {
									return zonaA.codigo === zonaB.codigo;
								}).length > 0;
						if (!encontrado) {
							result = false;
							return false;
						}
					});
				} else {
					result = false;
				}
			}
			return result;
		};

		var evaluateChange = function(args) {

			var change = false;

			$.each(model.generatedData.agrupadoresAvisoProductoZonasNivel,function(index, value) {
				var generatedAgrupadorAvisoProductoZonasNivelOld = value;

				var productoComercialEquals = false;
				var nivelEstructuraEquals = false;
				var zonasEquals = false;
				var conceptoBase;

				$.each(args.newData.agrupadoresAvisoProductoZonasNivel,function(index, value) {
					var generatedAgrupadorAvisoProductoZonasNivelNew = value;
					if (equalsProductoComercial(
							generatedAgrupadorAvisoProductoZonasNivelNew.productoComercial,
							generatedAgrupadorAvisoProductoZonasNivelOld.productoComercial)) {

						productoComercialEquals = true;

						if (equalsNivelEstructura(
								generatedAgrupadorAvisoProductoZonasNivelNew.nivelEstructura,
								generatedAgrupadorAvisoProductoZonasNivelOld.nivelEstructura)) {
							nivelEstructuraEquals = true;
						}

						if (equalsZonasComercializacion(
								generatedAgrupadorAvisoProductoZonasNivelOld.zonasComercializacion,
								generatedAgrupadorAvisoProductoZonasNivelNew.zonasComercializacion)) {
							zonasEquals = true;
						}
					}
				});

				if(!productoComercialEquals || !nivelEstructuraEquals ){
					limpiarOrden();
				}
				if(!zonasEquals){
					crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.fechaPedidoPublicacion = null;
					conceptoBase = new ConceptoVendibleAvisoDTO(crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0]);
					crearAvisosModel.getOrdenDePublicacion().conceptosVendibles = [];
					crearAvisosModel.getOrdenDePublicacion().conceptosVendibles.push(conceptoBase);
				}

				if (!productoComercialEquals || !nivelEstructuraEquals || !zonasEquals) {
					change = true;
					// saco las imagenes de la orden para que no
					// se muesren luego de ir a registrarse
					// SFHUB-2680
					crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.preview = null;
					crearAvisosModel.setPalabrasProhibidas(null);
					return false;
				}
			});

			// Guardo la nuevo info.
			model.generatedData.agrupadoresAvisoProductoZonasNivel = args.newData.agrupadoresAvisoProductoZonasNivel;

			// Updateo la variable de notificacion de cambio.
			model.notifyChange = change;

		};

		var actualizarDescripcionConcepto = function(args) {
			var conceptoVendible = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0];
			var descripcionConcepto = crearAvisosModel.getFamilia().descripcion + " > ";

			// Capitaliza la clase
			var clase = crearAvisosModel.getClase().descripcion.toLowerCase().replace(/\b[a-z]/g, function(letter) {
						return letter.toUpperCase();
					});

			// Capitaliza un el tipo de producto
			var tipoProducto = args.tipoProducto.toLowerCase().replace(/\b[a-z]/g, function(letter) {
						return letter.toUpperCase();
					});

			descripcionConcepto = descripcionConcepto + clase + " > ";
			descripcionConcepto = descripcionConcepto + crearAvisosModel.getTipoOperacion().codigo + " - ";
			descripcionConcepto = descripcionConcepto + tipoProducto + " > ";
			descripcionConcepto = descripcionConcepto + args.producto + " > ";

			// Busco si es lineal. Si el dia de mañana deciden vender otro tipo
			// de producto
			// deberian agregar otro if. Esto es porque no me llega el tipo.
			if (args.codigoProdComercial.toLowerCase().indexOf("lineal") >= 0) {
				descripcionConcepto = descripcionConcepto + "Lineal > ";
			}
			descripcionConcepto = descripcionConcepto + args.descripcionNivel;

			conceptoVendible.descripcion = descripcionConcepto;
		};

		var getAccedida = function() {
			return accedida;
		};

		var generarTextBreadCrum = function() {
			// Muestro el div con la descripcion de lo seleccionado
			ui.textoSeleccionaste[0].innerHTML = selectionBarUtils.generarTextoSeleccionaste(crearAvisosModel);
		};

		var generateTag = function() {
			decoratorModel.setA2("donde-se-publicara");
			var area = decoratorModel.getA1() + decoratorModel.getA2();
			gChangeTagName(area);
		};

		var verificarExistenDatosOrden = function() {
			var existenDatos = false;
			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;

			if( (aviso.zonasComercializacion !== null && aviso.zonasComercializacion !== undefined && aviso.zonasComercializacion.length > 0) &&
				(aviso.nivelEstructura !== null && aviso.nivelEstructura !== undefined) &&
				(aviso.productoComercial !== null && aviso.productoComercial !== undefined) ) {
					existenDatos = true;
			}
			return existenDatos;
		};

		var limpiarOrden = function(){
			var conceptoBase;
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.ordenamientos = new Array();
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.fechaPedidoPublicacion = null;
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.textoJustificado = "";
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.textoLibreJustificado = "";
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.preview	= null;
			conceptoBase = new ConceptoVendibleAvisoDTO(crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0]);
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles = [];
			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles.push(conceptoBase);
			crearAvisosModel.setTarjeta365("");
		};

		var renderHandlebars = function(source, context, uiComponent) {
			var template = Handlebars.compile(source);
			var html = template(context);
			uiComponent.append(html);
		};

		var limpiarPantalla = function() {
			doOnCancel();
		};

		var agregaPaso = function(){
			$(".infoPaso").remove();
			$("#MyWizard .steps").append("<li class='infoPaso'>2/5</li>");
		}

		var dibujarPantalla = function() {
			agregaPaso();
			// obtengo los datos del calendario.
			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_AGRUPADORES_PRODUCTO_ZONAS_NIVELES,
				dataObject : buildAgrupadorProductoZonasNivelesSearchDTO(),
				successHandlerCallback : setAgrupadoresProductoZonasNiveles,
				errorHandlerCallback : defaultErrorHandler
			});
		};

		// ------------------------------------------------
		// common interface ------------------------------
		// ------------------------------------------------

		var accedida = false;

		var index = 2;

		var doOnObserver = args.doOnObserver;

		var ui = {
			productoZonasNivelesContainer	: $("#MedioRubroMainWrapper"),
			zonaBox							: $("#zonaBox"),
			rubroBox						: $("#rubroBox"),
			panelVerSeleccionado			: $(".panel-ver-seleccionado"),
			textoSeleccionaste				: $("#textoSeleccionaste"),
			divTextoSeleccionaste			: $("#divTextoSeleccionaste"),
			categoriaBox					: $("#categoriaBox"),
			bienBox							: $("#bienBox"),
			tipoOperacionBox				: $("#tipoOperacionBox"),
			navFooterWizard					: $("#navFooterWizard")
		};

		var model = {
			notifyChange		: false,
			generatedData		: new GeneratedDataStep2({})
		};

		var doOnLoad = function(args) {

			var breadcrum_text = selectionBarUtils.generarTextoSeleccionaste(crearAvisosModel);

			/* Modifico el texto del popup de "Ver Seleccion" con lo seleccionado hasta el momento */
			modifyVerSeleccionadoText(breadcrum_text);

			generarTextBreadCrum(breadcrum_text);

			showBreadcrum('DONDE');
			showPanelSeleccionado('DONDE');
			generateTag();
			dibujarPantalla();
			accedida = true;
			doOnComplete({});

			//debo de regenerar la data debido a que cuando entra x onload y vuelve para atras el model esta vacio y no detecta cambio
			//pregunto primero si tiene cargada la informacion para agregar y evaluar camibios
			var agrupadoresAvisoProductoZonasNiveles = [];
			var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			if(aviso.zonasComercializacion.length > 0 && aviso.nivelEstructura !== null && aviso.productoComercial !== null){
				agrupadoresAvisoProductoZonasNiveles.push(new AgrupadorAvisoProductoZonasNivelDTO({
																"productoComercial" : aviso.productoComercial,
																"nivelEstructura" : aviso.nivelEstructura,
																"zonasComercializacion" : aviso.zonasComercializacion
															})
				);
			}
			evaluateChange({
				"newData" : new GeneratedDataStep2({"agrupadoresAvisoProductoZonasNivel" : agrupadoresAvisoProductoZonasNiveles})
			});
		};

		/**
		 * { event : StateEvents.EVENT_CONST, }
		 */
		var doOnEnter = function(args) {
			var breadcrum_text = selectionBarUtils.generarTextoSeleccionaste(crearAvisosModel);

			/* Modifico el texto del popup de "Ver Seleccion" con lo seleccionado hasta el momento */
			modifyVerSeleccionadoText(breadcrum_text);

			generarTextBreadCrum(breadcrum_text);

			showBreadcrum('DONDE');
			showPanelSeleccionado('DONDE');
			agregaPaso();
			if (args.event === StateEvents.PREVIOUS_FOOTER_ON_LOAD) {
				doOnLoad();
			} else {
				generateTag();
				if ( !verificarExistenDatosOrden() || !accedida) {
					limpiarPantalla();
					dibujarPantalla();
					accedida = true;
				}
				doOnComplete({});
			}
			
			if($(".bloqueZonas input:checked").length == 0){
				$("#paso2-Medio-rubro .MedioRubroMainWrapper").css({width:""});
			}
		};

		/**
		 * { event : StateEvents.EVENT_CONST, }
		 */
		var doOnExit = function(args) {

			var agrupadoresAvisoProductoZonasNiveles = [];

			var tipoProducto		= "";
			var producto			= "";
			var descripcionNivel	= "";
			var codigoProdComercial = "";

			$.each($.makeArray($(".agrupadorProductoZonasNiveles")),function(index,agrupadorProductoComercialZonasNiveles) {
				var agrupadorAvisoProductoZonasNivel = new AgrupadorAvisoProductoZonasNivelDTO({});
				var zonasSelected = false;
				var nivelSelected = false;

				$.each($.makeArray($(agrupadorProductoComercialZonasNiveles).find(":checkbox:checked")),
					function(index, zona) {agrupadorAvisoProductoZonasNivel.zonasComercializacion.push(
							new ZonaComercializacionDTO({
												"codigo" : $(zona).data("zonaComercializacionCodigo"),
												"descripcion" : $(zona).data("zonaComercializacionDescripcion")
											}));
											zonasSelected = true;
										});

				if (zonasSelected) {
					// Obtengo el producto del agrupador.
					var productoAgrupador = $(".productoAgrupador",agrupadorProductoComercialZonasNiveles)[0];
					var codigoNivelEstructura = $(agrupadorProductoComercialZonasNiveles).find("select option:selected").val();
					var productoComercial = null;

					if (codigoNivelEstructura !== "") {
						var agrupadorProductoComercialNivelEstructuraSelected = $(agrupadorProductoComercialZonasNiveles).find("select option:selected");

						agrupadorAvisoProductoZonasNivel.nivelEstructura = new NivelEstructuraDTO({
							"codigo"		: $(agrupadorProductoComercialNivelEstructuraSelected).data("nivelEstructuraCodigo"),
							"tipo"			: $(agrupadorProductoComercialNivelEstructuraSelected).data("nivelEstructuraTipo"),
							"descripcion"	: $(agrupadorProductoComercialNivelEstructuraSelected).data("nivelEstructuraDescripcion")
						});
						descripcionNivel = $(agrupadorProductoComercialNivelEstructuraSelected).data("nivelEstructuraDescripcion");

						agrupadorAvisoProductoZonasNivel.productoComercial = new ProductoComercialDTO({
							"codigo"		: $(agrupadorProductoComercialNivelEstructuraSelected).data("productoComercialCodigo"),
							"tipo"			: $(agrupadorProductoComercialNivelEstructuraSelected).data("productoComercialTipo"),
							"producto"		: new ProductoDTO({
								"codigo"		: $(productoAgrupador).data("productoCodigo"),
								"tipo"			: $(productoAgrupador).data("productoTipo"),
								"descripcion"	: $(productoAgrupador).data("productoDescripcion")
							})
						});
						codigoProdComercial = $(agrupadorProductoComercialNivelEstructuraSelected).data("productoComercialCodigo");
						tipoProducto = $(productoAgrupador).data("productoTipo");
						producto = $(productoAgrupador).data("productoDescripcion");

						agrupadoresAvisoProductoZonasNiveles.push(agrupadorAvisoProductoZonasNivel);
						nivelSelected = true;
					}
				}
				if (zonasSelected && nivelSelected) {
					setModel({"agrupadoresAvisoProductoZonasNiveles" : agrupadoresAvisoProductoZonasNiveles});
					evaluateChange({
						"newData" : new GeneratedDataStep2({"agrupadoresAvisoProductoZonasNivel" : agrupadoresAvisoProductoZonasNiveles})
					});
				}
			});

			actualizarDescripcionConcepto({
				"tipoProducto"			: tipoProducto,
				"descripcionNivel"		: descripcionNivel,
				"codigoProdComercial"	: codigoProdComercial,
				"producto"				: producto
			});
			if (args && args.event && args.event == StateEvents.NEXT_FOOTER){

				blockCallerUI.blockPost({ url : CrearAvisoServiceURL.GET_PRODUCTO_COMERCIAL_DEFAULT,
					dataObject : buildProductoComercialDefaultDTO(),
					successHandlerCallback : getProductoComercialDefaultHandler,
					errorHandlerCallback : defaultErrorHandler });
			}
    	};

    	var buildProductoComercialDefaultDTO = function (args){

    		return new ProductoComercialDefaultDTO({
    			codigoAgrupamientoProductoTecnico : crearAvisosModel.getCodigoAgrupamientoProductoTecnico(),
    			codigoCanalEntrada : crearAvisosModel.getCodigoCanalEntrada(),
    			codigoTipoOperacion : crearAvisosModel.getTipoOperacion().codigo,
    			codigoNivelEstructura : crearAvisosModel.getCodigoNivelEstructura()
    		});

    	};

    	var getProductoComercialDefaultHandler = function(data){
			var productoComercialDefault = new ProductoComercialDefaultDTO(data.productoComercialDefault);
			crearAvisosModel.setCodigoTemplateDetallado(productoComercialDefault.codigoTemplate);
		};

		var doOnError = function(args) {
			// Implements -----
		};

		var doOnCancel = function(args) {
			accedida = false;
			ui.productoZonasNivelesContainer[0].innerHTML = "";
			model.generatedData = new GeneratedDataStep2({});
			doOnComplete({});
		};

		var doOnChange = function(args) {

		};

		var doOnShow = function(args) {
			// Implements -----
			var mensajePopoverMedios = "Eleg&iacute; el medio";
			creaPopover(mensajePopoverMedios);
			$("#paso2-DondePublicara .popover").addClass("elegi");
		};

		var doOnComplete = function(args) {
			ui.navFooterWizard.show();
			// Evaluate Complete
			if (isComplete(args)) {
				doOnObserver({"eventEnabled" : StateEvents.NEXT_ENABLED});
			} else {
				doOnObserver({"eventEnabled" : StateEvents.NEXT_DISABLED});
			}
		};

		var doOnExitScreen = function() {
			// si no tiene seteados los elementos de la pantall los seteo en
			// esta funcion
			var agrupadoresAvisoProductoZonasNiveles = [];

			var tipoProducto			= "";
			var producto				= "";
			var descripcionNivel		= "";
			var codigoProdComercial		= "";

			$.each($.makeArray($(".agrupadorProductoZonasNiveles")),function(index,agrupadorProductoComercialZonasNiveles) {
				var agrupadorAvisoProductoZonasNivel = new AgrupadorAvisoProductoZonasNivelDTO({});
				var zonasSelected = false;
				var nivelSelected = false;
				$.each($.makeArray($(agrupadorProductoComercialZonasNiveles).find(":checkbox:checked")),function(index, zona) {
					agrupadorAvisoProductoZonasNivel.zonasComercializacion.push(new ZonaComercializacionDTO({
						"codigo" : $(zona).data("zonaComercializacionCodigo"),
						"descripcion" : $(zona).data("zonaComercializacionDescripcion")
					}));
					zonasSelected = true;
				});

				if (zonasSelected) {
					// Obtengo el producto del agrupador.
					var productoAgrupador = $(".productoAgrupador",agrupadorProductoComercialZonasNiveles)[0];
					var codigoNivelEstructura = $(agrupadorProductoComercialZonasNiveles).find("select option:selected").val();
					var productoComercial = null;

					if (codigoNivelEstructura !== "") {
						var agrupadorProductoComercialNivelEstructuraSelected = $(agrupadorProductoComercialZonasNiveles).find("select option:selected");
						agrupadorAvisoProductoZonasNivel.nivelEstructura = new NivelEstructuraDTO({
							"codigo"		: $(agrupadorProductoComercialNivelEstructuraSelected).data("nivelEstructuraCodigo"),
							"tipo"			: $(agrupadorProductoComercialNivelEstructuraSelected).data("nivelEstructuraTipo"),
							"descripcion"	: $(agrupadorProductoComercialNivelEstructuraSelected).data("nivelEstructuraDescripcion")
						});
						descripcionNivel = $(agrupadorProductoComercialNivelEstructuraSelected).data("nivelEstructuraDescripcion");

						agrupadorAvisoProductoZonasNivel.productoComercial = new ProductoComercialDTO({
							"codigo"		: $(agrupadorProductoComercialNivelEstructuraSelected).data("productoComercialCodigo"),
							"tipo"			: $(agrupadorProductoComercialNivelEstructuraSelected).data("productoComercialTipo"),
							"producto"		: new ProductoDTO({
								"codigo"		: $(productoAgrupador).data("productoCodigo"),
								"tipo"			: $(productoAgrupador).data("productoTipo"),
								"descripcion"	: $(productoAgrupador).data("productoDescripcion")
							})
						});
						codigoProdComercial = $(agrupadorProductoComercialNivelEstructuraSelected).data("productoComercialCodigo");
						tipoProducto = $(productoAgrupador).data("productoTipo");
						producto = $(productoAgrupador).data("productoDescripcion");

						nivelSelected = true;
					}
					agrupadoresAvisoProductoZonasNiveles.push(agrupadorAvisoProductoZonasNivel);
				}
				if (zonasSelected) {
					setModel({"agrupadoresAvisoProductoZonasNiveles" : agrupadoresAvisoProductoZonasNiveles});
					if (nivelSelected) {
						evaluateChange({"newData" : new GeneratedDataStep2({"agrupadoresAvisoProductoZonasNivel" : agrupadoresAvisoProductoZonasNiveles})
						});
					}

				}

			});
		};
		var bind = function(args) {
			// Implements -----
		};

		var unbind = function(args) {
			// Implements -----
		};

		var isComplete = function(args) {
			/**
			 * Verifico que en al menos un producto haya: al menos 1 zona y el
			 * nivel seleccionado.
			 */
			var complete = false;
			$.each($.makeArray($(".agrupadorProductoZonasNiveles")), function(
					index, agrupadorProductoZonasNiveles) {
				var zonasSelected = false;
				$.each($.makeArray($(agrupadorProductoZonasNiveles).find(
						":checkbox:checked")), function(index, zona) {
					zonasSelected = true;
					return false;
				});
				if (zonasSelected && $(agrupadorProductoZonasNiveles).find(
					"select option:selected").val() !== "") {
					complete = true;
					return false;
				}
			});
			return complete;
		};

		var notifyChange = function(args) {
			return model.notifyChange;
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