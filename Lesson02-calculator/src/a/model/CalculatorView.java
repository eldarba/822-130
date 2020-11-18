package a.model;

import java.util.Scanner;

// MVC = 1. Model (application logic)
// MVC = 2. View
// MVC = 3. Controller (connects view and model)
//view
public class CalculatorView {

	// MODEL
	private Calculator calculator = new Calculator();
	private Scanner sc = new Scanner(System.in);
	private boolean quit;

	// VIEW
	private void displayMenu() {
		System.out.println();
		System.out.println("======================");
		System.out.println("add ............. +");
		System.out.println("subtract .......  -");
		System.out.println("multiply ........ *");
		System.out.println("divide .......... /");
		System.out.println("clear ........... c");
		System.out.println("result .......... r");
		System.out.println("quit ............ q");
		System.out.print("enter you choice: ");
	}

	// CONTROLLER
	private void handleUserRequest() {
		String command = sc.nextLine();
		double val;
		switch (command) {
		case "+":
			System.out.println("enter value to add: ");
			val = Double.parseDouble(sc.nextLine());
			calculator.add(val);
			break;
		case "-":
			System.out.println("enter value to subtract: ");
			val = Double.parseDouble(sc.nextLine());
			calculator.sub(val);
			break;
		case "*":
			System.out.println("enter value to multiply by: ");
			val = Double.parseDouble(sc.nextLine());
			calculator.mul(val);
			break;
		case "/":
			System.out.println("enter value divide by: ");
			val = Double.parseDouble(sc.nextLine());
			calculator.div(val);
			break;
		case "c":
			calculator.clear();
			break;
		case "r":
			System.out.println("current result: " + calculator.getResult());
			break;
		case "q":
			this.quit = true;
			sc.close();
			break;
		default:
			System.out.println(command + " is an illegal command");
			break;
		}
	}

	public void start() {
		while (!quit) {
			displayMenu();
			handleUserRequest();
		}
		System.out.println("Bye");
	}

}
