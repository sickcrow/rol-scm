/*
 * @(#)TarjetaPagoDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de niveles de estructuras.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicaci�n y los
 * servicios HUB.
 * 
 * @author		Mauro Mosconi
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class TarjetaPagoDTO implements JSONDTO {

	private static final long serialVersionUID = -8056685470242557345L;
	
	private String codigoGATEWAY;
	private String descripcion;
	private String rutaImagenTC;
	
	private String prioridad;

	/**
	 * Obtiene el objeto c�digo gateway de este DTO. 
	 * 
	 * @return Objeto c�digo gateway de este DTO.
	 */
	public String getCodigoGATEWAY() {
		return codigoGATEWAY;
	}

	/**
	 * Setea el objeto c�digo gateway de este DTO.
	 * 
	 * @param codigoGATEWAY Objeto c�digo gateway de este DTO.
	 */
	public void setCodigoGATEWAY(String codigoGATEWAY) {
		this.codigoGATEWAY = codigoGATEWAY;
	}

	/**
	 * Obtiene el objeto descripci�n de este DTO. 
	 * 
	 * @return Objeto descripci�n de este DTO.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Setea el objeto descripci�n de este DTO.
	 * 
	 * @param descripcion Objeto descripci�n de este DTO.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene el objeto ruta imagen tarjeta cr�dito de este DTO. 
	 * 
	 * @return Objeto ruta imagen tarjeta cr�dito de este DTO.
	 */
	public String getRutaImagenTC() {
		return rutaImagenTC;
	}

	/**
	 * Setea el objeto ruta imagen tarjeta cr�dito de este DTO.
	 * 
	 * @param rutaImagenTC Objeto ruta imagen tarjeta cr�dito de este DTO.
	 */
	public void setRutaImagenTC(String rutaImagenTC) {
		this.rutaImagenTC = rutaImagenTC;
	}

	
	
	
	
	
	
	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoGATEWAY: ").append(codigoGATEWAY);
		description.append(", descripcion: ").append(descripcion);
		description.append(", rutaImagenTC: ").append(rutaImagenTC);
		
		return description.toString();
	}
}
