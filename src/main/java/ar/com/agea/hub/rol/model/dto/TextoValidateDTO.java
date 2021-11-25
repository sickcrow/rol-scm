/*
 * @(#)TextoValidateDTO.java		1.0 20/08/2013
 */

package ar.com.agea.hub.rol.model.dto;


/**
 * Representa un objeto Data Transfer Object para transferir datos de texto con palabras prohibidas a validar.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 20/08/2013
 */
public class TextoValidateDTO implements JSONDTO {
	
	private static final long serialVersionUID = 1662262305429365433L;
	
	private String codigoNivelEstructura;
	private String texto;

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
	 * Obtiene el objeto texto de este DTO.
	 * 
	 * @return Objeto texto de este DTO.
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * Setea el objeto texto de este DTO.
	 * 
	 * @param texto Objeto texto de este DTO.
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();

		description.append("codigoNivelEstructura: ").append(codigoNivelEstructura);
		description.append(", texto: ").append(texto);
		
		return description.toString();
	}
}
