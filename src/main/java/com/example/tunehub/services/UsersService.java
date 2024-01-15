package com.example.tunehub.services;

import com.example.tunehub.entities.users;

public interface UsersService {
	public String addUser(users user);

	public boolean emailExists(String email);

	public boolean validateUser(String email,String password);

	public String getRole(String email);
	
	public void updateuser(users user);

	public users getUser(String mail);

	
}
