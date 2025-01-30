package com.bvr.demo.services;

import java.util.Map;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpBinServices {
	
	@Autowired
	RestTemplate rest;


	public HttpBinServices(RestTemplate restTemplate) {
		super();
		this.rest = restTemplate;
	}
	
	public Map get() {
		return rest.getForObject("https://httpbin.org/get", Map.class);
	}
	
	public Map delay(int seconds) {
		return rest.getForObject("https://httpbin.org/delay/" + seconds, Map.class);
	}
	
	public Supplier<Map> delaySupplier(int seconds) {
		return () -> this.delay(seconds);
	}
}
