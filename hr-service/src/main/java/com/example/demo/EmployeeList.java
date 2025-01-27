package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmployeeList {
	
	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
