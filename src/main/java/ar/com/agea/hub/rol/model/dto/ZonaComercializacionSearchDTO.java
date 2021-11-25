/*
 * @(#)ZonaComercializacionSearchDTO.java		1.0 02/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;


/**
 * Representa un objeto Data Transfer Object para transferir datos de búsqueda de zonas de comercialización.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 02/09/2013
 */
public class ZonaComercializacionSearchDTO implements JSONDTO {
	
	private static final long serialVersionUID = 463279048538543641L;
	
	private String codigoProducto;
	private Date fechaVigencia;

	/**
	 * Obtiene el objeto código producto de este DTO.
	 * 
	 * @return Objeto código producto de este DTO.
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * Setea el objeto código producto de este DTO.
	 * 
	 * @param codigoProducto Objeto código producto de este DTO.
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	/**
	 * Obtiene el objeto fecha vigencia de este DTO.
	 * 
	 * @return Objeto fecha vigencia de este DTO.
	 */
	public Date getFechaVigencia() {
		Date result = null;
		
		if (fechaVigencia != null) {
			result = (Date) fechaVigencia.clone();
		}
		
		return result;
	}

	/**
	 * Setea el objeto fecha vigencia de este DTO.
	 * 
	 * @param fechaVigencia Objeto fecha vigencia de este DTO.
	 */
	public void setFechaVigencia(Date fechaVigencia) {
		if (fechaVigencia != null) {
			this.fechaVigencia = new Date(fechaVigencia.getTime());
		}
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoProducto: ").append(codigoProducto);
		description.append(", fechaVigencia: ").append(fechaVigencia);
		
		return description.toString();
	}
}
