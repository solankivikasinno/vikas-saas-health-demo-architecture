/*
infrateam and application team
 */
package com.amazonaws.saas.eks.service;

import java.util.List;

import com.amazonaws.saas.eks.model.Product;

public interface ProductService {

	Product save(Product product);

	Product update(Product product);

	Product getProductById(String productId, String tenantId);

	List<Product> getProducts(String tenantId);

	void delete(Product product);
}