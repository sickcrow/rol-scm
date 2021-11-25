/*
 * @(#)GWPCredentials.java		1.0 03/10/2013
 */
package ar.com.agea.hub.rol.credentials;

/**
 * Representa las credenciales necesarias para invokar los servicios GWP.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 03/10/2013
 */
public class GWPCredentials {

	private String codigoAplicacionCliente;
	private String llaveAplicacionCliente;
			
	/**
	 * Instancia un objeto de tipo GWPCredentials.
	 */
	public GWPCredentials(String codigoAplicacionCliente, String llaveAplicacionCliente) {
		this.codigoAplicacionCliente = codigoAplicacionCliente;
		this.llaveAplicacionCliente = llaveAplicacionCliente;
	}

	/**
	 * Obtiene el objeto c�digo aplicaci�n cliente de este objeto. 
	 * 
	 * @return Objeto c�digo aplicaci�n cliente de este objeto.
	 */
	public String getCodigoAplicacionCliente() {
		return codigoAplicacionCliente;
	}

	/**
	 * Setea el objeto c�digo aplicaci�n cliente de este objeto.
	 * 
	 * @param codigoAplicacionCliente Objeto c�digo aplicaci�n cliente de este objeto.
	 */
	public void setCodigoAplicacionCliente(String codigoAplicacionCliente) {
		this.codigoAplicacionCliente = codigoAplicacionCliente;
	}

	/**
	 * Obtiene el objeto llave aplicaci�n cliente de este objeto. 
	 * 
	 * @return Objeto llave aplicaci�n cliente de este objeto.
	 */
	public String getLlaveAplicacionCliente() {
		return llaveAplicacionCliente;
	}

	/**
	 * Setea el objeto llave aplicaci�n cliente de este objeto.
	 * 
	 * @param llaveAplicacionCliente Objeto llave aplicaci�n cliente de este objeto.
	 */
	public void setLlaveAplicacionCliente(String llaveAplicacionCliente) {
		this.llaveAplicacionCliente = llaveAplicacionCliente;
	}
}
