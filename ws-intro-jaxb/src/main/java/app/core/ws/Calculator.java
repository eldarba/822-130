package app.core.ws;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public class Calculator {

	public int sum(int a, int b) {
		return a + b;
	}

	public String greetStudent(Student student) {
		return "Hello " + student.getName();
	}
}
