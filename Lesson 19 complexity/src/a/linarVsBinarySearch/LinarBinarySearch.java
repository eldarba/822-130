package a.linarVsBinarySearch;

import java.util.Arrays;

public class LinarBinarySearch {

	public static void main(String[] args) {
		int[] arr = getRandomNumbers(1000, 0, 5000);
		print(arr);

		int val = 50;
//		int index = liniarSearch(arr, val);
		int index = binarySearch(arr, val);

		if (index != -1) {
			System.out.println("index of " + val + " is: " + index);
		} else {
			System.out.println(val + " not found");
		}

	}

	/**
	 * returns the index of specified value or -1 if not found
	 * 
	 * complexity: O(log n) [base 2]
	 * 
	 * if n = 100 than maximum number of steps is 7 (worst case) log 100[base 2] ~ 7
	 * 
	 * 2^7 = 128
	 */
	public static int binarySearch(int[] arr, int val) {
		int low = 0;
		int high = arr.length - 1;
		int counter = 0;

		while (low <= high) {
			counter++;
			int mid = (low + high) / 2;
			int midVal = arr[mid];
			if (midVal < val) {
				low = mid + 1;
			} else if (midVal > val) {
				high = mid - 1;
			} else {
				System.out.println("iterations: " + counter);
				return mid; // val found
			}
		}

		System.out.println("iterations: " + counter);
		return -1; // val not found
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
