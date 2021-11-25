/**
 * author: adifiore
 * version: 1.0.0
 * require: handlebars.js | data-utils.js
 * description: Clase placeholder para Templates y Helpers de componentes UI.
 */
CrearAvisosTemplates = {};

/*********************************************************
 * Templates
 *********************************************************/

//Muestra las familias de productos que se pueden publicar en clasificados-------
CrearAvisosTemplates.familias = [
 	"<div id='divCategoria' data-toggle='popover' data-html='true' data-placement='bottom' data-content='&lt;button class=&quot;close&quot; onclick=&quot;gOnclickClosePopoverCategoria();&quot; &gt;&times;&lt;/button&gt; &iquest;A cu&aacute;l de estas categor&iacute;as corresponde lo que quer&eacute;s publicar?'>",
		"<div id='filtoBusquedaWrapper' class='buscadorPaso'>",
			"<input id='inputFilterCategorias' onkeyup='gOnkeyupFilterItemsHandler(event)' data-id-lista='listaCategorias' type='search' placeholder='Buscar categor&iacute;a...' class='inputBuscadorPaso' />",
			"<input type='submit' class='btnBuscadorPaso' value='Buscar'>",
			"<span class='highlight'></span>",
			"<span class='bar'></span>",
			"<label for='inputFilterCategorias'>Buscar</label>",
		"</div>",
		"<div id='div-categorias'>",
			"<ul id='listaCategorias' class='lista-items'>",
				"{{#each familias}}",
					"<li><div id='categoria-{{codigo}}' title='{{descripcion}}' onclick='gOnclickSeleccionarCategoriaHandler(this)' class='btn genericBtn' data-codigo-clase='{{codigo}}' data-descripcion-clase='{{descripcion}}'><span>{{descripcion}}</span></div></li>",
				"{{/each}}",
			"</ul>",
		"</div>",
	"</div>",
].join("\n");

//Construye la caja de una categoria/familia seleccionada--------------------------------
CrearAvisosTemplates.categoriaSeleccionada = [
	"<div id='categoriaSeleccionada' title='{{descripcion}}' onclick='gOnclickDeseleccionarCategoriaHandler(this)' class='btn genericBtn' draggable='true'>",
		"<span>{{descripcion}}</span>",
	"</div>"
].join("\n");

//Construye la caja de un bien/clase seleccionado--------------------------------------
CrearAvisosTemplates.bienSeleccionado = [
	"<div id='bienSeleccionado' title='{{descripcion}}' onclick='gOnclickDeseleccionarBienHandler(this)' class='btn genericBtn' draggable='true'>",
		"<span>{{descripcionBien}}</span>",
	"</div>"
].join("\n");

//Construye la caja de un item seleccionads para mostrar en el panel lateral --------------------------------
CrearAvisosTemplates.itemLeftPanel = [
	"<div class='itemLeftPanel'>",
		"<span class='itemDescription'>{{descripcion}}</span>",
	"</div>"
].join("\n");

//Muestra los bienes correspondientes a la falimilia seleccionada----------------
CrearAvisosTemplates.bienes = [
	"<div id='divBien'>",
		"<div id='filtoBusquedaWrapper' class='buscadorPaso'>",
			"<input id='inputFilterBienes' onkeyup='gOnkeyupFilterItemsHandler(event)' data-id-lista='listaBienes' type='search' placeholder='Buscar bien...' class='inputBuscadorPaso' />",
			"<input type='submit' class='btnBuscadorPaso' value='Buscar'>",
			"<span class='highlight'></span>",
			"<span class='bar'></span>",
			"<label for='inputFilterBienes'>Buscar</label>",
			"<div class='clearfix'></div>",
		"</div>",
		"<div id='div-bienes'>",
			"<ul id='listaBienes' class='lista-items'>",
				"{{#each bienes}}",
					"<li><div id='bien-{{codigo}}' title='{{descripcion}}' onclick='gOnclickSeleccionarBienHandler(this)' class='btn genericBtn' data-codigo-clase='{{codigo}}' data-descripcion-clase='{{descripcion}}' data-descripcion-trim='{{descripcion-bien}}'><span>{{descripcion-bien}}</span></div></li>",
				"{{/each}}",
			"</ul>",
		"</div>",
	"</div>",
].join("\n");

