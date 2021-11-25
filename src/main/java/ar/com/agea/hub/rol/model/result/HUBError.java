/*
 * @(#)HUBError.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.io.Serializable;

/**
 * Representa los errores de los servicios HUB.
 * <p>
 * Estos errores son utilizados por Spring Web MVC para convertir
 * los objetos JSON que retornan los servicios HUB a objetos Java
 * utilizados por la aplicación. Esta clase es utilizada en conjunto
 * con Result y ErrorType.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public final class HUBError implements Serializable {

	private static final long serialVersionUID = -8394817224636312200L;
	
	private HUBErrorType errorType;
	private String message;
	
	/**
	 * Obtiene el objeto tipo error de este error.
	 * 
	 * @return Objeto tipo error de este error.
	 */
	public HUBErrorType getErrorType() {
		return errorType;
	}

	/**
	 * Setea el objeto tipo error de este error.
	 * 
	 * @param errorType Objeto tipo error de este error.
	 */
	public void setErrorType(HUBErrorType errorType) {
		this.errorType = errorType;
	}

	/**
	 * Obtiene el objeto mensaje de este error. 
	 * 
	 * @return Objeto mensaje de este error.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setea el objeto mensaje de este error.
	 * 
	 * @param message Objeto mensaje de este error.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((errorType == null) ? 0 : errorType.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		HUBError other = (HUBError) obj;
		
		if (errorType != other.errorType) {
			return false;
		}
		
		if (message == null) {
			if (other.message != null) {
				return false;
			}
		} else if (!message.equals(other.message)) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return message;
	}
}
