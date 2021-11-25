/*
 * @(#)TemplatePrecargaDTO.java		1.0 08/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

/**
 * Representa un objeto Data Transfer Object para transferir datos del template para precarga.
 * <p>
 * Estos objetos son utilizados por front-end y la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Alejandro Di Fiore
 * @version		1.0 08/01/2014
 */
public class TemplatePrecargaDTO implements JSONDTO {
	
	private static final long serialVersionUID = -5223638547160677150L;
	
	private Long id;
	private String codigo;
	private String nombre;
	private String descripcion;
	private String template;
	private Date fechaCaducidad;
	
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
	 * @param uuid Objeto id de este DTO.
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
	 * @param uuid Objeto código de este DTO.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Obtiene el objeto nombre de este DTO.
	 * 
	 * @return Objeto nombre de este DTO.
	 */	
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Setea el objeto nombre de este DTO.
	 * 
	 * @param uuid Objeto nombre de este DTO.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @param uuid Objeto descripción de este DTO.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Obtiene el objeto template de este DTO.
	 * 
	 * @return Objeto template de este DTO.
	 */	
	public String getTemplate() {
		return template;
	}
	
	/**
	 * Setea el objeto template de este DTO.
	 * 
	 * @param uuid Objeto template de este DTO.
	 */
	public void setTemplate(String template) {
		this.template = template;
	}
	
	/**
	 * Obtiene el objeto fecha caducidad de este DTO.
	 * 
	 * @return Objeto fecha caducidad de este DTO.
	 */	
	public Date getFechaCaducidad() {
		Date result = null;
		
		if (fechaCaducidad != null) {
			result = (Date) fechaCaducidad.clone();
		}
		
		return result;
	}
	
	/**
	 * Setea el objeto fecha caducidad de este DTO.
	 * 
	 * @param uuid Objeto fecha caducidad de este DTO.
	 */
	public void setFechaCaducidad(Date fechaCaducidad) {
		if (fechaCaducidad != null) {
			this.fechaCaducidad = new Date(fechaCaducidad.getTime());
		}
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("id: ").append(id);
		description.append(", codigo: ").append(codigo);
		description.append(", nombre: ").append(nombre);
		description.append(", descripcion: ").append(descripcion);
		description.append(", template: ").append(template);
		description.append(", fechaCaducidad: ").append(fechaCaducidad);
		
		return description.toString();
	}
}