// Muestra los tipo de operaciones correspondientes al bien seleccionado---------
CrearAvisosTemplates.tiposOperacion = [
	"<div id='divOperacion'>",
		"<div id='filtoBusquedaWrapper' class='buscadorPaso'>",
			"<input id='inputFilterOperaciones' onkeyup='gOnkeyupFilterItemsHandler(event)' data-id-lista='listaOperaciones' type='search' placeholder='Buscar operaci&oacute;n...' class='inputBuscadorPaso' />",
			"<input type='submit' class='btnBuscadorPaso' value='Buscar'>",
			"<span class='highlight'></span>",
			"<span class='bar'></span>",
			"<label for='inputFilterBienes'>Buscar</label>",
			"<div class='clearfix'></div>",
		"</div>",
		"<div id='ordenamientos-paso'>",
			"<ul id='listaOperaciones' class='lista-items'>",
			    "{{#each tiposOperacion}}",
					"<li><div id='operacion-{{codigo}}' title='{{descripcion}}' onclick='gOnclickSeleccionarTipoOperacionHandler(this)' data-codigo-operacion='{{codigo}}' data-descripcion-clase='{{descripcion}}' data-descripcion-operacion='{{descripcion}}' class='btn genericBtn itemOrdenamientoASeleccionar' draggable='true'><span>{{descripcion}}</span></div></li>",
			    "{{/each}}",
		    "</ul>",
	    "</div>",
    "</div>",
].join("\n");

//Construye la caja de un tipo de operacion seleccionado
CrearAvisosTemplates.tipoOperacionSeleccionada = [
    "<div id='tipoOperacionSeleccionada' title='{{descripcion}}' onclick='gOnclickDeseleccionarTipoOperacionHandler(this)' class='btn genericBtn' draggable='true'>",
 		"<span>{{descripcion}}</span>",
 	"</div>"
].join("\n");

//Muestra el calendario con los dias seleccionados ------------------------------
CrearAvisosTemplates.selectedDate = [
    "{{#each selectedDates}}",
    	"<div id='diasSelectWrapper' onclick='gOnclickQuitarFechaHandler(this)' data-fecha='{{this}}'>",
        	"<div>",
        		"<span class='mesSelect'>{{mes}}</span>",
        		"<span class='diaSelect'>{{dia}}</span>",
        	"</div>",
        "</div>",
    "{{/each}}"
].join("\n");

CrearAvisosTemplates.selectedDateNoEditable = [
	"{{#each selectedDates}}",
    	"<div id='diasSelectWrapper' data-fecha='{{this}}'>",
        	"<div>",
         		"<span class='mesSelect'>{{mes}}</span>",
         		"<span class='diaSelect'>{{dia}}</span>",
         	"</div>",
         "</div>",
     "{{/each}}"
 ].join("\n");

// Muestra las letras y los ordenamientos asociados a cada letra ----------------

CrearAvisosTemplates.indiceItemsOrdenamientos = [
	//"<h4 class='pull-left'>Seleccion&aacute; {{nombreOrdenamiento}}:</h4>",
	//"<div class='clearfix'></div>",
	"<div id='filtoBusquedaWrapper' class='buscadorPaso'>",
		"<input id='inputFilterOrdenamientos' onkeyup='gOnkeyupFilterOrdenamientosHandler(event)' data-id-lista='listaCategorias' type='search' placeholder='Buscar...' class='inputBuscadorPaso' />",
		"<input type='submit' class='btnBuscadorPaso' value='Buscar'>",
		"<span class='highlight'></span>",
		"<span class='bar'></span>",
		"<label for='inputFilterCategorias'>Buscar</label>",
	"</div>",

//	"<div id='filtoBusquedaWrapper'>",
//		"<label class='pull-left'>Buscar</label><input id='inputFilterOrdenamientos' onkeyup='gOnkeyupFilterOrdenamientosHandler(event)' type='search' class='pull-left'/>",
	//	"<div class='clearfix'></div>",
	"</div>",
    "<div id='ordenamientos-paso'>",
	    "{{#each agrupadoresItemsOrdenamiento}}",
	    	"<div class='indiceItemsOrdenamientos'>",
	    		"<h4 id='indice-{{indice}}'><span>{{indice}}</span></h4>",
				"<ul class='itemsOrdenamiento lista-items'>",
					"{{#each itemsOrdenamiento}}",
						"<li><div id='{{id}}' title='{{descripcion}}' onclick='gOnclickSelectOrdenamientoHandler(this)' data-id-ordenamiento-aviso='{{idOrdenamientoAviso}}' data-valor='{{valor}}' data-descripcion='{{descripcion}}' data-codigo-busqueda='{{codigoBusqueda}}' class='btn genericBtn itemOrdenamientoASeleccionar capitalize' draggable='true'><span>{{nombre-item-ordenamiento}}</span></div></li>",
					"{{/each}}",
				"</ul>",
			"</div>",
	    "{{/each}}",
	"</div>",
].join("\n");

// Muestra la caja con el ordenamiento a seleccionar ----------------------------

CrearAvisosTemplates.ordenamientoASeleccionar = [
	"<div id='{{id}}' data-ordenamiento-a-seleccionar-codigo='{{codigo}}' data-ordenamiento-a-seleccionar-obligatorio='{{obligatorio}}' class='CatBox'>",
		"<span class='inner-desc'>{{nombre-ordenamiento}}</span>",
	"</div>"
].join("\n");

