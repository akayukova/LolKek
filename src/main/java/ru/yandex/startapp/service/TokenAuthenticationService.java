package ru.yandex.startapp.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

public interface TokenAuthenticationService {

	Authentication getAuthentication(HttpServletRequest request);
}
