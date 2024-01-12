package com.example.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tunehub.entities.song;
import com.example.tunehub.repository.SongRepository;

@Service
public class songserviceimplementation implements Songservice 
{
	@Autowired
	SongRepository repo;
	@Override
	public void addsong(song song) 
	{
		repo.save(song);
	}
	@Override
	public List<song> fetchAllSongs() {
		return repo.findAll();
	}
	@Override
	public boolean songExists(String name) 
	{
		song song=repo.findByname(name);
		if(song == null)
		{
			return false;
		}
		else
		{
			return true;
			
		}
	}
	@Override
	public void updatesong(song song) {
		repo.save(song);
		
	}
}
