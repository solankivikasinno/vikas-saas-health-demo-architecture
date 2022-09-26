/*
infrateam and application team
 */
package com.amazonaws.saas.eks.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.servlet4preview.GenericFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthFilter extends GenericFilter {
	private static final Log logger = LogFactory.getLog(AuthFilter.class);
	private TokenProcessor cognitoIdTokenProcessor;

	public AuthFilter(TokenProcessor cognitoIdTokenProcessor) {
		this.cognitoIdTokenProcessor = cognitoIdTokenProcessor;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		Authentication authentication;

		try {
			authentication = this.cognitoIdTokenProcessor.authenticate((HttpServletRequest) request);
			if (authentication != null) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception var6) {
			logger.error("Cognito ID Token processing error", var6);
			SecurityContextHolder.clearContext();
		}

		filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
