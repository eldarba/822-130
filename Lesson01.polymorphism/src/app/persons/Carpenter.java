package app.persons;

public class Carpenter extends Employee {

	public Carpenter(double salary) {
		super(salary);
	}

	public void cutWood() {
		System.out.println("I am cutting wood");
	}
}
