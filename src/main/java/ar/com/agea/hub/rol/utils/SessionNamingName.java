/*
 * @(#)SessionNamingName.java		1.0 15/10/2013
 */

package ar.com.agea.hub.rol.utils;

/**
 * Representa los nombres de las constantes de session de la ROL.
 * <p>
 * Estos nombres son utilizados por las clase que extienden de ROLController 
 * para poder obtener los datos de la session que necesitan de acuerdo al 
 * contexto. 
 * 
 * @author		Alejandro Di Fiore
 * @version		1.0 15/10/2013
 */
public enum SessionNamingName {

	MODEL("MODEL"),
	CANTIDAD_INTENTOS_PROMOCION_365("CANTIDAD_INTENTOS_PROMOCION_365"),
	COTIZACION("COTIZACION"),
	TRACK_CAMPANA("TRACK_CAMPANA"),
	PRECIO_TOTAL_ORDEN_PUBLICACION_EDITADA("PRECIO_TOTAL_ORDEN_PUBLICACION_EDITADA");
	
	
	private String name;
	
	private SessionNamingName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el nombre del selector de session representado por su nombre.
	 * 
	 * @return Selector de session.
	 */
	public String getName() {
		return name;
	}
}
