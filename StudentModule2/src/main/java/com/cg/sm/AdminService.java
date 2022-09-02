package com.cg.sm;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service      // its a specification of @component annotation. it will register this class as the service layer and it will enables the auto-wiring.
@Transactional                         //you can annotate a bean with @Transactional either at the class or method level. 
public class AdminService 
{
	@Autowired                               //Force dependency injection.It injects object dependency implicitly
	private AdminRepository repo;
	
	public List<Admin> listAll()
	{
	return repo.findAll();
	}
	
	public void save(Admin admin)
	{
	repo.save(admin);
	}
	
	public  Admin get(Integer id)
	{
	return repo.findById(id).get();	
	}
	public void delete(Integer id)
	{
	repo.deleteById(id);
	}
}