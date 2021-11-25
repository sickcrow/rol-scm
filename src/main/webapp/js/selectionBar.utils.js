/**
 * author: vdenicolo
 * version: 1.0.0
 * description: Funciones javascript utilizadas para la barra de seleccion de crear-aviso
 */
var selectionBarUtils = (function () {

	// private interface ------------------------
	
	// public interface -------------------------

	return {
		
		/**
		 * Devuelve el texto de lo seleccionado en el paso 'Que'
		 */
		generarTextoSeleccionaste : function(crearAvisosModel){
			return crearAvisosModel.getFamilia().descripcion+" > "+
					crearAvisosModel.getClase().descripcion+" > "+
					crearAvisosModel.getTipoOperacion().descripcion;				
		},
	
		/**
		 * Copio la funcion de Mariano, para obtener solo la Familia seleccionada en el paso 'Que'
		 */
		obtenerFamiliaSeleccionada : function(crearAvisosModel){
			try { 
				return crearAvisosModel.getFamilia().descripcion;
			}catch(err){ 
				return null; 
			}
		},
		
		
		/**
		 * Para obtener solo el bien seleccionado
		 */
		obtenerBienSeleccionado : function(crearAvisosModel){
			try { 
				return crearAvisosModel.getClase().descripcion;
			}catch(err){ 
				return null; 
			}
		},

		/**
		 * Para obtener solo el tipo de operacion seleccionado
		 */
		obtenerTipoOperacionSeleccionado : function(crearAvisosModel){
			try { 
				return crearAvisosModel.getTipoOperacion().descripcion;
			}catch(err){ 
				return null; 
			}
		},
	
		
		/**
		 * Devuelve el texto de las zonas seleccionadas en el paso 'Donde'
		 */
		generarZonasTextoSeleccionaste : function(crearAvisosModel){
			var zonasSeleccionadas = "";
			$.each(crearAvisosModel.getZonasComercializacion(), function(index, value){
				if(index != 0){
					zonasSeleccionadas = zonasSeleccionadas + " + ";
				}
				zonasSeleccionadas = zonasSeleccionadas + value.descripcion;
			});
			
			return zonasSeleccionadas;
		},
		
		
		/**
		 * Devuelve el texto del rubro seleccionado en el paso 'Donde'
		 */
		generarNivelEstructuraTextoSeleccionaste : function(crearAvisosModel){
			try {
				return crearAvisosModel.getOrdenDePublicacion().conceptosVendibles[0].itemsConceptoVendible[0].itemsAviso[0].aviso.nivelEstructura.descripcion;
			}catch(err){
				return null;
			}
			
		},
		
		
		/**
		 * Devuelve el texto de lo seleccionado en el paso 'Cuando'
		 */
		generarFechasTextoSeleccionaste : function(crearAvisosModel){
			var fechasSeleccionadas = "";
			if (crearAvisosModel.getSelectedDates()){
				$.each(crearAvisosModel.getSelectedDates(), function(index, value){
					if(index != 0){
						fechasSeleccionadas = fechasSeleccionadas + " - ";
					}
					
					if(typeof value == "string"){
						fechasSeleccionadas = fechasSeleccionadas + dateUtils.getDateString(dateUtils.getDateParse(value));
					}else{
						fechasSeleccionadas = fechasSeleccionadas + dateUtils.getDateString(dateUtils.getDateParseMiliseconds(value));
					}
				});
			};
			
			return fechasSeleccionadas;
		},
		
		
		/**
		 * Devuelve el texto de lo seleccionado en el paso 'Como'
		 */
		generarOrdenamientosTextoSeleccionaste : function(crearAvisosModel){
			var ordenamientosSeleccionados = "";
			
			var aux1 = [];
			var aux2 = [];
			
			if(crearAvisosModel.getConfiguracionesOrdenamientoPantalla() && crearAvisosModel.getConfiguracionesOrdenamientoPantalla()[0] !== undefined){
				aux1 = crearAvisosModel.getConfiguracionesOrdenamientoPantalla()[0].ordenamientosAviso;
			}
			if(crearAvisosModel.getConfiguracionesOrdenamientoPantalla() && crearAvisosModel.getConfiguracionesOrdenamientoPantalla()[1] !== undefined){
				aux2 = crearAvisosModel.getConfiguracionesOrdenamientoPantalla()[1].ordenamientosAviso;
			}
			
			var ordenamientos = aux1.concat(aux2);
			
			$.each(crearAvisosModel.getOrdenamientos(), function(index, value){
				//para cada ordenamiento, lo busco en las configuraciones para saber si es oculto o no.
				ordenamientoBuscado = null;
				$.each(ordenamientos, function(index, ordenamiento){
					if(value.codigo === ordenamiento.codigo){
						ordenamientoBuscado = ordenamiento;
					}
				});
				//si es oculto entonces no lo agrego
				if(ordenamientoBuscado.ocultarValorUnico === false){
					if(index != 0){
						ordenamientosSeleccionados = ordenamientosSeleccionados + " > ";
					}
					ordenamientosSeleccionados = ordenamientosSeleccionados + value.valor;
				}
			});
			
			return ordenamientosSeleccionados;
		}
		
	}
	
})();