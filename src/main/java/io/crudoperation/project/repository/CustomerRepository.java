package io.crudoperation.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.crudoperation.project.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository <Customer, Long> { 
    List<Customer> findByName(String name); 
}