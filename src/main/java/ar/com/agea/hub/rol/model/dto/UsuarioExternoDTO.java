/*
 * @(#)UsuarioExternoDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de usuarios externos.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicaci�n y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class UsuarioExternoDTO implements JSONDTO {
	
	private static final long serialVersionUID = -6114250148900876790L;
	
	private String codigo;
	private String codigoSistema;
	
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
	 * Obtiene el objeto c�digo sistema de este DTO.
	 * 
	 * @return Objeto c�digo sistema de este DTO.
	 */
	public String getCodigoSistema() {
		return codigoSistema;
	}
	
	/**
	 * Setea el objeto c�digo sistema de este DTO.
	 * 
	 * @param codigoSistema Objeto c�digo sistema de este DTO.
	 */
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigo: ").append(codigo);
		description.append(", codigoSistema: ").append(codigoSistema);
		
		return description.toString();
	}
}
