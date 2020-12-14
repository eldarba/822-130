package a;

public class Test {

	public static void main(String[] args) {

		Student st1 = new Student();
		Student st2 = new Student();

		Classroom classroom = new Classroom();
		classroom.addStudent(st1);
		classroom.addStudent(st2);

	}

}
