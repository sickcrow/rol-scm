/*
 * @(#)DefaultItemAvisoFechaPublicacionComparator.java		1.0 19/11/2013
 */

package ar.com.agea.hub.rol.comparator.impl;

import org.springframework.stereotype.Component;

import ar.com.agea.hub.rol.comparator.ItemAvisoFechaPublicacionComparator;
import ar.com.agea.hub.rol.model.dto.ItemAvisoDTO;

/**
 * Provee una implementación de la interfaz ItemAvisoFechaPublicacionComparator.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 19/11/2013
 */
@Component
public class DefaultItemAvisoFechaPublicacionComparator implements ItemAvisoFechaPublicacionComparator {

	private static final long serialVersionUID = 2115536277131231155L;

	@Override
	public int compare(ItemAvisoDTO first, ItemAvisoDTO second) {
		return first.getAviso().getFechaPedidoPublicacion().compareTo(second.getAviso().getFechaPedidoPublicacion());
	}
}
