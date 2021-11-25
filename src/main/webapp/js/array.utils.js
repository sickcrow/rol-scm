/**
 * author: adifiore
 * version: 1.0.0
 * require: jquery.js
 * description: Clase que recopila funciones comunes para Arrays. 
 */
var arrayUtils = (function () {
	
	// private interface -------------------------------
	
	return {

		// public interface -------------------------------
		
		buildArrayObjFromJSON : function (arrayObjects, functionBuilder){
										
									var arrayResult = null;
			
									if ($.isArray(arrayObjects) && $.isFunction(functionBuilder)){
										
										arrayResult = new Array();
																				
										$.each(arrayObjects, function(index, value) {
											arrayResult.push(new functionBuilder(value));
										});
																															
									}			
										
									return arrayResult;										
								},
	
		singleResult : function (arrayObjects){
							return ($.isArray(arrayObjects) && arrayObjects.length === 1) ? arrayObjects[0] : null;
					   }
				
	}	
	
})();