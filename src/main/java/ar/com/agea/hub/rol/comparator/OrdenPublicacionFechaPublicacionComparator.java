/*
 * @(#)OrdenPublicacionFechaPublicacionComparator.java		1.0 19/11/2013
 */

package ar.com.agea.hub.rol.comparator;

import java.io.Serializable;
import java.util.Comparator;

import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;

/**
 * Representa una capa de abstración para comparación de ordenes publicación por fecha publicación.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 19/11/2013
 */
public interface OrdenPublicacionFechaPublicacionComparator extends Comparator<OrdenPublicacionDTO>, Serializable {
}
