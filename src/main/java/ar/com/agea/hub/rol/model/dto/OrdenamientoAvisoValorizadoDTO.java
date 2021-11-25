/*
 * @(#)OrdenamientoAvisoValorizadoDTO.java		1.0 22/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de ordenamientos avisos valorizados.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Mariano De Nicolo
 * @version		1.0 22/07/2013
 */
public class OrdenamientoAvisoValorizadoDTO implements JSONDTO {
	
	private static final long serialVersionUID = 8803665131395922673L;
	
	private String codigo;
	private String valor;
	private String codigoBusqueda;
	private String descripcion;
	
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
	 * Obtiene el objeto valor de este DTO.
	 * 
	 * @return Objeto valor de este DTO.
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Setea el objeto valor de este DTO.
	 * 
	 * @param valor Objeto valor de este DTO.
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * Obtiene el objeto código búsqueda de este DTO.
	 * 
	 * @return Objeto código búsqueda de este DTO.
	 */
	public String getCodigoBusqueda() {
		return codigoBusqueda;
	}

	/**
	 * Setea el objeto código búsqueda de este DTO.
	 * 
	 * @param codigoBusqueda Objeto código búsqueda de este DTO.
	 */
	public void setCodigoBusqueda(String codigoBusqueda) {
		this.codigoBusqueda = codigoBusqueda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigo: ").append(codigo);
		description.append(", valor: ").append(valor);
		description.append(", codigoBusqueda: ").append(codigoBusqueda);
		description.append(", descripcion: ").append(descripcion);
		
		return description.toString();
	}
}
