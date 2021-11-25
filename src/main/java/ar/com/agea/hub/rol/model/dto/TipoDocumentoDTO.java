/*
 * @(#)TipoDocumentoDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de tipos de documentos.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicaci�n y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class TipoDocumentoDTO implements JSONDTO {
	
	private static final long serialVersionUID = 6438051890953012466L;
	
	private String codigo;

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

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();

		description.append("codigo: ").append(codigo);
		
		return description.toString();
	}
}
