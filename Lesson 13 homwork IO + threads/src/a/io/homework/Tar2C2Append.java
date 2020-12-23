package a.io.homework;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Tar2C2Append {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			list.add((int) (Math.random() * 6) + 10);
		}

		System.out.println(list);

		Set<Integer> set = new LinkedHashSet<Integer>(list);
		System.out.println(set);

		try (PrintWriter out = new PrintWriter(new FileWriter("files/numbers.txt", true))) {
			out.println(set);
			System.out.println("numbers written to file");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
