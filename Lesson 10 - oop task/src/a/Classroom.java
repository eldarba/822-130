package a;

public class Classroom {

	private Student[] students = new Student[10];

	public void addStudent(Student student) {
		// add the student to the array
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
				break;
			}
		}
	}

}
