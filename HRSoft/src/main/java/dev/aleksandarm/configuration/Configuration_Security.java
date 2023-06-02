package dev.aleksandarm.configuration;

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

@Configuration
@EnableWebSecurity
public class Configuration_Security {
	
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
		UserDetails user = 
				User.withUsername("admin")
				.password(passwordEncoder().encode("123"))
				.roles("admin")
				.build();
		
		return new InMemoryUserDetailsManager(user);
	}
}
