/*
 * @(#)ProductoComercialTemplateDTO.java		1.0 30/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa el resultado de servicios HUB que retornan un objeto ProductoComercialTemplateDTO.
 * 
 * @author 		Martin Lichowski
 * @version		1.0 30/01/2014
 */
public class ProductoComercialTemplateDTO implements JSONDTO {

	private static final long serialVersionUID = -2048285725910173939L;
	
	private TemplateDetalladoDTO templateDetallado;
	private String codigoProductoComercial;

	/**
	 * Obtiene el objeto template detallado de este DTO. 
	 * 
	 * @return Objeto template detallado de este DTO.
	 */
	public TemplateDetalladoDTO getTemplateDetallado() {
		return templateDetallado;
	}

	/**
	 * Setea el objeto template detallado de este DTO.
	 * 
	 * @param codigo Objeto template detallado de este DTO.
	 */
	public void setTemplateDetallado(TemplateDetalladoDTO templateDetallado) {
		this.templateDetallado = templateDetallado;
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
	 * @param codigo Objeto código producto comercial de este DTO.
	 */
	public void setCodigoProductoComercial(String codigoProductoComercial) {
		this.codigoProductoComercial = codigoProductoComercial;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("templateDetallado: [").append(templateDetallado).append("]");
		description.append(", codigoProductoComercial: ").append(codigoProductoComercial);
		
		return description.toString();
	}
}
