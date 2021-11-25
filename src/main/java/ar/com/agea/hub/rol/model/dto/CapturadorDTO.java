/*
 * @(#)CapturadorDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de capturadores.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class CapturadorDTO implements JSONDTO {

	private static final long serialVersionUID = -6499996401715314345L;

	/**
	 * Identifica el tipo de este DTO.
	 * 
	 * @author      Eduardo Barrera
	 * @version		1.0 06/06/2013
	 */
	public static enum Tipo {ANUNCIANTE, RECEPTORIA;};
	
	private Tipo tipo;
	private Long numeroDocumento;
	private String codigoCliente;
	private Long codigoAnunciante;
	private String usuarioExternoCodigo;
	private DomicilioDTO domicilio;
	private String nombre;
	private String apellido;
	private String sexo;
	private String fechaNacimiento;
	private String email;
	
	private Long idCliente;
	private Long id;

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
	 * @param tipo Objeto tipo de este DTO.
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Obtiene el objeto número documento de este DTO. 
	 * 
	 * @return Objeto número documento de este DTO.
	 */	
	public Long getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * Setea el objeto número documento de este DTO.
	 * 
	 * @param numeroDocumento Objeto número documento de este DTO.
	 */
	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * Obtiene el objeto código cliente de este DTO. 
	 * 
	 * @return Objeto código cliente de este DTO.
	 */
	public String getCodigoCliente() {
		return codigoCliente;
	}
	
	/**
	 * Setea el objeto código cliente de este DTO.
	 * 
	 * @param codigoCliente Objeto código cliente de este DTO.
	 */
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	/**
	 * Obtiene el objeto código anunciante de este DTO. 
	 * 
	 * @return Objeto código anunciante de este DTO.
	 */
	public Long getCodigoAnunciante() {
		return codigoAnunciante;
	}
	
	/**
	 * Setea el objeto código anunciante de este DTO.
	 * 
	 * @param codigoAnunciante Objeto código anunciante de este DTO.
	 */
	public void setCodigoAnunciante(Long codigoAnunciante) {
		this.codigoAnunciante = codigoAnunciante;
	}

	/**
	 * Obtiene el objeto código de usuario externo de este DTO. 
	 * 
	 * @return Objeto código de usuario externo de este DTO.
	 */
	public String getUsuarioExternoCodigo() {
		return usuarioExternoCodigo;
	}

	/**
	 * Setea el objeto código de usuario externo de este DTO.
	 * 
	 * @param codigoPASE Objeto código usuario externo de este DTO.
	 */
	public void setUsuarioExternoCodigo(String usuarioExternoCodigo) {
		this.usuarioExternoCodigo = usuarioExternoCodigo;
	}

	/**
	 * Obtiene el objeto domicilio de este DTO. 
	 * 
	 * @return Objeto domicilio de este DTO.
	 */
	public DomicilioDTO getDomicilio() {
		return domicilio;
	}

	/**
	 * Setea el objeto domicilio de este DTO.
	 * 
	 * @param domicilio Objeto domicilio de este DTO.
	 */
	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
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
	 * Obtiene el objeto apellido de este DTO. 
	 * 
	 * @return Objeto apellido de este DTO.
	 */
	public Long getIdCliente() {
		return idCliente;
	}

	/**
	 * Setea el objeto apellido de este DTO.
	 * 
	 * @param apellido Objeto apellido de este DTO.
	 */
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("tipo: [").append(tipo).append("]");
		description.append(", numeroDocumento: ").append(numeroDocumento);
		description.append(", codigoCliente: ").append(codigoCliente);
		description.append(", codigoAnunciante: ").append(codigoAnunciante);
		description.append(", usuarioExternoCodigo: ").append(usuarioExternoCodigo);
		description.append(", domicilio: [").append(domicilio).append("]");
		description.append(", nombre: ").append(nombre);
		description.append(", apellido: ").append(apellido);
		
		return description.toString();
	}
}
