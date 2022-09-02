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

@RestController                      // It allows to handle all REST APLs such as GET,POST,DELETE,and PUT requests
public class EmployeeController {
	@Autowired                                 //Force dependency injection.It injects object dependency implicitly.
	private EmployeeService service;
	@GetMapping("/employee")
	public List<Employee> list()
	{
		return service.listAll();
	}
	@GetMapping("/employee/{id}")                                      //is used to handle GET type of request method
	public ResponseEntity<Employee> get(@PathVariable Integer id)
	{
		try {  //try:The try statement allows you to define a block of code to be tested for errors while it is being executed. 
			Employee employee = service.get(id);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
		catch (NoSuchElementException e)//The catch statement allows you to define a block of code to be executed, if an error occurs in the try block.
		{
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/employee")                                     // is used to handle POST type of request method
                                                                	//It is used to create a web service end-point that creates.
	public void add(@RequestBody Employee employee)
	{
		service.save(employee);
	}
	@PutMapping("/employee/{id}")               //It is used to create a web service end-point that creates or updates.
	public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Integer id)
	{
		try {
			Employee existEmployee = service.get(id);
			service.save(employee);
			return new ResponseEntity<>(HttpStatus.OK);
		} 
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/employee/{id}")                // It maps the HTTP DELETE requests on the specific handler method.
	public void delete(@PathVariable Integer id)
	{
		service.delete(id);
	}
}