package com.hyrathon.sm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service   
//its a specification of @component annotation. 
//it will register this class as the service layer and it will enables the auto-wiring.

@Transactional  
//you can annotate a bean with @Transactional either at the class or method level. 

public class UserService {

	
	@Autowired   //Force dependency injection.It injects object dependency implicitly
	
	private UserRepository repo;
		
		public User registerUser(User user)
		{
			return repo.save(user);
		}
		
		public List<User> getUser()
		{
			return (List<User>) repo.findAll();
		}
		
		public void deleteUser(Integer id)
		{
			repo.deleteById(id);
		}
		
		public User updateUser(User user)
		{
			
			Integer id = new Integer(0);
			User us = repo.findAll().get(id);
			us.setEmail(user.getEmail());
			us.setPhone(user.getPhone());
			us.setFirstname(user.getFirstname());
			us.setLastname(user.getLastname());
			us.setPassword(user.getPassword());
			
			return repo.save(us);
		}

	 
		}
//User Service class is used to create Methods for All REST APIs that is for 
//Delete, Post, Put, Get.


