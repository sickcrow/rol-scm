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
					<h2>Registro</h2>
				</header>
				<section id="register-LoginForm">
				
				<div class="info-login">
					<h5>Record&aacute; que si ya ten&eacute;s tu cuenta PASE Clar&iacute;n no necesit&aacute;s registrarte.</h5>
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
							<div class="form-group form-md-line-input has-info">
								<input class="form-control" id="emailField" placeholder="Correo Electr&oacute;nico..." type="text" data-atributo="email" onfocus='gOnfocusRecuperarEstiloInputHandler(this, "error-email")'/>
								<label>Correo Electr&oacute;nico</label>
								<span id="error-email" class="errorMSG"></span>
							</div>
						</div>	
						<div class="clearfix"></div>
						<div class="formItem pull-left">
							<div class="form-group form-md-line-input has-info">
								<input class="form-control" id="contrasenaField" placeholder="Contrase&ntilde;a..." type="password" data-atributo="palabraClave" onfocus='gOnfocusRecuperarEstiloInputHandler(this, "error-palabraClave")'/>
								<label>Contrase&ntilde;a</label>
								<span>LA CONTRASE&Ntilde;A DEBE TENER COMO M&Iacute;NIMO 8 CARACTERES, AL MENOS UNA LETRA MAY&Uacute;SCULA Y UNA MIN&Uacute;SCULA</span>
								<span id="error-palabraClave" class="errorMSG"></span>
							</div>
						</div>
						<div class="clearfix"></div>
						<div class="formItem pull-left">
							<div class="form-group form-md-line-input has-info">
								<input class="form-control" id="contrasenaCheckField" placeholder="Reingresar Contrase&ntilde;a..." type="password" data-atributo='checkPalabraClave' onfocus='gOnfocusRecuperarEstiloInputHandler(this, "error-checkPalabraClave")'/>
								<label>Reingresar Contrase&ntilde;a</label>
								<span id="error-checkPalabraClave" class="errorMSG noDisplay">Las contrase&ntilde;as no coinciden</span>
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
								<input class="form-control" id="dniField" placeholder="DNI..." type="text" maxlength="8" data-atributo="dni" onfocus='gOnfocusRecuperarEstiloInputHandler(this, "error-dni")'/>
								<label>DNI</label>
								<span>El DNI debe tener al menos 7 d&iacute;gitos</span>
							</div>
						</div>		
						<div class="clearfix"></div>
						<div class="formItem">
							<div class="innerCenterFields">
								<label class="pull-left radio radio-custom" for="radioHombre">Hombre</label>
								<input type="radio" class="pull-left" name="radioGenero" id="radioHombre" checked="checked" data-label="Hombre" data-value="M"/>
								<label class="pull-left radio radio-custom" for="radioMujer">Mujer</label>
								<input type="radio" class="pull-left" name="radioGenero" id="radioMujer" data-label="Mujer" data-value="F"/>
							</div>
							<span class="errorMSG"><!-- Empty --></span>
						</div>		
						<div class="clearfix"></div>
						
						
						
						<!-- captcha - begin -->
						<div class="formItem">
							<div id="captchaModule" class="innerCenterFields">
								<input id=defaultReal type="hidden" name="defaultReal" class="loginInput">
							</div>
							<span class="errorMSG"></span>
						</div>
						<div class="formItem pull-left">
							<div id="reCaptchaModule" class="form-group form-md-line-input has-info">
								<input class="form-control" placeholder="Texto de la im&aacute;gen..." id="defaultReallabel" type="text" name="defaultReallabel" maxlength="6" data-atributo='captcha' onfocus='gOnfocusRecuperarEstiloInputHandler(this, "errorDefaultReallabel")'/>
								<label>Texto de la im&aacute;gen</label>
								<span id="errorDefaultReallabel" class="errorMSG noDisplay">Debe coincidir el texto con la im&aacute;gen</span>
							</div>
							<span class="errorMSG"></span>
						</div>
						<!-- captcha - end -->
						
						
						
						<div class="clearfix"></div>
						<div class="formItem pull-left">
							<div class="innerCenterFields MedioRubroMainWrapper divTerminosCondiciones">
								<div id="termsCondiciones">
									<input type="checkbox" id="checkTerminosCondiciones" />
									<label class="checkbox checkbox-custom" for="checkTerminosCondiciones">Acepto los <a href="#" onclick="gOnclickTerminos(this);">t&eacute;rminos y condiciones</a></label>
								</div>
							</div>
							<span class="errorMSG"></span>
						</div>						
						
						<div class="clearfix"></div>
						
						<div>
							<div id="cancelarBtn" class="pull-left loginBtnCancel botonIzquierdo">Cancelar</div>
							<div id="RegistrarBtn" class="pull-left loginBtnOk disabledBtn botonDerecho">Registrarme</div>
							<div class="clearfix"></div>
							<p class="errorMSG"></p>
							<div id="errorPASENegocio" class="errorMSG"></div>
						</div>
												 
						<div class="clearfix"></div>
					</div>
				</section>					
			</section>
		</div>
		
		<!-- Scoring -->
		<noscript><p><img src="http://b.scorecardresearch.com/p?c1=2&amp;c2=6906409&amp;ns_site=clasificadosclarin&amp;name=receptoriaonline.registro" height="1" width="1" alt="*"></p></noscript>
		
		<!-- Colocar aqui los include de js necesarios para la pantalla -->
		<content tag="myJavascript">
			<script src="${pageContext.servletContext.contextPath}/js/lib/jqueryRealPerson.js" type="text/javascript" charset="cp1252"></script>
			<script src="${pageContext.servletContext.contextPath}/js/lib/jquery.customInput.js" type="text/javascript" charset="cp1252"></script>
			<script src="${pageContext.servletContext.contextPath}/js/registrarme/registrarme.controller.js" type="text/javascript" charset="cp1252"></script>
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
