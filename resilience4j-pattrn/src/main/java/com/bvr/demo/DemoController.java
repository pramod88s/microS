package com.bvr.demo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bvr.demo.services.HttpBinServices;

@RestController
public class DemoController {

	public DemoController() {
	}

	Logger LOG = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;
	
	@Autowired
	private HttpBinServices httpBinServices;
	
	public DemoController(CircuitBreakerFactory circuitBreakerFactory, HttpBinServices httpBinServices) {
		super();
		this.circuitBreakerFactory = circuitBreakerFactory;
		this.httpBinServices = httpBinServices;
	}

	@GetMapping("/get")
	public Map get() {
		return httpBinServices.get();
	}
	
	@GetMapping("/delay/{seconds}")
	public Map delay(@PathVariable int seconds) {
		return circuitBreakerFactory.create("delay").run(httpBinServices.delaySupplier(seconds), t -> {
			LOG.warn("Delay service call failed error.", t);
			
			Map<String, String> fallback = new HashMap<>();
			fallback.put("Message_from_fallback_functionality", "Alternative path from Oracle India.");
			return fallback;
		});
	}
	
}
