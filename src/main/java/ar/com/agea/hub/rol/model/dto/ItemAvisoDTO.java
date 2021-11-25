/*
 * @(#)ItemAvisoDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de items de avisos.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ItemAvisoDTO implements JSONDTO {
	
	private static final long serialVersionUID = 7228829721648553155L;
	
	private Long id;
	private Long numero;
	private AvisoDTO aviso;

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
	 * Obtiene el objeto número de este DTO. 
	 * 
	 * @return Objeto número de este DTO.
	 */
	public Long getNumero() {
		return numero;
	}

	/**
	 * Setea el objeto número de este DTO.
	 * 
	 * @param numero Objeto númerode este DTO.
	 */
	public void setNumero(Long numero) {
		this.numero = numero;
	}

	/**
	 * Obtiene el objeto aviso de este DTO. 
	 * 
	 * @return Objeto aviso de este DTO.
	 */
	public AvisoDTO getAviso() {
		return aviso;
	}

	/**
	 * Setea el objeto aviso de este DTO.
	 * 
	 * @param aviso Objeto aviso de este DTO.
	 */
	public void setAviso(AvisoDTO aviso) {
		this.aviso = aviso;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("id: ").append(id);
		description.append(", numero: ").append(numero);
		description.append(", aviso: [").append(aviso).append("]");
		
		return description.toString();
	}
}
