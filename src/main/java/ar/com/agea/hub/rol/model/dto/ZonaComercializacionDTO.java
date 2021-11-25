/*
 * @(#)ZonaComercializacionDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de zonas comercializaci�n.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicaci�n y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ZonaComercializacionDTO implements JSONDTO {

	private static final long serialVersionUID = 4784448558194147057L;
	
	private String codigo;
	private String descripcion;
	
	/**
	 * Obtiene el objeto c�digo de este DTO.
	 * 
	 * @return Objeto c�digo de este DTO.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Setea el objeto c�digo de este DTO.
	 * 
	 * @param codigo Objeto c�digo de este DTO.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigo: ").append(codigo);
		description.append(", descripcion: ").append(descripcion);
		
		return description.toString();
	}
}
