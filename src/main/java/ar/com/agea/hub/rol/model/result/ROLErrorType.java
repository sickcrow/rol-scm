/*
 * @(#)HUBErrorType.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.io.Serializable;

/**
 * Representa los tipos de errores de los servicios ROL.
 * <p>
 * Estos tipos de errores son utilizados por Spring Web MVC para convertir
 * los objetos JSON que retornan los servicios PASE a objetos Java
 * utilizados por la aplicación. Esta clase es utilizada en conjunto
 * con Result y Error.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public enum ROLErrorType implements Serializable {

	SECURITY,
	VALIDATION,
	REDIRECTION,
	EXCEPTION;
}
