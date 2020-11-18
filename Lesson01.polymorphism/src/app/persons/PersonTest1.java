package app.persons;

public class PersonTest1 {

	public static void main(String[] args) {

		Person[] arr = new Person[5];

		arr[0] = new Person();
		arr[1] = new Employee(1000);
		arr[2] = new Physician(5000);
		arr[3] = new Carpenter(4000);
		arr[4] = new Person();

		for (int i = 0; i < arr.length; i++) {
			Person p = arr[i];
			p.speak();

			// let's check if the current person is a worker
			if (p instanceof Employee) {
				System.out.println(i + " is an employee");
				Employee e = (Employee) p;
				e.work();
			} else {
				System.out.println(i + " is NOT an employee");
			}

			System.out.println("===============");
		}

	}

}
