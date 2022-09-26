/*
infrateam and application team
 */
package com.amazonaws.saas.eks.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Product")
public class Product {

	private String productId;
	private String tenantId;
	private String name;
	private Double price;
	private String pictureUrl;

	@DynamoDBHashKey(attributeName = "TenantId")
	public String getTenantId() {
		return tenantId;
	}

	@DynamoDBAutoGeneratedKey
	@DynamoDBRangeKey(attributeName = "ProductId")
	public String getProductId() {
		return productId;
	}

	public void setProductId(String id) {
		this.productId = id;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	@DynamoDBAttribute(attributeName = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@DynamoDBAttribute(attributeName = "Price")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@DynamoDBAttribute(attributeName = "PictureUrl")
	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", tenantId=" + tenantId + ", name=" + name + ", price=" + price
				+ ", pictureUrl=" + pictureUrl + "]";
	}

}