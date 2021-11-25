/*
 * @(#)ProductoTecnicoDTO.java		1.0 03/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de productos técnicos.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 03/09/2013
 */
public class ProductoTecnicoDTO implements JSONDTO {
	
	private static final long serialVersionUID = -7508985883410603071L;

	/**
	 * Identifica el tipo de este DTO.
	 * 
	 * @author      Eduardo Barrera
	 * @version		1.0 03/09/2013
	 */
	public static enum Tipo {PAPEL, WEB;};
	
	private Tipo tipo;
	private String codigo;
	private String descripcion;

	private Long id;
	private Boolean bienRequerido;
	private Boolean templateAsignado;
	private Object agrupamiento;
	private Object medicion;
	
	/**
	 * Obtiene el objeto tipo de este DTO.
	 * 
	 * @return Objeto tipo de este DTO.
	 */
	public Tipo getTipo() {
		return tipo;
	}
	
	/**
	 * Setea el objeto tipo de este DTO.
	 * 
	 * @param codigo Objeto tipo de este DTO.
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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

	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Boolean getBienRequerido() {
		return bienRequerido;
	}

	public void setBienRequerido(Boolean bienRequerido) {
		this.bienRequerido = bienRequerido;
	}
	
	

	public Boolean getTemplateAsignado() {
		return templateAsignado;
	}

	public void setTemplateAsignado(Boolean templateAsignado) {
		this.templateAsignado = templateAsignado;
	}
	
	

	public Object getAgrupamiento() {
		return agrupamiento;
	}

	public void setAgrupamiento(Object agrupamiento) {
		this.agrupamiento = agrupamiento;
	}
	
	

	public Object getMedicion() {
		return medicion;
	}

	public void setMedicion(Object medicion) {
		this.medicion = medicion;
	}

	
	
	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("tipo: [").append(tipo).append("]");
		description.append(", codigo: ").append(codigo);
		description.append(", descripcion: ").append(descripcion);
		
		return description.toString();
	}
}
