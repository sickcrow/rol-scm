/*
 * @(#)AgrupadorAtributoAvisoDTO.java	1.0 18/02/2014
 */
package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos agrupadores de atributo aviso.
 * Contiene el atributoAviso y el paso en el cual se debe enviar para tasar.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación.
 * 
 * @author		Alejandro Di Fiore
 * @version		1.0 18/02/2014
 */
public class AgrupadorAtributoAvisoDTO implements JSONDTO {
	
	private static final long serialVersionUID = -1500021646713297155L;

	private AtributoAvisoDTO atributoAviso;
	private Long step;
	
	/**
	 * Obtiene el objeto atributo aviso de este DTO. 
	 * 
	 * @return Objeto atributo aviso de este DTO.
	 */
	public AtributoAvisoDTO getAtributoAviso() {
		return atributoAviso;
	}
	
	/**
	 * Setea el objeto atributo aviso de este DTO.
	 * 
	 * @param producto Objeto atributo aviso de este DTO.
	 */
	public void setAtributoAviso(AtributoAvisoDTO atributoAviso) {
		this.atributoAviso = atributoAviso;
	}
	
	/**
	 * Obtiene el objeto step de este DTO. 
	 * 
	 * @return Objeto step de este DTO.
	 */
	public Long getStep() {
		return step;
	}
	
	/**
	 * Setea el objeto step de este DTO.
	 * 
	 * @param producto Objeto step de este DTO.
	 */
	public void setStep(Long step) {
		this.step = step;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("atributoAviso: [").append(atributoAviso).append("]");
		description.append(", step: ").append(step);
		
		return description.toString();
	}
}
