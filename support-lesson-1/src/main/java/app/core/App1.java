package app.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import app.core.beans.BeansUtil;
import app.core.beans.Car;
import app.core.beans.ConnectionPool;
import app.core.beans.Person;

@Configuration
@ComponentScan
public class App1 {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App1.class)) {
			BeansUtil util = ctx.getBean(BeansUtil.class);
			util.printAllBeanDefinitions();

			Person p1 = ctx.getBean("person1", Person.class);
			Person p2 = ctx.getBean("person2", Person.class);
			Car car = ctx.getBean(Car.class);
			ConnectionPool cp = ctx.getBean(ConnectionPool.class);
			cp.cloaseAllConnections();

			System.out.println(p1);
			System.out.println(p2);
			System.out.println(car);
			System.out.println(cp);
		}

	}

	@Bean
	public Person person2() {
		return new Person();
	}

}
