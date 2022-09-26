/*
infrateam and application team
 */
package com.amazonaws.saas.eks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.saas.eks.model.Product;
import com.amazonaws.saas.eks.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getProducts(String tenantId) {
		return productRepository.getProducts(tenantId);
	}

	@Override
	public Product getProductById(String productId, String tenantId) {
		return productRepository.getProductById(productId, tenantId);
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product update(Product product) {
		return productRepository.update(product);
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

}