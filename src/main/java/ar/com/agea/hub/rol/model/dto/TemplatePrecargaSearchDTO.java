/*
 * @(#)TemplatePrecargaSearchDTO.java		1.0 07/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de busqueda del template para precarga.
 * <p>
 * Estos objetos son utilizados por front-end y la capa middleware de la aplicación.
 * 
 * @author		Alejandro Di Fiore
 * @version		1.0 07/01/2014
 */
public class TemplatePrecargaSearchDTO implements JSONDTO {
	
	private static final long serialVersionUID = -2375999290589429287L;

	private String codigo;

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
	 * @param uuid Objeto codigo de este DTO.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigo: ").append(codigo);
		
		return description.toString();
	}
}
