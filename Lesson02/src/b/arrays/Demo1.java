package b.arrays;

public class Demo1 {

	public static void main(String[] args) {

		// dynamic initialization
		int[] arr1 = new int[10];
		arr1[0] = 3;
		System.out.println(arr1[0]);

		String[] arr2 = new String[10];
		arr2[3] = "hello";
		System.out.println(arr2[3]);

		System.out.println("======================");
		// static initialization
		int[] arr3 = { 2, 4, 6, 8 };
		System.out.println("array length: " + arr3.length);

		for (int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}

		System.out.println("===========================");
		String x;
		x = null;
		System.out.println(x);

	}

}
