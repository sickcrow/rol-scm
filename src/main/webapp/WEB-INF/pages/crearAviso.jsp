<!DOCTYPE html>
<html>
	<head>
		<title>Calendario</title>
	</head>
	<body>
		<div id="mainApp" class="container">
				<!--Wizard BreadCrum-->
				<div id="MyWizard" class="wizard">
					<ul class="steps">
						<li id="wizardPaso1" data-target="#step1" class="active">&iquest;Qu&eacute; quer&eacute;s publicar?<span class="chevron"></span></li>
						<li id="wizardPaso2" data-target="#step2">&iquest;D&oacute;nde se publicar&aacute;?<span class="chevron"></span></li>
						<li id="wizardPaso3" data-target="#step3">&iquest;Cu&aacute;ndo se publicar&aacute;?<span class="chevron"></span></li>
						<li id="wizardPaso4" data-target="#step4">&iquest;C&oacute;mo ser&aacute; tu aviso?<span class="chevron"></span></li>
						<li id="wizardPaso5" data-target="#step5" class="step-button-invisible">&iquest;C&oacute;mo ser&aacute; tu aviso?<span class="chevron"></span></li>
						<li id="wizardPaso6" data-target="#step6" class="step-button-invisible">&iquest;C&oacute;mo ser&aacute; tu aviso?<span class="chevron"></span></li>
						<li id="wizardPaso7" data-target="#step7">Confirmaci&oacute;n y pago</li>
						<li id="wizardPaso8" data-target="#step8" class="step-button-invisible">&iquest;C&oacute;mo ser&aacute; tu aviso?<span class="chevron"></span></li>
					</ul>
				</div>
				<!--End Wizard BreadCrum-->
				<!--Path Seleccionado Wizard-->
				<div id="divTextoSeleccionaste" class="breadcrum">
					<div id="textoSeleccionaste"></div>
				</div>
				<!--End Path Seleccionado Wizard-->

				<section id="paso1-Cat" class="pull-left panel-ver-seleccionado">
					<div class="container-panel">
						<div id="categoriaBox" class="CatBox hidden" data-orden="1" data-ordenamientos="Categor&iacute;a"><span class='inner-desc'>CATEGOR&Iacute;A</span></div>
						<div id="bienBox" class="CatBox hidden"><span class='inner-desc'>BIEN</span></div>
						<div id="tipoOperacionBox" class="CatBox hidden"><span class='inner-desc'>OPERACI&Oacute;N</span></div>
					</div>
				</section>
				<!--<section id="paso4-Cat" class="pull-left panel-ver-seleccionado">
					<div class="container-panel"></div>
				</section>-->

				<!--Wizard Step's content-->
				<div class="step-content">
					<!--Wizard Step 1 content-->
					<div class="step-pane active" id="step1">
						<section id="paso1-QueQueres" class="hidden paso1-QueQueres">
							<h4 id="titulo-paso">Seleccion&aacute; una categor&iacute;a</h4>
							<section id="paso1-SelecCat" class="pull-left selectButtons" data-toggle="popover" data-placement="bottom" data-content="&iquest;A cu&aacute;l de estos grupos corresponde lo que quer&eacute;s publicar">

							</section>
							<div class="clearfix"><!-- Empty --></div>
						</section>
					</div>
					<!--End Wizard Step 1 content-->
					<!--Wizard Step 2 content-->
					<div class="step-pane" id="step2">
						<section id="paso2-DondePublicara" class="paso2-DondePublicara">
							<button type='button' onclick='showPopUpVerSeleccion()' class='btn btn-ver-seleccion'><span>Ver Selecci&oacute;n</span></button>
								<header>
									<h2>&iquest;D&oacute;nde quer&eacute;s publicarlo?</h2>
								</header>
								<!--Eleccion Medio Rubro content-->
								<section id="paso2-Medio-rubro" class="">
									<div id="MedioRubroMainWrapper" class="MedioRubroMainWrapper">
										<!--Eleccion Medio Rubro content large select-->
									</div>
								</section>
								<!--End Eleccion Medio Rubro content-->

								<!-- GGONTARUK -->
								<!-- Promo Eleccion Medio Rubro content
								<section id="paso2-Medio-rubro-promos" class="pull-left">
									<h3>Promociones</h3>
									<label>Se activan automaticamente cuando elijas los medios.</label>
									<div id="AllactivesPromos">
										<div id="promosActivadasWrapper">
											<div>Obten&eacute; un <strong>20% de descuento</strong> publicando 3 d&iacute;as seguidos</div>
											<div>Obten&eacute; un <strong>20% de descuento</strong> publicando 3 d&iacute;as seguidos</div>
										</div>
									</div>
								</section>
								-->

								<!--End Promo Eleccion Medio Rubro content-->
								<div class="clearfix"><!-- Empty --></div>
						</section>
					</div>
					<!--End Wizard Step 2 content-->
					<!--Wizard Step 3 content-->
					<div class="step-pane" id="step3">
						<section id="paso3-CuandoSePublicara" class="paso3-CuandoSePublicara">
							<button type='button' onclick='showPopUpVerSeleccion()' class='btn btn-ver-seleccion'><span>Ver Selecci&oacute;n</span></button>
								<header>
									<h2>&iquest;Cu&aacute;ndo quer&eacute;s publicarlo?</h2>
								</header>

								<!--Calendar Custom-->
								<section id="paso3-Calendar">
									<div class="calendar" data-toggle="popover" data-html="true" data-placement="top"
										data-content="Elegí los días en el calendario.<button id='closeCalendarPopup' type='button' class='close' onclick='$(&quot;.calendar&quot;).popover(&quot;hide&quot;);'>&times;</button>">
									</div>
									<div class="leyenda-calendar">
										<div class="no-disponible" title="El día no se encuentra habilitado para publicar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
										<div class="no-disponible-nota">El día no se encuentra habilitado para publicar</div>
									</div>
									<label class="hidden">Carg&aacute; tu aviso con 3 dias de anticipaci&oacute;n si vas a usar PagoF&aacute;cil o Rapipago.</label>
								</section>
								<!--End Calendar Custom-->

								<section id="paso3-promo-avisosDiasPubli">
									<!--Promo Dinamic-->
									<div class="paso3-promociones">
										<h4>Promociones</h4>
										<div id="listaPromociones-paso3">
										</div>
									</div>
									<!--End Promo Dinamic-->

									<!--Days Picked-->
									<div class="clearfix PickedTop"></div>
									<div class="tuAvisoPublicara hide">
										<h4>Tu aviso se publicar&aacute; el:</h4>
										<div id="days-selected" class="days-selected-container"></div>
									</div>
									<div class="clearfix PickedFooter"></div>
								</section>

								<div class="clearfix"><!-- Empty --></div>
						</section>
					</div>
					<!--End Wizard Step 3 content-->
					<!--Wizard Step 4 content-->
					<div class="step-pane" id="step4">
						<section id="paso4-CuentanosMas-B" class="paso4-CuentanosMas-B">
							<button type='button' onclick='showPopUpVerSeleccion()' class='btn btn-ver-seleccion'><span>Ver Selecci&oacute;n</span></button>
								<header>
									<h4 id="selecciona-variable"></h4>
								</header>
								<section id="paso4-Cat" class="pull-left panel-ver-seleccionado">
									<div class="container-panel"></div>
								</section>
								<section id="paso4-SelecCat" class="pull-left selectButtons">
								</section>
						</section>
					</div>
					<!--End Wizard Step 4 content-->
					<!--Wizard Step 5 content-->
					<div class="step-pane" id="step5">
						<section id="paso4-ComoSeraTuAviso" class="paso4-ComoSeraTuAviso">
							<button type='button' onclick='showPopUpVerSeleccion()' class='btn btn-ver-seleccion'><span>Ver Selecci&oacute;n</span></button>
								<!--Title-->
								<header>
									<h4 class="titulo-paso">Detalle del aviso</h4>
								</header>
								<!--End Title-->
								<!--Crear Aviso-->
								<section id="paso4-CrearAviso" class="formCrearAviso">
									<div id="divOrdenamientos"><!-- Ordenamientos Dinamicos --></div>
									<div class="textoLibre">
										<a id="ejemplosPopup" href="#" class="pull-right hidden">Ver avisos de ejemplo.</a>
										<label for="txtAreaTextoLibre">Texto del aviso <small style="color:#f00;">*</small></label>
										<textarea id="txtAreaTextoLibre" rows="4" onclick="gClickMuestraAyuda(this);"  onblur="gOnblurMuestraAyuda(this);"></textarea>
										<p id="parrafoPalabrasProhibidas" class="validacion"></p>
										<p class="obligatorios"><small style="color:#f00;">*</small> - Campos obligatorios</p>
										<div class="popover fade bottom in">
												<div class="arrow"></div>
												<div class="popover-inner">
												<h3 class="popover-title"></h3>
												<div class="popover-content">Ingres&aacute; en el texto del aviso tu mensaje e informaci&oacute;n que quieras brindar a los lectores.<button type="button"  class="close">&times;</button></div>
											</div>
										</div>
									</div>

								</section>
								<!--Previsualizar Aviso-->

								<section id="paso4-PreviewAviso" class="paso4PrevisualizacionYCotizacion">
									<div>
										 <span id="lblPreview" class="lblPreview">As&iacute; ser&aacute; el texto de tu aviso.</span>
									</div>
									<div id="previewHolder"></div>
									<div id="previewCotizacion">
										<div id="precioPreview">
											<h4>Cotizaci&oacute;n</h4>
											<div class="desglosePrecios" id="desglosePreciosP4">
												<ul class="desgLabels pull-left">
													<li class="desgLabelPrecioSinPromo desglose" id="lblPrecioSinPromo" style="display: none;">Precio:</li>
													<li class="desgLabelMontoDePromo desglose" id="lblPrecioConPromo" style="display: none;">Descuento:</li>
													<li class="desgLabelPrecioTotal" id="lblPrecioTotal" >Precio:</li>
												</ul>
												<ul class="desgPrecios pull-right">
													<li class="desgPrecioSinPromo desglose" style="display: none;">$ <span id="valorSinPromo"> 0<!-- Empty --></span></li>
													<li class="desgMontoDePromo desglose" style="display: none;">$ <span id="valorConPromo"> 0<!-- Empty --></span></li>
													<li class="desgPrecioTotal">$ <span id="valorAviso"> 0<!-- Empty --></span></li>
												</ul>
												<p><span class="ivaIncluido">I.V.A. Incluido</span></p>
											</div>


