/**
 * author: adifiore
 * version: 1.0.0
 * require: jquery.js | jquery.blockUI.js
 * description: Clase utilizada para el bloqueo de la pantalla en llamadas
 * 				remotas o funciones.
 */
var blockCallerUI = (function () {

	// private interface -----------------------------------------

	var blockLoaderUI;

	var block = function (){
		$.blockUI({message: blockLoaderUI});
	};

	var unblock = function (){
		$.unblockUI();
	};

	// public interface -------------------------------------------

	return {

		/**
		 * {
		 * 	blockLoaderUI - Componente grafico que se muestra cuando se blockea la pantalla.
		 * 	css - CSS del blocker que contiene blockLoaderUI.
		 * }
		 */
		init : function(args){
			blockLoaderUI = args.blockLoaderUI;
			$.blockUI.defaults.css = args.css;
		},

		blockFunction : function (blockedFunction){
			block();
			blockedFunction();
			unblock();
		},

		/**
		 * {
		 * 	url - url del servicio post.
		 * 	dataObject - data object que recibe el servicio post correspondiente a la url.
		 * 	successHandlerCallback - handler en caso de exito de la llamada post.
		 * 	errorHandlerCallback - handler en caso de error de la llamada post.
		 * }
		 */
		blockPost : function (args){
			block();
			if(args.async != null && args.dataType != null){
				serviceConnector.setPostConfiguration(args.async, args.dataType);
			}
			serviceConnector.post({ url: args.url,
								    dataObject: args.dataObject,
								    successHandlerCallback : function (data){
								    							args.successHandlerCallback(data);
								    							unblock();
								    						 },
								    errorHandlerCallback : function (jqXHR, textStatus, errorThrown){
								    					      args.errorHandlerCallback(jqXHR, textStatus, errorThrown);
								    						  unblock();
								    					   }
								  });

		}

	}

})();

// init module -------------------------------------------

$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
$(document).ready(function() {

	blockCallerUI.init({ blockLoaderUI : $("#throbber"),
					   css : {
							padding:    0,
							margin:     0,
							width:      '30%',
							top:        '40%',
							left:       '35%',
							textAlign:  'center',
							cursor:     'wait'
						}});

});