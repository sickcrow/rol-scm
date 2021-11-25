/**
 * author: adifiore
 * version: 1.0.0
 * require: jquery.js 
 * description: Clase utilizada para la iteracion de la orden de publicacion. 
 */
var modelIterator = (function () {
	
	// private interface -----------------------------------------
				
	// public interface -------------------------------------------
	 
	return {
	
		iterateConceptosVendibles : function (conceptosVendiblesDTO, args, callback){
			$.each(conceptosVendiblesDTO, function( index, conceptoVendibleDTO ) {
				callback(index, conceptoVendibleDTO, args);
			});			
		},	
		
		iterateItemsConceptoVendible : function (itemsConceptoVendibleDTO, args, callback){
			$.each(itemsConceptoVendibleDTO, function( index, itemConceptoVendibleDTO ) {
				callback(index, itemConceptoVendibleDTO, args);
			});	
		},
		
		iterateItemsAviso : function (itemsAvisoDTO, args, callback){
			$.each(itemsAvisoDTO, function( index, itemAvisoDTO ) {
				callback(index, itemAvisoDTO, args);
			});	
		},
		
		iterateAvisosFromOrden : function (ordenDePublicacionDTO, args, callback){
			$.each(ordenDePublicacionDTO.conceptosVendibles, function( index, conceptoVendibleDTO ) {
				$.each(conceptoVendibleDTO.itemsConceptoVendible, function( index, itemConceptoVendibleDTO ) {
					$.each(itemConceptoVendibleDTO.itemsAviso, function( index, itemAvisoDTO ) {
						callback(index, itemAvisoDTO.aviso, args);
					});	
				});	
			});
		},
		
		iterateItemsAvisoFromOrden : function (ordenDePublicacionDTO, args, callback){
			$.each(ordenDePublicacionDTO.conceptosVendibles, function( index, conceptoVendibleDTO ) {
				$.each(conceptoVendibleDTO.itemsConceptoVendible, function( index, itemConceptoVendibleDTO ) {
					$.each(itemConceptoVendibleDTO.itemsAviso, function( index, itemAvisoDTO ) {
						callback(index, itemAvisoDTO, args);
					});	
				});	
			});
		},
		
		iterateItemsConceptoVendibleFromOrden : function (ordenDePublicacionDTO, args, callback){
			$.each(ordenDePublicacionDTO.conceptosVendibles, function( index, conceptoVendibleDTO ) {
				$.each(conceptoVendibleDTO.itemsConceptoVendible, function( index, itemConceptoVendibleDTO ) {
					callback(index, itemConceptoVendibleDTO, args);						
				});	
			});
		},
		
		iterateConceptosVendiblesFromOrden : function (ordenDePublicacionDTO, args, callback){
			$.each(ordenDePublicacionDTO.conceptosVendibles, function( index, conceptoVendibleDTO ) {
				callback(index, conceptoVendibleDTO, args);					
			});
		},
		
		iteratePromocionesFromConceptoVendible : function(conceptoVendibleDTO,args,callback){
			$.each(conceptoVendibleDTO.itemsConceptoVendible, function( index, itemConceptoVendibleDTO ) {
				$.each(itemConceptoVendibleDTO.itemsAviso, function( index, itemAvisoDTO ) {
					$.each(itemAvisoDTO.aviso.avisoPromocion, function( index, avisoPromocionDTO ) {
						callback(index, avisoPromocionDTO, args);
					});
				});	
			});
		}
		
	}	
	
})();