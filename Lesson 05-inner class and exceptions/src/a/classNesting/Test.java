package a.classNesting;

import a.classNesting.State.Citizen;

public class Test {

	public static void main(String[] args) {

		State isr = new State("Israel", 10000);
		State russia = new State("Russia", 1000000);

		Citizen c1 = isr.new Citizen("Dan");
		Citizen c2 = isr.new Citizen("Danna");
		Citizen c3 = isr.new Citizen("Ran");

		Citizen c4 = russia.new Citizen("Alex");
		Citizen c5 = russia.new Citizen("Vlad");

		System.out.println(c3);
		System.out.println(c4 + ": population " + c4.getState().getPopulation());

	}

}
