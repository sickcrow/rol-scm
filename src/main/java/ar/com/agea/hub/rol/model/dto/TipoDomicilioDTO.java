package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de tipo de domicilio.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicaci�n y los
 * servicios HUB.
 * 
 * @author		Juan Martin Lichowski
 * @version		1.0 13/11/2013
 */
public class TipoDomicilioDTO implements JSONDTO {

	private static final long serialVersionUID = -4059457612869624471L;
	
	private String codigo;
	private String descripcion;
	
	/**
	 * Obtiene el objeto c�digo de este DTO.
	 * 
	 * @return Objeto c�digo de este DTO.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Setea el objeto c�digo de este DTO.
	 * 
	 * @param codigo Objeto c�digo de este DTO.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/**
	 * Obtiene el objeto descripci�n de este DTO.
	 * 
	 * @return Objeto descripci�n de este DTO.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Setea el objeto descripci�n de este DTO.
	 * 
	 * @param descripcion Objeto descripci�n de este DTO.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();

		description.append("codigo: ").append(codigo);
		description.append(", descripcion: ").append(descripcion);
		
		return description.toString();
	}
}
