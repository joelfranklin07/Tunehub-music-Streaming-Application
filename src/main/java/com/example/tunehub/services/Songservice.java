package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entities.song;

public interface Songservice 
{
	public void addsong(song song);

	public List<song> fetchAllSongs();

	public boolean songExists(String name);

	public void updatesong(song song);

}
