package com.spring.sample;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class GreetingTest {

	public static void main(String[] args) {
	BeanFactory factory=new XmlBeanFactory(new FileSystemResource("greeting.xml"));
	GreetingService gsl=(GreetingService) factory.getBean("gs1");
	gsl.saygreeting();

	}

}