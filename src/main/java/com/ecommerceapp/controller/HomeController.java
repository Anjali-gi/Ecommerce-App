package com.ecommerceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecommerceapp.entity.Admin;
import com.ecommerceapp.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;

	@GetMapping({"/","/home"})
	public String homePage() {
		return "HomePage";	
	}
	
	@GetMapping("/products")
	public String productPage(Model model){
		model.addAttribute("productList", productService.getAllProduct());
		return "ProductPage";
	}
	
	@GetMapping("/contactUs")
	public String contactPage() {
		return "ContactPage";	
	}
	
	@GetMapping("/aboutUs")
	public String aboutUs() {
		return "AboutUs";	
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("admin",new Admin());
		return "Login";	
	}
	
}
