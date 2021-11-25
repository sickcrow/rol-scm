/*
 * @(#)GWPNotificationDTO.java		1.0 30/10/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ar.com.agea.hub.rol.utils.DateFormatterAdapter;
import ar.com.agea.hub.rol.utils.DoubleFormatterAdapter;

/**
 * Representa un objeto Data Transfer Object para transferir datos de transacciones.
 * <p>
 * Estos objetos son utilizados por la capa middleware de la aplicación y los
 * servicios GWP.
 * 
 * @author		Eduardo Barrera
 * @author		Juan Martín Lichowski
 * @version		1.0 30/10/2013
 */
@XmlRootElement(name="estadoPagoMessage")
public class GWPNotificationDTO implements XMLDTO {
	
	private static final long serialVersionUID = 5464962037833150096L;

	private String codigoAplicacionCliente;
	private String idTransaccionCliente;
	private String nombreItem;
	private Date fecha;
	private String estado;
	private String codigoMetodoPago;
	private String medioPago;
	private String numeroTarjeta;
	private String codigoMoneda;
	private Double monto;
	private Double montoPagado;
	private String idTransaccionProveedor;
	private String codigoProveedor;
	private Boolean posibleFraude;
	private String motivoPosibleFraude;

	/**
	 * Obtiene el objeto código aplicación cliente de este DTO. 
	 * 
	 * @return Objeto código aplicación cliente este DTO.
	 */
	public String getCodigoAplicacionCliente() {
		return codigoAplicacionCliente;
	}

	/**
	 * Setea el objeto código aplicación cliente de este DTO.
	 * 
	 * @param codigoAplicacionCliente Objeto código aplicación cliente de este DTO.
	 */
	public void setCodigoAplicacionCliente(String codigoAplicacionCliente) {
		this.codigoAplicacionCliente = codigoAplicacionCliente;
	}

	/**
	 * Obtiene el objeto id transacción cliente de este DTO. 
	 * 
	 * @return Objeto id transacción cliente este DTO.
	 */
	public String getIdTransaccionCliente() {
		return idTransaccionCliente;
	}

	/**
	 * Setea el objeto id transacción cliente de este DTO.
	 * 
	 * @param idTransaccionCliente Objeto id transacción cliente de este DTO.
	 */
	public void setIdTransaccionCliente(String idTransaccionCliente) {
		this.idTransaccionCliente = idTransaccionCliente;
	}
	
	/**
	 * Obtiene el objeto nombre ítem de este DTO. 
	 * 
	 * @return Objeto nombre ítem este DTO.
	 */
	public String getNombreItem() {
		return nombreItem;
	}

