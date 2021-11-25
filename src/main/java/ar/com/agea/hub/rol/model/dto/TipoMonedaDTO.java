/*
 * @(#)TipoMonedaDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de tipos de monedas.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class TipoMonedaDTO implements JSONDTO {
	
	private static final long serialVersionUID = 3727915296959990881L;
	
	private String codigo;

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

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();

		description.append("codigo: ").append(codigo);
		
		return description.toString();
	}
}
