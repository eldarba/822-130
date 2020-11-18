package a;

public class Demo5Switch {

	public static void main(String[] args) {
		int grade = (int) (Math.random() * 11);
		System.out.println("the grade: " + grade);

		switch (grade) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			System.out.println("Fail");
			break;
		case 7:
		case 8:
			System.out.println("Good");
			break;
		case 9:
		case 10:
			System.out.println("Great");
			break;
		default:
			System.out.println(grade + " is invalid grade value");
		}
	}

}
