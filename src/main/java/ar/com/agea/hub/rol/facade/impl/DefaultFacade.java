/*
 * @(#)DefaultFacade.java		1.0 23/10/2013
 */

package ar.com.agea.hub.rol.facade.impl;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ar.com.agea.hub.rol.facade.Facade;
import ar.com.agea.hub.rol.utils.DTOFieldName;
import ar.com.agea.hub.rol.utils.HttpHeadersResolver;
import ar.com.agea.hub.rol.utils.JSONFactory;
import ar.com.agea.hub.rol.utils.URLServiceName;
import ar.com.agea.hub.rol.utils.URLServiceResolver;

/**
 * Provee una implementación de la interfaz ROLFacade.
 * 
 * @author		Eduardo Barrera
 * @author		Juan Martín Lichowski
 * @version		1.0 23/10/2013
 */
public final class DefaultFacade implements Facade {

	private static final String LOGGER_NAME = "rol";
	
	private final Logger logger;
	
	private URLServiceResolver urlServiceResolver;
	private HttpHeadersResolver httpHeadersResolver;
	private RestTemplate restTemplate;
	
	/**
	 * Instancia un objeto de tipo DefaultROLFacade.
	 * <p>
	 * Este constructor es utilizado únicamente por Spring mediante IoC. 
	 */
	public DefaultFacade(URLServiceResolver urlServiceResolver, HttpHeadersResolver httpHeadersResolver, RestTemplate restTemplate) {
		logger = Logger.getLogger(LOGGER_NAME);
		
		this.urlServiceResolver = urlServiceResolver;
		this.httpHeadersResolver = httpHeadersResolver;	
		this.restTemplate = restTemplate;
	}

	@Override
	public <T> T callService(URLServiceName urlServiceName, Object object, Class<T> clazz, Set<DTOFieldName> fieldsToObfuscate) {
		String url = urlServiceResolver.getURL(urlServiceName);
		logger.info(String.format("Accediendo a servicio %s...", url));

		try {
			String json = (fieldsToObfuscate != null && !fieldsToObfuscate.isEmpty())
					? JSONFactory.createJSONObjectAsStringObfuscated(object, fieldsToObfuscate)
					: JSONFactory.createJSONObjectAsString(object);
			logger.info("JSON: " + json);
		} catch (Exception e) {
			logger.info("JSON: ha ocurrido un error al convertir un objeto en objeto JSON en el proceso de logueo.");
		}
		
		HttpEntity<Object> entity = new HttpEntity<Object>(object, httpHeadersResolver.getHttpHeaders(urlServiceName));
		
		ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.POST, entity, clazz);
				
		return response.getBody();
	}
}
