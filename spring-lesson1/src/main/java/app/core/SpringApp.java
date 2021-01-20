package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.components.Animal;
import app.core.components.Person;

public class SpringApp {

	public static void main(String[] args) {

		// create and start the container
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		// ask the container for a bean
		Person p = ctx.getBean(Person.class);
		// use the bean
		System.out.println(p);

		// animal
		Animal animal = ctx.getBean(Animal.class);
		animal.speak();

		// close the container
		ctx.close();
	}

}
