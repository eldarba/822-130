package d.abstracts.animals;

public class Hawk extends Bird implements AdvancedFlyer {

	@Override
	public void fly() {
		System.out.println("fly like a hawk");

	}

	@Override
	public void navigate() {
		System.out.println("navigate like a hawk");

	}

	@Override
	public void takeOff() {
		System.out.println("takeOff like a hawk");

	}

	@Override
	public void land() {
		System.out.println("land like a hawk");

	}

	@Override
	public void speak() {
		System.out.println("speak like a hawk");

	}

}
