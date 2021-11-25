/*
 * @(#)ValidacionPromocionDTO.java		1.0 30/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

/**
 * @author 		Martin Lichowski.
 * @version		1.0 30/01/2014
 */
public class ValidacionPromocionDTO implements JSONDTO {

	private static final long serialVersionUID = 7924562567197444430L;
	
	private Long idProductoComercial;
    private Date fechaPublicacion;
    private Boolean valida;
    private String motivoInvalidez;

	/**
	 * Obtiene el objeto id producto comercial de este DTO.
	 * 
	 * @return Objeto id producto comercial de este DTO.
	 */
	public Long getIdProductoComercial() {
		return idProductoComercial;
	}

	/**
	 * Setea el objeto id producto comercial de este DTO.
	 * 
	 * @param codigo Objeto id producto comercial de este DTO.
	 */
	public void setIdProductoComercial(Long idProductoComercial) {
		this.idProductoComercial = idProductoComercial;
	}
	
	/**
	 * Obtiene el objeto fecha publicación de este DTO.
	 * 
	 * @return Objeto fecha publicación de este DTO.
	 */
	public Date getFechaPublicacion() {
		Date result = null;
		
		if (fechaPublicacion != null) {
			result = (Date) fechaPublicacion.clone();
		}
		
		return result;
	}
	
	/**
	 * Setea el objeto fecha publicación de este DTO.
	 * 
	 * @param codigo Objeto fecha publicación de este DTO.
	 */
	public void setFechaPublicacion(Date fechaPublicacion) {
		if (fechaPublicacion != null) {
			this.fechaPublicacion = new Date(fechaPublicacion.getTime());
		}
	}
	
	/**
	 * Obtiene el objeto válida de este DTO.
	 * 
	 * @return Objeto válida de este DTO.
	 */
	public Boolean getValida() {
		return valida;
	}
	
	/**
	 * Setea el objeto válida de este DTO.
	 * 
	 * @param codigo Objeto válida de este DTO.
	 */
	public void setValida(Boolean valida) {
		this.valida = valida;
	}
	
	/**
	 * Obtiene el objeto motivo invalidez de este DTO.
	 * 
	 * @return Objeto motivo invalidez de este DTO.
	 */
	public String getMotivoInvalidez() {
		return motivoInvalidez;
	}
	
	/**
	 * Setea el objeto motivo invalidez de este DTO.
	 * 
	 * @param codigo Objeto motivo invalidez de este DTO.
	 */
	public void setMotivoInvalidez(String motivoInvalidez) {
		this.motivoInvalidez = motivoInvalidez;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("idProductoComercial: ").append(idProductoComercial);
		description.append(", fechaPublicacion: ").append(fechaPublicacion);
		description.append(", valida: ").append(valida);
		description.append(", motivoInvalidez: ").append(motivoInvalidez);

		return description.toString();
	}
}
