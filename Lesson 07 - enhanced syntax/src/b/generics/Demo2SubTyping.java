package b.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import b.generics.foods.Food;
import b.generics.foods.Fruit;
import b.generics.foods.Orange;

public class Demo2SubTyping {

	public static void main(String[] args) {

		// in arrays we have sub typing - in compile time
		Fruit[] fruits = new Orange[5];
		fruits[0] = new Orange();
		fruits[1] = new Fruit(); // fails in runtime

		System.out.println(Arrays.toString(fruits));

		// in collections we DO NOT have sub typing
		// List<Fruit> list = new ArrayList<Orange>;

	}

	public static void printFoodsArr(Food[] foods) {
		foods[0] = new Food(); // this might throw an exception
		for (int i = 0; i < foods.length; i++) {
			System.out.println(foods[i]);
		}
	}

	public static void printFoodsColl(Collection<Food> foods) {
		Iterator<Food> it = foods.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
