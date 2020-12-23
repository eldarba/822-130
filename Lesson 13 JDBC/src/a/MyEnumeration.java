package a;

import java.util.Enumeration;

public class MyEnumeration implements Enumeration<String> {

	private String[] arr = { "aaa", "bbb", "ccc" };
	int index;

	@Override
	public boolean hasMoreElements() {
		return index < arr.length;
	}

	@Override
	public String nextElement() {
		return arr[index++];
	}

	public static void main(String[] args) {

		MyEnumeration x = new MyEnumeration();

		while (x.hasMoreElements()) {
			System.out.println(x.nextElement());
		}
	}

}
