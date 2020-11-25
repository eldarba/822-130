package c.abstracts.shapes;

public class Test {

	public static void main(String[] args) {

		Shape shape = new Rectangle("Red", 15, 7);
		System.out.println(shape.getArea());

		Shape[] shapes = new Shape[4];
		shapes[0] = new Circle("White", 2.3);
		shapes[1] = new Rectangle("White", 2.3, 8);
		shapes[2] = new Circle("White", 2.3);
		shapes[3] = new Rectangle("White", 9, 3);

		for (int i = 0; i < shapes.length; i++) {
			Shape curr = shapes[i];
			System.out.println(curr.getClass().getSimpleName() + " area: " + curr.getArea());
		}

	}

}
