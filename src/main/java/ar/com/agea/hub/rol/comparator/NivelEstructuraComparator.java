/*
 * @(#)NivelEstructuraComparator.java		1.0 26/03/2014
 */

package ar.com.agea.hub.rol.comparator;

import ar.com.agea.hub.rol.model.dto.NivelEstructuraDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Representa una capa de abstración para comparación de niveles de estructuras.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/03/2014
 */
public interface NivelEstructuraComparator {

	/**
	 * Compara dos objetos nivel estructura.
	 * 
	 * @param dtoFirst Objeto producto comercial a comparar con el segundo objeto.
	 * @param dtoSecond Objeto producto comercial a comparar con el primer objeto.
	 * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	 * @return Objeto resultado comparado.
	 */
	Boolean compareNivelesEstructura(NivelEstructuraDTO dtoFirst, NivelEstructuraDTO dtoSecond, ComparatorContext context);
}
