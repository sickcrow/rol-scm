<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    	<script>
		</script>
    </head>
    <body>
		<div id="mainLogin" class="container">
			<section id="loginSection" class="loginSection">
				<header>
					<!-- <h2>Identificate para publicar tu aviso</h2> -->
					<h2>Bienvenido a ReceptoriaOnline</h2>
				</header>
				<section id="register-LoginForm">
					
					<!-- chau alert de usuario logueado!!! -->
					<!-- 
					<div id="divUsuarioLogueado" class="alert alert-warning fade in" style="display: none">
				        <button data-hidden="true" data-dismiss="alert" class="close" type="button">&times;</button>
				        Existe otra sesi&oacute;n donde ha ingresado otro usuario. Por favor recargue la p&aacute;gina.
			      	</div>
			      	 -->
					
					<!-- Confirmara la cuenta con auth0??? -->
					<div id="divUsuarioSuccess" class="alert alert-warning fade in" style="display: none">
				        <button data-hidden="true" data-dismiss="alert" class="close" type="button">&times;</button>
				        Gracias por registrarte. Recibir&aacute;s un correo electr&oacute;nico para confirmar tu cuenta.
			      	</div>
					
					<!-- 
					<div id="leftLogin" class="pull-left">
						<div id="leftLoginContent" class="pull-left">
							
							<!-- chau esto de mail para cambiar la contraseña o con auth0 aun vuelve y se mantiene? -->
							<!-- 
							<div id="correoPasswordEnviado" class="alert alert-warning fade in" style="display: none">
						        <button data-hidden="true" data-dismiss="alert" class="close" type="button">&times;</button>
						        Te hemos enviado un email a la casilla de correo electr&oacute;nico para que puedas cambiar tu contrase&ntilde;a
					      	</div>
					      	 -->
							
					      	<!--<div class="info-login">
					      		<!-- <h5>Record&aacute; que si ya ten&eacute;s tu cuenta PASE Clar&iacute;n no necesit&aacute;s registrarte.</h5> -->
					      		<!-- Cambio a cuenta Clarin quitando PASE-->
					      		<!-- <h5>Record&aacute; que si ya ten&eacute;s tu cuenta Clar&iacute;n no necesit&aacute;s registrarte.</h5>
							</div> -->
							
							<!-- Chau div de login -->
							<!-- 
							<div class="form-login">
								<div class="formItem pull-left">
									<div class="form-group form-md-line-input has-info">
										<input class="form-control" type="text" data-atributo="email" name="email" id="emailField" value="" onfocus='gOnfocusRecuperarEstiloInputHandler(this, "errorPASENegocio")' placeholder="Correo Electr&oacute;nico...">
										<label>Correo electr&oacute;nico </label>
									</div>

								</div>
								<div class="clearfix"></div>
								<div class="formItem pull-left">
									<div class="form-group form-md-line-input has-info">
										<input class="form-control" id="contrasenaField" name="passLogin" value="" placeholder="Contrase&ntilde;a..." type="password" data-atributo="palabraClave" onfocus='gOnfocusRecuperarEstiloInputHandler(this, "errorPASENegocio")'>
										<label>Contrase&ntilde;a </label>
									</div>
								</div>
								 -->

								<!-- <div class="clearfix"></div> -->
								
								<!-- Chau captcha -->
								<!-- captcha - begin -->
								<!--
								<div id="divCaptchaLogin" style="display:none; margin-top:20px;">
								<div class="formItem">
									<div id="captchaLoginModule" class="innerCenterFields">
										<input id=captchaLogin type="hidden" name="captchaLogin">
									</div>
									<span class="errorMSG"></span>
								</div>
								<div class="formItem pull-left">
									<div id="reCaptchaLoginModule" class="innerCenterFields">
										<input placeholder="Texto de la im&aacute;gen..." id="captchaLoginlabel" class="pull-left loginInput" type="text" name="captchaLoginlabel" maxlength="6" data-atributo="captcha" onfocus='gOnfocusRecuperarEstiloInputHandler(this, "errorCaptchaLoginlabel")'/>
										<span id="errorCaptchaLoginlabel" class="errorMSG noDisplay">Debe coincidir el texto con la im&aacute;gen</span>
										<span class="errorMSG"></span>
									</div>
									</div>
									<div class="clearfix"></div>
								</div>
								-->
								<!-- captcha - end -->
								
								
								<!-- <div class="clearfix"></div> -->


								<!-- Chau olvide mi contrasena -->
								<!--
								<div class="formItem pull-left">
									<div id="olvidarPass">Olvid&eacute; mi contrase&ntilde;a</div>
								</div>
								<div class="clearfix"></div>
								<div>
									<div id="cancelarBtn" class="pull-left loginBtnCancel botonIzquierdo">Cancelar</div>
									<div id="IngresarBtn" class="pull-right loginBtnOk disabledBtn botonDerecho">Ingresar</div>
								</div>
								<div class="clearfix"></div>
								<div>
									<div id="crearCuentaBtn" class="loginCreateAccount" title="Crear una cuenta nueva" onclick="gOnclickRedirectRegistrarHanlder(URLConstants.ROL_REGISTRARME)">Crear una cuenta nueva</div>
								</div>
								<div class="clearfix"></div>

								<div id="errorPASENegocio" class="errorMSG"></div>
								 -->
							<!-- </div> -->

							<!-- <div class="clearfix"></div> -->

						<!-- </div> -->

						<!-- //////////////////////////////////////////////////////////////////////// -->

						<!-- 
						<div id="olvidePass" class="pull-left">
					      	<div class="info-login">
								<h5>Recibir&aacute;s un mensaje en tu casilla con los datos para cambiar tu contrase&ntilde;a.</h5>
							</div>

							<div class="form-login">
								<div class="formItem pull-left">
									<div class="form-group form-md-line-input has-info">
										<input class="form-control" type="text" id="mailOlvida" name="mailOlvida" value="" placeholder="Correo Electr&oacute;nico..." type="text"/>
										<label>Correo Electr&oacute;nico </label>
										<span>Record&aacute; utilizar el mismo correo con el que te registraste</span>
										<span class="errorMSG"></span>
									</div>
								</div>

								<div class="clearfix"></div>

								<!-- captcha - begin -->
								<!--
								<div class="formItem">
									<div id="captchaModule" class="innerCenterFields">
										<input id=defaultReal type="hidden" name="defaultReal" class="loginInput" />
									</div>
									<span class="errorMSG"></span>
								</div>
								<div class="formItem pull-left">
									<div id="reCaptchaModule" class="form-group form-md-line-input has-info">
										<input class="form-control" type="text" placeholder="Texto de la im&aacute;gen..." id="defaultReallabel" name="defaultReallabel" maxlength="6" data-atributo='captcha' onfocus='gOnfocusRecuperarEstiloInputHandler(this, "errorDefaultReallabel")'/>
										<label>Texto de la imagen </label>
										<span id="errorDefaultReallabel" class="errorMSG noDisplay"></span>
									</div>
									<span class="errorMSG"></span>
								</div>
								<!-- captcha - end -->
								
								<!--
								<div class="clearfix"></div>

								<div>
									<div id="cancelaLogin" class="pull-left loginBtnCancel botonIzquierdo">Cancelar</div>
									<div id="recuerdaPassBtn" class="pull-right loginBtnOk disabledBtn botonDerecho">Cambiar</div>
								</div>
								<div class="clearfix"></div>
								<div>
									<div id="crearCuentaBtn" class="loginCreateAccount" title="Crear una cuenta nueva" onclick="gOnclickRedirectRegistrarHanlder(URLConstants.ROL_REGISTRARME)">Crear una cuenta nueva</div>
								</div>

								<div class="formItem pull-left">
									<div class="innerCenterFields">
										<span id="errorPASENegocioRecupPasswd" class="errorMSG errorNegocio noDisplay"></span>
									</div>
								</div>
								 
							</div>

							<div class="clearfix"></div>
						</div>
						 -->
						 
					<div id="leftLogin" class="pull-left">
						<div id="leftLoginContent" class="pull-left">						 
						 
						<div id="ingresaDni">
							<div id="bienvenidaUsuario" class="alert alert-warning fade in">
								<button data-hidden="true" data-dismiss="alert" class="close" type="button">&times;</button>
						        Hola, has ingresado correctamente.
							</div>
							<div class="info-login">
								<h5>Para poder continuar debes completar los siguientes datos de tu cuenta.</h5>
							</div>
							<div class="form-login">
								<div class="formItem pull-left">
									<div class="form-group form-md-line-input has-info">
										<input class="form-control" id="apellidoField" placeholder="Apellido..." type="text" data-atributo="apellido" onfocus='gOnfocusRecuperarEstiloInputHandler(this, "error-apellido")'/>
										<label>Apellido</label>
										<span id="error-apellido" class="errorMSG"></span>
									</div>
								</div>
								<div class="clearfix"></div>	
								<div class="formItem pull-left">
									<div class="form-group form-md-line-input has-info">
										<input class="form-control" id="nombreField" placeholder="Nombre..." type="text" data-atributo="nombre" onfocus='gOnfocusRecuperarEstiloInputHandler(this, "error-nombre")'/>
										<label>Nombre</label>
										<span id="error-nombre" class="errorMSG"></span>
									</div>
								</div>
								<div class="clearfix"></div>
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
								<div class="formItem pull-left">
									<div id="register-dni" class="form-group form-md-line-input has-info">
										<label id="dniLabel">DNI</label>
										<input id="dniHub" class="pull-left loginInput" placeholder="DNI..." name="dniHub" type="text" maxlength="8" data-atributo="dni" onfocus='gOnfocusRecuperarEstiloInputHandler(this, "error-dni")' />
										<span id="error-dni" class="errorMSG noDisplay">El DNI debe tener al menos 7 d&iacute;gitos</span>
									</div>
								</div>
								<div class="clearfix"></div>
								<div class="formItem">
									<div class="innerCenterFields">
										<label class="pull-left radio radio-custom" for="radioHombre" id="labelradioHombre">Hombre</label>
										<input type="radio" class="pull-left" name="radioGenero" id="radioHombre" checked="checked" data-label="Hombre" data-value="M"/>
										<label class="pull-left radio radio-custom" for="radioMujer" id="labelradioMujer">Mujer</label>
										<input type="radio" class="pull-left" name="radioGenero" id="radioMujer" data-label="Mujer" data-value="F"/>
									</div>
									<span class="errorMSG"><!-- Empty --></span>
								</div>
								<div class="clearfix"></div>
								<div class="formItem pull-left">
									<div class="innerCenterFields">
										<div id="termsCondiciones">
											<input type="checkbox" id="checkTerminosCondiciones" />
											<label class="checkbox checkbox-custom" for="checkTerminosCondiciones">Acepto los <a href="#" onclick="gOnclickTerminos(this);">t&eacute;minos y condiciones</a></label>
										</div>
									</div>
									<span class="errorMSG"></span>
								</div>
								<div class="clearfix"></div>
								<div>
									<div id="linkCancelarDni" title="Cancelar" class="pull-left loginBtnCancel botonIzquierdo" onclick="gOnclickLinkCancelar()">Cancelar</div>
									<div id="ingresaDniBtn" class="pull-left loginBtnOk disabledBtn botonDerecho">Continuar</div>
								</div>
								<div class="clearfix"></div>
								<!-- DEPRECATED - ya no hay animacion de sube y baja -->
								<!-- <p><a href="#" title="Anterior" id="linkAnteriorDni" class="pull-left" onclick='gOnclickLinkAnterior()'>Anterior</a></p> -->
							</div>
						</div>
						
					</div>

					</div>
				</section>
			</section>
		</div>

		<!-- Scoring -->
		<noscript><p><img src="http://b.scorecardresearch.com/p?c1=2&amp;c2=6906409&amp;ns_site=clasificadosclarin&amp;name=receptoriaonline.login" height="1" width="1" alt="*"></p></noscript>

		<!-- Colocar aqui los include de js necesarios para la pantalla -->
		<content tag="myJavascript">
        	<script src="${pageContext.servletContext.contextPath}/js/login/login.controller.js" type="text/javascript" charset="cp1252"></script>
        	<script src="${pageContext.servletContext.contextPath}/js/lib/jqueryRealPerson.js" type="text/javascript" charset="cp1252"></script>
        	<script src="${pageContext.servletContext.contextPath}/js/registrarme/registrarme.templates.js" type="text/javascript" charset="cp1252"></script>
        	<script type="text/javascript" charset="cp1252">
				$(document).ready(function(){
	     			$(function(){
	         			$('input').customInput();
	         		});
				});
			</script>
		</content>
    </body>
</html>