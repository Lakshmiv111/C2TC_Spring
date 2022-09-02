package com.cg.sm;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController                             // It allows to handle all REST APLs such as GET,POST,DELETE,and PUT requests

public class CustomerController {

	@Autowired                          //Force dependency injection, It injects object dependency implicitly
	private CustomerService service;
	@GetMapping("/customer")        //Is used to handle GET type of request method, It maps the HTTP GET requests on the specific handler method.
	
	public List<Customer> list()
	{
		return service.listAll();
	}
@GetMapping("/customer/{id}")
public ResponseEntity<Customer> get(@PathVariable Integer id)
{
	try {  //try:The try statement allows you to define a block of code to be tested for errors while it is being executed. 
		Customer customer = service.get(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	} 
 catch (NoSuchElementException e) { //The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
}
@PostMapping("/customer")                          // Is used to handle POST type of request method.
//It is used to create a web service end-point that creates.          
public void add(@RequestBody Customer customer)
{
service.save(customer);
}

@PutMapping("/customer/{id}")                //It maps the HTTP PUT requests on the specific handler method.
//It is used to create a web service end-point that creates or updates.
public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Integer id)
{
try
{
Customer existCustomer = service.get(id);
service.save(customer);
return new ResponseEntity<>(HttpStatus.OK);
}
catch (NoSuchElementException e)
{
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
@DeleteMapping("/customer/{id}")                      // It maps the HTTP DELETE requests on the specific handler method.
                                                     //It is used to create a web service end-point that deletes a resource. 
public void delete(@PathVariable Integer id)
{
	service.delete(id);
}
}