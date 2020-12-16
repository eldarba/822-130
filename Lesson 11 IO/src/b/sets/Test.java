package b.sets;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {

		Point p1 = new Point(1, 1);
		Point p2 = new Point(4, 9);
		Point p3 = new Point(1, 1);

		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));

		System.out.println("===================");
		Set<Point> points = new HashSet<Point>();

		System.out.println(points.add(p1)); // add and than print the add result (true/false)
		System.out.println(points.add(p2));
		System.out.println(points.add(p3));

		System.out.println(points);

	}

}
