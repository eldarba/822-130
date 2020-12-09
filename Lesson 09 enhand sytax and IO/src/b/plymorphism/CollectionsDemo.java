package b.plymorphism;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CollectionsDemo {

	public static void main(String[] args) {

		// we will be more specific if we know it is necessary because we need random
		// access.
		ArrayList<Integer> arrList;
		arrList = new ArrayList<Integer>();
//		arrList = new LinkedList<Integer>(); // error
//		arrList = new Vector<Integer>(); // error

		// we will be more general if we wand to use different implementations.
		List<Integer> anyList;
		anyList = new ArrayList<Integer>();
		anyList = new LinkedList<Integer>();
		anyList = new Vector<Integer>();

	}

}
