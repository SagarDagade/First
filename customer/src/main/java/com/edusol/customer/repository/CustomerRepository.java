package com.edusol.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusol.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
