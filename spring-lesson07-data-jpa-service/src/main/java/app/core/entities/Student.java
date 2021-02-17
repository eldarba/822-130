package app.core.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer age;
	private String email;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private boolean active;
	private LocalDate enrollment;
	@ManyToOne
	private University university;

	public enum Gender {
		M, F
	}

	public Student() {
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Student(String name, Integer age, String email, Gender gender, boolean active, LocalDate enrollment) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.active = active;
		this.enrollment = enrollment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDate getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(LocalDate enrollment) {
		this.enrollment = enrollment;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", gender=" + gender
				+ ", active=" + active + ", enrollment=" + enrollment + "]";
	}

}
