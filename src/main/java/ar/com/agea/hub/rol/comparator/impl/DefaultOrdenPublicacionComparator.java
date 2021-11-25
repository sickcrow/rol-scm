/*
 * @(#)DefaultOrdenPublicacionComparator.java		1.0 26/09/2013
 */

package ar.com.agea.hub.rol.comparator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.agea.hub.rol.comparator.ConceptoVendibleComparator;
import ar.com.agea.hub.rol.comparator.OrdenPublicacionComparator;
import ar.com.agea.hub.rol.model.dto.OrdenPublicacionDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Provee una implementación de la interfaz OrdenPublicacionComparator.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/09/2013
 */
@Component
public class DefaultOrdenPublicacionComparator implements OrdenPublicacionComparator {

	@Autowired
	private ConceptoVendibleComparator conceptoVendibleComparator;
	
	@Override
	public Boolean compareOrdenesPublicacion(OrdenPublicacionDTO dtoFirst, OrdenPublicacionDTO dtoSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();
		
		result.add(dtoFirst.getUuidGenerarOrden().equals(dtoSecond.getUuidGenerarOrden()));
		
		if (!result.contains(false)) {
			result.add(conceptoVendibleComparator.compareConceptosVendible(dtoFirst.getConceptosVendibles(), dtoSecond.getConceptosVendibles(), null));
		}
		
		return !result.contains(false);
	}
}
