/*
 * @(#)PropiedadDefaultDTO.java		1.0 21/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de propiedades default.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 21/08/2013
 */
public class PropiedadDefaultDTO implements JSONDTO {

	private static final long serialVersionUID = -7661926887201476655L;
	
	private String codigo;
	private String valor;

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
	 * Obtiene el objeto valor de este DTO. 
	 * 
	 * @return Objeto valor de este DTO.
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Setea el objeto valor de este DTO.
	 * 
	 * @param valor Objeto valor de este DTO.
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigo: ").append(codigo);
		description.append(", valor: ").append(valor);
		
		return description.toString();
	}
}
