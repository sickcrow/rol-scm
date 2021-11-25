package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

/**
 * Representa un objeto Data Transfer Object para transferir datos de busqueda para la 
 * obtención de permisos de atributos.
 * Contiene los criterios para realizar la búsqueda del permiso del atributo.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación.
 * 
 * @author		Alejandro Di Fiore
 * @version		1.0 10/06/2015
 */
public class PermisoAtributoSearchDTO implements JSONDTO {

	private static final long serialVersionUID = -5421248326987196052L;
	
	private String codigoAtributo; 
	private Date fechaVigencia; 
	private String codigoCanalEntrada; 
	private String codigoTipoOperacion; 
	private String codigoProductoComercial;
	private String codigoProducto;
	private String codigoNivelEstructura;
	
	/**
	 * Obtiene el valor del atributo codigoAtributo de este DTO.
	 * 
	 * @return El valor del atributo codigo atributo de este DTO.
	 */
	public String getCodigoAtributo() {
		return codigoAtributo;
	}
	
	/**
	 * Setea el valor del atributo codigoAtributo de este DTO.
	 * 
	 * @param codigoAtributo El valor del atributo codigo atributo de este DTO.
	 */
	public void setCodigoAtributo(String codigoAtributo) {
		this.codigoAtributo = codigoAtributo;
	}
	
	/**
	 * Obtiene el valor del atributo fechaVigencia de este DTO.
	 * 
	 * @return El valor del atributo fecha vigencia de este DTO.
	 */
	public Date getFechaVigencia() {
		return fechaVigencia;
	}
	
	/**
	 * Setea el valor del atributo fechaVigencia de este DTO.
	 * 
	 * @param fechaVigencia El valor del atributo fecha vigencia de este DTO.
	 */
	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}
	
	/**
	 * Obtiene el valor del atributo codigoCanalEntrada de este DTO.
	 * 
	 * @return El valor del atributo codigo canal entrada de este DTO.
	 */
	public String getCodigoCanalEntrada() {
		return codigoCanalEntrada;
	}
	
	/**
	 * Setea el valor del atributo codigoCanalEntrada de este DTO.
	 * 
	 * @param codigoCanalEntrada El valor del atributo codigo canal entrada de este DTO.
	 */
	public void setCodigoCanalEntrada(String codigoCanalEntrada) {
		this.codigoCanalEntrada = codigoCanalEntrada;
	}
	
	/**
	 * Obtiene el valor del atributo codigoTipoOperacion de este DTO.
	 * 
	 * @return El valor del atributo codigo tipo operación de este DTO.
	 */
	public String getCodigoTipoOperacion() {
		return codigoTipoOperacion;
	}
	
	/**
	 * Setea el valor del atributo codigoTipoOperacion de este DTO.
	 * 
	 * @param codigoTipoOperacion El valor del atributo codigo tipo operacion de este DTO.
	 */
	public void setCodigoTipoOperacion(String codigoTipoOperacion) {
		this.codigoTipoOperacion = codigoTipoOperacion;
	}
	
	/**
	 * Obtiene el valor del atributo codigoProductoComercial de este DTO.
	 * 
	 * @return El valor del atributo codigo producto comercial de este DTO.
	 */
	public String getCodigoProductoComercial() {
		return codigoProductoComercial;
	}
	
	/**
	 * Setea el valor del atributo codigoProductoComercial de este DTO.
	 * 
	 * @param codigoProductoComercial El valor del atributo codigo producto comercial de este DTO.
	 */
	public void setCodigoProductoComercial(String codigoProductoComercial) {
		this.codigoProductoComercial = codigoProductoComercial;
	}
	
	/**
	 * Obtiene el valor del atributo codigoProducto de este DTO.
	 * 
	 * @return El valor del atributo codigo producto de este DTO.
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}
	
	/**
	 * Setea el valor del atributo codigoProducto de este DTO.
	 * 
	 * @param codigoProducto El valor del atributo codigo producto de este DTO.
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	
	/**
	 * Obtiene el valor del atributo codigoNivelEstructura de este DTO.
	 * 
	 * @return El valor del atributo codigo nivel estructura de este DTO.
	 */
	public String getCodigoNivelEstructura() {
		return codigoNivelEstructura;
	}
	
	/**
	 * Setea el valor del atributo codigoNivelEstructura de este DTO.
	 * 
	 * @param subrubros El valor del atributo codigo nivel estructura de este DTO.
	 */
	public void setCodigoNivelEstructura(String codigoNivelEstructura) {
		this.codigoNivelEstructura = codigoNivelEstructura;
	}
	
}
