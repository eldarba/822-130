package d.finalDemo;

public final class Person { // final classes cannot be extented

	private final int id; // not initialized - must be initialized in CTOR
	private String name; // initialized to null

	public Person(int id) {
		this.id = id; // initialized and cannot be changed
	}

	// final method cannot be overridden
	public final String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

}
