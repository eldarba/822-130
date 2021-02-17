package app.core.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.core.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("from Student where gender='F'")
	List<Student> getFemaleStudents();

	@Query("from Student where gender='F'")
	List<Student> getFemaleStudents(Sort sort);

	@Query(value = "select * from Student where gender='M'", nativeQuery = true)
	List<Student> getMaleStudents();

	@Query("from Student where age > :age")
	List<Student> getAllOlderThan(int age);

	@Query("from Student where age > :age")
	List<Student> getAllOlderThan(int age, Sort sort);

}
