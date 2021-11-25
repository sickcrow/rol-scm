/*
 * @(#)CalendarioSearchDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos de calendarios.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class CalendarioSearchDTO implements JSONDTO {
	
	private static final long serialVersionUID = -4852268037194913217L;
	
	private String nivelEstructura;
	private Date fechaVigencia;
	private Boolean controlarHorarioCierre;
	private List<String> zonasComercializacion;
	private Long idItemPromocion;
	private String codigoCanalEntrada;

	/**
	 * Instancia un objeto de tipo CalendarioSearchDTO.
	 */
	public CalendarioSearchDTO() {
		zonasComercializacion = new ArrayList<String>();
	}

	/**
	 * Obtiene el objeto nivel estructura de este DTO. 
	 * 
	 * @return Objeto nivel estructura de este DTO.
	 */
	public String getNivelEstructura() {
		return nivelEstructura;
	}

	/**
	 * Setea el objeto nivel estructura de este DTO.
	 * 
	 * @param nivelEstructura Objeto nivel estructura de este DTO.
	 */
	public void setNivelEstructura(String nivelEstructura) {
		this.nivelEstructura = nivelEstructura;
	}

	/**
	 * Obtiene el objeto fecha vigencia de este DTO. 
	 * 
	 * @return Objeto fecha vigencia de este DTO.
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
	 * @param fechaVigencia Objeto fecha vigencia de este DTO.
	 */
	public void setFechaVigencia(Date fechaVigencia) {
		if (fechaVigencia != null) {
			this.fechaVigencia = new Date(fechaVigencia.getTime());
		}
	}

	/**
	 * Obtiene el objeto controlar horario cierre de este DTO. 
	 * 
	 * @return Objeto controlar horario cierre de este DTO.
	 */
	public Boolean getControlarHorarioCierre() {
		return controlarHorarioCierre;
	}
	
	/**
	 * Setea el objeto controlar horario cierre de este DTO.
	 * 
	 * @param controlarHorarioCierre Objeto controlar horario cierre de este DTO.
	 */
	public void setControlarHorarioCierre(Boolean controlarHorarioCierre) {
		this.controlarHorarioCierre = controlarHorarioCierre;
	}

	/**
	 * Obtiene los objetos zonas comercialización de este DTO. 
	 * 
	 * @return Objetos zonas comercialización de este DTO.
	 */
	public List<String> getZonasComercializacion() {
		return zonasComercializacion;
	}

	/**
	 * Setea los objetos zonas comercialización de este DTO.
	 * 
	 * @param zonasComercializacion Objetos zonas comercialización de este DTO.
	 */
	public void setZonasComercializacion(List<String> zonasComercializacion) {
		this.zonasComercializacion = zonasComercializacion;
	}

	/**
	 * Obtiene el objeto id item promoción de este DTO. 
	 * 
	 * @return Objeto id item promoción de este DTO.
	 */
	public Long getIdItemPromocion() {
		return idItemPromocion;
	}

	/**
	 * Setea el objeto id item promoción de este DTO.
	 * 
	 * @param idItemPromocion Objeto id item promoción de este DTO.
	 */
	public void setIdItemPromocion(Long idItemPromocion) {
		this.idItemPromocion = idItemPromocion;
	}

	/**
	 * Obtiene el objeto código canal entrada de este DTO. 
	 * 
	 * @return Objeto código canal entrada de este DTO.
	 */
	public String getCodigoCanalEntrada() {
		return codigoCanalEntrada;
	}

	/**
	 * Setea el objeto código canal entrada de este DTO.
	 * 
	 * @param codigoCanalEntrada Objeto código canal entrada de este DTO.
	 */
	public void setCodigoCanalEntrada(String codigoCanalEntrada) {
		this.codigoCanalEntrada = codigoCanalEntrada;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("nivelEstructura: ").append(nivelEstructura);
		description.append(", fechaVigencia: ").append(fechaVigencia);
		description.append(", controlarHorarioCierre: ").append(controlarHorarioCierre);
		description.append(", zonasComercializacion: [").append(toString(zonasComercializacion)).append("]");
		description.append(", idItemPromocion: ").append(idItemPromocion);
		description.append(", codigoCanalEntrada: ").append(codigoCanalEntrada);
		
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
