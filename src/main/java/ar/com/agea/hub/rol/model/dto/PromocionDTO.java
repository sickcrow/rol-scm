/*
 * @(#)PromocionDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos de promociones.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class PromocionDTO implements JSONDTO {

	private static final long serialVersionUID = -2220101178155443163L;
	
	private Long id;
	private String codigo;
	private String descripcion;
	private String observacion;
	private Boolean combo;
	private Boolean comboCerrado;
	private Boolean gratuita;
	private Boolean seleccion;
	private List<ValidacionPromocionDTO> validacionPromocion;
	private Boolean repiteSalida;
	private List<String> promocionesCompatibles;
	
	private Boolean aplicacionAutomatica;
	
	public PromocionDTO() {
		validacionPromocion = new ArrayList<ValidacionPromocionDTO>();
		promocionesCompatibles = new ArrayList<String>();
	}
	
	/**
	 * Obtiene el id de este DTO.
	 * 
	 * @return Id de este DTO.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setea el id de este DTO.
	 * 
	 * @param id.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtiene el objeto código de este DTO. 
	 * 
	 * @return Objeto código de este DTO.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Setea el objeto código de este DTO.
	 * 
	 * @param codigo Objeto código de este DTO.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	/**
	 * Obtiene la descripcion de este DTO.
	 * 
	 * @return descripcion de este DTO.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Setea la descripcion de este DTO.
	 * @param descripcion de este DTO.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la observacion de este DTO.
	 * 
	 * @return observacion de este DTO.
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * Setea la observacion de este DTO.
	 * 
	 * @param observacion de este DTO.
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * Obtiene el valor combo de este DTO.
	 * 
	 * @return combo de este DTO.
	 */
	public Boolean getCombo() {
		return combo;
	}

	/**
	 * Setea el valor combo de este DTO.
	 * 
	 * @param combo de este DTO. 
	 */
	public void setCombo(Boolean combo) {
		this.combo = combo;
	}

	/**
	 * Obtiene el valor combo cerrado de este DTO.
	 * 
	 * @return combo cerrado de este DTO.
	 */
	public Boolean getComboCerrado() {
		return comboCerrado;
	}

	/**
	 * Setea el valor combo cerrado de este DTO.
	 * 
	 * @param combo cerrado de este DTO.
	 */
	public void setComboCerrado(Boolean comboCerrado) {
		this.comboCerrado = comboCerrado;
	}

	/**
	 * Obtiene el valor gratuita de este DTO.
	 * 
	 * @return gratuita de este DTO.
	 */
	public Boolean getGratuita() {
		return gratuita;
	}

	/**
	 * Setea el valor gratuita de este DTO.
	 * 
	 * @param gratuita de este DTO.
	 */
	public void setGratuita(Boolean gratuita) {
		this.gratuita = gratuita;
	}

	/**
	 * Obtiene el valor seleccion de este DTO. 
	 * 
	 * @return Objetos seleccion de este DTO.
	 */
	public Boolean getSeleccion() {
		return seleccion;
	}

	/**
	 * Setea el valor seleccion  de este DTO.
	 * 
	 * @param seleccion Objeto seleccion de este DTO.
	 */
	public void setSeleccion(Boolean seleccion) {
		this.seleccion = seleccion;
	}
	
	/**
	 * Obtiene los objetos validacion promoción de este DTO. 
	 * 
	 * @return Objetos validacion promoción de este DTO.
	 */
	public List<ValidacionPromocionDTO> getValidacionPromocion() {
		return validacionPromocion;
	}

	/**
	 * Setea los objetos validacion promoción de este DTO.
	 * 
	 * @param validacionPromocion Objeto validacion promoción de este DTO.
	 */
	public void setValidacionPromocion(List<ValidacionPromocionDTO> validacionPromocion) {
		this.validacionPromocion = validacionPromocion;
	}

	/**
	 * Obtiene el objeto repite salida de este DTO. 
	 * 
	 * @return Objeto repite salida de este DTO.
	 */
	public Boolean getRepiteSalida() {
		return repiteSalida;
	}

	/**
	 * Setea el objeto repite salida de este DTO.
	 * 
	 * @param repiteSalida Objeto repite salida de este DTO.
	 */
	public void setRepiteSalida(Boolean repiteSalida) {
		this.repiteSalida = repiteSalida;
	}
	
	/**
	 * Obtiene los objetos promociones compatibles de este DTO. 
	 * 
	 * @return Objetos promociones compatibles de este DTO.
	 */
	public List<String> getPromocionesCompatibles() {
		return promocionesCompatibles;
	}

	/**
	 * Setea los objetos promociones compatibles de este DTO.
	 * 
	 * @param promocionesCompatibles Objeto promociones compatibles de este DTO.
	 */
	public void setPromocionesCompatibles(List<String> promocionesCompatibles) {
		this.promocionesCompatibles = promocionesCompatibles;
	}
	
	

	public Boolean getAplicacionAutomatica() {
		return aplicacionAutomatica;
	}

	public void setAplicacionAutomatica(Boolean aplicacionAutomatica) {
		this.aplicacionAutomatica = aplicacionAutomatica;
	}
	

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("id: ").append(id);
		description.append(", codigo: ").append(codigo);
		description.append(", descripcion: ").append(descripcion);
		description.append(", observacion: ").append(observacion);
		description.append(", combo: ").append(combo);
		description.append(", comboCerrado: ").append(comboCerrado);
		description.append(", gratuita: ").append(gratuita);
		description.append(", seleccion: ").append(seleccion);
		description.append(", validacionPromocion: [").append(toString(validacionPromocion)).append("]");
		description.append(", repiteSalida: ").append(repiteSalida);
		description.append(", promocionesCompatibles: [").append(toString(promocionesCompatibles)).append("]");
		
		description.append(", aplicacionAutomatica: ").append(aplicacionAutomatica);
		
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
