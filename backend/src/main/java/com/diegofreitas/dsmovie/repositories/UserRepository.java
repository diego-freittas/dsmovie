package com.diegofreitas.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegofreitas.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
}
