package b.arrays;

public class Demo3RectangleCinema {

	public static void main(String[] args) {

		String[][] cinema = new String[3][4];
		cinema[0][2] = "Ruth";
		cinema[1][1] = "Dan";

		for (int i = 0; i < cinema.length; i++) {
			for (int j = 0; j < cinema[i].length; j++) {
				System.out.print(cinema[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
