/*
 * @(#)ItemAvisoFechaPublicacionComparator.java		1.0 19/11/2013
 */

package ar.com.agea.hub.rol.comparator;

import java.io.Serializable;
import java.util.Comparator;

import ar.com.agea.hub.rol.model.dto.ItemAvisoDTO;

/**
 * Representa una capa de abstración para comparación de ítems avisos por fecha publicación.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 19/11/2013
 */
public interface ItemAvisoFechaPublicacionComparator extends Comparator<ItemAvisoDTO>, Serializable {
}
