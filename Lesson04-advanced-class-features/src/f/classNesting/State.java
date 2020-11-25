package f.classNesting;

public class State {
	private String name;

	public State(String name) {
		super();
		this.name = name;
	}

	// any citizen must belong to a state
	class Citiezen {
		private String name;

		public Citiezen(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public String getStateName() {
			return State.this.name;
		}

	}

}
