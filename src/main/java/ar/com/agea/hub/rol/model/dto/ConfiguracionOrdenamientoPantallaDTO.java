/*
 * @(#)ConfiguracionOrdenamientoPantallaDTO.java		1.0 22/07/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos de configuraciones ordenamientos por pantalla.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Mariano De Nicolo
 * @version		1.0 22/07/2013
 */
public class ConfiguracionOrdenamientoPantallaDTO implements JSONDTO {
	
	private static final long serialVersionUID = 4075397266013566849L;
	
	private Long id;
	private Integer posicion;
	private String codigoCanalEntrada;
	private List<OrdenamientoAvisoDTO> ordenamientosAviso;

	/**
	 * Instancia un objeto de tipo ConfiguracionOrdenamientoPantallaDTO.
	 */
	public ConfiguracionOrdenamientoPantallaDTO() {
		ordenamientosAviso = new ArrayList<OrdenamientoAvisoDTO>();
	}

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
	 * Obtiene el objeto posición de este DTO.
	 * 
	 * @return Objeto posición de este DTO.
	 */
	public Integer getPosicion() {
		return posicion;
	}

	/**
	 * Setea el objeto posición de este DTO.
	 * 
	 * @param posicion Objeto posición de este DTO.
	 */
	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
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
	 * Obtiene los objetos ordenamientos aviso de este DTO.
	 * 
	 * @return Objetos ordenamientos aviso de este DTO.
	 */
	public List<OrdenamientoAvisoDTO> getOrdenamientosAviso() {
		return ordenamientosAviso;
	}

	/**
	 * Setea los objetos ordenamientos aviso de este DTO.
	 * 
	 * @param ordenamientosAviso Objetos ordenamientos aviso de este DTO.
	 */
	public void setOrdenamientosAviso(List<OrdenamientoAvisoDTO> ordenamientosAviso) {
		this.ordenamientosAviso = ordenamientosAviso;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("id: ").append(id);
		description.append(", posicion: ").append(posicion);
		description.append(", codigoCanalEntrada: ").append(codigoCanalEntrada);
		description.append(", ordenamientosAviso: [").append(toString(ordenamientosAviso)).append("]");
		
		return description.toString();
	}
	
	private String toString(List<?> collection) {
		StringBuilder description = new StringBuilder();
		
		Iterator<?> iterator = collection.iterator();
		
		while (iterator.hasNext()) {
			description.append(iterator.next());
			
			if (iterator.hasNext()) {
				description.append(", ");
			}
		}
		
		return description.toString();
	}
}
