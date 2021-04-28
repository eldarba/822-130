package app.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Employee;
import app.core.repositories.EmployeeRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringLesson09Rest1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringLesson09Rest1Application.class, args);
	}

	// define a CommandLineRunner bean for some start actions (will run on context
	// startup)

//	@Bean // activate this bean if you wan the runner to run
	CommandLineRunner initDBWithData(EmployeeRepository repo) {

		// we can supply interface implementation using anonymous inner class:
		CommandLineRunner runner = new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				System.out.println(">>> CommandLineRunner started");
				// enter 2 employees to the database
				repo.save(new Employee(0, "Ella", "Engineer"));
				repo.save(new Employee(0, "Ron", "Legal Advisor"));

			}
		};

		return runner;

	}

}
