/**
 * author: vdenicolo
 * version: 1.0.0
 * require: handlebars.js | data-utils.js
 * description: Clase placeholder para Templates y Helpers de componentes UI.
 */
MisAvisosTemplates = {};

/*********************************************************
 * Templates
 *********************************************************/

MisAvisosTemplates.renderOrdenPublicacion = [
	"<div class='singleItemAvisos' id={{idOrden}} data-codigoClase='{{codigoClase}}'>",
		"<div class='headerAvisos'>",
			"<div class='headerAvisosCodigo'>C&oacute;digo de publicaci&oacute;n: <span class='codigoPublicacion'>{{idOrden}}</span></div>",
			"<div class='bloqueImprimir'>",
				"<span><a href='#' onclick='g_muestraVentanaPrint(this);' title='Imprimir Aviso'><span class='icon-print'>&nbsp;</span></a></span>",
				"<!-- <span><a href='#'  onclick='gCreaPdf(this);' title='Descargar Aviso en PDF'><span class='icon-download-alt'></span></a></span>-->",
			"</div>",
			"<div class='clearfix'><!-- Empty --></div>",
		"</div>",
		"<div class='bodyAvisos'>",
			"<div class='itemBodyAvisos'>",
				"<div class='textoAvisoCorto'>",
					"<p class='limit30'><a href='#' data-id-orden='{{idOrden}}' class='btnDetalleAviso'>{{textoLibre}}</a></p>",
				"</div>",
				"",
				"<span class='medioRubroMisAvisos'>{{aviso.productoComercial.producto.descripcion}}</span> &gt; " +
					"<span class='zonaComercializacionMisAvisos'>{{zonasComercializacion aviso.zonasComercializacion}}</span> &gt; " +
					"<span class='rubroTitMisAvisos'>{{aviso.nivelEstructura.descripcion}}</span> &gt; " +
					"<span class='tipoOperacionMisAvisos'>{{aviso.tipoOperacion.descripcion}}</span>" +
				"",
			"</div>",
			"<div class='itemBodyAvisos'>",
				"<div class='itemFechaPublicado'>",
				"{{#each avisos}}",
					"<div class='itemLineasPublicado'>",
						"<p>{{fechaPublicacion fechaPedidoPublicacion}}</p>",
						"<p class='txtEstado' data-identificador='estado-{{id}}'>{{traduccionEstado this ../mapEstados ../transaccionActual}}<span class='ico-ayuda' title='{{traduccionPopOver this ../mapEstados ../transaccionActual}}' data-identificador='popOver-{{id}}' data-toggle='tooltip' data-placement='top'></span></p>",
						"{{#ifHabilitarRepublicarAviso estado}}",
							"<p class='pRepublicar'><a class='republicarAviso' title='Republicar' href='javascript:;' data-idAviso='{{id}}' data-idOrden='{{../idOrden}}' data-identificador='linkRepublicar-{{id}}' onclick='gOnClickRepublicar(this);'>Republicar</a></p>",
						"{{else}}",
							"&nbsp;",
						"{{/ifHabilitarRepublicarAviso}}",
					"</div>",
				"{{/each}}",
				"</div>",
			"</div>",
			"<div class='itemImgAvisos'>",
				"<img id='imgPreview' src='data:image/jpeg;base64,{{aviso.preview.contenido}}'>",
			"</div>",
		"</div>",
		"<div class='footerAvisos'>",
			"<div class='btnFooterMisAvisos'>",
				"{{#if habilitarBotonPagar}}",
					"<div class='genericBtn btnPagar'><a href='#' title='Pagar' data-idorden='{{idOrden}}' onclick='g_muestraVentanaPagar(this);'><span>Pagar</span></a></div>",
				"{{else}}",
					"&nbsp;",
				"{{/if}}",
				"{{#ifHabilitarBotonEditar orden}}",
					"<div class='genericBtn btnEditar'><a href='#' title='Editar' data-idOrden='{{idOrden}}' data-orden='{{orden}}' onclick='gOnClickEditar(this);'><span>Editar</span></a></div>",
				"{{else}}",
					"&nbsp;",
				"{{/ifHabilitarBotonEditar}}",
				"{{#if habilitarBotonPagar}}",
					"<div class='clearfix'></div>",
				"{{/if}}",
				"{{#ifHabilitarBotonEditar orden}}",
					"<div class='clearfix'></div>",
				"{{/ifHabilitarBotonEditar}}",
			"</div>",
		"</div>",
	"</div>",
].join("\n");

