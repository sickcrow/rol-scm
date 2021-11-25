/*
 * @(#)HttpHeadersResolver.java		1.0 23/10/2013
 */

package ar.com.agea.hub.rol.utils;

import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;

import ar.com.agea.hub.rol.exception.InitializationException;

/**
 * Resuelve las rutas relativas de las cabeceras http GWP, HUB y PASE por nombre.
 * 
 * @author		Eduardo Barrera
 * @version		1.0 23/10/2013
 */
public final class HttpHeadersResolver {

	private static final String LOGGER_NAME = "rol";
	
	private static final String URL_NAME_REGEX = "_";
	private static final int URL_NAME_INDEX = 0;
	
	private final Logger logger;
	
	private Map<URLName, HttpHeaders> urlsName;
	
	/**
	 * Instancia un objeto de tipo HttpHeadersResolver.
	 * <p>
	 * Este constructor es utilizado únicamente por Spring mediante IoC.
	 */
	public HttpHeadersResolver(Map<URLName, HttpHeaders> urlsName) {
		this.urlsName = urlsName;
		logger = Logger.getLogger(LOGGER_NAME); 
	}
	
	/**
	 * Obtiene la ruta relativa de la cabecera http GWP, HUB o PASE a partir de su nombre asociado.
	 * 
	 * @param urlServiceName Nombre del servicio GWP, HUB o PASE.
	 * @return Ruta de la cabecera http GWP, HUB o PASE.
	 */
	public HttpHeaders getHttpHeaders(URLServiceName urlServiceName) {
		HttpHeaders httpHeaders = null;

		if (urlsName != null) {
			URLName urlName = URLName.valueOf(urlServiceName.name().split(URL_NAME_REGEX)[URL_NAME_INDEX]);
			
			if (urlName != null) {
				httpHeaders = urlsName.get(urlName);
			}
		}
		
		return httpHeaders;
	}
	
	/**
	 * Verifica que todas las rutas de las cabeceras http GWP, HUB y PASE estén asociadas
	 * a un nombre que lo identifica en la aplicación, caso contrario lanza
	 * una excepción de tipo InitializationException.
	 */
	public void init() {
		if (urlsName == null) {
			InitializationException exception = new InitializationException("El objeto HttpHeadersResolver no ha sido inicializado correctamente.");
			
			logger.error("Ha fallado la inicialización del objeto HttpHeadersResolver", exception);
			
			throw exception;
		}
		
		Set<URLName> urlsNameTmp = urlsName.keySet();
		
		for (URLName urlName : URLName.values()) {
			if (!urlsNameTmp.contains(urlName)) {
				InitializationException exception = new InitializationException("El objeto HttpHeadersResolver no ha sido inicializado con todos los servicios disponibles.");
				
				logger.error("Ha fallado la inicialización del objeto HttpHeadersResolver", exception);
				
				throw exception;
			}
		}
	}
}
