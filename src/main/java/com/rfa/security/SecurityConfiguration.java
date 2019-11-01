package com.rfa.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/*
		 * in memory authentication
		 * 
		 * auth.inMemoryAuthentication().withUser("admin").password("admin").roles(
		 * "ADMIN") .and().withUser("user").password("user").roles("USER");
		 */

		auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
				.withUser(User.builder().username("user").password("user").roles("USER").build())
				.withUser(User.builder().username("admin").password("admin").roles("ADMIN").build());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user").hasAnyRole("USER", "ADMIN")
			.antMatchers("/").permitAll()
			.and().formLogin();
	}

	@Bean
	public PasswordEncoder getPasswordEnco() {
		return NoOpPasswordEncoder.getInstance();
	}
}
