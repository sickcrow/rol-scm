/*
 * @(#)ImagenDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;


/**
 * Representa un objeto Data Transfer Object para transferir datos de imagenes.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ImagenDTO implements JSONDTO {
	
	private static final long serialVersionUID = -8255210109291269475L;

	/**
	 * Identifica el tipo de este DTO.
	 * 
	 * @author      Eduardo Barrera
	 * @version		1.0 06/06/2013
	 */
	public static enum Tipo {IMAGEN, PDF;};
	
	private Long id;
	private Tipo tipo;
	private String codigo;
	private String contenido;
	private String pathImagen;
	private String pathThumbnail;
	private Integer altura;
	private Integer ancho;
	private Long tamanio;
	private String repo;
	private String extension;
	
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
	 * @param id Objeto id de este DTO.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
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
	 * Obtiene el objeto contenido de este DTO.
	 * 
	 * @return Objeto contenido de este DTO.
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * Setea el objeto contenido de este DTO.
	 * 
	 * @param contenido Objeto contenido de este DTO.
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * Obtiene el objeto path imagen de este DTO.
	 * 
	 * @return Objeto path imagen de este DTO.
	 */
	public String getPathImagen() {
		return pathImagen;
	}
	
	/**
	 * Setea el objeto path imagen de este DTO.
	 * 
	 * @param pathImagen Objeto path imagen de este DTO.
	 */
	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}

	/**
	 * Obtiene el objeto path thumbnail de este DTO.
	 * 
	 * @return Objeto thumbnail de este DTO.
	 */
	public String getPathThumbnail() {
		return pathThumbnail;
	}

	/**
	 * Setea el objeto path thumbnail de este DTO.
	 * 
	 * @param pathThumbnail Objeto path thumbnail de este DTO.
	 */
	public void setPathThumbnail(String pathThumbnail) {
		this.pathThumbnail = pathThumbnail;
	}

	/**
	 * Obtiene el objeto altura de este DTO.
	 * 
	 * @return Objeto altura de este DTO.
	 */
	public Integer getAltura() {
		return altura;
	}

	/**
	 * Setea el objeto altura de este DTO.
	 * 
	 * @param altura Objeto altura de este DTO.
	 */
	public void setAltura(Integer altura) {
		this.altura = altura;
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
	 * @param ancho Objeto ancho de este DTO.
	 */
	public void setAncho(Integer ancho) {
		this.ancho = ancho;
	}

	/**
	 * Obtiene el objeto tamaño de este DTO.
	 * 
	 * @return Objeto tamaño de este DTO.
	 */
	public Long getTamanio() {
		return tamanio;
	}

	/**
	 * Setea el objeto tamaño de este DTO.
	 * 
	 * @param tamanio Objeto tamaño de este DTO.
	 */
	public void setTamanio(Long tamanio) {
		this.tamanio = tamanio;
	}

	/**
	 * Obtiene el objeto repo de este DTO.
	 * 
	 * @return Objeto repo de este DTO.
	 */
	public String getRepo() {
		return repo;
	}

	/**
	 * Setea el objeto repo de este DTO.
	 * 
	 * @param repo Objeto repo de este DTO.
	 */
	public void setRepo(String repo) {
		this.repo = repo;
	}

	/**
	 * Obtiene el objeto extensión de este DTO.
	 * 
	 * @return Objeto extensión de este DTO.
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * Setea el objeto extensión de este DTO.
	 * 
	 * @param extension Objeto extensión de este DTO.
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("id: ").append(id);
		description.append(", tipo: [").append(tipo).append("]");
		description.append(", codigo: ").append(codigo);
		description.append(", contenido: ").append(contenido);
		description.append(", pathImagen: ").append(pathImagen);
		description.append(", pathThumbnail: ").append(pathThumbnail);
		description.append(", altura: ").append(altura);
		description.append(", ancho: ").append(ancho);
		description.append(", tamanio: ").append(tamanio);
		description.append(", repo: ").append(repo);
		description.append(", extension: ").append(extension);
		
		return description.toString();
	}
}
