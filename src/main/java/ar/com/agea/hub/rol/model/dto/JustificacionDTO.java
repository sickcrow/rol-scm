/*
 * @(#)JustificacionDTO.java		1.0 22/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos de justificación.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Mariano De Nicolo
 * @version		1.0 22/07/2013
 */
public class JustificacionDTO implements JSONDTO {
	
	private static final long serialVersionUID = -7528424765317404065L;
	
	private String codigoProducto;
	private String codigoProductoComercial;
	private String codigoNivelEstructura;
	private String codigoTemplateDetallado;
	private List<OrdenamientoAvisoValorizadoDTO> ordenamientos;
	private String imagen;
	private Double cantidadLineas;
	private Integer cantidadLineasPublicadas;
	private String textoJustificado;
	private Float alturaEstandar;
	private Double puntosLibres;
	private String textoLibre;
	private String textoLibreJustificado;
	private String nombreImagen;
	private String nombreLibreriaImagen;
	private ImagenDTO material;

	/**
	 * Instancia un objeto de tipo JustificacionDTO.
	 */
	public JustificacionDTO() {
		ordenamientos = new ArrayList<OrdenamientoAvisoValorizadoDTO>();
	}
	
	/**
	 * Obtiene el objeto código producto de este DTO.
	 * 
	 * @return Objeto código producto de este DTO.
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * Setea el objeto código producto de este DTO.
	 * 
	 * @param codigoProducto Objeto código producto de este DTO.
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	/**
	 * Obtiene el objeto código producto comercial de este DTO.
	 * 
	 * @return Objeto código producto comercial de este DTO.
	 */
	public String getCodigoProductoComercial() {
		return codigoProductoComercial;
	}

	/**
	 * Setea el objeto código producto comercial de este DTO.
	 * 
	 * @param codigoProductoComercial Objeto código producto comercial de este DTO.
	 */
	public void setCodigoProductoComercial(String codigoProductoComercial) {
		this.codigoProductoComercial = codigoProductoComercial;
	}

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
	 * Obtiene el objeto código template detallado de este DTO.
	 * 
	 * @return Objeto código template detallado de este DTO.
	 */
	public String getCodigoTemplateDetallado() {
		return codigoTemplateDetallado;
	}

	/**
	 * Setea el objeto código template detallado de este DTO.
	 * 
	 * @param codigoTemplateDetallado Objeto código template detallado de este DTO.
	 */
	public void setCodigoTemplateDetallado(String codigoTemplateDetallado) {
		this.codigoTemplateDetallado = codigoTemplateDetallado;
	}

	/**
	 * Obtiene los objetos ordenamientos de este DTO.
	 * 
	 * @return Objetos ordenamientos de este DTO.
	 */
	public List<OrdenamientoAvisoValorizadoDTO> getOrdenamientos() {
		return ordenamientos;
	}

	/**
	 * Setea los objetos ordenamientos de este DTO.
	 * 
	 * @param ordenamientos Objetos ordenamientos de este DTO.
	 */
	public void setOrdenamientos(List<OrdenamientoAvisoValorizadoDTO> ordenamientos) {
		this.ordenamientos = ordenamientos;
	}

	/**
	 * Obtiene el objeto imagen de este DTO.
	 * 
	 * @return Objeto imagen de este DTO.
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Setea el objeto imagen de este DTO.
	 * 
	 * @param imagen Objeto código imagen de este DTO.
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el objeto cantidad líneas de este DTO.
	 * 
	 * @return Objeto cantidad líneas de este DTO.
	 */
	public Double getCantidadLineas() {
		return cantidadLineas;
	}

	/**
	 * Setea el objeto cantidad líneas de este DTO.
	 * 
	 * @param cantidadLineas Objeto cantidad líneas de este DTO.
	 */
	public void setCantidadLineas(Double cantidadLineas) {
		this.cantidadLineas = cantidadLineas;
	}
	
	/**
	 * Obtiene el objeto cantidad líneas publicadas de este DTO.
	 * 
	 * @return Objeto cantidad líneas publicadas de este DTO.
	 */
	public Integer getCantidadLineasPublicadas() {
		return cantidadLineasPublicadas;
	}

	/**
	 * Setea el objeto cantidad líneas publicadasde este DTO.
	 * 
	 * @param cantidadLineasPublicadas Objeto cantidad líneas publicadas de este DTO.
	 */
	public void setCantidadLineasPublicadas(Integer cantidadLineasPublicadas) {
		this.cantidadLineasPublicadas = cantidadLineasPublicadas;
	}

	/**
	 * Obtiene el objeto texto justificado de este DTO.
	 * 
	 * @return Objeto texto justificado de este DTO.
	 */
	public String getTextoJustificado() {
		return textoJustificado;
	}

