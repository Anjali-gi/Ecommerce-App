package com.ecommerceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceapp.entity.Order;
import com.ecommerceapp.entity.User;
import com.ecommerceapp.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;

	public List<Order> getAllOrder() {
		return orderRepo.findAll();
	}

	public Order getOrderById(Long id) {
		return orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order with id " + id + "not found"));
	}
	
	public void createOrder(Order Order) {
		orderRepo.save(Order);
	}

	public void updateOrder(Order Order, Long id) {
		orderRepo.findById(Order.getId())
				.orElseThrow(() -> new RuntimeException("user with id " + Order.getId() + "not found"));
		orderRepo.save(Order);
	}

	public void deleteOrder(Long id) {
		orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order with id " + id + "not found"));
		orderRepo.deleteById(id);
	}
	
	public List<Order>findOrdersByUser(User user){
		return orderRepo.findByUser(user);
	}

}
