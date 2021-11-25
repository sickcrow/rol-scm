/*
 * @(#)DefaultItemAvisoComparator.java		1.0 26/03/2014
 */

package ar.com.agea.hub.rol.comparator.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.agea.hub.rol.comparator.AvisoComparator;
import ar.com.agea.hub.rol.comparator.ItemAvisoComparator;
import ar.com.agea.hub.rol.model.dto.ItemAvisoDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Provee una implementaci�n de la interfaz ItemAvisoComparator.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/03/2014
 */
@Component
public class DefaultItemAvisoComparator implements ItemAvisoComparator {

	@Autowired
	private AvisoComparator avisoComparator;
	
	@Override
	public Boolean compareItemsAviso(ItemAvisoDTO dtoFirst, ItemAvisoDTO dtoSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();

		result.add(dtoFirst.getNumero().equals(dtoSecond.getNumero()));
	
		if (!result.contains(false)) {
			result.add(avisoComparator.compareAvisos(dtoFirst.getAviso(), dtoSecond.getAviso(), context));
		}
		
		return !result.contains(false);
	}

	@Override
	public Boolean compareItemsAviso(List<ItemAvisoDTO> dtosFirst, List<ItemAvisoDTO> dtosSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();
		
		/*
		 * Verifica que ambas colecciones tengan la misma cantidad de elementos.
		 */
		result.add(dtosFirst.size() == dtosSecond.size());

		Map<Long, List<ItemAvisoDTO>> itemsAviso = new HashMap<Long, List<ItemAvisoDTO>>();

		boolean mustContinue = false;
		
		/*
		 * Agrupa bajo n�mero de item aviso dos objetos item aviso que coincidan de ambas colecciones
		 * a traves de este c�digo.
		 * 
		 * Se finaliza la agrupaci�n en caso que sucedan los siguientes casos:
		 * 		1. el mismo item aviso existe m�s de una vez en la segunda colecci�n.
		 * 		2. el n�mero del item aviso ya existe como key en la colecci�n de agrupaci�n
		 * 		   por existir m�s de una vez en la primera colecci�n.
		 */
		for (ItemAvisoDTO dtoFirst : dtosFirst) {
			int counter = 0;
			List<ItemAvisoDTO> values = new ArrayList<ItemAvisoDTO>();
			values.add(dtoFirst);
			
			for (ItemAvisoDTO dtoSecond : dtosSecond) {
				if (dtoFirst.getNumero().equals(dtoSecond.getNumero())) {
					/*
					 * Si counter es es igual a 1 indica que el objeto item aviso en la segunda colecci�n
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
			 * Si mustContinue es false es porque alg�n objeto item aviso de la primera colecci�n
			 * no fue encontrado o fue encontrado m�s de una vez en la segunda colecci�n.
			 * 
			 * Si el n�mero de item aviso existe en la colecci�n zonas como key es porque
			 * la primera colecci�n contiene el mismo objeto item aviso m�s de una vez.
			 */
			if (mustContinue && !itemsAviso.containsKey(dtoFirst.getNumero())) {
				itemsAviso.put(dtoFirst.getNumero(), values);
			} else {
				result.add(false);
				break;
			}
		}
		
		/*
		 * Verifica que bajo un n�mero de item aviso exista �nicamente dos objetos item aviso
		 * y posteriormente compara su contenido que lo define como el mismo objeto.
		 */
		if (mustContinue) {
			for (Map.Entry<Long, List<ItemAvisoDTO>> entries : itemsAviso.entrySet()) {
				if (entries.getValue().size() == 2) {
					Iterator<ItemAvisoDTO> iterator = entries.getValue().iterator();
					
					result.add(compareItemsAviso(iterator.next(), iterator.next(), context));
				} else {
					result.add(false);
				}
			}
		}
		
		return !result.contains(false);
	}
}
