package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.store.Store;
import app.core.store.StoreException;
import app.core.store.aspects.ClientServiceAspect;

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

			try {
				clothings.buy("Pants");
			} catch (StoreException e) {
//				e.printStackTrace(System.out);
				System.out.println(e);
			}
			try {
				clothings.buy("tv");
			} catch (StoreException e) {
//				e.printStackTrace(System.out);
				System.out.println(e);
			}
			try {
				clothings.buy("Pants");
			} catch (StoreException e) {
//				e.printStackTrace(System.out);
				System.out.println(e);
			}
			try {
				elecronics.buy("tv");
			} catch (StoreException e) {
//				e.printStackTrace(System.out);
				System.out.println(e);
			}
			try {
				elecronics.buy("computer");
			} catch (StoreException e) {
//				e.printStackTrace(System.out);
				System.out.println(e);
			}
			try {
				elecronics.buy("milk");
			} catch (StoreException e) {
//				e.printStackTrace(System.out);
				System.out.println(e);
			}

			elecronics.returnProduct("tv");

			System.out.println("stats:");
			ClientServiceAspect clientServiceAspect = ctx.getBean(ClientServiceAspect.class);
			System.out.println("successful slaes: " + clientServiceAspect.getSalesCounter());
			System.out.println("failed slaes: " + clientServiceAspect.getSalesFailCounter());

		}

	}

}
