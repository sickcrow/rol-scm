/*
 * @(#)TrackCampanaDTO.java		1.0 24/06/2014
 */

package ar.com.agea.hub.rol.model.dto;

/**
 * Representa un objeto Data Transfer Object para transferir datos de trackeo a campanias.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Mariano De Nicolo
 * @version		1.0 24/06/2014
 */
public class TrackCampanaDTO implements JSONDTO {

	private static final long serialVersionUID = -9185591979684065096L;
	
	private String fuente;
	private String medio;
	private String campana;
	
	/**
	 * Instancia un objeto de tipo TrackCampanaDTO.
	 */
	public TrackCampanaDTO() {}
	
	/**
	 * Instancia un objeto de tipo TrackCampanaDTO a través de parámetros.
	 */
	public TrackCampanaDTO(String fuente, String medio, String campana) {
		this.fuente = fuente;
		this.medio = medio;
		this.campana = campana;
	}

	/**
	 * Obtiene el objeto fuente de este DTO.
	 * 
	 * @return Objeto fuente de este DTO.
	 */
	public String getFuente() {
		return fuente;
	}
	
	/**
	 * Setea el objeto fuente de este DTO.
	 * 
	 * @param fuente Objeto fuente de este DTO.
	 */
	public void setFuente(String fuente) {
		this.fuente = fuente;
	}
	
	/**
	 * Obtiene el objeto medio de este DTO.
	 * 
	 * @return Objeto medio de este DTO.
	 */
	public String getMedio() {
		return medio;
	}
	
	/**
	 * Setea el objeto medio de este DTO.
	 * 
	 * @param medio Objeto medio de este DTO.
	 */
	public void setMedio(String medio) {
		this.medio = medio;
	}
	
	/**
	 * Obtiene el objeto campana de este DTO.
	 * 
	 * @return Objeto campana de este DTO.
	 */
	public String getCampana() {
		return campana;
	}
	
	/**
	 * Setea el objeto campana de este DTO.
	 * 
	 * @param familia Objeto campana de este DTO.
	 */
	public void setCampana(String campana) {
		this.campana = campana;
	}
	
	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("fuente: ").append(fuente);
		description.append(", medio: ").append(medio);
		description.append(", campania: ").append(campana);
		
		return description.toString();
	}
}
