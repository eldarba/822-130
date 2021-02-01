package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.components.cars.Car;

public class App2 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);) {
			Car car = ctx.getBean(Car.class);
			car.startCar();
			car.startDrive();
		}
	}
}
