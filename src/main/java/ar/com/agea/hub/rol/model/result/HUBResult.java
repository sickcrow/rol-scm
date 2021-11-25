/*
 * @(#)HUBResult.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.model.result;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Representa los resultados de los servicios HUB.
 * <p>
 * Estos resultados son utilizados por Spring Web MVC para convertir
 * los objetos JSON que retornan los servicios HUB a objetos Java
 * utilizados por la aplicación. Esta clase es utilizada en conjunto
 * con ErrorType y Error.
 * <p>
 * Esta clase encapsula dos objetos llamados 'object' y 'errors'.
 * <p>
 * Es importante tener en cuenta que solo uno de los dos objetos
 * contendrá valores mientras que el otro permanecerá con valor null.
 * <p>
 * Si el resultado retornado produjo un error el objeto 'object' es null
 * mientras que 'errors' contiene todos los errores producidos.
 * En caso que el resultado no haya resultado en un error, el objeto 'object'
 * contiene el objeto como resultado de la ejecución del servicio HUB.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public abstract class HUBResult<T> implements Serializable {
	
	private static final long serialVersionUID = 5110526804055479463L;

	private T object;
	private Set<HUBError> errors;
	
	/**
	 * Instancia un objeto de tipo HUBResult.
	 * <p>
	 * La instanciación se realiza a partir de sus clases derivadas.
	 */
	protected HUBResult() {
		errors = new HashSet<HUBError>();
	}

	/**
	 * Obtiene el objeto resultado del servicio HUB.
	 * 
	 * @return Objeto resultado del servicio HUB.
	 */
	public T getObject() {
		return object;
	}

	/**
	 * Setea el objeto resultado del servicio HUB.
	 * 
	 * @param object Objeto resultado del servicio HUB.
	 */
	public void setObject(T object) {
		this.object = object;
	}

	/**
	 * Obtiene los objetos errores del servicio HUB.
	 * 
	 * @return Objeto errores del servicio HUB.
	 */
	public Set<HUBError> getErrors() {
		return errors;
	}

	/**
	 * Setea los objetos errores del servicio HUB.
	 * 
	 * @param errors Objeto errores del serivio HUB.
	 */
	public void setErrors(Set<HUBError> errors) {
		this.errors = errors;
	}

	/**
	 * Indica si el objeto contiene errores como resultado
	 * de los servicios HUB.
	 * 
	 * @return Objeto boolean que indica si contiene errores.
	 */
	public boolean hasErrors() {
		return errors != null && !errors.isEmpty();
	}
}
