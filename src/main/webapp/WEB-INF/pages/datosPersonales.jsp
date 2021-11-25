<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    	<script>
		</script>
    </head>
    <body>
		<div id="mainRegister" class="container" style="display:block;">
			<section id="registroSection" class="registroSection">
				<header>
					<h2>Configuraci&oacute;n de Cuenta</h2>
					<h4>Datos personales</h4>
				</header>
				<nav id="menuDatosPersonales" style="display:none">
					<ul>
						<li class="activa"><a href="#contDatosPersonales" title="Datos personales">Datos personales</a></li>
						<li><a href="#" title="Redes sociales">Redes sociales</a></li>
						<li><a href="#" title="Alertas">Alertas</a></li>
						<li><a href="#" title="Foto de perfil">Foto de perfil</a></li>
					</ul>
				</nav>
				<section id="contDatosPersonales">
					<div class="form-login">
						<div class="formItem">
							<div class="form-group form-md-line-input has-info">
								<input class="form-control" id="apellidoField" placeholder="Apellido..." type="text" data-atributo="apellido" onfocus='gOnfocusRecuperarEstiloInputHandler(this, "error-apellido")'/>
								<label>Apellido</label>
								<span id="error-apellido" class="errorMSG"></span>
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="formItem">
							<div class="form-group form-md-line-input has-info">
								<input class="form-control" id="nombreField" placeholder="Nombre..." type="text" data-atributo="nombre" onfocus='gOnfocusRecuperarEstiloInputHandler(this, "error-nombre")'/>
								<label>Nombre</label>
								<span id="error-nombre" class="errorMSG"></span>
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="formItem">
							<div class="form-group form-md-line-input has-info">
								<!--<input class="form-control" id="emailField" placeholder="Correo Electr&oacute;nico..." type="text"/>-->
								<label>Correo Electr&oacute;nico</label>
								<p id="emailField"/>
							</div>
						</div>
						<div class="clearfix"></div>
						<!-- div class="formItem" id="antiguaPassDatPer">
							<div class="form-group form-md-line-input has-info">
								<label>Contrase&ntilde;a</label>
								<p id="oldPassText" style="display:inline-flex;">&#9679;&#9679;&#9679;&#9679;&#9679;&#9679; &nbsp; <a href="#" title="Cambiar contrase&ntilde;a" id="linkCambiaPass" onclick="gOnclickMuestraCambioPass(this)">Cambiar contrase&ntilde;a</a></p>
								<input id="oldContrasenaField" class="form-control" placeholder="Contrase&ntilde;a vieja..." style="display:none" type="password" data-atributo="oldPalabraClave" onfocus='gOnfocusRecuperarEstiloInputHandler(this, "error-oldPalabraClave")' />
								<span id="error-oldPalabraClave" class="errorMSG noDisplay">La contrase&ntilde;a anterior no es correcta</span>
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="formItem hidden" id="nuevaPassDatPer">
							<div class="formItem pull-left">
								<div class="form-group form-md-line-input has-info">
									<input class="form-control" id="nuevaContrasenaField" placeholder="Contrase&ntilde;a nueva..." type="password" data-atributo="nuevaPalabraClave" onfocus='gOnfocusRecuperarEstiloInputHandler(this, "error-nuevaPalabraClave")'/>
									<label id="NuevaPass">Contrase&ntilde;a nueva</label>
									<span>LA CONTRASE&Ntilde;A DEBE TENER COMO M&Iacute;NIMO 8 CARACTERES, AL MENOS UNA LETRA MAY&Uacute;SCULA Y UNA MIN&Uacute;SCULA</span>
									<span id="error-nuevaPalabraClave" class="errorMSG noDisplay">Ingrese la nueva contrase&ntilde;a</span>
								</div>
							</div>
							<div class="clearfix"></div>
							<div class="formItem ">
								<div class="form-group form-md-line-input has-info">
									<input class="form-control" id="checkNuevaContrasenaField" placeholder="Reingresar Contrase&ntilde;a..." type="password" data-atributo='nuevaCheckPalabraClave' onfocus='gOnfocusRecuperarEstiloInputHandler(this, "error-nuevaCheckPalabraClave")'/>
									<label id="reingNuevaPass">Reingresar contrase&ntilde;a nueva</label>
									<span id="error-nuevaCheckPalabraClave" class="errorMSG noDisplay">Las contrase&ntilde;as no coinciden</span>
								</div>
							</div>
						</div>
						<div class="clearfix"></div-->
						<div class="formItem pull-left">
								<div id="fecha_nacimiento_container" class="form-group form-md-line-input has-info">
									<label>Fecha de nacimiento</label>
									<div id="divDiaNacimiento" class="form-group form-md-line-input has-info select-style" data-resize="auto"></div>
									<div id="divMesNacimiento" class="form-group form-md-line-input has-info select-style" data-resize="auto"></div>
									<div id="divAnioNacimiento" class="form-group form-md-line-input has-info select-style" data-resize="auto"></div>
									<span id="error-fechaNacimiento" class="errorMSG noDisplay"></span>
									<span id="errorFechaInvalida" class="errorMSG noDisplay">Fecha inv&aacute;lida</span>
									<span id="errorMenorDeEdad" class="errorMSG noDisplay">Debes ser mayor de 18 a&ntilde;os para registrarte</span>
								</div>
							</div>
						<div class="clearfix"></div>
						<div class="formItem">
							<div class="innerCenterFields">
								<label class="pull-left labelForm" style="display:none">Sexo:</label>
								<label id="labelradioHombre" class="pull-left radio radio-custom" for="radioHombre">Hombre</label>
								<input type="radio" class="pull-left" name="radioGenero" id="radioHombre" data-label="Hombre" data-value="M"/>
								<label id="labelradioMujer" class="pull-left radio radio-custom" for="radioMujer">Mujer</label>
								<input type="radio" class="pull-left" name="radioGenero" id="radioMujer" data-label="Mujer" data-value="F"/>
							</div>
							<span class="errorMSG"></span>
						</div>

						<div class="clearfix"></div>
						<div class="formItem">
							<div class="form-group form-md-line-input has-info">
								<input class="form-control" id="dniField" placeholder="DNI..." type="text" maxlength="8" data-atributo="dni" onfocus='gOnfocusRecuperarEstiloInputHandler(this, "error-dni")'/>
								<label>DNI</label>
								<span>El DNI debe tener al menos 7 d&iacute;gitos</span>
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="formItem pull-left">
							<div class="innerCenterFields">
								<span id="errorPASENegocio" class="errorMSG errorNegocio noDisplay"></span>
							</div>
						</div>

						<div class="clearfix"></div>
						<div class="formItem">
							<div id="cancelarBtn" class="pull-left loginBtnCancel botonIzquierdo">Cancelar</div>
							<div id="DatosPersonalesBtn" class="pull-left loginBtnOk disabledBtn botonDerecho">Aceptar</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</section>
			</section>
		</div>

		<!-- Scoring -->
		<noscript><p><img src="http://b.scorecardresearch.com/p?c1=2&amp;c2=6906409&amp;ns_site=clasificadosclarin&amp;name=receptoriaonline.datos-personales" height="1" width="1" alt="*"></p></noscript>

		<!-- Colocar aqui los include de js necesarios para la pantalla -->
		<content tag="myJavascript">
			<script src="${pageContext.servletContext.contextPath}/js/url.utils.js" type="text/javascript" charset="cp1252"></script>
			<script src="${pageContext.servletContext.contextPath}/js/datos-personales/datosPersonales.controller.js" type="text/javascript" charset="cp1252"></script>
			<script src="${pageContext.servletContext.contextPath}/js/datos-personales/datosPersonales.templates.js" type="text/javascript" charset="cp1252"></script>
			<script src="${pageContext.servletContext.contextPath}/js/lib/jquery.customInput.js" type="text/javascript" charset="cp1252"></script>
		</content>
    </body>
</html>