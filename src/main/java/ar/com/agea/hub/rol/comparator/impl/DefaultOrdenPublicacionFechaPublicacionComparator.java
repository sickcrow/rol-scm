/*
 * @(#)DefaultAvisoComparator.java		1.0 19/11/2013
 */

package ar.com.agea.hub.rol.comparator.impl;

import org.springframework.stereotype.Component;

import ar.com.agea.hub.rol.comparator.OrdenPublicacionFechaPublicacionComparator;
import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;

/**
 * Provee una implementación de la interfaz OrdenPublicacionFechaPublicacionComparator.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 19/11/2013
 */
@Component
public class DefaultOrdenPublicacionFechaPublicacionComparator implements OrdenPublicacionFechaPublicacionComparator {

	private static final long serialVersionUID = -2415729757289799558L;

	@Override
	public int compare(OrdenPublicacionDTO first, OrdenPublicacionDTO second) {
		return second.getId().compareTo(first.getId());
	}
}
