/*
 * @(#)GWPNotificationDTO.java		1.0 30/10/2013
 */

package ar.com.agea.hub.rol.model.dto;

import java.util.Date;

/**
 * Representa un objeto Data Transfer Object para transferir datos de transacciones.
 * <p>
 * Estos objetos son utilizados por la capa middleware de la aplicación y los
 * servicios GWP.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 30/10/2013
 */
public class GWPTransaccionDTO implements JSONDTO {
	
	private static final long serialVersionUID = 5464962037833150096L;

	private String codigoAplicacionCliente;
	private String idTransaccionCliente;
	private String nombreItem;
	private Date fechaImputado;
	private Date fechaTransaccion;
	private String estado;
	private String codigoMetodoPago;
	private String codigoMedioPago;
	private String numeroTarjeta;
	private String codigoMoneda;
	private Double monto;
	private Double montoPagado;
	private String idTransaccionProveedor;
	private String codigoProveedor;
	private Boolean posibleFraude;
	private String motivoPosibleFraude;
	private String email;
	private String apellidos;
	private String nombres;
	private String telefono;
	private String descripcionError;
	
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
	 * Obtiene el objeto fecha imputado de este DTO. 
	 * 
	 * @return Objeto fecha imputado este DTO.
	 */
	public Date getFechaImputado() {
		Date result = null;
		
		if (fechaImputado != null) {
			result = (Date) fechaImputado.clone();
		}
		
		return result;
	}

	/**
	 * Setea el objeto fecha imputado de este DTO.
	 * 
	 * @param fechaImputado Objeto fecha imputado de este DTO.
	 */
	public void setFechaImputado(Date fechaImputado) {
		if (fechaImputado != null) {
			this.fechaImputado = new Date(fechaImputado.getTime());
		}
	}
	
	/**
	 * Obtiene el objeto fecha transacción de este DTO. 
	 * 
	 * @return Objeto fecha transacción este DTO.
	 */
	public Date getFechaTransaccion() {
		Date result = null;
		
		if (fechaTransaccion != null) {
			result = (Date) fechaTransaccion.clone();
		}
		
		return result;
	}

	/**
	 * Setea el objeto fecha transacción de este DTO.
	 * 
	 * @param fechaImputado Objeto fecha transacción de este DTO.
	 */
	public void setFechaTransaccion(Date fechaTransaccion) {
		if (fechaTransaccion != null) {
			this.fechaTransaccion = new Date(fechaTransaccion.getTime());
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
	 * Obtiene el objeto código medio pago de este DTO. 
	 * 
	 * @return Objeto código medio pago este DTO.
	 */
	public String getCodigoMedioPago() {
		return codigoMedioPago;
	}

	/**
	 * Setea el objeto código medio pago de este DTO.
	 * 
	 * @param codigoMedioPago Objeto código medio pago de este DTO.
	 */
	public void setCodigoMedioPago(String codigoMedioPago) {
		this.codigoMedioPago = codigoMedioPago;
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

	/**
	 * Obtiene el objeto email de este DTO. 
	 * 
	 * @return Objeto email este DTO.
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
	 * Obtiene el objeto apellidos de este DTO. 
	 * 
	 * @return Objeto apellidos este DTO.
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Setea el objeto apellidos de este DTO.
	 * 
	 * @param apellidos Objeto apellidos de este DTO.
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Obtiene el objeto nombres de este DTO. 
	 * 
	 * @return Objeto nombres este DTO.
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * Setea el objeto nombres de este DTO.
	 * 
	 * @param nombres Objeto nombres de este DTO.
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * Obtiene el objeto telefono de este DTO. 
	 * 
	 * @return Objeto telefono este DTO.
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
	 * Obtiene el objeto descripcionError de este DTO. 
	 * 
	 * @return Objeto descripcionError este DTO.
	 */
	public String getDescripcionError() {
		return descripcionError;
	}

	/**
	 * Setea el objeto descripcionError de este DTO.
	 * 
	 * @param descripcionError Objeto descripcionError de este DTO.
	 */
	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoAplicacionCliente: ").append(codigoAplicacionCliente);
		description.append(", idTransaccionCliente: ").append(idTransaccionCliente);
		description.append(", nombreItem: ").append(nombreItem);
		description.append(", fechaImputado: ").append(fechaImputado);
		description.append(", fechaTransaccion: ").append(fechaTransaccion);
		description.append(", estado: ").append(estado);
		description.append(", codigoMetodoPago: ").append(codigoMetodoPago);
		description.append(", codigoMedioPago: ").append(codigoMedioPago);
		description.append(", numeroTarjeta: ").append(numeroTarjeta);
		description.append(", codigoMoneda: ").append(codigoMoneda);
		description.append(", monto: ").append(monto);
		description.append(", montoPagado: ").append(montoPagado);
		description.append(", idTransaccionProveedor: ").append(idTransaccionProveedor);
		description.append(", codigoProveedor: ").append(codigoProveedor);
		description.append(", posibleFraude: ").append(posibleFraude);
		description.append(", motivoPosibleFraude: ").append(motivoPosibleFraude);
		description.append(", email: ").append(email);
		description.append(", apellidos: ").append(apellidos);
		description.append(", nombres: ").append(nombres);
		description.append(", telefono: ").append(telefono);
		description.append(", descripcionError: ").append(descripcionError);
		
		return description.toString();
	}
}
