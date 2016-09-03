package com.spring.sample;

public class GreetingServiceImpl implements GreetingService {
	private String greeting;

	public GreetingServiceImpl(String greeting) {
		this.greeting = greeting;
	}

	public GreetingServiceImpl() {
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void saygreeting() {

		System.out.println("Hai" + greeting);

	}

}
