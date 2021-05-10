package com.example.demo;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.JwtUtil.UserDetails.UserType;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	private String signatureAlgorithm = SignatureAlgorithm.HS256.getJcaName();
	private String encodedSecretKey = "this+is+my+key+and+it+must+be+at+least+256+bits+long";
	private Key decodedSecretKey = new SecretKeySpec(Base64.getDecoder().decode(encodedSecretKey),
			this.signatureAlgorithm);

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", userDetails.id);
		claims.put("userType", userDetails.userType);
		return createToken(claims, userDetails.email);
	}

	private String createToken(Map<String, Object> claims, String subject) {

		Instant now = Instant.now();

		return Jwts.builder().setClaims(claims)

				.setSubject(subject)

				.setIssuedAt(Date.from(now))

				.setExpiration(Date.from(now.plus(10, ChronoUnit.HOURS)))

				.signWith(this.decodedSecretKey)

				.compact();
	}

	private Claims extractAllClaims(String token) throws ExpiredJwtException {
		JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(this.decodedSecretKey).build();
		return jwtParser.parseClaimsJws(token).getBody();
	}

	/** returns the JWT subject - in our case the email address */
	public String extractUsername(String token) {
		return extractAllClaims(token).getSubject();
	}

	public Date extractExpiration(String token) {
		return extractAllClaims(token).getExpiration();
	}

	private boolean isTokenExpired(String token) {
		try {
			extractAllClaims(token);
			return false;
		} catch (ExpiredJwtException e) {
			return true;
		}
	}

	/**
	 * returns true if the user (email) in the specified token equals the one in the
	 * specified user details and the token is not expired
	 */
	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.email) && !isTokenExpired(token));
	}

	public static class UserDetails {
		public String id;
		public String email;
		public UserType userType;

		public UserDetails(String id, String email, UserType userType) {
			super();
			this.id = id;
			this.email = email;
			this.userType = userType;
		}

		public enum UserType {
			ADMIN, COMPANY, CUSTOMER
		}

	}

	public static void main(String[] args) {

		JwtUtil util = new JwtUtil();

		UserDetails userDetails = new UserDetails("1245", "aaa@mail", UserType.COMPANY);
		String token = util.generateToken(userDetails);
		System.out.println(token);

		System.out.println(util.extractUsername(token));
		System.out.println(util.extractAllClaims(token));
		System.out.println(util.extractExpiration(token));
		System.out.println(util.isTokenExpired(token));
//		System.out.println("=====================");
//		System.out.println(util.validateToken(token, new UserDetails("111", "aaa@mail", UserType.ADMIN)));
	}
}
