package app.lines;

/**
 * represents a line with length
 */
public class Line {

	protected int length;

	public Line(int length) {
		super();
		this.length = length;
	}

	public void draw() {
		for (int i = 0; i < length; i++) {
			System.out.print(" * ");
		}
		System.out.println();
	}

}
