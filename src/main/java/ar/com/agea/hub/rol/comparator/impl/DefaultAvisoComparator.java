/*
 * @(#)DefaultAvisoComparator.java		1.0 26/09/2013
 */

package ar.com.agea.hub.rol.comparator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.agea.hub.rol.comparator.AvisoComparator;
import ar.com.agea.hub.rol.comparator.ImagenComparator;
import ar.com.agea.hub.rol.comparator.NivelEstructuraComparator;
import ar.com.agea.hub.rol.comparator.ProductoComercialComparator;
import ar.com.agea.hub.rol.comparator.PromocionComparator;
import ar.com.agea.hub.rol.comparator.ZonaComercializacionComparator;
import ar.com.agea.hub.rol.model.dto.AvisoDTO;
import ar.com.agea.hub.rol.model.dto.AvisoPromocionDTO;
import ar.com.agea.hub.rol.model.dto.ImagenDTO;
import ar.com.agea.hub.rol.model.dto.NivelEstructuraDTO;
import ar.com.agea.hub.rol.model.dto.ProductoComercialDTO;
import ar.com.agea.hub.rol.model.dto.PromocionDTO;
import ar.com.agea.hub.rol.model.dto.ZonaComercializacionDTO;
import ar.com.agea.hub.rol.utils.ComparatorContext;

/**
 * Provee una implementación de la interfaz AvisoComparator.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/09/2013
 */
@Component
public class DefaultAvisoComparator implements AvisoComparator {

	@Autowired
	private ImagenComparator imagenComparator;
	
	@Autowired
	private ProductoComercialComparator productoComercialComparator;
	
	@Autowired
	private NivelEstructuraComparator nivelEstructuraComparator;
	
	@Autowired
	private ZonaComercializacionComparator zonaComercializacionComparator;
	
	@Autowired
	private PromocionComparator promocionComparator;
		
	@Override
	public Boolean compareAvisos(AvisoDTO dtoFirst, AvisoDTO dtoSecond, ComparatorContext context) {
		List<Boolean> result = new ArrayList<Boolean>();

		result.add(dtoFirst.getTipo().equals(dtoSecond.getTipo()));
		result.add(dtoFirst.getFechaPedidoPublicacion().equals(dtoSecond.getFechaPedidoPublicacion()));
		result.add(dtoFirst.getTextoLibre().equals(dtoSecond.getTextoLibre()));
		result.add(dtoFirst.getTextoLibreTemplate().equals(dtoSecond.getTextoLibreTemplate()));
		result.add(dtoFirst.getTextoJustificado().equals(dtoSecond.getTextoJustificado()));
		result.add(dtoFirst.getAltoPuntosTipograficos().equals(dtoSecond.getAltoPuntosTipograficos()));
		result.add(dtoFirst.getLineasFacturadas().equals(dtoSecond.getLineasFacturadas()));
		result.add(dtoFirst.getLineasPublicadas().equals(dtoSecond.getLineasPublicadas()));
		result.add(dtoFirst.getFacturable().equals(dtoSecond.getFacturable()));
		
		if (!result.contains(false)) {
			ImagenDTO imagenFirst = dtoFirst.getPreview();
			ImagenDTO imagenSecond = dtoSecond.getPreview();
			
			result.add(imagenComparator.compareImagenes(imagenFirst, imagenSecond, context));
		}
		
		if (!result.contains(false)) {
			ProductoComercialDTO productoComercialFirst = dtoFirst.getProductoComercial();
			ProductoComercialDTO productoComercialSecond = dtoSecond.getProductoComercial();
			
			result.add(productoComercialComparator.compareProductosComerciales(productoComercialFirst, productoComercialSecond, context));
		}

		if (!result.contains(false)) {
			NivelEstructuraDTO nivelEstructuraFirst = dtoFirst.getNivelEstructura();
			NivelEstructuraDTO nivelEstructuraSecond = dtoSecond.getNivelEstructura();
			
			result.add(nivelEstructuraComparator.compareNivelesEstructura(nivelEstructuraFirst, nivelEstructuraSecond, context));
		}
		
		if (!result.contains(false)) {
			List<ZonaComercializacionDTO> zonasFirst = dtoFirst.getZonasComercializacion();
			List<ZonaComercializacionDTO> zonasSecond = dtoSecond.getZonasComercializacion();
			
			result.add(zonaComercializacionComparator.compareZonasComercializacion(zonasFirst, zonasSecond, context));
		}
		
		if (!result.contains(false)) {
			List<PromocionDTO> promocionesFirst = new ArrayList<PromocionDTO>();
			List<PromocionDTO> promocionesSecond = new ArrayList<PromocionDTO>();
			
			for (AvisoPromocionDTO avisoPromofirst : dtoFirst.getAvisoPromocion()) {
				promocionesFirst.add(avisoPromofirst.getPromocion());
			}

			for (AvisoPromocionDTO avisoPromoSecond : dtoSecond.getAvisoPromocion()) {
				promocionesSecond.add(avisoPromoSecond.getPromocion());
			}
			
			result.add(promocionComparator.comparePromociones(promocionesFirst, promocionesSecond, context));
		}
		
		return !result.contains(false);
	}
}
