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

@RestController                 // It allows to handle all REST APLs such as GET,POST,DELETE,and PUT requests
public class AdminController {

	@Autowired         //Force dependency injection, It injects object dependency implicitly
	
	private AdminService service;
	
	@GetMapping("/admin")       //Is used to handle GET type of request method. It maps the HTTP GET requests on the specific handler method.
	public List<Admin> list()
	{
	return service.listAll();
	}
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> get(@PathVariable Integer id)
	{
	try            //try:The try statement allows you to define a block of code to be tested for errors while it is being executed. 
	{
	Admin admin = service.get(id);
	return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}
	catch (NoSuchElementException e) //The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.
	{
	return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
	}
	}
	
	
	@PostMapping("/admin")                          // Is used to handle POST type of request method.
	                                          //It is used to create a web service end-point that creates.          
	public void add(@RequestBody Admin admin)
	{
	service.save(admin);
	}
	
	@PutMapping("/admin/{id}")                //It maps the HTTP PUT requests on the specific handler method.
	                                   //It is used to create a web service end-point that creates or updates.
	public ResponseEntity<?> update(@RequestBody Admin admin, @PathVariable Integer id)
	{
	try
	{
	Admin existAdmin = service.get(id);
	service.save(admin);
	return new ResponseEntity<>(HttpStatus.OK);
	}
	catch (NoSuchElementException e)
	{
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	
	@DeleteMapping("/admin/{id}")                     // It maps the HTTP DELETE requests on the specific handler method.
	                                                   //It is used to create a web service end-point that deletes a resource. 
	public void delete(@PathVariable Integer id)
	{
	service.delete(id);
	}
}