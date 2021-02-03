package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.a.injectors.circular.BeanA;

public class App2 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);) {

			BeanA a = ctx.getBean(BeanA.class);
			System.out.println(a);

		} catch (Exception e) {
			System.out.println("error");
		}

	}

}
