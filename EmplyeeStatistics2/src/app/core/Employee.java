package app.core;

public class Employee {

	private String firstName;
	private String lastName;
	private double salary;
	private String deprtment;

	public Employee() {
	}

	public Employee(String firstName, String lastName, double salary, String deprtment) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.deprtment = deprtment;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return deprtment;
	}

	public void setDeprtment(String deprtment) {
		this.deprtment = deprtment;
	}

	@Override
	public String toString() {
		return "Emplpyee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", deprtment="
				+ deprtment + "]";
	}

}
