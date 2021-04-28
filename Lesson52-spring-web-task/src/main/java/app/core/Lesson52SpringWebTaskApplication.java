package app.core;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import app.core.entities.Classroom;
import app.core.entities.Student;
import app.core.services.SchoolService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Lesson52SpringWebTaskApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Lesson52SpringWebTaskApplication.class, args);

		SchoolService service = ctx.getBean(SchoolService.class);

		Student st1 = new Student(0, "aaa", LocalDate.of(1999, 5, 12));
		Student st2 = new Student(0, "bbb", LocalDate.of(2005, 3, 12));
		Student st3 = new Student(0, "ccc", LocalDate.of(2010, 8, 12));

		Classroom classroom = new Classroom(0, "Ron");
		classroom.addStudent(st1);
		classroom.addStudent(st2);
		classroom.addStudent(st3);

		service.addClassroom(classroom);

	}

}