	/**
	 * Setea el objeto nombre ítem de este DTO.
	 * 
	 * @param nombreItem Objeto nombre ítem de este DTO.
	 */
	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}
	
	/**
	 * Obtiene el objeto fecha de este DTO. 
	 * 
	 * @return Objeto fecha este DTO.
	 */
	public Date getFecha() {
		Date result = null;
		
		if (fecha != null) {
			result = (Date) fecha.clone();
		}
		
		return result;
	}

	/**
	 * Setea el objeto fecha de este DTO.
	 * 
	 * @param fecha Objeto fecha de este DTO.
	 */
	@XmlJavaTypeAdapter(value = DateFormatterAdapter.class)
	public void setFecha(Date fecha) {
		if (fecha != null) {
			this.fecha = new Date(fecha.getTime());
		}
	}
	
	/**
	 * Obtiene el objeto estado de este DTO. 
	 * 
	 * @return Objeto estado este DTO.
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
	 * Obtiene el objeto código método pago de este DTO. 
	 * 
	 * @return Objeto código método pago este DTO.
	 */
	public String getCodigoMetodoPago() {
		return codigoMetodoPago;
	}

	/**
	 * Setea el objeto código método pago de este DTO.
	 * 
	 * @param codigoMetodoPago Objeto código método pago de este DTO.
	 */
	public void setCodigoMetodoPago(String codigoMetodoPago) {
		this.codigoMetodoPago = codigoMetodoPago;
	}

	/**
	 * Obtiene el objeto medio pago de este DTO. 
	 * 
	 * @return Objeto medio pago este DTO.
	 */
	public String getMedioPago() {
		return medioPago;
	}

	/**
	 * Setea el objeto medio pago de este DTO.
	 * 
	 * @param medioPago Objeto medio pago de este DTO.
	 */
	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}

	/**
	 * Obtiene el objeto número tarjeta de este DTO. 
	 * 
	 * @return Objeto número tarjeta este DTO.
	 */
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	/**
	 * Setea el objeto número tarjeta de este DTO.
	 * 
	 * @param numeroTarjeta Objeto número tarjeta de este DTO.
	 */
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	
	/**
	 * Obtiene el objeto código moneda de este DTO. 
	 * 
	 * @return Objeto código moneda este DTO.
	 */
	public String getCodigoMoneda() {
		return codigoMoneda;
	}

	/**
	 * Setea el objeto código moneda de este DTO.
	 * 
	 * @param codigoMoneda Objeto código moneda de este DTO.
	 */
	public void setCodigoMoneda(String codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}
	
	/**
	 * Obtiene el objeto monto de este DTO. 
	 * 
	 * @return Objeto monto este DTO.
	 */
	public Double getMonto() {
		return monto;
	}

	/**
	 * Setea el objeto monto de este DTO.
	 * 
	 * @param monto Objeto monto de este DTO.
	 */
	@XmlJavaTypeAdapter(value = DoubleFormatterAdapter.class)
	public void setMonto(Double monto) {
		this.monto = monto;
	}

	/**
	 * Obtiene el objeto monto pagado de este DTO. 
	 * 
	 * @return Objeto monto pagado este DTO.
	 */
	public Double getMontoPagado() {
		return montoPagado;
	}

	/**
	 * Setea el objeto monto pagado de este DTO.
	 * 
	 * @param montoPagado Objeto monto pagado de este DTO.
	 */
	@XmlJavaTypeAdapter(value = DoubleFormatterAdapter.class)
	public void setMontoPagado(Double montoPagado) {
		this.montoPagado = montoPagado;
	}
	
	/**
	 * Obtiene el objeto id transacción proveedor de este DTO. 
	 * 
	 * @return Objeto id transacción proveedor este DTO.
	 */
	public String getIdTransaccionProveedor() {
		return idTransaccionProveedor;
	}

	/**
	 * Setea el objeto id transacción proveedor de este DTO.
	 * 
	 * @param idTransaccionProveedor Objeto id transacción proveedor de este DTO.
	 */
	public void setIdTransaccionProveedor(String idTransaccionProveedor) {
		this.idTransaccionProveedor = idTransaccionProveedor;
	}

	/**
	 * Obtiene el objeto código proveedor de este DTO. 
	 * 
	 * @return Objeto código proveedor este DTO.
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * Setea el objeto código proveedor de este DTO.
	 * 
	 * @param codigoProveedor Objeto código proveedor de este DTO.
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	
	/**
	 * Obtiene el objeto posible fraude de este DTO. 
	 * 
	 * @return Objeto posible fraude este DTO.
	 */
	public Boolean getPosibleFraude() {
		return posibleFraude;
	}

	/**
	 * Setea el objeto posible fraude de este DTO.
	 * 
	 * @param posibleFraude Objeto posible fraude de este DTO.
	 */
	public void setPosibleFraude(Boolean posibleFraude) {
		this.posibleFraude = posibleFraude;
	}

	/**
	 * Obtiene el objeto motivo posible fraude de este DTO. 
	 * 
	 * @return Objeto motivo posible fraude este DTO.
	 */
	public String getMotivoPosibleFraude() {
		return motivoPosibleFraude;
	}

	/**
	 * Setea el objeto motivo posible fraude de este DTO.
	 * 
	 * @param motivoPosibleFraude Objeto motivo posible fraude de este DTO.
	 */
	public void setMotivoPosibleFraude(String motivoPosibleFraude) {
		this.motivoPosibleFraude = motivoPosibleFraude;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoAplicacionCliente: ").append(codigoAplicacionCliente);
		description.append(", idTransaccionCliente: ").append(idTransaccionCliente);
		description.append(", nombreItem: ").append(nombreItem);
		description.append(", fecha: ").append(fecha);
		description.append(", estado: ").append(estado);
		description.append(", codigoMetodoPago: ").append(codigoMetodoPago);
		description.append(", medioPago: ").append(medioPago);
		description.append(", numeroTarjeta: ").append(numeroTarjeta);
		description.append(", codigoMoneda: ").append(codigoMoneda);
		description.append(", monto: ").append(monto);
		description.append(", montoPagado: ").append(montoPagado);
		description.append(", idTransaccionProveedor: ").append(idTransaccionProveedor);
		description.append(", codigoProveedor: ").append(codigoProveedor);
		description.append(", posibleFraude: ").append(posibleFraude);
		description.append(", motivoPosibleFraude: ").append(motivoPosibleFraude);
		
		return description.toString();
	}
}
