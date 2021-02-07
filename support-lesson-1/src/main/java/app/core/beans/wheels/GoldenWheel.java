package app.core.beans.wheels;

import org.springframework.stereotype.Component;

@Component
public class GoldenWheel implements Wheel {

	@Override
	public void turn() {
		System.out.println("golden turn");

	}

}
