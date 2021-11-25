/*
 * @(#)ProvinciaDTO.java		1.0 24/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de provincias.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Mariano De Nicolo
 * @version		1.0 21/01/2014
 */
public class ProvinciaDTO implements JSONDTO{

	private static final long serialVersionUID = -3560227241529646411L;

	private Long id;
	private String codigo;
	private String codigoPais;
	
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
	 * Obtiene el objeto código de este DTO.
	 * 
	 * @return Objeto código de este DTO.
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Setea el objeto código de este DTO.
	 * 
	 * @param codigo Objeto código de este DTO.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Obtiene el objeto código país de este DTO.
	 * 
	 * @return Objeto código país de este DTO.
	 */
	public String getCodigoPais() {
		return codigoPais;
	}
	
	/**
	 * Setea el objeto código país de este DTO.
	 * 
	 * @param codigoPais Objeto código país de este DTO.
	 */
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("id: ").append(id);
		description.append(", codigo: ").append(codigo);
		description.append(", codigoPais: ").append(codigoPais);
		
		return description.toString();
	}
}
