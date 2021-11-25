/*
 * @(#)ROLFieldName.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.io.Serializable;

/**
 * Representa los nombres de campos de los servicios ROL.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public enum ROLFieldName implements Serializable {
	
	UID,
	APELLIDO,
	NOMBRE,
	GENERO,
	FECHA_NACIMIENTO,
	EMAIL,
	CONTRASENIA;
}
