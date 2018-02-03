package component;

import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenHandlerImpl implements TokenHandler {
	
	private String secret = "key";
	
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	public String createTokenForUser(UserDetails user) {
		// TODO Auto-generated method stub
		final ZonedDateTime afterOneWeek = ZonedDateTime.now().plusWeeks(1);

        return Jwts.builder()
                .setSubject(user.getUsername()) // expiration + session
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(Date.from(afterOneWeek.toInstant()))
                .compact();
	}

	@Override
	public UserDetails parseUserFromToken(String token) {
		// TODO Auto-generated method stub
		final String subject = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        final UserDetails user = userDetailsService.loadUserByUsername(subject);
        return user;
    
	}

}
