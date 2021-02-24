package app.core.ws;

import javax.xml.ws.Endpoint;

public class Server {

	public static void main(String[] args) {
		// create a remote object
		Calculator calc = new Calculator();
		// define the URL for the WSDL service so clients can connect
		String url = "http://localhost:8080/calc";
		System.out.println("WSDL is published in:");
		System.out.println(url + "?wsdl");
		// start a skeleton object (server side connector) and listen to requests
		Endpoint.publish(url, calc);
	}

}
