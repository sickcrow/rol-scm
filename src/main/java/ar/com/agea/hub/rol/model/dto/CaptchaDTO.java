/*
 * @(#)CaptchaDTO.java		1.0 24/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de captchas.
 * <p>
 * Estos objetos son utilizados por front-end y la capa middleware de la aplicación.
 * 
 * @author		Mauro Mosconi
 * @author		Eduardo Barrera
 * @version		1.0 24/09/2013
 */
public class CaptchaDTO implements JSONDTO {
	
	private static final long serialVersionUID = -1692053176740561407L;

	private String hashValue;
	private String inputValue;

	/**
	 * Obtiene el objeto hash value de este DTO. 
	 * 
	 * @return Objeto hash value de este DTO.
	 */
	public String getHashValue() {
		return hashValue;
	}

	/**
	 * Setea el objeto hash value de este DTO.
	 * 
	 * @param hashValue Objeto hash value de este DTO.
	 */
	public void setHashValue(String hashValue) {
		this.hashValue = hashValue;
	}

	/**
	 * Obtiene el objeto input value de este DTO. 
	 * 
	 * @return Objeto input value de este DTO.
	 */
	public String getInputValue() {
		return inputValue;
	}

	/**
	 * Setea el objeto input value de este DTO.
	 * 
	 * @param inputValue Objeto input value de este DTO.
	 */
	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("hashValue: ").append(hashValue);
		description.append(", inputValue: ").append(inputValue);
		
		return description.toString();
	}
}