//Construye la caja para agregar entre los ordenamientos seleccionados ----------
CrearAvisosTemplates.itemOrdenamientoSeleccionado = [
    "<div id='{{id}}' title='{{descripcion}}' onclick='gOnclickDeselectOrdenamientoHandler(this)' data-item-ordenamiento-seleccionado-id-ordenamiento-aviso='{{idOrdenamientoAviso}}' data-item-ordenamiento-seleccionado-valor='{{valor}}' data-item-ordenamiento-seleccionado-descripcion='{{descripcion}}' data-item-ordenamiento-seleccionado-codigo-busqueda='{{codigoBusqueda}}' class='genericBtn itemOrdenamientoSeleccionado capitalize' draggable='true'>",
 		"<span class='inner-desc-seleccionado'>{{nombre-item-ordenamiento}}</span>",
 	"</div>"
].join("\n");


//Construye el componente para un ordenamiento de tipo combo --------------------
CrearAvisosTemplates.ordenamientoLista = [
	"{{#if dataProvider.ordenamiento.ocultarValorUnico}}",
		"<div class='itemOrdenamientoOculto'>",
	"{{else}}",
		"<div class='itemOrdenamiento'>",
	"{{/if}}",
		"<label id='codigoOrdenamiento-{{dataProvider.ordenamiento.id}}' for='ordenamiento-{{dataProvider.ordenamiento.id}}'>",
		//"<span id='codigoOrdenamiento-{{dataProvider.ordenamiento.id}}' class='pull-left labelforCombo' >",
			"{{dataProvider.ordenamiento.codigo}}",
			"{{#if dataProvider.ordenamiento.obligatorio}}",
				"<small style='color:#f00;'>*</small>",
			"{{/if}}",
			"<span class='ico-ayuda' title='{{dataProvider.ordenamiento.descAyuda}}' data-placement='top'></span>",
		"</label>",
		//"<div id='myCombobox' class='input-append dropdown combobox pull-left'>",
		"<div id='myCombobox' class=''>",
			"<select id='ordenamiento-{{dataProvider.ordenamiento.id}}' class='ordenamientoDinamico select' onchange='gOnchangeCargarItemsOrdenamientoHijoHandler(this)' data-tipo='LISTA' data-id-ordenamiento='{{dataProvider.ordenamiento.id}}' data-obligatorio='{{dataProvider.ordenamiento.obligatorio}}' data-ordenamiento='{{dataProvider.ordenamiento.codigo}}' data-id-padre='{{dataProvider.ordenamiento.idPadre}}' data-items ='{{dataProvider.itemsOrdenamiento}}' style='width: 100%;'>",
				"<option></option>",
				"{{#each dataProvider.itemsOrdenamiento}}",
					"<option value='{{valor}}' data-codigo-busqueda='{{codigoBusqueda}}' data-descripcion='{{descripcion}}' >{{descripcion}}</option>",
			    "{{/each}}",
			"</select>",
		"</div>",
		"<span id='validacion-{{dataProvider.ordenamiento.id}}' class='validacion'>{{dataProvider.ordenamiento.descValidacion}}</span>",
	"</div>"
].join("\n");


//Construye el componente para un ordenamiento de tipo texto --------------------
CrearAvisosTemplates.ordenamientoTexto = [
"<div class='itemOrdenamiento'>",
	"<label for='ordenamiento-{{ordenamientoAviso.id}}' id='codigoOrdenamiento-{{ordenamientoAviso.id}}' class='labelforTextbox'>",
		"{{ordenamientoAviso.codigo}}",
		"{{#if ordenamientoAviso.obligatorio}}",
			"<small style='color:#f00;'>*</small>",
		"{{/if}}",
		"<span class='ico-ayuda' title='{{ordenamientoAviso.descAyuda}}' data-placement='top'></span>",
	"</label>",
	"<input id='ordenamiento-{{ordenamientoAviso.id}}' class='ordenamientoDinamico textbox' type='text' data-tipo='TEXTO' data-ordenamiento='{{ordenamientoAviso.codigo}}' data-validacion='{{ordenamientoAviso.validacion}}' data-id-ordenamiento='{{ordenamientoAviso.id}}' data-obligatorio='{{ordenamientoAviso.obligatorio}}' data-formato ='{{ordenamientoAviso.formato}}' onkeyup='gOnkeyupOrdenamientoTextoHandler(event)'/>",
	"<span id='validacion-{{ordenamientoAviso.id}}' class='validacion'>{{ordenamientoAviso.descValidacion}}</span>",
	"</div>"
].join("\n");


//Construye el componente de una option para el ordenamiento combo --------------
CrearAvisosTemplates.itemOrdenamiento = [
	"{{#each itemsOrdenamiento}}",
		"<option value='{{valor}}' data-codigo-busqueda='{{codigoBusqueda}}' data-descripcion='{{descripcion}}' >{{descripcion}}</option>",
	"{{/each}}"
].join("\n");

