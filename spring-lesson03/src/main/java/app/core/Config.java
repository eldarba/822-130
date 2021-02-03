package app.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import app.core.beans.a.injectors.ExampleInjectAnnotation;

@Configuration
@ComponentScan
public class Config {

	// bean methods

	@Bean
	public String appName() {
		return "Lesson 3 - SPRING";
	}

	@Bean
	public String appName2() {
		return "Lesson 3 - SPRING 2";
	}

	@Bean
	public Integer five() {
		return 5;
	}

	@Bean
	public ExampleInjectAnnotation myyyyyBean() {
		return new ExampleInjectAnnotation();
	}

}
