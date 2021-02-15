package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import app.core.dao.StudentDAO;
import app.core.entities.Student;

@SpringBootApplication
public class Lesson6SpringJpaApplication {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = SpringApplication.run(Lesson6SpringJpaApplication.class, args);) {
			StudentDAO dao = ctx.getBean(StudentDAO.class);
			dao.saveStudent(new Student("aaa", "aaa@mail"));

		}
	}

}
