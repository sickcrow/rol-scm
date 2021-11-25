/*
 * @(#)AgrupadorProductoZonasNivelesSearchDTO.java	1.0 02/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

/**
 * Representa un objeto Data Transfer Object para transferir datos de b�squeda de agrupadores de producto,
 * niveles de estructuras y zonas comercializaci�n.
 * <p>
 * Estos objetos son utilizados por front-end y la capa middleware de la aplicaci�n.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 02/09/2013
 */
public class AgrupadorProductoZonasNivelesSearchDTO implements JSONDTO {

	private static final long serialVersionUID = 1325249866368770319L;
	
	private String codigoCanalEntrada;
	private String codigoClase;
	private String codigoTipoOperacion;
	private String codigoAgrupamientoProductoTecnico;
	private Date fechaVigencia;

	/**
	 * Obtiene el objeto c�digo canal entrada de este DTO.
	 * 
	 * @return Objeto c�digo canal entrada de este DTO.
	 */
	public String getCodigoCanalEntrada() {
		return codigoCanalEntrada;
	}

	/**
	 * Setea el objeto c�digo canal entrada de este DTO.
	 * 
	 * @param codigoCanalEntrada Objeto c�digo canal entrada de este DTO.
	 */
	public void setCodigoCanalEntrada(String codigoCanalEntrada) {
		this.codigoCanalEntrada = codigoCanalEntrada;
	}

	/**
	 * Obtiene el objeto c�digo clase de este DTO.
	 * 
	 * @return Objeto c�digo clase de este DTO.
	 */
	public String getCodigoClase() {
		return codigoClase;
	}

	/**
	 * Setea el objeto c�digo clase de este DTO.
	 * 
	 * @param codigoClase Objeto c�digo clase de este DTO.
	 */
	public void setCodigoClase(String codigoClase) {
		this.codigoClase = codigoClase;
	}
	
	/**
	 * Obtiene el objeto c�digo tipo operaci�n de este DTO.
	 * 
	 * @return Objeto c�digo tipo operaci�n de este DTO.
	 */
	public String getCodigoTipoOperacion() {
		return codigoTipoOperacion;
	}

	/**
	 * Setea el objeto c�digo tipo operaci�n de este DTO.
	 * 
	 * @param codigoTipoOperacion Objeto c�digo tipo operaci�n de este DTO.
	 */
	public void setCodigoTipoOperacion(String codigoTipoOperacion) {
		this.codigoTipoOperacion = codigoTipoOperacion;
	}

	/**
	 * Obtiene el objeto c�digo agrupamiento producto t�cnico de este DTO.
	 * 
	 * @return Objeto c�digo agrupamiento producto t�cnico de este DTO.
	 */
	public String getCodigoAgrupamientoProductoTecnico() {
		return codigoAgrupamientoProductoTecnico;
	}
	
	/**
	 * Setea el objeto c�digo agrupamiento producto t�cnico de este DTO.
	 * 
	 * @param codigoTipoOperacion Objeto c�digo agrupamiento producto t�cnico de este DTO.
	 */
	public void setCodigoAgrupamientoProductoTecnico(String codigoAgrupamientoProductoTecnico) {
		this.codigoAgrupamientoProductoTecnico = codigoAgrupamientoProductoTecnico;
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
		description.append(", codigoAgrupamientoProductoTecnico: ").append(codigoAgrupamientoProductoTecnico);
		description.append(", fechaVigencia: ").append(fechaVigencia);
		
		return description.toString();
	}
}