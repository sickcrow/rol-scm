/*
 * @(#)AccionSecuenciaDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de acciones de secuencias.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class AccionSecuenciaDTO implements JSONDTO {

	private static final long serialVersionUID = -3882678178394670079L;
	
	private Long numero;
	private String accion;

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
	 * @param accion Objeto acción de este DTO.
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}
	
	/**
	 * Obtiene el objeto número de este DTO. 
	 * 
	 * @return Objeto número de este DTO.
	 */
	public Long getNumero() {
		return numero;
	}
	
	/**
	 * Setea el objeto número de este DTO.
	 * 
	 * @param numero Objeto número de este DTO.
	 */
	public void setNumero(Long numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("numero: ").append(numero);
		description.append(", accion: ").append(accion);
		
		return description.toString();
	}
}
