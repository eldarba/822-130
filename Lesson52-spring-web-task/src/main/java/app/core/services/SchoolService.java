package app.core.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Classroom;
import app.core.entities.Student;
import app.core.repositories.ClassroomRepository;
import app.core.repositories.StudentRepository;

@Service
@Transactional
public class SchoolService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ClassroomRepository classroomRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public Classroom addClassroom(Classroom classroom) {
		return classroomRepository.save(classroom);
	}

}
