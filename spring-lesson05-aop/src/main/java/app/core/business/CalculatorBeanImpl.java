package app.core.business;

import org.springframework.stereotype.Component;

import app.core.aspects.annotations.MyAOPAnnotation;

@Component
public class CalculatorBeanImpl implements CalculatorBean {

	@MyAOPAnnotation(key = "hello", value = 200, condition = true)
	@Override
	public String div(int a, int b) throws RuntimeException {
		System.out.println("--- div");
		return a + " / " + b + " = " + (a / b) + " [rem: " + a % b + "]";
	}

}
