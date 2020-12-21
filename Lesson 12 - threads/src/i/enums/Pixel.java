package i.enums;

public class Pixel {

	private int x;
	private int y;
	private Color color;

	public Pixel(int x, int y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Pixel [x=" + x + ", y=" + y + ", color=" + color + "]";
	}

	public enum Color {
		RED, GREEN, BLUE;
	}

	public static void main(String[] args) {
		Pixel p = new Pixel(2, 8, Color.GREEN);
		System.out.println(p);
	}

}
