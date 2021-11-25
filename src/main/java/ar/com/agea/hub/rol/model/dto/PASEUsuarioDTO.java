/*
 * @(#)UsuarioPASEDTO.java		1.0 24/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de usuarios PASE.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios PASE.
 * 
 * @author		Mariano De Nicolo
 * @author		Eduardo Barrera
 * @version		1.0 24/09/2013
 */
public class PASEUsuarioDTO implements JSONDTO {
	
	private static final long serialVersionUID = 103155025600523457L;
	
	/**
	 * Identifica el tipo de este DTO.
	 * 
	 * @author      Eduardo Barrera
	 * @version		1.0 24/09/2013
	 */
	public static enum Estado {CREADO, ACTIVO, CANCELADO;};
	
	private String codigoSitio;
	private String token;
	private String uid;
	private String apellido;
	private String nombre;
	private String genero;
	private String fechaNacimiento;
	private String email;
	private String palabraClave;
	private Estado estado;

	/**
	 * Obtiene el objeto código sitio de este DTO.
	 * 
	 * @return Objeto código sitio de este DTO.
	 */
	public String getCodigoSitio() {
		return codigoSitio;
	}

	/**
	 * Setea el objeto código sitio de este DTO.
	 * 
	 * @param codigoSitio Objeto código sitio de este DTO.
	 */
	public void setCodigoSitio(String codigoSitio) {
		this.codigoSitio = codigoSitio;
	}

	/**
	 * Obtiene el objeto token de este DTO.
	 * 
	 * @return Objeto token de este DTO.
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Setea el objeto token de este DTO.
	 * 
	 * @param token Objeto token de este DTO.
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * Obtiene el objeto uid de este DTO.
	 * 
	 * @return Objeto uid de este DTO.
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * Setea el objeto uid de este DTO.
	 * 
	 * @param uid Objeto uid de este DTO.
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * Obtiene el objeto apellido de este DTO.
	 * 
	 * @return Objeto apellido de este DTO.
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Setea el objeto apellido de este DTO.
	 * 
	 * @param apellido Objeto apellido de este DTO.
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	 * @param nombre Objeto nombre de este DTO.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el objeto genero de este DTO.
	 * 
	 * @return Objeto genero de este DTO.
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Setea el objeto genero de este DTO.
	 * 
	 * @param genero Objeto genero de este DTO.
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Obtiene el objeto fecha nacimiento de este DTO.
	 * 
	 * @return Objeto fecha nacimiento de este DTO.
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Setea el objeto fecha nacimiento de este DTO.
	 * 
	 * @param fechaNacimiento Objeto fecha nacimiento de este DTO.
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Obtiene el objeto email de este DTO.
	 * 
	 * @return Objeto email de este DTO.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setea el objeto email de este DTO.
	 * 
	 * @param email Objeto email de este DTO.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtiene el objeto palabra clave de este DTO.
	 * 
	 * @return Objeto palabra clave de este DTO.
	 */
	public String getPalabraClave() {
		return palabraClave;
	}

	/**
	 * Setea el objeto palabra clave de este DTO.
	 * 
	 * @param palabraClave Objeto palabra clave de este DTO.
	 */
	public void setPalabraClave(String palabraClave) {
		this.palabraClave = palabraClave;
	}

	/**
	 * Obtiene el objeto estado de este DTO.
	 * 
	 * @return Objeto estado de este DTO.
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * Setea el objeto estado de este DTO.
	 * 
	 * @param estado Objeto estado de este DTO.
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoSitio: ").append(codigoSitio);
		description.append(", token: ").append(token);
		description.append(", uid: ").append(uid);
		description.append(", apellido: ").append(apellido);
		description.append(", nombre: ").append(nombre);
		description.append(", genero: ").append(genero);
		description.append(", fechaNacimiento: ").append(fechaNacimiento);
		description.append(", email: ").append(email);
		description.append(", palabraClave: ").append(palabraClave);
		description.append(", estado: [").append(estado).append("]");
		
		return description.toString();
	}
}
