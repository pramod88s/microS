package com.bvr.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class SecondController {

	public SecondController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/message")
	public String test() {
		return "Api Gateway called in second service.";
	}

}
