package app.lines;

public class TestLines {

	public static void main(String[] args) {

		Line line1 = new Line(8);
		Line line2 = new Line(5);
		line1.draw();
		line2.draw();

		System.out.println("=======================");

		WLine wLine1 = new WLine(25, 3);
		wLine1.draw();

	}

}
