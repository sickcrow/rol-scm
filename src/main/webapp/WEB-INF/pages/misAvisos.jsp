<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    	<script></script>
    </head>
    <body>
    	<div id="mainMisAvisos" class="container" style="display:block;">
			<section id="misAvisosSection" class="misAvisosSection">
				<header>
					<h2 id="titMisAvisos">Mis Avisos</h2>
				</header>
				<section id="misAvisosSectionContent">
					<div class="filterMainWrapper">
						<div id="nuevoAvisoBtn" class="btn">
							<span>Nuevo aviso</span>
						</div>
						<div id="filtroFullWrapper" class="">
							<h2>Filtrar avisos</h2>
							<div id="filtroWrapper">
								<div id="filtroCategoriasMisAvisos" class="">
									<label class="labelSelect">Categor&iacute;a:</label>
									<div class="selFiltros">
										<select id="filtroCategoria" ></select>
									</div>
								</div>
								<div id="filtroEstadosMisAvisos" class="">
									<label class="labelSelect">Estado:</label>
									<div class="selFiltros">
										<select id="filtroEstado"></select>
									</div>
								</div>
							</div>
						</div>
						<div class="mensajesMisAvisos">
							<div id="divOrdenPublicacionSuccess" class="alert alert-warning fade in" style="display: none">
						        <button data-hidden="true" data-dismiss="alert" class="close" type="button">&times;</button>
						        El aviso fue guardado en forma exitosa. El proceso de confirmación de pagos puede demorar hasta 10 minutos en obtener la confirmación por parte de la tarjeta de crédito.
					      	</div>
							<div id="divOrdenPublicacionSuccessGratis" class="alert alert-warning fade in" style="display: none">
						        <button data-hidden="true" data-dismiss="alert" class="close" type="button">&times;</button>
						        El aviso fue guardado en forma exitosa.
					      	</div>
							<div id="divOrdenPublicacionSuccessEditPago" class="alert alert-warning fade in" style="display: none">
						        <button data-hidden="true" data-dismiss="alert" class="close" type="button">&times;</button>
						        Tu aviso fue modificado en forma exitosa.
					      	</div>
							<div id="divMensajeMontaner" class="alert alert-warning fade in" style="display: none">
						        <button data-hidden="true" data-dismiss="alert" class="close" type="button">&times;</button>
						        Ya estás participando por las entradas para el show de Romeo Santos! Más información <a href="http://clasificados.clarin.com/enamorados" target="_blank">click aquí</a>.
					      	</div>
					      	<div id="divListaVaciaMensaje" class="alert alert-warning fade in" style="display: none">
						        <button data-hidden="true" data-dismiss="alert" class="close" type="button">&times;</button>
						        Bienvenido a la Receptor&iacute;a online. Ya pod&eacute;s cargar tus avisos desde cualquier dispositivo, est&eacute;s donde est&eacute;s.
					      	</div>
					    </div>
					</div>
					<div class="clearfix"><!-- Empty --></div>
					<div id="listAvisosWrapper">
						<div id="cargandoDatos">
							<div class="cssload-container"><div class="cssload-loading"><i></i><i></i></div></div>
							<h3>Estamos cargando tus avisos, por favor espera un momento.</h3>
						</div>
						<!-- En caso que la lista este vacia -->
						<div id="divListaVacia">
							<h3>Aquí encontrarás tus avisos. ¡Comencemos ya!</h3>
							<div class="btn"><a href="../crearaviso/crear-aviso"><span>Cargar un aviso nuevo</span></a></div>
						</div>
						<div id="filtroMensaje">
							<h3>No se han encontrado resultados con los filtros aplicados. <a href="#" onclick="gOnclickEliminaFiltros();">Eliminar filtros</a></h3>
						</div>
					</div>
				</section>
			</section>

		</div>

		<!-- Scoring -->
		<noscript><p><img src="http://b.scorecardresearch.com/p?c1=2&amp;c2=6906409&amp;ns_site=clasificadosclarin&amp;name=receptoriaonline.mis-avisos" height="1" width="1" alt="*"></p></noscript>

		<!-- Colocar aqui los include de js necesarios para la pantalla -->
		<content tag="myJavascript">
			<script src="${pageContext.servletContext.contextPath}/js/lib/select2.full.min.js" type="text/javascript" charset="cp1252"></script>
       		<script src="${pageContext.servletContext.contextPath}/js/model.iterator.js" type="text/javascript" charset="cp1252"></script>
       		<script src="${pageContext.servletContext.contextPath}/js/mis-avisos/misAvisos.controller.js" type="text/javascript" charset="cp1252"></script>
       		<script src="${pageContext.servletContext.contextPath}/js/mis-avisos/misAvisos.templates.js" type="text/javascript" charset="cp1252"></script>
       		<script src="${pageContext.servletContext.contextPath}/js/mis-avisos/misAvisos.model.js" type="text/javascript" charset="cp1252"></script>
		</content>
    </body>
</html>