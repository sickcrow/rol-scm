/**
 * author: mdenicolo
 * version: 1.0.0
 * description: Clase que vincula la UI con la logica en la pantalla de registracion.
 */

//-----------------------------------------------------------------------------
//registrarseController -------------------------------------------------------
//-----------------------------------------------------------------------------

var registrarseController = (function () {

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
		return false;
	};

	gOnfocusRecuperarEstiloSelectHandler = function(component){
		component.style.borderColor = '#CCCCCC';
		component.style.borderWidth = '1px';
	}

	gOnfocusRecuperarEstiloInputHandler = function(component, componentError){
		if($(component).parent().hasClass("warning")){
			$(component).parent().removeClass("warning");
			document.getElementById(componentError).className='errorMSG noDisplay';
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

	//------------------------------------------------
	// private interface -----------------------------
	//------------------------------------------------

	var ui = {

			btnRegistrar 				: $('#RegistrarBtn'),
			btnCancelar					: $('#cancelarBtn'),

			campoApellido				: $('#apellidoField'),
			campoNombre					: $('#nombreField'),
			campoEmail					: $('#emailField'),
			campoContrasena				: $('#contrasenaField'),
			campoRepetirContrasena		: $('#contrasenaCheckField'),
			campoDni					: $('#dniField'),
			checkboxTerminosCondiciones	: $('#checkTerminosCondiciones'),

			reCaptcha					: $('#reCaptchaModule input[name=defaultReallabel]'),
			captcha						: $('#captchaModule input[name=defaultRealHash]'),

			errorApellido				: $('#error-apellido'),
			errorNombre					: $('#error-nombre'),
			errorMail					: $('#error-email'),
			errorContrasena				: $('#error-palabraClave'),
			errorRepetirContrasena		: $('#error-checkPalabraClave'),
			errorDni					: $('#error-dni'),

			divDiaNacimiento			: $('#divDiaNacimiento'),
			divMesNacimiento			: $('#divMesNacimiento'),
			divAnioNacimiento			: $('#divAnioNacimiento'),

			campoErrorNegocio			: $('#errorPASENegocio')

	};

	var model = {
			validacionRegistro 			: true,
			uuid						: "",
			prevenirMultiClicks			: false,
			numeroPasada				: 0
	};

	var marcarErrorCaptchaDistintas = function(){
		$("#reCaptchaModule").addClass('warning');
		$('#errorDefaultReallabel').removeClass('noDisplay');
	};

	var marcarErrorFechaNacimiento = function(){
		$('#divDiaNacimiento').addClass('warning');
		$('#divMesNacimiento').addClass('warning');
		$('#divAnioNacimiento').addClass('warning');
		$('#fecha_nacimiento_container').addClass('warning');
	};

	var marcarErrorInput = function(atributo){
		$("input[data-atributo='"+atributo+"']").parent("div.form-md-line-input").addClass('warning');
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

	var onClickRegistrarseHandler = function(){

		model.validacionRegistro = true;
		if (ui.btnRegistrar.hasClass("disabledBtn")){
			return false;
		}else{

			if(model.numeroPasada == 0){
				model.numeroPasada++;

				//si viene de un error de negocio se lo limpio
				if (!ui.campoErrorNegocio.hasClass("noDisplay")){
					ui.campoErrorNegocio.addClass("noDisplay");
					ui.campoErrorNegocio[0].innerHTML = "";
				}

				//valido contrasenias
				if(ui.campoContrasena[0].value != ui.campoRepetirContrasena[0].value){
					marcarErrorInput('checkPalabraClave');
					ui.errorRepetirContrasena.removeClass('noDisplay');
					model.validacionRegistro = false;
					model.numeroPasada = 0;
				}

				//valido fecha de nacimiento
				var fechaValidadaOK = validarFechaNacimiento();
				if(!fechaValidadaOK){
					model.validacionRegistro = false;
					model.numeroPasada = 0;
				}

				//valido dni
				var dniValidadoOK = validarDNI();
				if(!dniValidadoOK){
					marcarErrorInput('dni');
					ui.errorDni.removeClass('noDisplay');
					model.validacionRegistro = false;
					model.numeroPasada = 0;
				}

				//valido captcha
				blockCallerUI.blockPost({ url : RegistrarmeServiceURL.VALIDATE_CAPTCHA,
					dataObject : buildCaptcha(),
					successHandlerCallback : validateCaptchaHandler,
					errorHandlerCallback : defaultErrorHandler });

				//Si no tiene errores
				if(model.validacionRegistro){

					blockCallerUI.blockPost({ url : RegistrarmeServiceURL.SAVE_USUARIO,
						dataObject : buildUsuarioDTO(),
						successHandlerCallback : usuarioPASERegistradoRefactorizadoHandler,
						errorHandlerCallback : defaultErrorHandler });

				}

			}

		}
	};

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
	};

	var onClickCancelarHandler = function(){
		redirectMain(model.uuid);
	};

	var buildUsuarioDTO = function(){
		return new UsuarioDTO({
			apellido							: ui.campoApellido[0].value,
			nombre								: ui.campoNombre[0].value,
			email								: ui.campoEmail[0].value,
			fechaNacimiento						: $($('#anioNacimiento')[0].options[$('#anioNacimiento')[0].selectedIndex]).data('value')+'-'+
													$($('#mesNacimiento')[0].options[$('#mesNacimiento')[0].selectedIndex]).data('value')+'-'+
													$($('#diaNacimiento')[0].options[$('#diaNacimiento')[0].selectedIndex]).data('value')+' 00:00:00.000',	//NO QUITAR,
			genero								: $($("input[name='radioGenero']:checked")[0]).data('value'),
			palabraClave						: ui.campoContrasena[0].value,
			codigoTipoDocumento					: AtributosCapturadorConstants.CODIGO_TIPO_DOCUMENTO,
			numeroDocumento						: ui.campoDni[0].value,
			codigoCliente						: AtributosCapturadorConstants.CODIGO_CLIENTE,
			codigoTipoAnunciante				: AtributosCapturadorConstants.CODIGO_TIPO_ANUNCIANTE,
			codigoCanalEntrada					: AtributosCapturadorConstants.CODIGO_CANAL_ENTRADA,
			codigoTipoIVA						: AtributosCapturadorConstants.CODIGO_TIPO_IVA,
			codigoMedioPagoPrincipal			: AtributosCapturadorConstants.CODIGO_MEDIO_PAGO_PRINCIPAL,
			codigoPerfilAnunciante				: AtributosCapturadorConstants.CODIGO_PERFIL_ANUNCIANTE_ROL
		})
	};

	var mostrarMensajeError = function(atributo, mensaje){

		if($('#error-'+atributo).hasClass('noDisplay')){
			$('#error-'+atributo).removeClass("noDisplay");
		}

		$('#error-'+atributo)[0].innerHTML = mensaje;
	};

	//si es la fecha marco los 3 sino el input
	//no se considera el captcha, el genero y el checkbox pq lo valida front o hay valor default
	var marcarError = function(error){
		if(error.atributo == AtributosRegistracionPASE.FECHA_NACIMIENTO){
			marcarErrorFechaNacimiento();
		}else{
			marcarErrorInput(error.atributo);
		}
		mostrarMensajeError(error.atributo, error.mensaje);
	};

	var tieneErrores = function(listaErrores){
		if(listaErrores.length == 0){
			return false;
		}
		return true;
	};

	var usuarioPASERegistradoRefactorizadoHandler = function(data){
		var listaErrores = data.errors;

		//si no tiene errores ==> SUCCESS
		if( !tieneErrores(listaErrores) ){

			//agrego a url el param activate para msj y si venia con uuid tambien para que lo mantenga
			var url = URLConstants.ROL_LOGIN + '?activate=true';
			if(model.uuid != null){
				url = url+'&uuid='+model.uuid;
			}
			redirect(url);

		}else{

			for (var i = 0; i < listaErrores.length; i++){

				//manejo de errores
				if(listaErrores[i].errorType == ROLErrorTypeConstants.VALIDATION){

					//si esta en atributos marco el campo
					if(listaErrores[i].fieldName == AtributosRegistracionPASE.CONTRASENIA){
						marcarErrorInput('palabraClave');
						mostrarMensajeError('palabraClave', listaErrores[i].message);
					}else if(listaErrores[i].fieldName == AtributosRegistracionPASE.EMAIL){
						marcarErrorInput('email');
						mostrarMensajeError('email', listaErrores[i].message);
					}else if(listaErrores[i].messageCode == CodeErrorsConstants.CODE_000006){
						ui.campoErrorNegocio.removeClass('noDisplay');
						ui.campoErrorNegocio[0].innerHTML = 'El correo electr&oacute;nico ya se encuentra registrado';
					}else if(listaErrores[i].messageCode == CodeErrorsConstants.CODE_000012){
						ui.campoErrorNegocio.removeClass('noDisplay');
						ui.campoErrorNegocio[0].innerHTML = 'El e-mail ingresado no existe. Por favor registrese';
					}else{
						//muestro el error generico y acumulo si hay mas
						ui.campoErrorNegocio.removeClass('noDisplay');
						ui.campoErrorNegocio[0].innerHTML += "<br>" + listaErrores[i].message;
					}

				}

				//NO SE DEBE DAR PERO POR LAS DUDAS
				if(listaErrores[i].errorType == ROLErrorTypeConstants.EXCEPTION ||
						listaErrores[i].errorType == ROLErrorTypeConstants.REDIRECTION){
					alert('ERROR - Tipo: '+listaErrores[i].errorType+' - Mensaje: '+listaErrores[i].message);
				}

			}

			model.numeroPasada = 0;

		}
	};

	var validateCaptchaHandler = function(data){

		var valid = Boolean(data.valid);
		if(!valid){
			marcarErrorCaptchaDistintas();
			model.validacionRegistro = false;
			model.numeroPasada = 0;
		}

	};

	var defaultErrorHandler = function(jqXHR, textStatus, errorThrown){
		alert("Ha ocurrido un error: " + jqXHR.responseText + " " + jqXHR.status + " " + jqXHR.statusText);
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

	var checkMailCompletado = function(){
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

	var checkRepetirContrasenaCompletado = function(){
		if(ui.campoRepetirContrasena[0].value.trim().length > 0){
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
		return ui.checkboxTerminosCondiciones[0].checked;
	};

	var checkCaptchaCompletado = function(){
		if(ui.reCaptcha[0].value.trim().length > 0){
			return true;
		}
		return false;
	};

	var habilitarBotonRegistrar = function(){
		if( checkApellidoCompletado()			&&
			checkNombreCompletado()				&&
			checkMailCompletado()				&&
			checkContrasenaCompletado()			&&
			checkRepetirContrasenaCompletado()	&&
			checkFechaCompletada()				&&
			checkDniCompletado()				&&
			checkCaptchaCompletado()			&&
			checkTerminosCondicionesAceptadas()
		){
			//todo validado
			if (ui.btnRegistrar.hasClass("disabledBtn")){
				//si la tiene se la quito
				ui.btnRegistrar.removeClass("disabledBtn");
			}
		}else{
			//alguno falso
			if (!ui.btnRegistrar.hasClass("disabledBtn")){
				//si no la tiene se la agrego
				ui.btnRegistrar.addClass("disabledBtn");
			}
		}
	};

	var mostrarAyudaPass = function(){
		$(".ico-ayuda").tooltip();
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

		ui.campoApellido.bind("contextmenu cut copy paste", function (e){e.preventDefault();});
		ui.campoNombre.bind("contextmenu cut copy paste", function (e){e.preventDefault();});
		ui.campoEmail.bind("contextmenu cut copy paste", function (e){e.preventDefault();});
		ui.campoContrasena.bind("contextmenu cut copy paste", function (e){e.preventDefault();});
		ui.campoRepetirContrasena.bind("contextmenu cut copy paste", function (e){e.preventDefault();});
		ui.campoDni.bind("contextmenu cut copy paste", function (e){e.preventDefault();});

		ui.campoDni.keypress(function(e) {
			/*
			// Admite BACKSPACE y chequea por digitos
	        var keynum = window.event ? window.event.keyCode : e.which;
	        if (keynum == 8){	return true;	}
	        return /\d/.test(String.fromCharCode(keynum));
	        */
			//Se modifica la funcion anterior para que permita la tecla TAB en el campoDNI y funcione en IE y en el resto de navegadores
			var keynum;
		    var keychar;
		    var numcheck;
		    if(window.event){keynum = e.keyCode;} //IE
	        else if(e.which){keynum = e.which;} // netscape/Firefox/opera
	    	var tabkey = e.keyCode;
	        if( keynum == 8 || tabkey == 9 || tabkey == 37 || tabkey == 39){return true;}
	        else{
	        	keychar = String.fromCharCode(keynum);
	            numcheck = /[.0-9]/;
            	return numcheck.test(keychar);
	        }
		});

		renderHandlebars(RegistrarseTemplates.diaNacimiento, {}, ui.divDiaNacimiento);
		renderHandlebars(RegistrarseTemplates.mesNacimiento, {}, ui.divMesNacimiento);
		renderHandlebars(RegistrarseTemplates.anioNacimiento, {}, ui.divAnioNacimiento);
	}

	var initModel = function(){
		model.uuid = GetURLParameters('uuid');
	}

	var bindUIActions = function(){
		// registrarse -------------------------------
		ui.btnRegistrar.on('click', onClickRegistrarseHandler);
		ui.btnCancelar.on('click', onClickCancelarHandler);

		// habilitar boton ---------------------------
		ui.campoApellido.on('keyup', habilitarBotonRegistrar);
		ui.campoNombre.on('keyup', habilitarBotonRegistrar);
		ui.campoEmail.on('keyup', habilitarBotonRegistrar);
		ui.campoContrasena.on('keyup', habilitarBotonRegistrar);
		ui.campoRepetirContrasena.on('keyup', habilitarBotonRegistrar);
		ui.campoDni.on('keyup', habilitarBotonRegistrar);
		ui.reCaptcha.on('keyup', habilitarBotonRegistrar);

		$('#diaNacimiento').change(function(){	habilitarBotonRegistrar()	});
		$('#mesNacimiento').change(function(){	habilitarBotonRegistrar()	});
		$('#anioNacimiento').change(function(){	habilitarBotonRegistrar()	});

		ui.checkboxTerminosCondiciones.on('click', habilitarBotonRegistrar);
	};
	//------------------------------------------------
	// public interface ------------------------------
	//------------------------------------------------

	return {

		init : function (args){
			initUIComponents();
			bindUIActions();
			initImagenCaptcha();
			initModel();
			noSeleccionCaptcha();
			decoratorController.setUpFromModule({ module : ModuleConstants.REGISTRARME });
			mostrarAyudaPass();
		}

	}

})();

$(document).ready(function(){
	registrarseController.init({});
});