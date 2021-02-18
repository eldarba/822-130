package app.core.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Student;

@Repository // component
@Transactional // starts and endds transaction for each method
public class StudentDAOImpl implements StudentDAO {

	@PersistenceContext // auto wiring
	private EntityManager entityManager; // this is equivalent to Hibernate's Session

	@Override
	public int saveStudent(Student student) {
//		Session session = entityManager.unwrap(Session.class);
		entityManager.persist(student);
		return student.getId();
	}

	@Override
	public Student getStudent(int id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> getAllStudents() {
		TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
		return query.getResultList();
	}

	@Override
	public boolean updateStudent(Student student) {
		Student studentFromDb = entityManager.find(Student.class, student.getId());
		if (studentFromDb != null) {
			entityManager.merge(student); // this will update everything
			studentFromDb.setName(student.getName());
			studentFromDb.setEmail(student.getEmail());
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStudent(int id) {
		Student studentFromDb = entityManager.find(Student.class, id);
		if (studentFromDb != null) {
			entityManager.remove(studentFromDb);
			return true;
		}
		return false;
	}

}
