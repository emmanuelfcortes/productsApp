package br.com.products.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;


public class UserMemoryModel {
//	private List<UserDetails> users = new ArrayList();
//	public UserMemoryModel() {
//	}
//	
//	public UserDetailsManager userDetailsServices() {
//      UserDetails user1 = User.withUsername("user1")
//	  .password(passwordEncoder().encode("user1Pass"))
//	  .roles("USER")
//      .build();
//	  UserDetails user2 = User.withUsername("user2")
//	  .password(passwordEncoder().encode("user2Pass"))
//	  .roles("USER")
//      .build();
//	  UserDetails admin = User.withUsername("admin")
//	  .password(passwordEncoder().encode("adminPass"))
//	  .roles("ADMIN","USER")
//      .build();
//	  users.add(user1);
//	  users.add(user2);
//	  users.add(admin);
//      return new InMemoryUserDetailsManager(user1, user2,admin);
//	}
//	
//	public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}

}
