/*
 * @(#)ProductoComparator.java		1.0 10/02/2014
 */

package ar.com.agea.hub.rol.comparator;

import ar.com.agea.hub.rol.model.dto.ProductoDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;


/**
 * Representa una capa de abstración para comparación de productos.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/02/2014
 */
public interface ProductoComparator {

	/**
	 * Compara dos objetos producto.
	 * 
	 * @param dtoFirst Objeto producto a comparar con el segundo objeto.
	 * @param dtoSecond Objeto producto a comparar con el primer objeto.
	 * @param context Objeto contexto para realizar tratamnientos particulares en las comparaciones en caso de ser necesario.
	 * @return Objeto resultado comparado.
	 */
	Boolean compareProductos(ProductoDTO dtoFirst, ProductoDTO dtoSecond, ComparatorContext context);
}
