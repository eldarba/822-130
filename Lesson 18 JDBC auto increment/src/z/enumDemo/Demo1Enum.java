package z.enumDemo;

public class Demo1Enum {

	enum Category {
		SPORTS, CLOTHING, ELECTRONICS
	}

	public static void main(String[] args) {

		int ordinal = 0;

		Category cat = Category.values()[ordinal];
		System.out.println(cat);

	}

}
