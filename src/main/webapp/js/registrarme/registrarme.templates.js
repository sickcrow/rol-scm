/**
 * author: vdenicolo
 * version: 1.0.0
 * require: handlebars.js | data-utils.js
 * description: Clase placeholder para Templates y Helpers de componentes UI.
 */
RegistrarseTemplates = {};

/*********************************************************
 * Templates
 *********************************************************/

//Muestra el select para elegir el dia de nacimiento -------
RegistrarseTemplates.diaNacimiento = [
	"<label>D&iacute;a</label>",
	"<select id='diaNacimiento' class='' onfocus='gOnfocusRecuperarEstiloFechaHandler()'>",
		"<option data-value='-1'>D&iacute;a</option>",
		"{{genera-dias}}",
	"</select>"
].join("\n");

//Muestra el select para elegir el mes de nacimiento -------
RegistrarseTemplates.mesNacimiento = [
    "<label>Mes</label>",
	"<select id='mesNacimiento' class='' onfocus='gOnfocusRecuperarEstiloFechaHandler()'>",
		"<option data-value='-1'>Mes</option>",
		"{{genera-meses}}",
	"</select>"
].join("\n");

//Muestra el select para elegir el anio de nacimiento -------
RegistrarseTemplates.anioNacimiento = [
    "<label>A&ntilde;o</label>",
	"<select id='anioNacimiento' class='' onfocus='gOnfocusRecuperarEstiloFechaHandler()'>",
		"<option data-value='-1'>A&ntilde;o</option>",
		"{{genera-anios}}",
	"</select>"
].join("\n");

/*********************************************************
 * Helpers
 *********************************************************/

RegistrarseHelpers = {};

RegistrarseHelpers.generaDiasHelper = function(){
	var out = "";
	for(var i=1; i<=31; i++) {
		out = out + "<option data-value='"+i+"'>"+i+"</option>";
	}
	
	return new Handlebars.SafeString(out);
};

RegistrarseHelpers.generaMesesHelper = function(){
	var out = "";
	var meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", 
	             "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
	for(var i=0; i<12; i++) {
		out = out + "<option data-value='"+(i+1)+"'>"+meses[i]+"</option>";
	}
	
	return new Handlebars.SafeString(out);
};

RegistrarseHelpers.generaAniosHelper = function(){
	var out = "";
	for(var i= new Date().getFullYear(); i>=1900; i--) {
		out = out + "<option data-value='"+i+"'>"+i+"</option>";
	}
	
	return new Handlebars.SafeString(out);
};