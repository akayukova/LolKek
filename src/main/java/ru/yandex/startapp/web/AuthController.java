package ru.yandex.startapp.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import component.TokenHandler;
import ru.yandex.startapp.service.UserService;

@Controller
@RequestMapping("api/auth")
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final TokenHandler tokenHandler;
	private final UserDetailsService userDetailsService;
	private final UserService userService;
	private final MasterService userService;

	@Autowired
	AuthController(AuthenticationManager authenticationManager, TokenHandler tokenHandler,
			UserDetailsService userDetailsService, UserService userService) {
		this.authenticationManager = authenticationManager;
		this.tokenHandler = tokenHandler;
		this.userDetailsService = userDetailsService;
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public AuthResponse auth(@RequestBody AuthParams params) throws AuthenticationException {
		System.out.println("AuthControlle!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		final UsernamePasswordAuthenticationToken loginToken = params.toAuthenticationToken();
		System.out.println("LogTok!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		final Authentication authentication = authenticationManager.authenticate(loginToken);
		System.out.println("Auth!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		SecurityContextHolder.getContext().setAuthentication(authentication);
		System.out.println("setauth!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		UserDetails user = userDetailsService
				.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

		System.out.println("User " + user.getUsername());
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		final String token = tokenHandler.createTokenForUser(user);
		System.out.println("OK");
		return new AuthResponse(token, authorities, userService.getUserByLogin(user.getUsername()).getUserId());
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
		private Collection<? extends GrantedAuthority> authorities;
		private int id;

		public AuthResponse() {
		}

		public AuthResponse(String token, Collection<? extends GrantedAuthority> authorities, int id) {
			this.token = token;
			this.authorities = authorities;
			this.id = id;
		}

		public Collection<? extends GrantedAuthority> getAuthorities() {
			return authorities;
		}

		public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
			this.authorities = authorities;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

	}
}
