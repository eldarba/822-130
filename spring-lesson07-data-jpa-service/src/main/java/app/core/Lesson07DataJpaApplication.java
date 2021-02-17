package app.core;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import app.core.entities.Student;
import app.core.entities.University;
import app.core.services.AdminService;

@SpringBootApplication
@EnableTransactionManagement
public class Lesson07DataJpaApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(Lesson07DataJpaApplication.class, args);

		try {
			AdminService service = ctx.getBean(AdminService.class);

			{ // create
//				Student st1 = new Student("Avi", 25, "avi@mail", Gender.M, true, LocalDate.of(1996, 2, 25));
//				Student st2 = new Student("Dina", 18, "dina@mail", Gender.F, true, LocalDate.of(2000, 2, 25));
//				Student st3 = new Student("Shaul", 32, "shaul@mail", Gender.M, true, LocalDate.of(2020, 2, 25));
//				Student st4 = new Student("Vered", 20, "vered@mail", Gender.F, true, LocalDate.of(2020, 2, 25));
//				University u1 = new University("Tel Aviv", "Israel");
//				University u2 = new University("MIT", "USA");
//				u1.addStudent(st1);
//				u1.addStudent(st2);
//				u2.addStudent(st3);
//				u2.addStudent(st4);
//				service.addUniversity(u1); // send the university with all its students to the database
//				service.addUniversity(u2);
			}

			{
//				Student student = service.getStudent(1);
//				System.out.println(student);
//				if (student != null) {
//					University university = student.getUniversity();
//					System.out.println(university);
//				}
			}

			// get a university
			// from the university get the list of its students
			{
				University university = service.getUniversity(1);
				System.out.println(university);
				if (university != null) {
//					List<Student> students = university.getStudents(); // lazy load exception
					List<Student> students = service.getStudents(university.getId());
					System.out.println(students);
				}
			}

			System.out.println("about shutdown");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
