package com.bewar.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // annotation for controller
@RequestMapping("/todo") // specifies the URL path
public class TodoController {
	
	@GetMapping // get request
	public String index() {
		return "todo";
	}
	
}
