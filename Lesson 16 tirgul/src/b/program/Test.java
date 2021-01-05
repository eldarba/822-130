package b.program;

public class Test {

	public static void main(String[] args) {
		UserController uc = new UserController();
		uc.printUserDetails();
		uc.getUserDetails(true);
		uc.printUserDetails();

	}

}
