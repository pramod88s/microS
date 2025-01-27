package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HrResource {

	List<Employee> employees = Arrays.asList(
			new Employee("e1", "Ram", "k", "MedTech"),
			new Employee("e2", "Raj", "k", "Surgery"),
			new Employee("e3", "Rajesh", "k", "Dentistry")
			);
	
	@RequestMapping("/employees")
	public EmployeeList getEmployees(){
		EmployeeList empList = new EmployeeList();
		empList.setEmployees(employees);
		
		return empList;
	}
	
	
	@RequestMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") String id){
		Employee e = employees.stream()
				.filter(emp -> id.equals(emp.getId()))
				.findAny().orElse(null);
		
		return e;
	}
}
