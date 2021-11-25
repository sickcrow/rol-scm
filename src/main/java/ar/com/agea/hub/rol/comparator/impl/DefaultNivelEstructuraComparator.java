/*
 * @(#)DefaultNivelEstructuraComparator.java		1.0 26/03/2014
 */

package ar.com.agea.hub.rol.comparator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.com.agea.hub.rol.comparator.NivelEstructuraComparator;
import ar.com.agea.hub.rol.model.dto.NivelEstructuraDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Provee una implementación de la interfaz NivelEstructuraComparator.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/03/2014
 */
@Component
public class DefaultNivelEstructuraComparator implements NivelEstructuraComparator {

	@Override
	public Boolean compareNivelesEstructura(NivelEstructuraDTO dtoFirst, NivelEstructuraDTO dtoSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();

		result.add(dtoFirst.getTipo().equals(dtoSecond.getTipo()));
		result.add(dtoFirst.getCodigo().equals(dtoSecond.getCodigo()));
		
		return !result.contains(false);
	}
}
