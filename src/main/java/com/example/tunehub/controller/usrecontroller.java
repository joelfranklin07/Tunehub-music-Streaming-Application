package com.example.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.tunehub.entities.users;
import com.example.tunehub.services.UsersService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class usrecontroller 
{
	@Autowired
	UsersService service;
	@PostMapping("/register")
	public String adduser(@ModelAttribute users user) 
	{
		boolean userstatus=service.emailExists(user.getEmail());
		if(userstatus==false)
		{
			service.addUser(user);
		}
		else
		{
			System.out.println("user email already exist");
		}
		return "login";
	}
	@PostMapping("/validate")
	public String validate(@RequestParam("email")String email,
			@RequestParam("password") String password,
			HttpSession session) {
		
		if(service.validateUser(email,password) == true) {
			String role = service.getRole(email);
			
			session.setAttribute("email", email);
			
			if(role.equals("admin")) {
				return "adminHome";
			}
			else {
				return "customerHome";
			}
		}
		else {
			return "login";
		}
	}
/*
	@PostMapping("/login")
	public String premiumuser(@RequestParam ("ispremium")String ispremium,HttpSession session) 
	{
		if(service.validateUser(ispremium)==true)
		{
			users premium=service.getUser(ispremium);
			session.setAttribute("ispremium", ispremium);
		if(premium.equals(premium))
		{
			return "display";
		}
		else
		{
			return "pay";
		}
		}
		else
		{
			return "login";
		}
	}*/
	@GetMapping("/logout")
	public String logout(HttpSession session) 
	{
		session.invalidate();
		return "login";
	}
	
	
}
