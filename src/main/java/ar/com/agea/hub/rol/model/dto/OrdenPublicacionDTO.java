/*
 * @(#)OrdenPublicacionDTO.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Representa un objeto Data Transfer Object para transferir datos de ordenes de publicación.
 * <p>
 * Estos objetos son utilizados por front-end, la capa middleware de la aplicación y los
 * servicios HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class OrdenPublicacionDTO implements JSONDTO {
	
	private static final long serialVersionUID = -82438627168837072L;
	
	private Long id;
	private String uuidGenerarOrden;
	private Date fechaAlta;
	private Date fechaUltimaModificacion;
	private Boolean presupuestada;
	private Boolean incompleta;
	private Boolean leida;
	private Boolean procesada;
	private Boolean externa;
	//private String codigoCanalEntrada;
	private TipoDocumentoDTO tipoDocumento;
	private DomicilioDTO domicilio;
	private String telefono;
	private String email;	
	private String codigoMedioDePago;
	private String codigoTipoTarjeta;
	private TipoIVADTO tipoIVA;
	private List<ConceptoVendibleDTO> conceptosVendibles;
	private CapturadorDTO capturador;
	private UsuarioExternoDTO usuarioExterno;
	private GWPTransaccionDTO transaccionActual;
	private List<GWPTransaccionDTO> transacciones;
	private TrackCampanaDTO trackCampana;
	
	/**
	 * Instancia un objeto de tipo OrdenPublicacionDTO.
	 */
	public OrdenPublicacionDTO() {
		conceptosVendibles = new ArrayList<ConceptoVendibleDTO>();
		transacciones = new ArrayList<GWPTransaccionDTO>();
	}
	
	/**
	 * Obtiene el objeto id de este DTO. 
	 * 
	 * @return Objeto id este DTO.
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
	 * Obtiene el objeto uuid generar orden de este DTO. 
	 * 
	 * @return Objeto uuid generar orden de este DTO.
	 */
	public String getUuidGenerarOrden() {
		return uuidGenerarOrden;
	}

	/**
	 * Setea el objeto uuid generar orden de este DTO.
	 * 
	 * @param uuidGenerarOrden Objeto uuid generar orden de este DTO.
	 */
	public void setUuidGenerarOrden(String uuidGenerarOrden) {
		this.uuidGenerarOrden = uuidGenerarOrden;
	}

	/**
	 * Obtiene el objeto fecha alta de este DTO. 
	 * 
	 * @return Objeto fecha alta de este DTO.
	 */
	public Date getFechaAlta() {
		Date result = null;
		
		if (fechaAlta != null) {
			result = (Date) fechaAlta.clone();
		}
		
		return result;
	}

	/**
	 * Setea el objeto fecha alta de este DTO.
	 * 
	 * @param fechaAlta Objeto fecha alta de este DTO.
	 */
	public void setFechaAlta(Date fechaAlta) {
		if (fechaAlta != null) {
			this.fechaAlta = new Date(fechaAlta.getTime());
		}
	}
	
	/**
	 * Obtiene el objeto fecha última modificación de este DTO. 
	 * 
	 * @return Objeto fecha última modificación de este DTO.
	 */
	public Date getFechaUltimaModificacion() {
		Date result = null;
		
		if (fechaUltimaModificacion != null) {
			result = (Date) fechaUltimaModificacion.clone();
		}
		
		return result;
	}

	/**
	 * Setea el objeto fecha última modificación de este DTO.
	 * 
	 * @param fechaUltimaModificacion Objeto fecha última modificación de este DTO.
	 */
	public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
		if (fechaUltimaModificacion != null) {
			this.fechaUltimaModificacion = new Date(fechaUltimaModificacion.getTime());
		}
	}

	/**
	 * Obtiene el objeto presupuestada de este DTO. 
	 * 
	 * @return Objeto presupuestada de este DTO.
	 */
	public Boolean getPresupuestada() {
		return presupuestada;
	}

	/**
	 * Setea el objeto presupuestada de este DTO.
	 * 
	 * @param presupuestada Objeto presupuestada de este DTO.
	 */
	public void setPresupuestada(Boolean presupuestada) {
		this.presupuestada = presupuestada;
	}

	/**
	 * Obtiene el objeto incompleta de este DTO. 
	 * 
	 * @return Objeto incompleta de este DTO.
	 */
	public Boolean getIncompleta() {
		return incompleta;
	}

	/**
	 * Setea el objeto incompleta de este DTO.
	 * 
	 * @param incompleta Objeto incompleta de este DTO.
	 */
	public void setIncompleta(Boolean incompleta) {
		this.incompleta = incompleta;
	}

	/**
	 * Obtiene el objeto leida de este DTO. 
	 * 
	 * @return Objeto leida de este DTO.
	 */
	public Boolean getLeida() {
		return leida;
	}

	/**
	 * Setea el objeto leida de este DTO.
	 * 
	 * @param leida Objeto leida de este DTO.
	 */
	public void setLeida(Boolean leida) {
		this.leida = leida;
	}

	/**
	 * Obtiene el objeto procesada de este DTO. 
	 * 
	 * @return Objeto procesada de este DTO.
	 */
	public Boolean getProcesada() {
		return procesada;
	}

	/**
	 * Setea el objeto procesada de este DTO.
	 * 
	 * @param procesada Objeto procesada de este DTO.
	 */
	public void setProcesada(Boolean procesada) {
		this.procesada = procesada;
	}

	/**
	 * Obtiene el objeto externa de este DTO. 
	 * 
	 * @return Objeto externa de este DTO.
	 */
	public Boolean getExterna() {
		return externa;
	}

	/**
	 * Setea el objeto externa de este DTO.
	 * 
	 * @param externa Objeto externa de este DTO.
	 */
	public void setExterna(Boolean externa) {
		this.externa = externa;
	}

