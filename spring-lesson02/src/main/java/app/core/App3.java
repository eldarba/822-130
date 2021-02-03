package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.components.cars.Car;

public class App3 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);) {

			Car car = ctx.getBean("specialCar", Car.class);
			car.startCar();
			car.startDrive();
			System.out.println("=============");
			Car car2 = ctx.getBean("car", Car.class);
			car2.startCar();
			car2.startDrive();
		}
	}
}
