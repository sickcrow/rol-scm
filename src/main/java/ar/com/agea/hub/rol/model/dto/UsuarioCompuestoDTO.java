/*
 * @(#)UsuarioCompuestoDTO.java		1.0 22/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de usuarios PASE y HUB.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios PASE.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 24/09/2013
 */
public class UsuarioCompuestoDTO implements JSONDTO {

	private static final long serialVersionUID = 8539536406830006676L;

	private PASEUsuarioDTO paseUsuario;
	private CapturadorDTO capturador;


	/**
	 * Obtiene el objeto PASE usuario de este DTO.
	 * 
	 * @return Objeto PASE usuario de este DTO.
	 */
	public PASEUsuarioDTO getPASEUsuario() {
		return paseUsuario;
	}

	/**
	 * Setea el objeto PASE usuario de este DTO.
	 * 
	 * @param paseUsuario Objeto PASE usuario de este DTO.
	 */
	public void setPASEUsuario(PASEUsuarioDTO paseUsuario) {
		this.paseUsuario = paseUsuario;
	}

	/**
	 * Obtiene el objeto capturador de este DTO.
	 * 
	 * @return Objeto capturador de este DTO.
	 */
	public CapturadorDTO getCapturador() {
		return capturador;
	}

	/**
	 * Setea el objeto capturador de este DTO.
	 * 
	 * @param capturador Objeto capturador de este DTO.
	 */
	public void setCapturador(CapturadorDTO capturador) {
		this.capturador = capturador;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();

		description.append("paseUsuario: [").append(paseUsuario).append("]");
		description.append(", capturador: [").append(capturador).append("]");
		
		return description.toString();
	}
}
