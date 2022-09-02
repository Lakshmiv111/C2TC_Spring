package com.cg.sm;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service                     //it will register this class as the service layer and it will enables the auto-wiring.
@Transactional               //you can annotate a bean with @Transactional either at the class or method level. 

public class CustomerService {
	@Autowired                //Force dependency injection.It injects object dependency implicitly
	
private CustomerRepository repo;
	
	public List<Customer> listAll()
	{
	return repo.findAll();
	}
	
	public void save(Customer customer)
	{
	repo.save(customer);
	}
	
	public  Customer get(Integer id)
	{
	return repo.findById(id).get();	
	}
	
	public void delete(Integer id)
	{
	repo.deleteById(id);
}
}