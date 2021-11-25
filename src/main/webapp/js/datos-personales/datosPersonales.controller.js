/**
 * author: mdenicolo - csantos
 * version: 1.0.0
 * description: Clase que vincula la UI con la logica en la pantalla de datos personales.
 */

//-----------------------------------------------------------------------------
//datosPersonalesController -------------------------------------------------------
//-----------------------------------------------------------------------------

var datosPersonalesController = (function () {
	
	//------------------------------------------------
	// global interface ------------------------------
	//------------------------------------------------
	
	gOnfocusRecuperarEstiloSelectHandler = function(component){
		component.style.borderColor = '#CCCCCC';
		component.style.borderWidth = '1px';
	}
	
	gOnfocusRecuperarEstiloInputHandler = function(component, componentError){
		if(component.className=='pull-left warning'){
			component.className = 'pull-left';
			document.getElementById(componentError).className='errorMSG noDisplay';
			
		}
	}
	
	gOnfocusRecuperarEstiloFechaHandler = function(){
		$('#diaNacimiento').removeClass('warning');
		$('#mesNacimiento').removeClass('warning');
		$('#anioNacimiento').removeClass('warning');
		$('#errorFechaInvalida').addClass('noDisplay');
		$('#errorMenorDeEdad').addClass('noDisplay');
	}
	
	gOnclickMuestraCambioPass = function(){
		//$('#antiguaPassDatPer div').append('<input id="oldContrasenaField" class="pull-left" type="password" data-atributo="oldPalabraClave" onfocus="" />');
		ui.campoContrasenaAnterior[0].style.display = 'block';
		$('#antiguaPassDatPer div').show();
		$('#labeloldPass').html('Contrase&ntilde;a anterior:');
		$('#oldPassText').remove();
		$('#nuevaPassDatPer').hide().removeClass('hidden').show('slow');		
	}
	
	//------------------------------------------------
	// private interface -----------------------------
	//------------------------------------------------
	
	var ui = {
			menuLogueado				: $('#menuLogueado'),
			btnDatosPersonales			: $('#DatosPersonalesBtn'),
			btnCancelar					: $('#cancelarBtn'),
			mainDatosPersonales			: $('#contDatosPersonales'),
			
			campoApellido				: $('#apellidoField'),
			campoNombre					: $('#nombreField'),
			campoEmail					: $('#emailField'),
			campoContrasenaAnterior		: $('#oldContrasenaField'),
			campoContrasena				: $('#nuevaContrasenaField'),
			campoRepetirContrasena		: $('#checkNuevaContrasenaField'),
			campoRadioCheckbox			: $('input'),
			campoDni					: $('#dniField'),
			
			errorApellido				: $('#error-apellido'),
			errorNombre					: $('#error-nombre'),
			errorContrasenaAnterior		: $('#error-oldPalabraClave'),
			errorContrasena				: $('#error-nuevaPalabraClave'),
			errorRepetirContrasena		: $('#error-nuevaCheckPalabraClave'),
			errorDni					: $('#error-dni'),
			
			divDiaNacimiento			: $('#divDiaNacimiento'),
			divMesNacimiento			: $('#divMesNacimiento'),
			divAnioNacimiento			: $('#divAnioNacimiento'),
			
			campoErrorNegocio			: $('#errorPASENegocio')
			
	};
	
	var model = {		
		uuid							: "",
		validacionRegistro				: true,
		cambioContrasenia				: false
	};
	
	var checkRedirectUsuarioNoLogueado = function(){
		if(decoratorModel.getUsuario() == null){
			redirect(URLConstants.ROL_CREAR_AVISO);
		}else{
			ui.mainDatosPersonales.show();
		}
	};
	
	
	var marcarErrorFechaNacimiento = function(){
		$('#diaNacimiento').addClass('warning');
		$('#mesNacimiento').addClass('warning');
		$('#anioNacimiento').addClass('warning');
	};
	
	var marcarErrorInput = function(atributo){
		$("input[data-atributo='"+atributo+"']").addClass('warning');
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
	};
	
	var mostrarMensajeError = function(atributo, mensaje){
		if($('#error-'+atributo).hasClass('noDisplay')){
			$('#error-'+atributo).removeClass("noDisplay");
		}
		$('#error-'+atributo)[0].innerHTML = mensaje;
	};
	
//	var defaultErrorHandler = function(jqXHR, textStatus, errorThrown){
//		if (jqXHR.status === 601) {
//			redirect(URLConstants.ROL_LOGIN)
//		} else {
//			alert("Ha ocurrido un error: " + jqXHR.responseText + " " + jqXHR.status + " " + jqXHR.statusText);
//		}
//	};
	
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
	
	var checkContrasenaAnteriorCompletado= function(){
		if(ui.campoContrasenaAnterior[0].value.trim().length > 0){
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
	
	var tieneErrores = function(listaErrores){
		if(listaErrores.length == 0){
			return false;
		}
		return true;
	};
	
	var usuarioPASEUpdatedHandler = function(data){
		
		var listaErrores = data.errors; 
		
		//si no tiene errores ==> SUCCESS
		if( !tieneErrores(listaErrores) ){
			
			if(model.cambioContrasenia){
								
				decoratorController.removeCookie();
				decoratorController.removeCookieUsuario();
				decoratorController.removeCookieCapturador();
								
				redirect(URLConstants.ROL_LOGIN);
			}else{
				
				decoratorController.setCookie(data.object.pasecookie);
				decoratorController.setCookieUsuario(data.object.usuario);
				decoratorController.setCookieCapturador(data.object.capturador);
								
				decoratorModel.setUsuario(decoratorController.getCookieUsuario());
							
				if(model.uuid != null && model.uuid != ""){
					redirectMain(model.uuid);
				}else{
					redirect(URLConstants.ROL_MIS_AVISOS);
				}
			}
				
		}else{
			
			for (var i = 0; i < listaErrores.length; i++){
				
				//manejo de errores
				if(listaErrores[i].errorType == ROLErrorTypeConstants.VALIDATION){
					
					//contrasena anterior incorrecta
					if(listaErrores[i].messageCode == CodeErrorsConstants.CODE_000000){
						marcarErrorInput('oldPalabraClave');
						ui.errorContrasenaAnterior.removeClass('noDisplay');
					}else{
						
						//si esta en atributos marco el campo
						if(listaErrores[i].fieldName == AtributosRegistracionPASE.CONTRASENIA){
							marcarErrorInput('nuevaPalabraClave');
							mostrarMensajeError('nuevaPalabraClave', listaErrores[i].message);
						}else{
							//muestro el error generico y acumulo si hay mas
							ui.campoErrorNegocio.removeClass('noDisplay');
							ui.campoErrorNegocio[0].innerHTML += "<br>" + listaErrores[i].message;
						}
						
					}
					
				}
				
				//NO SE DEBE DAR PERO POR LAS DUDAS
				if(listaErrores[i].errorType == ROLErrorTypeConstants.EXCEPTION ||
						listaErrores[i].errorType == ROLErrorTypeConstants.REDIRECTION){
					alert('ERROR - Tipo: '+listaErrores[i].errorType+' - Mensaje: '+listaErrores[i].message);
				}
				
			}
		}
	};
	
	var buildUsuarioUpdatePASEDTO = function(){
		return new UsuarioDTO({			
			usuarioExternoCodigo				: decoratorModel.getUsuario().uid,
			apellido							: ui.campoApellido[0].value,
			nombre								: ui.campoNombre[0].value,
			email								: ui.campoEmail[0].innerHTML,
			//palabraClave						: ui.campoContrasenaAnterior[0].value,
			//palabraClaveNueva					: ui.campoContrasena[0].value,
			fechaNacimiento						: $($('#anioNacimiento')[0].options[$('#anioNacimiento')[0].selectedIndex]).data('value')+'-'+
													$($('#mesNacimiento')[0].options[$('#mesNacimiento')[0].selectedIndex]).data('value')+'-'+
													$($('#diaNacimiento')[0].options[$('#diaNacimiento')[0].selectedIndex]).data('value')+' 00:00:00.000',	//NO QUITAR
			genero								: $($("input[name='radioGenero']:checked")[0]).data('value'),
			codigoTipoDocumento					: AtributosCapturadorConstants.CODIGO_TIPO_DOCUMENTO,
			numeroDocumento						: ui.campoDni[0].value,
			codigoCliente						: decoratorModel.getCapturador().codigoCliente,
			codigoAnunciante					: decoratorModel.getCapturador().codigoAnunciante
		})
	};
	
	var onClickAceptarHandler = function(){
		
		model.validacionRegistro = true;
		if (ui.btnDatosPersonales.hasClass("disabledBtn")){
			return false;
		}else{
			
			//si viene de un error de negocio se lo limpio
			if (!ui.campoErrorNegocio.hasClass("noDisplay")){
				ui.campoErrorNegocio.addClass("noDisplay");
				ui.campoErrorNegocio[0].innerHTML = "";
			}
			
			//valido ingreso de contrasenias
//			if(ui.campoContrasenaAnterior[0].value.trim().length > 0){
//				if(ui.campoContrasena[0].value.trim().length == 0){
//					marcarErrorInput('nuevaPalabraClave');
//					ui.errorContrasena.removeClass('noDisplay');
//					model.validacionRegistro = false;
//				}else{
//					model.cambioContrasenia = true;
//				}
//			}
			
			//valido contrasenias
//			if(ui.campoContrasena[0].value != ui.campoRepetirContrasena[0].value){
//				marcarErrorInput('nuevaCheckPalabraClave');
//				ui.errorRepetirContrasena.removeClass('noDisplay');
//				model.validacionRegistro = false;
//			}
			
			//valido fecha de nacimiento
			var fechaValidadaOK = validarFechaNacimiento();
			if(!fechaValidadaOK){
				model.validacionRegistro = false;
			}
			
			//valido dni
			var dniValidadoOK = validarDNI();
			if(!dniValidadoOK){
				marcarErrorInput('dni');
				ui.errorDni.removeClass('noDisplay');
				model.validacionRegistro = false;
			}
			
			//Si no tiene errores
			if(model.validacionRegistro){
				
				blockCallerUI.blockPost({ url : DatosPersonalesServiceURL.UPDATE_USUARIO,
					dataObject : buildUsuarioUpdatePASEDTO(),   
					successHandlerCallback : usuarioPASEUpdatedHandler,
					errorHandlerCallback : defaultErrorHandler });
				
			}
		}
	};
	
	var onClickCancelarHandler = function(){
		if(model.uuid != null && model.uuid != ""){
			redirectMain(model.uuid);
			
		}
		else redirect(URLConstants.ROL_MIS_AVISOS);
	};
	
	var habilitarBotonDatosPersonales = function(){
		if( checkApellidoCompletado()			&&
			checkNombreCompletado()				&&
			checkFechaCompletada()				&&
			checkDniCompletado()
		){
			//todo validado
			if (ui.btnDatosPersonales.hasClass("disabledBtn")){
				//si la tiene se la quito
				ui.btnDatosPersonales.removeClass("disabledBtn");
			}
		}else{
			//alguno falso
			if (!ui.btnDatosPersonales.hasClass("disabledBtn")){
				//si no la tiene se la agrego
				ui.btnDatosPersonales.addClass("disabledBtn");
			}
		}
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
	
	var mostrarAyudaPass = function(){
		$(".ico-ayuda").tooltip();		
	};
	
	
	var renderHandlebars = function (source, context, uiComponent){
		
		Handlebars.registerHelper('genera-dias', DatosPersonalesHelpers.generaDiasHelper);
		Handlebars.registerHelper('genera-meses', DatosPersonalesHelpers.generaMesesHelper);
		Handlebars.registerHelper('genera-anios', DatosPersonalesHelpers.generaAniosHelper);
		    		
		var template = Handlebars.compile(source);
		var html     = template(context);
		
		uiComponent.append(html);
	};
	
	var initUIComponents = function (){
				
		ui.campoApellido.bind("contextmenu cut copy paste",function(e) {	e.preventDefault();	});
		ui.campoNombre.bind("contextmenu cut copy paste",function(e) {	e.preventDefault();	});
		ui.campoEmail.bind("contextmenu cut copy paste",function(e) {	e.preventDefault();	});
		//ui.campoContrasenaAnterior.bind("contextmenu cut copy paste",function(e) {	e.preventDefault();	});
		//ui.campoContrasena.bind("contextmenu cut copy paste",function(e) {	e.preventDefault();	});
		//ui.campoRepetirContrasena.bind("contextmenu cut copy paste",function(e) {	e.preventDefault();	});
		
		ui.campoDni.keypress(function(e) {    
			// Admite BACKSPACE y chequea por digitos
	        var keynum = window.event ? window.event.keyCode : e.which;
	        if (keynum == 8){	return true;	}
	        return /\d/.test(String.fromCharCode(keynum));
		});
		
		ui.campoNombre[0].value = decoratorModel.getCapturador().nombre;
		ui.campoApellido[0].value = decoratorModel.getCapturador().apellido;
		ui.campoEmail[0].innerHTML = decoratorModel.getCapturador().email;
		
		renderHandlebars(DatosPersonalesTemplates.diaNacimiento, {}, ui.divDiaNacimiento);
		renderHandlebars(DatosPersonalesTemplates.mesNacimiento, {}, ui.divMesNacimiento);
		renderHandlebars(DatosPersonalesTemplates.anioNacimiento, {}, ui.divAnioNacimiento);
		ui.campoRadioCheckbox.customInput();
		
		if(decoratorModel.getCapturador().fechaNacimiento !== undefined){
			seleccionarFechaNacimiento(decoratorModel.getCapturador().fechaNacimiento);
		}
		if(decoratorModel.getCapturador().sexo !== undefined){
			seleccionarCheckboxSexo(decoratorModel.getCapturador().sexo);
		}
		
		ui.campoDni[0].value = decoratorModel.getCapturador().numeroDocumento;
		
		habilitarBotonDatosPersonales();
	}
	
	var bindUIActions = function(){
		// Aceptar cambios -------------------------------
		ui.btnDatosPersonales.on('click', onClickAceptarHandler);
		ui.btnCancelar.on('click', onClickCancelarHandler);
		
		// habilitar boton ---------------------------
		ui.campoApellido.on('keyup', habilitarBotonDatosPersonales);
		ui.campoNombre.on('keyup', habilitarBotonDatosPersonales);
		ui.campoDni.on('keyup', habilitarBotonDatosPersonales);
		
		$('#diaNacimiento').change(function(){	habilitarBotonDatosPersonales()	});
		$('#mesNacimiento').change(function(){	habilitarBotonDatosPersonales()	});
		$('#anioNacimiento').change(function(){	habilitarBotonDatosPersonales()	});
		
	};
	
	var initModel = function(){
		model.uuid = GetURLParameters('uuid');
	}
	
	//------------------------------------------------
	// public interface ------------------------------
	//------------------------------------------------
	
	return {
	
		init : function (args){
			checkRedirectUsuarioNoLogueado();
			initUIComponents();
			bindUIActions();
			initModel();
			decoratorController.setUpFromModule({ module :ModuleConstants.DATOS_PERSONALES });
			mostrarAyudaPass();
		}
	
	}	
	
})();

$(document).ready(function() {
	datosPersonalesController.init({});
});