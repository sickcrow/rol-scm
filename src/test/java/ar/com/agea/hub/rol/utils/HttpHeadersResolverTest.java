/*
 * @(#)HttpHeadersResolverTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.utils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpHeaders;

import ar.com.agea.hub.rol.common.InstantiationTest;
import ar.com.agea.hub.rol.exception.InitializationException;

/**
 * Representa JUnit Tests de inicialización para la clase HttpHeadersResolver.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class HttpHeadersResolverTest extends InstantiationTest {

	/**
	 * Comprueba la creación de objeto de tipo HttpHeadersResolver.
	 */
	@Test
	public void testConstructor() {
		Map<URLName, HttpHeaders> urlsName = null;
		
		HttpHeadersResolver httpHeadersResolver = new HttpHeadersResolver(urlsName);
		
		Assert.assertNotNull("Ha fallado la creación del objeto de tipo \"HttpHeadersResolver\".",
				httpHeadersResolver);
	}

	/**
	 * Comprueba la ejecución de método init de la clase HttpHeadersResolver. 
	 */
	@Test
	public void testFirstInitMethod() {
		Map<URLName, HttpHeaders> urlsName = null;
		
		HttpHeadersResolver httpHeadersResolver = new HttpHeadersResolver(urlsName);
		boolean isException = false;
		
		try {
			httpHeadersResolver.init();
		} catch (InitializationException ie) {
			isException = true;
		}
		
		Assert.assertTrue("Ha fallado la llamada al método \"init\" de la clase \"HttpHeadersResolver\".",
				isException);
	}
	
	/**
	 * Comprueba la ejecución de método init de la clase HttpHeadersResolver. 
	 */
	@Test
	public void testSecondInitMethod() {
		Map<URLName, HttpHeaders> urlsName = new HashMap<URLName, HttpHeaders>();
		
		urlsName.put(URLName.GWP, new HttpHeaders());
		
		HttpHeadersResolver httpHeadersResolver = new HttpHeadersResolver(urlsName);
		boolean isException = false;
		
		try {
			httpHeadersResolver.init();
		} catch (InitializationException ie) {
			isException = true;
		}
		
		Assert.assertTrue("Ha fallado la llamada al método \"init\" de la clase \"HttpHeadersResolver\".",
				isException);
	}
	
	/**
	 * Comprueba la ejecución de método init de la clase HttpHeadersResolver. 
	 */
	@Test
	public void testThirdInitMethod() {
		Map<URLName, HttpHeaders> urlsName = new HashMap<URLName, HttpHeaders>();
		
		for (URLName tmp : URLName.values()) {
			urlsName.put(tmp, new HttpHeaders());
		}
		
		HttpHeadersResolver httpHeadersResolver = new HttpHeadersResolver(urlsName);
		boolean isException = false;
		
		try {
			httpHeadersResolver.init();
		} catch (InitializationException ie) {
			isException = true;
		}
		
		Assert.assertFalse("Ha fallado la llamada al método \"init\" de la clase \"HttpHeadersResolver\".",
				isException);
	}
	
	/**
	 * Comprueba la ejecución de método getURL de la clase HttpHeadersResolver. 
	 */
	@Test
	public void testGetURLMethod() {
		HttpHeadersResolver httpHeadersResolver = (HttpHeadersResolver) applicationContext.getBean("httpHeadersResolver");
		
		HttpHeaders httpHeaders = httpHeadersResolver.getHttpHeaders(URLServiceName.GWP_REALIZAR);
		
		Assert.assertNotNull("Ha fallado la llamada al método \"getHttpHeaders\" de la clase \"HttpHeadersResolver\".",
				httpHeaders);
	}
}
