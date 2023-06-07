package dev.aleksandarm.services.implementations;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.aleksandarm.data.Data_Income;
import dev.aleksandarm.repositories.Repo_Income;
import dev.aleksandarm.services.Service_Income;

@Service
public class Service_Impl_Income implements Service_Income{
	
	@Autowired
	Repo_Income repo;
	
	@Override
	public ResponseEntity<String> add(Data_Income income) {
		if(repo.existsByNameAndClient(income.getName(), income.getClient())) {
			return new ResponseEntity<String> ("Income already exist by name and client.", HttpStatus.IM_USED);
		} else {
			repo.save(income);
			return new ResponseEntity<String> ("Income registered.", HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<String> delete(String name, String client) {
		if(repo.existsByNameAndClient(name, client)) {
			Data_Income i = repo.findByNameAndClient(name, client);
			repo.delete(i);
			return new ResponseEntity<String> ("Income deleted.", HttpStatus.OK);
		} else {
			return new ResponseEntity<String> ("Income doesn't exist by name or client.", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<Data_Income>> get() {
		return null;
	}

	@Override
	public ResponseEntity<List<Data_Income>> fetch(String client) {
		List<Data_Income> data = repo.findByClient(client);
		if(data.isEmpty()) {
			return new ResponseEntity<List<Data_Income>> (data, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Data_Income>> (data, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<Integer> calculate() {
		Integer sum = 0;
		List<Data_Income> inc = repo.findAll();
		
		for(int i = 0; i < inc.size(); i++) {
			sum += inc.get(i).getRevenue();
		}
		
		return new ResponseEntity<Integer> (sum, HttpStatus.OK);
	}
}
