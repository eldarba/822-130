package a;

public class Demo3Switch {

	public static void main(String[] args) {

		int r = (int) (Math.random() * 3);
		System.out.println("0 - 2 inclusive");
		r = 200;
		System.out.println("the value is: " + r);

		// switch is a fall-through construct
//		key  can b
		switch (r) {
		case 0:
			System.out.println("zero");
			break; // exit the switch block
		case 1:
			System.out.println("one");
			break;
		case 2:
			System.out.println("two");
			break;
		default:
			System.out.println(r + " is not in the required range of 0 - 2");
		}

		// break will bring us here
		System.out.println("END");
	}

}
