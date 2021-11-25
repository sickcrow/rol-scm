/*
 * @(#)JSONFactory.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.utils;

import java.io.IOException;
import java.util.Set;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Representa un objeto Factory para crear objetos de clases espec�ficas
 * a partir de otros objetos que representan objetos JSON y viceverza.
 *  
 * @author		Eduardo Barrera
 * @author		Juan Mart�n Lichowski
 * @version		1.0 06/06/2013
 */
public final class JSONFactory {
	
	private static final String PATRON_JSON = "\":\\[\"?.*?\"?\\]";
	private static final String VALOR_REEMPLAZO = "\":\\[\"*******\"\\]";

	private static ObjectMapper mapper;
	
	static {
		mapper = new ObjectMapper();
	}
	
	private JSONFactory() {}

	/**
	 * Crea un objeto String a partir de un objeto de una clase espec�fica
	 * que representa un objeto JSON.
	 * 
	 * @param object Objeto a partir del cual se crea un objeto String. 
	 * @return Objeto String creado.
	 * @throws IOException Cuando existe un error de lectura del objeto JSON.
	 */
	public static <T> String createJSONObjectAsString(T object) throws IOException {
		return mapper.writeValueAsString(object);
	}

	/**
	 * Crea un objeto de una clase espec�fica a partir de un objeto String
	 * que representa un objeto JSON. 
	 * 
	 * @param json Objeto String a partir del cual se crea un objeto espec�fico.
	 * @param clazz Objeto Class que indica el objeto espec�fico a crear.
	 * @return Objeto de clase espec�fica creado.
	 * @throws IOException Cuando existe un error de lectura del objeto JSON.
	 */
	public static <T> T createObject(String json, Class<T> clazz) throws IOException {
		return mapper.readValue(json, clazz);
	}
	
	/**
	 * Crea un conjunto de objetos de una clase espec�fica a partir de un objeto TypeReference
	 * que representa un conjunto de objetos JSON.
	 * 
	 * @param json Objeto String a partir del cual se crea un objeto espec�fico.
	 * @param typeReference Objeto TypeReference que indica el conjunto de objetos espec�ficos a crear.
	 * @return Objetos de clase espec�fica creados.
	 * @throws IOException Cuando existe un error de lectura del objeto JSON.
	 */
	public static <T> T createObject(String json, TypeReference<T> typeReference) throws IOException {
		return mapper.readValue(json, typeReference);
	}
	
	/**
	 * Crea un objeto String a partir de un objeto de una clase espec�fica
	 * que representa un objeto JSON y ofusca los valores de sus campos cuyo nombres
	 * se encuentren en un conjunto de objetos String.
	 * 
	 * @param object Objeto a partir del cual se crea un objeto String.
	 * @param fieldsToObfuscate Objetos DTOFieldName que representan los campos cuyos valores deben ser ofuscados.
	 * @return Objeto String creado.
	 * @throws IOException Cuando existe un error de lectura del objeto JSON.
	 */
	public static <T> String createJSONObjectAsStringObfuscated(T object, Set<DTOFieldName> fieldsToObfuscate) throws IOException {
		String json = mapper.writeValueAsString(object);
		
		for (DTOFieldName field : fieldsToObfuscate) {
			if (json.contains(field.getName())) {
				json = Pattern.compile(field.getName() + PATRON_JSON).matcher(json).replaceAll(field.getName() + VALOR_REEMPLAZO);
			}
		}
		
		return json;
	} 
}
