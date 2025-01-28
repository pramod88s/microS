package com.bvr.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigProfileServiceApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(ConfigProfileServiceApplication.class, args);
	}
	
	@Autowired
	private ServerProperties serverProperties;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(serverProperties);
	}

}
