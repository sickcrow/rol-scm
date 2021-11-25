/*
 * @(#)LocalidadDTO.java		1.0 22/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de localidades.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Mariano De Nicolo
 * @version		1.0 22/01/2014
 */
public class LocalidadDTO implements JSONDTO{

	private static final long serialVersionUID = -1582039705997313321L;
	
	private Long id;
	private String codigo;
	private String codigoProvincia;
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
	
	/**
	 * Obtiene el objeto codigoProvincia de este DTO.
	 * 
	 * @return Objeto codigoProvincia de este DTO.
	 */
	public String getCodigoProvincia() {
		return codigoProvincia;
	}
	
	/**
	 * Setea el objeto codigoProvincia de este DTO.
	 * 
	 * @param codigoProvincia Objeto codigoProvincia de este DTO.
	 */
	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}
	
	/**
	 * Obtiene el objeto codigoPais de este DTO.
	 * 
	 * @return Objeto codigoPais de este DTO.
	 */
	public String getCodigoPais() {
		return codigoPais;
	}
	
	/**
	 * Setea el objeto codigoPais de este DTO.
	 * 
	 * @param codigoPais Objeto codigoPais de este DTO.
	 */
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("id: ").append(id);
		description.append(", codigo: ").append(codigo);
		description.append(", codigoProvincia: ").append(codigoProvincia);
		description.append(", codigoPais: ").append(codigoPais);
		
		return description.toString();
	}
}
