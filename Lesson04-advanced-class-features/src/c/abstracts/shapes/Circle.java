package c.abstracts.shapes;

public class Circle extends Shape {

	private double radius;

	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}

	/////////////////////////////////
	@Override
	public double getArea() {
		// PI * r ^ 2
		return Math.PI * Math.pow(radius, 2);
	}
	/////////////////////////////////

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}
