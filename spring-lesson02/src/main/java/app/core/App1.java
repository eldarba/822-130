package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.components.School;

public class App1 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);) {
			System.out.println("Spring container is up");
			// ============================================
			System.out.println("Hello");
			School sc1 = ctx.getBean("school1", School.class);
			School sc2 = ctx.getBean("school2", School.class);
			System.out.println(sc1.id);
			System.out.println(sc2.id);
			// singleton bean will always be that same instance
			System.out.println(ctx.getBean("school1", School.class));
			System.out.println(ctx.getBean("school1", School.class));
			System.out.println(ctx.getBean("school1", School.class));
			System.out.println(ctx.getBean("school1", School.class));

			System.out.println(ctx.getBean("randChange"));
			System.out.println(ctx.getBean("randChange"));
			System.out.println(ctx.getBean("randChange"));

			System.out.println();
			System.out.println(ctx.getBean("randUnchange"));
			System.out.println(ctx.getBean("randUnchange"));
			System.out.println(ctx.getBean("randUnchange"));
			// ============================================
		}

		System.out.println("Spring container is down");
	}
}
