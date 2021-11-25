/*
 * @(#)DoubleFormatterAdapter.java		1.0 30/10/2013
 */

package ar.com.agea.hub.rol.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Representa un objeto Adapter para adaptar un objeto double a objeto string
 * y viceversa.
 * <p>
 * Esta clase es únicamente utilizada por la clase GWPNotificationDTO debido a que
 * necesita una representación XML de un objeto double a string.
 * 
 * @author		Juan Martín Lichowski
 * @author		Eduardo Barrera
 * @version		1.0 30/10/2013
 */
public class DoubleFormatterAdapter extends XmlAdapter<String, Double> {

	private static final String SLASH_POINT_CHARACTERS = "\\."; 
	private static final String NONE_CHARACTER = "";
	private static final String COMMA_CHARACTER = ",";
	private static final String DOT_CHARACTER = ".";
	
	@Override
	public String marshal(Double value) throws Exception {
		return String.valueOf(value);
	}

	@Override
	public Double unmarshal(String value) throws Exception {
		String tmp = value;
		
		tmp = tmp.replaceAll(SLASH_POINT_CHARACTERS, NONE_CHARACTER);
		tmp = tmp.replaceAll(COMMA_CHARACTER, DOT_CHARACTER);
		
		return Double.parseDouble(tmp);
	}
}
