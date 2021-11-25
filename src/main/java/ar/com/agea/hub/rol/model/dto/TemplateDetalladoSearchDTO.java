/*
 * @(#)TemplateDetalladoSearchDTO.java		1.0 30/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;
import java.util.List;

/**
 * @author 		Martin Lichowski.
 * @version		1.0 30/01/2014
 */
public class TemplateDetalladoSearchDTO implements JSONDTO {

	private static final long serialVersionUID = 7031730957186929138L;
	
	private String codigoNivelEstructura;
	private String codigoCanalEntrada;
	private String codigoAgrupamientoProductoTecnico;	
	private String codigoTipoOperacion;
	private Date fechaVigencia;
	private List<String> promocionesAplicadas;
	
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
	 * @param codigo Objeto código nivel estructura de este DTO.
	 */
	public void setCodigoNivelEstructura(String codigoNivelEstructura) {
		this.codigoNivelEstructura = codigoNivelEstructura;
	}

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
	 * @param codigo Objeto código canal entrada de este DTO.
	 */
	public void setCodigoCanalEntrada(String codigoCanalEntrada) {
		this.codigoCanalEntrada = codigoCanalEntrada;
	}

	/**
	 * Obtiene el objeto codigo agrupamiento producto tecnico de este DTO. 
	 * 
	 * @return Objeto codigo agrupamiento producto tecnico de este DTO.
	 */
	public String getCodigoAgrupamientoProductoTecnico() {
		return codigoAgrupamientoProductoTecnico;
	}

	/**
	 * Setea el objeto codigo agrupamiento producto tecnico de este DTO.
	 * 
	 * @param codigoAgrupamientoProductoTecnico Objeto codigo agrupamiento producto tecnico de este DTO.
	 */
	public void setCodigoAgrupamientoProductoTecnico(
			String codigoAgrupamientoProductoTecnico) {
		this.codigoAgrupamientoProductoTecnico = codigoAgrupamientoProductoTecnico;
	}

	/**
	 * Obtiene el objeto codigo tipo operacion de este DTO. 
	 * 
	 * @return Objeto codigo tipo operacion de este DTO.
	 */
	public String getCodigoTipoOperacion() {
		return codigoTipoOperacion;
	}

	/**
	 * Setea el objeto codigo tipo operacion de este DTO.
	 * 
	 * @param codigoTipoOperacion Objeto codigo tipo operacion de este DTO.
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
	 * @param codigo Objeto fecha vigencia de este DTO.
	 */
	public void setFechaVigencia(Date fechaVigencia) {
		if (fechaVigencia != null) {
			this.fechaVigencia = new Date(fechaVigencia.getTime());
		}
	}
	
	
	
	/**
	 * @return the promocionesAplicadas
	 */
	public List<String> getPromocionesAplicadas() {
		return promocionesAplicadas;
	}

	/**
	 * @param promocionesAplicadas the promocionesAplicadas to set
	 */
	public void setPromocionesAplicadas(List<String> promocionesAplicadas) {
		this.promocionesAplicadas = promocionesAplicadas;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoNivelEstructura: ").append(codigoNivelEstructura);
		description.append(", codigoCanalEntrada: ").append(codigoCanalEntrada);
		description.append(", codigoAgrupamientoProductoTecnico: ").append(codigoAgrupamientoProductoTecnico);
		description.append(", codigoTipoOperacion: ").append(codigoTipoOperacion);
		description.append(", fechaVigencia: ").append(fechaVigencia);
		
		return description.toString();
	}

}
