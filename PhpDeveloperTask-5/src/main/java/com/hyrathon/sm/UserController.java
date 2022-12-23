package com.hyrathon.sm;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController                 // It allows to handle all REST APLs such as GET,POST,DELETE,and PUT requests
//It allows to handle all REST APLs such as GET,POST,DELETE,and PUT requests
//It is the combination of @Controller and @ ResponseBody

//Gives permission to angular that to interact with spring.
@CrossOrigin(allowedHeaders = "*", origins = "*")

public class UserController {
	
	@Autowired         //Force dependency injection, It injects object dependency implicitly
	//Force dependency injection, It injects object dependency implicitly

	//@Autowired   //Force dependency injection, It injects object dependency implicitly
	private UserService service;

	@GetMapping("/user")       //Is used to handle GET type of request method. It maps the HTTP GET requests on the specific handler method.
	public List<User> list()
	{
	return service.listAll();
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id)
	{
	try            //try:The try statement allows you to define a block of code to be tested for errors while it is being executed. 
	{
	User user = service.get(id);
	return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	catch (NoSuchElementException e) //The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.
	{
	return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	}
	//It is used to create a web service end-point that creates.	
	// Is used to handle POST type of request method.

	@PostMapping("/registerUser")
	public User registerUser(@RequestBody User user) {
		return service.registerUser(user, service); }

	@PostMapping("/user")                          // Is used to handle POST type of request method.
	                                          //It is used to create a web service end-point that creates.          
	public void add(@RequestBody User user)
	{
	service.save(user);
	}

	@PutMapping("/user/{id}")                //It maps the HTTP PUT requests on the specific handler method.
	                                   //It is used to create a web service end-point that creates or updates.
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id)
	{
	try
	{
	User existUser = service.get(id);
	service.save(user);
	return new ResponseEntity<>(HttpStatus.OK);
	}
	catch (NoSuchElementException e)
	{
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	//Is used to handle GET type of request method, 
	//It maps the HTTP GET requests on the specific handler method.

	@GetMapping("/getUser")
	public List<User> getUser(){
		return service.getUser();
			}

	// It maps the HTTP DELETE requests on the specific handler method.
	//It is used to create a web service end-point that deletes a resource.

	@DeleteMapping("/deleteUser")
	public void deleteUser(@RequestParam Integer id) {
		service.delete(id);}


	//It maps the HTTP PUT requests on the specific handler method.
	//It is used to create a web service end-point that creates or updates.	

	@PutMapping("/updateUser")
  public User updateUser(@RequestBody User user )	{
	return service.updateUser(user);

	}

	@DeleteMapping("/user/{id}")        
	// It maps the HTTP DELETE requests on the specific handler method.
	//It is used to create a web service end-point that deletes a resource. 
	public void delete(@PathVariable Integer id)
	{
	service.delete(id);

	}

	
	
	
	
	
	
	
	

}
