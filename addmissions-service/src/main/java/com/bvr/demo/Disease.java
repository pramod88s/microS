package com.bvr.demo;

public class Disease {
	
	private String id;
	private String description;
	private String treatment;
	public Disease(String id, String description, String treatment) {
		super();
		this.id = id;
		this.description = description;
		this.treatment = treatment;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	
}
