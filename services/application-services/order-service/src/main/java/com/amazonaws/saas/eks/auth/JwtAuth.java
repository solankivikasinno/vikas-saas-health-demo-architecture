/*
infrateam and application team
 */
package com.amazonaws.saas.eks.auth;

import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtAuth extends AbstractAuthenticationToken {

	private final Object principal;
	private JWTClaimsSet jwtClaimsSet;

	public JwtAuth(Object principal, JWTClaimsSet jwtClaimsSet, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		this.jwtClaimsSet = jwtClaimsSet;
		super.setAuthenticated(true);
	}

	public Object getCredentials() {
		return null;
	}

	public Object getPrincipal() {
		return this.principal;
	}

	public JWTClaimsSet getJwtClaimsSet() {
		return this.jwtClaimsSet;
	}
}
