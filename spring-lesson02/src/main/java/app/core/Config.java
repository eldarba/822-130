package app.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import app.core.components.School;

@Configuration
@ComponentScan
public class Config {

	@Bean("school2")
	public School otherSchool() {
		School school = new School();
		school.id = "school-2";
		return school;
	}

	@Bean
	@Scope("prototype")
	public Integer randChange() {
		int r = (int) (Math.random() * 101);
		return r;
	}

	@Bean
	public Integer randUnchange() {
		int r = (int) (Math.random() * 101);
		return r;
	}

}
