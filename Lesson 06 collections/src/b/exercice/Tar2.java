package b.exercice;

import java.util.Set;
import java.util.TreeSet;

public class Tar2 {

	public static void main(String[] args) {

		Set<Integer> set = new TreeSet<Integer>();

		int x = 0;
		while (set.size() < 10) {
			x++;
			set.add((int) (Math.random() * 11));
		}

		System.out.println(set);
		System.out.println(x);

	}

}
