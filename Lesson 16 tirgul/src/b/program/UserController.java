package b.program;

import java.util.Scanner;

public class UserController {

	private String name;
	private String email;

	public void getUserDetails(boolean nudge) {

		Nudger nudger = null;
		if (nudge) {
			nudger = new Nudger();
			nudger.start();
		}

		try (Scanner sc = new Scanner(System.in);) {

			System.out.println("enter name");
			this.name = sc.nextLine();

			System.out.println("enter email");
			this.email = sc.nextLine();

			System.out.println("thanks");

			if (nudge) {
				nudger.interrupt();
			}
		}

	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void printUserDetails() {
		System.out.println("User [name=" + name + ", email=" + email + "]");
	}

}