MisAvisosTemplates.renderOrdenPublicacionHeaderDetalle = [
"<div class='titulo-cortado'>",
	"<h3>{{tituloAvisoCortado}}</h3>",
"</div>",
"<div>",
	"<p><strong>C&oacute;digo de publicaci&oacute;n: {{codigoAviso}}</strong></p>",
"</div>",
].join("\n");

MisAvisosTemplates.renderOrdenPublicacionBodyDetalle = [
"<div class='topDetalle'>",
	"<div class='productoDetalle'>",
		"{{producto}} &gt; ",
		"{{zonasComercializacion aviso.zonasComercializacion}} &gt; ",
		"{{medioRubro}} &gt; ",
		"{{tipoOperacion}}",
	"</div>",
"</div>",
"<div class='clearfix'><!-- --></div>",
"<div id='bodyDetalle'>",
	"<div class='scrollDetalle'>",
		"<div class='DetalleUnAviso'>",
			"{{#each conceptosWrapper}}",
				"<div class='itemAviso'>",
					"<div class='lineasItem'>",
						"<p>{{lineasPublicadas}} l&iacute;neas</p>",
					"</div>",
					"<div class='montoTotalFinalSinPromo'>",
						"<p>$ {{totalAviso}}</p><span class='ivaIncluido'>I.V.A. Incluido</span>",
					"</div>",
				"</div>",
				"<div class='clearfix'><!-- --></div>",
				"{{#each wrapperAvisos}}",
					"<div class='listaFechasYEstados'>",
						"<div class='fechasDetalle'>",
							"{{fechaPublicacion aviso.fechaPedidoPublicacion}}",
						"</div>",
						"<div class='estadosDetalle' id='mensajeEstado'>",
							"<span class='uppercase'>{{traduccionEstado aviso mapEstados transaccionActual}}<span><span class='ico-ayuda' title='{{traduccionPopOver aviso mapEstados transaccionActual}}' data-toggle='tooltip' data-placement='top'></span>",
						"</div>",
					"</div>",
				"{{/each}}",
				"<div class='clearfix'><!-- --></div>",
				"{{#if tienePromociones }}",
					"{{#if muestraDetallePromocion }}",
						"{{#each wrapperPromociones}}",
							"<div class='detallePromos'>",
								"<div class='descPromosDetalle'>",
									"<p>{{promocionDescripcion}}</p>",
								"</div>",
								"<div class='montoDescuentosTotalFinal'>",
									"<p>$ {{promocionDescuento}}</p> <span class='ivaIncluido'>I.V.A. Incluido</span>",
								"</div>",
							"</div>",
						"{{/each}}",
					"{{else}}",
						"<div class='detallePromos'>",
							"<div class='descPromosDetalle'>",
								"<p>{{../../../promocionesDescripcion}}</p>",
							"</div>",
							"<div class='montoDescuentosTotalFinal'>",
								"<p>$ {{descuentos}}</p> <span class='ivaIncluido'>I.V.A. Incluido</span>",
								"</div>",
							"</div>",
					"{{/if}}",

				"{{/if}}",
				"{{#if ../multiplesConceptos}}",
					"<div class='subTotalDetalle'>",
						"<div class='titSubtotal'>",
							"<strong>Sub Total</strong>",
						"</div>",
						"<div class='precioSubTotal'>",
							"<p>$ {{subtotal}}</p> <span class='ivaIncluido'>I.V.A. Incluido</span>",
						"</div>",
					"</div>",
				"{{/if}}",
			"{{/each}}",
		"</div>",
		"<div class='imagenDetalle'>",
			"<img id='imgPreview' src='data:image/jpeg;base64,{{aviso.preview.contenido}}'>",
		"</div>",
		"<div class='totalDetalle'>",
			"<p>Total <span>$ {{montoTotalFinal}}</span></p> <span class='ivaIncluido'>I.V.A. Incluido</span>",
		"</div>",
	"</div>",
"</div>",
].join("\n");

