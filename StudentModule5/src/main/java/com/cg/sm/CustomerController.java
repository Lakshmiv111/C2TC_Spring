package com.cg.sm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//It allows to handle all REST APLs such as GET,POST,DELETE,and PUT requests
@RestController  

//Gives permission to angular that to interact with spring.
@CrossOrigin(allowedHeaders = "*", origins = "*")

public class CustomerController {

	//Force dependency injection, It injects object dependency implicitly
	
	@Autowired     
	private CustomerService service;
	
	//It is used to create a web service end-point that creates.	
		// Is used to handle POST type of request method.
	
	@PostMapping("/registerCustomer")
	public Customer registerCustomer(@RequestBody Customer customer) {
		return service.registerCustomer(customer); }
	
	
	//Is used to handle GET type of request method, 
		//It maps the HTTP GET requests on the specific handler method.
		
	@GetMapping("/getCustomer")
	public List<Customer> getCustomer(){
		return service.getCustomer();
			}
	
	// It maps the HTTP DELETE requests on the specific handler method.
		//It is used to create a web service end-point that deletes a resource.
	
	@DeleteMapping("/deleteCustomer")
	public void deleteCustomer(@RequestParam Integer id) {
		service.deleteCustomer(id);}
	
	
	//It maps the HTTP PUT requests on the specific handler method.
		//It is used to create a web service end-point that creates or updates.	
		
	
	@PutMapping("/updateCustomer")
public Customer updateCustomer(@RequestBody Customer customer )	{
	return service.updateCustomer(customer);

	}
	
	
	}
