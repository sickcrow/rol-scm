<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7 ui-mobile-rendering" lang="es"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8 ui-mobile-rendering" lang="es"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9 ui-mobile-rendering" lang="es"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js ui-mobile-rendering fuelux" lang="es"> <!--<![endif]-->
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    	<meta charset="utf-8">
        <title>Clasificados Clar&iacute;n - Receptor&iacute;a online - Publicar avisos en diario Clar&iacute;n</title>
        <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, width=device-width">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="apple-touch-icon" sizes="57x57" href="${pageContext.servletContext.contextPath}/img/favicon/apple-touch-icon-57x57.png?v=2.0">
		<link rel="apple-touch-icon" sizes="60x60" href="${pageContext.servletContext.contextPath}/img/favicon/apple-touch-icon-60x60.png?v=2.0">
		<link rel="apple-touch-icon" sizes="72x72" href="${pageContext.servletContext.contextPath}/img/favicon/apple-touch-icon-72x72.png?v=2.0">
		<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.servletContext.contextPath}/img/favicon/apple-touch-icon-76x76.png?v=2.0">
		<link rel="apple-touch-icon" sizes="114x114" href="${pageContext.servletContext.contextPath}/img/favicon/apple-touch-icon-114x114.png?v=2.0">
		<link rel="apple-touch-icon" sizes="120x120" href="${pageContext.servletContext.contextPath}/img/favicon/apple-touch-icon-120x120.png?v=2.0">
		<link rel="apple-touch-icon" sizes="144x144" href="${pageContext.servletContext.contextPath}/img/favicon/apple-touch-icon-144x144.png?v=2.0">
		<link rel="apple-touch-icon" sizes="152x152" href="${pageContext.servletContext.contextPath}/img/favicon/apple-touch-icon-152x152.png?v=2.0">
		<link rel="apple-touch-icon" sizes="180x180" href="${pageContext.servletContext.contextPath}/img/favicon/apple-touch-icon-180x180.png?v=2.0">
		<link rel="icon" type="image/png" href="${pageContext.servletContext.contextPath}/img/favicon/favicon-32x32.png?v=2.0" sizes="32x32">
		<link rel="icon" type="image/png" href="${pageContext.servletContext.contextPath}/img/favicon/android-chrome-192x192.png?v=2.0" sizes="192x192">
		<link rel="icon" type="image/png" href="${pageContext.servletContext.contextPath}/img/favicon/favicon-96x96.png?v=2.0" sizes="96x96">
		<link rel="icon" type="image/png" href="${pageContext.servletContext.contextPath}/img/favicon/favicon-16x16.png?v=2.0" sizes="16x16">
		<link rel="manifest" href="${pageContext.servletContext.contextPath}/img/favicon/manifest.json?v=2.0">
		<link rel="mask-icon" href="${pageContext.servletContext.contextPath}/img/favicon/safari-pinned-tab.svg?v=2.0" color="#5bbad5">
		<link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/img/favicon/favicon.ico?v=2.0">
		<meta name="apple-mobile-web-app-title" content="Clasificados Clar&iacute;n - Receptor&iacute;a online">
		<meta name="application-name" content="Clasificados Clar&iacute;n - Receptor&iacute;a online">
		<meta name="msapplication-TileColor" content="#b91d47">
		<meta name="msapplication-TileImage" content="${pageContext.servletContext.contextPath}/img/favicon/mstile-150x150.png?v=2.0">
		<meta name="msapplication-config" content="${pageContext.servletContext.contextPath}/img/favicon/browserconfig.xml?v=2.0">
		<meta name="theme-color" content="#ffffff">
        <link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.servletContext.contextPath}/css/jquery-ui-1.10.3.custom.css" rel="stylesheet">
		<!-- <link href="${pageContext.servletContext.contextPath}/css/rol.css" rel="stylesheet"> -->
		<link href="${pageContext.servletContext.contextPath}/css/select2.css" rel="stylesheet">
		<link href="${pageContext.servletContext.contextPath}/css/rol2.css" rel="stylesheet">
		<link href="${pageContext.servletContext.contextPath}/css/jquery.realperson.css" rel="stylesheet">
		<link href="${pageContext.servletContext.contextPath}/css/imprimir.css" rel="stylesheet" type="text/css" media="print" >
		<!--[if lt IE 9]>
			<script src="${pageContext.servletContext.contextPath}/js/lib/html5shiv.min.js"></script>
			<script src="${pageContext.servletContext.contextPath}/js/lib/respond.min.js"></script>
		<![endif]-->
		
		<!-- Se agrega el tag acorde a la guia https://developers.google.com/analytics/devguides/collection/analyticsjs/?hl=es-419 -->
		<!-- vdenicolo - 21/12/2017 -->
		<!-- Google Analytics -->
		<script>
			(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
			(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
			m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
			})(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
			
			ga('create', 'UA-4436008-9', 'auto');
			
			ga('set', 'dimension2', 'receptoriaonline');
			ga('set', 'dimension13', 'Clasificados Clarin - Receptoria online - Publicar avisos en diario Clarin');
		</script>
		<!-- End Google Analytics -->
    </head>

    <body>
    <div id="wrap">
	    <div id='mensajeCompatibilidadBrowser' style="display:none"><h2>Atención: Estás usando un navegador obsoleto, para disfrutar de todas las funcionalidades actualiza tu navegador <a href="#" onclick='redirect(URLConstants.ROL_ERROR_ACTUALIZA_NAVEGADOR)' title="Actualizá tu navegador">aqui</a>. <a href="#" class="gris" onclick="gOnclickCloseMensajeCompatibilidadBrowserHandler();">No, gracias.</a></h2></div>
		    <header id="headerRol" class="headerRol">
				<nav class="navbar navbar-default">
					<div class="container">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".menuRol" aria-expanded="false">
								<span class="sr-only">Menu</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<h1 class="navbar-brand"><a href="http://clasificados.clarin.com" title="Clasificados Clar&iacute;n">Clasificados Clar&iacute;n</a></h1>
						</div>
						<div class="collapse navbar-collapse menuRol" id="menu-rol">
							<ul id="menuNoLogueado" class="nav navbar-nav navbar-right">
								<li><a id="linkIngresar" onclick="gOnclickRedirectIngresarHanlder(URLConstants.ROL_LOGIN_AUTH0)" >Ingresar</a></li>
								<!-- <li><a id="linkRegistrarme" onclick="gOnclickRedirectRegistrarHanlder(URLConstants.ROL_REGISTRARME)" >Registrarme</a></li> -->
							</ul>
							<ul id="menuLogueado" class="nav navbar-nav navbar-right">
								<li><a id="linkMisAvisos" title="Mis avisos" onclick="gOnclickMisAvisos()">Mis avisos</a></li>
								<li><a id="linkDatosPersonales" onclick="gOnclickRedirectDatosPersonalesHanlder(URLConstants.ROL_DATOS_PERSONALES)">#</a></li>
								<li><a id="linkSalir" title="Salir de la aplicaci&oacute;n" onclick="gOnclickLogout()">Salir</a></li>
							</ul>
							<ul id="menuMailNoValidado" class="nav navbar-nav navbar-right">
								<li><a id="linkIngresar" style="text-transform: none" onclick="gOnclickRedirectIngresarHanlder(URLConstants.ROL_LOGIN_AUTH0)" >Activ&aacute; tu cuenta</a></li>
								<li><a id="datosPersonales" style="cursor:text;text-transform: none;pointer-events: none" >#</a></li>
								<li><a id="linkSalir" title="Salir de la aplicaci&oacute;n" onclick="gOnclickLogout()">Salir</a></li>
							</ul>	
							<ul id="menuSinCapturador" class="nav navbar-nav navbar-right">
								<li><a id="datosSinCapturador" style="cursor:text;text-transform: none;pointer-events: none" >#</a></li>
								<li><a id="linkSalir" title="Salir de la aplicaci&oacute;n" onclick="gOnclickLogout()">Salir</a></li>
							</ul>														
						</div>
					</div>
				</nav>
					<!-- <div id="bannerTop"> -->
	                    <!--<object type="application/x-shockwave-flash" data="../img/bannerEnamorados370x60.swf" width="370" height="60">
							<param name="Especial Día de los Enamorados" value="../img/bannerEnamorados370x60.swf" >
							<param name="quality" value="high">
							<param name="menu" value="false">
							<param name="wmode" value="transparent">
							<a href="http://clasificados.clarin.com/enamorados" target="_blank"><img src="../img/bannerEnamorados370x60.jpg" width="370" height="60" alt="Especial Día de los Enamorados" title="Especial Día de los Enamorados" ></a>
						</object>-->
						<!--
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="370" height="60">
							<param name="movie" value="../img/swf/banner-dia-madre-rol-370x60.swf" />
							<param name="quality" value="high" />
							<embed src="../img/swf/banner-dia-madre-rol-370x60.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="370" height="60"></embed>
						</object>
						<noscript><a href="http://www.clasificados.clarin.com/diadelamadre/?ns_campaign=diadelamadre&ns_mchannel=banner&ns_source=rol&ns_linkname=banner-rol&ns_fee=0.01" target="_blank"><img src="../img/dia-de-la-madre.gif" width="370" height="60" border="0"></a></noscript>
						-->
						 <!--
						 <a href="http://www.clasificados.clarin.com/enamorados/?ns_campaign=enamorados&ns_mchannel=banner&ns_source=rol&ns_linkname=banner-rol&ns_fee=0.01"><img src="../img/gif/370x60_enamorados.gif" border="0" alt="Especial Día de los Enamorados 2015"></a>
						 -->
					<!-- </div> -->
		    </header>

			<!--Wrapper Principal de contenido-->

			<section id="contentWrapper">
				<div id="throbber" style="display:none;"></div>
				<decorator:body/><span id='ruler'>&nbsp;</span><decorator:usePage id="thePage"/>
				<% String myJavascript = thePage.getProperty("page.myJavascript"); %>
			</section>
			<div class="push"></div>

			<!--End Wrapper Principal de contenido-->
		</div>
			<!--Footer Template-->
			<!--Se añade la navegacion "anterior" y "siguiente" del Wizard -->
			<aside id="navFooterWizard"></aside>
			<footer id="footerRol" class="footerRol">
				<div class="footerContentWrapper">
					<div class="container">
						<ul class="links-footer">
							<li><a href="#" title="Protecci&oacute;n de datos personales" onclick="gOnclickProteccion(this);">Protecci&oacute;n de datos personales</a></li>
							<li><a href="#" onclick="gOnclickTerminos(this);">T&eacute;rminos y condiciones de uso</a></li>
						</ul>
						<div id="atencionCliente"><span>Atenci&oacute;n a clientes:</span><a href="mailto: ceac@agea.com.ar">ceac@agea.com.ar</a></div>
					</div>
				</div>
			</footer>

		<!--End Footer Template-->
	    <!-- Le javascript==================================================-->
		<!-- Commonos  -->
<%-- 		<script data-main="../js/main" src="${pageContext.servletContext.contextPath}/js/require.js" type="text/javascript"></script> --%>
		<script src="${pageContext.servletContext.contextPath}/js/lib/jquery.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/lib/modernizr.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/lib/detectizr.min.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/lib/bootstrap.min.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/lib/jquery-ui.min.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/lib/jquery.ui.datepicker-es.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/lib/jquery-ui.multidatespicker.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/lib/loader.min.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/lib/handlebars.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/lib/jquery.blockUI.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/lib/jquery.cookie.v140.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/lib/jquery.customInput.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/lib/jquery.cropit.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/lib/select2.full.min.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/lib/sequence.callerUI.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/block.callerUI.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/service.connector.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/array.utils.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/string.utils.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/model.dto.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/url.utils.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/ct.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/decorator/decorator.templates.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/decorator/decorator.model.js" type="text/javascript"></script>
		<script src="${pageContext.servletContext.contextPath}/js/decorator/decorator.controller.js" type="text/javascript"></script>


		<!-- Specifics Javascript of the decorate page -->
		<% if(myJavascript != null){ %>
			<decorator:getProperty property="page.myJavascript"/>
		<% } %>

	</body>

</html>