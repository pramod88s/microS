package com.bvr.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pathology")
public class PathologyResource {
	
	List<Disease> diseases = Arrays.asList(
			new Disease("d1", "Infection", "Medicines"),
			new Disease("d2", "TMJ", "Aligners"),
			new Disease("d3", "Stomach flu", "acetaminophen")
			);
	
	@RequestMapping("/diseases")
	public DiseaseList getDiseases(){
		DiseaseList diseaseList = new DiseaseList();
		diseaseList.setDiseases(diseases);
		
		return diseaseList;
	}
	
	
	@RequestMapping("/diseases/{id}")
	public Disease getDiseaseById(@PathVariable("id") String id){
		Disease disease = diseases.stream()
				.filter(d -> id.equals(d.getId()))
				.findAny().orElse(null);
		
		return disease;
	}
}
