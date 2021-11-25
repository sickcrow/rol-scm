/*
 * @(#)ROLResult.java		1.0 26/08/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Representa los resultados de los servicios ROL.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 26/08/2013
 */
public class ROLResult implements Serializable {
	
	private static final long serialVersionUID = 5110526804055479463L;

	private Object object;
	private Set<ROLError> errors;
	
	/**
	 * Instancia un objeto de tipo ROLResult.
	 */
	public ROLResult() {
		errors = new HashSet<ROLError>();
	}

	/**
	 * Obtiene el objeto resultado del servicio ROL.
	 * 
	 * @return Objeto resultado del servicio ROL.
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * Setea el objeto resultado del servicio ROL.
	 * 
	 * @param object Objeto resultado del servicio ROL.
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * Obtiene los objetos errores del servicio ROL.
	 * 
	 * @return Objeto errores del servicio ROL.
	 */
	public Set<ROLError> getErrors() {
		return errors;
	}

	/**
	 * Setea los objetos errores del servicio ROL.
	 * 
	 * @param errors Objeto errores del serivio ROL.
	 */
	public void setErrors(Set<ROLError> errors) {
		this.errors = errors;
	}

	/**
	 * Agrega el objeto error ha este objeto.
	 * 
	 * @param error Objeto error a agregar.
	 * @return Objeto boolean que indica si el objeto error se agregó.
	 */
	public boolean addError(ROLError error) {
		return errors.add(error);
	}
	
	/**
	 * Agrega el objeto tipo error y mensaje a este objeto.
	 * 
	 * @param errorType Objeto tipo error a agregar.
	 * @param message Objeto mensaje a agregar.
	 * @return Objeto boolean que indica si el objeto error se agregó.
	 */
	public boolean addError(ROLErrorType errorType, String message) {
		ROLError error = new ROLError();
		
		error.setErrorType(errorType);
		error.setMessage(message);
		
		return addError(error);
	}
	
	/**
	 * Agrega los objetos errores a este objeto.
	 * 
	 * @param errors Objetos errores a agregar.
	 * @return Objeto boolean que indica si los objetos errores se agregaron.
	 */
	public boolean addErrors(Set<ROLError> errors) {
		return this.errors.addAll(errors);
	}
	
	/**
	 * Remueve el objeto error ha este objeto.
	 * 
	 * @param error Objeto error a remover.
	 * @return Objeto boolean que indica si el objeto error se removió.
	 */
	public boolean removeError(ROLError error) {
		return errors.remove(error);
	}
	
	/**
	 * Remueve los objetos errores a este objeto.
	 * 
	 * @param errors Objetos errores a remover.
	 * @return Objeto boolean que indica si los objetos errores se removieron.
	 */
	public boolean removeErrors(Set<ROLError> errors) {
		return this.errors.removeAll(errors);
	}

	/**
	 * Indica si el objeto contiene errores como resultado
	 * de los servicios ROL.
	 * 
	 * @return Objeto boolean que indica si contiene errores.
	 */
	public boolean hasErrors() {
		return errors != null && !errors.isEmpty();
	}
}
