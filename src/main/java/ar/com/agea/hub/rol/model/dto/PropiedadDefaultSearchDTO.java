/*
 * @(#)PropiedadDefaultSearchDTO.java		1.0 21/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos de búsqueda de propiedades default.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 21/08/2013
 */
public class PropiedadDefaultSearchDTO implements JSONDTO {
	
	private static final long serialVersionUID = -8631454372217209151L;
	
	private List<String> codigosPropiedadDefault;

	/**
	 * Instancia un objeto de tipo PropiedadDefaultSearchDTO.
	 */
	public PropiedadDefaultSearchDTO() {
		codigosPropiedadDefault = new ArrayList<String>();
	}
	
	/**
	 * Obtiene los objetos códigos propiedad default de este DTO.
	 * 
	 * @return Objetos códigos propiedad default de este DTO.
	 */
	public List<String> getCodigosPropiedadDefault() {
		return codigosPropiedadDefault;
	}

	/**
	 * Setea los objetos códigos propiedad default de este DTO.
	 * 
	 * @param codigosPropiedadDefault Objetos códigos propiedad default de este DTO.
	 */
	public void setCodigosPropiedadDefault(List<String> codigosPropiedadDefault) {
		this.codigosPropiedadDefault = codigosPropiedadDefault;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigosPropiedadDefault: [").append(toString(codigosPropiedadDefault)).append("]");
		
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
