/*
infrateam and application team
 */
package com.amazonaws.saas.eks.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Tenant")
public class Tenant {

	private String tenantId;
	private Boolean authUseSr;
	private Double authTimeoutFactor;
	private Integer authSrTimeout;
	private String authSrRedirectUri;
	private Boolean showDebugInfo;
	private Boolean authSessionChecksEnabled;
	private String authServer;
	private String authRedirectUri;
	private String authClientId;
	private Boolean authClearHashAfterLogin;
	private String plan;

	@DynamoDBHashKey(attributeName = "TENANT_ID")
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	@DynamoDBAttribute(attributeName = "AUTH_USE_SR")
	public Boolean getAuthUseSr() {
		return authUseSr;
	}

	public void setAuthUseSr(Boolean authUseSr) {
		this.authUseSr = authUseSr;
	}

	@DynamoDBAttribute(attributeName = "AUTH_TIMEOUT_FACTOR")
	public Double getAuthTimeoutFactor() {
		return authTimeoutFactor;
	}

	public void setAuthTimeoutFactor(Double authTimeoutFactor) {
		this.authTimeoutFactor = authTimeoutFactor;
	}

	@DynamoDBAttribute(attributeName = "AUTH_SR_TIMEOUT")
	public Integer getAuthSrTimeout() {
		return authSrTimeout;
	}

	public void setAuthSrTimeout(Integer authSrTimeout) {
		this.authSrTimeout = authSrTimeout;
	}

	@DynamoDBAttribute(attributeName = "AUTH_SR_REDIRECT_URI")
	public String getAuthSrRedirectUri() {
		return authSrRedirectUri;
	}

	public void setAuthSrRedirectUri(String authSrRedirectUri) {
		this.authSrRedirectUri = authSrRedirectUri;
	}

	@DynamoDBAttribute(attributeName = "AUTH_SHOW_DEBUG_INFO")
	public Boolean getShowDebugInfo() {
		return showDebugInfo;
	}

	public void setShowDebugInfo(Boolean showDebugInfo) {
		this.showDebugInfo = showDebugInfo;
	}

	@DynamoDBAttribute(attributeName = "AUTH_SESSION_CHECKS_ENABLED")
	public Boolean getAuthSessionChecksEnabled() {
		return authSessionChecksEnabled;
	}

	public void setAuthSessionChecksEnabled(Boolean authSessionChecksEnabled) {
		this.authSessionChecksEnabled = authSessionChecksEnabled;
	}

	@DynamoDBAttribute(attributeName = "AUTH_SERVER")
	public String getAuthServer() {
		return authServer;
	}

	public void setAuthServer(String authServer) {
		this.authServer = authServer;
	}

	@DynamoDBAttribute(attributeName = "AUTH_REDIRECT_URI")
	public String getAuthRedirectUri() {
		return authRedirectUri;
	}

	public void setAuthRedirectUri(String authRedirectUri) {
		this.authRedirectUri = authRedirectUri;
	}

	@DynamoDBAttribute(attributeName = "AUTH_CLIENT_ID")
	public String getAuthClientId() {
		return authClientId;
	}

	public void setAuthClientId(String authClientId) {
		this.authClientId = authClientId;
	}

	@DynamoDBAttribute(attributeName = "AUTH_CLEAR_HASH_AFTER_LOGIN")
	public Boolean getAuthClearHashAfterLogin() {
		return authClearHashAfterLogin;
	}

	public void setAuthClearHashAfterLogin(Boolean authClearHashAfterLogin) {
		this.authClearHashAfterLogin = authClearHashAfterLogin;
	}

	@DynamoDBAttribute(attributeName = "PLAN")
	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

}