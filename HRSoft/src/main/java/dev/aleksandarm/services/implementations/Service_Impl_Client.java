package dev.aleksandarm.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.aleksandarm.data.Data_Client;
import dev.aleksandarm.repositories.Repo_Client;
import dev.aleksandarm.services.Service_Client;

@Service
public class Service_Impl_Client implements Service_Client{
	
	@Autowired
	Repo_Client repo;
	private List<Data_Client> data;
	
	@Override
	public ResponseEntity<String> add(String name) {
		
		if(repo.existsByName(name)) {
			return new ResponseEntity<> ("Client already exists by that name.", HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<> ("Client successfully registered.", HttpStatus.ACCEPTED);
		}
	}

	@Override
	public List<Data_Client> get(Boolean all, String name) {
		if(all == Boolean.TRUE) {
			return repo.findAll();
		} else {
			data = null;
			data.add(repo.findByName(name));
			
			return data;
		}
	}
	
}
