/*
 * @(#)ItemConceptoVendibleDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos de items de conceptos vendibles.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ItemConceptoVendibleDTO implements JSONDTO {

	private static final long serialVersionUID = 3374141111844156656L;
	
	private Long id;
	private Long numero;
	private List<ItemAvisoDTO> itemsAviso;

	/**
	 * Instancia un objeto de tipo ItemConceptoVendible.
	 */
	public ItemConceptoVendibleDTO() {
		itemsAviso = new ArrayList<ItemAvisoDTO>();
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
	 * @param numero Objeto número de este DTO.
	 */
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	/**
	 * Obtiene los objetos items aviso de este DTO. 
	 * 
	 * @return Objetos items aviso de este DTO.
	 */
	public List<ItemAvisoDTO> getItemsAviso() {
		return itemsAviso;
	}
	
	/**
	 * Setea el objeto items aviso de este DTO.
	 * 
	 * @param itemsAviso Objeto items aviso de este DTO.
	 */
	public void setItemsAviso(List<ItemAvisoDTO> itemsAviso) {
		this.itemsAviso = itemsAviso;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("id: ").append(id);
		description.append(", numero: ").append(numero);
		description.append(", itemsAviso: [").append(toString(itemsAviso)).append("]");
		
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
