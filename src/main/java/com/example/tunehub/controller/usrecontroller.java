package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tunehub.entities.song;
import com.example.tunehub.entities.users;
import com.example.tunehub.services.Songservice;
import com.example.tunehub.services.UsersService;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class usrecontroller 
{
	@Autowired
	UsersService service;
	@Autowired
	Songservice songservice;
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
	public String validate(@RequestParam("email")String email,@RequestParam("password")String password,HttpSession session,Model model) 
	{
		if(service.validateUser(email,password) == true) {
			String role = service.getRole(email);
			
			session.setAttribute("email", email);
			
			if(role.equals("admin")) {
				return "adminHome";
			}
			else {
				users user=service.getUser(email);
				boolean userstatus=user.isIspremium();
				List<song>songlist=songservice.fetchAllSongs();
				model.addAttribute("songs", songlist);
				model.addAttribute("ispremium", userstatus);
				return "customerHome";
			}
		}
		else {
			return "login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) 
	{
		session.invalidate();
		return "login";
	}
	
	
}
