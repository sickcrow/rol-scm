/**
 * author: adifiore
 * version: 1.0.0
 * description: Clase que recopila funciones comunes para manipular strings.
 */
var stringUtils = (function () {

	// private interface ----------------------------

	var replaceAll = function (find, replace, str) {
		  			 	return str.replace(new RegExp(find, 'g'), replace);
					 };

	// public interface ----------------------------

	return {

		replaceAll : replaceAll

	}

})();

// Override for IE-8 compatibility.

if (!String.prototype.trim )
{
	String.prototype.trim = function()
	{
		return this.replace(/^\s+|\s+$/g, '');
	}
}

String.prototype.visualLength = function(clase)
{
    var ruler =  document.getElementById("ruler");
    var font = $(clase).css("font-size");
    if(font!=null&&font!=undefined){
    	ruler.style.fontSize = font;
    	ruler.innerHTML = this;
    	return ruler.offsetWidth;

    }
}

String.prototype.trimToPx = function(length,clase)
{
    var tmp = this;
    var trimmed = this;

    if (tmp.visualLength(clase) > length){
        trimmed += "...";
        while (trimmed.visualLength(clase) > length)
        {
            tmp = tmp.substring(0, tmp.length-1);
            trimmed = tmp + "...";
        }
    }

    return trimmed;
}