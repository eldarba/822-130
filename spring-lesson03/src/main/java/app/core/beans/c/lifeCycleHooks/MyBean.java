package app.core.beans.c.lifeCycleHooks;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements BeanNameAware {

	// how to get this bean name?
	private String theBeanName;

	// container invokes the CTOR
	public MyBean() {
		System.out.println(">>> from MyBean CTOR");
	}

	@Override
	public void setBeanName(String name) {
		this.theBeanName = name;
	}

	public String getTheBeanName() {
		return theBeanName;
	}

	// tell the container to invoke method after creation
	@PostConstruct
	public void myInitMethod() {
		System.out.println(">>> from myInitMethod of MyBean");
	}

	// tell the container to invoke method before destruction
	@PreDestroy
	public void myDestroMethod() {
		System.out.println(">>> from myDestroMethod of MyBean");
	}

}