CrearAvisosTemplates.productoZonasNiveles = [
	"{{#each agrupadoresProductoZonasNiveles}}",
		"<div class='MedioRubroInnerWrapper agrupadorProductoZonasNiveles'>",
			"<div class='medioPopover'></div>",
			"<div class='zonasComercializacion'>",
				"<h5 id='{{producto.codigo}}' data-producto-codigo='{{producto.codigo}}' data-producto-tipo='{{producto.tipo}}' data-producto-descripcion='{{producto.descripcion}}' class='productoAgrupador'>",
					"{{producto.descripcion}}<br><span>Publica en:</span>",
				"</h5>",
				"<div class='bloqueZonas'>",
					"{{#each zonasComercializacion}}",
						"<div class='divZonaComercializacion' data-zona-descripcion='{{descripcion}}'>",
						"<input id='{{codigo}}' data-zona-comercializacion-codigo='{{codigo}}' data-zona-comercializacion-descripcion='{{descripcion}}' class='pull-left checkRubro css-checkbox' type='checkbox' onclick='gOnchangeZonaComercializacionHandler(event)'/>",
						"<label for='{{codigo}}' class='css-label label-zona'>",
							"{{descripcion}}",
						"</label>",
						"</div>",
					"{{/each}}",
				"</div>",
				"<div class='bloqueNiveles'>",
					"<div class='input-append dropdown combobox nivelesEstructura' id='selectRubro'>",
						"<select class='selectRubroPaso2' id='select-{{producto.codigo}}' onchange='gOnchangeNivelEstructuraHandler(event)' style='width:100%'>",
							"<option></option>",
							"{{#each agrupadoresProductoComercialNivel}}",
								"<option data-nivel-estructura-codigo='{{nivelEstructura.codigo}}' data-nivel-estructura-tipo='{{nivelEstructura.tipo}}' data-nivel-estructura-descripcion='{{nivelEstructura.descripcion}}' data-producto-comercial-codigo='{{productoComercial.codigo}}' data-producto-comercial-tipo='{{productoComercial.tipo}}'>",
									"{{nivelEstructura.descripcion}}",
								"</option>",
							"{{/each}}",
						"</select>",
					"</div>",
				"</div>",
			"</div>",
			"<div class='clearfix'><!-- Empty --></div>",
		"</div>",
	"{{/each}}"
].join("\n");

CrearAvisosTemplates.textoAviso = [
    "<div class='paso6-TitlePublicacion'>{{textoAviso}}",
    "</div>"
].join("\n");

CrearAvisosTemplates.zonasPublicacion = [
    "{{#each avisos}}",
    "<div class='paso6-itemWrapperDondePublicar'>",
		"<h5>{{productoComercial.producto.descripcion}}</h5>",
		"{{#each zonasComercializacion}}",
			"<p class='bolder'>{{descripcion}}</p>",
		"{{/each}}",
		"<p>Rubro: {{nivelEstructura.descripcion}}</p>",
		"</div>",
	"{{/each}}"
].join("\n");

CrearAvisosTemplates.desglosePromociones = [
    "<ul class='desgLabels pull-left'>",
		"<li class='desgLabelPrecioSinPromo desglose' id='lblPrecioSinPromo' style='display: none;'>Precio:</li>",
		//"<li class='desgLabelDescuentos desglose' id='lblDescuentos' style='display: none; hidden;'>Descuentos:</li>",
		"{{#each avisosPromociones}}",
			"<li class='desgLabel-{{promocion.codigo}} desglose' id='lbl{{promocion.codigo}}' style='display: none;'>   {{promocion.descripcion}}",
		"{{/each}}",

	"</ul>",
	"<ul class='desgPrecios pull-right'>",
		"<li class='desgPrecioSinPromo desglose' style='display: none;'>$ <span id='valorSinPromo'> {{montoTotalSinPromo}}<!-- Empty --></span></li>",
		"{{#each avisosPromociones}}",
			"{{#if esDescuento}}",
				"<li class='desgMontoDePromo-{{promocion.codigo}} desglose precioConDescuento' style='display: none;'>$ <span id='valorPromo{{promocion.codigo}}'>-{{montoConIva}} </span></li>",
			"{{else}}",
				"<li class='desgMontoDePromo-{{promocion.codigo}} desglose' style='display: none;'>$ <span id='valorPromo{{promocion.codigo}}'>+{{montoConIva}} </span></li>",
			"{{/if}}",
		"{{/each}}",
	"</ul>",
	"<ul class='desgTotal pull-left'>",
		"<li class='desgLabelPrecioTotal' id='lblPrecioTotal' >Total:</li>",
	"</ul>",
	"<ul class='desgTotalPrecio pull-right'>",
		"<li class='desgPrecioTotal'>$ <span id='valorAvisoPromo'> {{montoTotal}}<!-- Empty --></span></li>",
	"</ul>",
	"<p><span class='ivaIncluido'>I.V.A. Incluido</span></p>"
].join("\n");

