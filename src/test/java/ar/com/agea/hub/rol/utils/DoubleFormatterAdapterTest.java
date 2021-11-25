/*
 * @(#)DoubleFormatterAdapterTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.utils;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicializaci�n para la clase DoubleFormatterAdapter.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class DoubleFormatterAdapterTest extends InstantiationTest {

	/**
	 * Comprueba la creaci�n de objeto de tipo DoubleFormatterAdapter.
	 */
	@Test
	public void testConstructor() {
		DoubleFormatterAdapter dto = new DoubleFormatterAdapter();
		
		Assert.assertNotNull("Ha fallado la creaci�n del objeto de tipo \"DoubleFormatterAdapter\""
				+ " utilizando el constructor por defecto.", dto);
	}
	
	/**
	 * Comprueba la ejecuci�n de m�todo marshal de la clase DoubleFormatterAdapter. 
	 */
	@Test
	public void testMarshalAndUnmarshalMethod() {
		DoubleFormatterAdapter adapter = new DoubleFormatterAdapter();
		Double doubleValue = 300.0;
		
		String stringValue = null;
		
		try {
			stringValue = adapter.marshal(doubleValue);
		} catch (Exception e) {
			Assert.assertNotNull("Ha fallado la llamada al m�todo \"marshal\" de la clase \"DoubleFormatterAdapter\"."
					+ " Ha ocurrido una excepcion.", stringValue);
		}
		
		Assert.assertNotNull("Ha fallado la llamada al m�todo \"marshal\" de la clase \"DoubleFormatterAdapter\".",
				stringValue);

		try {
			doubleValue = adapter.unmarshal(stringValue);
		} catch (Exception e) {
			Assert.assertNotNull("Ha fallado la llamada al m�todo \"unmarshal\" de la clase \"DoubleFormatterAdapter\"."
					+ " Ha ocurrido una excepcion.", doubleValue);
		}

		Assert.assertNotNull("Ha fallado la llamada al m�todo \"unmarshal\" de la clase \"DoubleFormatterAdapter\".",
				doubleValue);
	}
}
