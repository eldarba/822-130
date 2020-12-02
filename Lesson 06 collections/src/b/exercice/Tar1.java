package b.exercice;

import java.util.ArrayList;
import java.util.List;

public class Tar1 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			list.add((int) (Math.random() * 11));
		}

		System.out.println(list);

	}

}
