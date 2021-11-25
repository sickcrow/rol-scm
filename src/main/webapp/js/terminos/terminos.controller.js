/**
 * author: Carlos Santos
 * version: 1.0.0
 * description: Clase que gestiona el js de la pagina T�rminos y Condiciones de ROL.
 */

//-----------------------------------------------------------------------------
// ModuleConstants -----------------------------------------------------------
//-----------------------------------------------------------------------------


//-----------------------------------------------------------------------------
// headerController -----------------------------------------------------------
//-----------------------------------------------------------------------------

var terminosController = (function () {

	//------------------------------------------------
	// global interface ------------------------------
	//-----------------------------------------------

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

	gOnclickRedirectDatosPersonalesHanlder = function(url){
		if(model.uuid != null){
			url = url+'?uuid='+model.uuid;
		}
		redirect(url);
	};

	//------------------------------------------------
	// private interface -----------------------------
	//------------------------------------------------

	var compruebaAltoPantalla = function(){
		var altoVentana = $(window).height();
		var altoHeader = ui.headerRol.height();
		var altoContenedor = ui.contentWrapper.height();
		var altoFooter = ui.footerRol.height();
		var areaVisible = altoVentana-altoHeader-altoFooter-133;
		/*
		ui.contTerminos.height(areaVisible);
		$("#contTerminos").niceScroll({
			cursorcolor			: "#0088cc",
			cursoropacitymin	: 1,
			cursoropacitymax	: 1,
			cursorborder		: "0",
			cursorborderradius	: 0,
			cursorwidth			: "6px",
			background			: "#ccc"
		}).resize();
		*/
	}

	var creaScroll = function(){
		$(window).on("resize", function(){
			compruebaAltoPantalla();
		});
	};

	var eliminaLinks = function(){
		$("#terminosycondiciones").hide();
	}

	//------------------------------------------------
	// common interface ------------------------------
	//------------------------------------------------

	var ui = {
		// components:
		headerRol			: $("#headerRol"),
		contentWrapper		: $("#contentWrapper"),
		footerRol			: $("#footerRol"),
		contTerminos		: $("#contTerminos")
	};

	var model = {
		// implements.
	};

	var init = function (args){
		// funciones
		compruebaAltoPantalla();
		creaScroll();
		eliminaLinks();
		decoratorController.setUpFromModule({ module :ModuleConstants.TERMINOS });
	};


	//------------------------------------------------
	// public interface ------------------------------
	//------------------------------------------------

	return {
		init	: init
	};

})();

$(document).ready(function() {
	terminosController.init({});
});
