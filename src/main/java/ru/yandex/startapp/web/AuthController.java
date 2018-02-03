package ru.yandex.startapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import component.TokenHandler;

@Controller
@RequestMapping("api/auth")
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final TokenHandler tokenHandler;	
	private final UserDetailsService userDetailsService;

	@Autowired
	AuthController(
			AuthenticationManager authenticationManager, 
			TokenHandler tokenHandler,			
			UserDetailsService userDetailsService) {
		this.authenticationManager = authenticationManager;
		this.tokenHandler = tokenHandler;		
		this.userDetailsService = userDetailsService;
	}

	@RequestMapping(method = RequestMethod.POST)
    @ResponseBody public AuthResponse auth(@RequestBody AuthParams params) 
    		throws AuthenticationException {		
        final UsernamePasswordAuthenticationToken loginToken = params.toAuthenticationToken();
        final Authentication authentication = authenticationManager.authenticate(loginToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        UserDetails user = userDetailsService.loadUserByUsername(
        		SecurityContextHolder.getContext().getAuthentication().getName());
        
            final String token = tokenHandler.createTokenForUser(user);
            return new AuthResponse(token);		
    }

	private static final class AuthParams {
		private String username;
		private String password;

		public AuthParams() {
		}

		public AuthParams(String username, String password) {
			this.username = username;
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		UsernamePasswordAuthenticationToken toAuthenticationToken() {
			return new UsernamePasswordAuthenticationToken(username, password);
		}
	}

	private static final class AuthResponse {
		private String token;

		public AuthResponse() {
		}

		public AuthResponse(String token) {
			this.token = token;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
	}
}
