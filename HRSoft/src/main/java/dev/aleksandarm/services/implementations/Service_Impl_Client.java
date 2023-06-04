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
public class Service_Impl_Client implements Service_Client {

	@Autowired
	Repo_Client repo;
	private List<Data_Client> data;

	@Override
	public ResponseEntity<String> add(String name) {

		if (repo.existsByName(name)) {
			return new ResponseEntity<String>("Client already exists by that name.", HttpStatus.NOT_ACCEPTABLE);
		} else {
			Data_Client c = new Data_Client();
			c.setName(name);
			repo.save(c);
			return new ResponseEntity<String>("Client successfully registered.", HttpStatus.ACCEPTED);
		}
	}

	@Override
	public List<Data_Client> get(Boolean all, String name) {
		if (all == Boolean.TRUE) {
			return repo.findAll();
		} else {
			data = null;
			data.add(repo.findByName(name));

			return data;
		}
	}

	@Override
	public ResponseEntity<String> delete(String name) {
		if(repo.existsByName(name)) {
			Data_Client client = repo.findByName(name);
			repo.delete(client);
			
			return new ResponseEntity<String> ("Client removed.", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String> ("Client doesn't exist.", HttpStatus.NOT_FOUND);
		}
	}
}
