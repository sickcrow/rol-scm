/*
 * @(#)ImagenComparator.java		1.0 26/09/2013
 */

package ar.com.agea.hub.rol.comparator;

import ar.com.agea.hub.rol.model.dto.ImagenDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Representa una capa de abstración para comparación de imágenes.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/09/2013
 */
public interface ImagenComparator {

	/**
	 * Compara dos objetos imagen.
	 * 
	 * @param dtoFirst Objeto imagen a comparar con el segundo objeto.
	 * @param dtoSecond Objeto imagen a comparar con el primer objeto.
	 * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	 * @return Objeto resultado comparado.
	 */
	Boolean compareImagenes(ImagenDTO dtoFirst, ImagenDTO dtoSecond, ComparatorContext context);
}
