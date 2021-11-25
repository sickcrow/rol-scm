/**
 * author: Alejandro Di Fiore
 * version: 1.0.0
 * description: Clase que vincula la UI con la logica del header en las pantallas.
 * require: decorator-templates.js
 */

//-----------------------------------------------------------------------------
// ModuleConstants -----------------------------------------------------------
//-----------------------------------------------------------------------------

var ModuleConstants = {

	MIS_AVISOS						: "MIS_AVISOS",
	CREAR_AVISO						: "CREAR_AVISO",
	LOGIN							: "LOGIN",
	LOGOUT							: "LOGOUT",
	LOGIN_OLVIDE_CONTRASENIA		: "LOGIN_OLVIDE_CONTRASENIA",
	REGISTRARME						: "REGISTRARME",
	DATOS_PERSONALES				: "DATOS_PERSONALES",
	ERROR							: "ERROR",
	TERMINOS						: "TERMINOS",
	PREGUNTAS_FRECUENTES			: "PREGUNTAS_FRECUENTES"

}

//-----------------------------------------------------------------------------
// headerController -----------------------------------------------------------
//-----------------------------------------------------------------------------

var decoratorController = (function () {

	//------------------------------------------------
	// global interface ------------------------------
	//-----------------------------------------------

	gOnclickBoton1MisAvisosHandler = function(args) {
		$('#popUpMisAvisos').modal('hide');
	};

	gOnclickBoton2MisAvisosHandler = function(args) {
		$('#popUpMisAvisos').modal('hide');
		redirect(URLConstants.ROL_MIS_AVISOS);
	};

	gOnclickMisAvisosNP = function(args) {
		redirect(URLConstants.ROL_MIS_AVISOS);
	};

	gOnclickLogout = function (){
		decoratorModel.setA2("salir");
		var area = decoratorModel.getA1()+decoratorModel.getA2();
        gChangeTagName(area);
		$('#popUpLogout').modal('show');
	};
	gOnclickTerminos = function (){
//		decoratorModel.setA2("terminos-y-condiciones");
//		var area = decoratorModel.getA1()+decoratorModel.getA2();
//        gChangeTagName(area);
//		$('#popUpTerminos').modal('show');
//		$('#popUpTerminos h3#titVentana').html("Terminos y condiciones de uso");
//		$("#popUpTerminos .modal-body").html(DecoratorTemplates.textoTerminosYCondiciones);
//		$("#popUpTerminos .modal-body").animate({scrollTop: 0}, 900);
//		$("#popUpTerminos .modal-body a").on('click', function(){
//			var url = $(this).attr("href");
//			window.open(url);
//		});

		redirect(URLConstants.ROL_TERMINOS);
	};

	gOnclickProteccion = function (){
		decoratorModel.setA2("proteccion-datos-personales");
		var area = decoratorModel.getA1()+decoratorModel.getA2();
        gChangeTagName(area);
		$('#popUpTerminos').modal('show');
		$('#popUpTerminos h3#titVentana').html("Protecci&oacute;n de datos personales");
		$("#popUpTerminos .modal-body").html(DecoratorTemplates.textoProteccionDatos);
		$("#popUpTerminos .modal-body").animate({scrollTop: 0}, 900);
		$("#popUpTerminos .modal-body a").on('click', function(){
			var url = $(this).attr("href");
			window.open(url);
		});
	};

	gOnclickMisAvisos = function (){
		$('#popUpMisAvisos').modal('show');
	};

	gOnclickBoton1LogoutHandler = function(args) {
		$('#popUpLogout').modal('hide');
	};

	gOnclickBoton2LogoutHandler = function(args) {
		$('#popUpLogout').modal('hide');
		logoutProcess();
	};

	gOnclickCloseMensajeCompatibilidadBrowserHandler = function (){
		ui.mensajeCompatibilidadBrowser.slideUp(1500);
		$("body").animate({
			"paddingTop": "0"
		},1500);
	};

	gOnclickBoton1Handler = function(args) {
		$('.modal').modal('hide');
	};

	gOnclickBoton2Handler = function(args) {
		$('.modal').modal('hide');
		g_restart();
	};
	gOnclickAceptarErrorHandler = function(args) {
		$('.modal').modal('hide');
	};

	gOnExpireSessionHandler = function(args) {
		$('.modal').modal('hide');
		$('#popUpSesionExpirada').removeData("modal").modal({
            backdrop: 'static',
            keyboard: false,
            show: true
        });
	}

	gOnclickAceptarExpireSessionHandler = function(args) {
		$('.modal').modal('hide');
		logoutExpiredSession();
	}

	gOnErrorRedirectLoginHandler = function(redirectURL){
		g_redirectPageHandler(redirectURL);
	};

	gOnclickRedirectCrearAvisoHanlder = function(url){
		redirect(url);
	};

	defaultErrorHandler = function(jqXHR, textStatus, errorThrown){
		//TODO SACAR ESTO CUANDO LOS MENSAJES ESTEN SOLICONADOS
		/*var errorLineasStr = "líneas que el alto mínimo del template";
		var errorLineasStr = "l&iacute;neas que el alto mínimo del template";*/
		var errorLineasStr = "l\u00EDneas que el alto m\u00EDnimo del template";

		if(jqXHR.textStatus === 'error'){
			
			$('#popUpError').modal('show');
			$('#popUpError #titVentana').text('Ha ocurrido un error:');
			$("#popUpError .modal-body p").text("N\u00FAmero de error: "+jqXHR.status+" "+jqXHR.responseText+".");
			
		}else if(jqXHR.responseText.indexOf("NOT_APPLIED_VALUE")>= 0){

			$('#popUpAlerta').modal('show');
			$("#popUpAlerta .modal-body p").text("La fecha de publicaci\u00F3n seleccionada est\u00E1 cerrada. Por favor eleg\u00ED otra fecha.");
		}
		// En caso de que reciba un 601, significa que no hubo error, o el error es de jquery.
		if (jqXHR.status === 601) {
			decoratorModel.setExpired(true);
			gOnExpireSessionHandler();
		} else if(jqXHR.responseText.indexOf(errorLineasStr) > -1){
			$('#popUpError').modal('show');
			$('#popUpError #titVentana').text('Atenci\u00F3n');
			$("#popUpError .modal-header .close").hide();
			$("#popUpError .modal-body p").text("Para destacar tu aviso con una foto tenes que publicar al menos dos l\u00EDneas de texto.");
			$("#popUpError .modal-footer .btn-primary").attr("onclick","gOnclickAceptarErrorLinealHandler(this)");
//			$("#popUpError .modal-footer .btn.hidden").attr("onclick","gOnclickCancelarErrorLinealHandler(this)").text("Cancelar").addClass("btn-link").removeClass("hidden");
//			return false;
		}else{
			$('#popUpError').modal('show');
			$('#popUpError #titVentana').text('Ha ocurrido un error:');
			$("#popUpError .modal-body p").text("N\u00FAmero de error: "+jqXHR.status+" "+jqXHR.responseText+".");
		}
	};

	//Debe ser http. Verifica si en la url dice http o https. Si es https, le agrega una 's://sb',
	//sino le deja http y le agrega '://b'
	gChangeTagName = function(arg) {
		//DAX
		if (document.location){
			udm_('http'+(document.location.href.charAt(4)=='s'?'s://sb':'://b')+'.scorecardresearch.com/b?c1=2&c2=6906409&ns_site=clasificadosclarin&name=receptoriaonline'+arg);
		}
		//Analytics
		var paseId = -2;
		var usuario = $.cookie('usuario');
		if(usuario !== undefined){
			paseId = usuario.uid;
		}
		ga('send', 'pageview', {
			'dimension1': paseId,
			'dimension5': 'receptoriaonline'+arg
		});
	};

	gCleanUpAreas = function() {
		decoratorModel.setA1("indefinido");
		decoratorModel.setA2("indefinido");
		decoratorModel.setA3("indefinido");
		decoratorModel.setA4("indefinido");
		decoratorModel.setA5("indefinido");
	};

	g_restart = function (){

		if (hasUUID()){
			blockCallerUI.blockPost({ url : DecoratorServiceURL.REMOVE_MODEL,
				dataObject : buildModelSearchDTO(GetURLParameters('uuid')),
				successHandlerCallback : removeModelHandler,
				errorHandlerCallback : defaultErrorHandler });
		}

		redirect(URLConstants.ROL_CREAR_AVISO);
	};

	//------------------------------------------------
	// private interface -----------------------------
	//------------------------------------------------

	var udm_ = function(a) {
		var b="comScore=",c=document,d=c.cookie,e="",f="indexOf",g="substring",h="length",i=2048,j,k="&ns_",l="&",m,n,o,p,q=window,r=q.encodeURIComponent||escape;if(d[f](b)+1)for(o=0,n=d.split(";"),p=n[h];o<p;o++)m=n[o][f](b),m+1&&(e=l+unescape(n[o][g](m+b[h])));a+=k+"_t="+ +(new Date)+k+"c="+(c.characterSet||c.defaultCharset||"")+"&c8="+r(c.title)+e+"&c7="+r(c.URL)+"&c9="+r(c.referrer),a[h]>i&&a[f](l)>0&&(j=a[g](0,i-8).lastIndexOf(l),a=(a[g](0,j)+k+"cut="+r(a[g](j+1)))[g](0,i)),c.images?(m=new Image,q.ns_p||(ns_p=m),m.src=a):c.write("<","p","><",'img src="',a,'" height="1" width="1" alt="*"',"><","/p",">")
	};

	//Permite detectar cuando IE corre con Vista de Compatibilidad
    var compruebaCompatibilidad = function() {
        if (document.documentMode) {
            if (document.documentMode <= 7) {
                $("#actNavegador").prepend("<h3>CAMBIA LA VISTA DE COMPATIBILIDAD</h3><p>Inicia Internet Explorer</p>"+
            		"<p><strong>Opci&oacute;n 1</strong> - Hac&eacute; clic en el men&uacute; &quot;Herramientas&quot; y destild&aacute; la opci&oacute;n &quot;Vista de compatibilidad&quot;.</p>"+
            		"<p><strong>Opci&oacute;n 2</strong> - Hac&eacute; clic en el men&uacute; &quot;Herramientas&quot; y selecciona la opci&oacute;n &quot;Configuraci&oacutE;n de vista de compatibilidad&quot;. Esto abrir&aacute; una ventana donde se puede personalizar la funci&oacute;n &quot;Vista de compatibilidad&quot;.<br>" +
        			"Quit&aacute; la marca en la casilla junto a &quot;Mostrar todos los sitios web utilizando la vista de compatibilidad&quot; para desactivar la funci&oacutE;n.</p>"+
        			"<p>Si ya ha deshabilitado la vista de compatibilidad puede ir a <a href='crearaviso/crear-aviso' title='crear avisos'>crear avisos</a></p>");
                $("#actNavegador article").hide();
            	return;
            }
        }
    };

	var logoutProcess = function (){

		removeCookie({});
		removeCookieUsuario({});
		removeCookieCapturador({});
		removeCookieEmailValidated({});
		decoratorModel.setCapturador(null);
		decoratorModel.setUsuario(null);
		decoratorModel.setEmailValidated(null);

		/*blockCallerUI.blockPost({ url : DecoratorServiceURL.LOGOUT,
			dataObject : null,
			successHandlerCallback : handlerLogout,
			errorHandlerCallback : defaultErrorHandler });*/
		
		 window.location = DecoratorServiceURL.LOGOUT;
	};

	var logoutExpiredSession = function (){

		removeCookie({});
		removeCookieUsuario({});
		removeCookieCapturador({});
		decoratorModel.setCapturador(null);
		decoratorModel.setUsuario(null);

		var currentIndex = 10;
		if (ui && ui.wizard.wizard('selectedItem').step){
			 currentIndex = ui.wizard.wizard('selectedItem').step -1;
		}

		if ( (currentIndex >= 0) && (currentIndex <= 8) ){
			//g_redirectPageHandler(URLConstants.ROL_LOGIN);
			g_redirectPageHandler(URLConstants.ROL_CREAR_AVISO);
		} else {
			//redirect(URLConstants.ROL_LOGIN);
			//mando a crear aviso
			redirect(URLConstants.ROL_CREAR_AVISO);
		}
	};

	var handlerLogout = function (){
		//redirect(URLConstants.ROL_LOGIN);
		redirect(URLConstants.ROL_CREAR_AVISO);
	};

	var initCookieConfig = function (args){
		$.cookie.json 				= (args && args.json) ? args.json : true; // json support
		// Override defaults configuration.
		$.cookie.defaults.expires 	= (args && args.expires) ? args.expires : 1; // days.
		$.cookie.defaults.path 		= (args && args.path ) ? args.path : "/"; // across domain.
	};

	var setUsuarioFromCookie = function (){

		var usuarioCookie = $.cookie('usuario');

		if( usuarioCookie != null ){
			decoratorModel.setUsuario(usuarioCookie);
		}

	};

	var setCapturadorFromCookie = function (){

		var capturador = $.cookie('capturador');

		if ( capturador != null ){
			decoratorModel.setCapturador(capturador);
		}

	};

	var setEmailValidatedFromCookie = function (){

		var emailValidated = $.cookie('emailValidated');

		if ( emailValidated != null ){
			decoratorModel.setEmailValidated(emailValidated);
		}

	};
	
	var hasUUID = function (){
		var uuid = GetURLParameters('uuid');
		return (uuid != undefined && uuid != "");
	};

	var redirectHandler = function(data){
		redirect(data.url);
	};

	var buildModelSearchDTO = function(uuid){
		var ord = new ModelSearchDTO();
		ord.uuid = uuid;
		return ord;
	};

	var removeModelHandler = function (data){
		// implements.
	};

	var cortarDatosPersonales = function(){
		$('.limit30').each(function(){
	        var longitud=30;
	        var nombre = $(this);
	        if(nombre.text().length > longitud){
	            var texto=nombre.text().substring(0,longitud);
	            texto=texto.substring(0,longitud) +"...";
	            nombre.html(texto);
	        }
	    });
	};

	var setUsuarioUI = function (){

		if(decoratorModel.getUsuario() != null){
			if (decoratorModel.getEmailValidated() === true) {
				if (decoratorModel.getCapturador() != null) {
					ui.menuLogueado[0].style.display = "block";
					//ui.linkDatosPersonales[0].innerHTML = decoratorModel.getUsuario().nombre + " " + decoratorModel.getUsuario().apellido;
					ui.linkDatosPersonales[0].innerHTML = "<span class='dpNombre limit30' title='" + decoratorModel.getCapturador().nombre + "'>" + decoratorModel.getCapturador().nombre + "</span><span class='dpApellido limit30' title='" + decoratorModel.getCapturador().apellido + "' >" + decoratorModel.getCapturador().apellido + "</span>";
					cortarDatosPersonales();
				} else {
					// Aca es el caso de usuario valido en auth0 pero no existente en HUB
					ui.menuSinCapturador[0].style.display = "block";
					ui.datosSinCapturador[0].innerHTML = "<span class='dpNombre limit30' title='" + decoratorModel.getUsuario().email + "'>" + decoratorModel.getUsuario().email + "</span>";
				}
			} else {
				ui.menuMailNoValidado[0].style.display = "block";
				ui.datosPersonales[0].innerHTML = "<span class='dpNombre limit30' title='" + decoratorModel.getUsuario().email + "'>" + decoratorModel.getUsuario().email + "</span>";
			}
		}else{
			ui.menuNoLogueado[0].style.display = "block";
		}

	};


	//------------------------------------------------
	// common interface ------------------------------
	//------------------------------------------------

	var ui = {
		// components:
		linkIngresar					: $("#linkIngresar"),
		linkRegistrarme					: $("#linkRegistrarme"),
		linkRegistrarmeHtml				: "<li><a id='linkRegistrarme' onclick='gOnclickRedirectRegistrarHanlder(URLConstants.ROL_REGISTRARME)' >Registrarme</a></li>",
		linkMisAvisos					: $("#linkMisAvisos"),
		linkDatosPersonales				: $("#linkDatosPersonales"),
		datosPersonales					: $("#datosPersonales"),
		datosSinCapturador				: $("#datosSinCapturador"),
		linkSalir						: $("#linkSalir"),
		mainContainer					: $('#mainApp'),
    	menuLogueado					: $('#menuLogueado'),
		menuNoLogueado					: $('#menuNoLogueado'),
		menuMailNoValidado				: $('#menuMailNoValidado'),
		menuSinCapturador				: $('#menuSinCapturador'),
		mensajeCompatibilidadBrowser	: $('#mensajeCompatibilidadBrowser'),
		footer							: $('#footerRol'),
		wizard							: $('#MyWizard')
	};

	var model = {
			tempCookie	: null
		// implements.
	};

	var init = function (args){
		//compruebaCompatibilidad();
		initDetectizr();
		detectCompatibilyBrowser();
		initCookieConfig({});
		setUsuarioFromCookie();
		setCapturadorFromCookie();
		setEmailValidatedFromCookie();
		initPopUpCancelar();
		initPopUpEmailNoValidado();
		initPopUpError();
		initPopUpAlerta();
		initPopUpLogout();
		initPopUpTerminos();
		initPopUpMisAvisos();
		initPopUpSesionExpirada();
		initPopUpPerdidaDatos();
		initPopUpVerSeleccionado();
		// Si lo pude obtener de la cookie lo seteo en el modelo.
		var usuarioCookie = getCookieUsuario();
		if( usuarioCookie != null ){
			decoratorModel.setUsuario(usuarioCookie);
		}

		// Si lo pude obtener de la cookie lo seteo en el modelo.
		var capturadorCookie = getCookieCapturador();
		if (capturadorCookie != null){
			decoratorModel.setCapturador(capturadorCookie);
		}

		setUsuarioUI();

	};

	var removeCookie = function (){
		return $.removeCookie('cookie');
	};

	var getCookie = function (){
		var cookie = $.cookie('cookie');
		return (cookie != null) ? cookie : null;
	};

	var setCookie = function (cookie){
		$.cookie('cookie', cookie);
	};

	var removeCookieUsuario = function (){
		return $.removeCookie('usuario');
	};

	var getCookieUsuario = function (){
		var cookieUsuario = $.cookie('usuario');
		return (cookieUsuario != null) ? cookieUsuario : null;
	};

	var setCookieUsuario = function (cookieUsuario){
		$.cookie('usuario', cookieUsuario);
	};

	var removeCookieCapturador = function (){
		return $.removeCookie('capturador');
	};
	
	var removeCookieEmailValidated = function (){
		return $.removeCookie('emailValidated');
	};

	var getCookieCapturador = function (){
		var cookieCapturador = $.cookie('capturador');
		return (cookieCapturador != null) ? cookieCapturador : null;
	};

	var setCookieCapturador = function (cookieCapturador){
		$.cookie('capturador', cookieCapturador);
	};
	
	var getCookieEmailValidated = function (){
		var cookieEmailValidated = $.cookie('emailValidated');
		return (cookieEmailValidated != null) ? cookieEmailValidated : null;
	};

	var setCookieEmailValidated = function (cookieEmailValidated){
		$.cookie('emailValidated', cookieEmailValidated);
	};

	var setUpFromModule = function(args){

		if (!args || !args.module){
			return false;
		}

		//csantos: Muestra/Oculta el menu en mobile
		$(document).on('click','.navbar-toggle',function(e) {
			$(".navbar-collapse").toggleClass("in");
		});


		switch (args.module){
			case ModuleConstants.CREAR_AVISO:
				gCleanUpAreas();
				decoratorModel.setA1("crear-aviso");
				decoratorModel.setExpired(false);
		        break;
		     // LOGOUT ACTIONS:
			case ModuleConstants.LOGIN:
				gCleanUpAreas();
				decoratorModel.setA1("login.inicio");
				gChangeTagName(decoratorModel.getA1());
				// Deshabilito/Habilito los links:
				ui.linkIngresar.hide();
				ui.linkRegistrarme.hide();
				//ui.linkRegistrarme.parent().remove();
				//ui.menuNoLogueado.append(ui.linkRegistrarmeHtml);
				//ui.linkRegistrarme.parent().show();
				break;
			case ModuleConstants.LOGIN_OLVIDE_CONTRASENIA:
				gCleanUpAreas();
				decoratorModel.setA1("login.recuperar-clave");
				gChangeTagName(decoratorModel.getA1());
				// Deshabilito/Habilito los links:
				ui.linkIngresar.show();

				ui.linkRegistrarme.parent().remove();
				break;
			case ModuleConstants.REGISTRARME:
				gCleanUpAreas();
				decoratorModel.setA1("registro");
				gChangeTagName(decoratorModel.getA1());
				// Deshabilito/Habilito los links:
				ui.linkIngresar.show();

				ui.linkRegistrarme.parent().remove();
		        break;
		    // LOGIN ACTIONS:
			case ModuleConstants.MIS_AVISOS:
				gCleanUpAreas();
				decoratorModel.setA1("mis-avisos");
				gChangeTagName(decoratorModel.getA1());
				// Deshabilito/Habilito los links:
				ui.linkMisAvisos.hide();
				ui.linkDatosPersonales.parent().show().css({"border":"0"});
				ui.linkSalir.show();

				var usuario = decoratorController.getCookieUsuario();
				if(usuario == null || usuario == undefined){
					redirect(URLConstants.ROL_LOGIN);
				}

				break;
			case ModuleConstants.DATOS_PERSONALES:
				// Deshabilito/Habilito los links:
				gCleanUpAreas();
				decoratorModel.setA1("datos-personales");
				gChangeTagName(decoratorModel.getA1());
				ui.linkDatosPersonales.parent().hide();
				ui.linkMisAvisos.show();
				ui.linkSalir.show();
		        break;
			case ModuleConstants.ERROR:
				ui.linkDatosPersonales.parent().show().css({"border":"0"});
				ui.linkMisAvisos.show();
				ui.linkSalir.show();
				break;
			case ModuleConstants.TERMINOS:
				// trackeo
				gCleanUpAreas();
				decoratorModel.setA1("terminos");
				gChangeTagName(decoratorModel.getA1());
				break;
			default:
				// implements.
		        break;
		}

	};

	var initDetectizr = function (){
		Detectizr.detect({detectScreen:false, detectDevice: true});
		//Detectizr.detect({detectScreen : false});
	};

	var detectCompatibilyBrowser = function (){
		//alert("IE:"+document.documentMode);
		if(Detectizr.device.osVersion === "xp" && Detectizr.device.browser === "ie" && Detectizr.device.browserVersion == "7"){
			redirect(URLConstants.ROL_ERROR_ACTUALIZA_NAVEGADOR);
		}
		if(Detectizr.device.osVersion === "xp" && Detectizr.device.browser === "ie" && Detectizr.device.browserVersion == "8"){
			ui.mensajeCompatibilidadBrowser.slideDown(1500).show();
			$("body").css({
				paddingTop : 50
			});
			$(".css-label-radio").click( function () {
				$(".css-label-radio").css({
					"backgroundPositionY":"-5px"
				});
				$(this).css({
					"backgroundPositionY":"-87px"
				});
		    });
	    }
	};

	var initPopUpCancelar = function () {
		datos = {
			idPopUp   : "popUpCancelar",
			classTipoMensaje : "popUpAlerta", // Puede ser "popUpAlerta", "popUpInfo" "popUpError"
			titulo    : "Atenci\u00F3n",
			//mensaje   : NO ES NECESARIO, SE LE INDICA CUANDO SE LLAMA AL POPUP
			txtBoton1 : "Cancelar",
			txtBoton2 : "Aceptar",
			classBoton1 : "btn-link",
			funcionBoton1: "gOnclickBoton1Handler(this)",
			funcionBoton2: "gOnclickBoton2Handler(this)"

		};
		var source   = DecoratorTemplates.modalPopUpWindow;
		var template = Handlebars.compile(source);
		var html     = template(datos);

		ui.footer.append(html);
	};
	
	var initPopUpEmailNoValidado = function () {
		datos = {
			idPopUp   : "popUpEmailNoValidado",
			classTipoMensaje : "popUpAlerta", // Puede ser "popUpAlerta", "popUpInfo" "popUpError"
			titulo    : "Atenci\u00F3n",
			txtBoton2 : "Aceptar",
			classBoton1 : "hidden",
			funcionBoton2: "gOnclickAceptarErrorHandler(this)",
		};
		var source   = DecoratorTemplates.modalPopUpWindow;
		var template = Handlebars.compile(source);
		var html     = template(datos);

		ui.footer.append(html);
	};
	
	var initPopUpError = function () {
		datos = {
			idPopUp   : "popUpError",
			classTipoMensaje : "popUpError", // Puede ser "popUpAlerta", "popUpInfo" "popUpError"
			titulo    : "Ha ocurrido un error:",
			txtBoton2 : "Aceptar",
			classBoton1 : "hidden",
			funcionBoton1: "", //Vacio, solo tiene un boton
			funcionBoton2: "gOnclickAceptarErrorHandler(this)"

		};
		var source   = DecoratorTemplates.modalPopUpWindow;
		var template = Handlebars.compile(source);
		var html     = template(datos);

		ui.footer.append(html);
	};

	var initPopUpAlerta = function () {
		datos = {
			idPopUp   : "popUpAlerta",
			classTipoMensaje : "popUpAlerta", // Puede ser "popUpAlerta", "popUpInfo"  "popUpError"
			titulo    : "Atenci\u00F3n:",
			txtBoton2 : "Aceptar",
			classBoton1 : "hidden",
			funcionBoton1: "", //Vacio, solo tiene un boton
			funcionBoton2: "gOnclickAceptarErrorHandler(this)"

		};
		var source   = DecoratorTemplates.modalPopUpWindow;
		var template = Handlebars.compile(source);
		var html     = template(datos);

		ui.footer.append(html);
	};

	var initPopUpLogout = function () {
		datos = {
			idPopUp   : "popUpLogout",
			classTipoMensaje : "popUpAlerta", // Puede ser "popUpAlerta", "popUpInfo"  "popUpError"
			titulo    : "Atenci\u00F3n",
			mensaje   : "\u00BFEst\u00e1s seguro que quer\u00e9s salir?",
			txtBoton1 : "Cancelar",
			txtBoton2 : "Aceptar",
			classBoton1 : "btn-link",
			funcionBoton1: "gOnclickBoton1LogoutHandler(this)",
			funcionBoton2: "gOnclickBoton2LogoutHandler(this)"

		};
		var source   = DecoratorTemplates.modalPopUpWindow;
		var template = Handlebars.compile(source);
		var html     = template(datos);

		ui.footer.append(html);
	};

	var initPopUpTerminos = function () {

		datos = {
			idPopUp   : "popUpTerminos",
			classTipoMensaje : "popUpInfo", // Puede ser "popUpAlerta", "popUpInfo" "popUpError"
			titulo    : "Terminos y condiciones de uso",
			//mensaje   : "",
			classBoton1 : "hidden",
			txtBoton2 : "Aceptar",
			funcionBoton2: "gOnclickAceptarErrorHandler(this)"

		};
		var source   = DecoratorTemplates.modalPopUpWindow;
		var template = Handlebars.compile(source);
		var html     = template(datos);

		ui.footer.append(html);
	};

	var initPopUpMisAvisos = function () {
		datos = {
			idPopUp   : "popUpMisAvisos",
			classTipoMensaje : "popUpAlerta", // Puede ser "popUpAlerta", "popUpInfo" "popUpError"
			titulo    : "Atenci\u00F3n",
			mensaje   : "Si contin\u00FAa, perder\u00E1 todos los datos ingresados.",
			txtBoton1 : "Cancelar",
			txtBoton2 : "Aceptar",
			classBoton1 : "btn-link",
			funcionBoton1: "gOnclickBoton1MisAvisosHandler(this)",
			funcionBoton2: "gOnclickBoton2MisAvisosHandler(this)"

		};
		var source   = DecoratorTemplates.modalPopUpWindow;
		var template = Handlebars.compile(source);
		var html     = template(datos);

		ui.footer.append(html);
	};

	var initPopUpSesionExpirada = function () {
		datos = {
			idPopUp   : "popUpSesionExpirada",
			classTipoMensaje : "popUpAlerta", // Puede ser "popUpAlerta", "popUpInfo" "popUpError"
			titulo    : "Atenci\u00F3n:",
			mensaje	  : "Tu sesi\u00F3n ha expirado.",
			classBoton1 : "hidden",
			txtBoton2 : "Aceptar",
			funcionBoton1: "", //Vacio, solo tiene un boton
			funcionBoton2: "gOnclickAceptarExpireSessionHandler(this)"

		};
		var source   = DecoratorTemplates.modalPopUpWindowSinCerrar;
		var template = Handlebars.compile(source);
		var html     = template(datos);

		ui.footer.append(html);
	};

	var initPopUpPerdidaDatos = function () {
		datos = {
			idPopUp   : "popUpPerdidaDatos",
			classTipoMensaje : "popUpAlerta", // Puede ser "popUpAlerta", "popUpInfo"  "popUpError"
			titulo    : "Atenci\u00F3n",
			mensaje   : "Si modifica este dato, perder\u00E1 toda la informaci\u00F3n del aviso ingresada hasta el momento. \u00BFContin\u00FAa la modificaci\u00F3n?",
			txtBoton1 : "Cancelar",
			txtBoton2 : "Aceptar",
			classBoton1 : "btn-link",
			funcionBoton1: "gOnclickBoton1PerdidaDatosHandler(this)",
			funcionBoton2: "gOnclickBoton2PerdidaDatosHandler(this)"

		};
		var source   = DecoratorTemplates.modalPopUpWindow;
		var template = Handlebars.compile(source);
		var html     = template(datos);

		ui.footer.append(html);
	};
	var initPopUpVerSeleccionado = function () {

		datos = {
			idPopUp   : "popUpVerSeleccionado",
			classTipoMensaje : "popUpInfo", // Puede ser "popUpAlerta", "popUpInfo" o "popUpError"
			titulo    : "Has Seleccionado",
			mensaje   : "" ,
			txtBoton2 : "Cerrar",
			classBoton1 : "hidden",
			classBoton2 : "btn-link",
			funcionBoton1: "", //Vacio, solo tiene un boton
			funcionBoton2: "hidePopUpVerSeleccion()"

		};
		var source   = DecoratorTemplates.modalPopUpWindow;
		var template = Handlebars.compile(source);
		var html     = template(datos);
		ui.footer.append(html);
	};

	//------------------------------------------------
	// public interface ------------------------------
	//------------------------------------------------

	return {

		init 					: init,
		getCookie				: getCookie,
		setCookie				: setCookie,
		removeCookie 			: removeCookie,
		getCookieUsuario		: getCookieUsuario,
		setCookieUsuario		: setCookieUsuario,
		removeCookieUsuario 	: removeCookieUsuario,
		getCookieCapturador		: getCookieCapturador,
		setCookieCapturador		: setCookieCapturador,
		removeCookieCapturador 	: removeCookieCapturador,
		setUpFromModule			: setUpFromModule,
		model					: model

	}

})();

$(document).ready(function() {
	$(".steps").on("click", function(){
		return false;
	});
decoratorController.init({});
//	define([
//	        "decoratorTemplates",
//	        "decoratorModel",
//			"decoratorController"
//			], function() {
//			decoratorController.init({});
//		});
});