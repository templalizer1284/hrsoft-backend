package dev.aleksandarm.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import dev.aleksandarm.data.Data_Security;
import dev.aleksandarm.repositories.Repo_Security;
import dev.aleksandarm.services.Service_Security;

@Service
public class Service_Impl_Security implements Service_Security {

	@Autowired
	Repo_Security repo;
	
	@Override
	public List<Data_Security> fetch_users() {
		return repo.findAll();
	}
	
	@Override
	public ResponseEntity<String> register(Data_Security data) throws Exception {
		if(repo.existsByUsername(data.getUsername())) {
			return new ResponseEntity<String> ("User already exists.", HttpStatus.IM_USED);
		} else {
			
			UserDetails user = User.withUsername(data.getUsername())
					.password(data.getPassword())
					.roles(data.getRole()).build();
			
			AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder(null);
			auth.inMemoryAuthentication()
			.getUserDetailsService()
			.createUser(user);
			
			repo.save(data);
			
			return new ResponseEntity<String> ("User successfully registered.", HttpStatus.ACCEPTED);
		}
	}
}
