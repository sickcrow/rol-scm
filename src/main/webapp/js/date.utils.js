/**
 * author: adifiore
 * version: 1.0.0
 * description: Clase que recopila funciones comunes para date (fechas).
 */
var dateUtils = (function () {

	// private interface ------------------------
	
	Date.prototype.addDays = function(days) {
		var dat = new Date(this.valueOf())
		dat.setDate(dat.getDate() + days);
		return dat;
	};	
	
	// public interface ------------------------

	return {
		
		// constantes ------------------------
					
		ONE_DAY_MILLISECONDS : 86400000,
		
		SHORT_FORMAT_STRING_DATA : "yy-mm-dd",
	
		MONTHS_STRING_ARRAY : [ "Ene", "Feb", "Mar", "Abr", "May", "Jun",
		                        "Jul", "Ago", "Sep", "Oct", "Nov", "Dic" ],
		
		getDateRange : function(startDate, stopDate) {
			
			var dateArray = new Array();
		    var currentDate = startDate;
		    
		    while (currentDate <= stopDate) {
		    	dateArray.push(currentDate)
		        currentDate = currentDate.addDays(1);
		    }
		    
		    return dateArray;
		},
		
		
		substractDays : function(baseDays, substractDays){
			
			var diferenceDays = new Array();
			var encontrado = false;
			
			for (i = 0; i < baseDays.length; i ++ ) {				
				encontrado = false;				
				for (j = 0; j < substractDays.length && !encontrado; j ++ ) {
					var dateBase = (new Date(baseDays[i])).setHours(0,0,0,0);
					var dateSubstract = (new Date(substractDays[j])).setHours(0,0,0,0);
					if (dateBase == dateSubstract){
						encontrado = true;						
					}						
				}				
				if (!encontrado){
					diferenceDays.push(baseDays[i]);
				}				
			}	
			
			return diferenceDays;
		},	
		
		/**
		 * Devuelve la fecha pasada por parametro en formato string 'YYYY-MM-DD'. 
		 */
getDateFormatString : function(date){
			
			var zeroMes = "";
			var zeroDia = "";
			var dia  = date.getDate();
		    var mes  = date.getMonth() + 1; // Meses son 0 base.
		    var anio = date.getFullYear();
//		    Para que escriba correctamente el formato de fecha, es necesario que agregue ceros cuando es un digito
		    if (mes < 10){
		    	zeroMes = "0";
		    }
		    if (dia < 10){
		    	zeroDia = "0";
		    }
		    return anio + "-" + zeroMes + mes + "-" + zeroDia + dia;			
		},
		
		/**
		 * Devuelve la fecha pasada por parametro en formato string 'DD/MM/YYYY'. 
		 */
		getDateString : function(date){
			
			var zeroMes = "";
			var zeroDia = "";
			var dia  = date.getDate();
		    var mes  = date.getMonth() + 1; // Meses son 0 base.
		    var anio = date.getFullYear();
		    //Para que escriba correctamente el formato de fecha, es necesario que agregue ceros cuando es un digito
		    if (mes < 10){
		    	zeroMes = "0";
		    }
		    if (dia < 10){
		    	zeroDia = "0";
		    }
		    return zeroDia + dia + "/" + zeroMes + mes + "/" + anio;			
		},
		
		/**
		 * Devuelve la fecha apartir de una fecha string en formato 'YYYY-MM-DD'.  
		 */
		getDateParse : function(dateString) {
			var parts;
		  try {
			  parts = dateString.split('-');
			  /**
			   * new Date(year, month [, date [, hours[, minutes[, seconds[, ms]]]]])
			   * Meses son 0 base.
			   */
			  return new Date(parts[0], parts[1]-1, parts[2]);		  
		  } catch(err) {
			  parts = new Date(dateString);
			  return new Date(parts.getUTCFullYear(), parts.getUTCMonth(), parts.getUTCDate());
		  }
		},
		
		/**
		 * Devuelve la fecha apartir de una fecha en formato de milisegundos.  
		 */
		getDateParseMiliseconds : function(dateMiliseconds) {
			
		  var date = new Date(dateMiliseconds);
		 
		  return new Date(date.getUTCFullYear(), date.getUTCMonth(), date.getUTCDate());		  
		}
		
	}
	
})();