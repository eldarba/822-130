package app.core;

import java.util.HashSet;
import java.util.Set;

public class Test2 {

	public static void main(String[] args) {

		Set<Manager> mgrs = new HashSet<>();

		mgrs.add(null);
		mgrs.add(new Manager("aaa", "aaa", 4000, "Sales"));
		mgrs.add(new Manager("bbb", "aaa", 5000, "Legal"));
		mgrs.add(new Manager("ccc", "aaa", 6000, "Legal"));
		mgrs.add(new Manager("ddd", "aaa", 7000, "Sales"));
		mgrs.add(null);

		// ================================
		double avg = EmployeeStatistics.averageSalary(mgrs);
		int numOfEmps = EmployeeStatistics.numOfEmployees(mgrs);
		int numOfLegalEmps = EmployeeStatistics.numOfEmployees(mgrs, "Legal");

		System.out.println("Average Salary: " + avg);
		System.out.println("Number of Employees: " + numOfEmps);
		System.out.println("Number of Legal Employees: " + numOfLegalEmps);

	}

}
