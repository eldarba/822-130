package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.store.Store;

public class Main {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class)) {

			// get the beans (the implementation is actually a proxy to our beans)
			// ask for the interface - not any concrete type
			Store elecronics = ctx.getBean("electronicsStore", Store.class);
			Store clothings = ctx.getBean("clothingStore", Store.class);
			Store food = ctx.getBean("foodStore", Store.class);

			// work with the beans
			System.out.println(elecronics.getProducts());
			System.out.println(clothings.getProducts());
			System.out.println(food.getProducts());

			clothings.buy("Pants");
			clothings.buy("tv");
			elecronics.buy("tv");
			elecronics.buy("computer");
			elecronics.buy("milk");

			elecronics.returnProduct("tv");

		}

	}

}
