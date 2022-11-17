package com.cg.sm;

import java.util.List;
import java.util.NoSuchElementException;

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
// It is the combination of @Controller and @ ResponseBody
@RestController  

//Gives permission to angular that to interact with spring.
@CrossOrigin(allowedHeaders = "*", origins = "*")

public class AdminController {

	//Force dependency injection, It injects object dependency implicitly
	
	@Autowired   //Force dependency injection, It injects object dependency implicitly
	private AdminService service;
	
	
	//It is used to create a web service end-point that creates.	
	// Is used to handle POST type of request method.
	
	@PostMapping("/registerAdmin")
	public Admin registerAdmin(@RequestBody Admin admin) {
		return service.registerAdmin(admin); }
	
	

	//Is used to handle GET type of request method, 
	//It maps the HTTP GET requests on the specific handler method.
	
	@GetMapping("/getAdmin")
	public List<Admin> getAdmin(){
		return service.getAdmin();
			}
	
	// It maps the HTTP DELETE requests on the specific handler method.
	//It is used to create a web service end-point that deletes a resource.
	
	@DeleteMapping("/deleteAdmin")
	public void deleteAdmin(@RequestParam Integer id) {
		service.deleteAdmin(id);}
	
	
	//It maps the HTTP PUT requests on the specific handler method.
	//It is used to create a web service end-point that creates or updates.	
	
	@PutMapping("/updateAdmin")
  public Admin updateAdmin(@RequestBody Admin admin )	{
	return service.updateAdmin(admin);

	}
	
	
	}




	
