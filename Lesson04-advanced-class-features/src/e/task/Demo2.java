package e.task;

import java.util.Arrays;

public class Demo2 {

	public static void main(String[] args) {

		int[] arr1 = { 2, 4, 6, 8, 2, 5, 7, 9 };

		// swap the values in indices 2 and 5
		System.out.println(Arrays.toString(arr1));

		int temp = arr1[2];

		arr1[2] = arr1[5];
		arr1[5] = temp;

		System.out.println(Arrays.toString(arr1));

		System.out.println(5);
		System.out.println(0x5);

	}

}
