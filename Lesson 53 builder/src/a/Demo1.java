package a;

import java.util.Date;

public class Demo1 {

	public static void main(String[] args) {

		// this is the standard way to concatenate
		String str = "aaa";
		str += "bbb";

		// if we have a very heavy concatenation - we use StringBuilder
		StringBuilder sb = new StringBuilder("aaa").append("bbb").append(25);
		String str2 = sb.toString();

		String str3 = new StringBuilder("aaa").append("bbb").append(true).append(25).append(new Date()).toString();
		System.out.println(str3);

	}

}
