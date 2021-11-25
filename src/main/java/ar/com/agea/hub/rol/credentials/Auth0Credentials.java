package ar.com.agea.hub.rol.credentials;

/**
 * Representa las credenciales necesarias para invokar los servicios de Auth0 (Login). 
 * Estas credenciales son necesarias para los llamados contra Auth0. 
 * 
 * @author		Mariano De Nicolo
 * @author		Gabriel Castiglia
 * @version		1.0 04/08/2021
 */
public class Auth0Credentials {
	
	private String domain;
	private String clientId;
	private String clientSecret;
	private String callbackLogin;
	private String callbackLogout;
	private String webProtocol;
	
	
	/**
	 * Instancia un objeto de tipo Auth0Credentials.
	 */
	public Auth0Credentials(String domain, String clientId, String clientSecret, String callbackLogin, String callbackLogout, String webProtocol) {
		this.domain = domain;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.callbackLogin = callbackLogin;
		this.callbackLogout = callbackLogout;
		this.webProtocol = webProtocol;
	}
	
	
	
	public String getDomain() {
		return domain;
	}
	
	
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	
	public String getClientId() {
		return clientId;
	}
	
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	
	public String getClientSecret() {
		return clientSecret;
	}
	
	
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}


	public String getCallbackLogin() {
		return callbackLogin;
	}


	public void setCallbackLogin(String callbackLogin) {
		this.callbackLogin = callbackLogin;
	}


	public String getCallbackLogout() {
		return callbackLogout;
	}


	public void setCallbackLogout(String callbackLogout) {
		this.callbackLogout = callbackLogout;
	}


	public String getWebProtocol() {
		return webProtocol;
	}


	public void setWebProtocol(String webProtocol) {
		this.webProtocol = webProtocol;
	}
	
	
	
	
}
