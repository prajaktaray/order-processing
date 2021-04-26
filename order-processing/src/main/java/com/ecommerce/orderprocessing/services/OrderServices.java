package com.ecommerce.orderprocessing.services;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.stereotype.Service;

import com.ecommerce.orderprocessing.exception.OrderNotFoundException;
import com.ecommerce.orderprocessing.model.OrderModel;
import com.ecommerce.orderprocessing.repository.OrderRepository;

@Service
public class OrderServices {
	
	@Autowired
	OrderRepository order_repo;
	
	
	
	public List<OrderModel> getOrderByOrderId(String order_id) {
		
		List<OrderModel> orders = (List<OrderModel> )order_repo.findByOrderId(order_id);
		
		return orders;
		
	}
	public OrderModel createNewOrder(OrderModel model) {
		
		OrderModel order = order_repo.save(model);
	
		if(order != null) return order;
		return null;
	}
	
	/*
	 * public void cancelOrderByOrderId(String order_id) {
	 * order_repo.cancelByOrderId(order_id); return ; }
	 */
	 

}
