/**
 * author: adifiore
 * version: 1.0.0
 * description: Clase que vincula la UI con la logica en la pantalla de login.
 */

//-----------------------------------------------------------------------------
// logoutController -------------------------------------------------------
//-----------------------------------------------------------------------------

var logoutController = (function () {
		
	//------------------------------------------------
	// private interface -----------------------------
	//------------------------------------------------
		
	var logout = function (args){
		
		decoratorController.removeCookie({});
		decoratorController.removeCookieUsuario({});
		decoratorController.removeCookieCapturador({});
		decoratorModel.setCapturador(null);
		decoratorModel.setUsuario(null);
		
		blockCallerUI.blockPost({ url : LogoutServiceURL.LOGOUT,
			dataObject : null, 
			successHandlerCallback : handlerLogout,
			errorHandlerCallback : defaultErrorHandler });			
	};
	
	var handlerLogout = function (){		
		//redirect(URLConstants.ROL_LOGIN);
		//cambio redirect a crear aviso
		redirect(URLConstants.ROL_CREAR_AVISO);
	};
	
	var defaultErrorHandler = function(jqXHR, textStatus, errorThrown){
		alert("Ha ocurrido un error: " + jqXHR.responseText + " " + jqXHR.status + " " + jqXHR.statusText);
	};
	
	//------------------------------------------------
	// public interface ------------------------------
	//------------------------------------------------
	
	return {
	
		init : function (args){		
			decoratorController.setUpFromModule({ module :ModuleConstants.LOGOUT });
		},
	
		logout : function (args){
			logout({});
		}
	
	}	
		
})();

$(document).ready(function() {
	logoutController.init({});
	logoutController.logout({});
});