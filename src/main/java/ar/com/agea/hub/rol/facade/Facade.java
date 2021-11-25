/*
 * @(#)Facade.java		1.0 23/10/2013
 */

package ar.com.agea.hub.rol.facade;

import java.util.Set;

import ar.com.agea.hub.rol.utils.DTOFieldName;
import ar.com.agea.hub.rol.utils.URLServiceName;

/**
 * Brinda una interfaz de conexión y ejecución de servicios HUB y PASE
 * a todos los Controllers.
 * 
 * @author		Eduardo Barrera
 * @author		Juan Martín Lichowski
 * @version		1.0 23/10/2013
 */
public interface Facade {

	/**
	 * Realiza una llamada a un servicio HUB o PASE determinado por su nombre.
	 * 
	 * @param urlServiceName Nombre del servicio HUB.
	 * @param object Objeto de entrada del servicio HUB.
	 * @param clazz Objeto de salida del servicio HUB.
	 * @param fieldsToObfuscate Objetos DTOFieldName que representan los campos cuyos valores deben ser ofuscados. 
	 * @return Salida del servicio HUB.
	 */
	<T> T callService(URLServiceName urlServiceName, Object object, Class<T> clazz, Set<DTOFieldName> fieldsToObfuscate);
}
