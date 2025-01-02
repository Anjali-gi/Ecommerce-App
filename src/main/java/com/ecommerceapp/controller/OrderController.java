package com.ecommerceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ecommerceapp.service.OrderService;


@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;



}