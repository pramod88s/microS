package com.example.demo;

public class SampleBean {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SampleBean(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "SampleBean [message=" + message + "]";
	}

}
