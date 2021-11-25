package ar.com.agea.hub.rol.utils;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter, Serializable {

	private static final long serialVersionUID = 4949314438713796230L;
	private static final String STARTING_URLS_PARAMETER_NAME = "starting-urls";
	private static final String ENDING_URLS_PARAMETER_NAME = "ending-urls";
	private static final String PROCESS_COOKIES_PARAMETER_NAME = "process-cookies";
	
	private static final String TOKEN_SEPARATOR = ",";
	private static final String URL_TO_REDIRECT = "/rol/login/login";
	private static final String CREAR_AVISO_URL = "/crearaviso";
	
	private static final int MAX_AGE_COOKIE = 0; 
	private static final String PATH_COOKIE = "/";
	private static final boolean SECURE_COOKIE = false;
	private static final String VALUE_COOKIE = null;
	
	private static final int ERROR_NUMBER = 601;
	
	private Set<String> startingURLs;
	private Set<String> endingURLs;
	private Set<String> cookies;
	
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        Boolean eliminoCookie = false;
        
    	HttpSession session = httpRequest.getSession(false);

    	if (null == session) {
    		if (httpRequest.getCookies() != null) {
    			for (Cookie cookie : httpRequest.getCookies()) {
    				if (cookies.contains(cookie.getName())) {
    					cookie.setMaxAge(MAX_AGE_COOKIE);
    					cookie.setPath(PATH_COOKIE);
    					cookie.setSecure(SECURE_COOKIE);
    					cookie.setValue(VALUE_COOKIE);
    					httpResponse.addCookie(cookie);
    					eliminoCookie = true;
    				}
    			}
    		}
    		
    		if (eliminoCookie) {
    			String url = httpRequest.getServletPath();
    			
    			if (containsURLPart(startingURLs, url) && containsURLPart(endingURLs, url)) {
    				//Para el crear aviso contemplamos este numero de error como un redirect
    				httpResponse.sendError(ERROR_NUMBER);
    			} else if (containsURLPart(startingURLs, url) && !url.contains(CREAR_AVISO_URL)) {
    				httpResponse.sendRedirect(URL_TO_REDIRECT);
    			} else {
    				chain.doFilter(request, response);
    			}
    			return;
			}
		}
    	
        chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		startingURLs = splitValues(config.getInitParameter(STARTING_URLS_PARAMETER_NAME));
		endingURLs = splitValues(config.getInitParameter(ENDING_URLS_PARAMETER_NAME));
		cookies = splitValues(config.getInitParameter(PROCESS_COOKIES_PARAMETER_NAME));
	}
	
	private Set<String> splitValues(String values) {
		Set<String> result = new HashSet<String>();
		
        StringTokenizer tokens = new StringTokenizer(values, TOKEN_SEPARATOR);
  
        while (tokens.hasMoreTokens()) {
            result.add(tokens.nextToken().trim());
        }
		
		return result;
	}
	
	private boolean containsURLPart(Set<String> urls, String url) {
        boolean result = false;
        
        for (String tmp : urls) {
        	if (url.contains(tmp)) {
        		result = true;
        		
        		break;
        	}
        }
        
        return result;
	}
}
