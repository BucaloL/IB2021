package ib.T5.security;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtil {
	
	
	@Value ("IB")
	private String APP_NAME;
	
	@Value("secret")
	public String SECRET = "secret";
	
	@Value("3600000") //3600s=1h
	private int EXPIRIES_IN = 3600000;
	
	@Value("Authorization")
	private String AUTH_HEADER;
	
	private static final String AUDIENCE_WEB = "web";
	private static final String AUDIENCE_MOBILE = "mobile";
	private static final String AUDIENCE_TABLET = "tablet";
	
	
	private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
	
	public String generateToken(String email, String role) {
		return Jwts.builder()
				.setIssuer(APP_NAME)
				.setSubject(email)
				.setAudience(generateAudience())
				.setExpiration(generateExpirationDate())
				.claim("roles", role)
				.signWith(SIGNATURE_ALGORITHM , SECRET).compact();
		
	}
	
	private String generateAudience ( ) {
		return AUDIENCE_WEB;
	}
	
	private Date generateExpirationDate() {
		return new Date(new Date().getTime() + EXPIRIES_IN);
	}
	
	//funkcija za refresh jwt tokena
	
	public String refreshToken (String token) {
		
		String refreshToken;
		
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			claims.setIssuedAt(new Date());
			refreshToken = Jwts.builder()
					.setClaims(claims)
					.setExpiration(generateExpirationDate())
					.signWith(SIGNATURE_ALGORITHM, SECRET).compact();
			} catch(Exception e) {
				refreshToken = null;
			}
		return refreshToken;
	}
	
	
	public boolean canTokenBeRefreshed(String token,Timestamp lastPasswordReset) {
		final Date create = this.getIssuedDateFromToken(token);
		return (!(this.isCreatedBeforeLastPasswordReset(create, lastPasswordReset))
				&&(! (this.isTokenExpired(token)) || this.ignoreTokenExpiration(token)));
		
	}
	
	//funkcija za validaciju jwt tokena
	public Boolean validateToken(String token, UserDetails userDetails) {
		UserDetails user = (UserDetails) userDetails;
		final String email = getEmailsFromToken(token);
		final Date created = getIssuedDateFromToken(token);
		
		return (email != null && email.equals(user.getUsername()));
	}
	
	private Boolean ignoreTokenExpiration(String token) {
		String audience = this.getAudienceFromToken(token);
		return(audience.equals(AUDIENCE_TABLET) || audience.equals(AUDIENCE_MOBILE));
	}
	
	public String getEmailsFromToken(String token) {
		String email;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			email =claims.getSubject();
		} catch (Exception e) {
			email = null;
		}
		return email;
		}
	
	public Date getIssuedDateFromToken(String token) {
		Date issuesAt;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			issuesAt =claims.getIssuedAt();
		} catch (Exception e) {
			issuesAt= null;
		}
		return issuesAt;
		}
	
	public String getAudienceFromToken(String token) {
		String audience;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			audience = claims.getAudience();
		} catch (Exception e) {
			audience= null;
		}
		return audience;
	}
	
	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			expiration =claims.getExpiration();
		} catch (Exception e) {
			expiration= null;
		}
		return expiration;
		}

	public int fetExpiratedIn() {
		return EXPIRIES_IN;
		}
	
	public String getToken(HttpServletRequest request) {
		String authHeder = getAuthHeaderFromHeader (request);
		
		if(authHeder != null && authHeder.startsWith ("Bearer")) {
			return authHeder.substring (7);
		}
		
		return null;
	}
	
	public String getAuthHeaderFromHeader(HttpServletRequest request ) {
		return request.getHeader(AUTH_HEADER);
	}
	
	private Boolean isCreatedBeforeLastPasswordReset(Date created, Timestamp lastPasswordReset) {
		return (lastPasswordReset != null && created.before(new Date(lastPasswordReset.getTime())));
	}
	
	private Boolean isTokenExpired(String tooken) {
		final Date expiration = this.getExpirationDateFromToken(tooken);
		return expiration.before(new Date());
	}
	
	private Claims getAllClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token)
					.getBody();
			} catch (Exception e) {
				claims =  null;
			}
		return claims;
	}
}