MisAvisosTemplates.renderOrdenPublicacionImprimir = [
	"<div id='head-cont-aviso'>",
		"<div class='pull-left'>",
			"<p><strong>Capturada el:</strong> {{fechaPublicacionDiaSemana fechaCaptura}} </p>",
			"<p><strong>Impresa el:</strong> {{fechaPublicacionDiaSemana fechaDeImpresion}} </p>",
		"</div>",
		"<div class='pull-right'>",
			"<p><strong>Orden Nro:</strong> {{codigoAviso}}</p>",
		"</div>",
	"</div>",
	"<div class='clearfix'>&nbsp;</div>",
	"<div id='user-cont-aviso'>",
		"<h3 class='subTitAviso'>Datos de la orden de publicaci&oacute;n</h3>",
		"<p><strong>Nombre/Raz&oacute;n Social:</strong> <span>{{usuarioAvisoNombre}}</span>&nbsp;<span>{{usuarioAvisoApellido}}</span></p>",
		"<p><strong>Email de contacto:</strong> {{usuarioAvisoEmailContacto}}</p>",
		"<p><strong>Tel&eacute;fono de contacto:</strong> {{usuarioAvisoTelefonoContacto}}</p>",
		"<p class='medioPago'><strong>Medio de pago:</strong> {{medioPago}}</p>",
		"<p><strong>Producto:</strong> {{producto}}</p>",
		"<p class='pRubroImprimir'><strong>Rubro:</strong> {{medioRubro}}</p>",
		"<p><strong>Zona de comercializaci&oacute;n:</strong> {{zonasComercializacion aviso.zonasComercializacion}}</p>",
		"<p><strong>Tipo de operaci&oacute;n:</strong> {{tipoOperacion}}</p>",
		"<p><strong>Tama&ntilde;o:</strong> {{lineasAviso}} l&iacute;nea/s</p>",
		"{{#if tieneOrdenamientos }}",
			"<p><strong>Ordenamientos:</strong> {{ordenamientos}} </p>",
		"{{/if}}",
		"<p><strong>Publica el:</strong></p>",
		"<div class='listaFechasYEstados'>",
		"{{#each conceptosWrapper}}",
			"{{#each wrapperAvisos}}",
				"<ul class='fechaAvisosImprimir'>",
					"<li class='fechaPublicacionText'><p>{{fechaPublicacionDiaSemana aviso.fechaPedidoPublicacion}}</p></li>",
				"</ul>",
				"<ul class='estadosAvisosImprimir'>",
					"<li><p id='mensajeEstado'>({{traduccionEstado aviso mapEstados transaccionActual}})<span class='ico-ayuda' title='{{traduccionPopOver aviso mapEstados transaccionActual}}' data-toggle='tooltip' data-placement='top'></span></p></li>",
				"</ul>",
			"{{/each}}",
		"{{/each}}",
		"</div>",
		"{{#if mensajePago }}",
			"<p class='pagadoEl'><strong>Pagado el:</strong> {{fechaPublicacionDiaSemana fechaPago}}</p>",
		"{{/if}}",
		"<div class='clearfix'><!-- --></div>",
	"</div>",
	"<div class='divPrecioFinal'>",
		"<h3 class='subTitAviso'>Datos de la tarifa</h3>",
		"<div>",
			"{{#if tienePromociones }}",
				"<p><span class='tarifa-label'>{{lineasAviso}} l&iacute;nea/s: </span>$ {{montoTotalFinalSinPromo}}&nbsp; <span class='ivaIncluido'>I.V.A. Incluido</span> </p>",
				"{{#each promocionesDescuentos}}",
					"<p><span class='tarifa-label'>{{promocionDescripcion}}: </span>$ {{format promocionDescuento}}&nbsp;</span></strong> <span class='ivaIncluido'>I.V.A. Incluido</span> </p> ",
				"{{/each}}",
			"{{/if}}",
			"<span class='tarifa-label'>Total: </span>$ {{montoTotalFinal}}&nbsp;</span></strong> <span class='ivaIncluido'>I.V.A. Incluido</span>",
		"</div>",
	"</div>",
	"<div class='imagenAviso'>",
		"<img id='imgPreview' src='data:image/jpeg;base64,{{imgAviso}}'>",
	"</div>",
].join("\n");


