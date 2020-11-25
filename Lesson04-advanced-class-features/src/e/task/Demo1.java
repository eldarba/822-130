package e.task;

import java.util.Arrays;

public class Demo1 {

	public static void main(String[] args) {

		int[] arr1 = { 2, 4, 6, 8, 2, 5, 7, 9 };

		// create a number from the digits in indices 2, 4, 0

		int d1 = arr1[2];
		int d2 = arr1[4];
		int d3 = arr1[0];

		int x = d1 * 100 + d2 * 10 + d3;
		System.out.println(x);

		// swap the values in indices 2 and 5
		System.out.println(Arrays.toString(arr1));

		int eInd2 = arr1[2];
		int eInd5 = arr1[5];

		arr1[2] = eInd5;
		arr1[5] = eInd2;

		System.out.println(Arrays.toString(arr1));

	}

}
