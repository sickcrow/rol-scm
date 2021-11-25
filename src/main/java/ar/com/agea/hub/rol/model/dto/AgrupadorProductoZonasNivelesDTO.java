/*
 * @(#)AgrupadorProductoZonasNivelesDTO.java	1.0 30/08/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos agrupadores de producto,
 * niveles de estructuras y zonas comercialización.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación.
 * 
 * @author		Alejandro Di Fiore
 * @version		1.0 30/08/2013
 */
public class AgrupadorProductoZonasNivelesDTO implements JSONDTO {

	private static final long serialVersionUID = -3627953778495189254L;
	
	private ProductoDTO producto;
	private List<ZonaComercializacionDTO> zonasComercializacion;
	private List<AgrupadorProductoComercialNivelDTO> agrupadoresProductoComercialNivel;
		
	/**
	 * Instancia un objeto de tipo AgrupadorProductoZonasNivelesDTO.
	 */
	public AgrupadorProductoZonasNivelesDTO() {				
		zonasComercializacion = new ArrayList<ZonaComercializacionDTO>();
		agrupadoresProductoComercialNivel = new ArrayList<AgrupadorProductoComercialNivelDTO>(); 
	}
	
	/**
	 * Obtiene el objeto producto de este DTO. 
	 * 
	 * @return Objeto producto de este DTO.
	 */
	public ProductoDTO getProducto() {
		return producto;
	}

	/**
	 * Setea el objeto producto de este DTO.
	 * 
	 * @param producto Objeto producto de este DTO.
	 */
	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}

	/**
	 * Obtiene los objetos zonas comercialización de este DTO. 
	 * 
	 * @return Objetos zonas comercialización de este DTO.
	 */
	public List<ZonaComercializacionDTO> getZonasComercializacion() {
		return zonasComercializacion;
	}

	/**
	 * Setea los objetos zonas comercialización de este DTO.
	 * 
	 * @param zonasComercializacion Objetos zonas comercialización de este DTO.
	 */
	public void setZonasComercializacion(List<ZonaComercializacionDTO> zonasComercializacion) {
		this.zonasComercializacion = zonasComercializacion;
	}
	
	/**
	 * Obtiene los objetos agrupadores producto comercial nivel de este DTO. 
	 * 
	 * @return Objetos agrupadores producto comercial nivel de este DTO.
	 */
	public List<AgrupadorProductoComercialNivelDTO> getAgrupadoresProductoComercialNivel() {
		return agrupadoresProductoComercialNivel;
	}
	
	/**
	 * Setea los objetos agrupadores producto comercial nivel de este DTO.
	 * 
	 * @param agrupadoresProductoComercialNivel Objetos agrupadores producto comercial nivel de este DTO.
	 */
	public void setAgrupadoresProductoComercialNivel(List<AgrupadorProductoComercialNivelDTO> agrupadoresProductoComercialNivel) {
		this.agrupadoresProductoComercialNivel = agrupadoresProductoComercialNivel;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("producto: [").append(producto).append("]");
		description.append(", zonasComercializacion: [").append(toString(zonasComercializacion)).append("]");
		description.append(", agrupadoresProductoComercialNivel: [").append(toString(agrupadoresProductoComercialNivel)).append("]");
		
		return description.toString();
	}
	
	private String toString(List<?> collection) {
		StringBuilder description = new StringBuilder();
		
		Iterator<?> iterator = collection.iterator();
		
		while (iterator.hasNext()) {
			description.append(iterator.next());
			
			if (iterator.hasNext()) {
				description.append(", ");
			}
		}
		
		return description.toString();
	}
}
