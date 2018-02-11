package config;

import java.util.*;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import component.AuthenticationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan("component")
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationFilter authenticationFilter;	
	
	 /*@Autowired
	    public SecurityConfig(AuthenticationFilter authenticationFilter) {
	        super(true);
	        this.authenticationFilter = authenticationFilter;
	    }*/
	  	 
	public SecurityConfig() {
		super(true);
	}
	
	/*public void setup(AuthenticationFilter authenticationFilter) {
		this.authenticationFilter = authenticationFilter;
	}
*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
				
		http.csrf().disable()
        .exceptionHandling().and()
        .anonymous().and()
        .servletApi();

http.authorizeRequests().antMatchers("/api/auth").permitAll()
        //.antMatchers(HttpMethod.GET, "/transactions/list").hasRole(AUTHORIZED_ROLE) // maybe has role
        .antMatchers(HttpMethod.GET, "/api/test1").hasAuthority("ADMIN").anyRequest().permitAll();  
  //      .and()
//        .exceptionHandling()
//        .authenticationEntryPoint(new Http401AuthenticationEntryPoint("'Bearer token_type=\"JWT\"'"));		

		http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}	
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").authorities("ADMIN");
    }
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }	
	
	
	
	/*@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/

	
	/*@Bean 
	public UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList<UserDetails>();
		System.out.println("KuKuUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU!");
	    users.add(new User("admin", "admin", Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))));	    
	      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(users);	      
	      return manager;
	   }*/
	

    /*.credentialsExpired(true)
    .accountExpired(true)
    .accountLocked(true)*/
    
	
	
}
