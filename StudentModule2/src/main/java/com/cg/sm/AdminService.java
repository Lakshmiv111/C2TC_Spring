package com.cg.sm;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service   
// its a specification of @component annotation. 
//it will register this class as the service layer and it will enables the auto-wiring.

@Transactional  
//you can annotate a bean with @Transactional either at the class or method level. 


public class AdminService 
{
	@Autowired   //Force dependency injection.It injects object dependency implicitly
	
private AdminRepository repo;
	
	public Admin registerAdmin(Admin admin)
	{
		return repo.save(admin);
	}
	
	public List<Admin> getAdmin()
	{
		return (List<Admin>) repo.findAll();
	}
	
	public void deleteAdmin(Integer id)
	{
		repo.deleteById(id);
	}
	
	public Admin updateAdmin(Admin admin)
	{
		Integer id = admin.getId();
		Admin ad = repo.findById(id).get();
		ad.setName(admin.getName());
		ad.setPassword(admin.getPassword());
		ad.setPhone(admin.getPhone());
		return repo.save(ad);
	}
}