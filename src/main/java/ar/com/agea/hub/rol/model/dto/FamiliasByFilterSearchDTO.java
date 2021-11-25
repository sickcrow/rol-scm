/*
 * @(#)FamiliasByFilterSearchDTO.java		1.0 24/07/2014
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos de b�squeda de clases.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicaci�n y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 24/07/2014
 */
public class FamiliasByFilterSearchDTO implements XMLDTO {

	private static final long serialVersionUID = 6726634193530698083L;

	private List<String> codigosClase;
	private String codigoCanalEntrada;
	
	/**
	 * Instancia un objeto de tipo FamiliasByFilterSearchDTO.
	 */
	public FamiliasByFilterSearchDTO() {
		codigosClase = new ArrayList<String>();
	}

	/**
	 * Obtiene los objetos c�digos clase de este DTO. 
	 * 
	 * @return Objetos c�digos clase de este DTO.
	 */
	public List<String> getCodigosClase() {
		return codigosClase;
	}

	/**
	 * Setea los objetos c�digos clase de este DTO.
	 * 
	 * @param conceptosVendibles Objeto c�digos clase de este DTO.
	 */
	public void setCodigosClase(List<String> codigosClase) {
		this.codigosClase = codigosClase;
	}

	/**
	 * Obtiene el objeto c�digo canal entrada de este DTO. 
	 * 
	 * @return Objeto c�digo canal entrada este DTO.
	 */
	public String getCodigoCanalEntrada() {
		return codigoCanalEntrada;
	}

	/**
	 * Setea el objeto c�digo canal entrada de este DTO.
	 * 
	 * @param id Objeto c�digo canal entrada de este DTO.
	 */
	public void setCodigoCanalEntrada(String codigoCanalEntrada) {
		this.codigoCanalEntrada = codigoCanalEntrada;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append(", codigosClase: [").append(toString(codigosClase)).append("]");
		description.append(", codigoCanalEntrada: ").append(codigoCanalEntrada);
		
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
