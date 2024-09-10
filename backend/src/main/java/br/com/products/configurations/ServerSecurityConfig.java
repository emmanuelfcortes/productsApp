package br.com.products.configurations;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import jakarta.servlet.http.HttpServletRequest;


//@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
@Configuration
@EnableWebSecurity
public class ServerSecurityConfig{

//   private final AutenticationRestResource customAuthenticationEntryPoint;
//
//   private final UserDetailsService userDetailsService;
//
//   public ServerSecurityConfig(AutenticationRestResource customAuthenticationEntryPoint, 
//           @Qualifier("userService")
//		   UserDetailsService userDetailsService) {
//       this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
//       this.userDetailsService = userDetailsService;
//   }

   @Bean
   protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
               .csrf(AbstractHttpConfigurer::disable)
               .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .authorizeHttpRequests(authorizeHttpRequests ->
                       authorizeHttpRequests
                       		
                               .requestMatchers(HttpMethod.GET, "/api/categorias/**").permitAll()
                               .requestMatchers(HttpMethod.GET, "/error/**").permitAll()
                               .requestMatchers(HttpMethod.GET, "/api/produtos").hasAnyRole("USER", "ADMIN")
                               .anyRequest().authenticated()
               )
               .cors(c -> c.configurationSource(this::getCorsConfiguration))
               .formLogin( form -> form.loginPage("/auth").permitAll());

	   return http.build();
   }
   
   
//   @Bean
//   public WebSecurityCustomizer webSecurityCustomizer() {
//     return (web) -> web.ignoring()
//    		 .requestMatchers("/auth**");
//   }
//   
//   @Bean
//   public DaoAuthenticationProvider authenticationProvider() {
//       DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//       provider.setPasswordEncoder(passwordEncoder());
//       provider.setUserDetailsService(userDetailsService);
//       return provider;
//   }
//
//   @Bean
//   public PasswordEncoder passwordEncoder() {
//       return new BCryptPasswordEncoder();
//   }
////
//   @Bean
//   public AuthenticationManager authenticationManagerBean() throws Exception {
//       return authenticationManagerBean();
//   }
   
//   @Bean
//   protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	   http
//	   .csrf(AbstractHttpConfigurer::disable)
//	   .authorizeHttpRequests(req ->
//       req.requestMatchers("/auth**").permitAll().
//       requestMatchers(HttpMethod.GET, "test/dummy/authority").hasAuthority("ROLE_INEXISTENTE").
//       requestMatchers(HttpMethod.POST, "test/dummy/authority").
//               hasAnyAuthority("ROLE_MOD_LAF_INT_FUN_LAF_INT_FCA_VISUALIZAR", "ROLE_MOD_LAF_INT_FUN_LAF_INT_FCA_ACESSAR", "ROLE_MOD_LAF_INT_FUN_LAF_INT_FCA_CADASTRAR")
//       .anyRequest().permitAll()
//		).cors(c -> c.configurationSource(this::getCorsConfiguration));
//			   
//		return http.build();
//		
//	}
//   @Bean
//   public DataSource dataSource() {
//       return new EmbeddedDatabaseBuilder()
//           .setType(EmbeddedDatabaseType.H2)
//           .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//           .build();
//   }

//   @Bean
//   UserDetailsManager users(DataSource dataSource) {
//       UserDetails user = User.withDefaultPasswordEncoder()
//           .username("user")
//           .password("password")
//           .roles("USER")
//           .build();
//       JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//       users.createUser(user);
//       return users;
//   }
   
   public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
       CorsConfiguration config = new CorsConfiguration();
       config.setAllowedOrigins(List.of("*"));
       config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
       config.setAllowedHeaders(List.of("*"));
       return config;
   }
   
//   @Bean
//   public UserDetailsManager userDetailsService() {
//       UserDetails user1 = User.withUsername("user1")
//           .password(passwordEncoder().encode("user1Pass"))
//           .roles("USER")
//           .build();
//       UserDetails user2 = User.withUsername("user2")
//           .password(passwordEncoder().encode("user2Pass"))
//           .roles("USER")
//           .build();
//       UserDetails admin = User.withUsername("admin")
//           .password(passwordEncoder().encode("adminPass"))
//           .roles("ADMIN", "USER")
//           .build();
//       return new InMemoryUserDetailsManager(user1, user2, admin);
//   }
//   
//   @Bean
//	public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}

}