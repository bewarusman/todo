package com.bewar.todo.domain;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CustomAuthority implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;
	
	private final String authority;

	@Override
	public String getAuthority() {
		return authority;
	}
	
}
