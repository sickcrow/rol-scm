/*
 * @(#)PropiedadDefaultName.java		1.0 12/02/2014
 */

package ar.com.agea.hub.rol.utils;

/**
 * Representa los nombres de los códigos de un objeto PropiedadDefaultDTO.
 * <p>
 * Estos nombres son utilizados por la clase URLServiceResolver y HttpHeadersResolver
 * para resolver las rutas de los servicios GWP, HUB y PASE. 
 * 
 * @author		Eduardo Barrera
 * @version		1.0 12/02/2014
 */
public enum PropiedadDefaultName {

	ROL_PARAMETRO_NOMBRE_ITEM_GWP_TRANSACCION_REALIZAR ("ROL_PARAMETRO_NOMBRE_ITEM_GWP_TRANSACCION_REALIZAR"),
	ROL_MAX_INTENTOS_LOGIN ("ROL_MAX_INTENTOS_LOGIN"),
	ROL_LIMITE_COTIZACION_DIRECCION_REQUERIDA ("ROL_LIMITE_COTIZACION_DIRECCION_REQUERIDA"),
	ROL_MAX_INTENTOS_PROMOCION365 ("ROL_MAX_INTENTOS_PROMOCION365"),
	HTTP_PROXY_HOST ("http.proxyHost"),
	HTTP_PROXY_PORT ("http.proxyPort");	
	
	
	private String clave;
	
	private PropiedadDefaultName(String clave) {
		this.clave = clave;
	}

	public String getClave() {
		return clave;
	}
	
}
