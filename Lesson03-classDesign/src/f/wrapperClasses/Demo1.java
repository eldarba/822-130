package f.wrapperClasses;

import javax.swing.JOptionPane;

public class Demo1 {

	public static void main(String[] args) {

		{
			int a = 3;
//		Integer x = new Integer(a); // inbox
			Integer x = a; // auto-inbox
			Integer x1 = 5; // auto-inbox
		}

		{
			// represent primitives as objects
			Integer x = 5;
			Double y = 3.56;
		}

		// fields and methods
		System.out.println(Byte.MAX_VALUE);

		// parse methods
		// parse = translate
		// convert string to a number

		// get text input from user:
		String in1 = JOptionPane.showInputDialog("enter 1st number [int]");
		String in2 = JOptionPane.showInputDialog("enter 2nd number [double]");

		// since we expect the text to be in numeral format we can try to parse
		int x = Integer.parseInt(in1);
		double y = Double.parseDouble(in2);
		double sum = x + y;

		System.out.println(x + " + " + y + " = " + sum);

	}

}
