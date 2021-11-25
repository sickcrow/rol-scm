/*
 * @(#)HUBErrorType.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.io.Serializable;

/**
 * Representa los tipos de errores de los servicios HUB.
 * <p>
 * Estos tipos de errores son utilizados por Spring Web MVC para convertir
 * los objetos JSON que retornan los servicios HUB a objetos Java
 * utilizados por la aplicación. Esta clase es utilizada en conjunto
 * con Result y Error.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public enum HUBErrorType implements Serializable {
	
	NULLED_VALUE,
	EMPTY_VALUE,
	NULLED_EMPTY_VALUE,
	EXIST_VALUE,
	NOT_EXIST_VALUE,
	NOT_APPLIED_VALUE,
	NOT_EQUAL_VALUE,
	DUPLICATED_VALUE,
	EXCEPTION_OCCURRED;
}
