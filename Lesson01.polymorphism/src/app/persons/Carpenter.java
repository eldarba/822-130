package app.persons;

public class Carpenter extends Employee {

	public Carpenter(double salary) {
		super(salary);
	}

	public void cutWood() {
		System.out.println("I am cutting wood");
	}

	@Override
	protected void work() {
		super.work(); // you can invoke original method using super
		System.out.println("I am working like a carpenter");
	}
}
