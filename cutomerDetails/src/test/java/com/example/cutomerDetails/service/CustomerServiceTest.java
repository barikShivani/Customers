package com.example.cutomerDetails.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cutomerDetails.entity.Customer;
import com.example.cutomerDetails.repository.CustomerRepository;

@SpringBootTest
public class CustomerServiceTest {
	
	//inject that dependency of spring for the class which you want to test.now it is the task of spring container to provide you 
	//the bean of service when you are doing inject mock on it.
	
	@InjectMocks
	CustomerService customerService;
	
	//i dont want to invoke any Crudrepository i dont want to hit my database that means in reality this repository never going to be hit.
	@Mock
	CustomerRepository repo;
	
	

	@Test
	public void getCustomerByIdTest()
	{
		when(repo.findById(1)).thenReturn(createCustomerStub());
		Customer testCustomer = customerService.getCustomerById(1);
		
		assertEquals(testCustomer.getName(), "decode");
	}
	
	public Optional<Customer> createCustomerStub()
	{
		Customer stubCustomer = Customer.builder().id(1).name("decode").product("MacBook").price(100000000L).build();
		
		return Optional.of(stubCustomer);
	}
	
		
		
	
}
