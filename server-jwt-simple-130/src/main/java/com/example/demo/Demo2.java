package com.example.demo;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Demo2 {

	public static void main(String[] args) {

		// define signature algorithm
		String algorithm = "HmacSHA256AA";
		algorithm = SignatureAlgorithm.HS256.getJcaName();

		// set the encoded secret key for signing the JWT
		byte[] secretKeyEncoded = "this+is+my+key+and+it+must+be+at+least+256+bits+long".getBytes();
		// decode the key to base 64 so it is platform neutral
		byte[] secretKeyDecoded = Base64.getDecoder().decode(secretKeyEncoded);
		// preparing the key for the token signature (for authentication)
		// SecretKeySpec - used to construct a SecretKey from a byte array
		Key key = new SecretKeySpec(secretKeyDecoded, algorithm);

		// set an instant to now for setting issued at + expiration
		Instant now = Instant.now();

		// create a JWT builder
		String token = Jwts.builder()

				.signWith(key)

				.setIssuedAt(Date.from(now))

				.setExpiration(Date.from(now.plus(30, ChronoUnit.SECONDS)))

				.setId("101")

				.setSubject("email@mail")

				.claim("clientType", "admin")

				.claim("clientPassword", "xyzPass")

				.claim("address", "Tel Aviv")

				.compact();

		System.out.println(token);

		// ===============================================================
		System.out.println("\nparse: =======================");
		// parse / validate
		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();

// 		testing expired token
//		token = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjA1MDMyNzYsImV4cCI6MTYyMDUwMzMwNiwianRpIjoiMTAxIiwic3ViIjoiZW1haWxAbWFpIiwiY2xpZW50VHlwZSI6ImFkbWluIiwiY2xpZW50UGFzc3dvcmQiOiJ4eXpQYXNzIiwiZW1haWwiOiJhZG1pbkBtYWlsIiwiYWRkcmVzcyI6IlRlbCBBdml2In0._hspc_Q2iDT7Asan3qMDB9zyUQoaWtmMXWT0z7ELN_8";
		Jws<Claims> expandedJwt = jwtParser.parseClaimsJws(token);

		System.out.println(expandedJwt);

		System.out.println("header");
		System.out.println(expandedJwt.getHeader());
		System.out.println("body");
		System.out.println(expandedJwt.getBody());
		System.out.println("signature");
		System.out.println(expandedJwt.getSignature());

	}

}
