package e.exceptions;

import a.classNesting.State;

public class UncheckedExceptionsDemo {

	public static void main(String[] args) {

		Integer.parseInt("aaa");

		int[] arr = new int[-1];

		State st = new State("aaa", 5);
		st = null;
		st.getName();

		System.out.println(5 / 0);

	}

}
