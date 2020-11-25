package c.abstracts.shapes;

// an abstract class can have abstract methods
public abstract class Shape {

	private String color;

	public Shape(String color) {
		super();
		this.color = color;
	}

	public Shape() {
	}

	// an abstract method has no implementation /////////////////
	public abstract double getArea();
	// //////////////////////////////////////////////////////////

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