<!-- 											<div id="labelforValor" class="pull-left leftDiv">Precio:</div> -->
<!-- 											<div class="pull-left" id="valorWrapper">$ <span id="valorAviso">Empty</span> <span class="ivaIncluido">I.V.A. Incluido</span></div> -->
<!-- 											<div class="clearfix">Empty</div>										 -->
										</div>
										<!-- <div id="precioLinks">
											<div class="leftDiv pull-left">
												<a href="#" >Lista de Precios</a>
											</div>
											<div class="pull-left" style="visibility: hidden;">
												<a href="#">Ver Detalle</a>
											</div>
											<div class="clearfix"><!-- Empty --><!-- </div>
										</div>-->
									</div>
								</section>
								<section class="paso4-promociones">
									<h4>Promociones</h4>
									<div id="listaPromociones-paso4" class="">

									</div>
								</section>
								<!--End Previsualizar Aviso-->
								<!--Boton Convertir Aviso-->
								<section id="paso4-ConvertirAviso" class="pull-left">

								</section>
								<!--End Boton Convertir Aviso-->
								<!--End Crear Aviso-->

								<div class="clearfix"><!-- Empty --></div>
						</section>
					</div>
					<!--End Wizard Step 5 content-->
					<!--Wizard Step 6 content-->
					<div class="step-pane" id="step6">
						<section style="display:block;" id="paso4-Mejora-Posibilidades" class="paso4-Mejora-Posibilidades ">
							<button type='button' onclick='showPopUpVerSeleccion()' class='btn btn-ver-seleccion'><span>Ver Selecci&oacute;n</span></button>
								<header>
									<h4 class="titulo-paso">Destac&aacute; tu aviso</h4>
								</header>
								<!--Eleccion Medio Rubro content-->
								<section id="paso6-Destaca-Aviso" class="" data-toggle="popover" data-placement="top" data-html="true" data-content="Destac&aacute; tu aviso agreg&aacute;ndole una imagen <button id='closeDestacaPopup' type='button' class='close' onclick='$(&quot;#paso6-Destaca-Aviso&quot;).popover(&quot;hide&quot;);'>&times;</button>">
									<div id="listDestaque">
										<!--Eleccion Medio Rubro content text-->

										<!--End Eleccion Medio Rubro content text-->
									</div>
								</section>
								<!--End Eleccion Medio Rubro content-->

								<!--Previsualizar Aviso-->
								<section id="paso4C-PreviewAviso" class="">
									<div id="previewHolderP6">
										<span id="lblPreviewP6" class="lblPreview">As&iacute; ser&aacute; el texto de tu aviso.</span>
										<div class="boxImgPreview">
											<div class="imgPreview"></div>
											<div class="image-editor"></div>
										</div>
									</div>
									<div id="previewCotizacion">
										<div id="precioPreview">
											<h4>Cotizaci&oacute;n</h4>
											<div class="desglosePrecios" id="desglosePreciosP6">
												<ul class="desgLabels pull-left">
													<li class="desgLabelPrecioSinPromo desglose" id="lblPrecioSinPromoP6" style="display: none;">Precio:</li>
													<li class="desgLabelMontoDePromo desglose" id="lblPrecioConPromoP6" style="display: none;">Nombre Promoci&oacute;n:</li>
													<li class="desgLabelPrecioTotal" id="lblPrecioTotalP6">Total:</li>
												</ul>
												<ul class="desgPrecios pull-right">
													<li class="desgPrecioSinPromo desglose" style="display: none;">$ <span id="valorSinPromoP6"> 0<!-- Empty --></span></li>
													<li class="desgMontoDePromo desglose" style="display: none;">$ <span id="valorConPromoP6">0<!-- Empty --></span></li>
													<li class="desgPrecioTotal">$ <span id="valorAvisoP6">0<!-- Empty --></span></li>
												</ul>
												<p><span class="ivaIncluido">I.V.A. Incluido</span></p>
											</div>

