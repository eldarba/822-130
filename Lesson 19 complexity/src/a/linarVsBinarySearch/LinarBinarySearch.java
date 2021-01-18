package a.linarVsBinarySearch;

import java.util.Arrays;

public class LinarBinarySearch {

	public static void main(String[] args) {
		int[] arr = getRandomNumbers(100, 0, 100);
		print(arr);

		int val = 50;
		int index = liniarSearch(arr, val);

		if (index != -1) {
			System.out.println("index of " + val + " is: " + index);
		} else {
			System.out.println(val + " not found");
		}

	}

	/**
	 * returns the index of specified value or -1 if not found
	 * 
	 * complexity: O(n)
	 */
	public static int liniarSearch(int[] arr, int val) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			counter++;
			if (arr[i] == val) {
				System.out.println("iterations: " + counter);
				return i;
			}
		}
		System.out.println("iterations: " + counter);
		return -1;
	}

	// method for creating sorted array
	public static int[] getRandomNumbers(int length, int min, int max) {
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (max - min + 1) + min);
		}
		Arrays.sort(arr);
		return arr;
	}

	// method for printing array
	public static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

}
