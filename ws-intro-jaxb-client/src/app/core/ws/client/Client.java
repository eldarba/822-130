package app.core.ws.client;

import java.rmi.RemoteException;

import app.core.ws.Calculator;
import app.core.ws.CalculatorProxy;
import app.core.ws.Student;

public class Client {

	public static void main(String[] args) {

		try {
			Calculator calcStub = new CalculatorProxy().getCalculator();

			Student st = new Student("Eldar");
			String greeting = calcStub.greetStudent(st);
			System.out.println(greeting);

			int sum = calcStub.sum(12, 3);
			System.out.println(sum);

		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

}
