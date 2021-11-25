/*
 * @(#)GWPTransactionDTO.java		1.0 30/10/2013
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
public class GWPTransactionDTO implements JSONDTO {
	
	private static final long serialVersionUID = -7363671239162739317L;

	private String codigoAplicacionCliente;
	private String llaveAplicacionCliente;
	private String idTransaccionCliente;
	private String nombreItem;
	private String apellidos;
	private String nombres;
	private String mail;
	private String telefono;
	private String tipoTransaccion;
	private Integer numeroCliente;
	private String numeroFactura;
	private Date fechaVencimiento;
	private String codigoMetodoPago;
	private String codigoMedioPago;
	private Integer cantidadCuotas;
	private String codigoMoneda;
	private Double monto;
	private String urlImagen;
	private String urlExito;
	private String urlFracaso;

	/**
	 * Obtiene el objeto código aplicación cliente de este DTO. 
	 * 
	 * @return Objeto código aplicación cliente id este DTO.
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
	 * Obtiene el objeto llave aplicación cliente de este DTO. 
	 * 
	 * @return Objeto llave aplicación cliente id este DTO.
	 */
	public String getLlaveAplicacionCliente() {
		return llaveAplicacionCliente;
	}

	/**
	 * Setea el objeto llave aplicación cliente de este DTO.
	 * 
	 * @param llaveAplicacionCliente Objeto llave aplicación cliente de este DTO.
	 */
	public void setLlaveAplicacionCliente(String llaveAplicacionCliente) {
		this.llaveAplicacionCliente = llaveAplicacionCliente;
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
	 * @return Objeto nombre ítem id este DTO.
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
	 * Obtiene el objeto mail de este DTO. 
	 * 
	 * @return Objeto mail este DTO.
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Setea el objeto mail de este DTO.
	 * 
	 * @param mail Objeto mail de este DTO.
	 */
	public void setMail(String mail) {
		this.mail = mail;
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
	 * Obtiene el objeto tipo transacción de este DTO. 
	 * 
	 * @return Objeto tipo transacción este DTO.
	 */
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	/**
	 * Setea el objeto tipo transacción de este DTO.
	 * 
	 * @param tipoTransaccion Objeto tipo transacción de este DTO.
	 */
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	
	/**
	 * Obtiene el objeto número cliente de este DTO. 
	 * 
	 * @return Objeto número cliente este DTO.
	 */
	public Integer getNumeroCliente() {
		return numeroCliente;
	}

	/**
	 * Setea el objeto número cliente de este DTO.
	 * 
	 * @param numeroCliente Objeto número cliente de este DTO.
	 */
	public void setNumeroCliente(Integer numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	
	/**
	 * Obtiene el objeto número factura de este DTO. 
	 * 
	 * @return Objeto número factura este DTO.
	 */
	public String getNumeroFactura() {
		return numeroFactura;
	}

	/**
	 * Setea el objeto número factura de este DTO.
	 * 
	 * @param numeroFactura Objeto número factura de este DTO.
	 */
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	
	/**
	 * Obtiene el objeto fecha vencimiento de este DTO. 
	 * 
	 * @return Objeto fecha vencimiento este DTO.
	 */
	public Date getFechaVencimiento() {
		Date result = null;
		
		if (fechaVencimiento != null) {
			result = (Date) fechaVencimiento.clone();
		}
		
		return result;
	}

	/**
	 * Setea el objeto fecha vencimiento de este DTO.
	 * 
	 * @param fechaVencimiento Objeto fecha vencimiento de este DTO.
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		if (fechaVencimiento != null) {
			this.fechaVencimiento = new Date(fechaVencimiento.getTime());
		}
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
	 * Obtiene el objeto cantidad cuotas de este DTO. 
	 * 
	 * @return Objeto cantidad cuotas este DTO.
	 */
	public Integer getCantidadCuotas() {
		return cantidadCuotas;
	}

	/**
	 * Setea el objeto cantidad cuotas de este DTO.
	 * 
	 * @param cantidadCuotas Objeto cantidad cuotas de este DTO.
	 */
	public void setCantidadCuotas(Integer cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}
	
	/**
	 * Obtiene el objeto código moneda de este DTO. 
	 * 
	 * @return Objeto código moneda id este DTO.
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
	 * Obtiene el objeto urlImagen de este DTO. 
	 * 
	 * @return Objeto urlImagen este DTO.
	 */
	public String getUrlImagen() {
		return urlImagen;
	}

	/**
	 * Setea el objeto urlImagen de este DTO.
	 * 
	 * @param urlImagen Objeto urlImagen de este DTO.
	 */
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	/**
	 * Obtiene el objeto url éxito de este DTO. 
	 * 
	 * @return Objeto url éxito este DTO.
	 */
	public String getUrlExito() {
		return urlExito;
	}

	/**
	 * Setea el objeto url éxito de este DTO.
	 * 
	 * @param urlExito Objeto url éxito de este DTO.
	 */
	public void setUrlExito(String urlExito) {
		this.urlExito = urlExito;
	}

	/**
	 * Obtiene el objeto url fracaso de este DTO. 
	 * 
	 * @return Objeto url fracaso este DTO.
	 */
	public String getUrlFracaso() {
		return urlFracaso;
	}

	/**
	 * Setea el objeto url fracaso de este DTO.
	 * 
	 * @param urlFracaso Objeto url fracaso de este DTO.
	 */
	public void setUrlFracaso(String urlFracaso) {
		this.urlFracaso = urlFracaso;
	}

	@Override
	public String toString() {
		StringBuilder description = new StringBuilder();
		
		description.append("codigoAplicacionCliente: ").append(codigoAplicacionCliente);
		description.append(", llaveAplicacionCliente: ").append(llaveAplicacionCliente);
		description.append(", idTransaccionCliente: ").append(idTransaccionCliente);
		description.append(", nombreItem: ").append(nombreItem);
		description.append(", apellidos: ").append(apellidos);
		description.append(", nombres: ").append(nombres);
		description.append(", mail: ").append(mail);
		description.append(", telefono: ").append(telefono);
		description.append(", tipoTransaccion: ").append(tipoTransaccion);
		description.append(", numeroCliente: ").append(numeroCliente);
		description.append(", numeroFactura: ").append(numeroFactura);
		description.append(", fechaVencimiento: ").append(fechaVencimiento);
		description.append(", codigoMetodoPago: ").append(codigoMetodoPago);
		description.append(", codigoMedioPago: ").append(codigoMedioPago);
		description.append(", cantidadCuotas: ").append(cantidadCuotas);
		description.append(", codigoMoneda: ").append(codigoMoneda);
		description.append(", monto: ").append(monto);
		description.append(", urlImagen: ").append(urlImagen);
		description.append(", urlExito: ").append(urlExito);
		description.append(", urlFracaso: ").append(urlFracaso);
		
		return description.toString();
	}
}
