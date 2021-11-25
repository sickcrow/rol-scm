/**
 * author: csantos version: 1.0.0
 * Funciones del paso Cuando de Crear Aviso
 */


//-----------------------------------------------------------------------------
//StateStep3Creacion ---------------------------------------------------------
//-----------------------------------------------------------------------------

var StateStep3Creacion = (function() {

	return function(args) {

		// ------------------------------------------------
		// global interface ------------------------------
		// ------------------------------------------------

		gOnclickQuitarFechaHandler = function(target) {
			var fecha = $(target).data("fecha");
			ui.calendar.multiDatesPicker("removeDates", fecha);
			ui.divListaPromosPaso3.style.display = "none";
			onSelectDateHandler([]);
			doOnComplete({});
			if($("#days-selected .mesSelect").length == 0){
				ui.contDaysSelectedConteiner.addClass("hide");
			}
		};

		// ------------------------------------------------
		// private interface -----------------------------
		// ------------------------------------------------

		var calendarConfig = {
			maxPicks			: 60,
			dateFormat			: dateUtils.SHORT_FORMAT_STRING_DATA,
			onSelect			: null,
			addDisabledDates	: null,
			addDates			: null
		};

		var calendarPopoverConfig = {
			html : true
		};

		var getCodigosZonaComercializacion = function() {

			var codigosZonaComercializacion = [];

			for ( var i = 0; i < crearAvisosModel.getZonasComercializacion().length; i++) {
				codigosZonaComercializacion.push(crearAvisosModel.getZonasComercializacion()[i].codigo);
			}
			return codigosZonaComercializacion;
		};

		var getCalendarParams = function() {

			return new CalendarioSearchDTO({
				nivelEstructura			: crearAvisosModel.getCodigoNivelEstructura(),
				controlarHorarioCierre	: crearAvisosModel.getControlarHorarioCierre(),
				zonasComercializacion	: getCodigosZonaComercializacion(),
				idItemPromocion			: crearAvisosModel.getIdItemPromocion(),
				fechaVigencia			: crearAvisosModel.getServerTime().getTime(),
				codigoCanalEntrada		: crearAvisosModel.getCodigoCanalEntrada()
			});

		};

		var setServerTimeHandler = function(data) {
			crearAvisosModel.setServerTime(new Date(data.serverTime));
			setRangeCalendar();
		};

		var setRangeCalendar = function() {
			// despues de la inicializacion el maximo y minimo dia debe ser
			// seteado de este modo.
			ui.calendar.datepicker("option", "minDate", crearAvisosModel.getServerTime());
			ui.calendar.datepicker("option", "maxDate", crearAvisosModel.getServerTime().addDays(61));
		};

		var setAvailablesDaysCalendarHandler = function(data) {

			// limpia el calendario para que se refresque la pantalla
			calendarConfig.addDates = null;
			ui.calendar.multiDatesPicker("resetDates");
			ui.calendar.multiDatesPicker("resetDates", "disabled");
			var disabledDates = dateUtils.substractDays(dateUtils.getDateRange(crearAvisosModel.getServerTime(), (crearAvisosModel.getServerTime()).addDays(61)), data.dates);

			calendarConfig.addDisabledDates = disabledDates;
			// Me paro en la primera fecha disponible.
			ui.calendar.datepicker("setDate", dateUtils.getDateFormatString(new Date(data.dates[0])));

			ui.calendar.multiDatesPicker(calendarConfig);

			var fechasPedidoPublicacionString = getFechasPedidoPublicacionString();
			if (fechasPedidoPublicacionString.length > 0) {
				ui.calendar.multiDatesPicker("addDates",fechasPedidoPublicacionString);
				onSelectDateHandlerFromOrden(fechasPedidoPublicacionString);
			}
			else{
				onSelectDateHandlerFromOrden(fechasPedidoPublicacionString);
				getConfiguracionesPromocionPantallaFromOrden();
			}
    		doOnComplete({});

		};

		var getFechasPedidoPublicacionString = function() {
			var fechasPedidoPublicacionString = [];

			$.each(crearAvisosModel.getOrdenDePublicacion().conceptosVendibles,function(indexConcepto, concepto) {
				$.each(concepto.itemsConceptoVendible,function(indexItemConcepto,itemConcepto) {
					$.each(itemConcepto.itemsAviso,function(indexItemAviso,itemAviso) {
						if (itemAviso.aviso.fechaPedidoPublicacion) {
							fechasPedidoPublicacionString.push(dateUtils.getDateFormatString(new Date(itemAviso.aviso.fechaPedidoPublicacion)));
						}
					});
				});
			});

			return fechasPedidoPublicacionString;
		};


		var onSelectDateHandlerFromOrden = function (date){
			Handlebars.registerHelper("dia", CrearAvisosHelpers.selectedDateDia);
			Handlebars.registerHelper("mes", CrearAvisosHelpers.selectedDateMes);

			var source		= CrearAvisosTemplates.selectedDate;
			var template	= Handlebars.compile(source);
			var data		= ui.calendar.multiDatesPicker("getDates");
			var context		= {selectedDates : data};
			var html		= template(context);

			ui.contDaysSelected.html(html);

			crearAvisosModel.setSelectedDates(ui.calendar.multiDatesPicker('getDates'));
			setRangeCalendar();
			getConfiguracionesPromocionPantallaFromOrden();
			doOnComplete({});
		}

		var onSelectDateHandler = function(date) {


			Handlebars.registerHelper("dia", CrearAvisosHelpers.selectedDateDia);
			Handlebars.registerHelper("mes", CrearAvisosHelpers.selectedDateMes);

			var source		= CrearAvisosTemplates.selectedDate;
			var template	= Handlebars.compile(source);
			var data		= ui.calendar.multiDatesPicker("getDates");
			var context		= {selectedDates : data};
			var html		= template(context);

			ui.contDaysSelected.html(html);
			ui.contDaysSelectedConteiner.removeClass("hide");

			crearAvisosModel.setSelectedDates(ui.calendar.multiDatesPicker('getDates'));

			//Aca verificamos si las fechas que estan marcadas, son las mismas fechas que tiene la orden.
			//Esto se da en los casos cuando se vuelve de pasos mas adelantados del wizzard.
			var incluida	= false;
			if(crearAvisosModel.getSelectedDates().length === getFechasPedidoPublicacionString().length){
				$.each(getFechasPedidoPublicacionString(),function(index,fechaOrden) {
					$.each(crearAvisosModel.getSelectedDates(),function(indexF,fechaCalendario) {
						if (fechaOrden == fechaCalendario) {
							incluida = true;
							return;
						}else {
							incluida = false;
						};
					});
					if (!incluida){
						return;
					};
				});
			};
    		if (!incluida){
    			model.modificoFechas = true;
    			crearConceptosVendibles();
    		}
    		setRangeCalendar();
    		getConfiguracionesPromocionPantalla();
    		doOnComplete({});

			if($("#days-selected .mesSelect").length == 0){
				ui.contDaysSelectedConteiner.addClass("hide");
				ui.divListaPromosPaso3.style.display = "none";
			}
		};

		var evaluateChange = function(args) {

			var change = false;

			if (model.generatedData.fechasDePublicacion.length > 0 &&
					model.generatedData.fechasDePublicacion.length !== args.newData.fechasDePublicacion.length){
				change = true;
			} else {
				$.each(model.generatedData.fechasDePublicacion, function(index, generatedFechaDePublicacionOld) {
					var encontrado = false;
					$.each(args.newData.fechasDePublicacion, function(index, generatedFechaDePublicacionNew) {
						if (generatedFechaDePublicacionNew.getTime() === generatedFechaDePublicacionOld.getTime()) {
							encontrado = true;
						}
					});
					if (!encontrado){
						change = true;
						return false;
					}
				});
			}
			if (model.modificoFechas === true) {
				change = true;
				model.modificoFechas = false;
			}
			if (change){
				// Corto el bucle. saco las imagenes de la orden para que no se muesren luego de ir a registrarse SFHUB-2680
				modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), null, function (index, aviso, args){
					aviso.preview = null;
				});
				crearAvisosModel.setPalabrasProhibidas(null);
				crearAvisosModel.setTarjeta365("");
			}
			// Guardo la nuevo info.
			model.generatedData.fechasDePublicacion = args.newData.fechasDePublicacion;
			// Updateo la variable de notificacion de cambio.
			model.notifyChange = change;

		};

		var getConfiguracionesPromocionPantalla = function(args) {

			// obtengo los datos de la configuracion de promocion pantalla.
			if (crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.fechaPedidoPublicacion !== null) {

				blockCallerUI.blockPost({
					url : CrearAvisoServiceURL.GET_CONFIGURACIONES_PROMOCION_PANTALLA,
					dataObject : new PromocionSearchDTO({
						"codigoCanalEntrada"			: crearAvisosModel.getCodigoCanalEntrada(),
						"codigoProductoComercial"		: crearAvisosModel.getCodigoProductoComercial(),
						"codigoNivelEstructura"			: crearAvisosModel.getCodigoNivelEstructura(),
						"codigoZonasComercializacion"	: obtenerCodigosZonasComercializacion(),
						"fechaVigencia"					: crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.fechaPedidoPublicacion
					}),
					successHandlerCallback : configuracionPromocionPantallaHandler,
					errorHandlerCallback : defaultErrorHandler
				});
			}

		};

		var configuracionPromocionPantallaHandler = function(data) {
			crearAvisosModel.setConfiguracionesPromocionPantalla(arrayUtils.buildArrayObjFromJSON(data.configuracionesPromocionPantalla,ConfiguracionPromocionPantallaDTO));
			obtenerPromociones(data);
			mostrarPromociones(data);
			validarPromociones();
		};

		var obtenerCodigosZonasComercializacion = function(args) {
			var zonasComercializacion = [];
			$.each(crearAvisosModel.getZonasComercializacion(), function(index,zona) {
				zonasComercializacion.push(zona.codigo);
			});
			return zonasComercializacion;
		};

		var obtenerPromociones = function(data) {
			model.configuracionesPromocionPantallaVisible = [];
			if (crearAvisosModel.getConfiguracionesPromocionPantalla() && crearAvisosModel.getConfiguracionesPromocionPantalla().length > 0) {
				$.each(crearAvisosModel.getConfiguracionesPromocionPantalla(),function(indexPromociones,configuracionPromocionPantalla) {
					if (configuracionPromocionPantalla.pantallaShow === index) {
						model.configuracionesPromocionPantallaVisible.push(configuracionPromocionPantalla);
					}
				});
			}
		};

		var mostrarPromociones = function(args) {

			limpiarPromocionesPantalla();

			if (model.configuracionesPromocionPantallaVisible.length > 0) {
				renderHandlebars(CrearAvisosTemplates.promociones,{
					configuracionesPromocion : model.configuracionesPromocionPantallaVisible
				}, ui.promociones);
				ui.divListaPromosPaso3.style.display = "block";
				posicionarFechasSeleccionadas();
			} else {
				ui.divListaPromosPaso3.style.display = "none";
			}
		};

		var renderHandlebars = function(source, context, uiComponent) {
			var template = Handlebars.compile(source);
			var html = template(context);
			uiComponent.append(html);
		};


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

    				//se setea el numero de item aviso incremental  por cada fecha seleccionada
    				//en el caso de promociones de repeticion de contenido debe realizarse la logica cuando arma un solo concepto
    				conceptoVendibleTemp.itemsConceptoVendible[0].itemsAviso.push(itemAvisoTemp);
    				crearAvisosModel.getOrdenDePublicacion().conceptosVendibles.push(conceptoVendibleTemp);
    				crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[indice].itemsConceptoVendible[0].itemsAviso[0].aviso.fechaPedidoPublicacion = fechaSeleccionada;
    				crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[indice].fechaTarifa = fechaSeleccionada;
    			});
    		}
    		else{
    			limpiarPromocionesPantalla();
    			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles.push(conceptoBase);
    			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso.push(itemAvisoBase);
    			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.fechaPedidoPublicacion = null;
    			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.textoLibreJustificado ="";
    			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.preview = null;
    			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.avisoPromocion =[];
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

			if (promocionesRemover) {
				$.each(promocionesRemover,function(index, avisoPromocionRemover) {
					var avisoPromocionEncontrados = $.grep(promociones,function(promociones,index) {
						return (avisoPromocionRemover.promocion.repiteSalida === true);
					});

					if (avisoPromocionEncontrados.length === 1) {
						var indexBorrar = $.inArray(avisoPromocionEncontrados[0],promociones);
						promociones.splice(indexBorrar, 1);
					}

				});
			};

			crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.avisoPromocion = promociones;
		};

		var limpiarPromocionesPantalla = function(){
			ui.promociones.empty();
		};


    	var validarPromociones = function(){

    		var templateDetalladoAValidar = crearAvisosModel.getCodigoTemplateDetallado();
    		var productoComercialAValidar = crearAvisosModel.getCodigoProductoComercial();
    		if(crearAvisosModel.getCodigoTemplateDestaqueSeleccionado() !== null && crearAvisosModel.getCodigoProductoComercialDestaque() !== null){
    			templateDetalladoAValidar = crearAvisosModel.getCodigoTemplateDestaqueSeleccionado();
    			productoComercialAValidar = crearAvisosModel.getCodigoProductoComercialDestaque();
    		}

    		modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {"codigoTemplateDetallado":templateDetalladoAValidar, "codigoProductoComercial":productoComercialAValidar }, function (index, aviso, args){
				aviso.templateDetallado.codigo = args.codigoTemplateDetallado;
				aviso.productoComercial.codigo = args.codigoProductoComercial;});

    		blockCallerUI.blockPost({ url : CrearAvisoServiceURL.VALIDAR_PROMOCIONES,
    			dataObject :new ValidarPromocionesDTO({"promocionesAplicables":getPromocionesValidar(),"ordenPublicacion":crearAvisosModel.getOrdenDePublicacion()}),
    			successHandlerCallback : validarPromocionesHandler,
    			errorHandlerCallback : defaultErrorHandler });

    	};

    	var validarPromocionesDoOnLoad = function(){

    		modelIterator.iterateAvisosFromOrden(crearAvisosModel.getOrdenDePublicacion(), {"codigoTemplateDetallado":crearAvisosModel.getCodigoTemplateDetallado() }, function (index, aviso, args){
				aviso.templateDetallado.codigo = args.codigoTemplateDetallado;});

    		blockCallerUI.blockPost({ url : CrearAvisoServiceURL.VALIDAR_PROMOCIONES,
    			dataObject :new ValidarPromocionesDTO({"promocionesAplicables":getPromocionesValidarDoOnLoad(),"ordenPublicacion":crearAvisosModel.getOrdenDePublicacion()}),
    			successHandlerCallback : validarPromocionesHandlerDoOnLoad,
    			errorHandlerCallback : defaultErrorHandler });

    	};

    	var validarPromocionesHandler = function(data){

    		agregarPromocionesEnAvisos(data);
    		mostrarPromocionesAplicadas();
    	};

    	var validarPromocionesHandlerDoOnLoad = function(data){

    		agregarPromocionesEnAvisos(data);

    	};

    	var agregarPromocionesEnAvisos = function (data){
    		crearAvisosModel.setOrdenDePublicacion(new OrdenDePublicacionCabeceraDTO(data.ROLResult.ordenPublicacion));
    		var orden =crearAvisosModel.getOrdenDePublicacion();
			var aviso = orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
			var promociones = data.ROLResult.promocionesAplicables;
			limpiarPromocionesRepiteSalida();
			var avisoPromocionList = orden.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.avisoPromocion;
			if(promociones!=undefined){
				$.each(promociones, function(index, promocion){
					var avisoPromocion = new AvisoPromocionDTO({});
					avisoPromocion.promocion = promocion;
					avisoPromocionList.push(avisoPromocion);

				});
			}

			if (aviso.avisoPromocion && aviso.avisoPromocion.length > 0){
				modelIterator.iterateAvisosFromOrden(orden, {"avisoPromocionList":avisoPromocionList}, function(index, avisoDeOrden, args) {
					var avisoPromocionAplicables = [];
					var inserto = false;

					$.each(args.avisoPromocionList, function(indexPromociones,promoAplicable){
						$.each(avisoDeOrden.avisoPromocion, function(indexPromociones,avisoPromo){
							if (avisoPromo.promocion.codigo === promoAplicable.promocion.codigo){
								avisoPromocionAplicables.push(avisoPromo);
								inserto = true;
							};
						});
						if (!inserto){
							avisoPromocionAplicables.push(promoAplicable);
						};
						inserto = false;
					});
					avisoDeOrden.avisoPromocion = avisoPromocionAplicables;
				});
			} else {
				aviso.avisoPromocion = avisoPromocionList;
			}
    	}

    	var mostrarPromocionesAplicadas = function(){
      		var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
      		if(aviso.avisoPromocion !== undefined){
      			var promociones = [];
      			$.each(aviso.avisoPromocion, function(indexPromociones,avisoPromo){
      				promociones.push(avisoPromo.promocion);
      			})
      			crearAvisosModel.setPromociones(promociones);
      			$.each(aviso.avisoPromocion,function(indexPromociones,avisoPromo){
      				var componentePromocion 	= $('#'+avisoPromo.promocion.codigo+'-'+index);
      				if(componentePromocion!=='undefined'){
      					componentePromocion.removeClass('promoInactiva');
      					componentePromocion.addClass('promoActiva');
      					var configuracionPromocionPantalla = obtenerConfiguracionPromocion({'promocion':avisoPromo.promocion});
      					if(configuracionPromocionPantalla!==undefined){
      						var titulo					= $('#p-titulo-'+avisoPromo.promocion.codigo+"-"+index);
      						var descripcionPromocion	= $('#p-desc-'+avisoPromo.promocion.codigo+"-"+index);
      						titulo.text(configuracionPromocionPantalla.titulo);
      						descripcionPromocion.text(configuracionPromocionPantalla.descripcion);
      					}

      				}
      			});

      		}
      		else crearAvisosModel.setPromociones([]);
      	};

      	var limpiarPromocionesAplicadas = function(){
      		if(model.configuracionesPromocionPantallaVisible.length>0){

      			$.each(model.configuracionesPromocionPantallaVisible,function(indexconfiguracionPromocionPantalla,configuracionPromocionPantalla){
      				var componentePromocion 	= $('#'+configuracionPromocionPantalla.promocion.codigo+'-'+index);
      				var titulo					= $('#p-titulo-'+configuracionPromocionPantalla.promocion.codigo+"-"+index);
      				var descripcionPromocion	= $('#p-desc-'+configuracionPromocionPantalla.promocion.codigo+"-"+index);
      				if(componentePromocion!=='undefined'){
      					componentePromocion.removeClass('promoActiva');
      					componentePromocion.addClass('promoInactiva');
      					titulo.text(configuracionPromocionPantalla.titulo);
      					descripcionPromocion.text(configuracionPromocionPantalla.promocion.observacion);
      				}
      			});
	 		}
      	};

      	var obtenerConfiguracionPromocion = function(args){

      		var result;
      		$.each(model.configuracionesPromocionPantallaVisible, function(indexPromociones, configuracionPromocionPantalla){
    			if(configuracionPromocionPantalla.promocion.codigo === args.promocion.codigo){
    				// agrego en el listado de las promociones.
    				result = configuracionPromocionPantalla
    			};
    		});
      		return result;
      	};

      	var getPromocionesValidar = function(){

    		var promociones = [];
    		if(model.configuracionesPromocionPantallaVisible.length>0){
				$.each(model.configuracionesPromocionPantallaVisible, function(indexPromociones, configuracionPromocionPantalla){
	    			if(configuracionPromocionPantalla.pantallaShow === index && configuracionPromocionPantalla.trigger.length>0){
	    				// agrego en el listado de las promociones.
	    	    		promociones.push(configuracionPromocionPantalla.promocion);
	    			};
	    		});
    		}
    		return promociones;
      	};

      	var getPromocionesValidarDoOnLoad = function(){

    		var promociones = [];
    		var promociones = [];
    		var promoEncontrada = false;
    		var aviso = crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;

    		//busco las promociones que corresponden a la pantalla
    		if(model.configuracionesPromocionPantallaVisible.length>0){
				$.each(model.configuracionesPromocionPantallaVisible, function(indexPromociones, configuracionPromocionPantalla){
	    			if(configuracionPromocionPantalla.pantallaShow === index && configuracionPromocionPantalla.trigger.length>0){
	    				// agrego en el listado de las promociones.
	    	    		promociones.push(configuracionPromocionPantalla.promocion);
	    			};
	    		});
    		}
    		//si tiene promociones el aviso verifico cuales tiene
    		if(aviso.avisoPromocion.length>0){
				$.each(aviso.avisoPromocion, function(indexAvisoPromocion, avisoPromocion){
					promoEncontrada= false;
					$.each(promociones, function(indexPromocion, promocion){
						if(avisoPromocion.promocion.codigo == promocion.codigo){
							promoEncontrada = true;
						}
					});

					if(!promoEncontrada){
						promociones.push(avisoPromocion.promocion);
					}
	    		});
    		}
    		return promociones;
      	};

      	var getConfiguracionesPromocionPantallaFromOrden = function(){

      	// obtengo los datos de la configuracion de promocion pantalla.
			if (crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.fechaPedidoPublicacion !== null) {

				blockCallerUI.blockPost({
					url : CrearAvisoServiceURL.GET_CONFIGURACIONES_PROMOCION_PANTALLA,
					dataObject : new PromocionSearchDTO({
						"codigoCanalEntrada"			: crearAvisosModel.getCodigoCanalEntrada(),
						"codigoProductoComercial"		: crearAvisosModel.getCodigoProductoComercial(),
						"codigoNivelEstructura"			: crearAvisosModel.getCodigoNivelEstructura(),
						"codigoZonasComercializacion"	: obtenerCodigosZonasComercializacion(),
						"fechaVigencia"					: crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.fechaPedidoPublicacion
					}),
					successHandlerCallback : configuracionPromocionPantallaHandlerFromOrden,
					errorHandlerCallback : defaultErrorHandler
				});
			}
      	};

      	var configuracionPromocionPantallaHandlerFromOrden = function(data){

      		crearAvisosModel.setConfiguracionesPromocionPantalla(arrayUtils.buildArrayObjFromJSON(data.configuracionesPromocionPantalla,ConfiguracionPromocionPantallaDTO));
			obtenerPromociones(data);
			mostrarPromociones(data);
			mostrarPromocionesFromOrden();
			mostrarPromocionesAplicadas();

      	};

      	var mostrarPromocionesFromOrden = function(args) {
			if (model.configuracionesPromocionPantallaVisible.length > 0) {
				ui.divListaPromosPaso3.style.display = "block";
			} else {
				ui.divListaPromosPaso3.style.display = "none";
			}
		};

		var verficarExistenDatosOrden = function(){
			if(crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.fechaPedidoPublicacion === null){
				return false;
			}
			else return true;
		};

		var renderScreen = function(){

			accedida = true;
			model.modificoFechas = false;
			ui.calendar.popover("show");
			var breadcrum_text = selectionBarUtils.generarTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarZonasTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarNivelEstructuraTextoSeleccionaste(crearAvisosModel);

			ui.textoSeleccionaste[0].innerHTML = breadcrum_text;

			/* Modifico el texto del popup de "Ver Seleccion" con lo seleccionado hasta el momento */
			modifyVerSeleccionadoText(breadcrum_text);

			// obtengo los datos del calendario.
			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_SERVER_TIME,
				dataObject : null,
				successHandlerCallback : setServerTimeHandler,
				errorHandlerCallback : defaultErrorHandler
			});

			// obtengo los datos del calendario.
			blockCallerUI.blockPost({
				url : CrearAvisoServiceURL.GET_CALENDARIO,
				dataObject : getCalendarParams(),
				successHandlerCallback : setAvailablesDaysCalendarHandler,
				errorHandlerCallback : defaultErrorHandler
			});

			crearAvisosModel.setSelectedDates(ui.calendar.multiDatesPicker("getDates"));

			evaluateChange({"newData" : new GeneratedDataStep3({"fechasDePublicacion" : crearAvisosModel.getSelectedDates()})});
			ui.calendar.popover("hide");
			if($("#days-selected").html().length != 0){
				$(".tuAvisoPublicara").removeClass("hide");
			}
			doOnComplete({});
		};

		var clearScreen = function(){
			calendarConfig.addDates = null;
			ui.calendar.multiDatesPicker("resetDates", "disabled");
			ui.calendar.multiDatesPicker("resetDates");
			ui.calendar.popover("hide");
			limpiarPromociones();
			limpiarPromocionesPantalla();
			accedida = false;
		};

		var isFirstAccessOnEdit = function(args){
			return (args.event === StateEvents.PREVIOUS_FOOTER_EDIT && !accedida);
		};

		// ------------------------------------------------
		// common interface ------------------------------
		// ------------------------------------------------

		var modificada = false;

		var accedida = false;

		var index = 3;

		var doOnObserver = args.doOnObserver;

		var ui = {
			calendar					: $(".calendar"),
			contDaysSelected			: $("#days-selected"),
			contDaysSelectedConteiner 	: $(".tuAvisoPublicara"),
			fecha						: $("#diasSelectWrapper"),
			textoSeleccionaste			: $("#textoSeleccionaste"),
			divTextoSeleccionaste		: $("#divTextoSeleccionaste"),
			promociones					: $("#listaPromociones-paso3"),
			panelVerSeleccionado		: $(".panel-ver-seleccionado"),
			divListaPromosPaso3			: document.querySelector(".paso3-promociones")
		};

		var model = {
			notifyChange								: false,
			generatedData								: new GeneratedDataStep3({}),
			ordenSession								: null,
			configuracionesPromocionPantallaVisible		: [],
			modificoFechas								: false
		};

		var generateTag = function() {
			decoratorModel.setA2("cuando-se-publicara");
			var area = decoratorModel.getA1() + decoratorModel.getA2();
			gChangeTagName(area);
		};

		var mostrarBreadcrum = function(){
			if (isDesktop()){
				ui.divTextoSeleccionaste.show();
			}
		};
		var ocultarBreadcrum = function(){
			ui.divTextoSeleccionaste.hide();
		};

		/**
		 * { event : StateEvents.EVENT_CONST, }
		 */
		var agregaPaso = function(){
			$(".infoPaso").remove();
			$("#MyWizard .steps").append("<li class='infoPaso'>3/5</li>");
		}
		var doOnEnter = function(args) {

			ui.textoSeleccionaste[0].innerHTML = selectionBarUtils.generarTextoSeleccionaste(crearAvisosModel) + " > "+
			selectionBarUtils.generarZonasTextoSeleccionaste(crearAvisosModel)+ " > "+
			selectionBarUtils.generarNivelEstructuraTextoSeleccionaste(crearAvisosModel);

			showBreadcrum('CUANDO');
			showPanelSeleccionado('CUANDO');

			if (args.event === StateEvents.PREVIOUS_FOOTER_ON_LOAD || isFirstAccessOnEdit(args)) {
				doOnLoad(crearAvisosModel.getOrdenDePublicacion());
			} else {
				generateTag();
				if (!accedida || !verficarExistenDatosOrden()) {
					clearScreen();
					renderScreen();
				}
				doOnComplete({});
			}
			agregaPaso();
		};

		var doOnLoad = function(args) {
			generateTag();
			showBreadcrum('CUANDO');
			showPanelSeleccionado('CUANDO');
			model.ordenSession = args;
			renderScreen();
			agregaPaso();
		};

		/**
		 * { event : StateEvents.EVENT_CONST, }
		 */
		var doOnExit = function(args) {
			//si tiene una promo eco validada armo su estructura de conceptosVendibles (1 CV - 1 ICV - N IA - A)
			evaluateChange({"newData" : new GeneratedDataStep3({"fechasDePublicacion" : crearAvisosModel.getSelectedDates()})});
			ui.calendar.popover("hide");
		};

		var doOnError = function(args) {
			// Implements
		};

		var doOnCancel = function(args) {
			clearScreen();
			onSelectDateHandler([]);
			model.generatedData = new GeneratedDataStep3({});
			doOnComplete({});
		};

		var doOnChange = function(args) {
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
			// Evaluate Previous Action
			if (crearAvisosModel.esOrdenDePublicacionPersistida()){
				doOnObserver({"eventEnabled" : StateEvents.PREVIOUS_DISABLED});
			} else {
				doOnObserver({"eventEnabled" : StateEvents.PREVIOUS_ENABLED});
			}
		};

		var doOnExitScreen = function() {
			crearAvisosModel.setSelectedDates(ui.calendar.multiDatesPicker("getDates"));
			evaluateChange({"newData" : new GeneratedDataStep3({"fechasDePublicacion" : crearAvisosModel.getSelectedDates()})
			});
		};

		var bind = function(args) {
			calendarConfig.onSelect = onSelectDateHandler;
			ui.calendar.multiDatesPicker(calendarConfig);
			// show popover message.
			ui.calendar.popover(calendarPopoverConfig);
		};

		var unbind = function(args) {
			calendarConfig.onSelect = null;
			ui.calendar.multiDatesPicker(calendarConfig);
		};

		var isComplete = function(args) {
			return (ui.calendar.multiDatesPicker("getDates").length > 0) ? true : false;
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