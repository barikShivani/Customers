package com.example.cutomerDetails.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.cutomerDetails.entity.Customer;
import com.example.cutomerDetails.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	//save
	public Customer customerData(Customer customer)
	{
		return repository.save(customer);
	}
	
	//get data
	public List<Customer> getCustomerByName(String name)
	{
		return repository.getByName(name);
	}
	
	//get by id
	public Customer getCustomerById(int Id)
	{
		System.out.println(repository.findById(Id).get());
		Customer bookId = repository.findById(Id).get();
		return bookId;
	}
	//get by Price
		public List<Customer> getCustomerByPrice(Long price) {
			System.out.println(repository.getByPrice(price));
			return repository.getByPrice(price);
			
		}
	
	//get By price greater then 100000
	public List<Customer> getCustomerByPriceGreaterthen()
	{
		List<Customer> customers=repository.findAll();
		
		List<Customer> listOfCustomer = customers.stream().filter(x->x.getPrice()>100000).collect(Collectors.toList());
		System.out.println(listOfCustomer);
		
		return listOfCustomer;
	}
	//update by Id
	public Customer updateCustomer(Customer customer)
	{
		Customer newCustomer=repository.findById(customer.getId()).orElse(null);
		
		
		newCustomer.setName(customer.getName());
		newCustomer.setPrice(customer.getPrice());
		newCustomer.setProduct(customer.getProduct());
		
		
		
		return repository.save(newCustomer);
	}
	
	
	
	//delete data

	public String deleteById(int id) {
		
		 repository.deleteById(id);
		
		return "customer removed of id :"+id;
	}

	public List<Customer> getAllCustomer() {
		
		return repository.findAll();
	}
   

}
