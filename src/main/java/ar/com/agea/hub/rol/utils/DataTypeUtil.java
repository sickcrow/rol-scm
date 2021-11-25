/*
 * @(#)DataTypeUtil.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.utils;

import java.util.Collection;
import java.util.Date;

/**
 * Representa un objeto para la verificación de diferentes tipos de datos
 * cuyo valor equivale a vacío.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public final class DataTypeUtil {
	
	private DataTypeUtil() {}

	/**
	 * Verifica si el objeto value equivale a vacío.
	 * 
	 * @param value Objeto string a verificar.
	 * @return Objeto boolean que indica si el valor string equivale a vacío. 
	 */
	public static boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}

	/**
	 * Verifica si el objeto value equivale a vacío.
	 * 
	 * @param value Objeto double a verificar.
	 * @return Objeto boolean que indica si el valor double equivale a vacío.
	 */
	public static boolean isEmpty(Double value) {
		return value == null || value.equals(0.0);
	}
	
	/**
	 * Verifica si el objeto value equivale a vacío.
	 * 
	 * @param value Objeto integer a verificar.
	 * @return Objeto boolean que indica si el valor integer equivale a vacío.
	 */
	public static boolean isEmpty(Integer value) {
		return value == null || value.equals(0);
	}

	/**
	 * Verifica si el objeto value equivale a vacío.
	 * 
	 * @param value Objeto long a verificar.
	 * @return Objeto boolean que indica si el valor long equivale a vacío.
	 */
	public static boolean isEmpty(Long value) {
		return value == null || value.equals(0L);
	}
	
	/**
	 * Verifica si el objeto value equivale a vacío.
	 * 
	 * @param value Objeto date a verificar.
	 * @return Objeto boolean que indica si el valor date equivale a vacío.
	 */
	public static boolean isEmpty(Date value) {
		return value == null;
	}
	
	/**
	 * Verifica si el objeto value equivale a vacío.
	 * 
	 * @param value Objeto colección a verificar.
	 * @return Objeto boolean que indica si el valor colección equivale a vacío.
	 */
	public static boolean isEmpty(Collection<?> value) {
		return value == null || value.isEmpty();
	}
}
