/**
 * author: jlichowski
 * version: 1.0.0
 * description: Clase que vincula la UI con la logica en la pantalla de error.
 */

//-----------------------------------------------------------------------------
//errorController -------------------------------------------------------
//-----------------------------------------------------------------------------

var errorController = (function () {

	//------------------------------------------------
	// global interface ------------------------------
	//------------------------------------------------

	gOnclickRedirectDatosPersonalesHanlder = function(url){
		redirect(url);
	};

	gOnclickRedirectIngresarHanlder = function(url){
		redirect(url);
	};

	gOnclickRedirectRegistrarHanlder = function(url){
		redirect(url);
	};

	actualizaNavegador = function(){

		var ui = {
			// components:
			cuerpo							: $('body'),
			mensajeCompatibilidadBrowser	: $('#mensajeCompatibilidadBrowser')
		};

		var sOperativo = Detectizr.device.os;
        var versionSo = Detectizr.device.osVersion;
        var navegador = Detectizr.device.browser;
        var navVersion = Detectizr.device.browserVersion;
        var dispositivo = Detectizr.device.type;
        var usAgent = Detectizr.device.userAgent;

        ui.cuerpo.css({"paddingTop": "0"});
        ui.mensajeCompatibilidadBrowser.hide();

        $(".disp").append("<span class='tit'>"+sOperativo+"</span>&nbsp;con el navegador <span class='tit'>"+navegador+"</span> desde un "+dispositivo);
        $(".navegador").fadeTo("fast",0.9);
        $(".navegador").mouseenter(function(){
            $(this).animate({
                backgroundColor : "#feffbe"
            },200).fadeTo(100,1);
        }).mouseleave(function(){
            $(this).animate({
                backgroundColor : "#fff"
            },200).fadeTo(100,0.9);
        });
        navVersion = parseInt(navVersion.replace(/\./g," "));
        $("#porque").click(function(){
            $(".actualizaNavegador").toggle("slow");
        });
        $(".navegador").click(function(){
            var enlace = $(this).find("a").attr("href");
            window.open(enlace, '_blank');
            return false;
        });

        if(navegador == "ie" && versionSo == "xp"){
            $("#divIe").hide();
        }else if(navegador == "ie" && navVersion <= "9"){
            $("#divIe").show();
        }else if(navegador == "ie" && navVersion == "10"){
            $("#divIe").hide();
        }
        if(navegador == "firefox"){
            $("#divFirefox").hide();
        }
        if(navegador == "chrome"){
            $("#divChrome").hide();
        }
        if(navegador == "safari"){
            $("#divSafari").hide();
        }
        if(/opr/.test(usAgent)){
            $("#divOpera").hide();
            $("#divChrome").show();
        }
	}



	return {
		init : function (args){
			actualizaNavegador();
			decoratorController.setUpFromModule({ module :ModuleConstants.ERROR });
		}
	}
})();

$(document).ready(function() {
	errorController.init({});
});