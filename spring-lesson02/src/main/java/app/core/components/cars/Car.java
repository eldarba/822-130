package app.core.components.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

// FIELD INJECTION
	private Engine engine;
	private Gear gear;

// CTOR INJECTION
	// CTOR is invoked by Spring
	@Autowired
	public Car(Engine engine, @Qualifier("basicGear") Gear gear) {
		super();
		this.engine = engine;
		this.gear = gear;
	}

	public void startCar() {
		engine.start();
		System.out.println("car is on");
	}

	public void startDrive() {
		int state = gear.shiftUp();
		System.out.println("Car driving. Gear state: " + state + " gear type: " + gear.getClass().getSimpleName());
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Gear getGear() {
		return gear;
	}

	// SETTER INJECTION
	public void setGear(Gear gear) {
		this.gear = gear;
	}

}
