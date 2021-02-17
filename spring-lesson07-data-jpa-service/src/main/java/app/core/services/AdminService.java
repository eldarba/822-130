package app.core.services;

import java.util.List;
import java.util.Optional;

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

	public Student getStudent(int id) {
		Optional<Student> opt = studentRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public University getUniversity(int id) {
		Optional<University> opt = universityRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	public List<Student> getStudents(int universityId) {
		return studentRepository.findByUniversityId(universityId);
	}

}
