package com.example.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tunehub.entities.users;

public interface UserRepository extends JpaRepository<users,Integer> {
	public users findByEmail(String email);
}
