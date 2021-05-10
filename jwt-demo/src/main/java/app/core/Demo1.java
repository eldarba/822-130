package app.core;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Demo1 {

	public static void main(String[] args) {

		// digital signature
		// set algorithm
		String algorithm = SignatureAlgorithm.HS256.getJcaName();
		System.out.println(algorithm);

		// set secret key
		String secret = "this+is+my+scret+key+AAAAAAAAAAAAAAAAAAAAAAAAA";

		// background information
		// =============================================================
		/*
		 * the bytes of the secret key will be used by the signature algorithm - must be
		 * in base 64 format
		 */
//		byte[] scretKeyEncoded = secret.getBytes(); // java encoding
//		byte[] scretKeyDecoded = Base64.getDecoder().decode(secret); // base64
//		System.out.println(Arrays.toString(scretKeyEncoded));
//		System.out.println(Arrays.toString(scretKeyDecoded));
		// =====================================================================================

		// create the key from the decoded secret
		Key key = new SecretKeySpec(Base64.getDecoder().decode(secret), algorithm);

		Instant now = Instant.now();

		// create a JWT instance
		String jwt = Jwts.builder()

				.signWith(key)

				.setIssuedAt(Date.from(now))

				// will be valid for 10 seconds
				.setExpiration(Date.from(now.plus(10, ChronoUnit.SECONDS)))

				.setSubject("aaa@mail")

				.claim("First name", "Dan")

				.claim("Last name", "Levi")

				.compact();

		System.out.println(jwt);

		// ==================================================
		// parse the JWS to get the expanded JWT
//		JWS - JSON Web Signature [aaaa.bbbb.cccc]
//		JWT - JSON Web Token [aaaa.bbbb.cccc]

		System.out.println("====================");
		System.out.println("parsing the JWS to get a JWT");
		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
		// to demonstrate expiration paste an old JWS
		jwt = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MjA2Mzk1MTEsImV4cCI6MTYyMDYzOTUyMSwic3ViIjoiYWFhQG1haWwiLCJGaXJzdCBuYW1lIjoiRGFuIiwiTGFzdCBuYW1lIjoiTGV2aSJ9.cefEbBejjebKVILgOzca0LJZfd0F3qjezegeCaxOrfE";
		System.out.println(jwtParser.parse(jwt));
		System.out.println(jwtParser.parse(jwt).getHeader());
		System.out.println(jwtParser.parse(jwt).getBody());

	}

}
