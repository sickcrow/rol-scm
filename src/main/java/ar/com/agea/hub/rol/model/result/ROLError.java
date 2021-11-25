/*
 * @(#)ROLError.java		1.0 26/09/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.io.Serializable;

/**
 * Representa los errores de los servicios ROL.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/09/2013
 */
public final class ROLError implements Serializable {

	private static final long serialVersionUID = -8394817224636312200L;
	
	private ROLErrorType errorType;
	private ROLFieldName fieldName;
	private ROLMessageCode messageCode;
	private String message;

	/**
	 * Obtiene el objeto tipo error de este error.
	 * 
	 * @return Objeto tipo error de este error.
	 */
	public ROLErrorType getErrorType() {
		return errorType;
	}

	/**
	 * Setea el objeto tipo error de este error.
	 * 
	 * @param errorType Objeto tipo error de este error.
	 */
	public void setErrorType(ROLErrorType errorType) {
		this.errorType = errorType;
	}

	/**
	 * Obtiene el objeto nombre campo de este error.
	 * 
	 * @return Objeto nombre campo de este error.
	 */
	public ROLFieldName getFieldName() {
		return fieldName;
	}

	/**
	 * Setea el objeto nombre campo de este error.
	 * 
	 * @param fieldName Objeto nombre campo de este error.
	 */
	public void setFieldName(ROLFieldName fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * Obtiene el objeto código mensaje de este error.
	 * 
	 * @return Objeto código mensaje de este error.
	 */
	public ROLMessageCode getMessageCode() {
		return messageCode;
	}

	/**
	 * Setea el objeto código mensaje de este error.
	 * 
	 * @param messageCode Objeto código mensaje de este error.
	 */
	public void setMessageCode(ROLMessageCode messageCode) {
		this.messageCode = messageCode;
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
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result + ((messageCode == null) ? 0 : messageCode.hashCode());
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
		
		ROLError other = (ROLError) obj;
		
		if (errorType != other.errorType) {
			return false;
		}
		
		if (fieldName != other.fieldName) {
			return false;
		}
		
		if (messageCode != other.messageCode) {
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
