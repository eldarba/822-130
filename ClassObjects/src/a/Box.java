package a;

public class Box {

	int length;
	int width;
	int height;

	public static void main(String[] args) throws ClassNotFoundException {
		Box b1 = new Box();
		b1.length = 10;
		b1.width = 10;
		b1.height = 10;

		System.out.println(b1);
		System.out.println(b1.getClass());
		System.out.println(Box.class);
		Class<?> theBoxClass = Class.forName("a.Box");
		Class<Box> theBoxClass2 = Box.class;
		System.out.println(theBoxClass);
		System.out.println(theBoxClass2);
	}

}
