/*
 * @(#)CapturadorCRUDDTO.java		1.0 24/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

/**
 * Representa un objeto Data Transfer Object para transferir datos de anunciantes.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Mariano De Nicolo
 * @author		Eduardo Barrera
 * @version		1.0 24/09/2013
 */
public class CapturadorCRUDDTO implements JSONDTO {
	
	private static final long serialVersionUID = -8931446498451141485L;
	
	private Long codigoAnunciante;
	private String descripcionAnunciante; // TODO ver si se usa.
	private String codigoTipoAnunciante;
	private String codigoCliente;
	private String codigoClase; // TODO ver si se usa.
	private String codigoPerfilAnunciante;
	private String email;
	private String nombre;
	private String apellido;
	private String codigoMedioPagoPrincipal;
	private String codigoTipoIVA;
	private String codigoCanalEntrada;
	private String codigoTipoDocumento;
	private Long numeroDocumento;
	private String usuarioExternoCodigo;
	private DomicilioDTO domicilio;
	private String sexo;
	private String fechaNacimiento;
	
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
	 * Obtiene el objeto descripción anunciante de este DTO. 
	 * 
	 * @return Objeto descripción anunciante de este DTO.
	 * 
	 * @deprecated
	 */
	public String getDescripcionAnunciante() {
		return descripcionAnunciante;
	}

	/**
	 * Setea el objeto descripción anunciante de este DTO.
	 * 
	 * @param descripcionAnunciante Objeto descripción anunciante de este DTO.
	 * 
	 * @deprecated
	 */
	public void setDescripcionAnunciante(String descripcionAnunciante) {
		this.descripcionAnunciante = descripcionAnunciante;
	}

	/**
	 * Obtiene el objeto código tipo anunciante de este DTO. 
	 * 
	 * @return Objeto código tipo anunciante de este DTO.
	 */
	public String getCodigoTipoAnunciante() {
		return codigoTipoAnunciante;
	}

	/**
	 * Setea el objeto código tipo anunciante de este DTO.
	 * 
	 * @param codigoTipoAnunciante Objeto código tipo anunciante de este DTO.
	 */
	public void setCodigoTipoAnunciante(String codigoTipoAnunciante) {
		this.codigoTipoAnunciante = codigoTipoAnunciante;
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
	 * Obtiene el objeto código clase de este DTO. 
	 * 
	 * @return Objeto código clase de este DTO.
	 * 
	 * @deprecated
	 */
	public String getCodigoClase() {
		return codigoClase;
	}

	/**
	 * Setea el objeto código clase de este DTO.
	 * 
	 * @param codigoClase Objeto código clase de este DTO.
	 * 
	 * @deprecated
	 */
	public void setCodigoClase(String codigoClase) {
		this.codigoClase = codigoClase;
	}

	/**
	 * Obtiene el objeto código perfil anunciante de este DTO. 
	 * 
	 * @return Objeto código perfil anunciante de este DTO.
	 */
	public String getCodigoPerfilAnunciante() {
		return codigoPerfilAnunciante;
	}

	/**
	 * Setea el objeto código perfil anunciante de este DTO.
	 * 
	 * @param codigoPerfilAnunciante Objeto código perfil anunciante de este DTO.
	 */
	public void setCodigoPerfilAnunciante(String codigoPerfilAnunciante) {
		this.codigoPerfilAnunciante = codigoPerfilAnunciante;
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
	 * Obtiene el objeto código medio pago principal de este DTO. 
	 * 
	 * @return Objeto código medio pago principal de este DTO.
	 */
	public String getCodigoMedioPagoPrincipal() {
		return codigoMedioPagoPrincipal;
	}

	/**
	 * Setea el objeto código medio pago principal de este DTO.
	 * 
	 * @param codigoMedioPagoPrincipal Objeto código medio pago principal de este DTO.
	 */
	public void setCodigoMedioPagoPrincipal(String codigoMedioPagoPrincipal) {
		this.codigoMedioPagoPrincipal = codigoMedioPagoPrincipal;
	}

	/**
	 * Obtiene el objeto código tipo IVA de este DTO. 
	 * 
	 * @return Objeto código tipo IVA de este DTO.
	 */
	public String getCodigoTipoIVA() {
		return codigoTipoIVA;
	}

	/**
	 * Setea el objeto código tipo IVA de este DTO.
	 * 
	 * @param codigoTipoIVA Objeto código tipo IVA de este DTO.
	 */
	public void setCodigoTipoIVA(String codigoTipoIVA) {
		this.codigoTipoIVA = codigoTipoIVA;
	}

	/**
	 * Obtiene el objeto código canal entrada de este DTO. 
	 * 
	 * @return Objeto código canal entrada de este DTO.
	 */
	public String getCodigoCanalEntrada() {
		return codigoCanalEntrada;
	}

	/**
	 * Setea el objeto código canal entrada de este DTO.
	 * 
	 * @param codigoCanalEntrada Objeto código canal entrada de este DTO.
	 */
	public void setCodigoCanalEntrada(String codigoCanalEntrada) {
		this.codigoCanalEntrada = codigoCanalEntrada;
	}

	/**
	 * Obtiene el objeto código tipo documento de este DTO. 
	 * 
	 * @return Objeto código tipo documento de este DTO.
	 */
	public String getCodigoTipoDocumento() {
		return codigoTipoDocumento;
	}

	/**
	 * Setea el objeto código tipo documento de este DTO.
	 * 
	 * @param codigoTipoDocumento Objeto código tipo documento de este DTO.
	 */
	public void setCodigoTipoDocumento(String codigoTipoDocumento) {
		this.codigoTipoDocumento = codigoTipoDocumento;
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
	 * Obtiene el objeto codigo de usuario externo de este DTO. 
	 * 
	 * @return Objeto código de usuario externo de este DTO.
	 */
	public String getUsuarioExternoCodigo() {
		return usuarioExternoCodigo;
	}

	/**
	 * Setea el objeto código usuario externo de este DTO.
	 * 
	 * @param usuarioExternoCodigo Objeto código de usuario externo de este DTO.
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

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoAnunciante: ").append(codigoAnunciante);
		description.append(", descripcionAnunciante: ").append(descripcionAnunciante);
		description.append(", codigoTipoAnunciante: ").append(codigoTipoAnunciante);
		description.append(", codigoCliente: ").append(codigoCliente);
		description.append(", codigoClase: ").append(codigoClase);
		description.append(", codigoPerfilAnunciante: ").append(codigoPerfilAnunciante);
		description.append(", email: ").append(email);
		description.append(", nombre: ").append(nombre);
		description.append(", apellido: ").append(apellido);
		description.append(", codigoMedioPagoPrincipal: ").append(codigoMedioPagoPrincipal);
		description.append(", codigoTipoIVA: ").append(codigoTipoIVA);
		description.append(", codigoCanalEntrada: ").append(codigoCanalEntrada);
		description.append(", codigoTipoDocumento: ").append(codigoTipoDocumento);
		description.append(", numeroDocumento: ").append(numeroDocumento);
		description.append(", usuarioExternoCodigo: ").append(usuarioExternoCodigo);
		description.append(", domicilio: [").append(domicilio).append("]");
		description.append(", sexo: ").append(sexo);
		description.append(", fechaNacimiento: ").append(fechaNacimiento);
		
		return description.toString();
	}
}
