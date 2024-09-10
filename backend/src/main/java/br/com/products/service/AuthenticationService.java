package br.com.products.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

//@Service
//public class AuthenticationService implements UserDetailsService{
//	UserDetailsManager userDetailsService;
//	public AuthenticationService(UserDetailsManager userDetailsService) {
//		this.userDetailsService = userDetailsService;
//	}
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return this.userDetailsService.loadUserByUsername(username);
//	}

//}