<!-- 											<div id="labelforValor" class="pull-left leftDiv">Precio:</div> -->
<!-- 											<div class="pull-left" id="valorWrapper">$ <span id="valorAvisoP6">Empty</span> <span class="ivaIncluido">IVA Incluido</span></div> -->
<!-- 											<div class="clearfix">Empty</div>										 -->
										</div>
										<!-- <div id="precioLinks">
											<div class="leftDiv pull-left">
												<a href="#" >Lista de Precios</a>
											</div>
											<div class="pull-left" style="visibility: hidden;">
												<a href="#">Ver Detalle</a>
											</div>
											<div class="clearfix"><!-- Empty --><!-- </div>
										</div>-->
									</div>
								</section>
								<!--End Previsualizar Aviso-->

						</section>
					</div>
					<!--End Wizard Step 6 content-->
					<!--Wizard Step 7 content-->
					<div class="step-pane" id="step7">

						<section id="paso6-confirmacion" class="paso6-confirmacion">
								<header>
									<h4 class="titulo-paso">Confirmaci&oacute;n</h4>
								</header>
								<section id="paso6-confirmacion-body" data-toggle="popover" data-placement="bottom" data-content="&iquest;A cu&aacute;l de estos grupos corresponde lo que quer&eacute;s publicar">
									<div class="paso6-InnerRow" >
										<div class="paso6-label">
											<h4>&iquest;Qu&eacute; quer&eacute;s publicar?</h4>
										</div>
										<div id="publicacionContainer" class="paso6-rowcontent">
											<div class="paso6-TitlePublicacion">Ford Focus 2013</div>
										</div>
										<div class="clearfix"><!-- Empty --></div>
									</div>
									<div class="paso6-InnerRow">
										<div class="paso6-label">
											<h4>&iquest;D&oacute;nde quer&eacute;s publicarlo?</h4>
										</div>
										<div id="zonasContainer" class="paso6-rowcontent">
											<!-- Empty -->
										</div>
										<div class="clearfix"><!-- Empty --></div>
									</div>
									<div class="paso6-InnerRow">
										<div class="paso6-label">
											<h4>&iquest;Cu&aacute;ndo quer&eacute;s publicarlo?</h4>
										</div>
										<div id="fechaPublicacionContainer" class="paso6-rowcontent">
											<!-- Empty -->
										</div>
										<div id="editarFechaPublicacion" class="paso6-editar">Editar</div>
										<div class="clearfix"><!-- Empty --></div>
									</div>

									<div class="paso6-InnerRow">
										<div class="paso6-label">
											<h4>&iquest;C&oacute;mo ser&aacute; tu aviso?</h4>
										</div>
										<div id="imagenContainer" class="paso6-rowcontent">
											<div id="paso6-previewHolder">

											</div>
										</div>
										<div id="editarImagenAviso" class="paso6-editar">Editar</div>
										<div class="clearfix"><!-- Empty --></div>
									</div>
									<div id="divDescuentosConfirmacion" class="paso6-InnerRow">
										<div class="paso6-label">
											<h4>¿Qué descuentos?</h4>
										</div>
										<div class="paso6-rowcontent">
											<div id="listadoPromosConfirmacion"></div>
										</div>
										<div class="clearfix"><!-- Empty --></div>
									</div>
									<!--
									<div class="paso6-InnerRow">
										<div class="paso6-label">
											<h4>Aviso destacado con:</h4>
										</div>
										<div class="paso6-rowcontent">
											<div class="paso6-AvisoDestacado">Fondo</div>
										</div>
										<div class="paso6-editar">Editar</div>
										<div class="clearfix"> --> <!-- Empty -->
										<!--  </div>
									</div>	-->
								</section>
									<section id="paso6-total-confirmacion">
										<div id="paso6-previewCotizacion">
											<div id="precioPreview" class="paso6-label">
												<div class="desglosePrecios" id="paso6-desglose">
													<ul class="desgLabels pull-left">
														<li class="desgLabelPrecioSinPromo desglose" id="paso6-lblPrecioSinPromo" style="display: none;">Precio:</li>
														<li class="desgLabelMontoDePromo desglose" id="paso6-lblPrecioConPromo" style="display: none;">Nombre Promoci&oacute;n:</li>
														<li class="desgLabelPrecioTotal" id="paso6-lblPrecioTotal">Precio:</li>
													</ul>
													<ul class="desgPrecios pull-right">
														<li class="desgPrecioSinPromo desglose" style="display: none;">$&nbsp;<span class="textIvaIncluido">&nbsp;I.V.A. Incluido</span> <span id="paso6-valorSinPromo">0<!-- Empty --></span></li>
														<li class="desgMontoDePromo desglose" style="display: none;">$&nbsp;<span class="textIvaIncluido">&nbsp;I.V.A. Incluido</span> <span id="paso6-valorConPromo">0<!-- Empty --></span></li>
														<li class="desgPrecioTotal">$&nbsp;<span class="textIvaIncluido">&nbsp;I.V.A. Incluido</span> <span id="paso6-valorAviso">0<!-- Empty --></span></li>
													</ul>
													<div class="clearfix"></div>
												</div>

