/**
 * author: csantos version: 1.0.0 require: jquery.require.min.js|
 * En este archivo se especifica todos los archivos dependientes de crear aviso. 
 */

require.config({
	paths: {
		dateUtils :"date.utils", 
		selectionBarUtils :"selectionBar.utils", 
		modelIterator :"model.iterator", 
		crearAvisoModel :"crear-aviso/crearAviso.model", 
		crearAvisoTemplates	:"crear-aviso/crearAviso.templates", 
		crearAvisoControllerMain :"crear-aviso/crearAviso.controller", 
		crearAvisoControllerPasoQue:"crear-aviso/crearAviso.controller.paso.que", 
		crearAvisoControllerPasoDonde:"crear-aviso/crearAviso.controller.paso.donde", 
		crearAvisoControllerPasoCuando :"crear-aviso/crearAviso.controller.paso.cuando", 
		crearAvisoControllerPasoComo4 :"crear-aviso/crearAviso.controller.paso.como.4",
		crearAvisoControllerPasoComo5 :"crear-aviso/crearAviso.controller.paso.como.5", 
		crearAvisoControllerPasoComo6 :"crear-aviso/crearAviso.controller.paso.como.6", 
		crearAvisoControllerPasoConfYPago :"crear-aviso/crearAviso.controller.paso.confYPago", 
		jqueryRealPerson:"./lib/jqueryRealPerson" 
	}
});

require(["dateUtils",
         "selectionBarUtils",
         "modelIterator",
         "crearAvisoTemplates",
         "crearAvisoModel",
         "crearAvisoControllerMain",
         "jqueryRealPerson"
         ]);