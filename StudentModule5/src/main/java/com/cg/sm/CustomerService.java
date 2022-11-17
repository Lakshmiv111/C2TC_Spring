package com.cg.sm;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service   
// its a specification of @component annotation. 
//it will register this class as the service layer and it will enables the auto-wiring.

@Transactional  
//you can annotate a bean with @Transactional either at the class or method level. 


public class CustomerService 
{
	@Autowired   //Force dependency injection.It injects object dependency implicitly
	
private CustomerRepository repo;
	
	public Customer registerCustomer(Customer customer)
	{
		return repo.save(customer);
	}
	
	public List<Customer> getCustomer()
	{
		return repo.findAll();
	}
	
	public void deleteCustomer(Integer id)
	{
		repo.deleteById(id);
	}
	
	public Customer updateCustomer(Customer customer)
	{
		Integer id = customer.getId();
		Customer cus = repo.findById(id).get();
		cus.setName(customer.getName());
		cus.setOrder_details(customer.getOrder_details());
		cus.setEmail(customer.getEmail());
		return repo.save(cus);
	}
}