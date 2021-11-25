/*
 * @(#)ClaseDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de clases.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ClaseDTO implements JSONDTO {
	
	private static final long serialVersionUID = -6631440930483011403L;
	
	private Long id;
	private String codigo;
	private String descripcion;
	private Boolean editable;
	private Boolean transaccionable;

	
	/**
	 * Obtiene el objeto id de este DTO. 
	 * 
	 * @return Objeto id de este DTO.
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Setea el objeto id de este DTO.
	 * 
	 * @param codigo Objeto id de este DTO.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
	/**
	 * Obtiene el objeto código de este DTO. 
	 * 
	 * @return Objeto código de este DTO.
	 */
	public String getCodigo() {
		return codigo;
	}
	
	/**
	 * Setea el objeto código de este DTO.
	 * 
	 * @param codigo Objeto código de este DTO.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Obtiene el objeto descripción de este DTO. 
	 * 
	 * @return Objeto descripción de este DTO.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Setea el objeto descripción de este DTO.
	 * 
	 * @param descripcion Objeto descripción de este DTO.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	/**
	 * Obtiene el objeto id de este DTO. 
	 * 
	 * @return Objeto id de este DTO.
	 */
	public Boolean getTransaccionable() {
		return transaccionable;
	}
	
	/**
	 * Setea el objeto id de este DTO.
	 * 
	 * @param codigo Objeto id de este DTO.
	 */
	public void setTransaccionable(Boolean transaccionable) {
		this.transaccionable = transaccionable;
	}
	
	
	
	/**
	 * Obtiene el objeto id de este DTO. 
	 * 
	 * @return Objeto id de este DTO.
	 */
	public Boolean getEditable() {
		return editable;
	}
	
	/**
	 * Setea el objeto id de este DTO.
	 * 
	 * @param codigo Objeto id de este DTO.
	 */
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	
	
	

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigo: ").append(codigo);
		description.append(", descripcion: ").append(descripcion);
		
		return description.toString();
	}
}
