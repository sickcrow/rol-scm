/*
 * @(#)LimiteCotizacionDTO.java		1.0 16/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos del aviso.
 * Estos objetos son utilizados por front-end.
 * 
 * @author		Mariano De Nicolo
 * @version		1.0 16/01/2014
 */
public class LimiteCotizacionDTO implements JSONDTO{
	
	private static final long serialVersionUID = -5429016090075013724L;
	
	private Double montoAviso;

	/**
	 * Obtiene el objeto montoAviso de este DTO.
	 * 
	 * @return Objeto montoAviso de este DTO.
	 */
	public Double getMontoAviso() {
		return montoAviso;
	}

	/**
	 * Setea el objeto montoAviso de este DTO.
	 * 
	 * @param uuid Objeto montoAviso de este DTO.
	 */
	public void setMontoAviso(Double montoAviso) {
		this.montoAviso = montoAviso;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("montoAviso: ").append(montoAviso);
		
		return description.toString();
	}
}
