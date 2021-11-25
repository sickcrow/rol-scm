/*
 * @(#)PrimitiveDTO.java		1.0 31/07/2014
 */

package ar.com.agea.hub.rol.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ar.com.agea.hub.rol.utils.PrimitiveSerializer;

/**
 * Representa un objeto Data Transfer Object para transferir datos de tipo String, Date y wrappers, .
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Juan Martín Lichowski
 * @author		Eduardo Barrera
 * @version		1.0 31/07/2014
 */
@JsonSerialize(using = PrimitiveSerializer.class)
public class PrimitiveDTO<T> implements JSONDTO {

	private static final long serialVersionUID = 4662613345297818427L;

	private String fieldName;
	private T value;

	/**
	 * Instancia un objeto de tipo PrimitiveDTO a partir de parámetros.
	 */
	public PrimitiveDTO(String fieldName, T primitivo) {
		this.value = primitivo;
		this.fieldName = fieldName;
	}

	/**
	 * Obtiene el objeto field name de este DTO. 
	 * 
	 * @return Objeto field name de este DTO.
	 */
	public String getFieldName() {
		return fieldName;
	}
	
	/**
	 * Setea el objeto field name de este DTO.
	 * 
	 * @param fieldName Objeto field name de este DTO.
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * Obtiene el objeto value de este DTO. 
	 * 
	 * @return Objeto value este DTO.
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Setea el objeto value de este DTO.
	 * 
	 * @param value Objeto value de este DTO.
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();

		description.append("fieldName: ").append(fieldName);
		description.append(", value: ").append(value);
		
		return description.toString();
	}
}
