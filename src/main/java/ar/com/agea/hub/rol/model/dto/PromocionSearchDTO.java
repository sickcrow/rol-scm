/*
 * @(#)PromocionSearchDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos de búsqueda de promociones.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB. 
 * 
 * @author      Mauro Mosconi
 * @version		1.0 06/06/2013 
 */
public class PromocionSearchDTO implements JSONDTO {

	private static final long serialVersionUID = -4900397828264397412L;
	
	private String codigoCanalEntrada;
	private String codigoProductoComercial;
	private String codigoNivelEstructura;
	
	// TODO refactor codigoZonasComercializacion por codigosZonaComercializacion.
	private List<String> codigoZonasComercializacion;
	private Date fechaVigencia;

	/**
	 * Instancia un objeto de tipo PromocionSearchDTO.
	 */
	public PromocionSearchDTO() {
		codigoZonasComercializacion = new ArrayList<String>();
	}
	
	/**
	 * Obtiene el objeto código canal entrada de este DTO. 
	 * 
	 * @return Objeto código canal entrada este DTO.
	 */
	public String getCodigoCanalEntrada() {
		return codigoCanalEntrada;
	}

	/**
	 * Setea el objeto código canal entrada de este DTO.
	 * 
	 * @param id Objeto código canal entrada de este DTO.
	 */
	public void setCodigoCanalEntrada(String codigoCanalEntrada) {
		this.codigoCanalEntrada = codigoCanalEntrada;
	}

	/**
	 * Obtiene el objeto código producto comercial de este DTO. 
	 * 
	 * @return Objeto código producto comercial este DTO.
	 */
	public String getCodigoProductoComercial() {
		return codigoProductoComercial;
	}

	/**
	 * Setea el objeto código producto comercial de este DTO.
	 * 
	 * @param id Objeto código producto comercial de este DTO.
	 */
	public void setCodigoProductoComercial(String codigoProductoComercial) {
		this.codigoProductoComercial = codigoProductoComercial;
	}

	/**
	 * Obtiene el objeto código nivel estructura de este DTO. 
	 * 
	 * @return Objeto código nivel estructura este DTO.
	 */
	public String getCodigoNivelEstructura() {
		return codigoNivelEstructura;
	}

	/**
	 * Setea el objeto código nivel estructura de este DTO.
	 * 
	 * @param id Objeto código nivel estructura de este DTO.
	 */
	public void setCodigoNivelEstructura(String codigoNivelEstructura) {
		this.codigoNivelEstructura = codigoNivelEstructura;
	}

	/**
	 * Obtiene el objeto código zona comercialización de este DTO. 
	 * 
	 * @return Objeto código zona comercialización este DTO.
	 */
	public List<String> getCodigoZonasComercializacion() {
		return codigoZonasComercializacion;
	}

	/**
	 * Setea el objeto código zona comercialización de este DTO.
	 * 
	 * @param id Objeto código zona comercialización de este DTO.
	 */
	public void setCodigoZonasComercializacion(
			List<String> codigoZonasComercializacion) {
		this.codigoZonasComercializacion = codigoZonasComercializacion;
	}

	/**
	 * Obtiene el objeto fecha vigencia de este DTO. 
	 * 
	 * @return Objeto fecha vigencia este DTO.
	 */
	public Date getFechaVigencia() {
		Date result = null;
		
		if (fechaVigencia != null) {
			result = (Date) fechaVigencia.clone();
		}
		
		return result;
	}

	/**
	 * Setea el objeto fecha vigencia de este DTO.
	 * 
	 * @param id Objeto fecha vigencia de este DTO.
	 */
	public void setFechaVigencia(Date fechaVigencia) {
		if (fechaVigencia != null) {
			this.fechaVigencia = new Date(fechaVigencia.getTime());
		}
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoCanalEntrada: ").append(codigoCanalEntrada);
		description.append(", codigoProductoComercial: ").append(codigoProductoComercial);
		description.append(", codigoNivelEstructura: ").append(codigoNivelEstructura);
		description.append(", codigoZonasComercializacion: [").append(toString(codigoZonasComercializacion)).append("]");
		description.append(", fechaVigencia: ").append(fechaVigencia);
		
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
