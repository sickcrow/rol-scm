/*
 * @(#)OrdenPublicacionComparator.java		1.0 26/09/2013
 */

package ar.com.agea.hub.rol.comparator;

import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Representa una capa de abstraci�n para comparaci�n de ordenes publicaci�n.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/09/2013
 */
public interface OrdenPublicacionComparator {

	/**
	 * Compara dos objetos orden publicaci�n.
	 * 
	 * @param dtoFirst Objeto orden publicaci�n a comparar con el segundo objeto.
	 * @param dtoSecond Objeto orden publicaci�n a comparar con el primer objeto.
	 * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	 * @return Objeto resultado comparado.
	 */
	Boolean compareOrdenesPublicacion(OrdenPublicacionDTO dtoFirst, OrdenPublicacionDTO dtoSecond, ComparatorContext context);
}
