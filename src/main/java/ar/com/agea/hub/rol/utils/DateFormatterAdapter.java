/*
 * @(#)DateFormatterAdapter.java		1.0 30/10/2013
 */

package ar.com.agea.hub.rol.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Representa un objeto Adapter para adaptar un objeto date a objeto string
 * y viceversa.
 * <p>
 * Esta clase es únicamente utilizada por la clase GWPNotificationDTO debido a que
 * necesita una representación XML de un objeto date a string.
 * 
 * @author		Juan Martín Lichowski
 * @author		Eduardo Barrera
 * @version		1.0 30/10/2013
 */
public class DateFormatterAdapter extends XmlAdapter<String, Date> {
	
	private static final String DATE_PATTERN = "yyyy-MM-dd hh:mm:sss";
	
	private SimpleDateFormat simpleDateFormat;
	
	/**
	 * Instancia un objeto de tipo DateFormatterAdapter.
	 */
	public DateFormatterAdapter() {
		simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
	}
	
	@Override
	public String marshal(Date value) throws Exception {
		return simpleDateFormat.format(value);
	}

	@Override
	public Date unmarshal(String value) throws Exception {
		return simpleDateFormat.parse(value);
	}
}
