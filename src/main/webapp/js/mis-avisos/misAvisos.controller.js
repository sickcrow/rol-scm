/**
 * author: mdenicolo
 * version: 1.0.0
 * description: Clase que vincula la UI con la logica en la pantalla de mis avisos.
 */

//-----------------------------------------------------------------------------
//misAvisosController -------------------------------------------------------
//-----------------------------------------------------------------------------

var misAvisosController = (function () {

	//------------------------------------------------
	// global interface ------------------------------
	//------------------------------------------------

	gOnClick_tarjeta = function(codigoTarjetaGateway){


		if(Detectizr.device.browser === "ie" && Detectizr.device.browserVersion === "8"){

			$(".css-label-radio").click(function () {
				$(".css-label-radio").css({
					"backgroundPositionY":"-5px"
				});
				$(this).css({
					"backgroundPositionY":"-87px"
				});
		    });
	    }
		model.codigoGATEWAYSeleccionado = codigoTarjetaGateway;
		doOnComplete();

	};

	gOnclickRedirectDatosPersonalesHanlder = function(url){
		blockCallerUI.blockPost({
			url : MisAvisosServiceURL.GET_SESSION_STATUS,
			dataObject : {},
			successHandlerCallback : redirectDatosPersonalesHandler,
			errorHandlerCallback : defaultErrorHandler
		});
	};

	gOnclickPagar = function(component){
		decoratorModel.setA2("pago");
		var area = decoratorModel.getA1()+decoratorModel.getA2();
        gChangeTagName(area);
		misAvisosModel.ordenSeleccionada.codigoTipoTarjeta=model.codigoGATEWAYSeleccionado;
		ui.popup=window.open();

		if (ui.popup == null || typeof(ui.popup)=='undefined') {
		    alert('Por favor deshabilita el bloqueador de ventanas emergentes y vuelve a intentarlo.');
		} else {
			ui.popup.document.write('<h1 style="margin:20% 0 0 ; text-align:center; width:100%">Espera unos instantes.<br> Estamos preparando la informaci&oacute;n para pagar</h1><p style="text-align:center; width:100%"><img src="../img/ajax-loader.gif" alt="cargando"  ></p> ');
			blockCallerUI.blockPost({ url : MisAvisosServiceURL.EXECUTE_PAGAR_AND_ACTUALIZAR,
				dataObject : new OrdenDePublicacionCabeceraDTO(misAvisosModel.ordenSeleccionada),
				successHandlerCallback : pagarYActualizarOrdenDePublicacionHandler,
				errorHandlerCallback : defaultErrorHandler });
		}
	};

	g_muestraVentanaPrint = function(component){
		// FORMATO A NUMEROS
		function formatNumero(numero, decimales, separadorDecimal, separadorMiles){
			numero=parseFloat(numero);
			if(isNaN(numero)){return "";}
			if(decimales!==undefined){numero=numero.toFixed(decimales);}
			numero=numero.toString().replace(".", separadorDecimal!==undefined ? separadorDecimal : ",");
			if(separadorMiles){var miles=new RegExp("(-?[0-9]+)([0-9]{3})");while(miles.test(numero)) {numero=numero.replace(miles, "$1" + separadorMiles + "$2");}}
			return numero;
		}

		$("#popUpPrint").remove();
		initPopUpPrint();
		var idAviso = parseInt($(component).parents(".singleItemAvisos").attr("id"), "");
		var codigoAviso = $("#"+idAviso+" .codigoPublicacion").text();
		var ordenPublicacion = obtenerOrden(parseInt(codigoAviso, ""));
		var aviso = ordenPublicacion.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;

		//------- ESTO ES NECESARIO PARA TENER TODA LA INFORMACION DE LOS ORDENAMIENTOS -------
		//se tuvo que hacer la llamada para tener la informacion y no solo su valor
			var ordenamientosConfiguracion = null;

			blockCallerUI.blockPost({
				url : MisAvisosServiceURL.GET_CONFIGURACIONES_ORDENAMIENTO_PANTALLA,
				dataObject : buildOrdenamientoAvisoSearchDTO(aviso),
				successHandlerCallback : setConfiguracionesOrdenamientoHandler,
				errorHandlerCallback : defaultErrorHandler
			});

			//declaro la funcion que construye el dto
			function buildOrdenamientoAvisoSearchDTO(aviso) {

				return new OrdenamientoAvisoSearchDTO({
					codigoCanalEntrada					: "ROL",
					codigoNivelEstructura				: aviso.nivelEstructura.codigo,
					codigoAgrupamientoProductoTecnico	: aviso.tipo,
					codigoTipoOperacion					: aviso.tipoOperacion.codigo,
					fechaVigencia						: null
				});

			};

			//declaro la funcion que construye el handler de la funcion
			function setConfiguracionesOrdenamientoHandler(data){
				var ordenamientosPantalla = (arrayUtils.buildArrayObjFromJSON(
					data.configuracionesOrdenamientoPantalla,
					ConfiguracionOrdenamientoPantallaDTO));

				var aux1 = [];
				var aux2 = [];

				if(ordenamientosPantalla[0] !== undefined){
					aux1 = ordenamientosPantalla[0].ordenamientosAviso;
				}
				if(ordenamientosPantalla[1] !== undefined){
					aux2 = ordenamientosPantalla[1].ordenamientosAviso;
				}

				ordenamientosConfiguracion = aux1.concat(aux2);
			};
		//-------

		//datos que se envian al context
		var fechaDeImpresion = new Date().getTime();
		var fechaCaptura = ordenPublicacion.fechaAlta;
		var usuarioAvisoNombre = decoratorModel.getUsuario().nombre;
		var usuarioAvisoApellido = decoratorModel.getUsuario().apellido;
		var usuarioAvisoEmailContacto =	ordenPublicacion.email;
		var usuarioAvisoTelefonoContacto = ordenPublicacion.telefono;
		var medioPago = capitalize(ordenPublicacion.codigoMedioDePago);
		var producto = aviso.productoComercial.producto.descripcion;
		var medioRubro = aviso.nivelEstructura.descripcion;
		var tipoOperacion = aviso.tipoOperacion.descripcion;
		var lineasAviso = aviso.lineasPublicadas;
		var ordenamientos = generarListadoOrdenamientos(aviso.ordenamientos, ordenamientosConfiguracion);
		var tieneOrdenamientos = ordenamientos.length>0;	//abajo pq depende de ordenamientos
		var conceptosWrapper = crearWrapperConceptos(ordenPublicacion,model.mapEstados);
		var fechaPago = ordenPublicacion.fechaAlta;
		var mensajePago;

		//carga de datos si ya pago
		if (ordenPublicacion.transaccionActual){
			fechaPago = ordenPublicacion.transaccionActual.fechaTransaccion;
		}
		if (ordenPublicacion.transaccionActual && ordenPublicacion.transaccionActual.estado === "ACREDITADO"){
			mensajePago = fechaPago;
		}

		var tienePromociones = conceptosWrapper[0].wrapperPromociones.length > 0;
		var muestraDetallePromocion = conceptosWrapper[0].muestraDetallePromocion;

		//aca arranca para calcular los montos
		var montoTotalFinalSinPromo = 0;
		$.each(conceptosWrapper, function(index, concepto){
			montoTotalFinalSinPromo = parseFloat(montoTotalFinalSinPromo) + parseFloat(concepto.totalAviso);
		});

		var montoTotalFinal = 0;
		var promocionesDescuentos = [];
		if(tienePromociones){

			if(muestraDetallePromocion){
				$.each(conceptosWrapper, function(index, concepto){
					$.each(concepto.wrapperPromociones, function(index, promocion){
						var descuento = getDescuentoFromListByDesc(promocionesDescuentos, promocion.promocionDescripcion);
						if( descuento === null){
							descuento = { "promocionDescripcion" : promocion.promocionDescripcion, "promocionDescuento" : promocion.promocionDescuento};
							promocionesDescuentos.push(descuento);
						}else{
							descuento.promocionDescuento = parseFloat(descuento.promocionDescuento) + parseFloat(promocion.promocionDescuento);
						}
					});
				});

				montoTotalFinal = parseFloat(montoTotalFinalSinPromo) + parseFloat(sumarizarDescuentos(promocionesDescuentos));
			}else{
				var descuento = {"promocionDescripcion" : "Descuentos", "promocionDescuento" : 0};
				$.each(conceptosWrapper, function(index, concepto){
					descuento.promocionDescuento = parseFloat(descuento.promocionDescuento) + parseFloat(concepto.descuentos);
				});
				promocionesDescuentos.push(descuento);

				montoTotalFinal = parseFloat(montoTotalFinalSinPromo) + parseFloat(descuento.promocionDescuento);
			}

		}else{
			montoTotalFinal = montoTotalFinalSinPromo;
		}
		//-----

		var imgAviso = aviso.preview.contenido;

		//formateo post operaciones para que no moleste
		montoTotalFinalSinPromo = formatNumero(montoTotalFinalSinPromo, 2, ".", ",");
		montoTotalFinal = formatNumero(montoTotalFinal, 2, ".", ",");


		// ENCUENTRO EL DESCUENTO BUSCADO
		function getDescuentoFromListByDesc(promocionesDescuentos, descripcion){
			for(var i=0; i<promocionesDescuentos.length; i++){
				if(promocionesDescuentos[i].promocionDescripcion == descripcion){
					return promocionesDescuentos[i];
				}
			}
			return null;
		}

		// SUMA LOS VALORES DE DESCUENTO DE LA LISTA
		function sumarizarDescuentos(promocionesDescuentos){
			var totalDescuentos = 0;
			for(var i=0; i<promocionesDescuentos.length; i++){
				totalDescuentos = parseFloat(totalDescuentos) + parseFloat(promocionesDescuentos[i].promocionDescuento);
			}
			return totalDescuentos;
		}

		var posAviso = $("#"+idAviso).offset();
		posAviso = parseInt(posAviso.top, "");
		//window.scrollTo(200,200);
		$("html, body").animate({
			"scrollTop": posAviso
		});

		var template = Handlebars.compile(MisAvisosTemplates.renderOrdenPublicacionImprimir);
		var context  = {
				fechaCaptura					: fechaCaptura,
				fechaDeImpresion				: fechaDeImpresion,
				codigoAviso						: codigoAviso,
				usuarioAvisoNombre				: usuarioAvisoNombre,
				usuarioAvisoApellido			: usuarioAvisoApellido,
				usuarioAvisoEmailContacto		: usuarioAvisoEmailContacto,
				usuarioAvisoTelefonoContacto	: usuarioAvisoTelefonoContacto,
				medioPago						: medioPago,
				producto						: producto,
				medioRubro						: medioRubro,
				aviso							: aviso,
				tipoOperacion					: tipoOperacion,
				lineasAviso						: lineasAviso,
				tieneOrdenamientos				: tieneOrdenamientos,
				ordenamientos					: ordenamientos,
				conceptosWrapper				: conceptosWrapper,
				mensajePago						: mensajePago,
				fechaPago						: fechaPago,
				tienePromociones				: tienePromociones,
				muestraDetallePromocion			: muestraDetallePromocion,
				montoTotalFinalSinPromo			: montoTotalFinalSinPromo,
				promocionesDescuentos			: promocionesDescuentos,
				montoTotalFinal					: montoTotalFinal,
				imgAviso						: imgAviso

			};
		var html     = template(context);

		$("#popUpPrint .modal-body").append(html);



		var itemAviso = $("#"+idAviso);

		if(itemAviso.hasClass("ordenSinPromo")){
			$("#popUpPrint").addClass("printSinPromo");
		}
		if(itemAviso.hasClass("ordenConPromo")){
			$("#popUpPrint").addClass("printConPromo");
		}
		if(itemAviso.hasClass("ordenConPromoGratis")){
			$("#popUpPrint").addClass("printordenConPromoGratis");
		}

		$(".printSinPromo li.precioDesglose").css("visibility","hidden");
		$(".printordenConPromoGratis p.pagadoEl, .printordenConPromoGratis .itemFechaPublicado li strong").css("visibility","hidden");

		$("#"+idAviso).addClass("destacado");

		$("#logo").toggle();
		$("#popUpPrint .modal-header").append("<div id='logo-print' style='display:none'><img src='../img/logo-desktop.png'></div>");

		$("#logo-print").toggle();
		$("html, body").animate({
			"scrollTop": 0
		},0);
		$("#popUpPrint").css({
			overflow		: "initial",
			position		: "absolute",
			top				: "10px"
		});

		$("#popUpPrint").modal("show");
		setTimeout(function(){
			window.print();
		},1500);
		$("html").on("keydown", function(e){
			if (e.keyCode === 9){
				e.preventDefault();
			}
		});

		$("#popUpPrint").on("hidden", function () {
			$("#logo").toggle();

			$("#logo-print").toggle();
			setTimeout(function(){
				$("#"+idAviso).removeClass("destacado");
			},3000);
			$("html").off("keydown");
			var posAviso = $("#"+idAviso).offset();
			posAviso = parseInt(posAviso.top, "");
			//window.scrollTo(200,200);
			$("html, body").animate({
				"scrollTop": posAviso
			});
        });

	};

	g_muestraVentanaPagar = function(component){

		if( $.cookie("usuario") !== null){
			$("#popUpPagar").remove();
			initPopUpPagar();
			misAvisosModel.ordenSeleccionada = obtenerOrden($(component).data("idorden"));
			var template = Handlebars.compile(DecoratorTemplates.selectorTarjetas);
			var context  = {tarjetasPago : model.tarjetas};
			var html     = template(context);

			var idAviso = parseInt($(component).parents(".singleItemAvisos").attr("id"),"");

			//PRECIO
			var precioAvisoJSON = {precioAviso : 0};
			modelIterator.iterateConceptosVendiblesFromOrden(misAvisosModel.ordenSeleccionada, precioAvisoJSON, function(index, concepto, precioAvisoJSON){
				precioAvisoJSON.precioAviso = precioAvisoJSON.precioAviso + concepto.montoTotal;
			});
			var precioAviso = precioAvisoJSON.precioAviso;



			$('html, body').stop().animate({
		        'scrollTop': $("#"+idAviso).offset().top
		    }, 900, 'swing', function () {
		        window.location.hash = idAviso;
		    });
			$("#popUpPagar .modal-body").prepend("<p class='precioAviso'>Precio: <strong>$"+precioAviso+"</strong> <span class='ivaIncluido'>I.V.A. Incluido</span></p><div class='lTarjetas'></div>");
			$("#popUpPagar .btn").hide();
			$("#popUpPagar .modal-body .lTarjetas").append(html);
			$("#popUpPagar .modal-footer").append("<div class='genericBtn btnPagar' id='btnPagarPopUp'><a href='#' onclick='gOnclickPagar(this)' title='Pagar'><span>Pagar</span></a></div>");
			$("#popUpPagar").modal({
				backdrop: "static",
				show: true
			});
			$('html').on('keydown', function(e){
				if (e.keyCode == 9){
					e.preventDefault();
				}
			});
			$('input').customInput();
			$("#"+idAviso).addClass("destacado");
			$('#popUpPagar label').click(function(){
				var inputSeleccionado = $(this).siblings("input");
				inputSeleccionado.prop('checked', true);
				if(inputSeleccionado.prop('checked')){
					$('#popUpPagar input').siblings("label").removeClass("checked");
					inputSeleccionado.siblings("label").addClass("checked");
					var codigoTarjetaGateway = inputSeleccionado.attr('id');
					gOnClick_tarjeta(codigoTarjetaGateway);
				}else{
					$('#popUpPagar input').siblings("label").removeClass("checked");
				}
			});

			$('#popUpPagar').on('hidden', function () {
			setTimeout(function(){
				$("#"+idAviso).removeClass("destacado");
			},3000);
			$('html').off('keydown');
	        });
		}else{
			gOnExpireSessionHandler();
		}

		doOnComplete();
	};

	gOnclickEliminaFiltros = function(){
		$("#listAvisosWrapper .msjeNoHayAvisosConFiltro").remove();
		$("#filtroCategoria option[value=todos-categoria]").prop('selected', 'selected');
		$("#filtroEstado option[value=todos-estado]").prop('selected', 'selected');
		$("#filtroCategoria").select2();
		$("#filtroEstado").select2();
		aplicaFiltro();

	};

	// ------------------------------------------------
	// private interface -----------------------------
	// ------------------------------------------------

	// inicio metodos correspondientes al detener/reanudar.

	var muestraAvisoDetener = function(component){
		$('#popUpConfirmarDetener').modal({
			backdrop: "static",
			show: true
		});

		var idAviso = $(component).attr("data-idAviso");
		$("#popUpConfirmarDetener").attr("data-idAviso",idAviso);

		$("#popUpConfirmarDetener .modal-body").html("<p>¿Quer&eacute;s detener la publicaci&oacute;n?</p>" +
		"<p>**Al detener la publicaci&oacute;n evit&aacute;s que se publique el aviso pero no implica devoluci&oacute;n del dinero.**</p>");

	};

	var onClickCancelarDetenerPublicacion = function(component){
		$("#popUpConfirmarDetener").modal("hide");
	};

	var onClickAceptarDetenerPublicacion = function(component){

		$("#popUpConfirmarDetener").modal("hide");
		var idAviso = $('#popUpConfirmarDetener').attr("data-idAviso");
		blockCallerUI.blockPost({ url : MisAvisosServiceURL.SUSPENDER_PUBLICACION_AVISO,
			dataObject : new UpdateEstadoAvisoDTO({"idAviso":idAviso, "accion": AccionAviso.SUSPENDER}),
			successHandlerCallback : suspenderPublicacionAvisoHandler,
			errorHandlerCallback : defaultErrorHandler });
	};

	var muestraAvisoReanudar = function(component){
		$("#popUpConfirmarReanudar").modal({
			backdrop: "static",
			show: true
		});

		var idAviso = $(component).attr("data-idAviso");
		$("#popUpConfirmarReanudar").attr("data-idAviso",idAviso);

		$("#popUpConfirmarReanudar .modal-body").html("<p>¿Est&aacute;s seguro que quer&eacute;s reanudar la publicaci&oacute;n del aviso?</p>");

	};

	var onClickCancelarReanudarPublicacion = function(component){
		$("#popUpConfirmarReanudar").modal("hide");
	};

	var buildEditarOrdenDTO = function (args){
		return new EditarOrdenDTO({
			"idOrden" : args.idOrden
		});
	};

	var onClickAceptarReanudarPublicacion = function(component){
		$("#popUpConfirmarReanudar").modal("hide");
		var idAviso = $("#popUpConfirmarReanudar").attr("data-idAviso");
		blockCallerUI.blockPost({ url : MisAvisosServiceURL.REANUDAR_PUBLICACION_AVISO,
			dataObject : new UpdateEstadoAvisoDTO({"idAviso":idAviso, "accion": AccionAviso.REACTIVAR_AVISO}),
			successHandlerCallback : reanudarPublicacionAvisoHandler,
			errorHandlerCallback : defaultErrorHandler });
	};

	//Republicacion
	gOnClickRepublicar = function(component){
		var idAviso = $(component).attr("data-idAviso");
		var idOrden = $(component).attr("data-idOrden");
		blockCallerUI.blockPost({ url : MisAvisosServiceURL.REPUBLICAR_AVISO,
			dataObject : idOrden,
			successHandlerCallback : redirectHandler,
			errorHandlerCallback : defaultErrorHandler });
	}

	// Edicion
	gOnClickEditar = function (component){
		var idOrden = $(component).attr("data-idOrden");
		blockCallerUI.blockPost({ url : MisAvisosServiceURL.EDITAR_ORDEN_DE_PUBLICACION,
			dataObject : buildEditarOrdenDTO({ "idOrden" : idOrden }),
			successHandlerCallback : redirectHandler,
			errorHandlerCallback : defaultErrorHandler });
	}

	var obtenerDescripcionPromocionesAplicadas = function(ordenPublicacion){
		var detallePromociones = { "promociones" : [] };
		modelIterator.iterateAvisosFromOrden(ordenPublicacion, { "detallePromociones" : detallePromociones }, function(index, aviso, args){
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
		});
		return detallePromociones.promociones;
	};

	var generarListadoOrdenamientos = function(ordenamientosAviso, ordenamientosConfiguracion) {
		var listado = "";

		$.each($.makeArray($(ordenamientosAviso)), function(index, ordenamiento){
			//para cada ordenamiento, lo busco en las configuraciones para saber si es oculto o no.
			var ordenamientoBuscado = null;
			$.each($.makeArray($(ordenamientosConfiguracion)), function(index, ordenamientoConfiguracion){
				if(ordenamiento.codigo === ordenamientoConfiguracion.codigo){
					ordenamientoBuscado = ordenamientoConfiguracion;
				}
			});
			//si es oculto entonces no lo agrego
			if(ordenamientoBuscado === null){
				return false;
			}
			if(ordenamientoBuscado.ocultarValorUnico === false){
				if(listado.length === 0){
					listado = ordenamiento.valor;
				} else {
					listado = listado + " | " + ordenamiento.valor;
				}
			}
		});
		return listado;
	};

	var capitalize = function(arg){
		arg = arg.toLowerCase();
		return arg.charAt(0).toUpperCase() + arg.slice(1);
	};

	var errorHandler = function(jqXHR, textStatus, errorThrown){
		$("#popUpError").modal({
			backdrop: "static",
			show: true
		});
		$("#popUpError .modal-body p").text("N\xfamero de error: "+jqXHR.status+" "+jqXHR.responseText+".");
	};

	var obtenerTarjetasDisponibles = function (){

		blockCallerUI.blockPost({ url : MisAvisosServiceURL.GET_TARJETAS_PAGO,
			dataObject : new TarjetaPagoSearchDTO(decoratorModel.getCodigoCanalEntrada()),
			successHandlerCallback : obtenerTarjetasDisponiblesHandler,
			errorHandlerCallback : errorHandler });

	};

	var pagarYActualizarOrdenDePublicacionHandler = function(data){

		var result = data.ROLResult;
		if(result.errors.length>0){
    		if (result.errors[0].errorType == ROLErrorTypeConstants.VALIDATION) {
				$('#popUpAlerta').modal({
					backdrop: "static",
					show: true
				});
				$("#popUpAlerta .modal-body p").text("La fecha en que publica este aviso fue cerrada, ya no es posible publicar el aviso.");
    		} else {
        		$('#popUpError').modal('show');
        		$("#popUpError .modal-body p").text("Su pago no pudo ser procesado. Por favor intente mas tarde");
    		}
		} else {
			if(Detectizr.device.browser === "ie" && Detectizr.device.browserVersion == "8"){
				ui.popup.document.write(result.object);
				ui.popup.location.reload();
			} else {
				/*if(Detectizr.device.browser != "ie" && Detectizr.device.browser != ""){
					ui.popup.focus = function(){
						windowFocus=true;
					};
				}*/
				ui.popup.document.write(result.object);
				var evt = ui.popup.document.createEvent('Event');
				evt.initEvent('load', false, false);
				ui.popup.window.dispatchEvent(evt);
				redirect(URLConstants.ROL_MIS_AVISOS);
			}
		}
	};

	var obtenerOrden = function (idOrden){
		var ordenResult = null;
		$.each($.makeArray($(misAvisosModel.getListaOrdenesDePublicacion())), function(index, orden){
			if(orden.id === idOrden){
				ordenResult = orden;
			}
		});
		return ordenResult;
	};

	var obtenerTarjetasDisponiblesHandler = function(args){
		model.tarjetas  = args.tarjetas;
	};

	var fechaHoy = function(){
		var f = new Date();
		return formatear(f);
	};

	var formatear = function(fecha){
		var mes = fecha.getMonth() + 1;
		var diaMesAnio = fecha.getDate() + "/" + mes + "/" + fecha.getFullYear();
		var minutos = estandarizar2Digitos(fecha.getMinutes().toString());
		var segundos = estandarizar2Digitos(fecha.getSeconds().toString());
		var hora = fecha.getHours()+":"+minutos+":"+segundos;
		var fechaYhora = diaMesAnio+" "+hora;
		return fechaYhora;
	};

	var estandarizar2Digitos = function(valor){
		if (valor.length === 1){
			valor = "0"+valor;
		}
		return valor;
	};
    var nAltoDiv;
	var tomarAlto = function(){

		var headerPos = $("header").position();
		var footerPos = $("footer").position();
		var altoDiv = parseInt(footerPos.top, "");
		setTimeout(function(){
			var hayMensajes = function(){
				$(".alert").each(function() {
					if ($(this).is(":visible")){
						$(this).addClass("alertVisible");
					}else{
						$(this).addClass("alertOculto");
					}
				});
			}();

			if($(".alert").hasClass("alertVisible") ) {
				nAltoDiv = altoDiv - 310;
			}else{
				nAltoDiv = altoDiv - 210;
			}

			$("#listAvisosWrapper").css({
				"height" : 'auto'
			});
		},100);


	};

	var habilitarFuncionPagar = function(transaccionActual, aviso){
		if(aviso.estado === EstadoAviso.PENDIENTE_PAGO){
			if(transaccionActual.estado !== EstadoGWPTransaccion.PENDIENTE_CONFIRMACION &&
					transaccionActual.estado !== EstadoGWPTransaccion.ERROR){
				return true;
			}
		}
		return false;
	};

	var renderHandlebars = function (source, context, uiComponent){
		Handlebars.registerHelper("fechaPublicacion", MisAvisosHelpers.fechaPublicacion);
		Handlebars.registerHelper("fechaPublicacionDiaSemana", MisAvisosHelpers.fechaPublicacionDiaSemana);
		Handlebars.registerHelper("zonasComercializacion", MisAvisosHelpers.zonasComercializacion);
		Handlebars.registerHelper("traduccionEstado", MisAvisosHelpers.traduccionEstado);
		Handlebars.registerHelper("traduccionPopOver", MisAvisosHelpers.traduccionPopOver);
		Handlebars.registerHelper("ifHabilitarRepublicarAviso", MisAvisosHelpers.ifHabilitarRepublicarAviso);
		Handlebars.registerHelper("ifHabilitarBotonEditar", MisAvisosHelpers.ifHabilitarBotonEditar);

		Handlebars.registerHelper('format', function (value) {
			function formatNumero(numero, decimales, separador_decimal, separador_miles){
			    numero=parseFloat(numero);
			    if(isNaN(numero)){return "";}
			    if(decimales!==undefined){numero=numero.toFixed(decimales);}
			    numero=numero.toString().replace(".", separador_decimal!==undefined ? separador_decimal : ",");
			    if(separador_miles){var miles=new RegExp("(-?[0-9]+)([0-9]{3})");while(miles.test(numero)) {numero=numero.replace(miles, "$1" + separador_miles + "$2");}}
			    return numero;
			}
			return formatNumero(value, 2, ".", ".");
		});

		var template = Handlebars.compile(source);
		var html     = template(context);

		uiComponent.append(html);

		if(Detectizr.device.type === "desktop"){
			$(".bloqueImprimir").show();
		};
	};

	var mostrarDivsListaVacia = function(){
		ui.divListaVaciaMensaje[0].style.display = "block";
		ui.divListaVacia[0].style.display = "block";
	};

	var buildFamiliasByFilterSearchDTO = function(){
		return new FamiliasByFilterSearchDTO({
			codigosClase				: null,
			codigoCanalEntrada			: decoratorModel.getCodigoCanalEntrada()
		});
	};

	var cargarFamilias = function(){
		blockCallerUI.blockPost({ url : MisAvisosServiceURL.GET_FAMILIAS_BY_FILTER,
			dataObject : buildFamiliasByFilterSearchDTO(),
			successHandlerCallback : listarFamiliasHandler,
			errorHandlerCallback : defaultErrorHandler });
	};


	var mostrarFiltros = function(){
		$("#filtroFullWrapper").css("visibility","visible");
		$("#filtroCategoriasMisAvisos").css("visibility","visible");
		$("#filtroEstadosMisAvisos").css("visibility","visible");
		cargarFamilias();
		listarEstados();
		$(document).on("change", "#filtroCategoria, #filtroEstado", function(){
			var codigoSeleccionado = $(this).val();
			aplicaFiltro(codigoSeleccionado);
			$("#listAvisosWrapper").animate({ scrollTop: 0 }, 900);
		});
		/* INICIA EL COMPONENTE DE SELECT */
		$("#filtroCategoria").select2();


        $("#listAvisosWrapper").css({
            "height" : nAltoDiv
        });
	};

	var listarFamiliasHandler = function(data){
		var listaFamilias = data.ROLResult.object;

		//VACIO EL HTML DEL COMBOBOX POR SI CONTENIA ALGUN ELEMENTO HTML
		$("#filtroCategoria").empty();

		//AÑADO LA OPCION DE TODOS
		$("#filtroCategoria").append("<option value='todos-categoria' selected='selected'>Todos</option>");

		//ARMO EL COMBOBOX CON LAS FAMILIAS Y ASIGNO COMO VALOR LOS BIENES
		$.each(listaFamilias, function(index, object){
			var listaBienes = [];
			$.each(object.clases, function(index, bien){
				listaBienes.push(bien.codigo.replace(",",""));
			});
			$("#filtroCategoria").append("<option value='"+ listaBienes +"'>"+ object.clase.descripcion +"</option>");
		});
	};

	var listarEstados = function(){
		//VACIO EL HTML DEL COMBOBOX POR SI CONTENIA ALGUN ELEMENTO HTML
		$("#filtroEstado").empty();
		//AÑADO LA OPCION DE TODOS
		$("#filtroEstado").append("<option value='todos-estado' selected='selected'>Todos</option>");
		//RECORRO LOS AVISOS EN BUSCA DE LOS ESTADOS
		$(".singleItemAvisos").each(function() {
			var elemento = $(this);
			//var estadosAvisos = {};
			$(".itemLineasPublicado").each(function(){
				var elementoEstado = $(this);
				// ELIMINO LOS PARENTESIS DE LOS ESTADOS
				var elementoEstadoTxt = elementoEstado.find(".txtEstado").text().replace("(","").replace(")","");
				$("#filtroEstado").append("<option value='"+elementoEstadoTxt+"'>"+elementoEstadoTxt+"</option>");
			});

		});
		//ELIMINO LOS ESTADOS DUPLICADOS
		var estadosDuplicados = {};
		$("#filtroEstado option").each(function() {
			var txt = $(this).text();
			if (estadosDuplicados[txt]){
				$(this).remove();
			} else {
				estadosDuplicados[txt] = true;
			}
		});
		$("#filtroEstado").select2();
	};

	// APLICA EL FILTRO
	var aplicaFiltro = function(codigoSeleccionado){

		//COMPRUEBA SI SE HA SELECCIONADO EL FILTRO CATEGORIA
		var estadoFiltroCategoriaFn = function(){
			var valorFiltroCategoria = $("#filtroCategoria").val();

			if(valorFiltroCategoria !== "todos-categoria"){
				estadoFiltroCategoria = true;
			}else{
				estadoFiltroCategoria = false;
			}

		}();

		//COMPRUEBA SI SE HA SELECCIONADO EL FILTRO ESTADO
		var estadoFiltroEstadoFn = function(){
			var valorFiltroEstado = $("#filtroEstado").val();

			if(valorFiltroEstado !== "todos-estado"){
				estadoFiltroEstado = true;
			}else{
				estadoFiltroEstado = false;
			}

		}();

		//OCULTO LOS AVISOS SEGUN SE SELECCIONE LOS FILTROS
		if(estadoFiltroCategoria && estadoFiltroEstado){

			$(".singleItemAvisos").each(function() {

				var elemento = $(this);

				//ELIMINA LOS ATRIBUTOS ANTERIORES
				elemento
					.removeClass("avisoFiltrado")
					.show();

				//OBTENGO EL VALOR DE LA CATEGORIA SELECCIONADA
				var valorFiltroCategoria = $("#filtroCategoria").val().split(",");

				//RECORRO LOS BIENES DEL AVISO Y SI ALGUNO COINCIDE LE ASIGNO TRUE A estadoDosFiltrosCat
				var eachCategoria = function(){

					$.each(valorFiltroCategoria, function(index, valor){
						var codigoBien = elemento.attr("data-codigoclase");
						if(valor === codigoBien){
							estadoDosFiltrosCat = true;
							return false;
						}else{
							estadoDosFiltrosCat = false;
						}

					});

				}();

				//RECORRO LOS DISTINTOS ESTADOS DEL AVISO
				var estadosDelAviso = [];
				$(".itemLineasPublicado", this).each(function() {
					var elementoEstado = $(this);
					var elementoEstadoTxt = elementoEstado.find(".txtEstado").text().replace("(","").replace(")","");
					estadosDelAviso.push(elementoEstadoTxt);
				});

				//OBTENGO EL ESTADO SELECCIONADO
				var valorFiltroEstado = $("#filtroEstado").val();

				//RECORRO LOS ESTADOS DEL AVISOS Y SI ALGUNO COINCIDE LE ASIGNO TRUE A estadoDosFiltrosEst
				var eachEstado = function(){

					$.each(estadosDelAviso, function(index, estado){

						if(valorFiltroEstado === estado){
							estadoDosFiltrosEst = true;
							return false;
						}else{
							estadoDosFiltrosEst = false;
						}

					});
				}();

				//SI LOS DOS ESTAN EN TRUE APLICO LA CLASE avisoFiltrado
				if(estadoDosFiltrosCat && estadoDosFiltrosEst){
					$(this).addClass("avisoFiltrado");
				}

				//OCULTO LOS AVISOS QUE NO TENGAN LA CLASE avisoFiltrado
				$(".singleItemAvisos:not(.avisoFiltrado)").hide();

			});

			//COMPRUEBA LA CANTIDAD DE AVISOS FILTRADOS Y SI NO HAY AVISOS MUESTRA UN MENSAJE
			compruebaCantAvisos();

		}else if(estadoFiltroCategoria && !estadoFiltroEstado){
			//FILTRO POR CATEGORIA
			$(".singleItemAvisos").each(function() {

				var elemento = $(this);

				//ELIMINA LOS ATRIBUTOS ANTERIORES
				elemento
					.removeClass("avisoFiltrado")
					.show();

				var valorFiltroCategoria = $("#filtroCategoria").val().split(",");
				var codigoBien = elemento.attr("data-codigoclase").replace(",","");

				$.each(valorFiltroCategoria, function(index, valor){
					if(valor === codigoBien){
						elemento.addClass("avisoFiltrado");
					}

				});

				$(".singleItemAvisos:not(.avisoFiltrado)").hide();

			});

			//COMPRUEBA LA CANTIDAD DE AVISOS FILTRADOS Y SI NO HAY AVISOS MUESTRA UN MENSAJE
			compruebaCantAvisos();

		}else if(!estadoFiltroCategoria && estadoFiltroEstado){
			//FILTRO POR ESTADO
			$(".singleItemAvisos").each(function() {
				var elemento = $(this);

				//ELIMINA LOS ATRIBUTOS ANTERIORES
				elemento
					.removeClass("avisoFiltrado")
					.show();

				var valorFiltroEstado = $("#filtroEstado").val();

				var estadosDelAviso = [];
				$(".itemLineasPublicado", this).each(function() {
					var elementoEstado = $(this);
					var elementoEstadoTxt = elementoEstado.find(".txtEstado").text().replace("(","").replace(")","");
					estadosDelAviso.push(elementoEstadoTxt);

				});

				$.each(estadosDelAviso, function(index, estado){
					var valorFiltroEstado = $("#filtroEstado").val();
					if(valorFiltroEstado === estado){
						elemento.addClass("avisoFiltrado");
					}
				});
				$(".singleItemAvisos:not(.avisoFiltrado)").hide();
			});

			//COMPRUEBA LA CANTIDAD DE AVISOS FILTRADOS Y SI NO HAY AVISOS MUESTRA UN MENSAJE
			compruebaCantAvisos();

		}else{
			//ELIMINA LOS ATRIBUTOS ANTERIORES

			$(".singleItemAvisos").removeClass("avisoFiltrado").show();

		}

	};

	var compruebaCantAvisos = function(){
		var nroAvisosConFiltro = $(".singleItemAvisos.avisoFiltrado").length;
		$("#listAvisosWrapper .msjeNoHayAvisosConFiltro").remove();
		if(nroAvisosConFiltro === 0){
			$("#listAvisosWrapper").append("<div class='msjeNoHayAvisosConFiltro'><h4>No se han encontrado avisos. <a href='#' onclick='gOnclickEliminaFiltros();'>Limpiar filtros</a></h4></div>");
		}
	};

	var isOrdenFacturada = function (ordenPublicacion){

		var result = true;
		// Compruebo si toda la orden esta en estado cancelado
		modelIterator.iterateConceptosVendiblesFromOrden(ordenPublicacion, null, function (indexCV, conceptoVendibleIterado, argsCV){
			if (conceptoVendibleIterado.estado == EstadoConcepto.ANULADO){
				modelIterator.iterateItemsConceptoVendible(conceptoVendibleIterado.itemsConceptoVendible, null, function (indexICV, itemConceptoVendibleIterado, argsITCV){
					modelIterator.iterateItemsAviso(itemConceptoVendibleIterado.itemsAviso, null, function (indexIA, itemAvisoIterado, argsIA){
						if (itemAvisoIterado.aviso.estado != EstadoAviso.CANCELADO){
							result = false;
						}
					});
				});
			} else {
				result = false;
			}
		});

		return result;
	}

	var buildAvisoEnPantalla = function(ordenPublicacion){

		//lo trabajo a nivel de aviso para que sea mas accesible en el handlebars
		var conceptoVendible = ordenPublicacion.conceptosVendibles[0];
		var aviso = conceptoVendible.itemsConceptoVendible[0].itemsAviso[0].aviso;
		var avisos = [];
		var transaccionActual = ordenPublicacion.transaccionActual;
		var habilitarBotonPagar = habilitarFuncionPagar(transaccionActual, aviso);
		var textoIvaIncluido = "I.V.A. Incluido";
		var montoTotalSinPromoVal = conceptoVendible.montoTotalSinPromo;
		var detalleOrden = {"avisos" : avisos};
		var isOrdenCancelada = isOrdenFacturada(ordenPublicacion);

		modelIterator.iterateAvisosFromOrden(ordenPublicacion,{"detalleOrden" : detalleOrden, "isOrdenCancelada" : isOrdenCancelada},function(index,aviso,args){
			if (aviso.estado != EstadoAviso.CANCELADO || args.isOrdenCancelada){
				args.detalleOrden.avisos.push(aviso);
			}
		});

		// FORMATO A NUMEROS
		function formatNumero(numero, decimales, separador_decimal, separador_miles){
		    numero=parseFloat(numero);
		    if(isNaN(numero)){return "";}
		    if(decimales!==undefined){numero=numero.toFixed(decimales);}
		    numero=numero.toString().replace(".", separador_decimal!==undefined ? separador_decimal : ",");
		    if(separador_miles){var miles=new RegExp("(-?[0-9]+)([0-9]{3})");while(miles.test(numero)) {numero=numero.replace(miles, "$1" + separador_miles + "$2");}}
		    return numero;
		}


		if(aviso.avisoPromocion.length === 0){

			//SI NO HAY PROMOCION SETEO LAS VARIABLES A CERO
			var idOrden = ordenPublicacion.id;
			$("#"+idOrden).addClass("ordenSinPromo");
			var descOrecargo = "";
			var montoTotalSinPromoVal = conceptoVendible.montoTotal;
			var montoTotalSinPromoVal = formatNumero(montoTotalSinPromoVal, 2, ".", ".");
			var montoTotalSinPromoVal = "$ "+montoTotalSinPromoVal;
			var montoPromocionDesglose = "";
			var labelPromo = "";

		}else{
			//SI TIENE PROMOS
			var idOrden = ordenPublicacion.id;
			$("#"+idOrden).addClass("ordenConPromo");


			if(conceptoVendible.montoTotalSinPromo === -1){
				conceptoVendible.montoTotalSinPromo = 0;
			}
			if(conceptoVendible.montoTotalSinPromo < conceptoVendible.montoTotal){
				var descOrecargo = 1;
			}else if (conceptoVendible.montoTotalSinPromo > conceptoVendible.montoTotal){
				var descOrecargo = -1;
			} else {
				var descOrecargo = 0;
			}

			var montoTotalSinPromoVal = conceptoVendible.montoTotalSinPromo;
			var montoTotalVal = conceptoVendible.montoTotal;


			if(descOrecargo === 1){
				var simbDescOrecargo = "+";
				var montoPromocionDesglose = montoTotalSinPromoVal+montoTotalVal;
				var montoPromocionDesglose = montoPromocionDesglose.toFixed(2);
				var montoPromocionDesglose = "$ "+montoPromocionDesglose;
			}else if (descOrecargo === -1){
				var simbDescOrecargo = "-";
				var montoPromocionDesglose = montoTotalSinPromoVal-montoTotalVal;
				var montoPromocionDesglose = montoPromocionDesglose.toFixed(2);
				var montoPromocionDesglose = "$ "+montoPromocionDesglose;
			}else{
				var simbDescOrecargo = "";
				var montoPromocionDesglose = montoTotalSinPromoVal.toFixed(2);
				var montoPromocionDesglose = "$ "+montoPromocionDesglose;
			}
			var montoTotalSinPromoVal = formatNumero(montoTotalSinPromoVal, 2, ".", ".");
			var montoTotalSinPromoVal = "$ "+montoTotalSinPromoVal;
			var labelPromo = "";



		}

		var montoTotalConPromoVal = formatNumero(conceptoVendible.montoTotal, 2, ".", ".");
		renderHandlebars(MisAvisosTemplates.renderOrdenPublicacion,{
			idOrden: ordenPublicacion.id,
			montoTotalSinPromo: montoTotalSinPromoVal,
			montoPromocionDesglose: montoPromocionDesglose,
			montoFinal: montoTotalConPromoVal,
			avisos: detalleOrden.avisos,
			aviso: aviso,
			idAviso: aviso.id,
			codigoClase: aviso.codigoClase,
			habilitarBotonPagar: habilitarBotonPagar,
			labelPromo: labelPromo,
			avisosPromocion: aviso.avisoPromocion,
			textoLibre: aviso.textoLibre,
			simbDescOrecargo: simbDescOrecargo,
			mapEstados: model.mapEstados,
			transaccionActual: transaccionActual,
			orden: ordenPublicacion
		}, ui.divListaAvisos);

		if(aviso.avisoPromocion.length === 0){
			var idOrden = ordenPublicacion.id;
			$("#"+idOrden).addClass("ordenSinPromo");

			$(".ordenSinPromo .montoSinPromo").siblings().text(textoIvaIncluido);
		}else{
			$("#"+idOrden).addClass("ordenConPromo");
			var avisoPrintGratis = aviso.avisoPromocion[0].promocion.codigo;
			if(avisoPrintGratis === "PROMO_MOTO_1_LINEA_GRATIS_ROL"){
				$("#"+idOrden).addClass("ordenConPromoGratis");
			}
			$(".ordenConPromo span.ivaIncluido").text(textoIvaIncluido);
		}
		var cortarTextoLibre = function(){
			$('.limit30 a').each(function(){
		        var longitud=30;
		        var nombre = $(this);
		        if(nombre.text().length > longitud){
		            var texto=nombre.text().substring(0,longitud);
		            texto=texto.substring(0,longitud) +"...";
		            nombre.html(texto);
		        }
		    });
		};
		$('#cargandoDatos').hide();
		cortarTextoLibre();
		//si se trabaja a nivel de orden ver como se itera y como se pide el id una vez dentro...
		//renderHandlebars(MisAvisosTemplates.renderOrdenPublicacion, {ordenPublicacion: ordenPublicacion}}, ui.divListaAvisos);
	}

	var buildCapturadorCRUDDTO = function(){
		return new CapturadorCRUDDTO({
			codigoAnunciante					: decoratorModel.getCapturador().codigoAnunciante,
			codigoCliente						: decoratorModel.getCapturador().codigoCliente
		})
	};

	var renderizarMisAvisosHandlerOnLoad = function(data){
		var listaOrdenes = arrayUtils.buildArrayObjFromJSON(data.ordenesPublicacion, OrdenDePublicacionCabeceraDTO);
		if(listaOrdenes.length == 0){
			$('#cargandoDatos').hide();
			mostrarDivsListaVacia();
		}else{
			misAvisosModel.setListaOrdenesDePublicacion(listaOrdenes);
			for(var i=0; i<listaOrdenes.length; i++){
				buildAvisoEnPantalla(listaOrdenes[i]);
			}
		}
		listarEstados();
	}


	var cargarAvisosUsuario = function(){
		blockCallerUI.blockPost({
			url : MisAvisosServiceURL.GET_ORDENES_PUBLICACION_BY_CAPTURADOR,
			dataObject : buildCapturadorCRUDDTO(),
			successHandlerCallback : renderizarMisAvisosHandlerOnLoad,
			errorHandlerCallback : defaultErrorHandler
			//SE ELIMINAN LOS PARAMETROS DE ASYNC
		});
	};

	var onClickNuevoAvisoHandler = function(){
		blockCallerUI.blockPost({ url : MisAvisosServiceURL.GET_SESSION_STATUS,
			dataObject : {},
			successHandlerCallback : redirectNuevoAvisoHandler,
			errorHandlerCallback : defaultErrorHandler });
	};


	var initPopUpPagar = function () {
		datos = {
			idPopUp				: "popUpPagar",
			classTipoMensaje	: "popUpInfo", // Puede ser "popUpAlerta", "popUpInfo" o "popUpError"
			titulo				: "Pag\xe1 tu aviso"
		};
		var source   = DecoratorTemplates.modalPopUpWindow;
		var template = Handlebars.compile(source);
		var html     = template(datos);

		ui.mainContainer.append(html);
	};

	var initPopUpPrint = function () {
		datos = {
				idPopUp				: "popUpPrint",
				classTipoMensaje	: "popUpInfo", // Puede ser "popUpAlerta", "popUpInfo" o "popUpError"
				titulo				: "",
				txtBoton2			: "Cerrar",
				classBoton1 		: "hidden",
				funcionBoton2		: "gOnclickAceptarErrorHandler(this)"
		};
		var source   = DecoratorTemplates.modalPopUpWindow;
		var template = Handlebars.compile(source);
		var html     = template(datos);

		ui.mainContainer.append(html);
	};

	var initPopUpDetalle = function () {
		datos = {
			idPopUp				: "popUpDetalle",
			classTipoMensaje	: "popUpInfo", // Puede ser "popUpAlerta", "popUpInfo" o "popUpError"
			titulo				: "",
			txtBoton2			: "Cerrar",
			funcionBoton2		: "gOnclickAceptarErrorHandler(this)"
		};
		var source   = DecoratorTemplates.modalPopUpWindow;
		var template = Handlebars.compile(source);
		var html     = template(datos);

		ui.mainContainer.append(html);
	};

	var getUltimoPreviewContenido = function (ordenPublicacion){

		var args = { "ultimaFechaPedidoPublicacion" : null , "ultimoPreviewContenido" : null};

		modelIterator.iterateAvisosFromOrden(ordenPublicacion, args, function(index ,aviso ,args){

			if (args.ultimaFechaPedidoPublicacion == null || new Date(args.ultimaFechaPedidoPublicacion) < new Date(aviso.fechaPedidoPublicacion)){
				args.ultimaFechaPedidoPublicacion = aviso.fechaPedidoPublicacion;
				args.ultimoPreviewContenido = aviso.preview.contenido;
			}

		});

		return args.ultimoPreviewContenido;

	}

	var onClickDetalleAvisoHandler = function(component){
		$("#popUpDetalle").remove();
		initPopUpDetalle();
		var componente = $(this);
		var idAviso = parseInt(componente.parents(".singleItemAvisos").attr("id"), "");
		var tituloAvisoCortado = componente.text();
		var codigoAviso = $("#"+idAviso+" .codigoPublicacion").text();
		var ordenPublicacion = obtenerOrden(parseInt(codigoAviso, ""));
		var aviso = ordenPublicacion.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso;
		var multiplesConceptos = ordenPublicacion.conceptosVendibles.length > 1;
		var conceptos = [];


		var imgAviso = getUltimoPreviewContenido(ordenPublicacion);
		var producto = aviso.productoComercial.producto.descripcion;
		var zonaComercializacion = aviso.zonasComercializacion[0].descripcion;
		var medioRubro = aviso.nivelEstructura.descripcion;
		var transaccionActual = ordenPublicacion.transaccionActual;

		ordenPublicacion.conceptosVendibles = $.grep(ordenPublicacion.conceptosVendibles, function (conceptoVendible, index){
			return conceptoVendible.estado != EstadoConcepto.ANULADO;
		});

		var lineasAviso = aviso.lineasPublicadas;
		var tipoOperacion = aviso.tipoOperacion.descripcion;
		var promocionesDescripcion = "Descuentos";
		var montoTotal = 0;
		var montoTotalConPromo = 0;
		var montoTotalSinPromo = 0;

		var montos = {"montoTotalSinPromo":montoTotalSinPromo,"montoTotalConPromo":montoTotalConPromo,"montoTotal":montoTotal};
		modelIterator.iterateConceptosVendiblesFromOrden(ordenPublicacion,{"montos":montos},function(index,concepto,args){
			args.montos.montoTotalSinPromo = args.montos.montoTotalSinPromo + concepto.montoTotalSinPromo;
			args.montos.montoTotalConPromo =args.montos.montoTotalConPromo + concepto.montoTotalSinPromo-concepto.montoTotal;
			args.montos.montoTotal = args.montos.montoTotal + concepto.montoTotal;
		});

		var montoTotalFinal = montos.montoTotal.toFixed(2);
		var template = Handlebars.compile(MisAvisosTemplates.renderOrdenPublicacionHeaderDetalle);
		var context  = {
				idAviso						: idAviso,
				tituloAvisoCortado			: tituloAvisoCortado,
				codigoAviso					: codigoAviso
			};
		var html     = template(context);
		$("#popUpDetalle .modal-header").append(html);

		var templateBody = Handlebars.compile(MisAvisosTemplates.renderOrdenPublicacionBodyDetalle);
		var conceptosWrapper = crearWrapperConceptos(ordenPublicacion,model.mapEstados);
		var contextBody  = {
				idAviso						: idAviso,
				producto					: producto,
				zonaComercializacion		: zonaComercializacion,
				medioRubro					: medioRubro,
				tipoOperacion				: tipoOperacion,
				imgAviso					: imgAviso,
				lineasAviso					: lineasAviso,
				ordenPublicacion			: ordenPublicacion,
				aviso						: aviso,
				conceptosWrapper			: conceptosWrapper,
				montoTotalFinal				: montoTotalFinal,
				multiplesConceptos			: multiplesConceptos,
				promocionesDescripcion		: promocionesDescripcion

			};
		var htmlBody     = templateBody(contextBody);
		$("#popUpDetalle .modal-body").html(htmlBody);
		$("#popUpDetalle").modal("show");
		var posAviso = $("#"+idAviso).offset();
		posAviso = parseInt(posAviso.top, "");
		//window.scrollTo(200,200);
		$("html, body").animate({
			"scrollTop": posAviso
		});
		$("html").on("keydown", function(e){
			if (e.keyCode === 9){
				e.preventDefault();
			}
		});
		$("#popUpDetalle").on("hidden", function () {
			setTimeout(function(){
				$("#"+idAviso).removeClass("destacado");
			},3000);
			$("html").off("keydown");
        });
		var imgAvisoAlto = function(){
			var altoImg = $("#popUpDetalle .modal-body .imagenDetalle img").height();
			var maxAlto = 150;
			if(altoImg > maxAlto){
				$("#popUpDetalle .modal-body, #popUpDetalle .modal-footer").addClass("imgAlto");
			}
		}
		setTimeout(function(){
			imgAvisoAlto();
		},250);
	};

	var crearWrapperConceptos = function(orden,estadosAviso) {

		//crea un wrapper para ser mostrado en el detalle de avisos
		//este wrapper contiene el aviso con su referencia al precio del concepto que lo tiene y los descuentos por promociones

		var wrapperConceptos =[];

		//se hace con un each y no con el modelIterator  ya que se requiere recorrer conceptos y avisos
		$.each(orden.conceptosVendibles,function(index,conceptoVendible){
			var wrapperConcepto ={"wrapperAvisos":[],"subtotal":0,"descuentos":0,"totalAviso":0,"lineasPublicadas":0,"tienePromociones":false,"wrapperPromociones":[],"muestraDetallePromocion":true};
			var aviso = conceptoVendible.itemsConceptoVendible[0].itemsAviso[0].aviso;
			wrapperConcepto.lineasPublicadas = aviso.lineasPublicadas;

			if(aviso.avisoPromocion == undefined || aviso.avisoPromocion.length < 1||conceptoVendible.montoTotal===0){

				wrapperConcepto.subtotal = conceptoVendible.montoTotal;
				wrapperConcepto.subtotal = wrapperConcepto.subtotal.toFixed(2);
				wrapperConcepto.descuentos =  0;
				wrapperConcepto.totalAviso = conceptoVendible.montoTotal;
				wrapperConcepto.totalAviso = wrapperConcepto.totalAviso.toFixed(2);
				wrapperConcepto.tienePromociones = false;
			}
			else{
				modelIterator.iteratePromocionesFromConceptoVendible(conceptoVendible,{"wrapperConcepto":wrapperConcepto},function(index,avisoPromocionDTO,args){
					var wrapperPromocionDescripcion = {"promocionDescripcion":"","promocionDescuento":0};
					var actualizo = false;

					// deesta manera se mantiene la manera de mostrar aquellos avisos que no tienen detalle pero tienen promocion aplicada
					if(avisoPromocionDTO.montoConIva <= 0 ){
						wrapperConcepto.muestraDetallePromocion = false;
					}

					if(wrapperConcepto.wrapperPromociones.length>0){
						//calculo la sumatoria de descuentos por cada promocion
						$.each(wrapperConcepto.wrapperPromociones,function(indice,wrapperPromocion){
							if(wrapperPromocion.promocionDescripcion === avisoPromocionDTO.promocion.descripcion){
								wrapperPromocion.promocionDescripcion = avisoPromocionDTO.promocion.descripcion;
								if(avisoPromocionDTO.esDescuento){

									wrapperPromocion.promocionDescuento = wrapperPromocion.promocionDescuento - avisoPromocionDTO.montoConIva;
								}
								else wrapperPromocion.promocionDescuento = wrapperPromocion.promocionDescuento - avisoPromocionDTO.montoConIva;
								actualizo =true;
							}
						});
					}
					//si no se actualizo datos quiere decir que es la primera vez
					if(!actualizo){
						wrapperPromocionDescripcion.promocionDescripcion = avisoPromocionDTO.promocion.descripcion;
						if(avisoPromocionDTO.esDescuento){

							wrapperPromocionDescripcion.promocionDescuento = avisoPromocionDTO.montoConIva * -1;
						}
						else wrapperPromocionDescripcion.promocionDescuento = avisoPromocionDTO.montoConIva;
						wrapperConcepto.wrapperPromociones.push(wrapperPromocionDescripcion);
					}

				});

				if(wrapperConcepto.wrapperPromociones.length>0){
					$.each(wrapperConcepto.wrapperPromociones,function(indice,wrapperPromocion){
						wrapperPromocion.promocionDescuento = wrapperPromocion.promocionDescuento.toFixed(2);
					});
				}
				wrapperConcepto.subtotal = conceptoVendible.montoTotal;
				wrapperConcepto.subtotal = wrapperConcepto.subtotal.toFixed(2);
				wrapperConcepto.descuentos = conceptoVendible.montoTotal - conceptoVendible.montoTotalSinPromo;
				wrapperConcepto.descuentos = wrapperConcepto.descuentos.toFixed(2);

				wrapperConcepto.totalAviso = conceptoVendible.montoTotalSinPromo.toFixed(2);
				wrapperConcepto.tienePromociones = true;
			}
			$.each(conceptoVendible.itemsConceptoVendible,function(index,itemComceptoVendible){
				$.each(itemComceptoVendible.itemsAviso,function(index,itemAviso){
					var wrapperAviso ={"aviso":itemAviso.aviso,"mapEstados":estadosAviso,"transaccionActual":orden.transaccionActual};
					wrapperConcepto.wrapperAvisos.push(wrapperAviso);
				});
			});
			wrapperConceptos.push(wrapperConcepto);
		});

		return wrapperConceptos;
	};

	var checkRedirectUsuarioNoLogueado = function(){
		if(decoratorModel.getUsuario() == null){
			redirect(URLConstants.ROL_CREAR_AVISO);
		}
	};

	var redirectDatosPersonalesHandler = function(){
		redirect(URLConstants.ROL_DATOS_PERSONALES);
	};

	var redirectNuevoAvisoHandler = function(){
		redirect(URLConstants.ROL_CREAR_AVISO);
	};

	var inicializarMapEstados = function(){

		var estado0 = {estado: EstadoAviso.PENDIENTE_PAGO, traduccionEstadoGWPPendiente: TraduccionEstadoAviso.PENDIENTE_PAGO_GWP_PENDIENTE, traduccionEstadoGWPRechazado: TraduccionEstadoAviso.PENDIENTE_PAGO_GWP_RECHAZADO, traduccionEstadoGWPSinRespuesta: TraduccionEstadoAviso.PENDIENTE_PAGO_GWP_SIN_RESPUESTA, descPopOverGWPPendiente: DescripcionEstadoAvisoPopOver.PENDIENTE_PAGO_GWP_PENDIENTE, descPopOverGWPRechazado: DescripcionEstadoAvisoPopOver.PENDIENTE_PAGO_GWP_RECHAZADO, descPopOverGWPSinRespuesta: DescripcionEstadoAvisoPopOver.PENDIENTE_PAGO_GWP_SIN_RESPUESTA};
		var estado1 = {estado: EstadoAviso.SIN_AUTORIZAR, traduccionEstado: TraduccionEstadoAviso.SIN_AUTORIZAR, descPopOver: DescripcionEstadoAvisoPopOver.SIN_AUTORIZAR};
		var estado2 = {estado: EstadoAviso.PENDIENTE_PUBLICACION, traduccionEstado: TraduccionEstadoAviso.PENDIENTE_PUBLICACION, descPopOver: DescripcionEstadoAvisoPopOver.PENDIENTE_PUBLICACION};
		var estado3 = {estado: EstadoAviso.DERIVADO_PUBLICACION, traduccionEstadoFechaMenor: TraduccionEstadoAviso.DERIVADO_PUBLICACION_FECHA_MENOR, traduccionEstadoFechaMayor: TraduccionEstadoAviso.DERIVADO_PUBLICACION_FECHA_MAYOR, descPopOverFechaMenor: DescripcionEstadoAvisoPopOver.DERIVADO_PUBLICACION_FECHA_MENOR, descPopOverFechaMayor: DescripcionEstadoAvisoPopOver.DERIVADO_PUBLICACION_FECHA_MAYOR};
		var estado4 = {estado: EstadoAviso.VENCIDO, traduccionEstado: TraduccionEstadoAviso.VENCIDO, descPopOver: DescripcionEstadoAvisoPopOver.VENCIDO};
		var estado5 = {estado: EstadoAviso.CANCELADO, traduccionEstado: TraduccionEstadoAviso.CANCELADO, descPopOver: DescripcionEstadoAvisoPopOver.CANCELADO};
		var estado6 = {estado: EstadoAviso.RECHAZADO, traduccionEstado: TraduccionEstadoAviso.RECHAZADO, descPopOver: DescripcionEstadoAvisoPopOver.RECHAZADO};
		var estado7 = {estado: EstadoAviso.NO_PUBLICADO, traduccionEstado: TraduccionEstadoAviso.NO_PUBLICADO, descPopOver: DescripcionEstadoAvisoPopOver.NO_PUBLICADO};
		var estado8 = {estado: EstadoAviso.SUSPENDIDO_SIN_AUTORIZAR, traduccionEstado: TraduccionEstadoAviso.SUSPENDIDO_SIN_AUTORIZAR, descPopOver: DescripcionEstadoAvisoPopOver.SUSPENDIDO_SIN_AUTORIZAR};
		var estado9 = {estado: EstadoAviso.SUSPENDIDO_AUTORIZADO, traduccionEstado: TraduccionEstadoAviso.SUSPENDIDO_AUTORIZADO, descPopOver: DescripcionEstadoAvisoPopOver.SUSPENDIDO_AUTORIZADO};

		model.mapEstados.push(estado0);
		model.mapEstados.push(estado1);
		model.mapEstados.push(estado2);
		model.mapEstados.push(estado3);
		model.mapEstados.push(estado4);
		model.mapEstados.push(estado5);
		model.mapEstados.push(estado6);
		model.mapEstados.push(estado7);
		model.mapEstados.push(estado8);
		model.mapEstados.push(estado9);

	};

	var resizeWindows = function(){
		$(window).on("resize",function(){
			tomarAlto();
		});
	};

	var ui = {
		menuLogueado				: $("#menuLogueado"),
		menuNoLogueado				: $("#menuNoLogueado"),
		menuMailNoValidado			: $("#menuMailNoValidado"),
		menuSinCapturador			: $("#menuSinCapturador"),
		mainContainer				: $("#mainMisAvisos"),
		bloqueEstado				: $("#bloqueEstado"),
		btnNuevoAviso				: $("#nuevoAvisoBtn"),
		divListaAvisos				: $("#listAvisosWrapper"),
		divListaVacia				: $("#divListaVacia"),
		divListaVaciaMensaje		: $("#divListaVaciaMensaje"),
		divMensajeMontaner			: $("#divMensajeMontaner"),
		divMsjOrdenSuccess			: $("#divOrdenPublicacionSuccess"),
		divMsjOrdenSuccessGratis	: $("#divOrdenPublicacionSuccessGratis"),
		divMsjOrdenSuccessEditPago  : $("#divOrdenPublicacionSuccessEditPago"),
		popUpImprimirBody			: $("#popUpPrint .modal-body"),
		popUpPagar					:	null
	};

	var model = {
		uuid 						: "",
		mapEstados					: new Array(),
		tarjetas					: null,
		codigoGATEWAYSeleccionado 	: null

	};

	var initUIComponents = function (){
		tomarAlto();
		checkRedirectUsuarioNoLogueado();
		inicializarMapEstados();
		resizeWindows();
		cargarAvisosUsuario();
		mostrarFiltros();

		$(".alert").bind("closed", function () {
			tomarAlto();
		});
	};

	var bindUIActions = function(){
		ui.btnNuevoAviso.on('click', onClickNuevoAvisoHandler);
		$(".btnDetalleAviso").on('click', onClickDetalleAvisoHandler);
		$(".ico-ayuda").tooltip();
		$(".ico-ayuda").on("tap",function(){
			$(this).hide();
		});
	};

	var initModel = function(){

		model.uuid = GetURLParameters('uuid');

		if(model.uuid != null){
			checkAndShowGWPTransaccionMsjSuccess(model.uuid);
		}
	};

	var esOrdenDePublicacionPagoAcreditado = function(ordenDePublicacion){
		return (ordenDePublicacion.transaccionActual != undefined &&
					ordenDePublicacion.transaccionActual.estado == EstadoGWPTransaccion.ACREDITADO);
	}

	var checkAndShowGWPTransaccionMsjSuccess = function(ordenUuid){
		var ordenCargada = null;
		var listaOrdenes = misAvisosModel.getListaOrdenesDePublicacion();
		for(var i=0; i<listaOrdenes.length; i++){
			if(listaOrdenes[i].uuidGenerarOrden == model.uuid){
				ordenCargada = listaOrdenes[i];
			}
		}

		productoComercialAviso = ordenCargada.conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.productoComercial.codigo;
		var avisoGratis = ordenCargada.conceptosVendibles[0].montoTotal;
// MUESTRA EL MENSAJE DEPENDIENDO SI ES GRATUITO O NO Y SI TIENE LA PROMO DE ENAMORADOS
		if(avisoGratis !== 0){
			if (productoComercialAviso === "R5840 - Lineal con picto ROL NVO" ||
					productoComercialAviso === "R5840 - Lineal" ||
					productoComercialAviso === "R5840 - Lineal NVO" ||
					productoComercialAviso === "R5840 - Lineal con picto ROL" ||
					productoComercialAviso === "R5840 - Lineal con color" ||
					productoComercialAviso === "R5840 - Lineal con color ROL NVO" ||
					productoComercialAviso === "R5840 - Lineal con color ROL"){
				ui.divMensajeMontaner[0].style.display = 'block';
			}else{
				if (esOrdenDePublicacionPagoAcreditado(ordenCargada)){
					ui.divMsjOrdenSuccessEditPago[0].style.display = 'block';
				} else {
					ui.divMsjOrdenSuccess[0].style.display = 'block';
				}
			}
		}else{
			ui.divMsjOrdenSuccessGratis[0].style.display = 'block';
		}
	};

	var doOnComplete = function () {

		if(Detectizr.device.browser === "ie"){
			if(seleccionoTarjeta()){

				if ($('#btnPagarPopUp').hasClass("disabledBtn")){
					$('#btnPagarPopUp a').attr("onclick","gOnclickPagar(this)");
					$('#btnPagarPopUp').removeClass("disabledBtn");
				}
			}else{

				if (!$('#btnPagarPopUp').hasClass("disabledBtn")){
					$('#btnPagarPopUp a').removeAttr("onclick");
					$('#btnPagarPopUp').addClass("disabledBtn");
				}
			}
		}else{
			if(seleccionoTarjeta()){

				if ($('#btnPagarPopUp').hasClass("disabledBtn")){
					$('#btnPagarPopUp').removeClass("disabledBtn");
				}

			}
			else{

				if (!$('#btnPagarPopUp').hasClass("disabledBtn")){
					$('#btnPagarPopUp').addClass("disabledBtn");
				}
			}
		}
	};

	var seleccionoTarjeta = function (){
		var haySeleccion = false;
		$.each(model.tarjetas,function(index,tarjeta){

			if($("#"+tarjeta.codigoGATEWAY).prop('checked')){
				haySeleccion = true;
			};

		});
		return haySeleccion;
	};

	var initPopUpConfirmarDetener = function () {
		datos = {
			idPopUp   : "popUpConfirmarDetener",
			classTipoMensaje : "popUpAlerta", // Puede ser "popUpAlerta", "popUpInfo" o "popUpError"
			titulo    : "Atenci\xf3n:",
			txtBoton1 : "No",
			txtBoton2 : "S\xed",
			funcionBoton1: "gOnclickCancelarDetenerPublicacion(this)", //Vacio, solo tiene un boton
			funcionBoton2: "gOnclickAceptarDetenerPublicacion(this)"

		};
		var source   = DecoratorTemplates.modalPopUpWindow;
		var template = Handlebars.compile(source);
		var html     = template(datos);

		ui.mainContainer.append(html);
	};

	var initPopUpConfirmarReanudar = function () {
		datos = {
			idPopUp   : "popUpConfirmarReanudar",
			classTipoMensaje : "popUpAlerta", // Puede ser "popUpAlerta", "popUpInfo" o "popUpError"
			titulo    : "Atenci\xf3n:",
			txtBoton1 : "No",
			txtBoton2 : "S\xed",
			funcionBoton1: "gOnclickCancelarReanudarPublicacion(this)", //Vacio, solo tiene un boton
			funcionBoton2: "gOnclickAceptarReanudarPublicacion(this)"

		};
		var source   = DecoratorTemplates.modalPopUpWindow;
		var template = Handlebars.compile(source);
		var html     = template(datos);

		ui.mainContainer.append(html);
	};

	var suspenderPublicacionAvisoHandler = function(data){
		var aviso = data.ROLResult.object;

		var estadoAviso = $("span[data-identificador=\"estado-"+aviso.id+"\"]")[0];
		var descripcionEstadoAviso = $("span[data-identificador=\"popOver-"+aviso.id+"\"]")[0];
		if (aviso.estado === EstadoAviso.SUSPENDIDO_SIN_AUTORIZAR){
			estadoAviso.innerHTML = "("+TraduccionEstadoAviso.SUSPENDIDO_SIN_AUTORIZAR+")";
			$(descripcionEstadoAviso).attr("data-original-title", DescripcionEstadoAvisoPopOver.SUSPENDIDO_SIN_AUTORIZAR);
		} else if (aviso.estado === EstadoAviso.SUSPENDIDO_AUTORIZADO){
			estadoAviso.innerHTML = "("+TraduccionEstadoAviso.SUSPENDIDO_AUTORIZADO+")";
			$(descripcionEstadoAviso).attr("data-original-title", DescripcionEstadoAvisoPopOver.SUSPENDIDO_AUTORIZADO);
		}


		var linkDetenerPublicacion = $("a[data-identificador=\"linkDetener-"+aviso.id+"\"]")[0];
		linkDetenerPublicacion.innerHTML = "Reanudar publicaci&oacute;n";
		$(linkDetenerPublicacion).attr("onclick", "gMuestraAvisoReanudar(this);");
		$(linkDetenerPublicacion).attr("data-identificador", "linkReanudar-"+aviso.id);
		$(linkDetenerPublicacion).attr("title", "Reanudar publicaci&oacute;n");
		$(linkDetenerPublicacion).attr("class", "reanudarPublicacion");

	};

	var reanudarPublicacionAvisoHandler = function(data){
		var aviso = data.ROLResult.object;

		var estadoAviso = $("span[data-identificador=\"estado-"+aviso.id+"\"]")[0];
		var descripcionEstadoAviso = $("span[data-identificador=\"popOver-"+aviso.id+"\"]")[0];
		if(aviso.estado === EstadoAviso.SIN_AUTORIZAR){
			estadoAviso.innerHTML = "("+TraduccionEstadoAviso.SIN_AUTORIZAR+")";
			$(descripcionEstadoAviso).attr("data-original-title", DescripcionEstadoAvisoPopOver.SIN_AUTORIZAR);
		}else if(aviso.estado === EstadoAviso.PENDIENTE_PUBLICACION){
			estadoAviso.innerHTML = "("+TraduccionEstadoAviso.PENDIENTE_PUBLICACION+")";
			$(descripcionEstadoAviso).attr("data-original-title", DescripcionEstadoAvisoPopOver.PENDIENTE_PUBLICACION);
		}

		var linkReanudarPublicacion = $("a[data-identificador=\"linkReanudar-"+aviso.id+"\"]")[0];
		linkReanudarPublicacion.innerHTML = "Detener publicaci&oacute;n";
		$(linkReanudarPublicacion).attr("onclick", "gMuestraAvisoDetener(this);");
		$(linkReanudarPublicacion).attr("data-identificador", "linkDetener-"+aviso.id);
		$(linkReanudarPublicacion).attr("title", "Detener publicaci&oacute;n");
		$(linkReanudarPublicacion).attr("class", "detenerPublicacion");

	};

	//Implementados para republicacion
	var redirectHandler = function(data){
		redirect(data.url);
	};


	//------------------------------------------------
	// public interface ------------------------------
	//------------------------------------------------

	return {

		init : function (args){
			initUIComponents();
			bindUIActions();
			initModel();
			decoratorController.setUpFromModule({ module :ModuleConstants.MIS_AVISOS });
			initPopUpPagar();
			initPopUpPrint();
			initPopUpDetalle();
			initPopUpConfirmarDetener();
			initPopUpConfirmarReanudar();
			obtenerTarjetasDisponibles();
			fechaHoy();
		}

	}

})();

$(document).ready(function() {
	misAvisosController.init({});
});