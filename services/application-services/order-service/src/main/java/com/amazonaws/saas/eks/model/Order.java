/*
infrateam and application team
 */
package com.amazonaws.saas.eks.model;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

@DynamoDBTable(tableName = "Order")
public class Order {
	private String id;
	private String name;
	private List<OrderProduct> orderProduct = new ArrayList<OrderProduct>();

	@DynamoDBHashKey(attributeName = "OrderId")
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}

	public void setId(String string) {
		this.id = string;
	}

	@DynamoDBAttribute(attributeName = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@DynamoDBAttribute(attributeName = "OrderProduct")
	@DynamoDBTypeConverted(converter = OrderProductConverter.class)
	public List<OrderProduct> getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(List<OrderProduct> orderProduct) {
		this.orderProduct = orderProduct;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", orderProduct=" + orderProduct + "]";
	}

}