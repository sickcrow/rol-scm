/*
 * @(#)ConceptoVendibleComparator.java		1.0 26/09/2013
 */

package ar.com.agea.hub.rol.comparator;

import java.util.List;

import ar.com.agea.hub.rol.model.dto.ConceptoVendibleDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Representa una capa de abstración para comparación de conceptos vendibles.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/09/2013
 */
public interface ConceptoVendibleComparator {

	/**
	 * Compara dos objetos concepto vendible.
	 * 
	 * @param dtoFirst Objeto concepto vendible a comparar con el segundo objeto.
	 * @param dtoSecond Objeto concepto vendible a comparar con el primer objeto.
	 * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	 * @return Objeto resultado comparado.
	 */
	Boolean compareConceptosVendible(ConceptoVendibleDTO dtoFirst, ConceptoVendibleDTO dtoSecond, ComparatorContext context);
	
	/**
	 * Compara mas de dos objetos conceptos vendibles.
	 * 
	 * @param dtosFirst Objetos conceptos vendibles a comparar con el segundo objeto.
	 * @param dtosSecond Objetos conceptos vendibles a comparar con el primer objeto.
	 * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	 * @return Objeto resultado comparado.
	 */
	Boolean compareConceptosVendible(List<ConceptoVendibleDTO> dtosFirst, List<ConceptoVendibleDTO> dtosSecond, ComparatorContext context);
}
