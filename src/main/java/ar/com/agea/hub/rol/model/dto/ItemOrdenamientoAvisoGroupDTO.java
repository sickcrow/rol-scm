/*
 * @(#)ItemOrdenamientoAvisoGroupDTO.java		1.0 09/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Representa un objeto Data Transfer Object para transferir datos de items ordenamientos aviso.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 09/08/2013
 */
public class ItemOrdenamientoAvisoGroupDTO implements JSONDTO {
	
	private static final long serialVersionUID = -7710134528623982054L;

	private String codigoOrdenamientoAvisoPadre;
	private String codigoItemOrdenamientoAvisoPadre;
	private String codigoOrdenamientoAviso;
	private List<ItemOrdenamientoAvisoDTO> itemsOrdenamientoAviso;
	
	/**
	 * Instancia un objeto de tipo ItemOrdenamientoAvisoGroupDTO.
	 */
	public ItemOrdenamientoAvisoGroupDTO() {
		itemsOrdenamientoAviso = new ArrayList<ItemOrdenamientoAvisoDTO>();
	}
	
	/**
	 * Obtiene el objeto código ordenamiento aviso padre de este DTO. 
	 * 
	 * @return Objeto código ordenamiento aviso padre de este DTO.
	 */
	public String getCodigoOrdenamientoAvisoPadre() {
		return codigoOrdenamientoAvisoPadre;
	}

	/**
	 * Setea el objeto código ordenamiento aviso padre de este DTO.
	 * 
	 * @param codigoOrdenamientoAvisoPadre Objeto código ordenamiento aviso padre de este DTO.
	 */
	public void setCodigoOrdenamientoAvisoPadre(String codigoOrdenamientoAvisoPadre) {
		this.codigoOrdenamientoAvisoPadre = codigoOrdenamientoAvisoPadre;
	}

	/**
	 * Obtiene el objeto código ítem ordenamiento aviso padre de este DTO. 
	 * 
	 * @return Objeto código ítem ordenamiento aviso padre de este DTO.
	 */
	public String getCodigoItemOrdenamientoAvisoPadre() {
		return codigoItemOrdenamientoAvisoPadre;
	}
	
	/**
	 * Setea el objeto código ítem ordenamiento aviso padre de este DTO.
	 * 
	 * @param codigoItemOrdenamientoAvisoPadre Objeto código ítem ordenamiento aviso padre de este DTO.
	 */
	public void setCodigoItemOrdenamientoAvisoPadre(String codigoItemOrdenamientoAvisoPadre) {
		this.codigoItemOrdenamientoAvisoPadre = codigoItemOrdenamientoAvisoPadre;
	}

	/**
	 * Obtiene el objeto código ordenamiento aviso de este DTO. 
	 * 
	 * @return Objeto código ordenamiento aviso de este DTO.
	 */
	public String getCodigoOrdenamientoAviso() {
		return codigoOrdenamientoAviso;
	}

	/**
	 * Setea el objeto código ordenamiento aviso de este DTO.
	 * 
	 * @param codigoOrdenamientoAviso Objeto código ordenamiento aviso de este DTO.
	 */
	public void setCodigoOrdenamientoAviso(String codigoOrdenamientoAviso) {
		this.codigoOrdenamientoAviso = codigoOrdenamientoAviso;
	}

	/**
	 * Obtiene los objetos ítems ordenamiento aviso de este DTO. 
	 * 
	 * @return Objetos ítems ordenamiento aviso de este DTO.
	 */
	public List<ItemOrdenamientoAvisoDTO> getItemsOrdenamientoAviso() {
		return itemsOrdenamientoAviso;
	}

	/**
	 * Setea los objetos ítems ordenamiento aviso de este DTO.
	 * 
	 * @param itemsOrdenamientoAviso Objetos ítems ordenamiento aviso de este DTO.
	 */
	public void setItemsOrdenamientoAviso(List<ItemOrdenamientoAvisoDTO> itemsOrdenamientoAviso) {
		this.itemsOrdenamientoAviso = itemsOrdenamientoAviso;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoOrdenamientoAvisoPadre: ").append(codigoOrdenamientoAvisoPadre);
		description.append(", codigoItemOrdenamientoAvisoPadre: ").append(codigoItemOrdenamientoAvisoPadre);
		description.append(", codigoOrdenamientoAviso: ").append(codigoOrdenamientoAviso);
		description.append(", itemsOrdenamientoAviso: [").append(toString(itemsOrdenamientoAviso)).append("]");
		
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
