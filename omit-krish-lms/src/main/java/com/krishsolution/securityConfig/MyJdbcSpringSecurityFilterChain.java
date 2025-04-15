package com.krishsolution.securityConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * This is for InmemoryUserDetailsManager implementation
 * 
 * 
 */
@Configuration
@EnableWebSecurity(debug = true)
@Order(3)
public class MyJdbcSpringSecurityFilterChain {

	public MyJdbcSpringSecurityFilterChain() {

		System.out.println("MyJdbcSpringSecurityFilterChain class called...");
	}

	@Autowired
	private DataSource dataSource;

	@Bean
	public UserDetailsService userDetailsService() {

		JdbcUserDetailsManager jdbcUserDetailsService = new JdbcUserDetailsManager();

		jdbcUserDetailsService.setDataSource(dataSource);
		jdbcUserDetailsService.setUsersByUsernameQuery(
				"select user_name,user_password,user_isActive " + "from registration " + "where user_name = ?");

		jdbcUserDetailsService.setAuthoritiesByUsernameQuery(

				"select user_name,user_roles " + "from registration " + "where user_name = ?");

		return jdbcUserDetailsService;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/test", "/test-demo", "/WEB-INF/view/**", "/registration", "/registration-process")
				.permitAll().requestMatchers("/show-instructor-page").hasAnyAuthority("user", "admin")
				.requestMatchers("/showAddLessonPage").hasAnyAuthority("admin").anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/myLoginPage").loginProcessingUrl("/process-login").permitAll()
						.defaultSuccessUrl("/instructors", true).permitAll())

				.logout(logout -> logout

						.logoutRequestMatcher(new AntPathRequestMatcher("/logout")));

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return NoOpPasswordEncoder.getInstance();
	}
}
