/*
 * @(#)ServiceTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.common;

import java.io.IOException;

import ar.com.agea.hub.rol.utils.JSONFactory;

/**
 * Brinda una intefaz unificada a todos los JUnit Tests para el acceso
 * a los servicios publicados en HUB y PASE.
 * <p>
 * Todos los JUnit Tests relacionados con tests de servicios HUB y PASE
 * deben extender de esta clase para heredar y
 * utilizar sus prestaciones.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public abstract class ServiceTest extends SpringContextTest {
	
	/**
	 * Obtiene un objeto de una clase específica a partir de un objeto FileName que representa el archivo JSON a utilizar
	 * y la clase que representa dicho archivo.
	 * 
	 * @param fileName Nombre del archivo JSON.
	 * @param clazz Objeto que representa el archivo JSON.
	 * @return Objeto que representa el archivo JSON con su contenido. 
	 */
	protected <T> T getJSON(FileName fileName, Class<T> clazz) {
		T result = null;
		
		try {
			result = JSONFactory.createObject(getFileContent(fileName), clazz);
		} catch (IOException e) {
			throw new GenericTestException("Se produjo un error al leer o convertir contenido de archivos.", e);
		}
		
		return result;
	}
}
