package app.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeansUtil {

	@Autowired
	private ApplicationContext theContext;

	public void printAllBeanDefinitions() {
		String[] beanNames = theContext.getBeanDefinitionNames();
		System.out.println("===============");
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
		System.out.println("===============");
	}

}
