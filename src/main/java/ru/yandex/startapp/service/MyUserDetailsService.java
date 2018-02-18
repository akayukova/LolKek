package ru.yandex.startapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import ru.yandex.startapp.domain.Master;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	private UserDetailsService userDetailsService;
	private List<ru.yandex.startapp.domain.User> users;
	private List<UserDetails> usersDet = new ArrayList<UserDetails>();	
	
	private UserService userService;
	
	@Autowired
	public MyUserDetailsService(UserService userService) {
		this.userService = userService;
		System.out.println("®œ“¬ŒﬁÃ¿“‹!");
		if (userService == null)
			System.out.println("NUUUUUUUUUUUUUUUUUUUUUUUUUUUUULLLLLLLMS");
		users = userService.listUser();		
		if (users == null)
			System.out.println("NUUUUUUUUUUUUUUUUUUUUUUUUUUUUULLLLLLL");
		for(int i=0;i<users.size();i++) { 
			usersDet.add(new User(users.get(i).getLogin(), 
					users.get(i).getPassword(), Collections.singletonList(
					new SimpleGrantedAuthority(users.get(i).getAuthority()))));			 
			}		
		this.userDetailsService = new InMemoryUserDetailsManager(usersDet);
	}

	

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("loadUserByUsername!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return this.userDetailsService.loadUserByUsername(arg0);
		
	}

}
