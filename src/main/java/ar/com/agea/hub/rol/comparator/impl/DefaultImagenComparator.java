/*
 * @(#)DefaultImagenComparator.java		1.0 26/09/2013
 */

package ar.com.agea.hub.rol.comparator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.agea.hub.rol.comparator.ImagenComparator;
import ar.com.agea.hub.rol.model.dto.ImagenDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Provee una implementación de la interfaz ImagenComparator.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/09/2013
 */
@Component
public class DefaultImagenComparator implements ImagenComparator {

	@Override
	public Boolean compareImagenes(ImagenDTO dtoFirst, ImagenDTO dtoSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();

		result.add(dtoFirst.getTipo().equals(dtoSecond.getTipo()));
		result.add(dtoFirst.getContenido().equals(dtoSecond.getContenido()));
		
		return !result.contains(false);
	}
}
