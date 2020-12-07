package app.core;

import java.util.HashSet;
import java.util.Set;

public class Test3 {

	public static void main(String[] args) {

		Set<Employee> emps = new HashSet<Employee>();

		emps.add(null);
		emps.add(new Manager("aaa", "aaa", 4000, "Sales"));
		emps.add(new Employee("bbb", "aaa", 5000, "Legal"));
		emps.add(new Manager("ccc", "aaa", 6000, "Legal"));
		emps.add(new Employee("ddd", "aaa", 7000, "Sales"));
		emps.add(null);

		// ================================

		System.out.println(emps);
		System.out.println(EmployeeStatistics.getManagers(emps));

	}

}