//	/**
//	 * Obtiene el objeto código canal entrada de este DTO. 
//	 * 
//	 * @return Objeto código canal entrada de este DTO.
//	 */
//	public String getCodigoCanalEntrada() {
//		return codigoCanalEntrada;
//	}
//
//	/**
//	 * Setea el objeto código canal entrada de este DTO.
//	 * 
//	 * @param codigoCanalEntrada Objeto código canal entrada de este DTO.
//	 */
//	public void setCodigoCanalEntrada(String codigoCanalEntrada) {
//		this.codigoCanalEntrada = codigoCanalEntrada;
//	}

	/**
	 * Obtiene el objeto tipo documento de este DTO. 
	 * 
	 * @return Objeto tipo documento de este DTO.
	 */
	public TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * Setea el objeto tipo documento de este DTO.
	 * 
	 * @param tipoDocumento Objeto tipo documento de este DTO.
	 */
	public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * Obtiene el objeto domicilio de este DTO. 
	 * 
	 * @return Objeto domicilio de este DTO.
	 */
	public DomicilioDTO getDomicilio() {
		return domicilio;
	}

	/**
	 * Setea el objeto código medio de pago de este DTO.
	 * 
	 * @param codigoMedioDePago Objeto código medio de pago de este DTO.
	 */
	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}
	
	/**
	 * Obtiene el objeto telefono de este DTO. 
	 * 
	 * @return Objeto telefono de este DTO.
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Setea el objeto telefono de este DTO.
	 * 
	 * @param telefono Objeto telefono de este DTO.
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Obtiene el objeto email de este DTO. 
	 * 
	 * @return Objeto email de este DTO.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setea el objeto email de este DTO.
	 * 
	 * @param email Objeto email de este DTO.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
		
	/**
	 * Obtiene el objeto código medio de pago de este DTO. 
	 * 
	 * @return Objeto código medio de pago de este DTO.
	 */
	public String getCodigoMedioDePago() {
		return codigoMedioDePago;
	}

	/**
	 * Setea el objeto código medio de pago de este DTO.
	 * 
	 * @param codigoMedioDePago Objeto código medio de pago de este DTO.
	 */
	public void setCodigoMedioDePago(String codigoMedioDePago) {
		this.codigoMedioDePago = codigoMedioDePago;
	}

	/**
	 * Obtiene el objeto código tipo tarjeta de este DTO. 
	 * 
	 * @return Objeto código tipo tarjeta de este DTO.
	 */
	public String getCodigoTipoTarjeta() {
		return codigoTipoTarjeta;
	}

	/**
	 * Setea el objeto código tipo tarjeta de este DTO.
	 * 
	 * @param codigoTipoTarjeta Objeto código tipo tarjeta de este DTO.
	 */
	public void setCodigoTipoTarjeta(String codigoTipoTarjeta) {
		this.codigoTipoTarjeta = codigoTipoTarjeta;
	}

	/**
	 * Obtiene el objeto tipo IVA de este DTO. 
	 * 
	 * @return Objeto tipo IVA de este DTO.
	 */
	public TipoIVADTO getTipoIVA() {
		return tipoIVA;
	}

	/**
	 * Setea el objeto tipo IVA de este DTO.
	 * 
	 * @param tipoIVA Objeto tipo IVA de este DTO.
	 */
	public void setTipoIVA(TipoIVADTO tipoIVA) {
		this.tipoIVA = tipoIVA;
	}

	/**
	 * Obtiene los objetos conceptos vendibles de este DTO. 
	 * 
	 * @return Objetos conceptos vendibles de este DTO.
	 */
	public List<ConceptoVendibleDTO> getConceptosVendibles() {
		return conceptosVendibles;
	}

	/**
	 * Setea los objetos conceptos vendibles de este DTO.
	 * 
	 * @param conceptosVendibles Objeto conceptos vendibles de este DTO.
	 */
	public void setConceptosVendibles(
			List<ConceptoVendibleDTO> conceptosVendibles) {
		this.conceptosVendibles = conceptosVendibles;
	}

	/**
	 * Obtiene el objeto capturador de este DTO. 
	 * 
	 * @return Objeto capturador de este DTO.
	 */
	public CapturadorDTO getCapturador() {
		return capturador;
	}

	/**
	 * Setea el objeto capturador de este DTO.
	 * 
	 * @param capturador Objeto capturador de este DTO.
	 */
	public void setCapturador(CapturadorDTO capturador) {
		this.capturador = capturador;
	}

	/**
	 * Obtiene el objeto usuario externo de este DTO. 
	 * 
	 * @return Objeto usuario externo de este DTO.
	 */
	public UsuarioExternoDTO getUsuarioExterno() {
		return usuarioExterno;
	}

	/**
	 * Setea el objeto usuario externo de este DTO.
	 * 
	 * @param usuarioExterno Objeto usuario externo de este DTO.
	 */
	public void setUsuarioExterno(UsuarioExternoDTO usuarioExterno) {
		this.usuarioExterno = usuarioExterno;
	}

	/**
	 * Obtiene el objeto transacción actual de este DTO. 
	 * 
	 * @return Objeto transacción actual de este DTO.
	 */
	public GWPTransaccionDTO getTransaccionActual() {
		return transaccionActual;
	}

	/**
	 * Setea el objeto transacción actual de este DTO.
	 * 
	 * @param transaccionActual Objeto transacción actual de este DTO.
	 */
	public void setTransaccionActual(GWPTransaccionDTO transaccionActual) {
		this.transaccionActual = transaccionActual;
	}

	/**
	 * Obtiene los objetos transacciones de este DTO. 
	 * 
	 * @return Objetos transacciones de este DTO.
	 */
	public List<GWPTransaccionDTO> getTransacciones() {
		return transacciones;
	}

	/**
	 * Setea los objetos transacciones de este DTO.
	 * 
	 * @param transacciones Objeto transacciones de este DTO.
	 */
	public void setTransacciones(List<GWPTransaccionDTO> transacciones) {
		this.transacciones = transacciones;
	}

	/**
	 * Obtiene el objeto track campana de este DTO. 
	 * 
	 * @return Objeto track campana de este DTO.
	 */
	public TrackCampanaDTO getTrackCampana() {
		return trackCampana;
	}

	/**
	 * Setea el objeto track campana de este DTO.
	 * 
	 * @param trackCampana Objeto track campana de este DTO.
	 */
	public void setTrackCampana(TrackCampanaDTO trackCampana) {
		this.trackCampana = trackCampana;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("id: ").append(id);
		description.append(", uuidGenerarOrden: ").append(uuidGenerarOrden);
		description.append(", fechaAlta: ").append(fechaAlta);
		description.append(", fechaUltimaModificacion: ").append(fechaUltimaModificacion);
		description.append(", presupuestada: ").append(presupuestada);
		description.append(", incompleta: ").append(incompleta);
		description.append(", leida: ").append(leida);
		description.append(", procesada: ").append(procesada);
		description.append(", externa: ").append(externa);
		//description.append(", codigoCanalEntrada: ").append(codigoCanalEntrada);
		description.append(", tipoDocumento: [").append(tipoDocumento).append("]");
		description.append(", domicilio: [").append(domicilio).append("]");
		description.append(", codigoMedioDePago: ").append(codigoMedioDePago);
		description.append(", codigoTipoTarjeta: ").append(codigoTipoTarjeta);
		description.append(", tipoIVA: [").append(tipoIVA).append("]");
		description.append(", conceptosVendibles: [").append(toString(conceptosVendibles)).append("]");
		description.append(", capturador: [").append(capturador).append("]");
		description.append(", usuarioExterno: [").append(usuarioExterno).append("]");
		description.append(", transaccionActual: [").append(transaccionActual).append("]");
		description.append(", transacciones: [").append(toString(transacciones)).append("]");
		description.append(", trackCampana: [").append(trackCampana).append("]");
		
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
