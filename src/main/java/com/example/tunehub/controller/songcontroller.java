package com.example.tunehub.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.tunehub.entities.song;
import com.example.tunehub.services.Songservice;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class songcontroller 
{
	@Autowired
	Songservice service;
	@PostMapping("/addsong")
	public String addSong(@ModelAttribute song song) {
		boolean songname=service.songExists(song.getName());
		if(songname==false)
		{
			service.addsong(song);
		}
		else
		{
			System.out.println("song  already exists");
		}
		return "adminhome";
	}	
	@GetMapping("/viewsong")
	public String viewsong(Model model) 
	{
		List<song>songlist=service.fetchAllSongs();
		model.addAttribute("songs", songlist);
		return "display";
	}
	@GetMapping("/playSong")
	public String playsong(Model model) 
	{
		boolean premiumsuer=false;
		if(premiumsuer==true)
		{
			List<song>songlist=service.fetchAllSongs();
			model.addAttribute("songs", songlist);
			return "display";
		}
		else
		{
			return "makepayment"; 
		}
	}
}