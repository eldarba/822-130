package app.core;

import java.util.HashSet;
import java.util.Set;

public class Test4 {

	public static void main(String[] args) {

		Set<Employee> emps = new HashSet<>(); // destination
		emps.add(null);
		emps.add(new Manager("aaa", "aaa", 4000, "Sales"));
		emps.add(new Employee("bbb", "aaa", 5000, "Legal"));
		emps.add(new Manager("ccc", "aaa", 6000, "Legal"));
		emps.add(new Employee("ddd", "aaa", 7000, "Sales"));
		emps.add(null);

		Set<Manager> mgrs = new HashSet<>(); // source
		mgrs.add(null);
		mgrs.add(new Manager("eee", "aaa", 4000, "Sales"));
		mgrs.add(new Manager("eee", "aaa", 6000, "Legal"));
		mgrs.add(null);

		// ================================

//		EmployeeStatistics.insertEmployees(emps, mgrs);
		EmployeeStatistics.insertEmployees1(mgrs, emps);
//		EmployeeStatistics.insertEmployees1(mgrs, mgrs); // error
		EmployeeStatistics.insertEmployees2(mgrs, mgrs); // ok

	}

}
