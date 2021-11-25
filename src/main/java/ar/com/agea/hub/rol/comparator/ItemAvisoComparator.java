/*
 * @(#)ItemAvisoComparator.java		1.0 26/03/2014
 */

package ar.com.agea.hub.rol.comparator;

import java.util.List;

import ar.com.agea.hub.rol.model.dto.ItemAvisoDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Representa una capa de abstración para comparación de items avisos.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/03/2014
 */
public interface ItemAvisoComparator {

	 /**
	  * Compara dos objetos item aviso.
	  * 
	  * @param dtoFirst Objeto item aviso a comparar con el segundo objeto.
	  * @param dtoSecond Objeto item aviso a comparar con el primer objeto.
	  * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	  * @return Objeto resultado comparado.
	  */
	Boolean compareItemsAviso(ItemAvisoDTO dtoFirst, ItemAvisoDTO dtoSecond, ComparatorContext context);
	
	 /**
	  * Compara mas de dos objetos items avisos.
	  * 
	  * @param dtosFirst Objetos items avisos a comparar con el segundo objeto.
	  * @param dtosSecond Objetos items avisos a comparar con el primer objeto.
	  * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	  * @return Objeto resultado comparado.
	  */
	Boolean compareItemsAviso(List<ItemAvisoDTO> dtosFirst, List<ItemAvisoDTO> dtosSecond, ComparatorContext context);
}
