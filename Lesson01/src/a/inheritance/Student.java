package a.inheritance;

public class Student extends Person {

	private int grade;

	public void printDetailes() {
		System.out.println("student details: " + getId() + ", " + getName());
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
