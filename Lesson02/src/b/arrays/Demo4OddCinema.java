package b.arrays;

public class Demo4OddCinema {

	public static void main(String[] args) {

		String[][] cinema = new String[4][];

		cinema[0] = new String[3];
		cinema[1] = new String[5];
		cinema[2] = new String[2];
		cinema[3] = new String[4];

		cinema[0][0] = "John";
		cinema[1][3] = "Dan";
		cinema[2][1] = "Sam";
		cinema[3][1] = "Ruth";

		for (int i = 0; i < cinema.length; i++) {
			for (int j = 0; j < cinema[i].length; j++) {
				System.out.print(cinema[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
