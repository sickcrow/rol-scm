/*
 * @(#)DefaultZonaComercializacionComparator.java		1.0 10/02/2014
 */

package ar.com.agea.hub.rol.comparator.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import ar.com.agea.hub.rol.comparator.ZonaComercializacionComparator;
import ar.com.agea.hub.rol.model.dto.ZonaComercializacionDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Provee una implementación de la interfaz ZonaComercializacionComparator.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/02/2014
 */
@Component
public class DefaultZonaComercializacionComparator implements ZonaComercializacionComparator {

	@Override
	public Boolean compareZonasComercializacion(ZonaComercializacionDTO dtoFirst, ZonaComercializacionDTO dtoSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();

		result.add(dtoFirst.getCodigo().equals(dtoSecond.getCodigo()));
		
		return !result.contains(false);
	}

	@Override
	public Boolean compareZonasComercializacion(List<ZonaComercializacionDTO> dtosFirst, List<ZonaComercializacionDTO> dtosSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();
		
		/*
		 * Verifica que ambas colecciones tengan la misma cantidad de elementos.
		 */
		result.add(dtosFirst.size() == dtosSecond.size());

		Map<String, List<ZonaComercializacionDTO>> zonas = new HashMap<String, List<ZonaComercializacionDTO>>();

		boolean mustContinue = false;
		
		/*
		 * Agrupa bajo código de zona comercialización dos objetos zona comercialización que coincidan de ambas colecciones
		 * a traves de este código.
		 * 
		 * Se finaliza la agrupación en caso que sucedan los siguientes casos:
		 * 		1. la misma zona comercialización existe más de una vez en la segunda colección.
		 * 		2. el código de la zona comercialización ya existe como key en la colección de agrupación
		 * 		   por existir más de una vez en la primera colección.
		 */
		for (ZonaComercializacionDTO dtoFirst : dtosFirst) {
			int counter = 0;
			List<ZonaComercializacionDTO> values = new ArrayList<ZonaComercializacionDTO>();
			values.add(dtoFirst);
			
			for (ZonaComercializacionDTO dtoSecond : dtosSecond) {
				if (dtoFirst.getCodigo().equals(dtoSecond.getCodigo())) {
					/*
					 * Si counter es es igual a 1 indica que el objeto zona comercialización en la segunda colección
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
			 * Si mustContinue es false es porque algún objeto zona comercialización de la primera colección
			 * no fue encontrado o fue encontrado más de una vez en la segunda colección.
			 * 
			 * Si el código de zona comercialización existe en la colección zonas como key es porque
			 * la primera colección contiene el mismo objeto zona comercialización más de una vez.
			 */
			if (mustContinue && !zonas.containsKey(dtoFirst.getCodigo())) {
				zonas.put(dtoFirst.getCodigo(), values);
			} else {
				result.add(false);
				break;
			}
		}
		
		/*
		 * Verifica que bajo un código de zona comercialización exista únicamente dos objetos zona comercialización
		 * y posteriormente compara su contenido que lo define como el mismo objeto.
		 */
		if (mustContinue) {
			for (Map.Entry<String, List<ZonaComercializacionDTO>> entries : zonas.entrySet()) {
				if (entries.getValue().size() == 2) {
					Iterator<ZonaComercializacionDTO> iterator = entries.getValue().iterator();
					
					result.add(compareZonasComercializacion(iterator.next(), iterator.next(), context));
				} else {
					result.add(false);
				}
			}
		}
		
		return !result.contains(false);
	}
}
