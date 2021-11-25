/*
 * @(#)AvisoComparator.java		1.0 26/09/2013
 */

package ar.com.agea.hub.rol.comparator;

import ar.com.agea.hub.rol.model.dto.AvisoDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Representa una capa de abstración para comparación de avisos.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/09/2013
 */
public interface AvisoComparator {

	/**
	 * Compara dos objetos aviso.
	 * 
	 * @param dtoFirst Objeto aviso a comparar con el segundo objeto.
	 * @param dtoSecond Objeto aviso a comparar con el primer objeto.
	 * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	 * @return Objeto resultado comparado.
	 */
	Boolean compareAvisos(AvisoDTO dtoFirst, AvisoDTO dtoSecond, ComparatorContext context);
}
