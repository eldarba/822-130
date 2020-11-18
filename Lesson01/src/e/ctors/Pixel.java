package e.ctors;

public class Pixel extends Point {

	private String color;

	public Pixel(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}

	public Pixel(int x, int y) {
		this(x, y, "black");
	}

	public Pixel(int val) {
		this(val, val, "black");
	}

	public Pixel() {
		this(0, 0, "black");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
