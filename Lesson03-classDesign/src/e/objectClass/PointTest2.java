package e.objectClass;

public class PointTest2 {

	public static void main(String[] args) {

		Point p1 = new Point(2, 2);
		Point p2 = new Point(2, 2);
		Point p3 = p1;

		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		System.out.println(p3.hashCode());

		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));

	}

}
