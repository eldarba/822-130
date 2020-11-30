package a.classNesting;

public class State {

	private String name;
	private int population;
	private int area;

	public State(String name, int area) {
		super();
		this.name = name;
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

	@Override
	public String toString() {
		return "State [name=" + name + ", population=" + population + ", area=" + area + "]";
	}

	// inner class - non static nested class - each instance belongs to instance of
	// enclosing type
	public class Citizen {

		public final int id;
		private String name;

		{ // initializer - runs before CTOR on each object creation
			State.this.population++; // State.this is a reference to the state of this citizen
			this.id = State.this.population;
		}

		public Citizen(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		@Override
		public String toString() {
			return "Citizen [id=" + id + ", name=" + name + ", state=" + State.this.name + "]";
		}

		public State getState() {
			return State.this;
		}

	} // end of citizen class

	// static nested class - is independent of the enclosing type
	// the only difference here is that it is not in a separate file
	public static class Car {

	}

} // end of state class
