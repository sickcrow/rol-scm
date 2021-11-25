/*
 * @(#)AgrupadorProductoZonasNivelesDTO.java	1.0 30/08/2013
 */

package ar.com.agea.hub.rol.model.dto;


/**
 * Representa un objeto Data Transfer Object para transferir datos agrupadores de producto comercial
 * y nivel de estructura.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación.
 * 
 * @author		Alejandro Di Fiore
 * @version		1.0 30/08/2013
 */
public class AgrupadorProductoComercialNivelDTO implements JSONDTO {

	private static final long serialVersionUID = -1272928540257149369L;
	
	private ProductoComercialDTO productoComercial;
	private NivelEstructuraDTO nivelEstructura;
		
	/**
	 * Obtiene el objeto producto comercial de este DTO. 
	 * 
	 * @return Objeto producto comercial de este DTO.
	 */
	public ProductoComercialDTO getProductoComercial() {
		return productoComercial;
	}

	/**
	 * Setea el objeto producto comercial de este DTO.
	 * 
	 * @param producto Objeto producto comercial de este DTO.
	 */
	public void setProductoComercial(ProductoComercialDTO productoComercial) {
		this.productoComercial = productoComercial;
	}

	/**
	 * Obtiene el objeto nivel estructura de este DTO. 
	 * 
	 * @return Objeto nivel estructura de este DTO.
	 */
	public NivelEstructuraDTO getNivelEstructura() {
		return nivelEstructura;
	}

	/**
	 * Setea el objeto nivel estructura de este DTO.
	 * 
	 * @param nivelEstructura Objeto nivel estructura de este DTO.
	 */
	public void setNivelEstructura(NivelEstructuraDTO nivelEstructura) {
		this.nivelEstructura = nivelEstructura;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("productoComercial: [").append(productoComercial).append("]");
		description.append(", nivelEstructura: [").append(nivelEstructura).append("]");
		
		return description.toString();
	}
}
