package component;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public interface TokenHandler {
	
	String createTokenForUser(UserDetails user);
	
	UserDetails parseUserFromToken(String token);

}
