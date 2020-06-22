package com.bewar.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bewar.todo.domain.Role;
import com.bewar.todo.domain.User;
import com.bewar.todo.repository.UserRepository;


// spring application

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
	
	// add bean to run once per application life-cycle
	
	@Bean
	public CommandLineRunner seed(UserRepository userRepository) {
		return (args) -> {
			if(userRepository.count() > 0) return;
			
			User user = new User("bewar", "bewar");
			user.setRole(Role.ADMIN);
			user.setEnabled(true);
			user.setEmail("bewar.usman@gmail.com");
			userRepository.save(user);
		};
	}
}
