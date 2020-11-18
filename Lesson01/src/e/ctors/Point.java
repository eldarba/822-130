package e.ctors;

public class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		System.out.println("CTOR1");
	}

	public Point(int val) {
		this(val, val);
		System.out.println("CTOR2");
	}

	public Point() {
		this(-1);
		System.out.println("CTOR3");
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