/**
 * idPopUp   : Para identificarlo y utilizarlo luego
 * titulo    : Titulo del popup
 * mensaje   : Cuerpo del popup
 * txtBoton1 : Que contendra el boton 1 (Cancelar, No)
 * txtBoton2 : Que contendra el boton 2 (Guardar, Aceptar, Si, etc)
 */
/*CrearAvisosTemplates.modalPopUpWindow = [
    "<div id='{{idPopUp}}' class='modal fade {{classTipoMensaje}}' data-toggle='modal' >",
    	"<div class='modal-header'>",
    		"<a class='close' data-dismiss='modal' title='Cerrar'>&times;</a>",
    		"<h3>{{titulo}}</h3>",
    	"</div>",
	    "<div class='modal-body'>",
	    	"<p>{{mensaje}}</p>",
	    "</div>",
	    "<div class='modal-footer'>",
	    	"<div class='btn' onClick='{{funcionBoton1}}'>{{txtBoton1}}</div>",
	    	"<div class='btn btn-primary' onclick='{{funcionBoton2}}'>{{txtBoton2}}</div>",
	    "</div>",
    "</div>"
].join("\n");*/

CrearAvisosTemplates.divPalabrasProhibidas = [
    "<div id='divPalabrasProhibidas' >",
    "{{#each palabrasProhibidas}}",
    	"<label id=labelPalabraProhibida>",
			"{{this}}",
		"</label>",
	"{{/each}}",
    "</div>"
].join("\n");

CrearAvisosTemplates.navigationFooter = [
	"<section id='wrapperAction'>",
		"<div class='botonera-wrapper'>",
			"<a id='btn-Previsualizar' class='btn btn-siguiente btn-previsualizar greenBtn disabledBtn hidden' href='#'>Previsualizar y cotizar</a>",
			"<a id='btnWizardNext' href='#' class='btn btn-siguiente greenBtn'>Siguiente</a>",
			"<a id='btnWizardPrev' href='#' class='btn btn-anterior'>Anterior</a>",
			"<div class='terminaste' data-toggle='popover' data-placement='top'></div>",
		"</div>",
		"<div class='cancelar-wrapper'>",
			"<a id='btnWizardCancel' href='#' class='btn btn-cancelar'>Cancelar</a>",
		"</div>",
	"</section>"
].join("\n");

CrearAvisosTemplates.selectorTarjetas = [

	"<ul>",
		"<li id='liTarjetas'>",
			"<ul class='subListaTarjetas'>",
			 "{{#each tarjetasPago}}",
			 	"<li>",
					"<label class='radio'>",
						"<input type='radio' name='tipoTarjeta' id='{{codigoGATEWAY}}' value={{descripcion}} onclick='gOnClick_tarjeta(this)'>",
						"<span class='outer'><span class='inner'></span></span><span class='imgTarjeta'><img src='..{{rutaImagenTC}}' alt='{{descripcion}}' title='{{descripcion}}'></span>{{descripcion}}</label>",
			 	"</li>",
			 	//<input class='css-radio' type='radio' name='tipoTarjeta' id='{{codigoGATEWAY}}' value={{descripcion}} onclick='gOnClick_tarjeta(this)'><label class='css-label-radio' for={{codigoGATEWAY}} title={{descripcion}}><span class='imgTarjeta'><img src='..{{rutaImagenTC}}' alt='{{descripcion}}' title='{{descripcion}}'></span>{{descripcion}}</label></li>",
			 "{{/each}}",
			"</ul>",
		"</li>",
		"<li class='hidden'><input class='css-radio' type='radio' name='tipoPagoCheck' id='pagoConPagoFacil'><label class='css-label-radio' for='pagoConPagoFacil'>Pago F&aacute;cil / RapiPago</label></li>",
	"</ul>"

 ].join("\n");

