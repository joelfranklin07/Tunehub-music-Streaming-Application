package com.example.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunehub.entities.song;

public interface SongRepository extends JpaRepository<song, Integer>{

	public song findByname(String name);

}
