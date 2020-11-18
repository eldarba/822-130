package e.ctors;

public class Demo1PolyMorphism {

	public static void main(String[] args) {

		Point p = new Point(5, 3);
		Pixel px = new Pixel(10, 45, "Red");

		// options to have reference that is higher than the object

		// reference is a handle to an object (remote control)
		Object obj;
		Point point;
		Pixel pixel;

		obj = "aaa";
		obj = new Pixel();
//		System.out.println(obj.getX());

		point = new Pixel();
		System.out.println(point.getX());
//		System.out.println(point.getColor());

		pixel = new Pixel();
		System.out.println(pixel.getX());
		System.out.println(pixel.getColor());

		Point point2 = pixel;

		Point[] points = new Point[5];
		points[0] = new Point(1, 1);
		points[1] = new Pixel(2, 2);
		points[2] = new Pixel(3, 3);
		points[3] = new Pixel(4, 4);
		points[4] = new Pixel(5, 5);

		for (int i = 0; i < points.length; i++) {
			System.out.println("(" + points[i].getX() + ", " + points[i].getY() + ")");
		}

	}

}
