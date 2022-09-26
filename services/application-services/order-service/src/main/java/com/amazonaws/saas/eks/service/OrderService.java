/*
infrateam and application team
 */
package com.amazonaws.saas.eks.service;

import java.util.List;
import com.amazonaws.saas.eks.model.Order;

public interface OrderService {

	Order save(Order order, String tenantId);

	Order getOrderById(String orderId, String tenantId);

	List<Order> getOrders(String tenantId);

	void delete(Order order, String tenantId);
}