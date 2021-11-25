/*
 * @(#)ConfiguracionPromocionPantallaDTO.java		1.0 31/01/2014
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * @author      Mauro Mosconi
 * @version		1.0 31/01/2014
 */
public class ConfiguracionPromocionPantallaDTO implements JSONDTO {

	private static final long serialVersionUID = -8402983150637241282L;

	private Integer pantallaShow;
	private PromocionDTO promocion;
	private String trigger;
	private String descripcion;
	private String titulo;
	
	private Long id;
	private Integer prioridad;

	/**
	 * Obtiene el objeto pantalla show de este DTO.
	 * 
	 * @return Objeto pantalla show de este DTO.
	 */
	public Integer getPantallaShow() {
		return pantallaShow;
	}

	/**
	 * Setea el objeto pantalla show de este DTO.
	 * 
	 * @param id Objeto pantalla show de este DTO.
	 */
	public void setPantallaShow(Integer pantallaShow) {
		this.pantallaShow = pantallaShow;
	}

	/**
	 * Obtiene el objeto promoción de este DTO.
	 * 
	 * @return Objeto promoción de este DTO.
	 */
	public PromocionDTO getPromocion() {
		return promocion;
	}

	/**
	 * Setea el objeto promoción de este DTO.
	 * 
	 * @param id Objeto promoción de este DTO.
	 */
	public void setPromocion(PromocionDTO promocion) {
		this.promocion = promocion;
	}

	/**
	 * Obtiene el objeto trigger de este DTO.
	 * 
	 * @return Objeto trigger de este DTO.
	 */
	public String getTrigger() {
		return trigger;
	}

	/**
	 * Setea el objeto trigger de este DTO.
	 * 
	 * @param id Objeto trigger de este DTO.
	 */
	public void setTrigger(String trigger) {
		this.trigger = trigger;
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
	 * @param id Objeto descripción de este DTO.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene el objeto título de este DTO.
	 * 
	 * @return Objeto título de este DTO.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Setea el objeto título de este DTO.
	 * 
	 * @param id Objeto título de este DTO.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Integer getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("pantallaShow: ").append(pantallaShow);
		description.append(", promocion: [").append(promocion).append("]");
		description.append(", trigger: ").append(trigger);
		description.append(", descripcion: ").append(descripcion);
		description.append(", titulo: ").append(titulo);
		
		return description.toString();
	}
}
