/*
infrateam and application team
 */
package com.amazonaws.saas.eks.model;

import java.io.Serializable;

public class OrderProduct implements Serializable {
		
	private static final long serialVersionUID = 2753684762296062159L;
	
	private String productId;
	private Double price;
	private Integer quantity;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "OrderProduct [productId=" + productId + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
