package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	@Autowired
	private UserDao userDAO;
	
	public List<User> findAll() {
		return userDAO.getAll();
	}
}
