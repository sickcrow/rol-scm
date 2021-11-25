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
 * Provee una implementación de la interfaz PromocionComparator.
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
		 * Agrupa bajo código de promoción dos objetos promoción que coincidan de ambas colecciones
		 * a traves de este código.
		 * 
		 * Se finaliza la agrupación en caso que sucedan los siguientes casos:
		 * 		1. la misma promoción existe más de una vez en la segunda colección.
		 * 		2. el código de la promoción ya existe como key en la colección de agrupación
		 * 		   por existir más de una vez en la primera colección.
		 */
		for (PromocionDTO dtoFirst : dtosFirst) {
			int counter = 0;
			List<PromocionDTO> values = new ArrayList<PromocionDTO>();
			values.add(dtoFirst);
			
			for (PromocionDTO dtoSecond : dtosSecond) {
				if (dtoFirst.getCodigo().equals(dtoSecond.getCodigo())) {
					/*
					 * Si counter es es igual a 1 indica que el objeto promoción en la segunda colección
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
			 * Si mustContinue es false es porque algún objeto promoción de la primera colección
			 * no fue encontrado o fue encontrado más de una vez en la segunda colección.
			 * 
			 * Si el código de promoción existe en la colección zonas como key es porque
			 * la primera colección contiene el mismo objeto promoción más de una vez.
			 */
			if (mustContinue && !promociones.containsKey(dtoFirst.getCodigo())) {
				promociones.put(dtoFirst.getCodigo(), values);
			} else {
				result.add(false);
				break;
			}
		}
		
		/*
		 * Verifica que bajo un código de promoción exista únicamente dos objetos promoción
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
