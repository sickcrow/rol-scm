/*
 * @(#)OrdenamientoAvisoSearchDTO.java		1.0 22/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;


/**
 * Representa un objeto Data Transfer Object para transferir datos de b�squeda de ordenamientos avisos.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicaci�n y los
 * servicios HUB.
 * 
 * @author		Mariano De Nicolo
 * @version		1.0 22/07/2013
 */
public class OrdenamientoAvisoSearchDTO implements JSONDTO {
	
	private static final long serialVersionUID = 9143252279469665873L;
	
	private String codigoCanalEntrada;
	private String codigoNivelEstructura;
	private String codigoAgrupamientoProductoTecnico;
	private String codigoTipoOperacion;
	private Date fechaVigencia;
	private String codigoIndividuo;
	private String codigoClase;

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
	 * Obtiene el objeto c�digo nivel estructura de este DTO.
	 * 
	 * @return Objeto c�digo nivel estructura de este DTO.
	 */
	public String getCodigoNivelEstructura() {
		return codigoNivelEstructura;
	}

	/**
	 * Setea el objeto c�digo nivel estructura de este DTO.
	 * 
	 * @param codigoNivelEstructura Objeto c�digo nivel estructura de este DTO.
	 */
	public void setCodigoNivelEstructura(String codigoNivelEstructura) {
		this.codigoNivelEstructura = codigoNivelEstructura;
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
	 * @param codigoAgrupamientoProductoTecnico Objeto c�digo agrupamiento producto t�cnico de este DTO.
	 */
	public void setCodigoAgrupamientoProductoTecnico(
			String codigoAgrupamientoProductoTecnico) {
		this.codigoAgrupamientoProductoTecnico = codigoAgrupamientoProductoTecnico;
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

	/**
	 * Obtiene el objeto c�digo individuo de este DTO.
	 * 
	 * @return Objeto c�digo individuo de este DTO.
	 */
	public String getCodigoIndividuo() {
		return codigoIndividuo;
	}

	/**
	 * Setea el objeto c�digo individuo de este DTO.
	 * 
	 * @param codigoIndividuo Objeto c�digo individuo de este DTO.
	 */
	public void setCodigoIndividuo(String codigoIndividuo) {
		this.codigoIndividuo = codigoIndividuo;
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

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoCanalEntrada: ").append(codigoCanalEntrada);
		description.append(", codigoNivelEstructura: ").append(codigoNivelEstructura);
		description.append(", codigoAgrupamientoProductoTecnico: ").append(codigoAgrupamientoProductoTecnico);
		description.append(", codigoTipoOperacion: ").append(codigoTipoOperacion);
		description.append(", fechaVigencia: ").append(fechaVigencia);
		description.append(", codigoIndividuo: ").append(codigoIndividuo);
		description.append(", codigoClase: ").append(codigoClase);
		
		return description.toString();
	}
}
