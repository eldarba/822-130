package c.abstracts.shapes;

public class Test {

	public static void main(String[] args) {

		Shape shape = new Rectangle("Red", 15, 7);
		System.out.println(shape.getArea());

		Shape[] shapes = new Shape[4];
		for (int i = 0; i < shapes.length; i++) {
			Shape curr = shapes[i];
			System.out.println(curr.getArea());
		}

	}

}
