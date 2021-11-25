/*
 * @(#)FacadeTest.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.facade;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import ar.com.agea.hub.rol.common.SpringContextTest;
import ar.com.agea.hub.rol.utils.URLServiceName;
import ar.com.agea.hub.rol.utils.URLServiceResolver;

/**
 * Brinda una intefaz unificada a todos los JUnit Tests para el acceso
 * a los servicios publicados en HUB y PASE.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public class FacadeTest extends SpringContextTest {
	
	private static final String URL_NAME_REGEX = "_";
	private static final int URL_NAME_INDEX = 0;
	
	protected Facade facade;
	
	private URLServiceResolver urlServiceResolver;

	/**
	 * Inicializa todos los recursos necesarios para acceder a los servicios
	 * HUB.
	 */
	@Before
    public void setUp() {
		urlServiceResolver = (URLServiceResolver) applicationContext.getBean("urlServiceResolver");
		facade = (Facade) applicationContext.getBean("facade");
    }

	/**
	 * Realiza un test de conexión dependiendo del servicio HUB
	 * representado por el campo urlServiceName inicializado en el
	 * constructor de esta clase base.
	 */
	@Test
	public void testConnection() {
		boolean isHttpClientErrorException = false;
		boolean isResourceAccessException = false;
		URLServiceName urlServiceNameTmp = null;
		
		try {
			for (URLServiceName urlServiceName : URLServiceName.values()) {
				if (urlServiceName.name().split(URL_NAME_REGEX)[URL_NAME_INDEX].equalsIgnoreCase("HUB")) {
					urlServiceNameTmp = urlServiceName;
					
					facade.callService(urlServiceName, null, null, null);
				}
			}
		} catch(HttpClientErrorException hcee) {
			isHttpClientErrorException = true;
		} catch(ResourceAccessException rae) {
			isResourceAccessException = true;
		}
		
		Assert.assertFalse("Ha fallado la conexión al servicio \"" + urlServiceResolver.getURL(urlServiceNameTmp)
				+ "\" indicado por \"" + urlServiceNameTmp + "\". Posiblemente por credenciales incorrectas.", isHttpClientErrorException);
		
		Assert.assertFalse("Ha fallado la conexión al servicio \"" + urlServiceResolver.getURL(urlServiceNameTmp)
				+ "\" indicado por \"" + urlServiceNameTmp + "\". Posiblemente por url a HUB incorrecta.", isResourceAccessException);
	}
}
