package com.example.tunehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tunehub.entities.users;
import com.example.tunehub.repository.UserRepository;

@Service
public  class userServiceimplementation implements UsersService{
	@Autowired
	UserRepository repo;
	
	
	 public void updateResetPasswordToken(String token, String email) throws usersNotFoundException {
	        users u = repo.findByEmail(email);
	        if (u != null) {
	            u.setResetPasswordToken(token);
	            repo.save(u);
	        } else {
	            throw new usersNotFoundException("Could not find any customer with the email " + email);
	        }
	    }
	     
	    public users getByResetPasswordToken(String token) {
	        return repo.findByResetPasswordToken(token);
	    }
	     
	    public void updatePassword(users user, String newPassword) {
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(newPassword);
	        user.setPassword(encodedPassword);
	         
	        user.setResetPasswordToken(null);
	        repo.save(user);
	    }
	    
	    
	    
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
