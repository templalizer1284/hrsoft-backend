package dev.aleksandarm.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.aleksandarm.data.Data_Sector;
import dev.aleksandarm.repositories.Repo_Sector;
import dev.aleksandarm.services.Service_Sector;

@Service
public class Service_Impl_Sector implements Service_Sector {

	@Autowired
	Repo_Sector repo;
	
	@Override
	public List<Data_Sector> get() {
		return repo.findAll();
	}
	
	@Override
	public ResponseEntity<String> add(String name) {
		if(repo.existsByName(name)) {
			return new ResponseEntity<String> ("", HttpStatus.IM_USED);
		} else {
			Data_Sector sector = new Data_Sector(name);
			repo.save(sector);
			
			return new ResponseEntity<String> ("Sector saved.", HttpStatus.ACCEPTED);
		}
	}
	
	@Override
	public ResponseEntity<String> delete(String name) {
		if(repo.existsByName(name)) {
			Data_Sector s = repo.findByName(name);
			repo.delete(s);
			return new ResponseEntity<String> ("Sector deleted.", HttpStatus.OK);
		} else {
			return new ResponseEntity<String> ("Sector by that name doesn't exist.", HttpStatus.NOT_FOUND);
		}
	}
}
