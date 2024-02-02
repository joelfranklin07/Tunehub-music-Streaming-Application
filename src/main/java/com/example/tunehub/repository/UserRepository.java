package com.example.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tunehub.entities.users;

public interface UserRepository extends JpaRepository<users,Integer> {
	public users findByEmail(String email);
	@Query("SELECT c FROM users c WHERE c.email = ?1")
	public users findByResetPasswordToken(String token);
}
