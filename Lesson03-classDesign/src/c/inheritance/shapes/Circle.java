package c.inheritance.shapes;

public class Circle extends Shape {

	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

}
