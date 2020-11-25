package b.singletons;

public class Test {

	public static void main(String[] args) {

		School school1 = School.getInstance();
		School school2 = School.getInstance();
		School school3 = School.getInstance();

		// this is how we use a singleton object
		School.getInstance().addStudent(new Student());

	}

}
