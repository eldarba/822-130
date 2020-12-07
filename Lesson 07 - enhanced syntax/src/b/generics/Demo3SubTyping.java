package b.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import b.generics.foods.Food;
import b.generics.foods.Fruit;
import b.generics.foods.Orange;

public class Demo3SubTyping {

	public static void main(String[] args) {

		// in arrays we have sub typing - in compile time
		Orange[] oranges = { new Orange(), new Orange() };
		Food[] foods = { new Orange(), new Food() };

		printFoodsArr(oranges);
		printFoodsArr(foods);

		List<Food> listFoods = new ArrayList<>();
		listFoods.add(new Food());
		listFoods.add(new Orange());
		printFoodsColl(listFoods);

		List<Fruit> listFruit = new ArrayList<>();
		listFruit.add(new Fruit());
		listFruit.add(new Orange());
		printFoodsColl(listFruit); // method will not accept it

	}

	public static void printFoodsArr(Food[] foods) {
//		foods[0] = new Food(); // this might throw an exception
		for (int i = 0; i < foods.length; i++) {
			System.out.println(foods[i]);
		}
		System.out.println("============");
	}

	public static void printFoodsColl(List<? extends Food> foods) {
		// foods.add(new Fruit());
		Iterator<? extends Food> it = foods.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("============");
	}

	public static void printAnyColl(List<?> list) {
		// list.add(new Fruit());
		Iterator<?> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("============");
	}

	// 1 add - no wild cards
	public static void addFood(List<Food> list) {
		list.add(new Orange());
	}

	// 2 add - no wild cards
	// methods will agree to accept List of fruit and up - all the way to Object
	// method will allow to add - Fruit and down
	public static void addAnyFruit(List<? super Fruit> list) {
//		list.add(new Object());
		list.add(new Fruit());
		list.add(new Orange());
	}

}
