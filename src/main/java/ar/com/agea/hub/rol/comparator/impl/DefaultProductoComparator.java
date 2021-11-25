/*
 * @(#)DefaultProductoComparator.java		1.0 10/02/2014
 */

package ar.com.agea.hub.rol.comparator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.agea.hub.rol.comparator.ProductoComparator;
import ar.com.agea.hub.rol.model.dto.ProductoDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Provee una implementación de la interfaz ProductoComparator.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/02/2014
 */
@Component
public class DefaultProductoComparator implements ProductoComparator {

	@Override
	public Boolean compareProductos(ProductoDTO dtoFirst, ProductoDTO dtoSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();

		result.add(dtoFirst.getTipo().equals(dtoSecond.getTipo()));
		result.add(dtoFirst.getCodigo().equals(dtoSecond.getCodigo()));
		
		return !result.contains(false);
	}
}
