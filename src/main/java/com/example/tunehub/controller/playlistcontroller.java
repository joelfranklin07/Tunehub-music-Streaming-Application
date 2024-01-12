package com.example.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.tunehub.entities.playlist;
import com.example.tunehub.entities.song;
import com.example.tunehub.services.Songservice;
import com.example.tunehub.services.playlistService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class playlistcontroller
{
	@Autowired
	Songservice songservice;
	@Autowired
	playlistService playlistservice;
	
	@GetMapping("/createplaylist")
	public String createplaylist(Model model) 
	{
		List<song>songlist=songservice.fetchAllSongs();
		model.addAttribute("songs", songlist);
		return "createplaylist";
	}
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute playlist playlist)
	{
		playlistservice.addplaylist(playlist);
		System.out.println(playlist);
		List<song> songlist=playlist.getSongs();
		for(song s: songlist)
		{
			s.getPlaylists().add(playlist);
			songservice.updatesong(s);
		}
		return "adminhome";
	}
	@GetMapping("/viewplaylist")
	public String viewplaylist(Model model) 
	{
		List<playlist>allplaylist=playlistservice.fetchAllPlaylist();
		model.addAttribute("allplaylist", allplaylist);
		return "displayplaylist";
	}
	
	
	
}
