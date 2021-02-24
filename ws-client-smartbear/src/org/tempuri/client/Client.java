package org.tempuri.client;

import java.rmi.RemoteException;

import org.tempuri.CalculatorSoap;
import org.tempuri.CalculatorSoapProxy;

public class Client {

	public static void main(String[] args) {

		try {
			CalculatorSoap stub = new CalculatorSoapProxy().getCalculatorSoap();
			System.out.println(stub.add(10, 15));
			System.out.println(stub.divide(10, 3));
			System.out.println(stub.multiply(10, 15));
			System.out.println(stub.subtract(10, 15));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
