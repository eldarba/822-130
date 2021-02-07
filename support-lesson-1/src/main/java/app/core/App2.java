package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Car;
import app.core.beans.Person;

public class App2 {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App1.class)) {

			Person p1 = ctx.getBean("person2", Person.class);
			System.out.println(p1);

			Car car = ctx.getBean(Car.class);
			car.turn();
		}

	}

}