CrearAvisosTemplates.selectorDestaque = [

	"{{#each templatesDetallado}}",
		"<div class='MedioRubroMainWrapper'>",
			"{{#if templateDetallado.tieneImagenesPrediseniadas}}",
					"<div id='selPictosBox-{{templateDetallado.id}}' class='' >",
					"<div>",
						"<input id='radioPicto' class='pull-left checkRubro css-checkbox' type='checkbox' />",
						"<label id='labelRadioPicto' for='radioPicto' class='css-label label-zona' onclick='g_muestraPictos(this)' data-codigo='{{templateDetallado.codigo}}' data-id ='{{templateDetallado.id}}' data-productoComercial ='{{codigoProductoComercial}}'>",
							"{{templateDetallado.descripcion}}",
						"</label>",
					"</div>",
					"<div class='checkbox-picto-seleccionado'></div>",
					"<div class='cambiar-picto'>",
						"<a href='#' onclick='gCambiaPictos(this)'  data-codigo-cambiar='{{templateDetallado.codigo}}' data-id-cambiar ='{{templateDetallado.id}}' data-productoComercial-cambiar='{{codigoProductoComercial}}'>Cambiar imagen</a>",
					"</div>",
					"<div class='eliminar-picto'>",
						"<a href='#' onclick='g_eliminaPictos(this)' data-codigo-eliminar='{{templateDetallado.codigo}}' data-id-eliminar ='{{templateDetallado.id}}' data-productoComercial-eliminar ='{{codigoProductoComercial}}'>&nbsp;</a>",
					"</div>",
				"</div>",
			"{{else if templateDetallado.tieneColor }}",
				"<div id='selDestaqueColorBox-{{templateDetallado.id}}' class='MedioRubroInnerWrapper'>",
					"<div class='box-color'>",
						"<input class='css-radio-color' type='checkbox' id='radioColor' data-codigo-eliminar='{{templateDetallado.codigo}}' data-id-eliminar='{{templateDetallado.id}}' data-productoComercial-eliminar='{{codigoProductoComercial}}'>",
						"<label for='radioColor' class='css-label-radio-color' onclick='g_seleccionarColor(this,event)'  data-codigo='{{templateDetallado.codigo}}' data-id ='{{templateDetallado.id}}' data-productoComercial ='{{codigoProductoComercial}}'><span class='text-label'>{{templateDetallado.descripcion}}</span></label>",
					"</div>",
					"<div class='opcionesColor' id='{{templateDetallado.id}}'>",
						"<ul>",
							"<li class='linkEliminarDestaque'><a href='#' onclick='g_eliminaColor(this)' data-codigo-eliminar='{{templateDetallado.codigo}}' data-id-eliminar ='{{templateDetallado.id}}' data-productoComercial-eliminar ='{{codigoProductoComercial}}'>Eliminar color</a></li>",
						"</ul>",
					"</div>",
				"</div>",
			"{{else}}",
				"<div id='selDestaqueMaterialBox-{{templateDetallado.id}}' class='MedioRubroInnerWrapper'>",
					"<div class='box-material'>",
						"<input class='css-radio-material' type='checkbox' id='radioMaterial' data-codigo-eliminar='{{templateDetallado.codigo}}' data-id-eliminar='{{templateDetallado.id}}' data-productoComercial-eliminar='{{codigoProductoComercial}}'>",
						"<label for='radioMaterial' class='css-label-radio-material' onclick='g_seleccionarMaterial(this,event)' data-codigo='{{templateDetallado.codigo}}' data-id ='{{templateDetallado.id}}' data-productoComercial ='{{codigoProductoComercial}}'>",
							"<span class='text-label'>{{templateDetallado.descripcion}}</span>",
							"<span class='ico-ayuda' title='{{templateDetallado.ayuda}}' data-placement='top' data-trigger='hover'></span>",
						"</label>",
					"</div>",
					"<div class='opcionesMaterial' id='{{templateDetallado.id}}'>",
						"<ul>",
							"<li class='linkCambiarDestaqueMaterial'><a href='#' onclick='g_cambiaMaterial(this)' data-codigo-eliminar='{{templateDetallado.codigo}}' data-id-eliminar ='{{templateDetallado.id}}' data-productoComercial-eliminar ='{{codigoProductoComercial}}'>Cambiar Imagen</a></li>",
							"<li class='linkEliminarDestaqueMaterial'><a href='#' onclick='g_eliminaMaterial(this)' data-codigo-eliminar='{{templateDetallado.codigo}}' data-id-eliminar ='{{templateDetallado.id}}' data-productoComercial-eliminar ='{{codigoProductoComercial}}'>Eliminar Imagen</a></li>",
						"</ul>",
					"</div>",
				"</div>",
			"{{/if}}",
		"</div>",
	"{{/each}}"
].join("\n");