/*********************************************************
 * Helpers
 *********************************************************/

MisAvisosHelpers = {};

MisAvisosHelpers.fechaPublicacion = function(fechaPublicacionTimestamp){
	var out = "";
	var fechaPublicacionDate = new Date(fechaPublicacionTimestamp);
	var meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];

	out = fechaPublicacionDate.getDate()+" de "+meses[fechaPublicacionDate.getMonth()]+" de "+fechaPublicacionDate.getFullYear();

	return new Handlebars.SafeString(out);
};

MisAvisosHelpers.fechaPublicacionDiaSemana = function(fechaPublicacionTimestamp){
	var out = "";
	var fechaPublicacionDate = new Date(fechaPublicacionTimestamp);
	var meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
	var dias  = ["Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"];
	out = dias[fechaPublicacionDate.getDay()]+" "+fechaPublicacionDate.getDate()+" de "+meses[fechaPublicacionDate.getMonth()]+" de "+fechaPublicacionDate.getFullYear();

	return new Handlebars.SafeString(out);
};

MisAvisosHelpers.zonasComercializacion = function(zonasComercializacionArray){
	var out = "";
	for(var i=0; i<zonasComercializacionArray.length; i++){
		if(out != ""){
			out = out + " + ";
		}
		out = out + zonasComercializacionArray[i].descripcion;
	}

	return new Handlebars.SafeString(out);
};

MisAvisosHelpers.traduccionEstado = function(aviso, mapEstados, transaccionActual){

	var estadoAviso = aviso.estado;
	for(var i=0; i<mapEstados.length; i++){
		if(estadoAviso == mapEstados[i].estado){

			if(estadoAviso != EstadoAviso.PENDIENTE_PAGO && estadoAviso != EstadoAviso.DERIVADO_PUBLICACION){
				return mapEstados[i].traduccionEstado;
			}else if(estadoAviso == EstadoAviso.PENDIENTE_PAGO){
				if(transaccionActual.estado == EstadoGWPTransaccion.PENDIENTE_CONFIRMACION){
					return mapEstados[i].traduccionEstadoGWPPendiente;
				}
				if(transaccionActual.estado == EstadoGWPTransaccion.CANCELADO){
					return mapEstados[i].traduccionEstadoGWPRechazado;
				}
				if(transaccionActual.estado == EstadoGWPTransaccion.NO_RECIBIDO){
					return mapEstados[i].traduccionEstadoGWPSinRespuesta;
				}
				if(transaccionActual.estado == EstadoGWPTransaccion.ERROR){
					return mapEstados[i].traduccionEstadoGWPPendiente;
				}
				return estadoAviso;	//NUNCA SE DARIA...
			}else if(estadoAviso == EstadoAviso.DERIVADO_PUBLICACION){
				var fechaPublicacion = new Date(aviso.fechaPedidoPublicacion);
				var fechaHoy = new Date();
				if(fechaPublicacion < fechaHoy){
					return mapEstados[i].traduccionEstadoFechaMenor;
				}
				if(fechaPublicacion >= fechaHoy){
					return mapEstados[i].traduccionEstadoFechaMayor;
				}
			}

		}
	}
};

