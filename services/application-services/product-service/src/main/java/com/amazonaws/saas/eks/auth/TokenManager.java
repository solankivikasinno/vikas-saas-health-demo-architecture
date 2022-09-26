/*
infrateam and application team
 */
package com.amazonaws.saas.eks.auth;

import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

@Component
public class TokenManager {
	private static final Logger logger = LogManager.getLogger(TokenManager.class);
	private static final String CUSTOM_TENANT_ID = "custom:tenant-id";

	@Autowired
	private JwtConfig jwtConfiguration;

	public String getTenantId(HttpServletRequest request) throws Exception {
		String idToken = request.getHeader(this.jwtConfiguration.getHttpHeader());

		if (idToken != null) {
			SignedJWT signedJWT = null;

			try {
			    signedJWT = SignedJWT.parse(this.getBearerToken(idToken));
			} catch (java.text.ParseException e) {
			    logger.error(e);
			}

			JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();			
			String tenantId = claimsSet.getStringClaim(CUSTOM_TENANT_ID);
			logger.info("tenantId: " + tenantId);

			return tenantId;
		}
		return null;
	}

	private String getBearerToken(String token) {
		return token.startsWith("Bearer ") ? token.substring("Bearer ".length()) : token;
	}
}