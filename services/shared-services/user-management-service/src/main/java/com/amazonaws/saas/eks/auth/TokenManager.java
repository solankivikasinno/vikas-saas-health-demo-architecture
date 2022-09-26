/*
infrateam and application team
 */
package com.amazonaws.saas.eks.auth;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.saas.eks.dto.TenantUserDto;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

@Component
public class TokenManager {
	private static final Logger logger = LogManager.getLogger(TokenManager.class);
	private static final String CUSTOM_TENANT_ID = "custom:tenant-id";

	@Autowired
	private JwtConfig jwtConfiguration;

	private String getBearerToken(String token) {
		return token.startsWith("Bearer ") ? token.substring("Bearer ".length()) : token;
	}

	public TenantUserDto extractDataFromJwt(HttpServletRequest request) {
		TenantUserDto tenantUserDto = new TenantUserDto();
		String userPoolId = null;
		String tenantId = null;
		
		String idToken = request.getHeader(this.jwtConfiguration.getHttpHeader());

		if (idToken != null) {
			SignedJWT signedJWT = null;
			JWTClaimsSet claimsSet = null;
			
			try {
			    signedJWT = SignedJWT.parse(this.getBearerToken(idToken));
				claimsSet = signedJWT.getJWTClaimsSet();	
				
				tenantId = claimsSet.getStringClaim(CUSTOM_TENANT_ID);
				logger.info("tenantId: " + tenantId);
				tenantUserDto.setTenantId(tenantId);
			} catch (java.text.ParseException e) {
			    logger.error(e);
			}

			String issuer = claimsSet.getIssuer();
			logger.info("issuer: " + issuer);

			if(issuer!=null) {
				int c = issuer.lastIndexOf("/");
				userPoolId = issuer.substring(c+1);
				logger.info("userPoolId: " + userPoolId);

				tenantUserDto.setUserPoolId(userPoolId);
			}
		}
		return tenantUserDto;
	}

	
	public String extractUserPoolIdFromJwt(HttpServletRequest request) {
		String userPoolId = null;
		String idToken = request.getHeader(this.jwtConfiguration.getHttpHeader());

		if (idToken != null) {
			SignedJWT signedJWT = null;
			JWTClaimsSet claimsSet = null;
			
			try {
			    signedJWT = SignedJWT.parse(this.getBearerToken(idToken));
				claimsSet = signedJWT.getJWTClaimsSet();			
			} catch (java.text.ParseException e) {
			    logger.error(e);
			}

			String issuer = claimsSet.getIssuer();
			logger.info("issuer: " + issuer);

			if(issuer!=null) {
				int c = issuer.lastIndexOf("/");
				userPoolId = issuer.substring(c+1);
			}
			logger.info("userPoolId: " + userPoolId);
		}
		return userPoolId;
	}
}