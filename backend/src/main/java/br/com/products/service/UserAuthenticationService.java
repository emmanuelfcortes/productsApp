package br.com.products.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import br.com.products.model.UserMemoryModel;

@Configuration
@Service
public class UserAuthenticationService implements UserDetails{
List<UserDetails> users = new ArrayList<>();

//  public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//  }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return users.get(0).getAuthorities();
	}

	@Override
	public String getPassword() {
		return users.get(0).getPassword();
	}

	@Override
	public String getUsername() {
		return users.get(0).getUsername();
	}
	@Bean
	   public UserDetailsManager userDetailsService() {
	       UserDetails user1 = User.withUsername("user1")
	           .password(passwordEncoder().encode("user1Pass"))
	           .roles("USER")
	           .build();
	       UserDetails user2 = User.withUsername("user2")
	           .password(passwordEncoder().encode("user2Pass"))
	           .roles("USER")
	           .build();
	       UserDetails admin = User.withUsername("admin")
	           .password(passwordEncoder().encode("adminPass"))
	           .roles("ADMIN", "USER")
	           .build();
	       users.add(user1);
	       users.add(user2);
	       users.add(admin);
	       var a = new InMemoryUserDetailsManager(user1, user2, admin);
	       return a;
	       
	   }
	   
	   @Bean
		public PasswordEncoder passwordEncoder() {
		    return new BCryptPasswordEncoder();
		}

}
