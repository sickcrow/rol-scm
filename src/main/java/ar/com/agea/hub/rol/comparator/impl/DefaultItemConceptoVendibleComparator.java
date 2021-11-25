/*
 * @(#)DefaultItemConceptoVendibleComparator.java		1.0 26/03/2014
 */

package ar.com.agea.hub.rol.comparator.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.agea.hub.rol.comparator.ItemAvisoComparator;
import ar.com.agea.hub.rol.comparator.ItemConceptoVendibleComparator;
import ar.com.agea.hub.rol.model.dto.ItemConceptoVendibleDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;
import ar.com.agea.hub.rol.utils.ComparatorParameterType;

/**
 * Provee una implementaci�n de la interfaz ItemConceptoVendibleComparator.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/03/2014
 */
@Component
public class DefaultItemConceptoVendibleComparator implements ItemConceptoVendibleComparator {

	@Autowired
	private ItemAvisoComparator itemAvisoComparator;
	
	@Override
	public Boolean compareItemsConceptoVendible(ItemConceptoVendibleDTO dtoFirst, ItemConceptoVendibleDTO dtoSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();

		result.add(dtoFirst.getNumero().equals(dtoSecond.getNumero()));
		
		if (!result.contains(false)) {
			result.add(itemAvisoComparator.compareItemsAviso(dtoFirst.getItemsAviso(), dtoSecond.getItemsAviso(), context));
		}
		
		return !result.contains(false);
	}

	@Override
	public Boolean compareItemsConceptoVendible(List<ItemConceptoVendibleDTO> dtosFirst, List<ItemConceptoVendibleDTO> dtosSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();
		
		/*
		 * Verifica que ambas colecciones tengan la misma cantidad de elementos.
		 */
		result.add(dtosFirst.size() == dtosSecond.size());

		Map<Long, List<ItemConceptoVendibleDTO>> itemsConceptosVendibles = new HashMap<Long, List<ItemConceptoVendibleDTO>>();

		boolean mustContinue = false;
		
		/*
		 * Agrupa bajo n�mero de item concepto vendible dos objetos item concepto vendible que coincidan de ambas colecciones
		 * a traves de este c�digo.
		 * 
		 * Se finaliza la agrupaci�n en caso que sucedan los siguientes casos:
		 * 		1. el mismo item concepto vendible existe m�s de una vez en la segunda colecci�n.
		 * 		2. el n�mero del item concepto vendible ya existe como key en la colecci�n de agrupaci�n
		 * 		   por existir m�s de una vez en la primera colecci�n.
		 */
		for (ItemConceptoVendibleDTO dtoFirst : dtosFirst) {
			int counter = 0;
			List<ItemConceptoVendibleDTO> values = new ArrayList<ItemConceptoVendibleDTO>();
			values.add(dtoFirst);
			
			for (ItemConceptoVendibleDTO dtoSecond : dtosSecond) {
				if (dtoFirst.getNumero().equals(dtoSecond.getNumero())) {
					/*
					 * Si counter es es igual a 1 indica que el objeto item concepto vendible en la segunda colecci�n
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
			 * Si mustContinue es false es porque alg�n objeto item concepto vendible de la primera colecci�n
			 * no fue encontrado o fue encontrado m�s de una vez en la segunda colecci�n.
			 * 
			 * Si el n�mero de item concepto vendible existe en la colecci�n zonas como key es porque
			 * la primera colecci�n contiene el mismo objeto item concepto vendible m�s de una vez.
			 */
			if (mustContinue && !itemsConceptosVendibles.containsKey(dtoFirst.getNumero())) {
				itemsConceptosVendibles.put(dtoFirst.getNumero(), values);
			} else {
				result.add(false);
				break;
			}
		}

		/*
		 * Verifica que bajo un n�mero de item concepto vendible exista �nicamente dos objetos item concepto vendible
		 * y posteriormente compara su contenido que lo define como el mismo objeto.
		 */
		if (mustContinue) {
			for (Map.Entry<Long, List<ItemConceptoVendibleDTO>> entries : itemsConceptosVendibles.entrySet()) {
				if (entries.getValue().size() == 2) {
					Iterator<ItemConceptoVendibleDTO> iterator = entries.getValue().iterator();

					result.add(compareItemsConceptoVendible(iterator.next(), iterator.next(), context));
				} else {
					result.add(false);
				}
			}

			/*
			 * Verifica que si el contexto tiene el par�metro promocion repite salida y es true la cantidad
			 * de items avisos sea mayor a 1, caso contrario se trata de un solo aviso con promoci�n
			 * eco frecuencia adulterada.
			 */
			if (context.contains(ComparatorParameterType.PROMOCION_REPITE_SALIDA)
					&& (Boolean) context.getParameter(ComparatorParameterType.PROMOCION_REPITE_SALIDA)
					&& !(dtosFirst.iterator().next().getItemsAviso().size() > 1)) {
				result.add(false);
			}
		}
		
		return !result.contains(false);
	}
}
