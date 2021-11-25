/*
 * @(#)URLServiceResolverTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.utils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.exception.InitializationException;

/**
 * Representa JUnit Tests de inicialización para la clase URLServiceResolver.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class URLServiceResolverTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo URLServiceResolver.
	 */
	@Test
	public void testConstructor() {
		Map<URLName, String> urlsName = null;
		Map<URLServiceName, String> urls = null;
		
		URLServiceResolver urlServiceResolver = new URLServiceResolver(urlsName, urls);
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"URLServiceResolver\".",
				urlServiceResolver);
	}

	/**
	 * Comprueba la ejecución de método init de la clase URLServiceResolver. 
	 */
	@Test
	public void testFirstInitMethod() {
		Map<URLName, String> urlsName = null;
		Map<URLServiceName, String> urls = null;
		URLServiceResolver urlServiceResolver = new URLServiceResolver(urlsName, urls);
		boolean isException = false;
		
		try {
			urlServiceResolver.init();
		} catch (InitializationException ie) {
			isException = true;
		}
		
		Assert.assertTrue("Ha fallado la llamada al método \"init\" de la clase \"URLServiceResolver\".",
				isException);
	}
	
	/**
	 * Comprueba la ejecución de método init de la clase URLServiceResolver. 
	 */
	@Test
	public void testSecondInitMethod() {
		Map<URLName, String> urlsName = new HashMap<URLName, String>();
		
		urlsName.put(URLName.GWP, "${rol.gwp.url}");
		urlsName.put(URLName.HUB, "${rol.hubapi.url}");

		Map<URLServiceName, String> urls = null;
		URLServiceResolver urlServiceResolver = new URLServiceResolver(urlsName, urls);
		
		boolean isException = false;
		
		try {
			urlServiceResolver.init();
		} catch (InitializationException ie) {
			isException = true;
		}
		
		Assert.assertTrue("Ha fallado la llamada al método \"init\" de la clase \"URLServiceResolver\".",
				isException);
	}
	
	/**
	 * Comprueba la ejecución de método init de la clase URLServiceResolver. 
	 */
	@Test
	public void testThirdInitMethod() {
		Map<URLName, String> urlsName = new HashMap<URLName, String>();
		
		urlsName.put(URLName.GWP, "${rol.url}");
		
		Map<URLServiceName, String> urls = null;
		URLServiceResolver urlServiceResolver = new URLServiceResolver(urlsName, urls);
		boolean isException = false;
		
		try {
			urlServiceResolver.init();
		} catch (InitializationException ie) {
			isException = true;
		}
		
		Assert.assertTrue("Ha fallado la llamada al método \"init\" de la clase \"URLServiceResolver\".",
				isException);
	}
	
	/**
	 * Comprueba la ejecución de método init de la clase URLServiceResolver. 
	 */
	@Test
	public void testFourthInitMethod() {
		Map<URLName, String> urlsName = new HashMap<URLName, String>();
		
		for (URLName tmp : URLName.values()) {
			urlsName.put(tmp, "${rol.url}");
		}
		
		Map<URLServiceName, String> urls = new HashMap<URLServiceName, String>();
		
		urls.put(URLServiceName.GWP_REALIZAR, "/path/service");
		
		URLServiceResolver urlServiceResolver = new URLServiceResolver(urlsName, urls);
		boolean isException = false;
		
		try {
			urlServiceResolver.init();
		} catch (InitializationException ie) {
			isException = true;
		}
		
		Assert.assertTrue("Ha fallado la llamada al método \"init\" de la clase \"URLServiceResolver\".",
				isException);
	}
	
	/**
	 * Comprueba la ejecución de método init de la clase URLServiceResolver. 
	 */
	@Test
	public void testFifthInitMethod() {
		Map<URLName, String> urlsName = new HashMap<URLName, String>();
		
		for (URLName tmp : URLName.values()) {
			urlsName.put(tmp, "${rol.url}");
		}
		
		Map<URLServiceName, String> urls = new HashMap<URLServiceName, String>();
		
		for (URLServiceName tmp : URLServiceName.values()) {
			urls.put(tmp, "/path/service");
		}
		
		URLServiceResolver urlServiceResolver = new URLServiceResolver(urlsName, urls);
		boolean isException = false;
		
		try {
			urlServiceResolver.init();
		} catch (InitializationException ie) {
			isException = true;
		}
		
		Assert.assertFalse("Ha fallado la llamada al método \"init\" de la clase \"URLServiceResolver\".",
				isException);
	}
	
	/**
	 * Comprueba la ejecución de método getURL de la clase URLServiceResolver. 
	 */
	@Test
	public void testGetURLMethod() {
		URLServiceResolver urlServiceResolver = (URLServiceResolver) applicationContext.getBean("urlServiceResolver");
		
		String url = urlServiceResolver.getURL(URLServiceName.GWP_REALIZAR);
		
		Assert.assertNotNull("Ha fallado la llamada al método \"getURL\" de la clase \"URLServiceResolver\".",
				url);
	}
}
