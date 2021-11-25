/*
 * @(#)ProductoComercialDefaultDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de productos comerciales default.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicaci�n y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ProductoComercialDefaultDTO implements JSONDTO {

	private static final long serialVersionUID = -6220798125032000176L;
	
	private String codigoCanalEntrada;
	private String codigoAgrupamientoProductoTecnico;
	private String codigoTipoOperacion;
	private String codigoNivelEstructura;
	private String codigoProductoComercial;
	private String codigoTemplate;

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
	 * @param codigoTipoAviso Objeto c�digo agrupamiento producto t�cnico de este DTO.
	 */
	public void setCodigoAgrupamientoProductoTecnico(String codigoAgrupamientoProductoTecnico) {
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
	 * Obtiene el objeto c�digo producto comercial de este DTO.
	 * 
	 * @return Objeto c�digo producto comercial de este DTO.
	 */
	public String getCodigoProductoComercial() {
		return codigoProductoComercial;
	}

	/**
	 * Setea el objeto c�digo producto comercial de este DTO.
	 * 
	 * @param codigoProductoComercial Objeto c�digo producto comercial de este DTO.
	 */
	public void setCodigoProductoComercial(String codigoProductoComercial) {
		this.codigoProductoComercial = codigoProductoComercial;
	}

	/**
	 * Obtiene el objeto c�digo template de este DTO.
	 * 
	 * @return Objeto c�digo template de este DTO.
	 */
	public String getCodigoTemplate() {
		return codigoTemplate;
	}

	/**
	 * Setea el objeto c�digo template de este DTO.
	 * 
	 * @param codigoTemplate Objeto c�digo template de este DTO.
	 */
	public void setCodigoTemplate(String codigoTemplate) {
		this.codigoTemplate = codigoTemplate;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoCanalEntrada: ").append(codigoCanalEntrada);
		description.append(", codigoAgrupamientoProductoTecnico: ").append(codigoAgrupamientoProductoTecnico);
		description.append(", codigoTipoOperacion: ").append(codigoTipoOperacion);
		description.append(", codigoNivelEstructura: ").append(codigoNivelEstructura);
		description.append(", codigoProductoComercial: ").append(codigoProductoComercial);
		description.append(", codigoTemplate: ").append(codigoTemplate);
		
		return description.toString();
	}
}
