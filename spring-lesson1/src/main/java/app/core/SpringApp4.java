package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.components.Bank;
import app.core.components.Person;

public class SpringApp4 {

	public static void main(String[] args) {

		System.out.println("started");
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);) {

			Bank tlv = ctx.getBean("bankTlv", Bank.class);
			Bank jer = ctx.getBean("bankJer", Bank.class);

			tlv.add(ctx.getBean("theManager", Person.class));
			tlv.add(new Person(1, "aaa", 20));
			tlv.add(new Person(2, "bbb", 20));
			tlv.add(new Person(3, "ccc", 20));

			jer.add(ctx.getBean("theEngineer", Person.class));
			jer.add(new Person(4, "ccc", 20));
			jer.add(new Person(5, "eee", 20));

			System.out.println(tlv.getPersons());
			System.out.println(ctx.getBean("bankJer", Bank.class).getPersons()); // singleton

		}
		System.out.println("ended");

	}

}
