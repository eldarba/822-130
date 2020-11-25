package b.singletons;

public class School {

	private Student[] students;

	//////////////////////////////////////////////////
	// 1. define a private CTOR
	private School() {
		students = new Student[100];
	}

	// 2. define a static filed of a School instance [private]
	private static School instance = new School();

	// 3. define a get method for the singleton School instance
	public static School getInstance() {
		return instance;
	}
	//////////////////////////////////////////////////

	public void addStudent(Student student) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				students[i] = student;
				break;
			}
		}
	}

}
