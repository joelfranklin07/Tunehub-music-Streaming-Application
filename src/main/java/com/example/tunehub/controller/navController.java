package com.example.tunehub.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class navController 
{
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	@GetMapping("/newsong")
	public String newSong()
	{
		return "newsong";
	}
	
}
