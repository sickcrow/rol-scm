/*
 * @(#)AccionSecuenciaDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de acciones de secuencias.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicaci�n y los
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
	 * Obtiene el objeto acci�n de este DTO. 
	 * 
	 * @return Objeto acci�n de este DTO.
	 */
	public String getAccion() {
		return accion;
	}
	
	/**
	 * Setea el objeto acci�n de este DTO.
	 * 
	 * @param accion Objeto acci�n de este DTO.
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}
	
	/**
	 * Obtiene el objeto n�mero de este DTO. 
	 * 
	 * @return Objeto n�mero de este DTO.
	 */
	public Long getNumero() {
		return numero;
	}
	
	/**
	 * Setea el objeto n�mero de este DTO.
	 * 
	 * @param numero Objeto n�mero de este DTO.
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
