package e.exceptions;

public class MyClass {

	public void printHi() {
		System.out.println("Hi");
		return; // method ends without problems
	}

	public int divide(int a, int b) throws Exception { // handling 1 - throws declaration
		if (b != 0) {
			return a / b;
		} else {
			throw new Exception("you cannot divide by 0");
		}
	}

	public static void main(String[] args) {
		MyClass myClass = new MyClass();

		try { // handling 2 - try-catch
			int res = myClass.divide(10, 0);
			System.out.println(res);
		} catch (Exception e) { // handler code
			// e is a reference to the exception we caught
			System.out.println("error: " + e);
			System.out.println("error: " + e.getMessage());
			e.printStackTrace(System.out); // print stack trace helps in debugging
		}

		System.out.println("End of Program");
	}

}
