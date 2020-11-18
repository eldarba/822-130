package a.model;

/*
 * application layer + data layer
 * */
public class Calculator {

	// data layer is this field
	private double result;

	public void add(double val) {
		result += val;
	}

	public void sub(double val) {
		result -= val;
	}

	public void mul(double val) {
		result *= val;
	}

	public void div(double val) {
		result /= val;
	}

	public double getResult() {
		return result;
	}

	public void clear() {
		this.result = 0;
	}

}