//este helper hace lo mismo que el de traduccion estado solo que devuelve un string distinto que es el explica al estado
MisAvisosHelpers.traduccionPopOver = function(aviso, mapEstados, transaccionActual){

	var estadoAviso = aviso.estado;
	for(var i=0; i<mapEstados.length; i++){
		if(estadoAviso == mapEstados[i].estado){

			if(estadoAviso != EstadoAviso.PENDIENTE_PAGO && estadoAviso != EstadoAviso.DERIVADO_PUBLICACION){
				return mapEstados[i].descPopOver;
			}else if(estadoAviso == EstadoAviso.PENDIENTE_PAGO){
				if(transaccionActual.estado == EstadoGWPTransaccion.PENDIENTE_CONFIRMACION){
					return mapEstados[i].descPopOverGWPPendiente;
				}
				if(transaccionActual.estado == EstadoGWPTransaccion.CANCELADO){
					return mapEstados[i].descPopOverGWPRechazado;
				}
				if(transaccionActual.estado == EstadoGWPTransaccion.NO_RECIBIDO){
					return mapEstados[i].descPopOverGWPSinRespuesta;
				}
				if(transaccionActual.estado == EstadoGWPTransaccion.ERROR){
					return mapEstados[i].descPopOverGWPPendiente;
				}
				return estadoAviso;	//NUNCA SE DARIA
			}else if(estadoAviso == EstadoAviso.DERIVADO_PUBLICACION){
				var fechaPublicacion = new Date(aviso.fechaPedidoPublicacion);
				var fechaHoy = new Date();
				if(fechaPublicacion < fechaHoy){
					return mapEstados[i].descPopOverFechaMenor;
				}
				if(fechaPublicacion >= fechaHoy){
					return mapEstados[i].descPopOverFechaMayor;
				}
			}

		}
	}
};

//este helper chequea el estado del aviso y devuele si aplica o no
MisAvisosHelpers.ifHabilitarRepublicarAviso = function(estadoAviso, options){
	/*
	//apagado Republicar - vdenicolo 25/072016
//	if(estadoAviso === EstadoAviso.DERIVADO_PUBLICACION){
//		return options.fn(this);
//	}
	*/
	return options.inverse(this);
	
};

//este helper chequea el estado del aviso y devuele si aplica o no
MisAvisosHelpers.ifHabilitarBotonEditar = function(orden, options){

	//aca no debe ir false
	//vdenicolo 11/07/2016 SFHUB-7885
	return options.inverse(this);

	/* MDN --- se apaga el boton 07072015

	// CASO IMPAGO.
	var avisosPendientesDePago = $.grep(orden.avisos, function (aviso, index){
		if (aviso.estado === EstadoAviso.PENDIENTE_PAGO){
			return options.fn(this);
		}
	});

	if ($.isArray(avisosPendientesDePago) &&  avisosPendientesDePago.length === orden.avisos.length){
		if (orden.transaccionActual.estado !== EstadoGWPTransaccion.PENDIENTE_CONFIRMACION &&
				orden.transaccionActual.estado !== EstadoGWPTransaccion.ERROR){
			return options.fn(this);
		}
	}

	// CASO PAGO/GRATUITO.
	var avisosNoPublicados = $.grep(orden.avisos, function (aviso, index){
		if (aviso.estado === EstadoAviso.PENDIENTE_PUBLICACION ||
			aviso.estado === EstadoAviso.SIN_AUTORIZAR){
			return options.fn(this);
		}
	});

	if ($.isArray(avisosNoPublicados) &&  avisosNoPublicados.length === orden.avisos.length){
		if (orden.transaccionActual.estado === EstadoGWPTransaccion.ACREDITADO){
			return options.fn(this);
		}
	}

	return options.inverse(this);
	*/
};

