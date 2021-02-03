package app.core.beans.a.injectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class ExampleInjectAnnotation {

	// there are 2 types of injectors
//	@Autowired - matching is done by Type, Qualifier, Name 
//	@Resource - matching is done by Name, Type, Qualifier 
//	@Autowired
	@Resource
//	@Qualifier("appName")
	String five;

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + five;
	}

}
