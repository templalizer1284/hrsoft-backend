package dev.aleksandarm.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.aleksandarm.data.Data_Role;
import dev.aleksandarm.repositories.Repo_Role;
import dev.aleksandarm.services.Service_Role;

@Service
public class Service_Impl_Role implements Service_Role{
	
	@Autowired
	Repo_Role repo;
	
	@Override
	public List<Data_Role> get() {
		return repo.findAll();
	}
	
	@Override
	public ResponseEntity<String> add(String name) {
		if(repo.existsByName(name)) {
			return new ResponseEntity<String> ("Role by that name already exist.", HttpStatus.IM_USED);
		} else {
			Data_Role role = new Data_Role();
			role.setName(name);
			repo.save(role);
			return new ResponseEntity<String> ("Role registered.", HttpStatus.ACCEPTED);
		}
	}
	
	@Override
	public ResponseEntity<String> delete(String name) {
		if(repo.existsByName(name)) {
			Data_Role role = repo.findByName(name);
			repo.delete(role);
			return new ResponseEntity<String> ("Role deleted.", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String> ("Role doesn't exist.", HttpStatus.NOT_FOUND);
		}
	}
}
