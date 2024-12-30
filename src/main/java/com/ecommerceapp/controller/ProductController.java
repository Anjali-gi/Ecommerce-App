package com.ecommerceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerceapp.entity.Product;
import com.ecommerceapp.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/add/product")
	public String addProduct(){
		return "AddProduct";
	}
	
	@PostMapping("/add/product")
	public String addProduct(Product product) {
		productService.createProduct(product);
		
		return "/admin/home";
	}
	
	@GetMapping("/update/product/{id}")
	public String updateProduct(@PathVariable Long id, Model model){
		model.addAttribute("product" , productService.getProductById(id));
		
		return "AddProduct";
	}
	
	@PostMapping("/update/product")
	public String updateProduct(Product product) {
		productService.updateProduct(product);
		
		return "/admin/home";
	}
	
	@DeleteMapping("/delete/product/{id}")
	public String deleteProduct(@PathVariable Long id){
		productService.deleteProduct(id);

		return "/admin/home";

	}
	
	
	
}
