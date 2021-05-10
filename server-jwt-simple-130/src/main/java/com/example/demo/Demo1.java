package com.example.demo;

import io.jsonwebtoken.Jwts;

public class Demo1 {

	public static void main(String[] args) {

		// create a jwt using the Jwts factory
		String jwt = Jwts.builder()

				.setSubject("Sample Token")

				.claim("first name", "Dan")

				.claim("last name", "Lev")

				.compact();

		System.out.println(jwt);

	}

}
