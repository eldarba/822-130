package app.core.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import app.core.entities.Student;

@Repository // component
@Transactional // starts and endds transaction for each method
public class StudentDAOImpl implements StudentDAO {

	@PersistenceContext // auto wiring
	private EntityManager entityManager; // this is equivalent to Hibernate's Session

	@Override
	public int saveStudent(Student student) {
		// Session session = entityManager.unwrap(Session.class);
		entityManager.persist(student);
		return student.getId();
	}

	@Override
	public Student getStudent(int id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
