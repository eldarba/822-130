package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App1 {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);) {
			String[] beans = ctx.getBeanDefinitionNames();
			for (String beanName : beans) {
				System.out.println(beanName);
			}
//			MyBean bean = ctx.getBean(MyBean.class);
//			System.out.println(bean);

		}

	}

}