<!-- 												<div id="paso6-labelforValor">Precio Total:</div> -->
<!-- 												<div class="clearfix">Empty</div>										 -->
											</div>
<!-- 											<div id="precioLinks" class="paso6-rowcontent"> -->
<!-- 												<div class="pull-left">		 -->
<!-- 													<div class="pull-left" id="paso6-valorWrapper">$ <span id="paso6-valorAviso"></span> <span class="ivaIncluido">I.V.A. Incluido</span></div> -->
<!-- 													<a href="#"  style="visibility: hidden;">Ver Detalle</a> -->
<!-- 												</div>	 -->
<!-- 												<div class="clearfix"> Empty</div> 									 -->
<!-- 											</div> -->
										</div>
									</section>
								<div class="clearfix"><!-- Empty --></div>
						</section>
						<div id="previewImagen">
							<!-- Empty -->
						</div>
					</div>
					<!--End Wizard Step 7 content-->
					<!--Wizard Step 8 content-->
					<div class="step-pane" id="step8">
						<section id="paso8-AvisoPago" class="paso8-AvisoPago" style="display: none; visibility: hidden;">
							<header>
								<h2>Confirmación</h2>
							</header>
							<article>
								<p><strong>Tu aviso será modificado una vez que finalices la publicación.</strong></p>
							</article>
							<div id="boxDatosObligatoriosPago"></div>
						</section>
						<section id="paso8-AvisoGratuito" class="paso8-AvisoGratuito" style="display: none; visibility: hidden;">
							<header>
								<h2>Aviso gratuito</h2>
							</header>
							<article>
								<p><strong>Estás publicando una línea gratis.</strong> Recordá que si publicás más de 1 línea tenes un descuento del 50% sobre todo el aviso!. <!-- Si queres modificarlo hacé <a href="#" id="editarAvisoGratis">click aquí</a>. --></p>
							</article>
							<div id="boxDatosObligatoriosGratuito"></div>
						</section>
						<section id="paso7-ComoPagas" class="paso7-ComoPagas">
							<header>
								<h4 class="titulo-paso">Pagar el aviso</h4>
							</header>
							<section id="promociones"></section>
							<section id="precioPantallaPagar">
								<article id="precioPagos" class="listPago">
									<h3>Cotizaci&oacute;n</h3>
									<p>
										<span id="" class="labelTotal">Total:</span>
										<span id="precioPago" class="precioPago"></span>
									</p>
									<span class="ivaIncluido">I.V.A. Incluido</span>
								</article>
							</section>
							<section id="contentPago">

								<!-- <h2>&iquest;C&oacute;mo quer&eacute;s pagarlo?</h2> -->
								<article id="tipoPagos" class="listPago">
									<h3>Pagar mi aviso con tarjeta de crédito</h3>

									<div id="pagos" class="">

									</div>
								</article>
							</section>
							<section id="boxDatosObligatorios"></section>
							<section id="datosPago" style="display: none;">
								<div id="divAlertaLimiteCotizacion">
									<!-- Tu aviso supera los $<span id="valorLimite"></span>. Para generar tu factura necesitamos que nos definas los datos de tu domicilio. -->
									Ingres&aacute; tu domicilio
								</div>
								<div id="divCargaDireccion">
									<div id="divDirCol1" class="col-xs-12 col-sm-6 col-md-6 col-lg-6 form-pagar-group">
										<div id="divDirCalle" class="form-group form-md-line-input has-info">
											<input class="form-control" type="text" name="pagarCalle" id="pagarCalle" maxlength="30" value="" onkeyup="gOnkeyupHabilitarBotonPagar()" placeholder="Calle...">
											<label>Calle <span class="obligatory">*</span></label>
										</div>

										<div id="divSeleccionPais" class="form-group form-md-line-input has-info select-style selPais">
											<label for='pagarPais'>País <span class="obligatory">*</span></label>
											<select name="pagarPais" id="pagarPais" onchange="gOnchangeSeleccionarPaisHandler(this)">
												<option>Pa&iacute;s...</option>
											</select>
										</div>
										<div id="divSeleccionLocalidad" class="form-group form-md-line-input has-info select-style selLocalidad">
											<label for="pagarLocalidad">Localidad <span class="obligatory">*</span></label>
											<select name="pagarLocalidad" id="pagarLocalidad" onchange="gOnchangeSeleccionarLocalidadHandler()">
												<option>Localidad...</option>
											</select>
										</div>
										<span id="camposObligatorios" class="pull-left"><span class="obligatory">*</span> - Campos obligatorios</span>
									</div>
									<div id="divDirCol2" class="col-xs-12 col-sm-6 col-md-6 col-lg-6 form-pagar-group">
										<div class="form-group form-md-line-input has-info inpPuerta">
											<input class="form-control" type="text" name="pagarNumPuerta" id="pagarNumPuerta" maxlength="5" value="" onkeyup="gOnkeyupHabilitarBotonPagar()" placeholder="Puerta...">
											<label>Puerta <span class="obligatory">*</span></label>
										</div>
										<div class="form-group form-md-line-input has-info inpPiso">
											<input class="form-control" type="text" name="pagarPiso" id="pagarPiso" maxlength="10" value="" placeholder="Piso...">
											<label>Piso </label>
										</div>
										<div class="form-group form-md-line-input has-info inpDepto">
											<input class="form-control" type="text" name="pagarDepto" id="pagarDepto" maxlength="10" value="" placeholder="Depto...">
											<label>Depto </label>
										</div>
										<div class="form-group form-md-line-input has-info inpCp">
											<input class="form-control" type="text" name="pagarCp" id="pagarCp" maxlength="4" value="" onkeyup="gOnkeyupHabilitarBotonPagar()" placeholder="Cp...">
											<label>CP <span class="obligatory">*</span></label>
										</div>
										<div id="divSeleccionProvincia" class="form-group form-md-line-input has-info select-style selProvincia">
											<label for="pagarProvincia">Provincia <span class="obligatory">*</span></label>
											<select name="pagarProvincia" id="pagarProvincia" onchange="gOnchangeSeleccionarProvinciaHandler(this)">
												<option>Provincia...</option>
											</select>
										</div>
									</div>
									<div class="clearfix"></div>
								</div>
							</section>
						</section>
					</div>
				<!--End Wizard Step's content-->
				</div>
			</div>
		<div id="datosObligatorios" style="display:none;">
			<h4 id="datosContactoTitulo">Ingresando estos datos te van a poder contactar desde <a href="http://www.clasificados.clarin.com" target="_blank">www.clasificados.clarin.com</a></h4>
			<div class="boxInpEmail">
	        	<div class="popover fade right in" id="ayudaEmail">
						<div class="arrow"></div>
						<div class="popover-inner">
						<h3 class="popover-title"></h3>
						<div class="popover-content">El e-mail debe ser una dirección del tipo nombre@dominio.com o nombre.apellido@dominio.com.ar<button type="button"  class="close">&times;</button></div>
					</div>
				</div>
	        	<div class="form-group form-md-line-input has-info ">
					<input class="form-control" type="text" name="inputEmailAviso" id="inputEmailAviso" maxlength="250" value="" placeholder="Correo Electr&oacute;nico">
					<label>Correo Electr&oacute;nico <span class="obligatory">*</span></label>
				</div>
	        	<span data-placement="top" title="El e-mail debe ser una dirección del tipo nombre@dominio.com o nombre.apellido@dominio.com.ar" class="ico-ayuda"></span>
	        	<span class="errorEmail">Escriba un email válido.</span>
        	</div>
        	<div class="clearfix">&nbsp;</div>
        	<div class="pull-left boxInpTelefono">
	        	<div class="popover fade right in" id="ayudaTelefono">
						<div class="arrow"></div>
						<div class="popover-inner">
						<h3 class="popover-title"></h3>
						<div class="popover-content">El teléfono, solo debe contener números y no superar los 16 dígitos <button type="button"  class="close">&times;</button></div>
					</div>
				</div>
				<div class="popover fade right in" id="ayudaArea">
						<div class="arrow"></div>
						<div class="popover-inner">
						<h3 class="popover-title"></h3>
						<div class="popover-content">Indicanos tu código de área para que puedan contactarte desde cualquier parte del país <button type="button"  class="close">&times;</button></div>
					</div>
				</div>
	        	<div class="form-group form-md-line-input has-info inputAreaAviso">
					<input class="form-control" type="text" name="inputAreaAviso" id="inputAreaAviso" maxlength="6" value="" placeholder="">
					<label>C&oacute;digo &aacute;rea <span class="obligatory">*</span></label>
					<span>Ej. 11</span>
				</div>

	        	<div class="form-group form-md-line-input has-info inputTelefonoAviso">
					<input class="form-control" type="text" name="inputTelefonoAviso" id="inputTelefonoAviso" maxlength="10" value="" placeholder="">
					<label>Tel&eacute;fono <span class="obligatory">*</span></label>
					<span>Ej. 50201320</span>
				</div>

				<span data-placement="top" title="Indicanos tu código de área para que puedan contactarte desde cualquier parte del país. Al número de teléfono no le tenes que agregar el 15 en caso de ser celular" class="ico-ayuda"></span>
				<span class="errorTelefono">Escriba un teléfono válido.</span>
	        	<div class="clearfix">&nbsp;</div>
        	</div>
        	<div class="clearfix"><!-- Empty --></div>
        	<span id="camposObligatorios" class="pull-left"><span class="obligatory">*</span> - Campos obligatorios</span>
        	<div class="clearfix"><!-- Empty --></div>
		</div>
		<!-- Scoring -->
		<noscript><p><img src="https://b.scorecardresearch.com/p?c1=2&amp;c2=6906409&amp;ns_site=clasificadosclarin&amp;name=receptoriaonline.crear-aviso" height="1" width="1" alt="*"></p></noscript>

		<content tag="myJavascript">
         	<script data-main="../js/main" src="${pageContext.servletContext.contextPath}/js/lib/jquery.require.min.js" type="text/javascript"></script>
        </content>

	</body>
</html>
