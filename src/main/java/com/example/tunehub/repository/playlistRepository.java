package com.example.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunehub.entities.playlist;

public interface playlistRepository extends JpaRepository<playlist, Integer> 
{
	
	
}
