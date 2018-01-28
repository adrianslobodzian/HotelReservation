package com.github.adrianslobodzian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.adrianslobodzian.entities.User;



public interface UserRepository extends JpaRepository<User, Long> {

	User findFirstByEmail(String email);
	
}
