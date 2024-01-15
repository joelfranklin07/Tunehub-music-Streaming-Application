package com.example.tunehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entities.users;
import com.example.tunehub.repository.UserRepository;

@Service
public  class userServiceimplementation implements UsersService{
	@Autowired
	UserRepository repo;
	@Override
	public String addUser(users user)
	{
		repo.save(user);
		return "user added succesfully";
	}
	@Override
	public boolean emailExists(String email)
	{
		if(repo.findByEmail(email)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public boolean validateUser(String email,String password)
	{
		users user=repo.findByEmail(email);
		String db_pass=user.getPassword();
		if(password.equals(db_pass))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public String getRole(String email) {
		users user=repo.findByEmail(email);

		return user.getRole();
	}
	@Override
	public void updateuser(users user) 
	{
		repo.save(user);
		
	}
	@Override
	public users getUser(String email) {
		
		return repo.findByEmail(email);
	}
}
