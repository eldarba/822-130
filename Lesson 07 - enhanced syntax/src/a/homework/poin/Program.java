package a.homework.poin;

public class Program {

	public static void main(String[] args) {

		Point p1 = new Point();
		Point p2 = null;

		try {
			p2 = new Point(500, 9);
		} catch (PointXYException e) {
			System.out.println(">>> error: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println(p1);
		System.out.println(p2);

	}

}
