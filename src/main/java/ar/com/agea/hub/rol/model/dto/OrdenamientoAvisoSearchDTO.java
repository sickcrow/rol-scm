/*
 * @(#)OrdenamientoAvisoSearchDTO.java		1.0 22/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;


/**
 * Representa un objeto Data Transfer Object para transferir datos de búsqueda de ordenamientos avisos.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
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
	 * Obtiene el objeto código nivel estructura de este DTO.
	 * 
	 * @return Objeto código nivel estructura de este DTO.
	 */
	public String getCodigoNivelEstructura() {
		return codigoNivelEstructura;
	}

	/**
	 * Setea el objeto código nivel estructura de este DTO.
	 * 
	 * @param codigoNivelEstructura Objeto código nivel estructura de este DTO.
	 */
	public void setCodigoNivelEstructura(String codigoNivelEstructura) {
		this.codigoNivelEstructura = codigoNivelEstructura;
	}

	/**
	 * Obtiene el objeto código agrupamiento producto técnico de este DTO.
	 * 
	 * @return Objeto código agrupamiento producto técnico de este DTO.
	 */
	public String getCodigoAgrupamientoProductoTecnico() {
		return codigoAgrupamientoProductoTecnico;
	}

	/**
	 * Setea el objeto código agrupamiento producto técnico de este DTO.
	 * 
	 * @param codigoAgrupamientoProductoTecnico Objeto código agrupamiento producto técnico de este DTO.
	 */
	public void setCodigoAgrupamientoProductoTecnico(
			String codigoAgrupamientoProductoTecnico) {
		this.codigoAgrupamientoProductoTecnico = codigoAgrupamientoProductoTecnico;
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

	/**
	 * Obtiene el objeto código individuo de este DTO.
	 * 
	 * @return Objeto código individuo de este DTO.
	 */
	public String getCodigoIndividuo() {
		return codigoIndividuo;
	}

	/**
	 * Setea el objeto código individuo de este DTO.
	 * 
	 * @param codigoIndividuo Objeto código individuo de este DTO.
	 */
	public void setCodigoIndividuo(String codigoIndividuo) {
		this.codigoIndividuo = codigoIndividuo;
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
