/*
 * @(#)ComparatorContext.java		1.0 26/03/2014
 */

package ar.com.agea.hub.rol.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author		Eduardo Barrera
 * @version		1.0 26/03/2014
 */
public class ComparatorContext {

	private Map<ComparatorParameterType, Object> parameters;
	
	public ComparatorContext() {
		parameters = new HashMap<ComparatorParameterType, Object>();
	}
	
	public boolean putParameter(ComparatorParameterType key, Object value) {
		return parameters.put(key, value) != null;
	}
	
	public boolean remove(ComparatorParameterType key) {
		return parameters.remove(key) != null;
	}
	
	public Object getParameter(ComparatorParameterType key) {
		Object parameter = null;
				
		if (parameters.containsKey(key)) {
			parameter = parameters.get(key);
		}
		
		return parameter;
	}

	public boolean contains(ComparatorParameterType key) {
		return parameters.containsKey(key);
	}
}
