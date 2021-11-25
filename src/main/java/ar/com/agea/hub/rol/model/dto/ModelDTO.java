/*
 * @(#)ModelDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;


/**
 * Representa un objeto Data Transfer Object para transferir datos de modelo.
 * <p>
 * Todos las clases que representen Model Data Transfer Object deben implementar esta interfaz.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación. 
 * 
 * @author		Alejandro Di Fiore
 * @version		1.0 15/10/2013
 */
public abstract class ModelDTO implements JSONDTO {

	private static final long serialVersionUID = 4860578784991067014L;

	private String redirectURL;

	/**
	 * Obtiene el objeto redirect URL de este DTO.
	 * 
	 * @return Objeto redirect URL de este DTO.
	 */
	public String getRedirectURL() {
		return redirectURL;
	}

	/**
	 * Setea el objeto redirect URL de este DTO.
	 * 
	 * @param redirectURL Objeto redirect URL de este DTO.
	 */
	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("redirectURL: ").append(redirectURL);
		
		return description.toString();
	}
}
