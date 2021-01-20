package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.components.Person;

public class SpringApp3 {

	public static void main(String[] args) {

		System.out.println("started");
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);) {

			Person p1 = ctx.getBean("person", Person.class);
			Person p2 = ctx.getBean("person", Person.class);

			Person mgr = ctx.getBean("theManager", Person.class);
			Person eng = ctx.getBean("theEngineer", Person.class);

			System.out.println(p1);
			System.out.println(p2);
			System.out.println(mgr);
			System.out.println(eng);

		}
		System.out.println("ended");

	}

}
