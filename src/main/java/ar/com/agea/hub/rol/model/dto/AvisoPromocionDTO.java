package ar.com.agea.hub.rol.model.dto;


/**
 * Representa un objeto Data Transfer Object para transferir datos de la relacion entre aviso y promocion.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author jlichowski
 * @version 1.0 25/03/2014
 */
public class AvisoPromocionDTO implements JSONDTO {

	private static final long serialVersionUID = -34779905430041495L;
	
	private AvisoDTO aviso;
	private PromocionDTO promocion;
	private Double montoSinIva;
	private Double montoConIva;
	private Double porcentaje;
	private Boolean esDescuento;
	
	public AvisoDTO getAviso() {
		return aviso;
	}
	
	public void setAviso(AvisoDTO aviso) {
		this.aviso = aviso;
	}

	public PromocionDTO getPromocion() {
		return promocion;
	}

	public void setPromocion(PromocionDTO promocion) {
		this.promocion = promocion;
	}

	public Double getMontoSinIva() {
		return montoSinIva;
	}

	public void setMontoSinIva(Double montoSinIva) {
		this.montoSinIva = montoSinIva;
	}

	public Double getMontoConIva() {
		return montoConIva;
	}

	public void setMontoConIva(Double montoConIva) {
		this.montoConIva = montoConIva;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Boolean getEsDescuento() {
		return esDescuento;
	}

	public void setEsDescuento(Boolean esDescuento) {
		this.esDescuento = esDescuento;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("aviso: [").append(aviso).append("]");
		description.append(", promocion: [").append(promocion).append("]");
		description.append(", montoSinIva: ").append(montoSinIva);
		description.append(", montoConIva: ").append(montoConIva);
		description.append(", porcentaje: ").append(porcentaje);
		description.append(", esDescuento: ").append(esDescuento);
		
		return description.toString();
	}
}
