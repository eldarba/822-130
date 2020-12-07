package app.core;

public class Manager extends Employee {

	public Manager() {
		super();
	}

	public Manager(String firstName, String lastName, double salary, String deprtment) {
		super(firstName, lastName, salary, deprtment);
	}

	@Override
	public String toString() {
		return "Manager";
	}

}
