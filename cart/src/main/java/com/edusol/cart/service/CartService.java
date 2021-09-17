package com.edusol.cart.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edusol.cart.model.Cart;
import com.edusol.cart.model.Product;
import com.edusol.cart.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	RestTemplate template;
	
	Product p;
	List<Product> l;
	Cart c;

	public long total(List<Product> ll)
	{
		long t=0;
		for(int i=0; i<ll.size(); i++)
		{
			p = ll.get(i);
			t = t + (p.getPrice() * p.getQuantity());
		}
		return t;
	}
	public String addCart(int cid, int pid) 
	{
		
		final String url ="http://localhost:7001/prod/get-by?pid=" +pid;
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(header);
		ResponseEntity<Product> responce = template.exchange(url, HttpMethod.GET, entity, Product.class);
		
		if(cartRepo.existsById(cid))
		{
			c = cartRepo.getById(cid);
			l = c.getProd();
			
			for(int i=0; i<l.size(); i++)
			{
				p = l.get(i);
				if(p.getP_id() == pid)
					return "Alredy Exists";
			}
			
			l.add(responce.getBody());
			c.setProd(l);
			c.setTotal(total(l));
			cartRepo.save(c);
		}else
		{
			final String url1 ="http://localhost:7002/cust/check?cid=" +cid;
			HttpHeaders header1 = new HttpHeaders();
			header1.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity1 = new HttpEntity<String>(header1);
			ResponseEntity<Boolean> responce1 = template.exchange(url1, HttpMethod.GET, entity1, Boolean.class);
			System.out.println(responce1.getBody());
			if(responce1.getBody())
			{
				Cart c1 = new Cart();
				List<Product> l1 = new ArrayList<Product>();
				c1.setC_id(cid);
				l1.add(responce.getBody());
				c1.setProd(l1);
				c1.setTotal(total(l1));
				cartRepo.save(c1);
			}
		}
		
		return "Product Added";
	}

	public Object getCart() {
		
		return cartRepo.findAll();
	}

	public Object removeProd(int cid, int pid) {
		c = cartRepo.getById(cid);
		l = c.getProd();
		
		for(int i=0; i<l.size(); i++)
		{
			p = l.get(i);
			if(p.getP_id() == pid)
			{
				l.remove(i);
			}
		}
		
		c.setProd(l);
		c.setTotal(total(l));
		cartRepo.save(c);
		
		return "Product Removed";
	}

	public Object addQuantity(int cid, int pid, int q) {
		c = cartRepo.getById(cid);
		l = c.getProd();
		
		for(int i=0; i<l.size(); i++)
		{
			p = l.get(i);
			if(p.getP_id() == pid)
			{
				p.setQuantity(q);
				break;
			}
		}
		c.setProd(l);
		c.setTotal(total(l));
		cartRepo.save(c);
		return "Quantity Updated";
	}

}
