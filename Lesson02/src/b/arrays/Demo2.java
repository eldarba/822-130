package b.arrays;

public class Demo2 {

	public static void main(String[] args) {

		System.out.println();

		{
			int[][] arr = new int[5][10];
			arr[1][6] = 25;

			int[][] statArr = { { 1, 2, 3 }, { 2, 4, 6 }, { 3, 6, 9 } };
		}

		{
			int[][] arr = new int[5][];
			arr[0] = new int[25];
			arr[1] = new int[10];
			arr[2] = new int[3];
			arr[3] = new int[12];
			arr[4] = new int[7];
			System.out.println();

		}

	}

}
