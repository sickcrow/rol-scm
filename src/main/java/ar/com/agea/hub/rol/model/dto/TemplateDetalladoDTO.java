/*
 * @(#)TemplateDetalladoDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos de templates detallados.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class TemplateDetalladoDTO implements JSONDTO {

	private static final long serialVersionUID = -3806535474686809346L;
	
	private Long id;
	private String codigo;
	private String descripcion;
	private Boolean tieneImagenesPrediseniadas;
	private Boolean tieneColor; 
	private Boolean tieneMaterial;
	private String ayuda;
	private Integer orden;
	private List<String> extensionesMaterial;
	private Integer pesoMaterial;
	private Integer ancho;
	private Integer alto;
	
	/**
	 * Instancia un objeto de tipo TemplateDetalladoDTO.
	 */
	public TemplateDetalladoDTO() {
		extensionesMaterial = new ArrayList<String>();
	}
	
	/**
	 *  Obtiene el objeto id de este DTO. 
	 * 
	 * @return Objeto id de este DTO.
	 */
	public Long getId() {
		return id;
	}

	/**
	 *  Setea el objeto id de este DTO.
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
	 * @param codigo Objeto descripción de este DTO.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene el objeto tiene imagenes prediseniadas de este DTO. 
	 * 
	 * @return Objeto tiene imagenes prediseniadas de este DTO.
	 */
	public Boolean getTieneImagenesPrediseniadas() {
		return tieneImagenesPrediseniadas;
	}

	/**
	 * Setea el objeto tiene imagenes prediseniadas de este DTO.
	 * 
	 * @param codigo Objeto tiene imagenes prediseniadas de este DTO.
	 */
	public void setTieneImagenesPrediseniadas(Boolean tieneImagenesPrediseniadas) {
		this.tieneImagenesPrediseniadas = tieneImagenesPrediseniadas;
	}

	/**
	 * Obtiene el objeto tiene color de este DTO. 
	 * 
	 * @return Objeto tiene color de este DTO.
	 */
	public Boolean getTieneColor() {
		return tieneColor;
	}

	/**
	 * Setea el objeto tiene color de este DTO.
	 * 
	 * @param codigo Objeto tiene color de este DTO.
	 */
	public void setTieneColor(Boolean tieneColor) {
		this.tieneColor = tieneColor;
	}

	/**
	 * Obtiene el objeto tiene material de este DTO. 
	 * 
	 * @return Objeto tiene material de este DTO.
	 */
	public Boolean getTieneMaterial() {
		return tieneMaterial;
	}

	/**
	 * Setea el objeto tiene material de este DTO.
	 * 
	 * @param codigo Objeto tiene material de este DTO.
	 */
	public void setTieneMaterial(Boolean tieneMaterial) {
		this.tieneMaterial = tieneMaterial;
	}
	
	/**
	 * Obtiene el objeto ayuda de este DTO. 
	 * 
	 * @return Objeto ayuda de este DTO.
	 */
	public String getAyuda() {
		return ayuda;
	}

	/**
	 * Setea el objeto ayuda de este DTO.
	 * 
	 * @param codigo Objeto ayuda de este DTO.
	 */
	public void setAyuda(String ayuda) {
		this.ayuda = ayuda;
	}

	/**
	 * Obtiene el objeto orden de este DTO. 
	 * 
	 * @return Objeto orden de este DTO.
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * Setea el objeto orden de este DTO.
	 * 
	 * @param codigo Objeto orden de este DTO.
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/**
	 * Obtiene el objeto extensiones material de este DTO. 
	 * 
	 * @return Objeto extensiones material de este DTO.
	 */
	public List<String> getExtensionesMaterial() {
		return extensionesMaterial;
	}

	/**
	 * Setea el objeto extensiones material de este DTO.
	 * 
	 * @param codigo Objeto extensiones material de este DTO.
	 */
	public void setExtensionesMaterial(List<String> extensionesMaterial) {
		this.extensionesMaterial = extensionesMaterial;
	}

	/**
	 * Obtiene el objeto peso material de este DTO. 
	 * 
	 * @return Objeto peso material de este DTO.
	 */
	public Integer getPesoMaterial() {
		return pesoMaterial;
	}

	/**
	 * Setea el objeto peso material de este DTO.
	 * 
	 * @param codigo Objeto peso material de este DTO.
	 */
	public void setPesoMaterial(Integer pesoMaterial) {
		this.pesoMaterial = pesoMaterial;
	}

	/**
	 * Obtiene el objeto ancho de este DTO. 
	 * 
	 * @return Objeto ancho de este DTO.
	 */
	public Integer getAncho() {
		return ancho;
	}

	/**
	 * Setea el objeto ancho de este DTO.
	 * 
	 * @param codigo Objeto ancho de este DTO.
	 */
	public void setAncho(Integer ancho) {
		this.ancho = ancho;
	}

	/**
	 * Obtiene el objeto alto de este DTO. 
	 * 
	 * @return Objeto alto de este DTO.
	 */
	public Integer getAlto() {
		return alto;
	}

	/**
	 * Setea el objeto alto de este DTO.
	 * 
	 * @param codigo Objeto alto de este DTO.
	 */
	public void setAlto(Integer alto) {
		this.alto = alto;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigo: ").append(codigo);
		description.append(", descripcion: ").append(descripcion);
		description.append(", tieneImagenesPrediseniadas: ").append(tieneImagenesPrediseniadas);
		description.append(", tieneColor: ").append(tieneColor);
		description.append(", tieneMaterial: ").append(tieneMaterial);
		description.append(", ayuda: ").append(ayuda);
		description.append(", orden: ").append(orden);
		description.append(", extensionesMaterial: [").append(toString(extensionesMaterial)).append("]");
		description.append(", pesoMaterial: ").append(pesoMaterial);
		description.append(", ancho: ").append(ancho);
		description.append(", alto: ").append(alto);
		
		return description.toString();
	}
	
	private String toString(List<?> collection) {
		StringBuilder description = new StringBuilder();
		
		Iterator<?> iterator = collection.iterator();
		
		while (iterator.hasNext()) {
			description.append(iterator.next());
			
			if (iterator.hasNext()) {
				description.append(", ");
			}
		}
		
		return description.toString();
	}
}