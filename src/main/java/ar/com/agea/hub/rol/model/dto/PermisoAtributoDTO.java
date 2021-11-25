package ar.com.agea.hub.rol.model.dto;

public class PermisoAtributoDTO implements JSONDTO {
	
	private static final long serialVersionUID = 7866660581402236104L;
	
	private Boolean obligatorio;
	private Boolean publicable;
	
	/**
	 * Obtiene el valor del atributo obligatorio de este DTO.
	 * 
	 * @return El valor del atributo obligatorio de este DTO.
	 */
	public Boolean getObligatorio() {
		return obligatorio;
	}
	
	/**
	 * Setea el valor del atributo obligatorio de este DTO.
	 * 
	 * @param obligatorio El valor del atributo obligatorio de este DTO.
	 */
	public void setObligatorio(Boolean obligatorio) {
		this.obligatorio = obligatorio;
	}
	
	/**
	 * Obtiene el valor del atributo publicable de este DTO.
	 * 
	 * @return El valor del atributo publicable de este DTO.
	 */
	public Boolean getPublicable() {
		return publicable;
	}
	
	/**
	 * Setea el valor del atributo publicable de este DTO.
	 * 
	 * @param publicable El valor del atributo publicable de este DTO.
	 */
	public void setPublicable(Boolean publicable) {
		this.publicable = publicable;
	}
	
}
