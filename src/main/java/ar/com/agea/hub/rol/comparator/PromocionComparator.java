/*
 * @(#)PromocionComparator.java		1.0 10/02/2014
 */

package ar.com.agea.hub.rol.comparator;

import java.util.List;

import ar.com.agea.hub.rol.model.dto.PromocionDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;


/**
 * Representa una capa de abstraci�n para comparaci�n de promociones.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/02/2014
 */
public interface PromocionComparator {

	/**
	 * Compara dos objetos promoci�n.
	 * 
	 * @param dtoFirst Objeto promoci�n a comparar con el segundo objeto.
	 * @param dtoSecond Objeto promoci�n a comparar con el primer objeto.
	 * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	 * @return Objeto resultado comparado.
	 */
	Boolean comparePromociones(PromocionDTO dtoFirst, PromocionDTO dtoSecond, ComparatorContext context);
	
	/**
	 * Compara mas de dos objetos promoci�n.
	 * 
	 * @param dtosFirst Objetos promociones a comparar con el segundo objeto.
	 * @param dtosSecond Objetos promociones a comparar con el primer objeto.
	 * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	 * @return Objeto resultado comparado.
	 */
	Boolean comparePromociones(List<PromocionDTO> dtosFirst, List<PromocionDTO> dtosSecond, ComparatorContext context);
}
