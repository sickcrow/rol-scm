/*
 * @(#)DefaultConceptoVendibleComparator.java		1.0 26/09/2013
 */

package ar.com.agea.hub.rol.comparator.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.agea.hub.rol.comparator.ConceptoVendibleComparator;
import ar.com.agea.hub.rol.comparator.ItemConceptoVendibleComparator;
import ar.com.agea.hub.rol.model.dto.ConceptoVendibleDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Provee una implementación de la interfaz ConceptoVendibleComparator.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/09/2013
 */
@Component
public class DefaultConceptoVendibleComparator implements ConceptoVendibleComparator {

	@Autowired
	private ItemConceptoVendibleComparator itemConceptoVendibleComparator;
	
	@Override
	public Boolean compareConceptosVendible(ConceptoVendibleDTO dtoFirst, ConceptoVendibleDTO dtoSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();
		
		result.add(dtoFirst.getFechaTarifa().equals(dtoSecond.getFechaTarifa()));
		result.add(dtoFirst.getPorcentajeIVA().equals(dtoSecond.getPorcentajeIVA()));
		result.add(dtoFirst.getMontoSinIVA().equals(dtoSecond.getMontoSinIVA()));
		result.add(dtoFirst.getMontoIVA().equals(dtoSecond.getMontoIVA()));
		result.add(dtoFirst.getMontoPercepcion().equals(dtoSecond.getMontoPercepcion()));
		result.add(dtoFirst.getMontoTotal().equals(dtoSecond.getMontoTotal()));
		
		if (!result.contains(false)) {
			result.add(itemConceptoVendibleComparator.compareItemsConceptoVendible(dtoFirst.getItemsConceptoVendible(), dtoSecond.getItemsConceptoVendible(), context));
		}
		
		return !result.contains(false);
	}

	@Override
	public Boolean compareConceptosVendible(List<ConceptoVendibleDTO> dtosFirst, List<ConceptoVendibleDTO> dtosSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();
		
		/*
		 * Verifica que ambas colecciones tengan la misma cantidad de elementos.
		 */
		result.add(dtosFirst.size() == dtosSecond.size());

		Map<Date, List<ConceptoVendibleDTO>> conceptosVendibles = new HashMap<Date, List<ConceptoVendibleDTO>>();

		boolean mustContinue = false;
		
		/*
		 * Agrupa bajo fecha tarifa de concepto vendible dos objetos concepto vendible que coincidan de ambas colecciones
		 * a traves de este fecha tarifa.
		 * 
		 * Se finaliza la agrupación en caso que sucedan los siguientes casos:
		 * 		1. el mismo concepto vendible existe más de una vez en la segunda colección.
		 * 		2. la fecha tarifa del concepto vendible ya existe como key en la colección de agrupación
		 * 		   por existir más de una vez en la primera colección.
		 */
		for (ConceptoVendibleDTO dtoFirst : dtosFirst) {
			int counter = 0;
			List<ConceptoVendibleDTO> values = new ArrayList<ConceptoVendibleDTO>();
			values.add(dtoFirst);
			
			for (ConceptoVendibleDTO dtoSecond : dtosSecond) {
				if (dtoFirst.getFechaTarifa().equals(dtoSecond.getFechaTarifa())) {
					/*
					 * Si counter es es igual a 1 indica que el objeto concepto vendible en la segunda colección
					 * fue encontrado más de una vez.
					 */
					if (counter == 1) {
						mustContinue = false;
						break;
					} else {
						values.add(dtoSecond);
						mustContinue = true;
						counter++;
					}
				}
			}

			/*
			 * Si mustContinue es false es porque algún objeto concepto vendible de la primera colección
			 * no fue encontrado o fue encontrado más de una vez en la segunda colección.
			 * 
			 * Si la fecha tarifa de concepto vendible existe en la colección zonas como key es porque
			 * la primera colección contiene el mismo objeto concepto vendible más de una vez.
			 */
			if (mustContinue && !conceptosVendibles.containsKey(dtoFirst.getFechaTarifa())) {
				conceptosVendibles.put(dtoFirst.getFechaTarifa(), values);
			} else {
				result.add(false);
				break;
			}
		}
		
		/*
		 * Verifica que bajo una fecha tarifa de concepto vendible exista únicamente dos objetos concepto vendible
		 * y posteriormente compara su contenido que lo define como el mismo objeto.
		 */
		if (mustContinue) {
			for (Map.Entry<Date, List<ConceptoVendibleDTO>> entries : conceptosVendibles.entrySet()) {
				if (entries.getValue().size() == 2) {
					Iterator<ConceptoVendibleDTO> iterator = entries.getValue().iterator();
					
					result.add(compareConceptosVendible(iterator.next(), iterator.next(), context));
				} else {
					result.add(false);
				}
			}
		}
		
		return !result.contains(false);
	}
}
