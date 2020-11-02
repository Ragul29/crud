package io.crudoperation.project.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import io.crudoperation.project.entity.Customer;

@Repository
public interface CustomerRepository extends MongoRepository <Customer, String> { 
	
	
    List<Customer> findByName(String name); 
}