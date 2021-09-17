package com.edusol.product.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusol.product.model.Product;
import com.edusol.product.repository.ProductRepository;

import antlr.collections.List;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository prodRepo;

	public String addProduct(Product p) {
		
		prodRepo.save(p);
		return "Product Added Sccuessfull";
	}

	public Object getProduct() {
		
		return prodRepo.findAll();
	}

	public Object getProductById(int pid) {
		System.out.println(prodRepo.findById(pid));
		return prodRepo.findById(pid);
	}

	

}
