package app.core.business;

import org.springframework.stereotype.Component;

@Component
public class CalculatorBeanImpl implements CalculatorBean {

	@Override
	public String div(int a, int b) throws RuntimeException {
		System.out.println("--- div");
		return a + " / " + b + " = " + (a / b) + " [rem: " + a % b + "]";
	}
}
