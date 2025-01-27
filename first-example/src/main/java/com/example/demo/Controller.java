package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/home")
	public String welcome() {
		return "Welcome !";
	}
	
	@RequestMapping("/second")
	public String sayHello(@RequestParam String name) {
		return "Welcome: " + name;
	}
	
	@RequestMapping(path="/pathVar/{name}")
	public String fromUrlParam(@PathVariable String name) {
		return "Path Var: " + name;
	}
	
	@GetMapping(path="/sampleBean")
	public SampleBean getSampleBean() {
		return new SampleBean("SampleBean toString content returned");
	}
}
