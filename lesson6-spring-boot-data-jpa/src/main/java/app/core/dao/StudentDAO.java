package app.core.dao;

import java.util.List;

import app.core.entities.Student;

public interface StudentDAO {

	int saveStudent(Student student);

	Student getStudent(int id);

	List<Student> getAllStudents();

	boolean updateStudent(Student student);

	boolean deleteStudent(int id);

}
