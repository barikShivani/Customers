package com.example.cutomerDetails.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cutomerDetails.entity.Customer;
import com.example.cutomerDetails.service.CustomerService;



@RestController
@RequestMapping("/customer/")
public class CustomerContoller {
	
	@Autowired
	private CustomerService service;
	
	//save
	@PostMapping(path="/save")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer)
	{
		Customer newCustomer = service.customerData(customer);
		return new ResponseEntity<Customer>(newCustomer,HttpStatus.OK);
	}
	//get by name
	@GetMapping(path="/name/{name}")
	public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable String name)
	{
		return new ResponseEntity<List<Customer>>(service.getCustomerByName(name),HttpStatus.OK);
	}
	
	//get By Id
	@GetMapping(path="/id/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id)
	{
		Customer ids =service.getCustomerById(id);
		return new ResponseEntity<Customer>(ids,HttpStatus.OK);
	}
	
	//get by price greater then 10000
	@GetMapping(path="/price/{price}")
	public ResponseEntity<List<Customer>> getCustomerByPrice(@PathVariable Long price)
	{
	
		return new ResponseEntity<List<Customer>>(service.getCustomerByPrice(price),HttpStatus.OK);
	}
	
	@GetMapping(path="/customers")
	public ResponseEntity<List<Customer>> getCustomerByPriceGreaterThen()
	{
	
		return new ResponseEntity<List<Customer>>(service.getCustomerByPriceGreaterthen(),HttpStatus.OK);
	}
	
	@GetMapping(path="/all")
	public ResponseEntity<List<Customer>> getAllCustomer()
	{
		return new ResponseEntity<List<Customer>>(service.getAllCustomer(),HttpStatus.OK);
	}
	
	//update by id
	@PostMapping(path="/updateDetails")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(service.updateCustomer(customer),HttpStatus.OK);
	}
	
	
	
	//delete
	@DeleteMapping(path="/id/{id}")
	public ResponseEntity<?> removeCustomer(@PathVariable int id)
	{
		return new ResponseEntity<>(service.deleteById(id),HttpStatus.OK);
	}
	

}
