package app.core.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Student;
import app.core.entities.University;
import app.core.repositories.StudentRepository;
import app.core.repositories.UniversityRepository;

@Service
@Transactional // any method in this class is a transaction
public class AdminService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private UniversityRepository universityRepository;

	// business logic methods
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public University addUniversity(University university) {
		return universityRepository.save(university);
	}

}
