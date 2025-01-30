package com.bvr.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bvr.demo.models.Car;
import com.bvr.demo.repositories.CarMongoRepository;
import com.bvr.demo.repositories.CarSearchRepository;

@Controller
public class CarController {
	
	@Autowired
	private CarSearchRepository carSearchRepository;
	
	@Autowired
	private CarMongoRepository carRepository;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("carList", carRepository.findAll());
		return "home";
	}

	@RequestMapping(value = "/addCar", method=RequestMethod.POST)
	public String addCar(@ModelAttribute Car car) {
		carRepository.save(car);
		return "redirect:home";
	}
}
