package a.generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo1 {

	public static void main(String[] args) {
		// in invoking a method we send arguments
		int sum = sum(45, 31);
		System.out.println(sum);

		Printer<String> printerOfString = new Printer<>();
		printerOfString.print("AAA");

		Printer<Integer> printerOfInteger = new Printer<>();
		printerOfInteger.print(7);

		Printer<Date> printerOfDate = new Printer<>();
		printerOfDate.print(new Date());

		List<Integer> listOfInteger = new ArrayList<>();
		listOfInteger.add(5);

		Printer<? extends Object> printer = new Printer<String>();
	}

	// in defining a method we have parameters
	public static int sum(int a, int b) {
		return a + b;
	}

}

/*
 * Generics - syntax for type parameters and type arguments so the class can be
 * defined without specifying types
 */

class Printer<T> {

	public void print(T data) {
		System.out.println(data);
	}

}
