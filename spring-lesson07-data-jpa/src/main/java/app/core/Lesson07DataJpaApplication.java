package app.core;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

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

//				String[] names = { "Dan", "Ran", "Hila", "Tom", "Ely", "Moshe" };
//
//				for (int i = 0; i < 20; i++) {
//					String name = names[(int) (Math.random() * names.length)];
//					Gender gender = Gender.values()[(int) (Math.random() * 2)];
//					Student st = new Student(name, name + "@mail", gender);
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
				List<Student> femaleStudents = studentRepository.getFemaleStudents(Sort.by(Direction.DESC, "name"));
				for (Student student : femaleStudents) {
					System.out.println(student);
				}
			}
			System.out.println("==============");
			{
				List<Student> maleStudents = studentRepository.getMaleStudents();
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
