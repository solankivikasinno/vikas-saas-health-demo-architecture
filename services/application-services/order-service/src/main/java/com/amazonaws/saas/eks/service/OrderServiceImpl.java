/*
infrateam and application team
 */
package com.amazonaws.saas.eks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.saas.eks.model.Order;
import com.amazonaws.saas.eks.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public List<Order> getOrders(String tenantId) {
		return orderRepository.getOrders(tenantId);
	}

	@Override
	public Order getOrderById(String orderId, String tenantId) {
		return orderRepository.getOrderById(orderId, tenantId);
	}

	@Override
	public Order save(Order order, String tenantId) {
		return orderRepository.save(order, tenantId);
	}

	@Override
	public void delete(Order order, String tenantId) {
		orderRepository.delete(order, tenantId);
	}
}