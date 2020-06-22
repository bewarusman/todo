package com.bewar.todo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bewar.todo.domain.CustomAuthority;
import com.bewar.todo.domain.CustomUserDetails;
import com.bewar.todo.domain.User;
import com.bewar.todo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.debug("username: {}", username);
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		logger.debug(user.toString());
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new CustomAuthority("ADMIN"));
		return new CustomUserDetails(user, authorities);
	}
	
}
