package app.core;

import java.util.HashSet;
import java.util.Set;

public class Test2 {

	public static void main(String[] args) {

		Set<Manager> emps = new HashSet<>();

		emps.add(null);
		emps.add(new Manager("aaa", "aaa", 4000, "Sales"));
		emps.add(new Manager("bbb", "aaa", 5000, "Legal"));
		emps.add(new Manager("ccc", "aaa", 6000, "Legal"));
		emps.add(new Manager("ddd", "aaa", 7000, "Sales"));
		emps.add(null);

		// ================================
		double avg = EmployeeStatistics.averageSalary(emps);
		int numOfEmps = EmployeeStatistics.numOfEmployees(emps);
		int numOfLegalEmps = EmployeeStatistics.numOfEmployees(emps, "Legal");

		System.out.println("Average Salary: " + avg);
		System.out.println("Number of Employees: " + numOfEmps);
		System.out.println("Number of Legal Employees: " + numOfLegalEmps);

	}

}
