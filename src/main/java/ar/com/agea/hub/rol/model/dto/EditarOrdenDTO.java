package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de edición de avisos.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Alejandro Di Fiore
 * @version		1.0 17/11/2014
 */
public class EditarOrdenDTO implements JSONDTO {
	
	private static final long serialVersionUID = 6947885306842789328L;
	
	private Long idOrden;
		
	/**
	 * Obtiene el objeto id orden de este DTO. 
	 * 
	 * @return Objeto id orden de este DTO.
	 */
	public Long getIdOrden() {
		return idOrden;
	}
	
	/**
	 * Setea el objeto id orden de este DTO.
	 * 
	 * @param idOrden Objeto id orden de este DTO.
	 */
	public void setIdOrden(Long idOrden) {
		this.idOrden = idOrden;
	}
		
	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("idOrden: ").append(idOrden);
				
		return description.toString();
	}
		
}
