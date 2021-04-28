package app.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String teacherName;
	@OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
	private List<Student> students;

	public Classroom() {
	}

	public Classroom(int id, String teacherName) {
		super();
		this.id = id;
		this.teacherName = teacherName;
	}

	public Student addStudent(Student student) {
		if (this.students == null) {
			this.students = new ArrayList<Student>();
		}
		student.setClassroom(this);
		this.students.add(student);
		return student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Classroom [id=" + id + ", teacherName=" + teacherName + "]";
	}

}
