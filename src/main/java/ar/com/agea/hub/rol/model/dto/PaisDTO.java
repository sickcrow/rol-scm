/*
 * @(#)PaisDTO.java		1.0 24/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de paises.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Mariano De Nicolo
 * @version		1.0 21/01/2014
 */
public class PaisDTO implements JSONDTO{

	private static final long serialVersionUID = 1855779081644192456L;
	
	private Long id;
	private String codigo;
	
	/**
	 * Obtiene el objeto id de este DTO. 
	 * 
	 * @return Objeto id de este DTO.
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Setea el objeto id de este DTO.
	 * 
	 * @param id Objeto id de este DTO.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Obtiene el objeto codigo de este DTO. 
	 * 
	 * @return Objeto codigo de este DTO.
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Setea el objeto codigo de este DTO.
	 * 
	 * @param codigo Objeto codigo de este DTO.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("id: ").append(id);
		description.append(", codigo: ").append(codigo);
		
		return description.toString();
	}
}
