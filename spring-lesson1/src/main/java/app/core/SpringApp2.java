package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.components.Person;

public class SpringApp2 {

	public static void main(String[] args) {

		System.out.println("started");
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);) {
			Person p1 = ctx.getBean(Person.class);
			Person p2 = ctx.getBean(Person.class);
			System.out.println(p1.hashCode());
			System.out.println(p2.hashCode());
		}
		System.out.println("ended");

	}

}
