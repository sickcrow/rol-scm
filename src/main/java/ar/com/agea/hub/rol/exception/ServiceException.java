/*
 * @(#)ServiceException.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.exception;

/**
 * Representa un incorrecto funcionamiento de servicio.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = -1445225136784994161L;
	
	/**
	 * Instancia un objeto de tipo ServiceException. No contiene
	 * mensaje ni encapsula excepción.
	 */
	public ServiceException() {}

	/**
	 * Instancia un objeto de tipo ServiceException a partir de un
	 * mensaje y excepción.
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instancia un objeto de tipo ServiceException a partir de un
	 * mensaje. No encapsula excepción.
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * Instancia un objeto de tipo ServiceException a partir de una
	 * excepción. No contiene mensaje.
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}
}
