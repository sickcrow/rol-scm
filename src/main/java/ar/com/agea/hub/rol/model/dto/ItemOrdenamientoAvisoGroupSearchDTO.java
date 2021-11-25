/*
 * @(#)ItemOrdenamientoAvisoGroupSearchDTO.java		1.0 09/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos de búsqueda de items ordenamientos avisos.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 09/08/2013
 */
public class ItemOrdenamientoAvisoGroupSearchDTO implements JSONDTO {
	
	private static final long serialVersionUID = 8164559425854914434L;

	private String codigoNivelEstructura;
	private List<ItemOrdenamientoAvisoSearchDTO> itemsOrdenamientoAvisoSearch;

	/**
	 * Instancia un objeto de tipo ItemOrdenamientoAvisoGroupSearchDTO.
	 */
	public ItemOrdenamientoAvisoGroupSearchDTO() {
		itemsOrdenamientoAvisoSearch = new ArrayList<ItemOrdenamientoAvisoSearchDTO>();
	}
	
	/**
	 * Obtiene el objeto código nivel estructura de este DTO. 
	 * 
	 * @return Objeto código nivel estructura de este DTO.
	 */
	public String getCodigoNivelEstructura() {
		return codigoNivelEstructura;
	}

	/**
	 * Setea el objeto código nivel estructura de este DTO.
	 * 
	 * @param codigoNivelEstructura Objeto código nivel estructura de este DTO.
	 */
	public void setCodigoNivelEstructura(String codigoNivelEstructura) {
		this.codigoNivelEstructura = codigoNivelEstructura;
	}

	/**
	 * Obtiene los objetos ítems ordenamiento aviso search de este DTO. 
	 * 
	 * @return Objetos ítems ordenamiento aviso search de este DTO.
	 */
	public List<ItemOrdenamientoAvisoSearchDTO> getItemsOrdenamientoAvisoSearch() {
		return itemsOrdenamientoAvisoSearch;
	}

	/**
	 * Setea los objetos ítems ordenamiento aviso search de este DTO.
	 * 
	 * @param itemsOrdenamientoAvisoSearch Objetos ítems ordenamiento aviso search de este DTO.
	 */
	public void setItemsOrdenamientoAvisoSearch(List<ItemOrdenamientoAvisoSearchDTO> itemsOrdenamientoAvisoSearch) {
		this.itemsOrdenamientoAvisoSearch = itemsOrdenamientoAvisoSearch;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoNivelEstructura: ").append(codigoNivelEstructura);
		description.append(", itemsOrdenamientoAvisoSearch: [").append(toString(itemsOrdenamientoAvisoSearch)).append("]");
		
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
