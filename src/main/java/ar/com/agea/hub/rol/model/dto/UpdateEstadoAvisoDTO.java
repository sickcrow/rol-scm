/*
 * @(#)UpdateEstadoAvisoDTO.java		1.0 27/05/2014
 */

package ar.com.agea.hub.rol.model.dto;


/**
 * Representa un objeto Data Transfer Object para transferir datos de avisos.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 27/05/2014
 */
public class UpdateEstadoAvisoDTO implements JSONDTO {
	
	private static final long serialVersionUID = -1092364405895012961L;
	
	private Long idAviso;
	private String accion;
	private String motivoRechazo;
	private String observacion;

	/**
	 * Obtiene el objeto id aviso de este DTO.
	 * 
	 * @return Objeto id aviso de este DTO.
	 */
	public Long getIdAviso() {
		return idAviso;
	}

	/**
	 * Setea el objeto id aviso de este DTO.
	 * 
	 * @param id Objeto id aviso de este DTO.
	 */
	public void setIdAviso(Long idAviso) {
		this.idAviso = idAviso;
	}

	/**
	 * Obtiene el objeto acción de este DTO.
	 * 
	 * @return Objeto acción de este DTO.
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * Setea el objeto acción de este DTO.
	 * 
	 * @param id Objeto acción de este DTO.
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}

	/**
	 * Obtiene el objeto motivo rechazo de este DTO.
	 * 
	 * @return Objeto motivo rechazo de este DTO.
	 */
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	/**
	 * Setea el objeto motivo rechazo de este DTO.
	 * 
	 * @param id Objeto motivo rechazo de este DTO.
	 */
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	/**
	 * Obtiene el objeto observación de este DTO.
	 * 
	 * @return Objeto observación de este DTO.
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * Setea el objeto observación de este DTO.
	 * 
	 * @param id Objeto observación de este DTO.
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("idAviso: ").append(idAviso);
		description.append(", accion: ").append(accion);
		description.append(", motivoRechazo: ").append(motivoRechazo);
		description.append(", observacion: ").append(observacion);
		
		return description.toString();
	}
}
