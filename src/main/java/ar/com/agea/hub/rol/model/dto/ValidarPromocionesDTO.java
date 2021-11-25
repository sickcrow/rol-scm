/*
 * @(#)ValidarPromocionesDTO.java		1.0 24/02/2014
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos de validador de promociones.
 * <p>
 * Estos objetos son utilizados por front-end y la capa middleware de la aplicación.
 * 
 * @author		Mariano De Nicolo
 * @version		1.0 11/02/2014
 */
public class ValidarPromocionesDTO implements JSONDTO {

	private static final long serialVersionUID = 7638136253916580746L;

	private OrdenPublicacionDTO ordenPublicacion;
	private List<PromocionDTO> promocionesAplicables;
	private CaptchaDTO captcha;
	private Integer cantidadIntentos;
	
	/**
	 * Instancia un objeto de tipo ValidarPromocionesDTO.
	 */
	public ValidarPromocionesDTO() {
		promocionesAplicables = new ArrayList<PromocionDTO>();
	}
	
	/**
	 * Obtiene el objeto ordenPublicacion de este DTO. 
	 * 
	 * @return Objeto ordenPublicacion de este DTO.
	 */
	public OrdenPublicacionDTO getOrdenPublicacion() {
		return ordenPublicacion;
	}
	
	/**
	 * Obtiene el objeto ordenPublicacion de este DTO. 
	 * 
	 * @return Objeto ordenPublicacion de este DTO.
	 */
	public void setOrdenPublicacion(OrdenPublicacionDTO ordenPublicacion) {
		this.ordenPublicacion = ordenPublicacion;
	}
	
	/**
	 * Obtiene el objeto promocionesAplicables de este DTO. 
	 * 
	 * @return Objeto promocionesAplicables de este DTO.
	 */
	public List<PromocionDTO> getPromocionesAplicables() {
		return promocionesAplicables;
	}
	
	/**
	 * Obtiene el objeto promocionesAplicables de este DTO. 
	 * 
	 * @return Objeto promocionesAplicables de este DTO.
	 */
	public void setPromocionesAplicables(List<PromocionDTO> promocionesAplicables) {
		this.promocionesAplicables = promocionesAplicables;
	}

	/**
	 * Obtiene el objeto captcha de este DTO. 
	 * 
	 * @return Objeto captcha de este DTO.
	 */
	public CaptchaDTO getCaptcha() {
		return captcha;
	}
	
	/**
	 * Setea el objeto captcha de este DTO.
	 * 
	 * @param captcha Objeto captcha de este DTO.
	 */
	public void setCaptcha(CaptchaDTO captcha) {
		this.captcha = captcha;
	}
	
	/**
	 * Obtiene el objeto cantidad intentos promoción de este DTO. 
	 * 
	 * @return Objeto cantidad intentos promoción de este DTO.
	 */
	public Integer getCantidadIntentos() {
		return cantidadIntentos;
	}
	
	/**
	 * Setea el objeto cantidad intentos promoción de este DTO.
	 * 
	 * @param cantidadIntentos Objeto cantidad intentos promoción de este DTO.
	 */
	public void setCantidadIntentos(Integer cantidadIntentos) {
		this.cantidadIntentos = cantidadIntentos;
	}
	
	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("ordenPublicacion: [").append(ordenPublicacion).append("]");
		description.append(", promocionesAplicables: [").append(toString(promocionesAplicables)).append("]");
		description.append(", captcha: [").append(captcha).append("]");
		description.append(", cantidadIntentos: ").append(cantidadIntentos);
		
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