CrearAvisosTemplates.renderSubidaMaterial = [
	"<input type='file' name='file' id='file' class='inputfile cropit-image-input' accept='image/jpeg' >",
	"<label for='file' class='btn btn-primary hidden' id='btn-elige-archivo'>Elegir un archivo...</label>",
	"<div id='errorMsg' class='hidden'>",
		"<h5>La imagen seleccionada est&aacute; fuera de los par&aacute;metros establecidos</h5>",
		"<h6>Par&aacute;metros v&aacute;lidos:</h6>",
		"{{#each templatesDetallado}}",
		"{{#if templateDetallado.tieneImagenesPrediseniadas}}",
		"{{else if templateDetallado.tieneColor }}",
		"{{else}}",
					"<p id='msgExtension'>Extensi&oacute;n:",
						"{{#each templateDetallado.extensionesMaterial}}",
							"{{tipo}} <span class='slash'>/</span>",
						"{{/each}}",
					"</p>",
					"<p id='msgPeso'>Peso m&aacute;ximo: M&aacute;x. {{pesoMaterial}}</p>",
					"<p class='msgDimensionesAncho'>Ancho m&iacute;nimo: {{templateDetallado.ancho}}px</p>",
					"<p class='msgDimensionesAlto'>Alto m&iacute;nimo: {{templateDetallado.alto}}px</p>",
		"{{/if}}",
		"{{/each}}",
		"<p class='msgAdicional hidden'></p>",
		"<div class='btn-retry-box'>",
			"<a class='btn btn-primary btn-retry' title='Subir otra Imagen'>Subir otra imagen</a>",
		"</div>",
	"</div>",
	"<div id='boxImage' class='hidden'>",
		"<div id='loading' class='hidden'>",
			/*"<span class='spinner'></span>",*/
			"<div class='cssload-container'><div class='cssload-loading'><i></i><i></i></div></div>",
		"</div>",
		"<div class='cropit-preview'></div>",
		"<div class='cropit-range-box'>",
			"<div class='cropit-range-less' onclick='g_reduceImagen();'>-</div>",
			"<div><input type='range' id='cropit-range' class='cropit-image-zoom-input' min='1' max='100' value='0' step='10'></div>",
			"<div class='cropit-range-plus' onclick='g_ampliaImagen();'>+</div>",
		"</div>",
		"<div class='cropit-buttons'>",
			"<a class='btn btn-link btnCancelar' title='Elimina la imagen seleccionada'>Cancelar</a>",
			"<a class='btn btn-primary btnAceptarImagen' title='Envia la imagen seleccionada'>Aceptar</a>",
		"</div>",
	"</div>",
	"<div id='imgSubidaOculta'></div>",
].join("\n");

CrearAvisosTemplates.renderImagenes = [
	"<ul>",
		"{{#each imagenes}}",
		"<li><img src='data:image/jpeg;base64,{{contenido}}' alt='{{codigo}}' id='{{codigo}}' data-codigo='{{codigo}}' data-repo='{{repo}}' ></li>",
		"{{/each}}",
	"</ul>"
].join("\n");

CrearAvisosTemplates.paises = [
	"{{#each paises}}",
		"<option value='{{id}}' data-codigo='{{codigo}}' data-select='pais'>{{codigo}}</option>",
	"{{/each}}",
].join("\n");

CrearAvisosTemplates.provincias = [
	"{{#each provincias}}",
		"<option value='{{id}}' data-codigo='{{codigo}}' data-select='provincia'>{{codigo}}</option>",
	"{{/each}}",
].join("\n");

CrearAvisosTemplates.localidades = [
	"{{#each localidades}}",
		"<option value='{{id}}' data-codigo='{{codigo}}' data-select='localidad'>{{codigo}}</option>",
	"{{/each}}",
].join("\n");

CrearAvisosTemplates.promocion365 = [
	"<article id='promo365'>",
		"<div class=''>",
			"<h3>Promo 365</h3>",
		"</div>",
		"<div class=''>",
			"<div id='link365'>",
				"<p><a href='#' id='textLink365'>{{configuracionPromocionPantalla.promocion.observacion}}</a></p>",
			"</div>",
		"<div id='input365'>",
			"<input type='text' name='textInput365' id='textInput365' placeholder='Ingres\xe1 el n\xfamero de tu tarjeta...' maxlength='19' onfocus='gOnfocusRecuperarEstiloInputHandler(this, \"errorTarjeta365\")'>",
			"<div class='btn' id='btnInput365' onclick='gOnClickBotonTarjeta365(this);' data-promocion='{{configuracionPromocionPantalla.promocion.codigo}}'><span>Aplicar descuento</span></div>",
				"<div class=''id='errorTarjeta365'></div>",
			"</div>",
			"<div id='captcha365'>",
				"<label class='labelCaptcha365' for='captchaPromo365'>Texto de la imagen:</label>",
				"<input id='captchaPromo365' type='text' name='captchaPromo365' maxlength='6' data-atributo='captcha' onfocus='gOnfocusRecuperarEstiloInputHandler(this, \"errorCaptchaPromo365\")'>",
				"<span id='errorCaptchaPromo365' class='errorMSG noDisplay'>Debe coincidir el texto con la imagen</span>",
			"</div>",
			"<div id='ok365'>",
				"<p class='mensajeOk365'>Ten&eacute;s un 20&#37; de descuento por tu tarjeta N&#186; <span class='numTarjeta365'></span><span class='close365Ok'></span></p>",
			"</div>",
		"</div>",
	"</article>",
].join("\n");


