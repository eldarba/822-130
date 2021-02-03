package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.components.cinema.Cinema;

public class App4 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);) {

			Cinema cinema = ctx.getBean(Cinema.class);
			System.out.println(cinema);

		}
	}
}
