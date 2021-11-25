package ar.com.agea.hub.rol.utils;

import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.auth0.AuthenticationController;
import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.JwkProviderBuilder;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import ar.com.agea.hub.rol.credentials.Auth0Credentials;

public class Auth0LoginHelper {
	
	@Autowired
	private Auth0Credentials auth0Credentials;
	
	private AuthenticationController controller;
	
	
	public Auth0LoginHelper() {
		this.controller = null;
	}
	
	
	public AuthenticationController getInstance() {
		if(this.getController() == null) {
			JwkProvider jwkProvider = new JwkProviderBuilder(auth0Credentials.getDomain()).build();
			this.setController(AuthenticationController.newBuilder(auth0Credentials.getDomain(), auth0Credentials.getClientId(), auth0Credentials.getClientSecret())
	                							.withJwkProvider(jwkProvider)
	                							.build());
		}
		return this.getController();
	}
	
	
	public AuthenticationController getController() {
		return controller;
	}

	public void setController(AuthenticationController controller) {
		this.controller = controller;
	}
	
	
	public Map<String, String> verify(String token, HttpServletRequest req) {
		
        String domain = this.auth0Credentials.getDomain();

        // JwkProvider required for RS256 tokens. If using HS256, do not use.
        JwkProvider jwkProvider = new JwkProviderBuilder(domain).build();

        DecodedJWT jwt = null;
        try {
            jwt = JWT.decode(token);
            // Get the kid from received JWT token
            Jwk jwk = jwkProvider.get(jwt.getKeyId());
            
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) jwk.getPublicKey(), null);
            
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("https://" + domain + "/")
                    .acceptLeeway(60) // Otro intento de resolver el tema del 'The Token can't be used before ...'
                .build();
            
            jwt = verifier.verify(token);
            
            //no manejo meterlo aca en la session
            //SessionUtils.set(req, "claims", jwt.getClaims());
            
        } catch (JWTVerificationException e){
            //Invalid signature/claims
            e.printStackTrace();
        } catch (JwkException e) {
            // invalid JWT token
            e.printStackTrace();
        }

		return this.getClaimsTranslated(jwt.getClaims());
    }


	private Map<String, String> getClaimsTranslated(Map<String, Claim> claims) {
		Map<String, String> userData = new HashMap<String, String>();
		
		claims.entrySet().stream().forEach(claim -> userData.put(claim.getKey(), this.parseClameByType(claim.getValue()).toString()));
		
		return userData;
	}


	private Object parseClameByType(Claim value) {
		
		Object claimValue;
		if ((claimValue = value.asBoolean()) != null) {
		  return claimValue;
		} else if ((claimValue = value.asList(Object.class)) != null) {
		  return claimValue;
		} else if (value.asDouble() != null || value.asLong() != null || value.asInt() != null) {
		  return value.as(Number.class);
		} else if ((claimValue = value.asMap()) != null) {
		  return claimValue;
		} else if ((claimValue = value.asString()) != null) {
		  return claimValue;
		}
		return claimValue;
	}

	
	//--- getters y setters
	public Auth0Credentials getAuth0Credentials() {
		return auth0Credentials;
	}

	public void setAuth0Credentials(Auth0Credentials auth0Credentials) {
		this.auth0Credentials = auth0Credentials;
	}
	
}
