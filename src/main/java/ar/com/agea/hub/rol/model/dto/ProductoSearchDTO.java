/*
 * @(#)ProductoSearchDTO.java		1.0 30/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;


/**
 * Representa un objeto Data Transfer Object para transferir datos de búsqueda de productos.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 30/08/2013
 */
public class ProductoSearchDTO implements JSONDTO {
	
	private static final long serialVersionUID = 8512479503271281056L;
	
	private String codigoCanalEntrada;
	private String codigoClase;
	private String codigoTipoOperacion;
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
	 * Obtiene el objeto código tipo operación de este DTO.
	 * 
	 * @return Objeto código tipo operación de este DTO.
	 */
	public String getCodigoTipoOperacion() {
		return codigoTipoOperacion;
	}

	/**
	 * Setea el objeto código tipo operación de este DTO.
	 * 
	 * @param codigoTipoOperacion Objeto código tipo operación de este DTO.
	 */
	public void setCodigoTipoOperacion(String codigoTipoOperacion) {
		this.codigoTipoOperacion = codigoTipoOperacion;
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
		description.append(", codigoTipoOperacion: ").append(codigoTipoOperacion);
		description.append(", fechaVigencia: ").append(fechaVigencia);
		
		return description.toString();
	}
}
