/*
 * @(#)DTOFieldName.java		1.0 22/05/2014
 */

package ar.com.agea.hub.rol.utils;

/**
 * Representa los nombres de los campos de objetos DTOs.
 * <p>
 * Estos nombres son utilizados por la clase DefaultFacade para ofuscar
 * los valores de campos con el mismo nombre. 
 * 
 * @author		Eduardo Barrera
 * @version		1.0 22/05/2014
 */
public enum DTOFieldName {

	PALABRA_CLAVE("palabraClave");
	
	private String name;
	
	private DTOFieldName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el nombre del campo.
	 * 
	 * @return Nombre del campo.
	 */
	public String getName() {
		return name;
	}
}