/*
CrearAvisosTemplates.promocion365 = [
	"<div class='pago-section datos-365' id='promo365'>",
		"<h5 class='section-titulo'>Promo 365</h5>",
		"<div><a href='#' id='textLink365'>{{configuracionPromocionPantalla.promocion.observacion}}</a></div>",
		"<div><input id='textInput365' class='section-input' placeholder='Ingres\xe1 el n\xfamero de tu tarjeta' name='textInput365' onfocus='gOnfocusRecuperarEstiloInputHandler(this, \"errorTarjeta365\")'></div>",
		"<div><button class='promo-365-button' id='btnInput365' onclick='gOnClickBotonTarjeta365(this);' data-promocion='{{configuracionPromocionPantalla.promocion.codigo}}'>APLICAR DESCUENTO</button></div>",
		"<div class='pull-right'id='errorTarjeta365'></div>",
		"<div id='captcha365'>",
			"<label class='labelCaptcha365' for='captchaPromo365'>Texto de la imagen:</label>",
			"<input id='captchaPromo365' type='text' name='captchaPromo365' maxlength='6' data-atributo='captcha' onfocus='gOnfocusRecuperarEstiloInputHandler(this, \"errorCaptchaPromo365\")'>",
			"<span id='errorCaptchaPromo365' class='errorMSG noDisplay'>Debe coincidir el texto con la imagen</span>",
		"</div>",
		"<div id='ok365'>",
			"<p class='mensajeOk365'>Ten&eacute;s un 20&#37; de descuento por tu tarjeta N&#186; <span class='numTarjeta365'></span><span class='close365Ok'></span></p>",
		"</div>",
	"</div>"
].join("\n");
*/


CrearAvisosTemplates.promociones = [
        "<div id='promociones'>",
        "{{#each configuracionesPromocion}}",
        	"<div  class='promoItem promoInactiva' id='{{promocion.codigo}}-{{pantallaShow}}'>",
	        	"<div class='promosTextos'>",
	        		//"<span class='promoCheck'></span>",
	        		"<p class='promoTitulo' id='p-titulo{{promocion.codigo}}-{{pantallaShow}}'><span> {{titulo}}</span></p>",
	        		"<p class='promoDescripcion' id='p-desc-{{promocion.codigo}}-{{pantallaShow}}'>{{promocion.observacion}}</p>",
	        	"</div>",
    		"</div>",
    	"{{/each}}",
    	"</div>"
].join("\n");

CrearAvisosTemplates.listadoPromosConfirmacion = [
"{{#if tienePromocionesAplicadas }}",
"<ul>",
	"{{#each promocionesAplicadas}}",
		"<li><strong>{{descripcion}}</strong></li>",
	"{{/each}}",
"</ul>",
"{{/if}}",
].join("\n");
/*********************************************************
 * Helpers
 *********************************************************/

CrearAvisosHelpers = {};

CrearAvisosHelpers.selectedDateMes = function (){
	var datePart = this.split('-');
	return new Handlebars.SafeString(
		dateUtils.MONTHS_STRING_ARRAY[parseInt(datePart[1])-1]
	);
}

CrearAvisosHelpers.selectedDateDia = function (){
	var datePart = this.split('-');
	return new Handlebars.SafeString(
		datePart[2]
	);
}

CrearAvisosHelpers.nombreOrdenamiento = function (){
	var result = (this.codigo.length > 14) ? this.codigo.valueOf().substr(0,11) + "..." : this.codigo;
	return new Handlebars.SafeString(result);
}

CrearAvisosHelpers.nombreItemOrdenamiento = function (){
	//var result = this.descripcion.toString().trimToPx(140,".genericBtn span");
	var anchoBoton = parseInt($(".genericBtn span").width(),"");
	var result = this.descripcion.toString().toLowerCase().trimToPx(anchoBoton,".genericBtn");
	return new Handlebars.SafeString(result);
}

CrearAvisosHelpers.descripcionBien = function (){
	var dato = 0;
	if(this.codigo === "ELECTRODOMESTICOS"){
		dato = parseFloat($(".genericBtn").css("width")) - 30;
		var result = this.descripcion.trimToPx(dato,".genericBtn");
		return new Handlebars.SafeString(result);
	}else{
		dato = parseFloat($(".genericBtn").css("width"));
		var result = this.descripcion.trimToPx(dato,".genericBtn");
		return new Handlebars.SafeString(result);
	}
}

CrearAvisosHelpers.pesoMaterial = function (){
	var bytes = this.templateDetallado.pesoMaterial;
	var sizes = ['Bytes', 'Kb', 'Mb', 'Gb', 'Tb'];
	if (bytes == 0) return '0 Bytes';
	var i = parseInt(Math.floor(Math.log(bytes) / Math.log(1024)));
	var result = (bytes / Math.pow(1024, i)).toFixed(0) + '' + sizes[i];
	return new Handlebars.SafeString(result);
}


