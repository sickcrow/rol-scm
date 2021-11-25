/**
 * 
 */
package ar.com.agea.hub.rol.model.dto;


/**
 * @author Juan Martin Lichowski
 * 
 */

public class ValidateVigenciaDTO {

	private String codigoProductoComercial;
	private String codigoNivelEstructura;
	private String codigoProducto;

	/**
	 * Obtiene el objeto codigo producto comercial de este DTO.
	 * 
	 * @return Objeto codigo producto comercial de este DTO.
	 */
	public String getCodigoProductoComercial() {
		return codigoProductoComercial;
	}

	/**
	 * Setea el objeto codigo producto comercial de este DTO.
	 * 
	 * @param codigo Objeto codigo producto comercial de este DTO.
	 */
	public void setCodigoProductoComercial(String codigoProductoComercial) {
		this.codigoProductoComercial = codigoProductoComercial;
	}

	/**
	 * Obtiene el objeto codigo nivel estructura de este DTO.
	 * 
	 * @return Objeto codigo nivel estructura de este DTO.
	 */
	public String getCodigoNivelEstructura() {
		return codigoNivelEstructura;
	}

	/**
	 * Setea el objeto codigo nivel estructura de este DTO.
	 * 
	 * @param codigo Objeto codigo nivel estructura de este DTO.
	 */
	public void setCodigoNivelEstructura(String codigoNivelEstructura) {
		this.codigoNivelEstructura = codigoNivelEstructura;
	}

	/**
	 * Obtiene el objeto codigo producto de este DTO.
	 * 
	 * @return Objeto codigo producto de este DTO.
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * Setea el objeto codigo producto de este DTO.
	 * 
	 * @param codigo Objeto codigo producto de este DTO.
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	
	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();

		description.append("codigoProductoComercial: ").append(codigoProductoComercial);
		description.append(", codigoNivelEstructura: ").append(codigoNivelEstructura);
		description.append(", codigoProducto: ").append(codigoProducto);
		
		return description.toString();
	}	
}
