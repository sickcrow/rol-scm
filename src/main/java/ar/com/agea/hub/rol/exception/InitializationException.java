/*
 * @(#)InitializationException.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.exception;

/**
 * Representa una incorrecta inicializaci�n de componente.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class InitializationException extends RuntimeException {

	private static final long serialVersionUID = -1445225136784994161L;
	
	/**
	 * Instancia un objeto de tipo InitializationException. No contiene
	 * mensaje ni encapsula excepci�n.
	 */
	public InitializationException() {}

	/**
	 * Instancia un objeto de tipo InitializationException a partir de un
	 * mensaje y excepci�n.
	 */
	public InitializationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instancia un objeto de tipo InitializationException a partir de un
	 * mensaje. No encapsula excepci�n.
	 */
	public InitializationException(String message) {
		super(message);
	}

	/**
	 * Instancia un objeto de tipo InitializationException a partir de una
	 * excepci�n. No contiene mensaje.
	 */
	public InitializationException(Throwable cause) {
		super(cause);
	}
}
