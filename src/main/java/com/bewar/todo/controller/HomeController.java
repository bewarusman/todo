package com.bewar.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	public String home() {
		return "home"; // it renders a page called home.jsp
	}
	
	@GetMapping("/hello")
	@ResponseBody // specifies that the method does not render any page, only returns the text specified.
	public String hello() {
		return "Hello World";
	}
	
}
