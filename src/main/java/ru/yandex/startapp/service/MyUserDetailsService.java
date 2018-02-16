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
	private List<Master> masters;
	private List<UserDetails> users = new ArrayList<UserDetails>();	
	
	private MasterService masterService;
	
	@Autowired
	public MyUserDetailsService(MasterService masterService) {
		this.masterService = masterService;
		System.out.println("®œ“¬ŒﬁÃ¿“‹!");
		if (masterService == null)
			System.out.println("NUUUUUUUUUUUUUUUUUUUUUUUUUUUUULLLLLLLMS");
		masters = masterService.listMaster();		
		if (masters == null)
			System.out.println("NUUUUUUUUUUUUUUUUUUUUUUUUUUUUULLLLLLL");
		for(int i=0;i<masters.size();i++) { 
			users.add(new User(masters.get(i).getLogin(), 
					masters.get(i).getPassword(), Collections.singletonList(
					new SimpleGrantedAuthority(masters.get(i).getAuthority()))));			 
			}		
		this.userDetailsService = new InMemoryUserDetailsManager(users);
	}

	

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("loadUserByUsername!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return this.userDetailsService.loadUserByUsername(arg0);
		
	}

}
