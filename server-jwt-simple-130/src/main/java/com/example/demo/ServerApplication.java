package com.example.demo;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {

//		SpringApplication.run(ServerApplication.class, args);

		// define a secret key as text (base 64 characters only)
		String secretEncoded = "this+is+the+secret+key+it+must+be+long+enough+AA";
		System.out.println("secret encoded - platform specific");
		System.out.println(secretEncoded);
		System.out.println(Arrays.toString(secretEncoded.getBytes()));

		// decode the text - turn character data to binary data (uniform)
		byte[] secretDecodedToBase64 = Base64.getDecoder().decode(secretEncoded);
		System.out.println("secret decoded - cross platform");
		System.out.println(new String(secretDecodedToBase64));
		System.out.println(Arrays.toString(secretDecodedToBase64));
		System.out.println("=================");

		System.out.println("secret encoded");
		byte[] bytes = Base64.getEncoder().encode(secretDecodedToBase64);
		String x = new String(bytes);
		System.out.println(x);
		System.out.println(Arrays.toString(bytes));
		System.out.println("======================");

		System.out.println("\nthe HMAC Signature Algorithm");
		// choose the HMAC (HS256) Algorithm to compute the signature
		// HMAC stands for hash-based message authentication code
		// JCA - Java Cryptography Architecture
		String signatureAlgorithmJcaName = SignatureAlgorithm.HS256.getJcaName();
		System.out.println("Signature Algorithm: " + signatureAlgorithmJcaName); // HmacSHA256
		// preparing the key for the token signature (for authentication)
		// SecretKeySpec - used to construct a SecretKey from a byte array
		Key hmacKey = new SecretKeySpec(secretDecodedToBase64, signatureAlgorithmJcaName);
		System.out.println(hmacKey.getAlgorithm());
		System.out.println(hmacKey.getFormat());
		System.out.println(Arrays.toString(hmacKey.getEncoded()));

		Instant now = Instant.now();

		String token = Jwts.builder()

				.claim("name", "eldar")

				.setSubject("eldar")

				.setId("xxxTheIdxxx")

				.setIssuedAt(Date.from(now))

				.setExpiration(Date.from(now.plus(5, ChronoUnit.MINUTES)))

				.signWith(hmacKey)

				.compact();
		System.out.println(token);
		System.out.println(now.getEpochSecond());

		// parse / validate
		Jws<Claims> expandedJwt = Jwts.parserBuilder()

				.setSigningKey(hmacKey)

				.build()

				.parseClaimsJws(token);

		System.out.println("=======================");
		System.out.println(expandedJwt);
	}

}
