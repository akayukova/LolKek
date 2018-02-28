package ru.yandex.startapp.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import component.TokenHandler;

@Service
public class TokenAuthenticationServiceImpl implements TokenAuthenticationService {

	private final TokenHandler tokenHandler;

	@Autowired
	TokenAuthenticationServiceImpl(TokenHandler tokenHandler) {
		this.tokenHandler = tokenHandler;
	}

	@Override
	public Authentication getAuthentication(HttpServletRequest request) {
		final String authHeader = request.getHeader("authorization");
		if (authHeader == null)
			return null;
		if (!authHeader.startsWith("Bearer"))
			return null;
		final String jwt = authHeader.substring(7);
		System.out.println(jwt);
		if (jwt.isEmpty())
			return null;

		UserDetails user = tokenHandler.parseUserFromToken(jwt);
		return new UserAuthentication(user);

	}

}
