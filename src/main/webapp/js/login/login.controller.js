/**
 * author: mdenicolo
 * version: 1.0.0
 * description: Clase que vincula la UI con la logica en la pantalla de login.
 */

//-----------------------------------------------------------------------------
//loginController -------------------------------------------------------
//-----------------------------------------------------------------------------

var loginController = (function () {

	//------------------------------------------------
	// global interface ------------------------------
	//------------------------------------------------

	gOnclickRedirectIngresarHanlder = function(url){
		if(model.uuid != null){
			url = url+'?uuid='+model.uuid;
		}
		redirect(url);
	};

	gOnclickRedirectRegistrarHanlder = function(url){
		if(model.uuid != null){
			url = url+'?uuid='+model.uuid;
		}
		redirect(url);
	};
	
	gOnfocusRecuperarEstiloSelectHandler = function(component){
		component.style.borderColor = '#CCCCCC';
		component.style.borderWidth = '1px';
	}

	gOnfocusRecuperarEstiloInputHandler = function(component, componentError){
		if(component.className.includes('warning')){
			component.classList.remove('warning');
			document.getElementById(componentError).className='errorMSG errorNegocio noDisplay';
		}
		if(componentError == 'error-dni'){
			$('#register-dni').removeClass('warning');
		}
	}
	
	gOnfocusRecuperarEstiloFechaHandler = function(){
		$('#fecha_nacimiento_container').removeClass('warning');
		$('#divDiaNacimiento').removeClass('warning');
		$('#divMesNacimiento').removeClass('warning');
		$('#divAnioNacimiento').removeClass('warning');
		$('#errorFechaInvalida').addClass('noDisplay');
		$('#errorMenorDeEdad').addClass('noDisplay');
	}

	//DEPRECATED - 18/08/2021 - Auth0
	gOnclickLinkAnterior = function(){
		//viendo la funciones gOnclickLinkAnterior y gOnclickLinkCancelar - quito el anterior del jsp ya que no hay animacion sube y baja ya

		// Limpio cookies para que loguee de vuelta.
		decoratorController.removeCookie();
		decoratorController.removeCookieUsuario();
		
		$.blockUI({ message: null,overlayCSS: { backgroundColor: 'transparent' } });
        setTimeout($.unblockUI, 1550);
		$("#leftLoginContent").css({"position":"relative","width":"100%","left":"-1000px","top":"0px"}).animate({
			"left":"0px",
			"width":"100%"
		}, 1500);
		$("#ingresaDni").css({"display":"block","position":"relative","width":"100%","top":"-400px"}).animate({
			"top":"1000px"
		}, 2000, function(){
			$(this).hide();
		});
		$("#footerRol").css({"margin-top":"0px"}).animate({
			"top":"0px",
		}, 1500);
		$("#rightLoginContent").show();
	}

	gOnclickLinkCancelar = function(){
		// Limpio cookies pq cancelo post PASE
		decoratorController.removeCookie();
		decoratorController.removeCookieUsuario();

		redirectMain(model.uuid);
	}

	//------------------------------------------------
	// private interface -----------------------------
	//------------------------------------------------

	var defaultErrorHandler = function(jqXHR, textStatus, errorThrown){
		alert("Ha ocurrido un error: " + jqXHR.responseText + " " + jqXHR.status + " " + jqXHR.statusText);
	};

	var buildValidateAnuncianteDTO = function(){
		return new ValidateAnuncianteDTO({
			usuarioPASE					: ui.campoEmail[0].value
		})
	};

	var validarDNI = function(){
		if(ui.campoDni[0].value.trim().length < 7 || parseInt(ui.campoDni[0].value) < 1000000 ){
			return false;
		}
		return true;
	};

	var mostrarDivDNIAnunciante = function(){
		//$.blockUI({ message: null,overlayCSS: { backgroundColor: 'transparent' } });
        //setTimeout($.unblockUI, 1550);
		//cargo el nombre de usuario en el popover
        //Con el cambio de PASE ya no - vdenicolo - 28/06/2018
        //ui.usuarioDniPopover[0].innerHTML =  decoratorModel.getUsuarioTemporal().nombre;
        
        //auto completo los datos que vengan - vdenicolo - 13/09/2018
        if(decoratorModel.getUsuarioTemporal().nombre !== undefined){
        	ui.campoNombre[0].value = decoratorModel.getUsuarioTemporal().nombre;
        }
        if(decoratorModel.getUsuarioTemporal().apellido !== undefined){
        	ui.campoApellido[0].value = decoratorModel.getUsuarioTemporal().apellido;
        }
        
		if(decoratorModel.getUsuarioTemporal().fechaNacimiento !== undefined){
			seleccionarFechaNacimiento(decoratorModel.getUsuarioTemporal().fechaNacimiento);
		}
		if(decoratorModel.getUsuarioTemporal().genero !== undefined){
			seleccionarCheckboxSexo(decoratorModel.getUsuarioTemporal().genero);
		}

		/*$("#leftLoginContent").css({"position":"absolute","width":"100%","left":"360px","top":"160px"}).animate({
			"left":"-1800px"
		}, 1500);
		$("#olvidePass").css({"position":"absolute","width":"100%","top":"160px"}).animate({
			"top":"-1500px"
		}, 1500);
		$("#ingresaDni").css({"display":"block","position":"relative","width":"100%","top":"1500px"}).animate({
			"top":"0px"
		}, 1500);
		$("#footerRol").css({"margin-top":"160px"}).animate({
			"top":"0px"
		}, 1500);
		$("#rightLoginContent").hide();
		$(".alert").hide();
		$("#bienvenidaUsuario").show("slow", function(){
			$(this).css({
						"display" : "inline-block",
						"width" : "100%"
						});
		});*/
	};
	
	var seleccionarFechaNacimiento = function(fechaNacimiento){
		var fecha = $.datepicker.parseDate("yy-mm-dd", fechaNacimiento);
		var dia = fecha.getDate();
		var mes = fecha.getMonth()+1;
		var anio = fecha.getFullYear();

		seleccionarValorOption($('#diaNacimiento')[0].options, dia);
		seleccionarValorOption($('#mesNacimiento')[0].options, mes);
		seleccionarValorOption($('#anioNacimiento')[0].options, anio);
		
	}
	
	var seleccionarValorOption = function(opciones, valor){
		for(var i = 0; i<opciones.length; i++){
			if($(opciones[i]).data('value') == valor){
				$(opciones[i]).prop('selected', true);
				break;
			}
		}
	}
	
	var seleccionarCheckboxSexo = function(genero){
		if(genero.toUpperCase() == 'M'){
			$('#radioHombre').prop('checked', true);
			$('#labelradioMujer').removeClass('checked');
			$('#labelradioHombre').addClass('checked');
		}else if(genero.toUpperCase() == 'F'){
			$('#radioMujer').prop('checked', true);
			$('#labelradioHombre').removeClass('checked');
			$('#labelradioMujer').addClass('checked');
		}
	}

	var marcarErrorFechaNacimiento = function(){
		$('#divDiaNacimiento').addClass('warning');
		$('#divMesNacimiento').addClass('warning');
		$('#divAnioNacimiento').addClass('warning');
		$('#fecha_nacimiento_container').addClass('warning');
	};
	
	var marcarErrorInput = function(atributo){
		$("input[data-atributo='"+atributo+"']").addClass('warning');
	};

	var tieneErrores = function(listaErrores){
		if(listaErrores.length == 0){
			return false;
		}
		return true;
	};

	var cargarCookieUsuarioModel = function(data){

		decoratorController.setCookie(data.object.pasecookie, null);
		decoratorController.setCookieUsuario(data.object.paseusuario, null);

		decoratorModel.setUsuario(decoratorController.getCookieUsuario());
	}

	var cargarUsuarioTemporal = function(data){
		//decoratorModel.setUsuarioTemporal(data.object.paseusuario);
		if(data.object !== undefined){
			decoratorModel.setUsuarioTemporal(data.object.capturador);
		} else {
			decoratorModel.setUsuarioTemporal(decoratorModel.getUsuario());
		}
	}

	var traducirAtributo = function(atributo){
		if(atributo == "EMAIL"){
			return 'email';
		}
		if(atributo == "CONTRASENIA"){
			return 'palabraClave';
		}
	}

	var usuarioPASEValidadoHandler = function(data){

		var listaErrores = data.errors;

		//esto de lo errores no va mas pq no se llama al servicio de pase, nombre y apellido lo saca de pase y pueden no venir...
		//del llamado de pase tambien viene capturador!!
		
		//si no tiene errores ==> SUCCESS
		if( !tieneErrores(listaErrores) ){
			
			//Dado que ahora pueden venir null los datos nombre y apellido trato de usar los del capturador si vienen
			if(data.object.paseusuario.nombre === undefined && data.object.capturador.nombre !== undefined){
				data.object.paseusuario.nombre = data.object.capturador.nombre;
				
			}
			if(data.object.paseusuario.apellido === undefined && data.object.capturador.apellido !== undefined){
				data.object.paseusuario.apellido = data.object.capturador.apellido;
			}

			decoratorController.setCookie(data.object.pasecookie, null);
			decoratorController.setCookieUsuario(data.object.paseusuario, null);
			decoratorController.setCookieCapturador(data.object.capturador, null);

			decoratorModel.setUsuario(decoratorController.getCookieUsuario());
			

			if(model.uuid != null && model.uuid != ""){
				redirectMain(model.uuid);
			}else{
				redirect(URLConstants.ROL_MIS_AVISOS);
			}

		}else{

			for (var i = 0; i < listaErrores.length; i++){

				//chequeo si es de redirect ==> esta en PASE y no en HUB
				if(listaErrores[i].errorType == ROLErrorTypeConstants.REDIRECTION){

					decoratorController.model.tempCookie = data;
					cargarUsuarioTemporal(data);
					mostrarDivDNIAnunciante();
					break;

				}else{

					//manejo de errores
					if(listaErrores[i].errorType == ROLErrorTypeConstants.VALIDATION){

						//si esta en atributos marco el campo
						if(listaErrores[i].fieldName != ""){
							marcarErrorInput( traducirAtributo(listaErrores[i].fieldName) );
						}

						//muestro el error y acumulo
						ui.campoErrorNegocio.removeClass('noDisplay');
						ui.campoErrorNegocio[0].innerHTML += "<p>" + listaErrores[i].message + "</p>";

					}

					if(listaErrores[i].errorType == ROLErrorTypeConstants.SECURITY){
						if(listaErrores[i].message == TraduccionSecurityError.VALIDATE_CAPTCHA){
							mostrarDivCaptchaLogin();
						}else{
							marcarErrorCaptchaLoginDistintas();
						}
					}

					if(listaErrores[i].errorType == ROLErrorTypeConstants.EXCEPTION){
						alert(listaErrores[i].message);
					}

				}

			}

		}

	};

	var mostrarDivCaptchaLogin = function(){
		model.validateCaptcha = true;
		ui.divCaptchaLogin[0].style.display = "block";
        $(".realperson-regen").trigger("click");
	}

	var buildUsuarioDTO = function(){
		
		var captcha = new CaptchaDTO({
			hashValue							: $('#captchaLoginModule input[name=captchaLoginHash]').val(),
			inputValue							: ui.reCaptchaLogin[0].value
		});

		return new UsuarioDTO({
			email								: ui.campoEmail[0].value,
			palabraClave						: ui.campoContrasena[0].value,
			captcha								: captcha
		})
	};

	var onClickIngresarHandler = function(){

		if (ui.btnIngresar.hasClass("disabledBtn")){
			return false;
		}else{

			//si viene de un error de negocio se lo limpio
			if (!ui.campoErrorNegocio.hasClass("noDisplay")){
				ui.campoErrorNegocio.addClass("noDisplay");
			}
			ui.campoErrorNegocio[0].innerHTML = "";

			//limpio mensaje
			ui.divUsuarioLogueado[0].style.display = 'none';
			ui.divUsuarioSuccess[0].style.display = 'none';


			// TODO valido email
			/*
			var validateInput = function(component, regEx){
			if(regEx != null && regEx != ''){
				var pattern = new RegExp(regEx);
				if(!pattern.test(component[0].value)){
					return false;
				}
			}
			return true;
			};
			*/

			//Lo que veo es que del usuarioCookie solo le interesa el email y lo manda con el captcha y la pass a pase
			//esto ya no se usa pero si tengo que tener el email
			//---
			var usuarioCookie = decoratorController.getCookieUsuario();

			if( usuarioCookie != null && usuarioCookie.email != ui.campoEmail[0].value){
				ui.divUsuarioLogueado[0].style.display = 'block';
			
			//quito el else para que si vaya a hacer cosas al back
			//}else{

				//valido login con PASE
				blockCallerUI.blockPost({ url : LoginServiceURL.LOGIN_USUARIO,
					dataObject : buildUsuarioDTO(),
					successHandlerCallback : usuarioPASEValidadoHandler,
					errorHandlerCallback : defaultErrorHandler });

			}
			//---

		}

	};
	
	var isFechaInvalida = function(y,m,d){
		/*Como javascript automaticamente convierte una fecha inexistente a su posterior existente
		 * por ej (31 abril = 1 mayo) entonces valido que lo que llega sea igual a lo que convierte
		 */
		var date = new Date(y,m-1,d);
		var convertedDate =	""+date.getFullYear() + (date.getMonth()+1) + date.getDate();
		var givenDate = "" + y + m + d;
		return ( givenDate != convertedDate);
	};

	var isMenorDeEdad = function(y,m,d){
		var today = new Date();
		var fechaMenorDeEdad = new Date(today.getFullYear()-18, today.getMonth(), today.getDate());
		var fechaIngresada = new Date(y,m-1,d);
		return (fechaIngresada > fechaMenorDeEdad);
	};

	var validarFechaNacimiento = function(){
		var error = false;

		var diaSelected = $($('#diaNacimiento')[0].options[$('#diaNacimiento')[0].selectedIndex]).data('value');
		var mesSelected = $($('#mesNacimiento')[0].options[$('#mesNacimiento')[0].selectedIndex]).data('value');
		var anioSelected = $($('#anioNacimiento')[0].options[$('#anioNacimiento')[0].selectedIndex]).data('value');


		error = isFechaInvalida(anioSelected,mesSelected,diaSelected);
		if(error){
			marcarErrorFechaNacimiento();
			$('#errorFechaInvalida').removeClass('noDisplay');
			return false;
		}

		error = isMenorDeEdad(anioSelected,mesSelected,diaSelected);
		if(error){
			marcarErrorFechaNacimiento();
			$('#errorMenorDeEdad').removeClass('noDisplay');
			return false;
		}

		return true;
	};

	var validarDNI = function(){
		if(ui.campoDni[0].value.trim().length < 7 || parseInt(ui.campoDni[0].value) < 1000000 ){
			return false;
		}
		return true;
	}

	var usuarioPASERegistradoEnHUBHandler = function(data){

		cargarCookieUsuarioModel(data);
		decoratorController.setCookieCapturador(data.object.capturador, null);

		if(model.uuid != ""){
			redirectMain(model.uuid);
		}else{
			redirect(URLConstants.ROL_MIS_AVISOS);
		}

	};

	
	var buildUpdateUsuarioPaseDTO = function(){
		return new UsuarioDTO({
			codigoTipoAnunciante			: AtributosCapturadorConstants.CODIGO_TIPO_ANUNCIANTE,
			codigoCliente					: AtributosCapturadorConstants.CODIGO_CLIENTE,
			email							: decoratorModel.getUsuarioTemporal().email,
			nombre							: ui.campoNombre[0].value,
			apellido						: ui.campoApellido[0].value,
			codigoMedioPagoPrincipal		: AtributosCapturadorConstants.CODIGO_MEDIO_PAGO_PRINCIPAL,
			codigoTipoIVA					: AtributosCapturadorConstants.CODIGO_TIPO_IVA,
			codigoCanalEntrada				: AtributosCapturadorConstants.CODIGO_CANAL_ENTRADA,
			codigoTipoDocumento				: AtributosCapturadorConstants.CODIGO_TIPO_DOCUMENTO,
			numeroDocumento					: ui.campoDni[0].value,
			usuarioExternoCodigo			: decoratorModel.getUsuarioTemporal().usuarioExternoCodigo,
			genero							: $($("input[name='radioGenero']:checked")[0]).data('value'),
			fechaNacimiento					: $($('#anioNacimiento')[0].options[$('#anioNacimiento')[0].selectedIndex]).data('value')+'-'+
												$($('#mesNacimiento')[0].options[$('#mesNacimiento')[0].selectedIndex]).data('value')+'-'+
												$($('#diaNacimiento')[0].options[$('#diaNacimiento')[0].selectedIndex]).data('value')+' 00:00:00.000'	//NO QUITAR								
		});
	};

	var guardarCapturadorHUB = function(){
		blockCallerUI.blockPost({ url : LoginServiceURL.UPDATE_USUARIO_PASE,
			dataObject : buildUpdateUsuarioPaseDTO(),
			successHandlerCallback : usuarioPASERegistradoEnHUBHandler,
			errorHandlerCallback : defaultErrorHandler });
	};

	var onClickContinuarHandler = function(){

		try {
			if(Modernizr.Detectizr.device.browser === "ie"){
				if ($("#ingresaDniBtn").hasClass("disabledBtn")){
					return false;
				}
			}
	    }
	    catch (e) {
		     /**/
	    }

		model.validacionRegistro = true;
		if (ui.btnIngresar.hasClass("disabledBtn")){
			return false;
		}else{
			
			//valido fecha de nacimiento
			var fechaValidadaOK = validarFechaNacimiento();
			if(!fechaValidadaOK){
				model.validacionRegistro = false;
			}
			
			//valido dni
			var dniValidadoOK = validarDNI();
			if(!dniValidadoOK){
				marcarErrorInput('dni');
				$("#register-dni").addClass('warning');
				ui.errorDni.removeClass('noDisplay');
				model.validacionRegistro = false;
			}

			//Si no tiene errores
			if(model.validacionRegistro){
				
				//ahora adamas de guardar el capturador va a actualizar el usuario PASE
				guardarCapturadorHUB();
				
				//redirectMain(model.uuid);
			}

		}
	};

	var checkEmailCompletado = function(){
		if(ui.campoEmail[0].value.trim().length > 0){
			return true;
		}
		return false;
	};

	var checkContrasenaCompletado = function(){
		if(ui.campoContrasena[0].value.trim().length > 0){
			return true;

		}
		return false;
	};

	var checkApellidoCompletado = function(){
		if(ui.campoApellido[0].value.trim().length > 0){
			return true;
		}
		return false;
	};

	var checkNombreCompletado = function(){
		if(ui.campoNombre[0].value.trim().length > 0){
			return true;
		}
		return false;
	};
	
	var checkFechaCompletada = function(){
		dia = $($('#diaNacimiento')[0].options[$('#diaNacimiento')[0].selectedIndex]).data('value');
		mes = $($('#mesNacimiento')[0].options[$('#mesNacimiento')[0].selectedIndex]).data('value');
		anio = $($('#anioNacimiento')[0].options[$('#anioNacimiento')[0].selectedIndex]).data('value');

		if(dia != -1 && mes != -1 && anio != -1){
			return true;
		}
		return false;
	};
	
	var checkDniCompletado = function(){
		if(ui.campoDni[0].value.trim().length > 0){
			return true;
		}
		return false;
	};
	
	var checkTerminosCondicionesAceptadas = function(){
		return ui.checkTerminos[0].checked;
	};




	var habilitarBotonContinuar = function(){
		if( 
			checkApellidoCompletado()			&&
			checkNombreCompletado()				&&
			checkFechaCompletada()				&&
			checkDniCompletado()				&&
			checkTerminosCondicionesAceptadas()
		){
			//todo validado
			if (ui.btnContinuar.hasClass("disabledBtn")){
				//si la tiene se la quito
				ui.btnContinuar.removeClass("disabledBtn");
			}
		}else{
			//alguno falso
			if (!ui.btnContinuar.hasClass("disabledBtn")){
				//si no la tiene se la agrego
				ui.btnContinuar.addClass("disabledBtn");
			}
		}
	}


	var habilitarBotonIngresar = function(){
		if( checkEmailCompletado()				&&
			checkContrasenaCompletado()
		){
			//todo validado
			if (ui.btnIngresar.hasClass("disabledBtn")){
				//si la tiene se la quito
				ui.btnIngresar.removeClass("disabledBtn");
				ui.campoContrasena.keypress(function(e) {
					var keynum = window.event ? window.event.keyCode : e.which;
			        if (e.keyCode == 13){
			        	onClickIngresarHandler();
			        }
				})
			}
		}else{
			//alguno falso
			if (!ui.btnIngresar.hasClass("disabledBtn")){
				//si no la tiene se la agrego
				ui.btnIngresar.addClass("disabledBtn");
			}
		}
	};

	var buildUsuarioRecuperarContrasenaPASEDTO = function() {
		return new UsuarioPASEDTO({
			email								: ui.campoMailOlvida[0].value
		})
	}

	var onClickRecuperarContrasena = function(){
		if (ui.btnRecuperarContrasena.hasClass("disabledBtn")){
			return false;
		}else if (checkEmailCompletadoRecuperarPasswd()){
			permitirRecuperarContrasena = true;
			//si viene de un error de negocio se lo limpio
			if (!ui.campoErrorNegocioRecupPasswd.hasClass("noDisplay")){
				ui.campoErrorNegocioRecupPasswd.addClass("noDisplay");
				ui.campoErrorNegocioRecupPasswd[0].innerHTML = "";
			}

			//valido los captcha
			blockCallerUI.blockPost({ url : LoginServiceURL.VALIDATE_CAPTCHA,
				dataObject : buildCaptcha(),
				successHandlerCallback : validateCaptchaHandler,
				errorHandlerCallback : defaultErrorHandler });

			//valido login con PASE
			if (model.permitirRecuperarContrasena) {
				blockCallerUI.blockPost({ url : LoginServiceURL.RECUPERAR_PASSWORD_USUARIO,
					dataObject : buildUsuarioRecuperarContrasenaPASEDTO(),
					successHandlerCallback : recuperarPasswordHandler,
					errorHandlerCallback : defaultErrorHandler });
			}

		}

	};

	var recuperarPasswordHandler = function (data){
		var listaErrores = data.errors;

		if( tieneErrores(listaErrores) ){
			for (var i = 0; i < listaErrores.length; i++){
				//manejo de errores
				if(listaErrores[i].errorType == ROLErrorTypeConstants.VALIDATION){

					//SFHUB-2784 cambio de mensaje
					if(listaErrores[i].messageCode == CodeErrorsConstants.CODE_000001){
						listaErrores[i].message = "La cuenta de correo ingresada es inexistente"
					}

					//muestro el error y acumulo
					ui.campoErrorNegocioRecupPasswd.removeClass('noDisplay');
					ui.campoErrorNegocioRecupPasswd[0].innerHTML += "<br>" + listaErrores[i].message;
				}
				if(listaErrores[i].errorType == ROLErrorTypeConstants.EXCEPTION){
					alert(listaErrores[i].message);
				}
			}
		} else {
			mostrarDivCorreoRecuperarPasswdEnviado();
			//alert("Te hemos enviado un email a la casilla de correo electr�nico para que puedas cambiar tu contrase�a");
		}

	}

	var marcarErrorCaptchaDistintas = function(){
		ui.reCaptcha.addClass('warning');
		$('#errorDefaultReallabel').removeClass('noDisplay');
	};

	var marcarErrorCaptchaLoginDistintas = function(){
		ui.reCaptchaLogin.addClass('warning');
		$('#errorCaptchaLoginlabel').removeClass('noDisplay');
	};

	var validateCaptchaHandler = function(data){

		var valid = Boolean(data.valid);
		if(!valid){
			marcarErrorCaptchaDistintas();
			model.permitirRecuperarContrasena = false;
		}

	};

	var buildCaptcha = function(){
		return new CaptchaDTO({
			hashValue : $('#captchaModule input[name=defaultRealHash]').val(),
			inputValue :ui.reCaptcha.val()
		});
	}

	var initImagenCaptcha = function(){
		$('#defaultReal').realperson();
	};


	var intentosLoginHandler = function(data){
		var intentos = data.object;
		if(intentos >= TraduccionSecurityError.ROL_MAX_INTENTOS_LOGIN){
			mostrarDivCaptchaLogin();
		}
	}

	var mostrarDivCorreoRecuperarPasswdEnviado = function() {
		$("#correoPasswordEnviado").show();
		onClickCancelaLogin();
	}

	var onKeyUpReCaptchaHandler = function() {
		ui.reCaptcha.keypress(function(e) {
			var keynum = window.event ? window.event.keyCode : e.which;
	        if (e.keyCode == 13){
	        	onClickRecuperarContrasena();
	        }
		})
		onKeyUpMailOlvidaHandler()
	}

	var ui = {
			menuLogueado				: $('#menuLogueado'),
			menuNoLogueado				: $('#menuNoLogueado'),
			menuMailNoValidado			: $('#menuMailNoValidado'),
			menuSinCapturador			: $('#menuSinCapturador'),
			linkIngresar				: $('#linkIngresar'),

			divUsuarioLogueado			: $('#divUsuarioLogueado'),
			divUsuarioSuccess			: $('#divUsuarioSuccess'),

			btnIngresar					: $('#IngresarBtn'),
			btnContinuar				: $('#ingresaDniBtn'),
			btnCancelar					: $('#cancelarBtn'),

			campoEmail					: $('#emailField'),
			campoContrasena				: $('#contrasenaField'),
			campoDni					: $('#dniHub'),
			
			campoApellido				: $('#apellidoField'),
			campoNombre					: $('#nombreField'),
			divDiaNacimiento			: $('#divDiaNacimiento'),
			divMesNacimiento			: $('#divMesNacimiento'),
			divAnioNacimiento			: $('#divAnioNacimiento'),
			campoRadioCheckbox			: $('input'),

			usuarioDniPopover			: $('#usuarioDniPopover'),
			errorDni					: $('#error-dni'),
			checkTerminos				: $('#checkTerminosCondiciones'),

			campoErrorNegocio			: $('#errorPASENegocio'),
			campoErrorNegocioRecupPasswd: $('#errorPASENegocioRecupPasswd'),

			btnRecuperarContrasena		: $('#recuerdaPassBtn'),
			campoMailOlvida				: $('#mailOlvida'),
			btnOlvidarPass				: $("#olvidarPass"),
			btnCancelaLogin				: $("#cancelaLogin"),
			reCaptcha					: $('#reCaptchaModule input[name=defaultReallabel]'),
			captcha						: $('#captchaModule input[name=defaultRealHash]'),

			divCaptchaLogin				: $('#divCaptchaLogin'),
			captchaLogin				: $('#captchaLoginModule input[name=captchaLogin]'),
			reCaptchaLogin				: $('#reCaptchaLoginModule input[name=captchaLoginlabel]'),

			todo						: $('*')

	};

	var model = {
		uuid						: "",
		activate					: "false",
		permitirRecuperarContrasena : true,
		validateCaptcha				: false
	};
	
	var renderHandlebars = function (source, context, uiComponent){

		Handlebars.registerHelper('genera-dias', RegistrarseHelpers.generaDiasHelper);
		Handlebars.registerHelper('genera-meses', RegistrarseHelpers.generaMesesHelper);
		Handlebars.registerHelper('genera-anios', RegistrarseHelpers.generaAniosHelper);

		var template = Handlebars.compile(source);
		var html     = template(context);

		uiComponent.append(html);
	};

	var initUIComponents = function (){

		//aca no se si redirigir a mis avisos
		//de hecho no, ahora va a cambiar supongo, tengo que chequear los datos y si falta algo mas no?
//		if(decoratorModel.getUsuario() != null){
//			redirect(URLConstants.ROL_MIS_AVISOS);
//		}
		

		//esto no se como lo va a tratar auth0
		//si viene de registrarse muestro el msj de activar cuenta
		if(model.activate == "true"){
			ui.divUsuarioSuccess[0].style.display = "block";
		}

		ui.campoEmail.bind("contextmenu", function(e) {	e.preventDefault(); });
		ui.campoContrasena.bind("contextmenu", function(e) { e.preventDefault(); });

		ui.campoDni.keypress(function(e) {
			// Admite BACKSPACE y chequea por digitos
	        var keynum = window.event ? window.event.keyCode : e.which;
	        if (keynum == 8){	return true;	}
	        return /\d/.test(String.fromCharCode(keynum));
		});

		/*Estilos para el olvide contrasena */

		ui.btnRecuperarContrasena.addClass("disabledBtn");
		ui.btnContinuar.addClass("disabledBtn");

		ui.campoMailOlvida.bind("keydown", function(){});
		
		/*Estilos para el save capturador*/
		ui.campoApellido.bind("contextmenu cut copy paste", function (e){ e.preventDefault(); });
		ui.campoNombre.bind("contextmenu cut copy paste", function (e){ e.preventDefault(); });

		//reutilizo el de registrarse para no crear un archivo igual para login
		renderHandlebars(RegistrarseTemplates.diaNacimiento, {}, ui.divDiaNacimiento);
		renderHandlebars(RegistrarseTemplates.mesNacimiento, {}, ui.divMesNacimiento);
		renderHandlebars(RegistrarseTemplates.anioNacimiento, {}, ui.divAnioNacimiento);
		
		ui.campoRadioCheckbox.customInput();
	};

	var onClickCancelarHandler = function(){
		redirectMain(model.uuid);
	}

	var noSeleccionCaptcha = function(){
		var textCaptcha = document.getElementById('captchaModule');
		 	// Internet Explorer
		    textCaptcha.onselectstart = function(){
		          return false;
		    }
		// Firefox
			textCaptcha.onmousedown = function(){
				return false;
			}
	}

	var onClickOlvidarPassHandler = function() {
		$("body").css({"overflow":"hidden"});

		noSeleccionCaptcha();
		$.blockUI({ message: null,overlayCSS: { backgroundColor: 'transparent' } });
        setTimeout($.unblockUI, 1550);
        /* decoratorController.setUpFromModule({ module :ModuleConstants.LOGIN_OLVIDE_CONTRASENIA });*/
        $("#leftLoginContent").removeAttr( 'style' );
        $("#leftLoginContent").css({"position":"relative","width":"100%"}).animate({
			"top":"-1000px" }, 1500);
		$("#olvidePass").css({"display":"block","position":"relative","width":"100%","top":"1500px"}).animate({
			"top":"-390px" }, 1500, function() {
				$("body").css({"overflow":"initial"});
			});
	}

	var onClickCancelaLogin = function() {
		$("body").css({"overflow":"hidden"});
		$.blockUI({ message: null,overlayCSS: { backgroundColor: 'transparent' } });
        setTimeout($.unblockUI, 1550);
        /*decoratorController.setUpFromModule({ module :ModuleConstants.LOGIN });*/
        $("#olvidePass").css({"display":"block","position":"relative","width":"100%","top":"-400px"}).animate({
			"top":"1200px"
		}, 1500, function(){
			$(this).hide();
		});
		$("#leftLoginContent").css({"position":"relative","width":"100%"}).animate({
			"top":"0"
		}, 1500, function() {
			$("body").css({"overflow":"initial"});
		});
	}

	var checkEmailCompletadoRecuperarPasswd = function(){
		if(ui.campoMailOlvida[0].value.trim().length > 0){
			return true;
		}
		return false;
	};

	var checkCaptchaCompletado = function(){
		if(ui.reCaptcha[0].value.trim().length > 0){
			return true;
		}
		return false;
	};

	var onKeyUpMailOlvidaHandler = function() {
		if (checkEmailCompletadoRecuperarPasswd()&&checkCaptchaCompletado()){
			$(this).parent().find(".errorMSG").remove();
			var inputVal = $("input#mailOlvida").val();
		    var emailReg = /^([\w-\.]+@{1}([\w-]+\.)+[\w-]{2,4})?$/;
		    if(!emailReg.test(inputVal)) {
		    	$(this).after('<p><span class="errorMSG">Escriba un e-mail v&aacute;lido.</span></p>');
		        ui.btnRecuperarContrasena.addClass("disabledBtn");
		    }else{
		    	ui.btnRecuperarContrasena.removeClass("disabledBtn");
		    }
		} else if (!ui.btnRecuperarContrasena.hasClass("disabledBtn")) {
				ui.btnRecuperarContrasena.addClass("disabledBtn");
		}
	}

	var onComponentes = function(e) {
		e.preventDefault()
	}

	var initModel = function(){
		model.uuid = GetURLParameters('uuid');
		model.activate = GetURLParameters('activate');
	}

	var bindUIActions = function(){

		// registrarse -------------------------------
		ui.btnIngresar.on('click', onClickIngresarHandler);
		ui.btnContinuar.on('click', onClickContinuarHandler);
		ui.btnCancelar.on('click', onClickCancelarHandler);
		ui.btnOlvidarPass.on('click', onClickOlvidarPassHandler);


		// habilitar boton ---------------------------
		ui.campoEmail.on('keyup', habilitarBotonIngresar);
		ui.campoContrasena.on('keyup', habilitarBotonIngresar);
		
		// habilitar para extras PASE
		ui.campoApellido.on('keyup', habilitarBotonContinuar);
		ui.campoNombre.on('keyup', habilitarBotonContinuar);
		$('#diaNacimiento').change(function(){	habilitarBotonContinuar()	});
		$('#mesNacimiento').change(function(){	habilitarBotonContinuar()	});
		$('#anioNacimiento').change(function(){	habilitarBotonContinuar()	});

		ui.campoDni.on('keyup', habilitarBotonContinuar);

		ui.checkTerminos.on('click' , habilitarBotonContinuar);

		ui.campoMailOlvida.on('focusout',onKeyUpMailOlvidaHandler);
		ui.btnRecuperarContrasena.on('click', onClickRecuperarContrasena);
		ui.btnCancelaLogin.on('click', onClickCancelaLogin);

		ui.reCaptcha.on('keyup', onKeyUpReCaptchaHandler);

		//otros
		ui.todo.on('cut copy paste',onComponentes);
	};

	//------------------------------------------------
	// public interface ------------------------------
	//------------------------------------------------

	return {

		init : function (args){
			initModel();
			initImagenCaptcha();
			initUIComponents();
			bindUIActions();
			decoratorController.setUpFromModule({ module :ModuleConstants.LOGIN });
			
			//agrego comportamiento
			decoratorController.model.tempCookie = $.cookie('usuario');
			cargarUsuarioTemporal($.cookie('usuario'));
			if(model.activate == "true"){
				//mostrarPaginaQueQuiereJose()
			}else{
				mostrarDivDNIAnunciante();
			}
		}

	}


})();

$(document).ready(function() {
	loginController.init({});
});