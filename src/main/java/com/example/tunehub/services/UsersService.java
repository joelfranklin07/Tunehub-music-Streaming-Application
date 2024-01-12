package com.example.tunehub.services;

import com.example.tunehub.entities.users;

public interface UsersService {
	public String addUser(users user);

	public boolean emailExists(String email);

	public boolean validateUser(String email,String password);

	public void updateuser(users user);

	public String getRole(String email);

	public users getUser(String mail);

	
}
