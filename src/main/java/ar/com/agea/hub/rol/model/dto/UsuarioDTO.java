/*
 * @(#)UsuarioDTO.java		1.0 24/09/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de usuarios PASE y HUB.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios PASE.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 24/09/2013
 */
public class UsuarioDTO implements JSONDTO {
	
	private static final long serialVersionUID = 5733262831425688559L;

	private String uid;
	private String apellido;
	private String nombre;
	private String genero;
	private String fechaNacimiento;
	private String codigoTipoDocumento;
	private Long numeroDocumento;
	private String email;
	private String palabraClave;
	private String palabraClaveNueva;
	private String codigoCliente;
	private Long codigoAnunciante;
	private String codigoTipoAnunciante;
	private String codigoPerfilAnunciante;
	private String codigoCanalEntrada;
	private String codigoTipoIVA;
	private String codigoMedioPagoPrincipal;
	private CaptchaDTO captcha;
	private String usuarioExternoCodigo;
	
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
	 * Obtiene el objeto palabra clave nueva de este DTO.
	 * 
	 * @return Objeto palabra clave nueva de este DTO.
	 */
	public String getPalabraClaveNueva() {
		return palabraClaveNueva;
	}

	/**
	 * Setea el objeto palabra clave nueva de este DTO.
	 * 
	 * @param palabraClaveNueva Objeto palabra clave nueva de este DTO.
	 */
	public void setPalabraClaveNueva(String palabraClaveNueva) {
		this.palabraClaveNueva = palabraClaveNueva;
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
	 * Obtiene el objeto captcha de este DTO.
	 * 
	 * @return Objeto captcha de este DTO.
	 */
	public CaptchaDTO getCaptcha() {
		return captcha;
	}
	
	/**
	 * Setea el objeto captcha de este DTO.
	 * 
	 * @param captcha Objeto captcha de este DTO.
	 */
	public void setCaptcha(CaptchaDTO captcha) {
		this.captcha = captcha;
	}


	public String getUsuarioExternoCodigo() {
		return usuarioExternoCodigo;
	}

	public void setUsuarioExternoCodigo(String usuarioExternoCodigo) {
		this.usuarioExternoCodigo = usuarioExternoCodigo;
	}
	
	

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();

		description.append("uid: ").append(uid);
		description.append(", apellido: ").append(apellido);
		description.append(", nombre: ").append(nombre);
		description.append(", genero: ").append(genero);
		description.append(", fechaNacimiento: ").append(fechaNacimiento);
		description.append(", codigoTipoDocumento: ").append(codigoTipoDocumento);
		description.append(", numeroDocumento: ").append(numeroDocumento);
		description.append(", email: ").append(email);
		description.append(", palabraClave: ").append(palabraClave);
		description.append(", palabraClaveNueva: ").append(palabraClaveNueva);
		description.append(", codigoCliente: ").append(codigoCliente);
		description.append(", codigoAnunciante: ").append(codigoAnunciante);
		description.append(", codigoTipoAnunciante: ").append(codigoTipoAnunciante);
		description.append(", codigoPerfilAnunciante: ").append(codigoPerfilAnunciante);
		description.append(", codigoCanalEntrada: ").append(codigoCanalEntrada);
		description.append(", codigoTipoIVA: ").append(codigoTipoIVA);
		description.append(", codigoMedioPagoPrincipal: ").append(codigoMedioPagoPrincipal);
		description.append(", captcha: [").append(captcha).append("]");
		description.append(", usuarioExternoCodigo: ").append(usuarioExternoCodigo);
		
		return description.toString();
	}
}
