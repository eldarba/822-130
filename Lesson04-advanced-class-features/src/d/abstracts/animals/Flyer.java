package d.abstracts.animals;

public interface Flyer {

	// constants
	int MIN_ALT = 0;

	// abstract methods
	// must be overridden by implementing classes
	void fly();

	// can be overridden by implementing classes
	default void doSomething() {
		System.out.println("i am doing something");
	}

}
