package c.enums.planets;

public enum Planet {

	MERQURI(5, 100), VENUS(7, 150), EARTH(9, 200), MARS(6, 300), JUPITER(20, 420);

	private Planet(int mass, int orbit) {
//		System.out.println(">>> now creating: " + this);
		this.mass = mass;
		this.orbit = orbit;
	}

	private int mass;
	private int orbit;

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	public int getOrbit() {
		return orbit;
	}

	public void setOrbit(int orbit) {
		this.orbit = orbit;
	}

}
