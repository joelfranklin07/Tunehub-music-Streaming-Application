package com.example.tunehub.services;

import java.util.List;

import com.example.tunehub.entities.playlist;

public interface playlistService {

	public void addplaylist(playlist playlist);

	public List<playlist> fetchAllPlaylist();

}
