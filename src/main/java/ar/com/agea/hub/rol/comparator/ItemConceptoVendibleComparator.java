/*
 * @(#)ItemConceptoVendibleComparator.java		1.0 26/03/2014
 */

package ar.com.agea.hub.rol.comparator;

import java.util.List;

import ar.com.agea.hub.rol.model.dto.ItemConceptoVendibleDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Representa una capa de abstración para comparación de items conceptos vendibles.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/03/2014
 */
public interface ItemConceptoVendibleComparator {

	/**
	 * Compara dos objetos item concepto vendible.
	 * 
	 * @param dtoFirst Objeto item concepto vendible a comparar con el segundo objeto.
	 * @param dtoSecond Objeto item concepto vendible a comparar con el primer objeto.
	 * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	 * @return Objeto resultado comparado.
	 */
	Boolean compareItemsConceptoVendible(ItemConceptoVendibleDTO dtoFirst, ItemConceptoVendibleDTO dtoSecond, ComparatorContext context);
	
	/**
	 * Compara mas de dos objetos items conceptos vendibles.
	 * 
	 * @param dtosFirst Objetos items conceptos vendibles a comparar con el segundo objeto.
	 * @param dtosSecond Objetos items conceptos vendibles a comparar con el primer objeto.
	 * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	 * @return Objeto resultado comparado.
	 */
	Boolean compareItemsConceptoVendible(List<ItemConceptoVendibleDTO> dtosFirst, List<ItemConceptoVendibleDTO> dtosSecond, ComparatorContext context);
}
