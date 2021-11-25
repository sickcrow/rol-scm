/**
 * author: adifiore
 * version: 1.0.0
 * require: header-model.js
 * description: Clase que contiene los datos del modelo necesarios para el modulo header.
 */
var decoratorModel = (function () {
	
	// private interface ----------------------------		

	var usuario				= null;
	var usuarioTemporal		= null;
	var capturador 			= null;
	var emailValidated		= null;
	var codigoCanalEntrada	= "ROL";
	var expiredSession		= false;
	var A1 = "indefinido";
	var A2 = "indefinido";
	var A3 = "indefinido";
	var A4 = "indefinido";
	var A5 = "indefinido";
	
	// public interface ----------------------------
	
	return {
		
		// Usuario ----------
				
		setUsuario : function(_usuario){
			usuario = _usuario;			
		},
		
		getUsuario : function(){
			return usuario;
		},
		
		//Este Set y get, es una bandera para manejar casos particulares de los pasos del wizzard
		//Se implementa principalmente 
		setExpired : function(_flag){
			expiredSession = _flag;
		},
		
		getExpired : function(){
			return expiredSession;
		},
		
		// UsuarioTemporal ----------
		
		setUsuarioTemporal : function(_usuarioTemporal){
			usuarioTemporal = _usuarioTemporal;			
		},
		
		getUsuarioTemporal : function(){
			return usuarioTemporal;
		},
		
		// Capturador ----------
		
		setCapturador : function(_capturador){
			capturador = _capturador;			
		},
		
		getCapturador : function(){
			return capturador;
		},
		
		setCookieCapturador : function(_capturador){
			$.cookie('capturador', _capturador);
		},
		
		// EmailValidated ----------
		
		setEmailValidated : function(_emailValidated){
			emailValidated = _emailValidated;			
		},
		
		getEmailValidated : function(){
			return emailValidated;
		},
		
		setCodigoCanalEntrada: function(_codigoCanalEntrada){
			codigoCanalEntrada = _codigoCanalEntrada;
		},
		
		getCodigoCanalEntrada: function(){
			return codigoCanalEntrada;
		},
		
		//Areas
		
		setA1 : function(_A1) {
			A1 = _A1.toLowerCase();
			A2 = "indefinido";
			A3 = "indefinido";
			A4 = "indefinido";
			A5 = "indefinido";
		},
		
		getA1 : function() {
			return '.'+A1;
		},
		
		setA2 : function(_A2) {
			A2 = _A2.toLowerCase();
			A3 = "indefinido";
			A4 = "indefinido";
			A5 = "indefinido";
		},
		
		getA2 : function() {
			return '.'+A2;
		},
		
		setA3 : function(_A3) {
			A3 = _A3.toLowerCase();
			A4 = "indefinido";
			A5 = "indefinido";
		},
		
		getA3 : function() {
			return '.'+A3;
		},
		
		setA4 : function(_A4) {
			A4 = _A4.toLowerCase();
			A5 = "indefinido";
		},
		
		getA4 : function() {
			return '.'+A4;
		},
		
		setA5 : function(_A5) {
			A5 = _A5.toLowerCase();
		},
		
		getA5 : function() {
			return '.'+A5;
		}
		
	}	
	
})();  
