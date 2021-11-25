/*
 * @(#)ProductoComercialDefaultDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de productos comerciales default.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
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
	 * @param codigoTipoAviso Objeto código agrupamiento producto técnico de este DTO.
	 */
	public void setCodigoAgrupamientoProductoTecnico(String codigoAgrupamientoProductoTecnico) {
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
	 * Obtiene el objeto código producto comercial de este DTO.
	 * 
	 * @return Objeto código producto comercial de este DTO.
	 */
	public String getCodigoProductoComercial() {
		return codigoProductoComercial;
	}

	/**
	 * Setea el objeto código producto comercial de este DTO.
	 * 
	 * @param codigoProductoComercial Objeto código producto comercial de este DTO.
	 */
	public void setCodigoProductoComercial(String codigoProductoComercial) {
		this.codigoProductoComercial = codigoProductoComercial;
	}

	/**
	 * Obtiene el objeto código template de este DTO.
	 * 
	 * @return Objeto código template de este DTO.
	 */
	public String getCodigoTemplate() {
		return codigoTemplate;
	}

	/**
	 * Setea el objeto código template de este DTO.
	 * 
	 * @param codigoTemplate Objeto código template de este DTO.
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
