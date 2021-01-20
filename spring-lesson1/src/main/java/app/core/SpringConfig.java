package app.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import app.core.components.Bank;
import app.core.components.Person;

@ComponentScan
@Configuration
public class SpringConfig {

	@Bean
	@Scope("singleton") // singleton is default
	public Person theManager() {
		Person mgr = new Person();
		mgr.setId(1);
		mgr.setName("Mgr");
		mgr.setAge(35);
		return mgr;
	}

	@Bean
	public Person theEngineer() {
		Person eng = new Person();
		eng.setId(2);
		eng.setName("Eng");
		eng.setAge(20);
		return eng;
	}

	@Bean
	public Bank bankTlv() {
		return new Bank();
	}

	@Bean
	public Bank bankJer() {
		return new Bank();
	}

}
