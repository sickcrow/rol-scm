/**
 * author: adifiore
 * version: 1.0.0
 * require: model-dto.js
 * description: Clase que contiene los datos del modelo necesarios para el modulo crear-aviso.
 */
var crearAvisosModel = (function () {

	// private interface ----------------------------

	var codigoCanalEntrada					= "ROL";
	var codigoNivelEstructura				= null;
	var codigoNivelEstructuraDestaque		= null;
	var codigoAgrupamientoProductoTecnico   = "LINEAL";
	var tipoOperacion						= null;	// TipoOperacionDTO
	var codigoProducto						= null;
	var codigoProductoComercial				= null;
	var codigoProductoComercialDestaque		= null;
	var codigoTemplateDetallado				= null;
	var familia								= null; // FamiliaDTO
	var clase								= null; // ClaseDTO
	var zonasComercializacion				= [];
	var ordenamientos						= [];
	var configuracionesOrdenamientoPantalla = null; // ConfiguracionOrdenamientoPantallaDTO
	var caracteresInvalidos					= null;
	var serverTime							= null;
	var selectedDates						= [];
	var controlarHorarioCierre				= true;
	var idItemPromocion						= null;
	var palabrasProhibidas					= null;
	var mapItemsOrdenamientoCombo			= {};
	var step								= 0;
	var previsualizo						= false;
	var tarjetas							= [];
	var imagenes							= [];
	var codigoGATEWAYSeleccionado			= null;
	var templatesDetallado					= [];
	var tienePictoSeleccionado				= null;
	var tieneFondoColor						= null;
	var tieneMaterial						= null;
	var permisoAtributoEmail				= null;
	var permisoAtributoTelefono				= null;
	var codigoTemplateDestaqueSeleccionado	= null;
	var codigoImagenDestaqueSeleccionada	= null;
	var repoImagenDestaqueSeleccionada		= null;
	var ordenDepublicacionHistory			= null;
	var configuracionesPromocionPantalla	= [];
	var promociones							= [];
	var materiales							= [];
	var agrupadoresAtributoAviso			= arrayUtils.buildArrayObjFromJSON([], AgrupadorAtributoAvisoDTO);
	var tarjeta365							= null;
	var ordenDePublicacion					= {
												"presupuestada": false,
												"procesada": true,
												"telefono" : "",
												"tipoDocumento": {
													"codigo": "96"
												},
												"domicilio" : {
													"localidad": "CAPITAL FEDERAL",
													"provincia": "CAPITAL FEDERAL",
													"pais": "ARGENTINA"
												},
												"codigoMedioDePago": "TARJETA",
												"codigoTipoTarjeta": "VISA",
												"tipoIVA": {
													"codigo": "CONSUMIDOR_FINAL"
												},
												"conceptosVendibles": [{
													"descripcion": "Automotores > Auto > Venta - Papel > Clasificados Clarin > Lineal > Autom�viles Nacionales e Importados, Autos de Colecci�n. > Automoviles Nacionales e Importados",
													"fechaTarifa": 1373555461206,
													"prefacturado": false,
													"tipoMoneda": {
														"codigo": "ARS"
													},
													"acciones": [],
													"porcentajeIVA": 0,
													"montoSinIVA": 0,
													"montoIVA": 0,
													"montoPercepcion": 0,
													"montoTotal": 0,
													"itemsConceptoVendible": [{
														"numero": 0,
														"itemsAviso": [{
															"numero": 0,
															"aviso": {
																"tipo": "LINEAL",
																"fechaPedidoPublicacion": null,
																"fechaUltimaModificacion": 0,
																"incompleto": false,
																"bloqueado": false,
																"facturable": true,
																"tipoOperacion": {
																	"codigo": null
																},
																"productoComercial": null,
																"templateDetallado": {
																	"codigo": null
																},
																"materiales": [],
																"codigoFamilia": null,
																"codigoClase": null,
																"atributosAviso" : [],
																"nivelEstructura": null,
																"altoPuntosTipograficos": null,
																"zonasComercializacion": [],
											                    "ordenamientos": [],
																"lineasFacturadas": null,
																"textoLibre": null,
																"textoJustificado": null,
																"textoLibreTemplate" : null,
																"textoLibreJustificado" : null,
																"avisoPromocion" : []
															}
														}]
													}]
												}],
												"capturador": {
													"tipo": "ANUNCIANTE",
													"codigoCliente": "ROL",
													"codigoAnunciante": 300
												},
												"usuarioExterno": null,
												"trackCampana": null

											};
											// Fin ordenDePublicacion -----

	// public interface ----------------------------

	return {

		// CodigoAgrupamientoProductoTecnico ----------

		setCodigoAgrupamientoProductoTecnico : function(_codigoAgrupamientoProductoTecnico){
			codigoAgrupamientoProductoTecnico = _codigoAgrupamientoProductoTecnico;
		},

		getCodigoAgrupamientoProductoTecnico : function(){
			return codigoAgrupamientoProductoTecnico;
		},

		// CodigoFamilia --------------

		setFamilia : function(_familia){
			familia = _familia;
		},

		getFamilia : function(){
			return familia;
		},

		// Clase ----------------

		setClase : function(_clase){
			clase = _clase;
		},

		getClase : function(){
			return clase;
		},

		// Ordenamientos ----------------

		setOrdenamientos : function(_ordenamientos){
			ordenamientos = _ordenamientos;
		},

		getOrdenamientos : function(){
			return ordenamientos;
		},

		// CodigoProducto ----------------

		setCodigoProducto : function(_codigoProducto){
			codigoProducto = _codigoProducto;
		},

		getCodigoProducto : function(){
			return codigoProducto;
		},

		// CodigoProductoComercial ----------------

		setCodigoProductoComercial : function(_codigoProductoComercial){
			codigoProductoComercial = _codigoProductoComercial;
		},

		getCodigoProductoComercial : function(){
			return codigoProductoComercial;
		},

		//CodigoProductoComercialDestaque-----------
		setCodigoProductoComercialDestaque : function(_codigoProductoComercialDestaque){

			codigoProductoComercialDestaque = _codigoProductoComercialDestaque;
		},

		getCodigoProductoComercialDestaque : function(){
			return codigoProductoComercialDestaque;
		},

		// CodigoTemplateDetallado ----------------

		setCodigoTemplateDetallado : function(_codigoTemplateDetallado){
			codigoTemplateDetallado = _codigoTemplateDetallado;
		},

		getCodigoTemplateDetallado : function(){
			return codigoTemplateDetallado;
		},

		// TipoOperacion ----------------

		setTipoOperacion : function(_tipoOperacion){
			tipoOperacion = _tipoOperacion;
		},

		getTipoOperacion : function(){
			return tipoOperacion;
		},

		// CodigoCanalEntrada ----------------

		setCodigoCanalEntrada : function(_codigoCanalEntrada){
			codigoCanalEntrada = _codigoCanalEntrada;
		},

		getCodigoCanalEntrada : function(){
			return codigoCanalEntrada;
		},

		// SelectedDates ----------------

		setSelectedDates : function(_selectedDates){
			selectedDates = _selectedDates;
		},

		getSelectedDates : function(){
			return selectedDates;
		},

		// CodigoNivelEstructura ----------------

		setCodigoNivelEstructura : function (_codigoNivelEstructura){
			codigoNivelEstructura = _codigoNivelEstructura;
		},

		getCodigoNivelEstructura : function (){
			return codigoNivelEstructura;
		},

		//CodigoNivelEstructura ----------------

		setCodigoNivelEstructuraDestaque : function (_codigoNivelEstructuraDestaque){
			codigoNivelEstructuraDestaque = _codigoNivelEstructuraDestaque;
		},

		getCodigoNivelEstructuraDestaque : function (){
			return codigoNivelEstructuraDestaque;
		},

		// FechaVigencia ----------------

		setFechaVigencia : function (_fechaVigencia){
			fechaVigencia = _fechaVigencia;
		},

		getFechaVigencia : function (){
			return fechaVigencia;
		},

		// ControlarHorarioCierre ---------------

		setControlarHorarioCierre : function (_controlarHorarioCierre){
			controlarHorarioCierre = _controlarHorarioCierre;
		},

		getControlarHorarioCierre : function(){
			return controlarHorarioCierre;
		},

		// ZonasComercializacion ---------------

		setZonasComercializacion : function(_zonasComercializacion){
			zonasComercializacion = _zonasComercializacion;
		},

		getZonasComercializacion : function(){
			return zonasComercializacion;
		},

		// IdItemPromocion ---------------

		setIdItemPromocion : function(_idItemPromocion){
			idItemPromocion = _idItemPromocion;
		},

		getIdItemPromocion : function(){
			return idItemPromocion;
		},

		// OrdenDePublicacion ---------------

		getOrdenDePublicacion : function(){
			return ordenDePublicacion;
		},

		setOrdenDePublicacion : function(_ordenDePublicacion){
			ordenDePublicacion = _ordenDePublicacion;
		},

		// ServerTime ---------------

		getServerTime : function(){
			return serverTime;
		},

		setServerTime : function(_serverTime){
			serverTime = _serverTime;
		},

		// Justificacion ---------------

		getJustificacion : function(){
			return justificacion;
		},

		setJustificacion : function(_justificacion){
			justificacion = _justificacion;
		},

		// CaracteresProhibidos ---------------

		getCaracteresInvalidos : function(){
			return caracteresInvalidos;
		},

		setCaracteresInvalidos : function(_caracteresInvalidos){
			caracteresInvalidos = _caracteresInvalidos;
		},

		// PalabrasProhibidas --------------

		getPalabrasProhibidas:function(){
			return palabrasProhibidas;
		},

		setPalabrasProhibidas:function(_palabrasProhibidas){
			palabrasProhibidas=_palabrasProhibidas;
		},

		// ConfiguracionesOrdenamientoPantalla ---------------

		getConfiguracionesOrdenamientoPantalla : function(){
			return configuracionesOrdenamientoPantalla;
		},

		setConfiguracionesOrdenamientoPantalla : function(_configuracionesOrdenamientoPantalla){
			configuracionesOrdenamientoPantalla = _configuracionesOrdenamientoPantalla;
		},

		// MapItemsOrdenamientoCombo ---------------

		getMapItemsOrdenamientoCombo : function(){
			return mapItemsOrdenamientoCombo;
		},

		setMapItemsOrdenamientoCombo : function(_mapItemsOrdenamientoCombo){
			mapItemsOrdenamientoCombo = _mapItemsOrdenamientoCombo;
		},

		// Step ---------------

		getStep : function(){
			return step;
		},

		setStep : function(_step){
			step = _step;
		},

		//previsualizo

		getPrevisualizo : function(){
			return previsualizo;
		},

		setPrevisualizo : function(_previsualizo){
			previsualizo = _previsualizo;
		},

		//tarjetas

		getTarjetas : function(){
			return tarjetas;
		},

		setTarjetas : function(_tarjetas){
			tarjetas = _tarjetas;
		},

		//imagenes

		getImagenes : function(){
			return imagenes;
		},

		setImagenes : function(_imagenes){
			imagenes = _imagenes;
		},

		getCodigoImagenDestaqueSeleccionada :function(){
			return codigoImagenDestaqueSeleccionada;
		},

		setCodigoImagenDestaqueSeleccionada : function(_codigoImagenDestaqueSeleccionada){
			codigoImagenDestaqueSeleccionada =_codigoImagenDestaqueSeleccionada || null;
		},

		getRepoImagenDestaqueSeleccionada : function(){
			return repoImagenDestaqueSeleccionada;
		},

		setRepoImagenDestaqueSeleccionada : function(_repoImagenDestaqueSeleccionada){
			repoImagenDestaqueSeleccionada = _repoImagenDestaqueSeleccionada || null;
		},
		
		getTemplateTienePictoSeleccionado : function(){
			return tienePictoSeleccionado;
		},
		
		setTemplateTienePictoSeleccionado : function(_tienePictoSeleccionado){
			tienePictoSeleccionado = _tienePictoSeleccionado || null;
		},

		setTemplateTieneFondoColor : function(_tieneFondoColor){
			tieneFondoColor = _tieneFondoColor || null;
		},

		setTemplateTieneMaterial : function(_tieneMaterial){
			tieneMaterial = _tieneMaterial || null;
		},

		setContenidoTieneMaterial : function(_contenidoTieneMaterial){
			contenidoTieneMaterial = _contenidoTieneMaterial || null;
		},

		getTemplateTieneFondoColor : function(){
			return tieneFondoColor;
		},

		getTemplateTieneMaterial : function(){
			return tieneMaterial;
		},

		getContenidoTieneMaterial : function(){
			return contenidoTieneMaterial;
		},

		getCodigoGATEWAYSeleccionado :function(){
			return codigoGATEWAYSeleccionado;

		},

		setCodigoGATEWAYSeleccionado :function(_codigoGATEWAYSeleccionado){
			codigoGATEWAYSeleccionado = _codigoGATEWAYSeleccionado;
		},

		setTemplatesDetallado : function (_templatesDetallado){
			templatesDetallado = _templatesDetallado;
		},

		getTemplatesDetallado : function(){
			return templatesDetallado;
		},

		/*getValidacionesMaterial : function(){
			var validacionesMaterial = [{
				"alto" : 71,
				"ancho" : 141,
				"extension" : "jpg",
				"peso" : 5242880 / (1024*1024)
			}];
			return validacionesMaterial;
		},*/

		getCodigoTemplateDestaqueSeleccionado: function(){
			return codigoTemplateDestaqueSeleccionado;
		},

		setCodigoTemplateDestaqueSeleccionado: function(_codigoTemplateDestaqueSeleccionado){
			codigoTemplateDestaqueSeleccionado = _codigoTemplateDestaqueSeleccionado;
		},

		getOrdenDePublicacionHistory: function(){
			return ordenDepublicacionHistory;
		},

		setOrdenDepublicacionHistory: function(_ordenDepublicacionHistory){
			ordenDepublicacionHistory = _ordenDepublicacionHistory;
		},

		setConfiguracionesPromocionPantalla: function(_configuracionesPromocionPantalla){
			configuracionesPromocionPantalla = _configuracionesPromocionPantalla;
		},

		getConfiguracionesPromocionPantalla: function(){
			return configuracionesPromocionPantalla;
		},

		getPromociones : function(){
			return promociones;
		},

		setPromociones : function(_promociones){
			promociones = _promociones;
		},

		getMateriales : function(){
			return materiales;
		},

		setMateriales : function(_materiales){
			materiales = _materiales;
		},

		getPromocionesHastaPantallaSeleccionada : function(indexPantallaSeleccionada){
			var promocionesSeleccionadas = [];
			$.each(promociones, function (index, promocion){
				$.each(configuracionesPromocionPantalla, function (index, configuracionPromocionPantalla){
					if (promocion.codigo === configuracionPromocionPantalla.promocion.codigo &&
							configuracionPromocionPantalla.pantallaShow <= indexPantallaSeleccionada &&(configuracionPromocionPantalla.trigger!==""||configuracionPromocionPantalla.trigger===null)){
						promocionesSeleccionadas.push(promocion);
					}
				});
			});
			return promocionesSeleccionadas;
		},

		getPromocionesAnterioresValidadas : function(indexPantallaSeleccionada){
			var promocionesSeleccionadas = [];
			$.each(promociones, function (index, promocion){
				$.each(configuracionesPromocionPantalla, function (index, configuracionPromocionPantalla){
					if (promocion.codigo === configuracionPromocionPantalla.promocion.codigo &&
							configuracionPromocionPantalla.pantallaShow <indexPantallaSeleccionada&&(configuracionPromocionPantalla.trigger!==""||configuracionPromocionPantalla.trigger===null)){
						promocionesSeleccionadas.push(promocion);
					}
				});
			});
			return promocionesSeleccionadas;
		},

		getPromocionesValidar : function(indexPantallaSeleccionada){
			var promocionesSeleccionadas = [];
			$.each(configuracionesPromocionPantalla, function (index, configuracionPromocionPantalla){
				if(configuracionPromocionPantalla.trigger!==""||configuracionPromocionPantalla.trigger===null){
					if(configuracionPromocionPantalla.pantallaShow <indexPantallaSeleccionada){
						$.each(promociones, function (index, promocion){
							if(promocion.codigo === configuracionPromocionPantalla.promocion.codigo){
								promocionesSeleccionadas.push(promocion);
							}
						});

					}
					if(configuracionPromocionPantalla.pantallaShow == indexPantallaSeleccionada){
						promocionesSeleccionadas.push(configuracionPromocionPantalla.promocion);
					}
					if(configuracionPromocionPantalla.pantallaShow > indexPantallaSeleccionada){
						if ( crearAvisosModel.esOrdenDePublicacionPagoAcreditado() &&
								configuracionPromocionPantalla.promocion.codigo == Promocion365Constants.CODIGO_PROMOCION_365){
							// Chequeo si es la edicion de una orden paga con 365 para que mande en las cotizaciones dicha promo.

							var resultAtributoAvisoPromocion365 = $.grep(crearAvisosModel.getAgrupadoresAtributoAviso(), function (agrupadorAtributoAviso, index){
								return agrupadorAtributoAviso.atributoAviso.codigo == Promocion365Constants.CODIGO_ATRIBUTO_PROMOCION_365;
							});
							// Me fijo en los atributos de aviso, ya que las promociones segun navegabilidad se limpian.
							if (resultAtributoAvisoPromocion365.length > 0){
								configuracionPromocionPantalla.promocion.seleccion = true;
								promocionesSeleccionadas.push(configuracionPromocionPantalla.promocion);
							}
						}
					}
				}
			});

			return promocionesSeleccionadas;
		},

		//Recibe la promocion a agregar
		addPromocion : function(args){
			var distinto = true;
			$.each(promociones, function(indexPromociones, promocionModel){
				if (promocionModel.codigo === args.promocion.codigo ) {
					distinto = false;
					return;
				}
			});
			if (distinto){
				promociones.push(args.promocion);
			}
       	},

		getAgrupadoresAtributoAviso : function(){
			return agrupadoresAtributoAviso;
		},

		setAgrupadoresAtributoAviso : function(_agrupadoresAtributoAviso){
			agrupadoresAtributoAviso = _agrupadoresAtributoAviso;
		},

		getAtributosAvisoHastaPantallaSeleccionada : function(indexPantallaSeleccionada){
			var atributosAviso = [];
			$.each(agrupadoresAtributoAviso, function (index, agrupadorAtributoAviso){
				if (agrupadorAtributoAviso.step <= indexPantallaSeleccionada){
					atributosAviso.push(agrupadorAtributoAviso.atributoAviso);
				}
			});
			return atributosAviso;
		},

		esOrdenDePublicacionPersistida : function(){
			return (ordenDePublicacion.id != null) ? true : false;
		},

		esOrdenDePublicacionPagoAcreditado : function(){
			return (ordenDePublicacion.transaccionActual != undefined &&
						ordenDePublicacion.transaccionActual.estado == EstadoGWPTransaccion.ACREDITADO);
		},

		getTarjeta365 : function(){
			return tarjeta365;
		},

		setTarjeta365 : function(_tarjeta365){
			tarjeta365 = _tarjeta365;
		},

		getPermisoAtributoEmail : function (){
			return permisoAtributoEmail;
		},

		setPermisoAtributoEmail : function (_permisoAtributoEmail){
			permisoAtributoEmail = _permisoAtributoEmail;
		},

		getPermisoAtributoTelefono : function (){
			return permisoAtributoTelefono;
		},

		setPermisoAtributoTelefono : function (_permisoAtributoTelefono){
			permisoAtributoTelefono = _permisoAtributoTelefono;
		}

	}

})();
