/*
infrateam and application team
 */
package com.amazonaws.saas.eks.dto;

import java.io.Serializable;

public class TenantUserDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tenantId;
	private String userPoolId;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserPoolId() {
		return userPoolId;
	}

	public void setUserPoolId(String userPoolId) {
		this.userPoolId = userPoolId;
	}

}
