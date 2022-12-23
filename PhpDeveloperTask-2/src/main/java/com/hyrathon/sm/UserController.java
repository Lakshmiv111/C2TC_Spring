package com.hyrathon.sm;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.tomcat.util.descriptor.web.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
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



//It allows to handle all REST APLs such as GET,POST,DELETE,and PUT requests
//It is the combination of @Controller and @ ResponseBody
@RestController 

//Gives permission to angular that to interact with spring.
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

	
	
//Force dependency injection, It injects object dependency implicitly
/* 
 @Autowired is used to inject a bean or object into other inject a bean 
 */
@Autowired   //Force dependency injection, It injects object dependency implicitly
 private UserService service;
			
			
			//It is used to create a web service end-point that creates.	
			// Is used to handle POST type of request method.
/*
 @PostMapping annotation is used to , if you want to add new user to the 
 MySql database then you can go for @PostMapping.			
 */
@PostMapping("/registerUser")
	public User registerUser(@RequestBody User user) {
		return service.registerUser(user); }
			
			

			//Is used to handle GET type of request method, 
			//It maps the HTTP GET requests on the specific handler method.
/*
 @GetMapping is used to if you want to fetch or get something from the database
 the u can go for @GetMapping.	
 */
	@GetMapping("/getUser")
 public List<User> getUser(){
	return service.getUser();
					}
			
			// It maps the HTTP DELETE requests on the specific handler method.
			//It is used to create a web service end-point that deletes a resource.
	/*
@DeleteMapping is used because if you want to delete something from the database 
the you can go for @DeleteMapping.
	 */
 @DeleteMapping("/deleteUser")
	public void deleteUser(@RequestParam Integer id) {
service.deleteUser(id);}
			
			
			//It maps the HTTP PUT requests on the specific handler method.
			//It is used to create a web service end-point that creates or updates.	
/*
 @PutMapping is used to , if you want to update something from the database then you can 
 go for @PutMapping. 	
 */
	@PutMapping("/updateUser")
  public User updateUser(@RequestBody User user )	{
		return service.updateUser(user);

			}
			
			
			}




	
	
	
	
	
	
	
	
	
