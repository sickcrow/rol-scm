/*
 * @(#)FamiliaDTO.java		1.0 30/07/2014
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos de ordenes de publicación.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 30/07/2014
 */
public class FamiliaDTO implements JSONDTO {

	private static final long serialVersionUID = 3328979162787727118L;
	
	private ClaseDTO clase;
	private List<ClaseDTO> clases;

	/**
	 * Instancia un objeto de tipo FamiliaDTO.
	 */
	public FamiliaDTO() {
		clases = new ArrayList<ClaseDTO>();
	}

	/**
	 * Obtiene el objeto clase de este DTO. 
	 * 
	 * @return Objeto clase de este DTO.
	 */
	public ClaseDTO getClase() {
		return clase;
	}

	/**
	 * Setea el objeto clase de este DTO.
	 * 
	 * @param clase Objeto clase de este DTO.
	 */
	public void setClase(ClaseDTO clase) {
		this.clase = clase;
	}

	/**
	 * Obtiene los objetos clases de este DTO. 
	 * 
	 * @return Objetos clases de este DTO.
	 */
	public List<ClaseDTO> getClases() {
		return clases;
	}

	/**
	 * Setea los objetos clases de este DTO.
	 * 
	 * @param transacciones Objeto clases de este DTO.
	 */
	public void setClases(List<ClaseDTO> clases) {
		this.clases = clases;
	}
	
	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
	
		description.append("clase: [").append(clase).append("]");
		description.append(", clases: [").append(toString(clases)).append("]");
		
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
