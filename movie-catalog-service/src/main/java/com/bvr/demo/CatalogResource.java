package com.bvr.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvr.demo.models.CatalogItem;
import com.bvr.demo.models.Movie;
import com.bvr.demo.models.UserRating;
import com.bvr.demo.services.MovieInfo;
import com.bvr.demo.services.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	

	public CatalogResource() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	UserRatingInfo userRatingInfo;
	
	@Autowired
	MovieInfo movieInfo;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		UserRating userRating = userRatingInfo.getUserRating(userId);
		
		return userRating.getRatings().stream()
				.map(rating -> movieInfo.getCatalogItem(rating)).collect(Collectors.toList());
	}

}
