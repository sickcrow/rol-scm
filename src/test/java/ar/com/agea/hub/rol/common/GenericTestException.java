/*
 * @(#)GenericTestException.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.common;

/**
 * Representa una excepción genérica ocurrida en el entorno de JUnit.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class GenericTestException extends RuntimeException {

	private static final long serialVersionUID = -1445225136784994161L;
	
	/**
	 * Instancia un objeto de tipo GenericTestException. No contiene
	 * mensaje ni encapsula excepción.
	 */
	public GenericTestException() {}

	/**
	 * Instancia un objeto de tipo GenericTestException a partir de un
	 * mensaje y excepción.
	 */
	public GenericTestException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instancia un objeto de tipo GenericTestException a partir de un
	 * mensaje. No encapsula excepción.
	 */
	public GenericTestException(String message) {
		super(message);
	}

	/**
	 * Instancia un objeto de tipo GenericTestException a partir de una
	 * excepción. No contiene mensaje.
	 */
	public GenericTestException(Throwable cause) {
		super(cause);
	}
}
