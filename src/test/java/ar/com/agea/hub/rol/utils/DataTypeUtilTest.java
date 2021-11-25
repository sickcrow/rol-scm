/*
 * @(#)DataTypeUtilTest.java		1.0 06/12/2013
 */

package ar.com.agea.hub.rol.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;

/**
 * Representa JUnit Tests de inicialización para la clase DTOFactory.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/12/2013
 */
public class DataTypeUtilTest extends InstantiationTest {

	/**
	 * Comprueba la ejecución de método isEmpty para objetos String de la clase DataTypeUtil. 
	 */
	@Test
	public void testIsEmptyForStringMethod() {
		String value = null;
		
		Boolean isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertTrue("Ha fallado la llamada al método \"isEmpty\" para objetos String de la clase \"DataTypeUtil\".",
				isEmpty);

		value = "";
		
		isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertTrue("Ha fallado la llamada al método \"isEmpty\" para objetos String de la clase \"DataTypeUtil\".",
				isEmpty);
		
		value = "   ";
		
		isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertTrue("Ha fallado la llamada al método \"isEmpty\" para objetos String de la clase \"DataTypeUtil\".",
				isEmpty);
		
		value = "VALUE";
		
		isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertFalse("Ha fallado la llamada al método \"isEmpty\" para objetos String de la clase \"DataTypeUtil\".",
				isEmpty);
	}
	
	/**
	 * Comprueba la ejecución de método isEmpty para objetos Double de la clase DataTypeUtil. 
	 */
	@Test
	public void testIsEmptyForDoubleMethod() {
		Double value = null;
		
		Boolean isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertTrue("Ha fallado la llamada al método \"isEmpty\" para objetos Double de la clase \"DataTypeUtil\".",
				isEmpty);

		value = 0.0;
		
		isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertTrue("Ha fallado la llamada al método \"isEmpty\" para objetos Double de la clase \"DataTypeUtil\".",
				isEmpty);
		
		value = 300.0;
		
		isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertFalse("Ha fallado la llamada al método \"isEmpty\" para objetos Double de la clase \"DataTypeUtil\".",
				isEmpty);
	}
	
	/**
	 * Comprueba la ejecución de método isEmpty para objetos Integer de la clase DataTypeUtil. 
	 */
	@Test
	public void testIsEmptyForIntegerMethod() {
		Integer value = null;
		
		Boolean isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertTrue("Ha fallado la llamada al método \"isEmpty\" para objetos Integer de la clase \"DataTypeUtil\".",
				isEmpty);

		value = 0;
		
		isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertTrue("Ha fallado la llamada al método \"isEmpty\" para objetos Integer de la clase \"DataTypeUtil\".",
				isEmpty);
		
		value = 300;
		
		isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertFalse("Ha fallado la llamada al método \"isEmpty\" para objetos Integer de la clase \"DataTypeUtil\".",
				isEmpty);
	}
	
	/**
	 * Comprueba la ejecución de método isEmpty para objetos Long de la clase DataTypeUtil. 
	 */
	@Test
	public void testIsEmptyForLongMethod() {
		Long value = null;
		
		Boolean isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertTrue("Ha fallado la llamada al método \"isEmpty\" para objetos Long de la clase \"DataTypeUtil\".",
				isEmpty);

		value = 0L;
		
		isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertTrue("Ha fallado la llamada al método \"isEmpty\" para objetos Long de la clase \"DataTypeUtil\".",
				isEmpty);
		
		value = 300L;
		
		isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertFalse("Ha fallado la llamada al método \"isEmpty\" para objetos Long de la clase \"DataTypeUtil\".",
				isEmpty);
	}
	
	/**
	 * Comprueba la ejecución de método isEmpty para objetos Date de la clase DataTypeUtil. 
	 */
	@Test
	public void testIsEmptyForDateMethod() {
		Date value = null;
		
		Boolean isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertTrue("Ha fallado la llamada al método \"isEmpty\" para objetos Date de la clase \"DataTypeUtil\".",
				isEmpty);

		value = new Date();
		
		isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertFalse("Ha fallado la llamada al método \"isEmpty\" para objetos Date de la clase \"DataTypeUtil\".",
				isEmpty);
	}
	
	/**
	 * Comprueba la ejecución de método isEmpty para objetos Collection de la clase DataTypeUtil. 
	 */
	@Test
	public void testIsEmptyForCollectionMethod() {
		Collection<Object> value = null;
		
		Boolean isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertTrue("Ha fallado la llamada al método \"isEmpty\" para objetos Collection de la clase \"DataTypeUtil\".",
				isEmpty);

		value = new ArrayList<Object>();
		
		isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertTrue("Ha fallado la llamada al método \"isEmpty\" para objetos Collection de la clase \"DataTypeUtil\".",
				isEmpty);
		
		value.add(new Object());
		
		isEmpty = DataTypeUtil.isEmpty(value);
		
		Assert.assertFalse("Ha fallado la llamada al método \"isEmpty\" para objetos Collection de la clase \"DataTypeUtil\".",
				isEmpty);
	}
}
