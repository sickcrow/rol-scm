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
 * Provee una implementaci�n de la interfaz ZonaComercializacionComparator.
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
		 * Agrupa bajo c�digo de zona comercializaci�n dos objetos zona comercializaci�n que coincidan de ambas colecciones
		 * a traves de este c�digo.
		 * 
		 * Se finaliza la agrupaci�n en caso que sucedan los siguientes casos:
		 * 		1. la misma zona comercializaci�n existe m�s de una vez en la segunda colecci�n.
		 * 		2. el c�digo de la zona comercializaci�n ya existe como key en la colecci�n de agrupaci�n
		 * 		   por existir m�s de una vez en la primera colecci�n.
		 */
		for (ZonaComercializacionDTO dtoFirst : dtosFirst) {
			int counter = 0;
			List<ZonaComercializacionDTO> values = new ArrayList<ZonaComercializacionDTO>();
			values.add(dtoFirst);
			
			for (ZonaComercializacionDTO dtoSecond : dtosSecond) {
				if (dtoFirst.getCodigo().equals(dtoSecond.getCodigo())) {
					/*
					 * Si counter es es igual a 1 indica que el objeto zona comercializaci�n en la segunda colecci�n
					 * fue encontrado m�s de una vez.
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
			 * Si mustContinue es false es porque alg�n objeto zona comercializaci�n de la primera colecci�n
			 * no fue encontrado o fue encontrado m�s de una vez en la segunda colecci�n.
			 * 
			 * Si el c�digo de zona comercializaci�n existe en la colecci�n zonas como key es porque
			 * la primera colecci�n contiene el mismo objeto zona comercializaci�n m�s de una vez.
			 */
			if (mustContinue && !zonas.containsKey(dtoFirst.getCodigo())) {
				zonas.put(dtoFirst.getCodigo(), values);
			} else {
				result.add(false);
				break;
			}
		}
		
		/*
		 * Verifica que bajo un c�digo de zona comercializaci�n exista �nicamente dos objetos zona comercializaci�n
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
