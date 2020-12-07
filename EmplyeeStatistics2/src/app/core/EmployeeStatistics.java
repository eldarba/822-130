package app.core;

import java.util.Collection;

public class EmployeeStatistics {

	public static double averageSalary(Collection<Employee> employees) {
		double sum = 0;
		int counter = 0;
		for (Employee employee : employees) {
			if (employee != null) {
				sum += employee.getSalary();
				counter++;
			}
		}
		return sum / counter;
	}

	public static int numOfEmployees(Collection<Employee> employees) {
		int counter = 0;
		for (Employee employee : employees) {
			if (employee != null) {
				counter++;
			}
		}
		return counter;
	}

	public static int numOfEmployees(Collection<Employee> employees, String department) {
		int counter = 0;
		for (Employee employee : employees) {
			if (employee != null && employee.getDepartment().equalsIgnoreCase(department)) {
				counter++;
			}
		}
		return counter;
	}

}
