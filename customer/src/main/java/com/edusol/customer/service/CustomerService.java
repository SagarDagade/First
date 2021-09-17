package com.edusol.customer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edusol.customer.model.Customer;
import com.edusol.customer.model.Product;
import com.edusol.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	RestTemplate template;
	
	Product a;
	List<Product> p;
	Customer c;


	public String addCustomer(Customer c) {
		custRepo.save(c);
		return "Customer Added Successfully";
	}

	public Object getCustomer() {
		
		return custRepo.findAll();
	}
	
    public Boolean checkCustomer(int cid) {
		
		return custRepo.existsById(cid);
	}	

	
}
