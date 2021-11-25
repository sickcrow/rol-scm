/*
 * @(#)DefaultPromocionComparator.java		1.0 10/02/2014
 */

package ar.com.agea.hub.rol.comparator.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import ar.com.agea.hub.rol.comparator.PromocionComparator;
import ar.com.agea.hub.rol.model.dto.PromocionDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;
import ar.com.agea.hub.rol.utils.ComparatorParameterType;

/**
 * Provee una implementaci�n de la interfaz PromocionComparator.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 10/02/2014
 */
@Component
public class DefaultPromocionComparator implements PromocionComparator {

	@Override
	public Boolean comparePromociones(PromocionDTO dtoFirst, PromocionDTO dtoSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();
		
		result.add(dtoFirst.getCodigo().equals(dtoSecond.getCodigo()));

		if (dtoFirst.getRepiteSalida()) {
			context.putParameter(ComparatorParameterType.PROMOCION_REPITE_SALIDA, dtoFirst.getRepiteSalida());
		}
		
		return !result.contains(false);
	}

	@Override
	public Boolean comparePromociones(List<PromocionDTO> dtosFirst, List<PromocionDTO> dtosSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();
		
		result.add(dtosFirst.size() == dtosSecond.size());

		Map<String, List<PromocionDTO>> promociones = new HashMap<String, List<PromocionDTO>>();

		boolean mustContinue = false;
		
		/*
		 * Agrupa bajo c�digo de promoci�n dos objetos promoci�n que coincidan de ambas colecciones
		 * a traves de este c�digo.
		 * 
		 * Se finaliza la agrupaci�n en caso que sucedan los siguientes casos:
		 * 		1. la misma promoci�n existe m�s de una vez en la segunda colecci�n.
		 * 		2. el c�digo de la promoci�n ya existe como key en la colecci�n de agrupaci�n
		 * 		   por existir m�s de una vez en la primera colecci�n.
		 */
		for (PromocionDTO dtoFirst : dtosFirst) {
			int counter = 0;
			List<PromocionDTO> values = new ArrayList<PromocionDTO>();
			values.add(dtoFirst);
			
			for (PromocionDTO dtoSecond : dtosSecond) {
				if (dtoFirst.getCodigo().equals(dtoSecond.getCodigo())) {
					/*
					 * Si counter es es igual a 1 indica que el objeto promoci�n en la segunda colecci�n
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
			 * Si mustContinue es false es porque alg�n objeto promoci�n de la primera colecci�n
			 * no fue encontrado o fue encontrado m�s de una vez en la segunda colecci�n.
			 * 
			 * Si el c�digo de promoci�n existe en la colecci�n zonas como key es porque
			 * la primera colecci�n contiene el mismo objeto promoci�n m�s de una vez.
			 */
			if (mustContinue && !promociones.containsKey(dtoFirst.getCodigo())) {
				promociones.put(dtoFirst.getCodigo(), values);
			} else {
				result.add(false);
				break;
			}
		}
		
		/*
		 * Verifica que bajo un c�digo de promoci�n exista �nicamente dos objetos promoci�n
		 * y posteriormente compara su contenido que lo define como el mismo objeto.
		 */
		if (mustContinue) {
			for (Map.Entry<String, List<PromocionDTO>> entries : promociones.entrySet()) {
				if (entries.getValue().size() == 2) {
					Iterator<PromocionDTO> iterator = entries.getValue().iterator();
					
					result.add(comparePromociones(iterator.next(), iterator.next(), context));
				} else {
					result.add(false);
				}
			}
		}
		
		return !result.contains(false);
	}
}
