/*
infrateam and application team
 */
package com.amazonaws.saas.eks.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class AuthConfig implements Serializable {
	private static final long serialVersionUID = 1L;
	private String issuer;
	private Boolean strictDiscoveryDocumentValidation;
	private String clientId;
	private String responseType;
	private String redirectUri;
	private String silentRefreshRedirectUri;
	private String scope;
	private Boolean useSilentRefresh;
	private BigDecimal silentRefreshTimeout;
	private Double timeoutFactor;
	private Boolean sessionChecksEnabled;
	private Boolean showDebugInformation;
	private Boolean clearHashAfterLogin;
	private String nonceStateSeparator;
	private String cognitoDomain;

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public Boolean getStrictDiscoveryDocumentValidation() {
		return strictDiscoveryDocumentValidation;
	}

	public void setStrictDiscoveryDocumentValidation(Boolean strictDiscoveryDocumentValidation) {
		this.strictDiscoveryDocumentValidation = strictDiscoveryDocumentValidation;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getSilentRefreshRedirectUri() {
		return silentRefreshRedirectUri;
	}

	public void setSilentRefreshRedirectUri(String silentRefreshRedirectUri) {
		this.silentRefreshRedirectUri = silentRefreshRedirectUri;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Boolean getUseSilentRefresh() {
		return useSilentRefresh;
	}

	public void setUseSilentRefresh(Boolean useSilentRefresh) {
		this.useSilentRefresh = useSilentRefresh;
	}

	public BigDecimal getSilentRefreshTimeout() {
		return silentRefreshTimeout;
	}

	public void setSilentRefreshTimeout(BigDecimal bigDecimal) {
		this.silentRefreshTimeout = bigDecimal;
	}

	public Double getTimeoutFactor() {
		return timeoutFactor;
	}

	public void setTimeoutFactor(Double timeoutFactor) {
		this.timeoutFactor = timeoutFactor;
	}

	public Boolean getSessionChecksEnabled() {
		return sessionChecksEnabled;
	}

	public void setSessionChecksEnabled(Boolean sessionChecksEnabled) {
		this.sessionChecksEnabled = sessionChecksEnabled;
	}

	public Boolean getShowDebugInformation() {
		return showDebugInformation;
	}

	public void setShowDebugInformation(Boolean showDebugInformation) {
		this.showDebugInformation = showDebugInformation;
	}

	public Boolean getClearHashAfterLogin() {
		return clearHashAfterLogin;
	}

	public void setClearHashAfterLogin(Boolean clearHashAfterLogin) {
		this.clearHashAfterLogin = clearHashAfterLogin;
	}

	public String getNonceStateSeparator() {
		return nonceStateSeparator;
	}

	public void setNonceStateSeparator(String nonceStateSeparator) {
		this.nonceStateSeparator = nonceStateSeparator;
	}

	public String getCognitoDomain() {
		return cognitoDomain;
	}

	public void setCognitoDomain(String cognitoDomain) {
		this.cognitoDomain = cognitoDomain;
	}

}
