/*
 * @(#)ModelSearchDTO.java		1.0 15/10/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de busqueda del modelo en session.
 * <p>
 * Estos objetos son utilizados por front-end y la capa middleware de la aplicación.
 * 
 * @author		Alejandro Di Fiore
 * @version		1.0 15/10/2013
 */
public class ModelSearchDTO implements JSONDTO {

	private static final long serialVersionUID = -2572115565433755391L;
	
	private String uuid;

	/**
	 * Obtiene el objeto uuid de este DTO.
	 * 
	 * @return Objeto uuid de este DTO.
	 */	
	public String getUuid() {
		return uuid;
	}

	/**
	 * Setea el objeto uuid de este DTO.
	 * 
	 * @param uuid Objeto uuid de este DTO.
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("uuid: ").append(uuid);
		
		return description.toString();
	}
}
