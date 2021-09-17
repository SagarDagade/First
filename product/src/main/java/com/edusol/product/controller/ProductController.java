package com.edusol.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.product.model.Product;
import com.edusol.product.service.ProductService;

@RestController
@RequestMapping("/prod")
public class ProductController {
	
	@Autowired
	ProductService prodServ;

	@PostMapping("/add")
	public String addProduct(@RequestBody Product p)
	{
		return prodServ.addProduct(p);
	}
	
	@GetMapping("/get")
	public Object getProduct()
	{
		return prodServ.getProduct();
	}
	
	@GetMapping("/get-by")
	public Object getProductById(@RequestParam int pid)
	{
		System.out.println(pid);
		return prodServ.getProductById(pid);
	}
}
