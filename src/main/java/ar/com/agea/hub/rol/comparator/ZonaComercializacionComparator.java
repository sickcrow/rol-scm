/*
 * @(#)ZonaComercializacionComparator.java		1.0 10/02/2014
 */

package ar.com.agea.hub.rol.comparator;

import java.util.List;

import ar.com.agea.hub.rol.model.dto.ZonaComercializacionDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;


/**
 * Representa una capa de abstración para comparación de zonas comercialización.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/02/2014
 */
public interface ZonaComercializacionComparator {

	/**
	 * Compara dos objetos zona comercialización.
	 * 
	 * @param dtoFirst Objeto zona comercialización a comparar con el segundo objeto.
	 * @param dtoSecond Objeto zona comercialización a comparar con el primer objeto.
	 * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	 * @return Objeto resultado comparado.
	 */
	Boolean compareZonasComercializacion(ZonaComercializacionDTO dtoFirst, ZonaComercializacionDTO dtoSecond, ComparatorContext context);
	
	/**
	 * Compara mas de dos objetos zona comercialización.
	 * 
	 * @param dtosFirst Objetos zonas comercialización a comparar con el segundo objeto.
	 * @param dtosSecond Objetos zonas comercialización a comparar con el primer objeto.
	 * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	 * @return Objeto resultado comparado.
	 */
	Boolean compareZonasComercializacion(List<ZonaComercializacionDTO> dtosFirst, List<ZonaComercializacionDTO> dtosSecond, ComparatorContext context);
}
