package com.hyrathon.sm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import jakarta.transaction.Transactional;

@Service      
// its a specification of @component annotation. it will register this class as the service layer and it will enables the auto-wiring.
@Transactional                         
//you can annotate a bean with @Transactional either at the class or method level. 



public class UserService {


	@Autowired
	private UserRepository repo;
	
	
	public List<User> listAll(){
		return repo.findAll();
	}
	
	public void save(User user)
	{
	repo.save(user);
	}
	public User get(Integer id)
	{
	return repo.findById(id).get();
	}
	public void delete(Integer id)
	{
	repo.deleteById(id);
	
}

	public List<User> getUser() {
		
		return repo.findAll();
	}

	public void update(Integer id)
	{
	 
	}
	
	public User registerUser(User user, UserService service) {
	
	return service.updateUser(user);
		
	}

	User updateUser(User user) {
		
		return null;
	}

	public User updateCustomer(User user)
	{
		Integer id = user.getId();
		User cus = repo.findById(id).get();
		cus.setEmail(user.getEmail());
		cus.setFirstname(user.getFirstname());
		cus.setLastname(user.getLastname());
		cus.setPassword(user.getPassword());
		cus.setPhone(user.getPhone());
		return repo.save(cus);
	}

	
	
	
	
		
}

