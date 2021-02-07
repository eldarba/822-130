package app.core.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import app.core.beans.wheels.Wheel;

@Component
public class Car {

	private Wheel silverWheel; // name qualifier is last

	@Autowired
	public Car(@Qualifier("goldenWheel") Wheel silverWheel) {
		super();
		this.silverWheel = silverWheel;
	}

	public void turn() {
		silverWheel.turn();
	}

	public Wheel getSilverWheel() {
		return silverWheel;
	}

	public void setSilverWheel(Wheel silverWheel) {
		this.silverWheel = silverWheel;
	}

}
