var sequenceCallerUI = (function (){
//private interface
	var postCalled ;
	var objectProcess;
	var blockLoaderUI;
	
	var block = function (){
		$.blockUI({message: blockLoaderUI});		
	};
	
	var unblock = function (){
		$.unblockUI();
	};
	
	
	var excecutePost = function(postToCall){
		var dataObject = postToCall.processCallBack(postToCall.staticObject,objectProcess);
		postCalled = postToCall;
		serviceConnector.post({ url: postToCall.url,
		    dataObject: dataObject,								   
		    successHandlerCallback : function (data){
	    							secuenceSuccesHandler(data);
		    															    							
		    						 },
		    errorHandlerCallback : function (jqXHR, textStatus, errorThrown){
		    						secuenceErrorHandler(jqXHR, textStatus, errorThrown)
		    						  
		    					   }
		  });
	}
	
	var secuenceSuccesHandler = function(data){
		var listaErrores = data.ROLResult.errors;
		if(postCalled.next != null && (listaErrores === undefined || listaErrores === null || listaErrores.length === 0)){
			objectProcess = postCalled.succesHandlerCallBack(data);
			postCalled = postCalled.next;
			excecutePost(postCalled);
		}
		else {
			
			postCalled.succesHandlerCallBack(data);
			
		}
	}
	
	var secuenceErrorHandler = function(data){
		//prueba mariano
//		if(postCalled.next != null){
//			objectProcess = postCalled.errorHandlerCallBack(data);
//			postCalled = postCalled.next;
//			excecutePost(postCalled);
//		}
		//
		
		postCalled.errorHandlerCallBack(data);
	}
	
	//public interface
	return {
		
		 createPost : function (arrayArgument){
			
			for(var i =0; i<arrayArgument.length;i++){
				var firstEvent = arrayArgument[i];
				if(i+1<arrayArgument.length){
					var nextEvent = arrayArgument[i+1];
					firstEvent.next = nextEvent;
				}
			}
			excecutePost(arrayArgument[0]);
			
		}
		
	}
})();

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