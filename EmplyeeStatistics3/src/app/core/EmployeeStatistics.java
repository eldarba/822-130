package app.core;

import java.util.ArrayList;
import java.util.Collection;

public class EmployeeStatistics {

	public static double averageSalary(Collection<? extends Employee> employees) {
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

	public static int numOfEmployees(Collection<? extends Employee> employees) {
		int counter = 0;
		for (Employee employee : employees) {
			if (employee != null) {
				counter++;
			}
		}
		return counter;
	}

	public static int numOfEmployees(Collection<? extends Employee> employees, String department) {
		int counter = 0;
		for (Employee employee : employees) {
			if (employee != null && employee.getDepartment().equalsIgnoreCase(department)) {
				counter++;
			}
		}
		return counter;
	}

	public static Collection<Manager> getManagers(Collection<Employee> emps) {
		Collection<Manager> managers = new ArrayList<Manager>();
		for (Employee employee : emps) {
			if (employee instanceof Manager) {
				managers.add((Manager) employee);
			}
		}
		return managers;
	}

	public static void insertEmployees1(Collection<Manager> source, Collection<Employee> destination) {
		destination.addAll(source);
	}

	public static <T extends Employee> void insertEmployees2(Collection<T> source, Collection<? super T> destination) {
		destination.addAll(source);
	}

	public static <T> void insertAny(Collection<T> source, Collection<? super T> destination) {
		destination.addAll(source);
	}

}
