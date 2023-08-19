package com.example.cutomerDetails.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cutomerDetails.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> getByName(String name);

	

	List<Customer> getByPrice(Long price);



	
	

	

}
