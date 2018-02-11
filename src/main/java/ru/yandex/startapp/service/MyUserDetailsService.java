package ru.yandex.startapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	private UserDetailsService userDetailsService;
	private List<UserDetails> users;

	public MyUserDetailsService() {
		users = new ArrayList<UserDetails>();
		System.out.println("KuKuUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU!");
		users.add(new User("admin", "admin", Collections.singletonList(
				new SimpleGrantedAuthority("ADMIN"))));
		this.userDetailsService = new InMemoryUserDetailsManager(users);
	}

	

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("loadUserByUsername!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return this.userDetailsService.loadUserByUsername(arg0);
		
	}

}
