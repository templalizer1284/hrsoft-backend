package dev.aleksandarm.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import dev.aleksandarm.data.Data_Security;
import dev.aleksandarm.services.Service_Security;

@Configuration
@EnableWebSecurity
public class Configuration_Security {
	
	@Autowired
	Service_Security service;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf((csrfc) -> csrfc
					.disable())
			
			.cors((corsc) -> corsc
					.disable())
			
			.authorizeHttpRequests((authz) -> authz
					.requestMatchers("/**").permitAll()
					.anyRequest().permitAll())
			
			.formLogin((loginc) -> loginc
					.loginPage("/login").permitAll()
					.successForwardUrl("/").permitAll())
			
			.logout((logoutc) -> logoutc
					.logoutSuccessUrl("/").permitAll());
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		
		List<UserDetails> users = new ArrayList<UserDetails>();
		List<Data_Security> db_users = service.fetch_users();
		
		for(int i = 0; i < db_users.size(); i++) { 	
			users.add(
					User.withUsername(db_users.get(i).getUsername())
					.password(passwordEncoder().encode(db_users.get(i).getPassword()))
					.roles(db_users.get(i).getRole())
					.build());
		}

		return new InMemoryUserDetailsManager(users);
	}
}
