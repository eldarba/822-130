package app.core.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

	// derived queries
	List<Student> findByName(String name);

	List<Student> findByNameIsNot(String name);

	List<Student> findByActiveTrue();

	Long countByActiveTrue();

	List<Student> findByEnrollmentAfter(LocalDate enrollmentDate);

	// make sure this is working
	Optional<Student> getByName(String name);

}
