/*
 * @(#)ItemOrdenamientoAvisoSearchDTO.java		1.0 09/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de b�squeda de items ordenamientos avisos.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicaci�n y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 09/08/2013
 */
public class ItemOrdenamientoAvisoSearchDTO implements JSONDTO {
	
	private static final long serialVersionUID = 4719722551126983351L;
	
	private String codigoNivelEstructura; // Cuando no es utilizado en conjunto con ItemOrdenamientoAvisoGroupSearchDTO este campo debe contener su valor correspondiente.
	private String codigoOrdenamientoAviso;
	private String codigoOrdenamientoAvisoPadre;
	private String codigoItemOrdenamientoAvisoPadre;
	
	/**
	 * Obtiene el objeto c�digo nivel estructura de este DTO.
	 * 
	 * @return Objeto c�digo nivel estructura de este DTO.
	 */
	public String getCodigoNivelEstructura() {
		return codigoNivelEstructura;
	}

	/**
	 * Setea el objeto c�digo nivel estructura de este DTO.
	 * 
	 * @param codigoNivelEstructura Objeto c�digo nivel estructura de este DTO.
	 */
	public void setCodigoNivelEstructura(String codigoNivelEstructura) {
		this.codigoNivelEstructura = codigoNivelEstructura;
	}

	/**
	 * Obtiene el objeto c�digo ordenamiento aviso de este DTO.
	 * 
	 * @return Objeto c�digo ordenamiento aviso de este DTO.
	 */
	public String getCodigoOrdenamientoAviso() {
		return codigoOrdenamientoAviso;
	}

	/**
	 * Setea el objeto c�digo ordenamiento aviso de este DTO.
	 * 
	 * @param codigoOrdenamientoAviso Objeto c�digo ordenamiento aviso de este DTO.
	 */
	public void setCodigoOrdenamientoAviso(String codigoOrdenamientoAviso) {
		this.codigoOrdenamientoAviso = codigoOrdenamientoAviso;
	}
	
	/**
	 * Obtiene el objeto c�digo ordenamiento aviso de este DTO.
	 * 
	 * @return Objeto c�digo ordenamiento aviso de este DTO.
	 */
	public String getCodigoOrdenamientoAvisoPadre() {
		return codigoOrdenamientoAvisoPadre;
	}

	/**
	 * Setea el objeto c�digo ordenamiento aviso de este DTO.
	 * 
	 * @param codigoOrdenamientoAvisoPadre Objeto c�digo ordenamiento aviso de este DTO.
	 */
	public void setCodigoOrdenamientoAvisoPadre(String codigoOrdenamientoAvisoPadre) {
		this.codigoOrdenamientoAvisoPadre = codigoOrdenamientoAvisoPadre;
	}

	/**
	 * Obtiene el objeto c�digo item ordenamiento aviso padre de este DTO.
	 * 
	 * @return Objeto c�digo item ordenamiento aviso padre de este DTO.
	 */
	public String getCodigoItemOrdenamientoAvisoPadre() {
		return codigoItemOrdenamientoAvisoPadre;
	}

	/**
	 * Setea el objeto c�digo item ordenamiento aviso padre de este DTO.
	 * 
	 * @param codigoItemOrdenamientoAvisoPadre Objeto c�digo item ordenamiento aviso padre de este DTO.
	 */
	public void setCodigoItemOrdenamientoAvisoPadre(String codigoItemOrdenamientoAvisoPadre) {
		this.codigoItemOrdenamientoAvisoPadre = codigoItemOrdenamientoAvisoPadre;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoNivelEstructura: ").append(codigoNivelEstructura);
		description.append(", codigoOrdenamientoAviso: ").append(codigoOrdenamientoAviso);
		description.append(", codigoOrdenamientoAvisoPadre: ").append(codigoOrdenamientoAvisoPadre);
		description.append(", codigoItemOrdenamientoAvisoPadre: ").append(codigoItemOrdenamientoAvisoPadre);
		
		return description.toString();
	}
}
