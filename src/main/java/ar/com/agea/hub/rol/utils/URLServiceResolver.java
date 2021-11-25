/*
 * @(#)URLServiceResolver.java		1.0 06/06/2013
 */

package ar.com.agea.hub.rol.utils;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import ar.com.agea.hub.rol.exception.InitializationException;

/**
 * Resuelve las rutas relativas de los servicios GWP, HUB y PASE por nombre.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 06/06/2013
 */
public final class URLServiceResolver {

	private static final String LOGGER_NAME = "rol";
	
	private static final String URL_NAME_REGEX = "_";
	private static final int URL_NAME_INDEX = 0;

	private static final String GENERIC_LOGGING_ERROR = "Ha fallado la inicialización del objeto URLServiceResolver";
	
	private final Logger logger;
	
	private Map<URLName, String> urlsName;
	private Map<URLServiceName, String> urls;
	
	/**
	 * Instancia un objeto de tipo URLServiceResolver.
	 * <p>
	 * Este constructor es utilizado únicamente por Spring mediante IoC.
	 */
	public URLServiceResolver(Map<URLName, String> urlsName, Map<URLServiceName, String> urls) {
		this.urlsName = urlsName;
		this.urls = urls;
		logger = Logger.getLogger(LOGGER_NAME); 
	}
	
	/**
	 * Obtiene la ruta relativa del servicio GWP, HUB o PASE a partir de su nombre asociado.
	 * 
	 * @param urlServiceName Nombre del servicio GWP, HUB o PASE.
	 * @return Ruta del servicio GWP, HUB o PASE.
	 */
	public String getURL(URLServiceName urlServiceName) {
		String url = null;

		if (urls != null && urls.containsKey(urlServiceName)) {
			URLName urlName = URLName.valueOf(urlServiceName.name().split(URL_NAME_REGEX)[URL_NAME_INDEX]);
			
			if (urlName != null) {
				url = urlsName.get(urlName) + urls.get(urlServiceName);
			}
		}
		
		return url;
	}
	
	/**
	 * Verifica que todas las rutas de los servicios GWP, HUB y PASE estén asociados
	 * a un nombre que lo identifica en la aplicación, caso contrario lanza
	 * una excepción de tipo InitializationException.
	 */
	public void init() {
		if (urlsName == null) {
			InitializationException exception = new InitializationException("El objeto URLServiceResolver no ha sido inicializado correctamente.");
			
			logger.error(GENERIC_LOGGING_ERROR, exception);
			
			throw exception;
		}
		
		Set<URLName> urlsNameTmp = urlsName.keySet();
		
		for (URLName urlName : URLName.values()) {
			if (!urlsNameTmp.contains(urlName)) {
				InitializationException exception = new InitializationException("El objeto URLServiceResolver no ha sido inicializado con todos los servicios disponibles.");
				
				logger.error(GENERIC_LOGGING_ERROR, exception);
				
				throw exception;
			}
		}
		
		if (urls == null) {
			InitializationException exception = new InitializationException("El objeto URLServiceResolver no ha sido inicializado correctamente.");
			
			logger.error(GENERIC_LOGGING_ERROR, exception);
			
			throw exception;
		}
		
		Set<URLServiceName> urlsTmp = urls.keySet();
		
		for (URLServiceName urlServiceName : URLServiceName.values()) {
			if (!urlsTmp.contains(urlServiceName)) {
				InitializationException exception = new InitializationException("El objeto URLServiceResolver no ha sido inicializado con todos los servicios disponibles.");
				
				logger.error(GENERIC_LOGGING_ERROR, exception);
				
				throw exception;
			}
		}
	}
}
