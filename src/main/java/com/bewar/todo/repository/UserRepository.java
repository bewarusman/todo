package com.bewar.todo.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.bewar.todo.domain.User;

public interface UserRepository extends CrudRepository<User, UUID> {
	
	User findByUsername(String username);
	
}
