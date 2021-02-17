package app.core;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import app.core.entities.Student;
import app.core.repositories.StudentRepository;

@SpringBootApplication
public class Lesson07DataJpaApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(Lesson07DataJpaApplication.class, args);

		try {

			StudentRepository studentRepository = ctx.getBean(StudentRepository.class);

			// create {
			{

//				Student st1 = studentRepository.save(new Student("Ran", "aaa@mail", Gender.M));
//				Student st2 = studentRepository.save(new Student("Vered", "aaa@mail", Gender.F));
//				System.out.println(st1);
//				System.out.println(st2);

//				int numOfStudentsToCreate = 20;
//
//				String[] names = { "Dan", "Ran", "Nizan", "Tom", "Ely", "Lee" };
//
//				String name, email;
//				int age, year, month, dayOfMonth;
//				Gender gender;
//				boolean active;
//				LocalDate enrollment;
//				for (int i = 0; i < numOfStudentsToCreate; i++) {
//					name = names[(int) (Math.random() * names.length)];
//					age = (int) (Math.random() * 61) + 20; // 20 - 80
//					email = name + "@mail";
//					gender = Gender.values()[(int) (Math.random() * 2)];
//					active = Math.random() < 0.5 ? true : false; // ternary operator ?:
//
//					year = (int) (Math.random() * 21) + 2005;
//					month = (int) (Math.random() * 12) + 1;
//					dayOfMonth = (int) (Math.random() * 26) + 1;
//					enrollment = LocalDate.of(year, month, dayOfMonth);
//
//					Student st = new Student(name, age, email, gender, active, enrollment);
//					studentRepository.save(st);
//				}
			}

			// read
			{
//				int id = 11;
//				Optional<Student> opt = studentRepository.findById(id);
//				if (opt.isPresent()) {
//					Student st = opt.get();
//					System.out.println(st);
//				} else {
//					System.out.println("student with id " + id + " not found");
//				}

			}

			// read all
			{
//				List<Student> students = studentRepository.findAll();
//				System.out.println(students);
//
//				long numberOfStudents = studentRepository.count();
//				System.out.println("number of stodents: " + numberOfStudents);
			}

			{
//				List<Student> femaleStudents = studentRepository.getFemaleStudents(Sort.by(Direction.DESC, "name"));
//				for (Student student : femaleStudents) {
//					System.out.println(student);
//				}
			}
			{
//				List<Student> maleStudents = studentRepository.getMaleStudents();
//				for (Student student : maleStudents) {
//					System.out.println(student);
//				}
			}
			{
////				List<Student> maleStudents = studentRepository.getAllOlderThan(50);
//				List<Student> maleStudents = studentRepository.getAllOlderThan(50, Sort.by("age"));
//				for (Student student : maleStudents) {
//					System.out.println(student);
//				}

			}
			{
////				List<Student> maleStudents = studentRepository.getAllOlderThan(50);
//				List<Student> maleStudents = studentRepository.findByName("Dan");
//				for (Student student : maleStudents) {
//					System.out.println(student);
//				}

			}
			{
//				long x = studentRepository.countByActiveTrue();
//				System.out.println("number of active students: " + x);
//				List<Student> maleStudents = studentRepository.findByActiveTrue();
//				for (Student student : maleStudents) {
//					System.out.println(student);
//				}

			}

			System.out.println("==============");
			{
				LocalDate enrollmentDate = LocalDate.of(2020, 1, 1);
				System.out.println("enrooled after: " + enrollmentDate);
				List<Student> maleStudents = studentRepository.findByEnrollmentAfter(enrollmentDate);
				for (Student student : maleStudents) {
					System.out.println(student);
				}

			}

			System.out.println("about shutdown");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
