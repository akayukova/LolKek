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
import ru.yandex.startapp.domain.User;
import ru.yandex.startapp.service.MasterService;
import ru.yandex.startapp.service.UserService;

@Controller
@RequestMapping("api/auth")
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final TokenHandler tokenHandler;
	private final UserDetailsService userDetailsService;
	private final UserService userService;
	private final MasterService masterService;

	@Autowired
	AuthController(AuthenticationManager authenticationManager, TokenHandler tokenHandler,
			UserDetailsService userDetailsService, UserService userService, MasterService masterService) {
		this.authenticationManager = authenticationManager;
		this.tokenHandler = tokenHandler;
		this.userDetailsService = userDetailsService;
		this.userService = userService;
		this.masterService = masterService;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public AuthResponse auth(@RequestBody AuthParams params) throws AuthenticationException {
		final UsernamePasswordAuthenticationToken loginToken = params.toAuthenticationToken();
		final Authentication authentication = authenticationManager.authenticate(loginToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails user = userDetailsService
				.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println("User " + user.getUsername());
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		final String token = tokenHandler.createTokenForUser(user);
		System.out.println("OK");
		User userDomain = userService.getUserByLogin(user.getUsername());
		return new AuthResponse(token, authorities, userDomain.getUserId(),
				masterService.getMasterById(userDomain.getUserId()).getName());
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
		private String name;

		public AuthResponse() {
		}

		public AuthResponse(String token, Collection<? extends GrantedAuthority> authorities, int id, String name) {
			this.token = token;
			this.authorities = authorities;
			this.id = id;
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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
