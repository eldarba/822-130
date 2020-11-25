package f.classNesting;

import f.classNesting.State.Citiezen;

public class Test {

	public static void main(String[] args) {

		State israel = new State("Israel");
		State france = new State("France");

		Citiezen david = israel.new Citiezen("David");
		Citiezen pier = france.new Citiezen("Pier");

		System.out.println(pier.getName());
		System.out.println(pier.getStateName());

		System.out.println(david.getName());
		System.out.println(david.getStateName());

	}

}
