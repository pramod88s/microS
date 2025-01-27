package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "n1", 30));
		users.add(new User(2, "n2", 31));
		users.add(new User(3, "n3", 29));
	}

	public List<User> getAll() {
		return users;
	}
}
