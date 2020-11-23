package c.inheritance.shapes;

public class Shape {

	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getArea() {
		System.out.println("getArea not supported");
		return -1D;
	}

}
