package component;

import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenHandlerImpl implements TokenHandler {
	
	private String secret = "LoLKeK";
	
	@Autowired
	@Qualifier("userDetailsService")
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
		try {		
		JwtParser parser = Jwts.parser();		
		parser = parser.setSigningKey(secret);		
		Jws<Claims> jwsClaims = parser.parseClaimsJws(token);		
		Claims claims = jwsClaims.getBody();		
		final String subject = claims.getSubject();		
        final UserDetails user = userDetailsService.loadUserByUsername(subject);
        return user;}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
    
	}
	
	/*@Override
    public Optional<UserDetails> parseUserFromToken(String token) {
        final String subject = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        final User user = userRepository.findOne(Integer.valueOf(subject));

        return Optional.ofNullable(user);
    }

    @Override
    public String createTokenForUser(User user) {
        final ZonedDateTime afterOneWeek = ZonedDateTime.now().plusWeeks(1);

        return Jwts.builder()
                .setSubject(user.getId().toString()) // expiration + session
                .signWith(SignatureAlgorithm.HS512, secret)
                .setExpiration(Date.from(afterOneWeek.toInstant()))
                .compact();
    }*/

}
