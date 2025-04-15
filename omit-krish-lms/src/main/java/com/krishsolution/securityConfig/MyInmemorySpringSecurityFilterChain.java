package com.krishsolution.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
/**
 * This is for InmemoryUserDetailsManager implementation
 * 
 * 
 */
@Configuration
@EnableWebSecurity(debug = true)
@Order(2)
public class MyInmemorySpringSecurityFilterChain {
	
	public MyInmemorySpringSecurityFilterChain() {
		
		System.out.println("first inmemory filter calling..");
	}
	@Bean
	public UserDetailsService userDetailsService() {

		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("murali").password("{noop}password").roles("USER").build());
		return manager;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth.requestMatchers( "/myLoginPage", "/WEB-INF/view/**").permitAll() // ?
																													// Add
																													// this!
						.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/myLoginPage").loginProcessingUrl("/process-login")
						.defaultSuccessUrl("/instructors", true).permitAll())
				.logout(logout -> logout
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) // 🔥 Allow GET for logout
				)

		;
		return http.build();
	}
}
