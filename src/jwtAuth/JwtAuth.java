package jwtAuth;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtAuth {

	private String name;
	private String email;

	public JwtAuth(String name, String email) {

		this.name = name;
		this.email = email;

	}

	private String name1 = "id20";
	private int bound = 20;
	private int time = 2000;

	private Instant now = Instant.now();
	private String src = "PPy4jdlzeczdVUknCAzLVYD7M3CaugUTOYZ2ZDe/WCY=";// openssl rand -base64 32
	private byte[] secret = Base64.getDecoder().decode(src);

	public String jwt() {

		String jwt = Jwts.builder().setSubject(name).setAudience(email).claim(name1, new Random().nextInt(bound))
				.setIssuedAt(Date.from(now)).setExpiration(Date.from(now.plusMillis(time)))
				.signWith(Keys.hmacShaKeyFor(secret)).compact();

		return jwt;

	}

	public Jws<Claims> decodeToken(String Token) {

		Jws<Claims> result1 = (Jws<Claims>) Jwts.parser().requireAudience(email).setAllowedClockSkewSeconds(62)
				.setSigningKey(Keys.hmacShaKeyFor(secret)).parseClaimsJws(Token);

		return result1;

	}

}
