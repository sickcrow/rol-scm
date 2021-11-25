/*
 * @(#)ClaseSearchDTO.java		1.0 26/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;


/**
 * Representa un objeto Data Transfer Object para transferir datos de búsqueda de clases.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/08/2013
 */
public class ClaseSearchDTO implements JSONDTO {
	
	private static final long serialVersionUID = -5420189606821633385L;
	
	private String codigoCanalEntrada;
	private String codigoClase;
	private Date fechaVigencia;

	/**
	 * Obtiene el objeto código canal entrada de este DTO.
	 * 
	 * @return Objeto código canal entrada de este DTO.
	 */
	public String getCodigoCanalEntrada() {
		return codigoCanalEntrada;
	}

	/**
	 * Setea el objeto código canal entrada de este DTO.
	 * 
	 * @param codigoCanalEntrada Objeto código canal entrada de este DTO.
	 */
	public void setCodigoCanalEntrada(String codigoCanalEntrada) {
		this.codigoCanalEntrada = codigoCanalEntrada;
	}

	/**
	 * Obtiene el objeto código clase de este DTO.
	 * 
	 * @return Objeto código clase de este DTO.
	 */
	public String getCodigoClase() {
		return codigoClase;
	}

	/**
	 * Setea el objeto código clase de este DTO.
	 * 
	 * @param codigoClase Objeto código clase de este DTO.
	 */
	public void setCodigoClase(String codigoClase) {
		this.codigoClase = codigoClase;
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
		
		description.append("codigoCanalEntrada: ").append(codigoCanalEntrada);
		description.append(", codigoClase: ").append(codigoClase);
		description.append(", fechaVigencia: ").append(fechaVigencia);
		
		return description.toString();
	}
}
