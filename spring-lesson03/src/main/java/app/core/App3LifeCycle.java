package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.c.lifeCycleHooks.MyBean;

public class App3LifeCycle {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);) {

			MyBean bean = ctx.getBean(MyBean.class);
			System.out.println("bean name: " + bean.getTheBeanName());
		} catch (Exception e) {
			System.out.println("error");
		}

		System.out.println("context is down");

	}

}
