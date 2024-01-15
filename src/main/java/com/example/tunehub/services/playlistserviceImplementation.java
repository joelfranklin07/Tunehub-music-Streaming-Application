package com.example.tunehub.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tunehub.entities.playlist;
import com.example.tunehub.repository.playlistRepository;

@Service
public class playlistserviceImplementation implements playlistService
{
	@Autowired
	playlistRepository repo;
	@Override
	public void addplaylist(playlist playlist)
	{
		repo.save(playlist);
	}
	@Override
	public List<playlist> fetchAllPlaylist()
	{	
		return repo.findAll();
	}
}
