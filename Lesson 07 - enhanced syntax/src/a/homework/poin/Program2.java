package a.homework.poin;

import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Point p1 = new Point();
		int x = 0, y = 0;

		while (true) {

			try {

				System.out.println("enter value for x [" + Point.MIN + " - " + Point.MAX + "]");
				x = Integer.parseInt(sc.nextLine());
				System.out.println("enter value for y [" + Point.MIN + " - " + Point.MAX + "]");
				y = Integer.parseInt(sc.nextLine());
				p1.setX(x);
				p1.setY(y);
				break;

			} catch (PointXYException e) {
				try {
					System.out.println("error: " + e.getMessage());
					if (x >= Point.MIN && x <= Point.MAX) {
						p1.setX(x);
					} else {
						if (x > Point.MAX) {
							p1.setX(Point.MAX);
						} else {
							p1.setX(Point.MIN);
						}
					}
					if (y >= Point.MIN && y <= Point.MAX) {
						p1.setY(y);
					} else {
						if (y > Point.MAX) {
							p1.setY(Point.MAX);
						} else {
							p1.setY(Point.MIN);
						}
					}
					break;
				} catch (PointXYException e1) {
					e1.printStackTrace();
				}

			} catch (NumberFormatException e) {
				System.out.println("value must be a number: " + e.getMessage());
			}

		}

		System.out.println(p1);
		sc.close();

		System.out.println("END");

	}

}
