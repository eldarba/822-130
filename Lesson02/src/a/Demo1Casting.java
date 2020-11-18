package a;

public class Demo1Casting {

	public static void main(String[] args) {

		{
			double n1 = 3.56;
			int n2 = (int) n1; // explicit casting
			System.out.println(n1);
			System.out.println(n2);
		}

		{
			System.out.println("==================");
			byte n1 = 10;
			short n2 = n1; // implicit casting
			System.out.println(n1);
			System.out.println(n2);
		}

		{
			System.out.println("==================");
			short n1 = 300;
			byte n2 = (byte) n1; // explicit casting - bigger type to smaller type
			System.out.println(n1);
			System.out.println(n2);
		}
		{
			System.out.println("==================");
			double n1 = 2.5;
			float n2 = (float) n1; // explicit casting - bigger type to smaller type
			System.out.println(n1);
			System.out.println(n2);
		}
		{
			System.out.println("==================");
			long n1 = 99999999999999999L; // 64 bit
			float n2 = n1;// 32 bit // implicit casting
			System.out.println(n1);
			System.out.println(n2);

			System.out.println("max long: " + Long.MAX_VALUE);
			float f = 9223372036854775807F;
			System.out.println(f);
		}

		{
			System.out.println(3.33333333333333333333333333333333333333333D);
			System.out.println(3.33333333333333333333333333333333333333333F);
		}

		// casting objects
		{
			// implicit casting
			C c = new C();
			A a = c; // the polymorphic reference is implicit casting

			// wrong casting - not the same inheritance tree
//			A a2 = (A)"aaa";

			// explicit casting is required when casting is in the same inheritance tree
			C c2 = new C();
			A a2 = new C();

			if (a2 instanceof C) {
				c2 = (C) a2; // implicit casting
				System.out.println("success");
			}

		}

		{
			System.out.println("=============================");
			A a = new A();
			B b = new B();
			C c = new C();

			B b2 = new C();

			// instanceof is a binary operator (for complex types)
			// first operand is a reference to an object
			// second operand is a type (name of a class)
			// the result is a boolean
			// (true if the reference points to an object of the specified type)
			System.out.println(b instanceof B);
			System.out.println(b instanceof C);
			System.out.println(b instanceof A);
			System.out.println(b instanceof Object);

			System.out.println(b2 instanceof C);

		}

	} // end of main

}// end of class

class A {

}

class B extends A {

}

class C extends B {

}
