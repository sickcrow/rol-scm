package ar.com.agea.hub.rol.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {

	@Autowired
	private Auth0LoginHelper auth0LoginHelper;
	
	public CustomHttpServletRequestWrapper(HttpServletRequest request, Auth0LoginHelper auth0LoginHelper) {
		super(request);
		this.auth0LoginHelper = auth0LoginHelper;
	}
	
	@Override
	public StringBuffer getRequestURL() {
		String s = super.getRequestURL().toString();
		s = s.replaceFirst("http://", auth0LoginHelper.getAuth0Credentials().getWebProtocol() + "://");
		return new StringBuffer(s);
	}

	
	//--- getters y setters
	public Auth0LoginHelper getAuth0LoginHelper() {
		return auth0LoginHelper;
	}

	public void setAuth0LoginHelper(Auth0LoginHelper auth0LoginHelper) {
		this.auth0LoginHelper = auth0LoginHelper;
	}

	
}