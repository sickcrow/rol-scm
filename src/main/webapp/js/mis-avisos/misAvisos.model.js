/**
 * author: vdenicolo
 * version: 1.0.0
 * require: .js
 * description: Clase que contiene los datos del modelo necesarios para el modulo de mis-avisos.
 */
var misAvisosModel = (function () {
	
	// private interface ----------------------------		

	var listaOrdenesDePublicacion			= null;
	
	var ordenSeleccionada					= null;
	
	// public interface ----------------------------
	
	return {
		
		// listaOrdenesDePublicacion ----------
				
		setListaOrdenesDePublicacion : function(_listaOrdenes){
			listaOrdenesDePublicacion = _listaOrdenes;			
		},
		
		getListaOrdenesDePublicacion : function(){
			return listaOrdenesDePublicacion;
		},
		
		setOrdenSeleccionada: function(_ordenSeleccionada){
			ordenSeleccionada = _ordenSeleccionada;
		},
		
		getOrdenSeleccionada: function(){
			return ordenSeleccionada;
		}
		
	}	
	
})();