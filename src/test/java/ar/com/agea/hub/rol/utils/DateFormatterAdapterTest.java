/*
 * @(#)DateFormatterAdapterTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.utils;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase DateFormatterAdapter.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class DateFormatterAdapterTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo DateFormatterAdapter.
	 */
	@Test
	public void testConstructor() {
		DateFormatterAdapter dto = new DateFormatterAdapter();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"DateFormatterAdapter\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo marshal de la clase DateFormatterAdapter. 
	 */
	@Test
	public void testMarshalAndUnmarshalMethod() {
		DateFormatterAdapter adapter = new DateFormatterAdapter();
		Date dateValue = new Date();
		
		String stringValue = null;
		
		try {
			stringValue = adapter.marshal(dateValue);
		} catch (Exception e) {
			Assert.assertNotNull("Ha fallado la llamada al m�todo \"marshal\" de la clase \"DateFormatterAdapter\"."
					+ " Ha ocurrido una excepcion.", stringValue);
		}
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"marshal\" de la clase \"DateFormatterAdapter\".",
				stringValue);

		try {
			dateValue = adapter.unmarshal(stringValue);
		} catch (Exception e) {
			Assert.assertNotNull("Ha fallado la llamada al m�todo \"unmarshal\" de la clase \"DateFormatterAdapter\"."
					+ " Ha ocurrido una excepcion.", dateValue);
		}

		Assert.assertNotNull("Ha fallado la llamada al m�todo \"unmarshal\" de la clase \"DateFormatterAdapter\".",
				dateValue);
	}
}
