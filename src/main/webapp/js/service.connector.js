/**
 * author: adifiore
 * version: 1.0.0
 * require: jquery.js
 * description: Clase para hacer llamadas POST con AJAX. 
 */
var serviceConnector = (function () {
	
	// Metodos y Atributos privados
	
	var postHeaderConfiguration = {
		accept: "application/json; charset=UTF-8",
		contentType: "application/json"
	};
	
	var postConfiguration = {
		async: false,
		type: 'POST',
		dataType: 'json'
	};
		
	return {
		
		// Metodos y Atributos publicos
		
		/**
		 * Setea la configuracion del header de la llamada ajax por Post
		 * accept: String con el tipo de dato aceptado.
		 * contentType: String con el tipo de contenido aceptado.
		 */ 
		setPostHeaderConfiguration : function(_accept, _contentType){
			postHeaderConfiguration.accept = _accept;
			postHeaderConfiguration.contentType = _contentType;
		},
		
		/**
		 * Setea la configuracion central de la llamada ajax por Post
		 * async: Booleano que determina si el metodo es sincronico o no.
		 * dataType: String que determina el tipo de data que se va a postear.
		 */
		setPostConfiguration : function(_async, _dataType){
			postConfiguration.async = _async;
			postConfiguration.dataType = _dataType;		
		},
				
		/** 
		 * Postea en la url especificada el dataObject pasado, manejando el resultado 
		 * por los handlers.
		 * url: String que contiene la url del servicio que se desea postear.
		 * dataObject: Object contiene el objeto que se desea postear.
		 * successHandlerCallback: Funcion que maneja el exito de la llamada.
		 * errorHandlerCallback: Funcion que maneja el error de la llamada. 
		 */ 
		post : function(args){			
			$.ajax({
				headers: { 
			        'Accept': postHeaderConfiguration.accept,
			        'Content-Type': postHeaderConfiguration.contentType 
			    },
			    async: postConfiguration.async,
			    type: postConfiguration.type,
			    dataType: postConfiguration.dataType,
			    url: args.url,
			    data: JSON.stringify(args.dataObject),
			    success: args.successHandlerCallback,
			    error: args.errorHandlerCallback
			});
			
		}
		
	}
			
})();