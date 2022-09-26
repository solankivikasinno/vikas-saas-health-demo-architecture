/*
infrateam and application team
 */
package com.amazonaws.saas.eks.dto;

import java.io.Serializable;

public class SaaSProviderMetadata implements Serializable {
	private static final long serialVersionUID = 1L;
	private String s3Endpoint;
	private String orderServiceEcrRepoUri;
	private String productServiceEcrRepoUri;
	private String providerUserPool;

	public String getS3Endpoint() {
		return s3Endpoint;
	}

	public void setS3Endpoint(String s3Endpoint) {
		this.s3Endpoint = s3Endpoint;
	}

	public String getOrderServiceEcrRepoUri() {
		return orderServiceEcrRepoUri;
	}

	public void setOrderServiceEcrRepoUri(String orderServiceEcrRepoUri) {
		this.orderServiceEcrRepoUri = orderServiceEcrRepoUri;
	}

	public String getProductServiceEcrRepoUri() {
		return productServiceEcrRepoUri;
	}

	public void setProductServiceEcrRepoUri(String productServiceEcrRepoUri) {
		this.productServiceEcrRepoUri = productServiceEcrRepoUri;
	}

	public String getProviderUserPool() {
		return providerUserPool;
	}

	public void setProviderUserPool(String providerUserPool) {
		this.providerUserPool = providerUserPool;
	}

}
