package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoint2 {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public List<User> retrieveAll(){
		return userService.findAll();
	}

}
