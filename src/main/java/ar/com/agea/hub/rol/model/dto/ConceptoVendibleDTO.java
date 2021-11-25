/*
 * @(#)ConceptoVendibleDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos de conceptos vendibles.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ConceptoVendibleDTO implements JSONDTO {
	
	private static final long serialVersionUID = -1114798392356051472L;
	
	private Long id;
	private String descripcion;
	private Date fechaTarifa;
	private Boolean prefacturado;
	private TipoMonedaDTO tipoMoneda;
	private Double porcentajeIVA;
	private Double montoSinIVA;
	private Double montoSinIVASinPromo;
	private Double montoIVA;
	private Double montoIVASinPromo;
	private Double montoPercepcion;
	private Double montoPercepcionSinPromo;
	private Double montoTotal;
	private Double montoTotalSinPromo;
	private String estado;
	private String motivoEstado;
	private List<AccionSecuenciaDTO> acciones;
	private List<String> accionesPosibles;
	private PromocionDTO promocion;
	private List<ItemConceptoVendibleDTO> itemsConceptoVendible;
	private Boolean moderado;

	/**
	 * Instancia un objeto de tipo ConceptoVendibleDTO.
	 */
	public ConceptoVendibleDTO() {
		acciones = new ArrayList<AccionSecuenciaDTO>();
		accionesPosibles = new ArrayList<String>();
		itemsConceptoVendible = new ArrayList<ItemConceptoVendibleDTO>();
	}

	/**
	 * Obtiene el objeto id de este DTO. 
	 * 
	 * @return Objeto id de este DTO.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setea el objeto id de este DTO.
	 * 
	 * @param id Objeto id de este DTO.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtiene el objeto descripción de este DTO. 
	 * 
	 * @return Objeto descripción de este DTO.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Setea el objeto descripción de este DTO.
	 * 
	 * @param descripcion Objeto descripción de este DTO.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene el objeto fecha tarifa de este DTO. 
	 * 
	 * @return Objeto fecha tarifa de este DTO.
	 */
	public Date getFechaTarifa() {
		Date result = null;
		
		if (fechaTarifa != null) {
			result = (Date) fechaTarifa.clone(); 
		}
		
		return result;
	}

	/**
	 * Setea el objeto fecha tarifa de este DTO.
	 * 
	 * @param fechaTarifa Objeto fecha tarifa de este DTO.
	 */
	public void setFechaTarifa(Date fechaTarifa) {
		if (fechaTarifa != null) {
			this.fechaTarifa = new Date(fechaTarifa.getTime());
		}
	}

	/**
	 * Obtiene el objeto prefacturado de este DTO. 
	 * 
	 * @return Objeto prefacturado de este DTO.
	 */
	public Boolean getPrefacturado() {
		return prefacturado;
	}

	/**
	 * Setea el objeto prefacturado de este DTO.
	 * 
	 * @param prefacturado Objeto prefacturado de este DTO.
	 */
	public void setPrefacturado(Boolean prefacturado) {
		this.prefacturado = prefacturado;
	}

	/**
	 * Obtiene el objeto tipo moneda de este DTO. 
	 * 
	 * @return Objeto tipo moneda de este DTO.
	 */
	public TipoMonedaDTO getTipoMoneda() {
		return tipoMoneda;
	}

	/**
	 * Setea el objeto tipo moneda de este DTO.
	 * 
	 * @param tipoMoneda Objeto tipo moneda de este DTO.
	 */
	public void setTipoMoneda(TipoMonedaDTO tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	/**
	 * Obtiene el objeto porcentaje IVA de este DTO. 
	 * 
	 * @return Objeto porcentaje IVA de este DTO.
	 */
	public Double getPorcentajeIVA() {
		return porcentajeIVA;
	}

	/**
	 * Setea el objeto porcentaje IVA de este DTO.
	 * 
	 * @param porcentajeIVA Objeto porcentaje IVA de este DTO.
	 */
	public void setPorcentajeIVA(Double porcentajeIVA) {
		this.porcentajeIVA = porcentajeIVA;
	}

	/**
	 * Obtiene el objeto monto sin IVA de este DTO. 
	 * 
	 * @return Objeto monto sin IVA de este DTO.
	 */
	public Double getMontoSinIVA() {
		return montoSinIVA;
	}

	/**
	 * Setea el objeto monto sin IVA de este DTO.
	 * 
	 * @param montoSinIVA Objeto monto sin IVA de este DTO.
	 */
	public void setMontoSinIVA(Double montoSinIVA) {
		this.montoSinIVA = montoSinIVA;
	}

	/**
	 * Obtiene el objeto monto IVA de este DTO. 
	 * 
	 * @return Objeto monto IVA de este DTO.
	 */
	public Double getMontoIVA() {
		return montoIVA;
	}

	/**
	 * Setea el objeto monto IVA de este DTO.
	 * 
	 * @param montoIVA Objeto monto IVA de este DTO.
	 */
	public void setMontoIVA(Double montoIVA) {
		this.montoIVA = montoIVA;
	}

	/**
	 * Obtiene el objeto monto percepción de este DTO. 
	 * 
	 * @return Objeto monto percepción de este DTO.
	 */
	public Double getMontoPercepcion() {
		return montoPercepcion;
	}

	/**
	 * Setea el objeto monto percepción de este DTO.
	 * 
	 * @param montoPercepcion Objeto monto percepción de este DTO.
	 */
	public void setMontoPercepcion(Double montoPercepcion) {
		this.montoPercepcion = montoPercepcion;
	}

	/**
	 * Obtiene el objeto monto total de este DTO. 
	 * 
	 * @return Objeto monto total de este DTO.
	 */
	public Double getMontoTotal() {
		return montoTotal;
	}

	/**
	 * Setea el objeto monto total de este DTO.
	 * 
	 * @param montoTotal Objeto monto total de este DTO.
	 */
	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	/**
	 * Obtiene el objeto estado de este DTO. 
	 * 
	 * @return Objeto estado de este DTO.
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Setea el objeto estado de este DTO.
	 * 
	 * @param estado Objeto estado de este DTO.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene el objeto motivo estado de este DTO. 
	 * 
	 * @return Objeto motivo estado de este DTO.
	 */
	public String getMotivoEstado() {
		return motivoEstado;
	}

	/**
	 * Setea el objeto motivo estado de este DTO.
	 * 
	 * @param motivoEstado Objeto motivo estado de este DTO.
	 */
	public void setMotivoEstado(String motivoEstado) {
		this.motivoEstado = motivoEstado;
	}

	/**
	 * Obtiene los objetos acciones secuencia de este DTO. 
	 * 
	 * @return Objetos acciones secuencia de este DTO.
	 */
	public List<AccionSecuenciaDTO> getAcciones() {
		return acciones;
	}

	/**
	 * Setea los objetos acciones de este DTO.
	 * 
	 * @param acciones Objetos acciones de este DTO.
	 */
	public void setAcciones(List<AccionSecuenciaDTO> acciones) {
		this.acciones = acciones;
	}

	/**
	 * Obtiene los objetos acciones posibles de este DTO. 
	 * 
	 * @return Objetos acciones posibles de este DTO.
	 */
	public List<String> getAccionesPosibles() {
		return accionesPosibles;
	}

	/**
	 * Setea los objetos acciones posibles de este DTO.
	 * 
	 * @param accionesPosibles Objetos acciones posibles de este DTO.
	 */
	public void setAccionesPosibles(List<String> accionesPosibles) {
		this.accionesPosibles = accionesPosibles;
	}

	/**
	 * Obtiene el objeto promoción de este DTO. 
	 * 
	 * @return Objeto promoción de este DTO.
	 */
	public PromocionDTO getPromocion() {
		return promocion;
	}

	/**
	 * Setea el objeto promoción de este DTO.
	 * 
	 * @param promocion Objeto promoción de este DTO.
	 */
	public void setPromocion(PromocionDTO promocion) {
		this.promocion = promocion;
	}

	/**
	 * Obtiene los objetos items concepto vendible de este DTO. 
	 * 
	 * @return Objetos items concepto vendible de este DTO.
	 */
	public List<ItemConceptoVendibleDTO> getItemsConceptoVendible() {
		return itemsConceptoVendible;
	}

	/**
	 * Setea lps objetos items concepto vendible de este DTO.
	 * 
	 * @param itemsConceptoVendible Objetos items concepto vendible de este DTO.
	 */
	public void setItemsConceptoVendible(
			List<ItemConceptoVendibleDTO> itemsConceptoVendible) {
		this.itemsConceptoVendible = itemsConceptoVendible;
	}

	/**
	 * Obtiene el monto sin iva y sin promo de este DTO. 
	 * 
	 * @return Objetos monto sin iva y sin promocion de este DTO.
	 */
	public Double getMontoSinIVASinPromo() {
		return montoSinIVASinPromo;
	}

	public void setMontoSinIVASinPromo(Double montoSinIVASinPromo) {
		this.montoSinIVASinPromo = montoSinIVASinPromo;
	}

	/**
	 * Obtiene el monto sin promo de este DTO. 
	 * 
	 * @return Objetos monto sin promocion de este DTO.
	 */
	public Double getMontoIVASinPromo() {
		return montoIVASinPromo;
	}

	public void setMontoIVASinPromo(Double montoIVASinPromo) {
		this.montoIVASinPromo = montoIVASinPromo;
	}

	/**
	 * Obtiene el monto percepcion sin promo de este DTO. 
	 * 
	 * @return Objetos monto percepcion sin promocion de este DTO.
	 */
	public Double getMontoPercepcionSinPromo() {
		return montoPercepcionSinPromo;
	}

	public void setMontoPercepcionSinPromo(Double montoPercepcionSinPromo) {
		this.montoPercepcionSinPromo = montoPercepcionSinPromo;
	}

	/**
	 * Obtiene el monto total sin promo de este DTO. 
	 * 
	 * @return Objetos monto total sin promocion de este DTO.
	 */
	public Double getMontoTotalSinPromo() {
		return montoTotalSinPromo;
	}

	public void setMontoTotalSinPromo(Double montoTotalSinPromo) {
		this.montoTotalSinPromo = montoTotalSinPromo;
	}
	
	public Boolean getModerado() {
		return moderado;
	}

	public void setModerado(Boolean moderado) {
		this.moderado = moderado;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("id: ").append(id);
		description.append(", descripcion: ").append(descripcion);
		description.append(", fechaTarifa: ").append(fechaTarifa);
		description.append(", prefacturado: ").append(prefacturado);
		description.append(", tipoMoneda: [").append(tipoMoneda).append("]");
		description.append(", porcentajeIVA: ").append(porcentajeIVA);
		description.append(", montoSinIVA: ").append(montoSinIVA);
		description.append(", montoSinIVASinPromo: ").append(montoSinIVASinPromo);
		description.append(", montoIVA: ").append(montoIVA);
		description.append(", montoIVASinPromo: ").append(montoIVASinPromo);
		description.append(", montoPercepcion: ").append(montoPercepcion);
		description.append(", montoPercepcionSinPromo: ").append(montoPercepcionSinPromo);
		description.append(", montoTotal: ").append(montoTotal);
		description.append(", montoTotalSinPromo: ").append(montoTotalSinPromo);
		description.append(", estado: ").append(estado);
		description.append(", motivoEstado: ").append(motivoEstado);
		description.append(", acciones: [").append(toString(acciones)).append("]");
		description.append(", accionesPosibles: [").append(toString(accionesPosibles)).append("]");
		description.append(", promocion: [").append(promocion).append("]");
		description.append(", itemsConceptoVendible: [").append(toString(itemsConceptoVendible)).append("]");
		
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
