package com.edusol.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusol.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
