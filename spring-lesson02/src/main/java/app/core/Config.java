package app.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import app.core.components.School;
import app.core.components.cars.Car;
import app.core.components.cars.PremiumGear;
import app.core.components.cars.TurboEngine;

@Configuration
@ComponentScan
@PropertySource("application.properties")
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

	@Bean
	public Car specialCar() {
		// CTOR is invoked by client us
		Car car = new Car(new TurboEngine(), new PremiumGear());
		return car;
	}

}