	/**
	 * Setea el objeto texto justificado de este DTO.
	 * 
	 * @param textoJustificado Objeto texto justificado de este DTO.
	 */
	public void setTextoJustificado(String textoJustificado) {
		this.textoJustificado = textoJustificado;
	}

	/**
	 * Obtiene el objeto altura estandar de este DTO.
	 * 
	 * @return Objeto altura estandar de este DTO.
	 */
	public Float getAlturaEstandar() {
		return alturaEstandar;
	}

	/**
	 * Setea el objeto altura estandar de este DTO.
	 * 
	 * @param alturaEstandar Objeto altura estandar de este DTO.
	 */
	public void setAlturaEstandar(Float alturaEstandar) {
		this.alturaEstandar = alturaEstandar;
	}

	/**
	 * Obtiene el objeto puntos libres de este DTO.
	 * 
	 * @return Objeto puntos libres de este DTO.
	 */
	public Double getPuntosLibres() {
		return puntosLibres;
	}

	/**
	 * Setea el objeto puntos libres de este DTO.
	 * 
	 * @param puntosLibres Objeto puntos libres de este DTO.
	 */
	public void setPuntosLibres(Double puntosLibres) {
		this.puntosLibres = puntosLibres;
	}

	/**
	 * Obtiene el objeto texto libre de este DTO.
	 * 
	 * @return Objeto texto libre de este DTO.
	 */
	public String getTextoLibre() {
		return textoLibre;
	}

	/**
	 * Setea el objeto texto libre de este DTO.
	 * 
	 * @param textoLibre Objeto texto libre de este DTO.
	 */
	public void setTextoLibre(String textoLibre) {
		this.textoLibre = textoLibre;
	}

	/**
	 * Obtiene el objeto texto libre justificado de este DTO.
	 * 
	 * @return Objeto texto libre justificado de este DTO.
	 */
	public String getTextoLibreJustificado() {
		return textoLibreJustificado;
	}

	/**
	 * Setea el objeto texto libre justificado de este DTO.
	 * 
	 * @param textoLibreJustificado Objeto texto libre justificado de este DTO.
	 */
	public void setTextoLibreJustificado(String textoLibreJustificado) {
		this.textoLibreJustificado = textoLibreJustificado;
	}

	/**
	 * Obtiene el objeto nombre de imagen de este DTO.
	 * 
	 * @return Objeto texto nombre imagen de este DTO.
	 */
	public String getNombreImagen() {
		return nombreImagen;
	}

	/**
	 * Setea el objeto nombre de imagen de este DTO.
	 * 
	 * @param nombreImagen Objeto nombre imagen de este DTO.
	 */
	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	/**
	 * Obtiene el objeto nombre de libreria de imagen de este DTO.
	 * 
	 * @return Objeto nombre libreria imagen de este DTO.
	 */
	public String getNombreLibreriaImagen() {
		return nombreLibreriaImagen;
	}

	/**
	 * Setea el objeto nombre de repositorio de imagen de este DTO.
	 * 
	 * @param nombreLibreriaImagen Objeto nombre repositorio imagen de este DTO.
	 */
	public void setNombreLibreriaImagen(String nombreLibreriaImagen) {
		this.nombreLibreriaImagen = nombreLibreriaImagen;
	}
	
	/**
	 * Obtiene el objeto contenido material de este DTO.
	 * 
	 * @return Objeto contenido material de este DTO.
	 */
	public ImagenDTO getMaterial() {
		return material;
	}

	/**
	 * Setea el objeto contenido material de este DTO.
	 * 
	 * @param extension Objeto contenido material de este DTO.
	 */
	public void setMaterial(ImagenDTO material) {
		this.material = material;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoProducto: ").append(codigoProducto);
		description.append(", codigoProductoComercial: ").append(codigoProductoComercial);
		description.append(", codigoNivelEstructura: ").append(codigoNivelEstructura);
		description.append(", codigoTemplateDetallado: ").append(codigoTemplateDetallado);
		description.append(", ordenamientos: [").append(toString(ordenamientos)).append("]");
		description.append(", imagen: ").append(imagen);
		description.append(", cantidadLineas: ").append(cantidadLineas);
		description.append(", cantidadLineasPublicadas: ").append(cantidadLineasPublicadas);
		description.append(", textoJustificado: ").append(textoJustificado);
		description.append(", alturaEstandar: ").append(alturaEstandar);
		description.append(", puntosLibres: ").append(puntosLibres);
		description.append(", textoLibre: ").append(textoLibre);
		description.append(", textoLibreJustificado: ").append(textoLibreJustificado);
		description.append(", nombreImagen: ").append(nombreImagen);
		description.append(", nombreLibreriaImagen: ").append(nombreLibreriaImagen);
		description.append(", material: [").append(toString(ordenamientos)).append("]");
		
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
