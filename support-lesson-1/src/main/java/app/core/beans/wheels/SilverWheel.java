package app.core.beans.wheels;

import org.springframework.stereotype.Component;

@Component
public class SilverWheel implements Wheel {

	@Override
	public void turn() {
		System.out.println("silver turn");

	}

}
