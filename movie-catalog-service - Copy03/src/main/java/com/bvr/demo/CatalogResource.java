package com.bvr.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bvr.demo.models.CatalogItem;
import com.bvr.demo.models.Movie;
import com.bvr.demo.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);
		
		return userRating.getRatings().stream()
				.map(rating -> {
					Movie movie = restTemplate.getForObject("http://movie-service/movies/" + rating.getMovieId(), Movie.class);
					return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
				}).collect(Collectors.toList());
	}
	
	public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId) {
		return Arrays.asList(new CatalogItem("No Movie info at this time", "", 0));
	}

}
